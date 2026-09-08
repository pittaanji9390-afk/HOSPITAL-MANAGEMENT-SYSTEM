package com.hospital.services.cardiology;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CathLabInterventionRecord {
    private String procedureId;
    private String patientMrn;
    private String operatorPhysicianId;
    private String targetLesionVessel; // LAD, RCA, LCx
    private double preInterventionStenosisPercent;
    private double postInterventionStenosisPercent;
    private String stentModelSerial;
    private double stentDiameterMm;
    private double stentLengthMm;
    private double contrastVolumeMl;
    private double radiationDoseAreaProductGyCm2;
    private LocalDateTime balloonInflationTimestamp;
    private String timiFlowGrade; // TIMI 0, I, II, III
}
