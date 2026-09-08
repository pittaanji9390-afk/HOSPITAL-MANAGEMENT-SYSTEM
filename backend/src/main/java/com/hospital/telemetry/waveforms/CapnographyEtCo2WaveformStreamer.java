package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class CapnographyEtCo2WaveformStreamer {

    @Data
    @AllArgsConstructor
    public static class CapnoWaveformPacket {
        private String bedId;
        private List<Double> co2MmHgSamples; // Phase I baseline, Phase II expiratory upstroke, Phase III alveolar plateau, Phase IV inspiration
        private double endTidalCo2MmHg; // Normal 35-45 mmHg
        private double respiratoryRateBpm;
        private boolean isSharkFinBronchospasm;
        private Instant timestamp;
    }

    public CapnoWaveformPacket generateCapnoPacket(String bedId, double etco2, double rr) {
        List<Double> samples = List.of(0.0, 5.0, 25.0, 38.0, 40.0, 40.0, 39.0, 35.0, 10.0, 0.0);
        return new CapnoWaveformPacket(bedId, samples, etco2, rr, false, Instant.now());
    }
}
