package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirAllergyIntoleranceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirAllergyIntoleranceResource {
        private String resourceType; // "AllergyIntolerance"
        private String id;
        private Map<String, Object> clinicalStatus; // active, inactive, resolved
        private Map<String, Object> verificationStatus; // confirmed, unconfirmed
        private String type; // "allergy", "intolerance"
        private String category; // "medication", "food", "environment"
        private String criticality; // "low", "high", "unable-to-assess"
        private Map<String, Object> code; // RxNorm or UNII allergen
        private Map<String, String> patient;
        private List<Map<String, Object>> reaction;
    }

    public FhirAllergyIntoleranceResource toFhirAllergy(String id, String patientId, String allergenRxNorm, String allergenName, String severity, String manifestation) {
        Map<String, Object> clinStatus = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code", "active")));
        Map<String, Object> verStatus = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "code", "confirmed")));
        Map<String, Object> cd = Map.of("coding", List.of(Map.of("system", "http://www.nlm.nih.gov/research/umls/rxnorm", "code", allergenRxNorm, "display", allergenName)));
        Map<String, String> pt = Map.of("reference", "Patient/" + patientId);
        List<Map<String, Object>> rxns = List.of(
            Map.of("severity", severity, "manifestation", List.of(Map.of("text", manifestation)))
        );

        return new FhirAllergyIntoleranceResource("AllergyIntolerance", id, clinStatus, verStatus, "allergy", "medication", severity.equals("severe") ? "high" : "low", cd, pt, rxns);
    }
}
