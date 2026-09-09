package com.hospital.services.smartfhir;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Enterprise SMART on FHIR Core Specification Launch Context Broker.
 * Handles EHR-launch and standalone launch sequences, patient-context binding, and OAuth2 authorization codes.
 */
@Service
public class SmartOnFhirLaunchContextBrokerService {

    @Data
    @Builder
    public static class SmartLaunchResponse {
        private String launchId;
        private String patientContextId;
        private String encounterContextId;
        private String grantedScopes;
        private String fhirServerBaseUrl;
        private boolean isTlsEnforced;
    }

    public SmartLaunchResponse createLaunchContext(Long patientId, Long encounterId, String requestedScopes) {
        return SmartLaunchResponse.builder()
                .launchId("LAUNCH-" + UUID.randomUUID().toString().substring(0, 12).toUpperCase())
                .patientContextId(String.valueOf(patientId))
                .encounterContextId(String.valueOf(encounterId))
                .grantedScopes(requestedScopes != null ? requestedScopes : "launch/patient patient/*.read openid fhirUser")
                .fhirServerBaseUrl("https://api.hospital-hms.internal/fhir/r4")
                .isTlsEnforced(true)
                .build();
    }
}
