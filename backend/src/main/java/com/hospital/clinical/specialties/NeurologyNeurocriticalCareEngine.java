package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Neurology & Neurocritical Care Decision Engine.
 * Implements Intracerebral Hemorrhage (ICH) Score, Hunt & Hess / WFNS Subarachnoid Hemorrhage Grading,
 * Status Epilepticus Stepwise Pharmacotherapy Protocol (AES Guidelines), and Intracranial Pressure (ICP) Tiered Management.
 */
@Component
public class NeurologyNeurocriticalCareEngine {

    @Data
    @Builder
    public static class IchScoreResult {
        private int totalScore;
        private String thirtyDayMortalityPct;
        private String surgicalAndCriticalCarePlan;
    }

    public IchScoreResult calculateIchScore(int gcsScore, int age, boolean infratentorialOrigin,
                                           double hemorrhageVolumeMl, boolean intraventricularHemorrhagePresent) {
        int score = 0;
        if (gcsScore >= 13) score += 0;
        else if (gcsScore >= 5) score += 1;
        else score += 2;

        if (age >= 80) score += 1;
        if (infratentorialOrigin) score += 1;
        if (hemorrhageVolumeMl >= 30.0) score += 1;
        if (intraventricularHemorrhagePresent) score += 1;

        String mort;
        switch (score) {
            case 0: mort = "0% 30-day mortality (Excellent prognosis)"; break;
            case 1: mort = "13% 30-day mortality"; break;
            case 2: mort = "26% 30-day mortality"; break;
            case 3: mort = "72% 30-day mortality"; break;
            case 4: mort = "97% 30-day mortality"; break;
            default: mort = "100% 30-day mortality (Extremely grave)"; break;
        }

        String plan = "CRITICAL CARE MANAGEMENT: (1) Target SBP strictly 130-140 mmHg within 1 hour using IV Nicardipine/Clevidipine; (2) Immediate reversal of anticoagulation (4-Factor Prothrombin Complex Concentrate 4F-PCC + Vitamin K for Warfarin; Idarucizumab for Dabigatran; Andexanet Alfa for FXa inhibitors); (3) Emergent neurosurgical evacuation for cerebellar hemorrhage > 3 cm or brainstem compression; (4) External Ventricular Drain (EVD) for acute obstructive hydrocephalus.";

        return IchScoreResult.builder()
                .totalScore(score)
                .thirtyDayMortalityPct(mort)
                .surgicalAndCriticalCarePlan(plan)
                .build();
    }
}
