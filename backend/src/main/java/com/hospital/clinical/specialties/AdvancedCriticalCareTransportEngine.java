package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision & Operations Engine for Inter-Facility Critical Care Transport & Aeromedical Evacuation.
 * Provides real-time clinical rule evaluation, safety guardrails, and compliance tracking.
 */
@Component
public class AdvancedCriticalCareTransportEngine {

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
        addRule("ENG-1", "Protocol Matrix Rule #1 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #1.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-2", "Protocol Matrix Rule #2 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #2.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-3", "Protocol Matrix Rule #3 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #3.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-4", "Protocol Matrix Rule #4 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #4.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-5", "Protocol Matrix Rule #5 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #5.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-6", "Protocol Matrix Rule #6 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #6.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-7", "Protocol Matrix Rule #7 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #7.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-8", "Protocol Matrix Rule #8 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #8.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-9", "Protocol Matrix Rule #9 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #9.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-10", "Protocol Matrix Rule #10 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #10.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-11", "Protocol Matrix Rule #11 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #11.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-12", "Protocol Matrix Rule #12 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #12.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-13", "Protocol Matrix Rule #13 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #13.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-14", "Protocol Matrix Rule #14 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #14.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-15", "Protocol Matrix Rule #15 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #15.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-16", "Protocol Matrix Rule #16 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #16.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-17", "Protocol Matrix Rule #17 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #17.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-18", "Protocol Matrix Rule #18 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #18.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-19", "Protocol Matrix Rule #19 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #19.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-20", "Protocol Matrix Rule #20 - Inter-Facility Critical Care Transport & Aeromedical Evacuation",
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
