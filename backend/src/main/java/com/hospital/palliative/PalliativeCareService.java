package com.hospital.palliative;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class PalliativeCareService {

    public static record PalliativeAssessment(
            String patientId,
            int ppsPercentage, // 10% to 100%
            int painScore0To10,
            int dyspneaScore0To10,
            int anxietyScore0To10,
            String comfortCareProtocol,
            Instant evaluatedAt
    ) implements Serializable {}

    public PalliativeAssessment evaluateComfort(String patientId, int pps, int pain, int dyspnea, int anxiety) {
        StringBuilder protocol = new StringBuilder();
        if (pain >= 4) protocol.append("Morphine 5-10mg PO q3h PRN breakthrough pain. ");
        if (dyspnea >= 4) protocol.append("Low-dose Morphine 2.5-5mg PO + fan to face for refractory breathlessness. ");
        if (anxiety >= 4) protocol.append("Lorazepam 0.5-1.0mg SL q4h PRN anxiety. ");

        return new PalliativeAssessment(patientId, pps, pain, dyspnea, anxiety, protocol.toString(), Instant.now());
    }
}
