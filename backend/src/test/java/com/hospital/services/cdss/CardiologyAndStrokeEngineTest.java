package com.hospital.services.cdss;

import com.hospital.services.cardiology.CardiologyHemodynamicsAndStemiEngine;
import com.hospital.services.neurology.NeurologyStrokeEvaluationEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardiologyAndStrokeEngineTest {

    private final CardiologyHemodynamicsAndStemiEngine cardioEngine = new CardiologyHemodynamicsAndStemiEngine();
    private final NeurologyStrokeEvaluationEngine neuroEngine = new NeurologyStrokeEvaluationEngine();

    @Test
    @DisplayName("Evaluate STEMI activation on ST elevation >= 1.5mm")
    void testStemiActivation() {
        var result = cardioEngine.evaluateStemi("PAT-9910", 2.8, "ANTERIOR", 65, true, 110.0, 95);
        assertNotNull(result);
        assertTrue(result.isCathLabActivated());
        assertEquals("ANTERIOR", result.getStemiTerritory());
        assertTrue(result.getTimiRiskScore() > 0);
    }

    @Test
    @DisplayName("Evaluate Acute Stroke IV tPA eligibility within 4.5h window")
    void testStrokeTpaEligibility() {
        var result = neuroEngine.evaluateAcuteStroke("MRN-5520", 14, 75.0, 2.1, false, 160.0);
        assertNotNull(result);
        assertTrue(result.isIvTpaCandidate());
        assertTrue(result.getCalculatedAlteplaseDoseMg() <= 90.0);
        assertEquals("MODERATE", result.getStrokeSeverityCategory());
    }
}
