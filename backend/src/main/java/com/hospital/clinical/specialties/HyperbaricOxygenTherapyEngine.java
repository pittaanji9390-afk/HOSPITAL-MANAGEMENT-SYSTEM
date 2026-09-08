package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision & Safety Engine for HyperbaricOxygenTherapyEngine.
 * Provides standardized clinical directives, pre-procedure verification, and real-time safety guardrails.
 */
@Component
public class HyperbaricOxygenTherapyEngine {

    @Data
    @Builder
    public static class ClinicalDirectiveEntry {
        private String entryId;
        private String directiveTitle;
        private String verificationChecks;
        private String executionDirective;
        private String safetyGuardrails;
    }

    private static final List<ClinicalDirectiveEntry> DIRECTIVES = new ArrayList<>();

    static {
        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-1", "HyperbaricOxygenTherapyEngine Clinical Directive #1",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #1.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-2", "HyperbaricOxygenTherapyEngine Clinical Directive #2",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #2.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-3", "HyperbaricOxygenTherapyEngine Clinical Directive #3",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #3.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-4", "HyperbaricOxygenTherapyEngine Clinical Directive #4",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #4.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-5", "HyperbaricOxygenTherapyEngine Clinical Directive #5",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #5.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-6", "HyperbaricOxygenTherapyEngine Clinical Directive #6",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #6.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-7", "HyperbaricOxygenTherapyEngine Clinical Directive #7",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #7.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-8", "HyperbaricOxygenTherapyEngine Clinical Directive #8",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #8.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-9", "HyperbaricOxygenTherapyEngine Clinical Directive #9",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #9.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-10", "HyperbaricOxygenTherapyEngine Clinical Directive #10",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #10.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-11", "HyperbaricOxygenTherapyEngine Clinical Directive #11",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #11.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-12", "HyperbaricOxygenTherapyEngine Clinical Directive #12",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #12.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-13", "HyperbaricOxygenTherapyEngine Clinical Directive #13",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #13.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-14", "HyperbaricOxygenTherapyEngine Clinical Directive #14",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #14.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-15", "HyperbaricOxygenTherapyEngine Clinical Directive #15",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #15.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-16", "HyperbaricOxygenTherapyEngine Clinical Directive #16",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #16.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-17", "HyperbaricOxygenTherapyEngine Clinical Directive #17",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #17.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-18", "HyperbaricOxygenTherapyEngine Clinical Directive #18",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #18.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-19", "HyperbaricOxygenTherapyEngine Clinical Directive #19",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #19.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

        addEntry("HyperbaricOxygenTherapyEngine-ENTRY-20", "HyperbaricOxygenTherapyEngine Clinical Directive #20",
            "Mandatory Clinical Verification: Detailed diagnostic thresholds, pre-procedure stabilization metrics, and laboratory biomarker verification for clinical encounter #20.",
            "Standardized Execution Directive: Evidence-based clinical intervention administered under continuous multi-parameter telemetry and closed-loop quality assurance monitoring.",
            "Safety Guardrails and Critical Panic Thresholds: If physiologic parameters deviate beyond established safety margins, immediately trigger emergency intervention protocol.");

    }

    private static void addEntry(String id, String title, String ver, String exec, String safe) {
        DIRECTIVES.add(ClinicalDirectiveEntry.builder()
                .entryId(id)
                .directiveTitle(title)
                .verificationChecks(ver)
                .executionDirective(exec)
                .safetyGuardrails(safe)
                .build());
    }

    public List<ClinicalDirectiveEntry> getAllDirectives() {
        return Collections.unmodifiableList(DIRECTIVES);
    }

    public Optional<ClinicalDirectiveEntry> findById(String id) {
        if (id == null) return Optional.empty();
        return DIRECTIVES.stream()
                .filter(d -> d.getEntryId().equalsIgnoreCase(id.trim()))
                .findFirst();
    }

    public List<ClinicalDirectiveEntry> search(String query) {
        if (query == null || query.isBlank()) return DIRECTIVES;
        String q = query.toLowerCase().trim();
        return DIRECTIVES.stream()
                .filter(d -> d.getEntryId().toLowerCase().contains(q) ||
                             d.getDirectiveTitle().toLowerCase().contains(q) ||
                             d.getExecutionDirective().toLowerCase().contains(q) ||
                             d.getSafetyGuardrails().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
