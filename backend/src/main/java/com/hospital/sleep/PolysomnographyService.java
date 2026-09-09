package com.hospital.sleep;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class PolysomnographyService {

    public enum OsaSeverity { NORMAL, MILD, MODERATE, SEVERE }

    public static record PsgReport(
            String studyId,
            String patientId,
            double apneaHypopneaIndexAhi, // events/hr
            double nadirOxygenSaturationSpO2Percent,
            double sleepEfficiencyPercent,
            OsaSeverity severity,
            String cpapTitrationRecommendation,
            Instant reportedAt
    ) implements Serializable {}

    public PsgReport evaluatePsg(String studyId, String patientId, double ahi, double nadirSpo2, double efficiency) {
        OsaSeverity sev;
        if (ahi >= 30.0) sev = OsaSeverity.SEVERE;
        else if (ahi >= 15.0) sev = OsaSeverity.MODERATE;
        else if (ahi >= 5.0) sev = OsaSeverity.MILD;
        else sev = OsaSeverity.NORMAL;

        String cpap = sev == OsaSeverity.SEVERE || sev == OsaSeverity.MODERATE
                ? "Auto-CPAP titration (initial 8-14 cmH2O) with heated humidification and nasal pillows interface."
                : "Lifestyle modifications, positional therapy, or oral mandibular advancement appliance.";

        return new PsgReport(studyId, patientId, ahi, nadirSpo2, efficiency, sev, cpap, Instant.now());
    }
}
