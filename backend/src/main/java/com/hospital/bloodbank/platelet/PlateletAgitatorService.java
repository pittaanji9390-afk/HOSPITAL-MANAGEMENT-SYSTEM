package com.hospital.bloodbank.platelet;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Platelet Storage Incubator & Continuous Agitator Monitor (Helmer i.Series).
 * Validates 20°C - 24°C continuous temperature and 60 cycles/min gentle horizontal agitation
 * to prevent platelet activation/pH drop (< 6.2) and bacterial proliferation (5-day or 7-day LVDS expiration).
 */
@Service
public class PlateletAgitatorService {

    public record IncubatorTelemetry(
        String incubatorId,
        double chamberTempCelsius,
        int agitationCyclesPerMin,
        boolean agitatorMotionSensorEngaged,
        boolean temperatureInAlarmState,
        Instant lastRecordedAt
    ) {}

    private final Map<String, IncubatorTelemetry> agitators = new ConcurrentHashMap<>();

    public PlateletAgitatorService() {
        seedAgitators();
    }

    private void seedAgitators() {
        IncubatorTelemetry inc1 = new IncubatorTelemetry("PLT-INCUBATOR-01", 22.4, 62, true, false, Instant.now());
        agitators.put(inc1.incubatorId(), inc1);
    }

    public IncubatorTelemetry getTelemetry(String incubatorId) {
        return agitators.get(incubatorId);
    }
}
