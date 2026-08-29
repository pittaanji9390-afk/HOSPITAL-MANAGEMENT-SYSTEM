package com.hospital.ipd;

import com.hospital.common.BaseEntity;
import com.hospital.organization.Department;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import com.hospital.staff.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "ipd_admissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IpdAdmission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admission_no", nullable = false, unique = true, length = 30)
    private String admissionNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_doctor_id", nullable = false)
    private Doctor primaryDoctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_bed_id", nullable = false)
    private Bed currentBed;

    @Column(name = "admission_date", nullable = false)
    @Builder.Default
    private Instant admissionDate = Instant.now();

    @Column(name = "discharge_date")
    private Instant dischargeDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "admission_type", nullable = false, length = 30)
    @Builder.Default
    private AdmissionType admissionType = AdmissionType.PLANNED;

    @Column(name = "admission_reason", nullable = false, columnDefinition = "TEXT")
    private String admissionReason;

    @Column(name = "provisional_diagnosis", columnDefinition = "TEXT")
    private String provisionalDiagnosis;

    @Enumerated(EnumType.STRING)
    @Column(name = "discharge_type", length = 30)
    private DischargeType dischargeType;

    @Column(name = "discharge_summary", columnDefinition = "TEXT")
    private String dischargeSummary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private AdmissionStatus status = AdmissionStatus.ADMITTED;

    @Version
    @Column(nullable = false)
    @Builder.Default
    private int version = 0;

    public enum AdmissionType {
        EMERGENCY,
        PLANNED,
        TRANSFER,
        OBSERVATION
    }

    public enum DischargeType {
        ROUTINE,
        AGAINST_MEDICAL_ADVICE,
        TRANSFER,
        DECEASED,
        REFERRED
    }

    public enum AdmissionStatus {
        ADMITTED,
        TRANSFERRED,
        DISCHARGED,
        CANCELLED
    }
}
