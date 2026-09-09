package com.hospital.ipd;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "beds", uniqueConstraints = {
        @UniqueConstraint(name = "uk_room_bed", columnNames = {"room_id", "bed_number"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "bed_number", nullable = false, length = 30)
    private String bedNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private BedStatus status = BedStatus.AVAILABLE;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    @Version
    @Column(nullable = false)
    @Builder.Default
    private int version = 0;

    public enum BedStatus {
        AVAILABLE,
        RESERVED,
        OCCUPIED,
        CLEANING,
        MAINTENANCE,
        OUT_OF_SERVICE
    }
}
