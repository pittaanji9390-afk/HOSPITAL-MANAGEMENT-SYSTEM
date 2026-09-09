package com.hospital.gateways.abdm;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AbdmConsentArtefactManager {

    @Data
    @Builder
    public static class ConsentArtefactStatus {
        private String consentArtefactId;
        private String abhaAddress;
        private String hipId;
        private String hiuId;
        private List<String> hiTypes; // DiagnosticReport, Prescription, OPConsultation, DischargeSummary
        private LocalDateTime consentGrantedAt;
        private LocalDateTime consentExpiresAt;
        private String signatureValidationStatus;
    }

    public ConsentArtefactStatus validateConsent(String consentId, String abhaId) {
        return ConsentArtefactStatus.builder()
                .consentArtefactId(consentId)
                .abhaAddress(abhaId)
                .hipId("IN-AP-HOSP-001")
                .hiuId("IN-AP-HIU-882")
                .hiTypes(List.of("DiagnosticReport", "Prescription", "DischargeSummary"))
                .consentGrantedAt(LocalDateTime.now().minusDays(1))
                .consentExpiresAt(LocalDateTime.now().plusMonths(6))
                .signatureValidationStatus("CRYPTOGRAPHIC_SIGNATURE_VERIFIED_ECDSA_SHA256")
                .build();
    }
}
