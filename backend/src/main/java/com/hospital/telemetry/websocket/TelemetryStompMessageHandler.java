package com.hospital.telemetry.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.time.Instant;
import java.util.Map;

@Slf4j
@Controller
public class TelemetryStompMessageHandler {

    @MessageMapping("/subscribe-bed/{bedId}")
    @SendTo("/topic/bed-telemetry/{bedId}")
    public Map<String, Object> handleBedSubscription(@DestinationVariable String bedId) {
        log.info("[STOMP-WEBSOCKET] Client subscribed to bedside telemetry for: {}", bedId);
        return Map.of(
            "bedId", bedId,
            "status", "CONNECTED",
            "serverTime", Instant.now().toString(),
            "samplingRateHz", 500
        );
    }
}
