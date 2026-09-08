package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Gastrointestinal Motility Disorders & Functional GI Syndromes.
 * Provides standardized medical monographs, evidence-based diagnostic algorithms,
 * and therapeutic decision support for high-complexity clinical encounters.
 */
@Component
public class GastroenterologyMotilityEngine {

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
        add("SPEC-61", "Clinical Condition Model #61 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #1.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-62", "Clinical Condition Model #62 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #2.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-63", "Clinical Condition Model #63 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #3.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-64", "Clinical Condition Model #64 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #4.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-65", "Clinical Condition Model #65 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #5.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-66", "Clinical Condition Model #66 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #6.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-67", "Clinical Condition Model #67 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #7.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-68", "Clinical Condition Model #68 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #8.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-69", "Clinical Condition Model #69 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #9.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-70", "Clinical Condition Model #70 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #10.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-71", "Clinical Condition Model #71 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #11.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-72", "Clinical Condition Model #72 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #12.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-73", "Clinical Condition Model #73 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #13.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-74", "Clinical Condition Model #74 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #14.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-75", "Clinical Condition Model #75 - Gastrointestinal Motility Disorders & Functional GI Syndromes",
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
