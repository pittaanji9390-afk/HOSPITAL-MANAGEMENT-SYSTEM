package com.hospital.controller.ed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmergencyTriageEsiQueueRestControllerTest {

    @Test
    void testGetQueue() {
        EmergencyTriageEsiQueueRestController controller = new EmergencyTriageEsiQueueRestController();
        var resp = controller.getQueue();
        assertNotNull(resp.getBody());
        assertEquals(3, resp.getBody().size());
        assertEquals(1, resp.getBody().get(0).getEsiTriageLevel());
    }
}
