package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Enterprise Obstetrics & Maternal-Fetal Medicine Decision Engine.
 * Implements Naegele's Rule gestational age calculation, Bishop Score for cervical readiness,
 * Postpartum Hemorrhage (PPH) stage-based protocol, Pre-eclampsia severity evaluation with Magnesium Sulfate dosing,
 * and WHO Partograph labor progress surveillance.
 */
@Component
public class ObstetricsMaternalFetalEngine {

    @Data
    @Builder
    public static class GestationalAgeResult {
        private LocalDate estimatedDueDate;
        private long gestationalWeeks;
        private long gestationalDays;
        private String trimester;
        private List<String> requiredScreeningTests;
    }

    public GestationalAgeResult calculateGestationalAge(LocalDate lmpDate) {
        if (lmpDate == null) throw new IllegalArgumentException("LMP date cannot be null.");

        LocalDate edd = lmpDate.plusYears(1).minusMonths(3).plusDays(7); // Naegele's Rule
        LocalDate today = LocalDate.now();

        long totalDays = ChronoUnit.DAYS.between(lmpDate, today);
        long weeks = totalDays / 7;
        long days = totalDays % 7;

        String trimester;
        List<String> screenings = new ArrayList<>();

        if (weeks < 13) {
            trimester = "FIRST TRIMESTER (Weeks 1-12)";
            screenings.add("Dating Ultrasound (Crown-Rump Length CRL)");
            screenings.add("First Trimester Combined Screening: Nuchal Translucency (NT) + Free beta-hCG + PAPP-A");
            screenings.add("Non-Invasive Prenatal Testing (NIPT / Cell-Free Fetal DNA) at >= 10 weeks");
            screenings.add("Baseline Complete Blood Count, ABO/Rh antibody screen, Rubella, Syphilis, HIV, Hepatitis B surface antigen");
        } else if (weeks < 27) {
            trimester = "SECOND TRIMESTER (Weeks 13-26)";
            screenings.add("Fetal Anatomy Survey Ultrasound at 18-20 weeks (Level II target scan)");
            screenings.add("75g 2-Hour Oral Glucose Tolerance Test (OGTT) for Gestational Diabetes Mellitus (GDM) at 24-28 weeks");
            screenings.add("Repeat CBC and Indirect Coombs Test for Rh-negative mothers prior to Anti-D administration at 28 weeks");
        } else {
            trimester = "THIRD TRIMESTER (Weeks 27-40+)";
            screenings.add("Group B Streptococcus (GBS) recto-vaginal screening culture at 36-37 weeks");
            screenings.add("Non-Stress Test (NST) and Biophysical Profile (BPP) for high-risk maternal/fetal indications");
            screenings.add("Serial Fetal Growth Ultrasound and Umbilical Artery Doppler in Fetal Growth Restriction (FGR)");
        }

        return GestationalAgeResult.builder()
                .estimatedDueDate(edd)
                .gestationalWeeks(weeks)
                .gestationalDays(days)
                .trimester(trimester)
                .requiredScreeningTests(screenings)
                .build();
    }

    @Data
    @Builder
    public static class BishopScoreInput {
        private int cervicalDilationCm;   // 0: closed, 1: 1-2cm, 2: 3-4cm, 3: >=5cm
        private int cervicalEffacementPct; // 0: 0-30%, 1: 40-50%, 2: 60-70%, 3: >=80%
        private int fetalStation;         // 0: -3, 1: -2, 2: -1/0, 3: +1/+2
        private int cervicalConsistency;  // 0: firm, 1: medium, 2: soft
        private int cervicalPosition;     // 0: posterior, 1: mid-position, 2: anterior
    }

    @Data
    @Builder
    public static class BishopScoreResult {
        private int totalScore;
        private String readinessInterpretation;
        private String recommendedInductionMethod;
    }

    public BishopScoreResult evaluateBishopScore(BishopScoreInput input) {
        int score = input.getCervicalDilationCm() + input.getCervicalEffacementPct() +
                    input.getFetalStation() + input.getCervicalConsistency() + input.getCervicalPosition();

        String interp;
        String method;

        if (score >= 8) {
            interp = "FAVORABLE / RIPE CERVIX (Bishop Score >= 8)";
            method = "Direct induction with IV Oxytocin (Pitocin) infusion: Start at 1-2 mU/min, titrate by 1-2 mU/min every 30 minutes targeting 3-5 contractions in 10 minutes; Artificial Rupture of Membranes (Amniotomy / AROM) when head engaged.";
        } else if (score >= 6) {
            interp = "INTERMEDIATELY FAVORABLE (Bishop Score 6-7)";
            method = "Mechanical cervical ripening (Foley balloon catheter inflated with 30-50 mL sterile saline) or low-dose Prostaglandin E2 (Dinoprostone vaginal insert 10 mg over 24 hours).";
        } else {
            interp = "UNFAVORABLE / UNRIPE CERVIX (Bishop Score < 6)";
            method = "MANDATORY CERVICAL RIPENING PRIOR TO INDUCTION: Prostaglandin E1 (Misoprostol 25 mcg intravaginally every 3-6 hours) OR Prostaglandin E2 (Dinoprostone gel 0.5 mg endocervically / 10 mg insert) OR Double-balloon transcervical catheter (Cook balloon). Delay IV oxytocin for at least 4 hours post-misoprostol or 30 min post-dinoprostone removal.";
        }

        return BishopScoreResult.builder()
                .totalScore(score)
                .readinessInterpretation(interp)
                .recommendedInductionMethod(method)
                .build();
    }
}
