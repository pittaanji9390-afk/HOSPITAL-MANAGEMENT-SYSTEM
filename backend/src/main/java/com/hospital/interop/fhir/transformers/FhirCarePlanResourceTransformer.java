package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirCarePlanResourceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirCarePlanResource {
        private String resourceType; // "CarePlan"
        private String id;
        private String status; // "active"
        private String intent; // "plan"
        private String title;
        private String description;
        private Map<String, String> subject; // Patient ref
        private List<Map<String, Object>> activity;
    }

    public FhirCarePlanResource toFhirCarePlan(String id, String patientId, String title, String desc, List<String> activities) {
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);
        List<Map<String, Object>> actList = activities.stream().map(act -> Map.of("detail", (Object) Map.of("description", act, "status", "in-progress"))).toList();

        return new FhirCarePlanResource("CarePlan", id, "active", "plan", title, desc, subj, actList);
    }
}
