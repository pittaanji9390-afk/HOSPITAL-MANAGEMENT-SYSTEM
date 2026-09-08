package com.hospital.gateways.iot;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class BiomedicalMqttDeviceGateway {

    @Data
    @Builder
    public static class DeviceShadowState {
        private String deviceSerialNumber;
        private String thingName;
        private String connectionStatus; // CONNECTED, DISCONNECTED, ALARM_ALERT
        private Instant lastReportedTimestamp;
        private double batteryLevelPercent;
        private double firmwareVersion;
    }

    public DeviceShadowState getDeviceShadow(String serialNumber) {
        return DeviceShadowState.builder()
                .deviceSerialNumber(serialNumber)
                .thingName("Ventilator-ICU-Bed-04")
                .connectionStatus("CONNECTED")
                .lastReportedTimestamp(Instant.now())
                .batteryLevelPercent(98.5)
                .firmwareVersion(4.2)
                .build();
    }
}
