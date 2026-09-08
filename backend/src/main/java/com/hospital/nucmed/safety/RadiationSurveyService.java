package com.hospital.nucmed.safety;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hot Lab Daily Ambient Radiation Survey & Removable Wipe Test Engine (NRC 10 CFR 20 / 35.70).
 * - Ambient Geiger-Muller Survey Trigger Level: > 2.0 mR/hr (Restricted area) or > 0.05 mR/hr (Unrestricted).
 * - Removable Contamination Wipe Test Trigger: > 2000 dpm / 100 cm^2 (Beta/Gamma).
 */
@Service
public class RadiationSurveyService {

    public record HotLabSurveyLog(
        String logId,
        String areaName, // Fume Hood, Dose Calibrator, Waste Storage, Injection Chair
        double measuredDoseRateMrHr,
        double wipeTestDpmPer100cm2,
        boolean requiresDecontamination,
        String surveyorBadgeId,
        Instant surveyTime
    ) {}

    private final List<HotLabSurveyLog> surveyLogs = Collections.synchronizedList(new ArrayList<>());

    public HotLabSurveyLog logSurvey(String area, double mrHr, double dpm, String surveyor) {
        boolean decontam = mrHr > 2.0 || dpm > 2000.0;
        HotLabSurveyLog log = new HotLabSurveyLog("SURV-" + UUID.randomUUID().toString().substring(0, 8), area, mrHr, dpm, decontam, surveyor, Instant.now());
        surveyLogs.add(log);
        return log;
    }

    public List<HotLabSurveyLog> getLogs() {
        return new ArrayList<>(surveyLogs);
    }
}
