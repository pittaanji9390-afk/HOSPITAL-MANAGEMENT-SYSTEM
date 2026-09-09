package com.hospital.clinical.nursing;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Inpatient Nursing Clinical Care Standard for PatientControlledAnalgesiaSedationScore.
 * Standardizes bedside nursing assessments, aseptic technique, and alert escalation pathways.
 */
@Component
public class PatientControlledAnalgesiaSedationScoreEngine {

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
        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-1", "PatientControlledAnalgesiaSedationScore Nursing Intervention #1",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-2", "PatientControlledAnalgesiaSedationScore Nursing Intervention #2",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-3", "PatientControlledAnalgesiaSedationScore Nursing Intervention #3",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-4", "PatientControlledAnalgesiaSedationScore Nursing Intervention #4",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-5", "PatientControlledAnalgesiaSedationScore Nursing Intervention #5",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-6", "PatientControlledAnalgesiaSedationScore Nursing Intervention #6",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-7", "PatientControlledAnalgesiaSedationScore Nursing Intervention #7",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-8", "PatientControlledAnalgesiaSedationScore Nursing Intervention #8",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-9", "PatientControlledAnalgesiaSedationScore Nursing Intervention #9",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-10", "PatientControlledAnalgesiaSedationScore Nursing Intervention #10",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-11", "PatientControlledAnalgesiaSedationScore Nursing Intervention #11",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-12", "PatientControlledAnalgesiaSedationScore Nursing Intervention #12",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-13", "PatientControlledAnalgesiaSedationScore Nursing Intervention #13",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-14", "PatientControlledAnalgesiaSedationScore Nursing Intervention #14",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-15", "PatientControlledAnalgesiaSedationScore Nursing Intervention #15",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-16", "PatientControlledAnalgesiaSedationScore Nursing Intervention #16",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-17", "PatientControlledAnalgesiaSedationScore Nursing Intervention #17",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-18", "PatientControlledAnalgesiaSedationScore Nursing Intervention #18",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-19", "PatientControlledAnalgesiaSedationScore Nursing Intervention #19",
            "Bedside Clinical Assessment & Verification: Confirm 2 patient identifiers, inspect vascular access/dressing integrity, assess skin barrier, and document baseline physiologic indicators.",
            "Evidence-Based Nursing Technique: Execute strict aseptic non-touch technique (ANTT), maintain barrier precautions, record precise hourly fluid balance, and calibrate bedside infusion pumps.",
            "Quality Assurance & Alert Escalation: Report erythema, induration, extravasation, or hemodynamic deviation to the attending physician immediately and log tamper-evident incident report.");

        addNursingStep("PatientControlledAnalgesiaSedationScore-CARE-20", "PatientControlledAnalgesiaSedationScore Nursing Intervention #20",
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
