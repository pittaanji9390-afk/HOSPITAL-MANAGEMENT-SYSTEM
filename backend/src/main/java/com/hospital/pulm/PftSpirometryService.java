package com.hospital.pulm;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class PftSpirometryService {

    public enum PftPattern { NORMAL, OBSTRUCTIVE, RESTRICTIVE, MIXED }

    public static record SpirometryResult(
            String testId,
            String patientId,
            double fev1Liters,
            double fev1PercentPredicted,
            double fvcLiters,
            double fev1FvcRatioPercent,
            double dlcoPercentPredicted,
            PftPattern pattern,
            String goldCopdStage, // GOLD 1-4
            Instant evaluatedAt
    ) implements Serializable {}

    public SpirometryResult evaluatePft(String testId, String patientId, double fev1, double fev1Pred, double fvc, double ratio, double dlco) {
        PftPattern pattern;
        if (ratio < 70.0) {
            pattern = (dlco < 80.0) ? PftPattern.MIXED : PftPattern.OBSTRUCTIVE;
        } else if (fvc < 80.0) {
            pattern = PftPattern.RESTRICTIVE;
        } else {
            pattern = PftPattern.NORMAL;
        }

        String gold;
        if (ratio >= 70.0) gold = "Non-COPD";
        else if (fev1Pred >= 80.0) gold = "GOLD 1 (Mild)";
        else if (fev1Pred >= 50.0) gold = "GOLD 2 (Moderate)";
        else if (fev1Pred >= 30.0) gold = "GOLD 3 (Severe)";
        else gold = "GOLD 4 (Very Severe)";

        return new SpirometryResult(testId, patientId, fev1, fev1Pred, fvc, ratio, dlco, pattern, gold, Instant.now());
    }
}
