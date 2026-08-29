package com.hospital.clinical.knowledge;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Hospital Infection Prevention and Antimicrobial Stewardship (AMS) Engine.
 * Monitors Healthcare-Associated Infections (HAI: CAUTI, CLABSI, SSI, VAP),
 * restricted antimicrobial authorization, and cumulative antibiogram sensitivities.
 */
@Component
public class AntimicrobialStewardshipEngine {

    @Data
    @Builder
    public static class RestrictedAntimicrobial {
        private String antibioticCode;
        private String antibioticName;
        private String drugClass; // Carbapenem, Glycopeptide, Polymyxin, Lipopeptide
        private boolean preAuthorizationRequired;
        private String authorizedIndications;
        private int maxEmpiricDurationHours; // e.g. 48 or 72 hours before de-escalation timeout
        private List<String> requiredCulturesBeforeDispense;
    }

    @Data
    @Builder
    public static class HaiSurveillanceCase {
        private String infectionType; // CAUTI, CLABSI, SSI, VAP
        private String deviceInPlace; // Foley Catheter, Central Venous Line, Endotracheal Tube
        private int daysDeviceInSitu;
        private boolean criteriaMet;
        private String surveillanceDefinition;
        private List<String> recommendedBundleAudits;
    }

    private static final List<RestrictedAntimicrobial> RESTRICTED_DRUGS = new ArrayList<>();

    static {
        RESTRICTED_DRUGS.add(RestrictedAntimicrobial.builder()
                .antibioticCode("REST-COLIS")
                .antibioticName("Colistin (Polymyxin E)")
                .drugClass("Polymyxin")
                .preAuthorizationRequired(true)
                .authorizedIndications("Confirmed Multi-Drug Resistant (MDR) or Carbapenem-Resistant Enterobacteriaceae (CRE) / Acinetobacter with documented in vitro sensitivity")
                .maxEmpiricDurationHours(48)
                .requiredCulturesBeforeDispense(Arrays.asList("Blood Culture", "Endotracheal Aspirate / Sputum", "Urine Culture"))
                .build());

        RESTRICTED_DRUGS.add(RestrictedAntimicrobial.builder()
                .antibioticCode("REST-MERO")
                .antibioticName("Meropenem / Imipenem")
                .drugClass("Carbapenem")
                .preAuthorizationRequired(true)
                .authorizedIndications("Septic shock with high risk of ESBL-producing organisms, or documented ESBL infection")
                .maxEmpiricDurationHours(72)
                .requiredCulturesBeforeDispense(Arrays.asList("Blood Cultures x 2 Sets prior to 1st dose"))
                .build());

        RESTRICTED_DRUGS.add(RestrictedAntimicrobial.builder()
                .antibioticCode("REST-DAPTO")
                .antibioticName("Daptomycin")
                .drugClass("Lipopeptide")
                .preAuthorizationRequired(true)
                .authorizedIndications("Vancomycin-resistant Enterococcus (VRE) bacteremia or MRSA right-sided endocarditis (INACTIVATED BY SURFACTANT - DO NOT USE FOR PNEUMONIA)")
                .maxEmpiricDurationHours(48)
                .requiredCulturesBeforeDispense(Arrays.asList("Blood Cultures", "Baseline Serum CPK level"))
                .build());
    }

    public List<RestrictedAntimicrobial> getRestrictedList() {
        return RESTRICTED_DRUGS;
    }

    /**
     * Evaluates Catheter-Associated Urinary Tract Infection (CAUTI) CDC NHSN surveillance criteria.
     */
    public HaiSurveillanceCase evaluateCauti(int catheterDays, double feverTempC, boolean hasDysuriaOrSuprapubicPain, int colonyCountCfu) {
        boolean criteria = catheterDays >= 2 && (feverTempC >= 38.0 || hasDysuriaOrSuprapubicPain) && colonyCountCfu >= 100000;

        List<String> bundle = Arrays.asList(
                "1. Assess daily necessity of Foley catheter (Remove immediately if no longer indicated).",
                "2. Maintain sterile, continuously closed drainage system.",
                "3. Ensure unobstructed urine flow; collection bag below level of bladder.",
                "4. Perform hand hygiene and aseptic technique during catheter insertion and manipulation."
        );

        return HaiSurveillanceCase.builder()
                .infectionType("CAUTI")
                .deviceInPlace("Indwelling Urinary (Foley) Catheter")
                .daysDeviceInSitu(catheterDays)
                .criteriaMet(criteria)
                .surveillanceDefinition("CDC/NHSN CAUTI: Indwelling catheter in place > 2 calendar days + Fever >= 38.0C + Urine culture >= 10^5 CFU/mL with <= 2 species")
                .recommendedBundleAudits(bundle)
                .build();
    }
}
