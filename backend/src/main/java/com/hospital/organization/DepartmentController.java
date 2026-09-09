package com.hospital.organization;

import com.hospital.common.ApiResponse;
import com.hospital.common.ConflictException;
import com.hospital.common.PagedResponse;
import com.hospital.common.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByCode(String code);
    boolean existsByCode(String code);
    List<Department> findByActiveTrue();
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DepartmentDto {
    private Long id;
    @NotBlank(message = "Department code is required")
    private String code;
    @NotBlank(message = "Department name is required")
    private String name;
    @NotNull(message = "Department type is required")
    private Department.DepartmentType type;
    private Long headStaffId;
    private String phone;
    private String email;
    private String location;
    private boolean active;
}

@Service
@RequiredArgsConstructor
class DepartmentService {
    private final DepartmentRepository repository;

    @Transactional(readOnly = true)
    public PagedResponse<DepartmentDto> getAll(Pageable pageable) {
        Page<Department> page = repository.findAll(pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public List<DepartmentDto> getActiveDepartments() {
        return repository.findByActiveTrue().stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public DepartmentDto getById(Long id) {
        Department dept = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        return toDto(dept);
    }

    @Transactional
    public DepartmentDto create(DepartmentDto dto) {
        if (repository.existsByCode(dto.getCode())) {
            throw new ConflictException("Department code already exists: " + dto.getCode());
        }
        Department dept = Department.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .type(dto.getType())
                .headStaffId(dto.getHeadStaffId())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .location(dto.getLocation())
                .active(true)
                .build();
        return toDto(repository.save(dept));
    }

    @Transactional
    public DepartmentDto update(Long id, DepartmentDto dto) {
        Department dept = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        dept.setName(dto.getName());
        dept.setType(dto.getType());
        dept.setHeadStaffId(dto.getHeadStaffId());
        dept.setPhone(dto.getPhone());
        dept.setEmail(dto.getEmail());
        dept.setLocation(dto.getLocation());
        dept.setActive(dto.isActive());
        return toDto(repository.save(dept));
    }

    private DepartmentDto toDto(Department dept) {
        return DepartmentDto.builder()
                .id(dept.getId())
                .code(dept.getCode())
                .name(dept.getName())
                .type(dept.getType())
                .headStaffId(dept.getHeadStaffId())
                .phone(dept.getPhone())
                .email(dept.getEmail())
                .location(dept.getLocation())
                .active(dept.isActive())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Tag(name = "Departments", description = "Clinical, diagnostic, and administrative department management")
public class DepartmentController {
    private final DepartmentService service;

    @GetMapping
    @Operation(summary = "List all departments with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<DepartmentDto>>> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getAll(pageable)));
    }

    @GetMapping("/active")
    @Operation(summary = "Get list of all active departments for selection")
    public ResponseEntity<ApiResponse<List<DepartmentDto>>> getActive() {
        return ResponseEntity.ok(ApiResponse.ok(service.getActiveDepartments()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get department details by ID")
    public ResponseEntity<ApiResponse<DepartmentDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(service.getById(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('HOSPITAL_ADMIN') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Create a new hospital department")
    public ResponseEntity<ApiResponse<DepartmentDto>> create(@Valid @RequestBody DepartmentDto dto) {
        return new ResponseEntity<>(ApiResponse.ok(service.create(dto), "Department created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('HOSPITAL_ADMIN') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Update department details")
    public ResponseEntity<ApiResponse<DepartmentDto>> update(@PathVariable Long id, @Valid @RequestBody DepartmentDto dto) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(id, dto), "Department updated successfully"));
    }
}
