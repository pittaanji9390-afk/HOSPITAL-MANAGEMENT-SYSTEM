package com.hospital.staff;

import com.hospital.common.ApiResponse;
import com.hospital.common.ConflictException;
import com.hospital.common.PagedResponse;
import com.hospital.common.ResourceNotFoundException;
import com.hospital.organization.Department;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class StaffDto {
    private Long id;
    private Long userId;
    private String employeeNo;
    @NotNull(message = "Department is required")
    private Long departmentId;
    private String departmentName;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Gender is required")
    private Staff.Gender gender;
    @NotNull(message = "Date of birth is required")
    private LocalDate dob;
    @NotBlank(message = "Phone is required")
    private String phone;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Designation is required")
    private String designation;
    private String qualification;
    @NotNull(message = "Join date is required")
    private LocalDate joinDate;
    private boolean active;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DoctorDto {
    private Long id;
    private Long staffId;
    private String doctorName;
    private String employeeNo;
    private Long departmentId;
    private String departmentName;
    private String phone;
    private String email;
    @NotBlank(message = "License number is required")
    private String licenseNo;
    @NotBlank(message = "Specialization is required")
    private String specialization;
    private String subSpecialization;
    @NotNull(message = "Consultation fee is required")
    private BigDecimal consultationFee;
    private BigDecimal followUpFee;
    private int maxDailyPatients;
    private boolean availableForTelemed;
    private boolean active;
    private List<DoctorScheduleDto> schedules;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DoctorScheduleDto {
    private Long id;
    private int dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private int slotDurationMinutes;
    private int maxSlots;
    private boolean active;
}

@Service
@RequiredArgsConstructor
class StaffService {
    private final StaffRepository staffRepository;

    @Transactional(readOnly = true)
    public PagedResponse<StaffDto> getStaff(String query, Pageable pageable) {
        Page<Staff> page;
        if (query != null && !query.isBlank()) {
            page = staffRepository.searchStaff(query, pageable);
        } else {
            page = staffRepository.findByActiveTrue(pageable);
        }
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public StaffDto getById(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", id));
        return toDto(staff);
    }

    public StaffDto toDto(Staff staff) {
        return StaffDto.builder()
                .id(staff.getId())
                .userId(staff.getUser() != null ? staff.getUser().getId() : null)
                .employeeNo(staff.getEmployeeNo())
                .departmentId(staff.getDepartment().getId())
                .departmentName(staff.getDepartment().getName())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .gender(staff.getGender())
                .dob(staff.getDob())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .designation(staff.getDesignation())
                .qualification(staff.getQualification())
                .joinDate(staff.getJoinDate())
                .active(staff.isActive())
                .build();
    }
}

@Service
@RequiredArgsConstructor
class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public PagedResponse<DoctorDto> getDoctors(String query, Pageable pageable) {
        Page<Doctor> page;
        if (query != null && !query.isBlank()) {
            page = doctorRepository.searchDoctors(query, pageable);
        } else {
            page = doctorRepository.findAll(pageable);
        }
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public List<DoctorDto> getActiveDoctors() {
        return doctorRepository.findByActiveTrue().stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public List<DoctorDto> getDoctorsByDepartment(Long departmentId) {
        return doctorRepository.findByStaffDepartmentIdAndActiveTrue(departmentId).stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public DoctorDto getById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        return toDto(doctor);
    }

    public DoctorDto toDto(Doctor doctor) {
        List<DoctorScheduleDto> schedules = scheduleRepository.findByDoctorIdAndActiveTrue(doctor.getId())
                .stream()
                .map(s -> DoctorScheduleDto.builder()
                        .id(s.getId())
                        .dayOfWeek(s.getDayOfWeek())
                        .startTime(s.getStartTime())
                        .endTime(s.getEndTime())
                        .slotDurationMinutes(s.getSlotDurationMinutes())
                        .maxSlots(s.getMaxSlots())
                        .active(s.isActive())
                        .build())
                .collect(Collectors.toList());

        Staff staff = doctor.getStaff();
        return DoctorDto.builder()
                .id(doctor.getId())
                .staffId(staff.getId())
                .doctorName("Dr. " + staff.getFirstName() + " " + staff.getLastName())
                .employeeNo(staff.getEmployeeNo())
                .departmentId(staff.getDepartment().getId())
                .departmentName(staff.getDepartment().getName())
                .phone(staff.getPhone())
                .email(staff.getEmail())
                .licenseNo(doctor.getLicenseNo())
                .specialization(doctor.getSpecialization())
                .subSpecialization(doctor.getSubSpecialization())
                .consultationFee(doctor.getConsultationFee())
                .followUpFee(doctor.getFollowUpFee())
                .maxDailyPatients(doctor.getMaxDailyPatients())
                .availableForTelemed(doctor.isAvailableForTelemed())
                .active(doctor.isActive())
                .schedules(schedules)
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
@Tag(name = "Staff Management", description = "Clinical and administrative hospital employee records")
class StaffController {
    private final StaffService staffService;

    @GetMapping
    @Operation(summary = "List and search hospital staff")
    public ResponseEntity<ApiResponse<PagedResponse<StaffDto>>> getStaff(
            @RequestParam(required = false) String query,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(staffService.getStaff(query, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get staff details by ID")
    public ResponseEntity<ApiResponse<StaffDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(staffService.getById(id)));
    }
}

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
@Tag(name = "Doctors & Specialists", description = "Physician directory, specializations, and schedules")
class DoctorController {
    private final DoctorService doctorService;

    @GetMapping
    @Operation(summary = "List and search active doctors")
    public ResponseEntity<ApiResponse<PagedResponse<DoctorDto>>> getDoctors(
            @RequestParam(required = false) String query,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(doctorService.getDoctors(query, pageable)));
    }

    @GetMapping("/active")
    @Operation(summary = "Get all active doctors for appointment dropdowns")
    public ResponseEntity<ApiResponse<List<DoctorDto>>> getActive() {
        return ResponseEntity.ok(ApiResponse.ok(doctorService.getActiveDoctors()));
    }

    @GetMapping("/department/{deptId}")
    @Operation(summary = "Get doctors by department")
    public ResponseEntity<ApiResponse<List<DoctorDto>>> getByDepartment(@PathVariable Long deptId) {
        return ResponseEntity.ok(ApiResponse.ok(doctorService.getDoctorsByDepartment(deptId)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get doctor profile and weekly schedules")
    public ResponseEntity<ApiResponse<DoctorDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(doctorService.getById(id)));
    }
}
