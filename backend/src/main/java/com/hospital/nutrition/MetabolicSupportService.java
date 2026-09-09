package com.hospital.nutrition;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class MetabolicSupportService {

    public static record NutritionPlan(
            String patientId,
            double targetCaloriesKcalDay,
            double targetProteinGramsDay,
            boolean refeedingRisk,
            String electrolyteMonitoringOrder,
            Instant createdAt
    ) implements Serializable {}

    public NutritionPlan evaluateMetabolism(String patientId, double weightKg, double heightCm, int age, boolean ventilated, boolean malnourished) {
        // ASPEN 25-30 kcal/kg/day standard; 1.5 - 2.0 g/kg protein for critically ill
        double kcal = weightKg * (ventilated ? 22.0 : 28.0);
        double protein = weightKg * 1.5;

        String lytes = malnourished
                ? "HIGH REFEEDING RISK: Check stat Phosphate, Potassium, Magnesium prior to TPN/EN initiation; supplement IV Phosphate."
                : "Standard metabolic panel q24h.";

        return new NutritionPlan(patientId, Math.round(kcal), Math.round(protein), malnourished, lytes, Instant.now());
    }
}
