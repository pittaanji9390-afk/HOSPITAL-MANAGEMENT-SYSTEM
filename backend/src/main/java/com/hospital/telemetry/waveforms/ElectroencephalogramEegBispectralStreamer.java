package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class ElectroencephalogramEegBispectralStreamer {

    @Data
    @AllArgsConstructor
    public static class BisEegPacket {
        private String bedId;
        private int bisIndex; // 40-60 target surgical anesthesia, 0 flatline, 100 awake
        private double spectralEdgeFrequencyHz;
        private double burstSuppressionRatioPercent;
        private double electromyogramEmgDecibels;
        private String sedationState;
        private Instant timestamp;
    }

    public BisEegPacket generateBisPacket(String bedId, int bis) {
        String state = bis > 80 ? "LIGHT SEDATION / AWAKE" : bis >= 40 ? "GENERAL ANESTHESIA (TARGET 40-60)" : bis >= 20 ? "DEEP HYPNOTIC STATE" : "BURST SUPPRESSION / COMA";
        return new BisEegPacket(bedId, bis, 11.2, bis < 30 ? 25.0 : 0.0, 32.0, state, Instant.now());
    }
}
