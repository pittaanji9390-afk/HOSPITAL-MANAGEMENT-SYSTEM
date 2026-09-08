package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Acute Kidney Injury, Glomerulonephritis & Cardiorenal Syndromes.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class NephrologyAcuteKidneyInjuryEngine {

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
                .icdCode("N17.0")
                .conditionName("Acute Tubular Necrosis (Ischemic / Nephrotoxic ATN)")
                .diagnosticCriteria("KDIGO Stage 3 AKI: Serum Cr >= 3x baseline or Cr >= 4.0 mg/dL; FeNa > 2.0%, muddy brown casts")
                .evidenceBasedTherapy("Discontinue nephrotoxic agents (NSAIDs, Aminoglycosides, Vancomycin); Isotonic fluid optimization; Loop diuretic challenge only if volume overloaded")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N04.9")
                .conditionName("Nephrotic Syndrome (Membranous Nephropathy / FSGS)")
                .diagnosticCriteria("Proteinuria > 3.5 g/24h, Serum Albumin < 3.0 g/dL, generalized peripheral anasarca, hyperlipidemia")
                .evidenceBasedTherapy("Oral Prednisone 1 mg/kg/day (max 80mg) x 8-16 weeks + ACEi/ARB for antiproteinuric effect + Loop Diuretics + Statin therapy")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N00.9")
                .conditionName("Rapidly Progressive Glomerulonephritis (ANCA Vasculitis / Anti-GBM)")
                .diagnosticCriteria("Active urine sediment with dysmorphic RBCs and RBC casts; rapid doubling of serum creatinine within days")
                .evidenceBasedTherapy("Pulse IV Methylprednisolone 500-1000mg daily x 3 days followed by Cyclophosphamide or Rituximab 375 mg/m2 weekly x 4 + Therapeutic Plasma Exchange")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N17.8")
                .conditionName("Cardiorenal Syndrome Type 1 (Acute Cardiorenal)")
                .diagnosticCriteria("Acute worsening of renal function (Cr rise >= 0.3) in the setting of acute decompensated heart failure")
                .evidenceBasedTherapy("Intravenous Loop Diuretic continuous infusion (Furosemide 10-20 mg/hr) + Thiazide synergy (Metolazone 2.5-5mg PO) + Inotrope (Dobutamine 2.5-5 mcg/kg/min)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("N10")
                .conditionName("Acute Complicated Pyelonephritis with Sepsis")
                .diagnosticCriteria("Flank pain, CVA tenderness, fever > 38.5C, pyuria with WBC casts, bacteremia")
                .evidenceBasedTherapy("IV Piperacillin-Tazobactam 4.5g q6h or IV Meropenem 1g q8h; renal ultrasound to rule out obstructive hydronephrosis requiring emergency ureteral stenting")
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
