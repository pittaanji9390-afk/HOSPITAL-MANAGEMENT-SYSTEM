package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.*;

@Component
public class FhirEncounterResourceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirEncounterResource {
        private String resourceType; // "Encounter"
        private String id;
        private String status; // "in-progress", "finished"
        private Map<String, String> classCode; // IMP (inpatient), EMER (emergency), AMB (ambulatory)
        private Map<String, String> subject; // Reference to Patient
        private List<Map<String, Object>> participant;
        private Map<String, Instant> period;
        private List<Map<String, Object>> reasonCode;
        private Map<String, Object> hospitalization;
    }

    public FhirEncounterResource toFhirEncounter(String id, String patientId, String attendingDocId, String encClass, Instant start, String admissionSource, String admitReason) {
        Map<String, String> cls = Map.of("system", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code", encClass, "display", "Inpatient Encounter");
        Map<String, String> subj = Map.of("reference", "Patient/" + patientId);
        List<Map<String, Object>> participants = List.of(
            Map.of("individual", Map.of("reference", "Practitioner/" + attendingDocId), "type", List.of(Map.of("text", "Attending Physician")))
        );
        Map<String, Instant> per = Map.of("start", start);
        List<Map<String, Object>> reasons = List.of(
            Map.of("text", admitReason)
        );
        Map<String, Object> hosp = Map.of("admitSource", Map.of("text", admissionSource));

        return new FhirEncounterResource("Encounter", id, "in-progress", cls, subj, participants, per, reasons, hosp);
    }
}
