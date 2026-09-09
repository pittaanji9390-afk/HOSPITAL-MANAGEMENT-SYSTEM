package com.hospital.gi;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class MayoScoreService {

    public static record MayoResult(
            String patientId,
            int stoolFrequencyScore, // 0-3
            int rectalBleedingScore, // 0-3
            int endoscopicMucosalScore, // 0-3
            int physicianGlobalScore, // 0-3
            int totalMayoScore, // 0-12
            String diseaseActivityTier,
            String therapeuticAction,
            Instant calculatedAt
    ) implements Serializable {}

    public MayoResult calculateMayo(String patientId, int stool, int bleed, int endo, int pga) {
        int total = stool + bleed + endo + pga;
        String tier;
        String action;

        if (total <= 2 && endo <= 1) {
            tier = "Clinical & Endoscopic Remission";
            action = "Maintain Oral 5-ASA (Mesalamine 2.4 - 4.8 g/day).";
        } else if (total <= 5) {
            tier = "Mildly Active Ulcerative Colitis";
            action = "Optimize 5-ASA + topical rectally administered mesalamine foam.";
        } else if (total <= 10) {
            tier = "Moderately Active Ulcerative Colitis";
            action = "Oral Corticosteroids (Prednisone 40mg taper) + initiate Anti-TNF (Infliximab) / Vedolizumab.";
        } else {
            tier = "Severely Active / Acute Severe Ulcerative Colitis (ASUC)";
            action = "Urgent Inpatient Admission: IV Methylprednisolone 60mg daily + surgical consult on standby.";
        }

        return new MayoResult(patientId, stool, bleed, endo, pga, total, tier, action, Instant.now());
    }
}
