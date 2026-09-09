package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component
public class FhirImmunizationResourceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirImmunizationResource {
        private String resourceType; // "Immunization"
        private String id;
        private String status; // "completed"
        private Map<String, Object> vaccineCode; // CDC CVX code
        private Map<String, String> patient;
        private LocalDate occurrenceDate;
        private String lotNumber;
        private LocalDate expirationDate;
        private Map<String, Object> site;
        private Map<String, Object> route;
    }

    public FhirImmunizationResource toFhirImmunization(String id, String patientId, String cvxCode, String vaccineName, String lot, LocalDate adminDate) {
        Map<String, Object> cd = Map.of("coding", List.of(Map.of("system", "http://hl7.org/fhir/sid/cvx", "code", cvxCode, "display", vaccineName)));
        Map<String, String> pt = Map.of("reference", "Patient/" + patientId);
        Map<String, Object> site = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/v3-ActSite", "code", "LA", "display", "Left Arm Deltoid")));
        Map<String, Object> route = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/v3-RouteOfAdministration", "code", "IM", "display", "Intramuscular")));

        return new FhirImmunizationResource("Immunization", id, "completed", cd, pt, adminDate, lot, adminDate.plusYears(2), site, route);
    }
}
