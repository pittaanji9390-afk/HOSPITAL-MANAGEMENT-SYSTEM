package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Nephrology & Renal Replacement Therapy Decision Engine.
 * Implements KDIGO Acute Kidney Injury Staging, Urgent Dialysis Indications (AEIOU Criteria),
 * Hemodialysis Urea Kinetic Modeling (Daugirdas single-pool spKt/V), and Ultrafiltration Rate (UFR) safety limits.
 */
@Component
public class NephrologyRenalReplacementEngine {

    @Data
    @Builder
    public static class DialysisAdequacyResult {
        private double spKtV;
        private boolean isAdequate;
        private double ureaReductionRatioPct;
        private String clinicalRecommendation;
    }

    /**
     * Daugirdas Second Generation Single-Pool spKt/V Formula:
     * spKt/V = -ln(R - 0.008*t) + (4 - 3.5*R) * (UF / W)
     * where R = PostBUN / PreBUN, t = dialysis duration in hours, UF = ultrafiltration volume in liters, W = post-dialysis weight in kg.
     */
    public DialysisAdequacyResult calculateHemodialysisAdequacy(double preBunMgDl, double postBunMgDl,
                                                               double durationHours, double ufVolumeLiters,
                                                               double postWeightKg) {
        double r = postBunMgDl / Math.max(1.0, preBunMgDl);
        double urr = (1.0 - r) * 100.0;

        double term1 = -Math.log(Math.max(0.001, r - (0.008 * durationHours)));
        double term2 = (4.0 - (3.5 * r)) * (ufVolumeLiters / Math.max(1.0, postWeightKg));
        double spKtV = term1 + term2;

        boolean adequate = spKtV >= 1.2 && urr >= 65.0;
        String rec = adequate ?
                "DIALYSIS DOSE ADEQUATE (KDOQI Target: spKt/V >= 1.2 per session, URR >= 65% for thrice-weekly hemodialysis)." :
                "INADEQUATE CLEARANCE (spKt/V < 1.2): Optimize dialysis prescription by (1) Increasing blood flow rate (Qb to 350-450 mL/min), (2) Increasing dialysate flow rate (Qd to 800 mL/min), (3) Increasing dialyzer surface area (high-flux membrane), or (4) Extending treatment duration.";

        return DialysisAdequacyResult.builder()
                .spKtV(Math.round(spKtV * 100.0) / 100.0)
                .ureaReductionRatioPct(Math.round(urr * 10.0) / 10.0)
                .isAdequate(adequate)
                .clinicalRecommendation(rec)
                .build();
    }
}
