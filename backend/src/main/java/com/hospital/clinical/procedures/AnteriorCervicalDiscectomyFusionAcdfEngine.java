package com.hospital.clinical.procedures;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Surgical & Operative Procedure Safety Protocol for AnteriorCervicalDiscectomyFusionAcdf.
 * Implements perioperative surgical checklists, equipment sterile verification, and PACU discharge criteria.
 */
@Component
public class AnteriorCervicalDiscectomyFusionAcdfEngine {

    @Data
    @Builder
    public static class SurgicalChecklistEntry {
        private String stepId;
        private String stepDescription;
        private String preoperativeRequirements;
        private String operativeTechnique;
        private String postopRecoveryProtocol;
    }

    private static final List<SurgicalChecklistEntry> CHECKLIST = new ArrayList<>();

    static {
        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-1", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #1",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-2", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #2",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-3", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #3",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-4", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #4",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-5", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #5",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-6", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #6",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-7", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #7",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-8", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #8",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-9", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #9",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-10", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #10",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-11", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #11",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-12", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #12",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-13", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #13",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-14", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #14",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-15", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #15",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-16", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #16",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-17", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #17",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-18", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #18",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-19", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #19",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("AnteriorCervicalDiscectomyFusionAcdf-CHECK-20", "AnteriorCervicalDiscectomyFusionAcdf Surgical Check #20",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

    }

    private static void addChecklistStep(String id, String desc, String pre, String op, String post) {
        CHECKLIST.add(SurgicalChecklistEntry.builder()
                .stepId(id)
                .stepDescription(desc)
                .preoperativeRequirements(pre)
                .operativeTechnique(op)
                .postopRecoveryProtocol(post)
                .build());
    }

    public List<SurgicalChecklistEntry> getAllSteps() {
        return Collections.unmodifiableList(CHECKLIST);
    }

    public Optional<SurgicalChecklistEntry> findById(String id) {
        if (id == null) return Optional.empty();
        return CHECKLIST.stream()
                .filter(s -> s.getStepId().equalsIgnoreCase(id.trim()))
                .findFirst();
    }

    public List<SurgicalChecklistEntry> search(String query) {
        if (query == null || query.isBlank()) return CHECKLIST;
        String q = query.toLowerCase().trim();
        return CHECKLIST.stream()
                .filter(s -> s.getStepId().toLowerCase().contains(q) ||
                             s.getStepDescription().toLowerCase().contains(q) ||
                             s.getOperativeTechnique().toLowerCase().contains(q) ||
                             s.getPostopRecoveryProtocol().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
