package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SentinelEventRootCauseAnalysisEngine {

    @Data
    @AllArgsConstructor
    public static class RcaFishboneCase {
        private String incidentId;
        private String eventDescription;
        private List<String> peopleFactors;
        private List<String> processFactors;
        private List<String> equipmentFactors;
        private List<String> environmentalFactors;
        private String correctiveAndPreventiveActionCapa;
    }

    public RcaFishboneCase createRcaCase(String id, String desc) {
        return new RcaFishboneCase(
            id, desc,
            List.of("Fatigue", "Communication Handover Gap"),
            List.of("Incomplete Time Out", "Verbal Order Ambiguity"),
            List.of("Barcode Scanner Calibration Delay"),
            List.of("High Noise Level in Trauma Bay"),
            "Implement mandatory electronic barcode scanning and formal SBAR handover tool."
        );
    }
}
