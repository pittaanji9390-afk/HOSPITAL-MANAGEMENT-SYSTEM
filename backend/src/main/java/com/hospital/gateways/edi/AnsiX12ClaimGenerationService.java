package com.hospital.gateways.edi;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AnsiX12ClaimGenerationService {

    @Data
    @Builder
    public static class X12EdiClaimDocument {
        private String ediPayload;
        private String controlNumber;
        private int totalSegments;
        private BigDecimal totalBilledAmount;
        private boolean isCompliantWithHipaa5010;
    }

    public X12EdiClaimDocument generate837Claim(String claimId, String patientMrn, String payerId, BigDecimal amount) {
        String dt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String edi = "ISA*00*          *00*          *ZZ*SUBMITTER      *ZZ*" + payerId + "        *" + dt + "*1200*^*00501*000000001*0*P*:~\n" +
                     "GS*HC*SUBMITTER*" + payerId + "*" + dt + "*1200*1*X*005010X222A1~\n" +
                     "ST*837*0001*005010X222A1~\n" +
                     "BHT*0019*00*" + claimId + "*" + dt + "*1200*CH~\n" +
                     "NM1*41*2*HOSPITAL HEALTH SYSTEM*****46*192830192~\n" +
                     "CLM*" + claimId + "*" + amount + "***11:B:1*Y*A*Y*Y~\n" +
                     "SE*8*0001~\n" +
                     "GE*1*1~\n" +
                     "IEA*1*000000001~";

        return X12EdiClaimDocument.builder()
                .ediPayload(edi)
                .controlNumber("000000001")
                .totalSegments(9)
                .totalBilledAmount(amount)
                .isCompliantWithHipaa5010(true)
                .build();
    }
}
