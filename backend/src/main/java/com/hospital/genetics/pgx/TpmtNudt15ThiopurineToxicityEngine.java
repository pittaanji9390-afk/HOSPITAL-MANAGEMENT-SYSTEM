package com.hospital.genetics.pgx;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class TpmtNudt15ThiopurineToxicityEngine {

    @Data
    @AllArgsConstructor
    public static class ThiopurineGuidance {
        private String patientId;
        private String tpmtStatus; // NORMAL, INTERMEDIATE, POOR
        private String nudt15Status; // NORMAL, INTERMEDIATE, POOR
        private double recommendedStartingDosePercent; // 100%, 30-70%, 10%
        private String clinicalWarning;
    }

    public ThiopurineGuidance evaluateThiopurine(String patientId, String tpmt, String nudt15) {
        double dose = 100.0;
        String warning = "Standard starting dose of Azathioprine or 6-Mercaptopurine";

        if (tpmt.equals("POOR") || nudt15.equals("POOR")) {
            dose = 10.0;
            warning = "CRITICAL: Homozygous deficiency. Reduce dose by 90% and dose 3x weekly to avoid fatal myelosuppression.";
        } else if (tpmt.equals("INTERMEDIATE") || nudt15.equals("INTERMEDIATE")) {
            dose = 50.0;
            warning = "Intermediate metabolizer: Reduce starting dose by 50% and monitor CBC weekly.";
        }

        return new ThiopurineGuidance(patientId, tpmt, nudt15, dose, warning);
    }
}
