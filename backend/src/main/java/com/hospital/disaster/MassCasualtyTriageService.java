package com.hospital.disaster;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class MassCasualtyTriageService {

    public enum TriageTag {
        GREEN_MINOR("Green (Walking Wounded / Minor)"),
        YELLOW_DELAYED("Yellow (Delayed / Serious but stable)"),
        RED_IMMEDIATE("Red (Immediate / Life Threatening Shock / Airway)"),
        BLACK_EXPECTANT("Black (Expectant / Deceased)");

        private final String label;
        TriageTag(String label) { this.label = label; }
        public String getLabel() { return label; }
    }

    public static record TriageAssessment(
            String casualtyId,
            boolean ableToWalk,
            boolean spontaneousBreathing,
            int respiratoryRateBpm,
            boolean radialPulsePresent,
            boolean obeysCommands,
            TriageTag assignedTag,
            Instant triagedAt
    ) implements Serializable {}

    public TriageAssessment executeStartTriage(
            String id,
            boolean walk,
            boolean breath,
            int rr,
            boolean pulse,
            boolean obeys
    ) {
        TriageTag tag;
        if (walk) {
            tag = TriageTag.GREEN_MINOR;
        } else if (!breath) {
            tag = TriageTag.BLACK_EXPECTANT;
        } else if (rr > 30 || !pulse || !obeys) {
            tag = TriageTag.RED_IMMEDIATE;
        } else {
            tag = TriageTag.YELLOW_DELAYED;
        }

        return new TriageAssessment(id, walk, breath, rr, pulse, obeys, tag, Instant.now());
    }
}
