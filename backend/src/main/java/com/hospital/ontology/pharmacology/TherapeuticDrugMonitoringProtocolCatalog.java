package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class TherapeuticDrugMonitoringProtocolCatalog {

    @Data
    @AllArgsConstructor
    public static class TdmTargetRange {
        private String medication;
        private String samplingTiming;
        private String therapeuticTargetRange;
        private String toxicThreshold;
        private String dosageAdjustmentAction;
    }

    private final Map<String, TdmTargetRange> targets = new LinkedHashMap<>();

    public TherapeuticDrugMonitoringProtocolCatalog() {
        targets.put("Vancomycin", new TdmTargetRange("Vancomycin", "Trough within 30 min prior to 4th dose", "AUC/MIC 400-600 (or trough 15-20 mcg/mL)", "> 20 mcg/mL (Nephrotoxicity)", "Hold or reduce frequency to Q18H/Q24H"));
        targets.put("Tacrolimus", new TdmTargetRange("Tacrolimus", "12-hour trough level", "5 - 15 ng/mL (depending on organ & post-transplant time)", "> 20 ng/mL (Tremor, Nephrotoxicity)", "Adjust oral BID dose by 20-25%"));
        targets.put("Digoxin", new TdmTargetRange("Digoxin", "6-8 hours post-dose (or prior to next dose)", "0.5 - 0.9 ng/mL for Heart Failure", "> 2.0 ng/mL (Fatal arrhythmias)", "Hold dose; evaluate Serum Potassium & Magnesium"));
    }

    public Optional<TdmTargetRange> getTarget(String med) { return Optional.ofNullable(targets.get(med)); }
}
