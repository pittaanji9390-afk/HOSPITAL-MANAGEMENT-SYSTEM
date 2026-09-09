package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Thyroid Storm, Myxedema Coma & Acute Adrenal Crisis.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class EndocrinologyThyroidAdrenalEngine {

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
                .icdCode("E05.01")
                .conditionName("Thyroid Storm / Severe Thyrotoxic Crisis")
                .diagnosticCriteria("Burch-Wartofsky Point Scale >= 45: Hyperpyrexia > 39.5C, tachycardia > 140 bpm, atrial fibrillation, delirium, jaundice")
                .evidenceBasedTherapy("FIVE-STEP ANTITHYROID PROTOCOL: (1) Propylthiouracil (PTU) 500-1000mg load then 250mg q4h, (2) Saturated Potassium Iodide (SSKI) 5 drops q6h (1h post-PTU), (3) Hydrocortisone 100mg IV q8h, (4) Propranolol 60-80mg PO q4h or Esmolol IV, (5) Cooling")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E03.9")
                .conditionName("Myxedema Coma (Severe Decompensated Hypothyroidism)")
                .diagnosticCriteria("Hypothermia (< 35.5C), bradycardia, hypoventilation, hyponatremia, periorbital edema, stupor/coma")
                .evidenceBasedTherapy("IV Levothyroxine (T4) 200-400 mcg bolus then 50-100 mcg daily + IV Liothyronine (T3) 5-20 mcg q8h + IV Hydrocortisone 100mg q8h (mandatory before thyroid replacement)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E27.2")
                .conditionName("Acute Adrenocortical Crisis (Addisonian Crisis)")
                .diagnosticCriteria("Refractory shock unresponsive to vasopressors, severe hyponatremia, hyperkalemia, hypoglycemia, abdominal pain")
                .evidenceBasedTherapy("IMMEDIATE IV HYDROCORTISONE 100mg bolus then 50mg IV q6h + Rapid infusion of 0.9% Normal Saline with 5% Dextrose (D5NS) 1000 mL in first hour")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E24.0")
                .conditionName("Cushing Disease / Severe ACTH-Dependent Hypercortisolemia")
                .diagnosticCriteria("24-hour urinary free cortisol > 3x ULN, elevated late-night salivary cortisol, unsuppressed high-dose Dexamethasone")
                .evidenceBasedTherapy("Transsphenoidal pituitary adenomectomy (TSS) or Ketoconazole 200-400mg tid / Osilodrostat 2-30mg bid (Steroidogenesis inhibitors)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E27.5")
                .conditionName("Pheochromocytoma Hypertensive Paroxysm")
                .diagnosticCriteria("Severe episodic hypertension (BP > 220/120 mmHg), headache, sweating, palpitations; elevated plasma free metanephrines")
                .evidenceBasedTherapy("Alpha-adrenergic blockade FIRST (Phenoxybenzamine 10mg bid titrated up to 100mg/day for >= 10-14 days) BEFORE initiating beta-blockers (to avoid fatal unopposed alpha-vasoconstriction)")
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
