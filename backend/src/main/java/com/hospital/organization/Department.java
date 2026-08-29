package com.hospital.organization;

import com.hospital.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private DepartmentType type;

    @Column(name = "head_staff_id")
    private Long headStaffId;

    @Column(length = 25)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String location;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    public enum DepartmentType {
        CLINICAL,
        DIAGNOSTIC,
        ADMINISTRATIVE,
        SUPPORT,
        EMERGENCY
    }
}
