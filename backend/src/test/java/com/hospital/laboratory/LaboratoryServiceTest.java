package com.hospital.laboratory;

import com.hospital.common.ResourceNotFoundException;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import com.hospital.staff.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LaboratoryServiceTest {

    @Mock
    private LabTestRepository testRepository;

    @Mock
    private LabOrderRepository orderRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private LabService labService;

    private Patient testPatient;
    private Doctor testDoctor;
    private LabTest glucoseTest;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder().id(1L).firstName("Anand").lastName("Patil").mrn("MRN-10001").build();
        testDoctor = Doctor.builder().id(1L).staff(Staff.builder().firstName("Rajesh").lastName("Sharma").build()).build();
        glucoseTest = LabTest.builder()
                .id(1L)
                .code("LAB-GLUC-F")
                .name("Fasting Blood Glucose")
                .category("BIOCHEMISTRY")
                .specimenType("SERUM")
                .price(BigDecimal.valueOf(250.00))
                .normalRangeMin(70.0)
                .normalRangeMax(99.0)
                .unit("mg/dL")
                .active(true)
                .build();
    }

    @Test
    @DisplayName("Should create lab order and generate barcode for test specimens")
    void testCreateLabOrder() {
        CreateLabOrderRequest req = CreateLabOrderRequest.builder()
                .patientId(1L)
                .doctorId(1L)
                .priority(LabOrder.Priority.ROUTINE)
                .clinicalIndication("Metabolic checkup")
                .testIds(List.of(1L))
                .build();

        when(entityManager.getReference(eq(Patient.class), eq(1L))).thenReturn(testPatient);
        when(entityManager.getReference(eq(Doctor.class), eq(1L))).thenReturn(testDoctor);
        when(testRepository.findAllById(List.of(1L))).thenReturn(List.of(glucoseTest));
        when(sequenceService.getNextNumber("LAB_SEQ")).thenReturn("LAB-10001");
        when(orderRepository.save(any(LabOrder.class))).thenAnswer(i -> {
            LabOrder o = i.getArgument(0);
            o.setId(1L);
            return o;
        });

        LabOrderDto result = labService.createOrder(req, "dr.sharma");

        assertNotNull(result);
        assertEquals("LAB-10001", result.getOrderNo());
        assertEquals(1, result.getItems().size());
        assertEquals(LabOrder.OrderStatus.ORDERED, result.getStatus());
    }

    @Test
    @DisplayName("Should detect abnormal lab result when value is outside normal reference range")
    void testAbnormalResultDetection() {
        LabOrder order = LabOrder.builder().id(1L).orderNo("LAB-10001").patient(testPatient).orderingDoctor(testDoctor).build();
        LabOrderItem item = LabOrderItem.builder().id(1L).order(order).test(glucoseTest).status(LabOrderItem.ItemStatus.PENDING).build();
        order.getItems().add(item);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(LabOrder.class))).thenAnswer(i -> i.getArgument(0));

        LabOrderDto result = labService.recordResult(1L, 1L, "145.0", 145.0, "High fasting glucose", "lab.rahul");

        assertNotNull(result);
        assertTrue(item.isAbnormal()); // 145.0 > 99.0 max
        assertEquals(LabOrderItem.ItemStatus.RESULTED, item.getStatus());
        assertEquals("lab.rahul", item.getVerifiedByName());
    }
}
