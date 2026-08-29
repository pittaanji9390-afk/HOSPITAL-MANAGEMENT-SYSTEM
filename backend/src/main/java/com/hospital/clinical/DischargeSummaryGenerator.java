package com.hospital.clinical;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Automated Inpatient Clinical Discharge Summary & Continuity of Care Generator.
 * Compiles longitudinal hospital encounter data into a standardized medico-legal narrative document.
 */
@Component
public class DischargeSummaryGenerator {

    @Data
    @Builder
    public static class DischargeSummaryPayload {
        private String hospitalName;
        private String hospitalAddress;
        private String admissionNo;
        private String patientMrn;
        private String patientName;
        private int patientAge;
        private String patientGender;
        private LocalDate admissionDate;
        private LocalDate dischargeDate;
        private String primaryDoctorName;
        private String departmentName;
        private String wardBed;
        private String primaryDiagnosis;
        private List<String> secondaryDiagnoses;
        private String admissionReasonAndHistory;
        private String hospitalCourseAndInterventions;
        private List<String> keyLabAndImagingResults;
        private List<DischargeMedication> dischargeMedications;
        private List<String> dietaryAndPhysicalRestrictions;
        private String followUpSchedule;
        private List<String> emergencyRedFlags;
    }

    @Data
    @Builder
    public static class DischargeMedication {
        private String drugName;
        private String dosage;
        private String route;
        private String frequency;
        private int durationDays;
        private String instructions;
    }

    /**
     * Generates a standardized clinical discharge summary in clean markdown / plain text.
     */
    public String generateDischargeSummaryDocument(DischargeSummaryPayload p) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("================================================================================\n");
        sb.append("                        ").append(p.getHospitalName().toUpperCase()).append("\n");
        sb.append("                 CLINICAL DISCHARGE SUMMARY & CARE CONTINUITY\n");
        sb.append("================================================================================\n\n");

        sb.append("PATIENT DEMOGRAPHICS & ENCOUNTER DETAILS\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("Patient Name    : ").append(p.getPatientName()).append(" (").append(p.getPatientGender()).append(", ").append(p.getPatientAge()).append(" yrs)\n");
        sb.append("MRN             : ").append(p.getPatientMrn()).append(" | Admission No: ").append(p.getAdmissionNo()).append("\n");
        sb.append("Admission Date  : ").append(p.getAdmissionDate().format(fmt)).append(" | Discharge Date: ").append(p.getDischargeDate().format(fmt)).append("\n");
        sb.append("Attending Doctor: ").append(p.getPrimaryDoctorName()).append(" (Dept: ").append(p.getDepartmentName()).append(")\n");
        sb.append("Ward / Bed      : ").append(p.getWardBed()).append("\n\n");

        sb.append("FINAL CLINICAL DIAGNOSIS\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("Primary Diagnosis   : ").append(p.getPrimaryDiagnosis()).append("\n");
        if (p.getSecondaryDiagnoses() != null && !p.getSecondaryDiagnoses().isEmpty()) {
            sb.append("Secondary Diagnoses : ").append(String.join("; ", p.getSecondaryDiagnoses())).append("\n");
        }
        sb.append("\n");

        sb.append("CLINICAL SUMMARY OF HOSPITALIZATION\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("Presenting Complaint & History:\n").append(p.getAdmissionReasonAndHistory()).append("\n\n");
        sb.append("In-Hospital Clinical Course & Interventions:\n").append(p.getHospitalCourseAndInterventions()).append("\n\n");

        if (p.getKeyLabAndImagingResults() != null && !p.getKeyLabAndImagingResults().isEmpty()) {
            sb.append("Significant Investigations & Imaging Findings:\n");
            for (String lab : p.getKeyLabAndImagingResults()) {
                sb.append("  • ").append(lab).append("\n");
            }
            sb.append("\n");
        }

        sb.append("DISCHARGE MEDICATIONS & RECONCILIATION\n");
        sb.append("--------------------------------------------------------------------------------\n");
        if (p.getDischargeMedications() != null) {
            sb.append(String.format("%-25s | %-12s | %-12s | %-15s | %-8s | %s\n", "Medication", "Dose", "Route", "Frequency", "Duration", "Instructions"));
            sb.append("--------------------------------------------------------------------------------\n");
            for (DischargeMedication med : p.getDischargeMedications()) {
                sb.append(String.format("%-25s | %-12s | %-12s | %-15s | %-8s | %s\n",
                        med.getDrugName(), med.getDosage(), med.getRoute(), med.getFrequency(), med.getDurationDays() + " days", med.getInstructions()));
            }
        }
        sb.append("\n");

        sb.append("DISCHARGE ADVICE & REHABILITATION INSTRUCTIONS\n");
        sb.append("--------------------------------------------------------------------------------\n");
        if (p.getDietaryAndPhysicalRestrictions() != null) {
            for (String inst : p.getDietaryAndPhysicalRestrictions()) {
                sb.append("  ✓ ").append(inst).append("\n");
            }
        }
        sb.append("\nFollow-Up Schedule:\n  ").append(p.getFollowUpSchedule()).append("\n\n");

        sb.append("EMERGENCY RED FLAGS (REPORT TO HOSPITAL IMMEDIATELY IF EXPERIENCING):\n");
        sb.append("--------------------------------------------------------------------------------\n");
        if (p.getEmergencyRedFlags() != null) {
            for (String flag : p.getEmergencyRedFlags()) {
                sb.append("  ⚠ ").append(flag).append("\n");
            }
        }
        sb.append("\n================================================================================\n");
        sb.append("Attending Physician Signature: _______________________ Date: ").append(p.getDischargeDate().format(fmt)).append("\n");

        return sb.toString();
    }
}
