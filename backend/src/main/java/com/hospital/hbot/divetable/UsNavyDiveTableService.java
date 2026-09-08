package com.hospital.hbot.divetable;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Undersea and Hyperbaric Medical Society (UHMS) / US Navy Decompression Illness Recompression Protocols:
 * - Table 6 (Severe DCS Type II neurological / Arterial Gas Embolism AGE): 60 fsw (2.8 ATA) with O2 breathing + air breaks, total 285 min (extendable).
 * - Table 5 (Pain-only DCS Type I): 60 fsw for 135 min.
 * - Table 6A (Gas Embolism with initial 165 fsw / 6.0 ATA air descent).
 */
@Service
public class UsNavyDiveTableService {

    public enum DciSeverity { DCS_TYPE_1_PAIN_ONLY, DCS_TYPE_2_NEUROLOGICAL, ARTERIAL_GAS_EMBOLISM_AGE, AMBIENT_DIVING_TRAUMA }
    public record DiveTreatmentPlan(String selectedTable, double initialDepthFsw, double initialAta, int totalDurationMinutes, int o2BreathingPeriods, String extensionCriteria) {}

    public DiveTreatmentPlan selectTreatmentTable(DciSeverity severity, boolean alteredMentalStatus, boolean numbnessWeakness) {
        if (severity == DciSeverity.ARTERIAL_GAS_EMBOLISM_AGE || alteredMentalStatus) {
            return new DiveTreatmentPlan("US NAVY TREATMENT TABLE 6 (EXTENDED)", 60.0, 2.81, 330, 6, "Can add up to two 25-minute O2 extensions at 60 fsw and two 75-minute O2 extensions at 30 fsw.");
        } else if (severity == DciSeverity.DCS_TYPE_2_NEUROLOGICAL || numbnessWeakness) {
            return new DiveTreatmentPlan("US NAVY TREATMENT TABLE 6 (STANDARD)", 60.0, 2.81, 285, 5, "Standard Table 6: 60 fsw (20m O2 / 5m Air x 3) -> 30 fsw (20m O2 / 5m Air x 2).");
        } else {
            return new DiveTreatmentPlan("US NAVY TREATMENT TABLE 5", 60.0, 2.81, 135, 3, "Table 5: Pain-only DCS Type I with complete symptom resolution within 10 min at 60 fsw.");
        }
    }
}
