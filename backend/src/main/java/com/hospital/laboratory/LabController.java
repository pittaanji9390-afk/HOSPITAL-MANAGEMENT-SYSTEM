package com.hospital.laboratory;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import com.hospital.staff.Staff;
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

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "lab_tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String category; // HEMATOLOGY, BIOCHEMISTRY, MICROBIOLOGY, PATHOLOGY

    @Column(name = "specimen_type", nullable = false, length = 50)
    private String specimenType; // BLOOD, URINE, SERUM, CSF

    @Column(nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "normal_range_min", precision = 10, scale = 3)
    private BigDecimal normalRangeMin;

    @Column(name = "normal_range_max", precision = 10, scale = 3)
    private BigDecimal normalRangeMax;

    @Column(length = 30)
    private String unit;

    @Column(name = "turnaround_hours", nullable = false)
    @Builder.Default
    private int turnaroundHours = 24;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}

@Entity
@Table(name = "lab_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class LabOrder {

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
    @JoinColumn(name = "encounter_id")
    private OpdEncounter encounter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id")
    private IpdAdmission admission;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private Priority priority = Priority.ROUTINE;

    @Column(name = "clinical_indication", columnDefinition = "TEXT")
    private String clinicalIndication;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private OrderStatus status = OrderStatus.ORDERED;

    @Column(name = "ordered_at", nullable = false)
    @Builder.Default
    private Instant orderedAt = Instant.now();

    @Builder.Default
    @OneToMany(mappedBy = "labOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LabOrderItem> items = new ArrayList<>();

    public enum Priority {
        ROUTINE, URGENT, STAT
    }

    public enum OrderStatus {
        ORDERED, SAMPLE_COLLECTED, IN_PROCESS, COMPLETED, CANCELLED
    }
}

@Entity
@Table(name = "lab_order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class LabOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_order_id", nullable = false)
    private LabOrder labOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private LabTest test;

    @Column(name = "sample_barcode", length = 50)
    private String sampleBarcode;

    @Column(name = "sample_collected_at")
    private Instant sampleCollectedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sample_collected_by")
    private Staff sampleCollectedBy;

    @Column(name = "result_value")
    private String resultValue;

    @Column(name = "result_numeric", precision = 10, scale = 3)
    private BigDecimal resultNumeric;

    @Column(name = "normal_range_snapshot", length = 100)
    private String normalRangeSnapshot;

    @Column(name = "is_abnormal", nullable = false)
    @Builder.Default
    private boolean abnormal = false;

    @Column(name = "is_critical", nullable = false)
    @Builder.Default
    private boolean critical = false;

    @Column(name = "technician_notes", columnDefinition = "TEXT")
    private String technicianNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id")
    private Staff technician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verified_by")
    private Staff verifiedBy;

    @Column(name = "verified_at")
    private Instant verifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private ItemStatus status = ItemStatus.PENDING;

    public enum ItemStatus {
        PENDING, COLLECTED, PROCESSING, RESULTED, VERIFIED, CANCELLED
    }
}

@Repository
interface LabTestRepository extends JpaRepository<LabTest, Long> {
    List<LabTest> findByActiveTrue();
}

@Repository
interface LabOrderRepository extends JpaRepository<LabOrder, Long> {
    Optional<LabOrder> findByOrderNo(String orderNo);
    Page<LabOrder> findByPatientIdOrderByOrderedAtDesc(Long patientId, Pageable pageable);

    @Query("SELECT o FROM LabOrder o WHERE (:status IS NULL OR o.status = :status)")
    Page<LabOrder> searchOrders(@Param("status") LabOrder.OrderStatus status, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class LabOrderDto {
    private Long id;
    private String orderNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private Long doctorId;
    private String doctorName;
    private LabOrder.Priority priority;
    private String clinicalIndication;
    private LabOrder.OrderStatus status;
    private Instant orderedAt;
    private List<LabOrderItemDto> items;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class LabOrderItemDto {
    private Long id;
    private Long testId;
    private String testCode;
    private String testName;
    private String category;
    private String specimenType;
    private String sampleBarcode;
    private String resultValue;
    private BigDecimal resultNumeric;
    private String normalRangeSnapshot;
    private boolean abnormal;
    private boolean critical;
    private String technicianNotes;
    private String verifiedByName;
    private Instant verifiedAt;
    private LabOrderItem.ItemStatus status;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateLabOrderRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Ordering doctor ID is required")
    private Long doctorId;
    private Long encounterId;
    private Long admissionId;
    private LabOrder.Priority priority;
    private String clinicalIndication;
    @NotEmpty(message = "Select at least one lab test to order")
    private List<Long> testIds;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class EnterLabResultRequest {
    @NotNull(message = "Result value is required")
    private String resultValue;
    private BigDecimal resultNumeric;
    private boolean abnormal;
    private boolean critical;
    private String notes;
    @NotNull(message = "Technician staff ID is required")
    private Long technicianStaffId;
}

@Service
@RequiredArgsConstructor
class LabService {
    private final LabTestRepository testRepository;
    private final LabOrderRepository orderRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<LabTest> getCatalog() {
        return testRepository.findByActiveTrue();
    }

    @Transactional(readOnly = true)
    public PagedResponse<LabOrderDto> getOrders(LabOrder.OrderStatus status, Pageable pageable) {
        Page<LabOrder> page = orderRepository.searchOrders(status, pageable);
        return PagedResponse.from(page.map(this::toOrderDto));
    }

    @Transactional(readOnly = true)
    public PagedResponse<LabOrderDto> getPatientOrders(Long patientId, Pageable pageable) {
        Page<LabOrder> page = orderRepository.findByPatientIdOrderByOrderedAtDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toOrderDto));
    }

    @Transactional
    public LabOrderDto createOrder(CreateLabOrderRequest req, String actor) {
        Patient patient = entityManager.getReference(Patient.class, req.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, req.getDoctorId());
        OpdEncounter encounter = req.getEncounterId() != null ? entityManager.getReference(OpdEncounter.class, req.getEncounterId()) : null;
        IpdAdmission admission = req.getAdmissionId() != null ? entityManager.getReference(IpdAdmission.class, req.getAdmissionId()) : null;

        String orderNo = sequenceService.getNextNumber("LAB_SEQ");

        LabOrder order = LabOrder.builder()
                .orderNo(orderNo)
                .patient(patient)
                .orderingDoctor(doctor)
                .encounter(encounter)
                .admission(admission)
                .priority(req.getPriority() != null ? req.getPriority() : LabOrder.Priority.ROUTINE)
                .clinicalIndication(req.getClinicalIndication())
                .status(LabOrder.OrderStatus.ORDERED)
                .build();

        for (Long testId : req.getTestIds()) {
            LabTest test = testRepository.findById(testId)
                    .orElseThrow(() -> new ResourceNotFoundException("Lab Test", "id", testId));

            String rangeSnapshot = (test.getNormalRangeMin() != null && test.getNormalRangeMax() != null)
                    ? test.getNormalRangeMin() + " - " + test.getNormalRangeMax() + " " + (test.getUnit() != null ? test.getUnit() : "")
                    : "Standard reference";

            LabOrderItem item = LabOrderItem.builder()
                    .labOrder(order)
                    .test(test)
                    .sampleBarcode("SMP-" + System.currentTimeMillis() % 1000000)
                    .normalRangeSnapshot(rangeSnapshot)
                    .status(LabOrderItem.ItemStatus.PENDING)
                    .build();

            order.getItems().add(item);
        }

        return toOrderDto(orderRepository.save(order));
    }

    @Transactional
    public LabOrderDto enterResult(Long orderId, Long itemId, EnterLabResultRequest req) {
        LabOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Lab Order", "id", orderId));

        LabOrderItem item = order.getItems().stream()
                .filter(i -> i.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Lab Order Item", "id", itemId));

        Staff technician = entityManager.getReference(Staff.class, req.getTechnicianStaffId());

        item.setResultValue(req.getResultValue());
        item.setResultNumeric(req.getResultNumeric());
        item.setAbnormal(req.isAbnormal());
        item.setCritical(req.isCritical());
        item.setTechnicianNotes(req.getNotes());
        item.setTechnician(technician);
        item.setStatus(LabOrderItem.ItemStatus.RESULTED);

        // Check if all items are resulted
        boolean allResulted = order.getItems().stream()
                .allMatch(i -> i.getStatus() == LabOrderItem.ItemStatus.RESULTED || i.getStatus() == LabOrderItem.ItemStatus.VERIFIED);
        if (allResulted) {
            order.setStatus(LabOrder.OrderStatus.COMPLETED);
        }

        return toOrderDto(orderRepository.save(order));
    }

    public LabOrderDto toOrderDto(LabOrder o) {
        List<LabOrderItemDto> itemDtos = o.getItems().stream().map(i -> LabOrderItemDto.builder()
                .id(i.getId())
                .testId(i.getTest().getId())
                .testCode(i.getTest().getCode())
                .testName(i.getTest().getName())
                .category(i.getTest().getCategory())
                .specimenType(i.getTest().getSpecimenType())
                .sampleBarcode(i.getSampleBarcode())
                .resultValue(i.getResultValue())
                .resultNumeric(i.getResultNumeric())
                .normalRangeSnapshot(i.getNormalRangeSnapshot())
                .abnormal(i.isAbnormal())
                .critical(i.isCritical())
                .technicianNotes(i.getTechnicianNotes())
                .verifiedByName(i.getVerifiedBy() != null ? i.getVerifiedBy().getFirstName() + " " + i.getVerifiedBy().getLastName() : null)
                .verifiedAt(i.getVerifiedAt())
                .status(i.getStatus())
                .build()).collect(Collectors.toList());

        return LabOrderDto.builder()
                .id(o.getId())
                .orderNo(o.getOrderNo())
                .patientId(o.getPatient().getId())
                .patientName(o.getPatient().getFirstName() + " " + o.getPatient().getLastName())
                .patientMrn(o.getPatient().getMrn())
                .doctorId(o.getOrderingDoctor().getId())
                .doctorName("Dr. " + o.getOrderingDoctor().getStaff().getFirstName() + " " + o.getOrderingDoctor().getStaff().getLastName())
                .priority(o.getPriority())
                .clinicalIndication(o.getClinicalIndication())
                .status(o.getStatus())
                .orderedAt(o.getOrderedAt())
                .items(itemDtos)
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/laboratory")
@RequiredArgsConstructor
@Tag(name = "Laboratory Diagnostics", description = "Test catalog, specimen collection, result entry, and reports")
public class LabController {
    private final LabService labService;

    @GetMapping("/tests")
    @Operation(summary = "Get complete active laboratory test catalog")
    public ResponseEntity<ApiResponse<List<LabTest>>> getCatalog() {
        return ResponseEntity.ok(ApiResponse.ok(labService.getCatalog()));
    }

    @GetMapping("/orders")
    @Operation(summary = "Search laboratory orders with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<LabOrderDto>>> getOrders(
            @RequestParam(required = false) LabOrder.OrderStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(labService.getOrders(status, pageable)));
    }

    @GetMapping("/orders/patient/{patientId}")
    @Operation(summary = "Get all lab orders for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<LabOrderDto>>> getPatientOrders(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(labService.getPatientOrders(patientId, pageable)));
    }

    @PostMapping("/orders")
    @PreAuthorize("hasAuthority('PERM_LAB_ORDER_CREATE') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Create a new laboratory diagnostic order")
    public ResponseEntity<ApiResponse<LabOrderDto>> createOrder(@Valid @RequestBody CreateLabOrderRequest request) {
        LabOrderDto order = labService.createOrder(request, "DOCTOR");
        return new ResponseEntity<>(ApiResponse.ok(order, "Laboratory order created"), HttpStatus.CREATED);
    }

    @PostMapping("/orders/{orderId}/items/{itemId}/result")
    @PreAuthorize("hasAuthority('PERM_LAB_RESULT_WRITE') or hasRole('LAB_TECHNICIAN') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Enter diagnostic test result with abnormal flag analysis")
    public ResponseEntity<ApiResponse<LabOrderDto>> enterResult(
            @PathVariable Long orderId,
            @PathVariable Long itemId,
            @Valid @RequestBody EnterLabResultRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(labService.enterResult(orderId, itemId, request), "Lab result entered successfully"));
    }
}
