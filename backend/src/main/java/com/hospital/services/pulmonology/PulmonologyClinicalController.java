package com.hospital.services.pulmonology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/pulmonology")
public class PulmonologyClinicalController {

    private final PulmonologyVentilatorWeaningEngine engine;

    public PulmonologyClinicalController(PulmonologyVentilatorWeaningEngine engine) {
        this.engine = engine;
    }

    @GetMapping("/ventilator/weaning-status")
    public ResponseEntity<PulmonologyVentilatorWeaningEngine.VentilatorWeaningReadiness> getWeaningStatus(
            @RequestParam String patientId,
            @RequestParam(defaultValue = "92.0") double paO2,
            @RequestParam(defaultValue = "0.40") double fiO2,
            @RequestParam(defaultValue = "18") double respRate,
            @RequestParam(defaultValue = "0.45") double tidalVol,
            @RequestParam(defaultValue = "5.0") double peep) {
        return ResponseEntity.ok(engine.assessWeaning(patientId, paO2, fiO2, respRate, tidalVol, peep));
    }
}
