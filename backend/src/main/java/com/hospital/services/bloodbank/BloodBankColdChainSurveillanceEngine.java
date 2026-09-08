package com.hospital.services.bloodbank;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Enterprise Blood Bank Cold-Chain Continuous IoT Sensor Surveillance Engine.
 * Monitored temperature thresholds: PRBC (1-6°C), FFP (<= -18°C), Platelets (20-24°C with continuous agitation).
 */
@Component
public class BloodBankColdChainSurveillanceEngine {

    @Data
    @Builder
    public static class ColdChainStatusReport {
        private String storageUnitId;
        private String bloodComponentType;
        private double currentTemperatureCelsius;
        private boolean isTemperatureCompliant;
        private String alertLevel; // NORMAL, WARNING, CRITICAL_TEMPERATURE_EXCURSION
        private String requiredCorrectiveAction;
    }

    public ColdChainStatusReport evaluateStorageTemperature(String componentType, double tempCelsius) {
        boolean compliant;
        String alert;
        String action;

        if ("PRBC".equalsIgnoreCase(componentType)) {
            compliant = (tempCelsius >= 1.0 && tempCelsius <= 6.0);
            alert = compliant ? "NORMAL" : "CRITICAL_TEMPERATURE_EXCURSION";
            action = compliant ? "Temperature within AABB/WHO compliant range (1-6°C)." :
                    "ALARM TRIGGERED: Transfer blood units to secondary validated backup refrigerator immediately; quarantine exposed units for quality testing.";
        } else if ("FFP".equalsIgnoreCase(componentType)) {
            compliant = (tempCelsius <= -18.0);
            alert = compliant ? "NORMAL" : "CRITICAL_TEMPERATURE_EXCURSION";
            action = compliant ? "Temperature compliant (<= -18°C)." : "Quarantine thawed units.";
        } else {
            compliant = (tempCelsius >= 20.0 && tempCelsius <= 24.0);
            alert = compliant ? "NORMAL" : "TEMPERATURE_OUT_OF_BOUNDS";
            action = compliant ? "Compliant room temperature platelet storage." : "Inspect incubator agitator.";
        }

        return ColdChainStatusReport.builder()
                .storageUnitId("COLD-UNIT-PRBC-04")
                .bloodComponentType(componentType)
                .currentTemperatureCelsius(tempCelsius)
                .isTemperatureCompliant(compliant)
                .alertLevel(alert)
                .requiredCorrectiveAction(action)
                .build();
    }
}
