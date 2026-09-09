package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class TherapeuticDietaryPlanningCatalog {

    @Data
    @AllArgsConstructor
    public static class DietaryMenuProfile {
        private String dietCode;
        private String dietName;
        private String clinicalIndication;
        private String nutritionalParameters;
        private String iddsiTextureLevel;
    }

    private final Map<String, DietaryMenuProfile> menus = new LinkedHashMap<>();

    public TherapeuticDietaryPlanningCatalog() {
        menus.put("DIAB-1800", new DietaryMenuProfile("DIAB-1800", "Carbohydrate-Consistent Diabetic Diet", "Type 1 & 2 Diabetes Mellitus", "1800 kcal, 200g Carb, 60g Fat, 85g Protein", "Level 7 - Regular"));
        menus.put("RENAL-HEMO", new DietaryMenuProfile("RENAL-HEMO", "Hemodialysis Renal Diet", "End-Stage Renal Disease on HD", "High Protein (1.2g/kg), Low Potassium (< 2000mg), Low Phosphorus (< 800mg), Low Sodium (< 2000mg)", "Level 7 - Regular"));
        menus.put("DYSPHAGIA-PUR", new DietaryMenuProfile("DYSPHAGIA-PUR", "IDDSI Pureed Texture with Moderately Thick Liquids", "Post-Stroke Dysphagia / Oropharyngeal Aspiration Risk", "Homogeneous, non-sticky, cohesive puree", "Level 4 - Pureed / Level 3 - Liquid"));
    }

    public Optional<DietaryMenuProfile> getMenu(String code) { return Optional.ofNullable(menus.get(code)); }
}
