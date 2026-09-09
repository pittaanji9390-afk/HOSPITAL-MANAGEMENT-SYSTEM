package com.hospital.security.geofence;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class WorkstationGeofenceValidator {

    @Data
    @AllArgsConstructor
    public static class TrustedWorkstation {
        private String stationId;
        private String locationRoom;
        private String ipAddressSubnet;
        private boolean isRestrictedArea; // e.g., OR, ICU, Pharmacy Vault
        private boolean isDirectDoseDispenseTerminal;
    }

    private final Map<String, TrustedWorkstation> workstations = new LinkedHashMap<>();

    public WorkstationGeofenceValidator() {
        workstations.put("WS-OR-1", new TrustedWorkstation("WS-OR-1", "Operating Room 1 Anesthesia Desk", "10.240.10.12", true, true));
        workstations.put("WS-ICU-4", new TrustedWorkstation("WS-ICU-4", "ICU Bed 4 Bedside Touchscreen", "10.240.12.44", true, false));
        workstations.put("WS-PHARM-1", new TrustedWorkstation("WS-PHARM-1", "Central Inpatient Pharmacy ADC Console", "10.240.20.10", true, true));
    }

    public boolean isIpPermittedForRestrictedAction(String clientIp) {
        return workstations.values().stream().anyMatch(ws -> ws.getIpAddressSubnet().equals(clientIp) && ws.isRestrictedArea());
    }

    public List<TrustedWorkstation> getAllWorkstations() { return new ArrayList<>(workstations.values()); }
}
