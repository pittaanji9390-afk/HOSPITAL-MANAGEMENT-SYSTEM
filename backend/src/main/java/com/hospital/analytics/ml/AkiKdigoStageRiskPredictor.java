package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AkiKdigoStageRiskPredictor {

    @Data
    @AllArgsConstructor
    public static class AkiStagingResult {
        private String patientId;
        private String kdigoStage; // NO_AKI, STAGE_1, STAGE_2, STAGE_3
        private double baselineCreatinine;
        private double currentCreatinine;
        private double creatinineFoldIncrease;
        private boolean renalReplacementTherapyIndicated;
    }

    public AkiStagingResult evaluateAki(String patientId, double baselineCr, double currentCr, double urineOutputMlKgHr, int oliguriaHours) {
        double fold = baselineCr > 0 ? currentCr / baselineCr : 1.0;
        double absDelta = currentCr - baselineCr;

        String stage = "NO_AKI";
        boolean rrt = false;

        if (fold >= 3.0 || currentCr >= 4.0 || oliguriaHours >= 24) {
            stage = "STAGE_3";
            rrt = true;
        } else if (fold >= 2.0 || oliguriaHours >= 12) {
            stage = "STAGE_2";
        } else if (fold >= 1.5 || absDelta >= 0.3 || (urineOutputMlKgHr < 0.5 && oliguriaHours >= 6)) {
            stage = "STAGE_1";
        }

        return new AkiStagingResult(patientId, stage, baselineCr, currentCr, Math.round(fold * 100.0) / 100.0, rrt);
    }
}
