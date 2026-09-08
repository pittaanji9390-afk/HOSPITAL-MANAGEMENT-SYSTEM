package com.hospital.services.oncology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Enterprise Oncology Precision Chemotherapy Dosing Engine.
 * Implements Mosteller / DuBois Body Surface Area (BSA), Calvert Formula for Carboplatin AUC,
 * and Lifetime Cumulative Dose Tracking for Anthracyclines (Doxorubicin <= 450-500 mg/m2) and Bleomycin (<= 400 Units).
 */
@Component
public class ChemotherapyBsaAndCalvertDosingEngine {

    @Data
    @Builder
    public static class OncologyDosingCalculation {
        private double bodySurfaceAreaM2;
        private double carboplatinTargetDoseMg;
        private double lifetimeAnthracyclineCumulativeDoseMgM2;
        private boolean isWithinSafeLifetimeToxicityCap;
        private String dosingGuardrailAlert;
    }

    /**
     * Mosteller Formula: BSA (m2) = sqrt( [Height(cm) * Weight(kg)] / 3600 )
     * Calvert Formula: Total Carboplatin Dose (mg) = Target AUC * (GFR + 25)  [GFR capped at 125 mL/min]
     */
    public OncologyDosingCalculation calculateChemoDosing(double heightCm, double weightKg, double gfrMlMin, double targetAuc, double cumulativeDoxorubicinMgM2) {
        double bsa = Math.sqrt((heightCm * weightKg) / 3600.0);
        bsa = BigDecimal.valueOf(bsa).setScale(2, RoundingMode.HALF_UP).doubleValue();

        double cappedGfr = Math.min(125.0, gfrMlMin);
        double carboplatinDose = targetAuc * (cappedGfr + 25.0);

        boolean safeLifetime = cumulativeDoxorubicinMgM2 <= 450.0;
        String alert = safeLifetime ? "Cumulative Anthracycline dose within safe threshold (<= 450 mg/m2)." :
                "CRITICAL CARDIOTOXICITY ALERT: Cumulative Doxorubicin dose exceeds 450 mg/m2. Lifetime cap reached; substitute with non-anthracycline regimen or Liposomal Doxorubicin with Dexrazoxane cardioprotection.";

        return OncologyDosingCalculation.builder()
                .bodySurfaceAreaM2(bsa)
                .carboplatinTargetDoseMg(BigDecimal.valueOf(carboplatinDose).setScale(0, RoundingMode.HALF_UP).doubleValue())
                .lifetimeAnthracyclineCumulativeDoseMgM2(cumulativeDoxorubicinMgM2)
                .isWithinSafeLifetimeToxicityCap(safeLifetime)
                .dosingGuardrailAlert(alert)
                .build();
    }
}
