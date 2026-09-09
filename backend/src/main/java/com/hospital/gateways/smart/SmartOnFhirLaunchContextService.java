package com.hospital.gateways.smart;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class SmartOnFhirLaunchContextService {

    @Data
    @Builder
    public static class SmartLaunchContext {
        private String launchId;
        private String patientId;
        private String encounterId;
        private String fhirUser;
        private List<String> grantedScopes;
        private Instant tokenExpiresAt;
        private boolean isEhrLaunch;
    }

    public SmartLaunchContext resolveLaunchContext(String launchToken, String clientId, String requestedScopes) {
        List<String> scopes = Arrays.asList(requestedScopes.split(" "));
        return SmartLaunchContext.builder()
                .launchId(UUID.randomUUID().toString())
                .patientId("PAT-94820")
                .encounterId("ENC-2026-9912")
                .fhirUser("Practitioner/DR-7719")
                .grantedScopes(scopes)
                .tokenExpiresAt(Instant.now().plusSeconds(3600))
                .isEhrLaunch(true)
                .build();
    }
}
