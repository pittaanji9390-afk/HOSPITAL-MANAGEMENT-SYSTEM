package com.hospital.controller.radiology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/radiology/worklist")
@CrossOrigin(origins = "*")
public class RadiologyDicomWorklistRestController {

    @Data
    @AllArgsConstructor
    public static class ModalityWorklistItem {
        private String accessionNumber;
        private String patientId;
        private String modality; // CT, MR, XR, US, NM
        private String studyDescription;
        private String scheduledStationAeTitle;
        private String status; // SCHEDULED, IN_PROGRESS, COMPLETED, REPORTED
        private Instant scheduledDateTime;
    }

    private final Map<String, ModalityWorklistItem> worklist = new LinkedHashMap<>();

    public RadiologyDicomWorklistRestController() {
        worklist.put("ACC-77401", new ModalityWorklistItem("ACC-77401", "PT-9941", "CT", "CT Abdomen/Pelvis with IV Contrast", "CT_SOMATOM_01", "REPORTED", Instant.now().minusSeconds(86400)));
        worklist.put("ACC-77402", new ModalityWorklistItem("ACC-77402", "PT-8812", "XR", "STAT Portable Chest Radiograph 1 View", "XR_MOBILE_ICU", "SCHEDULED", Instant.now().plusSeconds(1800)));
    }

    @GetMapping
    public ResponseEntity<List<ModalityWorklistItem>> getWorklist() {
        return ResponseEntity.ok(new ArrayList<>(worklist.values()));
    }
}
