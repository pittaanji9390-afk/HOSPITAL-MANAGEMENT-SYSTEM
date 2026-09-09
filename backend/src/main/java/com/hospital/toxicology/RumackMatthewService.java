package com.hospital.toxicology;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class RumackMatthewService {

    public static record ApapEvaluation(
            String patientId,
            double hoursPostIngestion,
            double serumApapConcentrationUgMl,
            boolean aboveTreatmentLine, // 150 ug/mL at 4 hours line
            String antidoteProtocol,
            Instant evaluatedAt
    ) implements Serializable {}

    public ApapEvaluation evaluateIngestion(String patientId, double hours, double level) {
        if (hours < 4.0) {
            return new ApapEvaluation(patientId, hours, level, false, "Repeat APAP level at 4 hours post-ingestion for accurate nomogram plotting.", Instant.now());
        }

        // Treatment line: Level = 150 * (0.5 ^ ((hours - 4) / 4))
        double treatmentThreshold = 150.0 * Math.pow(0.5, (hours - 4.0) / 4.0);
        boolean treat = level >= treatmentThreshold;

        String rx = treat
                ? "ABOVE TREATMENT LINE: Initiate IV N-Acetylcysteine (NAC) 3-bag protocol: 150 mg/kg in 200 mL over 1h, then 50 mg/kg in 500 mL over 4h, then 100 mg/kg in 1000 mL over 16h."
                : "BELOW TREATMENT LINE: Hepatotoxicity unlikely; continue clinical observation.";

        return new ApapEvaluation(patientId, hours, level, treat, rx, Instant.now());
    }
}
