package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class BiomedicalWasteSegregationCatalog {

    @Data
    @AllArgsConstructor
    public static class WasteCategoryColor {
        private String colorCode; // YELLOW, RED, WHITE_TRANSLUCENT, BLUE
        private String wasteType;
        private List<String> itemExamples;
        private String treatmentAndDisposalMethod;
    }

    private final Map<String, WasteCategoryColor> categories = new LinkedHashMap<>();

    public BiomedicalWasteSegregationCatalog() {
        categories.put("YELLOW", new WasteCategoryColor("YELLOW", "Anatomical, Soiled & Cytotoxic Waste", List.of("Human anatomical tissues", "Blood-soaked gauze", "Expired cytotoxic drugs"), "High-temperature Incineration (> 1100°C)"));
        categories.put("RED", new WasteCategoryColor("RED", "Contaminated Recyclable Plastics", List.of("IV tubing sets", "Urine bags", "Plastic syringes without needles", "Vacutainers"), "Autoclaving / Hydroclaving followed by shredding"));
        categories.put("WHITE", new WasteCategoryColor("WHITE_TRANSLUCENT", "Sharps & Metallic Waste", List.of("Needles", "Scalpel blades", "Contaminated broken glass"), "Autoclaving and encapsulation in concrete sharps pit"));
        categories.put("BLUE", new WasteCategoryColor("BLUE", "Glassware & Metallic Implants", List.of("Medicine ampuls", "Vials", "Orthopedic implants"), "Disinfection with Sodium Hypochlorite and recycling"));
    }

    public Optional<WasteCategoryColor> getCategory(String color) { return Optional.ofNullable(categories.get(color)); }
}
