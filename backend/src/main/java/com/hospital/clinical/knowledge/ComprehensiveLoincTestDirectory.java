package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise LOINC (Logical Observation Identifiers Names and Codes) Directory.
 * Comprehensive diagnostic lab catalog with specimen requirements, methodologies,
 * age-stratified reference intervals, critical alert thresholds, and diagnostic utility.
 */
@Component
public class ComprehensiveLoincTestDirectory {

    @Data
    @Builder
    public static class LoincTestEntry {
        private String loincCode;
        private String componentName;
        private String property; // Mass concentration, Substance concentration, Arbitrary concentration
        private String timeAspect; // Point in time (Pt), 24 hour (24h)
        private String systemSpecimen; // Serum, Plasma, Whole Blood, Urine, CSF, Pleural fluid
        private String scaleType; // Quantitative (Qn), Qualitative (Ord/Nom)
        private String standardUnit; // mg/dL, g/dL, ng/mL, mmol/L, U/L
        private String methodology; // Photometry, Spectrophotometry, Chemiluminescent Immunoassay (CLIA), HPLC, RT-PCR
        private double criticalLowAlert;
        private double criticalHighAlert;
        private List<AgeReferenceInterval> referenceIntervals;
        private String clinicalSignificance;
        private String preAnalyticalHandling;
    }

    @Data
    @Builder
    public static class AgeReferenceInterval {
        private String ageGroup; // Neonate (0-28d), Infant (1-12m), Child (1-12y), Adult Male, Adult Female, Geriatric
        private double minReference;
        private double maxReference;
        private String unit;
    }

    private static final List<LoincTestEntry> DIRECTORY = new ArrayList<>();

    static {
        // ==========================================
        // BIOCHEMISTRY & RENAL / METABOLIC
        // ==========================================
        DIRECTORY.add(LoincTestEntry.builder()
                .loincCode("2345-7")
                .componentName("Glucose [Mass/volume] in Serum or Plasma")
                .property("Mass Concentration")
                .timeAspect("Pt")
                .systemSpecimen("Serum / Fluoride Plasma (Grey top tube)")
                .scaleType("Qn")
                .standardUnit("mg/dL")
                .methodology("Hexokinase / Glucose Oxidase Peroxidase (GOD-POD)")
                .criticalLowAlert(45.0)  // Severe neuroglycopenia risk (< 45 mg/dL)
                .criticalHighAlert(450.0) // DKA / HHS risk (> 450 mg/dL)
                .referenceIntervals(Arrays.asList(
                        AgeReferenceInterval.builder().ageGroup("Neonate (0-28 days)").minReference(40.0).maxReference(80.0).unit("mg/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Infant (1-12 months)").minReference(60.0).maxReference(100.0).unit("mg/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Fasting (>= 18 yrs)").minReference(70.0).maxReference(99.0).unit("mg/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Postprandial (2-hr)").minReference(70.0).maxReference(139.0).unit("mg/dL").build()
                ))
                .clinicalSignificance("Essential for diagnosing Diabetes Mellitus, impaired fasting glucose, and acute hypoglycemia. Critical values require stat dextrose administration or insulin therapy.")
                .preAnalyticalHandling("Centrifuge and separate serum/plasma within 30 minutes of collection or collect in Sodium Fluoride/Potassium Oxalate tube to inhibit in vitro glycolysis (decreases by 5-7 mg/dL/hr at room temp).")
                .build());

        DIRECTORY.add(LoincTestEntry.builder()
                .loincCode("2160-0")
                .componentName("Creatinine [Mass/volume] in Serum or Plasma")
                .property("Mass Concentration")
                .timeAspect("Pt")
                .systemSpecimen("Serum / Heparin Plasma")
                .scaleType("Qn")
                .standardUnit("mg/dL")
                .methodology("IDMS-traceable Enzymatic Assay / Jaffe Kinetic method")
                .criticalLowAlert(0.2)
                .criticalHighAlert(7.0) // Acute uremic emergency
                .referenceIntervals(Arrays.asList(
                        AgeReferenceInterval.builder().ageGroup("Neonate (0-28 days)").minReference(0.2).maxReference(0.8).unit("mg/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Child (1-12 years)").minReference(0.3).maxReference(0.7).unit("mg/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Male (18-65 yrs)").minReference(0.74).maxReference(1.35).unit("mg/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Female (18-65 yrs)").minReference(0.59).maxReference(1.04).unit("mg/dL").build()
                ))
                .clinicalSignificance("Primary endogenous biomarker for estimating Glomerular Filtration Rate (eGFR) and staging Acute Kidney Injury (KDIGO) and Chronic Kidney Disease.")
                .preAnalyticalHandling("Avoid hemolysis and gross lipemia. Non-IDMS Jaffe method may show positive interference from cephalosporins and acetoacetate.")
                .build());

        DIRECTORY.add(LoincTestEntry.builder()
                .loincCode("2823-3")
                .componentName("Potassium [Moles/volume] in Serum or Plasma")
                .property("Substance Concentration")
                .timeAspect("Pt")
                .systemSpecimen("Serum / Lithium Heparin Plasma (NO EDTA)")
                .scaleType("Qn")
                .standardUnit("mmol/L")
                .methodology("Ion-Selective Electrode (ISE - Indirect/Direct)")
                .criticalLowAlert(2.8)  // Risk of fatal ventricular arrhythmias (Torsades)
                .criticalHighAlert(6.2)  // Risk of peaked T-waves, sine wave, and asystole
                .referenceIntervals(Arrays.asList(
                        AgeReferenceInterval.builder().ageGroup("Neonate (0-28 days)").minReference(3.7).maxReference(5.9).unit("mmol/L").build(),
                        AgeReferenceInterval.builder().ageGroup("Child (1-12 years)").minReference(3.5).maxReference(5.0).unit("mmol/L").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult (>= 18 yrs)").minReference(3.5).maxReference(5.1).unit("mmol/L").build()
                ))
                .clinicalSignificance("Crucial electrolyte regulating cardiac membrane resting potential and neuromuscular transmission. Severe hyperkalemia requires immediate membrane stabilization (IV Calcium Gluconate).")
                .preAnalyticalHandling("CRITICAL: Rule out pseudohyperkalemia due to in vitro hemolysis (mechanical shearing, fist clenching, delayed centrifugation), prolonged tourniquet application, or EDTA tube contamination.")
                .build());

        // ==========================================
        // HEMATOLOGY & COAGULATION
        // ==========================================
        DIRECTORY.add(LoincTestEntry.builder()
                .loincCode("718-7")
                .componentName("Hemoglobin [Mass/volume] in Blood")
                .property("Mass Concentration")
                .timeAspect("Pt")
                .systemSpecimen("Whole Blood (K2-EDTA Lavender top tube)")
                .scaleType("Qn")
                .standardUnit("g/dL")
                .methodology("Automated Cell Counter - Cyanmethemoglobin / SLS-Hemoglobin method")
                .criticalLowAlert(6.0)  // Symptomatic tissue hypoxia; urgent PRBC transfusion trigger
                .criticalHighAlert(20.0) // Severe hyperviscosity syndrome
                .referenceIntervals(Arrays.asList(
                        AgeReferenceInterval.builder().ageGroup("Neonate (Cord / Day 1)").minReference(14.0).maxReference(22.0).unit("g/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Child (6-12 years)").minReference(11.5).maxReference(15.5).unit("g/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Male (>= 18 yrs)").minReference(13.8).maxReference(17.2).unit("g/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Female (Non-pregnant)").minReference(12.1).maxReference(15.1).unit("g/dL").build(),
                        AgeReferenceInterval.builder().ageGroup("Adult Female (Pregnant)").minReference(11.0).maxReference(14.0).unit("g/dL").build()
                ))
                .clinicalSignificance("Primary oxygen-carrying metalloprotein in erythrocytes. Evaluates anemia (microcytic, normocytic, macrocytic) and polycythemia vera.")
                .preAnalyticalHandling("Mix Lavender EDTA tube by gentle inversion 8-10 times immediately after phlebotomy. Check for microclots.")
                .build());

        DIRECTORY.add(LoincTestEntry.builder()
                .loincCode("5902-2")
                .componentName("Prothrombin Time (PT) and International Normalized Ratio (INR)")
                .property("Time / Arbitrary Ratio")
                .timeAspect("Pt")
                .systemSpecimen("Citrated Plasma (Light Blue top tube, 3.2% Sodium Citrate 9:1 blood ratio)")
                .scaleType("Qn")
                .standardUnit("INR (Ratio)")
                .methodology("Optical / Mechanical Clot Detection with Recombinant Human Thromboplastin (ISI ~1.0)")
                .criticalLowAlert(0.8)
                .criticalHighAlert(5.0)  // High risk of catastrophic spontaneous intracranial/GI hemorrhage
                .referenceIntervals(Arrays.asList(
                        AgeReferenceInterval.builder().ageGroup("Normal Adult Control").minReference(0.85).maxReference(1.15).unit("INR").build(),
                        AgeReferenceInterval.builder().ageGroup("Therapeutic Range (DVT/PE/AFib on Warfarin)").minReference(2.0).maxReference(3.0).unit("INR").build(),
                        AgeReferenceInterval.builder().ageGroup("Therapeutic Range (Mechanical Mitral Valve)").minReference(2.5).maxReference(3.5).unit("INR").build()
                ))
                .clinicalSignificance("Evaluates the extrinsic and common coagulation pathways (Factors VII, X, V, II, and I). Monitors Vitamin K antagonist (Warfarin) anticoagulation and assesses liver synthetic function.")
                .preAnalyticalHandling("Strict fill volume to line on tube (9:1 blood to anticoagulant ratio is essential). Overfilled or underfilled tubes alter citrate concentration, causing falsely prolonged PT/INR results.")
                .build());
    }

    public List<LoincTestEntry> search(String query) {
        if (query == null || query.isBlank()) {
            return DIRECTORY;
        }
        String q = query.toLowerCase().trim();
        return DIRECTORY.stream()
                .filter(t -> t.getLoincCode().contains(q) ||
                             t.getComponentName().toLowerCase().contains(q) ||
                             t.getSystemSpecimen().toLowerCase().contains(q) ||
                             t.getMethodology().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<LoincTestEntry> findByLoincCode(String code) {
        return DIRECTORY.stream()
                .filter(t -> t.getLoincCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
