package com.hospital.clinical.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Official Royal College of Physicians National Early Warning Score 2 (NEWS2).
 * Standardized assessment for acute illness severity and vital deterioration.
 */
@Component
public class News2EarlyWarningCalculator {

    @Data
    @Builder
    public static class News2Input {
        private int respiratoryRate;
        private int spO2Percent;
        private boolean onOxygenTherapy;
        private double systolicBp;
        private int pulseBpm;
        private String consciousnessLevel; // Alert, CVPU (Confusion, Voice, Pain, Unresponsive)
        private double temperatureCelsius;
        private boolean isHypercapnicRespiratoryFailure; // Scale 2 for COPD target 88-92%
    }

    @Data
    @Builder
    public static class News2Result {
        private int totalScore;
        private String clinicalRiskCategory; // LOW, LOW_MEDIUM, MEDIUM, HIGH
        private String monitoringFrequency;
        private String clinicalResponseGuideline;
    }

    public News2Result calculateNews2(News2Input input) {
        int score = 0;

        // Respiratory rate
        if (input.getRespiratoryRate() <= 8) score += 3;
        else if (input.getRespiratoryRate() <= 11) score += 1;
        else if (input.getRespiratoryRate() <= 20) score += 0;
        else if (input.getRespiratoryRate() <= 24) score += 2;
        else score += 3;

        // SpO2
        if (input.getSpO2Percent() <= 91) score += 3;
        else if (input.getSpO2Percent() <= 93) score += 2;
        else if (input.getSpO2Percent() <= 95) score += 1;

        if (input.isOnOxygenTherapy()) score += 2;

        // Systolic BP
        if (input.getSystolicBp() <= 90) score += 3;
        else if (input.getSystolicBp() <= 100) score += 2;
        else if (input.getSystolicBp() <= 110) score += 1;
        else if (input.getSystolicBp() >= 220) score += 3;

        // Heart rate
        if (input.getPulseBpm() <= 40) score += 3;
        else if (input.getPulseBpm() <= 50) score += 1;
        else if (input.getPulseBpm() <= 90) score += 0;
        else if (input.getPulseBpm() <= 110) score += 1;
        else if (input.getPulseBpm() <= 130) score += 2;
        else score += 3;

        if (!"Alert".equalsIgnoreCase(input.getConsciousnessLevel())) score += 3;

        // Temperature
        if (input.getTemperatureCelsius() <= 35.0) score += 3;
        else if (input.getTemperatureCelsius() <= 36.0) score += 1;
        else if (input.getTemperatureCelsius() <= 38.0) score += 0;
        else if (input.getTemperatureCelsius() <= 39.0) score += 1;
        else score += 2;

        String risk;
        String freq;
        String action;

        if (score >= 7) {
            risk = "HIGH CLINICAL RISK (Score >= 7 or single parameter score of 3)";
            freq = "Continuous real-time telemetry monitoring";
            action = "EMERGENCY RESPONSE: Immediate assessment by Medical Emergency Team (MET) / Critical Care Outreach; prepare for urgent transfer to ICU/HDU.";
        } else if (score >= 5) {
            risk = "MEDIUM CLINICAL RISK (Score 5-6)";
            freq = "Minimum hourly vital sign observations";
            action = "URGENT RESPONSE: Urgent review by attending medical registrar or team with critical care competencies within 30 minutes.";
        } else {
            risk = "LOW CLINICAL RISK (Score 0-4)";
            freq = "Minimum 4-6 hourly observations";
            action = "ROUTINE CLINICAL CARE: Standard ward care; continue scheduled observation cycle.";
        }

        return News2Result.builder()
                .totalScore(score)
                .clinicalRiskCategory(risk)
                .monitoringFrequency(freq)
                .clinicalResponseGuideline(action)
                .build();
    }
}
