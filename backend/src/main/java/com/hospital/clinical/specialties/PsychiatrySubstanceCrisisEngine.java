package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Addiction Medicine, Acute Withdrawal Protocols & Psychiatric Emergencies.
 * Production-grade medical protocols, diagnostic criteria, and evidence-based therapeutic regimens.
 */
@Component
public class PsychiatrySubstanceCrisisEngine {

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
                .protocolName("Severe Alcohol Withdrawal Delirium (Delirium Tremens / CIWA-Ar > 15)")
                .pharmacotherapyAndInterventions("Symptom-Triggered Benzodiazepine Protocol: IV Diazepam 10-20mg or IV Lorazepam 2-4mg q1-2h until CIWA-Ar < 10 + IV Thiamine 500mg tid (MANDATORY BEFORE GLUCOSE to prevent Wernicke encephalopathy)")
                .adverseReactionsAndToxicity("Grand mal withdrawal seizures, hyperadrenergic collapse, hyperthermia, aspiration, Wernicke-Korsakoff syndrome")
                .dosageAdjustmentAndSafetyRules("Add Phenobarbital 130-260mg IV or Dexmedetomidine infusion for refractory DTs in ICU")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Acute Opioid Withdrawal (COWS Score >= 13)")
                .pharmacotherapyAndInterventions("Buprenorphine-Naloxone (Suboxone) Induction: 2-4mg SL once COWS >= 12 (to avoid precipitated withdrawal) OR Clonidine 0.1-0.2mg PO q6h + Loperamide 4mg + Ondansetron 4mg")
                .adverseReactionsAndToxicity("Severe autonomic distress (mydriasis, piloerection, diarrhea, vomiting, severe muscle aches)")
                .dosageAdjustmentAndSafetyRules("DO NOT administer Buprenorphine too early (requires minimum 12-24h since short-acting opioid or 48-72h since Methadone)")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Serotonin Syndrome (Hunter Toxicity Criteria Met)")
                .pharmacotherapyAndInterventions("Immediate discontinuation of all serotonergic agents + IV Lorazepam 2-4mg for sedation and hypertonicity + Cyproheptadine 12mg PO load then 2mg q2h + Active external cooling")
                .adverseReactionsAndToxicity("Clonus (spontaneous, inducible, ocular), hyperthermia (> 38.5C), autonomic instability, rhabdomyolysis")
                .dosageAdjustmentAndSafetyRules("AVOID DANTROLENE AND BROMOCRIPTINE (indicated for NMS, not serotonin syndrome); paralyze and intubate for core temp > 40C")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Neuroleptic Malignant Syndrome (NMS from Antipsychotics)")
                .pharmacotherapyAndInterventions("Immediate cessation of all neuroleptic agents + IV Dantrolene 1-2.5 mg/kg IV bolus + Bromocriptine 2.5-5mg PO tid + IV Crystalloid hydration (target UO > 100 mL/hr)")
                .adverseReactionsAndToxicity("\"Lead-pipe\" muscle rigidity, hyperpyrexia (> 40C), elevated serum CK (> 10,000 U/L), autonomic instability, leukocytosis")
                .dosageAdjustmentAndSafetyRules("Restart antipsychotics (low-potency atypical like Quetiapine) with extreme caution only after minimum 2-week washout")
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
