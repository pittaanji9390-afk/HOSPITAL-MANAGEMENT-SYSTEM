package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirDiagnosticReportTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirDiagnosticReportResource {
        private String resourceType; // "DiagnosticReport"
        private String id;
        private String status; // "final"
        private List<Map<String, Object>> category; // LAB, RAD
        private Map<String, Object> code; // LOINC Panel
        private Map<String, String> subject; // Patient ref
        private Instant effectiveDateTime;
        private Instant issued;
        private List<Map<String, String>> result; // Observation references
        private String conclusion;
    }

    public FhirDiagnosticReportResource toFhirReport(String id, String patientId, String panelLoinc, String panelName, List<String> obsIds, String conclusionText) {
        List<Map<String, Object>> cat = List.of(Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/v2-0074", "code", "LAB"))));
        Map<String, Object> cd = Map.of("coding", List.of(Map.of("system", "http://loinc.org", "code", panelLoinc, "display", panelName)));
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);
        List<Map<String, String>> results = obsIds.stream().map(obsId -> Map.of("reference", "Observation/" + obsId)).toList();

        return new FhirDiagnosticReportResource("DiagnosticReport", id, "final", cat, cd, subj, Instant.now(), Instant.now(), results, conclusionText);
    }
}
