package com.hospital.hbot.tcom;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Transcutaneous Oximetry (TcPO2 / TCOM) Evaluation Service.
 * Evaluates peri-wound microvascular oxygen tension (mmHg) during normobaric room air,
 * normobaric 100% O2 challenge, and hyperbaric (2.0-2.4 ATA) oxygen challenge.
 * - Baseline TcPO2 < 40 mmHg indicates microvascular hypoxia.
 * - In-chamber TcPO2 > 200 mmHg predicts successful ulcer healing with HBOT.
 */
@Service
public class TranscutaneousOximetryService {

    public record Tcpo2Assessment(
        double baselineRoomAirMmHg,
        double normobaric100O2MmHg,
        double inChamberHyperbaricMmHg,
        boolean severePeriwoundHypoxia,
        boolean responsiveToOxygenChallenge,
        boolean highProbabilityOfHbotHealing,
        String clinicalRecommendation
    ) {}

    public Tcpo2Assessment evaluateTcpo2(double baseline, double normo100, double inChamber) {
        boolean hypoxia = baseline < 40.0;
        boolean responsive = (normo100 - baseline) >= 10.0 || normo100 >= 100.0;
        boolean willHeal = inChamber >= 200.0;

        String rec;
        if (!hypoxia) {
            rec = "Normoxic peri-wound tissue (TcPO2 >= 40 mmHg). Standard wound care adequate without HBOT.";
        } else if (willHeal) {
            rec = "EXCELLENT HBOT CANDIDATE: In-chamber TcPO2 > 200 mmHg confirms microvascular responsiveness and high probability of angiogenesis.";
        } else if (responsive) {
            rec = "MODERATE HBOT CANDIDATE: Partial oxygen challenge response. Consider trial of 10-15 HBOT sessions.";
        } else {
            rec = "NON-RESPONSIVE (TcPO2 < 100 in chamber): Severe fixed macrovascular disease. Urgent vascular surgery revascularization required prior to HBOT.";
        }

        return new Tcpo2Assessment(baseline, normo100, inChamber, hypoxia, responsive, willHeal, rec);
    }
}
