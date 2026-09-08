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
public class MedicationOrderRequestDto {
    private String orderId;
    private String patientMrn;
    private String prescribingDoctorId;
    private String rxCui;
    private String medicationName;
    private String doseStrength;
    private String route;
    private String frequencyCode; // Q6H, BID, TID, STAT, PRN
    private int durationDays;
    private String clinicalIndication;
    private boolean isHighAlertMedication;
    private LocalDateTime orderCreatedTime;
}
