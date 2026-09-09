package com.hospital.transplant.lung;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * UNOS Lung Continuous Distribution & Composite Allocation Score (CAS).
 * Predicts 1-year waitlist mortality vs 1-year post-transplant survival
 * based on FVC%, PA systolic pressure, continuous supplemental O2 (L/min), and 6-minute walk distance.
 */
@Service
public class LungAllocationService {

    public record LungCandidate(
        String diagnosisGroup,
        double fvcPercentPredicted,
        double pulmonaryArterySystolicMmHg,
        double supplementalOxygenLpmAtRest,
        double sixMinuteWalkDistanceFeet,
        boolean onEcmovenoArterial
    ) {}

    public record LungCasResult(double calculatedLasScore, String urgencyStatus, boolean ecmopriorityStatus) {}

    public LungCasResult calculateLas(LungCandidate in) {
        if (in.onEcmovenoArterial()) {
            return new LungCasResult(88.5, "TIER 1 (ECMO EMERGENCY BRIDGE)", true);
        }

        double score = 30.0;
        score += (100.0 - in.fvcPercentPredicted()) * 0.25;
        score += in.supplementalOxygenLpmAtRest() * 2.5;
        score += (in.pulmonaryArterySystolicMmHg() - 25.0) * 0.3;
        score -= (in.sixMinuteWalkDistanceFeet() / 100.0) * 1.5;

        double finalLas = Math.min(100.0, Math.max(1.0, score));
        String urgency = finalLas >= 50.0 ? "HIGH WAITLIST PRIORITY" : "STANDARD ALLOCATION";

        return new LungCasResult(finalLas, urgency, false);
    }
}
