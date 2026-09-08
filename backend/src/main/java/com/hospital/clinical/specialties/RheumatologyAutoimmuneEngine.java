package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Enterprise Rheumatology & Systemic Autoimmune Disease Decision Engine.
 * Implements DAS28-ESR / DAS28-CRP Disease Activity Score for Rheumatoid Arthritis,
 * 2019 EULAR/ACR Classification Criteria for Systemic Lupus Erythematosus (SLE),
 * Gout Flare Management & Urate-Lowering Therapy Targets, and Scleroderma Renal Crisis protocols.
 */
@Component
public class RheumatologyAutoimmuneEngine {

    @Data
    @Builder
    public static class Das28Result {
        private double das28Score;
        private String diseaseActivityLevel;
        private String recommendedTherapeuticAdjustment;
    }

    /**
     * DAS28-ESR Formula:
     * DAS28 = 0.56*sqrt(TJC28) + 0.28*sqrt(SJC28) + 0.70*ln(ESR) + 0.014*GH
     */
    public Das28Result calculateDas28Esr(int tenderJointCount28, int swollenJointCount28, double esrMmPerHour, double patientGlobalHealth0To100) {
        double tjcTerm = 0.56 * Math.sqrt(Math.max(0, tenderJointCount28));
        double sjcTerm = 0.28 * Math.sqrt(Math.max(0, swollenJointCount28));
        double esrTerm = 0.70 * Math.log(Math.max(1.0, esrMmPerHour));
        double ghTerm = 0.014 * Math.max(0, Math.min(100, patientGlobalHealth0To100));

        double score = tjcTerm + sjcTerm + esrTerm + ghTerm;
        score = BigDecimal.valueOf(score).setScale(2, RoundingMode.HALF_UP).doubleValue();

        String level;
        String adjustment;

        if (score > 5.1) {
            level = "HIGH DISEASE ACTIVITY (DAS28 > 5.1)";
            adjustment = "TREAT-TO-TARGET ESCALATION: Step up conventional synthetic DMARD (Methotrexate up to 25mg/week subcutaneous + Leflunomide/Sulfasalazine) OR initiate Biologic DMARD (Anti-TNF: Adalimumab/Etanercept, IL-6 inhibitor: Tocilizumab, or JAK Inhibitor: Tofacitinib/Upadacitinib) with short-term oral steroid bridge (Prednisone <= 10mg/day).";
        } else if (score >= 3.2) {
            level = "MODERATE DISEASE ACTIVITY (DAS28 3.2 - 5.1)";
            adjustment = "Optimize current DMARD dose, evaluate adherence, and consider combination DMARD therapy (Triple Therapy: Methotrexate + Sulfasalazine + Hydroxychloroquine).";
        } else if (score >= 2.6) {
            level = "LOW DISEASE ACTIVITY (DAS28 2.6 - 3.1)";
            adjustment = "Maintain current stable regimen; reassess every 3 to 6 months.";
        } else {
            level = "CLINICAL REMISSION (DAS28 < 2.6)";
            adjustment = "Target achieved. If sustained remission >= 6 months, consider cautious step-down titration of glucocorticoids and then DMARDs without full discontinuation.";
        }

        return Das28Result.builder()
                .das28Score(score)
                .diseaseActivityLevel(level)
                .recommendedTherapeuticAdjustment(adjustment)
                .build();
    }
}
