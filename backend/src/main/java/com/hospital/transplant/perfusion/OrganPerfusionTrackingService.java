package com.hospital.transplant.perfusion;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Organ Cold Ischemia Time (CIT) and Hypothermic / Normothermic Machine Perfusion (e.g. LifePort / TransMedics OCS) Telemetry.
 * Monitors cross-clamp time, perfusion pressure (mmHg), flow rate (mL/min), resistance index, and GPS transit geofence.
 */
@Service
public class OrganPerfusionTrackingService {

    public enum OrganType { HEART, LUNG, LIVER, KIDNEY, PANCREAS }
    public enum PreservationMethod { STATIC_COLD_STORAGE_4C, HYPOTHERMIC_MACHINE_PERFUSION, NORMOTHERMIC_OCS }

    public record PerfusionTelemetry(
        String organTrackingId,
        OrganType organType,
        PreservationMethod method,
        Instant aorticCrossClampTime,
        double perfusionPressureMmHg,
        double perfusionFlowMlPerMin,
        double vascularResistanceIndex,
        double organTempCelsius,
        double gpsLatitude,
        double gpsLongitude,
        String transitStatus
    ) {}

    private final Map<String, PerfusionTelemetry> liveTelemetry = new ConcurrentHashMap<>();

    public OrganPerfusionTrackingService() {
        seedTelemetry();
    }

    private void seedTelemetry() {
        PerfusionTelemetry kidney1 = new PerfusionTelemetry(
            "DONOR-ORG-KIDNEY-4091",
            OrganType.KIDNEY,
            PreservationMethod.HYPOTHERMIC_MACHINE_PERFUSION,
            Instant.now().minus(4, ChronoUnit.HOURS),
            28.5,
            110.0,
            0.26,
            3.8,
            34.0522,
            -118.2437,
            "IN_TRANSIT_FLIGHT_MEDEVAC_7"
        );
        liveTelemetry.put(kidney1.organTrackingId(), kidney1);
    }

    public long getElapsedColdIschemiaMinutes(String organId) {
        PerfusionTelemetry tel = liveTelemetry.get(organId);
        if (tel == null) return 0;
        return ChronoUnit.MINUTES.between(tel.aorticCrossClampTime(), Instant.now());
    }

    public PerfusionTelemetry getTelemetry(String organId) {
        return liveTelemetry.get(organId);
    }

    public List<PerfusionTelemetry> listActiveOrgans() {
        return new ArrayList<>(liveTelemetry.values());
    }
}
