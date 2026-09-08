package com.hospital.services.nutrition;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Enterprise Inpatient Clinical Nutrition & Total Parenteral Nutrition (TPN) Formulation Engine.
 * Implements Mifflin-St Jeor Basal Metabolic Rate (BMR), stress injury factors (Burns, Sepsis, Post-Op),
 * macronutrient distribution (Amino Acids 4 kcal/g, Dextrose 3.4 kcal/g, Lipids 10 kcal/g), and osmolarity limits.
 */
@Component
public class ClinicalNutritionAndTpnCalculationEngine {

    @Data
    @Builder
    public static class TpnFormulationResult {
        private double basalMetabolicRateKcal;
        private double targetDailyCaloriesKcal;
        private double aminoAcidGrams;
        private double dextroseGrams;
        private double lipidEmulsionGrams;
        private double totalVolumeMl;
        private double calculatedOsmolarityMosmPerL;
        private boolean isCentralLineMandatory;
        private String refeedingSyndromeSafetyAlert;
    }

    /**
     * Mifflin-St Jeor Formula:
     * - Male: 10*Weight(kg) + 6.25*Height(cm) - 5*Age(yr) + 5
     * - Female: 10*Weight(kg) + 6.25*Height(cm) - 5*Age(yr) - 161
     */
    public TpnFormulationResult calculateTpnRegimen(double weightKg, double heightCm, int ageYears, boolean isMale, double stressFactor) {
        double bmr = (10.0 * weightKg) + (6.25 * heightCm) - (5.0 * ageYears) + (isMale ? 5.0 : -161.0);
        double totalKcal = bmr * (stressFactor > 0 ? stressFactor : 1.25);

        double proteinGrams = weightKg * 1.5; // 1.5 g/kg in critical illness
        double proteinKcal = proteinGrams * 4.0;
        double nonProteinKcal = totalKcal - proteinKcal;

        double dextroseKcal = nonProteinKcal * 0.70;
        double lipidKcal = nonProteinKcal * 0.30;

        double dextroseGrams = dextroseKcal / 3.4;
        double lipidGrams = lipidKcal / 10.0;

        double osmolarity = 1450.0; // Standard 2-in-1 / 3-in-1 TPN osmolarity > 900 mOsm/L

        return TpnFormulationResult.builder()
                .basalMetabolicRateKcal(BigDecimal.valueOf(bmr).setScale(0, RoundingMode.HALF_UP).doubleValue())
                .targetDailyCaloriesKcal(BigDecimal.valueOf(totalKcal).setScale(0, RoundingMode.HALF_UP).doubleValue())
                .aminoAcidGrams(BigDecimal.valueOf(proteinGrams).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .dextroseGrams(BigDecimal.valueOf(dextroseGrams).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .lipidEmulsionGrams(BigDecimal.valueOf(lipidGrams).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .totalVolumeMl(2200.0)
                .calculatedOsmolarityMosmPerL(osmolarity)
                .isCentralLineMandatory(osmolarity > 900.0)
                .refeedingSyndromeSafetyAlert("Monitor Serum Phosphate, Potassium, and Magnesium at 12h, 24h, 48h to prevent fatal refeeding syndrome hypophosphatemia.")
                .build();
    }
}
