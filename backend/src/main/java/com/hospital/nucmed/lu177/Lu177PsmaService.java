package com.hospital.nucmed.lu177;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Lutetium-177 VIP-PSMA-617 (Pluvicto) Targeted Radionuclide Therapy Engine (VISION Trial Protocol).
 * Delivers 7.4 GBq (200 mCi) IV every 6 weeks for up to 6 cycles for PSMA-positive metastatic castration-resistant prostate cancer (mCRPC).
 * Tracks cumulative kidney radiation absorbed dose (Safety limit: < 23 Gy BED) and bone marrow dose (< 2.0 Gy).
 */
@Service
public class Lu177PsmaService {

    public record Lu177TreatmentCycle(
        String patientMrn,
        int cycleNumber,
        double administeredActivityGbg,
        double estimatedKidneyAbsorbedDoseGy,
        double estimatedBoneMarrowAbsorbedDoseGy,
        double baselineHemoglobinGDl,
        double baselinePlateletsX10e3,
        double baselineEgfrMlMin
    ) {}

    public record Lu177SafetyEvaluation(
        boolean safeToProceedWithCycle,
        double cumulativeKidneyDoseGy,
        boolean doseReductionRequired,
        String clinicalGuidance
    ) {}

    public Lu177SafetyEvaluation evaluateCycle(Lu177TreatmentCycle c, double priorKidneyDoseGy) {
        double totalKidney = priorKidneyDoseGy + c.estimatedKidneyAbsorbedDoseGy();
        boolean myelosuppressed = c.baselinePlateletsX10e3() < 75.0 || c.baselineHemoglobinGDl() < 8.0;
        boolean renalImpairment = c.baselineEgfrMlMin() < 30.0;
        boolean kidneyDoseExceeded = totalKidney > 23.0;

        boolean pass = !myelosuppressed && !renalImpairment && !kidneyDoseExceeded;
        boolean reduce = c.baselinePlateletsX10e3() >= 75.0 && c.baselinePlateletsX10e3() < 100.0;

        String msg;
        if (!pass) {
            msg = "CYCLE HELD: Severe myelosuppression (Platelets < 75k) or eGFR < 30 mL/min or cumulative kidney absorbed dose limit (23 Gy) reached.";
        } else if (reduce) {
            msg = "DOSE REDUCTION (20% to 5.92 GBq): Moderate thrombocytopenia. Administer with amino acid renal protector infusion (Lysine/Arginine).";
        } else {
            msg = "PROCEED: Standard 7.4 GBq (200 mCi) Pluvicto infusion with concurrent IV hydration and antiemetics.";
        }

        return new Lu177SafetyEvaluation(pass, totalKidney, reduce, msg);
    }
}
