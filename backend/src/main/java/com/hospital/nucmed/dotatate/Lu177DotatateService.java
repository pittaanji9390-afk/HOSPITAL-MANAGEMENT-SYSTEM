package com.hospital.nucmed.dotatate;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Peptide Receptor Radionuclide Therapy (PRRT) with 177Lu-DOTATATE (Lutathera) for GEP-NETs (NETTER-1 Trial).
 * Delivers 7.4 GBq (200 mCi) IV Q8W x 4 cycles with mandatory concurrent Amino Acid Infusion (2.5% Lysine + 2.5% Arginine)
 * to competitively inhibit renal proximal tubule peptide reabsorption and prevent nephrotoxicity.
 */
@Service
public class Lu177DotatateService {

    public record PrrtSession(
        String rxId,
        String netPrimarySite,
        int sstrKrenningScore, // 1 to 4 on Ga-68 DOTATATE PET/CT
        int cycleIndex,
        boolean aminoAcidInfusionStarted30MinPrior
    ) {}

    public record PrrtEligibility(boolean eligibleForLutathera, String protocolRequirement) {}

    public PrrtEligibility evaluatePrrt(PrrtSession s) {
        boolean sstrAvid = s.sstrKrenningScore() >= 3; // Must be >= Liver background
        if (!sstrAvid) {
            return new PrrtEligibility(false, "INELIGIBLE: Somatostatin receptor expression (Krenning score < 3) insufficient on Ga-68 DOTATATE PET scan.");
        }
        if (!s.aminoAcidInfusionStarted30MinPrior()) {
            return new PrrtEligibility(false, "HOLD RADIONUCLIDE: Amino acid renal protector infusion (Lysine/Arginine) MUST be running for >= 30 min before Lutathera infusion.");
        }
        return new PrrtEligibility(true, "ELIGIBLE: Administer 7.4 GBq (200 mCi) Lu-177 DOTATATE IV over 30 min. Continue amino acid infusion for 3.5 hours post-dose.");
    }
}
