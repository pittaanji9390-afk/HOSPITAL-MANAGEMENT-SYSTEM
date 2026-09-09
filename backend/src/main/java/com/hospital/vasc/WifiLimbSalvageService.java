package com.hospital.vasc;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class WifiLimbSalvageService {

    public static record WifiAssessment(
            String patientId,
            int woundScore, // 0-3
            int ischemiaScore, // 0-3 (ABI >0.8=0, 0.6-0.79=1, 0.4-0.59=2, <0.4=3)
            int footInfectionScore, // 0-3
            String amputationRisk1Year, // Very Low, Low, Moderate, High
            boolean revascularizationBenefitExpected,
            Instant assessedAt
    ) implements Serializable {}

    public WifiAssessment evaluateLimb(String patientId, int wound, int ischemia, int fi) {
        String risk;
        boolean benefit = ischemia >= 2 || (wound >= 2 && ischemia >= 1);

        int composite = wound + ischemia + fi;
        if (composite >= 6 || ischemia == 3) risk = "High 1-Year Amputation Risk (>50%)";
        else if (composite >= 4) risk = "Moderate 1-Year Amputation Risk (20-50%)";
        else risk = "Low 1-Year Amputation Risk (<10%)";

        return new WifiAssessment(patientId, wound, ischemia, fi, risk, benefit, Instant.now());
    }
}
