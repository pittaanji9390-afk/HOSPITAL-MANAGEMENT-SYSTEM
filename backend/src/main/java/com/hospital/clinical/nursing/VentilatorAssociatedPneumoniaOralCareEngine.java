package com.hospital.clinical.nursing;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Inpatient Nursing Clinical Care Standard for VentilatorAssociatedPneumoniaOralCare.
 * Standardizes bedside nursing assessments, aseptic technique, and alert escalation pathways.
 */
@Component
public class VentilatorAssociatedPneumoniaOralCareEngine {

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
        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-1", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #1",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-2", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #2",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-3", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #3",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-4", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #4",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-5", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #5",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-6", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #6",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-7", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #7",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-8", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #8",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-9", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #9",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-10", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #10",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-11", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #11",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-12", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #12",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-13", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #13",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-14", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #14",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-15", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #15",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-16", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #16",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-17", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #17",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-18", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #18",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-19", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #19",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("VentilatorAssociatedPneumoniaOralCare-CARE-20", "VentilatorAssociatedPneumoniaOralCare Nursing Intervention #20",
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
