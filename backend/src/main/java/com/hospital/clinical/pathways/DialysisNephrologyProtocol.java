package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Hemodialysis & Renal Replacement Therapy Clinical Protocol Engine.
 * Implements KDOQI guidelines for dialysis adequacy, Ultrafiltration Rate (UFR) safety limits,
 * and Kt/V clearance monitoring.
 */
@Component
public class DialysisNephrologyProtocol {

    @Data
    @Builder
    public static class DialysisPrescription {
        private double preWeightKg;
        private double dryWeightTargetKg;
        private double sessionDurationHours; // e.g. 4.0 hours
        private String dialyzerType; // High-flux Polysulfone
        private int bloodFlowRateMlMin; // 300-400 mL/min
        private int dialysateFlowRateMlMin; // 500-800 mL/min
        private String vascularAccessType; // AV_FISTULA, AV_GRAFT, TUNNELED_CATHETER
        private double heparinBolusUnits;
        private double heparinHourlyUnits;
    }

    @Data
    @Builder
    public static class UltrafiltrationResult {
        private double fluidRemovalTargetLiters; // Pre-weight - Dry weight
        private double ultrafiltrationRateMlKgHr; // mL/kg/hr
        private boolean ufrWithinSafeLimits; // UFR <= 13.0 mL/kg/hr (Reduces mortality & myocardial stunning)
        private String clinicalRecommendation;
    }

    /**
     * Calculates the Ultrafiltration Rate (UFR):
     * Fluid To Remove (mL) = (Pre-weight - Dry weight) x 1000 + Rinseback (e.g. 200 mL)
     * UFR (mL/kg/hr) = Total Fluid to Remove / (Pre-weight x Duration in Hours)
     */
    public UltrafiltrationResult calculateUfr(double preWeightKg, double dryWeightKg, double durationHours) {
        if (preWeightKg <= 0 || dryWeightKg <= 0 || durationHours <= 0) {
            throw new IllegalArgumentException("Weights and duration must be positive numbers");
        }

        double fluidOverloadKg = preWeightKg - dryWeightKg;
        if (fluidOverloadKg < 0) {
            fluidOverloadKg = 0;
        }

        double totalRemovalMl = (fluidOverloadKg * 1000.0) + 200.0; // Adding 200 mL for IV prime / rinseback
        double ufr = totalRemovalMl / (preWeightKg * durationHours);

        boolean safe = ufr <= 13.0;
        String advice;
        if (safe) {
            advice = "UFR is within standard safety thresholds (<= 13 mL/kg/hr). Low risk of intradialytic hypotension.";
        } else {
            advice = "WARNING: UFR exceeds safe threshold (> 13 mL/kg/hr). High risk of intradialytic hypotension and subendocardial ischemia. Consider extending session duration (e.g. 4.5h) or scheduling an extra ultrafiltration session.";
        }

        return UltrafiltrationResult.builder()
                .fluidRemovalTargetLiters(BigDecimal.valueOf(fluidOverloadKg).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .ultrafiltrationRateMlKgHr(BigDecimal.valueOf(ufr).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .ufrWithinSafeLimits(safe)
                .clinicalRecommendation(advice)
                .build();
    }

    /**
     * Daugirdas single-pool Kt/V formula for hemodialysis adequacy:
     * spKt/V = -ln(R - 0.008 x t) + (4 - 3.5 x R) x (UF / W)
     * Target: spKt/V >= 1.2 per session (KDOQI target 1.4)
     */
    public double calculateSinglePoolKtV(double preBunMgDl, double postBunMgDl, double sessionHours, double ultrafiltrationLiters, double postWeightKg) {
        if (preBunMgDl <= 0 || postBunMgDl <= 0 || postWeightKg <= 0) {
            return 0.0;
        }

        double r = postBunMgDl / preBunMgDl;
        double lnTerm = -Math.log(r - (0.008 * sessionHours));
        double ufTerm = (4.0 - (3.5 * r)) * (ultrafiltrationLiters / postWeightKg);
        double ktv = lnTerm + ufTerm;

        return BigDecimal.valueOf(ktv).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
