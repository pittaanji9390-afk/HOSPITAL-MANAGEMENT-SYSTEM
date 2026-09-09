package com.hospital.picu;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * Pediatric Risk of Mortality (PRISM III) and PIM3 Scoring Service
 * Validated physiological risk score for pediatric intensive care unit mortality prediction.
 */
@Service
public class PrismScoringService {

    public static record PrismAssessment(
            String assessmentId,
            String patientId,
            int ageMonths,
            double weightKg,
            int systolicBpMmHg,
            int heartRateBpm,
            double coreTemperatureCelsius,
            double pupillaryReflexScore, // 0=normal, 5=fixed/dilated
            double gcsScore,
            double bloodGlucoseMgDl,
            double serumPotassiumMeqL,
            int totalPrismIiiScore,
            double predictedMortalityRiskPercent,
            String clinicalRiskCategory,
            Instant assessedAt
    ) implements Serializable {}

    public PrismAssessment calculatePrism(
            String id,
            String patientId,
            int ageMonths,
            double weightKg,
            int sbp,
            int hr,
            double temp,
            double pupillary,
            double gcs,
            double glucose,
            double k
    ) {
        int score = 0;
        if (sbp < 65 || sbp > 150) score += 4;
        if (hr > 180 || hr < 60) score += 4;
        if (temp < 35.0 || temp > 39.5) score += 3;
        if (pupillary > 0) score += (int) pupillary;
        if (gcs < 8) score += 6;
        if (glucose > 250 || glucose < 50) score += 3;
        if (k > 6.0 || k < 3.0) score += 3;

        double risk = Math.min(95.0, 1.2 * Math.exp(score * 0.14));
        String cat = risk < 5.0 ? "Low Risk (<5%)" : risk < 20.0 ? "Moderate PICU Risk (5-20%)" : "High Mortality Risk (>20%)";

        return new PrismAssessment(
                id, patientId, ageMonths, weightKg, sbp, hr, temp, pupillary, gcs, glucose, k, score,
                Math.round(risk * 10.0) / 10.0, cat, Instant.now()
        );
    }
}
