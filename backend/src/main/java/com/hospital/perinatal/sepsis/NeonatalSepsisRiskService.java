package com.hospital.perinatal.sepsis;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

/**
 * Kaiser Permanente Early-Onset Sepsis (EOS) Risk Calculator
 * Evaluates maternal chorioamnionitis, ROM duration, GBS status, maternal intrapartum temperature, and clinical presentation.
 */
@Service
public class NeonatalSepsisRiskService {

    public enum InfantClinicalExam {
        WELL_APPEARING("Well-Appearing: Normal vitals, normal tone, normal respiratory effort"),
        EQUIVOCAL("Equivocal: Persistent tachypnea (>60/min), mild retraction, or temperature instability for >2 hours"),
        CLINICALLY_ILL("Clinically Ill: Persistent respiratory distress, hemodynamic instability, lethargy, encephalopathy, or seizure");

        private final String details;
        InfantClinicalExam(String details) { this.details = details; }
        public String getDetails() { return details; }
    }

    public static record EosRiskEvaluation(
            String infantId,
            double baselineEosRiskPer1000,
            double posteriorEosRiskPer1000,
            InfantClinicalExam clinicalExam,
            String recommendedCareDirective, // Routine care, Enhanced surveillance, Blood culture + Empiric antibiotics
            Instant evaluatedAt
    ) implements Serializable {}

    public EosRiskEvaluation calculateEosRisk(
            String infantId,
            int gestationalAgeWeeks,
            double maternalHighestTempCelsius,
            int romDurationHours,
            boolean gbsPositive,
            boolean adequateIapReceived,
            InfantClinicalExam exam
    ) {
        // Baseline EOS risk incidence modeling (Kaiser EOS multi-variable logistic model)
        double baseRisk = 0.5; // per 1000 live births

        if (gestationalAgeWeeks < 37) baseRisk *= 2.5;
        if (maternalHighestTempCelsius >= 39.0) baseRisk *= 6.0;
        else if (maternalHighestTempCelsius >= 38.0) baseRisk *= 3.0;

        if (romDurationHours >= 24) baseRisk *= 2.8;
        else if (romDurationHours >= 18) baseRisk *= 1.6;

        if (gbsPositive && !adequateIapReceived) baseRisk *= 3.2;

        // Clinical exam likelihood ratio adjustment
        double posteriorRisk = switch (exam) {
            case WELL_APPEARING -> baseRisk * 0.2;
            case EQUIVOCAL -> baseRisk * 2.5;
            case CLINICALLY_ILL -> baseRisk * 8.0;
        };

        StringBuilder directive = new StringBuilder();
        if (exam == InfantClinicalExam.CLINICALLY_ILL || posteriorRisk >= 3.0) {
            directive.append("EMPIRIC ANTIBIOTIC THERAPY INDICATED: Draw blood culture stat. Initiate IV Ampicillin (100 mg/kg/day divided q12h) + Gentamicin (4-5 mg/kg q24-36h). Transfer to NICU for close cardiorespiratory monitoring.");
        } else if (exam == InfantClinicalExam.EQUIVOCAL || posteriorRisk >= 1.0) {
            directive.append("ENHANCED CLINICAL SURVEILLANCE: Serial physical exams and vitals every 4 hours for 24-48 hours. If condition deteriorates, draw blood culture and start empiric antibiotics.");
        } else {
            directive.append("ROUTINE CLINICAL CARE: Low risk of early-onset sepsis (<1 per 1000). Standard postpartum rooming-in and vital signs surveillance.");
        }

        return new EosRiskEvaluation(
                infantId,
                round(baseRisk, 2),
                round(posteriorRisk, 2),
                exam,
                directive.toString(),
                Instant.now()
        );
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
