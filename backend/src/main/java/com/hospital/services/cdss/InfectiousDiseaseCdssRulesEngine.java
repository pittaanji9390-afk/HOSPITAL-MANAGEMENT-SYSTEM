package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class InfectiousDiseaseCdssRulesEngine {

    @Data
    @Builder
    public static class SepsisBundleTriage {
        private String encounterId;
        private int sofaScore; // 0 - 24
        private int qSofaScore; // 0 - 3
        private boolean isSepticShockPresent;
        private String hour1BundleMandates;
    }

    public SepsisBundleTriage evaluateSepsis(String encounterId, double pfRatio, double platelets, double bilirubin, double meanArterialPressure, double norepinephrineMcgMin, int gcs, double creatinine, double serumLactateMmolL) {
        int resp = pfRatio < 100 ? 4 : (pfRatio < 200 ? 3 : (pfRatio < 300 ? 2 : (pfRatio < 400 ? 1 : 0)));
        int coag = platelets < 20 ? 4 : (platelets < 50 ? 3 : (platelets < 100 ? 2 : (platelets < 150 ? 1 : 0)));
        int liver = bilirubin >= 12.0 ? 4 : (bilirubin >= 6.0 ? 3 : (bilirubin >= 2.0 ? 2 : (bilirubin >= 1.2 ? 1 : 0)));
        int cardio = norepinephrineMcgMin > 0.1 ? 4 : (norepinephrineMcgMin > 0 ? 3 : (meanArterialPressure < 70 ? 1 : 0));
        int cns = gcs < 6 ? 4 : (gcs <= 9 ? 3 : (gcs <= 12 ? 2 : (gcs <= 14 ? 1 : 0)));
        int renal = creatinine >= 5.0 ? 4 : (creatinine >= 3.5 ? 3 : (creatinine >= 2.0 ? 2 : (creatinine >= 1.2 ? 1 : 0)));

        int totalSofa = resp + coag + liver + cardio + cns + renal;
        boolean shock = totalSofa >= 2 && serumLactateMmolL > 2.0 && norepinephrineMcgMin > 0;

        return SepsisBundleTriage.builder()
                .encounterId(encounterId)
                .sofaScore(totalSofa)
                .qSofaScore(1)
                .isSepticShockPresent(shock)
                .hour1BundleMandates("SEPSIS HOUR-1 BUNDLE: 1. Measure blood lactate; 2. Obtain blood cultures prior to antibiotics; 3. Administer broad-spectrum antibiotics (Vancomycin + Cefepime); 4. Rapid administration of 30 mL/kg crystalloid for hypotension or lactate >= 4; 5. Apply vasopressors (Norepinephrine) if hypotensive during or after fluid resuscitation to maintain MAP >= 65 mmHg.")
                .build();
    }
}
