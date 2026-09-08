package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ToxicologyAntidoteReversalHandbook {

    @Data
    @AllArgsConstructor
    public static class AntidoteProtocol {
        private String toxinOrOverdoseAgent;
        private String specificAntidote;
        private String standardInitialDose;
        private String administrationRoute;
        private String monitoringEndpoint;
    }

    private final Map<String, AntidoteProtocol> antidotes = new LinkedHashMap<>();

    public ToxicologyAntidoteReversalHandbook() {
        antidotes.put("Opioids", new AntidoteProtocol("Opioid Toxicity / Respiratory Depression", "Naloxone (Narcan)", "0.4 - 2.0 mg IV/IM/IN (titrated)", "IV / IM / Intranasal", "Adequate spontaneous respiratory rate (>= 12 bpm)"));
        antidotes.put("Benzodiazepines", new AntidoteProtocol("Benzodiazepine Overdose", "Flumazenil (Romazicon)", "0.2 mg IV over 30 sec, then 0.3 mg at 1 min", "IV Push", "Caution: May precipitate refractory seizures in chronic users"));
        antidotes.put("Acetaminophen", new AntidoteProtocol("Acetaminophen Toxicity", "N-Acetylcysteine (NAC)", "150 mg/kg IV loading dose over 60 min", "IV 3-bag protocol (or 21-dose oral)", "Normal ALT/AST and undetectable acetaminophen level"));
        antidotes.put("Warfarin", new AntidoteProtocol("Warfarin Major Bleeding", "4-Factor Prothrombin Complex (4F-PCC) + Vitamin K", "25 - 50 Units/kg IV + 10mg IV Vitamin K", "IV Infusion", "Rapid normalization of INR (< 1.5)"));
    }

    public Optional<AntidoteProtocol> getAntidote(String toxin) { return Optional.ofNullable(antidotes.get(toxin)); }
}
