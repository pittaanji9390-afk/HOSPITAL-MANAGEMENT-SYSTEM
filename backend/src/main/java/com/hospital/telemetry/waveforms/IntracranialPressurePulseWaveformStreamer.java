package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class IntracranialPressurePulseWaveformStreamer {

    @Data
    @AllArgsConstructor
    public static class IcpWavePacket {
        private String bedId;
        private double p1PercussionWave;
        private double p2TidalWave;
        private double p3DicroticWave;
        private double p2OverP1ComplianceRatio;
        private boolean isIntracranialComplianceCompromised;
        private Instant timestamp;
    }

    public IcpWavePacket generateIcpWave(String bedId, double icp) {
        double p1 = icp + 4.0;
        double p2 = icp + 2.0; // Normal P1 > P2 > P3
        double p3 = icp;
        double ratio = p2 / p1;
        return new IcpWavePacket(bedId, p1, p2, p3, Math.round(ratio * 100.0) / 100.0, ratio >= 1.0, Instant.now());
    }
}
