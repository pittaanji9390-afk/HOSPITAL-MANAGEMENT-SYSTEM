package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Standardized Cardiology & Cardiovascular Clinical Practice Pathways.
 * Implements ACC/AHA and ESC guidelines for Acute Coronary Syndromes and Heart Failure.
 */
@Component
public class CardiologyClinicalPathway {

    @Data
    @Builder
    public static class ClinicalStep {
        private int stepNumber;
        private String timing; // "0-10 min", "10-30 min", "24-48 hours"
        private String actionName;
        private String description;
        private List<String> standardOrderSet;
        private String requiredDocumentation;
    }

    @Data
    @Builder
    public static class ClinicalPathway {
        private String pathwayId;
        private String conditionName;
        private String icd10Primary;
        private String targetPopulation;
        private List<ClinicalStep> steps;
        private List<String> dischargeCriteria;
    }

    private static final Map<String, ClinicalPathway> PATHWAYS = new HashMap<>();

    static {
        // 1. STEMI (ST-Elevation Myocardial Infarction) Acute Code Pathway
        List<ClinicalStep> stemiSteps = Arrays.asList(
                ClinicalStep.builder()
                        .stepNumber(1)
                        .timing("0 - 10 Minutes from Door Arrival")
                        .actionName("Immediate Triage & ECG Acquisition")
                        .description("Acquire and interpret 12-lead ECG within 10 minutes of presentation. Establish dual large-bore IV access.")
                        .standardOrderSet(Arrays.asList(
                                "12-Lead Electrocardiogram (ECG)",
                                "Continuous Cardiac Telemetry",
                                "Pulse Oximetry (Target SpO2 90-96%)",
                                "Stat Point-of-Care Troponin I",
                                "Stat CBC, PT/INR, aPTT, Serum Electrolytes, Serum Creatinine"
                        ))
                        .requiredDocumentation("Door-to-ECG Time (minutes), Baseline Vital Signs, Pain Severity (1-10)")
                        .build(),

                ClinicalStep.builder()
                        .stepNumber(2)
                        .timing("10 - 20 Minutes")
                        .actionName("Emergency Medical Therapy & Cath Lab Activation")
                        .description("Administer loading antiplatelet therapy. Trigger immediate Cath Lab activation for Primary PCI (Target Door-to-Balloon < 90 min).")
                        .standardOrderSet(Arrays.asList(
                                "Aspirin 325 mg non-enteric coated orally (chewed)",
                                "Ticagrelor 180 mg loading dose (or Clopidogrel 600 mg)",
                                "Unfractionated Heparin 60 units/kg IV bolus (max 4000 units)",
                                "Sublingual Nitroglycerin 0.4 mg q5min x 3 (if SBP > 100 mmHg without RV infarct)",
                                "Atorvastatin 80 mg oral loading dose"
                        ))
                        .requiredDocumentation("Cath Lab Activation Timestamp, Antiplatelet Administration Timestamps")
                        .build(),

                ClinicalStep.builder()
                        .stepNumber(3)
                        .timing("20 - 90 Minutes")
                        .actionName("Primary Percutaneous Coronary Intervention (PCI)")
                        .description("Transfer to Cardiac Catheterization Suite. Perform emergency coronary angiography and culprit lesion stenting.")
                        .standardOrderSet(Arrays.asList(
                                "Coronary Angiography with Left Ventriculography",
                                "Drug-Eluting Stent (DES) Implantation",
                                "Weight-adjusted IV Heparin maintenance or Bivalirudin"
                        ))
                        .requiredDocumentation("Door-to-Balloon Time (minutes), Culprit Artery (LAD/RCA/LCx), Post-PCI TIMI 3 Flow")
                        .build(),

                ClinicalStep.builder()
                        .stepNumber(4)
                        .timing("Post-PCI Day 1 - 3 (CCU)")
                        .actionName("Coronary Care Unit Telemetry & GDMT Titration")
                        .description("Continuous arrhythmia monitoring. Initiate guideline-directed medical therapy (GDMT). Perform echocardiogram.")
                        .standardOrderSet(Arrays.asList(
                                "Transthoracic Echocardiogram (TTE) for LVEF assessment",
                                "Beta-blocker (Metoprolol Succinate 25-50mg daily)",
                                "ACE-Inhibitor (Ramipril / Enalapril) or ARNI if LVEF <= 40%",
                                "Dual Antiplatelet Therapy (DAPT: Aspirin 81mg + Ticagrelor 90mg BID)",
                                "Statin (Atorvastatin 80mg daily)"
                        ))
                        .requiredDocumentation("LVEF percentage, Peak Troponin, Renal Function Trend")
                        .build()
        );

        PATHWAYS.put("STEMI_PATHWAY", ClinicalPathway.builder()
                .pathwayId("PATH-CARD-001")
                .conditionName("Acute ST-Elevation Myocardial Infarction (STEMI)")
                .icd10Primary("I21.0 - I21.3")
                .targetPopulation("Adult emergency patients with persistent ST-segment elevation >= 1mm in 2 contiguous leads")
                .steps(stemiSteps)
                .dischargeCriteria(Arrays.asList(
                        "Hemodynamically stable >= 24 hours without inotropes or vasodilators",
                        "Absence of malignant ventricular arrhythmias on continuous telemetry",
                        "Patient on optimal GDMT regimen with documented ejection fraction",
                        "Formal cardiac rehabilitation consultation completed",
                        "Follow-up cardiology outpatient appointment scheduled within 7-10 days"
                ))
                .build());

        // 2. Acute Decompensated Heart Failure (ADHF) Pathway
        List<ClinicalStep> hfSteps = Arrays.asList(
                ClinicalStep.builder()
                        .stepNumber(1)
                        .timing("0 - 60 Minutes (Intake)")
                        .actionName("Hemodynamic Profile & Decongestive Therapy")
                        .description("Classify hemodynamic profile (Warm/Cold, Wet/Dry). Assess volume overload. Initiate IV loop diuretics.")
                        .standardOrderSet(Arrays.asList(
                                "IV Furosemide bolus (2.5x oral home dose) or 40-80 mg IV stat",
                                "Strict Intake & Output (I&O) recording",
                                "Daily weights with standing scale",
                                "Stat NT-proBNP or BNP, Electrolytes, BUN, Creatinine",
                                "Chest Radiograph (PA/AP) and Point-of-Care Lung Ultrasound (B-lines)"
                        ))
                        .requiredDocumentation("Baseline JVP, Peripheral Edema Grade (1-4+), Lung Crackles")
                        .build(),

                ClinicalStep.builder()
                        .stepNumber(2)
                        .timing("24 - 48 Hours")
                        .actionName("Diuretic Optimization & Neurohormonal Blockade")
                        .description("Evaluate 2-hour spot urinary sodium (> 50-70 mmol/L) or 6-hour urine output (> 100-150 mL/h). Double diuretic dose if inadequate.")
                        .standardOrderSet(Arrays.asList(
                                "Sequential Nephron Blockade (add Metolazone 2.5-5 mg) if diuretic resistant",
                                "Daily Metabolic Panel (Sodium, Potassium, Creatinine)",
                                "Initiate or uptitrate SGLT2 inhibitor (Empagliflozin 10mg or Dapagliflozin 10mg)"
                        ))
                        .requiredDocumentation("Net 24-hour Fluid Balance (target -1.5 to -2.0 Liters/day), Weight change")
                        .build()
        );

        PATHWAYS.put("HF_PATHWAY", ClinicalPathway.builder()
                .pathwayId("PATH-CARD-002")
                .conditionName("Acute Decompensated Heart Failure (ADHF)")
                .icd10Primary("I50.9")
                .targetPopulation("Adult patients with acute pulmonary congestion and peripheral fluid overload")
                .steps(hfSteps)
                .dischargeCriteria(Arrays.asList(
                        "Clinical euvolemia achieved (resolution of orthopnea, JVP normal, trace/no edema)",
                        "Transition to stable oral diuretic regimen >= 24 hours prior to discharge",
                        "Stable renal function and electrolytes on guideline-directed oral therapy",
                        "Patient educated on low-sodium diet (< 2g/day) and daily weight monitoring protocol"
                ))
                .build());
    }

    public List<ClinicalPathway> getAllPathways() {
        return new ArrayList<>(PATHWAYS.values());
    }

    public Optional<ClinicalPathway> getPathway(String key) {
        return Optional.ofNullable(PATHWAYS.get(key));
    }
}
