package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaSafetyProtectionCatalog {

    @Data
    @AllArgsConstructor
    public static class NandaDiagnosis {
        private String code;
        private String diagnosisName;
        private String domain;
        private String classNumber;
        private List<String> definingCharacteristics;
        private List<String> relatedFactors;
        private List<String> suggestedNicInterventions;
        private List<String> targetNocOutcomes;
    }

    private final Map<String, NandaDiagnosis> diagnoses = new LinkedHashMap<>();

    public NandaSafetyProtectionCatalog() {
        diagnoses.put("00004", new NandaDiagnosis("00004", "Risk for Infection", "Safety/Protection", "1. Infection",
            List.of("N/A (Risk Diagnosis): Invasive lines present (CVC, Foley, ETT)", "Neutropenia ANC <500", "Immunosuppressive therapy"),
            List.of("Invasive procedures", "Chronic disease (DM, ESRD)", "Malnutrition", "Breaks in skin integrity"),
            List.of("Infection Control (6540)", "Infection Protection (6550)", "Wound Care: Aseptic (3660)", "Central Line Bundle (2440)"),
            List.of("Immune Status (0702)", "Infection Severity (0703)", "Risk Control: Infectious Process (1924)")));

        diagnoses.put("00155", new NandaDiagnosis("00155", "Risk for Falls", "Safety/Protection", "2. Physical Injury",
            List.of("N/A (Risk Diagnosis): Morse Fall Scale score >=45", "Age >=65", "History of previous falls", "Sedative medications"),
            List.of("Altered mental status / delirium", "Lower extremity weakness", "Orthostatic hypotension", "Urinary urgency with gait instability"),
            List.of("Fall Prevention (6490)", "Environmental Safety (6486)", "Bed Alarm Monitoring (6492)", "Gait Training Assistance (0222)"),
            List.of("Fall Occurrence (1912)", "Safe Home/Hospital Environment (1909)", "Balance (0202)")));

        diagnoses.put("00046", new NandaDiagnosis("00046", "Impaired Skin Integrity", "Safety/Protection", "2. Physical Injury",
            List.of("Disruption of epidermal/dermal skin layer", "Stage 2 pressure injury with blister/abrasion", "Surgical wound dehiscence"),
            List.of("Braden scale <=14", "External shear & friction forces", "Incontinence-associated dermatitis (IAD)", "Hypoperfusion"),
            List.of("Pressure Ulcer Care (3520)", "Skin Surveillance (3590)", "Pressure Management: Alternating Air Mattress (0842)"),
            List.of("Tissue Integrity: Skin & Mucous Membranes (1101)", "Wound Healing: Primary/Secondary Intention (1102)")));

        diagnoses.put("00039", new NandaDiagnosis("00039", "Risk for Aspiration", "Safety/Protection", "2. Physical Injury",
            List.of("N/A (Risk Diagnosis): Depressed gag/cough reflex", "Impaired swallowing", "Enteral tube feeding in progress"),
            List.of("Reduced consciousness (GCS <=8)", "Facial trauma / endotracheal intubation", "Delayed gastric emptying"),
            List.of("Aspiration Precautions (3200)", "Positioning: Head of Bed 30-45 deg (0840)", "Suctioning: Airway (3160)"),
            List.of("Aspiration Prevention (1918)", "Respiratory Status: Airway Patency (0410)", "Neurological Status (0900)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
