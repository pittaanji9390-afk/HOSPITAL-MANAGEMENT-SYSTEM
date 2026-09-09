package com.hospital.perinatal.pph;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

/**
 * CMQCC Postpartum Hemorrhage (PPH) Stage 0 to Stage 3 Protocol & Quantitative Blood Loss (QBL) Engine
 * Implements gravimetric QBL weighing and multi-agent uterotonic algorithms (Oxytocin, Methergine, Hemabate, Cytotec, TXA).
 */
@Service
public class PostpartumHemorrhageService {

    public enum PphStage {
        STAGE_0_PREVENT("Stage 0: Normal Delivery / Prophylaxis (All patients receive active management of 3rd stage)"),
        STAGE_1_MILD("Stage 1: QBL >= 500 mL vaginal / >= 1000 mL cesarean OR HR > 110, SBP < 85"),
        STAGE_2_MODERATE("Stage 2: Continued bleeding / QBL 1000 - 1500 mL or unresolved Stage 1 with 2 uterotonics"),
        STAGE_3_CRITICAL("Stage 3: QBL > 1500 mL OR abnormal vitals / suspected DIC / MTP Massive Transfusion activation");

        private final String description;
        PphStage(String description) { this.description = description; }
        public String getDescription() { return description; }
    }

    public static record PphEvaluation(
            String caseId,
            String patientId,
            double quantitativeBloodLossMl,
            int heartRateBpm,
            int systolicBpMmHg,
            int diastolicBpMmHg,
            PphStage stage,
            List<String> activeUterotonics,
            boolean tranexamicAcidIndicated, // 1g TXA IV over 10m within 3 hours of birth (WOMAN trial)
            boolean massiveTransfusionActivated,
            String teamActionPlan,
            Instant evaluatedAt
    ) implements Serializable {}

    public PphEvaluation evaluatePph(
            String caseId,
            String patientId,
            double qblMl,
            int hr,
            int sbp,
            int dbp,
            boolean asthmaHistory,
            boolean hypertensionHistory
    ) {
        PphStage stage;
        List<String> meds = new ArrayList<>();
        boolean txa = false;
        boolean mtp = false;
        StringBuilder plan = new StringBuilder();

        if (qblMl > 1500.0 || sbp < 70 || (hr > 120 && sbp < 80)) {
            stage = PphStage.STAGE_3_CRITICAL;
            mtp = true;
            txa = true;
            plan.append("STAGE 3 CODE OB HEMORRHAGE: Activate Massive Transfusion Protocol (4:4:1 RBC:FFP:Platelets). Call Gynecologic Oncology / Trauma surgery backup. Move to OR for Bakri Balloon, B-Lynch suture, uterine artery embolization (UAE), or hysterectomy. Maintain normothermia and calcium replacement.");
        } else if (qblMl >= 1000.0 || (hr > 110 && sbp < 85)) {
            stage = PphStage.STAGE_2_MODERATE;
            txa = true;
            plan.append("STAGE 2 HEMORRHAGE: Rapid Response OB Team to bedside. Second large bore IV (16/18G). Stat Type & Cross 2-4 units PRBCs. Intrauterine tamponade balloon (Bakri 300-500 mL saline) or Jada vacuum-induced suction device.");
        } else if (qblMl >= 500.0 || hr > 100 || sbp < 90) {
            stage = PphStage.STAGE_1_MILD;
            plan.append("STAGE 1 HEMORRHAGE: Primary nurse notifies OB provider. Vigorously massage fundus. Empty bladder with Foley catheter. Weigh all pads/drapes for exact QBL.");
        } else {
            stage = PphStage.STAGE_0_PREVENT;
            plan.append("STAGE 0: Routine Active Management of Third Stage of Labor (AMTSL) - Oxytocin 20-30 units in 1000 mL crystalloid at 334 mL/hr, gentle cord traction.");
        }

        // Uterotonic Selection Matrix
        meds.add("Oxytocin (Pitocin) 30 units in 500 mL IV rapid infusion or 10 units IM");
        if (stage != PphStage.STAGE_0_PREVENT) {
            if (!hypertensionHistory) {
                meds.add("Methylergonovine (Methergine) 0.2 mg IM (Contraindicated if HTN/Preeclampsia)");
            }
            if (!asthmaHistory) {
                meds.add("Carboprost Tromethamine (Hemabate) 250 mcg IM/intramyometrial (Contraindicated if Asthma)");
            }
            meds.add("Misoprostol (Cytotec) 800 - 1000 mcg buccal/sublingual/rectal");
            if (txa) {
                meds.add("Tranexamic Acid (TXA) 1 g IV over 10 min (WOMAN Trial: Reduces mortality if given <3h from birth)");
            }
        }

        return new PphEvaluation(
                caseId,
                patientId,
                round(qblMl, 1),
                hr,
                sbp,
                dbp,
                stage,
                meds,
                txa,
                mtp,
                plan.toString(),
                Instant.now()
        );
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
