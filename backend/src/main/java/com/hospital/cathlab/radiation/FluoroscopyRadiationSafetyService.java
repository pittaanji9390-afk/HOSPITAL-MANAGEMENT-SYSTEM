package com.hospital.cathlab.radiation;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class FluoroscopyRadiationSafetyService {

    public enum RadiationAlertLevel {
        NORMAL("Dose within standard diagnostic limits"),
        ADVISORY_500_MGY("First advisory threshold reached (Air Kerma >= 0.5 Gy)"),
        WARNING_2000_MGY("SIR Significant Radiation Dose threshold (Air Kerma >= 2.0 Gy)"),
        CRITICAL_5000_MGY("Critical skin injury threshold (Air Kerma >= 5.0 Gy); Mandatory 30-day clinical follow-up");

        private final String message;
        RadiationAlertLevel(String message) { this.message = message; }
        public String getMessage() { return message; }
    }

    public static record RadiationDoseLog(
            String logId,
            String procedureId,
            String patientId,
            String operatorName,
            double totalFluoroTimeMinutes,
            int totalCineRuns,
            int totalCineFrames,
            double cumulativeAirKermaGy,
            double doseAreaProductGyCm2,
            double estimatedPeakSkinDoseGy,
            RadiationAlertLevel alertLevel,
            boolean mandatoryFollowupRequired,
            String radiationOptimizationAdvise,
            Instant loggedAt
    ) implements Serializable {}

    public RadiationDoseLog evaluateRadiationDose(
            String logId,
            String procId,
            String patientId,
            String operator,
            double fluoroMin,
            int cineRuns,
            int cineFrames,
            double airKermaGy,
            double dapGyCm2
    ) {
        double psdGy = airKermaGy * 0.75;

        RadiationAlertLevel level;
        boolean followup = false;
        StringBuilder advise = new StringBuilder();

        if (airKermaGy >= 5.0 || psdGy >= 5.0) {
            level = RadiationAlertLevel.CRITICAL_5000_MGY;
            followup = true;
            advise.append("MANDATORY POST-PROCEDURE CLINICAL SKIN EXAM at 30 days (Erythema/Ulceration risk). File SIR Radiation Event Report.");
        } else if (airKermaGy >= 2.0 || psdGy >= 2.0) {
            level = RadiationAlertLevel.WARNING_2000_MGY;
            followup = true;
            advise.append("SRD THRESHOLD REACHED: Advise patient regarding self-inspection of back/flank skin.");
        } else if (airKermaGy >= 0.5) {
            level = RadiationAlertLevel.ADVISORY_500_MGY;
            advise.append("Standard advisory: Utilize copper beam filtration, tight beam collimation, and pulsed fluoroscopy.");
        } else {
            level = RadiationAlertLevel.NORMAL;
            advise.append("ALARA compliance verified.");
        }

        return new RadiationDoseLog(
                logId,
                procId,
                patientId,
                operator,
                round(fluoroMin, 1),
                cineRuns,
                cineFrames,
                round(airKermaGy, 3),
                round(dapGyCm2, 2),
                round(psdGy, 3),
                level,
                followup,
                advise.toString(),
                Instant.now()
        );
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
