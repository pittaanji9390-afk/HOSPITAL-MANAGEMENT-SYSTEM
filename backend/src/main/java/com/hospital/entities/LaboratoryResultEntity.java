package com.hospital.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "laboratory_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaboratoryResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String orderAccessionNumber;

    @Column(nullable = false, length = 64)
    private String analyteCode;

    @Column(nullable = false, length = 128)
    private String analyteName;

    @Column(nullable = false, length = 64)
    private String quantitativeResult;

    @Column(length = 32)
    private String standardUnit;

    @Column(length = 64)
    private String referenceRange;

    @Column(length = 16)
    private String abnormalFlag; // NORMAL, HIGH, LOW, CRITICAL_HIGH, CRITICAL_LOW

    @Column(nullable = false)
    private LocalDateTime resultedTimestamp;

    @Column(length = 64)
    private String verifyingPathologist;
}
