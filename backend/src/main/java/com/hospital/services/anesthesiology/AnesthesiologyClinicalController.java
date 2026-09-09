package com.hospital.services.anesthesiology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/anesthesiology")
public class AnesthesiologyClinicalController {

    private final AnesthesiologyPerioperativeEngine engine;

    public AnesthesiologyClinicalController(AnesthesiologyPerioperativeEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/pacu/aldrete")
    public ResponseEntity<AnesthesiologyPerioperativeEngine.AnesthesiaPacuReport> evaluatePacu(
            @RequestParam String caseId,
            @RequestParam(defaultValue = "ASA_III") String asa,
            @RequestParam(defaultValue = "2") int mallampati,
            @RequestParam(defaultValue = "2") int activity,
            @RequestParam(defaultValue = "2") int respiration,
            @RequestParam(defaultValue = "2") int circulation,
            @RequestParam(defaultValue = "2") int consciousness,
            @RequestParam(defaultValue = "2") int o2Sat) {
        return ResponseEntity.ok(engine.assessAnesthesia(caseId, asa, mallampati, activity, respiration, circulation, consciousness, o2Sat));
    }
}
