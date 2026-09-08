package com.hospital.services.gastroenterology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class GastroenterologyEndoscopyEngine {

    @Data
    @Builder
    public static class GastroHepaticAssessment {
        private String patientId;
        private double meld30Score;
        private String forrestUlcerGrade;
        private double rebleedingRiskPercent;
        private String endoscopicHemostasisIntervention;
        private String postEndoscopyMedicationOrder;
    }

    public GastroHepaticAssessment calculateMeldAndForrest(String patientId, double bilirubin, double inr, double creatinine, double sodium, double albumin, boolean isFemale, String forrestCode) {
        double meld = 1.33 * (isFemale ? 1.0 : 0.0) + 4.56 * Math.log(Math.max(1.0, bilirubin)) + 0.82 * (137.0 - Math.min(137.0, Math.max(125.0, sodium))) - 0.24 * (137.0 - Math.min(137.0, Math.max(125.0, sodium))) * Math.log(Math.max(1.0, bilirubin)) + 9.09 * Math.log(Math.max(1.0, inr)) + 11.14 * Math.log(Math.max(1.0, creatinine)) + 1.85 * (3.5 - Math.min(3.5, albumin)) - 1.83 * (3.5 - Math.min(3.5, albumin)) * Math.log(Math.max(1.0, inr)) + 6.0;

        double rebleedRisk = forrestCode.startsWith("Ia") ? 90.0 : (forrestCode.startsWith("Ib") ? 60.0 : (forrestCode.startsWith("IIa") ? 45.0 : 10.0));

        return GastroHepaticAssessment.builder()
                .patientId(patientId)
                .meld30Score(Math.round(meld * 10.0) / 10.0)
                .forrestUlcerGrade(forrestCode)
                .rebleedingRiskPercent(rebleedRisk)
                .endoscopicHemostasisIntervention("Dual Modality: Epinephrine (1:10000) injection + Hemoclips deployment.")
                .postEndoscopyMedicationOrder("Pantoprazole 80mg IV bolus followed by 8mg/hour continuous IV infusion for 72 hours.")
                .build();
    }
}
