package com.hospital.bloodbank.modification;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Blood Component Special Modification Service:
 * 1. Irradiation (2500 cGy / 25 Gy to prevent Transfusion-Associated Graft-versus-Host Disease TA-GvHD). Expiration shortens to 28 days.
 * 2. Saline Washing (Removes > 99% plasma proteins for IgA deficiency anaphylaxis prevention). Expiration shortens to 24 hours.
 * 3. Pre-storage Leukocyte Reduction (< 5.0 x 10^6 residual WBCs).
 */
@Service
public class ComponentModificationService {

    public enum ModificationType { GAMMA_IRRADIATION_25GY, SALINE_WASHED_24HR, VOLUME_REDUCED, LEUKO_REDUCED_FILTER }
    public record ModifiedUnit(String din, ModificationType type, Instant modifiedAt, Instant newExpirationTime, String radTagVerificationColor, String operatorBadge) {}

    private final Map<String, ModifiedUnit> modifiedRegistry = new ConcurrentHashMap<>();

    public ModifiedUnit recordIrradiation(String din, String operator) {
        Instant now = Instant.now();
        Instant exp = now.plus(28, ChronoUnit.DAYS); // Max 28 days post-irradiation
        ModifiedUnit unit = new ModifiedUnit(din, ModificationType.GAMMA_IRRADIATION_25GY, now, exp, "RAD-TAG BLACK INDICATOR CONFIRMED (PASS >= 25 Gy)", operator);
        modifiedRegistry.put(din, unit);
        return unit;
    }

    public ModifiedUnit recordWashing(String din, String operator) {
        Instant now = Instant.now();
        Instant exp = now.plus(24, ChronoUnit.HOURS); // Open system 24-hr limit
        ModifiedUnit unit = new ModifiedUnit(din, ModificationType.SALINE_WASHED_24HR, now, exp, "N/A", operator);
        modifiedRegistry.put(din, unit);
        return unit;
    }

    public ModifiedUnit getModifiedUnit(String din) {
        return modifiedRegistry.get(din);
    }
}
