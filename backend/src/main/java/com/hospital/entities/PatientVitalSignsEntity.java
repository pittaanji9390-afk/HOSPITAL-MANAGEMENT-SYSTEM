package com.hospital.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_vital_signs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientVitalSignsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String patientMrn;

    @Column(length = 64)
    private String encounterUuid;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    private Double systolicBloodPressure;
    private Double diastolicBloodPressure;
    private Integer heartRateBpm;
    private Integer respiratoryRateBpm;
    private Double bodyTemperatureCelsius;
    private Double oxygenSaturationPercent;
    private Integer glasgowComaScale;
    private Double supplementalOxygenLiters;
}
