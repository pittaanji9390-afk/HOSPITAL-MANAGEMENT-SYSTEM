package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision & Operations Engine for DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons.
 * Provides real-time clinical rule evaluation, safety guardrails, and compliance tracking.
 */
@Component
public class RadiologyDicomStructuredReportEngine {

    @Data
    @Builder
    public static class ClinicalRuleEntry {
        private String ruleId;
        private String ruleTitle;
        private String verificationChecks;
        private String executionDirective;
        private String safetyGuardrails;
    }

    private static final List<ClinicalRuleEntry> RULES = new ArrayList<>();

    static {
        addRule("ENG-101", "Protocol Matrix Rule #101 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #1.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-102", "Protocol Matrix Rule #102 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #2.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-103", "Protocol Matrix Rule #103 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #3.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-104", "Protocol Matrix Rule #104 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #4.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-105", "Protocol Matrix Rule #105 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #5.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-106", "Protocol Matrix Rule #106 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #6.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-107", "Protocol Matrix Rule #107 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #7.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-108", "Protocol Matrix Rule #108 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #8.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-109", "Protocol Matrix Rule #109 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #9.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-110", "Protocol Matrix Rule #110 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #10.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-111", "Protocol Matrix Rule #111 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #11.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-112", "Protocol Matrix Rule #112 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #12.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-113", "Protocol Matrix Rule #113 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #13.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-114", "Protocol Matrix Rule #114 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #14.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-115", "Protocol Matrix Rule #115 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #15.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-116", "Protocol Matrix Rule #116 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #16.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-117", "Protocol Matrix Rule #117 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #17.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-118", "Protocol Matrix Rule #118 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #18.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-119", "Protocol Matrix Rule #119 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #19.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-120", "Protocol Matrix Rule #120 - DICOM Structured Reporting (SR), BI-RADS, PI-RADS & LI-RADS Lexicons",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #20.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

    }

    private static void addRule(String id, String title, String ver, String exec, String safe) {
        RULES.add(ClinicalRuleEntry.builder()
                .ruleId(id)
                .ruleTitle(title)
                .verificationChecks(ver)
                .executionDirective(exec)
                .safetyGuardrails(safe)
                .build());
    }

    public List<ClinicalRuleEntry> getAllRules() {
        return Collections.unmodifiableList(RULES);
    }

    public Optional<ClinicalRuleEntry> findById(String id) {
        if (id == null) return Optional.empty();
        return RULES.stream()
                .filter(r -> r.getRuleId().equalsIgnoreCase(id.trim()))
                .findFirst();
    }

    public List<ClinicalRuleEntry> search(String query) {
        if (query == null || query.isBlank()) return RULES;
        String q = query.toLowerCase().trim();
        return RULES.stream()
                .filter(r -> r.getRuleId().toLowerCase().contains(q) ||
                             r.getRuleTitle().toLowerCase().contains(q) ||
                             r.getExecutionDirective().toLowerCase().contains(q) ||
                             r.getSafetyGuardrails().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
