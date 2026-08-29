package com.hospital.patients;

import com.hospital.common.ConflictException;
import com.hospital.common.ResourceNotFoundException;
import com.hospital.configuration.SequenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientConsentRepository consentRepository;

    @Mock
    private PatientMergeRepository mergeRepository;

    @Mock
    private SequenceService sequenceService;

    @InjectMocks
    private PatientService patientService;

    private Patient testPatient;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder()
                .id(1L)
                .mrn("MRN-10001")
                .firstName("Anand")
                .lastName("Patil")
                .dob(LocalDate.of(1982, 6, 14))
                .gender("MALE")
                .bloodGroup("O+")
                .phone("+91-98450-12345")
                .email("anand@example.com")
                .city("Bengaluru")
                .state("Karnataka")
                .status(Patient.PatientStatus.ACTIVE)
                .build();
    }

    @Test
    @DisplayName("Should successfully register a new patient and assign collision-free MRN")
    void testRegisterPatientSuccess() {
        CreatePatientRequest req = CreatePatientRequest.builder()
                .firstName("Anand")
                .lastName("Patil")
                .dob(LocalDate.of(1982, 6, 14))
                .gender("MALE")
                .bloodGroup("O+")
                .phone("+91-98450-12345")
                .email("anand@example.com")
                .city("Bengaluru")
                .state("Karnataka")
                .build();

        when(patientRepository.existsByPhone("+91-98450-12345")).thenReturn(false);
        when(sequenceService.getNextNumber("MRN_SEQ")).thenReturn("MRN-10001");
        when(patientRepository.save(any(Patient.class))).thenReturn(testPatient);

        PatientDto result = patientService.registerPatient(req, "reception.amit");

        assertNotNull(result);
        assertEquals("MRN-10001", result.getMrn());
        assertEquals("Anand", result.getFirstName());
        assertEquals("Patil", result.getLastName());
        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    @DisplayName("Should reject registration when duplicate national ID exists")
    void testDuplicateNationalIdRejection() {
        CreatePatientRequest req = CreatePatientRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .dob(LocalDate.of(1990, 1, 1))
                .gender("MALE")
                .nationalId("AADHAAR-12345")
                .phone("+91-98765-00000")
                .build();

        when(patientRepository.existsByNationalId("AADHAAR-12345")).thenReturn(true);

        assertThrows(ConflictException.class, () -> patientService.registerPatient(req, "reception.amit"));
    }

    @Test
    @DisplayName("Should retrieve patient by MRN")
    void testGetPatientByMrn() {
        when(patientRepository.findByMrn("MRN-10001")).thenReturn(Optional.of(testPatient));

        PatientDto result = patientService.getPatientByMrn("MRN-10001");

        assertNotNull(result);
        assertEquals("MRN-10001", result.getMrn());
    }

    @Test
    @DisplayName("Should merge duplicate patient record into target patient")
    void testMergePatients() {
        Patient duplicate = Patient.builder()
                .id(2L)
                .mrn("MRN-10002")
                .firstName("Anand")
                .lastName("Patil")
                .status(Patient.PatientStatus.ACTIVE)
                .build();

        when(patientRepository.findById(1L)).thenReturn(Optional.of(testPatient));
        when(patientRepository.findById(2L)).thenReturn(Optional.of(duplicate));

        patientService.mergePatients(1L, 2L, "Accidental duplicate entry at reception", "superadmin");

        assertEquals(Patient.PatientStatus.MERGED, duplicate.getStatus());
        verify(patientRepository, times(1)).save(duplicate);
        verify(mergeRepository, times(1)).save(any(PatientMerge.class));
    }
}
