package com.hospital.billing;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
import com.hospital.patients.Patient;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "service_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String category; // CONSULTATION, LAB, RADIOLOGY, BED, PROCEDURE, NURSING, MISC

    @Column(name = "unit_price", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal unitPrice = BigDecimal.ZERO;

    @Column(name = "tax_percent", nullable = false, precision = 5, scale = 2)
    @Builder.Default
    private BigDecimal taxPercent = BigDecimal.ZERO;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_no", nullable = false, unique = true, length = 30)
    private String invoiceNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encounter_id")
    private OpdEncounter encounter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id")
    private IpdAdmission admission;

    @Column(nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(name = "discount_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(name = "tax_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal taxAmount = BigDecimal.ZERO;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Column(name = "paid_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal paidAmount = BigDecimal.ZERO;

    @Column(name = "balance_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal balanceAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private InvoiceStatus status = InvoiceStatus.DRAFT;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Version
    @Column(nullable = false)
    @Builder.Default
    private int version = 0;

    @Builder.Default
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceItem> items = new ArrayList<>();

    public enum InvoiceStatus {
        DRAFT, ISSUED, PARTIALLY_PAID, PAID, VOIDED
    }
}

@Entity
@Table(name = "invoice_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Column(name = "item_type", nullable = false, length = 50)
    private String itemType; // SERVICE, MEDICINE, LAB, RADIOLOGY, BED, PROCEDURE

    @Column(name = "reference_id")
    private Long referenceId;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    @Builder.Default
    private int quantity = 1;

    @Column(name = "unit_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "discount_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(name = "tax_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal taxAmount = BigDecimal.ZERO;

    @Column(name = "total_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalPrice;
}

@Repository
interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
    List<ServiceItem> findByActiveTrue();
}

@Repository
interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByInvoiceNo(String invoiceNo);
    Page<Invoice> findByPatientIdOrderByCreatedAtDesc(Long patientId, Pageable pageable);

    @Query("SELECT i FROM Invoice i WHERE (:status IS NULL OR i.status = :status)")
    Page<Invoice> searchInvoices(@Param("status") Invoice.InvoiceStatus status, Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class InvoiceDto {
    private Long id;
    private String invoiceNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private Long encounterId;
    private Long admissionId;
    private BigDecimal subtotal;
    private BigDecimal discountAmount;
    private BigDecimal taxAmount;
    private BigDecimal totalAmount;
    private BigDecimal paidAmount;
    private BigDecimal balanceAmount;
    private Invoice.InvoiceStatus status;
    private LocalDate dueDate;
    private String notes;
    private Instant createdAt;
    private List<InvoiceItemDto> items;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class InvoiceItemDto {
    private Long id;
    private String itemType;
    private Long referenceId;
    private String description;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal discountAmount;
    private BigDecimal taxAmount;
    private BigDecimal totalPrice;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class CreateInvoiceRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    private Long encounterId;
    private Long admissionId;
    private LocalDate dueDate;
    private String notes;
    private BigDecimal discountAmount;
    @NotEmpty(message = "Invoice must contain at least one line item")
    private List<InvoiceItemDto> items;
}

@Service
@RequiredArgsConstructor
class BillingService {
    private final ServiceItemRepository serviceItemRepository;
    private final InvoiceRepository invoiceRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<ServiceItem> getPriceList() {
        return serviceItemRepository.findByActiveTrue();
    }

    @Transactional(readOnly = true)
    public PagedResponse<InvoiceDto> getInvoices(Invoice.InvoiceStatus status, Pageable pageable) {
        Page<Invoice> page = invoiceRepository.searchInvoices(status, pageable);
        return PagedResponse.from(page.map(this::toInvoiceDto));
    }

    @Transactional(readOnly = true)
    public PagedResponse<InvoiceDto> getPatientInvoices(Long patientId, Pageable pageable) {
        Page<Invoice> page = invoiceRepository.findByPatientIdOrderByCreatedAtDesc(patientId, pageable);
        return PagedResponse.from(page.map(this::toInvoiceDto));
    }

    @Transactional(readOnly = true)
    public InvoiceDto getById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", id));
        return toInvoiceDto(invoice);
    }

    @Transactional
    public InvoiceDto createInvoice(CreateInvoiceRequest req, String createdBy) {
        Patient patient = entityManager.getReference(Patient.class, req.getPatientId());
        OpdEncounter encounter = req.getEncounterId() != null ? entityManager.getReference(OpdEncounter.class, req.getEncounterId()) : null;
        IpdAdmission admission = req.getAdmissionId() != null ? entityManager.getReference(IpdAdmission.class, req.getAdmissionId()) : null;

        String invNo = sequenceService.getNextNumber("INV_SEQ");

        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal totalTax = BigDecimal.ZERO;

        Invoice invoice = Invoice.builder()
                .invoiceNo(invNo)
                .patient(patient)
                .encounter(encounter)
                .admission(admission)
                .dueDate(req.getDueDate() != null ? req.getDueDate() : LocalDate.now().plusDays(7))
                .notes(req.getNotes())
                .status(Invoice.InvoiceStatus.ISSUED)
                .build();
        invoice.setCreatedBy(createdBy);

        for (InvoiceItemDto itemDto : req.getItems()) {
            BigDecimal lineBase = itemDto.getUnitPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity()));
            BigDecimal lineDiscount = itemDto.getDiscountAmount() != null ? itemDto.getDiscountAmount() : BigDecimal.ZERO;
            BigDecimal lineTax = itemDto.getTaxAmount() != null ? itemDto.getTaxAmount() : BigDecimal.ZERO;
            BigDecimal lineTotal = lineBase.subtract(lineDiscount).add(lineTax);

            subtotal = subtotal.add(lineBase);
            totalTax = totalTax.add(lineTax);

            InvoiceItem item = InvoiceItem.builder()
                    .invoice(invoice)
                    .itemType(itemDto.getItemType())
                    .referenceId(itemDto.getReferenceId())
                    .description(itemDto.getDescription())
                    .quantity(itemDto.getQuantity())
                    .unitPrice(itemDto.getUnitPrice())
                    .discountAmount(lineDiscount)
                    .taxAmount(lineTax)
                    .totalPrice(lineTotal)
                    .build();

            invoice.getItems().add(item);
        }

        BigDecimal discount = req.getDiscountAmount() != null ? req.getDiscountAmount() : BigDecimal.ZERO;
        BigDecimal grandTotal = subtotal.subtract(discount).add(totalTax);

        invoice.setSubtotal(subtotal);
        invoice.setDiscountAmount(discount);
        invoice.setTaxAmount(totalTax);
        invoice.setTotalAmount(grandTotal);
        invoice.setPaidAmount(BigDecimal.ZERO);
        invoice.setBalanceAmount(grandTotal);

        return toInvoiceDto(invoiceRepository.save(invoice));
    }

    public InvoiceDto toInvoiceDto(Invoice i) {
        List<InvoiceItemDto> itemDtos = i.getItems().stream().map(item -> InvoiceItemDto.builder()
                .id(item.getId())
                .itemType(item.getItemType())
                .referenceId(item.getReferenceId())
                .description(item.getDescription())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .discountAmount(item.getDiscountAmount())
                .taxAmount(item.getTaxAmount())
                .totalPrice(item.getTotalPrice())
                .build()).collect(Collectors.toList());

        return InvoiceDto.builder()
                .id(i.getId())
                .invoiceNo(i.getInvoiceNo())
                .patientId(i.getPatient().getId())
                .patientName(i.getPatient().getFirstName() + " " + i.getPatient().getLastName())
                .patientMrn(i.getPatient().getMrn())
                .encounterId(i.getEncounter() != null ? i.getEncounter().getId() : null)
                .admissionId(i.getAdmission() != null ? i.getAdmission().getId() : null)
                .subtotal(i.getSubtotal())
                .discountAmount(i.getDiscountAmount())
                .taxAmount(i.getTaxAmount())
                .totalAmount(i.getTotalAmount())
                .paidAmount(i.getPaidAmount())
                .balanceAmount(i.getBalanceAmount())
                .status(i.getStatus())
                .dueDate(i.getDueDate())
                .notes(i.getNotes())
                .createdAt(i.getCreatedAt())
                .items(itemDtos)
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/billing")
@RequiredArgsConstructor
@Tag(name = "Billing & Invoicing", description = "Price list catalog, charge capture, invoice generation, and balances")
public class BillingController {
    private final BillingService billingService;

    @GetMapping("/services")
    @Operation(summary = "Get standard hospital service pricing catalog")
    public ResponseEntity<ApiResponse<List<ServiceItem>>> getPriceList() {
        return ResponseEntity.ok(ApiResponse.ok(billingService.getPriceList()));
    }

    @GetMapping("/invoices")
    @Operation(summary = "List invoices with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<InvoiceDto>>> getInvoices(
            @RequestParam(required = false) Invoice.InvoiceStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(billingService.getInvoices(status, pageable)));
    }

    @GetMapping("/invoices/patient/{patientId}")
    @Operation(summary = "Get all invoices for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<InvoiceDto>>> getPatientInvoices(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(billingService.getPatientInvoices(patientId, pageable)));
    }

    @GetMapping("/invoices/{id}")
    @Operation(summary = "Get invoice details and line items")
    public ResponseEntity<ApiResponse<InvoiceDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(billingService.getById(id)));
    }

    @PostMapping("/invoices")
    @PreAuthorize("hasAuthority('PERM_INVOICE_WRITE') or hasRole('ACCOUNTANT') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Generate and issue patient invoice")
    public ResponseEntity<ApiResponse<InvoiceDto>> createInvoice(@Valid @RequestBody CreateInvoiceRequest request) {
        InvoiceDto invoice = billingService.createInvoice(request, "ACCOUNTANT");
        return new ResponseEntity<>(ApiResponse.ok(invoice, "Invoice created successfully"), HttpStatus.CREATED);
    }
}
