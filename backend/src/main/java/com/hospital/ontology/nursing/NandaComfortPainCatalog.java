package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaComfortPainCatalog {

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

    public NandaComfortPainCatalog() {
        diagnoses.put("00132", new NandaDiagnosis("00132", "Acute Pain", "Comfort", "1. Physical Comfort",
            List.of("Verbal report of pain NRS >=7/10", "Guarding behavior", "Facial grimacing", "Diaphoresis & autonomic tachycardia/hypertension"),
            List.of("Biological injury agent (surgical incision, acute ischemia, fracture, inflammation)"),
            List.of("Pain Management: Acute (1400)", "Analgesic Administration: PCA / IV (2210)", "Positioning for Comfort (0840)", "Cold/Heat Application (1380)"),
            List.of("Pain Level (2102)", "Pain Control (1605)", "Comfort Level (2100)")));

        diagnoses.put("00133", new NandaDiagnosis("00133", "Chronic Pain", "Comfort", "1. Physical Comfort",
            List.of("Pain duration >3 months", "Self-focused behavior / depression", "Fatigue / sleep disturbances", "Impaired social functioning"),
            List.of("Chronic musculoskeletal disorders", "Neuropathic nerve injury (diabetic neuropathy, phantom limb)", "Malignancy bone metastases"),
            List.of("Pain Management: Chronic (1415)", "Progressive Muscle Relaxation (1460)", "Medication: Neuropathic Agents (2300)"),
            List.of("Pain: Disruptive Effects (2101)", "Pain Level (2102)", "Quality of Life (2000)")));

        diagnoses.put("00134", new NandaDiagnosis("00134", "Nausea", "Comfort", "1. Physical Comfort",
            List.of("Aversion to food", "Increased salivation", "Sour taste in mouth", "Subjective sensation of urge to vomit"),
            List.of("Chemotherapy / radiation", "Post-anesthesia medication effect", "Gastric distention / ileus", "Motion / labyrinthitis"),
            List.of("Nausea Management (1450)", "Antiemetic Administration (2300)", "Oral Hygiene (1720)", "Dietary Staging: Clear Liquids (1100)"),
            List.of("Nausea & Vomiting Severity (2107)", "Nausea & Vomiting Control (1618)", "Comfort Level (2100)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
