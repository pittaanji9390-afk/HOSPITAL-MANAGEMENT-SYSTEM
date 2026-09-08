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
public class BiomedicalDeviceTelemetryDto {
    private String deviceSerialNumber;
    private String deviceType; // VENTILATOR, INFUSION_PUMP, PATIENT_MONITOR, DIALYSIS_MACHINE
    private String assignedBedCode;
    private String patientMrn;
    private LocalDateTime sampleTimestamp;
    private double primaryParameterValue;
    private String parameterUnit;
    private String alertSeverity; // NORMAL, WARNING, CRITICAL_ALARM
    private String alarmMessage;
}
