package com.hospital.controller.clinical;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntensiveCareTelemetryStreamRestControllerTest {

    @Test
    void testGetBedTelemetryCurrent() {
        IntensiveCareTelemetryStreamRestController controller = new IntensiveCareTelemetryStreamRestController();
        var resp = controller.getBedTelemetryCurrent("ICU-Bed-04");
        assertNotNull(resp.getBody());
        assertEquals("ICU-Bed-04", resp.getBody().getBedId());
        assertEquals(78.0, resp.getBody().getHeartRateBpm());
    }
}
