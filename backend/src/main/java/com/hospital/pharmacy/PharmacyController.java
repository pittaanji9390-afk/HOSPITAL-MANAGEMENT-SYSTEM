package com.hospital.pharmacy;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import com.hospital.prescriptions.Prescription;
import com.hospital.prescriptions.PrescriptionItem;
import com.hospital.staff.Staff;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "pharmacy_dispensations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PharmacyDispensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dispensation_no", nullable = false, unique = true, length = 30)
    private String dispensationNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispensed_by", nullable = false)
    private Staff dispensedBy;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private DispensationStatus status = DispensationStatus.COMPLETED;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Builder.Default
    private Instant createdAt = Instant.now();

    @Builder.Default
    @OneToMany(mappedBy = "dispensation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PharmacyDispensationItem> items = new ArrayList<>();

    public enum DispensationStatus {
        COMPLETED, RETURNED, CANCELLED
    }
}

@Entity
@Table(name = "pharmacy_dispensation_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class PharmacyDispensationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispensation_id", nullable = false)
    private PharmacyDispensation dispensation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_item_id", nullable = false)
    private PrescriptionItem prescriptionItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id", nullable = false)
    private MedicineBatch batch;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "total_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalPrice;
}

@Repository
interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Optional<Medicine> findByCode(String code);

    @Query("SELECT m FROM Medicine m WHERE m.active = true AND (" +
           "LOWER(m.brandName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(m.genericName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(m.code) LIKE LOWER(CONCAT('%', :query, '%')))")
    Page<Medicine> searchMedicines(@Param("query") String query, Pageable pageable);
}

@Repository
interface MedicineBatchRepository extends JpaRepository<MedicineBatch, Long> {
    List<MedicineBatch> findByMedicineIdAndQuantityInStockGreaterThanAndExpiryDateAfterOrderByExpiryDateAsc(
            Long medicineId, int minStock, LocalDate minDate);

    @Query("SELECT b FROM MedicineBatch b WHERE b.expiryDate <= :alertDate AND b.quantityInStock > 0 ORDER BY b.expiryDate ASC")
    List<MedicineBatch> findExpiringBatches(@Param("alertDate") LocalDate alertDate);
}

@Repository
interface PharmacyDispensationRepository extends JpaRepository<PharmacyDispensation, Long> {
    Page<PharmacyDispensation> findAllByOrderByCreatedAtDesc(Pageable pageable);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class MedicineDto {
    private Long id;
    private String code;
    private String brandName;
    private String genericName;
    private Long categoryId;
    private String categoryName;
    private String dosageForm;
    private String strength;
    private String manufacturer;
    private boolean prescriptionRequired;
    private boolean narcotic;
    private int reorderLevel;
    private int totalStock;
    private boolean active;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DispenseItemRequest {
    @NotNull(message = "Prescription item ID is required")
    private Long prescriptionItemId;
    @NotNull(message = "Batch ID is required")
    private Long batchId;
    @NotNull(message = "Quantity to dispense is required")
    private int quantity;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DispenseRequest {
    @NotNull(message = "Prescription ID is required")
    private Long prescriptionId;
    @NotNull(message = "Pharmacist staff ID is required")
    private Long dispensedByStaffId;
    @NotEmpty(message = "Items to dispense cannot be empty")
    private List<DispenseItemRequest> items;
}

@Service
@RequiredArgsConstructor
class PharmacyService {
    private final MedicineRepository medicineRepository;
    private final MedicineBatchRepository batchRepository;
    private final PharmacyDispensationRepository dispensationRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public PagedResponse<MedicineDto> getMedicines(String query, Pageable pageable) {
        Page<Medicine> page;
        if (query != null && !query.isBlank()) {
            page = medicineRepository.searchMedicines(query, pageable);
        } else {
            page = medicineRepository.findAll(pageable);
        }
        return PagedResponse.from(page.map(this::toMedicineDto));
    }

    @Transactional(readOnly = true)
    public List<MedicineBatch> getAvailableBatches(Long medicineId) {
        return batchRepository.findByMedicineIdAndQuantityInStockGreaterThanAndExpiryDateAfterOrderByExpiryDateAsc(
                medicineId, 0, LocalDate.now());
    }

    @Transactional(readOnly = true)
    public List<MedicineBatch> getExpiringBatches(int daysThreshold) {
        return batchRepository.findExpiringBatches(LocalDate.now().plusDays(daysThreshold));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PharmacyDispensation dispensePrescription(DispenseRequest req, String actor) {
        Prescription prescription = entityManager.getReference(Prescription.class, req.getPrescriptionId());
        Staff pharmacist = entityManager.getReference(Staff.class, req.getDispensedByStaffId());

        String dispNo = sequenceService.getNextNumber("DSP_SEQ");
        BigDecimal totalAmount = BigDecimal.ZERO;

        PharmacyDispensation dispensation = PharmacyDispensation.builder()
                .dispensationNo(dispNo)
                .prescription(prescription)
                .patient(prescription.getPatient())
                .dispensedBy(pharmacist)
                .status(PharmacyDispensation.DispensationStatus.COMPLETED)
                .build();

        for (DispenseItemRequest itemReq : req.getItems()) {
            MedicineBatch batch = batchRepository.findById(itemReq.getBatchId())
                    .orElseThrow(() -> new ResourceNotFoundException("Medicine Batch", "id", itemReq.getBatchId()));

            if (batch.isExpired()) {
                throw new ConflictException("Cannot dispense expired stock from batch: " + batch.getBatchNumber());
            }

            if (batch.getQuantityInStock() < itemReq.getQuantity()) {
                throw new ConflictException("Insufficient stock in batch " + batch.getBatchNumber() + ". Requested: " + itemReq.getQuantity() + ", Available: " + batch.getQuantityInStock());
            }

            // Deduct stock
            batch.setQuantityInStock(batch.getQuantityInStock() - itemReq.getQuantity());
            batchRepository.save(batch);

            PrescriptionItem rxItem = entityManager.getReference(PrescriptionItem.class, itemReq.getPrescriptionItemId());
            rxItem.setQuantityDispensed(rxItem.getQuantityDispensed() + itemReq.getQuantity());
            if (rxItem.getQuantityDispensed() >= rxItem.getQuantityPrescribed()) {
                rxItem.setStatus(PrescriptionItem.ItemStatus.DISPENSED);
            } else {
                rxItem.setStatus(PrescriptionItem.ItemStatus.PARTIALLY_DISPENSED);
            }

            BigDecimal itemTotal = batch.getSellingPrice().multiply(BigDecimal.valueOf(itemReq.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);

            PharmacyDispensationItem dispItem = PharmacyDispensationItem.builder()
                    .dispensation(dispensation)
                    .prescriptionItem(rxItem)
                    .batch(batch)
                    .quantity(itemReq.getQuantity())
                    .unitPrice(batch.getSellingPrice())
                    .totalPrice(itemTotal)
                    .build();

            dispensation.getItems().add(dispItem);
        }

        dispensation.setTotalAmount(totalAmount);
        prescription.setStatus(Prescription.PrescriptionStatus.DISPENSED);

        return dispensationRepository.save(dispensation);
    }

    private MedicineDto toMedicineDto(Medicine m) {
        int totalStock = m.getBatches().stream().mapToInt(MedicineBatch::getQuantityInStock).sum();
        return MedicineDto.builder()
                .id(m.getId())
                .code(m.getCode())
                .brandName(m.getBrandName())
                .genericName(m.getGenericName())
                .categoryId(m.getCategory().getId())
                .categoryName(m.getCategory().getName())
                .dosageForm(m.getDosageForm())
                .strength(m.getStrength())
                .manufacturer(m.getManufacturer())
                .prescriptionRequired(m.isPrescriptionRequired())
                .narcotic(m.isNarcotic())
                .reorderLevel(m.getReorderLevel())
                .totalStock(totalStock)
                .active(m.isActive())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/pharmacy")
@RequiredArgsConstructor
@Tag(name = "Pharmacy & Dispensary", description = "Medicine catalog, batch stock, FEFO dispensing, and expiry tracking")
public class PharmacyController {
    private final PharmacyService service;

    @GetMapping("/medicines")
    @Operation(summary = "Search medicines with pagination and total stock count")
    public ResponseEntity<ApiResponse<PagedResponse<MedicineDto>>> getMedicines(
            @RequestParam(required = false) String query,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getMedicines(query, pageable)));
    }

    @GetMapping("/medicines/{id}/batches")
    @Operation(summary = "Get non-expired batches for a medicine sorted by earliest expiry (FEFO)")
    public ResponseEntity<ApiResponse<List<MedicineBatch>>> getBatches(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(service.getAvailableBatches(id)));
    }

    @GetMapping("/expiring-soon")
    @Operation(summary = "Get list of batches expiring within next N days (default 60 days)")
    public ResponseEntity<ApiResponse<List<MedicineBatch>>> getExpiring(@RequestParam(defaultValue = "60") int days) {
        return ResponseEntity.ok(ApiResponse.ok(service.getExpiringBatches(days)));
    }

    @PostMapping("/dispense")
    @PreAuthorize("hasAuthority('PERM_PHARMACY_DISPENSE') or hasRole('PHARMACIST') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Dispense prescription with transactional stock deduction and FEFO validation")
    public ResponseEntity<ApiResponse<PharmacyDispensation>> dispense(@Valid @RequestBody DispenseRequest request) {
        PharmacyDispensation dispensation = service.dispensePrescription(request, "PHARMACIST");
        return new ResponseEntity<>(ApiResponse.ok(dispensation, "Prescription dispensed successfully"), HttpStatus.CREATED);
    }
}
