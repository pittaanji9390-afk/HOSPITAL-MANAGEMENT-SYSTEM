package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Vascular Surgery, Aortic Dissections & Critical Limb Ischemia.
 * Production-grade medical protocols, diagnostic criteria, and evidence-based therapeutic regimens.
 */
@Component
public class VascularSurgeryAorticLimbEngine {

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
                .protocolName("Acute Stanford Type A Aortic Dissection")
                .pharmacotherapyAndInterventions("EMERGENT SURGICAL REPAIR (Ascending Aorta / Hemiarch replacement with Dacron graft); IV Esmolol + Nicardipine target SBP 100-120 and HR < 60 bpm")
                .adverseReactionsAndToxicity("Fatal cardiac tamponade, aortic rupture, acute severe aortic regurgitation, coronary malperfusion")
                .dosageAdjustmentAndSafetyRules("Beta-blocker FIRST to lower dP/dt before vasodilators to avoid reflex tachycardia and dissection propagation")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Acute Stanford Type B Aortic Dissection (Uncomplicated)")
                .pharmacotherapyAndInterventions("Medical Anti-Impulse Therapy: IV Esmolol / Labetalol + Oral Clevidipine / Nicardipine; Thoracic Endovascular Aortic Repair (TEVAR) for complicated Type B")
                .adverseReactionsAndToxicity("Visceral and lower extremity malperfusion, retrograde Type A extension, chronic aneurysmal expansion")
                .dosageAdjustmentAndSafetyRules("Strict blood pressure control (target SBP < 120 mmHg long term); serial CT Angiography surveillance at 1, 6, 12 months")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Acute Lower Limb Ischemia (Rutherford Class IIa / IIb)")
                .pharmacotherapyAndInterventions("Immediate IV Unfractionated Heparin (80 U/kg bolus + 18 U/kg/hr infusion); Emergent Fogarty Catheter Balloon Embolectomy or Catheter-Directed Thrombolysis (CDT: Alteplase 0.5-1.0 mg/hr)")
                .adverseReactionsAndToxicity("Reperfusion compartment syndrome (mandatory fasciotomy if ischemic time > 4-6 hours), rhabdomyolysis, hyperkalemia")
                .dosageAdjustmentAndSafetyRules("Monitor aPTT every 6 hours (target 60-85 seconds); initiate prophylactic four-compartment fasciotomy if limb tense")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Ruptured Abdominal Aortic Aneurysm (AAA)")
                .pharmacotherapyAndInterventions("EMERGENT DAMAGE-CONTROL RESUSCITATION: Permissive hypotension (target SBP 80-90 mmHg); Immediate Endovascular Aneurysm Repair (EVAR) or Open Aortic Clamping & Grafting")
                .adverseReactionsAndToxicity("Exsanguinating retroperitoneal hemorrhage, abdominal compartment syndrome, ischemic colitis")
                .dosageAdjustmentAndSafetyRules("Avoid aggressive crystalloid resuscitation which dislodges retroperitoneal containment hematoma")
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
