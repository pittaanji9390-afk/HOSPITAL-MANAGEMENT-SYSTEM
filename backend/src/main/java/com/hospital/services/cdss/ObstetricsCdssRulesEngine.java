package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ObstetricsCdssRulesEngine {

    @Data
    @Builder
    public static class MaternalSafetyAssessment {
        private String patientMrn;
        private boolean hasSeverePreeclampsiaFeatures;
        private String magnesiumSulfateSeizureProphylaxisOrder;
        private String pphStage; // STAGE_1, STAGE_2, STAGE_3
        private String uterotonicInterventionPathway;
    }

    public MaternalSafetyAssessment evaluateMaternalSafety(String mrn, double sbp, double dbp, double platelets, double astAlt, double creatinine, boolean severeHeadache, double quantifiedBloodLossMl, boolean isCesareanDelivery) {
        boolean severePreE = (sbp >= 160 || dbp >= 110) || platelets < 100000 || astAlt > 80.0 || creatinine > 1.1 || severeHeadache;

        double pphThreshold = isCesareanDelivery ? 1000.0 : 500.0;
        String pphStage = "NORMAL_LOCHIA";
        if (quantifiedBloodLossMl >= 1500.0) {
            pphStage = "PPH_STAGE_3_MASSIVE";
        } else if (quantifiedBloodLossMl >= 1000.0) {
            pphStage = "PPH_STAGE_2";
        } else if (quantifiedBloodLossMl >= pphThreshold) {
            pphStage = "PPH_STAGE_1";
        }

        return MaternalSafetyAssessment.builder()
                .patientMrn(mrn)
                .hasSeverePreeclampsiaFeatures(severePreE)
                .magnesiumSulfateSeizureProphylaxisOrder(severePreE ? "Magnesium Sulfate 4g IV loading dose over 20 min, followed by 2g/hr continuous IV maintenance. Labetalol 20mg IV STAT for SBP >= 160." : "Routine blood pressure surveillance.")
                .pphStage(pphStage)
                .uterotonicInterventionPathway(pphStage.equals("NORMAL_LOCHIA") ? "Routine Oxytocin 20 Units in 1000mL LR post-placenta delivery." : "Oxytocin 40 U IV infusion + Methylergonovine 0.2mg IM + Carboprost (Hemabate) 250mcg IM + Misoprostol 800mcg PR. Prepare Bakri Tamponade Balloon.")
                .build();
    }
}
