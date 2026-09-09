package com.hospital.bloodbank.coldchain;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * AABB 30-Minute Return Rule & Blood Bag Time-Temperature Indicator (TTI / Safe-T-Vue) Evaluator.
 * If un-transfused blood is returned within 30 minutes and core temperature <= 10°C, unit can be restocked.
 */
@Service
public class ColdChainTrackerService {

    public record BloodReturnAssessment(String din, Instant checkedOutTime, Instant returnedTime, double surfaceTempCelsius, boolean ttiTagTriggered, boolean eligibleForRestock, String disposition) {}

    public BloodReturnAssessment evaluateReturn(String din, Instant checkedOut, double temp, boolean ttiRed) {
        long minutesOut = ChronoUnit.MINUTES.between(checkedOut, Instant.now());
        boolean restockable = minutesOut <= 30 && temp <= 10.0 && !ttiRed;

        String disposition = restockable ? "ACCEPTED FOR RE-INVENTORY: Cold-chain verified within 30-min window." : "QUARANTINE / DISCARD: Exceeded 30-min ambient exposure or temperature > 10°C.";

        return new BloodReturnAssessment(din, checkedOut, Instant.now(), temp, ttiRed, restockable, disposition);
    }
}
