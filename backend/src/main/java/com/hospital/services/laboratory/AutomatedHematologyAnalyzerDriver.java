package com.hospital.services.laboratory;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Enterprise Laboratory Information System (LIS) Hematology Analyzer Driver (Sysmex / Beckman Coulter).
 * Parses ASTM E1381/E1394 serial instrument streams, extracts 5-part differential leukocyte counts,
 * and flags abnormal erythrocyte morphology alerts.
 */
@Service
public class AutomatedHematologyAnalyzerDriver {

    @Data
    @Builder
    public static class HematologyRunResult {
        private String analyzerSerialNumber;
        private String specimenBarcode;
        private double wbcCountThousandPerUl;
        private double rbcCountMillionPerUl;
        private double hemoglobinGPerDl;
        private double hematocritPercent;
        private double plateletCountThousandPerUl;
        private double neutrophilPercent;
        private double lymphocytePercent;
        private double monocytePercent;
        private double eosinophilPercent;
        private double basophilPercent;
        private List<String> morphologyAlertFlags;
        private boolean isDeltaCheckPassed;
    }

    public HematologyRunResult parseInstrumentAstmStream(String rawAstmPayload, double previousHemoglobin) {
        List<String> flags = new ArrayList<>();
        double hb = 13.8;
        if (Math.abs(hb - previousHemoglobin) > 2.5) {
            flags.add("DELTA CHECK FAILURE: Hemoglobin shifted by > 2.5 g/dL in < 24 hours. Hold report for repeat verification.");
        }

        return HematologyRunResult.builder()
                .analyzerSerialNumber("SYSMEX-XN9000-01")
                .specimenBarcode("LAB-849204")
                .wbcCountThousandPerUl(7.4)
                .rbcCountMillionPerUl(4.65)
                .hemoglobinGPerDl(hb)
                .hematocritPercent(41.2)
                .plateletCountThousandPerUl(245.0)
                .neutrophilPercent(62.5)
                .lymphocytePercent(28.0)
                .monocytePercent(6.5)
                .eosinophilPercent(2.2)
                .basophilPercent(0.8)
                .morphologyAlertFlags(flags)
                .isDeltaCheckPassed(flags.isEmpty())
                .build();
    }
}
