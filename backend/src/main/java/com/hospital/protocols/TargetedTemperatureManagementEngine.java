package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class TargetedTemperatureManagementEngine {

    @Data
    @Builder
    public static class TtmCoolingProtocol {
        private String encounterId;
        private double targetTemperatureCelsius;
        private int maintenanceDurationHours;
        private double rewarmingRateCelsiusPerHour;
        private String shiveringControlRegimen;
        private String sedationAndNeuromuscularBlockade;
    }

    public TtmCoolingProtocol generateTtmProtocol(String encounterId, double targetTemp) {
        double temp = (targetTemp >= 32.0 && targetTemp <= 36.0) ? targetTemp : 36.0;

        return TtmCoolingProtocol.builder()
                .encounterId(encounterId)
                .targetTemperatureCelsius(temp)
                .maintenanceDurationHours(24)
                .rewarmingRateCelsiusPerHour(0.25)
                .shiveringControlRegimen("BSAS (Bedside Shivering Assessment Scale) titration: Acetaminophen 1g Q6H + Magnesium Sulfate 2-4g IV + Buspirone 30mg PO/NGT.")
                .sedationAndNeuromuscularBlockade("Continuous Propofol (20-50 mcg/kg/min) + Fentanyl (1-2 mcg/kg/hr) + Cisatracurium if shivering refractory.")
                .build();
    }
}
