package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class CentorStrepPharyngitisScoreCalculator {

    @Data
    @AllArgsConstructor
    public static class CentorResult {
        private String patientId;
        private int centorScore;
        private double strepProbabilityPercent;
        private String recommendation;
    }

    public CentorResult calculateCentor(String patientId, boolean tonsillarExudate, boolean tenderAnteriorCervicalNodes, boolean feverHistory, boolean absenceOfCough, int age) {
        int score = 0;
        if (tonsillarExudate) score++;
        if (tenderAnteriorCervicalNodes) score++;
        if (feverHistory) score++;
        if (absenceOfCough) score++;
        if (age >= 3 && age <= 14) score++;
        else if (age >= 45) score--;

        double prob = score >= 4 ? 52.0 : score == 3 ? 30.0 : score == 2 ? 15.0 : score == 1 ? 7.0 : 2.0;
        String rec = score >= 4 ? "Empiric Antibiotics or Rapid Strep Test + Culture" : score >= 2 ? "Perform Rapid Antigen Detection Test (RADT)" : "No testing or antibiotics required (Symptomatic care)";

        return new CentorResult(patientId, score, prob, rec);
    }
}
