package com.hospital.services.orthopedics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clinical/orthopedics")
public class OrthopedicsClinicalController {

    private final OrthopedicsJointRegistryEngine engine;

    public OrthopedicsClinicalController(OrthopedicsJointRegistryEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/arthroplasty/evaluate")
    public ResponseEntity<OrthopedicsJointRegistryEngine.JointArthroplastyAssessment> evaluate(
            @RequestParam String registryId,
            @RequestParam(defaultValue = "HIP") String joint,
            @RequestParam(defaultValue = "44.0") double pain,
            @RequestParam(defaultValue = "38.0") double function,
            @RequestParam(defaultValue = "4.0") double deformity,
            @RequestParam(defaultValue = "5.0") double motion,
            @RequestParam(defaultValue = "CERAMIC_ON_POLYETHYLENE") String bearing) {
        return ResponseEntity.ok(engine.evaluateJoint(registryId, joint, pain, function, deformity, motion, bearing));
    }
}
