package com.hospital.cathlab.hemodynamics;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class CoronaryPhysiologyFfrService {

    public static record PhysiologyMeasurement(
            String measurementId,
            String patientId,
            String targetVessel,
            double aorticPressureMeanPa,
            double distalCoronaryPressureMeanPd,
            double hyperemiaAorticPressurePa,
            double hyperemiaDistalPressurePd,
            double ifrValue,
            double restingCfr,
            double hyperemicMicrovascularResistanceHmr,
            boolean isHemodynamicallySignificant,
            String clinicalAction,
            Instant timestamp
    ) implements Serializable {}

    public PhysiologyMeasurement evaluateCoronaryPhysiology(
            String measurementId,
            String patientId,
            String vessel,
            double restingPa,
            double restingPd,
            double hyperPa,
            double hyperPd,
            double tmnRestSec,
            double tmnHyperSec
    ) {
        double ffr = (hyperPa > 0) ? (hyperPd / hyperPa) : 1.0;
        double ifr = (restingPa > 0) ? (restingPd / restingPa) : 1.0;
        double cfr = (tmnHyperSec > 0) ? (tmnRestSec / tmnHyperSec) : 1.0;
        double hmr = (tmnHyperSec > 0) ? (hyperPd * tmnHyperSec) : 0.0;

        boolean significant = (ffr <= 0.80) || (ifr <= 0.89);

        StringBuilder action = new StringBuilder();
        if (significant) {
            action.append("ISCHEMIA POSITIVE (FFR: ").append(round(ffr, 2))
                  .append(", iFR: ").append(round(ifr, 2)).append("). ")
                  .append("Revascularization is clinically indicated. Class I Evidence.");
        } else {
            action.append("HEMODYNAMICALLY NON-SIGNIFICANT (FFR: ").append(round(ffr, 2))
                  .append(", iFR: ").append(round(ifr, 2)).append("). ")
                  .append("Defer PCI; manage with Optimal Medical Therapy (OMT).");
        }

        return new PhysiologyMeasurement(
                measurementId,
                patientId,
                vessel,
                round(restingPa, 1),
                round(restingPd, 1),
                round(hyperPa, 1),
                round(hyperPd, 1),
                round(ifr, 2),
                round(cfr, 2),
                round(hmr, 2),
                significant,
                action.toString(),
                Instant.now()
        );
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
