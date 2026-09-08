package com.hospital.telemetry.waveforms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Service
public class VentilatorFlowPressureLoopStreamer {

    @Data
    @AllArgsConstructor
    public static class PvLoopDataPoint {
        private double airwayPressureCmH2O;
        private double volumeMl;
    }

    @Data
    @AllArgsConstructor
    public static class PvLoopPacket {
        private String bedId;
        private List<PvLoopDataPoint> inspiratoryLimb;
        private List<PvLoopDataPoint> expiratoryLimb;
        private double lowerInflectionPointCmH2O;
        private double upperInflectionPointCmH2O;
        private Instant timestamp;
    }

    public PvLoopPacket generatePvLoop(String bedId) {
        List<PvLoopDataPoint> insp = List.of(new PvLoopDataPoint(5, 0), new PvLoopDataPoint(10, 100), new PvLoopDataPoint(18, 350), new PvLoopDataPoint(24, 480));
        List<PvLoopDataPoint> exp = List.of(new PvLoopDataPoint(24, 480), new PvLoopDataPoint(15, 300), new PvLoopDataPoint(8, 80), new PvLoopDataPoint(5, 0));
        return new PvLoopPacket(bedId, insp, exp, 10.0, 22.0, Instant.now());
    }
}
