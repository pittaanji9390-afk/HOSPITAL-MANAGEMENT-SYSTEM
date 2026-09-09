package com.hospital.controller.surgery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SurgicalOperatingTheaterScheduleRestControllerTest {

    @Test
    void testGetCases() {
        SurgicalOperatingTheaterScheduleRestController controller = new SurgicalOperatingTheaterScheduleRestController();
        var resp = controller.getCases();
        assertNotNull(resp.getBody());
        assertEquals(2, resp.getBody().size());
    }
}
