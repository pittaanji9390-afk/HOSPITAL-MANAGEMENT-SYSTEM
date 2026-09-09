package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class GraceAcsMortalityCalculator {

    @Data
    @AllArgsConstructor
    public static class GraceResult {
        private String patientId;
        private int graceScore;
        private double inHospitalMortalityPercent;
        private String clinicalRecommendation;
    }

    public GraceResult computeGrace(String patientId, int age, double hr, double sbp, double crMgDl, int killipClass, boolean cardiacArrestAtAdmission, boolean stSegmentDeviation, boolean elevatedEnzymes) {
        int score = 50;
        if (age >= 70) score += 40;
        if (hr >= 100) score += 20;
        if (sbp < 100) score += 25;
        if (crMgDl >= 2.0) score += 20;
        score += (killipClass - 1) * 20;
        if (cardiacArrestAtAdmission) score += 39;
        if (stSegmentDeviation) score += 28;
        if (elevatedEnzymes) score += 14;

        double mortality = score > 140 ? 12.5 : score > 109 ? 4.2 : 1.1;
        String rec = score > 140 ? "Urgent Invasive Coronary Angiography within 24h" : "Early Invasive Strategy within 72h";

        return new GraceResult(patientId, score, mortality, rec);
    }
}
