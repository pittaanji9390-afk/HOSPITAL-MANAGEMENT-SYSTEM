package com.hospital.genetics.oncology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class BrafV600MelanomaTherapyEngine {

    @Data
    @AllArgsConstructor
    public static class BrafGuidance {
        private String patientId;
        private String brafStatus; // V600E, V600K, WILD_TYPE
        private String recommendedCombination;
    }

    public BrafGuidance evaluateBraf(String patientId, String status) {
        String combo = status.startsWith("V600") ? "Dabrafenib (Tafinlar) 150mg BID + Trametinib (Mekinist) 2mg Daily (BRAF + MEK Dual Inhibition)" : "Immune Checkpoint Blockade (Nivolumab + Ipilimumab)";
        return new BrafGuidance(patientId, status, combo);
    }
}
