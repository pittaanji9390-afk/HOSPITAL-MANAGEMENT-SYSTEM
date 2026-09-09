package com.hospital.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class AdvancedTraumaLifeSupportPathway {

    @Data
    @Builder
    public static class AtlsSurveyStep {
        private String step;
        private String assessmentFocus;
        private List<String> criticalInterventions;
    }

    public List<AtlsSurveyStep> getPrimarySurveySteps() {
        return List.of(
            AtlsSurveyStep.builder()
                .step("A - AIRWAY")
                .assessmentFocus("Airway maintenance with cervical spine protection")
                .criticalInterventions(List.of("In-line manual cervical stabilization", "Suction airway secretions/blood", "Rapid Sequence Intubation (RSI) if GCS <= 8"))
                .build(),
            AtlsSurveyStep.builder()
                .step("B - BREATHING")
                .assessmentFocus("Breathing and ventilation")
                .criticalInterventions(List.of("Needle decompression / finger thoracostomy for tension pneumothorax", "Chest tube insertion (28-32 Fr) for hemothorax", "High-flow supplemental oxygen"))
                .build(),
            AtlsSurveyStep.builder()
                .step("C - CIRCULATION")
                .assessmentFocus("Circulation with hemorrhage control")
                .criticalInterventions(List.of("Direct pressure on active bleeding", "Pelvic binder application for open-book pelvic fractures", "Activate Massive Transfusion Protocol (1:1:1 PRBC:FFP:Platelets)"))
                .build(),
            AtlsSurveyStep.builder()
                .step("D - DISABILITY")
                .assessmentFocus("Neurologic status (GCS and pupillary responsiveness)")
                .criticalInterventions(List.of("Calculate Glasgow Coma Scale", "Examine pupillary symmetry and light reflex", "Check blood glucose"))
                .build(),
            AtlsSurveyStep.builder()
                .step("E - EXPOSURE")
                .assessmentFocus("Exposure and environmental control (Hypothermia prevention)")
                .criticalInterventions(List.of("Completely undress patient to inspect for occult injuries", "Cover with warm blankets and utilize forced-air warming device"))
                .build()
        );
    }
}
