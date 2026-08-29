package com.hospital.radiology;

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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RadiologyServiceTest {

    @Mock
    private RadiologyExamRepository examRepository;

    @Mock
    private RadiologyOrderRepository orderRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private RadiologyService radiologyService;

    private Patient testPatient;
    private Doctor testDoctor;
    private RadiologyExam chestXray;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder().id(1L).firstName("Anand").lastName("Patil").mrn("MRN-10001").build();
        testDoctor = Doctor.builder().id(1L).staff(Staff.builder().firstName("Rajesh").lastName("Sharma").build()).build();
        chestXray = RadiologyExam.builder()
                .id(1L)
                .code("RAD-XR-CHEST")
                .name("Chest X-Ray PA View")
                .modality(RadiologyExam.Modality.X_RAY)
                .bodyPart("Thorax")
                .price(BigDecimal.valueOf(800.00))
                .active(true)
                .build();
    }

    @Test
    @DisplayName("Should create radiology imaging order")
    void testCreateRadiologyOrder() {
        CreateRadiologyOrderRequest req = CreateRadiologyOrderRequest.builder()
                .patientId(1L)
                .doctorId(1L)
                .examinationId(1L)
                .priority(RadiologyOrder.Priority.ROUTINE)
                .clinicalHistory("Post-operative check")
                .build();

        when(entityManager.getReference(eq(Patient.class), eq(1L))).thenReturn(testPatient);
        when(entityManager.getReference(eq(Doctor.class), eq(1L))).thenReturn(testDoctor);
        when(examRepository.findById(1L)).thenReturn(Optional.of(chestXray));
        when(sequenceService.getNextNumber("RAD_SEQ")).thenReturn("RAD-10001");
        when(orderRepository.save(any(RadiologyOrder.class))).thenAnswer(i -> {
            RadiologyOrder o = i.getArgument(0);
            o.setId(1L);
            return o;
        });

        RadiologyOrderDto result = radiologyService.createOrder(req, "dr.sharma");

        assertNotNull(result);
        assertEquals("RAD-10001", result.getOrderNo());
        assertEquals("Chest X-Ray PA View", result.getExaminationName());
        assertEquals(RadiologyOrder.OrderStatus.ORDERED, result.getStatus());
    }

    @Test
    @DisplayName("Should submit radiologist report findings and impression")
    void testSubmitReport() {
        RadiologyOrder order = RadiologyOrder.builder()
                .id(1L)
                .orderNo("RAD-10001")
                .patient(testPatient)
                .orderingDoctor(testDoctor)
                .examination(chestXray)
                .status(RadiologyOrder.OrderStatus.ORDERED)
                .build();

        SubmitRadiologyReportRequest req = SubmitRadiologyReportRequest.builder()
                .radiologistId(1L)
                .findings("Normal lung fields. No consolidation or effusion.")
                .impression("Normal chest radiograph.")
                .pacsImageUrl("https://pacs.hospital.org/viewer?study=94819")
                .build();

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(entityManager.getReference(eq(Doctor.class), eq(1L))).thenReturn(testDoctor);
        when(orderRepository.save(any(RadiologyOrder.class))).thenAnswer(i -> i.getArgument(0));

        RadiologyOrderDto result = radiologyService.submitReport(1L, req);

        assertNotNull(result);
        assertEquals(RadiologyOrder.OrderStatus.REPORTED, order.getStatus());
        assertEquals("Normal chest radiograph.", order.getImpression());
        assertNotNull(order.getCompletedAt());
    }
}
