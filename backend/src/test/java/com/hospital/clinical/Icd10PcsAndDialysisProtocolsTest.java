package com.hospital.clinical;

import com.hospital.clinical.knowledge.Icd10PcsProcedureMaster;
import com.hospital.clinical.pathways.DialysisNephrologyProtocol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Icd10PcsAndDialysisProtocolsTest {

    private final Icd10PcsProcedureMaster pcsMaster = new Icd10PcsProcedureMaster();
    private final DialysisNephrologyProtocol dialysisProtocol = new DialysisNephrologyProtocol();

    @Test
    @DisplayName("ICD-10-PCS: Should retrieve CABG surgical code 0210093 with 7-character specification")
    void testCabgPcsLookup() {
        Optional<Icd10PcsProcedureMaster.PcsProcedure> proc = pcsMaster.findByCode("0210093");
        assertTrue(proc.isPresent());
        assertEquals("Bypass", proc.get().getRootOperation());
        assertEquals("Heart and Great Vessels", proc.get().getBodySystem());
        assertEquals("Open", proc.get().getApproach());
    }

    @Test
    @DisplayName("ICD-10-PCS: Should retrieve Laparoscopic Cholecystectomy code 0FT44ZZ")
    void testLapCholecystectomyLookup() {
        Optional<Icd10PcsProcedureMaster.PcsProcedure> proc = pcsMaster.findByCode("0FT44ZZ");
        assertTrue(proc.isPresent());
        assertEquals("Resection", proc.get().getRootOperation());
        assertEquals("Gallbladder", proc.get().getBodyPart());
        assertEquals("Percutaneous Endoscopic", proc.get().getApproach());
    }

    @Test
    @DisplayName("Dialysis: Should calculate safe UFR rate for 70 kg patient with 2.5 L fluid overload over 4 hours (~9.6 mL/kg/hr <= 13.0)")
    void testSafeUltrafiltrationRate() {
        // Pre-weight: 72.5 kg, Dry weight: 70.0 kg (2.5 L overload) + 200 mL rinseback = 2700 mL
        // UFR: 2700 / (72.5 * 4.0) = 9.3 mL/kg/hr
        DialysisNephrologyProtocol.UltrafiltrationResult ufr = dialysisProtocol.calculateUfr(72.5, 70.0, 4.0);

        assertNotNull(ufr);
        assertEquals(2.5, ufr.getFluidRemovalTargetLiters());
        assertTrue(ufr.getUltrafiltrationRateMlKgHr() <= 13.0);
        assertTrue(ufr.isUfrWithinSafeLimits());
    }

    @Test
    @DisplayName("Dialysis: Should flag excessive UFR (> 13.0 mL/kg/hr) for large fluid gain")
    void testExcessiveUltrafiltrationWarning() {
        // Pre-weight: 75.0 kg, Dry weight: 70.0 kg (5.0 L overload)
        // UFR: 5200 / (75.0 * 4.0) = 17.3 mL/kg/hr
        DialysisNephrologyProtocol.UltrafiltrationResult ufr = dialysisProtocol.calculateUfr(75.0, 70.0, 4.0);

        assertNotNull(ufr);
        assertFalse(ufr.isUfrWithinSafeLimits());
        assertTrue(ufr.getClinicalRecommendation().contains("WARNING: UFR exceeds safe threshold"));
    }

    @Test
    @DisplayName("Dialysis: Should calculate Daugirdas single-pool Kt/V dialyzer clearance adequacy (Target >= 1.2)")
    void testKtVClearanceCalculation() {
        // Pre-BUN: 70 mg/dL, Post-BUN: 20 mg/dL, 4 hours, 2.5 L UF, Post-weight: 70 kg
        double ktv = dialysisProtocol.calculateSinglePoolKtV(70.0, 20.0, 4.0, 2.5, 70.0);

        assertTrue(ktv >= 1.2); // Adequate clearance achieved
    }
}
