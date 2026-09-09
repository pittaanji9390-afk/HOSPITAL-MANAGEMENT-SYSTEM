package com.hospital.perinatal.efm;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * ACOG / NICHD Electronic Fetal Monitoring (EFM) Cardiotocography Classifier
 * Categorizes intrapartum fetal heart rate (FHR) strips into Category I (Normal), Category II (Indeterminate), or Category III (Abnormal).
 */
@Service
public class ElectronicFetalMonitoringService {

    public enum EfmCategory {
        CATEGORY_I_NORMAL("Category I: Strongly predictive of normal fetal acid-base status; routine care"),
        CATEGORY_II_INDETERMINATE("Category II: Not predictive of abnormal acid-base status; warrants continuous evaluation & intrauterine resuscitation"),
        CATEGORY_III_ABNORMAL("Category III: Predictive of abnormal fetal acid-base status; warrants immediate delivery / emergency operative intervention");

        private final String summary;
        EfmCategory(String summary) { this.summary = summary; }
        public String getSummary() { return summary; }
    }

    public enum FhrVariability {
        ABSENT("Absent (Amplitude range undetectable)"),
        MINIMAL("Minimal (Amplitude range > undetectable to <= 5 bpm)"),
        MODERATE("Moderate (Amplitude range 6 to 25 bpm - Normal)"),
        MARKED("Marked (Amplitude range > 25 bpm)");

        private final String description;
        FhrVariability(String description) { this.description = description; }
        public String getDescription() { return description; }
    }

    public static record EfmClassificationResult(
            String stripId,
            String patientId,
            int baselineFhrBpm,
            FhrVariability variability,
            boolean accelerationsPresent,
            boolean lateDecelerationsPresent,
            boolean recurrentVariableDecelerationsPresent,
            boolean sinusoidalPattern,
            boolean prolongedDeceleration,
            EfmCategory category,
            String intrauterineResuscitationProtocol,
            String obstetricActionPlan,
            Instant evaluatedAt
    ) implements Serializable {}

    public EfmClassificationResult classifyEfmStrip(
            String stripId,
            String patientId,
            int baselineBpm,
            FhrVariability variability,
            boolean accelerations,
            boolean lateDecels,
            boolean recurrentVariables,
            boolean sinusoidal,
            boolean prolongedDecel
    ) {
        EfmCategory category;
        StringBuilder resuscitation = new StringBuilder();
        StringBuilder action = new StringBuilder();

        // Check for Category III criteria:
        // 1. Sinusoidal pattern OR
        // 2. Absent variability with recurrent lates, recurrent variables, or bradycardia (<110 bpm)
        if (sinusoidal || (variability == FhrVariability.ABSENT && (lateDecels || recurrentVariables || baselineBpm < 110))) {
            category = EfmCategory.CATEGORY_III_ABNORMAL;
            resuscitation.append("IMMEDIATE INTRAUTERINE RESUSCITATION: Maternal repositioning (left lateral decubitus), IV fluid bolus (500-1000 mL Lactated Ringer's), discontinue Oxytocin, O2 by non-rebreather at 10 L/min, Terbutaline 0.25mg SC if tachysystole. ");
            action.append("OBSTETRIC EMERGENCY: Category III pattern indicates progressive fetal hypoxemia/acidemia. Prepare OR for emergent Cesarean delivery if not resolved within 10-15 minutes.");
        }
        // Check for Category I criteria:
        // Baseline 110-160, Moderate variability, Absent late/variable decels, Accelerations present or absent, Early decels present or absent
        else if (baselineBpm >= 110 && baselineBpm <= 160 && variability == FhrVariability.MODERATE && !lateDecels && !recurrentVariables && !prolongedDecel) {
            category = EfmCategory.CATEGORY_I_NORMAL;
            resuscitation.append("No active resuscitation needed. Maintain supportive labor care.");
            action.append("Category I (Normal). Continue routine labor management and intermittent or continuous CTG surveillance.");
        }
        // Otherwise, Category II (Indeterminate)
        else {
            category = EfmCategory.CATEGORY_II_INDETERMINATE;
            resuscitation.append("Initiate intrauterine resuscitation measures: Maternal repositioning, IV fluid bolus, stop/reduce uterotonic infusion, evaluate for cervical change/cord prolapse.");
            action.append("Category II (Indeterminate). Requires continuous fetal heart rate monitoring, bedside assessment, and escalation if persistent recurrent decelerations occur.");
        }

        return new EfmClassificationResult(
                stripId,
                patientId,
                baselineBpm,
                variability,
                accelerations,
                lateDecels,
                recurrentVariables,
                sinusoidal,
                prolongedDecel,
                category,
                resuscitation.toString(),
                action.toString(),
                Instant.now()
        );
    }
}
