package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Obstructive Lung Diseases, Asthma Exacerbations & Bronchiectasis.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class PulmonologyCopdAsthmaEngine {

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
                .icdCode("J44.1")
                .conditionName("COPD with Acute Exacerbation (Anthonisen Type I)")
                .diagnosticCriteria("Increased dyspnea, increased sputum volume, and increased sputum purulence")
                .evidenceBasedTherapy("Oral Prednisone 40mg daily x 5 days + Inhaled SABA/SAMA (Albuterol/Ipratropium) + Antibiotic (Azithromycin 500mg or Augmentin 875mg x 5 days)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J45.52")
                .conditionName("Severe Persistent Asthma with Status Asthmaticus")
                .diagnosticCriteria("Severe bronchospasm, silent chest, pulsus paradoxus > 12 mmHg, PEF < 50% predicted")
                .evidenceBasedTherapy("Continuous nebulized Albuterol (10-15 mg/hr) + IV Magnesium Sulfate 2g over 20 min + IV Methylprednisolone 60-125mg q6h + Inhaled Ipratropium")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J47.0")
                .conditionName("Infected Bronchiectasis with Pseudomonas Aeruginosa")
                .diagnosticCriteria("Chronic mucopurulent productive cough with high-resolution CT signet-ring sign")
                .evidenceBasedTherapy("Inhaled Tobramycin 300mg bid (28 days on / 28 days off) + Oral Ciprofloxacin 750mg bid or IV Cefepime 2g q8h + Airway clearance physiotherapy")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J84.112")
                .conditionName("Idiopathic Pulmonary Fibrosis (IPF)")
                .diagnosticCriteria("Usual Interstitial Pneumonia (UIP) pattern on HRCT: subpleural basilar reticulation and honeycombing")
                .evidenceBasedTherapy("Antifibrotic therapy: Nintedanib 150mg bid (Tyrosine kinase inhibitor) or Pirfenidone 801mg tid; early lung transplant evaluation")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J18.9")
                .conditionName("Severe Community-Acquired Pneumonia (CURB-65 = 4)")
                .diagnosticCriteria("Confusion, Urea > 7 mmol/L, RR >= 30, SBP < 90 / DBP <= 60, Age >= 65")
                .evidenceBasedTherapy("IV Ceftriaxone 2g daily + IV Azithromycin 500mg daily OR IV Levofloxacin 750mg daily; ICU admission")
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
