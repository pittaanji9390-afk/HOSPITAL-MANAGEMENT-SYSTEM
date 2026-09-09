package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class HasBledAnticoagulationBleedingRisk {

    @Data
    @AllArgsConstructor
    public static class HasBledResult {
        private String patientId;
        private int hasBledScore; // 0 to 9
        private double annualMajorBleedRiskPercent;
        private String riskTier; // LOW (0-1), MODERATE (2), HIGH (>=3)
    }

    public HasBledResult calculateHasBled(String patientId, boolean htn, boolean renalDisease, boolean liverDisease, boolean priorStroke, boolean priorBleeding, boolean labileInr, int age, boolean drugsOrAlcohol) {
        int score = 0;
        if (htn) score++;
        if (renalDisease) score++;
        if (liverDisease) score++;
        if (priorStroke) score++;
        if (priorBleeding) score++;
        if (labileInr) score++;
        if (age >= 65) score++;
        if (drugsOrAlcohol) score++;

        double bleedRisk = score >= 5 ? 12.5 : score == 4 ? 8.7 : score == 3 ? 5.8 : score == 2 ? 4.1 : score == 1 ? 2.4 : 1.1;
        String tier = score >= 3 ? "HIGH BLEEDING RISK (Caution & Frequent Review)" : score == 2 ? "MODERATE RISK" : "LOW RISK";

        return new HasBledResult(patientId, score, bleedRisk, tier);
    }
}
