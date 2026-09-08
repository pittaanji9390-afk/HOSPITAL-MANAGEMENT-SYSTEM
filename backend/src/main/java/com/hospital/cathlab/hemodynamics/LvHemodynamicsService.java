package com.hospital.cathlab.hemodynamics;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;

@Service
public class LvHemodynamicsService {

    public static record HemodynamicProfile(
            String patientId,
            double lvPeakSystolicPressureMmHg,
            double lvEndDiastolicPressureMmHg,
            double aorticMeanPressureMmHg,
            double rightAtrialMeanPressureMmHg,
            double pulmonaryCapillaryWedgePressureMmHg,
            double cardiacOutputLMin,
            double cardiacIndexLMinM2,
            double systemicVascularResistanceDynes,
            double cardiacPowerOutputWatts,
            String hemodynamicPhenotype,
            String mechanicalCirculatorySupportRecommendation,
            Instant evaluatedAt
    ) implements Serializable {}

    public HemodynamicProfile evaluateLvHemodynamics(
            String patientId,
            double lvSystolic,
            double lvedp,
            double map,
            double cvp,
            double pcwp,
            double cardiacOutput,
            double bodySurfaceAreaM2
    ) {
        double ci = (bodySurfaceAreaM2 > 0) ? (cardiacOutput / bodySurfaceAreaM2) : 2.5;
        double svr = (cardiacOutput > 0) ? ((map - cvp) * 80.0 / cardiacOutput) : 1200.0;
        double cpo = (map * cardiacOutput) / 451.0;

        String phenotype;
        String mcs;

        boolean wet = pcwp > 18.0 || lvedp > 18.0;
        boolean cold = ci < 2.2;

        if (cold && wet) {
            phenotype = "Cold & Wet: Cardiogenic Shock / Decompensated Heart Failure";
            if (cpo < 0.6) {
                mcs = "CRITICAL SHOCK (CPO < 0.6W): Immediate Mechanical Circulatory Support indicated (Impella CP / ECMO).";
            } else {
                mcs = "Consider IABP or Impella; Inotropic support (Dobutamine) + loop diuretics.";
            }
        } else if (!cold && wet) {
            phenotype = "Warm & Wet: Congested / Normoperfused Heart Failure";
            mcs = "Intravenous Vasodilators + High-dose loop diuretics.";
        } else if (cold && !wet) {
            phenotype = "Cold & Dry: Hypovolemic Shock or Over-diuresis";
            mcs = "Careful fluid challenge under continuous CVP monitoring.";
        } else {
            phenotype = "Warm & Dry: Compensated Hemodynamics";
            mcs = "Maintain guideline-directed medical therapy.";
        }

        return new HemodynamicProfile(
                patientId,
                round(lvSystolic, 1),
                round(lvedp, 1),
                round(map, 1),
                round(cvp, 1),
                round(pcwp, 1),
                round(cardiacOutput, 2),
                round(ci, 2),
                round(svr, 0),
                round(cpo, 2),
                phenotype,
                mcs,
                Instant.now()
        );
    }

    private double round(double val, int dec) {
        return BigDecimal.valueOf(val).setScale(dec, RoundingMode.HALF_UP).doubleValue();
    }
}
