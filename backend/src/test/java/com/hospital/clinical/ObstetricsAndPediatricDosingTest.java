package com.hospital.clinical;

import com.hospital.clinical.pathways.ObstetricsLaborDeliveryProtocols;
import com.hospital.clinical.pathways.PediatricNeonatalDosingEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstetricsAndPediatricDosingTest {

    private final ObstetricsLaborDeliveryProtocols obstetricsProtocols = new ObstetricsLaborDeliveryProtocols();
    private final PediatricNeonatalDosingEngine pediatricDosingEngine = new PediatricNeonatalDosingEngine();

    @Test
    @DisplayName("Obstetrics: Should calculate favorable Bishop Score (>= 8) for spontaneous labor induction")
    void testFavorableBishopScore() {
        ObstetricsLaborDeliveryProtocols.BishopScoreInput in = ObstetricsLaborDeliveryProtocols.BishopScoreInput.builder()
                .cervicalDilationCm(4)      // Score: 2
                .cervicalEffacementPct(80)  // Score: 3
                .fetalStation(1)            // Score: 3
                .consistency(ObstetricsLaborDeliveryProtocols.CervicalConsistency.SOFT) // Score: 2
                .position(ObstetricsLaborDeliveryProtocols.CervicalPosition.ANTERIOR)   // Score: 2
                .build();

        ObstetricsLaborDeliveryProtocols.BishopScoreResult res = obstetricsProtocols.calculateBishopScore(in);

        assertNotNull(res);
        assertEquals(12, res.getTotalScore());
        assertTrue(res.getRipenessInterpretation().contains("FAVORABLE_CERVIX"));
        assertTrue(res.getRecommendedInductionMethod().contains("Oxytocin"));
    }

    @Test
    @DisplayName("Obstetrics: Should calculate APGAR score and identify reassuring newborn transition (Score 9)")
    void testReassuringApgarScore() {
        ObstetricsLaborDeliveryProtocols.ApgarInput in = ObstetricsLaborDeliveryProtocols.ApgarInput.builder()
                .appearanceSkinColor(1) // Pink body, blue extremities (acrocyanosis)
                .pulseHeartRate(2)      // > 100 bpm
                .grimaceReflex(2)       // Vigorous cry
                .activityMuscleTone(2)  // Active flexion
                .respirationEffort(2)   // Strong cry
                .build();

        ObstetricsLaborDeliveryProtocols.ApgarResult res = obstetricsProtocols.calculateApgar(in);

        assertNotNull(res);
        assertEquals(9, res.getTotalScore());
        assertEquals("REASSURING (Normal newborn transition)", res.getStatus());
    }

    @Test
    @DisplayName("Pediatrics: Should calculate accurate Holliday-Segar 4-2-1 maintenance fluid requirement for 25 kg child (1600 mL/day, 65 mL/hr)")
    void testHollidaySegarFluidCalculation() {
        // Child weight 25 kg:
        // First 10 kg: 1000 mL (40 mL/hr)
        // Next 10 kg: 500 mL (20 mL/hr)
        // Next 5 kg: 5 * 20 = 100 mL (5 mL/hr)
        // Total: 1600 mL/day, 65 mL/hr
        PediatricNeonatalDosingEngine.FluidRequirement fluids = pediatricDosingEngine.calculateHollidaySegarFluids(25.0);

        assertNotNull(fluids);
        assertEquals(1600.0, fluids.getDailyVolumeMl());
        assertEquals(65.0, fluids.getHourlyRateMlHr());
        assertTrue(fluids.getRecommendedFluid().contains("0.45% Normal Saline"));
    }

    @Test
    @DisplayName("Pediatrics: Should calculate Paracetamol 15 mg/kg weight-based dose with adult capping")
    void testPediatricWeightBasedDosing() {
        // Child 20 kg @ 15 mg/kg -> 300 mg per dose, Q6H
        PediatricNeonatalDosingEngine.PediatricDoseResult dose = pediatricDosingEngine.calculatePediatricDose(
                "Paracetamol Syrup", 20.0, 15.0, 4, 1000.0);

        assertNotNull(dose);
        assertEquals(300.0, dose.getSingleDoseMg());
        assertEquals(1200.0, dose.getTotalDailyDoseMg());
        assertFalse(dose.isDoseExceedsAdultMax());
    }
}
