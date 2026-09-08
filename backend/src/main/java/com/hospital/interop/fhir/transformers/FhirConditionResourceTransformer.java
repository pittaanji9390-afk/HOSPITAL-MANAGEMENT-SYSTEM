package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component
public class FhirConditionResourceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirConditionResource {
        private String resourceType; // "Condition"
        private String id;
        private Map<String, Object> clinicalStatus; // active, recurrence, relapse, inactive, remission, resolved
        private Map<String, Object> verificationStatus; // confirmed, provisional, differential
        private List<Map<String, Object>> category; // problem-list-item, encounter-diagnosis
        private Map<String, Object> code; // ICD-10 or SNOMED-CT
        private Map<String, String> subject; // Reference to Patient
        private LocalDate onsetDate;
        private LocalDate recordedDate;
    }

    public FhirConditionResource toFhirCondition(String id, String patientId, String icd10Code, String display, String clinicalStatus, LocalDate onset) {
        Map<String, Object> clinStatus = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/condition-clinical", "code", clinicalStatus)));
        Map<String, Object> verStatus = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/condition-ver-status", "code", "confirmed")));
        List<Map<String, Object>> categories = List.of(Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/condition-category", "code", "encounter-diagnosis"))));
        Map<String, Object> cd = Map.of("coding", List.of(Map.of("system", "http://hl7.org/fhir/sid/icd-10-cm", "code", icd10Code, "display", display)), "text", display);
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);

        return new FhirConditionResource("Condition", id, clinStatus, verStatus, categories, cd, subj, onset, LocalDate.now());
    }
}
