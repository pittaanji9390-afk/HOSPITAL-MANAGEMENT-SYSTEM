package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NocOutcomesTaxonomyCatalog {

    @Data
    @AllArgsConstructor
    public static class NocOutcome {
        private String code;
        private String outcomeName;
        private String domain;
        private String className;
        private String likertScaleType; // e.g., 1 (Severely Compromised) to 5 (Not Compromised)
        private List<String> keyIndicators;
    }

    private final Map<String, NocOutcome> outcomes = new LinkedHashMap<>();

    public NocOutcomesTaxonomyCatalog() {
        outcomes.put("0402", new NocOutcome("0402", "Respiratory Status: Gas Exchange", "Physiologic Health", "E. Cardiopulmonary",
            "1 (Severely Compromised) to 5 (Not Compromised)",
            List.of("PaO2 / Arterial oxygen tension", "PaCO2 / Arterial carbon dioxide tension", "Oxygen saturation SpO2 >=95%", "Absence of dyspnea at rest", "Absence of cyanosis")));

        outcomes.put("0400", new NocOutcome("0400", "Cardiac Pump Effectiveness", "Physiologic Health", "E. Cardiopulmonary",
            "1 (Severely Compromised) to 5 (Not Compromised)",
            List.of("Mean Arterial Pressure (MAP) 70-100 mmHg", "Cardiac Index 2.5-4.0 L/min/m2", "Urine output >=0.5 mL/kg/h", "Absence of peripheral edema", "Absence of S3 gallop")));

        outcomes.put("1101", new NocOutcome("1101", "Tissue Integrity: Skin & Mucous Membranes", "Physiologic Health", "L. Tissue Integrity",
            "1 (Severely Compromised) to 5 (Not Compromised)",
            List.of("Skin intactness over bony prominences", "Skin temperature and turgor", "Absence of erythema / necrosis", "Granulation tissue development")));

        outcomes.put("2102", new NocOutcome("2102", "Pain Level", "Functional Health", "V. Symptom Status",
            "1 (Severe Pain 8-10) to 5 (No Pain 0)",
            List.of("Reported pain intensity on NRS scale", "Absence of protective guarding behavior", "Resting heart rate in normal range", "Facial expression relaxed")));

        outcomes.put("1912", new NocOutcome("1912", "Fall Occurrence", "Safe Care Environment", "V. Risk Control",
            "1 (>6 Falls) to 5 (0 Falls)",
            List.of("Number of falls during inpatient shift", "Number of falls resulting in minor injury", "Number of falls resulting in major injury / fracture")));
    }

    public Optional<NocOutcome> getByCode(String code) { return Optional.ofNullable(outcomes.get(code)); }
    public List<NocOutcome> getAllOutcomes() { return new ArrayList<>(outcomes.values()); }
}
