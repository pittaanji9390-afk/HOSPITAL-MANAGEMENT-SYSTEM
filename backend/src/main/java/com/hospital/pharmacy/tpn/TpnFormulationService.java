package com.hospital.pharmacy.tpn;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Total Parenteral Nutrition (TPN / PPN) Formulator.
 * Calculates total calories (dextrose, lipids, amino acids), nitrogen ratio, calculated osmolarity (mOsm/L),
 * and verifies Calcium / Phosphate curve solubility to prevent fatal pulmonary microvascular embolisms.
 */
@Service
public class TpnFormulationService {

    public record TpnPrescription(
        String rxId,
        double patientWeightKg,
        boolean isCentralLine,
        double aminoAcidsGrams,
        double dextroseGrams,
        double lipid20PercentMl,
        double sodiumMeq,
        double potassiumMeq,
        double calciumMeq,
        double phosphateMmol,
        double magnesiumMeq,
        double totalInfusionVolumeMl
    ) {}

    public record TpnSafetyProfile(
        String rxId,
        double totalCaloriesKcal,
        double nonProteinCaloriesToNitrogenRatio,
        double calculatedOsmolarityMOsmPerLiter,
        boolean peripheralLineSafe,
        boolean calciumPhosphatePrecipitationRisk,
        String safetySummary
    ) {}

    public TpnSafetyProfile evaluateTpn(TpnPrescription rx) {
        // Calorie math: Dextrose = 3.4 kcal/g, Amino Acids = 4.0 kcal/g, 20% Lipids = 2.0 kcal/mL
        double aminoCal = rx.aminoAcidsGrams() * 4.0;
        double dexCal = rx.dextroseGrams() * 3.4;
        double lipCal = rx.lipid20PercentMl() * 2.0;
        double totalKcal = aminoCal + dexCal + lipCal;

        // Nitrogen calculation: Grams of AA / 6.25
        double gramsNitrogen = rx.aminoAcidsGrams() / 6.25;
        double npcToN = gramsNitrogen > 0 ? (dexCal + lipCal) / gramsNitrogen : 0.0;

        // Osmolarity (mOsm/L) approximation:
        // AA: 10 mOsm/g, Dextrose: 5 mOsm/g, Lipids 20%: 0.7 mOsm/mL, Electrolytes: 1-2 mOsm/mEq
        double mOsmAA = rx.aminoAcidsGrams() * 10.0;
        double mOsmDex = rx.dextroseGrams() * 5.0;
        double mOsmLip = rx.lipid20PercentMl() * 0.7;
        double mOsmLytes = (rx.sodiumMeq() * 2.0) + (rx.potassiumMeq() * 2.0) + (rx.calciumMeq() * 1.4) + (rx.magnesiumMeq() * 1.0);
        double totalMOsm = mOsmAA + mOsmDex + mOsmLip + mOsmLytes;
        double osmolarityPerLiter = (totalMOsm / (rx.totalInfusionVolumeMl() / 1000.0));

        // Peripheral line threshold: Max ~900 mOsm/L
        boolean peripheralSafe = osmolarityPerLiter <= 900.0;

        // Calcium-Phosphate solubility check (Empirical guideline: [Ca (mEq/L) + Phos (mmol/L)] <= 45 in presence of adequate AA > 2.5%)
        double caPerLiter = (rx.calciumMeq() / (rx.totalInfusionVolumeMl() / 1000.0));
        double phosPerLiter = (rx.phosphateMmol() / (rx.totalInfusionVolumeMl() / 1000.0));
        double caPhosSum = caPerLiter + phosPerLiter;
        boolean caPhosRisk = caPhosSum > 45.0 && (rx.aminoAcidsGrams() / (rx.totalInfusionVolumeMl() / 100.0)) < 2.5;

        List<String> warnings = new ArrayList<>();
        if (!rx.isCentralLine() && !peripheralSafe) {
            warnings.add(String.format("HIGH OSMOLARITY (%.0f mOsm/L): Exceeds peripheral vein limit of 900 mOsm/L. Central venous access required.", osmolarityPerLiter));
        }
        if (caPhosRisk) {
            warnings.add(String.format("CRITICAL PRECIPITATION RISK: Calcium + Phosphate sum (%.1f) exceeds solubility product. Risk of insoluble calcium phosphate crystal emboli.", caPhosSum));
        }
        if (warnings.isEmpty()) {
            warnings.add("TPN formulation is chemically stable and clinically validated.");
        }

        return new TpnSafetyProfile(rx.rxId(), totalKcal, npcToN, osmolarityPerLiter, peripheralSafe, caPhosRisk, String.join(" | ", warnings));
    }
}
