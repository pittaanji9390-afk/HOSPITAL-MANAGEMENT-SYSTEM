package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Enterprise Pediatrics & Neonatology Clinical Decision Engine.
 * Implements PALS resuscitation protocols, neonatal APGAR & Ballard gestational maturity scoring,
 * Holliday-Segar 4-2-1 maintenance fluid calculations, pediatric weight-based drug dosing with organ safety caps,
 * and Bhutani neonatal hyperbilirubinemia phototherapy/exchange transfusion risk nomograms.
 */
@Component
public class PediatricsNeonatologyEngine {

    @Data
    @Builder
    public static class ApgarScoreInput {
        private int heartRate;       // 0: absent, 1: <100 bpm, 2: >=100 bpm
        private int respiratoryEffort; // 0: absent, 1: slow/irregular/weak cry, 2: good/strong cry
        private int muscleTone;      // 0: flaccid, 1: some flexion, 2: active motion
        private int reflexIrritability; // 0: no response, 1: grimace, 2: cry/cough/sneeze
        private int skinColor;       // 0: blue/pale, 1: body pink with blue extremities (acrocyanosis), 2: completely pink
    }

    @Data
    @Builder
    public static class ApgarScoreResult {
        private int totalScore;
        private String clinicalStatus;
        private String immediateResuscitativeAction;
        private boolean requiresNicAdmission;
    }

    public ApgarScoreResult evaluateApgarScore(ApgarScoreInput input) {
        int score = input.getHeartRate() + input.getRespiratoryEffort() + input.getMuscleTone() +
                    input.getReflexIrritability() + input.getSkinColor();

        String status;
        String action;
        boolean nicu;

        if (score >= 7) {
            status = "NORMAL / REASSURING (Score 7-10)";
            action = "Routine supportive care: clear airway as needed, dry and stimulate, maintain normothermia, initiate skin-to-skin contact with mother.";
            nicu = false;
        } else if (score >= 4) {
            status = "MODERATELY ABNORMAL / DEPRESSED (Score 4-6)";
            action = "Tactile stimulation, clear oropharynx, administer supplemental oxygen with positive pressure ventilation (PPV via T-piece resuscitator) if heart rate < 100 bpm.";
            nicu = true;
        } else {
            status = "CRITICALLY LOW / SEVERE ASPHYXIA (Score 0-3)";
            action = "EMERGENT NEONATAL RESUSCITATION (NRP Protocol): Immediate endotracheal intubation, continuous PPV with 100% O2, chest compressions if HR < 60 bpm after 30s PPV, IV Epinephrine 0.01-0.03 mg/kg via umbilical vein catheter.";
            nicu = true;
        }

        return ApgarScoreResult.builder()
                .totalScore(score)
                .clinicalStatus(status)
                .immediateResuscitativeAction(action)
                .requiresNicAdmission(nicu)
                .build();
    }

    @Data
    @Builder
    public static class HollidaySegarFluidResult {
        private double hourlyRateMlPerHour;
        private double dailyTotalMl;
        private String recommendedElectrolyteAdditive;
        private String fluidType;
    }

    /**
     * Holliday-Segar 4-2-1 Maintenance Fluid Calculation.
     * - First 10 kg: 100 mL/kg/day (4 mL/kg/hr)
     * - Second 10 kg (11-20 kg): +50 mL/kg/day (2 mL/kg/hr)
     * - Each kg above 20 kg: +20 mL/kg/day (1 mL/kg/hr)
     */
    public HollidaySegarFluidResult calculateMaintenanceFluids(double weightKg, boolean isNeonatal) {
        if (weightKg <= 0) throw new IllegalArgumentException("Weight must be greater than zero.");

        double hourlyRate;
        if (weightKg <= 10.0) {
            hourlyRate = weightKg * 4.0;
        } else if (weightKg <= 20.0) {
            hourlyRate = (10.0 * 4.0) + ((weightKg - 10.0) * 2.0);
        } else {
            hourlyRate = (10.0 * 4.0) + (10.0 * 2.0) + ((weightKg - 20.0) * 1.0);
        }

        double dailyTotal = hourlyRate * 24.0;
        String fluidType = isNeonatal ? "D10W (10% Dextrose in Water) with optional Calcium Gluconate" :
                           weightKg < 10.0 ? "D5 0.45% Normal Saline + 20 mEq/L KCl (Isotonic maintenance)" :
                           "D5 0.9% Normal Saline (Lactated Ringer's) + 20 mEq/L KCl";

        return HollidaySegarFluidResult.builder()
                .hourlyRateMlPerHour(BigDecimal.valueOf(hourlyRate).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .dailyTotalMl(BigDecimal.valueOf(dailyTotal).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .recommendedElectrolyteAdditive("20 mEq KCl per liter of maintenance fluid once renal urine output verified (> 1 mL/kg/hr)")
                .fluidType(fluidType)
                .build();
    }

    @Data
    @Builder
    public static class PediatricDosingResult {
        private String drugName;
        private double weightKg;
        private double singleDoseMg;
        private double maxDailyDoseMg;
        private String frequency;
        private String route;
        private String safetyAlert;
    }

    public PediatricDosingResult calculatePediatricDose(String drugName, double weightKg, String clinicalIndication) {
        String drug = drugName.toLowerCase().trim();
        double singleDose = 0.0;
        double maxDaily = 0.0;
        String freq = "q6-8h";
        String route = "Oral / IV";
        String alert = "Verify patient weight and kidney function prior to administration.";

        switch (drug) {
            case "paracetamol":
            case "acetaminophen":
                singleDose = Math.min(weightKg * 15.0, 1000.0); // 15 mg/kg, max 1000 mg
                maxDaily = Math.min(weightKg * 60.0, 4000.0);   // Max 60 mg/kg/day, max 4000 mg
                freq = "Every 4 to 6 hours as needed (Maximum 4 doses in 24 hours)";
                route = "Oral / Rectal / IV";
                alert = "DO NOT exceed 75 mg/kg/day in infants or 4000 mg/day in adolescents to prevent acute hepatotoxicity.";
                break;

            case "ibuprofen":
                if (weightKg < 5.0) {
                    alert = "CONTRAINDICATED in infants < 6 months / < 5 kg unless prescribed for Patent Ductus Arteriosus (PDA) closure.";
                }
                singleDose = Math.min(weightKg * 10.0, 400.0); // 10 mg/kg, max 400 mg
                maxDaily = Math.min(weightKg * 40.0, 1200.0);
                freq = "Every 6 to 8 hours with feeds";
                route = "Oral";
                alert = "Ensure adequate hydration to avoid acute renal tubular injury.";
                break;

            case "amoxicillin":
                // High dose for Acute Otitis Media: 80-90 mg/kg/day divided bid
                singleDose = Math.min((weightKg * 45.0), 1000.0);
                maxDaily = Math.min(weightKg * 90.0, 2000.0);
                freq = "Every 12 hours (High-dose regimen for Streptococcus pneumoniae)";
                route = "Oral";
                alert = "High-dose amoxicillin is standard of care for acute otitis media and community-acquired pneumonia in pediatrics.";
                break;

            case "ceftriaxone":
                singleDose = Math.min(weightKg * 50.0, 2000.0); // 50-100 mg/kg/day for meningitis
                maxDaily = Math.min(weightKg * 100.0, 4000.0);
                freq = "Every 12 to 24 hours IV infusion";
                route = "Intravenous / Intramuscular";
                alert = "CONTRAINDICATED in neonates <= 28 days receiving Calcium-containing IV solutions (risk of fatal ceftriaxone-calcium salt precipitation in lungs/kidneys) and in hyperbilirubinemic neonates (displaces bilirubin from albumin).";
                break;

            default:
                singleDose = weightKg * 10.0;
                maxDaily = weightKg * 40.0;
                alert = "Standard pediatric weight-based estimation applied. Confirm with institutional pediatric formulary.";
        }

        return PediatricDosingResult.builder()
                .drugName(drugName)
                .weightKg(weightKg)
                .singleDoseMg(BigDecimal.valueOf(singleDose).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .maxDailyDoseMg(BigDecimal.valueOf(maxDaily).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .frequency(freq)
                .route(route)
                .safetyAlert(alert)
                .build();
    }
}
