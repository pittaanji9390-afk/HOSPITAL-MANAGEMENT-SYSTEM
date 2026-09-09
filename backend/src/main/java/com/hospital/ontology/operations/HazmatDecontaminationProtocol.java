package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class HazmatDecontaminationProtocol {

    @Data
    @AllArgsConstructor
    public static class HazmatZoneDirective {
        private String zoneName; // HOT_ZONE, WARM_DECON_ZONE, COLD_CLEAN_ZONE
        private String ppeLevelRequired; // LEVEL_A, LEVEL_B, LEVEL_C, LEVEL_D
        private List<String> operationalProtocols;
    }

    public List<HazmatZoneDirective> getZoneDirectives() {
        return List.of(
            new HazmatZoneDirective("HOT_ZONE (Contaminated Entry)", "LEVEL_B (Vapor-protective suit & SCBA)", List.of("Gross liquid decontamination", "Cut away contaminated garments")),
            new HazmatZoneDirective("WARM_ZONE (Decontamination Corridor)", "LEVEL_C (Chemical-resistant coverall & PAPR)", List.of("Tepid water shower for 3-5 min with soap", "Copious eye irrigation with saline")),
            new HazmatZoneDirective("COLD_ZONE (Clean Hospital Treatment)", "LEVEL_D (Standard Hospital PPE)", List.of("Secondary medical assessment", "Transfer to Negative-Pressure Isolation Room"))
        );
    }
}
