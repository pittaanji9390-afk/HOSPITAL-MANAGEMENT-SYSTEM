package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class MassCasualtyTriageEngine {

    @Data
    @AllArgsConstructor
    public static class StartTriageResult {
        private String casualtyId;
        private String triageCategory; // RED_IMMEDIATE, YELLOW_DELAYED, GREEN_MINOR, BLACK_EXPECTANT
        private String triageColorTag;
        private String clinicalDirective;
    }

    public StartTriageResult evaluateStart(String casualtyId, boolean canWalk, boolean isBreathing, boolean breathsAfterAirwayOpened, int respRate, boolean radialPulsePresent, boolean followsSimpleCommands) {
        if (canWalk) {
            return new StartTriageResult(casualtyId, "GREEN_MINOR", "GREEN (Walking Wounded)", "Direct to Minor Injury Assembly Area in Outpatient Gym.");
        }
        if (!isBreathing) {
            if (!breathsAfterAirwayOpened) {
                return new StartTriageResult(casualtyId, "BLACK_EXPECTANT", "BLACK (Deceased / Expectant)", "Palliative comfort care or morgue transfer.");
            } else {
                return new StartTriageResult(casualtyId, "RED_IMMEDIATE", "RED (Immediate)", "Immediate airway positioning / advanced airway in Trauma Bay 1.");
            }
        }
        if (respRate > 30 || !radialPulsePresent || !followsSimpleCommands) {
            return new StartTriageResult(casualtyId, "RED_IMMEDIATE", "RED (Immediate)", "Immediate resuscitation & hemorrhage control in Red Zone.");
        }
        return new StartTriageResult(casualtyId, "YELLOW_DELAYED", "YELLOW (Delayed)", "Transfer to Yellow Zone for secondary survey within 60 minutes.");
    }
}
