package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class HypoglycemiaProtocolEngine {

    @Data
    @Builder
    public static class HypoglycemiaCorrectionOrder {
        private String patientMrn;
        private double pointOfCareGlucoseMgDl;
        private boolean isConsciousAndAbleToSwallow;
        private String immediateTreatmentAction;
        private int recheckIntervalMinutes;
        private String secondaryEscalationPlan;
    }

    public HypoglycemiaCorrectionOrder evaluateHypoglycemia(String mrn, double glucose, boolean canSwallow) {
        String action;
        if (canSwallow && glucose >= 54.0 && glucose < 70.0) {
            action = "Administer 15-20 grams of fast-acting oral carbohydrates (4 oz fruit juice / 4 glucose tablets). Hold rapid-acting insulin.";
        } else if (glucose < 54.0 || !canSwallow) {
            action = "CRITICAL HYPOGLYCEMIA: Administer Dextrose 50% (D50W) 25 grams (50 mL) IV push over 2-3 minutes. If no IV access, administer Glucagon 1 mg IM/SC.";
        } else {
            action = "Blood glucose normal (>= 70 mg/dL). Resume routine bedside glucose monitoring schedule.";
        }

        return HypoglycemiaCorrectionOrder.builder()
                .patientMrn(mrn)
                .pointOfCareGlucoseMgDl(glucose)
                .isConsciousAndAbleToSwallow(canSwallow)
                .immediateTreatmentAction(action)
                .recheckIntervalMinutes(15)
                .secondaryEscalationPlan("Recheck capillary blood glucose in exactly 15 minutes. If glucose remains < 70 mg/dL, repeat Rule-of-15 protocol.")
                .build();
    }
}
