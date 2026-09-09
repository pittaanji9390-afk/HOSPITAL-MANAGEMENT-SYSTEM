package com.hospital.transplant.allocation;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * UNOS / OPTN MELD-Na (Model for End-Stage Liver Disease with Serum Sodium) Calculator.
 * Used for organ allocation priority in deceased donor liver transplantation (OPTN Policy 9).
 */
@Service
public class MeldNaAllocationService {

    public record MeldNaInput(
        double serumBilirubinMgDl,
        double inr,
        double serumCreatinineMgDl,
        double serumSodiumMeqL,
        boolean onDialysisTwicePastWeek
    ) {}

    public record MeldNaResult(
        int rawMeldScore,
        int meldNaScore,
        double estimated90DayMortalityPercent,
        String unosTierPriority
    ) {}

    public MeldNaResult calculateMeldNa(MeldNaInput in) {
        double bili = Math.max(1.0, in.serumBilirubinMgDl());
        double inrVal = Math.max(1.0, in.inr());
        double cr = in.onDialysisTwicePastWeek() ? 4.0 : Math.min(4.0, Math.max(1.0, in.serumCreatinineMgDl()));
        double na = Math.min(137.0, Math.max(125.0, in.serumSodiumMeqL()));

        // Standard MELD formula
        double rawMeld = (0.957 * Math.log(cr)) + (0.378 * Math.log(bili)) + (1.120 * Math.log(inrVal)) + 0.643;
        rawMeld = Math.round(rawMeld * 10.0);

        int finalScore;
        if (rawMeld > 11) {
            double meldNa = rawMeld + 1.32 * (137.0 - na) - (0.033 * rawMeld * (137.0 - na));
            finalScore = (int) Math.min(40.0, Math.max(6.0, Math.round(meldNa)));
        } else {
            finalScore = (int) Math.min(40.0, Math.max(6.0, rawMeld));
        }

        double mortality;
        if (finalScore >= 40) mortality = 71.3;
        else if (finalScore >= 30) mortality = 52.6;
        else if (finalScore >= 20) mortality = 19.6;
        else if (finalScore >= 10) mortality = 6.0;
        else mortality = 1.9;

        String tier = finalScore >= 35 ? "STATUS 1B / TIER 1 (CRITICAL)" : finalScore >= 25 ? "TIER 2 (HIGH URGENCY)" : "TIER 3 (ROUTINE WAITLIST)";

        return new MeldNaResult((int) rawMeld, finalScore, mortality, tier);
    }
}
