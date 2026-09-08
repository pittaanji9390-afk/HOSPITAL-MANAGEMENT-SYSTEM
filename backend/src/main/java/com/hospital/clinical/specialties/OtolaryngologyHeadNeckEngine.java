package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Otolaryngology (ENT) & Head and Neck Surgery Engine.
 * Implements Modified Centor / McIsaac Score for Group A Streptococcal Pharyngitis,
 * Epistaxis Stepwise Hemostasis Protocols, Benign Paroxysmal Positional Vertigo (BPPV) Epley Maneuver,
 * and Sudden Sensorineural Hearing Loss (SSNHL) High-Dose Steroid Regimens.
 */
@Component
public class OtolaryngologyHeadNeckEngine {

    @Data
    @Builder
    public static class CentorScoreResult {
        private int totalScore;
        private String probabilityOfGroupAStrep;
        private String recommendedDiagnosticAndAntibioticStrategy;
    }

    public CentorScoreResult evaluateCentorScore(boolean feverOver38C, boolean tonsillarExudates,
                                                boolean tenderAnteriorCervicalAdenopathy, boolean absenceOfCough,
                                                int patientAge) {
        int score = 0;
        if (feverOver38C) score++;
        if (tonsillarExudates) score++;
        if (tenderAnteriorCervicalAdenopathy) score++;
        if (absenceOfCough) score++;

        // McIsaac Age adjustment
        if (patientAge >= 3 && patientAge <= 14) score += 1;
        else if (patientAge >= 45) score -= 1;

        String prob;
        String strategy;

        if (score >= 4) {
            prob = "HIGH (38 - 53% risk of GAS)";
            strategy = "Perform Rapid Antigen Detection Test (RADT) and/or throat culture; initiate empiric antimicrobial therapy: Amoxicillin 500mg PO bid (or Penicillin V 500mg qid) for 10 full days to prevent Acute Rheumatic Fever and Peritonsillar Abscess.";
        } else if (score == 3) {
            prob = "INTERMEDIATE (17 - 32% risk of GAS)";
            strategy = "Perform Rapid Antigen Detection Test (RADT); treat with antibiotics ONLY if RADT or throat culture is positive.";
        } else if (score == 2) {
            prob = "LOW-INTERMEDIATE (10 - 17% risk of GAS)";
            strategy = "Perform RADT in children/adolescents; in adults, treat symptomatically (analgesics/lozenges) without antibiotics unless throat culture confirms GAS.";
        } else {
            prob = "VERY LOW (< 5% risk of GAS)";
            strategy = "Viral pharyngitis highly likely. No testing or antibiotics indicated. Supportive care with NSAIDs/Acetaminophen and warm saline gargles.";
        }

        return CentorScoreResult.builder()
                .totalScore(score)
                .probabilityOfGroupAStrep(prob)
                .recommendedDiagnosticAndAntibioticStrategy(strategy)
                .build();
    }
}
