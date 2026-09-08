package com.hospital.bloodbank.hemovigilance;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * CDC NHSN Hemovigilance Module Adverse Transfusion Reaction Classifier.
 * Distinguishes Transfusion-Related Acute Lung Injury (TRALI Type I/II) from Transfusion-Associated
 * Circulatory Overload (TACO), Acute Hemolytic Transfusion Reaction (AHTR), and Febrile Non-Hemolytic Reactions (FNHTR).
 */
@Service
public class HemovigilanceService {

    public enum TransfusionReactionType { TRALI, TACO, ACUTE_HEMOLYTIC_AHTR, FEBRILE_NON_HEMOLYTIC_FNHTR, ALLERGIC_ANAPHYLACTIC, TRANSFUSION_SEPSIS_BACTERIAL }
    public record TransfusionReactionReport(
        String reactionId,
        String unitDin,
        TransfusionReactionType probableType,
        String severityGrade,
        boolean immediateTransfusionHaltMandated,
        String cliaLaboratoryInvestigationWorkup
    ) {}

    public TransfusionReactionReport evaluateReaction(
        boolean acuteDyspnea,
        boolean bilateralPulmonaryInfiltrates,
        boolean elevatedBnp,
        boolean elevatedJvpHypertension,
        boolean responseToDiuretics,
        boolean feverChills,
        boolean hemoglobinuriaPinkPlasma,
        boolean directAntiglobulinDatPositive
    ) {
        TransfusionReactionType type;
        String severity = "SEVERE (GRADE 3)";

        if (hemoglobinuriaPinkPlasma || directAntiglobulinDatPositive) {
            type = TransfusionReactionType.ACUTE_HEMOLYTIC_AHTR;
            severity = "LIFE-THREATENING (GRADE 4: CLERICAL / ABO INCOMPATIBILITY)";
        } else if (acuteDyspnea && bilateralPulmonaryInfiltrates && (elevatedBnp || elevatedJvpHypertension || responseToDiuretics)) {
            type = TransfusionReactionType.TACO;
        } else if (acuteDyspnea && bilateralPulmonaryInfiltrates && !elevatedBnp && !elevatedJvpHypertension) {
            type = TransfusionReactionType.TRALI;
        } else if (feverChills && !hemoglobinuriaPinkPlasma) {
            type = TransfusionReactionType.FEBRILE_NON_HEMOLYTIC_FNHTR;
            severity = "MODERATE (GRADE 2)";
        } else {
            type = TransfusionReactionType.ALLERGIC_ANAPHYLACTIC;
            severity = "MILD (GRADE 1)";
        }

        String workup = "Mandatory: Send remaining unit + blood bag tubing + post-transfusion EDTA whole blood + urine for DAT, Visual Hemolysis, Repeat ABO/Rh and Clerical Re-check.";

        return new TransfusionReactionReport("RXN-" + UUID.randomUUID().toString().substring(0, 8), "W0123-26-881920", type, severity, true, workup);
    }
}
