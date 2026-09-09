package com.hospital.patients;

import com.hospital.staff.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "patient_consents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "consent_type", nullable = false, length = 50)
    private String consentType; // GENERAL_TREATMENT, DATA_SHARING, SURGICAL_PROCEDURE, RESEARCH

    @Column(nullable = false, columnDefinition = "TEXT")
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private ConsentStatus status = ConsentStatus.GRANTED;

    @Column(name = "granted_at", nullable = false)
    @Builder.Default
    private Instant grantedAt = Instant.now();

    @Column(name = "expires_at")
    private Instant expiresAt;

    @Column(name = "revoked_at")
    private Instant revokedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "witness_staff_id")
    private Staff witnessStaff;

    @Column(name = "document_ref")
    private String documentRef;

    public enum ConsentStatus {
        GRANTED, REVOKED, EXPIRED
    }
}
