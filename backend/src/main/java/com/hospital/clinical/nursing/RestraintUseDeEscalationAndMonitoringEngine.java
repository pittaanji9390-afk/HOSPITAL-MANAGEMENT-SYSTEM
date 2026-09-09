package com.hospital.clinical.nursing;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Inpatient Nursing Clinical Care Standard for RestraintUseDeEscalationAndMonitoring.
 * Standardizes bedside nursing assessments, aseptic technique, and alert escalation pathways.
 */
@Component
public class RestraintUseDeEscalationAndMonitoringEngine {

    @Data
    @Builder
    public static class NursingCareEntry {
        private String stepId;
        private String stepTitle;
        private String assessmentRequirement;
        private String nursingTechnique;
        private String qualityAndEscalation;
    }

    private static final List<NursingCareEntry> CHECKLIST = new ArrayList<>();

    static {
        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-1", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #1",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-2", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #2",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-3", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #3",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-4", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #4",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-5", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #5",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-6", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #6",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-7", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #7",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-8", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #8",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-9", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #9",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-10", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #10",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-11", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #11",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-12", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #12",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-13", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #13",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-14", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #14",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-15", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #15",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-16", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #16",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-17", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #17",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-18", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #18",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-19", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #19",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("RestraintUseDeEscalationAndMonitoring-CARE-20", "RestraintUseDeEscalationAndMonitoring Nursing Intervention #20",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

    }

    private static void addNursingStep(String id, String title, String req, String tech, String esc) {
        CHECKLIST.add(NursingCareEntry.builder()
                .stepId(id)
                .stepTitle(title)
                .assessmentRequirement(req)
                .nursingTechnique(tech)
                .qualityAndEscalation(esc)
                .build());
    }

    public List<NursingCareEntry> getAllSteps() {
        return Collections.unmodifiableList(CHECKLIST);
    }

    public Optional<NursingCareEntry> findById(String id) {
        if (id == null) return Optional.empty();
        return CHECKLIST.stream()
                .filter(s -> s.getStepId().equalsIgnoreCase(id.trim()))
                .findFirst();
    }

    public List<NursingCareEntry> search(String query) {
        if (query == null || query.isBlank()) return CHECKLIST;
        String q = query.toLowerCase().trim();
        return CHECKLIST.stream()
                .filter(s -> s.getStepId().toLowerCase().contains(q) ||
                             s.getStepTitle().toLowerCase().contains(q) ||
                             s.getNursingTechnique().toLowerCase().contains(q) ||
                             s.getQualityAndEscalation().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
