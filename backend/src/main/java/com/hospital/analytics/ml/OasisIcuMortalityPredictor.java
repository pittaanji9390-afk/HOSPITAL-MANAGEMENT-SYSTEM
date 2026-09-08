package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class OasisIcuMortalityPredictor {

    @Data
    @AllArgsConstructor
    public static class OasisScoreResult {
        private String patientId;
        private int totalOasisScore;
        private double predictedHospitalMortalityPercent;
        private String riskStratification;
    }

    public OasisScoreResult calculateOasis(String patientId, int age, int preIcuLosHours, int gcs, double hr, double map, double rr, double tempC, double urine24h, boolean isVentilated, boolean isElectiveSurgery) {
        int score = 0;
        // Age scoring
        if (age >= 86) score += 9;
        else if (age >= 78) score += 7;
        else if (age >= 54) score += 6;
        else if (age >= 24) score += 3;

        // Pre-ICU LOS
        if (preIcuLosHours >= 300) score += 5;
        else if (preIcuLosHours >= 5) score += 3;

        // GCS
        if (gcs <= 7) score += 10;
        else if (gcs <= 13) score += 4;

        // Heart Rate
        if (hr >= 125) score += 6;
        else if (hr >= 107) score += 3;

        // Ventilation
        if (isVentilated) score += 9;

        // Elective surgery reduction
        if (isElectiveSurgery) score -= 6;
        score = Math.max(0, score);

        // Logistic regression mapping to mortality: logit = -4.88 + 0.127 * OASIS
        double logit = -4.88 + 0.127 * score;
        double mortality = (1.0 / (1.0 + Math.exp(-logit))) * 100.0;

        String strat = mortality >= 40 ? "VERY HIGH RISK (>40%)" : mortality >= 20 ? "HIGH RISK (20-40%)" : mortality >= 10 ? "MODERATE RISK (10-20%)" : "LOW RISK (<10%)";

        return new OasisScoreResult(patientId, score, Math.round(mortality * 10.0) / 10.0, strat);
    }
}
