package com.hospital.pharmacy;

import com.hospital.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicine_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
}

@Entity
@Table(name = "medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String code;

    @Column(name = "brand_name", nullable = false, length = 100)
    private String brandName;

    @Column(name = "generic_name", nullable = false, length = 100)
    private String genericName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private MedicineCategory category;

    @Column(name = "dosage_form", nullable = false, length = 50)
    private String dosageForm; // TABLET, CAPSULE, SYRUP, INJECTION, OINTMENT

    @Column(nullable = false, length = 50)
    private String strength;

    @Column(length = 100)
    private String manufacturer;

    @Column(name = "is_prescription_required", nullable = false)
    @Builder.Default
    private boolean prescriptionRequired = true;

    @Column(name = "is_narcotic", nullable = false)
    @Builder.Default
    private boolean narcotic = false;

    @Column(name = "reorder_level", nullable = false)
    @Builder.Default
    private int reorderLevel = 50;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;

    @Builder.Default
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    private List<MedicineBatch> batches = new ArrayList<>();
}

@Entity
@Table(name = "medicine_batches", uniqueConstraints = {
        @UniqueConstraint(name = "uk_medicine_batch", columnNames = {"medicine_id", "batch_number"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;

    @Column(name = "batch_number", nullable = false, length = 50)
    private String batchNumber;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "cost_price", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal costPrice = BigDecimal.ZERO;

    @Column(name = "selling_price", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal sellingPrice = BigDecimal.ZERO;

    @Column(name = "quantity_in_stock", nullable = false)
    @Builder.Default
    private int quantityInStock = 0;

    @Column(name = "supplier_name", length = 100)
    private String supplierName;

    @Column(name = "received_date")
    @Builder.Default
    private LocalDate receivedDate = LocalDate.now();

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
