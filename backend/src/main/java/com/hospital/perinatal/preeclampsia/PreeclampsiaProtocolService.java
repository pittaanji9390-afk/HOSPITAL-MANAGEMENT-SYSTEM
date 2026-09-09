package com.hospital.perinatal.preeclampsia;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * ACOG Preeclampsia with Severe Features & Magnesium Sulfate Protocol Service
 * Evaluates severe blood pressure thresholds (SBP >= 160 or DBP >= 110), end-organ symptoms,
 * and manages MgSO4 loading (4-6g IV) and maintenance (1-2g/hr) with Calcium Gluconate antidote ready.
 */
@Service
public class PreeclampsiaProtocolService {

    public static record PreeclampsiaEvaluation(
            String patientId,
            int gestationalAgeWeeks,
            int systolicBp,
            int diastolicBp,
            boolean persistentHeadache,
            boolean visualDisturbances,
            boolean epigastricRightUpperQuadrantPain,
            double plateletCountPerUl,
            double serumCreatinineMgDl,
            double astAltU_L,
            boolean severeFeaturesPresent,
            String antihypertensiveEmergentOrder, // Hydralazine, Labetalol, Nifedipine
            String magnesiumSulfateProtocol,
            String deliveryTimingRecommendation,
            Instant evaluatedAt
    ) implements Serializable {}

    public PreeclampsiaEvaluation evaluatePreeclampsia(
            String patientId,
            int gaWeeks,
            int sbp,
            int dbp,
            boolean headache,
            boolean visual,
            boolean ruqPain,
            double platelets,
            double scr,
            double ast
    ) {
        boolean severeBp = sbp >= 160 || dbp >= 110;
        boolean thrombocytopenia = platelets < 100000;
        boolean renalImpairment = scr > 1.1;
        boolean hepaticImpairment = ast > 70; // 2x upper limit

        boolean severe = severeBp || headache || visual || ruqPain || thrombocytopenia || renalImpairment || hepaticImpairment;

        StringBuilder antihypertensive = new StringBuilder();
        if (severeBp) {
            antihypertensive.append("EMERGENT ANTIHYPERTENSIVE PROTOCOL (Target SBP 140-150, DBP 90-100 within 30-60 min): ")
                           .append("1st line: Labetalol 20 mg IV over 2 min (repeat with 40mg, then 80mg q10m max 220mg) OR ")
                           .append("Hydralazine 5-10 mg IV over 2 min OR Nifedipine 10-20 mg PO immediate-release.");
        } else {
            antihypertensive.append("Blood pressure below emergent hypertensive crisis threshold; monitor q15-30m.");
        }

        StringBuilder mgProtocol = new StringBuilder();
        if (severe) {
            mgProtocol.append("MAGNESIUM SULFATE SEIZURE PROPHYLAXIS: 4-6 g IV loading dose in 100 mL over 20 min, followed by 1-2 g/hr continuous maintenance IV infusion. ")
                      .append("Monitor patellar reflexes, respiratory rate (>12/min), and urine output (>30 mL/hr). ")
                      .append("ANTIDOTE AT BEDSIDE: Calcium Gluconate 1 g (10 mL of 10% solution) IV over 3-5 min for Mg toxicity.");
        } else {
            mgProtocol.append("Magnesium sulfate not indicated for non-severe preeclampsia unless intrapartum labor progression.");
        }

        StringBuilder delivery = new StringBuilder();
        if (severe) {
            if (gaWeeks >= 34) {
                delivery.append("Delivery indicated upon maternal stabilization (GA >= 34 weeks).");
            } else {
                delivery.append("Inpatient expectant management at Level III/IV Maternal Center if GA < 34 weeks with reassuring maternal-fetal status; administer Betamethasone 12mg IM q24h x 2.");
            }
        } else {
            delivery.append("Delivery recommended at 37 0/7 weeks of gestation.");
        }

        return new PreeclampsiaEvaluation(
                patientId,
                gaWeeks,
                sbp,
                dbp,
                headache,
                visual,
                ruqPain,
                platelets,
                scr,
                ast,
                severe,
                antihypertensive.toString(),
                mgProtocol.toString(),
                delivery.toString(),
                Instant.now()
        );
    }
}
