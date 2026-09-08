package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaCopingStressCatalog {

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

    public NandaCopingStressCatalog() {
        diagnoses.put("00146", new NandaDiagnosis("00146", "Anxiety", "Coping/Stress Tolerance", "2. Coping Responses",
            List.of("Tachycardia >100 bpm", "Diaphoresis", "Verbalized fear of death/surgery", "Restlessness / trembling", "Insomnia"),
            List.of("Threat of impending surgical procedure", "Critical illness diagnosis", "Uncertain prognosis", "Financial catastrophe"),
            List.of("Anxiety Reduction (5820)", "Calming Technique (5880)", "Support System Enhancement (5440)"),
            List.of("Anxiety Level (1211)", "Coping (1302)", "Vital Signs (0802)")));

        diagnoses.put("00049", new NandaDiagnosis("00049", "Decreased Intracranial Adaptive Capacity", "Coping/Stress Tolerance", "3. Neurobehavioral Stress",
            List.of("Sustained ICP >20 mmHg", "Disproportionate ICP spikes to minor stimuli (suctioning, repositioning)", "Cushing triad (HTN, bradycardia, irregular respirations)"),
            List.of("Severe traumatic brain injury", "Intracranial hemorrhage / mass effect", "Obstructive hydrocephalus", "Cerebral edema"),
            List.of("Cerebral Edema Management (2540)", "Intracranial Pressure (ICP) Monitoring (2590)", "Neurological Monitoring (2620)", "Head Elevation 30-deg (0840)"),
            List.of("Neurological Status: Central Nervous System (0909)", "Tissue Perfusion: Cerebral (0406)", "Vital Signs (0802)")));

        diagnoses.put("00009", new NandaDiagnosis("00009", "Autonomic Dysreflexia", "Coping/Stress Tolerance", "3. Neurobehavioral Stress",
            List.of("Severe paroxysmal hypertension SBP >200", "Throbbing headache", "Profuse sweating above spinal lesion", "Bradycardia"),
            List.of("Spinal cord injury at or above T6", "Bladder distention / blocked Foley", "Fecal impaction", "Skin irritation / pressure point"),
            List.of("Dysreflexia Management (2580)", "Urinary Catheterization: STAT (0580)", "Bowel Disimpaction (0450)"),
            List.of("Neurological Status: Autonomic (0920)", "Vital Signs (0802)", "Symptom Control (1608)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
