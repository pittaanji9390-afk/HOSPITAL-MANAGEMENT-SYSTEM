package com.hospital.services.ophthalmology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/ophthalmology")
public class OphthalmologyClinicalController {

    private final OphthalmologyEyeExamEngine engine;

    public OphthalmologyClinicalController(OphthalmologyEyeExamEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/exam/summary")
    public ResponseEntity<OphthalmologyEyeExamEngine.EyeExaminationSummary> getExamSummary(
            @RequestParam String patientMrn,
            @RequestParam(defaultValue = "24.0") double odIop,
            @RequestParam(defaultValue = "18.0") double osIop,
            @RequestParam(defaultValue = "20/40") String odSnellen,
            @RequestParam(defaultValue = "20/20") String osSnellen,
            @RequestParam(defaultValue = "MODERATE_NPDR") String etdrsStage) {
        return ResponseEntity.ok(engine.processEyeExam(patientMrn, odIop, osIop, odSnellen, osSnellen, etdrsStage));
    }
}
