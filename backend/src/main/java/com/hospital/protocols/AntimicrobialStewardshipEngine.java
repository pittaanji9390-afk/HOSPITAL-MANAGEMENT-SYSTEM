package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AntimicrobialStewardshipEngine {

    @Data
    @Builder
    public static class StewardshipReviewResult {
        private String orderId;
        private String patientMrn;
        private String currentEmpiricAntibiotic;
        private String bloodCultureOrganism;
        private String deEscalationRecommendation;
        private boolean isIvToOralSwitchEligible;
    }

    public StewardshipReviewResult reviewAntibioticOrder(String orderId, String mrn, String currentDrug, String organism, String susceptibility, boolean isAfebrile48h, boolean canTolerateOral) {
        String deEscalate = "Continue current regimen pending final sensitivities.";
        if (organism.contains("MSSA") && susceptibility.contains("OXACILLIN_S")) {
            deEscalate = "De-escalate from Vancomycin to Cefazolin 2g IV Q8H (or Nafcillin 2g IV Q4H).";
        } else if (organism.contains("E. coli") && susceptibility.contains("CEFTRIAXONE_S")) {
            deEscalate = "De-escalate from Meropenem/Cefepime to Ceftriaxone 2g IV Q24H.";
        }

        boolean oralEligible = isAfebrile48h && canTolerateOral && (currentDrug.contains("Levofloxacin") || currentDrug.contains("Linezolid") || currentDrug.contains("Metronidazole") || currentDrug.contains("Fluconazole"));

        return StewardshipReviewResult.builder()
                .orderId(orderId)
                .patientMrn(mrn)
                .currentEmpiricAntibiotic(currentDrug)
                .bloodCultureOrganism(organism)
                .deEscalationRecommendation(deEscalate)
                .isIvToOralSwitchEligible(oralEligible)
                .build();
    }
}
