package com.hospital.controller.surgery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/surgical/theater-schedule")
@CrossOrigin(origins = "*")
public class SurgicalOperatingTheaterScheduleRestController {

    @Data
    @AllArgsConstructor
    public static class OperatingTheaterCase {
        private String caseId;
        private String operatingRoomNumber; // OR-1, OR-2, Robotic Suite
        private String patientId;
        private String primarySurgeon;
        private String procedureName;
        private String intraopStatus; // PREOP_HOLDING, IN_OR, TIMEOUT_COMPLETED, SURGERY_IN_PROGRESS, CLOSING, IN_PACU
        private Instant scheduledStartTime;
        private int estimatedDurationMinutes;
    }

    private final Map<String, OperatingTheaterCase> cases = new LinkedHashMap<>();

    public SurgicalOperatingTheaterScheduleRestController() {
        cases.put("SURG-901", new OperatingTheaterCase("SURG-901", "OR-3 (Cardiac Suite)", "PT-8812", "Dr. Preston Burke", "Emergency Coronary Artery Bypass Graft (CABG x3)", "SURGERY_IN_PROGRESS", Instant.now().minusSeconds(3600), 240));
        cases.put("SURG-902", new OperatingTheaterCase("SURG-902", "OR-1 (Trauma Suite)", "PT-3091", "Dr. Callie Torres", "Open Reduction Internal Fixation (ORIF) Left Femur", "PREOP_HOLDING", Instant.now().plusSeconds(1800), 120));
    }

    @GetMapping
    public ResponseEntity<List<OperatingTheaterCase>> getCases() {
        return ResponseEntity.ok(new ArrayList<>(cases.values()));
    }
}
