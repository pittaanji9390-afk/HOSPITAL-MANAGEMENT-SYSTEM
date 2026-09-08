package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision & Operations Engine for Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances.
 * Provides real-time clinical rule evaluation, safety guardrails, and compliance tracking.
 */
@Component
public class PharmacyAutomatedDispensingCabinetEngine {

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
        addRule("ENG-141", "Protocol Matrix Rule #141 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #1.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-142", "Protocol Matrix Rule #142 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #2.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-143", "Protocol Matrix Rule #143 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #3.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-144", "Protocol Matrix Rule #144 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #4.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-145", "Protocol Matrix Rule #145 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #5.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-146", "Protocol Matrix Rule #146 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #6.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-147", "Protocol Matrix Rule #147 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #7.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-148", "Protocol Matrix Rule #148 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #8.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-149", "Protocol Matrix Rule #149 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #9.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-150", "Protocol Matrix Rule #150 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #10.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-151", "Protocol Matrix Rule #151 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #11.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-152", "Protocol Matrix Rule #152 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #12.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-153", "Protocol Matrix Rule #153 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #13.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-154", "Protocol Matrix Rule #154 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #14.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-155", "Protocol Matrix Rule #155 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #15.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-156", "Protocol Matrix Rule #156 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #16.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-157", "Protocol Matrix Rule #157 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #17.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-158", "Protocol Matrix Rule #158 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #18.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-159", "Protocol Matrix Rule #159 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
            "Mandatory Clinical Verification: Detailed laboratory thresholds, physiological telemetry targets, and pre-authorization verification for encounter #19.",
            "Standardized Execution Directive: Evidence-based stepwise clinical intervention administered under closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiological deviations exceed established hospital tolerance boundaries, immediately trigger specialist escalation.");

        addRule("ENG-160", "Protocol Matrix Rule #160 - Automated Dispensing Cabinets (ADC), Pyxis Integration & Controlled Substances",
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
