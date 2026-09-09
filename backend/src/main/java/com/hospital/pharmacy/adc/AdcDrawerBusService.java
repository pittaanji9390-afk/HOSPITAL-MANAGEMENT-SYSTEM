package com.hospital.pharmacy.adc;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Enterprise Automated Dispensing Cabinet (ADC) Drawer Bus Controller.
 * Interfaces with RS-485 / CAN-bus solenoid locking matrices for Pyxis MedStation and Omnicell XT towers.
 */
@Service
public class AdcDrawerBusService {

    public enum DrawerType { MATRIX, CAROUSEL, HIGH_SECURITY_CUBIE, REFRIGERATED_LOCKER, BULK_OVERFLOW }
    public enum SolenoidState { LOCKED, UNLOCKED, TAMPER_ALARM, SENSOR_FAULT, AJAR_TIMEOUT }

    public record PocketCoordinate(int cabinetId, int drawerIndex, int row, int column, String pocketId) {}
    public record DrawerTelemetry(String drawerId, SolenoidState state, double internalTempCelsius, boolean microswitchEngaged, Instant lastAudit) {}

    private final Map<String, DrawerTelemetry> telemetryStore = new ConcurrentHashMap<>();
    private final Map<String, List<PocketCoordinate>> pocketMap = new ConcurrentHashMap<>();

    public AdcDrawerBusService() {
        initializeVirtualAdcBus();
    }

    private void initializeVirtualAdcBus() {
        for (int c = 1; c <= 4; c++) {
            for (int d = 1; d <= 6; d++) {
                String drawerId = "CAB-" + c + "-DRW-" + d;
                telemetryStore.put(drawerId, new DrawerTelemetry(drawerId, SolenoidState.LOCKED, 4.2 + (d * 0.3), true, Instant.now()));
                List<PocketCoordinate> pockets = new ArrayList<>();
                for (int r = 1; r <= 4; r++) {
                    for (int col = 1; col <= 6; col++) {
                        pockets.add(new PocketCoordinate(c, d, r, col, "PKT-" + c + "-" + d + "-" + r + "-" + col));
                    }
                }
                pocketMap.put(drawerId, pockets);
            }
        }
    }

    public synchronized SolenoidState unlockPocket(String drawerId, String pocketId, String nurseBadgeId, String rxOrderNumber) {
        DrawerTelemetry current = telemetryStore.get(drawerId);
        if (current == null) {
            throw new IllegalArgumentException("ADC Drawer " + drawerId + " not found on CAN-bus.");
        }
        if (current.state() == SolenoidState.TAMPER_ALARM) {
            throw new IllegalStateException("Drawer " + drawerId + " locked in tamper state. Bio-ID supervisor override required.");
        }
        telemetryStore.put(drawerId, new DrawerTelemetry(drawerId, SolenoidState.UNLOCKED, current.internalTempCelsius(), false, Instant.now()));
        return SolenoidState.UNLOCKED;
    }

    public synchronized SolenoidState lockDrawer(String drawerId) {
        DrawerTelemetry current = telemetryStore.get(drawerId);
        if (current != null) {
            telemetryStore.put(drawerId, new DrawerTelemetry(drawerId, SolenoidState.LOCKED, current.internalTempCelsius(), true, Instant.now()));
            return SolenoidState.LOCKED;
        }
        return SolenoidState.SENSOR_FAULT;
    }

    public DrawerTelemetry getDrawerTelemetry(String drawerId) {
        return telemetryStore.getOrDefault(drawerId, new DrawerTelemetry(drawerId, SolenoidState.SENSOR_FAULT, -99.9, false, Instant.MIN));
    }

    public List<PocketCoordinate> getDrawerPockets(String drawerId) {
        return pocketMap.getOrDefault(drawerId, Collections.emptyList());
    }
}
