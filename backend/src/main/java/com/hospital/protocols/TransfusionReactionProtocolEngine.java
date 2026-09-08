package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TransfusionReactionProtocolEngine {

    @Data
    @Builder
    public static class TransfusionReactionReport {
        private String unitBarcode;
        private String patientMrn;
        private String suspectedReactionType; // ACUTE_HEMOLYTIC, FEBRILE_NON_HEMOLYTIC, ALLERGIC, TRALI, TACO, SEPSIS
        private boolean isLifeThreatening;
        private List<String> mandatoryImmediateActions;
        private String laboratoryWorkupDirectives;
    }

    public TransfusionReactionReport evaluateReaction(String unitId, String mrn, double tempRiseCelsius, boolean hasHives, boolean hasDyspnea, boolean hasHypotension, boolean hasHemoglobinuria) {
        String reaction = "FEBRILE_NON_HEMOLYTIC";
        boolean lifeThreatening = false;

        if (hasHypotension && hasHemoglobinuria) {
            reaction = "ACUTE_HEMOLYTIC_TRANSFUSION_REACTION";
            lifeThreatening = true;
        } else if (hasDyspnea && hasHypotension) {
            reaction = "TRANSFUSION_RELATED_ACUTE_LUNG_INJURY_TRALI";
            lifeThreatening = true;
        } else if (hasDyspnea && !hasHypotension) {
            reaction = "TRANSFUSION_ASSOCIATED_CIRCULATORY_OVERLOAD_TACO";
        } else if (hasHives && tempRiseCelsius < 1.0) {
            reaction = "MILD_ALLERGIC_URTICARIAL";
        }

        return TransfusionReactionReport.builder()
                .unitBarcode(unitId)
                .patientMrn(mrn)
                .suspectedReactionType(reaction)
                .isLifeThreatening(lifeThreatening)
                .mandatoryImmediateActions(List.of(
                    "STOP TRANSFUSION IMMEDIATELY. Disconnect tubing from IV catheter.",
                    "Maintain IV access with new tubing and 0.9% Normal Saline at KVO.",
                    "Perform clerical check of blood unit label, patient ID band, and transfusion tag.",
                    "Notify Blood Bank and Attending Physician STAT."
                ))
                .laboratoryWorkupDirectives("Send blood unit bag, IV administration set, post-transfusion blood specimen (EDTA + Clot), and first voided urine to Blood Bank for DAT, free hemoglobin, and repeat crossmatch.")
                .build();
    }
}
