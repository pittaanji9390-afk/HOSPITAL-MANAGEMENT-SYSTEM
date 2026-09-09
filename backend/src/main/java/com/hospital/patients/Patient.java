package com.hospital.patients;

import com.hospital.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String mrn; // Medical Record Number

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    @Column(name = "blood_group", length = 10)
    private String bloodGroup;

    @Column(name = "national_id", length = 50)
    private String nationalId;

    @Column(nullable = false, length = 25)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(name = "address_line1", length = 150)
    private String addressLine1;

    @Column(name = "address_line2", length = 150)
    private String addressLine2;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(length = 50)
    @Builder.Default
    private String country = "India";

    @Column(name = "emergency_contact_name", length = 100)
    private String emergencyContactName;

    @Column(name = "emergency_contact_relation", length = 50)
    private String emergencyContactRelation;

    @Column(name = "emergency_contact_phone", length = 25)
    private String emergencyContactPhone;

    @Column(name = "marital_status", length = 20)
    private String maritalStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private PatientStatus status = PatientStatus.ACTIVE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merged_into_id")
    private Patient mergedInto;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum PatientStatus {
        ACTIVE, INACTIVE, MERGED, DECEASED
    }
}
