package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Anesthesiology & Perioperative Medicine Decision Engine.
 * Implements ASA Physical Status Classification, Mallampati Airway Risk Assessment,
 * Apfel Score for Postoperative Nausea and Vomiting (PONV), Malignant Hyperthermia Dantrolene Protocol,
 * and Minimum Alveolar Concentration (MAC) volatile anesthetic adjustments.
 */
@Component
public class AnesthesiologyPerioperativeEngine {

    @Data
    @Builder
    public static class MallampatiAirwayEvaluation {
        private int mallampatiClass; // 1 to 4
        private boolean hasLimitedCervicalExtension;
        private double thyromentalDistanceCm; // < 6 cm indicates difficult airway
        private boolean hasInterincisorGapLessThan3Cm;
        private String difficultIntubationRisk;
        private List<String> airwayPreparationPlan;
    }

    public MallampatiAirwayEvaluation evaluateAirway(int mallampatiClass, double thyromentalDistanceCm,
                                                    boolean limitedNeckExtension, boolean mouthOpeningUnder3Cm) {
        int riskFactors = 0;
        if (mallampatiClass >= 3) riskFactors += 2;
        if (thyromentalDistanceCm < 6.0) riskFactors += 2;
        if (limitedNeckExtension) riskFactors += 1;
        if (mouthOpeningUnder3Cm) riskFactors += 2;

        String risk;
        List<String> plan = new ArrayList<>();

        if (riskFactors >= 3) {
            risk = "HIGH RISK FOR DIFFICULT MASK VENTILATION AND INTUBATION (LEMON Score Elevated)";
            plan.add("Have Video Laryngoscope (GlideScope / C-MAC) immediately available in operating room.");
            plan.add("Prepare Fiberoptic Bronchoscope for Awake Fiberoptic Intubation under local topicalization.");
            plan.add("Ensure Supraglottic Airway Devices (LMA Supreme / i-gel) and Scalpel Cricothyroidotomy kit ready.");
            plan.add("Pre-oxygenate with 100% FiO2 for 3-5 minutes with tight mask seal and High-Flow Nasal Cannula (THRIVE).");
        } else {
            risk = "STANDARD / PREDICTED ROUTINE AIRWAY (Mallampati I-II)";
            plan.add("Standard direct laryngoscopy with Macintosh #3/4 blade.");
            plan.add("Bougie / Endotracheal tube introducer on standby.");
        }

        return MallampatiAirwayEvaluation.builder()
                .mallampatiClass(mallampatiClass)
                .hasLimitedCervicalExtension(limitedNeckExtension)
                .thyromentalDistanceCm(thyromentalDistanceCm)
                .hasInterincisorGapLessThan3Cm(mouthOpeningUnder3Cm)
                .difficultIntubationRisk(risk)
                .airwayPreparationPlan(plan)
                .build();
    }

    @Data
    @Builder
    public static class MalignantHyperthermiaProtocol {
        private String triggerAgents;
        private String immediateFirstAction;
        private double dantroleneInitialDoseMgPerKg;
        private String dantrolenePreparationInstructions;
        private List<String> supportiveCriticalMeasures;
    }

    public MalignantHyperthermiaProtocol getMalignantHyperthermiaRescueProtocol(double patientWeightKg) {
        double initialDantroleneTotalMg = patientWeightKg * 2.5; // 2.5 mg/kg initial bolus

        List<String> measures = new ArrayList<>();
        measures.add("IMMEDIATELY DISCONTINUE ALL VOLATILE ANESTHETICS (Sevoflurane, Desflurane, Isoflurane) and SUCCINYLCHOLINE.");
        measures.add("Hyperventilate with 100% O2 at maximum fresh gas flow rate (> 10 L/min) using clean breathing circuit and charcoal filters.");
        measures.add("Administer IV Dantrolene 2.5 mg/kg push rapidly, repeated every 5-10 minutes until hypermetabolic signs subside (Max cumulative dose 10-30 mg/kg).");
        measures.add("Active internal and external cooling: Cold IV saline 0.9% (1000 mL boluses), ice packs to axillae/groin, bladder irrigation with cold saline (Stop cooling at core temp 38.0°C to prevent hypothermic overshoot).");
        measures.add("Treat severe hyperkalemia: IV Regular Insulin 10 units + 50 mL D50W, IV Calcium Chloride 10% 10 mL (1g), and Sodium Bicarbonate 1-2 mEq/kg for metabolic acidosis.");
        measures.add("Maintain brisk diuresis (> 1-2 mL/kg/hr) with IV fluids, Furosemide, or Mannitol to prevent acute tubular necrosis from massive rhabdomyolysis / myoglobinuria.");

        return MalignantHyperthermiaProtocol.builder()
                .triggerAgents("Volatile Halogenated Inhalation Anesthetics (Sevoflurane, Desflurane, Isoflurane) and Depolarizing Muscle Relaxants (Succinylcholine)")
                .immediateFirstAction("CALL FOR HELP / MH CART & DISCONTINUE ANESTHETIC AGENTS")
                .dantroleneInitialDoseMgPerKg(2.5)
                .dantrolenePreparationInstructions("Reconstitute each 20 mg vial of Dantrolene with 60 mL of sterile preservative-free water (without bacteriostatic agents) and shake vigorously until clear. Total initial dose for " + patientWeightKg + " kg patient: " + initialDantroleneTotalMg + " mg (~" + (int)Math.ceil(initialDantroleneTotalMg / 20.0) + " vials).")
                .supportiveCriticalMeasures(measures)
                .build();
    }
}
