package com.hospital.bloodbank;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

/**
 * Blood Bank Cold Chain Surveillance & Crossmatch Verification Engine.
 * Enforces strict temperature monitoring for blood components and ABO/Rh compatibility matrices.
 */
@Component
public class BloodBankColdChainEngine {

    @Data
    @Builder
    public static class ColdChainAlert {
        private String storageUnitId; // e.g. FRIDGE-PRBC-01, FREEZER-FFP-01, AGITATOR-PLT-01
        private String bloodComponentType; // PRBC, FFP, PLATELETS, CRYOPRECIPITATE
        private double currentTemperatureCelsius;
        private double minAllowedTemp;
        private double maxAllowedTemp;
        private boolean breachDetected;
        private String correctiveAction;
    }

    @Data
    @Builder
    public static class CrossmatchResult {
        private String recipientAboRh;
        private String donorUnitAboRh;
        private String bloodComponent;
        private boolean compatible;
        private String interpretation;
    }

    public ColdChainAlert evaluateStorageTemperature(String unitId, String componentType, double tempCelsius) {
        double min;
        double max;

        switch (componentType.toUpperCase()) {
            case "PRBC":
            case "WHOLE_BLOOD":
                min = 2.0;
                max = 6.0;
                break;
            case "FFP":
            case "CRYOPRECIPITATE":
                min = -40.0;
                max = -18.0;
                break;
            case "PLATELETS":
                min = 20.0;
                max = 24.0;
                break;
            default:
                min = 2.0;
                max = 6.0;
        }

        boolean breach = tempCelsius < min || tempCelsius > max;
        String action;
        if (breach) {
            action = "CRITICAL COLD CHAIN BREACH: Quarantine all units in " + unitId + ". Activate backup cooling compressor immediately and notify Blood Bank Director.";
        } else {
            action = "Temperature within optimal therapeutic range (" + min + "°C to " + max + "°C).";
        }

        return ColdChainAlert.builder()
                .storageUnitId(unitId)
                .bloodComponentType(componentType)
                .currentTemperatureCelsius(tempCelsius)
                .minAllowedTemp(min)
                .maxAllowedTemp(max)
                .breachDetected(breach)
                .correctiveAction(action)
                .build();
    }

    public CrossmatchResult verifyAboCompatibility(String recipientBloodGroup, String donorUnitGroup, String component) {
        boolean isCompatible = false;
        String rec = recipientBloodGroup.toUpperCase().replace(" ", "");
        String don = donorUnitGroup.toUpperCase().replace(" ", "");

        if ("PRBC".equalsIgnoreCase(component) || "WHOLE_BLOOD".equalsIgnoreCase(component)) {
            // O- is universal red cell donor; AB+ is universal red cell recipient
            if ("O-".equals(don)) {
                isCompatible = true;
            } else if ("O+".equals(don) && (rec.endsWith("+"))) {
                isCompatible = rec.startsWith("O") || rec.startsWith("A") || rec.startsWith("B") || rec.startsWith("AB");
            } else if ("A-".equals(don) && (rec.startsWith("A") || rec.startsWith("AB"))) {
                isCompatible = true;
            } else if ("A+".equals(don) && rec.endsWith("+") && (rec.startsWith("A") || rec.startsWith("AB"))) {
                isCompatible = true;
            } else if ("B-".equals(don) && (rec.startsWith("B") || rec.startsWith("AB"))) {
                isCompatible = true;
            } else if ("B+".equals(don) && rec.endsWith("+") && (rec.startsWith("B") || rec.startsWith("AB"))) {
                isCompatible = true;
            } else if ("AB-".equals(don) && rec.startsWith("AB")) {
                isCompatible = true;
            } else if ("AB+".equals(don) && "AB+".equals(rec)) {
                isCompatible = true;
            }
        } else if ("FFP".equalsIgnoreCase(component) || "PLASMA".equalsIgnoreCase(component)) {
            // AB is universal plasma donor; O is universal plasma recipient
            if ("AB+".equals(don) || "AB-".equals(don)) {
                isCompatible = true;
            } else if ("A+".equals(don) || "A-".equals(don)) {
                isCompatible = rec.startsWith("A") || rec.startsWith("O");
            } else if ("B+".equals(don) || "B-".equals(don)) {
                isCompatible = rec.startsWith("B") || rec.startsWith("O");
            } else if ("O+".equals(don) || "O-".equals(don)) {
                isCompatible = rec.startsWith("O");
            }
        }

        return CrossmatchResult.builder()
                .recipientAboRh(rec)
                .donorUnitAboRh(don)
                .bloodComponent(component)
                .compatible(isCompatible)
                .interpretation(isCompatible ? "COMPATIBLE: Safe for major crossmatch and patient issue." : "INCOMPATIBLE: Acute hemolytic transfusion reaction risk. DO NOT ISSUE.")
                .build();
    }
}
