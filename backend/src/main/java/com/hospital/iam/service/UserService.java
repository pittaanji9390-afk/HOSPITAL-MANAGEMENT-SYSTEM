package com.hospital.iam.service;

import com.hospital.common.ConflictException;
import com.hospital.common.PagedResponse;
import com.hospital.common.ResourceNotFoundException;
import com.hospital.iam.dto.AuthResponse;
import com.hospital.iam.dto.ChangePasswordRequest;
import com.hospital.iam.dto.CreateUserRequest;
import com.hospital.iam.entity.Role;
import com.hospital.iam.entity.User;
import com.hospital.iam.repository.RoleRepository;
import com.hospital.iam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public PagedResponse<AuthResponse.UserDto> getUsers(String query, Pageable pageable) {
        Page<User> userPage;
        if (query != null && !query.isBlank()) {
            userPage = userRepository.searchUsers(query, pageable);
        } else {
            userPage = userRepository.findAll(pageable);
        }
        Page<AuthResponse.UserDto> dtoPage = userPage.map(this::mapToDto);
        return PagedResponse.from(dtoPage);
    }

    @Transactional(readOnly = true)
    public AuthResponse.UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapToDto(user);
    }

    @Transactional
    public AuthResponse.UserDto createUser(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ConflictException("Username is already taken");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException("Email is already registered");
        }

        Set<Role> roles = new HashSet<>();
        for (String roleName : request.getRoles()) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new ResourceNotFoundException("Role", "name", roleName));
            roles.add(role);
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .roles(roles)
                .status(User.Status.ACTIVE)
                .build();

        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    @Transactional
    public void changePassword(Long userId, ChangePasswordRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPasswordHash())) {
            throw new ConflictException("Current password does not match");
        }

        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    public AuthResponse.UserDto mapToDto(User user) {
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        List<String> permissions = user.getRoles().stream()
                .flatMap(r -> r.getPermissions().stream())
                .map(p -> p.getName())
                .distinct()
                .collect(Collectors.toList());

        return AuthResponse.UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .roles(roles)
                .permissions(permissions)
                .build();
    }
}
