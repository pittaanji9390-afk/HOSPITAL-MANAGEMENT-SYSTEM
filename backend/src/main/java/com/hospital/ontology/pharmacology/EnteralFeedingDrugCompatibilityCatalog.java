package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class EnteralFeedingDrugCompatibilityCatalog {

    @Data
    @AllArgsConstructor
    public static class EnteralCompatibilityEntry {
        private String drugName;
        private boolean canCrushTablet;
        private boolean holdEnteralFeedBeforeAfter;
        private int holdDurationMinutes;
        private String recommendedFlushingVolumeMl;
        private String clinicalGuidance;
    }

    private final Map<String, EnteralCompatibilityEntry> entries = new LinkedHashMap<>();

    public EnteralFeedingDrugCompatibilityCatalog() {
        entries.put("Phenytoin", new EnteralCompatibilityEntry("Phenytoin Suspension", true, true, 120, "15-30 mL sterile water", "Hold tube feeding 2h before and 2h after to prevent protein binding absorption failure."));
        entries.put("Levothyroxine", new EnteralCompatibilityEntry("Levothyroxine", true, true, 60, "15-30 mL sterile water", "Hold enteral nutrition 1h before and 1h after."));
        entries.put("Ciprofloxacin", new EnteralCompatibilityEntry("Ciprofloxacin", true, true, 120, "30 mL sterile water", "Avoid co-administration with divalent cations (Ca, Mg, Fe) in feed formulas."));
    }

    public Optional<EnteralCompatibilityEntry> getEntry(String drug) { return Optional.ofNullable(entries.get(drug)); }
}
