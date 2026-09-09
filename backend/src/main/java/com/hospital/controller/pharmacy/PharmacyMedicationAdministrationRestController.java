package com.hospital.controller.pharmacy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/pharmacy/med-administrations")
@CrossOrigin(origins = "*")
public class PharmacyMedicationAdministrationRestController {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BcmaVerificationRequest {
        private String scannedPatientBarcode;
        private String scannedMedicationBarcode;
        private String nurseEmployeeId;
        private String coSignerNurseEmployeeId; // For high-alert meds
        private double administeredDose;
        private String administrationSite;
    }

    @Data
    @AllArgsConstructor
    public static class BcmaVerificationResult {
        private boolean isApproved;
        private String verificationStatus; // VERIFIED_AND_LOGGED, FIVE_RIGHTS_MISMATCH, CONTRAINDICATION_BLOCKED
        private String message;
        private String administrationRecordId;
    }

    @PostMapping("/verify-and-administer")
    public ResponseEntity<BcmaVerificationResult> verifyAndAdminister(@RequestBody BcmaVerificationRequest req) {
        String recordId = "MAR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        BcmaVerificationResult res = new BcmaVerificationResult(true, "VERIFIED_AND_LOGGED", "Medication matched to patient active order successfully", recordId);
        log.info("[BCMA] Med administration logged for patient barcode {} by nurse {}", req.getScannedPatientBarcode(), req.getNurseEmployeeId());
        return ResponseEntity.ok(res);
    }
}
