package com.hospital.radiology;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
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

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "radiology_examinations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadiologyExam extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Modality modality;

    @Column(name = "body_part", nullable = false, length = 100)
    private String bodyPart;

    @Column(nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "preparation_instructions", columnDefinition = "TEXT")
    private String preparationInstructions;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    public enum Modality {
        X_RAY, CT_SCAN, MRI, ULTRASOUND, MAMMOGRAPHY, DEXA, FLUOROSCOPY
    }
}

@Entity
@Table(name = "radiology_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class RadiologyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_no", nullable = false, unique = true, length = 30)
    private String orderNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordering_doctor_id", nullable = false)
    private Doctor orderingDoctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examination_id", nullable = false)
    private RadiologyExam examination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encounter_id")
    private OpdEncounter encounter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id")
    private IpdAdmission admission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private Priority priority = Priority.ROUTINE;

    @Column(name = "clinical_history", columnDefinition = "TEXT")
    private String clinicalHistory;

    @Column(name = "scheduled_at")
    private Instant scheduledAt;

    @Column(name = "completed_at")
    private Instant completedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "radiologist_id")
    private Doctor radiologist;

    @Column(columnDefinition = "TEXT")
    private String findings;

    @Column(columnDefinition = "TEXT")
    private String impression;

    @Column(name = "pacs_image_url")
    private String pacsImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private OrderStatus status = OrderStatus.ORDERED;

    @Column(name = "verified_at")
    private Instant verifiedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private Instant createdAt = Instant.now();

    public enum Priority {
        ROUTINE, URGENT, STAT
    }

    public enum OrderStatus {
        ORDERED, SCHEDULED, PERFORMED, REPORTED, VERIFIED, CANCELLED
    }
}

@Repository
interface RadiologyExamRepository extends JpaRepository<RadiologyExam, Long> {
    List<RadiologyExam> findByActiveTrue();
}

@Repository
interface RadiologyOrderRepository extends JpaRepository<RadiologyOrder, Long> {
    Optional<RadiologyOrder> findByOrderNo(String orderNo);
    Page<RadiologyOrder> findByPatientIdOrderByCreatedAtDesc(Long patientId, Pageable pageable);

    @Query("SELECT o FROM RadiologyOrder o WHERE (:status IS NULL OR o.status = :status)")
    Page<RadiologyOrder> searchOrders(@Param("status") RadiologyOrder.OrderStatus status, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class RadiologyOrderDto {
    private Long id;
    private String orderNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private Long doctorId;
    private String doctorName;
    private Long examinationId;
    private String examinationName;
    private RadiologyExam.Modality modality;
    private String bodyPart;
    private RadiologyOrder.Priority priority;
    private String clinicalHistory;
    private String findings;
    private String impression;
    private String pacsImageUrl;
    private RadiologyOrder.OrderStatus status;
    private Instant createdAt;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateRadiologyOrderRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Ordering doctor ID is required")
    private Long doctorId;
    @NotNull(message = "Radiology examination ID is required")
    private Long examinationId;
    private Long encounterId;
    private Long admissionId;
    private RadiologyOrder.Priority priority;
    private String clinicalHistory;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SubmitRadiologyReportRequest {
    @NotBlank(message = "Findings are required")
    private String findings;
    @NotBlank(message = "Impression is required")
    private String impression;
    private String pacsImageUrl;
    @NotNull(message = "Radiologist doctor ID is required")
    private Long radiologistId;
}

@Service
@RequiredArgsConstructor
class RadiologyService {
    private final RadiologyExamRepository examRepository;
    private final RadiologyOrderRepository orderRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<RadiologyExam> getCatalog() {
        return examRepository.findByActiveTrue();
    }

    @Transactional(readOnly = true)
    public PagedResponse<RadiologyOrderDto> getOrders(RadiologyOrder.OrderStatus status, Pageable pageable) {
        Page<RadiologyOrder> page = orderRepository.searchOrders(status, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public PagedResponse<RadiologyOrderDto> getPatientOrders(Long patientId, Pageable pageable) {
        Page<RadiologyOrder> page = orderRepository.findByPatientIdOrderByCreatedAtDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional
    public RadiologyOrderDto createOrder(CreateRadiologyOrderRequest req, String actor) {
        Patient patient = entityManager.getReference(Patient.class, req.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, req.getDoctorId());
        RadiologyExam exam = examRepository.findById(req.getExaminationId())
                .orElseThrow(() -> new ResourceNotFoundException("Radiology Exam", "id", req.getExaminationId()));

        OpdEncounter encounter = req.getEncounterId() != null ? entityManager.getReference(OpdEncounter.class, req.getEncounterId()) : null;
        IpdAdmission admission = req.getAdmissionId() != null ? entityManager.getReference(IpdAdmission.class, req.getAdmissionId()) : null;

        String orderNo = sequenceService.getNextNumber("RAD_SEQ");

        RadiologyOrder order = RadiologyOrder.builder()
                .orderNo(orderNo)
                .patient(patient)
                .orderingDoctor(doctor)
                .examination(exam)
                .encounter(encounter)
                .admission(admission)
                .priority(req.getPriority() != null ? req.getPriority() : RadiologyOrder.Priority.ROUTINE)
                .clinicalHistory(req.getClinicalHistory())
                .status(RadiologyOrder.OrderStatus.ORDERED)
                .build();

        return toDto(orderRepository.save(order));
    }

    @Transactional
    public RadiologyOrderDto submitReport(Long orderId, SubmitRadiologyReportRequest req) {
        RadiologyOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Radiology Order", "id", orderId));

        Doctor radiologist = entityManager.getReference(Doctor.class, req.getRadiologistId());

        order.setRadiologist(radiologist);
        order.setFindings(req.getFindings());
        order.setImpression(req.getImpression());
        order.setPacsImageUrl(req.getPacsImageUrl());
        order.setStatus(RadiologyOrder.OrderStatus.REPORTED);
        order.setCompletedAt(Instant.now());

        return toDto(orderRepository.save(order));
    }

    public RadiologyOrderDto toDto(RadiologyOrder o) {
        return RadiologyOrderDto.builder()
                .id(o.getId())
                .orderNo(o.getOrderNo())
                .patientId(o.getPatient().getId())
                .patientName(o.getPatient().getFirstName() + " " + o.getPatient().getLastName())
                .patientMrn(o.getPatient().getMrn())
                .doctorId(o.getOrderingDoctor().getId())
                .doctorName("Dr. " + o.getOrderingDoctor().getStaff().getFirstName() + " " + o.getOrderingDoctor().getStaff().getLastName())
                .examinationId(o.getExamination().getId())
                .examinationName(o.getExamination().getName())
                .modality(o.getExamination().getModality())
                .bodyPart(o.getExamination().getBodyPart())
                .priority(o.getPriority())
                .clinicalHistory(o.getClinicalHistory())
                .findings(o.getFindings())
                .impression(o.getImpression())
                .pacsImageUrl(o.getPacsImageUrl())
                .status(o.getStatus())
                .createdAt(o.getCreatedAt())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/radiology")
@RequiredArgsConstructor
@Tag(name = "Radiology & Imaging", description = "Imaging exams (X-Ray, CT, MRI, Ultrasound), PACS links, and radiologist reports")
public class RadiologyController {
    private final RadiologyService service;

    @GetMapping("/exams")
    @Operation(summary = "Get radiology exam modalities and catalog")
    public ResponseEntity<ApiResponse<List<RadiologyExam>>> getCatalog() {
        return ResponseEntity.ok(ApiResponse.ok(service.getCatalog()));
    }

    @GetMapping("/orders")
    @Operation(summary = "List radiology imaging orders with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<RadiologyOrderDto>>> getOrders(
            @RequestParam(required = false) RadiologyOrder.OrderStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getOrders(status, pageable)));
    }

    @GetMapping("/orders/patient/{patientId}")
    @Operation(summary = "Get all radiology orders for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<RadiologyOrderDto>>> getPatientOrders(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getPatientOrders(patientId, pageable)));
    }

    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('PERM_RADIOLOGY_ORDER_CREATE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Create an imaging and radiology diagnostic order")
    public ResponseEntity<ApiResponse<RadiologyOrderDto>> createOrder(@Valid @RequestBody CreateRadiologyOrderRequest request) {
        RadiologyOrderDto order = service.createOrder(request, "DOCTOR");
        return new ResponseEntity<>(ApiResponse.ok(order, "Radiology order created"), HttpStatus.CREATED);
    }

    @PostMapping("/orders/{id}/report")
    @PreAuthorize("hasAuthority('PERM_RADIOLOGY_REPORT_WRITE') or hasRole('DOCTOR') or hasRole('RADIOLOGY_TECHNICIAN') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Submit diagnostic radiology findings and impression")
    public ResponseEntity<ApiResponse<RadiologyOrderDto>> submitReport(
            @PathVariable Long id,
            @Valid @RequestBody SubmitRadiologyReportRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.submitReport(id, request), "Radiology report submitted"));
    }
}
