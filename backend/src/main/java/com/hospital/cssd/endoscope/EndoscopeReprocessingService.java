package com.hospital.cssd.endoscope;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Flexible Endoscope High-Level Disinfection (HLD) & Reprocessing Management (ANSI/AAMI ST91).
 * Tracks Point-of-Use Bedside Wipe (within 1 hr), Dry/Wet Leak Testing, Enzymatic Channel Brushing,
 * Automated Endoscope Reprocessor (AER) OPA/Peracetic Acid Cycles, HEPA Cabinet Storage & 7-day hang time.
 */
@Service
public class EndoscopeReprocessingService {

    public enum EndoscopeType { COLONOSCOPE, GASTROSCOPE, DUODENOSCOPE_ERCP, BRONCHOSCOPE, CYSTOSCOPE }
    public enum HldStatus { BEDSIDE_PRECLEANED, LEAK_TEST_PASSED, LEAK_TEST_FAILED, MANUAL_BRUSHED, AER_DISINFECTED, HEPA_STORAGE_VALID, HANG_TIME_EXPIRED }

    public record EndoscopeDevice(
        String serialNumber,
        String modelNumber,
        EndoscopeType type,
        String manufacturer,
        HldStatus status,
        double maxHangHoursAllowed,
        Instant lastAerCycleCompletedAt,
        String currentStorageCabinetSlot
    ) {}

    private final Map<String, EndoscopeDevice> scopeRegistry = new ConcurrentHashMap<>();

    public EndoscopeReprocessingService() {
        seedScopes();
    }

    private void seedScopes() {
        scopeRegistry.put("SCOPE-OLY-CF-190L-8821", new EndoscopeDevice("SCOPE-OLY-CF-190L-8821", "CF-HQ190L", EndoscopeType.COLONOSCOPE, "Olympus", HldStatus.HEPA_STORAGE_VALID, 168.0, Instant.now().minusSeconds(86400), "CAB-HEPA-01-SLOT-03"));
        scopeRegistry.put("SCOPE-OLY-TJF-Q190V-4410", new EndoscopeDevice("SCOPE-OLY-TJF-Q190V-4410", "TJF-Q190V (Elevator Duodenoscope)", EndoscopeType.DUODENOSCOPE_ERCP, "Olympus", HldStatus.HEPA_STORAGE_VALID, 168.0, Instant.now().minusSeconds(43200), "CAB-HEPA-01-SLOT-07"));
        scopeRegistry.put("SCOPE-PNTX-EB1970-1120", new EndoscopeDevice("SCOPE-PNTX-EB1970-1120", "EB-1970TK", EndoscopeType.BRONCHOSCOPE, "Pentax", HldStatus.HEPA_STORAGE_VALID, 168.0, Instant.now().minusSeconds(21600), "CAB-HEPA-02-SLOT-01"));
    }

    public synchronized EndoscopeDevice recordLeakTest(String serialNumber, boolean passed, double measuredPressureMbar) {
        EndoscopeDevice scope = scopeRegistry.get(serialNumber);
        if (scope == null) throw new IllegalArgumentException("Scope not registered: " + serialNumber);

        HldStatus next = passed ? HldStatus.LEAK_TEST_PASSED : HldStatus.LEAK_TEST_FAILED;
        EndoscopeDevice updated = new EndoscopeDevice(scope.serialNumber(), scope.modelNumber(), scope.type(), scope.manufacturer(), next, scope.maxHangHoursAllowed(), scope.lastAerCycleCompletedAt(), passed ? scope.currentStorageCabinetSlot() : "QUARANTINE-REPAIR");
        scopeRegistry.put(serialNumber, updated);
        return updated;
    }

    public List<EndoscopeDevice> listAllScopes() {
        return new ArrayList<>(scopeRegistry.values());
    }
}
