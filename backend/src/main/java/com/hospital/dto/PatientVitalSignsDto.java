package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientVitalSignsDto {
    private String patientMrn;
    private String encounterUuid;
    private LocalDateTime timestamp;
    private double systolicBp;
    private double diastolicBp;
    private int heartRate;
    private int respiratoryRate;
    private double temperatureCelsius;
    private double oxygenSaturation;
    private int gcs;
    private double supplementalOxygenLiters;
    private int calculatedNews2Score;
    private String earlyWarningAlertLevel;
}
