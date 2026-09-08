package com.hospital.analytics.ml;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class DvtPaduaCapriniVteRiskCalculator {

    @Data
    @AllArgsConstructor
    public static class VteRiskResult {
        private String patientId;
        private int paduaScore;
        private boolean isHighVteRiskPadua;
        private String recommendedProphylaxis;
    }

    public VteRiskResult calculatePadua(String patientId, boolean activeCancer, boolean previousVte, boolean reducedMobility, boolean knownThrombophilia, boolean recentTraumaOrSurgery, int age) {
        int score = 0;
        if (activeCancer) score += 3;
        if (previousVte) score += 3;
        if (reducedMobility) score += 3;
        if (knownThrombophilia) score += 3;
        if (recentTraumaOrSurgery) score += 2;
        if (age >= 70) score += 1;

        boolean highRisk = score >= 4;
        String rx = highRisk ? "Enoxaparin 40 mg SubQ Daily + Sequential Compression Devices (SCDs)" : "Early Ambulation + Hydration";

        return new VteRiskResult(patientId, score, highRisk, rx);
    }
}
