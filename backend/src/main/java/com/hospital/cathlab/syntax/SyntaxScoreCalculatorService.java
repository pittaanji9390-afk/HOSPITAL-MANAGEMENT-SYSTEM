package com.hospital.cathlab.syntax;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class SyntaxScoreCalculatorService {

    public enum Dominance { RIGHT, LEFT, CO_DOMINANT }

    public static record CoronaryLesion(
            int segmentNumber,
            double diameterStenosisPercent,
            boolean totalOcclusion,
            int occlusionAgeMonths,
            boolean bluntStump,
            boolean bridgingCollaterals,
            boolean bifurcation,
            int bifurcationMedinaType,
            boolean trifurcation,
            boolean aortoOstial,
            boolean severeTortuosity,
            boolean heavyCalcification,
            boolean thrombusPresent,
            boolean diffuseDiseaseLongSegment
    ) implements Serializable {}

    public static record SyntaxScoreResult(
            String patientId,
            double syntaxScoreI,
            String anatomicalTiert,
            double syntaxScoreIiCabg4YearMortality,
            double syntaxScoreIiPci4YearMortality,
            String heartTeamRecommendation,
            List<String> clinicalModifiers,
            Instant calculatedAt
    ) implements Serializable {}

    public SyntaxScoreResult calculateSyntax(
            String patientId,
            Dominance dominance,
            List<CoronaryLesion> lesions,
            int age,
            double creatinineClearanceMlMin,
            double lvefPercent,
            boolean copd,
            boolean peripheralVascularDisease,
            boolean female
    ) {
        double scoreI = 0.0;

        for (CoronaryLesion lesion : lesions) {
            double segmentWeight = getSegmentWeight(lesion.segmentNumber(), dominance);
            double lesionPoints = 0.0;

            if (lesion.totalOcclusion()) {
                lesionPoints += 5.0 * segmentWeight;
                if (lesion.occlusionAgeMonths() > 3) lesionPoints += 1.0;
                if (lesion.bluntStump()) lesionPoints += 1.0;
                if (lesion.bridgingCollaterals()) lesionPoints += 1.0;
            } else if (lesion.diameterStenosisPercent() >= 50.0) {
                lesionPoints += 2.0 * segmentWeight;
            }

            if (lesion.bifurcation()) {
                lesionPoints += (lesion.bifurcationMedinaType() == 111) ? 2.0 : 1.0;
            }
            if (lesion.trifurcation()) lesionPoints += 3.0;
            if (lesion.aortoOstial()) lesionPoints += 1.0;
            if (lesion.severeTortuosity()) lesionPoints += 2.0;
            if (lesion.heavyCalcification()) lesionPoints += 2.0;
            if (lesion.thrombusPresent()) lesionPoints += 1.0;
            if (lesion.diffuseDiseaseLongSegment()) lesionPoints += 1.0;

            scoreI += lesionPoints;
        }

        String tier;
        if (scoreI <= 22.0) {
            tier = "Low Anatomical Complexity (0 - 22)";
        } else if (scoreI <= 32.0) {
            tier = "Intermediate Anatomical Complexity (23 - 32)";
        } else {
            tier = "High Anatomical Complexity (>= 33)";
        }

        List<String> modifiers = new ArrayList<>();
        double pciMortalityBase = 4.2 + (scoreI * 0.32) + (age * 0.18) - (creatinineClearanceMlMin * 0.08) - (lvefPercent * 0.15);
        double cabgMortalityBase = 3.5 + (age * 0.16) - (creatinineClearanceMlMin * 0.06) - (lvefPercent * 0.12);

        if (copd) { pciMortalityBase += 4.5; cabgMortalityBase += 5.8; modifiers.add("COPD Present"); }
        if (peripheralVascularDisease) { pciMortalityBase += 5.0; cabgMortalityBase += 4.2; modifiers.add("PVD Present"); }
        if (female) { pciMortalityBase += 1.5; cabgMortalityBase += 2.1; modifiers.add("Female Sex Factor"); }

        double pciMortality = Math.max(1.5, Math.min(65.0, pciMortalityBase));
        double cabgMortality = Math.max(1.2, Math.min(60.0, cabgMortalityBase));

        String recommendation;
        if (scoreI >= 33.0 || cabgMortality < (pciMortality - 4.0)) {
            recommendation = "CABG strongly favored by Heart Team guidelines due to high anatomical complexity/SYNTAX II advantage.";
        } else if (scoreI <= 22.0 && pciMortality <= (cabgMortality + 2.0)) {
            recommendation = "PCI with Drug-Eluting Stents favored; lower procedural morbidity with equivalent 4-year survival.";
        } else {
            recommendation = "Equipoise: Both PCI and CABG offer comparable long-term survival.";
        }

        return new SyntaxScoreResult(
                patientId,
                round(scoreI, 1),
                tier,
                round(cabgMortality, 1),
                round(pciMortality, 1),
                recommendation,
                modifiers,
                Instant.now()
        );
    }

    private double getSegmentWeight(int seg, Dominance dom) {
        return switch (seg) {
            case 1 -> (dom == Dominance.LEFT) ? 0.0 : 1.0;
            case 2 -> (dom == Dominance.LEFT) ? 0.0 : 1.0;
            case 3 -> (dom == Dominance.LEFT) ? 0.0 : 1.0;
            case 5 -> 5.0;
            case 6 -> 3.5;
            case 7 -> 2.5;
            case 8 -> 1.0;
            case 11 -> (dom == Dominance.LEFT) ? 2.5 : 1.5;
            case 13 -> (dom == Dominance.LEFT) ? 2.0 : 0.5;
            default -> 1.0;
        };
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
