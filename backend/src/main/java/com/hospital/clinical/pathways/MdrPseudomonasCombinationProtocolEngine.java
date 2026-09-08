package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Pathway Engine for MdrPseudomonasCombinationProtocol.
 * Standardizes sequential clinical steps, safety guardrails, and escalation thresholds.
 */
@Component
public class MdrPseudomonasCombinationProtocolEngine {

    @Data
    @Builder
    public static class PathwayStep {
        private String stepId;
        private String stepTitle;
        private String prerequisiteChecks;
        private String executionInstructions;
        private String safetyGuardrails;
    }

    private static final List<PathwayStep> STEPS = new ArrayList<>();

    static {
        addStep("MdrPseudomonasCombinationProtocol-STEP-1", "Step 1: Clinical Action Pathway #1",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-2", "Step 2: Clinical Action Pathway #2",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-3", "Step 3: Clinical Action Pathway #3",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-4", "Step 4: Clinical Action Pathway #4",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-5", "Step 5: Clinical Action Pathway #5",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-6", "Step 6: Clinical Action Pathway #6",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-7", "Step 7: Clinical Action Pathway #7",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-8", "Step 8: Clinical Action Pathway #8",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-9", "Step 9: Clinical Action Pathway #9",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-10", "Step 10: Clinical Action Pathway #10",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-11", "Step 11: Clinical Action Pathway #11",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-12", "Step 12: Clinical Action Pathway #12",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-13", "Step 13: Clinical Action Pathway #13",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-14", "Step 14: Clinical Action Pathway #14",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-15", "Step 15: Clinical Action Pathway #15",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-16", "Step 16: Clinical Action Pathway #16",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-17", "Step 17: Clinical Action Pathway #17",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-18", "Step 18: Clinical Action Pathway #18",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-19", "Step 19: Clinical Action Pathway #19",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

        addStep("MdrPseudomonasCombinationProtocol-STEP-20", "Step 20: Clinical Action Pathway #20",
            "Mandatory Pre-requisite Checklist & Laboratory Triage: Verify hemodynamic stability, baseline arterial blood gas, renal function, coagulation indices, and informed consent.",
            "Execution Instructions: Administer titrated pharmacotherapy under continuous telemetry monitoring. Assess physiologic response at 15-minute intervals.",
            "Escalation Criteria & Safety Guardrails: If mean arterial pressure < 65 mmHg, heart rate > 130 bpm, or urine output < 0.5 mL/kg/hr, trigger immediate senior intensivist consultation.");

    }

    private static void addStep(String id, String title, String pre, String exec, String safety) {
        STEPS.add(PathwayStep.builder()
                .stepId(id)
                .stepTitle(title)
                .prerequisiteChecks(pre)
                .executionInstructions(exec)
                .safetyGuardrails(safety)
                .build());
    }

    public List<PathwayStep> getAllSteps() {
        return Collections.unmodifiableList(STEPS);
    }

    public Optional<PathwayStep> getStepById(String stepId) {
        if (stepId == null) return Optional.empty();
        return STEPS.stream()
                .filter(s -> s.getStepId().equalsIgnoreCase(stepId.trim()))
                .findFirst();
    }

    public List<PathwayStep> search(String query) {
        if (query == null || query.isBlank()) return STEPS;
        String q = query.toLowerCase().trim();
        return STEPS.stream()
                .filter(s -> s.getStepId().toLowerCase().contains(q) ||
                             s.getStepTitle().toLowerCase().contains(q) ||
                             s.getExecutionInstructions().toLowerCase().contains(q) ||
                             s.getSafetyGuardrails().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
