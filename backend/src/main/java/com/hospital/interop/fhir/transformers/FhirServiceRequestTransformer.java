package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirServiceRequestTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirServiceRequestResource {
        private String resourceType; // "ServiceRequest"
        private String id;
        private String status; // "active", "completed"
        private String intent; // "order"
        private String priority; // "stat", "urgent", "routine"
        private Map<String, Object> code; // CPT or SNOMED-CT
        private Map<String, String> subject; // Patient ref
        private Instant authoredOn;
        private Map<String, String> requester;
    }

    public FhirServiceRequestResource toFhirServiceRequest(String id, String patientId, String doctorId, String cptCode, String procedureName, String priority) {
        Map<String, Object> cd = Map.of("coding", List.of(Map.of("system", "http://www.ama-assn.org/go/cpt", "code", cptCode, "display", procedureName)));
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);
        Map<String, String> req = Map.of("reference", "Practitioner/" + doctorId);

        return new FhirServiceRequestResource("ServiceRequest", id, "active", "order", priority, cd, subj, Instant.now(), req);
    }
}
