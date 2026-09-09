package com.hospital.services.dermatology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class DermatologyWoundCareEngine {

    @Data
    @Builder
    public static class WoundAndSkinAssessment {
        private String patientId;
        private int bradenScore;
        private String pressureInjuryRiskLevel;
        private double pasiScore;
        private String psoriasisSeverity;
        private String woundCareNursingOrder;
    }

    public WoundAndSkinAssessment assessSkin(String patientId, int sensory, int moisture, int activity, int mobility, int nutrition, int friction, double pasiRaw) {
        int braden = sensory + moisture + activity + mobility + nutrition + friction;
        String risk = braden <= 9 ? "VERY_HIGH_RISK" : (braden <= 12 ? "HIGH_RISK" : (braden <= 14 ? "MODERATE_RISK" : (braden <= 18 ? "MILD_RISK" : "NO_RISK")));

        String pasiCat = pasiRaw >= 10.0 ? "MODERATE_TO_SEVERE" : "MILD";

        return WoundAndSkinAssessment.builder()
                .patientId(patientId)
                .bradenScore(braden)
                .pressureInjuryRiskLevel(risk)
                .pasiScore(pasiRaw)
                .psoriasisSeverity(pasiCat)
                .woundCareNursingOrder("Pressure redistribution alternating air mattress; Q2H repositioning protocol; apply barrier cream to sacrum.")
                .build();
    }
}
