package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaHealthPromotionCatalog {

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

    public NandaHealthPromotionCatalog() {
        diagnoses.put("00097", new NandaDiagnosis("00097", "Deficient Diversional Activity", "Health Promotion", "1. Health Awareness",
            List.of("Boredom statements", "Usual hobbies cannot be undertaken in hospital", "Flat affect"),
            List.of("Prolonged hospitalization", "Isolation precautions", "Physical immobility"),
            List.of("Recreation Therapy (5360)", "Music Therapy (4400)", "Environmental Management (6480)"),
            List.of("Leisure Participation (1604)", "Play Participation (0203)", "Quality of Life (2000)")));

        diagnoses.put("00168", new NandaDiagnosis("00168", "Sedentary Lifestyle", "Health Promotion", "1. Health Awareness",
            List.of("Physical deconditioning", "Preference for low physical activity", "Lack of exercise habit"),
            List.of("Lack of motivation", "Insufficient knowledge of health benefits", "Sedentary occupational role"),
            List.of("Exercise Promotion (0200)", "Health Education (5510)", "Behavior Modification (4360)"),
            List.of("Physical Activity Level (0005)", "Knowledge: Health Promotion (1823)", "Health Promoting Behavior (1602)")));

        diagnoses.put("00257", new NandaDiagnosis("00257", "Frail Elderly Syndrome", "Health Promotion", "2. Health Management",
            List.of("Muscle weakness", "Unintentional weight loss >5%", "Exhaustion", "Slow walking speed"),
            List.of("Advanced age >75", "Chronic illness multimorbidity", "Social vulnerability", "Impaired mobility"),
            List.of("Fall Prevention (6490)", "Nutrition Management (1100)", "Energy Management (0180)", "Multidisciplinary Care (7610)"),
            List.of("Frailty Health Status (2012)", "Physical Mobility (0208)", "Nutritional Status (1004)", "Fall Occurrence (1912)")));

        diagnoses.put("00078", new NandaDiagnosis("00078", "Ineffective Health Management", "Health Promotion", "2. Health Management",
            List.of("Failure to adhere to treatment plan", "Exacerbation of chronic illness", "Inability to manage medication regimen"),
            List.of("Complexity of medical regimen", "Financial hardship", "Low health literacy", "Decisional conflicts"),
            List.of("Health System Guidance (7400)", "Medication Management (2380)", "Mutual Goal Setting (4410)"),
            List.of("Knowledge: Treatment Regimen (1813)", "Compliance Behavior (1601)", "Self-Care: Disease Management (3102)")));

        diagnoses.put("00186", new NandaDiagnosis("00186", "Readiness for Enhanced Community Health", "Health Promotion", "2. Health Management",
            List.of("Community desires to enhance immunization coverage", "Availability of local health screening programs"),
            List.of("Community empowerment initiatives", "Public health resource availability"),
            List.of("Community Health Development (8500)", "Immunization Management (6530)", "Surveillance: Community (6652)"),
            List.of("Community Competence (2701)", "Community Health Status (2800)", "Community Risk Control (2802)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
