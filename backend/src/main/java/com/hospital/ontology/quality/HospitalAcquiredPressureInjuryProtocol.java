package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class HospitalAcquiredPressureInjuryProtocol {

    @Data
    @AllArgsConstructor
    public static class PressureInjuryStaging {
        private String stage; // STAGE_1, STAGE_2, STAGE_3, STAGE_4, UNSTAGEABLE, DTI
        private String clinicalDescription;
        private String recommendedDressing;
        private String repositioningFrequency;
    }

    public PressureInjuryStaging getStagingGuidance(String stage) {
        return new PressureInjuryStaging(stage, "Non-blanchable erythema or tissue loss", "Hydrocolloid or Foam dressing with silicone border", "Q2H lateral turn schedule + low air loss mattress");
    }
}
