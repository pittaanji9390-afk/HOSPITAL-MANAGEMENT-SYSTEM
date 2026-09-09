package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class CardiologyCdssRulesEngine {

    @Data
    @Builder
    public static class AfibAnticoagulationReport {
        private String patientMrn;
        private int cha2ds2VascScore;
        private double annualStrokeRiskPercent;
        private boolean isOralAnticoagulationIndicated;
        private String recommendedDoacAgent;
        private String hasBledBleedingRiskEvaluation;
    }

    public AfibAnticoagulationReport evaluateAfibStrokeRisk(String mrn, boolean chf, boolean hypertension, int age, boolean diabetes, boolean priorStrokeTia, boolean vascularDisease, boolean isFemale, int hasBledScore) {
        int score = (chf ? 1 : 0) + (hypertension ? 1 : 0) + (age >= 75 ? 2 : (age >= 65 ? 1 : 0)) + (diabetes ? 1 : 0) + (priorStrokeTia ? 2 : 0) + (vascularDisease ? 1 : 0) + (isFemale ? 1 : 0);
        
        double strokeRisk = score == 0 ? 0.2 : (score == 1 ? 0.6 : (score == 2 ? 2.2 : (score == 3 ? 3.2 : (score == 4 ? 4.8 : (score == 5 ? 7.2 : (score == 6 ? 9.7 : 12.5))))));
        
        int threshold = isFemale ? 2 : 1;
        boolean indicated = score >= threshold;

        return AfibAnticoagulationReport.builder()
                .patientMrn(mrn)
                .cha2ds2VascScore(score)
                .annualStrokeRiskPercent(strokeRisk)
                .isOralAnticoagulationIndicated(indicated)
                .recommendedDoacAgent(indicated ? "Apixaban 5mg BID (or Rivaroxaban 20mg daily with food) preferred over Warfarin unless mechanical heart valve present." : "No antithrombotic therapy required.")
                .hasBledBleedingRiskEvaluation(hasBledScore >= 3 ? "HIGH BLEEDING RISK (HAS-BLED >= 3): Address modifiable risk factors (BP control, NSAID avoidance, alcohol reduction)." : "Low-to-moderate bleeding risk.")
                .build();
    }
}
