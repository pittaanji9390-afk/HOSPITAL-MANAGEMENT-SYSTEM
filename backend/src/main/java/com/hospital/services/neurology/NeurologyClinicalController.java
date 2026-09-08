package com.hospital.services.neurology;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/neurology")
public class NeurologyClinicalController {

    private final NeurologyStrokeEvaluationEngine engine;

    public NeurologyClinicalController(NeurologyStrokeEvaluationEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/stroke/evaluate")
    public ResponseEntity<NeurologyStrokeEvaluationEngine.StrokeProtocolAssessment> evaluateStroke(
            @RequestParam String patientMrn,
            @RequestParam(defaultValue = "14") int nihss,
            @RequestParam(defaultValue = "72.0") double weightKg,
            @RequestParam(defaultValue = "1.8") double hoursFromOnset,
            @RequestParam(defaultValue = "false") boolean hemorrhage,
            @RequestParam(defaultValue = "165.0") double systolicBp) {
        return ResponseEntity.ok(engine.evaluateAcuteStroke(patientMrn, nihss, weightKg, hoursFromOnset, hemorrhage, systolicBp));
    }
}
