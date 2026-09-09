package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalEncounterDto {
    private String encounterUuid;
    private String patientMrn;
    private String patientFullName;
    private String encounterType;
    private LocalDateTime admissionTime;
    private LocalDateTime dischargeTime;
    private String attendingPhysicianName;
    private String departmentName;
    private String wardBedNumber;
    private String chiefComplaint;
    private List<String> icd10DiagnosisCodes;
    private String dischargeSummary;
}
