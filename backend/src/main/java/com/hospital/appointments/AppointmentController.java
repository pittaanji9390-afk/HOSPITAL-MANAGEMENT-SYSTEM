package com.hospital.appointments;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.organization.Department;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import com.hospital.staff.DoctorSchedule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.LockModeType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByAppointmentNo(String appointmentNo);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.scheduledDate = :date AND a.status NOT IN ('CANCELLED', 'RESCHEDULED')")
    List<Appointment> findActiveAppointmentsForDoctor(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);

    @Query("SELECT a FROM Appointment a WHERE a.scheduledDate = :date AND a.status = :status")
    List<Appointment> findByScheduledDateAndStatus(@Param("date") LocalDate date, @Param("status") Appointment.AppointmentStatus status);

    @Query("SELECT a FROM Appointment a WHERE a.patient.id = :patientId ORDER BY a.scheduledDate DESC, a.startTime DESC")
    Page<Appointment> findByPatientId(@Param("patientId") Long patientId, Pageable pageable);

    @Query("SELECT a FROM Appointment a WHERE (:doctorId IS NULL OR a.doctor.id = :doctorId) AND " +
           "(:date IS NULL OR a.scheduledDate = :date) AND " +
           "(:status IS NULL OR a.status = :status)")
    Page<Appointment> searchAppointments(
            @Param("doctorId") Long doctorId,
            @Param("date") LocalDate date,
            @Param("status") Appointment.AppointmentStatus status,
            Pageable pageable);

    boolean existsByDoctorIdAndScheduledDateAndStartTimeAndStatusNotIn(
            Long doctorId, LocalDate scheduledDate, LocalTime startTime, List<Appointment.AppointmentStatus> statuses);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AppointmentDto {
    private Long id;
    private String appointmentNo;
    private Long patientId;
    private String patientName;
    private String patientMrn;
    private String patientPhone;
    private Long doctorId;
    private String doctorName;
    private Long departmentId;
    private String departmentName;
    private LocalDate scheduledDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Appointment.AppointmentType type;
    private Appointment.AppointmentStatus status;
    private String reason;
    private String notes;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BookAppointmentRequest {
    @NotNull(message = "Patient ID is required")
    private Long patientId;
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
    @NotNull(message = "Department ID is required")
    private Long departmentId;
    @NotNull(message = "Scheduled date is required")
    private LocalDate scheduledDate;
    @NotNull(message = "Start time is required")
    private LocalTime startTime;
    private Appointment.AppointmentType type;
    private String reason;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SlotDto {
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean available;
}

@Service
@RequiredArgsConstructor
class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<AppointmentDto> getAppointments(Long doctorId, LocalDate date, Appointment.AppointmentStatus status, Pageable pageable) {
        Page<Appointment> page = appointmentRepository.searchAppointments(doctorId, date, status, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public PagedResponse<AppointmentDto> getPatientAppointments(Long patientId, Pageable pageable) {
        Page<Appointment> page = appointmentRepository.findByPatientId(patientId, pageable);
        return PagedResponse.from(page.map(this::toDto));
    }

    @Transactional(readOnly = true)
    public List<SlotDto> getAvailableSlots(Long doctorId, LocalDate date) {
        // Find existing booked appointments on that date
        List<Appointment> booked = appointmentRepository.findActiveAppointmentsForDoctor(doctorId, date);
        List<LocalTime> bookedStartTimes = booked.stream().map(Appointment::getStartTime).toList();

        // Default clinic hours from 09:00 to 17:00 with 15-minute slot intervals
        List<SlotDto> slots = new ArrayList<>();
        LocalTime current = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 0);

        while (current.isBefore(end)) {
            LocalTime next = current.plusMinutes(15);
            boolean isBooked = bookedStartTimes.contains(current);
            slots.add(SlotDto.builder()
                    .startTime(current)
                    .endTime(next)
                    .available(!isBooked)
                    .build());
            current = next;
        }
        return slots;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public AppointmentDto bookAppointment(BookAppointmentRequest request, String createdBy) {
        // Enforce concurrency validation to prevent double booking
        boolean alreadyBooked = appointmentRepository.existsByDoctorIdAndScheduledDateAndStartTimeAndStatusNotIn(
                request.getDoctorId(),
                request.getScheduledDate(),
                request.getStartTime(),
                List.of(Appointment.AppointmentStatus.CANCELLED, Appointment.AppointmentStatus.RESCHEDULED)
        );

        if (alreadyBooked) {
            throw new ConflictException("The selected doctor slot at " + request.getStartTime() + " on " + request.getScheduledDate() + " has already been reserved.");
        }

        Patient patient = entityManager.getReference(Patient.class, request.getPatientId());
        Doctor doctor = entityManager.getReference(Doctor.class, request.getDoctorId());
        Department department = entityManager.getReference(Department.class, request.getDepartmentId());

        String apptNo = sequenceService.getNextNumber("APT_SEQ");
        LocalTime endTime = request.getStartTime().plusMinutes(15);

        Appointment appointment = Appointment.builder()
                .appointmentNo(apptNo)
                .patient(patient)
                .doctor(doctor)
                .department(department)
                .scheduledDate(request.getScheduledDate())
                .startTime(request.getStartTime())
                .endTime(endTime)
                .type(request.getType() != null ? request.getType() : Appointment.AppointmentType.CONSULTATION)
                .status(Appointment.AppointmentStatus.CONFIRMED)
                .reason(request.getReason())
                .build();
        appointment.setCreatedBy(createdBy);

        return toDto(appointmentRepository.save(appointment));
    }

    @Transactional
    public AppointmentDto updateStatus(Long id, Appointment.AppointmentStatus newStatus, String cancellationReason) {
        Appointment appt = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));

        appt.setStatus(newStatus);
        if (cancellationReason != null) {
            appt.setCancellationReason(cancellationReason);
        }
        return toDto(appointmentRepository.save(appt));
    }

    public AppointmentDto toDto(Appointment a) {
        return AppointmentDto.builder()
                .id(a.getId())
                .appointmentNo(a.getAppointmentNo())
                .patientId(a.getPatient().getId())
                .patientName(a.getPatient().getFirstName() + " " + a.getPatient().getLastName())
                .patientMrn(a.getPatient().getMrn())
                .patientPhone(a.getPatient().getPhone())
                .doctorId(a.getDoctor().getId())
                .doctorName("Dr. " + a.getDoctor().getStaff().getFirstName() + " " + a.getDoctor().getStaff().getLastName())
                .departmentId(a.getDepartment().getId())
                .departmentName(a.getDepartment().getName())
                .scheduledDate(a.getScheduledDate())
                .startTime(a.getStartTime())
                .endTime(a.getEndTime())
                .type(a.getType())
                .status(a.getStatus())
                .reason(a.getReason())
                .notes(a.getNotes())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
@Tag(name = "Appointments & Scheduling", description = "Appointment booking, slot management, and check-in workflows")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    @PreAuthorize("hasAuthority('PERM_APPOINTMENT_READ') or hasRole('SUPER_ADMIN') or hasRole('DOCTOR') or hasRole('RECEPTIONIST')")
    @Operation(summary = "Search appointments by doctor, date, and status")
    public ResponseEntity<ApiResponse<PagedResponse<AppointmentDto>>> getAppointments(
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) Appointment.AppointmentStatus status,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(appointmentService.getAppointments(doctorId, date, status, pageable)));
    }

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get historical and upcoming appointments for a patient")
    public ResponseEntity<ApiResponse<PagedResponse<AppointmentDto>>> getPatientAppointments(
            @PathVariable Long patientId,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(appointmentService.getPatientAppointments(patientId, pageable)));
    }

    @GetMapping("/slots")
    @Operation(summary = "Get available doctor appointment slots for a specific date")
    public ResponseEntity<ApiResponse<List<SlotDto>>> getSlots(
            @RequestParam Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(ApiResponse.ok(appointmentService.getAvailableSlots(doctorId, date)));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PERM_APPOINTMENT_WRITE') or hasRole('RECEPTIONIST') or hasRole('DOCTOR') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Book appointment with database concurrency control")
    public ResponseEntity<ApiResponse<AppointmentDto>> bookAppointment(@Valid @RequestBody BookAppointmentRequest request) {
        AppointmentDto booked = appointmentService.bookAppointment(request, "SYSTEM");
        return new ResponseEntity<>(ApiResponse.ok(booked, "Appointment booked successfully"), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Update appointment status (CONFIRMED, CHECKED_IN, IN_CONSULTATION, COMPLETED, CANCELLED, NO_SHOW)")
    public ResponseEntity<ApiResponse<AppointmentDto>> updateStatus(
            @PathVariable Long id,
            @RequestParam Appointment.AppointmentStatus status,
            @RequestParam(required = false) String reason) {
        return ResponseEntity.ok(ApiResponse.ok(appointmentService.updateStatus(id, status, reason), "Appointment status updated"));
    }
}
