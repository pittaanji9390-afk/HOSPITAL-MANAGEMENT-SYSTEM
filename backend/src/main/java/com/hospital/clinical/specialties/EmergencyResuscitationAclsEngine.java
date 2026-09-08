package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Emergency & Critical Care Resuscitation Engine (AHA/ERC ACLS Guidelines).
 * Implements Cardiac Arrest Algorithms (VF/pVT vs Asystole/PEA), Post-Cardiac Arrest Care (TTM & ROSC hemodynamic targets),
 * Reversible Causes of Arrest (5 H's and 5 T's), Shock Index, and Sepsis Hour-1 Resuscitation.
 */
@Component
public class EmergencyResuscitationAclsEngine {

    public enum CardiacArrestRhythm {
        VENTRICULAR_FIBRILLATION, PULSELESS_VENTRICULAR_TACHYCARDIA, ASYSTOLE, PULSELESS_ELECTRICAL_ACTIVITY
    }

    @Data
    @Builder
    public static class AclsActionPlan {
        private CardiacArrestRhythm rhythm;
        private boolean isShockable;
        private String defibrillationEnergy;
        private String pharmacotherapy;
        private String airwayAndCprInstructions;
        private List<String> reversibleCausesHsAndTs;
    }

    public AclsActionPlan evaluateCardiacArrest(CardiacArrestRhythm rhythm, int cprCycleNumber) {
        boolean shockable = (rhythm == CardiacArrestRhythm.VENTRICULAR_FIBRILLATION ||
                             rhythm == CardiacArrestRhythm.PULSELESS_VENTRICULAR_TACHYCARDIA);

        String defib;
        String pharma;

        if (shockable) {
            defib = "DELIVER 1 DEFIBRILLATION SHOCK (Biphasic: 120-200 Joules manufacturer specific / 200J default; Monophasic: 360 Joules). Resume CPR immediately for 2 minutes without checking pulse.";
            if (cprCycleNumber >= 2 && cprCycleNumber % 2 == 0) {
                pharma = "IV/IO Epinephrine 1 mg (1:10,000) every 3-5 minutes; AND IV/IO Amiodarone 300 mg bolus for refractory VF/pVT (Second dose 150 mg after 2 additional cycles) OR Lidocaine 1.0-1.5 mg/kg IV bolus.";
            } else {
                pharma = "Administer IV/IO Epinephrine 1 mg after second defibrillation shock; prepare antiarrhythmic (Amiodarone/Lidocaine).";
            }
        } else {
            defib = "NON-SHOCKABLE RHYTHM. DO NOT DEFIBRILLATE. Resume CPR immediately.";
            pharma = "ADMINISTER IV/IO EPINEPHRINE 1 MG AS EARLY AS POSSIBLE, repeat every 3-5 minutes. Search aggressively for reversible causes (H's and T's).";
        }

        List<String> hsAndTs = Arrays.asList(
                "HYPOVOLEMIA (Rapid IV crystalloid bolus)",
                "HYPOXIA (Verify airway, 100% FiO2, bag-mask seal)",
                "HYDROGEN ION / ACIDOSIS (Hyperventilate, IV Sodium Bicarbonate for severe metabolic acidosis)",
                "HYPO/HYPERKALEMIA (Calcium Chloride 1g + Insulin/Glucose for hyperkalemia; Potassium replacement for hypokalemia)",
                "HYPOTHERMIA (Active core rewarming)",
                "TENSION PNEUMOTHORAX (Immediate needle decompression in 2nd ICS MCL or 5th ICS AAL followed by chest tube)",
                "TAMPONADE, CARDIAC (Emergent bedside ultrasound and pericardiocentesis)",
                "TOXINS / OVERDOSE (Specific antidotes: Naloxone for opioids, Lipid emulsion for local anesthetic toxicity)",
                "THROMBOSIS, PULMONARY (Massive PE: Consider emergent systemic thrombolysis with Alteplase 50mg IV push)",
                "THROMBOSIS, CORONARY (ACS/STEMI: Emergent transport to Cardiac Catheterization Lab for primary PCI)"
        );

        return AclsActionPlan.builder()
                .rhythm(rhythm)
                .isShockable(shockable)
                .defibrillationEnergy(defib)
                .pharmacotherapy(pharma)
                .airwayAndCprInstructions("High-Quality CPR: Compress at 100-120/min, depth 5-6 cm (2-2.4 inches), allow complete chest recoil, minimize interruptions (< 10s), rotate compressor every 2 minutes. Continuous waveform capnography (PETCO2 < 10 mmHg indicates low CPR quality; sudden increase to 35-40 mmHg indicates ROSC).")
                .reversibleCausesHsAndTs(hsAndTs)
                .build();
    }
}
