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
public class LaboratoryResultReportDto {
    private String accessionNumber;
    private String patientMrn;
    private String loincCode;
    private String testName;
    private String quantitativeValue;
    private String units;
    private String referenceInterval;
    private String flag; // NORMAL, HIGH, LOW, PANIC_CRITICAL
    private LocalDateTime specimenCollectionTime;
    private LocalDateTime resultedTime;
    private String pathologistSignoff;
}
