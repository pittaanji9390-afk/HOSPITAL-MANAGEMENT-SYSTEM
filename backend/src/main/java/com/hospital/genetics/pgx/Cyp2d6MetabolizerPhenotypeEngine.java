package com.hospital.genetics.pgx;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class Cyp2d6MetabolizerPhenotypeEngine {

    @Data
    @AllArgsConstructor
    public static class Cyp2d6Guidance {
        private String patientId;
        private String diplotype; // e.g., *1/*1, *1/*4, *4/*4, *1/*1xN
        private double activityScore; // 0.0 (PM), 0.5-1.0 (IM), 1.5-2.0 (NM), >2.0 (UM)
        private String metabolizerPhenotype; // POOR_METABOLIZER, INTERMEDIATE_METABOLIZER, NORMAL_METABOLIZER, ULTRARAPID_METABOLIZER
        private String codeineRecommendation;
        private String tamoxifenRecommendation;
    }

    public Cyp2d6Guidance interpretDiplotype(String patientId, String diplotype) {
        double score = diplotype.contains("*4/*4") ? 0.0 : diplotype.contains("*1/*4") ? 1.0 : diplotype.contains("xN") ? 3.0 : 2.0;
        String pheno = score == 0.0 ? "POOR_METABOLIZER" : score <= 1.0 ? "INTERMEDIATE_METABOLIZER" : score <= 2.0 ? "NORMAL_METABOLIZER" : "ULTRARAPID_METABOLIZER";

        String codeine = pheno.equals("POOR_METABOLIZER") ? "CONTRAINDICATED: Inability to convert codeine to morphine (no analgesia). Use non-opioid or direct morphine." :
                         pheno.equals("ULTRARAPID_METABOLIZER") ? "CONTRAINDICATED: Rapid conversion to lethal morphine concentrations (respiratory depression risk)." : "Standard dosing acceptable.";

        String tamoxifen = pheno.equals("POOR_METABOLIZER") ? "Consider alternative Aromatase Inhibitor (e.g. Anastrozole) due to reduced endoxifen active metabolite levels." : "Standard Tamoxifen 20mg daily.";

        return new Cyp2d6Guidance(patientId, diplotype, score, pheno, codeine, tamoxifen);
    }
}
