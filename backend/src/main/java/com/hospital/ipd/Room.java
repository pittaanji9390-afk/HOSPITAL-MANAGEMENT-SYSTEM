package com.hospital.ipd;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rooms", uniqueConstraints = {
        @UniqueConstraint(name = "uk_ward_room", columnNames = {"ward_id", "room_number"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @Column(name = "room_number", nullable = false, length = 30)
    private String roomNumber;

    @Column(name = "room_type", nullable = false, length = 30)
    @Builder.Default
    private String roomType = "STANDARD";

    @Column(name = "rate_per_day", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal ratePerDay = BigDecimal.ZERO;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}
