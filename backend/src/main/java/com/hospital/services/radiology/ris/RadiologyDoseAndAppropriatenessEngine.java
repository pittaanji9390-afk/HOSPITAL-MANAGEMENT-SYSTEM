package com.hospital.services.radiology.ris;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class RadiologyDoseAndAppropriatenessEngine {

    @Data
    @Builder
    public static class RadiologyOrderValidation {
        private String accessionNumber;
        private String requestedModality; // CT, MRI, XRAY, US, PET
        private int acrAppropriatenessScore; // 1 (Usually not appropriate) to 9 (Usually appropriate)
        private double estimatedRadiationDoseMsv;
        private double cumulativeLifetimeRadiationDoseMsv;
        private boolean isHighRadiationExposureAlert;
        private String clinicalDecisionSupportJustification;
    }

    public RadiologyOrderValidation validateExam(String accession, String modality, int acrScore, double examDoseMsv, double priorCumulativeMsv) {
        double newCumulative = priorCumulativeMsv + examDoseMsv;
        boolean doseAlert = newCumulative >= 100.0; // 100 mSv cumulative trigger

        return RadiologyOrderValidation.builder()
                .accessionNumber(accession)
                .requestedModality(modality)
                .acrAppropriatenessScore(acrScore)
                .estimatedRadiationDoseMsv(examDoseMsv)
                .cumulativeLifetimeRadiationDoseMsv(newCumulative)
                .isHighRadiationExposureAlert(doseAlert)
                .clinicalDecisionSupportJustification(acrScore >= 7 ? "Order satisfies ACR Appropriateness Criteria (Category 7-9: Usually Appropriate)." : "Consider alternative non-ionizing modality (MRI / Ultrasound) to minimize radiation exposure.")
                .build();
    }
}
