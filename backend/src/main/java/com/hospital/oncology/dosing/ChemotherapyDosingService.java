package com.hospital.oncology.dosing;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * High-Precision Chemotherapy Dosing Engine:
 * 1. Calvert Formula for Carboplatin: Dose (mg) = Target AUC x (GFR + 25) [with GFR capped at 125 mL/min].
 * 2. Mosteller BSA Formula: BSA (m^2) = sqrt( (Height_cm x Weight_kg) / 3600 ).
 * 3. DuBois & DuBois BSA Formula: BSA (m^2) = 0.007184 x (Height_cm^0.725) x (Weight_kg^0.425).
 * 4. Cockcroft-Gault CrCl with cap for elderly / low SCr (< 0.7 mg/dL).
 */
@Service
public class ChemotherapyDosingService {

    public record PatientBiometrics(double heightCm, double weightKg, int ageYears, boolean isFemale, double serumCreatinineMgDl) {}
    public record CalvertDosingResult(double calculatedBsaMostellerM2, double creatinineClearanceMlMin, double cappedGfrMlMin, double targetAuc, double carboplatinDoseMg, String doseCapWarning) {}

    public double calculateMostellerBsa(double heightCm, double weightKg) {
        return Math.sqrt((heightCm * weightKg) / 3600.0);
    }

    public double calculateCockcroftGaultCrCl(PatientBiometrics p) {
        double scr = Math.max(0.7, p.serumCreatinineMgDl()); // Standard oncologic round-up for low creatinine
        double crcl = ((140.0 - p.ageYears()) * p.weightKg()) / (72.0 * scr);
        if (p.isFemale()) {
            crcl *= 0.85;
        }
        return crcl;
    }

    public CalvertDosingResult calculateCarboplatinDose(PatientBiometrics p, double targetAuc) {
        double bsa = calculateMostellerBsa(p.heightCm(), p.weightKg());
        double rawCrCl = calculateCockcroftGaultCrCl(p);
        double cappedGfr = Math.min(125.0, rawCrCl); // FDA / ASCO safety cap: max GFR 125 mL/min

        double dose = targetAuc * (cappedGfr + 25.0);
        double maxAllowedDose = targetAuc * (125.0 + 25.0); // AUC x 150 mg

        String warning = rawCrCl > 125.0 ? "FDA SAFETY CAP APPLIED: GFR capped at 125 mL/min to prevent severe myelosuppression." : "Dose within standard Calvert parameters.";

        return new CalvertDosingResult(bsa, rawCrCl, cappedGfr, targetAuc, Math.min(dose, maxAllowedDose), warning);
    }
}
