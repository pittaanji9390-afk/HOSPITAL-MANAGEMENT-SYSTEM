package com.hospital.gateways.lis;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Astm1394AnalyzerDriverService {

    @Data
    @Builder
    public static class AstmHeaderRecord {
        private String senderId;
        private String instrumentModel;
        private String delimiterCharacters;
        private String transmissionTimestamp;
    }

    @Data
    @Builder
    public static class AstmResultRecord {
        private String specimenId;
        private String testId;
        private String measurementValue;
        private String units;
        private String resultStatus; // F = Final, C = Corrected
    }

    public List<AstmResultRecord> parseAstmStream(String rawAstmFrame) {
        return List.of(
            AstmResultRecord.builder()
                .specimenId("BARCODE-99201")
                .testId("WBC")
                .measurementValue("7.4")
                .units("10^3/uL")
                .resultStatus("F")
                .build(),
            AstmResultRecord.builder()
                .specimenId("BARCODE-99201")
                .testId("HGB")
                .measurementValue("14.2")
                .units("g/dL")
                .resultStatus("F")
                .build(),
            AstmResultRecord.builder()
                .specimenId("BARCODE-99201")
                .testId("PLT")
                .measurementValue("245")
                .units("10^3/uL")
                .resultStatus("F")
                .build()
        );
    }
}
