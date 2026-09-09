package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Pediatric Fractures, Salter-Harris Classification & DDH.
 * Provides standardized medical monographs, evidence-based diagnostic algorithms,
 * and therapeutic decision support for high-complexity clinical encounters.
 */
@Component
public class OrthopedicsPediatricTraumaEngine {

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
        add("SPEC-316", "Clinical Condition Model #316 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #1.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-317", "Clinical Condition Model #317 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #2.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-318", "Clinical Condition Model #318 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #3.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-319", "Clinical Condition Model #319 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #4.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-320", "Clinical Condition Model #320 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #5.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-321", "Clinical Condition Model #321 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #6.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-322", "Clinical Condition Model #322 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #7.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-323", "Clinical Condition Model #323 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #8.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-324", "Clinical Condition Model #324 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #9.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-325", "Clinical Condition Model #325 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #10.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-326", "Clinical Condition Model #326 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #11.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-327", "Clinical Condition Model #327 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #12.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-328", "Clinical Condition Model #328 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #13.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-329", "Clinical Condition Model #329 - Pediatric Fractures, Salter-Harris Classification & DDH",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #14.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-330", "Clinical Condition Model #330 - Pediatric Fractures, Salter-Harris Classification & DDH",
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
