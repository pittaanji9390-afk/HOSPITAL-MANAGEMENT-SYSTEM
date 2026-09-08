package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class AmbulanceDispatchCadEngine {

    @Data
    @AllArgsConstructor
    public static class AmbulanceDispatchTrip {
        private String dispatchCallId;
        private String ambulanceVehicleNumber;
        private String fleetTier; // ALS_ADVANCED_LIFE_SUPPORT, BLS_BASIC_LIFE_SUPPORT, NEONATAL_TRANSPORT
        private String emergencyLocation;
        private int estimatedArrivalMinutes;
        private boolean isOnboardDefibrillatorTelemetryActive;
    }

    public AmbulanceDispatchTrip dispatchUnit(String callId, String location, String priority) {
        String tier = priority.equals("CODE_STEMI") || priority.equals("CODE_STROKE") || priority.equals("TRAUMA_DELTA") ? "ALS_ADVANCED_LIFE_SUPPORT" : "BLS_BASIC_LIFE_SUPPORT";
        return new AmbulanceDispatchTrip(callId, "AMB-AP-01", tier, location, 8, true);
    }
}
