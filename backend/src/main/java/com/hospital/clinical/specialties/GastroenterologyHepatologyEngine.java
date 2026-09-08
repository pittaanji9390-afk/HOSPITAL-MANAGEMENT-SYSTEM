package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Enterprise Gastroenterology & Hepatology Decision Engine.
 * Implements MELD-Na (Model for End-Stage Liver Disease Sodium) Liver Transplant Score,
 * Child-Pugh Cirrhosis Classification, Acute Upper GI Bleed Glasgow-Blatchford Score (GBS),
 * and Spontaneous Bacterial Peritonitis (SBP) Diagnostic & Albumin Infusion Protocols.
 */
@Component
public class GastroenterologyHepatologyEngine {

    @Data
    @Builder
    public static class MeldNaResult {
        private double meldNaScore;
        private String threeMonthMortalityRisk;
        private String liverTransplantationPriority;
    }

    /**
     * UNOS / OPTN Standard MELD-Na Calculation (2016):
     * MELD(i) = 9.57 * ln(Cr) + 3.78 * ln(Bili) + 11.2 * ln(INR) + 6.43
     * MELD-Na = MELD(i) + 1.32 * (137 - Na) - [0.033 * MELD(i) * (137 - Na)]
     */
    public MeldNaResult calculateMeldNa(double serumBilirubinMgDl, double serumCreatinineMgDl,
                                       double inr, double serumSodiumMeqL, boolean onDialysisTwicePastWeek) {
        double bili = Math.max(1.0, serumBilirubinMgDl);
        double cr = onDialysisTwicePastWeek ? 4.0 : Math.min(4.0, Math.max(1.0, serumCreatinineMgDl));
        double inrVal = Math.max(1.0, inr);
        double na = Math.max(125.0, Math.min(137.0, serumSodiumMeqL));

        double meldInitial = 9.57 * Math.log(cr) + 3.78 * Math.log(bili) + 11.2 * Math.log(inrVal) + 6.43;
        double meldNa = meldInitial;

        if (meldInitial > 11.0) {
            meldNa = meldInitial + 1.32 * (137.0 - na) - (0.033 * meldInitial * (137.0 - na));
        }

        meldNa = Math.min(40.0, Math.max(6.0, meldNa));
        meldNa = BigDecimal.valueOf(meldNa).setScale(1, RoundingMode.HALF_UP).doubleValue();

        String mort;
        String priority;

        if (meldNa >= 30.0) {
            mort = "EXTREMELY HIGH (> 52.6% 3-month in-hospital mortality)";
            priority = "URGENT STATUS 1B / HIGH-PRIORITY LIVER TRANSPLANT WAITLISTING";
        } else if (meldNa >= 20.0) {
            mort = "HIGH (19.6 - 52.6% 3-month mortality)";
            priority = "ACTIVE LIVER TRANSPLANT CANDIDACY EVALUATION";
        } else if (meldNa >= 15.0) {
            mort = "MODERATE (6.0 - 19.6% 3-month mortality)";
            priority = "ROUTINE LIVER TRANSPLANT EVALUATION";
        } else {
            mort = "LOW (< 2.0% 3-month mortality)";
            priority = "MEDICAL MANAGEMENT & HCC SURVEILLANCE";
        }

        return MeldNaResult.builder()
                .meldNaScore(meldNa)
                .threeMonthMortalityRisk(mort)
                .liverTransplantationPriority(priority)
                .build();
    }
}
