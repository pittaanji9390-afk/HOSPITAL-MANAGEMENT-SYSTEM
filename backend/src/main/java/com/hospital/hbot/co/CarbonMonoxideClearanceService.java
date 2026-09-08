package com.hospital.hbot.co;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Carbon Monoxide (CO) Poisoning Hyperbaric Clearance Engine.
 * COHb Elimination Half-Life:
 * - Room Air (21% O2 @ 1.0 ATA): ~320 minutes (5.3 hours).
 * - High-Flow Non-Rebreather Mask (100% O2 @ 1.0 ATA): ~74 - 80 minutes.
 * - Hyperbaric Oxygen (100% O2 @ 3.0 ATA): ~20 - 23 minutes.
 * Prevents Delayed Neurological Sequelae (DNS) in patients with loss of consciousness or pregnancy (fetal HbCO).
 */
@Service
public class CarbonMonoxideClearanceService {

    public record CoPoisoningAssessment(
        double initialCohbPercent,
        boolean lossOfConsciousness,
        boolean isPregnant,
        boolean ischemicEcgChanges,
        double metabolicAcidosisPh,
        boolean hbotMandated,
        double estimatedHalfLifeRoomAirMinutes,
        double estimatedHalfLifeNrb100Minutes,
        double estimatedHalfLifeHbot3AtaMinutes,
        String treatmentRecommendation
    ) {}

    public CoPoisoningAssessment evaluateCoPoisoning(double cohb, boolean syncope, boolean pregnant, boolean ecgIschemia, double ph) {
        boolean hbotIndicated = cohb >= 25.0 || (pregnant && cohb >= 15.0) || syncope || ecgIschemia || (ph < 7.25);

        double tHalfRoom = 320.0;
        double tHalfNrb = 80.0;
        double tHalfHbot = 22.0;

        String rec = hbotIndicated
            ? "EMERGENCY HBOT MANDATED: 100% O2 @ 2.8 - 3.0 ATA x 1-3 sessions within 24 hours to prevent Delayed Neurological Sequelae (DNS)."
            : "Supportive Normobaric 100% O2 via high-flow non-rebreather mask until COHb < 5%.";

        return new CoPoisoningAssessment(cohb, syncope, pregnant, ecgIschemia, ph, hbotIndicated, tHalfRoom, tHalfNrb, tHalfHbot, rec);
    }
}
