package com.hospital.genetics.lynch;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Lynch Syndrome (Hereditary Nonpolyposis Colorectal Cancer HNPCC) Clinical Evaluator.
 * Evaluates:
 * 1. Amsterdam II Criteria (3-2-1 Rule: 3 affected relatives, 2 successive generations, 1 diagnosed < age 50).
 * 2. Revised Bethesda Guidelines for Microsatellite Instability (MSI) / IHC tumor testing.
 * 3. MLH1 Promoter Hypermethylation & BRAF V600E reflex to differentiate sporadic vs germline.
 */
@Service
public class LynchSyndromeEvaluatorService {

    public record FamilyHistory(
        int relativesWithLynchCancers, // CRC, Endometrial, Ovarian, Gastric, Small Bowel, Urothelial
        int successiveGenerationsAffected,
        boolean atLeastOneDiagnosedUnder50,
        boolean fapExcluded
    ) {}

    public record MmrIhcProfile(boolean mlh1Lost, boolean pms2Lost, boolean msh2Lost, boolean msh6Lost, boolean brafV600eMutated, boolean mlh1PromoterHypermethylated) {}

    public record LynchAssessment(boolean meetsAmsterdamII, boolean germlineGeneticTestingMandated, String recommendedNextDiagnosticStep) {}

    public LynchAssessment evaluate(FamilyHistory fam, MmrIhcProfile ihc) {
        boolean amsterdam2 = (fam.relativesWithLynchCancers() >= 3 && fam.successiveGenerationsAffected() >= 2 && fam.atLeastOneDiagnosedUnder50() && fam.fapExcluded());

        boolean isSporadicMlh1 = (ihc.mlh1Lost() && ihc.pms2Lost()) && (ihc.brafV600eMutated() || ihc.mlh1PromoterHypermethylated());
        boolean germlineIndicated = amsterdam2 || (ihc.msh2Lost() || ihc.msh6Lost()) || ((ihc.mlh1Lost() && ihc.pms2Lost()) && !isSporadicMlh1);

        String nextStep;
        if (isSporadicMlh1) {
            nextStep = "Likely Sporadic CRC: BRAF V600E / MLH1 promoter methylation confirmed. Germline sequencing not routinely indicated.";
        } else if (germlineIndicated) {
            nextStep = "Mandatory Germline Multi-Gene NGS Panel (MLH1, MSH2, MSH6, PMS2, EPCAM) + Genetic Counseling + Colonoscopy Q1-2Y starting age 20-25.";
        } else {
            nextStep = "Standard Population Screening or Enhanced Family Risk surveillance.";
        }

        return new LynchAssessment(amsterdam2, germlineIndicated, nextStep);
    }
}
