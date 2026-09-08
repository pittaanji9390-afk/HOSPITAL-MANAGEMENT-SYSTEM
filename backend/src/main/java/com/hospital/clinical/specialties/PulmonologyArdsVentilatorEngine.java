package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Acute Respiratory Distress Syndrome & Advanced Mechanical Ventilation.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class PulmonologyArdsVentilatorEngine {

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
                .icdCode("J80")
                .conditionName("Severe ARDS (Berlin Definition: PaO2/FiO2 <= 100 on PEEP >= 5)")
                .diagnosticCriteria("Bilateral non-cardiogenic alveolar opacities on CXR/CT within 7 days of clinical insult")
                .evidenceBasedTherapy("ARDSNet lung-protective protocol: 6 mL/kg PBW, Pplat <= 30 cmH2O, Driving pressure < 14 cmH2O, Prone positioning >= 16h/day, Cisatracurium")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J96.01")
                .conditionName("Acute Hypoxemic Respiratory Failure (Type 1)")
                .diagnosticCriteria("PaO2 < 60 mmHg on room air with normal or low PaCO2 (< 40 mmHg)")
                .evidenceBasedTherapy("High-Flow Nasal Cannula (HFNC: Flow 40-60 L/min, FiO2 0.6-1.0) or Non-Invasive Ventilation (NIV / CPAP 8-12 cmH2O)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J96.02")
                .conditionName("Acute Hypercapnic Respiratory Failure (Type 2)")
                .diagnosticCriteria("PaCO2 > 50 mmHg with arterial pH < 7.30 (Respiratory Acidosis)")
                .evidenceBasedTherapy("Non-Invasive Positive Pressure Ventilation (BiPAP: IPAP 12-16 cmH2O, EPAP 4-6 cmH2O) targeting tidal volume 6-8 mL/kg")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J93.0")
                .conditionName("Spontaneous Tension Pneumothorax")
                .diagnosticCriteria("Severe dyspnea, tracheal deviation away from affected side, hypotension, absent breath sounds")
                .evidenceBasedTherapy("Immediate needle decompression in 2nd intercostal space midclavicular line followed by 28-32 Fr tube thoracostomy")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("J90")
                .conditionName("Massive Pleural Effusion / Empyema")
                .diagnosticCriteria("Pleural fluid pH < 7.20, Glucose < 40 mg/dL, LDH > 1000 IU/L, or positive Gram stain")
                .evidenceBasedTherapy("Chest tube drainage (pigtail catheter 14 Fr) + Intrapleural tPA (10mg) and DNase (5mg) twice daily for 3 days or VATS decortication")
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
