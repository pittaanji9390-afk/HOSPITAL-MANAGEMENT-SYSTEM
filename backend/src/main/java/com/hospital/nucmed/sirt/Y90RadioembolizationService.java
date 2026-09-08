package com.hospital.nucmed.sirt;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Yttrium-90 Selective Internal Radiation Therapy (SIRT) / Transarterial Radioembolization (TARE).
 * Uses Tc-99m Macroaggregated Albumin (MAA) scan to calculate Lung Shunt Fraction (LSF).
 * - LSF < 10%: Full activity (100%) permitted.
 * - LSF 10-15%: 20% dose reduction.
 * - LSF 15-20%: 40% dose reduction.
 * - LSF > 20% (or lung absorbed dose > 30 Gy single / 50 Gy cumulative): CONTRAINDICATED (Radiation Pneumonitis risk).
 */
@Service
public class Y90RadioembolizationService {

    public record MaaScanCounts(double totalLungCounts, double totalLiverCounts, double targetLiverMassGrams, double intendedTumorDoseGy) {}
    public record Y90DosimetryPlan(double lungShuntFractionPercent, double doseReductionFactor, boolean safeForRadioembolization, double recommendedY90ActivityGbg, String safetyWarning) {}

    public Y90DosimetryPlan calculateDosimetry(MaaScanCounts scan) {
        double lsf = (scan.totalLungCounts() / (scan.totalLungCounts() + scan.totalLiverCounts())) * 100.0;

        double factor = 1.0;
        boolean safe = true;
        String warning = "Safe for Y-90 administration.";

        if (lsf > 20.0) {
            safe = false;
            factor = 0.0;
            warning = "CONTRAINDICATED: Lung Shunt Fraction " + String.format("%.1f", lsf) + "% > 20%. Fatal radiation pneumonitis risk.";
        } else if (lsf > 15.0) {
            factor = 0.60;
            warning = "40% DOSE REDUCTION APPLIED: Lung Shunt Fraction between 15-20%.";
        } else if (lsf >= 10.0) {
            factor = 0.80;
            warning = "20% DOSE REDUCTION APPLIED: Lung Shunt Fraction between 10-15%.";
        }

        // MIRD Activity Formula approximation: Activity (GBq) = (Dose_Gy x Mass_kg) / 50
        double uncorrectedGbg = (scan.intendedTumorDoseGy() * (scan.targetLiverMassGrams() / 1000.0)) / 50.0;
        double finalActivityGbg = uncorrectedGbg * factor;

        return new Y90DosimetryPlan(lsf, factor, safe, finalActivityGbg, warning);
    }
}
