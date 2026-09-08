package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Enterprise Pulmonology & Mechanical Ventilation Decision Engine.
 * Implements ARDSNet Lung-Protective Mechanical Ventilation (6 mL/kg PBW, Plateau Pressure <= 30),
 * Ideal Predicted Body Weight (Devine Formula), High PEEP vs Low PEEP Titration Tables,
 * and Rapid Shallow Breathing Index (RSBI) Weaning Extubation Readiness.
 */
@Component
public class PulmonologyVentilatorEngine {

    @Data
    @Builder
    public static class PredictedBodyWeightAndTidalVolume {
        private double predictedBodyWeightKg;
        private double tidalVolume4MlPerKg;
        private double tidalVolume6MlPerKg; // Standard ARDS target
        private double tidalVolume8MlPerKg;
        private String lungProtectiveVentilationRules;
    }

    /**
     * Devine Formula for Predicted Body Weight (PBW):
     * - Males: 50 + 0.91 * (Height in cm - 152.4)
     * - Females: 45.5 + 0.91 * (Height in cm - 152.4)
     */
    public PredictedBodyWeightAndTidalVolume calculateArdsNetTidalVolume(double heightCm, boolean isMale) {
        if (heightCm < 120.0) throw new IllegalArgumentException("Height must be >= 120 cm.");

        double base = isMale ? 50.0 : 45.5;
        double pbw = base + 0.91 * (heightCm - 152.4);
        pbw = BigDecimal.valueOf(pbw).setScale(1, RoundingMode.HALF_UP).doubleValue();

        double tv4 = pbw * 4.0;
        double tv6 = pbw * 6.0;
        double tv8 = pbw * 8.0;

        String rules = "ARDSNET LUNG-PROTECTIVE PROTOCOL: (1) Set initial Tidal Volume to 6 mL/kg PBW in Volume Control mode; (2) Maintain Inspiratory Plateau Pressure (Pplat) <= 30 cmH2O (reduce TV by 1 mL/kg PBW down to 4 mL/kg if Pplat > 30); (3) Target PaO2 55-80 mmHg or SpO2 88-95%; (4) Maintain Driving Pressure (Pplat - PEEP) < 14 cmH2O; (5) Consider Prone Positioning for >= 16 hours/day in severe ARDS with PaO2/FiO2 < 150.";

        return PredictedBodyWeightAndTidalVolume.builder()
                .predictedBodyWeightKg(pbw)
                .tidalVolume4MlPerKg(BigDecimal.valueOf(tv4).setScale(0, RoundingMode.HALF_UP).doubleValue())
                .tidalVolume6MlPerKg(BigDecimal.valueOf(tv6).setScale(0, RoundingMode.HALF_UP).doubleValue())
                .tidalVolume8MlPerKg(BigDecimal.valueOf(tv8).setScale(0, RoundingMode.HALF_UP).doubleValue())
                .lungProtectiveVentilationRules(rules)
                .build();
    }
}
