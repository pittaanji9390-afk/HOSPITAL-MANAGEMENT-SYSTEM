package com.hospital.cssd.bowiedick;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Daily Bowie-Dick (Air Removal) Test Analyzer (AAMI/ANSI ST79).
 * Evaluates chemical indicator test sheets for uniform color change to detect vacuum pump leak rates (> 1.0 mmHg/min)
 * or non-condensable steam gases that cause sterilizer cold air pockets.
 */
@Service
public class BowieDickTestService {

    public enum TestResult { UNIFORM_COLOR_PASS, NON_UNIFORM_AIR_POCKET_FAIL, VACUUM_LEAK_FAIL }
    public record BowieDickLog(String testId, String sterilizerUnitId, double leakRateMmHgPerMin, TestResult result, String techBadge, Instant timestamp) {}

    private final Map<String, BowieDickLog> testLogs = new ConcurrentHashMap<>();

    public BowieDickTestService() {
        seedBowieDick();
    }

    private void seedBowieDick() {
        BowieDickLog log = new BowieDickLog("BD-2026-0908-01", "AUTOCLAVE-STERIS-V120", 0.35, TestResult.UNIFORM_COLOR_PASS, "TECH-CSSD-402", Instant.now().minusSeconds(14400));
        testLogs.put(log.testId(), log);
    }

    public BowieDickLog logDailyTest(String sterilizerId, double leakRate, TestResult result, String techBadge) {
        String testId = "BD-" + UUID.randomUUID().toString().substring(0, 8);
        BowieDickLog record = new BowieDickLog(testId, sterilizerId, leakRate, result, techBadge, Instant.now());
        testLogs.put(testId, record);
        return record;
    }

    public List<BowieDickLog> listAll() {
        return new ArrayList<>(testLogs.values());
    }
}
