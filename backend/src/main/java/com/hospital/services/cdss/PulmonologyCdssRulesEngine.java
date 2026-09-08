package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PulmonologyCdssRulesEngine {

    @Data
    @Builder
    public static class PneumoniaAndPeTriage {
        private String patientId;
        private int curb65Score;
        private String pneumoniaSiteOfCare; // OUTPATIENT, INPATIENT_WARD, ICU
        private double wellsPeScore;
        private String peRiskStratification; // LOW, MODERATE, HIGH
        private String diagnosticWorkupPlan;
    }

    public PneumoniaAndPeTriage evaluatePulmonaryRisk(String patientId, boolean confusion, double bunMgDl, int respRate, double sbp, double dbp, int age, boolean clinicalDvt, boolean peLikely, double hr, boolean priorDvtPe, boolean hemoptysis, boolean activeMalignancy) {
        int curb = (confusion ? 1 : 0) + (bunMgDl > 19.0 ? 1 : 0) + (respRate >= 30 ? 1 : 0) + ((sbp < 90 || dbp <= 60) ? 1 : 0) + (age >= 65 ? 1 : 0);
        
        String careSite = curb <= 1 ? "OUTPATIENT_TREATMENT" : (curb == 2 ? "INPATIENT_HOSPITAL_WARD" : "CONSIDER_ICU_ADMISSION");

        double wells = (clinicalDvt ? 3.0 : 0.0) + (peLikely ? 3.0 : 0.0) + (hr > 100 ? 1.5 : 0.0) + (priorDvtPe ? 1.5 : 0.0) + (hemoptysis ? 1.0 : 0.0) + (activeMalignancy ? 1.0 : 0.0);
        
        String peRisk = wells > 6.0 ? "HIGH_PROBABILITY" : (wells >= 2.0 ? "MODERATE_PROBABILITY" : "LOW_PROBABILITY");

        return PneumoniaAndPeTriage.builder()
                .patientId(patientId)
                .curb65Score(curb)
                .pneumoniaSiteOfCare(careSite)
                .wellsPeScore(wells)
                .peRiskStratification(peRisk)
                .diagnosticWorkupPlan(wells > 4.0 ? "STAT CT Pulmonary Angiography (CTPA) + Therapeutic Enoxaparin 1 mg/kg SC Q12H." : "High-sensitivity D-Dimer Assay. If negative (< 500 ng/mL FEU), PE ruled out.")
                .build();
    }
}
