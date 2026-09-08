package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Pharmacogenomics & Precision Dosing Engine (CPIC Guidelines).
 * Implements genotype-guided dosing adjustments for CYP2C19 (Clopidogrel), CYP2D6 (Codeine/Tamoxifen),
 * TPMT/NUDT15 (Thiopurines), HLA-B*5701 (Abacavir), VKORC1/CYP2C9 (Warfarin), and DPYD (Fluoropyrimidines).
 */
@Component
public class PharmacogenomicsPrecisionDosingEngine {

    @Data
    @Builder
    public static class PcxGuidelineEntry {
        private String geneSymbol;
        private String diplotypeOrPhenotype;
        private String drugName;
        private String clinicalRecommendation;
        private String riskLevel; // CONTRAINDICATED, MAJOR_DOSE_REDUCTION, STANDARD_DOSING
        private String evidenceLevel; // CPIC Level A, B
    }

    private static final List<PcxGuidelineEntry> GUIDELINES = new ArrayList<>();

    static {
        add("CYP2C19", "Poor Metabolizer (*2/*2, *2/*3, *3/*3)", "Clopidogrel",
                "Significantly reduced active thiol metabolite levels and impaired platelet inhibition. HIGH RISK OF RECURRENT ISCHEMIC EVENTS / STENT THROMBOSIS. Avoid clopidogrel. Prescribe alternative P2Y12 inhibitor: Prasugrel 10mg daily or Ticagrelor 90mg bid unless contraindicated.",
                "CONTRAINDICATED", "CPIC Level A");

        add("CYP2D6", "Ultrarapid Metabolizer (>= 3 active alleles)", "Codeine / Tramadol",
                "Greatly increased rate of conversion of codeine to morphine. HIGH RISK OF SEVERE, POTENTIALLY FATAL RESPIRATORY DEPRESSION even at standard doses. Avoid codeine and tramadol. Use non-opioid analgesics or direct opioids (morphine, hydromorphone).",
                "CONTRAINDICATED", "CPIC Level A");

        add("TPMT", "Poor / Deficient Metabolizer (*3A/*3A, *2/*3A)", "Azathioprine / 6-Mercaptopurine",
                "Extremely low TPMT enzyme activity leading to toxic accumulation of active thioguanine nucleotides (6-TGN). CATASTROPHIC FATAL MYELOSUPPRESSION / BONE MARROW APLASIA. Reduce standard starting dose by 90% (e.g. 10% of normal dose given thrice weekly) or switch to non-thiopurine.",
                "MAJOR_DOSE_REDUCTION", "CPIC Level A");

        add("HLA-B", "HLA-B*57:01 Positive", "Abacavir",
                "High risk of severe, life-threatening immunological ABACAVIR HYPERSENSITIVITY REACTION (fever, rash, GI symptoms, respiratory distress, shock). Abacavir is STRICTLY CONTRAINDICATED. Never rechallenge.",
                "CONTRAINDICATED", "CPIC Level A");

        add("DPYD", "Complete DPD Deficiency (*2A/*2A, *13/*13)", "5-Fluorouracil / Capecitabine",
                "Absence of Dihydropyrimidine Dehydrogenase (DPD) enzyme activity preventing catabolism of 5-FU. EXTREME RISK OF FATAL 5-FU TOXICITY (severe pancytopenic sepsis, toxic epidermal necrolysis, neurotoxicity). Avoid 5-FU, Capecitabine, and Tegafur. Select non-fluoropyrimidine chemotherapy.",
                "CONTRAINDICATED", "CPIC Level A");

        add("VKORC1", "VKORC1 -1639 G>A (A/A Low Dose)", "Warfarin",
                "Increased sensitivity to Warfarin due to lower baseline vitamin K epoxide reductase synthesis. Reduce standard empirical initiation dose to 2.5-3.0 mg daily (instead of 5.0 mg) to prevent severe supratherapeutic INR (> 5.0) and major hemorrhage.",
                "MAJOR_DOSE_REDUCTION", "CPIC Level A");
    }

    private static void add(String gene, String pheno, String drug, String rec, String risk, String ev) {
        GUIDELINES.add(PcxGuidelineEntry.builder()
                .geneSymbol(gene)
                .diplotypeOrPhenotype(pheno)
                .drugName(drug)
                .clinicalRecommendation(rec)
                .riskLevel(risk)
                .evidenceLevel(ev)
                .build());
    }

    public List<PcxGuidelineEntry> searchByDrug(String drugName) {
        if (drugName == null || drugName.isBlank()) return GUIDELINES;
        String q = drugName.toLowerCase().trim();
        return GUIDELINES.stream()
                .filter(g -> g.getDrugName().toLowerCase().contains(q) || g.getGeneSymbol().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<PcxGuidelineEntry> getAllGuidelines() {
        return Collections.unmodifiableList(GUIDELINES);
    }
}
