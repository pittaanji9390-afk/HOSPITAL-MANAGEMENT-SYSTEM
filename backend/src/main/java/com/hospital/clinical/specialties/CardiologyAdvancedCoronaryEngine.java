package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Advanced Coronary Artery Disease & Acute Coronary Syndromes.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class CardiologyAdvancedCoronaryEngine {

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
                .icdCode("I21.0")
                .conditionName("Acute Transmural Anterior STEMI")
                .diagnosticCriteria(">= 1mm ST-elevation in >= 2 contiguous precordial leads (V1-V4)")
                .evidenceBasedTherapy("Immediate Primary PCI with Drug-Eluting Stent within 90 min Door-to-Balloon time; DAPT: Aspirin 300mg + Ticagrelor 180mg")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I21.1")
                .conditionName("Acute Inferior Wall STEMI with RV Infarction")
                .diagnosticCriteria("ST-elevation in II, III, aVF with >= 1mm STE in V4R; avoidance of nitrates")
                .evidenceBasedTherapy("Aggressive IV Normal Saline volume loading to maintain RV preload; Primary PCI to culprit Right Coronary Artery (RCA)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I21.4")
                .conditionName("Non-ST-Elevation Myocardial Infarction (NSTEMI)")
                .diagnosticCriteria("Elevated hs-cTnI (> 0.04 ng/mL) with ischemic symptoms; GRACE risk score > 140")
                .evidenceBasedTherapy("Early invasive coronary angiography within 24 hours; Fondaparinux 2.5mg SC daily + Clopidogrel/Ticagrelor + Atorvastatin 80mg")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I20.0")
                .conditionName("Unstable Angina Pectoris (Braunwald Class III)")
                .diagnosticCriteria("Accelerating crescendo angina occurring at rest without biomarker rise")
                .evidenceBasedTherapy("Dual Antiplatelet Therapy + High-intensity Statin + Beta-blocker (Metoprolol 25-50mg bid); Sublingual Nitroglycerin 0.4mg q5m")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I25.10")
                .conditionName("Chronic Stable Coronary Atherosclerosis")
                .diagnosticCriteria("Exertional angina with Canadian Cardiovascular Society (CCS) Class II-III")
                .evidenceBasedTherapy("Anti-anginal optimization: Bisoprolol 5-10mg daily + Ranolazine 500mg bid + Aspirin 75-100mg + Rosuvastatin 20-40mg")
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
