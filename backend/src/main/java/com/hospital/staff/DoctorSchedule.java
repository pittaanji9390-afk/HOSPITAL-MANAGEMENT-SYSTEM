package com.hospital.staff;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "doctor_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "day_of_week", nullable = false)
    private int dayOfWeek; // 1 = Monday, 7 = Sunday

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "slot_duration_minutes", nullable = false)
    @Builder.Default
    private int slotDurationMinutes = 15;

    @Column(name = "max_slots", nullable = false)
    @Builder.Default
    private int maxSlots = 20;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}
