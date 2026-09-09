package com.hospital.billing.edi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AnsiX12276ClaimStatusRequestEngine {

    @Data
    @AllArgsConstructor
    public static class ClaimStatusInquiry276 {
        private String claimControlNumber;
        private String patientMemberId;
        private double totalClaimCharge;
        private String serviceStartDate;
    }

    public String generate276Edi(ClaimStatusInquiry276 inq) {
        return "ST*276*0001*005010X212~\nTRN*1*" + inq.getClaimControlNumber() + "*1234567890~\nSE*3*0001~";
    }
}
