package com.hospital.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class AcuteStemiClinicalPathway {

    @Data
    @Builder
    public static class StemiMilestone {
        private String milestoneCode;
        private String description;
        private int targetElapsedMinutesFromArrival;
        private String responsibleRole;
        private List<String> mandatoryActions;
    }

    public List<StemiMilestone> getPathwayProtocols() {
        return List.of(
            StemiMilestone.builder()
                .milestoneCode("M1_DOOR_TO_ECG")
                .description("First Diagnostic 12-Lead ECG Acquisition & Physician Interpretation")
                .targetElapsedMinutesFromArrival(10)
                .responsibleRole("TRIAGE_NURSE_AND_ED_PHYSICIAN")
                .mandatoryActions(List.of("Perform 12-lead ECG within 10 min", "Identify ST elevation in >= 2 contiguous leads", "Notify Interventional Cardiologist"))
                .build(),
            StemiMilestone.builder()
                .milestoneCode("M2_CATH_LAB_ACTIVATION")
                .description("Single-Call Cath Lab Team Activation & Antithrombotic Loading")
                .targetElapsedMinutesFromArrival(20)
                .responsibleRole("INTERVENTIONAL_TEAM")
                .mandatoryActions(List.of("Aspirin 325mg PO chewable", "Ticagrelor 180mg or Prasugrel 60mg load", "Unfractionated Heparin 60 U/kg IV bolus"))
                .build(),
            StemiMilestone.builder()
                .milestoneCode("M3_DOOR_TO_BALLOON")
                .description("Primary Percutaneous Coronary Intervention (PCI) Culprit Lesion Revascularization")
                .targetElapsedMinutesFromArrival(90)
                .responsibleRole("INTERVENTIONAL_CARDIOLOGIST")
                .mandatoryActions(List.of("Radial artery vascular access", "Coronary angiography", "Thrombus aspiration and Drug-Eluting Stent (DES) deployment"))
                .build()
        );
    }
}
