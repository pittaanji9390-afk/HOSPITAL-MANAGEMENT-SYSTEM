package com.hospital.clinical.procedures;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Surgical & Operative Procedure Safety Protocol for TotalHipArthroplastyImplants.
 * Implements perioperative surgical checklists, equipment sterile verification, and PACU discharge criteria.
 */
@Component
public class TotalHipArthroplastyImplantsEngine {

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
        addChecklistStep("TotalHipArthroplastyImplants-CHECK-1", "TotalHipArthroplastyImplants Surgical Check #1",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-2", "TotalHipArthroplastyImplants Surgical Check #2",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-3", "TotalHipArthroplastyImplants Surgical Check #3",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-4", "TotalHipArthroplastyImplants Surgical Check #4",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-5", "TotalHipArthroplastyImplants Surgical Check #5",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-6", "TotalHipArthroplastyImplants Surgical Check #6",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-7", "TotalHipArthroplastyImplants Surgical Check #7",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-8", "TotalHipArthroplastyImplants Surgical Check #8",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-9", "TotalHipArthroplastyImplants Surgical Check #9",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-10", "TotalHipArthroplastyImplants Surgical Check #10",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-11", "TotalHipArthroplastyImplants Surgical Check #11",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-12", "TotalHipArthroplastyImplants Surgical Check #12",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-13", "TotalHipArthroplastyImplants Surgical Check #13",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-14", "TotalHipArthroplastyImplants Surgical Check #14",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-15", "TotalHipArthroplastyImplants Surgical Check #15",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-16", "TotalHipArthroplastyImplants Surgical Check #16",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-17", "TotalHipArthroplastyImplants Surgical Check #17",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-18", "TotalHipArthroplastyImplants Surgical Check #18",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-19", "TotalHipArthroplastyImplants Surgical Check #19",
            "Preoperative Assessment & Anesthesia Clearance: Mandatory airway verification, ASA physical status confirmation, baseline complete metabolic panel, and type-and-screen crossmatch verification.",
            "Operative Technique & Surgical Instrumentation: Aseptic skin prep with 2% chlorhexidine in 70% isopropyl alcohol, standardized anatomical dissection, precise hemostatic control using bipolar electrocautery, and systematic count reconciliation.",
            "Postoperative PACU Protocol & Complication Surveillance: Serial vital sign monitoring every 15 minutes, visual analog scale pain titration, surgical drain output measurement, and deep vein thrombosis prophylaxis.");

        addChecklistStep("TotalHipArthroplastyImplants-CHECK-20", "TotalHipArthroplastyImplants Surgical Check #20",
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
