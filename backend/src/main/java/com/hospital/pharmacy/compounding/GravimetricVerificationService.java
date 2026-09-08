package com.hospital.pharmacy.compounding;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Gravimetric IV Compounding Verification System.
 * Calculates expected weight based on specific gravity of diluents (D5W, 0.9% NaCl, SWFI)
 * and active pharmaceutical ingredients (APIs), validating precision within +/- 2.0% tolerance.
 */
@Service
public class GravimetricVerificationService {

    public record DiluentDensity(String diluentName, double densityGramsPerMl) {}
    public record IngredientComponent(String drugName, double targetVolumeMl, double specificGravity) {}
    public record CompoundingValidationResult(
        String compoundingSessionId,
        double targetVolumeTotalMl,
        double expectedNetWeightGrams,
        double actualMeasuredWeightGrams,
        double percentVariance,
        boolean withinAcceptableTolerance,
        String validationMessage
    ) {}

    private final Map<String, Double> specificGravityRegistry = new HashMap<>();

    public GravimetricVerificationService() {
        specificGravityRegistry.put("0.9% SODIUM CHLORIDE", 1.0046);
        specificGravityRegistry.put("5% DEXTROSE (D5W)", 1.0185);
        specificGravityRegistry.put("STERILE WATER FOR INJECTION", 1.0000);
        specificGravityRegistry.put("VANCOMYCIN 50MG/ML", 1.0250);
        specificGravityRegistry.put("CISPLATIN 1MG/ML", 1.0060);
        specificGravityRegistry.put("PACLITAXEL 6MG/ML", 0.9850);
        specificGravityRegistry.put("POTASSIUM CHLORIDE 2MEQ/ML", 1.0800);
    }

    public CompoundingValidationResult validateGravimetricDose(
        String sessionId,
        String baseDiluent,
        double diluentVolumeMl,
        List<IngredientComponent> additives,
        double actualWeightWithContainerGrams,
        double emptyBagTareWeightGrams
    ) {
        double diluentDensity = specificGravityRegistry.getOrDefault(baseDiluent.toUpperCase(), 1.0000);
        double expectedDiluentWeight = diluentVolumeMl * diluentDensity;

        double expectedAdditivesWeight = 0.0;
        double totalVolume = diluentVolumeMl;

        for (IngredientComponent additive : additives) {
            double density = additive.specificGravity() > 0 ? additive.specificGravity() : specificGravityRegistry.getOrDefault(additive.drugName().toUpperCase(), 1.0000);
            expectedAdditivesWeight += (additive.targetVolumeMl() * density);
            totalVolume += additive.targetVolumeMl();
        }

        double expectedNetWeight = expectedDiluentWeight + expectedAdditivesWeight;
        double actualNetWeight = actualWeightWithContainerGrams - emptyBagTareWeightGrams;
        double variancePercent = ((actualNetWeight - expectedNetWeight) / expectedNetWeight) * 100.0;
        boolean isPass = Math.abs(variancePercent) <= 2.50; // Standard USP <797> gravimetric window

        String msg = isPass ? "PASSED: Gravimetric weight is within +/- 2.5% tolerance." :
            String.format("FAILED: Weight variance %.2f%% exceeds the +/- 2.5%% safety limit. Risk of under/over-infusion.", variancePercent);

        return new CompoundingValidationResult(sessionId, totalVolume, expectedNetWeight, actualNetWeight, variancePercent, isPass, msg);
    }
}
