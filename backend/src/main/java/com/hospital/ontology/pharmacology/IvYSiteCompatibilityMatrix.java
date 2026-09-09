package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class IvYSiteCompatibilityMatrix {

    public enum CompatibilityStatus {
        COMPATIBLE,
        INCOMPATIBLE_PRECIPITATE_RISK,
        VARIABLE_DEPENDENT_ON_CONCENTRATION
    }

    @Data
    @AllArgsConstructor
    public static class YSitePair {
        private String drugA;
        private String drugB;
        private CompatibilityStatus status;
        private String incompatibilityMechanism;
    }

    private final List<YSitePair> pairs = new ArrayList<>();

    public IvYSiteCompatibilityMatrix() {
        pairs.add(new YSitePair("Furosemide", "Milrinone", CompatibilityStatus.INCOMPATIBLE_PRECIPITATE_RISK, "Immediate milky white particulate precipitation"));
        pairs.add(new YSitePair("Pantoprazole", "Midazolam", CompatibilityStatus.INCOMPATIBLE_PRECIPITATE_RISK, "Acid-base precipitation"));
        pairs.add(new YSitePair("Norepinephrine", "Vasopressin", CompatibilityStatus.COMPATIBLE, "Stable in standard D5W / NS infusions"));
    }

    public List<YSitePair> getAllPairs() { return pairs; }
}
