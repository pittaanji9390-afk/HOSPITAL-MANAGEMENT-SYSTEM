package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class ArterialLinePressureWaveformStreamer {

    @Data
    @AllArgsConstructor
    public static class ArtLinePacket {
        private String bedId;
        private List<Double> pressureSamplesMmHg;
        private double sbp;
        private double dbp;
        private double map;
        private double strokeVolumeMl;
        private Instant timestamp;
    }

    public ArtLinePacket generateArtPacket(String bedId, double sbp, double dbp) {
        double map = (sbp + 2.0 * dbp) / 3.0;
        List<Double> samples = List.of(dbp, sbp, sbp * 0.9, sbp * 0.75 /* Dicrotic notch */, sbp * 0.8, dbp * 1.1, dbp);
        return new ArtLinePacket(bedId, samples, sbp, dbp, Math.round(map), 75.0, Instant.now());
    }
}
