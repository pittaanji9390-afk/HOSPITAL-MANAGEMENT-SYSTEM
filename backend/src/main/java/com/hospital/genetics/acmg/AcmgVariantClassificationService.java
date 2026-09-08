package com.hospital.genetics.acmg;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * ACMG / AMP 2015 Sequence Variant Classification Engine.
 * Implements standard rules combining PVS (Very Strong), PS (Strong), PM (Moderate), PP (Supporting),
 * BA (Stand-alone Benign), BS (Strong Benign), and BP (Supporting Benign) criteria into:
 * 1. Pathogenic
 * 2. Likely Pathogenic
 * 3. Variant of Uncertain Significance (VUS)
 * 4. Likely Benign
 * 5. Benign
 */
@Service
public class AcmgVariantClassificationService {

    public enum AcmgClassification { PATHOGENIC, LIKELY_PATHOGENIC, VARIANT_OF_UNCERTAIN_SIGNIFICANCE_VUS, LIKELY_BENIGN, BENIGN }

    public record VariantEvidenceCriteria(
        boolean pvs1_nullVariant,
        int ps_strongPathogenicCount,
        int pm_moderatePathogenicCount,
        int pp_supportingPathogenicCount,
        boolean ba1_standAloneBenignFreqGt5Pct,
        int bs_strongBenignCount,
        int bp_supportingBenignCount
    ) {}

    public record AcmgResult(AcmgClassification classification, String evidenceSummary, boolean actionableForMedicalManagement) {}

    public AcmgResult classifyVariant(VariantEvidenceCriteria c) {
        if (c.ba1_standAloneBenignFreqGt5Pct()) {
            return new AcmgResult(AcmgClassification.BENIGN, "BA1: Allele frequency > 5% in gnomAD (Stand-alone benign).", false);
        }

        // Pathogenic rules
        boolean isPathogenic = false;
        if (c.pvs1_nullVariant() && (c.ps_strongPathogenicCount() >= 1 || c.pm_moderatePathogenicCount() >= 2 || (c.pm_moderatePathogenicCount() == 1 && c.pp_supportingPathogenicCount() == 1) || c.pp_supportingPathogenicCount() >= 2)) {
            isPathogenic = true;
        } else if (c.ps_strongPathogenicCount() >= 2 || (c.ps_strongPathogenicCount() == 1 && c.pm_moderatePathogenicCount() >= 3)) {
            isPathogenic = true;
        }

        // Likely pathogenic rules
        boolean isLikelyPathogenic = false;
        if (!isPathogenic) {
            if (c.pvs1_nullVariant() && c.pm_moderatePathogenicCount() == 1) isLikelyPathogenic = true;
            else if (c.ps_strongPathogenicCount() == 1 && (c.pm_moderatePathogenicCount() == 1 || c.pm_moderatePathogenicCount() == 2)) isLikelyPathogenic = true;
            else if (c.pm_moderatePathogenicCount() >= 3) isLikelyPathogenic = true;
        }

        // Benign rules
        boolean isBenign = c.bs_strongBenignCount() >= 2;
        boolean isLikelyBenign = (c.bs_strongBenignCount() == 1 && c.bp_supportingBenignCount() >= 1) || c.bp_supportingBenignCount() >= 2;

        AcmgClassification finalClass;
        if (isPathogenic) finalClass = AcmgClassification.PATHOGENIC;
        else if (isLikelyPathogenic) finalClass = AcmgClassification.LIKELY_PATHOGENIC;
        else if (isBenign) finalClass = AcmgClassification.BENIGN;
        else if (isLikelyBenign) finalClass = AcmgClassification.LIKELY_BENIGN;
        else finalClass = AcmgClassification.VARIANT_OF_UNCERTAIN_SIGNIFICANCE_VUS;

        boolean actionable = (finalClass == AcmgClassification.PATHOGENIC || finalClass == AcmgClassification.LIKELY_PATHOGENIC);
        String summary = "ACMG 2015 Tier: " + finalClass.name() + " (PVS1=" + c.pvs1_nullVariant() + ", PS=" + c.ps_strongPathogenicCount() + ", PM=" + c.pm_moderatePathogenicCount() + ", PP=" + c.pp_supportingPathogenicCount() + ")";

        return new AcmgResult(finalClass, summary, actionable);
    }
}
