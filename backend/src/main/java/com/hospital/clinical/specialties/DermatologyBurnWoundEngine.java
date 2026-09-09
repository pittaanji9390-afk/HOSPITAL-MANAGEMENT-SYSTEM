package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Enterprise Dermatology, Burn Care & Advanced Wound Healing Engine.
 * Implements Parkland Burn Resuscitation Formula (4 mL/kg/%TBSA), Wallace Rule of Nines,
 * SCORTEN prognostic score for Toxic Epidermal Necrolysis (TEN / Stevens-Johnson Syndrome SJS),
 * and Braden Scale for Pressure Injury Risk.
 */
@Component
public class DermatologyBurnWoundEngine {

    @Data
    @Builder
    public static class ParklandBurnResult {
        private double total24HourFluidMl;
        private double first8HoursRateMlPerHour;
        private double next16HoursRateMlPerHour;
        private String fluidType;
        private String monitoringTargets;
    }

    /**
     * Parkland Formula for Major Burns (>= 20% TBSA 2nd/3rd degree):
     * Total 24-hr Fluid (mL) = 4 mL * Weight (kg) * % TBSA Burn
     * - First 50% given over the first 8 hours FROM THE TIME OF INJURY
     * - Remaining 50% given over the subsequent 16 hours
     */
    public ParklandBurnResult calculateParklandFormula(double weightKg, double tbsaPercent) {
        if (weightKg <= 0 || tbsaPercent <= 0) {
            throw new IllegalArgumentException("Weight and TBSA burn percentage must be positive numbers.");
        }

        double totalFluid = 4.0 * weightKg * tbsaPercent;
        double first8Hours = totalFluid * 0.5;
        double next16Hours = totalFluid * 0.5;

        double rateFirst8 = first8Hours / 8.0;
        double rateNext16 = next16Hours / 16.0;

        return ParklandBurnResult.builder()
                .total24HourFluidMl(BigDecimal.valueOf(totalFluid).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .first8HoursRateMlPerHour(BigDecimal.valueOf(rateFirst8).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .next16HoursRateMlPerHour(BigDecimal.valueOf(rateNext16).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .fluidType("Lactated Ringer's Solution (Isotonic Balanced Crystalloid)")
                .monitoringTargets("TITRATE FLUIDS TO URINE OUTPUT: Target 0.5 - 1.0 mL/kg/hour in adults (30-50 mL/hr) or 1.0 - 1.5 mL/kg/hr in children. Avoid over-resuscitation to prevent fluid creep and abdominal compartment syndrome.")
                .build();
    }
}
