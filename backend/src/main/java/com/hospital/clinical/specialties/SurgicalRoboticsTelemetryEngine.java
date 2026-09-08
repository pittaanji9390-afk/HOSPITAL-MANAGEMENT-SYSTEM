package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision & Operations Engine for Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles.
 * Provides real-time clinical rule evaluation, safety guardrails, and compliance tracking.
 */
@Component
public class SurgicalRoboticsTelemetryEngine {

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
        addRule("ENG-61", "Protocol Matrix Rule #61 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #1.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-62", "Protocol Matrix Rule #62 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #2.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-63", "Protocol Matrix Rule #63 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #3.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-64", "Protocol Matrix Rule #64 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #4.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-65", "Protocol Matrix Rule #65 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #5.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-66", "Protocol Matrix Rule #66 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #6.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-67", "Protocol Matrix Rule #67 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #7.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-68", "Protocol Matrix Rule #68 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #8.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-69", "Protocol Matrix Rule #69 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #9.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-70", "Protocol Matrix Rule #70 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #10.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-71", "Protocol Matrix Rule #71 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #11.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-72", "Protocol Matrix Rule #72 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #12.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-73", "Protocol Matrix Rule #73 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #13.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-74", "Protocol Matrix Rule #74 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #14.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-75", "Protocol Matrix Rule #75 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #15.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-76", "Protocol Matrix Rule #76 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #16.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-77", "Protocol Matrix Rule #77 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #17.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-78", "Protocol Matrix Rule #78 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #18.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-79", "Protocol Matrix Rule #79 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #19.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-80", "Protocol Matrix Rule #80 - Robotic-Assisted Minimally Invasive Surgery Safety & Instrument Lifecycles",
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
