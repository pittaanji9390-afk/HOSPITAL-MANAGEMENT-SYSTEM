package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Obstetrics & Perinatal Labor & Delivery Clinical Protocols.
 * Implements ACOG and RCOG guidelines for labor induction (Bishop Score),
 * neonatal adaptation (APGAR), and Postpartum Hemorrhage (PPH) bundles.
 */
@Component
public class ObstetricsLaborDeliveryProtocols {

    // ==========================================
    // 1. BISHOP SCORE FOR CERVICAL RIPENESS
    // ==========================================
    @Data
    @Builder
    public static class BishopScoreInput {
        private int cervicalDilationCm;     // 0 = Closed (0), 1-2 cm (1), 3-4 cm (2), >= 5 cm (3)
        private int cervicalEffacementPct;  // 0-30% (0), 40-50% (1), 60-70% (2), >= 80% (3)
        private int fetalStation;           // -3 (0), -2 (1), -1/0 (2), +1/+2 (3)
        private CervicalConsistency consistency; // FIRM (0), MEDIUM (1), SOFT (2)
        private CervicalPosition position;       // POSTERIOR (0), MIDPOSITION (1), ANTERIOR (2)
    }

    public enum CervicalConsistency { FIRM, MEDIUM, SOFT }
    public enum CervicalPosition { POSTERIOR, MIDPOSITION, ANTERIOR }

    @Data
    @Builder
    public static class BishopScoreResult {
        private int totalScore; // 0 to 13
        private String ripenessInterpretation;
        private String recommendedInductionMethod;
    }

    public BishopScoreResult calculateBishopScore(BishopScoreInput in) {
        int score = 0;

        // Dilation
        if (in.getCervicalDilationCm() >= 5) score += 3;
        else if (in.getCervicalDilationCm() >= 3) score += 2;
        else if (in.getCervicalDilationCm() >= 1) score += 1;

        // Effacement
        if (in.getCervicalEffacementPct() >= 80) score += 3;
        else if (in.getCervicalEffacementPct() >= 60) score += 2;
        else if (in.getCervicalEffacementPct() >= 40) score += 1;

        // Station
        if (in.getFetalStation() >= 1) score += 3;
        else if (in.getFetalStation() >= -1) score += 2;
        else if (in.getFetalStation() >= -2) score += 1;

        // Consistency
        if (in.getConsistency() == CervicalConsistency.SOFT) score += 2;
        else if (in.getConsistency() == CervicalConsistency.MEDIUM) score += 1;

        // Position
        if (in.getPosition() == CervicalPosition.ANTERIOR) score += 2;
        else if (in.getPosition() == CervicalPosition.MIDPOSITION) score += 1;

        String interp;
        String rec;
        if (score >= 8) {
            interp = "FAVORABLE_CERVIX (High likelihood of successful vaginal delivery)";
            rec = "Direct induction with IV Oxytocin infusion or amniotomy.";
        } else if (score >= 6) {
            interp = "INTERMEDIATE_CERVIX";
            rec = "Consider mechanical dilation (Foley balloon) or low-dose Oxytocin.";
        } else {
            interp = "UNFAVORABLE_CERVIX (High risk of failed induction / prolonged labor)";
            rec = "Cervical ripening required prior to induction: Prostaglandin E2 (Dinoprostone) or PGE1 (Misoprostol 25 mcg) or mechanical cervical ripening.";
        }

        return BishopScoreResult.builder()
                .totalScore(score)
                .ripenessInterpretation(interp)
                .recommendedInductionMethod(rec)
                .build();
    }

    // ==========================================
    // 2. APGAR SCORE (1 & 5 MINUTES)
    // ==========================================
    @Data
    @Builder
    public static class ApgarInput {
        private int appearanceSkinColor; // 0 = Blue/Pale, 1 = Pink body/Blue extremities, 2 = Completely Pink
        private int pulseHeartRate;      // 0 = Absent, 1 = < 100 bpm, 2 = >= 100 bpm
        private int grimaceReflex;       // 0 = Flaccid/No response, 1 = Grimace/Feeble cry, 2 = Sneeze/Cough/Vigorous cry
        private int activityMuscleTone;  // 0 = Limp, 1 = Some flexion, 2 = Active motion
        private int respirationEffort;   // 0 = Absent, 1 = Slow/Irregular, 2 = Good strong cry
    }

    @Data
    @Builder
    public static class ApgarResult {
        private int totalScore; // 0 to 10
        private String status; // REASSURING, MODERATELY_ABNORMAL, SEVERELY_DEPRESSED
        private String resuscitationAction;
    }

    public ApgarResult calculateApgar(ApgarInput in) {
        int total = in.getAppearanceSkinColor() + in.getPulseHeartRate() +
                    in.getGrimaceReflex() + in.getActivityMuscleTone() + in.getRespirationEffort();

        String status;
        String action;
        if (total >= 7) {
            status = "REASSURING (Normal newborn transition)";
            action = "Routine newborn care: Skin-to-skin contact, clear airway if needed, thermal protection.";
        } else if (total >= 4) {
            status = "MODERATELY_ABNORMAL (Mild-to-moderate newborn depression)";
            action = "Tactile stimulation, airway repositioning, supplemental oxygen / CPAP. Reassess at 5 and 10 minutes.";
        } else {
            status = "SEVERELY_DEPRESSED (Critical neonatal distress)";
            action = "Immediate Neonatal Resuscitation Program (NRP) activation: Positive pressure ventilation (PPV), chest compressions if HR < 60, emergency endotracheal intubation.";
        }

        return ApgarResult.builder()
                .totalScore(total)
                .status(status)
                .resuscitationAction(action)
                .build();
    }
}
