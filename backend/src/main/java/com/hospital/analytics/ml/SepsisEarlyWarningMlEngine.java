package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SepsisEarlyWarningMlEngine {

    @Data
    @AllArgsConstructor
    public static class SepsisRiskPrediction {
        private String patientId;
        private double predictedSepsisProbabilityPercent;
        private String riskTier; // LOW, MODERATE, HIGH, IMMINENT_SEPTIC_SHOCK
        private List<String> topContributingFeatures;
        private double qSofaScore;
        private double lactateVelocityMmPerHr;
        private String clinicalRecommendation;
    }

    public SepsisRiskPrediction predictSepsisRisk(String patientId, double hr, double rr, double sbp, double tempC, double wbcK, double lactate, double baselineLactate) {
        double qSofa = 0;
        if (rr >= 22) qSofa++;
        if (sbp <= 100) qSofa++;

        List<String> contributors = new ArrayList<>();
        double prob = 5.0;

        if (lactate > 2.0) {
            prob += (lactate - 2.0) * 20.0;
            contributors.add("Elevated Serum Lactate (" + lactate + " mmol/L)");
        }
        if (hr > 100) {
            prob += 15.0;
            contributors.add("Tachycardia HR > 100 bpm (" + (int)hr + " bpm)");
        }
        if (rr >= 22) {
            prob += 20.0;
            contributors.add("Tachypnea RR >= 22 bpm (" + (int)rr + " bpm)");
        }
        if (wbcK > 12.0 || wbcK < 4.0) {
            prob += 15.0;
            contributors.add("Leukocytosis/Leukopenia (" + wbcK + " k/uL)");
        }

        prob = Math.min(99.0, Math.max(1.0, prob));
        String tier = prob >= 75 ? "IMMINENT_SEPTIC_SHOCK" : prob >= 50 ? "HIGH" : prob >= 25 ? "MODERATE" : "LOW";
        String rec = prob >= 50 ? "STAT Blood Cultures x2, IV Fluid Resuscitation 30mL/kg, Broad Spectrum Antibiotics within 1 hour" : "Continue routine vital surveillance Q4H";

        return new SepsisRiskPrediction(patientId, prob, tier, contributors, qSofa, lactate - baselineLactate, rec);
    }
}
