package com.hospital.cathlab.cin;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class MehranRiskCinService {

    public static record CinRiskEvaluation(
            String patientId,
            int mehranRiskScore,
            String riskTier,
            double cinRiskProbabilityPercent,
            double dialysisRiskPercent,
            double maxSafeContrastVolumeMl,
            String hydrationGuideline,
            Instant evaluatedAt
    ) implements Serializable {}

    public CinRiskEvaluation evaluateCinRisk(
            String patientId,
            boolean hypotension,
            boolean iabp,
            boolean chfClassIiiIv,
            int age,
            boolean diabetes,
            double baselineScrMgDl,
            double hematocritPercent,
            double plannedContrastVolumeMl,
            double weightKg,
            boolean female
    ) {
        int score = 0;

        if (hypotension) score += 5;
        if (iabp) score += 5;
        if (chfClassIiiIv) score += 5;
        if (age > 75) score += 4;
        if (diabetes) score += 3;

        if (baselineScrMgDl > 1.5) {
            score += (int) Math.round((baselineScrMgDl - 1.5) * 8.0) + 4;
        }

        if ((female && hematocritPercent < 36.0) || (!female && hematocritPercent < 39.0)) {
            score += 3;
        }

        score += (int) (plannedContrastVolumeMl / 100.0);

        String tier;
        double cinProb;
        double dialysisProb;

        if (score <= 5) {
            tier = "Low Risk (Score <= 5)";
            cinProb = 7.5;
            dialysisProb = 0.04;
        } else if (score <= 10) {
            tier = "Moderate Risk (Score 6 - 10)";
            cinProb = 14.0;
            dialysisProb = 0.12;
        } else if (score <= 15) {
            tier = "High Risk (Score 11 - 15)";
            cinProb = 26.1;
            dialysisProb = 1.09;
        } else {
            tier = "Very High Risk (Score >= 16)";
            cinProb = 57.3;
            dialysisProb = 12.6;
        }

        double maxContrast = (baselineScrMgDl > 0) ? (5.0 * weightKg) / baselineScrMgDl : 300.0;

        StringBuilder hyd = new StringBuilder();
        hyd.append("Pre-hydration: Isotonic Normal Saline (0.9% NaCl) at 1.0 - 1.5 mL/kg/h for 3-12 hours pre-procedure. ");
        hyd.append("Post-hydration: Continue 1.0 mL/kg/h for 6-12 hours post-procedure. ");
        if (score >= 11) {
            hyd.append("HIGH RISK ALERT: Utilize Iso-osmolar contrast (Iodixanol); target contrast volume < ").append(Math.round(maxContrast)).append(" mL.");
        }

        return new CinRiskEvaluation(
                patientId,
                score,
                tier,
                cinProb,
                dialysisProb,
                BigDecimal.valueOf(maxContrast).setScale(1, RoundingMode.HALF_UP).doubleValue(),
                hyd.toString(),
                Instant.now()
        );
    }
}
