package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class IsmpHighAlertMedicationRegistry {

    @Data
    @AllArgsConstructor
    public static class HighAlertItem {
        private String medicationClass;
        private List<String> commonAgents;
        private boolean isIndependentDoubleCheckMandatory;
        private String verificationChecklist;
    }

    private final List<HighAlertItem> registry = new ArrayList<>();

    public IsmpHighAlertMedicationRegistry() {
        registry.add(new HighAlertItem("Insulin (IV / SubQ)", List.of("Regular Insulin", "Glargine", "Lispro"), true, "Two licensed nurses independently verify patient, dose, syringe units, vial label, and pump rate."));
        registry.add(new HighAlertItem("Anticoagulants (IV Heparin)", List.of("Unfractionated Heparin", "Argatroban", "Bivalirudin"), true, "Verify baseline aPTT/Anti-Xa, bolus dose, continuous infusion rate, and smart pump drug library profile."));
        registry.add(new HighAlertItem("Neuromuscular Blockers", List.of("Rocuronium", "Vecuronium", "Cisatracurium"), true, "Mandatory verification that patient is mechanically ventilated and adequately sedated."));
    }

    public List<HighAlertItem> getRegistry() { return registry; }
}
