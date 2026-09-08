package com.hospital.oncology.tls;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Cairo-Bishop Definition for Tumor Lysis Syndrome (TLS).
 * Laboratory TLS (LTLS): >= 2 of Uric acid >= 8.0 mg/dL, Potassium >= 6.0 mEq/L, Phosphate >= 4.5 mg/dL, Calcium <= 7.0 mg/dL (or 25% change).
 * Clinical TLS (CTLS): LTLS + Creatinine >= 1.5x ULN, Cardiac Arrhythmia / Sudden Death, or Seizures (Grades 0-5).
 */
@Service
public class TumorLysisSyndromeService {

    public record TlsLabs(double uricAcidMgDl, double potassiumMeqL, double phosphateMgDl, double calciumMgDl, double serumCreatinineMgDl, boolean cardiacArrhythmia, boolean seizures) {}
    public record TlsDiagnosis(boolean hasLaboratoryTls, boolean hasClinicalTls, int cairoBishopGrade, String rasburicaseHydrationProtocol) {}

    public TlsDiagnosis evaluateTls(TlsLabs l) {
        int ltlsCriteria = 0;
        if (l.uricAcidMgDl() >= 8.0) ltlsCriteria++;
        if (l.potassiumMeqL() >= 6.0) ltlsCriteria++;
        if (l.phosphateMgDl() >= 4.5) ltlsCriteria++;
        if (l.calciumMgDl() <= 7.0) ltlsCriteria++;

        boolean isLtls = ltlsCriteria >= 2;
        boolean isCtls = isLtls && (l.serumCreatinineMgDl() >= 1.5 || l.cardiacArrhythmia() || l.seizures());

        int grade = 0;
        if (isCtls) {
            if (l.cardiacArrhythmia() || l.seizures()) grade = 4;
            else if (l.serumCreatinineMgDl() >= 3.0) grade = 3;
            else if (l.serumCreatinineMgDl() >= 1.5) grade = 2;
            else grade = 1;
        }

        String protocol;
        if (l.uricAcidMgDl() >= 8.0 || isCtls) {
            protocol = "Rasburicase (Elitek) 0.2 mg/kg IV x 1 dose + Aggressive IV Hydration (3 L/m2/day without potassium/calcium).";
        } else {
            protocol = "Allopurinol 300 mg/day PO + Vigorous IV Hydration (Maintain urine output > 100 mL/m2/hr).";
        }

        return new TlsDiagnosis(isLtls, isCtls, grade, protocol);
    }
}
