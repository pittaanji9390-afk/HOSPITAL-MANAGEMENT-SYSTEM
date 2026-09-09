package com.hospital.controller.clinical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InpatientOrderEntryCpoeRestControllerTest {

    private InpatientOrderEntryCpoeRestController controller;

    @BeforeEach
    void setUp() {
        controller = new InpatientOrderEntryCpoeRestController();
    }

    @Test
    void testPlaceAndQueryOrders() {
        var req = new InpatientOrderEntryCpoeRestController.CpoeOrderRequest("PT-7712", "DR-7719", "MEDICATION", "RX-7980", "Vancomycin 1.5g IV Q12H", "Infuse over 2h", "ROUTINE");
        var resp = controller.placeOrder(req);
        assertNotNull(resp.getBody());
        assertEquals("PENDING_VERIFICATION", resp.getBody().getStatus());

        var listResp = controller.getOrdersByPatient("PT-7712");
        assertEquals(1, listResp.getBody().size());
    }
}
