package com.hospital.services.cdss;

import com.hospital.services.dialysis.DialysisPrescriptionAndKtVEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NephrologyAndDialysisTest {

    private final NephrologyCdssRulesEngine akiEngine = new NephrologyCdssRulesEngine();
    private final DialysisPrescriptionAndKtVEngine hdEngine = new DialysisPrescriptionAndKtVEngine();

    @Test
    @DisplayName("Verify KDIGO Stage 3 AKI when Creatinine triples")
    void testAkiStage3() {
        var report = akiEngine.evaluateRenalStatus("MRN-8812", 1.0, 3.2, 0.2, 24, 60, false);
        assertNotNull(report);
        assertEquals("KDIGO_AKI_STAGE_3", report.getKdigoAkiStage());
    }

    @Test
    @DisplayName("Verify Hemodialysis adequacy spKt/V >= 1.2")
    void testDialysisAdequacy() {
        var report = hdEngine.calculateAdequacy(70.0, 20.0, 4.0, 2.5, 70.0);
        assertNotNull(report);
        assertTrue(report.getSinglePoolSpKtV() >= 1.2);
        assertTrue(report.isAdequateDoseDelivered());
    }
}
