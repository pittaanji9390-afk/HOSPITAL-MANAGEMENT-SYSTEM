package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Heart Failure with Reduced/Preserved Ejection Fraction & Valvular Disorders.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class CardiologyHeartFailureValveEngine {

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
                .icdCode("I50.21")
                .conditionName("Acute Decompensated HFrEF (LVEF <= 40%)")
                .diagnosticCriteria("Bilateral pulmonary rales, S3 gallop, elevated NT-proBNP (> 1000 pg/mL)")
                .evidenceBasedTherapy("Four Pillars GDMT: (1) ARNI Sacubitril/Valsartan 24/26mg bid, (2) SGLT2i Empagliflozin 10mg, (3) Beta-Blocker Carvedilol, (4) MRA Spironolactone")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I50.32")
                .conditionName("Chronic Diastolic Heart Failure (HFpEF, LVEF >= 50%)")
                .diagnosticCriteria("E/e ratio > 14, Left Atrial Volume Index > 34 mL/m2, elevated BNP")
                .evidenceBasedTherapy("SGLT2 inhibitors (Empagliflozin 10mg / Dapagliflozin 10mg) + Loop Diuretic (Torsemide 10-20mg) for congestion")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I35.0")
                .conditionName("Severe Calcific Aortic Stenosis")
                .diagnosticCriteria("Aortic Valve Area <= 1.0 cm2, Mean gradient >= 40 mmHg, Peak velocity >= 4.0 m/s")
                .evidenceBasedTherapy("Transcatheter Aortic Valve Implantation (TAVI / TAVR) or Surgical Aortic Valve Replacement (SAVR)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I34.0")
                .conditionName("Severe Mitral Regurgitation (Primary / Degenerative)")
                .diagnosticCriteria("Regurgitant Volume >= 60 mL/beat, Effective Regurgitant Orifice Area >= 0.40 cm2")
                .evidenceBasedTherapy("Mitral valve repair / replacement or Transcatheter Edge-to-Edge Repair (TEER / MitraClip)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("I42.0")
                .conditionName("Dilated Cardiomyopathy (Non-Ischemic)")
                .diagnosticCriteria("LV end-diastolic dimension > 55mm with global hypokinesis and LVEF < 35%")
                .evidenceBasedTherapy("Implantable Cardioverter-Defibrillator (ICD) for primary prevention of sudden death + Cardiac Resynchronization Therapy (CRT-D)")
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
