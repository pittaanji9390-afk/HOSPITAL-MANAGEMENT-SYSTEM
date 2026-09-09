package com.hospital.controller.radiology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadiologyDicomWorklistRestControllerTest {

    @Test
    void testGetWorklist() {
        RadiologyDicomWorklistRestController controller = new RadiologyDicomWorklistRestController();
        var resp = controller.getWorklist();
        assertNotNull(resp.getBody());
        assertEquals(2, resp.getBody().size());
    }
}
