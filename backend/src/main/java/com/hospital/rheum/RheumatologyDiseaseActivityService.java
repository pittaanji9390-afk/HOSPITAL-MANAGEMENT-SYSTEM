package com.hospital.rheum;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class RheumatologyDiseaseActivityService {

    public static record Das28Result(
            String assessmentId,
            String patientId,
            int tenderJointCount28,
            int swollenJointCount28,
            double crpMgL,
            int patientGlobalAssessment0To100,
            double das28CrpScore,
            String diseaseActivityCategory, // Remission (<2.6), Low (2.6-3.2), Moderate (3.2-5.1), High (>5.1)
            String biologicRecommendation,
            Instant evaluatedAt
    ) implements Serializable {}

    public Das28Result calculateDas28(String id, String patientId, int tjc, int sjc, double crp, int pga) {
        // DAS28-CRP = 0.56*sqrt(TJC28) + 0.28*sqrt(SJC28) + 0.36*ln(CRP + 1) + 0.014*PGA + 0.96
        double score = 0.56 * Math.sqrt(tjc) + 0.28 * Math.sqrt(sjc) + 0.36 * Math.log(crp + 1.0) + 0.014 * pga + 0.96;
        score = Math.round(score * 100.0) / 100.0;

        String cat;
        String bio;
        if (score < 2.6) {
            cat = "Clinical Remission (DAS28 < 2.6)";
            bio = "Maintain current conventional synthetic DMARD (csDMARD - Methotrexate).";
        } else if (score <= 3.2) {
            cat = "Low Disease Activity (2.6 - 3.2)";
            bio = "Optimize csDMARD titration.";
        } else if (score <= 5.1) {
            cat = "Moderate Disease Activity (3.2 - 5.1)";
            bio = "Consider escalation to TNF inhibitor (Adalimumab / Etanercept) or JAK inhibitor.";
        } else {
            cat = "High Disease Activity (> 5.1)";
            bio = "Initiate targeted biologic DMARD (bDMARD) / JAK inhibitor + bridge steroid.";
        }

        return new Das28Result(id, patientId, tjc, sjc, crp, pga, score, cat, bio, Instant.now());
    }
}
