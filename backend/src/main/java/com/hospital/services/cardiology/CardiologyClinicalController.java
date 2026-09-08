package com.hospital.services.cardiology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/clinical/cardiology")
public class CardiologyClinicalController {

    private final CardiologyHemodynamicsAndStemiEngine engine;

    public CardiologyClinicalController(CardiologyHemodynamicsAndStemiEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/stemi/triage")
    public ResponseEntity<CardiologyHemodynamicsAndStemiEngine.StemiDoorToBalloonTriage> triageStemi(
            @RequestParam String patientId,
            @RequestParam(defaultValue = "2.5") double stElevation,
            @RequestParam(defaultValue = "ANTERIOR") String territory,
            @RequestParam(defaultValue = "62") int age,
            @RequestParam(defaultValue = "true") boolean hasDiabetes,
            @RequestParam(defaultValue = "115") double systolicBp,
            @RequestParam(defaultValue = "88") int heartRate) {
        return ResponseEntity.ok(engine.evaluateStemi(patientId, stElevation, territory, age, hasDiabetes, systolicBp, heartRate));
    }
}
