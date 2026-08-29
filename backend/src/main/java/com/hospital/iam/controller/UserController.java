package com.hospital.iam.controller;

import com.hospital.common.ApiResponse;
import com.hospital.common.PagedResponse;
import com.hospital.iam.dto.AuthResponse;
import com.hospital.iam.dto.ChangePasswordRequest;
import com.hospital.iam.dto.CreateUserRequest;
import com.hospital.iam.service.UserService;
import com.hospital.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "User administration and profile endpoints")
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('PERM_USER_READ') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "List and search users with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<AuthResponse.UserDto>>> getUsers(
            @RequestParam(required = false) String query,
            @PageableDefault(size = 20) Pageable pageable) {
        PagedResponse<AuthResponse.UserDto> response = userService.getUsers(query, pageable);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @GetMapping("/me")
    @Operation(summary = "Get current authenticated user profile")
    public ResponseEntity<ApiResponse<AuthResponse.UserDto>> getCurrentUser(@AuthenticationPrincipal UserPrincipal principal) {
        AuthResponse.UserDto user = userService.getUserById(principal.getId());
        return ResponseEntity.ok(ApiResponse.ok(user));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PERM_USER_READ') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Get user details by ID")
    public ResponseEntity<ApiResponse<AuthResponse.UserDto>> getUserById(@PathVariable Long id) {
        AuthResponse.UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.ok(user));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PERM_USER_WRITE') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Create a new hospital staff or admin user account")
    public ResponseEntity<ApiResponse<AuthResponse.UserDto>> createUser(@Valid @RequestBody CreateUserRequest request) {
        AuthResponse.UserDto user = userService.createUser(request);
        return new ResponseEntity<>(ApiResponse.ok(user, "User account created successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/change-password")
    @Operation(summary = "Change password for the current authenticated user")
    public ResponseEntity<ApiResponse<Void>> changePassword(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(principal.getId(), request);
        return ResponseEntity.ok(ApiResponse.ok(null, "Password changed successfully"));
    }
}
