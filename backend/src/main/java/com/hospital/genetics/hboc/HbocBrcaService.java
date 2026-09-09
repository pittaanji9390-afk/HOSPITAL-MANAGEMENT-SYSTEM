package com.hospital.genetics.hboc;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Hereditary Breast and Ovarian Cancer (HBOC) NCCN Guideline Evaluator.
 * Identifies high-risk criteria for germline BRCA1 / BRCA2 / PALB2 testing:
 * - Breast cancer <= 50y, Triple-Negative Breast Cancer (TNBC) <= 60y, Ovarian / Fallopian / Peritoneal Cancer at any age,
 * - Metastatic Prostate Cancer, Pancreatic Adenocarcinoma at any age, or Ashkenazi Jewish ancestry.
 */
@Service
public class HbocBrcaService {

    public record HbocClinicalProfile(
        boolean epithelialOvarianCancerAnyAge,
        boolean breastCancerUnder50,
        boolean tripleNegativeBreastCancerUnder60,
        boolean metastaticProstateCancer,
        boolean pancreaticAdenocarcinoma,
        boolean ashkenaziJewishAncestry,
        int firstDegreeRelativesWithBreastUnder50
    ) {}

    public record HbocTestingRecommendation(boolean meetsNccnTestingCriteria, String geneticPanelRecommendation, String targetedParpInhibitorOptions) {}

    public HbocTestingRecommendation evaluateHboc(HbocClinicalProfile p) {
        boolean meets = p.epithelialOvarianCancerAnyAge() || p.breastCancerUnder50() || p.tripleNegativeBreastCancerUnder60()
            || p.metastaticProstateCancer() || p.pancreaticAdenocarcinoma() || (p.ashkenaziJewishAncestry() && (p.breastCancerUnder50() || p.firstDegreeRelativesWithBreastUnder50() >= 1))
            || p.firstDegreeRelativesWithBreastUnder50() >= 2;

        String panel = meets ? "Comprehensive Germline Multi-Gene Hereditary Cancer Panel (BRCA1, BRCA2, PALB2, TP53, PTEN, CDH1, CHEK2, ATM)" : "Does not meet standard NCCN germline testing threshold.";
        String parp = meets ? "If BRCA1/2 Pathogenic: Olaparib (Lynparza), Talazoparib (Talzenna), Rucaparib (Rubraca), or Niraparib (Zejula) indicated." : "N/A";

        return new HbocTestingRecommendation(meets, panel, parp);
    }
}
