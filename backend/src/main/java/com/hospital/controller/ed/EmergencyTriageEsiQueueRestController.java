package com.hospital.controller.ed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/emergency/triage-queue")
@CrossOrigin(origins = "*")
public class EmergencyTriageEsiQueueRestController {

    @Data
    @AllArgsConstructor
    public static class EdTriagePatient {
        private String trackingId;
        private String patientName;
        private int esiTriageLevel; // 1 (Resuscitation), 2 (Emergent), 3 (Urgent), 4 (Less Urgent), 5 (Non-Urgent)
        private String chiefComplaint;
        private Instant arrivalTime;
        private String assignedEdBay;
        private int waitingTimeMinutes;
    }

    private final Map<String, EdTriagePatient> queue = new LinkedHashMap<>();

    public EmergencyTriageEsiQueueRestController() {
        queue.put("ED-001", new EdTriagePatient("ED-001", "John Doe (Trauma)", 1, "Severe Hemorrhagic Shock / GCS 6", Instant.now().minusSeconds(600), "Trauma Bay 1", 10));
        queue.put("ED-002", new EdTriagePatient("ED-002", "Sarah Jenkins", 2, "Crushing Retrosternal Chest Pain", Instant.now().minusSeconds(1200), "Cardiac Bay 2", 20));
        queue.put("ED-003", new EdTriagePatient("ED-003", "David Miller", 3, "Right Lower Quadrant Abdominal Pain / Fever", Instant.now().minusSeconds(2400), "Waiting Room", 40));
    }

    @GetMapping
    public ResponseEntity<List<EdTriagePatient>> getQueue() {
        return ResponseEntity.ok(new ArrayList<>(queue.values()));
    }
}
