package com.hospital.perinatal.gbs;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * CDC / ACOG Group B Streptococcus (GBS) Intrapartum Antibiotic Prophylaxis (IAP) Algorithm
 * Evaluates GBS screening (36 0/7 - 37 6/7 wks), penicillin allergy risk (low vs high risk anaphylaxis), and clindamycin susceptibility.
 */
@Service
public class GroupBStrepProphylaxisService {

    public enum PenicillinAllergyTier {
        NONE,
        LOW_RISK_RASH_NO_ANAPHYLAXIS,
        HIGH_RISK_ANAPHYLAXIS_ANGIOEDEMA_RESPIRATORY_DISTRESS
    }

    public static record GbsIapRecommendation(
            String patientId,
            boolean iapIndicated,
            String firstLineAntibioticRegimen,
            String timingRequirement, // At least 4 hours of IV antibiotics prior to delivery for adequate fetal levels
            String neonatalSurveillanceOrders,
            Instant generatedAt
    ) implements Serializable {}

    public GbsIapRecommendation evaluateGbsIap(
            String patientId,
            boolean positiveRectovaginalCulture,
            boolean gbsBacteriuriaThisPregnancy,
            boolean priorInfantWithEarlyOnsetGbs,
            int gestationalAgeWeeks,
            int ruptureOfMembranesHours,
            double maternalTemperatureCelsius,
            PenicillinAllergyTier allergyTier,
            boolean clindamycinSusceptible
    ) {
        boolean indicated = positiveRectovaginalCulture 
                || gbsBacteriuriaThisPregnancy 
                || priorInfantWithEarlyOnsetGbs
                || (gestationalAgeWeeks < 37)
                || (ruptureOfMembranesHours >= 18)
                || (maternalTemperatureCelsius >= 38.0);

        StringBuilder rx = new StringBuilder();

        if (!indicated) {
            rx.append("IAP Not Indicated: GBS negative culture and no intrapartum risk factors.");
        } else {
            if (allergyTier == PenicillinAllergyTier.NONE) {
                rx.append("Penicillin G: 5 million units IV initial dose, then 2.5-3.0 million units IV every 4 hours until delivery (Preferred) OR Ampicillin 2g IV initial then 1g q4h.");
            } else if (allergyTier == PenicillinAllergyTier.LOW_RISK_RASH_NO_ANAPHYLAXIS) {
                rx.append("Cefazolin: 2 g IV initial dose, then 1 g IV every 8 hours until delivery.");
            } else {
                if (clindamycinSusceptible) {
                    rx.append("Clindamycin: 900 mg IV every 8 hours until delivery (confirmed inducible clindamycin resistance D-zone test negative).");
                } else {
                    rx.append("Vancomycin: 20 mg/kg IV every 8 hours (maximum 2 g per single dose) until delivery.");
                }
            }
        }

        String timing = indicated 
                ? "Optimal adequacy requires >= 4 hours of IV antibiotics before delivery. Document exact time of 1st dose." 
                : "N/A";

        String neonatal = indicated 
                ? "If >=4h IAP received and infant well-appearing: Routine 24-48h vitals observation. If <4h IAP and membrane rupture >=18h: 48h observation." 
                : "Standard newborn nursery care.";

        return new GbsIapRecommendation(
                patientId,
                indicated,
                rx.toString(),
                timing,
                neonatal,
                Instant.now()
        );
    }
}
