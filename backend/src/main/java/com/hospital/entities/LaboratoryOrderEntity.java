package com.hospital.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "laboratory_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaboratoryOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String orderAccessionNumber;

    @Column(nullable = false, length = 32)
    private String patientMrn;

    @Column(nullable = false, length = 64)
    private String loincTestCode;

    @Column(nullable = false, length = 128)
    private String testName;

    @Column(nullable = false)
    private LocalDateTime orderTimestamp;

    private LocalDateTime collectionTimestamp;
    private LocalDateTime verificationTimestamp;

    @Column(length = 32)
    private String specimenType; // WHOLE_BLOOD, SERUM, PLASMA, CSF, URINE

    @Column(length = 32)
    private String status; // ORDERED, COLLECTED, IN_ANALYTICAL_PROCESS, VERIFIED, CANCELLED

    @Column(length = 32)
    private String priority; // ROUTINE, STAT, TIMED
}
