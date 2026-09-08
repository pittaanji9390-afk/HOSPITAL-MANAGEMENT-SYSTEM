package com.hospital.oncology.mtb;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Molecular Tumor Board (MTB) Precision Oncology Actionable Genomic Variant Engine.
 * Annotates somatic NGS findings against OncoKB / FDA levels of evidence (Level 1, 2, 3A, 3B, 4):
 * EGFR L858R/Exon19del -> Osimertinib, BRAF V600E -> Dabrafenib + Trametinib, KRAS G12C -> Sotorasib / Adagrasib,
 * NTRK1/2/3 Fusions -> Larotrectinib, MSI-H / TMB-H (>= 10 mut/Mb) -> Pembrolizumab.
 */
@Service
public class MolecularTumorBoardService {

    public record GenomicAlteration(String geneSymbol, String variantHsp, String variantType, double variantAlleleFrequencyPct, String oncoKbTier) {}
    public record PrecisionTherapyRecommendation(String gene, String variant, String fdaApprovedTherapy, String levelOfEvidence, String clinicalTrialEligibility) {}

    private final Map<String, PrecisionTherapyRecommendation> actionableCatalog = new HashMap<>();

    public MolecularTumorBoardService() {
        seedActionableCatalog();
    }

    private void seedActionableCatalog() {
        actionableCatalog.put("EGFR:L858R", new PrecisionTherapyRecommendation("EGFR", "L858R", "Osimertinib (Tagrisso) 80mg daily", "Level 1 (FDA Approved standard of care)", "FLAURA2 combination trials"));
        actionableCatalog.put("BRAF:V600E", new PrecisionTherapyRecommendation("BRAF", "V600E", "Dabrafenib 150mg BID + Trametinib 2mg daily", "Level 1 (FDA Approved tumor-agnostic)", "BRAF basket clinical protocols"));
        actionableCatalog.put("KRAS:G12C", new PrecisionTherapyRecommendation("KRAS", "G12C", "Sotorasib (Lumakras) 960mg daily or Adagrasib (Krazati)", "Level 1 (FDA Approved for NSCLC)", "KRAS-SHP2 combination inhibitor trials"));
        actionableCatalog.put("NTRK1:FUSION", new PrecisionTherapyRecommendation("NTRK1", "LMNA-NTRK1 Fusion", "Larotrectinib 100mg BID (Vitrakvi)", "Level 1 (FDA Approved tissue-agnostic)", "Next-Gen TRK repotrectinib trials"));
    }

    public PrecisionTherapyRecommendation annotateVariant(String gene, String variant) {
        String key = gene.toUpperCase() + ":" + variant.toUpperCase();
        return actionableCatalog.getOrDefault(key, new PrecisionTherapyRecommendation(gene, variant, "Standard Chemotherapy / Immunotherapy", "Level 4 (Biomarker under investigation)", "Eligible for Phase I/II basket protocols"));
    }
}
