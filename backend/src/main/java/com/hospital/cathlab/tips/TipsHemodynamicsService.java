package com.hospital.cathlab.tips;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class TipsHemodynamicsService {

    public static record TipsProcedureLog(
            String procedureId,
            String patientId,
            double prePortalPressureMmHg,
            double preRightAtrialPressureMmHg,
            double prePsgMmHg,
            double postPortalPressureMmHg,
            double postRightAtrialPressureMmHg,
            double postPsgMmHg,
            int stentDiameterMm,
            boolean targetPsgAchieved,
            String encephalopathyRiskTier,
            String clinicalRecommendation,
            Instant recordedAt
    ) implements Serializable {}

    public TipsProcedureLog evaluateTipsGradient(
            String procId,
            String patientId,
            double prePortal,
            double preRa,
            double postPortal,
            double postRa,
            int stentDiamMm,
            int patientAge,
            double baselineTotalBilirubinMgDl,
            double baselineInr
    ) {
        double prePsg = prePortal - preRa;
        double postPsg = postPortal - postRa;

        boolean success = postPsg < 12.0 || postPsg <= (prePsg * 0.5);

        String heRisk;
        if (stentDiamMm >= 10 && (patientAge > 65 || baselineTotalBilirubinMgDl > 3.0 || postPsg < 8.0)) {
            heRisk = "High Risk for Post-TIPS Hepatic Encephalopathy (Over-shunting / Low PSG < 8 mmHg)";
        } else if (stentDiamMm >= 10 || patientAge > 60) {
            heRisk = "Moderate Risk for Hepatic Encephalopathy";
        } else {
            heRisk = "Low Risk (Controlled shunting with 8mm caliber stent)";
        }

        StringBuilder rec = new StringBuilder();
        if (postPsg < 8.0) {
            rec.append("WARNING: PSG is excessively reduced (< 8 mmHg). High risk of HE.");
        } else if (success) {
            rec.append("OPTIMAL GRADIENT: Post-TIPS PSG is ").append(round(postPsg, 1)).append(" mmHg (<12 mmHg threshold).");
        } else {
            rec.append("SUBOPTIMAL DECOMPRESSION: Post-TIPS PSG remains >= 12 mmHg.");
        }

        return new TipsProcedureLog(
                procId,
                patientId,
                round(prePortal, 1),
                round(preRa, 1),
                round(prePsg, 1),
                round(postPortal, 1),
                round(postRa, 1),
                round(postPsg, 1),
                stentDiamMm,
                success,
                heRisk,
                rec.toString(),
                Instant.now()
        );
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
