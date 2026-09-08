package com.hospital.controller.clinical;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ClinicalAdmissionEpisodeRestControllerTest {

    private ClinicalAdmissionEpisodeRestController controller;

    @BeforeEach
    void setUp() {
        controller = new ClinicalAdmissionEpisodeRestController();
    }

    @Test
    void testGetAllAdmissions() {
        ResponseEntity<List<ClinicalAdmissionEpisodeRestController.AdmissionResponseDto>> response = controller.getAllAdmissions();
        assertNotNull(response.getBody());
        assertTrue(response.getBody().size() >= 2);
    }

    @Test
    void testCreateAdmission() {
        ClinicalAdmissionEpisodeRestController.AdmissionRequestDto req = new ClinicalAdmissionEpisodeRestController.AdmissionRequestDto(
            "PT-3091", "DR-101", "Cardiology", "TELE-05", "EMERGENCY", "Chest Pain", "3"
        );
        var resp = controller.createAdmission(req);
        assertNotNull(resp.getBody());
        assertEquals("INPATIENT_ACTIVE", resp.getBody().getStatus());
        assertEquals("PT-3091", resp.getBody().getPatientId());
    }
}
