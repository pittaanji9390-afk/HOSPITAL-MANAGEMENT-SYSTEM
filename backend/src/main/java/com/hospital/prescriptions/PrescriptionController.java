package com.hospital.prescriptions;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
import com.hospital.patients.Patient;
import com.hospital.pharmacy.Medicine;
import com.hospital.staff.Doctor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
import java.util.stream.Collectors;

@Entity
@Table(name = "prescription_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrescriptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;

    @Column(nullable = false, length = 50)
    private String dosage; // e.g. "1 Tablet"

    @Column(nullable = false, length = 30)
    private String route;  // ORAL, IV, IM, TOPICAL

    @Column(nullable = false, length = 30)
    private String frequency; // ONCE_DAILY, TWICE_DAILY, THRICE_DAILY, PRN, STAT

    @Column(name = "duration_days", nullable = false)
    private int durationDays;

    @Column(name = "quantity_prescribed", nullable = false)
    private int quantityPrescribed;

    @Column(name = "quantity_dispensed", nullable = false)
    @Builder.Default
    private int quantityDispensed = 0;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private ItemStatus status = ItemStatus.PENDING;

    public enum ItemStatus {
        PENDING, PARTIALLY_DISPENSED, DISPENSED, CANCELLED
    }
}

@Repository
interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    Optional<Prescription> findByPrescriptionNo(String prescriptionNo);
    Page<Prescription> findByPatientIdOrderByIssuedAtDesc(Long patientId, Pageable pageable);

    @Query("SELECT p FROM Prescription p WHERE (:status IS NULL OR p.status = :status)")
    Page<Prescription> searchPrescriptions(@Param("status") Prescription.PrescriptionStatus status, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PrescriptionDto {
    private Long id;
    private String prescriptionNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private Long doctorId;
    private String doctorName;
    private Long encounterId;
    private Long admissionId;
    private Prescription.PrescriptionStatus status;
    private String clinicalNotes;
    private Instant issuedAt;
    private List<PrescriptionItemDto> items;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PrescriptionItemDto {
    private Long id;
    private Long medicineId;
    private String medicineName;
    private String genericName;
    @NotBlank(message = "Dosage is required")
    private String dosage;
    @NotBlank(message = "Route is required")
    private String route;
    @NotBlank(message = "Frequency is required")
    private String frequency;
    private int durationDays;
    private int quantityPrescribed;
    private int quantityDispensed;
    private String instructions;
    private PrescriptionItem.ItemStatus status;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreatePrescriptionRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    private Long encounterId;
    private Long admissionId;
    private String clinicalNotes;
    @NotEmpty(message = "Prescription must contain at least one medicine item")
    private List<PrescriptionItemDto> items;
}

@Service
@RequiredArgsConstructor
class PrescriptionService {
    private final PrescriptionRepository repository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<PrescriptionDto> getPrescriptions(Prescription.PrescriptionStatus status, Pageable pageable) {
        Page<Prescription> page = repository.searchPrescriptions(status, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public PagedResponse<PrescriptionDto> getPatientPrescriptions(Long patientId, Pageable pageable) {
        Page<Prescription> page = repository.findByPatientIdOrderByIssuedAtDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public PrescriptionDto getById(Long id) {
        Prescription p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription", "id", id));
        return toDto(p);
    }

    @Transactional
    public PrescriptionDto createPrescription(CreatePrescriptionRequest req, String createdBy) {
        Patient patient = entityManager.getReference(Patient.class, req.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, req.getDoctorId());
        OpdEncounter encounter = req.getEncounterId() != null ? entityManager.getReference(OpdEncounter.class, req.getEncounterId()) : null;
        IpdAdmission admission = req.getAdmissionId() != null ? entityManager.getReference(IpdAdmission.class, req.getAdmissionId()) : null;

        String rxNo = sequenceService.getNextNumber("RX_SEQ");

        Prescription prescription = Prescription.builder()
                .prescriptionNo(rxNo)
                .patient(patient)
                .doctor(doctor)
                .encounter(encounter)
                .admission(admission)
                .status(Prescription.PrescriptionStatus.ISSUED)
                .clinicalNotes(req.getClinicalNotes())
                .issuedAt(Instant.now())
                .build();
        prescription.setCreatedBy(createdBy);

        for (PrescriptionItemDto itemDto : req.getItems()) {
            Medicine med = entityManager.getReference(Medicine.class, itemDto.getMedicineId());
            PrescriptionItem item = PrescriptionItem.builder()
                    .prescription(prescription)
                    .medicine(med)
                    .dosage(itemDto.getDosage())
                    .route(itemDto.getRoute())
                    .frequency(itemDto.getFrequency())
                    .durationDays(itemDto.getDurationDays())
                    .quantityPrescribed(itemDto.getQuantityPrescribed())
                    .instructions(itemDto.getInstructions())
                    .status(PrescriptionItem.ItemStatus.PENDING)
                    .build();
            prescription.getItems().add(item);
        }

        return toDto(repository.save(prescription));
    }

    public PrescriptionDto toDto(Prescription p) {
        List<PrescriptionItemDto> itemDtos = p.getItems().stream().map(i -> PrescriptionItemDto.builder()
                .id(i.getId())
                .medicineId(i.getMedicine().getId())
                .medicineName(i.getMedicine().getBrandName())
                .genericName(i.getMedicine().getGenericName())
                .dosage(i.getDosage())
                .route(i.getRoute())
                .frequency(i.getFrequency())
                .durationDays(i.getDurationDays())
                .quantityPrescribed(i.getQuantityPrescribed())
                .quantityDispensed(i.getQuantityDispensed())
                .instructions(i.getInstructions())
                .status(i.getStatus())
                .build()).collect(Collectors.toList());

        return PrescriptionDto.builder()
                .id(p.getId())
                .prescriptionNo(p.getPrescriptionNo())
                .patientId(p.getPatient().getId())
                .patientName(p.getPatient().getFirstName() + " " + p.getPatient().getLastName())
                .patientMrn(p.getPatient().getMrn())
                .doctorId(p.getDoctor().getId())
                .doctorName("Dr. " + p.getDoctor().getStaff().getFirstName() + " " + p.getDoctor().getStaff().getLastName())
                .encounterId(p.getEncounter() != null ? p.getEncounter().getId() : null)
                .admissionId(p.getAdmission() != null ? p.getAdmission().getId() : null)
                .status(p.getStatus())
                .clinicalNotes(p.getClinicalNotes())
                .issuedAt(p.getIssuedAt())
                .items(itemDtos)
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/prescriptions")
@RequiredArgsConstructor
@Tag(name = "E-Prescriptions", description = "Electronic prescriptions authoring, dosages, and fulfillment tracking")
public class PrescriptionController {
    private final PrescriptionService service;

    @GetMapping
    @Operation(summary = "Search all prescriptions with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<PrescriptionDto>>> getPrescriptions(
            @RequestParam(required = false) Prescription.PrescriptionStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPrescriptions(status, pageable)));
    }

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get all prescriptions for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<PrescriptionDto>>> getPatientPrescriptions(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPatientPrescriptions(patientId, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get prescription details and medication items")
    public ResponseEntity<ApiResponse<PrescriptionDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(service.getById(id)));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PERM_PRESCRIPTION_WRITE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Author and issue a new electronic prescription")
    public ResponseEntity<ApiResponse<PrescriptionDto>> createPrescription(@Valid @RequestBody CreatePrescriptionRequest request) {
        PrescriptionDto created = service.createPrescription(request, "SYSTEM");
        return new ResponseEntity<>(ApiResponse.ok(created, "Prescription issued successfully"), HttpStatus.CREATED);
    }
}
