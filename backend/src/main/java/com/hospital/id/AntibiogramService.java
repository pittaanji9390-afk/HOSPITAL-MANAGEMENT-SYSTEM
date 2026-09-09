package com.hospital.id;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class AntibiogramService {

    public static record VancomycinAucResult(
            String patientId,
            double troughMgL,
            double peakMgL,
            double auc24, // Target 400 - 600 mg*h/L for MRSA
            boolean therapeutic,
            String doseAdjustmentAdvice,
            Instant calculatedAt
    ) implements Serializable {}

    public VancomycinAucResult calculateVancomycinAuc(String patientId, double trough, double peak, double doseMg, int intervalHours) {
        // Simplified trapezoidal / 2-point AUC estimation
        double kel = Math.log(peak / trough) / (intervalHours - 2.0);
        double auc24 = (doseMg / intervalHours) * 24.0 / (kel * 40.0);
        auc24 = Math.round(auc24);

        boolean ok = auc24 >= 400.0 && auc24 <= 600.0;
        String adv = auc24 > 600.0
                ? "HIGH AUC (>600): Elevated nephrotoxicity risk. Reduce dose or extend dosing interval."
                : auc24 < 400.0
                ? "SUBTHERAPEUTIC AUC (<400): Inadequate MRSA bactericidal killing. Increase daily dose."
                : "TARGET AUC ACHIEVED (400-600 mg*h/L). Maintain regimen with weekly SCr checks.";

        return new VancomycinAucResult(patientId, trough, peak, auc24, ok, adv, Instant.now());
    }
}
