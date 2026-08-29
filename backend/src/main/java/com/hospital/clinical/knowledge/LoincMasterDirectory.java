package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Standard LOINC (Logical Observation Identifiers Names and Codes) Laboratory Knowledge Base.
 */
@Component
public class LoincMasterDirectory {

    @Data
    @Builder
    public static class LoincTestEntry {
        private String loincNum;
        private String component;
        private String property;
        private String system; // SERUM, BLOOD, URINE, CSF, PLEURAL
        private String scaleType; // QUANTITATIVE, ORDINAL, NOMINAL
        private String classType; // CHEM, HEM/BC, MICRO, COAG, TOX
        private Double normalRangeMin;
        private Double normalRangeMax;
        private String unit;
        private Double criticalLow;
        private Double criticalHigh;
        private String clinicalSignificance;
    }

    private static final List<LoincTestEntry> ENTRIES = new ArrayList<>();

    static {
        // Complete Blood Count & Hematology
        add("6690-2", "Leukocytes [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 4.5, 11.0, "10^3/uL", 2.0, 30.0, "Elevated in bacterial infections, leukemias; decreased in bone marrow failure or severe sepsis.");
        add("789-8", "Erythrocytes [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 4.3, 5.9, "10^6/uL", 2.5, 7.0, "Red blood cell count; assesses anemia or polycythemia.");
        add("718-7", "Hemoglobin [Mass/volume] in Blood", "Mass", "BLOOD", "QUANTITATIVE", "HEM/BC", 13.5, 17.5, "g/dL", 7.0, 20.0, "Critical marker for tissue oxygen carrying capacity and blood transfusion trigger.");
        add("4544-3", "Hematocrit [Volume Fraction] of Blood", "VFr", "BLOOD", "QUANTITATIVE", "HEM/BC", 38.8, 50.0, "%", 20.0, 60.0, "Percentage of blood volume composed of red blood cells.");
        add("777-3", "Platelets [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 150.0, 450.0, "10^3/uL", 20.0, 1000.0, "Key for primary hemostasis. Severe thrombocytopenia risk of spontaneous bleeding.");
        add("751-8", "Neutrophils [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 1.8, 7.7, "10^3/uL", 0.5, 20.0, "Absolute neutrophil count (ANC); critical for assessing neutropenic fever in oncology.");
        add("731-0", "Lymphocytes [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 1.0, 4.8, "10^3/uL", 0.5, 15.0, "Assesses viral response, immune competence, or chronic lymphoid disorders.");
        add("711-2", "Eosinophils [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 0.0, 0.5, "10^3/uL", null, 5.0, "Elevated in allergic reactions, asthma, and parasitic infections.");
        add("742-7", "Monocytes [#/volume] in Blood", "Num", "BLOOD", "QUANTITATIVE", "HEM/BC", 0.2, 0.8, "10^3/uL", null, 3.0, "Elevated in chronic inflammatory states, tuberculosis, and mononucleosis.");
        add("30341-2", "Erythrocyte sedimentation rate (ESR)", "Len", "BLOOD", "QUANTITATIVE", "HEM/BC", 0.0, 20.0, "mm/h", null, 100.0, "Nonspecific acute-phase marker of systemic inflammation.");

        // Metabolic, Renal & Electrolytes (Chemistry)
        add("2345-7", "Glucose [Mass/volume] in Serum or Plasma (Fasting)", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 70.0, 99.0, "mg/dL", 45.0, 400.0, "Diagnostic for diabetes mellitus, hypoglycemia, and acute metabolic derangements.");
        add("4548-4", "Hemoglobin A1c/Hemoglobin.total in Blood", "MFr", "BLOOD", "QUANTITATIVE", "CHEM", 4.0, 5.6, "%", null, 14.0, "3-month average glycemic control; diagnostic threshold >= 6.5% for diabetes.");
        add("2160-0", "Creatinine [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 0.7, 1.3, "mg/dL", null, 5.0, "Primary biomarker for glomerular filtration and acute kidney injury (KDIGO).");
        add("3094-0", "Urea nitrogen [Mass/volume] in Serum or Plasma (BUN)", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 7.0, 20.0, "mg/dL", null, 100.0, "Assesses renal excretion and BUN/Creatinine ratio in prerenal azotemia.");
        add("2951-2", "Sodium [Moles/volume] in Serum or Plasma", "Subst", "SERUM", "QUANTITATIVE", "CHEM", 135.0, 145.0, "mmol/L", 120.0, 160.0, "Major extracellular cation; critical for cerebral volume regulation and osmolarity.");
        add("2823-3", "Potassium [Moles/volume] in Serum or Plasma", "Subst", "SERUM", "QUANTITATIVE", "CHEM", 3.5, 5.0, "mmol/L", 2.8, 6.5, "Major intracellular cation; cardiac membrane stability; fatal arrhythmias if critical.");
        add("2075-0", "Chloride [Moles/volume] in Serum or Plasma", "Subst", "SERUM", "QUANTITATIVE", "CHEM", 96.0, 106.0, "mmol/L", 80.0, 120.0, "Major extracellular anion; used in calculating serum Anion Gap.");
        add("1963-8", "Bicarbonate [Moles/volume] in Serum or Plasma", "Subst", "SERUM", "QUANTITATIVE", "CHEM", 22.0, 29.0, "mmol/L", 10.0, 40.0, "Acid-base balance indicator; low in metabolic acidosis (DKA, lactic acidosis).");
        add("17861-6", "Calcium [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 8.6, 10.2, "mg/dL", 6.5, 13.0, "Neuromuscular excitability and bone metabolism; requires albumin correction.");
        add("2601-3", "Magnesium [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 1.7, 2.2, "mg/dL", 1.0, 4.0, "Cofactor in ATP metabolism; hypomagnesemia causes refractory hypokalemia and Torsades.");

        // Liver Function Panel
        add("1751-7", "Albumin [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 3.5, 5.2, "g/dL", 1.5, null, "Reflects hepatic synthetic capacity and nutritional status; plasma oncotic pressure.");
        add("2885-2", "Protein [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 6.0, 8.3, "g/dL", 4.0, 10.0, "Total serum protein.");
        add("1975-2", "Bilirubin.total [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 0.2, 1.2, "mg/dL", null, 15.0, "Assesses cholestasis, biliary obstruction, and hemolytic jaundice.");
        add("1968-7", "Bilirubin.direct [Mass/volume] in Serum or Plasma", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 0.0, 0.3, "mg/dL", null, 10.0, "Conjugated bilirubin fraction.");
        add("1742-6", "Alanine aminotransferase (ALT/SGPT) in Serum or Plasma", "EnzAct", "SERUM", "QUANTITATIVE", "CHEM", 7.0, 56.0, "U/L", null, 1000.0, "Specific marker of hepatocellular injury and acute viral/toxic hepatitis.");
        add("1920-8", "Aspartate aminotransferase (AST/SGOT) in Serum or Plasma", "EnzAct", "SERUM", "QUANTITATIVE", "CHEM", 10.0, 40.0, "U/L", null, 1000.0, "Hepatocellular, cardiac, and skeletal muscle marker; AST/ALT ratio > 2 in alcoholic liver disease.");
        add("6768-6", "Alkaline phosphatase [Enzymatic activity/volume] in Serum", "EnzAct", "SERUM", "QUANTITATIVE", "CHEM", 44.0, 147.0, "U/L", null, 500.0, "Elevated in biliary tree obstruction and high bone turnover states.");

        // Cardiac Biomarkers & Coagulation
        add("42757-5", "Troponin I.cardiac [Mass/volume] in Serum or Plasma (High Sensitivity)", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 0.0, 0.04, "ng/mL", null, 0.50, "Gold standard biomarker for myocardial injury and acute myocardial infarction (AMI).");
        add("33762-6", "Natriuretic peptide.B prohormone N-Terminal (NT-proBNP)", "Mass", "SERUM", "QUANTITATIVE", "CHEM", 0.0, 125.0, "pg/mL", null, 5000.0, "Ventricular stretch biomarker; high sensitivity for congestive heart failure (CHF).");
        add("5902-2", "Prothrombin time (PT)", "Time", "BLOOD", "QUANTITATIVE", "COAG", 11.0, 13.5, "seconds", null, 30.0, "Extrinsic coagulation pathway; evaluates warfarin therapy and liver failure.");
        add("6301-6", "INR in Blood by Coagulation assay", "RelTime", "BLOOD", "QUANTITATIVE", "COAG", 0.8, 1.1, "ratio", null, 5.0, "Standardized PT ratio; target 2.0-3.0 for mechanical valve / DVT anticoagulation.");
        add("3173-2", "Activated partial thromboplastin time (aPTT)", "Time", "BLOOD", "QUANTITATIVE", "COAG", 25.0, 35.0, "seconds", null, 100.0, "Intrinsic coagulation pathway; monitors unfractionated heparin therapy.");
        add("48065-7", "D-dimer [Mass/volume] in Platelet poor plasma", "Mass", "SERUM", "QUANTITATIVE", "COAG", 0.0, 0.50, "ug/mL", null, 5.0, "Fibrin degradation product; high negative predictive value for DVT and pulmonary embolism.");

        // Arterial Blood Gas (ABG) & Critical Care
        add("2744-1", "pH of Arterial blood", "pH", "BLOOD", "QUANTITATIVE", "CHEM", 7.35, 7.45, "pH", 7.10, 7.60, "Systemic acid-base status.");
        add("2019-8", "Carbon dioxide partial pressure (pCO2) in Arterial blood", "Press", "BLOOD", "QUANTITATIVE", "CHEM", 35.0, 45.0, "mmHg", 20.0, 70.0, "Respiratory component of acid-base regulation.");
        add("2703-7", "Oxygen partial pressure (pO2) in Arterial blood", "Press", "BLOOD", "QUANTITATIVE", "CHEM", 80.0, 100.0, "mmHg", 50.0, null, "Arterial oxygenation; PaO2/FiO2 ratio used in ARDS Berlin definition.");
        add("2524-7", "Lactate [Mass/volume] in Blood", "Mass", "BLOOD", "QUANTITATIVE", "CHEM", 0.5, 2.0, "mmol/L", null, 4.0, "Tissue hypoperfusion and anaerobic metabolism; hallmark of septic shock (Sepsis-3).");
    }

    private static void add(String loinc, String comp, String prop, String sys, String scale, String cls,
                            Double min, Double max, String unit, Double critLow, Double critHigh, String sig) {
        ENTRIES.add(LoincTestEntry.builder()
                .loincNum(loinc)
                .component(comp)
                .property(prop)
                .system(sys)
                .scaleType(scale)
                .classType(cls)
                .normalRangeMin(min)
                .normalRangeMax(max)
                .unit(unit)
                .criticalLow(critLow)
                .criticalHigh(critHigh)
                .clinicalSignificance(sig)
                .build());
    }

    public List<LoincTestEntry> search(String query) {
        if (query == null || query.isBlank()) {
            return ENTRIES;
        }
        String q = query.toLowerCase().trim();
        return ENTRIES.stream()
                .filter(e -> e.getLoincNum().toLowerCase().contains(q) ||
                             e.getComponent().toLowerCase().contains(q) ||
                             e.getClassType().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<LoincTestEntry> findByLoinc(String loinc) {
        return ENTRIES.stream()
                .filter(e -> e.getLoincNum().equalsIgnoreCase(loinc))
                .findFirst();
    }
}
