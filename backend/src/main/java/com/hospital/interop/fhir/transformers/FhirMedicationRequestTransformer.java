package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirMedicationRequestTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirMedicationRequestResource {
        private String resourceType; // "MedicationRequest"
        private String id;
        private String status; // "active", "completed", "cancelled"
        private String intent; // "order", "plan"
        private Map<String, Object> medicationCodeableConcept; // RxNorm
        private Map<String, String> subject; // Patient ref
        private Instant authoredOn;
        private Map<String, String> requester; // Practitioner ref
        private List<Map<String, Object>> dosageInstruction;
    }

    public FhirMedicationRequestResource toFhirMedRequest(String id, String patientId, String doctorId, String rxNormCui, String drugName, String doseSig, double doseValue, String unit) {
        Map<String, Object> medConcept = Map.of("coding", List.of(Map.of("system", "http://www.nlm.nih.gov/research/umls/rxnorm", "code", rxNormCui, "display", drugName)));
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);
        Map<String, String> req = Map.of("reference", "Practitioner/" + doctorId);
        List<Map<String, Object>> dosage = List.of(
            Map.of("text", doseSig, "doseAndRate", List.of(Map.of("doseQuantity", Map.of("value", doseValue, "unit", unit))))
        );

        return new FhirMedicationRequestResource("MedicationRequest", id, "active", "order", medConcept, subj, Instant.now(), req, dosage);
    }
}
