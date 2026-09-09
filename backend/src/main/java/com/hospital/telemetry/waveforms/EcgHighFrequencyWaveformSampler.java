package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class EcgHighFrequencyWaveformSampler {

    @Data
    @AllArgsConstructor
    public static class EcgWaveformPacket {
        private String bedId;
        private String leadName; // Lead II, V1, V5
        private List<Double> voltageMicrovolts; // 500 samples per second packet
        private int heartRateBpm;
        private boolean isPvcDetected;
        private Instant timestamp;
    }

    public EcgWaveformPacket generateEcgPacket(String bedId, int hr) {
        List<Double> samples = new ArrayList<>();
        for (int i = 0; i < 50; i++) { // 100ms chunk (50 samples at 500Hz)
            double t = (double) i / 50.0;
            double val = Math.sin(t * Math.PI * 2.0) * 100.0; // Simulated ECG QRS microvolt amplitude
            samples.add(Math.round(val * 10.0) / 10.0);
        }
        return new EcgWaveformPacket(bedId, "Lead II", samples, hr, false, Instant.now());
    }
}
