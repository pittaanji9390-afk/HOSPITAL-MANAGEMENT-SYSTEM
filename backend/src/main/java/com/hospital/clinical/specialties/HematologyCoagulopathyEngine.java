package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Hematology, Bleeding Disorders & Thrombotic Microangiopathies.
 * Production-grade medical protocols, diagnostic criteria, and evidence-based therapeutic regimens.
 */
@Component
public class HematologyCoagulopathyEngine {

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
                .protocolName("Disseminated Intravascular Coagulation (Overt ISTH DIC Score >= 5)")
                .pharmacotherapyAndInterventions("Treat underlying trigger (Sepsis / Abruptio placentae / Trauma) + Platelet transfusion for < 50k with bleeding + FFP 15 mL/kg for INR > 1.5 + Cryoprecipitate for Fibrinogen < 150 mg/dL")
                .adverseReactionsAndToxicity("Widespread microvascular thrombosis causing multi-organ failure alongside consumptive hemorrhage")
                .dosageAdjustmentAndSafetyRules("Avoid routine heparin in bleeding DIC; consider therapeutic Unfractionated Heparin (low dose 5-10 U/kg/hr) only in thrombosis-predominant DIC (e.g. solid tumor / purpura fulminans)")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Heparin-Induced Thrombocytopenia (HIT - 4Ts Score >= 6)")
                .pharmacotherapyAndInterventions("IMMEDIATELY CESSATE ALL HEPARIN (including flushes); Initiate Non-Heparin Anticoagulant: Argatroban (0.5-2.0 mcg/kg/min IV, target aPTT 1.5-3x) OR Bivalirudin OR Fondaparinux")
                .adverseReactionsAndToxicity("Catastrophic venous and arterial thrombosis (HITT: white clot syndrome, DVT, limb gangrene, stroke)")
                .dosageAdjustmentAndSafetyRules("DO NOT TRANSFUSE PLATELETS (fuels thrombosis); DO NOT START WARFARIN until platelets recover >= 150k (prevents warfarin-induced skin necrosis)")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Thrombotic Thrombocytopenic Purpura (TTP - PLASMIC Score 6-7)")
                .pharmacotherapyAndInterventions("EMERGENT THERAPEUTIC PLASMA EXCHANGE (TPE / Plasmapheresis with 1.0-1.5 plasma volume daily) + High-Dose Methylprednisolone 1g IV daily x 3d + Caplacizumab 10mg + Rituximab 375 mg/m2")
                .adverseReactionsAndToxicity("Microangiopathic hemolytic anemia (schistocytes on blood smear), profound thrombocytopenia, renal failure, fluctuating neurological deficits")
                .dosageAdjustmentAndSafetyRules("TPE supplies ADAMTS13 and removes autoantibodies; DO NOT DELAY TPE for ADAMTS13 test results (mortality > 90% without TPE)")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Immune Thrombocytopenia (ITP with Severe Bleeding / Platelets < 20k)")
                .pharmacotherapyAndInterventions("IV Immunoglobulin (IVIG 1 g/kg/day x 2 days) + IV Dexamethasone 40mg daily x 4 days; Second-line: TPO Receptor Agonists (Eltrombopag 50mg / Romiplostim 1-10 mcg/kg weekly)")
                .adverseReactionsAndToxicity("Mucocutaneous bleeding, intracranial hemorrhage (risk < 1% but fatal)")
                .dosageAdjustmentAndSafetyRules("Platelet transfusion reserved strictly for life-threatening intracranial or internal hemorrhage (rapidly destroyed by circulating autoantibodies)")
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
