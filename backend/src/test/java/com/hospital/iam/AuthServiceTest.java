package com.hospital.iam;

import com.hospital.common.BadRequestException;
import com.hospital.common.ConflictException;
import com.hospital.common.UnauthorizedException;
import com.hospital.iam.dto.AuthResponse;
import com.hospital.iam.dto.LoginRequest;
import com.hospital.iam.dto.RefreshTokenRequest;
import com.hospital.iam.entity.*;
import com.hospital.iam.repository.*;
import com.hospital.iam.service.AuthService;
import com.hospital.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSessionRepository sessionRepository;

    @Mock
    private LoginHistoryRepository loginHistoryRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthService authService;

    private User testUser;
    private Role testRole;

    @BeforeEach
    void setUp() {
        testRole = Role.builder()
                .id(1L)
                .name("ROLE_DOCTOR")
                .description("Physician")
                .permissions(Set.of(Permission.builder().id(1L).name("PATIENT_READ").build()))
                .build();

        testUser = User.builder()
                .id(1L)
                .username("dr.sharma")
                .email("dr.sharma@hospital.org")
                .passwordHash("$2a$12$hashedPassword")
                .firstName("Rajesh")
                .lastName("Sharma")
                .accountStatus(User.AccountStatus.ACTIVE)
                .roles(Set.of(testRole))
                .failedLoginAttempts(0)
                .build();
    }

    @Test
    @DisplayName("Should successfully authenticate user with valid credentials and return JWT token pair")
    void testLoginSuccess() {
        LoginRequest req = LoginRequest.builder()
                .usernameOrEmail("dr.sharma")
                .password("Hospital@123")
                .build();

        when(userRepository.findByUsernameOrEmail("dr.sharma", "dr.sharma")).thenReturn(Optional.of(testUser));
        when(passwordEncoder.matches("Hospital@123", testUser.getPasswordHash())).thenReturn(true);
        when(jwtTokenProvider.generateAccessToken(any(), any(), any())).thenReturn("mock-access-token");
        when(jwtTokenProvider.generateRefreshToken(any())).thenReturn("mock-refresh-token");
        when(jwtTokenProvider.getAccessTokenValidityMs()).thenReturn(900000L);

        AuthResponse response = authService.login(req, "192.168.1.100", "Mozilla/5.0");

        assertNotNull(response);
        assertEquals("mock-access-token", response.getAccessToken());
        assertEquals("mock-refresh-token", response.getRefreshToken());
        assertEquals("dr.sharma", response.getUser().getUsername());
        assertEquals(0, testUser.getFailedLoginAttempts());
        assertNotNull(testUser.getLastLoginAt());

        verify(sessionRepository, times(1)).save(any(UserSession.class));
        verify(loginHistoryRepository, times(1)).save(any(LoginHistory.class));
    }

    @Test
    @DisplayName("Should reject authentication with bad password and increment failed attempt counter")
    void testLoginBadPassword() {
        LoginRequest req = LoginRequest.builder()
                .usernameOrEmail("dr.sharma")
                .password("WrongPassword")
                .build();

        when(userRepository.findByUsernameOrEmail("dr.sharma", "dr.sharma")).thenReturn(Optional.of(testUser));
        when(passwordEncoder.matches("WrongPassword", testUser.getPasswordHash())).thenReturn(false);

        assertThrows(UnauthorizedException.class, () -> authService.login(req, "192.168.1.100", "Mozilla/5.0"));
        assertEquals(1, testUser.getFailedLoginAttempts());
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    @DisplayName("Should lock account when failed login attempts reach threshold (5)")
    void testLoginAccountLockout() {
        testUser.setFailedLoginAttempts(4);
        LoginRequest req = LoginRequest.builder()
                .usernameOrEmail("dr.sharma")
                .password("WrongPasswordAgain")
                .build();

        when(userRepository.findByUsernameOrEmail("dr.sharma", "dr.sharma")).thenReturn(Optional.of(testUser));
        when(passwordEncoder.matches("WrongPasswordAgain", testUser.getPasswordHash())).thenReturn(false);

        assertThrows(UnauthorizedException.class, () -> authService.login(req, "192.168.1.100", "Mozilla/5.0"));
        assertEquals(User.AccountStatus.LOCKED, testUser.getAccountStatus());
        assertNotNull(testUser.getLockedUntil());
    }

    @Test
    @DisplayName("Should rotate refresh token and issue new token pair")
    void testRefreshTokenRotationSuccess() {
        UserSession activeSession = UserSession.builder()
                .id(1L)
                .user(testUser)
                .refreshTokenHash("valid-refresh-token")
                .expiresAt(Instant.now().plusSeconds(86400))
                .revoked(false)
                .build();

        RefreshTokenRequest req = RefreshTokenRequest.builder()
                .refreshToken("valid-refresh-token")
                .build();

        when(jwtTokenProvider.validateToken("valid-refresh-token")).thenReturn(true);
        when(sessionRepository.findByRefreshTokenHash("valid-refresh-token")).thenReturn(Optional.of(activeSession));
        when(jwtTokenProvider.generateAccessToken(any(), any(), any())).thenReturn("new-access-token");
        when(jwtTokenProvider.generateRefreshToken(any())).thenReturn("new-refresh-token");
        when(jwtTokenProvider.getAccessTokenValidityMs()).thenReturn(900000L);

        AuthResponse response = authService.refreshToken(req, "192.168.1.100", "Mozilla/5.0");

        assertNotNull(response);
        assertEquals("new-access-token", response.getAccessToken());
        assertEquals("new-refresh-token", response.getRefreshToken());
        assertTrue(activeSession.isRevoked()); // Prior token revoked
        verify(sessionRepository, times(2)).save(any(UserSession.class)); // 1 for revocation, 1 for new session
    }
}
