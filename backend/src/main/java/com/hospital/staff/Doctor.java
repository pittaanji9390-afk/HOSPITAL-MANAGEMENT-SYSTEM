package com.hospital.staff;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id", nullable = false, unique = true)
    private Staff staff;

    @Column(name = "license_no", nullable = false, unique = true, length = 50)
    private String licenseNo;

    @Column(nullable = false, length = 100)
    private String specialization;

    @Column(name = "sub_specialization", length = 100)
    private String subSpecialization;

    @Column(name = "consultation_fee", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal consultationFee = BigDecimal.ZERO;

    @Column(name = "follow_up_fee", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal followUpFee = BigDecimal.ZERO;

    @Column(name = "max_daily_patients", nullable = false)
    @Builder.Default
    private int maxDailyPatients = 30;

    @Column(name = "is_available_for_telemed", nullable = false)
    @Builder.Default
    private boolean availableForTelemed = false;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    @Builder.Default
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorSchedule> schedules = new ArrayList<>();
}
