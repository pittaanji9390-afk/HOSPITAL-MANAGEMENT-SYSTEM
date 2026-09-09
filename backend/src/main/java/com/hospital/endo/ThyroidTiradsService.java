package com.hospital.endo;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class ThyroidTiradsService {

    public static record TiradsEvaluation(
            String noduleId,
            String patientId,
            int totalPoints,
            String tiradsCategory, // TR1 (0) to TR5 (>=7)
            double noduleSizeCm,
            boolean fnaBiopsyRecommended,
            Instant evaluatedAt
    ) implements Serializable {}

    public TiradsEvaluation evaluateNodule(String noduleId, String patientId, int points, double sizeCm) {
        String cat;
        boolean fna = false;

        if (points >= 7) {
            cat = "TR5: Highly Suspicious";
            fna = sizeCm >= 1.0;
        } else if (points >= 4) {
            cat = "TR4: Moderately Suspicious";
            fna = sizeCm >= 1.5;
        } else if (points == 3) {
            cat = "TR3: Mildly Suspicious";
            fna = sizeCm >= 2.5;
        } else {
            cat = "TR1 / TR2: Benign / Not Suspicious";
        }

        return new TiradsEvaluation(noduleId, patientId, points, cat, sizeCm, fna, Instant.now());
    }
}
