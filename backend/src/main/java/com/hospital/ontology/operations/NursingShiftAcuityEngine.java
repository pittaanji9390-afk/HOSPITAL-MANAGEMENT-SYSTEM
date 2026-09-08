package com.hospital.ontology.operations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class NursingShiftAcuityEngine {

    @Data
    @AllArgsConstructor
    public static class WardStaffingRequirement {
        private String wardCode;
        private int totalPatients;
        private int highAcuityVentilatedCount;
        private int recommendedRegisteredNurses;
        private String nurseToPatientRatio;
    }

    public WardStaffingRequirement calculateStaffing(String ward, int totalPatients, int highAcuity) {
        int standardPatients = totalPatients - highAcuity;
        int nursesNeeded;
        String ratio;

        if (ward.contains("ICU")) {
            nursesNeeded = (int) Math.ceil((highAcuity * 1.0) + (standardPatients * 0.5));
            ratio = "1:1 for critical / 1:2 standard ICU";
        } else if (ward.contains("STEPDOWN") || ward.contains("HDU")) {
            nursesNeeded = (int) Math.ceil(totalPatients / 3.0);
            ratio = "1:3 Stepdown HDU";
        } else {
            nursesNeeded = (int) Math.ceil(totalPatients / 5.0);
            ratio = "1:5 General Medical/Surgical";
        }

        return new WardStaffingRequirement(ward, totalPatients, highAcuity, Math.max(1, nursesNeeded), ratio);
    }
}
