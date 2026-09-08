package com.hospital.hbot.sensory;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Emergency Ophthalmic & Otolaryngologic HBOT Protocols:
 * 1. Central Retinal Artery Occlusion (CRAO): Retinal ischemic tolerance is 4-6 hours (up to 24h). HBOT at 2.0-2.8 ATA supplies choroidal diffusion.
 * 2. Sudden Sensorineural Hearing Loss (SSNHL): Loss of >= 30 dB over 3 contiguous frequencies within 72 hrs. Best efficacy when HBOT initiated within 14 days.
 */
@Service
public class SensoryEmergencyHbotService {

    public record SensoryHbotPlan(String condition, double targetAta, int recommendedSessions, String therapeuticWindow, String adjunctiveMedication) {}

    public SensoryHbotPlan getPlan(String condition) {
        if ("CRAO".equalsIgnoreCase(condition)) {
            return new SensoryHbotPlan("Central Retinal Artery Occlusion (CRAO)", 2.8, 10, "Emergency: Initiate within 6-24 hours of vision loss", "Ocular massage, anterior chamber paracentesis, Acetazolamide 500mg IV");
        } else {
            return new SensoryHbotPlan("Sudden Sensorineural Hearing Loss (SSNHL)", 2.4, 20, "Golden Window: Initiate within 14 days of onset", "High-Dose Oral Prednisone (60mg daily x 7-14 days) or Intratympanic Dexamethasone");
        }
    }
}
