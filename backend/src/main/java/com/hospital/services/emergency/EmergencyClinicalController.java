package com.hospital.services.emergency;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/emergency")
public class EmergencyClinicalController {

    private final EmergencyTraumaTriageEngine engine;

    public EmergencyClinicalController(EmergencyTraumaTriageEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/triage/calculate")
    public ResponseEntity<EmergencyTraumaTriageEngine.EmergencyTriageReport> calculateTriage(
            @RequestParam String encounterId,
            @RequestParam(defaultValue = "false") boolean lifesaving,
            @RequestParam(defaultValue = "true") boolean highRisk,
            @RequestParam(defaultValue = "3") int resources,
            @RequestParam(defaultValue = "14") int gcs,
            @RequestParam(defaultValue = "95.0") double sbp,
            @RequestParam(defaultValue = "22") int rr) {
        return ResponseEntity.ok(engine.calculateEsiAndTrauma(encounterId, lifesaving, highRisk, resources, gcs, sbp, rr));
    }
}
