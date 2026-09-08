package com.hospital.controller.billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/billing/edi-claims")
@CrossOrigin(origins = "*")
public class BillingClaimsAnsiX12RestController {

    @Data
    @AllArgsConstructor
    public static class EdiClaimSummary {
        private String claimControlNumber;
        private String patientId;
        private String payerName; // Medicare Part A, Blue Cross Blue Shield, UnitedHealth
        private double totalBilledCharges;
        private double expectedReimbursement;
        private String drgCode;
        private String claimStatus; // SCRUBBED_READY, TRANSMITTED_837I, PAID_835_REMIT, DENIED_APPEAL
        private Instant submissionTimestamp;
    }

    private final Map<String, EdiClaimSummary> claims = new LinkedHashMap<>();

    public BillingClaimsAnsiX12RestController() {
        claims.put("CLM-881201", new EdiClaimSummary("CLM-881201", "PT-9941", "Medicare Part A", 48500.0, 39200.0, "MS-DRG 329", "TRANSMITTED_837I", Instant.now().minusSeconds(86400)));
        claims.put("CLM-881202", new EdiClaimSummary("CLM-881202", "PT-8812", "Blue Cross Blue Shield", 82100.0, 68400.0, "MS-DRG 246", "PAID_835_REMIT", Instant.now().minusSeconds(86400 * 3)));
    }

    @GetMapping
    public ResponseEntity<List<EdiClaimSummary>> getClaims() {
        return ResponseEntity.ok(new ArrayList<>(claims.values()));
    }
}
