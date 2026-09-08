package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirObservationResourceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirObservationResource {
        private String resourceType; // "Observation"
        private String id;
        private String status; // "final", "amended"
        private List<Map<String, Object>> category; // vital-signs, laboratory
        private Map<String, Object> code; // LOINC code
        private Map<String, String> subject; // Patient ref
        private Instant effectiveDateTime;
        private Map<String, Object> valueQuantity; // value, unit, system, code
        private List<Map<String, Object>> referenceRange;
    }

    public FhirObservationResource toFhirLabObservation(String id, String patientId, String loincCode, String testName, double val, String unit, double low, double high) {
        List<Map<String, Object>> categories = List.of(Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/observation-category", "code", "laboratory"))));
        Map<String, Object> cd = Map.of("coding", List.of(Map.of("system", "http://loinc.org", "code", loincCode, "display", testName)));
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);
        Map<String, Object> valQty = Map.of("value", val, "unit", unit, "system", "http://unitsofmeasure.org", "code", unit);
        List<Map<String, Object>> refRange = List.of(Map.of("low", Map.of("value", low, "unit", unit), "high", Map.of("value", high, "unit", unit)));

        return new FhirObservationResource("Observation", id, "final", categories, cd, subj, Instant.now(), valQty, refRange);
    }
}
