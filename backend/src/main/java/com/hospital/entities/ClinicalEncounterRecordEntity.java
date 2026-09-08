package com.hospital.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clinical_encounters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicalEncounterRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String encounterUuid;

    @Column(nullable = false, length = 32)
    private String patientMrn;

    @Column(nullable = false, length = 32)
    private String encounterType; // INPATIENT, OUTPATIENT, EMERGENCY, ICU, SURGERY

    @Column(nullable = false)
    private LocalDateTime admissionTime;

    private LocalDateTime dischargeTime;

    @Column(length = 64)
    private String attendingPhysicianId;

    @Column(length = 32)
    private String departmentCode;

    @Column(length = 32)
    private String assignedBedCode;

    @Column(columnDefinition = "TEXT")
    private String chiefComplaint;

    @Column(columnDefinition = "TEXT")
    private String dischargeDisposition;
}
