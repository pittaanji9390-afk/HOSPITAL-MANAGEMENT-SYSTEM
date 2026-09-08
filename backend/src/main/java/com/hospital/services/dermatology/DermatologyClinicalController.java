package com.hospital.services.dermatology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/dermatology")
public class DermatologyClinicalController {

    private final DermatologyWoundCareEngine engine;

    public DermatologyClinicalController(DermatologyWoundCareEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/skin/assess")
    public ResponseEntity<DermatologyWoundCareEngine.WoundAndSkinAssessment> assess(
            @RequestParam String patientId,
            @RequestParam(defaultValue = "2") int sensory,
            @RequestParam(defaultValue = "2") int moisture,
            @RequestParam(defaultValue = "2") int activity,
            @RequestParam(defaultValue = "2") int mobility,
            @RequestParam(defaultValue = "2") int nutrition,
            @RequestParam(defaultValue = "1") int friction,
            @RequestParam(defaultValue = "12.5") double pasi) {
        return ResponseEntity.ok(engine.assessSkin(patientId, sensory, moisture, activity, mobility, nutrition, friction, pasi));
    }
}
