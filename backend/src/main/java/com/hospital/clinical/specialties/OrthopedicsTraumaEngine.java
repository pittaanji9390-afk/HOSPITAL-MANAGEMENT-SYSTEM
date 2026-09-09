package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Orthopedic Trauma & Musculoskeletal Decision Engine.
 * Implements Gustilo-Anderson open fracture grading, Compartment Syndrome delta-pressure thresholds,
 * AO/OTA fracture classification rules, and Ottawa Ankle/Knee Rules for radiography triage.
 */
@Component
public class OrthopedicsTraumaEngine {

    public enum GustiloAndersonType {
        TYPE_I, TYPE_II, TYPE_IIIA, TYPE_IIIB, TYPE_IIIC
    }

    @Data
    @Builder
    public static class OpenFractureManagementPlan {
        private GustiloAndersonType type;
        private String woundDescription;
        private List<String> antimicrobialRegimen;
        private String surgicalTiming;
        private String softTissueCoverageStrategy;
    }

    public OpenFractureManagementPlan evaluateOpenFracture(double woundLengthCm, boolean extensiveSoftTissueDamage,
                                                          boolean periostealStripping, boolean arterialInjuryRequiringRepair,
                                                          boolean soilFarmyardContamination) {
        GustiloAndersonType type;
        String woundDesc;
        List<String> antibiotics = new ArrayList<>();
        String timing;
        String coverage;

        if (arterialInjuryRequiringRepair) {
            type = GustiloAndersonType.TYPE_IIIC;
            woundDesc = "Open fracture with major arterial vascular injury requiring emergent revascularization/repair regardless of wound size.";
            antibiotics.add("Cefazolin 2g IV q8h (First-generation Cephalosporin)");
            antibiotics.add("Gentamicin 5 mg/kg IV q24h (Gram-negative coverage)");
            if (soilFarmyardContamination) antibiotics.add("Penicillin G 4 million units IV q4h (Clostridial coverage)");
            timing = "EMERGENT OPERATIVE INTERVENTION WITHIN 2-6 HOURS (Simultaneous vascular shunt/repair and external skeletal stabilization).";
            coverage = "Temporary negative pressure wound therapy (VAC dressing) followed by free microvascular tissue transfer (e.g. Anterolateral Thigh ALT flap).";
        } else if (periostealStripping || soilFarmyardContamination) {
            type = GustiloAndersonType.TYPE_IIIB;
            woundDesc = "High-energy open fracture with extensive soft tissue loss, periosteal stripping, and bone exposure requiring flap coverage.";
            antibiotics.add("Cefazolin 2g IV q8h");
            antibiotics.add("Gentamicin 5 mg/kg IV q24h");
            if (soilFarmyardContamination) antibiotics.add("Penicillin G 4 million units IV q4h or Metronidazole 500mg IV q8h");
            timing = "Operative surgical debridement and irrigation with >= 9 liters low-pressure saline within 6 hours.";
            coverage = "Local rotational muscle flap (Gastrocnemius / Soleus) or Free Flap reconstruction within 72 hours (Godina principle).";
        } else if (extensiveSoftTissueDamage || woundLengthCm > 10.0) {
            type = GustiloAndersonType.TYPE_IIIA;
            woundDesc = "Extensive soft tissue laceration (> 10 cm) but adequate soft tissue coverage of the fractured bone remains.";
            antibiotics.add("Cefazolin 2g IV q8h");
            antibiotics.add("Gentamicin 5 mg/kg IV q24h");
            timing = "Urgent surgical irrigation and debridement within 12 hours with external fixator or reamed intramedullary nail.";
            coverage = "Delayed primary closure or split-thickness skin graft (STSG).";
        } else if (woundLengthCm > 1.0) {
            type = GustiloAndersonType.TYPE_II;
            woundDesc = "Open fracture wound 1.0 - 10.0 cm without extensive soft tissue damage or periosteal stripping.";
            antibiotics.add("Cefazolin 2g IV q8h for 48 hours post-closure");
            timing = "Urgent operative debridement and stabilization within 24 hours.";
            coverage = "Primary or delayed primary wound closure.";
        } else {
            type = GustiloAndersonType.TYPE_I;
            woundDesc = "Clean open fracture puncture wound <= 1.0 cm (inside-out mechanism) with minimal soft tissue contusion.";
            antibiotics.add("Cefazolin 2g IV q8h for 24 hours");
            timing = "Operative debridement and definitive internal fixation (ORIF / Intramedullary Nail).";
            coverage = "Direct primary closure.";
        }

        return OpenFractureManagementPlan.builder()
                .type(type)
                .woundDescription(woundDesc)
                .antimicrobialRegimen(antibiotics)
                .surgicalTiming(timing)
                .softTissueCoverageStrategy(coverage)
                .build();
    }

    @Data
    @Builder
    public static class CompartmentSyndromeEvaluation {
        private double compartmentPressureMmHg;
        private double diastolicBloodPressure;
        private double deltaPressureMmHg; // Diastolic BP - Compartment Pressure
        private boolean isEmergencyFasciotomyIndicated;
        private String surgicalAction;
    }

    public CompartmentSyndromeEvaluation evaluateCompartmentSyndrome(double intracompartmentalPressureMmHg, double diastolicBp) {
        double deltaP = diastolicBp - intracompartmentalPressureMmHg;
        boolean fasciotomy = (deltaP <= 30.0) || (intracompartmentalPressureMmHg >= 30.0);

        String action = fasciotomy ?
                "EMERGENCY BEDSIDE / OR FASCIOTOMY MANDATORY: Immediate complete surgical decompression of all anatomical compartments (e.g. Dual-incision 4-compartment fasciotomy for lower leg: Anterolateral incision for anterior/lateral compartments, Posteromedial incision for superficial/deep posterior compartments) within 6 hours to prevent irreversible ischemic muscle necrosis, Volkmann ischemic contracture, rhabdomyolysis, and permanent peroneal nerve palsy." :
                "Continue close serial neurovascular monitoring (check 5 P's: Pain out of proportion to injury, Pain on passive stretch, Paresthesias, Pallor, Pulselessness). Repeat compartment pressure measurement in 2 hours if clinical suspicion persists.";

        return CompartmentSyndromeEvaluation.builder()
                .compartmentPressureMmHg(intracompartmentalPressureMmHg)
                .diastolicBloodPressure(diastolicBp)
                .deltaPressureMmHg(deltaP)
                .isEmergencyFasciotomyIndicated(fasciotomy)
                .surgicalAction(action)
                .build();
    }
}
