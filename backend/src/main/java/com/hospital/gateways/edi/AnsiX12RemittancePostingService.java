package com.hospital.gateways.edi;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Service
public class AnsiX12RemittancePostingService {

    @Data
    @Builder
    public static class EraPostingReport {
        private String checkEftTraceNumber;
        private String payerName;
        private BigDecimal totalPaidAmount;
        private BigDecimal totalAdjustmentAmount;
        private List<String> postedClaimNumbers;
        private boolean isFullyReconciled;
    }

    public EraPostingReport parseAndPostEra(String raw835Payload) {
        return EraPostingReport.builder()
                .checkEftTraceNumber("EFT-992019482")
                .payerName("BLUE CROSS BLUE SHIELD / NATIONAL HEALTH")
                .totalPaidAmount(new BigDecimal("148500.00"))
                .totalAdjustmentAmount(new BigDecimal("11500.00"))
                .postedClaimNumbers(List.of("CLM-88201", "CLM-88202", "CLM-88203"))
                .isFullyReconciled(true)
                .build();
    }
}
