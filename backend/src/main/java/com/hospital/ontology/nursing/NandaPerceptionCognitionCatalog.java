package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaPerceptionCognitionCatalog {

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

    public NandaPerceptionCognitionCatalog() {
        diagnoses.put("00128", new NandaDiagnosis("00128", "Acute Confusion (Delirium)", "Perception/Cognition", "4. Cognition",
            List.of("Fluctuating CAM-ICU positive score", "Inattention and disorganized thinking", "Altered level of consciousness (RASS +2 to -2)", "Hallucinations"),
            List.of("Severe sepsis", "Sedative/anticholinergic medication toxicity", "Hypoxia / metabolic encephalopathy", "Sensory deprivation / sleep fragmentation"),
            List.of("Delirium Management (6440)", "Reality Orientation (4880)", "Environmental Management (6480)", "Early Mobility (0221)"),
            List.of("Cognitive Orientation (0901)", "Neurological Status: Consciousness (0900)", "Safety Behavior: Personal (1911)")));

        diagnoses.put("00131", new NandaDiagnosis("00131", "Impaired Memory", "Perception/Cognition", "4. Cognition",
            List.of("Inability to recall recent events", "Inability to learn new medical instructions", "Forgetting medication times", "Confabulation"),
            List.of("Alzheimer dementia / vascular dementia", "Traumatic brain injury (TBI)", "Anoxic brain injury post-cardiac arrest"),
            List.of("Memory Training (4760)", "Reminiscence Therapy (5400)", "Dementia Management (6450)"),
            List.of("Memory (0908)", "Information Processing (0907)", "Self-Management: Dementia (3103)")));

        diagnoses.put("00051", new NandaDiagnosis("00051", "Impaired Verbal Communication", "Perception/Cognition", "5. Communication",
            List.of("Expressive/receptive aphasia", "Inability to speak due to endotracheal tube / tracheostomy", "Dysarthria / slurred speech"),
            List.of("Left hemispheric MCA stroke", "Mechanical intubation", "Amyotrophic lateral sclerosis (ALS)"),
            List.of("Communication Enhancement: Speech Deficit (4976)", "Augmentative Communication Board (4978)", "Active Listening (4920)"),
            List.of("Communication: Expressive (0903)", "Communication: Receptive (0904)", "Psychosocial Adaptation (1300)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
