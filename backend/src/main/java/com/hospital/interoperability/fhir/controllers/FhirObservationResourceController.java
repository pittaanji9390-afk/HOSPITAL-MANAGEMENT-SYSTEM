package com.hospital.interoperability.fhir.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Official HL7 FHIR R4 RESTful API Controller for 'Observation' Resource.
 * Exposes clinical vital signs, lab pathology results, and diagnostic measurements.
 */
@RestController
@RequestMapping("/fhir/r4/Observation")
@RequiredArgsConstructor
@Tag(name = "HL7 FHIR R4 - Observation", description = "FHIR R4 Observation endpoints for vitals and laboratory observations")
public class FhirObservationResourceController {

    @GetMapping("/{id}")
    @Operation(summary = "Read FHIR R4 Observation by ID")
    public ResponseEntity<Map<String, Object>> getObservation(@PathVariable Long id) {
        Map<String, Object> obs = new LinkedHashMap<>();
        obs.put("resourceType", "Observation");
        obs.put("id", String.valueOf(id));
        obs.put("status", "final");

        Map<String, Object> code = new HashMap<>();
        Map<String, Object> coding = new HashMap<>();
        coding.put("system", "http://loinc.org");
        coding.put("code", "85354-9");
        coding.put("display", "Blood pressure panel with all children optional");
        code.put("coding", List.of(coding));
        obs.put("code", code);

        Map<String, Object> subject = new HashMap<>();
        subject.put("reference", "Patient/1");
        obs.put("subject", subject);

        obs.put("effectiveDateTime", "2026-09-08T12:30:00Z");

        return ResponseEntity.ok(obs);
    }
}
