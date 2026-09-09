package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class Apache4SeverityPredictor {

    @Data
    @AllArgsConstructor
    public static class Apache4Result {
        private String patientId;
        private int apache4Score;
        private double predictedIcuMortalityPercent;
        private double predictedIcuLosDays;
        private double predictedVentilatorDays;
    }

    public Apache4Result computeApache4(String patientId, int apsPoints, int agePoints, int chronicHealthPoints) {
        int totalScore = apsPoints + agePoints + chronicHealthPoints;
        double mortality = Math.min(95.0, Math.max(2.0, totalScore * 0.65));
        double losDays = Math.min(30.0, Math.max(1.0, totalScore * 0.12));
        double ventDays = Math.min(20.0, Math.max(0.5, totalScore * 0.08));

        return new Apache4Result(patientId, totalScore, mortality, losDays, ventDays);
    }
}
