package com.hospital.clinical;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Automated Inpatient Clinical Discharge Summary & Continuity of Care Generator.
 * Compiles longitudinal hospital encounter data into a standardized, clean medico-legal narrative document.
 * Includes strict null-safety, whitespace sanitation, and blank section suppression.
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

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    /**
     * Generates a sanitized clinical discharge summary document in clean markdown.
     */
    public String generateDischargeSummaryDocument(DischargeSummaryPayload p) {
        if (p == null) {
            return "ERROR: Discharge summary payload is null.";
        }

        StringBuilder sb = new StringBuilder();

        // 1. Hospital Header
        String hosp = StringUtils.hasText(p.getHospitalName()) ? p.getHospitalName().trim().toUpperCase() : "APEX HEALTHCARE SYSTEM";
        sb.append("================================================================================\n");
        sb.append(centerText(hosp, 80)).append("\n");
        sb.append(centerText("CLINICAL DISCHARGE SUMMARY & CARE CONTINUITY", 80)).append("\n");
        sb.append("================================================================================\n\n");

        // 2. Patient Demographics
        sb.append("PATIENT DEMOGRAPHICS & ENCOUNTER DETAILS\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("Patient Name    : ").append(defaultString(p.getPatientName(), "Unknown"))
                .append(" (").append(defaultString(p.getPatientGender(), "U"))
                .append(", ").append(p.getPatientAge()).append(" yrs)\n");
        sb.append("MRN             : ").append(defaultString(p.getPatientMrn(), "N/A"))
                .append(" | Admission No: ").append(defaultString(p.getAdmissionNo(), "N/A")).append("\n");

        String admDate = p.getAdmissionDate() != null ? p.getAdmissionDate().format(DATE_FMT) : "N/A";
        String disDate = p.getDischargeDate() != null ? p.getDischargeDate().format(DATE_FMT) : "N/A";
        sb.append("Admission Date  : ").append(admDate).append(" | Discharge Date: ").append(disDate).append("\n");
        sb.append("Attending Doctor: ").append(defaultString(p.getPrimaryDoctorName(), "Staff Physician"))
                .append(" (Dept: ").append(defaultString(p.getDepartmentName(), "General Medicine")).append(")\n");
        sb.append("Ward / Bed      : ").append(defaultString(p.getWardBed(), "N/A")).append("\n\n");

        // 3. Clinical Diagnoses
        sb.append("FINAL CLINICAL DIAGNOSIS\n");
        sb.append("--------------------------------------------------------------------------------\n");
        sb.append("Primary Diagnosis   : ").append(defaultString(p.getPrimaryDiagnosis(), "Clinical Evaluation Pending")).append("\n");

        List<String> cleanSecDiag = cleanList(p.getSecondaryDiagnoses());
        if (!cleanSecDiag.isEmpty()) {
            sb.append("Secondary Diagnoses : ").append(String.join("; ", cleanSecDiag)).append("\n");
        }
        sb.append("\n");

        // 4. Clinical Summary of Hospitalization
        if (StringUtils.hasText(p.getAdmissionReasonAndHistory()) || StringUtils.hasText(p.getHospitalCourseAndInterventions())) {
            sb.append("CLINICAL SUMMARY OF HOSPITALIZATION\n");
            sb.append("--------------------------------------------------------------------------------\n");
            if (StringUtils.hasText(p.getAdmissionReasonAndHistory())) {
                sb.append("Presenting Complaint & History:\n").append(p.getAdmissionReasonAndHistory().trim()).append("\n\n");
            }
            if (StringUtils.hasText(p.getHospitalCourseAndInterventions())) {
                sb.append("In-Hospital Clinical Course & Interventions:\n").append(p.getHospitalCourseAndInterventions().trim()).append("\n\n");
            }
        }

        // 5. Significant Investigations
        List<String> cleanLabs = cleanList(p.getKeyLabAndImagingResults());
        if (!cleanLabs.isEmpty()) {
            sb.append("SIGNIFICANT INVESTIGATIONS & IMAGING FINDINGS\n");
            sb.append("--------------------------------------------------------------------------------\n");
            for (String lab : cleanLabs) {
                sb.append("  • ").append(lab).append("\n");
            }
            sb.append("\n");
        }

        // 6. Discharge Medications & Reconciliation
        if (p.getDischargeMedications() != null && !p.getDischargeMedications().isEmpty()) {
            sb.append("DISCHARGE MEDICATIONS & RECONCILIATION\n");
            sb.append("--------------------------------------------------------------------------------\n");
            sb.append(String.format("%-25s | %-12s | %-10s | %-15s | %-8s | %s\n", "Medication", "Dose", "Route", "Frequency", "Duration", "Instructions"));
            sb.append("--------------------------------------------------------------------------------\n");
            for (DischargeMedication med : p.getDischargeMedications()) {
                if (med != null && StringUtils.hasText(med.getDrugName())) {
                    sb.append(String.format("%-25s | %-12s | %-10s | %-15s | %-8s | %s\n",
                            truncate(med.getDrugName(), 25),
                            defaultString(med.getDosage(), "-"),
                            defaultString(med.getRoute(), "Oral"),
                            defaultString(med.getFrequency(), "Daily"),
                            med.getDurationDays() > 0 ? med.getDurationDays() + " d" : "Ongoing",
                            defaultString(med.getInstructions(), "As directed")));
                }
            }
            sb.append("\n");
        }

        // 7. Advice & Rehabilitation Instructions
        List<String> cleanAdvice = cleanList(p.getDietaryAndPhysicalRestrictions());
        if (!cleanAdvice.isEmpty() || StringUtils.hasText(p.getFollowUpSchedule())) {
            sb.append("DISCHARGE ADVICE & REHABILITATION INSTRUCTIONS\n");
            sb.append("--------------------------------------------------------------------------------\n");
            for (String inst : cleanAdvice) {
                sb.append("  ✓ ").append(inst).append("\n");
            }
            if (StringUtils.hasText(p.getFollowUpSchedule())) {
                sb.append("Follow-Up Schedule:\n  ").append(p.getFollowUpSchedule().trim()).append("\n");
            }
            sb.append("\n");
        }

        // 8. Emergency Red Flags
        List<String> cleanFlags = cleanList(p.getEmergencyRedFlags());
        if (!cleanFlags.isEmpty()) {
            sb.append("EMERGENCY RED FLAGS (REPORT TO HOSPITAL IMMEDIATELY IF EXPERIENCING):\n");
            sb.append("--------------------------------------------------------------------------------\n");
            for (String flag : cleanFlags) {
                sb.append("  ⚠ ").append(flag).append("\n");
            }
            sb.append("\n");
        }

        // 9. Sign-off
        sb.append("================================================================================\n");
        sb.append("Attending Physician Signature: _______________________ Date: ").append(disDate).append("\n");

        return sb.toString();
    }

    private static String defaultString(String val, String def) {
        return StringUtils.hasText(val) ? val.trim() : def;
    }

    private static List<String> cleanList(List<String> list) {
        if (list == null) return List.of();
        return list.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(StringUtils::hasText)
                .collect(Collectors.toList());
    }

    private static String truncate(String val, int maxLen) {
        if (val == null) return "";
        return val.length() <= maxLen ? val : val.substring(0, maxLen - 3) + "...";
    }

    private static String centerText(String text, int width) {
        if (text == null) text = "";
        int pad = Math.max(0, (width - text.length()) / 2);
        return " ".repeat(pad) + text;
    }
}
