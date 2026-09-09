package com.hospital.perinatal.gdm;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * Gestational Diabetes Mellitus (GDM) Diagnostic Engine
 * Supports 2-Step Screening (50g 1-hour screen + 100g 3-hour Carpenter-Coustan OGTT) and 1-Step 75g IADPSG criteria.
 */
@Service
public class GestationalDiabetesService {

    public static record GdmDiagnosticResult(
            String patientId,
            int gestationalAgeWeeks,
            double oneHour50gScreenMgDl, // Cutoff >= 135-140 mg/dL prompts 100g test
            double fastingOgttMgDl, // Carpenter-Coustan: 95 mg/dL
            double oneHourOgttMgDl, // 180 mg/dL
            double twoHourOgttMgDl, // 155 mg/dL
            double threeHourOgttMgDl, // 140 mg/dL
            int abnormalValuesCount,
            boolean gdmDiagnosed,
            String glycemicManagementPlan,
            Instant evaluatedAt
    ) implements Serializable {}

    public GdmDiagnosticResult evaluateTwoStepOgtt(
            String patientId,
            int gaWeeks,
            double screen50g,
            double fasting,
            double oneHr,
            double twoHr,
            double threeHr
    ) {
        int abnormalCount = 0;
        if (fasting >= 95.0) abnormalCount++;
        if (oneHr >= 180.0) abnormalCount++;
        if (twoHr >= 155.0) abnormalCount++;
        if (threeHr >= 140.0) abnormalCount++;

        // ACOG 2-step diagnosis: >= 2 abnormal values on 100g 3-hour OGTT (or initial 50g screen >= 200 mg/dL)
        boolean diagnosed = abnormalCount >= 2 || screen50g >= 200.0;

        StringBuilder plan = new StringBuilder();
        if (diagnosed) {
            plan.append("GDM DIAGNOSED: Initiate Medical Nutrition Therapy (MNT), carb-controlled meal planning (3 meals + 3 snacks), and 30 min daily walking. ")
                .append("Capillary Blood Glucose targets: Fasting < 95 mg/dL, 1-hour postprandial < 140 mg/dL, 2-hour postprandial < 120 mg/dL. ")
                .append("Initiate Insulin (Lispro/NPH) if >30% values above target despite diet.");
        } else if (abnormalCount == 1) {
            plan.append("SINGLE ABNORMAL VALUE: Repeat OGTT in 4 weeks or initiate home blood glucose testing; increased risk of macrosomia.");
        } else {
            plan.append("NORMAL GLUCOSE TOLERANCE: Routine prenatal dietary counseling.");
        }

        return new GdmDiagnosticResult(
                patientId,
                gaWeeks,
                screen50g,
                fasting,
                oneHr,
                twoHr,
                threeHr,
                abnormalCount,
                diagnosed,
                plan.toString(),
                Instant.now()
        );
    }
}
