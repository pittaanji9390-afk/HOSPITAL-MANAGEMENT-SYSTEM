package com.hospital.services.emergency;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class EmergencyTraumaTriageEngine {

    @Data
    @Builder
    public static class EmergencyTriageReport {
        private String encounterId;
        private int esiLevel; // 1 (Resuscitation) to 5 (Non-urgent)
        private String triageCategory;
        private double revisedTraumaScoreRts;
        private boolean isMassiveTransfusionProtocolActivated;
        private String immediateClinicalDirectives;
    }

    public EmergencyTriageReport calculateEsiAndTrauma(String encounterId, boolean requiresImmediateLifesaving, boolean isHighRiskConfusedSeverePain, int projectedResources, int gcs, double systolicBp, int respRate) {
        int esi;
        String cat;
        if (requiresImmediateLifesaving) {
            esi = 1;
            cat = "RESUSCITATION_IMMEDIATE";
        } else if (isHighRiskConfusedSeverePain) {
            esi = 2;
            cat = "EMERGENT_HIGH_RISK";
        } else if (projectedResources >= 2) {
            esi = 3;
            cat = "URGENT_MULTIPLE_RESOURCES";
        } else if (projectedResources == 1) {
            esi = 4;
            cat = "LESS_URGENT_SINGLE_RESOURCE";
        } else {
            esi = 5;
            cat = "NON_URGENT";
        }

        double gcsCoded = gcs >= 13 ? 4 : (gcs >= 9 ? 3 : (gcs >= 6 ? 2 : (gcs >= 4 ? 1 : 0)));
        double sbpCoded = systolicBp > 89 ? 4 : (systolicBp >= 76 ? 3 : (systolicBp >= 50 ? 2 : (systolicBp >= 1 ? 1 : 0)));
        double rrCoded = (respRate >= 10 && respRate <= 29) ? 4 : (respRate > 29 ? 3 : (respRate >= 6 ? 2 : (respRate >= 1 ? 1 : 0)));

        double rts = (0.9368 * gcsCoded) + (0.7326 * sbpCoded) + (0.2908 * rrCoded);
        boolean mtp = rts < 6.0 || systolicBp < 90.0;

        return EmergencyTriageReport.builder()
                .encounterId(encounterId)
                .esiLevel(esi)
                .triageCategory(cat)
                .revisedTraumaScoreRts(Math.round(rts * 100.0) / 100.0)
                .isMassiveTransfusionProtocolActivated(mtp)
                .immediateClinicalDirectives(mtp ? "ACTIVATE MASSIVE TRANSFUSION PROTOCOL (1:1:1 PRBC:FFP:Platelets). Trauma Team Delta STAT." : "Establish 2x large bore 16G peripheral IVs, type & crossmatch 4 units PRBC.")
                .build();
    }
}
