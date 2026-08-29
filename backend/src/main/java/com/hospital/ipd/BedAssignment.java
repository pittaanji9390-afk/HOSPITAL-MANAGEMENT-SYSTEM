package com.hospital.ipd;

import com.hospital.staff.Doctor;
import com.hospital.staff.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "bed_assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BedAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id", nullable = false)
    private IpdAdmission admission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed;

    @Column(name = "assigned_at", nullable = false)
    @Builder.Default
    private Instant assignedAt = Instant.now();

    @Column(name = "released_at")
    private Instant releasedAt;

    @Column(name = "transfer_reason", columnDefinition = "TEXT")
    private String transferReason;

    @Column(name = "assigned_by", nullable = false, length = 50)
    private String assignedBy;
}

@Entity
@Table(name = "doctor_rounds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class DoctorRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id", nullable = false)
    private IpdAdmission admission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "round_time", nullable = false)
    @Builder.Default
    private Instant roundTime = Instant.now();

    @Column(nullable = false, columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @Column(name = "plan_of_care", columnDefinition = "TEXT")
    private String planOfCare;
}

@Entity
@Table(name = "nursing_notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class NursingNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id", nullable = false)
    private IpdAdmission admission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nurse_id", nullable = false)
    private Staff nurse;

    @Column(nullable = false, length = 20)
    private String shift; // MORNING, EVENING, NIGHT

    @Column(name = "assessment_notes", nullable = false, columnDefinition = "TEXT")
    private String assessmentNotes;

    @Column(name = "actions_taken", columnDefinition = "TEXT")
    private String actionsTaken;

    @Column(name = "recorded_at", nullable = false)
    @Builder.Default
    private Instant recordedAt = Instant.now();
}
