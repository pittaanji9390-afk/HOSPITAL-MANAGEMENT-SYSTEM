package com.hospital.cssd.bi;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Biological Indicator (BI) & Chemical Indicator (CI) Quality Assurance Engine.
 * Tracks Geobacillus stearothermophilus (Steam/VHP) and Bacillus atrophaeus (EO/Dry Heat) spores
 * in 3M Attest / Steris Celerity 24-minute rapid-read auto-readers.
 */
@Service
public class BiologicalIndicatorService {

    public enum SporeOrganism { GEOBACILLUS_STEAROTHERMOPHILUS, BACILLUS_ATROPHAEUS }
    public enum BiResult { NEGATIVE_PASS, POSITIVE_GROWTH_FAIL, CONTROL_VALID_POSITIVE, PENDING_INCUBATION }

    public record BiTestRecord(
        String biTestId,
        String sterilizerUnitId,
        String cycleId,
        String lotNumber,
        SporeOrganism organism,
        String testPackType,
        int incubationDurationMinutes,
        BiResult result,
        String operatorStaffId,
        Instant loadTime,
        Instant readTime,
        boolean loadQuarantineReleased
    ) {}

    private final Map<String, BiTestRecord> testRecords = new ConcurrentHashMap<>();

    public BiologicalIndicatorService() {
        seedBiTests();
    }

    private void seedBiTests() {
        BiTestRecord bi1 = new BiTestRecord(
            "BI-TEST-998801",
            "AUTOCLAVE-STERIS-V120",
            "CYC-2026-0908-01",
            "LOT-2026-GBS-882",
            SporeOrganism.GEOBACILLUS_STEAROTHERMOPHILUS,
            "AAMI Challenge Process Pack (PCD)",
            24,
            BiResult.NEGATIVE_PASS,
            "TECH-CSSD-402",
            Instant.now().minusSeconds(2400),
            Instant.now().minusSeconds(960),
            true
        );
        testRecords.put(bi1.biTestId(), bi1);
    }

    public synchronized BiTestRecord logBiResult(String testId, BiResult result, String staffId) {
        BiTestRecord current = testRecords.get(testId);
        if (current == null) throw new IllegalArgumentException("BI Test record not found: " + testId);

        boolean released = (result == BiResult.NEGATIVE_PASS);
        BiTestRecord updated = new BiTestRecord(
            current.biTestId(), current.sterilizerUnitId(), current.cycleId(), current.lotNumber(),
            current.organism(), current.testPackType(), current.incubationDurationMinutes(),
            result, staffId, current.loadTime(), Instant.now(), released
        );
        testRecords.put(testId, updated);
        return updated;
    }

    public List<BiTestRecord> getAllBiRecords() {
        return new ArrayList<>(testRecords.values());
    }
}
