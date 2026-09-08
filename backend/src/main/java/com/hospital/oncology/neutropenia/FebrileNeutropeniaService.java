package com.hospital.oncology.neutropenia;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Multinational Association for Supportive Care in Cancer (MASCC) & ASCO Febrile Neutropenia Score.
 * Score >= 21: Low risk for serious complications (Eligible for outpatient oral Ciprofloxacin + Augmentin).
 * Score < 21: High risk (Mandates emergency inpatient IV Cefepime / Meropenem / Pip-Tazo).
 */
@Service
public class FebrileNeutropeniaService {

    public record MasccCriteria(
        int burdenOfIllnessScore, // 5 = None/Mild, 3 = Moderate, 0 = Severe
        boolean noHypotension, // 5 pts
        boolean noCopd, // 4 pts
        boolean solidTumorOrNoPriorFungalInfection, // 4 pts
        boolean noDehydration, // 3 pts
        boolean outpatientAtFeverOnset, // 3 pts
        boolean ageUnder60 // 2 pts
    ) {}

    public record MasccEvaluation(int totalScore, boolean isLowRiskOutpatientEligible, String recommendedAntibioticRegimen, String gcsfRecommendation) {}

    public MasccEvaluation calculateMascc(MasccCriteria c) {
        int score = c.burdenOfIllnessScore();
        if (c.noHypotension()) score += 5;
        if (c.noCopd()) score += 4;
        if (c.solidTumorOrNoPriorFungalInfection()) score += 4;
        if (c.noDehydration()) score += 3;
        if (c.outpatientAtFeverOnset()) score += 3;
        if (c.ageUnder60()) score += 2;

        boolean lowRisk = score >= 21;
        String abx = lowRisk ? "Outpatient Oral: Ciprofloxacin 750mg BID + Amoxicillin/Clavulanate 875mg BID with 24-hr follow-up" : "Inpatient IV Monotherapy: Cefepime 2g IV Q8H or Piperacillin-Tazobactam 4.5g IV Q6H within 60 min";
        String gcsf = "Evaluate G-CSF (Filgrastim 5mcg/kg/day or Pegfilgrastim 6mg) if high risk of prolonged severe neutropenia (ANC < 100 /mcL > 7 days).";

        return new MasccEvaluation(score, lowRisk, abx, gcsf);
    }
}
