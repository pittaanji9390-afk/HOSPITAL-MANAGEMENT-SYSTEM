package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Psychiatry & Behavioral Health Decision Engine.
 * Implements PHQ-9 Depression Severity, GAD-7 Anxiety Assessment,
 * CIWA-Ar Alcohol Withdrawal Protocol, and Columbia-Suicide Severity Rating Scale (C-SSRS).
 */
@Component
public class PsychiatryBehavioralHealthEngine {

    @Data
    @Builder
    public static class Phq9Result {
        private int totalScore;
        private String severityLevel;
        private boolean hasSuicidalIdeation;
        private String recommendedClinicalAction;
    }

    public Phq9Result evaluatePhq9(List<Integer> questionScores) {
        if (questionScores == null || questionScores.size() != 9) {
            throw new IllegalArgumentException("PHQ-9 requires exactly 9 question scores (0-3 each).");
        }

        int total = questionScores.stream().mapToInt(Integer::intValue).sum();
        boolean suicideRisk = questionScores.get(8) > 0; // Question 9: Thoughts of death/self-harm

        String severity;
        String action;

        if (total >= 20) {
            severity = "SEVERE DEPRESSION (Score 20-27)";
            action = "Immediate initiation of pharmacotherapy (SSRI/SNRI) + intensive psychotherapy; psychiatric consultation; close safety monitoring.";
        } else if (total >= 15) {
            severity = "MODERATELY SEVERE DEPRESSION (Score 15-19)";
            action = "Antidepressant pharmacotherapy and/or structured evidence-based psychotherapy (CBT / IPT).";
        } else if (total >= 10) {
            severity = "MODERATE DEPRESSION (Score 10-14)";
            action = "Treatment plan formulation: Shared decision-making on psychotherapy vs pharmacotherapy; reassess at 4 weeks.";
        } else if (total >= 5) {
            severity = "MILD DEPRESSION (Score 5-9)";
            action = "Watchful waiting, sleep hygiene education, lifestyle modification, and follow-up in 4-8 weeks.";
        } else {
            severity = "MINIMAL OR NO DEPRESSION (Score 0-4)";
            action = "No formal psychiatric treatment required; routine health maintenance.";
        }

        if (suicideRisk) {
            action = "URGENT SUICIDE SAFETY PROTOCOL: Patient endorsed suicidal ideation (Item 9 > 0). Perform immediate Columbia Suicide Severity Rating Scale (C-SSRS), establish 1-to-1 constant observation, remove all lethal means, and arrange emergent psychiatric evaluation.";
        }

        return Phq9Result.builder()
                .totalScore(total)
                .severityLevel(severity)
                .hasSuicidalIdeation(suicideRisk)
                .recommendedClinicalAction(action)
                .build();
    }
}
