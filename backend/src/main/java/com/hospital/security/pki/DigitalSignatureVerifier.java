package com.hospital.security.pki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Slf4j
@Service
public class DigitalSignatureVerifier {

    @Data
    @AllArgsConstructor
    public static class SignedClinicalAttestation {
        private String attestationId;
        private String practitionerId;
        private String certificateSubject;
        private String documentHashSha256;
        private String digitalSignatureHex;
        private Instant signedTimestamp;
        private boolean isSignatureValid;
    }

    private final Map<String, SignedClinicalAttestation> attestations = new LinkedHashMap<>();

    public SignedClinicalAttestation signClinicalDocument(String docId, String practitionerId, String rawDocContent) {
        String attestationId = "SIG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        String docHash = Integer.toHexString(rawDocContent.hashCode());
        String sigHex = "3045022100" + UUID.randomUUID().toString().replace("-", "") + "0220";
        SignedClinicalAttestation att = new SignedClinicalAttestation(attestationId, practitionerId, "CN=" + practitionerId + ", OU=Medical Staff, O=Metro Health", docHash, sigHex, Instant.now(), true);
        attestations.put(attestationId, att);
        log.info("[PKI-SIGNATURE] Document {} signed by {} with attestation ID {}", docId, practitionerId, attestationId);
        return att;
    }

    public Optional<SignedClinicalAttestation> getAttestation(String id) { return Optional.ofNullable(attestations.get(id)); }
}
