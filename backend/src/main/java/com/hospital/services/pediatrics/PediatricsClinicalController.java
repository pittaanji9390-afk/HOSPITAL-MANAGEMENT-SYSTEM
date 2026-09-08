package com.hospital.services.pediatrics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/pediatrics")
public class PediatricsClinicalController {

    private final PediatricsNicuManagementEngine engine;

    public PediatricsClinicalController(PediatricsNicuManagementEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/nicu/assessment")
    public ResponseEntity<PediatricsNicuManagementEngine.NeonatalAssessment> evaluateBaby(
            @RequestParam String babyMrn,
            @RequestParam(defaultValue = "7") int apgar1,
            @RequestParam(defaultValue = "9") int apgar5,
            @RequestParam(defaultValue = "1850.0") double birthWeightGrams,
            @RequestParam(defaultValue = "33") int gaWeeks,
            @RequestParam(defaultValue = "9.5") double bili,
            @RequestParam(defaultValue = "10.0") double dextrosePct,
            @RequestParam(defaultValue = "8.0") double infusionRate) {
        return ResponseEntity.ok(engine.calculateNicuParameters(babyMrn, apgar1, apgar5, birthWeightGrams, gaWeeks, bili, dextrosePct, infusionRate));
    }
}
