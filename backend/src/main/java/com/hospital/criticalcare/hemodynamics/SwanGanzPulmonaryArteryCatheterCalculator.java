package com.hospital.criticalcare.hemodynamics;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class SwanGanzPulmonaryArteryCatheterCalculator {

    @Data
    @AllArgsConstructor
    public static class PacHemodynamics {
        private String patientId;
        private double systemicVascularResistanceSvr; // 800 - 1200 dynes*sec/cm5
        private double pulmonaryVascularResistancePvr; // 100 - 250 dynes*sec/cm5
        private double leftVentricularStrokeWorkIndexLvswi; // 50 - 62 g*m/m2
        private String hemodynamicShockPattern; // CARDIOGENIC, SEPTIC_DISTRIBUTIVE, HYPOVOLEMIC, OBSTRUCTIVE
    }

    public PacHemodynamics calculatePac(String patientId, double co, double map, double cvp, double papMean, double paopWedge, double bsa) {
        double svr = co > 0 ? ((map - cvp) / co) * 80.0 : 0;
        double pvr = co > 0 ? ((papMean - paopWedge) / co) * 80.0 : 0;
        double lvswi = bsa > 0 ? (co / bsa) * (map - paopWedge) * 0.0136 : 0;

        String pattern = "NORMAL";
        if (co < 3.5 && paopWedge > 18.0 && svr > 1400.0) {
            pattern = "CARDIOGENIC SHOCK";
        } else if (co > 6.0 && svr < 700.0 && paopWedge < 12.0) {
            pattern = "HYPERDYNAMIC SEPTIC / DISTRIBUTIVE SHOCK";
        } else if (co < 3.5 && paopWedge < 8.0 && cvp < 4.0) {
            pattern = "HYPOVOLEMIC SHOCK";
        }

        return new PacHemodynamics(patientId, Math.round(svr), Math.round(pvr), Math.round(lvswi * 10.0) / 10.0, pattern);
    }
}
