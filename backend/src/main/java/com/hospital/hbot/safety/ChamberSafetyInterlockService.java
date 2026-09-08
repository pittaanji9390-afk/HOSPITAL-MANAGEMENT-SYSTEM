package com.hospital.hbot.safety;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Hyperbaric Chamber Safety & Environmental Gas Analyzer (NFPA 99 Chapter 14 & ASME PVHO-1).
 * In Multiplace chambers: Ambient O2 concentration must be strictly <= 23.5% (to prevent fire hazard).
 * CO2 scrubber must keep PCO2 < 5.0 mmHg (0.5% surface equivalent).
 */
@Service
public class ChamberSafetyInterlockService {

    public record ChamberGasTelemetry(double ambientOxygenPercent, double co2Ppm, double relativeHumidityPercent, boolean groundStrapConductive, boolean fireSafetyInterlockSafe) {}

    public ChamberGasTelemetry evaluateSafety(double o2Pct, double co2, double rh, boolean grounded) {
        // NFPA 99 rule: Chamber ambient O2 > 23.5% triggers automatic overboard exhaust dump
        boolean o2Safe = o2Pct <= 23.5;
        boolean rhSafe = rh >= 50.0; // RH >= 50% prevents static electricity spark ignition
        boolean co2Safe = co2 <= 5000.0; // <= 0.5%

        boolean allSafe = o2Safe && rhSafe && co2Safe && grounded;
        return new ChamberGasTelemetry(o2Pct, co2, rh, grounded, allSafe);
    }
}
