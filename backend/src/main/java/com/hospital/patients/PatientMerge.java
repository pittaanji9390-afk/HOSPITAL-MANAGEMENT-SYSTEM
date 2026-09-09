package com.hospital.patients;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "patient_merges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientMerge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_patient_id", nullable = false)
    private Patient primaryPatient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merged_patient_id", nullable = false)
    private Patient mergedPatient;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Column(name = "merged_by", nullable = false, length = 50)
    private String mergedBy;

    @Column(name = "merged_at", nullable = false)
    @Builder.Default
    private Instant mergedAt = Instant.now();
}
