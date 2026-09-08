package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Hyperacute Ischemic Stroke Reperfusion, Thrombolysis & Neuroprotection.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class NeurologyAcuteStrokeTnkEngine {

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
                .icdCode("I63.50")
                .conditionName("Acute Ischemic Stroke within 4.5-Hour Thrombolysis Window")
                .diagnosticCriteria("Disabling acute focal neurologic deficit, non-contrast CT head negative for intracranial hemorrhage, NIHSS >= 5")
                .evidenceBasedTherapy("IV Tenecteplase 0.25 mg/kg (max 25mg) single IV bolus OR IV Alteplase 0.9 mg/kg (max 90mg: 10% bolus, 90% over 60 min); Target BP < 180/105 mmHg with Labetalol/Nicardipine")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I63.1")
                .conditionName("Acute Ischemic Stroke with Large Vessel Occlusion (LVO: MCA M1 / ICA)")
                .diagnosticCriteria("NIHSS >= 6, CTA/MRA confirming proximal large vessel occlusion within 0-24 hours from Last Known Well")
                .evidenceBasedTherapy("EMERGENT ENDOVASCULAR THROMBECTOMY (EVT): Stent retriever / direct aspiration catheter targeting TICI 2b/3 revascularization (DAWN / DEFUSE-3 criteria)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("G45.9")
                .conditionName("High-Risk Transient Ischemic Attack (ABCD2 Score >= 4)")
                .diagnosticCriteria("Age >= 60, BP >= 140/90, Unilateral weakness, Speech disturbance, Duration > 60 min, Diabetes")
                .evidenceBasedTherapy("DUAL ANTIPLATELET THERAPY (DAPT): Aspirin 300mg load then 100mg daily + Clopidogrel 300mg load then 75mg daily for EXACTLY 21 DAYS (CHANCE/POINT trials) + Atorvastatin 80mg")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I61.9")
                .conditionName("Acute Spontaneous Intracerebral Hemorrhage (Basal Ganglia / Thalamic)")
                .diagnosticCriteria("Sudden headache, hemiplegia, non-contrast CT showing hyperdense intraparenchymal hematoma")
                .evidenceBasedTherapy("Rapid blood pressure reduction: SBP 130-140 mmHg within 1 hour with IV Nicardipine; Immediate reversal of coagulopathy (4F-PCC 25-50 U/kg + Vitamin K 10mg IV for Warfarin)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("G93.6")
                .conditionName("Malignant Middle Cerebral Artery (MCA) Infarction with Brain Herniation")
                .diagnosticCriteria("Ischemic infarction involving > 50% MCA territory, midline shift > 5mm, declining GCS, uncal herniation")
                .evidenceBasedTherapy("EMERGENCY DECOMPRESSIVE HEMICRANIECTOMY within 24-48 hours (reduces mortality from 80% to 20%) + 3% Hypertonic Saline 250 mL bolus (Target serum Na 145-155 mEq/L)")
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
