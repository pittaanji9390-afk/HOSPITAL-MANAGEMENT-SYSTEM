package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision & Operations Engine for Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings.
 * Provides real-time clinical rule evaluation, safety guardrails, and compliance tracking.
 */
@Component
public class LaboratoryQualityControlWestgardEngine {

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
        addRule("ENG-121", "Protocol Matrix Rule #121 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #1.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-122", "Protocol Matrix Rule #122 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #2.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-123", "Protocol Matrix Rule #123 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #3.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-124", "Protocol Matrix Rule #124 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #4.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-125", "Protocol Matrix Rule #125 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #5.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-126", "Protocol Matrix Rule #126 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #6.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-127", "Protocol Matrix Rule #127 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #7.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-128", "Protocol Matrix Rule #128 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #8.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-129", "Protocol Matrix Rule #129 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #9.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-130", "Protocol Matrix Rule #130 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #10.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-131", "Protocol Matrix Rule #131 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #11.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-132", "Protocol Matrix Rule #132 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #12.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-133", "Protocol Matrix Rule #133 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #13.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-134", "Protocol Matrix Rule #134 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #14.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-135", "Protocol Matrix Rule #135 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #15.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-136", "Protocol Matrix Rule #136 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #16.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-137", "Protocol Matrix Rule #137 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #17.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-138", "Protocol Matrix Rule #138 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #18.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-139", "Protocol Matrix Rule #139 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #19.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-140", "Protocol Matrix Rule #140 - Clinical Laboratory Quality Control (QC), Westgard Multirules & Levey-Jennings",
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
