package com.hospital.cathlab.coronary;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

/**
 * TIMI Flow Grade and Myocardial Blush Grade (MBG) Perfusion Engine
 * Compliant with ACC/AHA and ESC PCI Guidelines for STEMI/NSTEMI revascularization.
 */
@Service
public class TimiFlowGradeService {

    public enum TimiFlowGrade {
        TIMI_0_NO_PERFUSION("TIMI 0: Complete absence of any antegrade flow beyond a coronary occlusion"),
        TIMI_1_FAINT_PERFUSION("TIMI 1: Faint antegrade flow beyond occlusion; contrast fails to opacify entire bed"),
        TIMI_2_DELAYED_PERFUSION("TIMI 2: Delayed/sluggish filling and clearing of the entire distal coronary artery bed"),
        TIMI_3_NORMAL_PERFUSION("TIMI 3: Normal, brisk antegrade filling and clearing comparable to non-culprit vessels");

        private final String description;
        TimiFlowGrade(String description) { this.description = description; }
        public String getDescription() { return description; }
    }

    public enum MyocardialBlushGrade {
        MBG_0_NO_BLUSH("MBG 0: No myocardial blush or ground-glass opacification (severe microvascular obstruction/no-reflow)"),
        MBG_1_MINIMAL_BLUSH("MBG 1: Minimal myocardial blush present"),
        MBG_2_MODERATE_BLUSH("MBG 2: Moderate blush present, but less dense or clearing slower than normal zone"),
        MBG_3_NORMAL_BLUSH("MBG 3: Normal myocardial blush with brisk entry and clearing (optimal microvascular reperfusion)");

        private final String description;
        MyocardialBlushGrade(String description) { this.description = description; }
        public String getDescription() { return description; }
    }

    public static record TimiPerfusionAssessment(
            String procedureId,
            String patientId,
            String culpritVessel,
            TimiFlowGrade baselineTimi,
            TimiFlowGrade postPciTimi,
            MyocardialBlushGrade postPciMbg,
            int correctedTimiFrameCount,
            boolean noReflowPhenomenon,
            String pharmacologicalIntervention,
            String clinicalRecommendation,
            Instant assessmentTimestamp
    ) implements Serializable {}

    public TimiPerfusionAssessment evaluateRevascularization(
            String procedureId,
            String patientId,
            String vessel,
            TimiFlowGrade preTimi,
            TimiFlowGrade postTimi,
            MyocardialBlushGrade postMbg,
            int rawFrameCount
    ) {
        int ctfc = "LAD".equalsIgnoreCase(vessel) 
                ? (int) Math.round(rawFrameCount / 1.7) 
                : rawFrameCount;

        boolean noReflow = (postTimi == TimiFlowGrade.TIMI_0_NO_PERFUSION || postTimi == TimiFlowGrade.TIMI_1_FAINT_PERFUSION || postMbg == MyocardialBlushGrade.MBG_0_NO_BLUSH)
                && preTimi != TimiFlowGrade.TIMI_3_NORMAL_PERFUSION;

        StringBuilder rx = new StringBuilder();
        StringBuilder rec = new StringBuilder();

        if (noReflow) {
            rx.append("Intracoronary Adenosine (50-200 mcg bolus) + Nicardipine (200 mcg) or Sodium Nitroprusside (100-200 mcg); avoid distal embolization.");
            rec.append("WARNING: Acute No-Reflow / Slow-Flow detected. Verify absence of flow-limiting dissection, stent thrombosis, or spasm. Maintain MAP > 70 mmHg.");
        } else if (postTimi == TimiFlowGrade.TIMI_3_NORMAL_PERFUSION && postMbg == MyocardialBlushGrade.MBG_3_NORMAL_BLUSH) {
            rx.append("Standard DAPT (Aspirin + Ticagrelor 90mg BID or Prasugrel 10mg daily) + High-intensity Statin.");
            rec.append("Optimal epicardial (TIMI 3) and microvascular (MBG 3) reperfusion achieved. Corrected TIMI frame count: ").append(ctfc).append(" frames.");
        } else {
            rx.append("Optimize intracoronary vasodilators; consider GP IIb/IIIa inhibitor (Tirofiban / Eptifibatide) if high thrombus burden.");
            rec.append("Suboptimal blush grade (MBG ").append(postMbg).append("). Monitor for reperfusion injury and post-PCI troponin elevation.");
        }

        return new TimiPerfusionAssessment(
                procedureId,
                patientId,
                vessel,
                preTimi,
                postTimi,
                postMbg,
                ctfc,
                noReflow,
                rx.toString(),
                rec.toString(),
                Instant.now()
        );
    }
}
