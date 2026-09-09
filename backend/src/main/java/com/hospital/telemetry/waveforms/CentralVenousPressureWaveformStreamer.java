package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class CentralVenousPressureWaveformStreamer {

    @Data
    @AllArgsConstructor
    public static class CvpWaveformPacket {
        private String bedId;
        private List<Double> cvpSamplesMmHg; // a-wave, c-wave, v-wave, x-descent, y-descent
        private double meanCvpMmHg;
        private boolean isCannonAWavePresent;
        private Instant timestamp;
    }

    public CvpWaveformPacket generateCvpPacket(String bedId, double meanCvp) {
        List<Double> samples = List.of(meanCvp + 4.0 /* a */, meanCvp + 1.0 /* x */, meanCvp + 2.0 /* c */, meanCvp + 3.0 /* v */, meanCvp /* y */);
        return new CvpWaveformPacket(bedId, samples, meanCvp, false, Instant.now());
    }
}
