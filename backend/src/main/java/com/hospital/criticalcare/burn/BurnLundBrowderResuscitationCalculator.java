package com.hospital.criticalcare.burn;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class BurnLundBrowderResuscitationCalculator {

    @Data
    @AllArgsConstructor
    public static class BurnFluidPlan {
        private String patientId;
        private double totalBodySurfaceAreaPercent;
        private double total24HourLactatedRingersMl; // 4 mL * kg * %TBSA
        private double first8HoursHourlyRateMlHr; // 50% in first 8 hours
        private double remaining16HoursHourlyRateMlHr; // 50% in next 16 hours
        private String targetUrineOutputGoal; // 0.5 - 1.0 mL/kg/h in adults
    }

    public BurnFluidPlan computeParkland(String patientId, double weightKg, double tbsaPercent) {
        double total24h = 4.0 * weightKg * tbsaPercent;
        double half = total24h / 2.0;
        double rateFirst8 = half / 8.0;
        double rateNext16 = half / 16.0;

        return new BurnFluidPlan(patientId, tbsaPercent, Math.round(total24h), Math.round(rateFirst8), Math.round(rateNext16), "Titrate LR to maintain urine output 30-50 mL/h (0.5 mL/kg/h)");
    }
}
