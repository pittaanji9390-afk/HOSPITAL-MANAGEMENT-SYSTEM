package com.hospital.ipd;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.organization.Department;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import com.hospital.staff.Staff;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
interface WardRepository extends JpaRepository<Ward, Long> {
    List<Ward> findByActiveTrue();
}

@Repository
interface BedRepository extends JpaRepository<Bed, Long> {
    List<Bed> findByRoomWardIdAndStatus(Long wardId, Bed.BedStatus status);
    List<Bed> findByStatus(Bed.BedStatus status);
    Optional<Bed> findByIdAndStatus(Long id, Bed.BedStatus status);
}

@Repository
interface IpdAdmissionRepository extends JpaRepository<IpdAdmission, Long> {
    Optional<IpdAdmission> findByAdmissionNo(String admissionNo);

    @Query("SELECT a FROM IpdAdmission a WHERE (:wardId IS NULL OR a.ward.id = :wardId) AND (:status IS NULL OR a.status = :status)")
    Page<IpdAdmission> searchAdmissions(@Param("wardId") Long wardId, @Param("status") IpdAdmission.AdmissionStatus status, Pageable pageable);

    List<IpdAdmission> findByPatientIdAndStatus(Long patientId, IpdAdmission.AdmissionStatus status);
}

@Repository
interface BedAssignmentRepository extends JpaRepository<BedAssignment, Long> {
    List<BedAssignment> findByAdmissionIdOrderByAssignedAtDesc(Long admissionId);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AdmissionDto {
    private Long id;
    private String admissionNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private String patientPhone;
    private Long primaryDoctorId;
    private String primaryDoctorName;
    private Long departmentId;
    private String departmentName;
    private Long wardId;
    private String wardName;
    private Long bedId;
    private String bedNumber;
    private String roomNumber;
    private Instant admissionDate;
    private Instant dischargeDate;
    private IpdAdmission.AdmissionType admissionType;
    private String admissionReason;
    private String provisionalDiagnosis;
    private IpdAdmission.DischargeType dischargeType;
    private String dischargeSummary;
    private IpdAdmission.AdmissionStatus status;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AdmitPatientRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Doctor ID is required")
    private Long primaryDoctorId;
    @NotNull(message = "Department ID is required")
    private Long departmentId;
    @NotNull(message = "Ward ID is required")
    private Long wardId;
    @NotNull(message = "Bed ID is required")
    private Long bedId;
    private IpdAdmission.AdmissionType admissionType;
    @NotBlank(message = "Admission reason is required")
    private String admissionReason;
    private String provisionalDiagnosis;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DischargeRequest {
    @NotNull(message = "Discharge type is required")
    private IpdAdmission.DischargeType dischargeType;
    @NotBlank(message = "Discharge summary is required")
    private String dischargeSummary;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BedDto {
    private Long id;
    private String bedNumber;
    private Long roomId;
    private String roomNumber;
    private Long wardId;
    private String wardName;
    private BigDecimal ratePerDay;
    private Bed.BedStatus status;
}

@Service
@RequiredArgsConstructor
class IpdService {
    private final IpdAdmissionRepository admissionRepository;
    private final BedRepository bedRepository;
    private final BedAssignmentRepository assignmentRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<AdmissionDto> getAdmissions(Long wardId, IpdAdmission.AdmissionStatus status, Pageable pageable) {
        Page<IpdAdmission> page = admissionRepository.searchAdmissions(wardId, status, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public AdmissionDto getById(Long id) {
        IpdAdmission a = admissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("IPD Admission", "id", id));
        return toDto(a);
    }

    @Transactional(readOnly = true)
    public List<BedDto> getAvailableBeds(Long wardId) {
        List<Bed> beds;
        if (wardId != null) {
            beds = bedRepository.findByRoomWardIdAndStatus(wardId, Bed.BedStatus.AVAILABLE);
        } else {
            beds = bedRepository.findByStatus(Bed.BedStatus.AVAILABLE);
        }
        return beds.stream().map(this::toBedDto).toList();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public AdmissionDto admitPatient(AdmitPatientRequest req, String createdBy) {
        // Concurrency-safe bed allocation
        Bed bed = bedRepository.findById(req.getBedId())
                .orElseThrow(() -> new ResourceNotFoundException("Bed", "id", req.getBedId()));

        if (bed.getStatus() != Bed.BedStatus.AVAILABLE) {
            throw new ConflictException("Selected bed " + bed.getBedNumber() + " is currently " + bed.getStatus() + " and cannot be occupied.");
        }

        bed.setStatus(Bed.BedStatus.OCCUPIED);
        bedRepository.save(bed);

        Patient patient = entityManager.getReference(Patient.class, req.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, req.getPrimaryDoctorId());
        Department department = entityManager.getReference(Department.class, req.getDepartmentId());
        Ward ward = entityManager.getReference(Ward.class, req.getWardId());

        String admNo = sequenceService.getNextNumber("ADM_SEQ");

        IpdAdmission admission = IpdAdmission.builder()
                .admissionNo(admNo)
                .patient(patient)
                .primaryDoctor(doctor)
                .department(department)
                .ward(ward)
                .currentBed(bed)
                .admissionDate(Instant.now())
                .admissionType(req.getAdmissionType() != null ? req.getAdmissionType() : IpdAdmission.AdmissionType.PLANNED)
                .admissionReason(req.getAdmissionReason())
                .provisionalDiagnosis(req.getProvisionalDiagnosis())
                .status(IpdAdmission.AdmissionStatus.ADMITTED)
                .build();
        admission.setCreatedBy(createdBy);

        IpdAdmission savedAdmission = admissionRepository.save(admission);

        BedAssignment assignment = BedAssignment.builder()
                .admission(savedAdmission)
                .bed(bed)
                .assignedAt(Instant.now())
                .assignedBy(createdBy)
                .build();
        assignmentRepository.save(assignment);

        return toDto(savedAdmission);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public AdmissionDto dischargePatient(Long admissionId, DischargeRequest req, String dischargedBy) {
        IpdAdmission admission = admissionRepository.findById(admissionId)
                .orElseThrow(() -> new ResourceNotFoundException("IPD Admission", "id", admissionId));

        if (admission.getStatus() != IpdAdmission.AdmissionStatus.ADMITTED) {
            throw new BadRequestException("Admission is not currently active");
        }

        // Release the bed
        Bed bed = admission.getCurrentBed();
        bed.setStatus(Bed.BedStatus.CLEANING); // Moves to cleaning before available
        bedRepository.save(bed);

        // Close bed assignment
        List<BedAssignment> assignments = assignmentRepository.findByAdmissionIdOrderByAssignedAtDesc(admissionId);
        if (!assignments.isEmpty()) {
            BedAssignment currentAssignment = assignments.get(0);
            currentAssignment.setReleasedAt(Instant.now());
            assignmentRepository.save(currentAssignment);
        }

        admission.setDischargeDate(Instant.now());
        admission.setDischargeType(req.getDischargeType());
        admission.setDischargeSummary(req.getDischargeSummary());
        admission.setStatus(IpdAdmission.AdmissionStatus.DISCHARGED);
        admission.setUpdatedBy(dischargedBy);

        return toDto(admissionRepository.save(admission));
    }

    public AdmissionDto toDto(IpdAdmission a) {
        return AdmissionDto.builder()
                .id(a.getId())
                .admissionNo(a.getAdmissionNo())
                .patientId(a.getPatient().getId())
                .patientName(a.getPatient().getFirstName() + " " + a.getPatient().getLastName())
                .patientMrn(a.getPatient().getMrn())
                .patientPhone(a.getPatient().getPhone())
                .primaryDoctorId(a.getPrimaryDoctor().getId())
                .primaryDoctorName("Dr. " + a.getPrimaryDoctor().getStaff().getFirstName() + " " + a.getPrimaryDoctor().getStaff().getLastName())
                .departmentId(a.getDepartment().getId())
                .departmentName(a.getDepartment().getName())
                .wardId(a.getWard().getId())
                .wardName(a.getWard().getName())
                .bedId(a.getCurrentBed().getId())
                .bedNumber(a.getCurrentBed().getBedNumber())
                .roomNumber(a.getCurrentBed().getRoom().getRoomNumber())
                .admissionDate(a.getAdmissionDate())
                .dischargeDate(a.getDischargeDate())
                .admissionType(a.getAdmissionType())
                .admissionReason(a.getAdmissionReason())
                .provisionalDiagnosis(a.getProvisionalDiagnosis())
                .dischargeType(a.getDischargeType())
                .dischargeSummary(a.getDischargeSummary())
                .status(a.getStatus())
                .build();
    }

    public BedDto toBedDto(Bed b) {
        return BedDto.builder()
                .id(b.getId())
                .bedNumber(b.getBedNumber())
                .roomId(b.getRoom().getId())
                .roomNumber(b.getRoom().getRoomNumber())
                .wardId(b.getRoom().getWard().getId())
                .wardName(b.getRoom().getWard().getName())
                .ratePerDay(b.getRoom().getRatePerDay())
                .status(b.getStatus())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/ipd")
@RequiredArgsConstructor
@Tag(name = "Inpatient Department (IPD) & Wards", description = "Inpatient admissions, ward beds, rounds, and discharges")
public class IpdController {
    private final IpdService ipdService;

    @GetMapping("/admissions")
    @Operation(summary = "Search inpatient admissions by ward and status")
    public ResponseEntity<ApiResponse<PagedResponse<AdmissionDto>>> getAdmissions(
            @RequestParam(required = false) Long wardId,
            @RequestParam(required = false) IpdAdmission.AdmissionStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(ipdService.getAdmissions(wardId, status, pageable)));
    }

    @GetMapping("/admissions/{id}")
    @Operation(summary = "Get inpatient admission details")
    public ResponseEntity<ApiResponse<AdmissionDto>> getAdmissionById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(ipdService.getById(id)));
    }

    @GetMapping("/beds/available")
    @Operation(summary = "Get currently available inpatient beds")
    public ResponseEntity<ApiResponse<List<BedDto>>> getAvailableBeds(@RequestParam(required = false) Long wardId) {
        return ResponseEntity.ok(ApiResponse.ok(ipdService.getAvailableBeds(wardId)));
    }

    @PostMapping("/admissions")
    @PreAuthorize("hasAuthority('PERM_IPD_MANAGE') or hasRole('DOCTOR') or hasRole('NURSE') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Admit patient with transactional bed allocation")
    public ResponseEntity<ApiResponse<AdmissionDto>> admitPatient(@Valid @RequestBody AdmitPatientRequest request) {
        AdmissionDto admission = ipdService.admitPatient(request, "SYSTEM");
        return new ResponseEntity<>(ApiResponse.ok(admission, "Patient admitted successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/admissions/{id}/discharge")
    @PreAuthorize("hasAuthority('PERM_IPD_MANAGE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Discharge inpatient and release bed")
    public ResponseEntity<ApiResponse<AdmissionDto>> dischargePatient(
            @PathVariable Long id,
            @Valid @RequestBody DischargeRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(ipdService.dischargePatient(id, request, "SYSTEM"), "Patient discharged successfully"));
    }
}
