package com.hospital.services.neurology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class NeurologyStrokeEvaluationEngine {

    @Data
    @Builder
    public static class StrokeProtocolAssessment {
        private String patientMrn;
        private int nihssScore;
        private String strokeSeverityCategory;
        private boolean isIvTpaCandidate;
        private boolean isMechanicalThrombectomyCandidate;
        private double doorToNeedleTargetMinutes;
        private double calculatedAlteplaseDoseMg;
        private double calculatedAlteplaseBolusMg;
        private String imagingSummary;
    }

    public StrokeProtocolAssessment evaluateAcuteStroke(String patientMrn, int nihss, double weightKg, double hoursFromOnset, boolean hasIntracranialHemorrhage, double bloodPressureSystolic) {
        boolean tpaEligible = hoursFromOnset <= 4.5 && !hasIntracranialHemorrhage && bloodPressureSystolic < 185 && nihss >= 4;
        boolean thrombectomyEligible = hoursFromOnset <= 24.0 && nihss >= 6 && !hasIntracranialHemorrhage;

        double totalTpa = Math.min(90.0, weightKg * 0.9);
        double bolusTpa = totalTpa * 0.10;

        String severity = nihss <= 4 ? "MILD" : (nihss <= 15 ? "MODERATE" : (nihss <= 20 ? "MODERATE-TO-SEVERE" : "SEVERE"));

        return StrokeProtocolAssessment.builder()
                .patientMrn(patientMrn)
                .nihssScore(nihss)
                .strokeSeverityCategory(severity)
                .isIvTpaCandidate(tpaEligible)
                .isMechanicalThrombectomyCandidate(thrombectomyEligible)
                .doorToNeedleTargetMinutes(45.0)
                .calculatedAlteplaseDoseMg(Math.round(totalTpa * 10.0) / 10.0)
                .calculatedAlteplaseBolusMg(Math.round(bolusTpa * 10.0) / 10.0)
                .imagingSummary("NCCT Brain: ASPECTS 9/10, No acute hemorrhage, hyperdense MCA sign on left.")
                .build();
    }
}
