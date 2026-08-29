package com.hospital.interoperability;

import com.hospital.interoperability.fhir.FhirR4ResourceEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FhirEngineTest {

    private final FhirR4ResourceEngine fhirEngine = new FhirR4ResourceEngine();

    @Test
    @DisplayName("FHIR R4: Should accurately model standard FHIR Patient resource")
    void testToFhirPatient() {
        Map<String, Object> patient = fhirEngine.toFhirPatient(
                1L,
                "MRN-10001",
                "Anand",
                "Patil",
                "1982-06-14",
                "MALE",
                "+919845012345",
                "anand@example.com",
                "74 Indiranagar",
                "Bengaluru",
                "Karnataka",
                "560029"
        );

        assertNotNull(patient);
        assertEquals("Patient", patient.get("resourceType"));
        assertEquals("patient-1", patient.get("id"));
        assertEquals("male", patient.get("gender"));
        assertEquals("1982-06-14", patient.get("birthDate"));

        List<Map<String, Object>> ids = (List<Map<String, Object>>) patient.get("identifier");
        assertNotNull(ids);
        assertEquals("MRN-10001", ids.get(0).get("value"));
    }

    @Test
    @DisplayName("FHIR R4: Should model vital observation with LOINC coding and UCUM units")
    void testToFhirObservation() {
        Map<String, Object> obs = fhirEngine.toFhirVitalObservation(
                "Heart Rate",
                74.0,
                "/min",
                "8867-4",
                "MRN-10001",
                "2026-08-29T10:00:00Z"
        );

        assertNotNull(obs);
        assertEquals("Observation", obs.get("resourceType"));
        assertEquals("final", obs.get("status"));

        Map<String, Object> qty = (Map<String, Object>) obs.get("valueQuantity");
        assertEquals(74.0, qty.get("value"));
        assertEquals("/min", qty.get("unit"));
    }

    @Test
    @DisplayName("FHIR R4: Should create standard searchset Bundle wrapping multiple resources")
    void testCreateFhirBundle() {
        Map<String, Object> pat = fhirEngine.toFhirPatient(1L, "MRN-10001", "Anand", "Patil", "1982-06-14", "MALE", null, null, null, null, null, null);
        Map<String, Object> cond = fhirEngine.toFhirCondition("I10", "Essential Hypertension", "MRN-10001", "2026-08-29", true);

        Map<String, Object> bundle = fhirEngine.createBundle("searchset", List.of(pat, cond));

        assertNotNull(bundle);
        assertEquals("Bundle", bundle.get("resourceType"));
        assertEquals("searchset", bundle.get("type"));
        assertEquals(2, bundle.get("total"));
        List<Map<String, Object>> entries = (List<Map<String, Object>>) bundle.get("entry");
        assertEquals(2, entries.size());
    }
}
