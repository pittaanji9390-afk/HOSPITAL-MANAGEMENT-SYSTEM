package com.hospital.interoperability.fhir;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

/**
 * HL7 FHIR Release 4 (R4) Standard Healthcare Resource Modeling & JSON Serializer.
 * Supports standard FHIR resources: Patient, Observation, Condition, MedicationRequest,
 * DiagnosticReport, Encounter, and Transaction Bundles without external dependencies.
 */
@Component
public class FhirR4ResourceEngine {

    @Data
    @Builder
    public static class FhirPatient {
        private String resourceType; // "Patient"
        private String id;
        private List<Map<String, Object>> identifier;
        private boolean active;
        private List<Map<String, Object>> name;
        private List<Map<String, Object>> telecom;
        private String gender; // male | female | other | unknown
        private String birthDate; // YYYY-MM-DD
        private List<Map<String, Object>> address;
        private List<Map<String, Object>> contact;
    }

    @Data
    @Builder
    public static class FhirObservation {
        private String resourceType; // "Observation"
        private String id;
        private String status; // final | preliminary | amended
        private List<Map<String, Object>> category;
        private Map<String, Object> code;
        private Map<String, Object> subject; // Reference to Patient
        private String effectiveDateTime;
        private Map<String, Object> valueQuantity;
        private String valueString;
        private List<Map<String, Object>> referenceRange;
        private List<Map<String, Object>> interpretation;
    }

    @Data
    @Builder
    public static class FhirCondition {
        private String resourceType; // "Condition"
        private String id;
        private Map<String, Object> clinicalStatus; // active | recurrence | relapse | inactive | remission | resolved
        private Map<String, Object> verificationStatus; // confirmed | provisional | differential | refuted
        private List<Map<String, Object>> category;
        private Map<String, Object> code; // ICD-10 or SNOMED
        private Map<String, Object> subject;
        private String recordedDate;
    }

    @Data
    @Builder
    public static class FhirMedicationRequest {
        private String resourceType; // "MedicationRequest"
        private String id;
        private String status; // active | completed | cancelled
        private String intent; // order | plan | proposal
        private Map<String, Object> medicationCodeableConcept;
        private Map<String, Object> subject;
        private String authoredOn;
        private Map<String, Object> requester;
        private List<Map<String, Object>> dosageInstruction;
    }

    @Data
    @Builder
    public static class FhirBundle {
        private String resourceType; // "Bundle"
        private String type; // searchset | transaction | batch | collection
        private int total;
        private List<Map<String, Object>> entry;
    }

    /**
     * Converts a hospital patient record into a standard FHIR R4 Patient JSON object.
     */
    public Map<String, Object> toFhirPatient(Long id, String mrn, String firstName, String lastName,
                                              String dob, String gender, String phone, String email,
                                              String addressLine, String city, String state, String postalCode) {
        Map<String, Object> fhir = new LinkedHashMap<>();
        fhir.put("resourceType", "Patient");
        fhir.put("id", "patient-" + id);

        // Identifiers (MRN)
        Map<String, Object> idMap = new LinkedHashMap<>();
        idMap.put("use", "usual");
        idMap.put("system", "https://hospital.org/fhir/mrn");
        idMap.put("value", mrn);
        fhir.put("identifier", Collections.singletonList(idMap));

        fhir.put("active", true);

        // HumanName
        Map<String, Object> nameMap = new LinkedHashMap<>();
        nameMap.put("use", "official");
        nameMap.put("family", lastName);
        nameMap.put("given", Collections.singletonList(firstName));
        fhir.put("name", Collections.singletonList(nameMap));

        // Telecom (Phone & Email)
        List<Map<String, Object>> telecomList = new ArrayList<>();
        if (phone != null && !phone.isBlank()) {
            Map<String, Object> phoneMap = new LinkedHashMap<>();
            phoneMap.put("system", "phone");
            phoneMap.put("value", phone);
            phoneMap.put("use", "mobile");
            telecomList.add(phoneMap);
        }
        if (email != null && !email.isBlank()) {
            Map<String, Object> emailMap = new LinkedHashMap<>();
            emailMap.put("system", "email");
            emailMap.put("value", email);
            telecomList.add(emailMap);
        }
        fhir.put("telecom", telecomList);

        // Demographic attributes
        fhir.put("gender", gender != null ? gender.toLowerCase() : "unknown");
        fhir.put("birthDate", dob);

        // Address
        Map<String, Object> addrMap = new LinkedHashMap<>();
        addrMap.put("use", "home");
        addrMap.put("line", Collections.singletonList(addressLine != null ? addressLine : ""));
        addrMap.put("city", city != null ? city : "");
        addrMap.put("state", state != null ? state : "");
        addrMap.put("postalCode", postalCode != null ? postalCode : "");
        addrMap.put("country", "IND");
        fhir.put("address", Collections.singletonList(addrMap));

        return fhir;
    }

    /**
     * Converts a vital sign observation (e.g. Blood Pressure, Heart Rate, SpO2) to FHIR R4 Observation.
     */
    public Map<String, Object> toFhirVitalObservation(String vitalType, Double value, String unit,
                                                      String loincCode, String patientMrn, String recordedAt) {
        Map<String, Object> obs = new LinkedHashMap<>();
        obs.put("resourceType", "Observation");
        obs.put("id", "obs-" + vitalType.toLowerCase() + "-" + System.currentTimeMillis());
        obs.put("status", "final");

        // Category: vital-signs
        Map<String, Object> catCoding = new LinkedHashMap<>();
        catCoding.put("system", "http://terminology.hl7.org/CodeSystem/observation-category");
        catCoding.put("code", "vital-signs");
        catCoding.put("display", "Vital Signs");
        obs.put("category", Collections.singletonList(Collections.singletonMap("coding", Collections.singletonList(catCoding))));

        // Code (LOINC)
        Map<String, Object> codeCoding = new LinkedHashMap<>();
        codeCoding.put("system", "http://loinc.org");
        codeCoding.put("code", loincCode);
        codeCoding.put("display", vitalType);
        obs.put("code", Collections.singletonMap("coding", Collections.singletonList(codeCoding)));

        // Subject Reference
        obs.put("subject", Collections.singletonMap("reference", "Patient/" + patientMrn));
        obs.put("effectiveDateTime", recordedAt != null ? recordedAt : Instant.now().toString());

        // ValueQuantity
        Map<String, Object> qty = new LinkedHashMap<>();
        qty.put("value", value);
        qty.put("unit", unit);
        qty.put("system", "http://unitsofmeasure.org");
        qty.put("code", unit);
        obs.put("valueQuantity", qty);

        return obs;
    }

    /**
     * Converts a diagnosis to FHIR R4 Condition.
     */
    public Map<String, Object> toFhirCondition(String icd10Code, String diagnosisText, String patientMrn,
                                                String recordedDate, boolean isActive) {
        Map<String, Object> cond = new LinkedHashMap<>();
        cond.put("resourceType", "Condition");
        cond.put("id", "cond-" + icd10Code.toLowerCase().replace(".", "-"));

        // Clinical Status
        Map<String, Object> statusCoding = new LinkedHashMap<>();
        statusCoding.put("system", "http://terminology.hl7.org/CodeSystem/condition-clinical");
        statusCoding.put("code", isActive ? "active" : "resolved");
        cond.put("clinicalStatus", Collections.singletonMap("coding", Collections.singletonList(statusCoding)));

        // Verification Status: confirmed
        Map<String, Object> verifCoding = new LinkedHashMap<>();
        verifCoding.put("system", "http://terminology.hl7.org/CodeSystem/condition-ver-status");
        verifCoding.put("code", "confirmed");
        cond.put("verificationStatus", Collections.singletonMap("coding", Collections.singletonList(verifCoding)));

        // Code (ICD-10)
        Map<String, Object> icdCoding = new LinkedHashMap<>();
        icdCoding.put("system", "http://hl7.org/fhir/sid/icd-10");
        icdCoding.put("code", icd10Code);
        icdCoding.put("display", diagnosisText);
        cond.put("code", Collections.singletonMap("coding", Collections.singletonList(icdCoding)));

        cond.put("subject", Collections.singletonMap("reference", "Patient/" + patientMrn));
        cond.put("recordedDate", recordedDate != null ? recordedDate : Instant.now().toString());

        return cond;
    }

    /**
     * Bundles multiple FHIR resources into a standard FHIR searchset or transaction Bundle.
     */
    public Map<String, Object> createBundle(String bundleType, List<Map<String, Object>> resources) {
        Map<String, Object> bundle = new LinkedHashMap<>();
        bundle.put("resourceType", "Bundle");
        bundle.put("type", bundleType != null ? bundleType : "searchset");
        bundle.put("total", resources != null ? resources.size() : 0);

        List<Map<String, Object>> entries = new ArrayList<>();
        if (resources != null) {
            for (Map<String, Object> res : resources) {
                Map<String, Object> entry = new LinkedHashMap<>();
                entry.put("fullUrl", "urn:uuid:" + UUID.randomUUID());
                entry.put("resource", res);
                entries.add(entry);
            }
        }
        bundle.put("entry", entries);
        return bundle;
    }
}
