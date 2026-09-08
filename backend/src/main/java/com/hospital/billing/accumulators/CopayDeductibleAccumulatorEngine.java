package com.hospital.billing.accumulators;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class CopayDeductibleAccumulatorEngine {

    @Data
    @AllArgsConstructor
    public static class AccumulatorState {
        private String patientId;
        private double totalDeductibleLimit;
        private double accumulatedDeductibleMet;
        private double outOfPocketMaxLimit;
        private double accumulatedOutOfPocketMet;
        private boolean isDeductibleFullyMet;
    }

    public AccumulatorState calculateAccumulator(String patientId, double deductibleLimit, double deductibleMet, double moopLimit, double moopMet) {
        return new AccumulatorState(patientId, deductibleLimit, deductibleMet, moopLimit, moopMet, deductibleMet >= deductibleLimit);
    }
}
