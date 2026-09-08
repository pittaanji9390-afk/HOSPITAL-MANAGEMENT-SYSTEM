package com.hospital.telemetry.alarms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Slf4j
@Service
public class RealTimeTelemetryAlarmBroadcaster {

    @Data
    @AllArgsConstructor
    public static class TelemetryAlarmPayload {
        private String alarmId;
        private String bedId;
        private String patientId;
        private String priority; // HIGH (Flashing Red), MEDIUM (Yellow), LOW (Cyan), TECHNICAL (Blue)
        private String alarmMessage;
        private double triggeredValue;
        private double thresholdLimit;
        private Instant alarmTimestamp;
        private boolean isSilenced;
    }

    public TelemetryAlarmPayload broadcastAlarm(String bedId, String patientId, String priority, String msg, double val, double limit) {
        String alarmId = "ALM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        TelemetryAlarmPayload payload = new TelemetryAlarmPayload(alarmId, bedId, patientId, priority, msg, val, limit, Instant.now(), false);
        log.warn("[TELEMETRY-ALARM] {} Bed: {} | Priority: {} | Msg: {}", alarmId, bedId, priority, msg);
        return payload;
    }
}
