package com.hospital.gateways.telemed;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WebRtcSignalingGatewayService {

    @Data
    @Builder
    public static class TeleconsultSessionConfig {
        private String roomSessionToken;
        private String sfuRouterEndpoint;
        private List<String> turnServerUris;
        private String turnUsername;
        private String turnCredential;
        private boolean isDtlsSrtpEncrypted;
    }

    public TeleconsultSessionConfig createConsultationRoom(String encounterUuid, String doctorId, String patientId) {
        return TeleconsultSessionConfig.builder()
                .roomSessionToken("ROOM-" + UUID.randomUUID().toString())
                .sfuRouterEndpoint("wss://telemed-sfu.hospital.org/ws")
                .turnServerUris(List.of("turns:turn1.hospital.org:5349?transport=tcp", "stun:stun.hospital.org:3478"))
                .turnUsername("user-" + doctorId)
                .turnCredential("token-" + UUID.randomUUID())
                .isDtlsSrtpEncrypted(true)
                .build();
    }
}
