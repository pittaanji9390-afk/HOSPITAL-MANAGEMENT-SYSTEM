package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Status Epilepticus, Refractory Seizures & Epilepsy Management.
 * Production-grade medical knowledge models, diagnostic criteria, and evidence-based clinical protocols.
 */
@Component
public class NeurologyEpilepsySeizureEngine {

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
                .icdCode("G41.0")
                .conditionName("Convulsive Status Epilepticus (Phase 1: 5-20 minutes)")
                .diagnosticCriteria("Continuous generalized tonic-clonic motor seizure activity lasting >= 5 minutes or recurrent seizures without full recovery")
                .evidenceBasedTherapy("FIRST-LINE BENZODIAZEPINE: IV Lorazepam 4 mg (0.1 mg/kg) over 2 min (repeat once at 5 min) OR IM Midazolam 10 mg (> 40 kg) OR IV Diazepam 10 mg")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("G41.9")
                .conditionName("Established Status Epilepticus (Phase 2: 20-40 minutes)")
                .diagnosticCriteria("Persistent seizure activity despite adequate first-line benzodiazepine administration")
                .evidenceBasedTherapy("SECOND-LINE NON-SEDATING AED (ESETT Trial): IV Levetiracetam 60 mg/kg (max 4500mg) over 10 min OR IV Fosphenytoin 20 mg PE/kg (max 1500mg) OR IV Valproate Sodium 40 mg/kg (max 3000mg)")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("G41.8")
                .conditionName("Refractory Status Epilepticus (Phase 3: > 40 minutes)")
                .diagnosticCriteria("Seizure activity persisting despite benzodiazepine and second-line antiepileptic drug")
                .evidenceBasedTherapy("THIRD-LINE GENERAL ANESTHETIC COMA: Continuous IV Midazolam (0.2 mg/kg load + 0.05-2 mg/kg/hr) OR Propofol (2 mg/kg load + 2-10 mg/kg/hr) OR Ketamine with continuous video-EEG burst suppression")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("G40.301")
                .conditionName("Generalized Tonic-Clonic Epilepsy (Drug-Resistant)")
                .diagnosticCriteria(">= 2 unprovoked seizures failing >= 2 tolerated and appropriately chosen antiepileptic regimens")
                .evidenceBasedTherapy("Levetiracetam 1000-1500mg bid + Lamotrigine 100-200mg bid (slow titration to avoid SJS) OR Vagus Nerve Stimulation (VNS) / Resective Epilepsy Surgery")
                .build());

        REGISTRY.add(ClinicalMonograph.builder()
                .icdCode("G70.01")
                .conditionName("Myasthenia Gravis with Acute Myasthenic Crisis")
                .diagnosticCriteria("Severe bulbar and diaphragmatic respiratory muscle weakness (Negative Inspiratory Force NIF < -20 cmH2O, FVC < 15 mL/kg)")
                .evidenceBasedTherapy("Therapeutic Plasma Exchange (5-6 exchanges on alternate days) OR IV Immunoglobulin (IVIG 2 g/kg over 5 days) + IV Methylprednisolone 60mg/day (HOLD Pyridostigmine during mechanical ventilation)")
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
