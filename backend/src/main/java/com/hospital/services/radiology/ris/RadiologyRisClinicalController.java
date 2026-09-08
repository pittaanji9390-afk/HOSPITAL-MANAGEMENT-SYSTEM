package com.hospital.services.radiology.ris;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/radiology/ris")
public class RadiologyRisClinicalController {

    private final RadiologyDoseAndAppropriatenessEngine engine;

    public RadiologyRisClinicalController(RadiologyDoseAndAppropriatenessEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/order/validate")
    public ResponseEntity<RadiologyDoseAndAppropriatenessEngine.RadiologyOrderValidation> validateOrder(
            @RequestParam String accession,
            @RequestParam(defaultValue = "CT") String modality,
            @RequestParam(defaultValue = "8") int acrScore,
            @RequestParam(defaultValue = "7.5") double examDose,
            @RequestParam(defaultValue = "42.0") double priorDose) {
        return ResponseEntity.ok(engine.validateExam(accession, modality, acrScore, examDose, priorDose));
    }
}
