package com.hospital.bloodbank;

import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
import com.hospital.staff.Doctor;
import com.hospital.staff.Staff;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "blood_donors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodDonor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "donor_no", nullable = false, unique = true, length = 30)
    private String donorNo;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "blood_group", nullable = false, length = 10)
    private String bloodGroup;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false, length = 25)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(name = "last_donation_date")
    private LocalDate lastDonationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "eligibility_status", nullable = false, length = 30)
    @Builder.Default
    private EligibilityStatus eligibilityStatus = EligibilityStatus.ELIGIBLE;

    public enum EligibilityStatus {
        ELIGIBLE, TEMPORARILY_DEFERRED, PERMANENTLY_DEFERRED
    }
}

@Entity
@Table(name = "blood_units")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class BloodUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_barcode", nullable = false, unique = true, length = 50)
    private String unitBarcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id", nullable = false)
    private BloodDonor donor;

    @Column(name = "blood_group", nullable = false, length = 10)
    private String bloodGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "component_type", nullable = false, length = 30)
    private ComponentType componentType;

    @Column(name = "volume_ml", nullable = false)
    @Builder.Default
    private int volumeMl = 450;

    @Column(name = "collection_date", nullable = false)
    @Builder.Default
    private LocalDate collectionDate = LocalDate.now();

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "storage_location", nullable = false, length = 100)
    private String storageLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private UnitStatus status = UnitStatus.TESTED_SAFE;

    public enum ComponentType {
        WHOLE_BLOOD, PACKED_RED_CELLS, FRESH_FROZEN_PLASMA, PLATELETS, CRYOPRECIPITATE
    }

    public enum UnitStatus {
        QUARANTINED, TESTED_SAFE, RESERVED, ISSUED, EXPIRED, DISCARDED
    }
}

@Repository
interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {
    Page<BloodDonor> findAll(Pageable pageable);
}

@Repository
interface BloodUnitRepository extends JpaRepository<BloodUnit, Long> {
    List<BloodUnit> findByBloodGroupAndStatusAndExpiryDateAfter(String bloodGroup, BloodUnit.UnitStatus status, LocalDate now);

    @Query("SELECT u.bloodGroup, COUNT(u) FROM BloodUnit u WHERE u.status = 'TESTED_SAFE' AND u.expiryDate >= CURRENT_DATE GROUP BY u.bloodGroup")
    List<Object[]> getStockSummary();
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BloodStockSummaryDto {
    private String bloodGroup;
    private long count;
}

@Service
@RequiredArgsConstructor
class BloodBankService {
    private final BloodDonorRepository donorRepository;
    private final BloodUnitRepository unitRepository;
    private final SequenceService sequenceService;

    @Transactional(readOnly = true)
    public List<BloodStockSummaryDto> getStockSummary() {
        return unitRepository.getStockSummary().stream()
                .map(row -> BloodStockSummaryDto.builder()
                        .bloodGroup((String) row[0])
                        .count((Long) row[1])
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<BloodUnit> getAvailableUnits(String bloodGroup) {
        return unitRepository.findByBloodGroupAndStatusAndExpiryDateAfter(
                bloodGroup, BloodUnit.UnitStatus.TESTED_SAFE, LocalDate.now());
    }
}

@RestController
@RequestMapping("/api/v1/blood-bank")
@RequiredArgsConstructor
@Tag(name = "Blood Bank & Transfusion", description = "Donors, component tracking, storage refrigeration, and cross-matching")
public class BloodBankController {
    private final BloodBankService service;

    @GetMapping("/stock-summary")
    @Operation(summary = "Get aggregated inventory count by blood group (A+, B+, O+, AB-, etc.)")
    public ResponseEntity<ApiResponse<List<BloodStockSummaryDto>>> getStockSummary() {
        return ResponseEntity.ok(ApiResponse.ok(service.getStockSummary()));
    }

    @GetMapping("/available-units")
    @Operation(summary = "Find tested safe blood bags by blood group")
    public ResponseEntity<ApiResponse<List<BloodUnit>>> getAvailableUnits(@RequestParam String bloodGroup) {
        return ResponseEntity.ok(ApiResponse.ok(service.getAvailableUnits(bloodGroup)));
    }
}
