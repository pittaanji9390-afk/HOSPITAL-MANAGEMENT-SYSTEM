package com.hospital.genetics.lqts;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Schwartz Diagnostic Criteria for Congenital Long QT Syndrome (LQTS).
 * Score >= 3.5: High probability of LQTS.
 * Genotype classification:
 * - LQT1 (KCNQ1): Exercise / Swimming triggered arrhythmias (Broad T waves).
 * - LQT2 (KCNH2 / HERG): Auditory / Alarm triggered arrhythmias (Notched / low amplitude T waves).
 * - LQT3 (SCN5A): Rest / Sleep triggered arrhythmias (Late onset peaked T waves).
 */
@Service
public class LongQtSchwartzService {

    public record LqtsInput(
        double qtcMs,
        boolean torsadesDePointes,
        boolean tWaveAlternans,
        boolean syncopeWithStress,
        boolean syncopeWithoutStress,
        boolean congenitalDeafness,
        boolean familyMemberDefiniteLqts
    ) {}

    public record LqtsAssessment(double schwartzScore, boolean highProbabilityLqts, String recommendedGeneticSubtyping, String betaBlockerGuidance) {}

    public LqtsAssessment calculateSchwartz(LqtsInput in) {
        double score = 0.0;
        if (in.qtcMs() >= 480.0) score += 3.0;
        else if (in.qtcMs() >= 460.0) score += 2.0;
        else if (in.qtcMs() >= 450.0) score += 1.0;

        if (in.torsadesDePointes()) score += 2.0;
        if (in.tWaveAlternans()) score += 1.0;
        if (in.syncopeWithStress()) score += 2.0;
        else if (in.syncopeWithoutStress()) score += 1.0;
        if (in.congenitalDeafness()) score += 0.5;
        if (in.familyMemberDefiniteLqts()) score += 1.0;

        boolean highProb = score >= 3.5;
        String subtype = highProb ? "Targeted Cardiac Channelopathy NGS Panel: KCNQ1 (LQT1), KCNH2 (LQT2), SCN5A (LQT3)." : "Low to Intermediate Probability.";
        String therapy = highProb ? "Nadolol / Propranolol non-selective beta-blockade + ICD evaluation if prior arrest or QTc > 500ms." : "Clinical monitoring.";

        return new LqtsAssessment(score, highProb, subtype, therapy);
    }
}
