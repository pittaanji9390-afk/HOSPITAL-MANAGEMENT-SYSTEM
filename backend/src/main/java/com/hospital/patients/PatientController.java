package com.hospital.patients;

import com.hospital.common.ApiResponse;
import com.hospital.common.ConflictException;
import com.hospital.common.PagedResponse;
import com.hospital.common.ResourceNotFoundException;
import com.hospital.configuration.SequenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByMrn(String mrn);
    boolean existsByMrn(String mrn);

    @Query("SELECT p FROM Patient p WHERE p.status != 'MERGED' AND (" +
           "LOWER(p.mrn) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(p.firstName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(p.lastName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "p.phone LIKE CONCAT('%', :query, '%') OR " +
           "LOWER(p.email) LIKE LOWER(CONCAT('%', :query, '%')))")
    Page<Patient> searchPatients(@Param("query") String query, Pageable pageable);

    @Query("SELECT p FROM Patient p WHERE p.phone = :phone AND p.status = 'ACTIVE' AND p.id != :excludeId")
    List<Patient> findPotentialDuplicatesByPhone(@Param("phone") String phone, @Param("excludeId") Long excludeId);
}

@Repository
interface PatientConsentRepository extends JpaRepository<PatientConsent, Long> {
    List<PatientConsent> findByPatientIdOrderByGrantedAtDesc(Long patientId);
}

@Repository
interface PatientMergeRepository extends JpaRepository<PatientMerge, Long> {
    List<PatientMerge> findByPrimaryPatientId(Long primaryPatientId);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PatientDto {
    private Long id;
    private String mrn;
    @NotBlank(message = "First name is required")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Date of birth is required")
    private LocalDate dob;
    @NotNull(message = "Gender is required")
    private Patient.Gender gender;
    private String bloodGroup;
    private String nationalId;
    @NotBlank(message = "Phone number is required")
    private String phone;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String emergencyContactName;
    private String emergencyContactRelation;
    private String emergencyContactPhone;
    private String maritalStatus;
    private Patient.PatientStatus status;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class MergeRequest {
    @NotNull(message = "Primary patient ID is required")
    private Long primaryPatientId;
    @NotNull(message = "Secondary patient ID to merge is required")
    private Long secondaryPatientId;
    @NotBlank(message = "Merge reason is required")
    private String reason;
}

@Service
@RequiredArgsConstructor
class PatientService {
    private final PatientRepository patientRepository;
    private final PatientConsentRepository consentRepository;
    private final PatientMergeRepository mergeRepository;
    private final SequenceService sequenceService;

    @Transactional(readOnly = true)
    public PagedResponse<PatientDto> getPatients(String query, Pageable pageable) {
        Page<Patient> page;
        if (query != null && !query.isBlank()) {
            page = patientRepository.searchPatients(query, pageable);
        } else {
            page = patientRepository.findAll(pageable);
        }
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public PatientDto getById(Long id) {
        Patient p = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        return toDto(p);
    }

    @Transactional(readOnly = true)
    public PatientDto getByMrn(String mrn) {
        Patient p = patientRepository.findByMrn(mrn)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "MRN", mrn));
        return toDto(p);
    }

    @Transactional
    public PatientDto registerPatient(PatientDto dto, String createdBy) {
        String mrn = sequenceService.getNextNumber("MRN_SEQ");

        Patient patient = Patient.builder()
                .mrn(mrn)
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .dob(dto.getDob())
                .gender(dto.getGender())
                .bloodGroup(dto.getBloodGroup())
                .nationalId(dto.getNationalId())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .city(dto.getCity())
                .state(dto.getState())
                .postalCode(dto.getPostalCode())
                .country(dto.getCountry() != null ? dto.getCountry() : "India")
                .emergencyContactName(dto.getEmergencyContactName())
                .emergencyContactRelation(dto.getEmergencyContactRelation())
                .emergencyContactPhone(dto.getEmergencyContactPhone())
                .maritalStatus(dto.getMaritalStatus())
                .status(Patient.PatientStatus.ACTIVE)
                .build();
        patient.setCreatedBy(createdBy);

        Patient saved = patientRepository.save(patient);
        return toDto(saved);
    }

    @Transactional
    public PatientDto updatePatient(Long id, PatientDto dto, String updatedBy) {
        Patient p = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));

        p.setFirstName(dto.getFirstName());
        p.setMiddleName(dto.getMiddleName());
        p.setLastName(dto.getLastName());
        p.setDob(dto.getDob());
        p.setGender(dto.getGender());
        p.setBloodGroup(dto.getBloodGroup());
        p.setNationalId(dto.getNationalId());
        p.setPhone(dto.getPhone());
        p.setEmail(dto.getEmail());
        p.setAddressLine1(dto.getAddressLine1());
        p.setAddressLine2(dto.getAddressLine2());
        p.setCity(dto.getCity());
        p.setState(dto.getState());
        p.setPostalCode(dto.getPostalCode());
        p.setCountry(dto.getCountry());
        p.setEmergencyContactName(dto.getEmergencyContactName());
        p.setEmergencyContactRelation(dto.getEmergencyContactRelation());
        p.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        p.setMaritalStatus(dto.getMaritalStatus());
        p.setUpdatedBy(updatedBy);

        return toDto(patientRepository.save(p));
    }

    @Transactional
    public void mergePatients(MergeRequest request, String mergedBy) {
        if (request.getPrimaryPatientId().equals(request.getSecondaryPatientId())) {
            throw new ConflictException("Cannot merge a patient into itself");
        }

        Patient primary = patientRepository.findById(request.getPrimaryPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Primary Patient", "id", request.getPrimaryPatientId()));
        Patient secondary = patientRepository.findById(request.getSecondaryPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Secondary Patient", "id", request.getSecondaryPatientId()));

        secondary.setStatus(Patient.PatientStatus.MERGED);
        secondary.setMergedInto(primary);
        patientRepository.save(secondary);

        PatientMerge merge = PatientMerge.builder()
                .primaryPatient(primary)
                .mergedPatient(secondary)
                .reason(request.getReason())
                .mergedBy(mergedBy)
                .build();
        mergeRepository.save(merge);
    }

    public PatientDto toDto(Patient p) {
        return PatientDto.builder()
                .id(p.getId())
                .mrn(p.getMrn())
                .firstName(p.getFirstName())
                .middleName(p.getMiddleName())
                .lastName(p.getLastName())
                .dob(p.getDob())
                .gender(p.getGender())
                .bloodGroup(p.getBloodGroup())
                .nationalId(p.getNationalId())
                .phone(p.getPhone())
                .email(p.getEmail())
                .addressLine1(p.getAddressLine1())
                .addressLine2(p.getAddressLine2())
                .city(p.getCity())
                .state(p.getState())
                .postalCode(p.getPostalCode())
                .country(p.getCountry())
                .emergencyContactName(p.getEmergencyContactName())
                .emergencyContactRelation(p.getEmergencyContactRelation())
                .emergencyContactPhone(p.getEmergencyContactPhone())
                .maritalStatus(p.getMaritalStatus())
                .status(p.getStatus())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
@Tag(name = "Master Patient Index", description = "Patient registration, demographics, and merge workflows")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    @PreAuthorize("hasAuthority('PERM_PATIENT_READ') or hasRole('SUPER_ADMIN') or hasRole('DOCTOR') or hasRole('NURSE') or hasRole('RECEPTIONIST')")
    @Operation(summary = "Search and list patients with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<PatientDto>>> getPatients(
            @RequestParam(required = false) String query,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(patientService.getPatients(query, pageable)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PERM_PATIENT_READ') or hasRole('SUPER_ADMIN') or hasRole('DOCTOR') or hasRole('NURSE')")
    @Operation(summary = "Get patient demographics by ID")
    public ResponseEntity<ApiResponse<PatientDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(patientService.getById(id)));
    }

    @GetMapping("/mrn/{mrn}")
    @PreAuthorize("hasAuthority('PERM_PATIENT_READ') or hasRole('SUPER_ADMIN') or hasRole('DOCTOR') or hasRole('NURSE')")
    @Operation(summary = "Find patient by Medical Record Number (MRN)")
    public ResponseEntity<ApiResponse<PatientDto>> getByMrn(@PathVariable String mrn) {
        return ResponseEntity.ok(ApiResponse.ok(patientService.getByMrn(mrn)));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PERM_PATIENT_WRITE') or hasRole('RECEPTIONIST') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Register a new patient and generate unique MRN")
    public ResponseEntity<ApiResponse<PatientDto>> registerPatient(@Valid @RequestBody PatientDto dto) {
        PatientDto created = patientService.registerPatient(dto, "SYSTEM");
        return new ResponseEntity<>(ApiResponse.ok(created, "Patient registered successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PERM_PATIENT_WRITE') or hasRole('RECEPTIONIST') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Update patient demographics")
    public ResponseEntity<ApiResponse<PatientDto>> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientDto dto) {
        return ResponseEntity.ok(ApiResponse.ok(patientService.updatePatient(id, dto, "SYSTEM"), "Patient updated successfully"));
    }

    @PostMapping("/merge")
    @PreAuthorize("hasAuthority('PERM_PATIENT_MERGE') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Merge duplicate patient records")
    public ResponseEntity<ApiResponse<Void>> mergePatients(@Valid @RequestBody MergeRequest request) {
        patientService.mergePatients(request, "SYSTEM");
        return ResponseEntity.ok(ApiResponse.ok(null, "Patient records merged successfully"));
    }
}
