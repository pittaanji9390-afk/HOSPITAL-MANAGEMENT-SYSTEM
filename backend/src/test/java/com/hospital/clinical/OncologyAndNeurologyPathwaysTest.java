package com.hospital.clinical;

import com.hospital.clinical.pathways.OncologyChemoRegimens;
import com.hospital.clinical.pathways.StrokeNeurologyProtocol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OncologyAndNeurologyPathwaysTest {

    private final OncologyChemoRegimens oncologyEngine = new OncologyChemoRegimens();
    private final StrokeNeurologyProtocol strokeProtocol = new StrokeNeurologyProtocol();

    @Test
    @DisplayName("Oncology: Should accurately calculate BSA using Mosteller formula (Height 175 cm, Weight 70 kg -> ~1.84 m2)")
    void testMostellerBsaCalculation() {
        BigDecimal bsa = oncologyEngine.calculateBsaMosteller(175.0, 70.0);
        assertNotNull(bsa);
        assertEquals(BigDecimal.valueOf(1.84), bsa);
    }

    @Test
    @DisplayName("Oncology: Should calculate individual patient chemo dose based on BSA")
    void testIndividualChemoDoseCalculation() {
        BigDecimal bsa = BigDecimal.valueOf(1.84);
        // Doxorubicin standard dose 60 mg/m2 -> 60 * 1.84 = 110.4 mg
        BigDecimal individualDose = oncologyEngine.calculateIndividualDose(60.0, bsa);
        assertEquals(BigDecimal.valueOf(110.4), individualDose);
    }

    @Test
    @DisplayName("Oncology: Should retrieve standardized mFOLFOX6 colorectal protocol")
    void testFolfoxRegimenLookup() {
        Optional<OncologyChemoRegimens.OncologyRegimen> regimen = oncologyEngine.getRegimenByCode("FOLFOX_CRC");
        assertTrue(regimen.isPresent());
        assertEquals("mFOLFOX6 (Oxaliplatin + Leucovorin + 5-FU)", regimen.get().getRegimenName());
        assertEquals(14, regimen.get().getCycleLengthDays());
        assertEquals(4, regimen.get().getDrugs().size());
    }

    @Test
    @DisplayName("Stroke: Should evaluate NIHSS severe stroke and identify Large Vessel Occlusion (LVO)")
    void testNihssEvaluation() {
        StrokeNeurologyProtocol.NihssInput in = StrokeNeurologyProtocol.NihssInput.builder()
                .locConsciousness(1)
                .locQuestions(1)
                .locCommands(0)
                .bestGaze(1)
                .visualFields(1)
                .facialPalsy(2)
                .motorArmLeft(3)
                .motorArmRight(0)
                .motorLegLeft(3)
                .motorLegRight(0)
                .limbAtaxia(1)
                .sensoryLoss(1)
                .bestLanguage(1)
                .dysarthria(1)
                .extinctionInattention(1)
                .build();

        StrokeNeurologyProtocol.NihssResult res = strokeProtocol.evaluateNihss(in);

        assertNotNull(res);
        assertEquals(17, res.getTotalScore());
        assertEquals("MODERATE_TO_SEVERE_STROKE", res.getSeverityClassification());
        assertTrue(res.isLargeVesselOcclusionSuspected());
    }

    @Test
    @DisplayName("Stroke: Should calculate Alteplase weight-based 0.9 mg/kg dose with 10% bolus and 90% infusion")
    void testAlteplaseDosingCalculation() {
        // Patient weight 80 kg -> Total: 72.0 mg; Bolus: 7.2 mg; Infusion: 64.8 mg
        StrokeNeurologyProtocol.AlteplaseDose dose = strokeProtocol.calculateAlteplaseDosing(80.0);

        assertNotNull(dose);
        assertEquals(BigDecimal.valueOf(72.0), dose.getTotalDoseMg());
        assertEquals(BigDecimal.valueOf(7.2), dose.getIvBolusMg());
        assertEquals(BigDecimal.valueOf(64.8), dose.getIvInfusionMg());
        assertFalse(dose.isMaxDoseCapped());
    }

    @Test
    @DisplayName("Stroke: Should cap Alteplase dose at maximum 90.0 mg for patients > 100 kg")
    void testAlteplaseMaxDoseCapping() {
        // Patient weight 120 kg -> 120 * 0.9 = 108 mg -> Capped at 90.0 mg
        StrokeNeurologyProtocol.AlteplaseDose dose = strokeProtocol.calculateAlteplaseDosing(120.0);

        assertNotNull(dose);
        assertEquals(BigDecimal.valueOf(90.0), dose.getTotalDoseMg());
        assertEquals(BigDecimal.valueOf(9.0), dose.getIvBolusMg());
        assertEquals(BigDecimal.valueOf(81.0), dose.getIvInfusionMg());
        assertTrue(dose.isMaxDoseCapped());
    }
}
