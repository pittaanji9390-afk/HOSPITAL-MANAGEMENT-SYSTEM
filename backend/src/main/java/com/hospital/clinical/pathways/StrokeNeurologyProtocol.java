package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Acute Stroke & Neuro-Vascular Emergency Protocol.
 * Implements AHA/ASA Guidelines for the Early Management of Patients with Acute Ischemic Stroke.
 */
@Component
public class StrokeNeurologyProtocol {

    @Data
    @Builder
    public static class NihssInput {
        private int locConsciousness;       // 0-3: 1a Level of Consciousness
        private int locQuestions;           // 0-2: 1b LOC Questions (Month and Age)
        private int locCommands;            // 0-2: 1c LOC Commands (Open/Close eyes, Grip/Release)
        private int bestGaze;               // 0-2: 2 Horizontal extraocular movements
        private int visualFields;           // 0-3: 3 Visual field confrontation
        private int facialPalsy;            // 0-3: 4 Facial symmetry
        private int motorArmLeft;           // 0-4: 5a Left Arm drift (10 seconds)
        private int motorArmRight;          // 0-4: 5b Right Arm drift
        private int motorLegLeft;           // 0-4: 6a Left Leg drift (5 seconds)
        private int motorLegRight;          // 0-4: 6b Right Leg drift
        private int limbAtaxia;             // 0-2: 7 Finger-to-nose and Heel-to-shin
        private int sensoryLoss;            // 0-2: 8 Pinprick sensation
        private int bestLanguage;           // 0-3: 9 Aphasia assessment (Cookie theft picture)
        private int dysarthria;             // 0-2: 10 Speech clarity (Mama, Tip-top, 50-50)
        private int extinctionInattention;  // 0-2: 11 Visual / tactile neglect
    }

    @Data
    @Builder
    public static class NihssResult {
        private int totalScore; // 0 to 42
        private String severityClassification; // NO_STROKE, MINOR, MODERATE, MODERATE_TO_SEVERE, SEVERE
        private boolean largeVesselOcclusionSuspected; // NIHSS >= 6
        private String thrombolysisCandidateAssessment;
    }

    public NihssResult evaluateNihss(NihssInput in) {
        int total = in.getLocConsciousness() + in.getLocQuestions() + in.getLocCommands() +
                    in.getBestGaze() + in.getVisualFields() + in.getFacialPalsy() +
                    in.getMotorArmLeft() + in.getMotorArmRight() + in.getMotorLegLeft() + in.getMotorLegRight() +
                    in.getLimbAtaxia() + in.getSensoryLoss() + in.getBestLanguage() +
                    in.getDysarthria() + in.getExtinctionInattention();

        String severity;
        if (total >= 21) {
            severity = "SEVERE_STROKE";
        } else if (total >= 16) {
            severity = "MODERATE_TO_SEVERE_STROKE";
        } else if (total >= 5) {
            severity = "MODERATE_STROKE";
        } else if (total >= 1) {
            severity = "MINOR_STROKE";
        } else {
            severity = "NO_STROKE_SYMPTOMS";
        }

        boolean lvo = total >= 6;

        String thrombolysisAdvice;
        if (total >= 4 && total <= 25) {
            thrombolysisAdvice = "Strong candidate for IV thrombolysis if within 4.5 hours of Last Known Well (LKW) and no contraindications.";
        } else if (total > 25) {
            thrombolysisAdvice = "High severity stroke. High risk of hemorrhagic transformation; weigh benefits vs risk carefully.";
        } else {
            thrombolysisAdvice = "Low NIHSS (< 4). Assess for disabling neurological deficits before administering thrombolysis.";
        }

        return NihssResult.builder()
                .totalScore(total)
                .severityClassification(severity)
                .largeVesselOcclusionSuspected(lvo)
                .thrombolysisCandidateAssessment(thrombolysisAdvice)
                .build();
    }

    /**
     * Calculates Alteplase (rtPA) dosing:
     * Total Dose: 0.9 mg/kg (Maximum 90 mg)
     * Bolus: 10% of total dose given over 1 minute
     * Infusion: 90% of total dose infused over 60 minutes
     */
    @Data
    @Builder
    public static class AlteplaseDose {
        private BigDecimal totalDoseMg;
        private BigDecimal ivBolusMg;
        private BigDecimal ivInfusionMg;
        private boolean maxDoseCapped;
    }

    public AlteplaseDose calculateAlteplaseDosing(double patientWeightKg) {
        double rawTotal = patientWeightKg * 0.90;
        boolean capped = false;
        if (rawTotal > 90.0) {
            rawTotal = 90.0;
            capped = true;
        }

        BigDecimal total = BigDecimal.valueOf(rawTotal).setScale(1, RoundingMode.HALF_UP);
        BigDecimal bolus = total.multiply(BigDecimal.valueOf(0.10)).setScale(1, RoundingMode.HALF_UP);
        BigDecimal infusion = total.subtract(bolus);

        return AlteplaseDose.builder()
                .totalDoseMg(total)
                .ivBolusMg(bolus)
                .ivInfusionMg(infusion)
                .maxDoseCapped(capped)
                .build();
    }
}
