package com.hospital.services.pediatrics;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PediatricsNicuManagementEngine {

    @Data
    @Builder
    public static class NeonatalAssessment {
        private String babyMrn;
        private int apgar1Min;
        private int apgar5Min;
        private double birthWeightGrams;
        private int gestationalAgeWeeks;
        private double dailyMaintenanceFluidMl;
        private double glucoseInfusionRateGirMgKgMin;
        private String phototherapyThresholdAction;
    }

    public NeonatalAssessment calculateNicuParameters(String babyMrn, int a1, int a5, double birthWeightGrams, int gaWeeks, double serumBilirubinMgDl, double dextrosePercent, double infusionRateMlHr) {
        double weightKg = birthWeightGrams / 1000.0;
        double dailyFluid = (gaWeeks < 32 ? 100.0 : 80.0) * weightKg;

        double gir = (infusionRateMlHr * dextrosePercent * 10.0) / (weightKg * 60.0);

        boolean needsBiliLight = serumBilirubinMgDl >= (gaWeeks >= 35 ? 12.0 : 8.0);

        return NeonatalAssessment.builder()
                .babyMrn(babyMrn)
                .apgar1Min(a1)
                .apgar5Min(a5)
                .birthWeightGrams(birthWeightGrams)
                .gestationalAgeWeeks(gaWeeks)
                .dailyMaintenanceFluidMl(Math.round(dailyFluid * 10.0) / 10.0)
                .glucoseInfusionRateGirMgKgMin(Math.round(gir * 100.0) / 100.0)
                .phototherapyThresholdAction(needsBiliLight ? "INTENSIVE_BLUE_LED_PHOTOTHERAPY_INITIATED" : "SERUM_BILIRUBIN_MONITORING_Q12H")
                .build();
    }
}
