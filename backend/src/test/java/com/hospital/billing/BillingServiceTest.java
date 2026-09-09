package com.hospital.billing;

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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BillingServiceTest {

    @Mock
    private ServiceItemRepository serviceItemRepository;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private BillingService billingService;

    private Patient testPatient;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder()
                .id(1L)
                .mrn("MRN-10001")
                .firstName("Anand")
                .lastName("Patil")
                .build();
    }

    @Test
    @DisplayName("Should accurately calculate invoice subtotal, tax, discounts, and ledger balance")
    void testCreateInvoiceCalculation() {
        InvoiceItemDto item1 = InvoiceItemDto.builder()
                .itemType("SERVICE")
                .description("Consultation - Cardiology")
                .quantity(1)
                .unitPrice(BigDecimal.valueOf(1000.00))
                .discountAmount(BigDecimal.ZERO)
                .taxAmount(BigDecimal.ZERO)
                .build();

        InvoiceItemDto item2 = InvoiceItemDto.builder()
                .itemType("LAB")
                .description("Lipid Profile Diagnostic")
                .quantity(1)
                .unitPrice(BigDecimal.valueOf(800.00))
                .discountAmount(BigDecimal.ZERO)
                .taxAmount(BigDecimal.valueOf(40.00)) // 5% tax
                .build();

        CreateInvoiceRequest req = CreateInvoiceRequest.builder()
                .patientId(1L)
                .dueDate(LocalDate.now().plusDays(7))
                .discountAmount(BigDecimal.valueOf(100.00)) // 100 overall discount
                .items(List.of(item1, item2))
                .build();

        when(entityManager.getReference(eq(Patient.class), eq(1L))).thenReturn(testPatient);
        when(sequenceService.getNextNumber("INV_SEQ")).thenReturn("INV-10001");
        when(invoiceRepository.save(any(Invoice.class))).thenAnswer(invocation -> {
            Invoice saved = invocation.getArgument(0);
            saved.setId(1L);
            return saved;
        });

        InvoiceDto result = billingService.createInvoice(req, "acc.suresh");

        assertNotNull(result);
        assertEquals("INV-10001", result.getInvoiceNo());
        assertEquals(BigDecimal.valueOf(1800.00), result.getSubtotal()); // 1000 + 800
        assertEquals(BigDecimal.valueOf(100.00), result.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(40.00), result.getTaxAmount());
        assertEquals(BigDecimal.valueOf(1740.00), result.getTotalAmount()); // 1800 - 100 + 40
        assertEquals(BigDecimal.valueOf(1740.00), result.getBalanceAmount());
        assertEquals(BigDecimal.ZERO, result.getPaidAmount());
        assertEquals(Invoice.InvoiceStatus.ISSUED, result.getStatus());
        assertEquals(2, result.getItems().size());
    }
}
