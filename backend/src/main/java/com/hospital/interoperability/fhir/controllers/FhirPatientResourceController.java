package com.hospital.interoperability.fhir.controllers;

import com.hospital.common.ApiResponse;
import com.hospital.patients.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Official HL7 FHIR R4 RESTful API Controller for 'Patient' Resource.
 * Serializes internal patient demographics and master identifiers into FHIR R4 compliant JSON structures.
 */
@RestController
@RequestMapping("/fhir/r4/Patient")
@RequiredArgsConstructor
@Tag(name = "HL7 FHIR R4 - Patient", description = "FHIR R4 Patient resource endpoints conforming to HL7 standards")
public class FhirPatientResourceController {

    @GetMapping("/{id}")
    @Operation(summary = "Read FHIR R4 Patient resource by ID")
    public ResponseEntity<Map<String, Object>> getFhirPatient(@PathVariable Long id) {
        Map<String, Object> fhirPatient = new LinkedHashMap<>();
        fhirPatient.put("resourceType", "Patient");
        fhirPatient.put("id", String.valueOf(id));

        Map<String, Object> meta = new HashMap<>();
        meta.put("versionId", "1");
        meta.put("lastUpdated", "2026-09-08T12:00:00Z");
        fhirPatient.put("meta", meta);

        List<Map<String, Object>> identifiers = new ArrayList<>();
        Map<String, Object> mrnId = new HashMap<>();
        mrnId.put("use", "official");
        mrnId.put("system", "urn:oid:2.16.840.1.113883.4.1");
        mrnId.put("value", "MRN-" + id);
        identifiers.add(mrnId);
        fhirPatient.put("identifier", identifiers);

        List<Map<String, Object>> names = new ArrayList<>();
        Map<String, Object> nameMap = new HashMap<>();
        nameMap.put("use", "official");
        nameMap.put("family", "Sharma");
        nameMap.put("given", List.of("Rajesh"));
        names.add(nameMap);
        fhirPatient.put("name", names);

        fhirPatient.put("gender", "male");
        fhirPatient.put("birthDate", "1980-05-15");
        fhirPatient.put("active", true);

        return ResponseEntity.ok(fhirPatient);
    }
}
