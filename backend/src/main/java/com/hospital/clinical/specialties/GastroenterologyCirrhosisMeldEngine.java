package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Decompensated Hepatic Cirrhosis, Portal Hypertension & Variceal Bleeding.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class GastroenterologyCirrhosisMeldEngine {

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
                .icdCode("K70.31")
                .conditionName("Decompensated Cirrhosis with Acute Esophageal Variceal Hemorrhage")
                .diagnosticCriteria("Hematemesis, melena, hemodynamic shock, active bleeding varices identified on endoscopy")
                .evidenceBasedTherapy("EMERGENT VARICEAL BUNDLE: (1) Octreotide 50 mcg IV bolus then 50 mcg/hr infusion x 5 days, (2) Endoscopic Variceal Ligation (EVL banding), (3) Prophylactic IV Ceftriaxone 1g/day x 7 days, (4) Restrictive transfusion (target Hb 7-8 g/dL)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K72.90")
                .conditionName("Hepatic Encephalopathy (West Haven Grade III-IV Coma)")
                .diagnosticCriteria("Confusion, somnolence, asterixis flapping tremor, elevated arterial ammonia (> 100 umol/L)")
                .evidenceBasedTherapy("Lactulose 30 mL orally / via NG tube q1-2h until 2-3 soft bowel movements/day + Rifaximin 550 mg PO bid + Correct hypokalemia and precipitating infections")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K76.7")
                .conditionName("Hepatorenal Syndrome (HRS-AKI Type 1)")
                .diagnosticCriteria("Doubling of serum creatinine > 2.5 mg/dL in < 2 weeks without proteinuria, hematuria, or response to albumin volume expansion")
                .evidenceBasedTherapy("Terlipressin (1-2 mg IV q4-6h) OR Norepinephrine (0.5-3.0 mg/hr titrating MAP +10 mmHg) + 20% Albumin (1 g/kg Day 1, then 20-40 g/day); Liver transplantation evaluation")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K65.0")
                .conditionName("Spontaneous Bacterial Peritonitis (SBP)")
                .diagnosticCriteria("Ascitic fluid absolute neutrophil count (ANC) >= 250 cells/uL (0.25 x 10^9/L)")
                .evidenceBasedTherapy("IV Cefotaxime 2g q8h or IV Ceftriaxone 2g q24h x 5 days + IV Albumin 1.5 g/kg on Day 1 and 1.0 g/kg on Day 3 to prevent hepatorenal syndrome")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("K76.0")
                .conditionName("Metabolic Dysfunction-Associated Steatohepatitis (MASH / NASH F3-F4)")
                .diagnosticCriteria("Hepatic steatosis on FibroScan (CAP > 280 dB/m) with advanced fibrosis (LSM > 12 kPa)")
                .evidenceBasedTherapy("Resmetirom 80-100mg daily (Thyroid hormone receptor beta agonist) + GLP-1 receptor agonist (Semaglutide 2.4mg weekly) + Vitamin E 800 IU daily")
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
