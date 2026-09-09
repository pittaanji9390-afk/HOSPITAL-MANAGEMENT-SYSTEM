package com.hospital.payments;

import com.hospital.billing.Invoice;
import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_no", nullable = false, unique = true, length = 30)
    private String paymentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, length = 30)
    private PaymentMethod paymentMethod;

    @Column(name = "transaction_ref", length = 100)
    private String transactionRef;

    @Column(name = "idempotency_key", length = 100, unique = true)
    private String idempotencyKey;

    @Column(name = "received_by", nullable = false, length = 50)
    private String receivedBy;

    @Column(name = "payment_date", nullable = false)
    @Builder.Default
    private Instant paymentDate = Instant.now();

    @Column(columnDefinition = "TEXT")
    private String notes;

    public enum PaymentMethod {
        CASH, CREDIT_CARD, DEBIT_CARD, UPI, BANK_TRANSFER, INSURANCE, CHEQUE
    }
}

@Entity
@Table(name = "payment_refunds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class PaymentRefund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "refund_no", nullable = false, unique = true, length = 30)
    private String refundNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Column(name = "authorized_by", nullable = false, length = 50)
    private String authorizedBy;

    @Column(name = "refund_date", nullable = false)
    @Builder.Default
    private Instant refundDate = Instant.now();
}

@Repository
interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByIdempotencyKey(String idempotencyKey);
    List<Payment> findByInvoiceId(Long invoiceId);
    Page<Payment> findByPatientIdOrderByPaymentDateDesc(Long patientId, Pageable pageable);
    Page<Payment> findAllByOrderByPaymentDateDesc(Pageable pageable);
}

@Repository
interface PaymentRefundRepository extends JpaRepository<PaymentRefund, Long> {
    List<PaymentRefund> findByInvoiceId(Long invoiceId);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PaymentDto {
    private Long id;
    private String paymentNo;
    private Long invoiceId;
    private String invoiceNo;
    private Long patientId;
    private String patientName;
    private BigDecimal amount;
    private Payment.PaymentMethod paymentMethod;
    private String transactionRef;
    private String receivedBy;
    private Instant paymentDate;
    private String notes;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ProcessPaymentRequest {
    @NotNull(message = "Invoice ID is required")
    private Long invoiceId;
    @NotNull(message = "Payment amount is required")
    @DecimalMin(value = "0.01", message = "Payment amount must be greater than zero")
    private BigDecimal amount;
    @NotNull(message = "Payment method is required")
    private Payment.PaymentMethod paymentMethod;
    private String transactionRef;
    private String idempotencyKey;
    private String notes;
}

@Service
@RequiredArgsConstructor
class PaymentService {
    private final PaymentRepository paymentRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<PaymentDto> getPayments(Pageable pageable) {
        Page<Payment> page = paymentRepository.findAllByOrderByPaymentDateDesc(pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public List<PaymentDto> getInvoicePayments(Long invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId).stream().map(this::toDto).toList();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PaymentDto processPayment(ProcessPaymentRequest req, String receivedBy) {
        // Idempotency check
        if (req.getIdempotencyKey() != null && !req.getIdempotencyKey().isBlank()) {
            Optional<Payment> existing = paymentRepository.findByIdempotencyKey(req.getIdempotencyKey());
            if (existing.isPresent()) {
                return toDto(existing.get());
            }
        }

        Invoice invoice = entityManager.find(Invoice.class, req.getInvoiceId(), LockModeType.PESSIMISTIC_WRITE);
        if (invoice == null) {
            throw new ResourceNotFoundException("Invoice", "id", req.getInvoiceId());
        }

        if (invoice.getStatus() == Invoice.InvoiceStatus.PAID) {
            throw new ConflictException("Invoice has already been settled in full.");
        }

        if (req.getAmount().compareTo(invoice.getBalanceAmount()) > 0) {
            throw new BadRequestException("Payment amount (" + req.getAmount() + ") exceeds remaining balance (" + invoice.getBalanceAmount() + ").");
        }

        String paymentNo = sequenceService.getNextNumber("PAY_SEQ");

        Payment payment = Payment.builder()
                .paymentNo(paymentNo)
                .invoice(invoice)
                .patient(invoice.getPatient())
                .amount(req.getAmount())
                .paymentMethod(req.getPaymentMethod())
                .transactionRef(req.getTransactionRef())
                .idempotencyKey(req.getIdempotencyKey())
                .receivedBy(receivedBy)
                .paymentDate(Instant.now())
                .notes(req.getNotes())
                .build();

        Payment savedPayment = paymentRepository.save(payment);

        // Update invoice ledger balances
        BigDecimal newPaid = invoice.getPaidAmount().add(req.getAmount());
        BigDecimal newBalance = invoice.getTotalAmount().subtract(newPaid);

        invoice.setPaidAmount(newPaid);
        invoice.setBalanceAmount(newBalance);

        if (newBalance.compareTo(BigDecimal.ZERO) == 0) {
            invoice.setStatus(Invoice.InvoiceStatus.PAID);
        } else {
            invoice.setStatus(Invoice.InvoiceStatus.PARTIALLY_PAID);
        }
        entityManager.merge(invoice);

        return toDto(savedPayment);
    }

    public PaymentDto toDto(Payment p) {
        return PaymentDto.builder()
                .id(p.getId())
                .paymentNo(p.getPaymentNo())
                .invoiceId(p.getInvoice().getId())
                .invoiceNo(p.getInvoice().getInvoiceNo())
                .patientId(p.getPatient().getId())
                .patientName(p.getPatient().getFirstName() + " " + p.getPatient().getLastName())
                .amount(p.getAmount())
                .paymentMethod(p.getPaymentMethod())
                .transactionRef(p.getTransactionRef())
                .receivedBy(p.getReceivedBy())
                .paymentDate(p.getPaymentDate())
                .notes(p.getNotes())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
@Tag(name = "Payments & Financial Ledger", description = "Multi-tender payment processing, idempotency guards, and receipts")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    @Operation(summary = "List payment transactions with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<PaymentDto>>> getPayments(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(paymentService.getPayments(pageable)));
    }

    @GetMapping("/invoice/{invoiceId}")
    @Operation(summary = "Get all payments made against an invoice")
    public ResponseEntity<ApiResponse<List<PaymentDto>>> getInvoicePayments(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(ApiResponse.ok(paymentService.getInvoicePayments(invoiceId)));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PERM_PAYMENT_COLLECT') or hasRole('ACCOUNTANT') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Process a payment with idempotency key protection")
    public ResponseEntity<ApiResponse<PaymentDto>> processPayment(@Valid @RequestBody ProcessPaymentRequest request) {
        PaymentDto payment = paymentService.processPayment(request, "ACCOUNTANT");
        return new ResponseEntity<>(ApiResponse.ok(payment, "Payment recorded successfully"), HttpStatus.CREATED);
    }
}
