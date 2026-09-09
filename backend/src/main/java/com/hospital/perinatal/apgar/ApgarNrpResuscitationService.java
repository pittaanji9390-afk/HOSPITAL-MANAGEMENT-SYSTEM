package com.hospital.perinatal.apgar;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * Neonatal APGAR Scoring (1, 5, 10 min) and Neonatal Resuscitation Program (NRP 8th Edition) Algorithm
 * Evaluates Appearance, Pulse, Grimace, Activity, Respiration, and directs Positive Pressure Ventilation (PPV), MR. SOPA, and Epinephrine.
 */
@Service
public class ApgarNrpResuscitationService {

    public static record ApgarScoreResult(
            String infantId,
            int minuteInterval, // 1, 5, 10, 15, 20
            int heartRateScore, // 0=Absent, 1=<100 bpm, 2=>=100 bpm
            int respiratoryEffortScore, // 0=Absent, 1=Weak/gasping, 2=Good vigorous cry
            int muscleToneScore, // 0=Flaccid, 1=Some flexion, 2=Active motion
            int reflexIrritabilityScore, // 0=No response, 1=Grimace, 2=Crying/coughing/pulling away
            int colorScore, // 0=Blue/pale, 1=Acrocyanosis, 2=Completely pink
            int totalApgar,
            String nrpResuscitationSteps,
            Instant recordedAt
    ) implements Serializable {}

    public ApgarScoreResult evaluateApgar(
            String infantId,
            int min,
            int hr,
            int resp,
            int tone,
            int reflex,
            int color,
            int actualHrBpm
    ) {
        int total = hr + resp + tone + reflex + color;
        StringBuilder nrp = new StringBuilder();

        if (actualHrBpm < 60) {
            nrp.append("CRITICAL BRADYCARDIAL SHOCK (HR < 60 bpm): ")
               .append("1. Initiate Chest Compressions with 100% O2 in 3:1 ratio (90 compressions + 30 breaths/min). ")
               .append("2. Secure Endotracheal Tube (ETT). ")
               .append("3. Administer IV Epinephrine (0.02 mg/kg of 0.1 mg/mL = 0.2 mL/kg) via umbilical venous catheter (UVC). Flush with 3 mL NS.");
        } else if (actualHrBpm < 100 || resp == 0) {
            nrp.append("APNEA / BRADYCARDIAL DISTRESS (HR < 100 bpm): ")
               .append("1. Initiate Positive Pressure Ventilation (PPV) with 21-30% FiO2 at 40-60 breaths/min (PIAP 20-25 cmH2O, PEEP 5 cmH2O). ")
               .append("2. If chest not rising, perform MR. SOPA (Mask readjust, Reposition airway, Suction mouth/nose, Open mouth, Pressure increase, Alternative airway).");
        } else if (total < 7) {
            nrp.append("DEPRESSED APGAR (< 7): Warm, dry, stimulate, position airway, apply pulse oximeter on right wrist (pre-ductal). Provide supplemental CPAP (5 cmH2O) if labored breathing.");
        } else {
            nrp.append("VIGOROUS NEWBORN (APGAR 7-10): Place skin-to-skin on mother's chest, clear secretions with bulb syringe as needed, initiate early breastfeeding.");
        }

        return new ApgarScoreResult(
                infantId,
                min,
                hr,
                resp,
                tone,
                reflex,
                color,
                total,
                nrp.toString(),
                Instant.now()
        );
    }
}
