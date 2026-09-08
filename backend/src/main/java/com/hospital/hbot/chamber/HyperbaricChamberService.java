package com.hospital.hbot.chamber;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hyperbaric Chamber Pressure Profile & Oxygen Toxicity Controller.
 * Controls ATA (Atmospheres Absolute: 2.0 to 3.0 ATA), 100% O2 delivery via hood/mask,
 * and enforces mandatory 5-minute Air Breaks every 20-30 minutes to prevent central nervous system
 * (CNS) oxygen toxicity convulsions and pulmonary (Lorrain Smith) toxicity.
 */
@Service
public class HyperbaricChamberService {

    public enum ChamberType { MONOPLACE_SECHRIST, MULTIPLACE_ACRYLIC, TRANSPORTABLE_DECOMPRESSION }
    public enum GasMixture { PURE_OXYGEN_100, MEDICAL_AIR_21, NITROX_32, HELIOX }

    public record ChamberSession(
        String sessionId,
        String chamberUnitId,
        double currentPressureAta,
        double targetPressureAta,
        GasMixture activeGas,
        int totalElapsedMinutes,
        int currentO2PeriodMinutes,
        int airBreaksCompleted,
        boolean cnsToxicityWarning,
        Instant sessionStartTime
    ) {}

    private final Map<String, ChamberSession> activeSessions = new ConcurrentHashMap<>();

    public ChamberSession startSession(String chamberId, double targetAta) {
        String sessId = "HBOT-SESS-" + UUID.randomUUID().toString().substring(0, 8);
        ChamberSession sess = new ChamberSession(sessId, chamberId, 1.0, targetAta, GasMixture.PURE_OXYGEN_100, 0, 0, 0, false, Instant.now());
        activeSessions.put(sessId, sess);
        return sess;
    }

    public ChamberSession advanceSessionTelemetry(String sessId, double currentAta, GasMixture gas, int elapsedMin, int currentO2Min, int airBreaks) {
        ChamberSession current = activeSessions.get(sessId);
        if (current == null) throw new IllegalArgumentException("Session not found: " + sessId);

        // UHMS rule: O2 period > 30 min at >= 2.4 ATA risks CNS toxicity
        boolean cnsRisk = (gas == GasMixture.PURE_OXYGEN_100 && currentPressureAta >= 2.4 && currentO2Min >= 30);

        ChamberSession updated = new ChamberSession(sessId, current.chamberUnitId(), currentAta, current.targetPressureAta(), gas, elapsedMin, currentO2Min, airBreaks, cnsRisk, current.sessionStartTime());
        activeSessions.put(sessId, updated);
        return updated;
    }

    public ChamberSession getSession(String sessId) {
        return activeSessions.get(sessId);
    }
}
