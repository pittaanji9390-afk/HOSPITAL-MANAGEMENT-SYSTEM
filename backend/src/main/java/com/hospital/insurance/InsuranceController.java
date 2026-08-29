package com.hospital.insurance;

import com.hospital.billing.Invoice;
import com.hospital.common.*;
import com.hospital.configuration.SequenceService;
import com.hospital.patients.Patient;
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
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "insurance_providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceProvider extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "contact_person", length = 100)
    private String contactPerson;

    @Column(length = 25)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(name = "claim_submission_email", length = 100)
    private String claimSubmissionEmail;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}

@Entity
@Table(name = "insurance_policies", uniqueConstraints = {
        @UniqueConstraint(name = "uk_patient_policy", columnNames = {"patient_id", "provider_id", "policy_no"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class InsurancePolicy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private InsuranceProvider provider;

    @Column(name = "policy_no", nullable = false, length = 50)
    private String policyNo;

    @Column(name = "group_no", length = 50)
    private String groupNo;

    @Column(name = "coverage_percentage", nullable = false, precision = 5, scale = 2)
    @Builder.Default
    private BigDecimal coveragePercentage = BigDecimal.valueOf(80.00);

    @Column(name = "max_coverage_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal maxCoverageAmount;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @Column(name = "valid_until", nullable = false)
    private LocalDate validUntil;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean active = true;
}

@Entity
@Table(name = "insurance_claims")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class InsuranceClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "claim_no", nullable = false, unique = true, length = 30)
    private String claimNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", nullable = false)
    private InsurancePolicy policy;

    @Column(name = "claimed_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal claimedAmount;

    @Column(name = "approved_amount", precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal approvedAmount = BigDecimal.ZERO;

    @Column(name = "patient_copay", precision = 12, scale = 2)
    @Builder.Default
    private BigDecimal patientCopay = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private ClaimStatus status = ClaimStatus.SUBMITTED;

    @Column(name = "rejection_reason", columnDefinition = "TEXT")
    private String rejectionReason;

    @Column(name = "submitted_at", nullable = false)
    @Builder.Default
    private Instant submittedAt = Instant.now();

    @Column(name = "adjudicated_at")
    private Instant adjudicatedAt;

    public enum ClaimStatus {
        SUBMITTED, UNDER_REVIEW, APPROVED, PARTIALLY_APPROVED, REJECTED
    }
}

@Repository
interface InsuranceProviderRepository extends JpaRepository<InsuranceProvider, Long> {
    List<InsuranceProvider> findByActiveTrue();
}

@Repository
interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
    List<InsurancePolicy> findByPatientIdAndActiveTrue(Long patientId);
}

@Repository
interface InsuranceClaimRepository extends JpaRepository<InsuranceClaim, Long> {
    Page<InsuranceClaim> findAllByOrderBySubmittedAtDesc(Pageable pageable);
    List<InsuranceClaim> findByInvoiceId(Long invoiceId);
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class SubmitClaimRequest {
    @NotNull(message = "Invoice ID is required")
    private Long invoiceId;
    @NotNull(message = "Policy ID is required")
    private Long policyId;
    @NotNull(message = "Claimed amount is required")
    private BigDecimal claimedAmount;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ClaimDto {
    private Long id;
    private String claimNo;
    private Long invoiceId;
    private String invoiceNo;
    private String patientName;
    private String providerName;
    private String policyNo;
    private BigDecimal claimedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal patientCopay;
    private InsuranceClaim.ClaimStatus status;
    private String rejectionReason;
    private Instant submittedAt;
    private Instant adjudicatedAt;
}

@Service
@RequiredArgsConstructor
class InsuranceService {
    private final InsuranceProviderRepository providerRepository;
    private final InsurancePolicyRepository policyRepository;
    private final InsuranceClaimRepository claimRepository;
    private final SequenceService sequenceService;
    private final jakarta.persistence.EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<InsuranceProvider> getProviders() {
        return providerRepository.findByActiveTrue();
    }

    @Transactional(readOnly = true)
    public PagedResponse<ClaimDto> getClaims(Pageable pageable) {
        Page<InsuranceClaim> page = claimRepository.findAllByOrderBySubmittedAtDesc(pageable);
        return PagedResponse.from(page.map(this::toClaimDto));
    }

    @Transactional
    public ClaimDto submitClaim(SubmitClaimRequest req) {
        Invoice invoice = entityManager.getReference(Invoice.class, req.getInvoiceId());
        InsurancePolicy policy = entityManager.getReference(InsurancePolicy.class, req.getPolicyId());

        String claimNo = sequenceService.getNextNumber("CLM_SEQ");

        InsuranceClaim claim = InsuranceClaim.builder()
                .claimNo(claimNo)
                .invoice(invoice)
                .policy(policy)
                .claimedAmount(req.getClaimedAmount())
                .status(InsuranceClaim.ClaimStatus.SUBMITTED)
                .build();

        return toClaimDto(claimRepository.save(claim));
    }

    public ClaimDto toClaimDto(InsuranceClaim c) {
        return ClaimDto.builder()
                .id(c.getId())
                .claimNo(c.getClaimNo())
                .invoiceId(c.getInvoice().getId())
                .invoiceNo(c.getInvoice().getInvoiceNo())
                .patientName(c.getInvoice().getPatient().getFirstName() + " " + c.getInvoice().getPatient().getLastName())
                .providerName(c.getPolicy().getProvider().getName())
                .policyNo(c.getPolicy().getPolicyNo())
                .claimedAmount(c.getClaimedAmount())
                .approvedAmount(c.getApprovedAmount())
                .patientCopay(c.getPatientCopay())
                .status(c.getStatus())
                .rejectionReason(c.getRejectionReason())
                .submittedAt(c.getSubmittedAt())
                .adjudicatedAt(c.getAdjudicatedAt())
                .build();
    }
}

@RestController
@RequestMapping("/api/v1/insurance")
@RequiredArgsConstructor
@Tag(name = "Insurance & TPA", description = "Payers, policies, pre-authorizations, and claims adjudication")
public class InsuranceController {
    private final InsuranceService service;

    @GetMapping("/providers")
    @Operation(summary = "Get list of registered insurance providers/TPAs")
    public ResponseEntity<ApiResponse<List<InsuranceProvider>>> getProviders() {
        return ResponseEntity.ok(ApiResponse.ok(service.getProviders()));
    }

    @GetMapping("/claims")
    @Operation(summary = "List insurance claims with pagination")
    public ResponseEntity<ApiResponse<PagedResponse<ClaimDto>>> getClaims(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(service.getClaims(pageable)));
    }

    @PostMapping("/claims")
    @PreAuthorize("hasAuthority('PERM_INSURANCE_CLAIM_MANAGE') or hasRole('ACCOUNTANT') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "File a new insurance reimbursement / cashless claim")
    public ResponseEntity<ApiResponse<ClaimDto>> submitClaim(@Valid @RequestBody SubmitClaimRequest request) {
        ClaimDto claim = service.submitClaim(request);
        return new ResponseEntity<>(ApiResponse.ok(claim, "Claim filed successfully"), HttpStatus.CREATED);
    }
}
