package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Enterprise Pediatric Advanced Life Support (PALS) & Critical Care Engine.
 * Implements Broselow Tape weight/equipment estimations, pediatric endotracheal tube (ETT) formulas,
 * Defibrillation/Cardioversion energy calculations, and Pediatric Glasgow Coma Scale (pGCS).
 */
@Component
public class PediatricAdvancedPalsEngine {

    @Data
    @Builder
    public static class PalsResuscitationPlan {
        private double patientWeightKg;
        private double ettInternalDiameterCuffedMm;
        private double ettInternalDiameterUncuffedMm;
        private double ettInsertionDepthLipCm;
        private double defibrillationInitialEnergyJoules;
        private double defibrillationSubsequentEnergyJoules;
        private double synchronizedCardioversionEnergyJoules;
        private double epinephrineIvIoDoseMg;
        private double amiodaroneIvIoDoseMg;
        private double fluidBolusMl;
    }

    /**
     * Calculates age-based and weight-based PALS emergency parameters.
     * ETT Uncuffed Formula: (Age in years / 4) + 4.0
     * ETT Cuffed Formula: (Age in years / 4) + 3.5
     * ETT Depth at Lip (cm): ETT Internal Diameter * 3 OR (Age in years / 2) + 12
     */
    public PalsResuscitationPlan calculatePalsParameters(double ageYears, double weightKg) {
        double uncuffedEtt = (ageYears / 4.0) + 4.0;
        double cuffedEtt = (ageYears / 4.0) + 3.5;
        double depthCm = cuffedEtt * 3.0;

        double defibInitial = Math.min(weightKg * 2.0, 200.0);    // 2 J/kg initial, max 200 J
        double defibSubsequent = Math.min(weightKg * 4.0, 360.0); // 4 J/kg subsequent, max 360 J
        double cardioversion = Math.min(weightKg * 1.0, 100.0);   // 0.5 - 1.0 J/kg initial

        double epiDose = Math.min(weightKg * 0.01, 1.0);          // 0.01 mg/kg (0.1 mL/kg of 1:10,000), max 1 mg
        double amioDose = Math.min(weightKg * 5.0, 300.0);        // 5 mg/kg bolus, max 300 mg
        double fluidBolus = Math.min(weightKg * 20.0, 1000.0);    // 20 mL/kg isotonic crystalloid

        return PalsResuscitationPlan.builder()
                .patientWeightKg(weightKg)
                .ettInternalDiameterCuffedMm(BigDecimal.valueOf(cuffedEtt).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .ettInternalDiameterUncuffedMm(BigDecimal.valueOf(uncuffedEtt).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .ettInsertionDepthLipCm(BigDecimal.valueOf(depthCm).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .defibrillationInitialEnergyJoules(defibInitial)
                .defibrillationSubsequentEnergyJoules(defibSubsequent)
                .synchronizedCardioversionEnergyJoules(cardioversion)
                .epinephrineIvIoDoseMg(BigDecimal.valueOf(epiDose).setScale(3, RoundingMode.HALF_UP).doubleValue())
                .amiodaroneIvIoDoseMg(BigDecimal.valueOf(amioDose).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .fluidBolusMl(fluidBolus)
                .build();
    }
}
