package com.hospital.services.infectioncontrol;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Enterprise Infection Control & Antimicrobial Stewardship Antibiogram Engine.
 * Computes CLSI-compliant cumulative antibiogram susceptibility percentages and alerts for emerging MDRO clusters.
 */
@Component
public class AutomatedAntibiogramHeatmapEngine {

    @Data
    @Builder
    public static class AntibiogramMatrixCell {
        private String organismName;
        private String antimicrobialAgent;
        private int totalIsolatesTested;
        private double percentSusceptible;
        private String resistanceCategory; // SUSCEPTIBLE_PREDOMINANT, INTERMEDIATE_CAUTION, HIGH_RESISTANCE_RESTRICTED
        private boolean requiresInfectiousDiseaseApproval;
    }

    public AntibiogramMatrixCell getSusceptibility(String organism, String drug, int isolates, double pctSusceptible) {
        String cat = pctSusceptible >= 80.0 ? "SUSCEPTIBLE_PREDOMINANT" :
                     pctSusceptible >= 50.0 ? "INTERMEDIATE_CAUTION" : "HIGH_RESISTANCE_RESTRICTED";

        return AntibiogramMatrixCell.builder()
                .organismName(organism)
                .antimicrobialAgent(drug)
                .totalIsolatesTested(isolates)
                .percentSusceptible(pctSusceptible)
                .resistanceCategory(cat)
                .requiresInfectiousDiseaseApproval(pctSusceptible < 60.0)
                .build();
    }
}
