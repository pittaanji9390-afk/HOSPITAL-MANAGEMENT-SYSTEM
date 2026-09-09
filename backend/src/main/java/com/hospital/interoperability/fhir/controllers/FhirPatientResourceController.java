package com.hospital.interoperability.fhir.controllers;

import com.hospital.patients.PatientController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Official HL7 FHIR R4 RESTful API Controller for 'Patient' Resource.
 * Dynamically serializes internal patient entities from database into FHIR R4 compliant JSON structures.
 */
@RestController
@RequestMapping("/fhir/r4/Patient")
@RequiredArgsConstructor
@Tag(name = "HL7 FHIR R4 - Patient", description = "FHIR R4 Patient resource endpoints conforming to HL7 standards")
public class FhirPatientResourceController {

    private final PatientController.PatientService patientService;

    @GetMapping("/{id}")
    @Operation(summary = "Read FHIR R4 Patient resource by ID")
    public ResponseEntity<Map<String, Object>> getFhirPatient(@PathVariable Long id) {
        PatientController.PatientDto p = patientService.getById(id);

        Map<String, Object> fhirPatient = new LinkedHashMap<>();
        fhirPatient.put("resourceType", "Patient");
        fhirPatient.put("id", String.valueOf(p.getId()));

        Map<String, Object> meta = new HashMap<>();
        meta.put("versionId", "1");
        meta.put("lastUpdated", p.getUpdatedAt() != null ? p.getUpdatedAt().toString() : "2026-09-08T12:00:00Z");
        fhirPatient.put("meta", meta);

        List<Map<String, Object>> identifiers = new ArrayList<>();
        Map<String, Object> mrnId = new HashMap<>();
        mrnId.put("use", "official");
        mrnId.put("system", "urn:oid:2.16.840.1.113883.4.1");
        mrnId.put("value", p.getMrn());
        identifiers.add(mrnId);
        fhirPatient.put("identifier", identifiers);

        List<Map<String, Object>> names = new ArrayList<>();
        Map<String, Object> nameMap = new HashMap<>();
        nameMap.put("use", "official");
        nameMap.put("family", p.getLastName());
        nameMap.put("given", List.of(p.getFirstName()));
        names.add(nameMap);
        fhirPatient.put("name", names);

        fhirPatient.put("gender", p.getGender() != null ? p.getGender().name().toLowerCase() : "unknown");
        fhirPatient.put("birthDate", p.getDob() != null ? p.getDob().toString() : "");
        fhirPatient.put("active", "ACTIVE".equalsIgnoreCase(p.getStatus() != null ? p.getStatus().name() : "ACTIVE"));

        return ResponseEntity.ok(fhirPatient);
    }
}
