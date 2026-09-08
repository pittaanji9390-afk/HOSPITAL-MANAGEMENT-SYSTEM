package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class MorgueChainOfCustodyCatalog {

    @Data
    @AllArgsConstructor
    public static class DeceasedReleaseRecord {
        private String deceasedId;
        private String patientMrn;
        private String coldChamberBayNumber;
        private boolean isMedicoLegalCaseMlc;
        private String authorizedReceivingPerson;
        private String deathCertificateSerialNumber;
        private LocalDateTime releaseTimestamp;
    }

    public DeceasedReleaseRecord verifyRelease(String deceasedId, String mrn, String bay, boolean isMlc, String receiver, String certNo) {
        return new DeceasedReleaseRecord(deceasedId, mrn, bay, isMlc, receiver, certNo, LocalDateTime.now());
    }
}
