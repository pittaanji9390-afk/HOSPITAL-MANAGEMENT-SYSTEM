package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Standard ICD-10-PCS (Procedure Coding System) Medical & Surgical Directory.
 * Represents standard 7-character inpatient surgical and interventional procedure codes.
 */
@Component
public class Icd10PcsProcedureMaster {

    @Data
    @Builder
    public static class PcsProcedure {
        private String pcsCode;           // 7-character alphanumeric code (e.g. 0210093)
        private String description;
        private String section;           // 0: Medical and Surgical, 1: Obstetrics, B: Imaging, H: Physical Rehab
        private String bodySystem;        // 2: Heart and Great Vessels, L: Tendons, T: Urinary System
        private String rootOperation;     // 1: Bypass, 2: Change, B: Excision, T: Resection, R: Replacement
        private String bodyPart;          // Coronary Artery, Gallbladder, Knee Joint
        private String approach;          // 0: Open, 4: Percutaneous Endoscopic, X: External
        private String device;            // Synthetic Substitute, Autologous Venous Tissue, No Device
        private String qualifier;         // Diagnostic, Internal Mammary, No Qualifier
    }

    private static final List<PcsProcedure> PCS_CODES = new ArrayList<>();

    static {
        // Cardiovascular Procedures (Section 0, Body System 2)
        add("0210093", "Bypass Coronary Artery, One Site from Coronary Artery with Autologous Venous Tissue, Open Approach", "Medical and Surgical", "Heart and Great Vessels", "Bypass", "Coronary Artery, One Site", "Open", "Autologous Venous Tissue", "Coronary Artery");
        add("02100Z9", "Bypass Coronary Artery, One Site from Internal Mammary, Open Approach", "Medical and Surgical", "Heart and Great Vessels", "Bypass", "Coronary Artery, One Site", "Open", "No Device", "Internal Mammary");
        add("027034Z", "Dilation of Coronary Artery, One Site with Drug-eluting Intraluminal Device, Percutaneous Approach (PCI with DES)", "Medical and Surgical", "Heart and Great Vessels", "Dilation", "Coronary Artery, One Site", "Percutaneous", "Drug-eluting Intraluminal Device", "No Qualifier");
        add("02RF0JZ", "Replacement of Aortic Valve with Synthetic Substitute, Open Approach", "Medical and Surgical", "Heart and Great Vessels", "Replacement", "Aortic Valve", "Open", "Synthetic Substitute", "No Qualifier");
        add("02RG0JZ", "Replacement of Mitral Valve with Synthetic Substitute, Open Approach", "Medical and Surgical", "Heart and Great Vessels", "Replacement", "Mitral Valve", "Open", "Synthetic Substitute", "No Qualifier");
        add("02HK0DZ", "Insertion of Pacemaker Lead into Right Ventricle, Open Approach", "Medical and Surgical", "Heart and Great Vessels", "Insertion", "Right Ventricle", "Open", "Intraluminal Device", "No Qualifier");

        // Digestive System Procedures (Section 0, Body System F & D)
        add("0FT44ZZ", "Resection of Gallbladder, Percutaneous Endoscopic Approach (Laparoscopic Cholecystectomy)", "Medical and Surgical", "Hepatobiliary System and Pancreas", "Resection", "Gallbladder", "Percutaneous Endoscopic", "No Device", "No Qualifier");
        add("0DTJ4ZZ", "Resection of Appendix, Percutaneous Endoscopic Approach (Laparoscopic Appendectomy)", "Medical and Surgical", "Gastrointestinal System", "Resection", "Appendix", "Percutaneous Endoscopic", "No Device", "No Qualifier");
        add("0D160ZA", "Bypass Stomach to Jejunum, Open Approach (Roux-en-Y Gastric Bypass)", "Medical and Surgical", "Gastrointestinal System", "Bypass", "Stomach", "Open", "No Device", "Jejunum");
        add("0DJD8ZZ", "Inspection of Upper Gastrointestinal Tract, Via Natural or Artificial Opening Endoscopic (Diagnostic EGD)", "Medical and Surgical", "Gastrointestinal System", "Inspection", "Upper Gastrointestinal Tract", "Via Natural Opening Endoscopic", "No Device", "No Qualifier");
        add("0DJD8ZZ", "Inspection of Lower Gastrointestinal Tract, Via Natural or Artificial Opening Endoscopic (Diagnostic Colonoscopy)", "Medical and Surgical", "Gastrointestinal System", "Inspection", "Lower Gastrointestinal Tract", "Via Natural Opening Endoscopic", "No Device", "No Qualifier");

        // Musculoskeletal & Joint Procedures (Section 0, Body System S)
        add("0SRD0JZ", "Replacement of Right Knee Joint with Synthetic Substitute, Open Approach (Right Total Knee Arthroplasty)", "Medical and Surgical", "Lower Joints", "Replacement", "Right Knee Joint", "Open", "Synthetic Substitute", "No Qualifier");
        add("0SRE0JZ", "Replacement of Left Knee Joint with Synthetic Substitute, Open Approach (Left Total Knee Arthroplasty)", "Medical and Surgical", "Lower Joints", "Replacement", "Left Knee Joint", "Open", "Synthetic Substitute", "No Qualifier");
        add("0SR9019", "Replacement of Right Hip Joint with Metal on Polyethylene, Open Approach (Right Total Hip Arthroplasty)", "Medical and Surgical", "Lower Joints", "Replacement", "Right Hip Joint", "Open", "Metal on Polyethylene", "No Qualifier");
        add("0SRB019", "Replacement of Left Hip Joint with Metal on Polyethylene, Open Approach (Left Total Hip Arthroplasty)", "Medical and Surgical", "Lower Joints", "Replacement", "Left Hip Joint", "Open", "Metal on Polyethylene", "No Qualifier");
        add("0SHG44Z", "Repair Right Knee Tendon, Percutaneous Endoscopic Approach (Arthroscopic ACL Reconstruction)", "Medical and Surgical", "Bursae, Ligaments, and Tendons", "Repair", "Right Knee Tendon", "Percutaneous Endoscopic", "Internal Fixation Device", "No Qualifier");

        // Obstetrics Procedures (Section 10)
        add("10D00Z0", "Extraction of Products of Conception, Open Approach (Classical Cesarean Section)", "Obstetrics", "Pregnancy", "Extraction", "Products of Conception", "Open", "No Device", "Classical C-Section");
        add("10D00Z1", "Extraction of Products of Conception, Low Cervical Open Approach (Low Transverse Cesarean Section)", "Obstetrics", "Pregnancy", "Extraction", "Products of Conception", "Open", "No Device", "Low Transverse C-Section");
        add("10E0XZZ", "Delivery of Products of Conception, External Approach (Spontaneous Vaginal Delivery)", "Obstetrics", "Pregnancy", "Delivery", "Products of Conception", "External", "No Device", "No Qualifier");
    }

    private static void add(String code, String desc, String sec, String sys, String root, String part, String app, String dev, String qual) {
        PCS_CODES.add(PcsProcedure.builder()
                .pcsCode(code)
                .description(desc)
                .section(sec)
                .bodySystem(sys)
                .rootOperation(root)
                .bodyPart(part)
                .approach(app)
                .device(dev)
                .qualifier(qual)
                .build());
    }

    public List<PcsProcedure> search(String query) {
        if (query == null || query.isBlank()) {
            return PCS_CODES;
        }
        String q = query.toLowerCase().trim();
        return PCS_CODES.stream()
                .filter(p -> p.getPcsCode().toLowerCase().contains(q) ||
                             p.getDescription().toLowerCase().contains(q) ||
                             p.getBodySystem().toLowerCase().contains(q) ||
                             p.getRootOperation().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public Optional<PcsProcedure> findByCode(String code) {
        return PCS_CODES.stream()
                .filter(p -> p.getPcsCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
