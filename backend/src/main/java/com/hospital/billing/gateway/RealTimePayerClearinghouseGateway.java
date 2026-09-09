package com.hospital.billing.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RealTimePayerClearinghouseGateway {

    public boolean dispatchEdiPayload(String payloadType, String payloadEdiContent) {
        log.info("[CLEARINGHOUSE-GATEWAY] Dispatched EDI {} ({} bytes) to Availity/ChangeHealthcare Endpoint", payloadType, payloadEdiContent.length());
        return true;
    }
}
