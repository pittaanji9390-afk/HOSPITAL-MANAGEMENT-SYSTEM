package com.hospital.controller.lab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/lab-specimens")
@CrossOrigin(origins = "*")
public class LaboratorySpecimenWorkflowRestController {

    @Data
    @AllArgsConstructor
    public static class LabSpecimenRecord {
        private String specimenBarcode;
        private String patientId;
        private String containerColor; // Gold SST, Lavender EDTA, Light Blue Sodium Citrate
        private String testPanelName;
        private String workflowStatus; // COLLECTED, RECEIVED_IN_LAB, ANALYZING, RESULTED, CRITICAL_ALERT
        private Instant collectedAt;
        private boolean isCriticalValueFlagged;
    }

    private final Map<String, LabSpecimenRecord> specimens = new LinkedHashMap<>();

    public LaboratorySpecimenWorkflowRestController() {
        specimens.put("SPEC-9921", new LabSpecimenRecord("SPEC-9921", "PT-9941", "Lavender EDTA", "Complete Blood Count (CBC)", "RESULTED", Instant.now().minusSeconds(3600), false));
        specimens.put("SPEC-9922", new LabSpecimenRecord("SPEC-9922", "PT-8812", "Light Blue Citrate", "STAT Coagulation PT/INR/PTT", "CRITICAL_ALERT", Instant.now().minusSeconds(1200), true));
    }

    @GetMapping
    public ResponseEntity<List<LabSpecimenRecord>> getAllSpecimens() {
        return ResponseEntity.ok(new ArrayList<>(specimens.values()));
    }
}
