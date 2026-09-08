package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class GastroenterologyCdssRulesEngine {

    @Data
    @Builder
    public static class PancreatitisSeverityScore {
        private String encounterId;
        private int bisapScore; // 0 - 5
        private double estimatedMortalityPercent;
        private boolean isSevereAcutePancreatitisPredicted;
        private String fluidResuscitationProtocol;
    }

    public PancreatitisSeverityScore evaluateBisap(String encounterId, double bunMgDl, boolean impairedMentalStatus, boolean sirsCriteriaPresent, int age, boolean pleuralEffusionOnImaging) {
        int score = (bunMgDl > 25.0 ? 1 : 0) + (impairedMentalStatus ? 1 : 0) + (sirsCriteriaPresent ? 1 : 0) + (age > 60 ? 1 : 0) + (pleuralEffusionOnImaging ? 1 : 0);
        
        double mortality = score <= 1 ? 1.0 : (score == 2 ? 2.0 : (score == 3 ? 5.3 : (score == 4 ? 12.7 : 22.5)));

        return PancreatitisSeverityScore.builder()
                .encounterId(encounterId)
                .bisapScore(score)
                .estimatedMortalityPercent(mortality)
                .isSevereAcutePancreatitisPredicted(score >= 3)
                .fluidResuscitationProtocol(score >= 3 ? "Goal-directed Lactated Ringer's resuscitation: 20 mL/kg bolus over 2 hours, then 3 mL/kg/hr. Monitor Hematocrit and BUN at 12h." : "Standard maintenance hydration (150-200 mL/hr). Early oral feeding as tolerated.")
                .build();
    }
}
