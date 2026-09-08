package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class FallRiskAssessmentModelsCatalog {

    @Data
    @AllArgsConstructor
    public static class MorseFallScoreResult {
        private String patientMrn;
        private int totalScore;
        private String riskTier; // NO_RISK, LOW_RISK, HIGH_RISK
        private String nursingInterventionDirectives;
    }

    public MorseFallScoreResult calculateMorseFallScore(String mrn, boolean historyOfFalls, boolean secondaryDiagnosis, boolean ambulatoryAidCrutchesWalker, boolean ivHeparinLock, boolean impairedGait, boolean forgetsLimitations) {
        int score = (historyOfFalls ? 25 : 0) + (secondaryDiagnosis ? 15 : 0) + (ambulatoryAidCrutchesWalker ? 30 : 0) + (ivHeparinLock ? 20 : 0) + (impairedGait ? 20 : 0) + (forgetsLimitations ? 15 : 0);
        
        String tier = score >= 45 ? "HIGH_FALL_RISK" : (score >= 25 ? "MODERATE_FALL_RISK" : "LOW_NO_RISK");
        String directives = score >= 45 ? "HIGH FALL PRECAUTIONS: Yellow wristband, bed alarm activated, nonskid socks, 1:1 assisted ambulation, call light within easy reach." : "Standard inpatient fall precautions.";

        return new MorseFallScoreResult(mrn, score, tier, directives);
    }
}
