package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NicInterventionsTaxonomyCatalog {

    @Data
    @AllArgsConstructor
    public static class NicIntervention {
        private String code;
        private String interventionName;
        private String domain;
        private String className;
        private List<String> clinicalActivities;
        private String requiredCompetency;
    }

    private final Map<String, NicIntervention> interventions = new LinkedHashMap<>();

    public NicInterventionsTaxonomyCatalog() {
        interventions.put("3140", new NicIntervention("3140", "Airway Management", "Physiological: Complex", "K. Respiratory Management",
            List.of("Assess airway patency and bilateral breath sounds", "Position patient in semi-Fowler position to maximize ventilation",
            "Perform endotracheal/tracheostomy suctioning as clinically indicated", "Administer humidified oxygen therapy per protocol"),
            "Critical Care Registered Nurse (CCRN)"));

        interventions.put("4150", new NicIntervention("4150", "Hemodynamic Regulation", "Physiological: Complex", "N. Tissue Perfusion Management",
            List.of("Zero and calibrate arterial line and CVP transducers", "Continuously titrate norepinephrine/epinephrine for MAP >=65 mmHg",
            "Assess cardiac index, stroke volume variation, and lactate levels", "Document response to passive leg raise fluid responsiveness test"),
            "ICU Advanced Practice Nurse"));

        interventions.put("3520", new NicIntervention("3520", "Pressure Ulcer Care", "Physiological: Complex", "L. Skin/Wound Management",
            List.of("Cleanse ulcer base with sterile normal saline", "Apply hydrocellular foam or alginate dressing per wound staging protocol",
            "Record wound dimensions: length, width, depth, tunneling in cm", "Maintain pressure redistribution surface on bed"),
            "Certified Wound Care Nurse (CWCN)"));

        interventions.put("2210", new NicIntervention("2210", "Analgesic Administration", "Physiological: Basic", "H. Drug Management",
            List.of("Verify 5 Rights of medication safety and 2-nurse independent check for high-alert opioids",
            "Evaluate baseline pain score using NRS or CPOT before administration", "Reassess and document pain score within 30 minutes of IV dose",
            "Monitor respiratory rate and sedation level (POSS score) continuously"),
            "Registered Nurse (RN)"));

        interventions.put("6440", new NicIntervention("6440", "Delirium Management", "Behavioral", "T. Cognitive Therapy",
            List.of("Perform CAM-ICU or ICDSC assessment every 8-hour shift", "Ensure visual and hearing aids are accessible to patient",
            "Maintain circadian light-dark cycle in patient room", "Promote early progressive mobilization and physical therapy within 24h"),
            "Staff Registered Nurse (RN)"));
    }

    public Optional<NicIntervention> getByCode(String code) { return Optional.ofNullable(interventions.get(code)); }
    public List<NicIntervention> getAllInterventions() { return new ArrayList<>(interventions.values()); }
}
