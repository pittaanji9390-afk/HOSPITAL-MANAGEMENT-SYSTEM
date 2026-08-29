package com.hospital.ipd;

import com.hospital.common.ConflictException;
import com.hospital.configuration.SequenceService;
import com.hospital.organization.Department;
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
class IpdServiceTest {

    @Mock
    private IpdAdmissionRepository admissionRepository;

    @Mock
    private BedRepository bedRepository;

    @Mock
    private BedAssignmentRepository assignmentRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private IpdService ipdService;

    private Patient testPatient;
    private Doctor testDoctor;
    private Department testDept;
    private Ward testWard;
    private Room testRoom;
    private Bed testBed;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder().id(1L).firstName("Anand").lastName("Patil").build();
        testDept = Department.builder().id(1L).name("Cardiology").build();
        testDoctor = Doctor.builder().id(1L).staff(Staff.builder().firstName("Rajesh").lastName("Sharma").build()).build();
        testWard = Ward.builder().id(1L).name("Coronary Care Unit").build();
        testRoom = Room.builder().id(1L).roomNumber("CCU-301").ward(testWard).build();
        testBed = Bed.builder().id(1L).bedNumber("BED-CCU-01").room(testRoom).status(Bed.BedStatus.AVAILABLE).ratePerDay(BigDecimal.valueOf(5000.00)).build();
    }

    @Test
    @DisplayName("Should admit patient, allocate available bed atomically, and transition bed status to OCCUPIED")
    void testAdmitPatientSuccess() {
        AdmitPatientRequest req = AdmitPatientRequest.builder()
                .patientId(1L)
                .primaryDoctorId(1L)
                .departmentId(1L)
                .wardId(1L)
                .bedId(1L)
                .admissionType(IpdAdmission.AdmissionType.PLANNED)
                .admissionReason("Acute chest pain evaluation")
                .build();

        when(entityManager.find(eq(Bed.class), eq(1L), any())).thenReturn(testBed);
        when(entityManager.getReference(eq(Patient.class), eq(1L))).thenReturn(testPatient);
        when(entityManager.getReference(eq(Doctor.class), eq(1L))).thenReturn(testDoctor);
        when(entityManager.getReference(eq(Department.class), eq(1L))).thenReturn(testDept);
        when(entityManager.getReference(eq(Ward.class), eq(1L))).thenReturn(testWard);
        when(sequenceService.getNextNumber("IPD_SEQ")).thenReturn("IPD-10001");
        when(admissionRepository.save(any(IpdAdmission.class))).thenAnswer(i -> {
            IpdAdmission a = i.getArgument(0);
            a.setId(1L);
            return a;
        });

        IpdAdmissionDto result = ipdService.admitPatient(req, "dr.sharma");

        assertNotNull(result);
        assertEquals("IPD-10001", result.getAdmissionNo());
        assertEquals(Bed.BedStatus.OCCUPIED, testBed.getStatus());
        verify(bedRepository, times(1)).save(testBed);
        verify(assignmentRepository, times(1)).save(any(BedAssignment.class));
    }

    @Test
    @DisplayName("Should reject admission when selected bed is not in AVAILABLE status")
    void testBedUnavailableConflict() {
        testBed.setStatus(Bed.BedStatus.OCCUPIED);
        AdmitPatientRequest req = AdmitPatientRequest.builder()
                .patientId(1L)
                .bedId(1L)
                .build();

        when(entityManager.find(eq(Bed.class), eq(1L), any())).thenReturn(testBed);

        assertThrows(ConflictException.class, () -> ipdService.admitPatient(req, "dr.sharma"));
    }

    @Test
    @DisplayName("Should discharge patient, release bed back to CLEANING status, and record discharge summary")
    void testDischargePatient() {
        IpdAdmission admission = IpdAdmission.builder()
                .id(1L)
                .admissionNo("IPD-10001")
                .patient(testPatient)
                .primaryDoctor(testDoctor)
                .department(testDept)
                .ward(testWard)
                .bed(testBed)
                .status(IpdAdmission.AdmissionStatus.ADMITTED)
                .build();

        BedAssignment activeAssignment = BedAssignment.builder()
                .id(1L)
                .admission(admission)
                .bed(testBed)
                .active(true)
                .build();

        DischargePatientRequest req = DischargePatientRequest.builder()
                .dischargeType(IpdAdmission.DischargeType.ROUTINE)
                .dischargeSummary("Patient recovered completely. Stable on oral medication.")
                .build();

        when(admissionRepository.findById(1L)).thenReturn(Optional.of(admission));
        when(assignmentRepository.findByAdmissionIdAndActiveTrue(1L)).thenReturn(Optional.of(activeAssignment));

        IpdAdmissionDto result = ipdService.dischargePatient(1L, req);

        assertNotNull(result);
        assertEquals(IpdAdmission.AdmissionStatus.DISCHARGED, admission.getStatus());
        assertEquals(Bed.BedStatus.CLEANING, testBed.getStatus());
        assertFalse(activeAssignment.isActive());
        assertNotNull(admission.getDischargeDate());
    }
}
