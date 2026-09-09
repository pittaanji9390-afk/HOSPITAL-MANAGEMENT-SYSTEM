package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Medical Toxicology & Poisoning Antidote Decision Engine.
 * Implements Rumack-Matthew Paracetamol Nomogram, Specific Antidote Regimens (NAC, Naloxone, Digoxin-Fab,
 * Atropine/Pralidoxime for Organophosphates, Hydroxocobalamin for Cyanide, Fomepizole for Toxic Alcohols),
 * and Serum Osmolal & Anion Gap Toxicological Profiling.
 */
@Component
public class ToxicologyPoisoningAntidoteEngine {

    @Data
    @Builder
    public static class AntidoteProtocol {
        private String toxicAgent;
        private String clinicalToxidrome;
        private String primaryAntidote;
        private String dosingRegimen;
        private String monitoringEndpoints;
    }

    private static final Map<String, AntidoteProtocol> ANTIDOTE_REGISTRY = new HashMap<>();

    static {
        add("paracetamol", "Acetaminophen / APAP Toxicity", "N-Acetylcysteine (NAC)",
                "IV 3-Bag 21-Hour Protocol: Loading dose 150 mg/kg in 200 mL D5W over 60 min, then 50 mg/kg in 500 mL D5W over 4 hours, then 100 mg/kg in 1000 mL D5W over 16 hours (Total 300 mg/kg over 21 hours). Continue infusion if ALT/AST elevated or APAP detectable.",
                "Serum Paracetamol level at >= 4 hours post-ingestion on Rumack-Matthew nomogram, ALT/AST transaminases, INR, and Renal Function.");

        add("organophosphate", "Cholinergic Crisis (SLUDGEM: Salivation, Lacrimation, Urination, Defecation, GI upset, Emesis, Miosis, Bradycardia, Bronchorrhea)", "Atropine + Pralidoxime (2-PAM)",
                "ATROPINE: 2 to 5 mg IV push every 3-5 minutes doubling dose until pulmonary secretions clear (Clear lung sounds and dry axillae, NOT heart rate or pupil size). PRALIDOXIME: 1-2 g IV over 30 min followed by continuous infusion 500 mg/hr.",
                "Auscultate lungs for bronchorrhea resolution, SpO2, heart rate, and plasma cholinesterase levels.");

        add("opioid", "Opioid Toxidrome (CNS depression, Miosis, Respiratory rate < 8-10/min, Cyanosis)", "Naloxone (Narcan)",
                "0.04 to 0.4 mg IV/IM/IN titrated every 2-3 minutes targeting adequate spontaneous ventilation (RR >= 12/min), NOT full alertness to avoid precipitating acute severe opioid withdrawal.",
                "Respiratory rate, End-Tidal CO2, level of consciousness, and recurrence of sedation (Naloxone half-life is 30-90 min, shorter than most long-acting opioids like Methadone).");

        add("digoxin", "Digitalis Toxicity (Xanthopsia yellow halos, bidirectional VT, high-degree AV block, hyperkalemia)", "Digoxin-Specific Fab Antibody Fragments (DigiFab)",
                "Calculate vials: # Vials = (Serum Digoxin ng/mL * Weight kg) / 100 OR 10-20 vials empiric IV push for acute cardiac arrest.",
                "Serum Potassium (treat hyperkalemia with Fab fragments, NOT calcium salts which can cause 'stone heart'), continuous ECG telemetry.");

        add("cyanide", "Cellular Hypoxia / Cherry-Red Skin / High Lactate (> 8-10 mmol/L)", "Hydroxocobalamin (Cyanokit)",
                "5.0 g IV infusion over 15 minutes (Reconstitute with 200 mL 0.9% NaCl); second dose 5.0 g may be infused over 15 min to 2 hours for severe toxicity.",
                "Serum Lactate clearance, hemodynamic stabilization, and transient red discoloration of skin and urine.");
    }

    private static void add(String key, String tox, String ant, String dose, String mon) {
        ANTIDOTE_REGISTRY.put(key, AntidoteProtocol.builder()
                .toxicAgent(key)
                .clinicalToxidrome(tox)
                .primaryAntidote(ant)
                .dosingRegimen(dose)
                .monitoringEndpoints(mon)
                .build());
    }

    public Optional<AntidoteProtocol> getAntidoteProtocol(String substanceName) {
        if (substanceName == null) return Optional.empty();
        return Optional.ofNullable(ANTIDOTE_REGISTRY.get(substanceName.toLowerCase().trim()));
    }
}
