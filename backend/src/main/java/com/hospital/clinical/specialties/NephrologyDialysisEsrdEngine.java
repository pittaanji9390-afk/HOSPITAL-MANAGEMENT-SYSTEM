package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for End-Stage Renal Disease, Hemodialysis & Peritoneal Dialysis Management.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class NephrologyDialysisEsrdEngine {

    @Data
    @Builder
    public static class ClinicalMonograph {
        private String icdCode;
        private String conditionName;
        private String diagnosticCriteria;
        private String evidenceBasedTherapy;
    }

    private static final List<ClinicalMonograph> REGISTRY = new ArrayList<>();

    static {
        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N18.6")
                .conditionName("End-Stage Renal Disease on Maintenance Hemodialysis")
                .diagnosticCriteria("eGFR < 15 mL/min/1.73m2 with chronic uremic symptoms requiring renal replacement therapy")
                .evidenceBasedTherapy("High-flux intermittent hemodialysis thrice weekly (4 hours/session, target spKt/V >= 1.4); Phosphate binders (Sevelamer 800mg tid) + Erythropoietin (EPO 50-100 U/kg)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N18.61")
                .conditionName("Continuous Ambulatory Peritoneal Dialysis (CAPD) Peritonitis")
                .diagnosticCriteria("Cloudy peritoneal effluent with dialysate WBC > 100/uL (> 50% neutrophils); abdominal pain")
                .evidenceBasedTherapy("Intraperitoneal (IP) Vancomycin 15-30 mg/kg q5-7d + IP Ceftazidime 1000-1500mg daily in dialysate dwell bag for 14-21 days")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("E87.5")
                .conditionName("Severe Hyperkalemia in Renal Failure (K+ >= 6.8 mEq/L)")
                .diagnosticCriteria("Peaked T waves, PR prolongation, widened QRS, loss of P waves on ECG")
                .evidenceBasedTherapy("EMERGENCY PROTOCOL: (1) IV Calcium Gluconate 10% 10-20 mL over 3-5 min (membrane stabilization), (2) IV Regular Insulin 10U + 50mL D50W, (3) Inhaled Albuterol 10-20mg, (4) Sodium Bicarbonate, (5) Emergent HD")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("D63.1")
                .conditionName("Anemia of Chronic Kidney Disease")
                .diagnosticCriteria("Hemoglobin < 10.0 g/dL with Ferritin < 500 ng/mL and Transferrin Saturation (TSAT) < 30%")
                .evidenceBasedTherapy("IV Ferric Carboxymaltose 1000mg single dose + Erythropoiesis-Stimulating Agent (Darbepoetin Alfa 0.45 mcg/kg SC q2w) targeting Hb 10.0-11.5 g/dL")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N25.0")
                .conditionName("CKD-Mineral and Bone Disorder (Secondary Hyperparathyroidism)")
                .diagnosticCriteria("Intact PTH > 300-600 pg/mL, hyperphosphatemia (PO4 > 5.5 mg/dL), vascular calcifications")
                .evidenceBasedTherapy("Calcimimetic (Cinacalcet 30-60mg daily) + Active Vitamin D (Calcitriol 0.25-0.5 mcg daily) + Non-calcium phosphate binder (Lanthanum Carbonate)")
                .build());

    }

    public List<ClinicalMonograph> getAllMonographs() {
        return Collections.unmodifiableList(REGISTRY);
    }

    public Optional<ClinicalMonograph> findByCode(String icdCode) {
        if (icdCode == null) return Optional.empty();
        return REGISTRY.stream()
                .filter(m -> m.getIcdCode().equalsIgnoreCase(icdCode.trim()))
                .findFirst();
    }

    public List<ClinicalMonograph> searchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) return REGISTRY;
        String q = keyword.toLowerCase().trim();
        return REGISTRY.stream()
                .filter(m -> m.getIcdCode().toLowerCase().contains(q) ||
                             m.getConditionName().toLowerCase().contains(q) ||
                             m.getDiagnosticCriteria().toLowerCase().contains(q) ||
                             m.getEvidenceBasedTherapy().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
