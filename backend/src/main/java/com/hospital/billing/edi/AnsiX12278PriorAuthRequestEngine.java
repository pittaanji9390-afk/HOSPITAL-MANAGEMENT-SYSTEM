package com.hospital.billing.edi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AnsiX12278PriorAuthRequestEngine {

    @Data
    @AllArgsConstructor
    public static class PriorAuthRequest278 {
        private String authTrackingNumber;
        private String patientMemberId;
        private String orderingNpi;
        private String requestedCptCode;
        private String procedureDescription;
        private String icd10PrimaryDiagnosis;
        private String clinicalJustification;
    }

    public String build278Edi(PriorAuthRequest278 req) {
        return "ST*278*" + req.getAuthTrackingNumber() + "*005010X217~\nUM*AR*I*2*11:B~\nHI*BK:" + req.getIcd10PrimaryDiagnosis() + "~\nSV2*" + req.getRequestedCptCode() + "~\nSE*5*" + req.getAuthTrackingNumber() + "~";
    }
}
