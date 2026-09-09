package com.hospital.controller.pharmacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PharmacyMedicationAdministrationRestControllerTest {

    @Test
    void testBcmaVerification() {
        PharmacyMedicationAdministrationRestController controller = new PharmacyMedicationAdministrationRestController();
        var req = new PharmacyMedicationAdministrationRestController.BcmaVerificationRequest("BAR-PT-9941", "BAR-MED-1120", "RN-3021", null, 1.0, "Right Deltoid");
        var resp = controller.verifyAndAdminister(req);
        assertNotNull(resp.getBody());
        assertTrue(resp.getBody().isApproved());
        assertEquals("VERIFIED_AND_LOGGED", resp.getBody().getVerificationStatus());
    }
}
