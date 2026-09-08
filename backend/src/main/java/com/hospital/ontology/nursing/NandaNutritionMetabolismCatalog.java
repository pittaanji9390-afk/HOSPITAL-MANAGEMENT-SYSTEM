package com.hospital.ontology.nursing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NandaNutritionMetabolismCatalog {

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

    public NandaNutritionMetabolismCatalog() {
        diagnoses.put("00002", new NandaDiagnosis("00002", "Imbalanced Nutrition: Less than Body Requirements", "Nutrition", "1. Ingestion",
            List.of("Body weight <20% below ideal", "Serum albumin <3.0 g/dL", "Severe muscle wasting", "Early satiety"),
            List.of("Hypermetabolic state (sepsis, burns)", "Chemotherapy anorexia", "Inability to ingest nutrients", "Malabsorption"),
            List.of("Nutrition Therapy (1120)", "Enteral Tube Feeding (1056)", "Weight Management (1260)", "Electrolyte Monitoring (2000)"),
            List.of("Nutritional Status: Food & Fluid Intake (1008)", "Nutritional Status: Nutrient Intake (1009)", "Weight Gain (1014)")));

        diagnoses.put("00103", new NandaDiagnosis("00103", "Impaired Swallowing", "Nutrition", "1. Ingestion",
            List.of("Choking/coughing before/during/after swallow", "Gargly wet voice after swallowing", "Pocketing food in buccal cavity"),
            List.of("Neuromuscular impairment (CVA, ALS)", "Mechanical obstruction", "Prolonged intubation laryngeal edema"),
            List.of("Swallowing Therapy (1860)", "Aspiration Precautions (3200)", "Positioning: High Fowler (0840)"),
            List.of("Swallowing Status (1015)", "Aspiration Prevention (1918)", "Neurological Status: Cranial Nerves (0908)")));

        diagnoses.put("00027", new NandaDiagnosis("00027", "Deficient Fluid Volume", "Nutrition", "5. Hydration",
            List.of("Postural hypotension", "Dry mucous membranes", "Decreased skin turgor", "Oliguria <0.5 mL/kg/h", "Elevated BUN/Cr >20"),
            List.of("Active fluid loss (vomiting, diarrhea, hemorrhage)", "Diuretic overuse", "Severe burns", "Third-space shifting"),
            List.of("Fluid Management (4120)", "Intravenous (IV) Therapy (2120)", "Hypovolemia Management (4180)", "Shock Management (4250)"),
            List.of("Fluid Balance (0601)", "Hydration (0602)", "Vital Signs (0802)")));

        diagnoses.put("00026", new NandaDiagnosis("00026", "Excess Fluid Volume", "Nutrition", "5. Hydration",
            List.of("Bilateral peripheral edema (3+/4+)", "Jugular venous distention (JVD)", "Pulmonary crackles / S3 gallop", "Weight gain >2kg in 24h"),
            List.of("Compromised regulatory mechanism (CHF, ESRD, Cirrhosis)", "Excessive IV sodium/fluid infusion"),
            List.of("Fluid Restriction (4170)", "Diuretic Administration (2300)", "Hemodialysis Monitoring (2100)", "Positioning: Semi-Fowler (0840)"),
            List.of("Fluid Overload Severity (0603)", "Electrolyte Balance (0606)", "Respiratory Status: Gas Exchange (0402)")));

        diagnoses.put("00194", new NandaDiagnosis("00194", "Neonatal Hyperbilirubinemia", "Nutrition", "4. Metabolism",
            List.of("Yellowish sclera & skin", "Total serum bilirubin in high-risk zone on Bhutani nomogram", "Lethargy & poor feeding"),
            List.of("ABO/Rh incompatibility", "Delayed meconium passage", "Prematurity <37 weeks", "Inadequate breastfeeding jaundice"),
            List.of("Phototherapy: Neonate (6924)", "Newborn Monitoring (6880)", "Lactation Counseling (5244)"),
            List.of("Neonatal Adaptation (0118)", "Hyperbilirubinemia Management (0120)", "Nutritional Status: Infant (1020)")));
    }

    public Optional<NandaDiagnosis> getByCode(String code) { return Optional.ofNullable(diagnoses.get(code)); }
    public List<NandaDiagnosis> getAllDiagnoses() { return new ArrayList<>(diagnoses.values()); }
}
