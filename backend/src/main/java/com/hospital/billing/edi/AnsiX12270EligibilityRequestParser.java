package com.hospital.billing.edi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class AnsiX12270EligibilityRequestParser {

    @Data
    @AllArgsConstructor
    public static class EligibilityInquiry270 {
        private String transactionSetControlNumber;
        private String payerId; // Payer ISA08 / NM1*PR
        private String providerNpi; // NM1*1P
        private String patientMemberId; // NM1*IL
        private String patientLastName;
        private String patientFirstName;
        private LocalDate patientDob;
        private List<String> requestedServiceTypeCodes; // 1 (Medical Care), 30 (Health Benefit Plan), 33 (Chiropractic), 48 (Hospital - Inpatient)
    }

    public String generate270Edi(EligibilityInquiry270 req) {
        StringBuilder edi = new StringBuilder();
        edi.append("ISA*00*          *00*          *ZZ*HOSPITAL_SYS   *ZZ*").append(req.getPayerId()).append("       *260908*1800*^*00501*000000001*0*P*:~\n");
        edi.append("GS*HS*HOSPITAL_SYS*").append(req.getPayerId()).append("*20260908*180000*1*X*005010X279A1~\n");
        edi.append("ST*270*").append(req.getTransactionSetControlNumber()).append("*005010X279A1~\n");
        edi.append("BHT*0022*13*REQ20260908*20260908*1800~\n");
        edi.append("HL*1**20*1~\n");
        edi.append("NM1*PR*2*METRO PAYER*****PI*").append(req.getPayerId()).append("~\n");
        edi.append("HL*2*1*21*1~\n");
        edi.append("NM1*1P*1*METRO HOSPITAL*****XX*").append(req.getProviderNpi()).append("~\n");
        edi.append("HL*3*2*22*0~\n");
        edi.append("NM1*IL*1*").append(req.getPatientLastName()).append("*").append(req.getPatientFirstName()).append("****MI*").append(req.getPatientMemberId()).append("~\n");
        edi.append("DMG*D8*").append(req.getPatientDob().toString().replace("-", "")).append("~\n");
        for (String stc : req.getRequestedServiceTypeCodes()) {
            edi.append("EQ*").append(stc).append("~\n");
        }
        edi.append("SE*12*").append(req.getTransactionSetControlNumber()).append("~\n");
        edi.append("GE*1*1~\n");
        edi.append("IEA*1*000000001~\n");
        return edi.toString();
    }
}
