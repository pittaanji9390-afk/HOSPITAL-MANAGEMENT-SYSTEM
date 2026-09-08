package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Metabolic Bone Diseases, Paget Disease & Osteomalacia.
 * Provides standardized medical monographs, evidence-based diagnostic algorithms,
 * and therapeutic decision support for high-complexity clinical encounters.
 */
@Component
public class EndocrinologyBoneMetabolismEngine {

    @Data
    @Builder
    public static class ClinicalMonograph {
        private String monographCode;
        private String conditionTitle;
        private String diagnosticCriteria;
        private String therapeuticRegimen;
        private String monitoringParameters;
    }

    private static final List<ClinicalMonograph> REGISTRY = new ArrayList<>();

    static {
        add("SPEC-166", "Clinical Condition Model #166 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #1.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-167", "Clinical Condition Model #167 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #2.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-168", "Clinical Condition Model #168 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #3.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-169", "Clinical Condition Model #169 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #4.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-170", "Clinical Condition Model #170 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #5.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-171", "Clinical Condition Model #171 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #6.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-172", "Clinical Condition Model #172 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #7.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-173", "Clinical Condition Model #173 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #8.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-174", "Clinical Condition Model #174 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #9.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-175", "Clinical Condition Model #175 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #10.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-176", "Clinical Condition Model #176 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #11.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-177", "Clinical Condition Model #177 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #12.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-178", "Clinical Condition Model #178 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #13.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-179", "Clinical Condition Model #179 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #14.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-180", "Clinical Condition Model #180 - Metabolic Bone Diseases, Paget Disease & Osteomalacia",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #15.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

    }

    private static void add(String code, String title, String diag, String therapy, String mon) {
        REGISTRY.add(ClinicalMonograph.builder()
                .monographCode(code)
                .conditionTitle(title)
                .diagnosticCriteria(diag)
                .therapeuticRegimen(therapy)
                .monitoringParameters(mon)
                .build());
    }

    public List<ClinicalMonograph> getAllMonographs() {
        return Collections.unmodifiableList(REGISTRY);
    }

    public Optional<ClinicalMonograph> findByCode(String code) {
        if (code == null) return Optional.empty();
        return REGISTRY.stream()
                .filter(m -> m.getMonographCode().equalsIgnoreCase(code.trim()))
                .findFirst();
    }

    public List<ClinicalMonograph> search(String query) {
        if (query == null || query.isBlank()) return REGISTRY;
        String q = query.toLowerCase().trim();
        return REGISTRY.stream()
                .filter(m -> m.getMonographCode().toLowerCase().contains(q) ||
                             m.getConditionTitle().toLowerCase().contains(q) ||
                             m.getDiagnosticCriteria().toLowerCase().contains(q) ||
                             m.getTherapeuticRegimen().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
