package com.hospital.cathlab.thrombectomy;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class CatheterThrombolysisService {

    public enum Indication {
        MASSIVE_SUBMASSIVE_PULMONARY_EMBOLISM,
        ILIOFEMORAL_DEEP_VEIN_THROMBOSIS,
        ACUTE_LIMB_ISCHEMIA
    }

    public static record ThrombolysisSession(
            String sessionId,
            String patientId,
            Indication indication,
            boolean ekosUltrasoundActive,
            double tpaInfusionRateMgPerHour,
            int numberOfCatheters,
            double unfractionatedHeparinUnitsPerHour,
            double plasmaFibrinogenMgDl,
            double totalTpaAdministeredMg,
            int infusionDurationHours,
            boolean bleedingHemorrhageAlert,
            String infusionAdjustments,
            Instant monitoredAt
    ) implements Serializable {}

    public ThrombolysisSession evaluateSession(
            String sessionId,
            String patientId,
            Indication indication,
            boolean ekosOn,
            double rateMgHr,
            int catheterCount,
            double heparinUnitsHr,
            double fibrinogenMgDl,
            double totalTpaSoFarMg,
            int elapsedHours
    ) {
        boolean alert = false;
        StringBuilder adj = new StringBuilder();

        if (fibrinogenMgDl < 100.0) {
            alert = true;
            adj.append("CRITICAL HYPOFIBRINOGENEMIA (<100 mg/dL). IMMEDIATELY HOLD tPA INFUSION. Order stat Cryoprecipitate (10 units).");
        } else if (fibrinogenMgDl < 150.0) {
            alert = true;
            adj.append("Fibrinogen depressed (100-150 mg/dL). Reduce tPA infusion rate by 50%.");
        } else if (totalTpaSoFarMg >= 24.0) {
            alert = true;
            adj.append("Maximum 24mg tPA limit reached. Recommend catheter pullback angiogram.");
        } else {
            adj.append("Therapeutic parameters within safe window. Ultrasound acoustic pulse dissociation active.");
        }

        return new ThrombolysisSession(
                sessionId,
                patientId,
                indication,
                ekosOn,
                rateMgHr,
                catheterCount,
                heparinUnitsHr,
                fibrinogenMgDl,
                totalTpaSoFarMg,
                elapsedHours,
                alert,
                adj.toString(),
                Instant.now()
        );
    }
}
