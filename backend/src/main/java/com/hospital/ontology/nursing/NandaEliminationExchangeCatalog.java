package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaEliminationExchangeCatalog {

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

    public NandaEliminationExchangeCatalog() {
        diagnoses.put("00030", new NandaDiagnosis("00030", "Impaired Gas Exchange", "Elimination & Exchange", "4. Respiratory Function",
            List.of("PaO2 <60 mmHg on room air", "PaCO2 >45 mmHg", "Dyspnea & tachypnea >28 bpm", "Somnolence / confusion", "PaO2/FiO2 ratio <300"),
            List.of("Alveolar-capillary membrane changes (ARDS, pneumonia)", "Ventilation-perfusion mismatch (PE, COPD)", "Pulmonary edema"),
            List.of("Oxygen Therapy (3320)", "Airway Management (3140)", "Mechanical Ventilation Management (3300)", "Acid-Base Monitoring (1920)"),
            List.of("Respiratory Status: Gas Exchange (0402)", "Respiratory Status: Ventilation (0403)", "Tissue Perfusion (0416)")));

        diagnoses.put("00016", new NandaDiagnosis("00016", "Impaired Urinary Elimination", "Elimination & Exchange", "1. Urinary Function",
            List.of("Dysuria", "Urinary frequency >8 times/day", "Urinary hesitancy", "Post-void residual >150 mL"),
            List.of("Benign prostatic hyperplasia (BPH)", "Neurogenic bladder", "Catheter-associated urinary tract infection (CAUTI)"),
            List.of("Urinary Elimination Management (0590)", "Bladder Scan / Catheterization (0580)", "Perineal Care (1750)"),
            List.of("Urinary Elimination (0503)", "Urinary Continence (0502)", "Symptom Severity (2103)")));

        diagnoses.put("00011", new NandaDiagnosis("00011", "Constipation", "Elimination & Exchange", "2. Gastrointestinal Function",
            List.of("Hard dry formed stool", "Frequency <3 times per week", "Straining at defecation", "Abdominal distention / cramping"),
            List.of("Opioid analgesic therapy", "Immobility / bedrest", "Inadequate fluid and fiber intake", "Anticholinergic medications"),
            List.of("Bowel Management (0430)", "Constipation/Impaction Management (0450)", "Medication: Laxatives (2300)"),
            List.of("Bowel Elimination (0501)", "Gastrointestinal Function (1015)", "Comfort Level (2100)")));

        diagnoses.put("00013", new NandaDiagnosis("00013", "Diarrhea", "Elimination & Exchange", "2. Gastrointestinal Function",
            List.of("Loose unformed watery stools >=3 per day", "Hyperactive bowel sounds", "Perianal skin erythema", "Abdominal urgency"),
            List.of("Clostridioides difficile infection", "Enteral tube feeding intolerance", "Broad-spectrum antibiotics", "Inflammatory bowel disease"),
            List.of("Diarrhea Management (0460)", "Perineal Care / Skin Barrier (1750)", "Fluid & Electrolyte Management (2080)", "Infection Control (6540)"),
            List.of("Bowel Elimination (0501)", "Electrolyte & Acid/Base Balance (0600)", "Skin Integrity (1101)")));

        diagnoses.put("00196", new NandaDiagnosis("00196", "Dysfunctional Gastrointestinal Motility", "Elimination & Exchange", "2. Gastrointestinal Function",
            List.of("Absent bowel sounds >48h post-op", "Gastric residual volume >500 mL", "Nausea & vomiting", "Abdominal distention"),
            List.of("Postoperative paralytic ileus", "Critical illness sepsis", "Electrolyte derangement (hypokalemia)", "Opioid infusion"),
            List.of("Gastrointestinal Intubation (1080)", "Enteral Nutrition Management (1056)", "Early Ambulation (0221)"),
            List.of("Gastrointestinal Motility (1015)", "Nutritional Status (1004)", "Symptom Control (1608)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
