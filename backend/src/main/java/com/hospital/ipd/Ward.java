package com.hospital.ipd;

import com.hospital.common.BaseEntity;
import com.hospital.organization.Department;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ward extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "ward_type", nullable = false, length = 30)
    private WardType wardType;

    @Column(name = "gender_allowed", nullable = false, length = 10)
    @Builder.Default
    private String genderAllowed = "ALL";

    @Column(name = "total_beds", nullable = false)
    @Builder.Default
    private int totalBeds = 0;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    public enum WardType {
        GENERAL,
        SEMI_PRIVATE,
        PRIVATE,
        ICU,
        NICU,
        CCU,
        ISOLATION,
        MATERNITY,
        PEDIATRIC
    }
}
