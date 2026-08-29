package com.hospital.iam.service;

import com.hospital.common.AppException;
import com.hospital.common.BadRequestException;
import com.hospital.common.UnauthorizedException;
import com.hospital.iam.dto.AuthResponse;
import com.hospital.iam.dto.LoginRequest;
import com.hospital.iam.dto.RefreshTokenRequest;
import com.hospital.iam.entity.LoginHistory;
import com.hospital.iam.entity.User;
import com.hospital.iam.entity.UserSession;
import com.hospital.iam.repository.LoginHistoryRepository;
import com.hospital.iam.repository.UserRepository;
import com.hospital.iam.repository.UserSessionRepository;
import com.hospital.security.JwtTokenProvider;
import com.hospital.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final LoginHistoryRepository loginHistoryRepository;
    private final JwtTokenProvider tokenProvider;

    @Value("${app.security.max-failed-attempts:5}")
    private int maxFailedAttempts;

    @Value("${app.security.lockout-duration-minutes:15}")
    private int lockoutDurationMinutes;

    @Transactional
    public AuthResponse login(LoginRequest request, HttpServletRequest httpRequest) {
        String clientIp = getClientIP(httpRequest);
        String userAgent = httpRequest.getHeader("User-Agent");

        Optional<User> userOpt = userRepository.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // Check if locked
            if (user.isAccountLocked()) {
                recordLoginAttempt(request.getUsernameOrEmail(), user, "LOCKED", clientIp, userAgent, "Account is temporarily locked");
                throw new LockedException("Account is temporarily locked due to multiple failed attempts. Please try again later.");
            }

            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword())
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);

                // Reset failed attempts upon success
                user.setFailedLoginAttempts(0);
                user.setLockedUntil(null);
                user.setLastLoginAt(Instant.now());
                userRepository.save(user);

                // Generate tokens
                String accessToken = tokenProvider.generateAccessToken(authentication);
                String rawRefreshToken = tokenProvider.generateRefreshToken();

                // Save session with hashed refresh token
                String tokenHash = hashToken(rawRefreshToken);
                UserSession session = UserSession.builder()
                        .user(user)
                        .refreshTokenHash(tokenHash)
                        .deviceInfo(userAgent)
                        .ipAddress(clientIp)
                        .expiresAt(Instant.now().plus(tokenProvider.getRefreshTokenExpirationMs(), ChronoUnit.MILLIS))
                        .build();
                userSessionRepository.save(session);

                recordLoginAttempt(user.getUsername(), user, "SUCCESS", clientIp, userAgent, null);

                UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
                List<String> roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList());
                List<String> permissions = principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .filter(a -> a.startsWith("PERM_"))
                        .map(a -> a.substring(5))
                        .collect(Collectors.toList());

                return AuthResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(rawRefreshToken)
                        .tokenType("Bearer")
                        .expiresIn(900)
                        .user(AuthResponse.UserDto.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .firstName(user.getFirstName())
                                .lastName(user.getLastName())
                                .phone(user.getPhone())
                                .roles(roles)
                                .permissions(permissions)
                                .build())
                        .build();

            } catch (BadCredentialsException ex) {
                int attempts = user.getFailedLoginAttempts() + 1;
                user.setFailedLoginAttempts(attempts);
                if (attempts >= maxFailedAttempts) {
                    user.setStatus(User.Status.LOCKED);
                    user.setLockedUntil(Instant.now().plus(lockoutDurationMinutes, ChronoUnit.MINUTES));
                    log.warn("User account locked due to excessive failed attempts: {}", user.getUsername());
                }
                userRepository.save(user);

                recordLoginAttempt(request.getUsernameOrEmail(), user, "FAILED", clientIp, userAgent, "Invalid credentials");
                throw new BadCredentialsException("Invalid username or password");
            }
        } else {
            recordLoginAttempt(request.getUsernameOrEmail(), null, "FAILED", clientIp, userAgent, "User does not exist");
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Transactional
    public AuthResponse refreshToken(RefreshTokenRequest request, HttpServletRequest httpRequest) {
        String tokenHash = hashToken(request.getRefreshToken());
        UserSession session = userSessionRepository.findByRefreshTokenHashAndRevokedAtIsNull(tokenHash)
                .orElseThrow(() -> new UnauthorizedException("Invalid or revoked refresh token"));

        if (session.isExpired()) {
            session.setRevokedAt(Instant.now());
            userSessionRepository.save(session);
            throw new UnauthorizedException("Refresh token has expired");
        }

        User user = session.getUser();
        if (user.getStatus() != User.Status.ACTIVE) {
            throw new UnauthorizedException("User account is inactive");
        }

        // Revoke old session and issue new rotated refresh token
        session.setRevokedAt(Instant.now());
        userSessionRepository.save(session);

        String newRawRefreshToken = tokenProvider.generateRefreshToken();
        String newHash = hashToken(newRawRefreshToken);

        UserSession newSession = UserSession.builder()
                .user(user)
                .refreshTokenHash(newHash)
                .deviceInfo(httpRequest.getHeader("User-Agent"))
                .ipAddress(getClientIP(httpRequest))
                .expiresAt(Instant.now().plus(tokenProvider.getRefreshTokenExpirationMs(), ChronoUnit.MILLIS))
                .build();
        userSessionRepository.save(newSession);

        UserPrincipal principal = UserPrincipal.create(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
        String newAccessToken = tokenProvider.generateAccessToken(authentication);

        List<String> roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList());
        List<String> permissions = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(a -> a.startsWith("PERM_"))
                .map(a -> a.substring(5))
                .collect(Collectors.toList());

        return AuthResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRawRefreshToken)
                .tokenType("Bearer")
                .expiresIn(900)
                .user(AuthResponse.UserDto.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .phone(user.getPhone())
                        .roles(roles)
                        .permissions(permissions)
                        .build())
                .build();
    }

    @Transactional
    public void logout(String rawRefreshToken) {
        if (rawRefreshToken != null && !rawRefreshToken.isBlank()) {
            String tokenHash = hashToken(rawRefreshToken);
            userSessionRepository.findByRefreshTokenHashAndRevokedAtIsNull(tokenHash)
                    .ifPresent(session -> {
                        session.setRevokedAt(Instant.now());
                        userSessionRepository.save(session);
                    });
        }
    }

    private void recordLoginAttempt(String username, User user, String status, String ip, String userAgent, String failureReason) {
        try {
            LoginHistory history = LoginHistory.builder()
                    .username(username)
                    .user(user)
                    .status(status)
                    .ipAddress(ip)
                    .userAgent(userAgent)
                    .failureReason(failureReason)
                    .build();
            loginHistoryRepository.save(history);
        } catch (Exception ex) {
            log.error("Failed to persist login audit record", ex);
        }
    }

    private String hashToken(String token) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(token.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new AppException("SHA-256 cryptographic algorithm not available");
        }
    }

    private String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(",")) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0].trim();
    }
}
