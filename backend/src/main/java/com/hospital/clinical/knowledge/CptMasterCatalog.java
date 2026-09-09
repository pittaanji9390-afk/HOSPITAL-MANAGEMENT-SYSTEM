package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Standard CPT (Current Procedural Terminology) Clinical Coding Directory.
 * Self-contained procedure database with Relative Value Units (RVU) and specialty assignments.
 */
@Component
public class CptMasterCatalog {

    @Data
    @Builder
    public static class CptCodeEntry {
        private String code;
        private String description;
        private String category; // Evaluation & Management, Surgery, Radiology, Laboratory, Medicine
        private String subSpecialty;
        private double workRvu;
        private boolean anesthesiaRequired;
        private BigDecimal standardFacilityFee;
    }

    private static final List<CptCodeEntry> CODES = new ArrayList<>();

    static {
        // Evaluation and Management (E/M) Codes
        add("99202", "Office/outpatient visit for new patient, 15-29 minutes, straightforward MDM", "Evaluation & Management", "Outpatient Clinic", 0.93, false, 850.0);
        add("99203", "Office/outpatient visit for new patient, 30-44 minutes, low-level MDM", "Evaluation & Management", "Outpatient Clinic", 1.60, false, 1200.0);
        add("99204", "Office/outpatient visit for new patient, 45-59 minutes, moderate-level MDM", "Evaluation & Management", "Outpatient Clinic", 2.60, false, 1800.0);
        add("99205", "Office/outpatient visit for new patient, 60-74 minutes, high-level MDM", "Evaluation & Management", "Outpatient Clinic", 3.50, false, 2500.0);
        add("99212", "Office/outpatient visit for established patient, 10-19 minutes, straightforward MDM", "Evaluation & Management", "Outpatient Clinic", 0.70, false, 600.0);
        add("99213", "Office/outpatient visit for established patient, 20-29 minutes, low-level MDM", "Evaluation & Management", "Outpatient Clinic", 1.30, false, 900.0);
        add("99214", "Office/outpatient visit for established patient, 30-39 minutes, moderate-level MDM", "Evaluation & Management", "Outpatient Clinic", 1.92, false, 1400.0);
        add("99215", "Office/outpatient visit for established patient, 40-54 minutes, high-level MDM", "Evaluation & Management", "Outpatient Clinic", 2.80, false, 2000.0);
        add("99221", "Initial hospital inpatient care, per day, low-level MDM", "Evaluation & Management", "Inpatient IPD", 1.92, false, 1500.0);
        add("99222", "Initial hospital inpatient care, per day, moderate-level MDM", "Evaluation & Management", "Inpatient IPD", 2.61, false, 2200.0);
        add("99223", "Initial hospital inpatient care, per day, high-level MDM", "Evaluation & Management", "Inpatient IPD", 3.86, false, 3200.0);
        add("99231", "Subsequent hospital inpatient care, per day, straightforward/low MDM", "Evaluation & Management", "Inpatient IPD", 0.76, false, 800.0);
        add("99232", "Subsequent hospital inpatient care, per day, moderate MDM", "Evaluation & Management", "Inpatient IPD", 1.39, false, 1200.0);
        add("99233", "Subsequent hospital inpatient care, per day, high MDM", "Evaluation & Management", "Inpatient IPD", 2.00, false, 1800.0);
        add("99281", "Emergency department visit, straightforward MDM", "Evaluation & Management", "Emergency ER", 0.48, false, 750.0);
        add("99282", "Emergency department visit, low-level MDM", "Evaluation & Management", "Emergency ER", 0.93, false, 1100.0);
        add("99283", "Emergency department visit, moderate-level MDM", "Evaluation & Management", "Emergency ER", 1.42, false, 1600.0);
        add("99284", "Emergency department visit, high-level MDM without immediate threat", "Evaluation & Management", "Emergency ER", 2.56, false, 2500.0);
        add("99285", "Emergency department visit, high-level MDM with immediate threat to life/function", "Evaluation & Management", "Emergency ER", 3.80, false, 4000.0);
        add("99291", "Critical care, evaluation and management of critically ill patient, first 30-74 minutes", "Evaluation & Management", "Critical Care ICU", 4.50, false, 5500.0);

        // Cardiovascular Surgery & Interventions
        add("33510", "Coronary artery bypass, single venous graft", "Surgery", "Cardiothoracic", 23.40, true, 180000.0);
        add("33511", "Coronary artery bypass, 2 venous grafts", "Surgery", "Cardiothoracic", 25.10, true, 210000.0);
        add("33512", "Coronary artery bypass, 3 venous grafts", "Surgery", "Cardiothoracic", 27.20, true, 240000.0);
        add("33533", "Coronary artery bypass, single arterial graft (LIMA to LAD)", "Surgery", "Cardiothoracic", 26.50, true, 220000.0);
        add("92928", "Percutaneous transcatheter placement of intracoronary stent(s), single major vessel", "Surgery", "Interventional Cardiology", 8.50, true, 95000.0);
        add("92929", "Percutaneous transcatheter placement of intracoronary stent(s), each additional vessel", "Surgery", "Interventional Cardiology", 3.20, true, 45000.0);
        add("93458", "Left heart catheterization with coronary angiography and left ventriculography", "Medicine", "Interventional Cardiology", 4.20, true, 35000.0);
        add("33405", "Replacement, aortic valve, with cardiopulmonary bypass; with prosthetic valve", "Surgery", "Cardiothoracic", 32.50, true, 280000.0);

        // Orthopedic Surgery & Arthroscopy
        add("27447", "Arthroplasty, knee, condyle and plateau; medial and lateral compartments (Total Knee Arthroplasty)", "Surgery", "Orthopedics", 20.72, true, 160000.0);
        add("27130", "Arthroplasty, acetabular and proximal femoral prosthetic replacement (Total Hip Arthroplasty)", "Surgery", "Orthopedics", 20.90, true, 175000.0);
        add("29881", "Arthroscopy, knee, surgical; with meniscectomy (medial OR lateral)", "Surgery", "Orthopedics", 7.20, true, 45000.0);
        add("29888", "Arthroscopically aided anterior cruciate ligament (ACL) repair/reconstruction", "Surgery", "Orthopedics", 13.80, true, 85000.0);
        add("27236", "Open treatment of femoral fracture, proximal end, neck, internal fixation or prosthetic replacement", "Surgery", "Orthopedics", 14.50, true, 75000.0);
        add("27758", "Open treatment of tibial shaft fracture with plate/screws or intramedullary nail", "Surgery", "Orthopedics", 11.20, true, 60000.0);

        // General Surgery & Digestive Endoscopy
        add("47562", "Laparoscopy, surgical; cholecystectomy (Removal of Gallbladder)", "Surgery", "General Surgery", 9.80, true, 55000.0);
        add("44970", "Laparoscopy, surgical, appendectomy (Removal of Appendix)", "Surgery", "General Surgery", 8.40, true, 48000.0);
        add("49505", "Repair initial inguinal hernia, age 5 years or older; reducible", "Surgery", "General Surgery", 6.20, true, 35000.0);
        add("43239", "Esophagogastroduodenoscopy (EGD), flexible, transoral; with biopsy, single or multiple", "Surgery", "Gastroenterology", 2.20, true, 12000.0);
        add("45380", "Colonoscopy, flexible; with biopsy, single or multiple", "Surgery", "Gastroenterology", 3.10, true, 16000.0);

        // Radiology & Diagnostic Imaging
        add("71046", "Radiologic examination, chest; 2 views (PA and Lateral)", "Radiology", "Diagnostic Radiology", 0.22, false, 800.0);
        add("70450", "Computed tomography, head or brain; without contrast material (CT Head)", "Radiology", "Computed Tomography", 0.85, false, 3500.0);
        add("71250", "Computed tomography, thorax, diagnostic; without contrast material (CT Chest)", "Radiology", "Computed Tomography", 1.16, false, 4500.0);
        add("74176", "Computed tomography, abdomen and pelvis; without contrast material", "Radiology", "Computed Tomography", 1.74, false, 6500.0);
        add("72148", "Magnetic resonance (e.g., proton) imaging, spinal canal and contents, lumbar; without contrast", "Radiology", "Magnetic Resonance", 1.48, false, 8000.0);
        add("76700", "Ultrasound, abdominal, real time with image documentation; complete", "Radiology", "Ultrasound", 0.81, false, 2200.0);
        add("93306", "Echocardiography, transthoracic, real-time with image documentation, complete with Doppler", "Medicine", "Cardiology", 1.30, false, 4000.0);
    }

    private static void add(String code, String desc, String cat, String spec, double rvu, boolean anesth, Double fee) {
        CODES.add(CptCodeEntry.builder()
                .code(code)
                .description(desc)
                .category(cat)
                .subSpecialty(spec)
                .workRvu(rvu)
                .anesthesiaRequired(anesth)
                .standardFacilityFee(BigDecimal.valueOf(fee))
                .build());
    }

    public List<CptCodeEntry> search(String query) {
        if (query == null || query.isBlank()) {
            return CODES;
        }
        String q = query.toLowerCase().trim();
        return CODES.stream()
                .filter(c -> c.getCode().contains(q) ||
                             c.getDescription().toLowerCase().contains(q) ||
                             c.getCategory().toLowerCase().contains(q) ||
                             c.getSubSpecialty().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<CptCodeEntry> findByCode(String code) {
        return CODES.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
