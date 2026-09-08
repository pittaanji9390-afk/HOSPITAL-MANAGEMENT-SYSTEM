package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class HfrReadmissionRiskPredictor {

    @Data
    @AllArgsConstructor
    public static class HfrReadmissionPrediction {
        private String patientId;
        private double predicted30DayReadmissionPercent;
        private String riskCategory; // LOW, MEDIUM, HIGH
        private boolean recommendedForTransitionalCareProgram;
    }

    public HfrReadmissionPrediction predictHfr(String patientId, int age, double bnpPgMl, double egfr, int priorAdmissions12Mo, boolean hasDiabetes, boolean hasCopd) {
        double risk = 10.0;
        if (age >= 75) risk += 10.0;
        if (bnpPgMl > 1000) risk += 18.0;
        if (egfr < 45) risk += 15.0;
        risk += priorAdmissions12Mo * 12.0;
        if (hasCopd) risk += 8.0;

        risk = Math.min(85.0, Math.max(5.0, risk));
        String cat = risk >= 40.0 ? "HIGH" : risk >= 20.0 ? "MEDIUM" : "LOW";

        return new HfrReadmissionPrediction(patientId, risk, cat, risk >= 25.0);
    }
}
