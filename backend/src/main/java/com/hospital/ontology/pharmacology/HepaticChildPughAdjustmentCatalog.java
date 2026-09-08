package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class HepaticChildPughAdjustmentCatalog {

    @Data
    @AllArgsConstructor
    public static class HepaticDoseRule {
        private String drugCode;
        private String genericName;
        private String childPughASafeDose;
        private String childPughBReduction;
        private String childPughCContraindication;
    }

    private final Map<String, HepaticDoseRule> rules = new LinkedHashMap<>();

    public HepaticChildPughAdjustmentCatalog() {
        rules.put("HEP-001", new HepaticDoseRule("HEP-001", "Acetaminophen", "Max 2-3g/day", "Max 2g/day", "CONTRAINDICATED in acute hepatic failure"));
        rules.put("HEP-002", new HepaticDoseRule("HEP-002", "Morphine", "100% normal dose", "Reduce dose by 50%", "Avoid due to hepatic encephalopathy risk"));
        rules.put("HEP-003", new HepaticDoseRule("HEP-003", "Atorvastatin", "Standard dose", "Reduce initial dose to 10mg", "CONTRAINDICATED in active liver disease"));
    }

    public Optional<HepaticDoseRule> getRule(String code) { return Optional.ofNullable(rules.get(code)); }
}
