package com.hospital.clinical;

import com.hospital.common.ApiResponse;
import com.hospital.common.PagedResponse;
import com.hospital.common.ResourceNotFoundException;
import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Repository
interface ClinicalNoteRepository extends JpaRepository<ClinicalNote, Long> {
    Page<ClinicalNote> findByPatientIdOrderByCreatedAtDesc(Long patientId, Pageable pageable);
}

@Repository
interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    List<Diagnosis> findByPatientIdOrderByDiagnosedAtDesc(Long patientId);
}

@Repository
interface PatientAllergyRepository extends JpaRepository<PatientAllergy, Long> {
    List<PatientAllergy> findByPatientIdAndStatus(Long patientId, PatientAllergy.AllergyStatus status);
}

@Repository
interface PatientVitalRepository extends JpaRepository<PatientVital, Long> {
    Page<PatientVital> findByPatientIdOrderByRecordedAtDesc(Long patientId, Pageable pageable);
    List<PatientVital> findTop10ByPatientIdOrderByRecordedAtDesc(Long patientId);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ClinicalNoteDto {
    private Long id;
    private Long patientId;
    private Long encounterId;
    private Long admissionId;
    private Long authorId;
    private String authorName;
    private ClinicalNote.NoteType noteType;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Content is required")
    private String content;
    private ClinicalNote.NoteStatus status;
    private Instant finalizedAt;
    private Long amendedFromId;
    private String amendmentReason;
    private Instant createdAt;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DiagnosisDto {
    private Long id;
    private Long patientId;
    private Long encounterId;
    private Long admissionId;
    @NotBlank(message = "ICD-10 code is required")
    private String icd10Code;
    @NotBlank(message = "Diagnosis text is required")
    private String diagnosisText;
    private Diagnosis.DiagnosisType type;
    private Diagnosis.DiagnosisStatus status;
    private Long doctorId;
    private String doctorName;
    private Instant diagnosedAt;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AllergyDto {
    private Long id;
    private Long patientId;
    @NotBlank(message = "Allergen is required")
    private String allergen;
    private PatientAllergy.AllergyType allergyType;
    @NotBlank(message = "Reaction description is required")
    private String reaction;
    private PatientAllergy.AllergySeverity severity;
    private LocalDate onsetDate;
    private PatientAllergy.AllergyStatus status;
    private String recordedBy;
    private Instant recordedAt;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class VitalDto {
    private Long id;
    private Long patientId;
    private Long encounterId;
    private Long admissionId;
    private BigDecimal tempCelsius;
    private Integer bpSystolic;
    private Integer bpDiastolic;
    private Integer heartRate;
    private Integer respRate;
    private BigDecimal spo2;
    private BigDecimal bloodGlucose;
    private Integer painScore;
    private BigDecimal weightKg;
    private BigDecimal heightCm;
    private BigDecimal bmi;
    private String recordedBy;
    private Instant recordedAt;
}

@Service
@RequiredArgsConstructor
class ClinicalRecordService {
    private final ClinicalNoteRepository noteRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final PatientAllergyRepository allergyRepository;
    private final PatientVitalRepository vitalRepository;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<ClinicalNoteDto> getPatientNotes(Long patientId, Pageable pageable) {
        Page<ClinicalNote> page = noteRepository.findByPatientIdOrderByCreatedAtDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toNoteDto));
    }

    @Transactional
    public ClinicalNoteDto createNote(ClinicalNoteDto dto, String authorUsername) {
        Patient patient = entityManager.getReference(Patient.class, dto.getPatientId());
        Staff author = entityManager.getReference(Staff.class, dto.getAuthorId());
        OpdEncounter encounter = dto.getEncounterId() != null ? entityManager.getReference(OpdEncounter.class, dto.getEncounterId()) : null;
        IpdAdmission admission = dto.getAdmissionId() != null ? entityManager.getReference(IpdAdmission.class, dto.getAdmissionId()) : null;

        ClinicalNote note = ClinicalNote.builder()
                .patient(patient)
                .encounter(encounter)
                .admission(admission)
                .author(author)
                .noteType(dto.getNoteType() != null ? dto.getNoteType() : ClinicalNote.NoteType.PROGRESS_NOTE)
                .title(dto.getTitle())
                .content(dto.getContent())
                .status(dto.getStatus() != null ? dto.getStatus() : ClinicalNote.NoteStatus.DRAFT)
                .finalizedAt(dto.getStatus() == ClinicalNote.NoteStatus.FINALIZED ? Instant.now() : null)
                .build();
        note.setCreatedBy(authorUsername);

        return toNoteDto(noteRepository.save(note));
    }

    @Transactional(readOnly = true)
    public List<DiagnosisDto> getPatientDiagnoses(Long patientId) {
        return diagnosisRepository.findByPatientIdOrderByDiagnosedAtDesc(patientId).stream().map(this::toDiagDto).toList();
    }

    @Transactional
    public DiagnosisDto addDiagnosis(DiagnosisDto dto) {
        Patient patient = entityManager.getReference(Patient.class, dto.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, dto.getDoctorId());

        Diagnosis diagnosis = Diagnosis.builder()
                .patient(patient)
                .icd10Code(dto.getIcd10Code())
                .diagnosisText(dto.getDiagnosisText())
                .type(dto.getType() != null ? dto.getType() : Diagnosis.DiagnosisType.PROVISIONAL)
                .status(Diagnosis.DiagnosisStatus.ACTIVE)
                .diagnosedBy(doctor)
                .build();

        return toDiagDto(diagnosisRepository.save(diagnosis));
    }

    @Transactional(readOnly = true)
    public List<AllergyDto> getPatientAllergies(Long patientId) {
        return allergyRepository.findByPatientIdAndStatus(patientId, PatientAllergy.AllergyStatus.ACTIVE)
                .stream().map(this::toAllergyDto).toList();
    }

    @Transactional
    public AllergyDto recordAllergy(AllergyDto dto, String recordedBy) {
        Patient patient = entityManager.getReference(Patient.class, dto.getPatientId());

        PatientAllergy allergy = PatientAllergy.builder()
                .patient(patient)
                .allergen(dto.getAllergen())
                .allergyType(dto.getAllergyType() != null ? dto.getAllergyType() : PatientAllergy.AllergyType.DRUG)
                .reaction(dto.getReaction())
                .severity(dto.getSeverity() != null ? dto.getSeverity() : PatientAllergy.AllergySeverity.MODERATE)
                .onsetDate(dto.getOnsetDate())
                .status(PatientAllergy.AllergyStatus.ACTIVE)
                .recordedBy(recordedBy)
                .build();

        return toAllergyDto(allergyRepository.save(allergy));
    }

    @Transactional(readOnly = true)
    public PagedResponse<VitalDto> getPatientVitals(Long patientId, Pageable pageable) {
        Page<PatientVital> page = vitalRepository.findByPatientIdOrderByRecordedAtDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toVitalDto));
    }

    @Transactional
    public VitalDto recordVitals(VitalDto dto, String recordedBy) {
        Patient patient = entityManager.getReference(Patient.class, dto.getPatientId());

        BigDecimal bmi = null;
        if (dto.getWeightKg() != null && dto.getHeightCm() != null && dto.getHeightCm().doubleValue() > 0) {
            double heightM = dto.getHeightCm().doubleValue() / 100.0;
            double calculatedBmi = dto.getWeightKg().doubleValue() / (heightM * heightM);
            bmi = BigDecimal.valueOf(calculatedBmi).setScale(1, java.math.RoundingMode.HALF_UP);
        }

        PatientVital vital = PatientVital.builder()
                .patient(patient)
                .tempCelsius(dto.getTempCelsius())
                .bpSystolic(dto.getBpSystolic())
                .bpDiastolic(dto.getBpDiastolic())
                .heartRate(dto.getHeartRate())
                .respRate(dto.getRespRate())
                .spo2(dto.getSpo2())
                .bloodGlucose(dto.getBloodGlucose())
                .painScore(dto.getPainScore())
                .weightKg(dto.getWeightKg())
                .heightCm(dto.getHeightCm())
                .bmi(bmi)
                .recordedBy(recordedBy)
                .build();

        return toVitalDto(vitalRepository.save(vital));
    }

    private ClinicalNoteDto toNoteDto(ClinicalNote n) {
        return ClinicalNoteDto.builder()
                .id(n.getId())
                .patientId(n.getPatient().getId())
                .encounterId(n.getEncounter() != null ? n.getEncounter().getId() : null)
                .admissionId(n.getAdmission() != null ? n.getAdmission().getId() : null)
                .authorId(n.getAuthor().getId())
                .authorName(n.getAuthor().getFirstName() + " " + n.getAuthor().getLastName())
                .noteType(n.getNoteType())
                .title(n.getTitle())
                .content(n.getContent())
                .status(n.getStatus())
                .finalizedAt(n.getFinalizedAt())
                .amendedFromId(n.getAmendedFrom() != null ? n.getAmendedFrom().getId() : null)
                .amendmentReason(n.getAmendmentReason())
                .createdAt(n.getCreatedAt())
                .build();
    }

    private DiagnosisDto toDiagDto(Diagnosis d) {
        return DiagnosisDto.builder()
                .id(d.getId())
                .patientId(d.getPatient().getId())
                .icd10Code(d.getIcd10Code())
                .diagnosisText(d.getDiagnosisText())
                .type(d.getType())
                .status(d.getStatus())
                .doctorId(d.getDiagnosedBy().getId())
                .doctorName("Dr. " + d.getDiagnosedBy().getStaff().getFirstName() + " " + d.getDiagnosedBy().getStaff().getLastName())
                .diagnosedAt(d.getDiagnosedAt())
                .build();
    }

    private AllergyDto toAllergyDto(PatientAllergy a) {
        return AllergyDto.builder()
                .id(a.getId())
                .patientId(a.getPatient().getId())
                .allergen(a.getAllergen())
                .allergyType(a.getAllergyType())
                .reaction(a.getReaction())
                .severity(a.getSeverity())
                .onsetDate(a.getOnsetDate())
                .status(a.getStatus())
                .recordedBy(a.getRecordedBy())
                .recordedAt(a.getRecordedAt())
                .build();
    }

    private VitalDto toVitalDto(PatientVital v) {
        return VitalDto.builder()
                .id(v.getId())
                .patientId(v.getPatient().getId())
                .tempCelsius(v.getTempCelsius())
                .bpSystolic(v.getBpSystolic())
                .bpDiastolic(v.getBpDiastolic())
                .heartRate(v.getHeartRate())
                .respRate(v.getRespRate())
                .spo2(v.getSpo2())
                .bloodGlucose(v.getBloodGlucose())
                .painScore(v.getPainScore())
                .weightKg(v.getWeightKg())
                .heightCm(v.getHeightCm())
                .bmi(v.getBmi())
                .recordedBy(v.getRecordedBy())
                .recordedAt(v.getRecordedAt())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/clinical")
@RequiredArgsConstructor
@Tag(name = "Clinical Records & EMR", description = "Electronic Medical Records, clinical notes, vitals, and diagnoses")
public class ClinicalRecordController {
    private final ClinicalRecordService service;

    @GetMapping("/patients/{patientId}/notes")
    @Operation(summary = "Get clinical notes for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<ClinicalNoteDto>>> getNotes(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPatientNotes(patientId, pageable)));
    }

    @PostMapping("/notes")
    @PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Author a new clinical note (Draft or Finalized)")
    public ResponseEntity<ApiResponse<ClinicalNoteDto>> createNote(@Valid @RequestBody ClinicalNoteDto dto) {
        return new ResponseEntity<>(ApiResponse.ok(service.createNote(dto, "SYSTEM"), "Clinical note saved"), HttpStatus.CREATED);
    }

    @GetMapping("/patients/{patientId}/diagnoses")
    @Operation(summary = "Get active and resolved diagnoses for a patient")
    public ResponseEntity<ApiResponse<List<DiagnosisDto>>> getDiagnoses(@PathVariable Long patientId) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPatientDiagnoses(patientId)));
    }

    @PostMapping("/diagnoses")
    @PreAuthorize("hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Record patient diagnosis (ICD-10)")
    public ResponseEntity<ApiResponse<DiagnosisDto>> addDiagnosis(@Valid @RequestBody DiagnosisDto dto) {
        return new ResponseEntity<>(ApiResponse.ok(service.addDiagnosis(dto), "Diagnosis recorded"), HttpStatus.CREATED);
    }

    @GetMapping("/patients/{patientId}/allergies")
    @Operation(summary = "Get active allergy alerts for a patient")
    public ResponseEntity<ApiResponse<List<AllergyDto>>> getAllergies(@PathVariable Long patientId) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPatientAllergies(patientId)));
    }

    @PostMapping("/allergies")
    @PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Record patient drug/food/environmental allergy")
    public ResponseEntity<ApiResponse<AllergyDto>> recordAllergy(@Valid @RequestBody AllergyDto dto) {
        return new ResponseEntity<>(ApiResponse.ok(service.recordAllergy(dto, "SYSTEM"), "Allergy recorded"), HttpStatus.CREATED);
    }

    @GetMapping("/patients/{patientId}/vitals")
    @Operation(summary = "Get physiological vitals time-series history for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<VitalDto>>> getVitals(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPatientVitals(patientId, pageable)));
    }

    @PostMapping("/vitals")
    @PreAuthorize("hasRole('NURSE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Record vital signs (Temperature, Blood Pressure, Heart Rate, SpO2, BMI)")
    public ResponseEntity<ApiResponse<VitalDto>> recordVitals(@Valid @RequestBody VitalDto dto) {
        return new ResponseEntity<>(ApiResponse.ok(service.recordVitals(dto, "SYSTEM"), "Vitals recorded successfully"), HttpStatus.CREATED);
    }
}
