package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PediatricsCdssRulesEngine {

    @Data
    @Builder
    public static class PediatricDeteriorationAlert {
        private String babyOrChildMrn;
        private int pewsScore; // 0 - 9
        private String escalationAction;
        private int westleyCroupScore;
        private String croupManagementProtocol;
    }

    public PediatricDeteriorationAlert evaluatePediatricVitals(String mrn, int behavior, int cardiovascular, int respiratory, boolean isReceivingNebulizer, int stridor, int retractions, int airEntry, int cyanosis, int consciousness) {
        int pews = behavior + cardiovascular + respiratory + (isReceivingNebulizer ? 1 : 0);
        
        String pewsAction = pews >= 6 ? "RAPID RESPONSE TEAM (RRT) / PICU FELLOW CONSULT STAT" : (pews >= 4 ? "Charge Nurse Review & Urgent Pediatrician Assessment within 15 min" : "Routine nursing observations Q4H");

        int westley = stridor + retractions + airEntry + cyanosis + consciousness;
        String croupAction = westley >= 6 ? "SEVERE CROUP: Nebulized Racemic Epinephrine (0.5 mL of 2.25%) + Dexamethasone 0.6 mg/kg IV/PO. Admit to High Dependency Unit." : "MILD-TO-MODERATE CROUP: Single dose oral Dexamethasone 0.15 - 0.6 mg/kg. Cool mist observation.";

        return PediatricDeteriorationAlert.builder()
                .babyOrChildMrn(mrn)
                .pewsScore(pews)
                .escalationAction(pewsAction)
                .westleyCroupScore(westley)
                .croupManagementProtocol(croupAction)
                .build();
    }
}
