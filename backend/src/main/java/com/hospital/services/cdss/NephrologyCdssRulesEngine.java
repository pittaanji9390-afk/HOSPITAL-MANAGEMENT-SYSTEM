package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class NephrologyCdssRulesEngine {

    @Data
    @Builder
    public static class RenalFunctionAssessment {
        private String patientMrn;
        private double baselineCreatinine;
        private double currentCreatinine;
        private String kdigoAkiStage; // NO_AKI, STAGE_1, STAGE_2, STAGE_3
        private double calculatedEgfrMlMin173m2;
        private String ckdStage;
        private String nephrotoxicDrugGuardrailDirective;
    }

    public RenalFunctionAssessment evaluateRenalStatus(String mrn, double baselineCr, double currentCr, double urineOutputMlKgHr, int urineHours, int age, boolean isFemale) {
        double crRatio = currentCr / Math.max(0.1, baselineCr);
        double crDelta = currentCr - baselineCr;

        String akiStage = "NO_AKI";
        if (crRatio >= 3.0 || currentCr >= 4.0 || (urineOutputMlKgHr < 0.3 && urineHours >= 24)) {
            akiStage = "KDIGO_AKI_STAGE_3";
        } else if (crRatio >= 2.0 || (urineOutputMlKgHr < 0.5 && urineHours >= 12)) {
            akiStage = "KDIGO_AKI_STAGE_2";
        } else if (crRatio >= 1.5 || crDelta >= 0.3 || (urineOutputMlKgHr < 0.5 && urineHours >= 6)) {
            akiStage = "KDIGO_AKI_STAGE_1";
        }

        // 2021 CKD-EPI Creatinine Equation (Race-free)
        double k = isFemale ? 0.7 : 0.9;
        double alpha = isFemale ? -0.241 : -0.302;
        double minTerm = Math.min(currentCr / k, 1.0);
        double maxTerm = Math.max(currentCr / k, 1.0);
        double egfr = 142.0 * Math.pow(minTerm, alpha) * Math.pow(maxTerm, -1.200) * Math.pow(0.9938, age) * (isFemale ? 1.012 : 1.0);

        String ckdStage = egfr >= 90 ? "G1 (Normal)" : (egfr >= 60 ? "G2 (Mildly Decreased)" : (egfr >= 45 ? "G3a (Mild-to-Moderate)" : (egfr >= 30 ? "G3b (Moderate-to-Severe)" : (egfr >= 15 ? "G4 (Severely Decreased)" : "G5 (Kidney Failure)"))));

        return RenalFunctionAssessment.builder()
                .patientMrn(mrn)
                .baselineCreatinine(baselineCr)
                .currentCreatinine(currentCr)
                .kdigoAkiStage(akiStage)
                .calculatedEgfrMlMin173m2(Math.round(egfr * 10.0) / 10.0)
                .ckdStage(ckdStage)
                .nephrotoxicDrugGuardrailDirective(akiStage.equals("NO_AKI") ? "Routine medication dosing." : "HOLD NSAIDs, ACE-Inhibitors/ARBs, Aminoglycosides, and IV iodinated contrast. Renally adjust Vancomycin and Piperacillin/Tazobactam.")
                .build();
    }
}
