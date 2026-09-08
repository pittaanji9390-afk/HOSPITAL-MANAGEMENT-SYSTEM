package com.hospital.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medication_administrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationAdministrationRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String administrationUuid;

    @Column(nullable = false, length = 32)
    private String patientMrn;

    @Column(nullable = false, length = 64)
    private String rxCuiCode;

    @Column(nullable = false, length = 128)
    private String medicationName;

    @Column(nullable = false, length = 32)
    private String prescribedDose;

    @Column(nullable = false, length = 32)
    private String route;

    @Column(nullable = false)
    private LocalDateTime scheduledAdministrationTime;

    private LocalDateTime actualAdministrationTime;

    @Column(length = 32)
    private String status; // GIVEN, HELD, REFUSED, MISSED

    @Column(length = 64)
    private String administeringNurseId;

    @Column(length = 64)
    private String dualWitnessNurseId;
}
