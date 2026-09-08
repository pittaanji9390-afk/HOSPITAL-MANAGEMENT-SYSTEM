package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Cardiology & Infectious Diseases Endocarditis Decision Engine.
 * Implements 2023 Modified Duke Criteria for Infective Endocarditis (IE),
 * Native Valve vs Prosthetic Valve Empirical Regimens, and Emergent Surgical Indications.
 */
@Component
public class CardiologyInfectiveEndocarditisEngine {

    @Data
    @Builder
    public static class DukeCriteriaResult {
        private String diagnosisCategory; // DEFINITE, POSSIBLE, REJECTED
        private int majorCriteriaMet;
        private int minorCriteriaMet;
        private List<String> empiricalAntimicrobialRegimen;
        private List<String> urgentSurgicalIndications;
    }

    public DukeCriteriaResult evaluateDukeCriteria(int majorCriteriaCount, int minorCriteriaCount, boolean isProstheticValve) {
        String category;
        if (majorCriteriaCount >= 2 || (majorCriteriaCount == 1 && minorCriteriaCount >= 3) || minorCriteriaCount >= 5) {
            category = "DEFINITE INFECTIVE ENDOCARDITIS";
        } else if ((majorCriteriaCount == 1 && minorCriteriaCount >= 1) || minorCriteriaCount >= 3) {
            category = "POSSIBLE INFECTIVE ENDOCARDITIS";
        } else {
            category = "INFECTIVE ENDOCARDITIS REJECTED / UNLIKELY";
        }

        List<String> antibiotics = new ArrayList<>();
        if (isProstheticValve) {
            antibiotics.add("PROSTHETIC VALVE EMPIRIC REGIMEN: Vancomycin 15-20 mg/kg IV q8-12h (Target trough 15-20 mcg/mL) + Rifampin 300mg PO/IV q8h + Gentamicin 1 mg/kg IV q8h for 6 weeks (Rifampin penetrates staphylococcal biofilm on prosthetic rings/valves).");
        } else {
            antibiotics.add("NATIVE VALVE EMPIRIC REGIMEN: Ampicillin-Sulbactam 3g IV q6h + Gentamicin 1 mg/kg IV q8h OR Vancomycin 15-20 mg/kg IV q8-12h + Ceftriaxone 2g IV q24h for 4-6 weeks.");
        }

        List<String> surgical = Arrays.asList(
                "HEART FAILURE: Refractory acute pulmonary edema or cardiogenic shock due to severe acute aortic/mitral regurgitation or valve perforation (Class I, Level A).",
                "UNCONTROLLED INFECTION: Persistent bacteremia or fever > 7-10 days despite optimal targeted antimicrobials, or local abscess / pseudoaneurysm / fistula formation.",
                "EMBOLISM PREVENTION: Large mobile vegetation > 10 mm on left-sided valve with recurrent systemic embolic events, or very large vegetation > 15-30 mm."
        );

        return DukeCriteriaResult.builder()
                .diagnosisCategory(category)
                .majorCriteriaMet(majorCriteriaCount)
                .minorCriteriaMet(minorCriteriaCount)
                .empiricalAntimicrobialRegimen(antibiotics)
                .urgentSurgicalIndications(surgical)
                .build();
    }
}
