package com.hospital.controller.clinical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/telemetry-streams")
@CrossOrigin(origins = "*")
public class IntensiveCareTelemetryStreamRestController {

    @Data
    @AllArgsConstructor
    public static class TelemetrySnapshot {
        private String bedId;
        private String patientId;
        private double heartRateBpm;
        private double arterialBloodPressureSystolic;
        private double arterialBloodPressureDiastolic;
        private double meanArterialPressure;
        private double spo2Percent;
        private double respiratoryRateBpm;
        private double intracranialPressureMmHg;
        private double coreTemperatureCelsius;
        private String cardiacRhythmStatus;
        private Instant timestamp;
    }

    @GetMapping("/bed/{bedId}/current")
    public ResponseEntity<TelemetrySnapshot> getBedTelemetryCurrent(@PathVariable String bedId) {
        TelemetrySnapshot snap = new TelemetrySnapshot(
            bedId, "PT-ICU-8821", 78.0, 122.0, 74.0, 90.0, 98.0, 16.0, 12.0, 37.1, "Normal Sinus Rhythm", Instant.now()
        );
        return ResponseEntity.ok(snap);
    }
}
