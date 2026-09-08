package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class SofaOrganFailureScoreCalculator {

    @Data
    @AllArgsConstructor
    public static class SofaScoreResult {
        private String patientId;
        private int totalSofaScore; // 0 to 24
        private int respiratorySubScore; // PaO2/FiO2
        private int coagulationSubScore; // Platelets
        private int liverSubScore; // Bilirubin
        private int cardiovascularSubScore; // MAP & Vasopressors
        private int cnsSubScore; // GCS
        private int renalSubScore; // Creatinine & Urine
        private String organFailureSeverity;
    }

    public SofaScoreResult calculateSofa(String patientId, double pfRatio, double plateletsK, double biliMgDl, double map, double norepiDose, int gcs, double crMgDl) {
        int resp = pfRatio < 100 ? 4 : pfRatio < 200 ? 3 : pfRatio < 300 ? 2 : pfRatio < 400 ? 1 : 0;
        int coag = plateletsK < 20 ? 4 : plateletsK < 50 ? 3 : plateletsK < 100 ? 2 : plateletsK < 150 ? 1 : 0;
        int liver = biliMgDl >= 12.0 ? 4 : biliMgDl >= 6.0 ? 3 : biliMgDl >= 2.0 ? 2 : biliMgDl >= 1.2 ? 1 : 0;
        int cv = norepiDose > 0.1 ? 4 : norepiDose > 0 ? 3 : map < 70 ? 1 : 0;
        int cns = gcs < 6 ? 4 : gcs <= 9 ? 3 : gcs <= 12 ? 2 : gcs <= 14 ? 1 : 0;
        int renal = crMgDl >= 5.0 ? 4 : crMgDl >= 3.5 ? 3 : crMgDl >= 2.0 ? 2 : crMgDl >= 1.2 ? 1 : 0;

        int total = resp + coag + liver + cv + cns + renal;
        String sev = total >= 12 ? "CRITICAL MULTI-ORGAN FAILURE (>80% MORTALITY)" : total >= 8 ? "SEVERE DYSFUNCTION" : total >= 4 ? "MODERATE FAILURE" : "MILD DYSFUNCTION";

        return new SofaScoreResult(patientId, total, resp, coag, liver, cv, cns, renal, sev);
    }
}
