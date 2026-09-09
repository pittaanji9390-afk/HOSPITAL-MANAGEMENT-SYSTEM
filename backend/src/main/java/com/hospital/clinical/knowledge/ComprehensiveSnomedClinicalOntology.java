package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise SNOMED-CT (Systematized Nomenclature of Medicine - Clinical Terms) Concept Network.
 * Provides hierarchical concept ontology, Fully Specified Names (FSN), Preferred Terms (PT),
 * Semantic Tags (disorder, procedure, finding, body structure), and Is-A relationships.
 */
@Component
public class ComprehensiveSnomedClinicalOntology {

    @Data
    @Builder
    public static class SnomedConceptNode {
        private String conceptId;
        private String fullySpecifiedName;
        private String preferredTerm;
        private String semanticTag; // disorder, procedure, finding, organism, substance, body structure
        private String parentConceptId;
        private List<String> synonyms;
        private String clinicalDefinition;
    }

    private static final List<SnomedConceptNode> ONTOLOGY = new ArrayList<>();

    static {
        // =========================================================================
        // DISORDERS (Clinical Findings & Diagnoses)
        // =========================================================================
        add("38341003", "Hypertensive disorder, systemic arterial (disorder)", "Essential hypertension", "disorder", "64859006",
                Arrays.asList("Primary hypertension", "Systemic hypertension", "High blood pressure"),
                "Persistent elevated systemic arterial pressure (SBP >= 130 or DBP >= 80 mmHg) without identifiable secondary etiology.");

        add("22298006", "Myocardial infarction (disorder)", "Acute myocardial infarction", "disorder", "414545008",
                Arrays.asList("Heart attack", "Coronary thrombosis", "Cardiac infarction"),
                "Cardiomyocyte necrosis caused by acute, prolonged myocardial ischemia.");

        add("401303003", "Acute ST segment elevation myocardial infarction (disorder)", "STEMI", "disorder", "22298006",
                Arrays.asList("ST elevation MI", "Transmural myocardial infarction", "Acute STEMI"),
                "Transmural myocardial necrosis characterized by persistent J-point ST-segment elevation on 12-lead ECG.");

        add("401314000", "Acute non-ST segment elevation myocardial infarction (disorder)", "NSTEMI", "disorder", "22298006",
                Arrays.asList("Non-ST elevation MI", "Subendocardial myocardial infarction"),
                "Myocardial necrosis with elevated cardiac troponins in the absence of persistent ST-segment elevation.");

        add("42343007", "Congestive heart failure (disorder)", "Congestive heart failure", "disorder", "84114007",
                Arrays.asList("CHF", "Heart failure with congestion", "Decompensated cardiac failure"),
                "Clinical syndrome of pulmonary and systemic venous congestion resulting from impaired ventricular filling or ejection.");

        add("49436004", "Atrial fibrillation (disorder)", "Atrial fibrillation", "disorder", "17366009",
                Arrays.asList("AFib", "Auricular fibrillation", "A-Fib"),
                "Disorganized atrial tachyarrhythmia (350-600 bpm) with irregular ventricular response.");

        add("230690007", "Stroke (disorder)", "Cerebrovascular accident", "disorder", "62914000",
                Arrays.asList("CVA", "Brain attack", "Acute stroke"),
                "Acute focal neurological injury caused by vascular interruption (ischemic or hemorrhagic).");

        add("422504002", "Ischemic stroke (disorder)", "Acute ischemic stroke", "disorder", "230690007",
                Arrays.asList("Cerebral infarction", "Brain ischemia"),
                "Cerebral tissue necrosis caused by arterial occlusion from thrombosis or embolism.");

        add("274100004", "Hemorrhagic stroke (disorder)", "Intracerebral hemorrhage", "disorder", "230690007",
                Arrays.asList("ICH", "Parenchymal brain hemorrhage"),
                "Bleeding directly into the brain parenchyma caused by arteriole rupture.");

        add("91302008", "Sepsis (disorder)", "Sepsis", "disorder", "91302008",
                Arrays.asList("Septicemia", "Systemic inflammatory response to infection"),
                "Life-threatening organ dysfunction caused by a dysregulated host response to infection (SOFA increase >= 2).");

        add("76571007", "Septic shock (disorder)", "Septic shock", "disorder", "91302008",
                Arrays.asList("Distributive shock due to sepsis", "Endotoxic shock"),
                "Subset of sepsis with persistent hypotension requiring vasopressors (MAP >= 65) and serum lactate > 2.0 mmol/L.");

        add("195967001", "Asthma (disorder)", "Bronchial asthma", "disorder", "195951007",
                Arrays.asList("Chronic asthma", "Hyperreactive airway disease"),
                "Chronic inflammatory airway disorder characterized by variable expiratory airflow limitation and bronchial hyperresponsiveness.");

        add("13645005", "Chronic obstructive lung disease (disorder)", "COPD", "disorder", "195951007",
                Arrays.asList("Chronic obstructive pulmonary disease", "COAD"),
                "Persistent airflow limitation (FEV1/FVC < 0.70) caused by small airway disease and emphysematous parenchymal destruction.");

        add("67782005", "Acute respiratory distress syndrome (disorder)", "ARDS", "disorder", "67782005",
                Arrays.asList("Shock lung", "Diffuse alveolar damage", "Wet lung"),
                "Non-cardiogenic pulmonary edema with bilateral alveolar infiltrates and severe hypoxemia (PaO2/FiO2 <= 300 on PEEP >= 5).");

        add("73211009", "Diabetes mellitus (disorder)", "Diabetes mellitus", "disorder", "362969004",
                Arrays.asList("DM", "Hyperglycemia syndrome"),
                "Metabolic disease characterized by chronic hyperglycemia resulting from defects in insulin secretion, action, or both.");

        add("46635009", "Type 1 diabetes mellitus (disorder)", "Type 1 diabetes", "disorder", "73211009",
                Arrays.asList("T1D", "Juvenile-onset diabetes", "Insulin-dependent diabetes mellitus IDDM"),
                "Autoimmune destruction of pancreatic beta-islet cells causing absolute insulin deficiency.");

        add("44054006", "Type 2 diabetes mellitus (disorder)", "Type 2 diabetes", "disorder", "73211009",
                Arrays.asList("T2D", "Adult-onset diabetes", "Non-insulin dependent diabetes mellitus NIDDM"),
                "Metabolic disorder characterized by progressive insulin resistance combined with inadequate compensatory insulin secretion.");

        add("420422005", "Diabetic ketoacidosis (disorder)", "Diabetic ketoacidosis", "disorder", "73211009",
                Arrays.asList("DKA", "Diabetic ketosis and acidosis"),
                "Acute diabetic emergency: Hyperglycemia (> 250 mg/dL), metabolic acidosis (pH < 7.30, HCO3 < 18), and elevated beta-hydroxybutyrate.");

        add("14669001", "Acute kidney injury (disorder)", "Acute kidney injury", "disorder", "14669001",
                Arrays.asList("AKI", "Acute renal failure ARF", "Acute tubular necrosis"),
                "Sudden decline in renal function: Serum Creatinine increase >= 0.3 mg/dL within 48h or >= 1.5x baseline within 7 days.");

        add("709044004", "Chronic kidney disease (disorder)", "Chronic kidney disease", "disorder", "709044004",
                Arrays.asList("CKD", "Chronic renal failure"),
                "Persistent abnormalities of kidney structure or function (eGFR < 60 mL/min/1.73m2 or albuminuria) lasting > 3 months.");

        // =========================================================================
        // PROCEDURES (Surgical & Interventional)
        // =========================================================================
        add("232717009", "Coronary artery bypass graft (procedure)", "CABG surgery", "procedure", "232717009",
                Arrays.asList("Aortocoronary bypass", "Bypass grafting of coronary artery", "Open heart bypass"),
                "Surgical revascularization of ischemic myocardium using autologous arterial (LIMA/RIMA) or venous (SVG) conduits.");

        add("415070008", "Percutaneous coronary intervention (procedure)", "PCI / Stenting", "procedure", "415070008",
                Arrays.asList("Coronary angioplasty", "PTCA with stent placement", "Cardiac stenting"),
                "Catheter-based coronary revascularization using balloon angioplasty and drug-eluting stent (DES) deployment.");

        add("38102005", "Cholecystectomy (procedure)", "Cholecystectomy", "procedure", "38102005",
                Arrays.asList("Gallbladder removal", "Laparoscopic cholecystectomy", "Excision of gallbladder"),
                "Surgical excision of the gallbladder for symptomatic cholelithiasis or acute cholecystitis.");

        add("80146002", "Appendectomy (procedure)", "Appendectomy", "procedure", "80146002",
                Arrays.asList("Removal of vermiform appendix", "Laparoscopic appendectomy"),
                "Surgical removal of the inflamed appendix for acute appendicitis.");

        add("10849003", "Hemodialysis (procedure)", "Hemodialysis", "procedure", "10849003",
                Arrays.asList("Renal dialysis", "Artificial kidney clearance", "Extracorporeal blood filtration"),
                "Extracorporeal blood purification removing uremic toxins and excess fluid across a semipermeable synthetic membrane.");
    }

    private static void add(String id, String fsn, String pt, String tag, String parent, List<String> syn, String def) {
        ONTOLOGY.add(SnomedConceptNode.builder()
                .conceptId(id)
                .fullySpecifiedName(fsn)
                .preferredTerm(pt)
                .semanticTag(tag)
                .parentConceptId(parent)
                .synonyms(syn)
                .clinicalDefinition(def)
                .build());
    }

    public List<SnomedConceptNode> search(String query) {
        if (query == null || query.isBlank()) {
            return ONTOLOGY;
        }
        String q = query.toLowerCase().trim();
        return ONTOLOGY.stream()
                .filter(n -> n.getConceptId().contains(q) ||
                             n.getFullySpecifiedName().toLowerCase().contains(q) ||
                             n.getPreferredTerm().toLowerCase().contains(q) ||
                             n.getSemanticTag().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<SnomedConceptNode> findById(String id) {
        return ONTOLOGY.stream()
                .filter(n -> n.getConceptId().equalsIgnoreCase(id))
                .findFirst();
    }
}
