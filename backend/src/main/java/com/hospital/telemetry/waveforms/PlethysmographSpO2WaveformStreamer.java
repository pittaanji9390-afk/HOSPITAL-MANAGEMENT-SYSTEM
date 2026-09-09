package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class PlethysmographSpO2WaveformStreamer {

    @Data
    @AllArgsConstructor
    public static class PlethWaveformPacket {
        private String bedId;
        private List<Double> plethAmplitudes;
        private double spo2Percent;
        private double perfusionIndex; // 0.2% - 20.0%
        private Instant timestamp;
    }

    public PlethWaveformPacket generatePlethPacket(String bedId, double spo2) {
        List<Double> samples = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            samples.add(Math.sin((double) i / 25.0 * Math.PI) * 50.0 + 50.0);
        }
        return new PlethWaveformPacket(bedId, samples, spo2, 4.5, Instant.now());
    }
}
