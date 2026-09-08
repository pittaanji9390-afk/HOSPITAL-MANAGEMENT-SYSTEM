package com.hospital.services.psychiatry;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PsychiatryAssessmentEngine {

    @Data
    @Builder
    public static class MentalHealthEvaluation {
        private String patientMrn;
        private int phq9Score;
        private String depressionSeverity;
        private int gad7Score;
        private String anxietySeverity;
        private int ciwaArScore;
        private String withdrawalRiskTier;
        private boolean isSuicidePrecautionsMandatory;
        private String psychiatricCarePlan;
    }

    public MentalHealthEvaluation evaluateMentalHealth(String patientMrn, int phq9, int gad7, int ciwa, boolean suicidalIdeationQ9) {
        String dep = phq9 >= 20 ? "SEVERE_MAJOR_DEPRESSION" : (phq9 >= 15 ? "MODERATELY_SEVERE_DEPRESSION" : (phq9 >= 10 ? "MODERATE_DEPRESSION" : (phq9 >= 5 ? "MILD_DEPRESSION" : "MINIMAL_NONE")));
        String anx = gad7 >= 15 ? "SEVERE_ANXIETY" : (gad7 >= 10 ? "MODERATE_ANXIETY" : (gad7 >= 5 ? "MILD_ANXIETY" : "MINIMAL_NONE"));
        String ciwaCat = ciwa >= 20 ? "SEVERE_WITHDRAWAL_HIGH_DT_RISK" : (ciwa >= 10 ? "MODERATE_WITHDRAWAL" : "MILD_WITHDRAWAL");

        return MentalHealthEvaluation.builder()
                .patientMrn(patientMrn)
                .phq9Score(phq9)
                .depressionSeverity(dep)
                .gad7Score(gad7)
                .anxietySeverity(anx)
                .ciwaArScore(ciwa)
                .withdrawalRiskTier(ciwaCat)
                .isSuicidePrecautionsMandatory(suicidalIdeationQ9 || phq9 >= 20)
                .psychiatricCarePlan("Initiate 1:1 Continuous Visual Observation (sitter); secure room environment (ligature-resistant); psych consult STAT.")
                .build();
    }
}
