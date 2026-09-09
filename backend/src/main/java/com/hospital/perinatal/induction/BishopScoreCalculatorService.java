package com.hospital.perinatal.induction;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * Bishop Score and Modified Bishop Cervical Ripening Evaluation Service
 * Evaluates Dilation, Effacement, Station, Consistency, and Cervical Position for Labor Induction.
 */
@Service
public class BishopScoreCalculatorService {

    public enum CervicalConsistency { FIRM, MEDIUM, SOFT }
    public enum CervicalPosition { POSTERIOR, MIDPOSITION, ANTERIOR }

    public static record BishopEvaluation(
            String patientId,
            int dilationCm,
            int effacementPercent,
            int fetalStation, // -3 to +3
            CervicalConsistency consistency,
            CervicalPosition position,
            int totalBishopScore,
            boolean favorableCervix, // Score >= 8 favorable for Oxytocin induction; < 6 unfavorable (requires ripening)
            String recommendedInductionAgent, // Dinoprostone (Cervidil), Misoprostol (Cytotec), Foley bulb, Oxytocin
            Instant evaluatedAt
    ) implements Serializable {}

    public BishopEvaluation calculateBishopScore(
            String patientId,
            int dilationCm,
            int effacementPercent,
            int station,
            CervicalConsistency consistency,
            CervicalPosition position,
            boolean priorCesareanDelivery
    ) {
        int score = 0;

        // Dilation score
        if (dilationCm >= 5) score += 3;
        else if (dilationCm >= 3) score += 2;
        else if (dilationCm >= 1) score += 1;

        // Effacement score
        if (effacementPercent >= 80) score += 3;
        else if (effacementPercent >= 60) score += 2;
        else if (effacementPercent >= 40) score += 1;

        // Station score (-3 to +3)
        if (station >= 1) score += 3;
        else if (station >= -1) score += 2;
        else if (station >= -2) score += 1;

        // Consistency
        if (consistency == CervicalConsistency.SOFT) score += 2;
        else if (consistency == CervicalConsistency.MEDIUM) score += 1;

        // Position
        if (position == CervicalPosition.ANTERIOR) score += 2;
        else if (position == CervicalPosition.MIDPOSITION) score += 1;

        boolean favorable = score >= 8;
        StringBuilder rec = new StringBuilder();

        if (favorable) {
            rec.append("Favorable Cervix (Bishop >= 8): Direct Oxytocin (Pitocin) infusion protocol + artificial rupture of membranes (AROM) when indicated.");
        } else if (score < 6) {
            if (priorCesareanDelivery) {
                rec.append("Unfavorable Cervix with Prior Cesarean (TOLAC): Mechanical cervical ripening with Double-Balloon / Foley Catheter (30-60 mL) preferred. CONTRAINDICATION: Prostaglandins (Misoprostol / Dinoprostone) strictly contraindicated due to uterine rupture risk.");
            } else {
                rec.append("Unfavorable Cervix (Bishop < 6): Pharmacological ripening with Misoprostol (Cytotec 25 mcg vaginal/buccal q4h) OR Dinoprostone vaginal insert (Cervidil 10 mg), or mechanical Foley bulb.");
            }
        } else {
            rec.append("Intermediate Cervix (Bishop 6-7): Low-dose Oxytocin titration or mechanical Foley balloon ripening.");
        }

        return new BishopEvaluation(
                patientId,
                dilationCm,
                effacementPercent,
                station,
                consistency,
                position,
                score,
                favorable,
                rec.toString(),
                Instant.now()
        );
    }
}
