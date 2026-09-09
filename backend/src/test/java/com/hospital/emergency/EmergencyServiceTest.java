package com.hospital.emergency;

import com.hospital.common.ConflictException;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmergencyServiceTest {

    @Mock
    private EmergencyCaseRepository caseRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private EmergencyService emergencyService;

    private Doctor testDoctor;

    @BeforeEach
    void setUp() {
        testDoctor = Doctor.builder()
                .id(1L)
                .staff(Staff.builder().firstName("Rajesh").lastName("Sharma").build())
                .build();
    }

    @Test
    @DisplayName("Should successfully record rapid emergency intake with ESI Level 1 (Critical)")
    void testEmergencyIntakeSuccess() {
        EmergencyIntakeRequest req = EmergencyIntakeRequest.builder()
                .modeOfArrival(EmergencyCase.ModeOfArrival.AMBULANCE)
                .triageLevel(1)
                .chiefComplaint("Cardiopulmonary arrest in transit, CPR ongoing")
                .traumaDetails("STEMI suspected")
                .attendingDoctorId(1L)
                .build();

        when(sequenceService.getNextNumber("EMR_SEQ")).thenReturn("EMR-10001");
        when(entityManager.getReference(eq(Doctor.class), eq(1L))).thenReturn(testDoctor);
        when(caseRepository.save(any(EmergencyCase.class))).thenAnswer(i -> {
            EmergencyCase c = i.getArgument(0);
            c.setId(1L);
            return c;
        });

        EmergencyCaseDto result = emergencyService.createIntake(req, "reception.amit");

        assertNotNull(result);
        assertEquals("EMR-10001", result.getCaseNo());
        assertEquals(1, result.getTriageLevel());
        assertEquals(EmergencyCase.TriagePriority.CRITICAL, result.getTriagePriority());
        assertEquals(EmergencyCase.CaseStatus.TRIAGED, result.getStatus());
        verify(caseRepository, times(1)).save(any(EmergencyCase.class));
    }

    @Test
    @DisplayName("Should retrieve active queue sorted by triage priority and level")
    void testGetActiveQueue() {
        EmergencyCase c1 = EmergencyCase.builder().id(1L).caseNo("EMR-10001").triageLevel(1).triagePriority(EmergencyCase.TriagePriority.CRITICAL).status(EmergencyCase.CaseStatus.UNDER_TREATMENT).build();
        EmergencyCase c2 = EmergencyCase.builder().id(2L).caseNo("EMR-10002").triageLevel(2).triagePriority(EmergencyCase.TriagePriority.URGENT).status(EmergencyCase.CaseStatus.TRIAGED).build();

        when(caseRepository.findActiveQueue()).thenReturn(List.of(c1, c2));

        List<EmergencyCaseDto> queue = emergencyService.getActiveQueue();

        assertEquals(2, queue.size());
        assertEquals("EMR-10001", queue.get(0).getCaseNo());
    }
}
