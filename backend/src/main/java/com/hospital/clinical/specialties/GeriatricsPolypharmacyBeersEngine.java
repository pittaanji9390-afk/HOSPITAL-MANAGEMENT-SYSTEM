package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Geriatric Medicine, Polypharmacy De-prescribing & Frailty Care.
 * Production-grade medical protocols, diagnostic criteria, and evidence-based therapeutic regimens.
 */
@Component
public class GeriatricsPolypharmacyBeersEngine {

    @Data
    @Builder
    public static class ClinicalProtocol {
        private String protocolName;
        private String pharmacotherapyAndInterventions;
        private String adverseReactionsAndToxicity;
        private String dosageAdjustmentAndSafetyRules;
    }

    private static final List<ClinicalProtocol> PROTOCOLS = new ArrayList<>();

    static {
        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("2023 AGS Beers Criteria: Anticholinergic Avoidance")
                .pharmacotherapyAndInterventions("Avoid Diphenhydramine, Hydroxyzine, Amitriptyline, Paroxetine, Oxybutynin in patients >= 65 years")
                .adverseReactionsAndToxicity("Acute delirium, urinary retention, severe constipation, falls with hip fractures, cognitive decline")
                .dosageAdjustmentAndSafetyRules("Switch to non-anticholinergic alternatives: Melatonin for insomnia, Cetirizine/Fexofenadine for allergies, Mirabegron for overactive bladder")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Geriatric Delirium Prevention & Management (CAM Positive)")
                .pharmacotherapyAndInterventions("NON-PHARMACOLOGICAL BUNDLE FIRST: Reorientation, sleep protocol, early mobilization, hydration, sensory aids (glasses/hearing aids); Haloperidol 0.25-0.5mg PO/IV ONLY for severe agitation posing safety risk")
                .adverseReactionsAndToxicity("Antipsychotic extrapyramidal symptoms, QTc prolongation, stroke and mortality risk in dementia")
                .dosageAdjustmentAndSafetyRules("AVOID BENZODIAZEPINES IN DELIRIUM (worsens paradoxical agitation and delirium duration except in alcohol/sedative withdrawal)")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Clinical Frailty Scale & Comprehensive Geriatric Assessment")
                .pharmacotherapyAndInterventions("Nutritional supplementation (High protein 1.2-1.5 g/kg/day + Vitamin D3 1000-2000 IU) + Supervised Resistance Exercise Physiotherapy")
                .adverseReactionsAndToxicity("Sarcopenia, progressive mobility loss, pressure injury risk, loss of functional independence")
                .dosageAdjustmentAndSafetyRules("De-prescribe tight glycemic targets (relax HbA1c to 7.5-8.0% in frail elderly) and de-intensify antihypertensives (SBP target 130-139 mmHg)")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Palliative Symptom Management in Advanced Terminal Disease")
                .pharmacotherapyAndInterventions("Morphine 5-10mg PO / 2.5-5mg SC q4h prn for pain/dyspnea + Glycopyrrolate 0.2mg SC q4h for respiratory death rattle + Haloperidol 1-2mg for terminal restlessness")
                .adverseReactionsAndToxicity("Constipation (co-prescribe stimulant laxative Senna + Docusate with all opioids); sedation")
                .dosageAdjustmentAndSafetyRules("Sublingual and subcutaneous routes preferred when oral route lost in active dying phase")
                .build());

    }

    public List<ClinicalProtocol> getAllProtocols() {
        return Collections.unmodifiableList(PROTOCOLS);
    }

    public Optional<ClinicalProtocol> findByName(String name) {
        if (name == null) return Optional.empty();
        return PROTOCOLS.stream()
                .filter(p -> p.getProtocolName().toLowerCase().contains(name.toLowerCase().trim()))
                .findFirst();
    }

    public List<ClinicalProtocol> search(String query) {
        if (query == null || query.isBlank()) return PROTOCOLS;
        String q = query.toLowerCase().trim();
        return PROTOCOLS.stream()
                .filter(p -> p.getProtocolName().toLowerCase().contains(q) ||
                             p.getPharmacotherapyAndInterventions().toLowerCase().contains(q) ||
                             p.getAdverseReactionsAndToxicity().toLowerCase().contains(q) ||
                             p.getDosageAdjustmentAndSafetyRules().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
