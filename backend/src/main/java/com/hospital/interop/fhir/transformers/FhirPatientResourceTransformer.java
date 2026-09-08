package com.hospital.interop.fhir.transformers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component
public class FhirPatientResourceTransformer {

    @Data
    @AllArgsConstructor
    public static class FhirPatientResource {
        private String resourceType; // "Patient"
        private String id;
        private List<Map<String, String>> identifier;
        private boolean active;
        private List<Map<String, Object>> name;
        private List<Map<String, String>> telecom;
        private String gender;
        private LocalDate birthDate;
        private List<Map<String, Object>> address;
        private Map<String, Object> maritalStatus;
    }

    public FhirPatientResource toFhirPatient(String id, String mrn, String firstName, String lastName, String phone, String gender, LocalDate dob, String city, String state, String zip) {
        List<Map<String, String>> identifiers = List.of(
            Map.of("system", "http://hospital.metro.org/mrn", "value", mrn, "use", "usual")
        );
        List<Map<String, Object>> names = List.of(
            Map.of("use", "official", "family", lastName, "given", List.of(firstName))
        );
        List<Map<String, String>> telecoms = List.of(
            Map.of("system", "phone", "value", phone, "use", "mobile")
        );
        List<Map<String, Object>> addresses = List.of(
            Map.of("use", "home", "line", List.of("123 Healthcare Ave"), "city", city, "state", state, "postalCode", zip, "country", "USA")
        );
        Map<String, Object> marital = Map.of("coding", List.of(Map.of("system", "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "code", "M", "display", "Married")));

        return new FhirPatientResource("Patient", id, identifiers, true, names, telecoms, gender, dob, addresses, marital);
    }
}
