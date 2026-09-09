package com.hospital.payments;

import com.hospital.billing.Invoice;
import com.hospital.common.BadRequestException;
import com.hospital.common.ConflictException;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private PaymentService paymentService;

    private Invoice testInvoice;
    private Patient testPatient;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder()
                .id(1L)
                .firstName("Anand")
                .lastName("Patil")
                .build();

        testInvoice = Invoice.builder()
                .id(1L)
                .invoiceNo("INV-10001")
                .patient(testPatient)
                .totalAmount(BigDecimal.valueOf(1500.00))
                .paidAmount(BigDecimal.ZERO)
                .balanceAmount(BigDecimal.valueOf(1500.00))
                .status(Invoice.InvoiceStatus.ISSUED)
                .build();
    }

    @Test
    @DisplayName("Should return existing transaction on identical idempotency key without double billing")
    void testIdempotencyProtection() {
        Payment existing = Payment.builder()
                .id(1L)
                .paymentNo("PAY-10001")
                .invoice(testInvoice)
                .patient(testPatient)
                .amount(BigDecimal.valueOf(500.00))
                .paymentMethod(Payment.PaymentMethod.CREDIT_CARD)
                .idempotencyKey("KEY-12345")
                .build();

        ProcessPaymentRequest req = ProcessPaymentRequest.builder()
                .invoiceId(1L)
                .amount(BigDecimal.valueOf(500.00))
                .paymentMethod(Payment.PaymentMethod.CREDIT_CARD)
                .idempotencyKey("KEY-12345")
                .build();

        when(paymentRepository.findByIdempotencyKey("KEY-12345")).thenReturn(Optional.of(existing));

        PaymentDto result = paymentService.processPayment(req, "acc.suresh");

        assertNotNull(result);
        assertEquals("PAY-10001", result.getPaymentNo());
        verify(entityManager, never()).find(eq(Invoice.class), any(), any());
    }

    @Test
    @DisplayName("Should process partial payment and adjust invoice balance and status to PARTIALLY_PAID")
    void testPartialPaymentProcessing() {
        ProcessPaymentRequest req = ProcessPaymentRequest.builder()
                .invoiceId(1L)
                .amount(BigDecimal.valueOf(500.00))
                .paymentMethod(Payment.PaymentMethod.UPI)
                .idempotencyKey("KEY-NEW-001")
                .build();

        when(paymentRepository.findByIdempotencyKey("KEY-NEW-001")).thenReturn(Optional.empty());
        when(entityManager.find(eq(Invoice.class), eq(1L), any())).thenReturn(testInvoice);
        when(sequenceService.getNextNumber("PAY_SEQ")).thenReturn("PAY-10002");
        when(paymentRepository.save(any(Payment.class))).thenAnswer(i -> {
            Payment p = i.getArgument(0);
            p.setId(2L);
            return p;
        });

        PaymentDto result = paymentService.processPayment(req, "acc.suresh");

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(500.00), testInvoice.getPaidAmount());
        assertEquals(BigDecimal.valueOf(1000.00), testInvoice.getBalanceAmount());
        assertEquals(Invoice.InvoiceStatus.PARTIALLY_PAID, testInvoice.getStatus());
        verify(entityManager, times(1)).merge(testInvoice);
    }

    @Test
    @DisplayName("Should process full settlement and transition invoice status to PAID")
    void testFullSettlementProcessing() {
        ProcessPaymentRequest req = ProcessPaymentRequest.builder()
                .invoiceId(1L)
                .amount(BigDecimal.valueOf(1500.00))
                .paymentMethod(Payment.PaymentMethod.CREDIT_CARD)
                .build();

        when(entityManager.find(eq(Invoice.class), eq(1L), any())).thenReturn(testInvoice);
        when(sequenceService.getNextNumber("PAY_SEQ")).thenReturn("PAY-10003");
        when(paymentRepository.save(any(Payment.class))).thenAnswer(i -> i.getArgument(0));

        PaymentDto result = paymentService.processPayment(req, "acc.suresh");

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(1500.00), testInvoice.getPaidAmount());
        assertEquals(BigDecimal.ZERO, testInvoice.getBalanceAmount());
        assertEquals(Invoice.InvoiceStatus.PAID, testInvoice.getStatus());
    }

    @Test
    @DisplayName("Should reject overpayment when payment amount exceeds remaining balance")
    void testOverpaymentRejection() {
        ProcessPaymentRequest req = ProcessPaymentRequest.builder()
                .invoiceId(1L)
                .amount(BigDecimal.valueOf(2000.00)) // Balance is only 1500
                .paymentMethod(Payment.PaymentMethod.CASH)
                .build();

        when(entityManager.find(eq(Invoice.class), eq(1L), any())).thenReturn(testInvoice);

        assertThrows(BadRequestException.class, () -> paymentService.processPayment(req, "acc.suresh"));
    }
}
