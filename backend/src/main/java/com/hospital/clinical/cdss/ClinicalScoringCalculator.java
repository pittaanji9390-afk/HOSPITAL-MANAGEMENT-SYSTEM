package com.hospital.clinical.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clinical Decision Support Algorithms & Validated Bedside Scoring Systems.
 */
@Component
public class ClinicalScoringCalculator {

    // ==========================================
    // 1. MODIFIED EARLY WARNING SCORE (MEWS)
    // ==========================================
    @Data
    @Builder
    public static class MewsInput {
        private int systolicBp;
        private int heartRate;
        private int respiratoryRate;
        private double tempCelsius;
        private AvpuScale avpu; // ALERT, REACTS_TO_VOICE, REACTS_TO_PAIN, UNRESPONSIVE
    }

    public enum AvpuScale {
        ALERT, REACTS_TO_VOICE, REACTS_TO_PAIN, UNRESPONSIVE
    }

    @Data
    @Builder
    public static class MewsResult {
        private int totalScore;
        private String riskLevel; // LOW, MEDIUM, HIGH, CRITICAL
        private String clinicalAction;
    }

    public MewsResult calculateMews(MewsInput input) {
        int score = 0;

        // Systolic Blood Pressure
        if (input.getSystolicBp() <= 70) score += 3;
        else if (input.getSystolicBp() <= 80) score += 2;
        else if (input.getSystolicBp() <= 100) score += 1;
        else if (input.getSystolicBp() >= 200) score += 2;

        // Heart Rate
        if (input.getHeartRate() < 40) score += 2;
        else if (input.getHeartRate() <= 50) score += 1;
        else if (input.getHeartRate() >= 130) score += 3;
        else if (input.getHeartRate() >= 111) score += 2;
        else if (input.getHeartRate() >= 101) score += 1;

        // Respiratory Rate
        if (input.getRespiratoryRate() < 9) score += 2;
        else if (input.getRespiratoryRate() >= 30) score += 3;
        else if (input.getRespiratoryRate() >= 21) score += 2;
        else if (input.getRespiratoryRate() >= 15) score += 1;

        // Temperature (°C)
        if (input.getTempCelsius() < 35.0) score += 2;
        else if (input.getTempCelsius() >= 38.5) score += 2;

        // Neurological AVPU
        if (input.getAvpu() == AvpuScale.ALERT) score += 0;
        else if (input.getAvpu() == AvpuScale.REACTS_TO_VOICE) score += 1;
        else if (input.getAvpu() == AvpuScale.REACTS_TO_PAIN) score += 2;
        else if (input.getAvpu() == AvpuScale.UNRESPONSIVE) score += 3;

        String risk;
        String action;
        if (score >= 5) {
            risk = "CRITICAL";
            action = "Trigger Medical Emergency Team (MET) / Rapid Response Team. Immediate bedside evaluation by ICU specialist.";
        } else if (score >= 4) {
            risk = "HIGH";
            action = "Urgent clinical review by attending physician within 30 minutes. Increase monitoring frequency to q1h.";
        } else if (score >= 2) {
            risk = "MEDIUM";
            action = "Inform charge nurse. Increase vital signs monitoring frequency to every 2 to 4 hours.";
        } else {
            risk = "LOW";
            action = "Routine ward observation per standard nursing protocols (q8h).";
        }

        return MewsResult.builder()
                .totalScore(score)
                .riskLevel(risk)
                .clinicalAction(action)
                .build();
    }

    // ==========================================
    // 2. GLASGOW COMA SCALE (GCS)
    // ==========================================
    @Data
    @Builder
    public static class GcsInput {
        private int eyeOpening;    // 1-4
        private int verbalResponse;// 1-5
        private int motorResponse; // 1-6
    }

    @Data
    @Builder
    public static class GcsResult {
        private int totalGcs; // 3 - 15
        private String injuryClassification; // MILD, MODERATE, SEVERE
        private boolean intubationIndicated; // GCS <= 8
    }

    public GcsResult calculateGcs(GcsInput input) {
        int total = Math.max(1, Math.min(4, input.getEyeOpening())) +
                    Math.max(1, Math.min(5, input.getVerbalResponse())) +
                    Math.max(1, Math.min(6, input.getMotorResponse()));

        String injury;
        if (total >= 13) {
            injury = "MILD_BRAIN_INJURY";
        } else if (total >= 9) {
            injury = "MODERATE_BRAIN_INJURY";
        } else {
            injury = "SEVERE_BRAIN_INJURY";
        }

        boolean intubate = total <= 8;

        return GcsResult.builder()
                .totalGcs(total)
                .injuryClassification(injury)
                .intubationIndicated(intubate)
                .build();
    }

    // ==========================================
    // 3. CURB-65 PNEUMONIA SEVERITY SCORE
    // ==========================================
    @Data
    @Builder
    public static class Curb65Input {
        private boolean confusion;             // Abbreviated Mental Test <= 8 or new disorientation
        private double ureaMmolPerL;           // BUN > 7 mmol/L (19 mg/dL)
        private int respiratoryRate;           // >= 30 breaths/min
        private int systolicBp;                // < 90 mmHg
        private int diastolicBp;               // <= 60 mmHg
        private int age;                       // >= 65 years
    }

    @Data
    @Builder
    public static class Curb65Result {
        private int score; // 0 - 5
        private String mortalityRisk;
        private String recommendedDisposition; // OUTPATIENT, INPATIENT_WARD, ICU_ADMISSION
    }

    public Curb65Result calculateCurb65(Curb65Input input) {
        int score = 0;
        if (input.isConfusion()) score++;
        if (input.getUreaMmolPerL() > 7.0) score++;
        if (input.getRespiratoryRate() >= 30) score++;
        if (input.getSystolicBp() < 90 || input.getDiastolicBp() <= 60) score++;
        if (input.getAge() >= 65) score++;

        String risk;
        String disposition;
        if (score >= 3) {
            risk = "HIGH (17.0% - 30.0% 30-day mortality)";
            disposition = "Urgent Inpatient Admission; assess for Intensive Care Unit (ICU).";
        } else if (score == 2) {
            risk = "INTERMEDIATE (9.2% 30-day mortality)";
            disposition = "Short Inpatient Stay or closely supervised outpatient monitoring.";
        } else {
            risk = "LOW (0.7% - 2.1% 30-day mortality)";
            disposition = "Suitable for Outpatient Management with oral antimicrobials.";
        }

        return Curb65Result.builder()
                .score(score)
                .mortalityRisk(risk)
                .recommendedDisposition(disposition)
                .build();
    }

    // ==========================================
    // 4. CKD-EPI 2021 eGFR CALCULATOR
    // ==========================================
    public BigDecimal calculateEgfrCkdEpi(double serumCreatinineMgDl, int ageYears, boolean isFemale) {
        double k = isFemale ? 0.7 : 0.9;
        double a = isFemale ? -0.241 : -0.302;
        double scrOverK = serumCreatinineMgDl / k;
        double minPart = Math.pow(Math.min(scrOverK, 1.0), a);
        double maxPart = Math.pow(Math.max(scrOverK, 1.0), -1.200);
        double agePart = Math.pow(0.9938, ageYears);
        double genderMultiplier = isFemale ? 1.012 : 1.0;

        double egfr = 142.0 * minPart * maxPart * agePart * genderMultiplier;
        return BigDecimal.valueOf(egfr).setScale(1, RoundingMode.HALF_UP);
    }
}
