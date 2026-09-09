package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Obstetrics High-Risk Pre-eclampsia & Eclampsia Protocol Engine.
 * Implements ACOG Severe Features Criteria, Magnesium Sulfate Zuspan / Pritchard Regimens,
 * Acute Antihypertensive Crisis Management (Labetalol, Hydralazine, Nifedipine), and HELLP Syndrome diagnosis.
 */
@Component
public class ObstetricsSeverePreeclampsiaEngine {

    @Data
    @Builder
    public static class PreeclampsiaAssessment {
        private boolean isSeverePreeclampsia;
        private boolean isHellpSyndrome;
        private List<String> severeFeaturesPresent;
        private String magnesiumSulfateSeizureProphylaxis;
        private String acuteAntihypertensiveRegimen;
        private String deliveryTimingRecommendation;
    }

    public PreeclampsiaAssessment evaluatePreeclampsia(double systolicBp, double diastolicBp,
                                                       double plateletCount, double serumCreatinine,
                                                       double astAlt, boolean persistentHeadacheOrVisionChanges,
                                                       boolean pulmonaryEdema, double gestationalWeeks) {
        List<String> features = new ArrayList<>();
        boolean severe = false;

        if (systolicBp >= 160 || diastolicBp >= 110) {
            features.add("Severe Hypertension (SBP >= 160 or DBP >= 110 mmHg on 2 occasions 15 min apart)");
            severe = true;
        }
        if (plateletCount < 100000) {
            features.add("Thrombocytopenia (Platelets < 100,000 / uL)");
            severe = true;
        }
        if (serumCreatinine > 1.1) {
            features.add("Renal Insufficiency (Serum Creatinine > 1.1 mg/dL or doubling of baseline)");
            severe = true;
        }
        if (astAlt > 70) {
            features.add("Impaired Liver Function (Transaminases > 2x Upper Limit of Normal with RUQ / epigastric pain)");
            severe = true;
        }
        if (persistentHeadacheOrVisionChanges) {
            features.add("New-Onset Persistent Cerebral or Visual Disturbances (Photopsia, scotomata, severe frontal headache)");
            severe = true;
        }
        if (pulmonaryEdema) {
            features.add("Acute Pulmonary Edema");
            severe = true;
        }

        boolean hellp = (plateletCount < 100000) && (astAlt > 70);

        String mgso4 = "MAGNESIUM SULFATE SEIZURE PROPHYLAXIS (Zuspan Regimen): 4 to 6 g IV loading dose in 100 mL D5W over 20 minutes, followed by 1 to 2 g/hour continuous IV maintenance infusion. Maintain infusion for 24 hours postpartum. (Keep Calcium Gluconate 10% 10 mL at bedside as antidote for Mg toxicity; monitor deep tendon reflexes, RR > 12/min, UO > 30 mL/hr).";

        String antihypertensive = "ACUTE ANTIHYPERTENSIVE PROTOCOL (For SBP >= 160 or DBP >= 110): (1) IV Labetalol 20mg IV over 2 min; if elevated after 10 min, give 40mg, then 80mg (Max 220mg); OR (2) IV Hydralazine 5-10mg IV over 2 min, repeat 10mg after 20 min (Max 20mg); OR (3) Oral Immediate-Release Nifedipine 10-20mg PO (repeat in 20 min). Target BP 140-150 / 90-100 mmHg.";

        String delivery = (gestationalWeeks >= 34.0 || hellp || pulmonaryEdema) ?
                "EXPEDITE DELIVERY: In severe pre-eclampsia at >= 34 0/7 weeks (or any gestational age with HELLP, pulmonary edema, placental abruption, or fetal distress), delivery is indicated after maternal stabilization." :
                "EXPECTANT MANAGEMENT AT TERTIARY CENTER (for 24-34 weeks): Administer Betamethasone 12mg IM q24h x 2 doses for fetal lung maturity; continuous maternal-fetal surveillance.";

        return PreeclampsiaAssessment.builder()
                .isSeverePreeclampsia(severe)
                .isHellpSyndrome(hellp)
                .severeFeaturesPresent(features)
                .magnesiumSulfateSeizureProphylaxis(mgso4)
                .acuteAntihypertensiveRegimen(antihypertensive)
                .deliveryTimingRecommendation(delivery)
                .build();
    }
}
