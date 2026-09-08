package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceClaimSubmissionDto {
    private String claimUuid;
    private String patientMrn;
    private String payerPayerId;
    private String payerName;
    private String policyNumber;
    private LocalDate serviceStartDate;
    private LocalDate serviceEndDate;
    private BigDecimal totalBilledAmount;
    private List<String> billedCptCodes;
    private List<String> primaryAndSecondaryIcd10Codes;
    private String claimStatus; // SCRUBBED, SUBMITTED, ADJUDICATED, DENIED, PAID
}
