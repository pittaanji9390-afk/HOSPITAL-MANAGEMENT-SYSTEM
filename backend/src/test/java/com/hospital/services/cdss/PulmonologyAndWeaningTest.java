package com.hospital.services.cdss;

import com.hospital.services.pulmonology.PulmonologyVentilatorWeaningEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PulmonologyAndWeaningTest {

    private final PulmonologyVentilatorWeaningEngine engine = new PulmonologyVentilatorWeaningEngine();

    @Test
    @DisplayName("Verify Spontaneous Breathing Trial (SBT) readiness when RSBI < 105 and P/F >= 200")
    void testExtubationReadinessSuccess() {
        var result = engine.assessWeaning("ICU-BED-04", 95.0, 0.40, 16, 0.50, 5.0);
        assertNotNull(result);
        assertTrue(result.isSbtExtubationReady());
        assertTrue(result.getRapidShallowBreathingIndexRsbi() < 105.0);
    }

    @Test
    @DisplayName("Verify ARDS severity grading on low P/F ratio")
    void testArdsSevereClassification() {
        var result = engine.assessWeaning("ICU-BED-09", 60.0, 0.80, 32, 0.35, 14.0);
        assertNotNull(result);
        assertEquals("SEVERE_ARDS", result.getArdsSeverityGrade());
        assertFalse(result.isSbtExtubationReady());
    }
}
