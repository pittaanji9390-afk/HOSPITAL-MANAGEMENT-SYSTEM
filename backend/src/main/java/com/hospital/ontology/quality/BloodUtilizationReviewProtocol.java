package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class BloodUtilizationReviewProtocol {

    @Data
    @AllArgsConstructor
    public static class CrossmatchToTransfusionAudit {
        private String surgicalService;
        private int unitsCrossmatched;
        private int unitsTransfused;
        private double crossmatchToTransfusionRatioCt;
        private boolean isWithinBenchmarkLimit; // Target C/T <= 2.0
    }

    public CrossmatchToTransfusionAudit calculateCtRatio(String service, int crossmatched, int transfused) {
        double ratio = (double) crossmatched / Math.max(1, transfused);
        return new CrossmatchToTransfusionAudit(service, crossmatched, transfused, Math.round(ratio * 100.0) / 100.0, ratio <= 2.0);
    }
}
