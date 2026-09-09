package com.hospital.pain;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class OpioidMmeCalculatorService {

    public static record MmeResult(
            String patientId,
            double totalDailyMme,
            boolean overdoseRiskWarning, // >= 50 MME/day requires caution; >= 90 MME/day avoid or justify
            boolean coPrescribedBenzodiazepine,
            boolean naloxonePrescriptionMandatory,
            Instant calculatedAt
    ) implements Serializable {}

    public MmeResult calculateMme(String patientId, double oxycodoneMg, double hydromorphoneMg, double fentanylMcgHr, boolean benzo) {
        // Conversion factors: Oxycodone=1.5, Hydromorphone=4.0, Fentanyl patch=2.4 per mcg/hr
        double totalMme = (oxycodoneMg * 1.5) + (hydromorphoneMg * 4.0) + (fentanylMcgHr * 2.4);
        boolean highRisk = totalMme >= 50.0 || benzo;
        boolean naloxone = totalMme >= 50.0 || benzo;

        return new MmeResult(patientId, Math.round(totalMme), highRisk, benzo, naloxone, Instant.now());
    }
}
