package com.hospital.criticalcare.pediatric;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PediatricPim3MortalityRiskCalculator {

    @Data
    @AllArgsConstructor
    public static class Pim3Result {
        private String patientId;
        private double pim3Score;
        private double predictedPicuMortalityPercent;
        private String severityRiskBand;
    }

    public Pim3Result calculatePim3(String patientId, double sbp, double pupillaryReaction, double pao2Fio2, double baseExcess, boolean isVentilated, boolean electiveAdmission, boolean highRiskDiagnosis) {
        double logit = -4.5;
        if (pupillaryReaction == 0) logit += 2.8; // Fixed dilated
        if (isVentilated) logit += 0.8;
        if (highRiskDiagnosis) logit += 1.6;
        if (electiveAdmission) logit -= 1.2;

        double mortality = (1.0 / (1.0 + Math.exp(-logit))) * 100.0;
        String band = mortality >= 20 ? "VERY HIGH RISK (>20%)" : mortality >= 10 ? "HIGH RISK (10-20%)" : "MODERATE/LOW RISK (<10%)";

        return new Pim3Result(patientId, Math.round(logit * 100.0) / 100.0, Math.round(mortality * 10.0) / 10.0, band);
    }
}
