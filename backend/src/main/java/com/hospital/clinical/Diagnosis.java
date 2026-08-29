package com.hospital.clinical;

import com.hospital.ipd.IpdAdmission;
import com.hospital.opd.OpdEncounter;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "diagnoses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diagnosis {

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

    @Column(name = "icd10_code", nullable = false, length = 20)
    private String icd10Code;

    @Column(name = "diagnosis_text", nullable = false, length = 255)
    private String diagnosisText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private DiagnosisType type = DiagnosisType.PROVISIONAL;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private DiagnosisStatus status = DiagnosisStatus.ACTIVE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosed_by", nullable = false)
    private Doctor diagnosedBy;

    @Column(name = "diagnosed_at", nullable = false)
    @Builder.Default
    private Instant diagnosedAt = Instant.now();

    public enum DiagnosisType {
        PROVISIONAL, FINAL, SECONDARY, DIFFERENTIAL, ADMISSION, DISCHARGE
    }

    public enum DiagnosisStatus {
        ACTIVE, RESOLVED, RULED_OUT
    }
}

@Entity
@Table(name = "patient_allergies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class PatientAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false, length = 100)
    private String allergen;

    @Enumerated(EnumType.STRING)
    @Column(name = "allergy_type", nullable = false, length = 50)
    private AllergyType allergyType;

    @Column(nullable = false, length = 255)
    private String reaction;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AllergySeverity severity;

    @Column(name = "onset_date")
    private LocalDate onsetDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private AllergyStatus status = AllergyStatus.ACTIVE;

    @Column(name = "recorded_by", nullable = false, length = 50)
    private String recordedBy;

    @Column(name = "recorded_at", nullable = false)
    @Builder.Default
    private Instant recordedAt = Instant.now();

    public enum AllergyType {
        DRUG, FOOD, ENVIRONMENTAL, LATEX, OTHER
    }

    public enum AllergySeverity {
        MILD, MODERATE, SEVERE, LIFE_THREATENING
    }

    public enum AllergyStatus {
        ACTIVE, INACTIVE, RESOLVED, REFUTED
    }
}

@Entity
@Table(name = "patient_vitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class PatientVital {

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

    @Column(name = "temp_celsius", precision = 4, scale = 1)
    private BigDecimal tempCelsius;

    @Column(name = "bp_systolic")
    private Integer bpSystolic;

    @Column(name = "bp_diastolic")
    private Integer bpDiastolic;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "resp_rate")
    private Integer respRate;

    @Column(name = "spo2", precision = 4, scale = 1)
    private BigDecimal spo2;

    @Column(name = "blood_glucose", precision = 5, scale = 1)
    private BigDecimal bloodGlucose;

    @Column(name = "pain_score")
    private Integer painScore;

    @Column(name = "weight_kg", precision = 5, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "height_cm", precision = 5, scale = 2)
    private BigDecimal heightCm;

    @Column(name = "bmi", precision = 4, scale = 1)
    private BigDecimal bmi;

    @Column(name = "recorded_by", nullable = false, length = 50)
    private String recordedBy;

    @Column(name = "recorded_at", nullable = false)
    @Builder.Default
    private Instant recordedAt = Instant.now();
}
