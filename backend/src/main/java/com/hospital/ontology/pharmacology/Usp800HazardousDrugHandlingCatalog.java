package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Usp800HazardousDrugHandlingCatalog {

    @Data
    @AllArgsConstructor
    public static class HazardousDrugProfile {
        private String drugName;
        private String nioshCategory; // GROUP_1_ANTINEOPLASTIC, GROUP_2_NON_ANTINEOPLASTIC, GROUP_3_REPRODUCTIVE_RISK
        private boolean requiresCstdClosedSystem;
        private String mandatoryPpe;
        private String containmentEngineeringDirective;
    }

    private final List<HazardousDrugProfile> profiles = new ArrayList<>();

    public Usp800HazardousDrugHandlingCatalog() {
        profiles.add(new HazardousDrugProfile("Cisplatin", "GROUP_1_ANTINEOPLASTIC", true, "Double chemotherapy-rated gloves, ASTM-tested gown, eye protection", "Compounded in negative-pressure ISO Class 5 BSC/C-PEC"));
        profiles.add(new HazardousDrugProfile("Methotrexate", "GROUP_1_ANTINEOPLASTIC", true, "Double gloves, gown, mask with face shield", "Closed System Drug-Transfer Device (CSTD) mandatory for administration"));
        profiles.add(new HazardousDrugProfile("Finasteride", "GROUP_3_REPRODUCTIVE_RISK", false, "Single chemotherapy-rated glove for handling intact tablets", "Pregnant personnel must not handle crushed or broken tablets"));
    }

    public List<HazardousDrugProfile> getProfiles() { return profiles; }
}
