package com.hospital.services.gastroenterology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/gastroenterology")
public class GastroenterologyClinicalController {

    private final GastroenterologyEndoscopyEngine engine;

    public GastroenterologyClinicalController(GastroenterologyEndoscopyEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/endoscopy/assess")
    public ResponseEntity<GastroenterologyEndoscopyEngine.GastroHepaticAssessment> assessGastro(
            @RequestParam String patientId,
            @RequestParam(defaultValue = "2.4") double bilirubin,
            @RequestParam(defaultValue = "1.6") double inr,
            @RequestParam(defaultValue = "1.5") double creatinine,
            @RequestParam(defaultValue = "132.0") double sodium,
            @RequestParam(defaultValue = "2.9") double albumin,
            @RequestParam(defaultValue = "false") boolean isFemale,
            @RequestParam(defaultValue = "IIa") String forrestCode) {
        return ResponseEntity.ok(engine.calculateMeldAndForrest(patientId, bilirubin, inr, creatinine, sodium, albumin, isFemale, forrestCode));
    }
}
