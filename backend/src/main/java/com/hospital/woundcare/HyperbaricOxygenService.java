package com.hospital.woundcare;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class HyperbaricOxygenService {

    public enum WagnerGrade {
        GRADE_0_PRE_ULCERATIVE,
        GRADE_1_SUPERFICIAL_ULCER,
        GRADE_2_DEEP_ULCER_TO_TENDON_BONE,
        GRADE_3_OSTEOMYELITIS_OR_DEEP_ABSCESS,
        GRADE_4_FOREFOOT_GANGRENE,
        GRADE_5_WHOLE_FOOT_GANGRENE
    }

    public static record HbotSession(
            String sessionId,
            String patientId,
            WagnerGrade wagnerGrade,
            double tcpo2RoomAirMmHg, // Transcutaneous oximetry < 30 mmHg indicates tissue hypoxia
            double tcpo2InChamber100PercentO2MmHg, // > 200 mmHg predicts successful healing
            double chamberPressureAtmospheresAbsolute, // Typical 2.0 - 2.5 ATA
            int sessionDurationMinutes, // 90-120 mins
            boolean approvedForHbotCoverage,
            String protocolDirectives,
            Instant scheduledAt
    ) implements Serializable {}

    public HbotSession evaluateSession(
            String id,
            String patientId,
            WagnerGrade grade,
            double roomTcpo2,
            double inChamberTcpo2,
            double ata,
            int durationMin
    ) {
        boolean approved = (grade == WagnerGrade.GRADE_3_OSTEOMYELITIS_OR_DEEP_ABSCESS || grade == WagnerGrade.GRADE_4_FOREFOOT_GANGRENE)
                && roomTcpo2 < 40.0 && inChamberTcpo2 >= 200.0;

        String dir = approved
                ? "HBOT Approved (CMS National Coverage): 30 sessions at 2.4 ATA for 90 minutes with air breaks q30m."
                : "Standard advanced moist wound dressing & offloading; HBOT coverage criteria pending re-evaluation.";

        return new HbotSession(id, patientId, grade, roomTcpo2, inChamberTcpo2, ata, durationMin, approved, dir, Instant.now());
    }
}
