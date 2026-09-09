package com.hospital.appointments;

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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private jakarta.persistence.EntityManager entityManager;

    @InjectMocks
    private AppointmentService appointmentService;

    private Patient testPatient;
    private Doctor testDoctor;
    private Department testDept;

    @BeforeEach
    void setUp() {
        testPatient = Patient.builder()
                .id(1L)
                .mrn("MRN-10001")
                .firstName("Anand")
                .lastName("Patil")
                .build();

        testDept = Department.builder()
                .id(1L)
                .name("Cardiology")
                .build();

        testDoctor = Doctor.builder()
                .id(1L)
                .staff(Staff.builder().firstName("Rajesh").lastName("Sharma").build())
                .department(testDept)
                .build();
    }

    @Test
    @DisplayName("Should successfully book appointment when slot is open")
    void testBookAppointmentSuccess() {
        BookAppointmentRequest req = BookAppointmentRequest.builder()
                .patientId(1L)
                .doctorId(1L)
                .departmentId(1L)
                .scheduledDate(LocalDate.now().plusDays(1))
                .startTime(LocalTime.of(9, 30))
                .type(Appointment.AppointmentType.CONSULTATION)
                .reason("Routine follow-up")
                .build();

        when(appointmentRepository.existsByDoctorIdAndScheduledDateAndStartTimeAndStatusNot(any(), any(), any(), any()))
                .thenReturn(false);
        when(entityManager.getReference(eq(Patient.class), eq(1L))).thenReturn(testPatient);
        when(entityManager.getReference(eq(Doctor.class), eq(1L))).thenReturn(testDoctor);
        when(entityManager.getReference(eq(Department.class), eq(1L))).thenReturn(testDept);
        when(sequenceService.getNextNumber("APT_SEQ")).thenReturn("APT-10001");
        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(i -> {
            Appointment a = i.getArgument(0);
            a.setId(1L);
            return a;
        });

        AppointmentDto result = appointmentService.bookAppointment(req, "reception.amit");

        assertNotNull(result);
        assertEquals("APT-10001", result.getAppointmentNo());
        assertEquals("Anand Patil", result.getPatientName());
        assertEquals(Appointment.AppointmentStatus.CONFIRMED, result.getStatus());
        verify(appointmentRepository, times(1)).save(any(Appointment.class));
    }

    @Test
    @DisplayName("Should reject booking and throw ConflictException when doctor slot is already occupied")
    void testSlotDoubleBookingConflict() {
        BookAppointmentRequest req = BookAppointmentRequest.builder()
                .patientId(1L)
                .doctorId(1L)
                .departmentId(1L)
                .scheduledDate(LocalDate.now().plusDays(1))
                .startTime(LocalTime.of(9, 30))
                .build();

        when(appointmentRepository.existsByDoctorIdAndScheduledDateAndStartTimeAndStatusNot(
                eq(1L), eq(req.getScheduledDate()), eq(req.getStartTime()), eq(Appointment.AppointmentStatus.CANCELLED)))
                .thenReturn(true);

        assertThrows(ConflictException.class, () -> appointmentService.bookAppointment(req, "reception.amit"));
    }

    @Test
    @DisplayName("Should update appointment status through clinical workflow states")
    void testStatusTransition() {
        Appointment appt = Appointment.builder()
                .id(1L)
                .patient(testPatient)
                .doctor(testDoctor)
                .department(testDept)
                .status(Appointment.AppointmentStatus.CONFIRMED)
                .build();

        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appt));
        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(i -> i.getArgument(0));

        AppointmentDto result = appointmentService.updateStatus(1L, Appointment.AppointmentStatus.CHECKED_IN);

        assertNotNull(result);
        assertEquals(Appointment.AppointmentStatus.CHECKED_IN, appt.getStatus());
    }
}
