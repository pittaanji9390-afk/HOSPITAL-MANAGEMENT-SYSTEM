package com.hospital.pharmacy.cleanroom;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Real-time Environmental Monitoring for USP <797> (Sterile Preparations) and USP <800> (Hazardous Drugs).
 * Validates ISO Class 5 Primary Engineering Controls (Laminar Flow Hoods, Biological Safety Cabinets),
 * ISO Class 7 Buffer Rooms, and ISO Class 8 Ante-Rooms.
 */
@Service
public class CleanroomMonitoringService {

    public enum IsoClass { ISO_5, ISO_7, ISO_8, UNCLASSIFIED }
    public enum PressureRegime { POSITIVE_STERILE, NEGATIVE_HAZARDOUS }
    public enum SensorStatus { OPTIMAL, WARNING, CRITICAL_BREACH, CALIBRATION_OVERDUE }

    public record CleanroomZone(
        String zoneId,
        String name,
        IsoClass classification,
        PressureRegime pressureType,
        double minDifferentialPressureInchesWater,
        double maxDifferentialPressureInchesWater,
        double maxParticleCount0_5MicronPerM3,
        double targetAirChangesPerHour
    ) {}

    public record EnvironmentalReading(
        String zoneId,
        double differentialPressureInchesWater,
        double particleCount0_5Micron,
        double temperatureCelsius,
        double relativeHumidityPercent,
        double airChangesPerHour,
        SensorStatus status,
        Instant timestamp
    ) {}

    private final Map<String, CleanroomZone> zones = new ConcurrentHashMap<>();
    private final Map<String, EnvironmentalReading> latestReadings = new ConcurrentHashMap<>();

    public CleanroomMonitoringService() {
        registerStandardZones();
    }

    private void registerStandardZones() {
        CleanroomZone sterileBuffer = new CleanroomZone("ZONE-STERILE-BUF-7", "ISO 7 Non-Hazardous Buffer Room", IsoClass.ISO_7, PressureRegime.POSITIVE_STERILE, +0.020, +0.050, 352000.0, 30.0);
        CleanroomZone hazardousBuffer = new CleanroomZone("ZONE-HAZARD-BUF-7", "ISO 7 Hazardous Negative Buffer Room", IsoClass.ISO_7, PressureRegime.NEGATIVE_HAZARDOUS, -0.030, -0.010, 352000.0, 30.0);
        CleanroomZone anteRoom = new CleanroomZone("ZONE-ANTE-8", "ISO 8 Ante-Room & Gowning Area", IsoClass.ISO_8, PressureRegime.POSITIVE_STERILE, +0.010, +0.025, 3520000.0, 20.0);
        CleanroomZone bscHood = new CleanroomZone("ZONE-BSC-HOOD-1", "ISO 5 Biological Safety Cabinet (Chemo)", IsoClass.ISO_5, PressureRegime.NEGATIVE_HAZARDOUS, -0.050, -0.020, 3520.0, 60.0);

        zones.put(sterileBuffer.zoneId(), sterileBuffer);
        zones.put(hazardousBuffer.zoneId(), hazardousBuffer);
        zones.put(anteRoom.zoneId(), anteRoom);
        zones.put(bscHood.zoneId(), bscHood);

        // Seed initial telemetry
        latestReadings.put("ZONE-STERILE-BUF-7", new EnvironmentalReading("ZONE-STERILE-BUF-7", 0.035, 14200.0, 19.4, 45.2, 34.2, SensorStatus.OPTIMAL, Instant.now()));
        latestReadings.put("ZONE-HAZARD-BUF-7", new EnvironmentalReading("ZONE-HAZARD-BUF-7", -0.022, 18500.0, 18.9, 42.0, 32.8, SensorStatus.OPTIMAL, Instant.now()));
        latestReadings.put("ZONE-ANTE-8", new EnvironmentalReading("ZONE-ANTE-8", 0.018, 120000.0, 20.1, 48.1, 24.5, SensorStatus.OPTIMAL, Instant.now()));
        latestReadings.put("ZONE-BSC-HOOD-1", new EnvironmentalReading("ZONE-BSC-HOOD-1", -0.038, 42.0, 18.2, 39.5, 75.0, SensorStatus.OPTIMAL, Instant.now()));
    }

    public EnvironmentalReading evaluateTelemetry(String zoneId, double diffPressure, double particle05, double temp, double rh, double ach) {
        CleanroomZone zone = zones.get(zoneId);
        if (zone == null) throw new IllegalArgumentException("Unknown cleanroom zone: " + zoneId);

        SensorStatus status = SensorStatus.OPTIMAL;
        if (diffPressure < zone.minDifferentialPressureInchesWater() || diffPressure > zone.maxDifferentialPressureInchesWater()) {
            status = SensorStatus.CRITICAL_BREACH;
        } else if (particle05 > zone.maxParticleCount0_5MicronPerM3()) {
            status = SensorStatus.WARNING;
        } else if (temp > 20.0 || rh > 60.0 || ach < zone.targetAirChangesPerHour()) {
            status = SensorStatus.WARNING;
        }

        EnvironmentalReading reading = new EnvironmentalReading(zoneId, diffPressure, particle05, temp, rh, ach, status, Instant.now());
        latestReadings.put(zoneId, reading);
        return reading;
    }

    public List<CleanroomZone> getAllZones() {
        return new ArrayList<>(zones.values());
    }

    public EnvironmentalReading getLatestReading(String zoneId) {
        return latestReadings.get(zoneId);
    }
}
