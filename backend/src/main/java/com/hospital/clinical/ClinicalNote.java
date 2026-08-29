package com.hospital.clinical;

import com.hospital.common.BaseEntity;
import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
import com.hospital.patients.Patient;
import com.hospital.staff.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "clinical_notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicalNote extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encounter_id")
    private OpdEncounter encounter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id")
    private IpdAdmission admission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Staff author;

    @Enumerated(EnumType.STRING)
    @Column(name = "note_type", nullable = false, length = 30)
    private NoteType noteType;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private NoteStatus status = NoteStatus.DRAFT;

    @Column(name = "finalized_at")
    private Instant finalizedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amended_from_id")
    private ClinicalNote amendedFrom;

    @Column(name = "amendment_reason", columnDefinition = "TEXT")
    private String amendmentReason;

    @Version
    @Column(nullable = false)
    @Builder.Default
    private int version = 0;

    public enum NoteType {
        PROGRESS_NOTE,
        CONSULTATION,
        NURSING_NOTE,
        DISCHARGE_SUMMARY,
        PROCEDURE_NOTE,
        EMERGENCY_NOTE
    }

    public enum NoteStatus {
        DRAFT,
        FINALIZED,
        AMENDED
    }
}
