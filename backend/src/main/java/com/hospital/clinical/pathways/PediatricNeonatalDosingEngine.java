package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Pediatric & Neonatal Weight-Based Medication & Fluid Calculation Engine.
 * Implements standard pediatric pharmacotherapy and the Holliday-Segar 4-2-1 maintenance fluid formula.
 */
@Component
public class PediatricNeonatalDosingEngine {

    @Data
    @Builder
    public static class FluidRequirement {
        private double dailyVolumeMl;   // Total mL per 24 hours
        private double hourlyRateMlHr;  // Infusion rate mL/hr
        private String recommendedFluid; // e.g. D5 0.45% NS + 20 mEq KCl
    }

    /**
     * Calculates 24-hour and hourly maintenance fluid requirements using the 4-2-1 Holliday-Segar Formula:
     * - First 10 kg: 100 mL/kg/day (4 mL/kg/hr)
     * - Second 10 kg (11-20 kg): 50 mL/kg/day (2 mL/kg/hr)
     * - Each kg above 20 kg: 20 mL/kg/day (1 mL/kg/hr)
     */
    public FluidRequirement calculateHollidaySegarFluids(double weightKg) {
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }

        double dailyMl = 0.0;
        double hourlyMl = 0.0;

        if (weightKg <= 10.0) {
            dailyMl = weightKg * 100.0;
            hourlyMl = weightKg * 4.0;
        } else if (weightKg <= 20.0) {
            dailyMl = 1000.0 + ((weightKg - 10.0) * 50.0);
            hourlyMl = 40.0 + ((weightKg - 10.0) * 2.0);
        } else {
            dailyMl = 1500.0 + ((weightKg - 20.0) * 20.0);
            hourlyMl = 60.0 + ((weightKg - 20.0) * 1.0);
        }

        String fluidType;
        if (weightKg < 5.0) {
            fluidType = "10% Dextrose in 0.2% Normal Saline (Neonatal maintenance)";
        } else {
            fluidType = "5% Dextrose in 0.45% Normal Saline + 20 mEq/L KCl (Standard pediatric maintenance)";
        }

        return FluidRequirement.builder()
                .dailyVolumeMl(Math.round(dailyMl * 10.0) / 10.0)
                .hourlyRateMlHr(Math.round(hourlyMl * 10.0) / 10.0)
                .recommendedFluid(fluidType)
                .build();
    }

    @Data
    @Builder
    public static class PediatricDoseResult {
        private String medicationName;
        private double singleDoseMg;
        private double totalDailyDoseMg;
        private String frequency;
        private double maxDailyDoseMg;
        private boolean doseExceedsAdultMax;
    }

    /**
     * Calculates weight-based single and daily dose with adult maximum dose capping.
     */
    public PediatricDoseResult calculatePediatricDose(String drugName, double weightKg,
                                                      double mgPerKgPerDose, int dosesPerDay,
                                                      double maxSingleAdultDoseMg) {
        double rawSingle = weightKg * mgPerKgPerDose;
        boolean capped = false;
        if (rawSingle > maxSingleAdultDoseMg) {
            rawSingle = maxSingleAdultDoseMg;
            capped = true;
        }

        double totalDaily = rawSingle * dosesPerDay;

        return PediatricDoseResult.builder()
                .medicationName(drugName)
                .singleDoseMg(BigDecimal.valueOf(rawSingle).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .totalDailyDoseMg(BigDecimal.valueOf(totalDaily).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .frequency(dosesPerDay == 4 ? "Every 6 hours (QID)" : dosesPerDay == 3 ? "Every 8 hours (TID)" : dosesPerDay == 2 ? "Every 12 hours (BID)" : "Once daily")
                .maxDailyDoseMg(maxSingleAdultDoseMg * dosesPerDay)
                .doseExceedsAdultMax(capped)
                .build();
    }
}
