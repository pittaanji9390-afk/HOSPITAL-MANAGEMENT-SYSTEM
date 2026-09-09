package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Diabetic Ketoacidosis, Hyperosmolar Hyperglycemic State & Acute Endocrine Emergencies.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class EndocrinologyDkaDiabetesEngine {

    @Data
    @Builder
    public static class ClinicalMonograph {
        private String icdCode;
        private String conditionName;
        private String diagnosticCriteria;
        private String evidenceBasedTherapy;
    }

    private static final List<ClinicalMonograph> REGISTRY = new ArrayList<>();

    static {
        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E10.10")
                .conditionName("Severe Diabetic Ketoacidosis (DKA)")
                .diagnosticCriteria("Blood Glucose > 250 mg/dL, Arterial pH < 7.00, Serum Bicarbonate < 10 mEq/L, Anion Gap > 16, positive beta-hydroxybutyrate")
                .evidenceBasedTherapy("FOUR PILLARS OF DKA: (1) 0.9% Normal Saline 1-1.5 L in first hour, (2) IV Regular Insulin infusion 0.1 U/kg/hr (HOLD if K+ < 3.3), (3) Potassium 20-30 mEq/L fluid once K+ < 5.2, (4) Switch to D5W 0.45% NS when glucose < 200 mg/dL")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E11.00")
                .conditionName("Hyperosmolar Hyperglycemic State (HHS)")
                .diagnosticCriteria("Blood Glucose > 600 mg/dL, Effective Serum Osmolality > 320 mOsm/kg, Arterial pH > 7.30, profound dehydration (8-10 L deficit)")
                .evidenceBasedTherapy("Aggressive fluid resuscitation: 0.9% NS 1000 mL/hr for 2-3 hours; IV Regular Insulin 0.05-0.1 U/kg/hr; target gradual glucose reduction 50-70 mg/dL/hr")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E16.0")
                .conditionName("Severe Drug-Induced Hypoglycemia (Glucose < 40 mg/dL with Neuroglycopenia)")
                .diagnosticCriteria("Confusion, diaphoresis, seizure, or coma with capillary blood glucose < 54 mg/dL")
                .evidenceBasedTherapy("IV Dextrose 50% (D50W) 50 mL (25g) push over 3-5 min followed by 10% Dextrose infusion 100 mL/hr; Octreotide 50-100 mcg SC for sulfonylurea-induced hypoglycemia")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E11.40")
                .conditionName("Diabetic Peripheral Sensorimotor Polyneuropathy")
                .diagnosticCriteria("Loss of 10g monofilament protective sensation, burning paresthesias, Toronto score >= 6")
                .evidenceBasedTherapy("Duloxetine 60mg daily (SNRI) OR Pregabalin 150-300mg daily (GABA analog) OR Gabapentin 300-900mg tid + Strict glycemic control (HbA1c < 7.0%)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E11.21")
                .conditionName("Diabetic Kidney Disease with Macroalbuminuria")
                .diagnosticCriteria("Urine Albumin-to-Creatinine Ratio (UACR) > 300 mg/g on 2 of 3 baseline tests")
                .evidenceBasedTherapy("SGLT2 inhibitor (Dapagliflozin 10mg / Empagliflozin 10mg) + Non-steroidal MRA (Finerenone 10-20mg daily) + Max-tolerated ACEi/ARB (Losartan 100mg)")
                .build());

    }

    public List<ClinicalMonograph> getAllMonographs() {
        return Collections.unmodifiableList(REGISTRY);
    }

    public Optional<ClinicalMonograph> findByCode(String icdCode) {
        if (icdCode == null) return Optional.empty();
        return REGISTRY.stream()
                .filter(m -> m.getIcdCode().equalsIgnoreCase(icdCode.trim()))
                .findFirst();
    }

    public List<ClinicalMonograph> searchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) return REGISTRY;
        String q = keyword.toLowerCase().trim();
        return REGISTRY.stream()
                .filter(m -> m.getIcdCode().toLowerCase().contains(q) ||
                             m.getConditionName().toLowerCase().contains(q) ||
                             m.getDiagnosticCriteria().toLowerCase().contains(q) ||
                             m.getEvidenceBasedTherapy().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
