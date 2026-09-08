package com.hospital.genetics.pgx;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class HlaB5701AbacavirHypersensitivityEngine {

    @Data
    @AllArgsConstructor
    public static class HlaB5701Result {
        private String patientId;
        private boolean isHlaB5701Positive;
        private String abacavirPrescriptionSafety;
    }

    public HlaB5701Result checkHlaB5701(String patientId, boolean positive) {
        String safety = positive ? "ABSOLUTE CONTRAINDICATION: High risk of fatal multi-organ Abacavir Hypersensitivity Reaction (AHR). Use Tenofovir/Emtricitabine." : "HLA-B*57:01 Negative: Abacavir administration safe.";
        return new HlaB5701Result(patientId, positive, safety);
    }
}
