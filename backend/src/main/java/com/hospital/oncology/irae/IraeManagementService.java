package com.hospital.oncology.irae;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * ASCO / NCCN Immune-Related Adverse Events (irAE) CTCAE v5.0 Management System.
 * Grades toxicity for Anti-PD-1 (Pembrolizumab, Nivolumab) and Anti-CTLA-4 (Ipilimumab) therapies:
 * Immune-mediated Colitis, Pneumonitis, Hepatitis, Hypophysitis, and Myocarditis.
 */
@Service
public class IraeManagementService {

    public enum OrganToxicity { COLITIS, PNEUMONITIS, HEPATITIS, HYPOPHYSITIS, MYOCARDITIS }
    public record IraeAssessment(OrganToxicity organ, int ctcaeGrade, boolean holdCheckpointInhibitor, boolean permanentlyDiscontinue, String mandatedCorticosteroidDose, String secondLineBiologic) {}

    public IraeAssessment gradeIrae(OrganToxicity organ, int grade) {
        boolean hold = grade >= 2;
        boolean permanentStop = grade >= 3 || (organ == OrganToxicity.MYOCARDITIS && grade >= 2) || (organ == OrganToxicity.PNEUMONITIS && grade >= 3);
        
        String steroids;
        String biologic = "None";

        if (grade == 1) {
            steroids = "Symptomatic treatment; close clinical observation without systemic steroids.";
        } else if (grade == 2) {
            steroids = "Prednisone / Methylprednisolone 0.5 - 1.0 mg/kg/day PO/IV tapered over >= 4-6 weeks.";
        } else {
            steroids = "High-Dose Methylprednisolone 1.0 - 2.0 mg/kg/day IV. Hospital admission mandatory.";
            if (organ == OrganToxicity.COLITIS) {
                biologic = "Infliximab 5 mg/kg or Vedolizumab (if refractory to steroids after 48-72 hrs).";
            } else if (organ == OrganToxicity.HEPATITIS) {
                biologic = "Mycophenolate Mofetil (MMF) 1000mg BID (Avoid Infliximab due to hepatic risk).";
            }
        }

        return new IraeAssessment(organ, grade, hold, permanentStop, steroids, biologic);
    }
}
