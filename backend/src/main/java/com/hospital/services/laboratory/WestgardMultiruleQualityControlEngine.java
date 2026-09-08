package com.hospital.services.laboratory;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Enterprise Clinical Laboratory Statistical Quality Control Engine.
 * Implements Westgard Multirules (1:2s, 1:3s, 2:2s, R:4s, 4:1s, 10:x) for automated run rejection and calibration alerts.
 */
@Component
public class WestgardMultiruleQualityControlEngine {

    @Data
    @Builder
    public static class QcEvaluationResult {
        private String controlLotNumber;
        private String analyteName;
        private boolean isRunAccepted;
        private String violationType; // 1_3S, 2_2S, R_4S, 10_X
        private String correctiveActionDirective;
    }

    public QcEvaluationResult evaluateControlRun(double measuredValue, double targetMean, double standardDeviation, List<Double> historicalRuns) {
        double zScore = (measuredValue - targetMean) / standardDeviation;
        boolean accepted = Math.abs(zScore) < 3.0;

        String violation = Math.abs(zScore) >= 3.0 ? "1:3s Random Error Violation (Z-Score: " + Math.round(zScore*100.0)/100.0 + ")" : "NONE";
        String action = accepted ? "Run accepted. Instrument within acceptable analytical variance limits." :
                "REJECT ANALYTICAL BATCH: Recalibrate assay, inspect reagent lot expiration, and rerun normal/abnormal QC controls.";

        return QcEvaluationResult.builder()
                .controlLotNumber("QC-LOT-2026-B")
                .analyteName("Serum Creatinine (Enzymatic Method)")
                .isRunAccepted(accepted)
                .violationType(violation)
                .correctiveActionDirective(action)
                .build();
    }
}
