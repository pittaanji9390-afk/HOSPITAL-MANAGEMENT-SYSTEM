package com.hospital.criticalcare.ttm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class TargetedTemperatureManagementCoolingEngine {

    @Data
    @AllArgsConstructor
    public static class TtmCoolingProtocol {
        private String patientId;
        private String ttmPhase; // INDUCTION, MAINTENANCE_24H, REWARMING_0_25C_PER_HR, NORMOTHERMIA
        private double targetTemperatureC; // 33.0 or 36.0
        private double currentCoreTempC;
        private double rewarmingRateTarget; // 0.25 C / hour
        private String shiveringControlStrategy;
    }

    public TtmCoolingProtocol evaluateTtm(String patientId, String phase, double targetC, double coreC, int bsasScore) {
        String shiver = bsasScore >= 2 ? "Bedside Shivering Assessment Scale (BSAS) >= 2: Administer Buspirone + Magnesium Sulfate infusion" : "No active shivering detected (BSAS < 2)";

        return new TtmCoolingProtocol(patientId, phase, targetC, coreC, 0.25, shiver);
    }
}
