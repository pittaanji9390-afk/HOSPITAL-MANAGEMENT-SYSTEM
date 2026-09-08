package com.hospital.controller.bloodbank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BloodBankTransfusionSafetyRestControllerTest {

    @Test
    void testGetUnits() {
        BloodBankTransfusionSafetyRestController controller = new BloodBankTransfusionSafetyRestController();
        var resp = controller.getUnits();
        assertNotNull(resp.getBody());
        assertEquals(2, resp.getBody().size());
    }
}
