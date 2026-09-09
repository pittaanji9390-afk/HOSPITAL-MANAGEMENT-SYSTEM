package com.hospital.pharmacy;

import com.hospital.common.BadRequestException;
import com.hospital.common.ConflictException;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import com.hospital.prescriptions.Prescription;
import com.hospital.prescriptions.PrescriptionItem;
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
class PharmacyServiceTest {

    @Mock
    private MedicineRepository medicineRepository;

    @Mock
    private MedicineBatchRepository batchRepository;

    @Mock
    private PharmacyDispensationRepository dispensationRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private PharmacyService pharmacyService;

    private Medicine testMedicine;
    private MedicineBatch validBatch;
    private MedicineBatch expiredBatch;

    @BeforeEach
    void setUp() {
        testMedicine = Medicine.builder()
                .id(1L)
                .code("MED-AUG625")
                .brandName("Augmentin 625")
                .genericName("Amoxicillin + Clavulanate")
                .dosageForm("TABLET")
                .strength("625mg")
                .totalStock(100)
                .active(true)
                .build();

        validBatch = MedicineBatch.builder()
                .id(1L)
                .medicine(testMedicine)
                .batchNumber("BCH-2026-001")
                .expiryDate(LocalDate.now().plusMonths(12))
                .quantityInStock(50)
                .costPrice(BigDecimal.valueOf(15.00))
                .sellingPrice(BigDecimal.valueOf(22.50))
                .build();

        expiredBatch = MedicineBatch.builder()
                .id(2L)
                .medicine(testMedicine)
                .batchNumber("BCH-2023-EXPIRED")
                .expiryDate(LocalDate.now().minusDays(10))
                .quantityInStock(30)
                .costPrice(BigDecimal.valueOf(12.00))
                .sellingPrice(BigDecimal.valueOf(18.00))
                .build();
    }

    @Test
    @DisplayName("Should detect expired batch and reject dispensing")
    void testExpiredBatchValidation() {
        assertTrue(expiredBatch.isExpired());
        assertFalse(validBatch.isExpired());
    }

    @Test
    @DisplayName("Should successfully dispense medication and decrement batch stock inside transaction")
    void testDispensePrescriptionSuccess() {
        Prescription prescription = Prescription.builder()
                .id(1L)
                .prescriptionNo("RX-10001")
                .patient(Patient.builder().id(1L).firstName("Anand").lastName("Patil").build())
                .status(Prescription.PrescriptionStatus.ISSUED)
                .build();

        PrescriptionItem item = PrescriptionItem.builder()
                .id(1L)
                .prescription(prescription)
                .medicine(testMedicine)
                .quantityPrescribed(10)
                .quantityDispensed(0)
                .status(PrescriptionItem.ItemStatus.PENDING)
                .build();
        prescription.getItems().add(item);

        DispensePrescriptionRequest.DispenseItemRequest itemReq = DispensePrescriptionRequest.DispenseItemRequest.builder()
                .prescriptionItemId(1L)
                .batchId(1L)
                .quantityToDispense(10)
                .build();

        DispensePrescriptionRequest req = DispensePrescriptionRequest.builder()
                .prescriptionId(1L)
                .items(List.of(itemReq))
                .build();

        when(entityManager.find(eq(Prescription.class), eq(1L), any())).thenReturn(prescription);
        when(entityManager.find(eq(MedicineBatch.class), eq(1L), any())).thenReturn(validBatch);
        when(sequenceService.getNextNumber("DISP_SEQ")).thenReturn("DSP-10001");

        pharmacyService.dispensePrescription(req, "pharm.kavita");

        assertEquals(40, validBatch.getQuantityInStock()); // 50 - 10 = 40
        assertEquals(10, item.getQuantityDispensed());
        assertEquals(PrescriptionItem.ItemStatus.DISPENSED, item.getStatus());
        assertEquals(Prescription.PrescriptionStatus.DISPENSED, prescription.getStatus());

        verify(dispensationRepository, times(1)).save(any(PharmacyDispensation.class));
    }

    @Test
    @DisplayName("Should throw ConflictException when requesting more quantity than available batch stock")
    void testInsufficientStockValidation() {
        Prescription prescription = Prescription.builder()
                .id(1L)
                .status(Prescription.PrescriptionStatus.ISSUED)
                .build();

        PrescriptionItem item = PrescriptionItem.builder()
                .id(1L)
                .prescription(prescription)
                .medicine(testMedicine)
                .quantityPrescribed(100)
                .quantityDispensed(0)
                .status(PrescriptionItem.ItemStatus.PENDING)
                .build();
        prescription.getItems().add(item);

        DispensePrescriptionRequest.DispenseItemRequest itemReq = DispensePrescriptionRequest.DispenseItemRequest.builder()
                .prescriptionItemId(1L)
                .batchId(1L)
                .quantityToDispense(80) // Available is only 50
                .build();

        DispensePrescriptionRequest req = DispensePrescriptionRequest.builder()
                .prescriptionId(1L)
                .items(List.of(itemReq))
                .build();

        when(entityManager.find(eq(Prescription.class), eq(1L), any())).thenReturn(prescription);
        when(entityManager.find(eq(MedicineBatch.class), eq(1L), any())).thenReturn(validBatch);

        assertThrows(ConflictException.class, () -> pharmacyService.dispensePrescription(req, "pharm.kavita"));
    }
}
