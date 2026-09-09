package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Surviving Sepsis Campaign (SSC) & Sepsis-3 International Critical Care Protocol.
 * Standardizes early recognition, 1-hour resuscitation bundle, and septic shock management.
 */
@Component
public class CriticalCareSepsisProtocol {

    @Data
    @Builder
    public static class SepsisScreeningResult {
        private boolean sepsisSuspected;
        private int qSofaScore; // Quick SOFA: RR >= 22 (1), SBP <= 100 (1), GCS < 15 (1)
        private String clinicalClassification; // SEPSIS, SEPTIC_SHOCK, LOW_PROBABILITY
        private List<String> immediateBundleActions;
    }

    /**
     * Evaluates Quick SOFA (qSOFA) criteria at the bedside or triage.
     */
    public SepsisScreeningResult screenQsofa(int respiratoryRate, int systolicBp, int gcsScore, double lactateMmolL, boolean sourceInfectionIdentified) {
        int qsofa = 0;
        if (respiratoryRate >= 22) qsofa++;
        if (systolicBp <= 100) qsofa++;
        if (gcsScore < 15) qsofa++;

        boolean isSepsis = (qsofa >= 2 || lactateMmolL > 2.0) && sourceInfectionIdentified;
        boolean isSepticShock = isSepsis && (systolicBp < 90 || lactateMmolL >= 4.0);

        List<String> bundle = new ArrayList<>();
        if (isSepsis || isSepticShock) {
            bundle.add("1. Measure blood lactate level. Re-measure within 2-4 hours if initial lactate > 2.0 mmol/L.");
            bundle.add("2. Obtain 2 sets of blood cultures (aerobic and anaerobic) prior to initiating antimicrobials.");
            bundle.add("3. Administer broad-spectrum empiric IV antimicrobials within 1 hour of recognition.");
            bundle.add("4. Rapidly administer 30 mL/kg crystalloid fluid bolus (Balanced Crystalloid: Plasmalyte / Ringer's Lactate) for hypotension (MAP < 65) or lactate >= 4.0 mmol/L.");
            bundle.add("5. Apply vasopressors (First-line: Norepinephrine infusion) if patient is hypotensive during or after fluid resuscitation to maintain Mean Arterial Pressure (MAP) >= 65 mmHg.");
        }

        String classification;
        if (isSepticShock) {
            classification = "SEPTIC_SHOCK (High In-Hospital Mortality > 40%)";
        } else if (isSepsis) {
            classification = "SEPSIS (Organ Dysfunction Present)";
        } else {
            classification = "LOW_PROBABILITY";
        }

        return SepsisScreeningResult.builder()
                .sepsisSuspected(isSepsis || isSepticShock)
                .qSofaScore(qsofa)
                .clinicalClassification(classification)
                .immediateBundleActions(bundle)
                .build();
    }
}
