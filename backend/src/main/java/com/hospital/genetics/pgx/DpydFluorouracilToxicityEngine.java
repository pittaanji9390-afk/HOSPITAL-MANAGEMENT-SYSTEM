package com.hospital.genetics.pgx;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class DpydFluorouracilToxicityEngine {

    @Data
    @AllArgsConstructor
    public static class DpydGuidance {
        private String patientId;
        private String dpydVariantDetected; // None, *2A, *13, c.2846A>T, HapB3
        private double dpydActivityScore; // 0.0 to 2.0
        private String fluorouracilCapecitabineDoseRecommendation;
    }

    public DpydGuidance evaluateDpyd(String patientId, String variant) {
        double score = variant.equals("*2A") || variant.equals("*13") ? 0.0 : variant.equals("c.2846A>T") ? 1.0 : 2.0;
        String rec = score == 0.0 ? "CONTRAINDICATED: Complete DPD deficiency. Avoid 5-Fluorouracil and Capecitabine." : score <= 1.0 ? "Reduce starting dose by 50% with strict neutropenia/mucositis monitoring." : "Standard 5-FU / Capecitabine dosing.";

        return new DpydGuidance(patientId, variant, score, rec);
    }
}
