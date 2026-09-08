package com.hospital.services.psychiatry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/psychiatry")
public class PsychiatryClinicalController {

    private final PsychiatryAssessmentEngine engine;

    public PsychiatryClinicalController(PsychiatryAssessmentEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/screen")
    public ResponseEntity<PsychiatryAssessmentEngine.MentalHealthEvaluation> screen(
            @RequestParam String patientMrn,
            @RequestParam(defaultValue = "18") int phq9,
            @RequestParam(defaultValue = "14") int gad7,
            @RequestParam(defaultValue = "12") int ciwa,
            @RequestParam(defaultValue = "true") boolean suicidal) {
        return ResponseEntity.ok(engine.evaluateMentalHealth(patientMrn, phq9, gad7, ciwa, suicidal));
    }
}
