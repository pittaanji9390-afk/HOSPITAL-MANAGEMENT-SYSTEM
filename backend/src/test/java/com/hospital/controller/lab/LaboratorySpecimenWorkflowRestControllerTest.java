package com.hospital.controller.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LaboratorySpecimenWorkflowRestControllerTest {

    @Test
    void testGetAllSpecimens() {
        LaboratorySpecimenWorkflowRestController controller = new LaboratorySpecimenWorkflowRestController();
        var resp = controller.getAllSpecimens();
        assertNotNull(resp.getBody());
        assertEquals(2, resp.getBody().size());
    }
}
