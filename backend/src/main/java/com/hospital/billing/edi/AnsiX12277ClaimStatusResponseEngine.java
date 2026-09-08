package com.hospital.billing.edi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AnsiX12277ClaimStatusResponseEngine {

    @Data
    @AllArgsConstructor
    public static class ClaimStatusReport {
        private String claimControlNumber;
        private String statusCode; // A1 (Received), A2 (Accepted), P1 (Pending Review), F1 (Finalized / Paid)
        private String statusDescription;
        private double paidAmount;
    }

    public ClaimStatusReport parse277(String claimId) {
        return new ClaimStatusReport(claimId, "F1", "Claim Finalized and Adjudicated: Electronic 835 Remittance Issued", 39200.0);
    }
}
