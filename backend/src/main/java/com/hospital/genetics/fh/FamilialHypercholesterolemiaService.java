package com.hospital.genetics.fh;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Dutch Lipid Clinic Network (DLCN) Diagnostic Criteria for Familial Hypercholesterolemia (FH).
 * Evaluates Family History, Clinical History (Premature CAD), Physical Exam (Tendon Xanthomas, Arcus Cornealis < 45y),
 * Untreated LDL-C levels, and Molecular Testing (LDLR, APOB, PCSK9 mutations).
 * Score > 8: Definite FH; 6-8: Probable FH; 3-5: Possible FH; < 3: Unlikely.
 */
@Service
public class FamilialHypercholesterolemiaService {

    public record FhInput(
        boolean firstDegreePrematureCad,
        boolean tendonXanthomas,
        boolean arcusCornealisUnder45,
        double untreatedLdlCMgDl,
        boolean causativeMutationIdentified
    ) {}

    public record FhDiagnosis(int dlcnScore, String diagnosticCategory, boolean cascadeGeneticTestingMandated, String recommendedLipidLoweringRegimen) {}

    public FhDiagnosis calculateDlcn(FhInput in) {
        int score = 0;
        if (in.causativeMutationIdentified()) score += 8;
        if (in.tendonXanthomas()) score += 6;
        if (in.arcusCornealisUnder45()) score += 4;
        if (in.firstDegreePrematureCad()) score += 1;

        if (in.untreatedLdlCMgDl() >= 330.0) score += 8;
        else if (in.untreatedLdlCMgDl() >= 250.0) score += 5;
        else if (in.untreatedLdlCMgDl() >= 190.0) score += 3;
        else if (in.untreatedLdlCMgDl() >= 155.0) score += 1;

        String cat;
        if (score > 8) cat = "DEFINITE FAMILIAL HYPERCHOLESTEROLEMIA";
        else if (score >= 6) cat = "PROBABLE FAMILIAL HYPERCHOLESTEROLEMIA";
        else if (score >= 3) cat = "POSSIBLE FAMILIAL HYPERCHOLESTEROLEMIA";
        else cat = "UNLIKELY FH";

        boolean cascade = score >= 6;
        String rx = (score >= 6) ? "High-Intensity Statin (Atorvastatin 80mg) + Ezetimibe 10mg + PCSK9 Monoclonal (Evolocumab / Alirocumab) or Inclisiran." : "Moderate to High-Intensity Statin therapy.";

        return new FhDiagnosis(score, cat, cascade, rx);
    }
}
