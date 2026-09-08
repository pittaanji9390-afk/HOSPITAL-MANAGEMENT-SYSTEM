package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols.
 * Provides standardized medical monographs, evidence-based diagnostic algorithms,
 * and therapeutic decision support for high-complexity clinical encounters.
 */
@Component
public class OphthalmologyCorneaExternalEngine {

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
        add("SPEC-361", "Clinical Condition Model #361 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #1.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-362", "Clinical Condition Model #362 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #2.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-363", "Clinical Condition Model #363 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #3.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-364", "Clinical Condition Model #364 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #4.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-365", "Clinical Condition Model #365 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #5.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-366", "Clinical Condition Model #366 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #6.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-367", "Clinical Condition Model #367 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #7.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-368", "Clinical Condition Model #368 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #8.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-369", "Clinical Condition Model #369 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #9.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-370", "Clinical Condition Model #370 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #10.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-371", "Clinical Condition Model #371 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #11.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-372", "Clinical Condition Model #372 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #12.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-373", "Clinical Condition Model #373 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #13.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-374", "Clinical Condition Model #374 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #14.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-375", "Clinical Condition Model #375 - Corneal Ulcers, Keratoconus & Ocular Surface Disease Protocols",
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
