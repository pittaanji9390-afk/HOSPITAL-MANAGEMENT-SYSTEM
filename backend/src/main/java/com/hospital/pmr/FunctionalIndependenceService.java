package com.hospital.pmr;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class FunctionalIndependenceService {

    public static record FimAssessment(
            String assessmentId,
            String patientId,
            int motorFimScore, // 13-91
            int cognitiveFimScore, // 5-35
            int totalFimScore, // 18-126
            int bergBalanceScore, // 0-56 (<45 indicates fall risk)
            String dischargePlacementPrediction,
            Instant assessedAt
    ) implements Serializable {}

    public FimAssessment evaluatePatient(String id, String patientId, int motor, int cognitive, int berg) {
        int total = motor + cognitive;
        String placement = total >= 80 && berg >= 45
                ? "Community / Home with Outpatient Physical Therapy"
                : total >= 50
                ? "Subacute Inpatient Rehabilitation Facility (IRF - 3 hours therapy/day)"
                : "Long-Term Acute Care / Skilled Nursing Facility (SNF)";

        return new FimAssessment(id, patientId, motor, cognitive, total, berg, placement, Instant.now());
    }
}
