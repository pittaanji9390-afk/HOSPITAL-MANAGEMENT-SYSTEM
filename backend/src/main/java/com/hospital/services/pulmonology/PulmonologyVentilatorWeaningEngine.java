package com.hospital.services.pulmonology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PulmonologyVentilatorWeaningEngine {

    @Data
    @Builder
    public static class VentilatorWeaningReadiness {
        private String patientId;
        private double paO2FiO2Ratio;
        private String ardsSeverityGrade; // NONE, MILD, MODERATE, SEVERE
        private double rapidShallowBreathingIndexRsbi;
        private boolean isSbtExtubationReady;
        private String recommendedVentilatorMode;
        private String lungProtectiveVentilationGuidance;
    }

    public VentilatorWeaningReadiness assessWeaning(String patientId, double paO2, double fiO2Fraction, double respRateBpm, double tidalVolumeLiters, double peepCmH2O) {
        double pfRatio = paO2 / Math.max(0.21, fiO2Fraction);
        double rsbi = respRateBpm / Math.max(0.1, tidalVolumeLiters);

        String ardsGrade;
        if (pfRatio > 300) ardsGrade = "NONE";
        else if (pfRatio > 200) ardsGrade = "MILD_ARDS";
        else if (pfRatio > 100) ardsGrade = "MODERATE_ARDS";
        else ardsGrade = "SEVERE_ARDS";

        boolean extubationReady = rsbi < 105 && pfRatio >= 200 && peepCmH2O <= 8.0;

        return VentilatorWeaningReadiness.builder()
                .patientId(patientId)
                .paO2FiO2Ratio(Math.round(pfRatio * 10.0) / 10.0)
                .ardsSeverityGrade(ardsGrade)
                .rapidShallowBreathingIndexRsbi(Math.round(rsbi * 10.0) / 10.0)
                .isSbtExtubationReady(extubationReady)
                .recommendedVentilatorMode(extubationReady ? "PRESSURE_SUPPORT_CPAP" : "VOLUME_SYNCHRONIZED_INTERMITTENT")
                .lungProtectiveVentilationGuidance("Maintain Tidal Volume at 6 mL/kg PBW; Plateau Pressure < 30 cmH2O; Driving Pressure < 15 cmH2O.")
                .build();
    }
}
