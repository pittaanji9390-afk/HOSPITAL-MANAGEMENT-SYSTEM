package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurgicalOrCaseDto {
    private String surgeryCaseId;
    private String patientMrn;
    private String operatingRoomNumber;
    private String primarySurgeonId;
    private String anesthesiologistId;
    private String scheduledProcedureName;
    private String cptCode;
    private LocalDateTime wheelsInTime;
    private LocalDateTime incisionTime;
    private LocalDateTime closureTime;
    private LocalDateTime wheelsOutTime;
    private List<String> implantedUdiBarcodes;
    private double bloodLossMl;
}
