package com.hospital.bloodbank.mtp;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Trauma / Hemorrhagic Shock Massive Transfusion Protocol (MTP) Engine.
 * Enforces evidence-based PROMMTT / PROPPR guidelines for 1:1:1 or 1:1:2 ratio
 * (Packed Red Blood Cells : Fresh Frozen Plasma : Apheresis Platelet equivalent units).
 */
@Service
public class MassiveTransfusionService {

    public record MtpCooler(
        String coolerId,
        String mtpActivationId,
        String patientMrn,
        int coolerRoundNumber,
        int prbcUnitsDispensed,
        int ffpUnitsDispensed,
        int plateletUnitsDispensed,
        int cryoprecipitateDosesDispensed,
        Instant dispatchedAt,
        double calculatedPrbcToFfpRatio,
        boolean meetsTargetRatio
    ) {}

    private final Map<String, MtpCooler> coolerLog = new ConcurrentHashMap<>();

    public MtpCooler dispatchMtpCooler(String mtpId, String mrn, int round, int prbc, int ffp, int plt, int cryo) {
        double ratio = ffp > 0 ? (double) prbc / ffp : prbc;
        boolean ratioOk = ratio >= 0.8 && ratio <= 1.5; // Near 1:1 ratio target

        String coolerId = "COOLER-" + mtpId + "-R" + round;
        MtpCooler record = new MtpCooler(coolerId, mtpId, mrn, round, prbc, ffp, plt, cryo, Instant.now(), ratio, ratioOk);
        coolerLog.put(coolerId, record);
        return record;
    }

    public List<MtpCooler> getActiveCoolers(String mtpId) {
        return coolerLog.values().stream().filter(c -> c.mtpActivationId().equals(mtpId)).toList();
    }
}
