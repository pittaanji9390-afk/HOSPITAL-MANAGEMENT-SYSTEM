package com.hospital.security.privacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SafeHarborDeidentifier {

    @Data
    @AllArgsConstructor
    public static class DeidentifiedPatientPayload {
        private String syntheticPatientPseudonym;
        private String ageBand; // e.g. 70-74 (Ages >89 aggregated into 90+)
        private String zipCode3Digit; // e.g. 100xx
        private String maskedMedicalRecordNumber; // e.g. MRN-***-9941
        private List<String> clinicalConditions;
        private List<String> anonymizedMedications;
    }

    public DeidentifiedPatientPayload deidentify(String rawPatientId, String name, int age, String zip5, String mrn, List<String> conditions, List<String> meds) {
        String pseudonym = "SYNTH-" + UUID.nameUUIDFromBytes(rawPatientId.getBytes()).toString().substring(0, 8).toUpperCase();
        String ageBand = age >= 90 ? "90+" : (age / 5 * 5) + "-" + (age / 5 * 5 + 4);
        String zip3 = zip5 != null && zip5.length() >= 3 ? zip5.substring(0, 3) + "xx" : "000xx";
        String maskedMrn = "MRN-***-" + (mrn.length() > 4 ? mrn.substring(mrn.length() - 4) : "0000");

        return new DeidentifiedPatientPayload(pseudonym, ageBand, zip3, maskedMrn, conditions, meds);
    }
}
