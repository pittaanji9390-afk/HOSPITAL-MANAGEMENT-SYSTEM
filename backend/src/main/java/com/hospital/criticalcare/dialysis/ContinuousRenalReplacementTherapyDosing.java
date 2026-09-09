package com.hospital.criticalcare.dialysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ContinuousRenalReplacementTherapyDosing {

    @Data
    @AllArgsConstructor
    public static class CrrtDosePrescription {
        private String patientId;
        private double deliveredEffluentDoseMlKgHr; // Target 20 - 25 mL/kg/h
        private double filtrationFractionPercent; // Target < 20% to prevent clotted filter
        private boolean isDoseAdequate;
        private String citrateInfusionGuidance;
    }

    public CrrtDosePrescription calculateCrrt(String patientId, double patientWeightKg, double dialysateFlowRateMlHr, double replacementFlowRateMlHr, double netUltrafiltrationMlHr, double bloodFlowRateMlMin) {
        double totalEffluent = dialysateFlowRateMlHr + replacementFlowRateMlHr + netUltrafiltrationMlHr;
        double dose = patientWeightKg > 0 ? totalEffluent / patientWeightKg : 0;

        double plasmaFlowRateMlHr = (bloodFlowRateMlMin * 60.0) * (1.0 - 0.30); // Assuming Hct 30%
        double filtrationFraction = plasmaFlowRateMlHr > 0 ? (replacementFlowRateMlHr + netUltrafiltrationMlHr) / plasmaFlowRateMlHr * 100.0 : 0;

        boolean ok = dose >= 20.0 && dose <= 30.0;
        String guidance = "Maintain post-filter ionized Ca2+ between 0.25 - 0.35 mmol/L with systemic CaCl2 infusion";

        return new CrrtDosePrescription(patientId, Math.round(dose * 10.0) / 10.0, Math.round(filtrationFraction * 10.0) / 10.0, ok, guidance);
    }
}
