package com.hospital.services.cardiology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CardiologyHemodynamicsAndStemiEngine {

    @Data
    @Builder
    public static class StemiDoorToBalloonTriage {
        private String patientId;
        private LocalDateTime symptomOnsetTime;
        private LocalDateTime firstEcgAcquisitionTime;
        private double stElevationMm;
        private String stemiTerritory; // ANTERIOR, INFERIOR, LATERAL, POSTERIOR
        private boolean isCathLabActivated;
        private int estimatedDoorToBalloonMinutes;
        private double timiRiskScore;
        private double graceRiskPercentMortality;
        private String antithromboticProtocol;
    }

    public StemiDoorToBalloonTriage evaluateStemi(String patientId, double stElevation, String territory, int age, boolean hasDiabetes, double systolicBp, int heartRate) {
        double timi = (age >= 75 ? 3 : (age >= 65 ? 2 : 0)) + (hasDiabetes ? 1 : 0) + (systolicBp < 100 ? 3 : 0) + (heartRate > 100 ? 2 : 0) + (stElevation >= 2.0 ? 1 : 0);
        double graceMortality = Math.min(65.0, (age * 0.4) + (heartRate * 0.15) + (systolicBp < 100 ? 15.0 : 2.0));

        return StemiDoorToBalloonTriage.builder()
                .patientId(patientId)
                .symptomOnsetTime(LocalDateTime.now().minusHours(1))
                .firstEcgAcquisitionTime(LocalDateTime.now().minusMinutes(12))
                .stElevationMm(stElevation)
                .stemiTerritory(territory)
                .isCathLabActivated(stElevation >= 1.5)
                .estimatedDoorToBalloonMinutes(55)
                .timiRiskScore(timi)
                .graceRiskPercentMortality(Math.round(graceMortality * 10.0) / 10.0)
                .antithromboticProtocol("Aspirin 325mg chewable STAT + Ticagrelor 180mg loading dose + Unfractionated Heparin 60 U/kg IV bolus.")
                .build();
    }
}
