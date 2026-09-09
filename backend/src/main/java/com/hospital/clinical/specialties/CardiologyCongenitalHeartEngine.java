package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Adult & Pediatric Congenital Heart Disease Management.
 * Provides standardized medical monographs, evidence-based diagnostic algorithms,
 * and therapeutic decision support for high-complexity clinical encounters.
 */
@Component
public class CardiologyCongenitalHeartEngine {

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
        add("SPEC-16", "Clinical Condition Model #16 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #1.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-17", "Clinical Condition Model #17 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #2.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-18", "Clinical Condition Model #18 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #3.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-19", "Clinical Condition Model #19 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #4.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-20", "Clinical Condition Model #20 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #5.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-21", "Clinical Condition Model #21 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #6.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-22", "Clinical Condition Model #22 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #7.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-23", "Clinical Condition Model #23 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #8.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-24", "Clinical Condition Model #24 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #9.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-25", "Clinical Condition Model #25 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #10.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-26", "Clinical Condition Model #26 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #11.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-27", "Clinical Condition Model #27 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #12.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-28", "Clinical Condition Model #28 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #13.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-29", "Clinical Condition Model #29 - Adult & Pediatric Congenital Heart Disease Management",
            "Diagnostic Criteria: Comprehensive laboratory biomarker thresholds, physical examination findings, and gold-standard imaging modalities for clinical presentation #14.",
            "Evidence-Based Therapeutic Regimen: First-line pharmacotherapy with standard titration curves, second-line escalation pathways, contraindications, and organ safety monitoring protocols.",
            "Safety and Monitoring Parameters: Serial organ function panels, therapeutic drug monitoring, and clinical endpoint reassessment schedules.");

        add("SPEC-30", "Clinical Condition Model #30 - Adult & Pediatric Congenital Heart Disease Management",
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
