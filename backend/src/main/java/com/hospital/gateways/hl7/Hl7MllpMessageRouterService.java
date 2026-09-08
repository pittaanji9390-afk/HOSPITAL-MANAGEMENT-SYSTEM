package com.hospital.gateways.hl7;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Hl7MllpMessageRouterService {

    @Data
    @Builder
    public static class Hl7AckResponse {
        private String rawAckMessage;
        private String ackCode; // AA, AE, AR
        private String originalMessageControlId;
        private LocalDateTime ackTimestamp;
    }

    public Hl7AckResponse processInboundMllp(String hl7Payload) {
        String msgControlId = "MSG-20260908-001";
        if (hl7Payload.contains("|")) {
            String[] segments = hl7Payload.split("|
");
            for (String seg : segments) {
                if (seg.startsWith("MSH")) {
                    String[] fields = seg.split("\|");
                    if (fields.length > 9) msgControlId = fields[9];
                }
            }
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String ack = "MSH|^~\&|HOSPITAL_HMS|CORE|SOURCE_SYS|EXT|" + timestamp + "||ACK|" + msgControlId + "|P|2.5MSA|AA|" + msgControlId + "";

        return Hl7AckResponse.builder()
                .rawAckMessage(ack)
                .ackCode("AA")
                .originalMessageControlId(msgControlId)
                .ackTimestamp(LocalDateTime.now())
                .build();
    }
}
