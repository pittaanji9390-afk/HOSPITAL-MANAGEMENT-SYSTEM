package com.hospital.surgery;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.*;

/**
 * Operating Theater Optimization & Block Scheduling Engine.
 * Calculates surgical duration estimates, turnover buffers, and ASA physical status stratification.
 */
@Component
public class SurgicalSchedulingOptimizationEngine {

    @Data
    @Builder
    public static class OrSlotEstimate {
        private String procedureName;
        private int estimatedSurgicalMinutes;
        private int anesthesiaInductionMinutes;
        private int orTurnoverAndCleaningMinutes;
        private int totalBlockTimeMinutes;
        private String asaRiskCategory;
    }

    public OrSlotEstimate estimateBlockTime(String procedureName, String asaGrade) {
        int surgTime;
        int anesthTime;
        int turnover = 25; // Standard 25 min cleaning & room setup

        String proc = procedureName.toLowerCase();
        if (proc.contains("cabg") || proc.contains("bypass")) {
            surgTime = 240;
            anesthTime = 45;
        } else if (proc.contains("knee") || proc.contains("hip") || proc.contains("arthroplasty")) {
            surgTime = 120;
            anesthTime = 30;
        } else if (proc.contains("cholecystectomy") || proc.contains("appendectomy")) {
            surgTime = 60;
            anesthTime = 20;
        } else {
            surgTime = 90;
            anesthTime = 25;
        }

        // ASA III-IV patients require longer induction/monitoring
        if (asaGrade != null && (asaGrade.contains("III") || asaGrade.contains("IV") || asaGrade.contains("V"))) {
            anesthTime += 15;
        }

        int total = surgTime + anesthTime + turnover;

        return OrSlotEstimate.builder()
                .procedureName(procedureName)
                .estimatedSurgicalMinutes(surgTime)
                .anesthesiaInductionMinutes(anesthTime)
                .orTurnoverAndCleaningMinutes(turnover)
                .totalBlockTimeMinutes(total)
                .asaRiskCategory(asaGrade != null ? asaGrade : "ASA_I")
                .build();
    }
}
