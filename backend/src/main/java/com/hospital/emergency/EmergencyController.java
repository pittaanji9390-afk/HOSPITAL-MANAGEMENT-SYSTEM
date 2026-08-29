package com.hospital.emergency;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "emergency_cases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyCase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "case_no", nullable = false, unique = true, length = 30)
    private String caseNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "anonymous_identifier", length = 50)
    private String anonymousIdentifier;

    @Column(name = "arrival_time", nullable = false)
    @Builder.Default
    private Instant arrivalTime = Instant.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "mode_of_arrival", length = 50)
    private ModeOfArrival modeOfArrival;

    @Column(name = "triage_level", nullable = false)
    private int triageLevel; // 1 = Resuscitation, 2 = Emergent, 3 = Urgent, 4 = Less Urgent, 5 = Non-Urgent

    @Enumerated(EnumType.STRING)
    @Column(name = "triage_priority", nullable = false, length = 20)
    private TriagePriority triagePriority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attending_doctor_id")
    private Doctor attendingDoctor;

    @Column(name = "chief_complaint", nullable = false, columnDefinition = "TEXT")
    private String chiefComplaint;

    @Column(name = "trauma_details", columnDefinition = "TEXT")
    private String traumaDetails;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private EmergencyStatus status = EmergencyStatus.TRIAGED;

    @Column(name = "outcome_notes", columnDefinition = "TEXT")
    private String outcomeNotes;

    @Column(name = "discharged_at")
    private Instant dischargedAt;

    @Version
    @Column(nullable = false)
    @Builder.Default
    private int version = 0;

    public enum ModeOfArrival {
        AMBULANCE, WALK_IN, POLICE, TRANSFER
    }

    public enum TriagePriority {
        CRITICAL, URGENT, MODERATE, LOW
    }

    public enum EmergencyStatus {
        TRIAGED, UNDER_TREATMENT, ADMITTED, TRANSFERRED, DISCHARGED, DECEASED
    }
}

@Repository
interface EmergencyCaseRepository extends JpaRepository<EmergencyCase, Long> {
    Optional<EmergencyCase> findByCaseNo(String caseNo);

    @Query("SELECT e FROM EmergencyCase e WHERE e.status IN ('TRIAGED', 'UNDER_TREATMENT') ORDER BY e.triageLevel ASC, e.arrivalTime ASC")
    List<EmergencyCase> findActiveQueue();

    @Query("SELECT e FROM EmergencyCase e WHERE (:status IS NULL OR e.status = :status)")
    Page<EmergencyCase> searchCases(@Param("status") EmergencyCase.EmergencyStatus status, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class EmergencyCaseDto {
    private Long id;
    private String caseNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private String anonymousIdentifier;
    private Instant arrivalTime;
    private EmergencyCase.ModeOfArrival modeOfArrival;
    private int triageLevel;
    private EmergencyCase.TriagePriority triagePriority;
    private Long attendingDoctorId;
    private String attendingDoctorName;
    private String chiefComplaint;
    private String traumaDetails;
    private EmergencyCase.EmergencyStatus status;
    private String outcomeNotes;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class TriageIntakeRequest {
    private Long patientId;
    private String anonymousIdentifier;
    private EmergencyCase.ModeOfArrival modeOfArrival;
    @Min(value = 1, message = "Triage level must be between 1 and 5")
    @Max(value = 5, message = "Triage level must be between 1 and 5")
    private int triageLevel;
    @NotNull(message = "Triage priority is required")
    private EmergencyCase.TriagePriority triagePriority;
    private Long attendingDoctorId;
    @NotBlank(message = "Chief complaint is required")
    private String chiefComplaint;
    private String traumaDetails;
}

@Service
@RequiredArgsConstructor
class EmergencyService {
    private final EmergencyCaseRepository repository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<EmergencyCaseDto> getActiveQueue() {
        return repository.findActiveQueue().stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public PagedResponse<EmergencyCaseDto> getAllCases(EmergencyCase.EmergencyStatus status, Pageable pageable) {
        Page<EmergencyCase> page = repository.searchCases(status, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional
    public EmergencyCaseDto intakeCase(TriageIntakeRequest req, String createdBy) {
        Patient patient = req.getPatientId() != null ? entityManager.getReference(Patient.class, req.getPatientId()) : null;
        Doctor doctor = req.getAttendingDoctorId() != null ? entityManager.getReference(Doctor.class, req.getAttendingDoctorId()) : null;

        String caseNo = sequenceService.getNextNumber("ER_SEQ");

        EmergencyCase emergencyCase = EmergencyCase.builder()
                .caseNo(caseNo)
                .patient(patient)
                .anonymousIdentifier(req.getAnonymousIdentifier())
                .arrivalTime(Instant.now())
                .modeOfArrival(req.getModeOfArrival() != null ? req.getModeOfArrival() : EmergencyCase.ModeOfArrival.AMBULANCE)
                .triageLevel(req.getTriageLevel())
                .triagePriority(req.getTriagePriority())
                .attendingDoctor(doctor)
                .chiefComplaint(req.getChiefComplaint())
                .traumaDetails(req.getTraumaDetails())
                .status(EmergencyCase.EmergencyStatus.TRIAGED)
                .build();
        emergencyCase.setCreatedBy(createdBy);

        return toDto(repository.save(emergencyCase));
    }

    @Transactional
    public EmergencyCaseDto updateCaseStatus(Long id, EmergencyCase.EmergencyStatus status, String outcomeNotes) {
        EmergencyCase emergencyCase = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Case", "id", id));

        emergencyCase.setStatus(status);
        if (outcomeNotes != null) {
            emergencyCase.setOutcomeNotes(outcomeNotes);
        }
        if (status == EmergencyCase.EmergencyStatus.DISCHARGED || status == EmergencyCase.EmergencyStatus.TRANSFERRED || status == EmergencyCase.EmergencyStatus.ADMITTED) {
            emergencyCase.setDischargedAt(Instant.now());
        }

        return toDto(repository.save(emergencyCase));
    }

    public EmergencyCaseDto toDto(EmergencyCase e) {
        String patientName = e.getPatient() != null ? (e.getPatient().getFirstName() + " " + e.getPatient().getLastName()) : (e.getAnonymousIdentifier() != null ? e.getAnonymousIdentifier() : "Unknown Trauma Patient");
        String patientMrn = e.getPatient() != null ? e.getPatient().getMrn() : "N/A";
        String doctorName = e.getAttendingDoctor() != null ? ("Dr. " + e.getAttendingDoctor().getStaff().getFirstName() + " " + e.getAttendingDoctor().getStaff().getLastName()) : "Unassigned ER Physician";

        return EmergencyCaseDto.builder()
                .id(e.getId())
                .caseNo(e.getCaseNo())
                .patientId(e.getPatient() != null ? e.getPatient().getId() : null)
                .patientName(patientName)
                .patientMrn(patientMrn)
                .anonymousIdentifier(e.getAnonymousIdentifier())
                .arrivalTime(e.getArrivalTime())
                .modeOfArrival(e.getModeOfArrival())
                .triageLevel(e.getTriageLevel())
                .triagePriority(e.getTriagePriority())
                .attendingDoctorId(e.getAttendingDoctor() != null ? e.getAttendingDoctor().getId() : null)
                .attendingDoctorName(doctorName)
                .chiefComplaint(e.getChiefComplaint())
                .traumaDetails(e.getTraumaDetails())
                .status(e.getStatus())
                .outcomeNotes(e.getOutcomeNotes())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/emergency")
@RequiredArgsConstructor
@Tag(name = "Emergency & Trauma", description = "Emergency triage queue (ESI 1-5), resuscitation, and trauma intake")
public class EmergencyController {
    private final EmergencyService emergencyService;

    @GetMapping("/active-queue")
    @Operation(summary = "Get active real-time emergency triage dashboard queue")
    public ResponseEntity<ApiResponse<List<EmergencyCaseDto>>> getActiveQueue() {
        return ResponseEntity.ok(ApiResponse.ok(emergencyService.getActiveQueue()));
    }

    @GetMapping("/cases")
    @Operation(summary = "List all emergency cases with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<EmergencyCaseDto>>> getAllCases(
            @RequestParam(required = false) EmergencyCase.EmergencyStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(emergencyService.getAllCases(status, pageable)));
    }

    @PostMapping("/intake")
    @PreAuthorize("hasAuthority('PERM_EMERGENCY_TRIAGE') or hasRole('NURSE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Intake and triage a new emergency case")
    public ResponseEntity<ApiResponse<EmergencyCaseDto>> intakeCase(@Valid @RequestBody TriageIntakeRequest request) {
        EmergencyCaseDto result = emergencyService.intakeCase(request, "SYSTEM");
        return new ResponseEntity<>(ApiResponse.ok(result, "Emergency case triaged"), HttpStatus.CREATED);
    }

    @PatchMapping("/cases/{id}/status")
    @PreAuthorize("hasAuthority('PERM_EMERGENCY_TRIAGE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Update emergency case status (UNDER_TREATMENT, ADMITTED, DISCHARGED, DECEASED)")
    public ResponseEntity<ApiResponse<EmergencyCaseDto>> updateStatus(
            @PathVariable Long id,
            @RequestParam EmergencyCase.EmergencyStatus status,
            @RequestParam(required = false) String outcomeNotes) {
        return ResponseEntity.ok(ApiResponse.ok(emergencyService.updateCaseStatus(id, status, outcomeNotes), "Case status updated"));
    }
}
