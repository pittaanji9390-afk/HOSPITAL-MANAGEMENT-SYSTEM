package com.hospital.opd;

import com.hospital.appointments.Appointment;
import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.organization.Department;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
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

import java.time.Instant;
import java.util.Optional;

@Entity
@Table(name = "opd_encounters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpdEncounter extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "encounter_no", nullable = false, unique = true, length = 30)
    private String encounterNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(name = "encounter_date", nullable = false)
    @Builder.Default
    private Instant encounterDate = Instant.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "triage_priority", nullable = false, length = 20)
    @Builder.Default
    private TriagePriority triagePriority = TriagePriority.ROUTINE;

    @Column(name = "chief_complaint", nullable = false, columnDefinition = "TEXT")
    private String chiefComplaint;

    @Column(name = "history_of_present_illness", columnDefinition = "TEXT")
    private String historyOfPresentIllness;

    @Column(name = "physical_examination", columnDefinition = "TEXT")
    private String physicalExamination;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private EncounterStatus status = EncounterStatus.WAITING;

    @Version
    @Column(nullable = false)
    @Builder.Default
    private int version = 0;

    public enum TriagePriority {
        ROUTINE, PRIORITY, URGENT
    }

    public enum EncounterStatus {
        WAITING, WITH_DOCTOR, COMPLETED, CANCELLED
    }
}

@Repository
interface OpdEncounterRepository extends JpaRepository<OpdEncounter, Long> {
    Optional<OpdEncounter> findByEncounterNo(String encounterNo);

    @Query("SELECT e FROM OpdEncounter e WHERE (:doctorId IS NULL OR e.doctor.id = :doctorId) AND (:status IS NULL OR e.status = :status)")
    Page<OpdEncounter> searchEncounters(@Param("doctorId") Long doctorId, @Param("status") OpdEncounter.EncounterStatus status, Pageable pageable);

    Page<OpdEncounter> findByPatientIdOrderByEncounterDateDesc(Long patientId, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class OpdEncounterDto {
    private Long id;
    private String encounterNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private String patientPhone;
    private Long doctorId;
    private String doctorName;
    private Long departmentId;
    private String departmentName;
    private Long appointmentId;
    private Instant encounterDate;
    private OpdEncounter.TriagePriority triagePriority;
    private String chiefComplaint;
    private String historyOfPresentIllness;
    private String physicalExamination;
    private OpdEncounter.EncounterStatus status;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateOpdEncounterRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    @NotNull(message = "Department ID is required")
    private Long departmentId;
    private Long appointmentId;
    private OpdEncounter.TriagePriority triagePriority;
    @NotBlank(message = "Chief complaint is required")
    private String chiefComplaint;
    private String historyOfPresentIllness;
    private String physicalExamination;
}

@Service
@RequiredArgsConstructor
class OpdService {
    private final OpdEncounterRepository repository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<OpdEncounterDto> getEncounters(Long doctorId, OpdEncounter.EncounterStatus status, Pageable pageable) {
        Page<OpdEncounter> page = repository.searchEncounters(doctorId, status, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public PagedResponse<OpdEncounterDto> getPatientEncounters(Long patientId, Pageable pageable) {
        Page<OpdEncounter> page = repository.findByPatientIdOrderByEncounterDateDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public OpdEncounterDto getById(Long id) {
        OpdEncounter e = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OPD Encounter", "id", id));
        return toDto(e);
    }

    @Transactional
    public OpdEncounterDto createEncounter(CreateOpdEncounterRequest req, String createdBy) {
        Patient patient = entityManager.getReference(Patient.class, req.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, req.getDoctorId());
        Department department = entityManager.getReference(Department.class, req.getDepartmentId());
        Appointment appointment = req.getAppointmentId() != null ? entityManager.getReference(Appointment.class, req.getAppointmentId()) : null;

        String encNo = sequenceService.getNextNumber("ENC_SEQ");

        OpdEncounter encounter = OpdEncounter.builder()
                .encounterNo(encNo)
                .patient(patient)
                .doctor(doctor)
                .department(department)
                .appointment(appointment)
                .triagePriority(req.getTriagePriority() != null ? req.getTriagePriority() : OpdEncounter.TriagePriority.ROUTINE)
                .chiefComplaint(req.getChiefComplaint())
                .historyOfPresentIllness(req.getHistoryOfPresentIllness())
                .physicalExamination(req.getPhysicalExamination())
                .status(OpdEncounter.EncounterStatus.WAITING)
                .build();
        encounter.setCreatedBy(createdBy);

        return toDto(repository.save(encounter));
    }

    @Transactional
    public OpdEncounterDto updateConsultationNotes(Long id, String physicalExam, String hpi, OpdEncounter.EncounterStatus status) {
        OpdEncounter encounter = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OPD Encounter", "id", id));

        if (physicalExam != null) encounter.setPhysicalExamination(physicalExam);
        if (hpi != null) encounter.setHistoryOfPresentIllness(hpi);
        if (status != null) encounter.setStatus(status);

        return toDto(repository.save(encounter));
    }

    public OpdEncounterDto toDto(OpdEncounter e) {
        return OpdEncounterDto.builder()
                .id(e.getId())
                .encounterNo(e.getEncounterNo())
                .patientId(e.getPatient().getId())
                .patientName(e.getPatient().getFirstName() + " " + e.getPatient().getLastName())
                .patientMrn(e.getPatient().getMrn())
                .patientPhone(e.getPatient().getPhone())
                .doctorId(e.getDoctor().getId())
                .doctorName("Dr. " + e.getDoctor().getStaff().getFirstName() + " " + e.getDoctor().getStaff().getLastName())
                .departmentId(e.getDepartment().getId())
                .departmentName(e.getDepartment().getName())
                .appointmentId(e.getAppointment() != null ? e.getAppointment().getId() : null)
                .encounterDate(e.getEncounterDate())
                .triagePriority(e.getTriagePriority())
                .chiefComplaint(e.getChiefComplaint())
                .historyOfPresentIllness(e.getHistoryOfPresentIllness())
                .physicalExamination(e.getPhysicalExamination())
                .status(e.getStatus())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/opd")
@RequiredArgsConstructor
@Tag(name = "Outpatient Department (OPD)", description = "OPD triage queue, consultations, and intake workflows")
public class OpdEncounterController {
    private final OpdService opdService;

    @GetMapping
    @Operation(summary = "Get OPD consultation queue and encounters")
    public ResponseEntity<ApiResponse<PagedResponse<OpdEncounterDto>>> getEncounters(
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) OpdEncounter.EncounterStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(opdService.getEncounters(doctorId, status, pageable)));
    }

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get patient outpatient encounter history")
    public ResponseEntity<ApiResponse<PagedResponse<OpdEncounterDto>>> getPatientEncounters(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(opdService.getPatientEncounters(patientId, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get encounter details by ID")
    public ResponseEntity<ApiResponse<OpdEncounterDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(opdService.getById(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('RECEPTIONIST') or hasRole('NURSE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Create OPD encounter (Walk-in or from checked-in appointment)")
    public ResponseEntity<ApiResponse<OpdEncounterDto>> createEncounter(@Valid @RequestBody CreateOpdEncounterRequest request) {
        OpdEncounterDto created = opdService.createEncounter(request, "SYSTEM");
        return new ResponseEntity<>(ApiResponse.ok(created, "OPD encounter created"), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Update encounter consultation notes and status")
    public ResponseEntity<ApiResponse<OpdEncounterDto>> updateConsultation(
            @PathVariable Long id,
            @RequestParam(required = false) String physicalExam,
            @RequestParam(required = false) String hpi,
            @RequestParam(required = false) OpdEncounter.EncounterStatus status) {
        return ResponseEntity.ok(ApiResponse.ok(opdService.updateConsultationNotes(id, physicalExam, hpi, status), "Consultation updated"));
    }
}
