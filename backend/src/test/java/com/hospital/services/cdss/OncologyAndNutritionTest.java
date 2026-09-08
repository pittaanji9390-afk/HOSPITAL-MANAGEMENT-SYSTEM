package com.hospital.services.cdss;

import com.hospital.services.nutrition.ClinicalNutritionAndTpnCalculationEngine;
import com.hospital.services.oncology.ChemotherapyBsaAndCalvertDosingEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OncologyAndNutritionTest {

    private final ChemotherapyBsaAndCalvertDosingEngine chemoEngine = new ChemotherapyBsaAndCalvertDosingEngine();
    private final ClinicalNutritionAndTpnCalculationEngine tpnEngine = new ClinicalNutritionAndTpnCalculationEngine();

    @Test
    @DisplayName("Verify Mosteller BSA & Calvert Carboplatin AUC calculation")
    void testChemoDosing() {
        var dosing = chemoEngine.calculateChemoDosing(175.0, 70.0, 90.0, 5.0, 300.0);
        assertNotNull(dosing);
        assertEquals(1.84, dosing.getBodySurfaceAreaM2(), 0.05);
        assertTrue(dosing.isWithinSafeLifetimeToxicityCap());
    }

    @Test
    @DisplayName("Verify TPN Mifflin-St Jeor caloric formulation")
    void testTpnCalculation() {
        var tpn = tpnEngine.calculateTpnRegimen(75.0, 180.0, 50, true, 1.3);
        assertNotNull(tpn);
        assertTrue(tpn.getTargetDailyCaloriesKcal() > 1500.0);
        assertTrue(tpn.getAminoAcidGrams() > 100.0);
    }
}
