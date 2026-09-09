package com.hospital.controller.billing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BillingClaimsAnsiX12RestControllerTest {

    @Test
    void testGetClaims() {
        BillingClaimsAnsiX12RestController controller = new BillingClaimsAnsiX12RestController();
        var resp = controller.getClaims();
        assertNotNull(resp.getBody());
        assertEquals(2, resp.getBody().size());
    }
}
