package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PediatricStatusEpilepticusEngine {

    @Data
    @Builder
    public static class SeizureRescueOrder {
        private String patientMrn;
        private double weightKg;
        private int seizureDurationMinutes;
        private String firstTierRescueBenzodiazepine;
        private String secondTierAntiepileptic;
        private String rapidSequenceIntubationReadiness;
    }

    public SeizureRescueOrder calculateSeizureOrders(String mrn, double weightKg, int durationMinutes) {
        double midazolamDose = Math.min(10.0, weightKg * 0.20);
        double levetiracetamDose = Math.min(4500.0, weightKg * 60.0);

        return SeizureRescueOrder.builder()
                .patientMrn(mrn)
                .weightKg(weightKg)
                .seizureDurationMinutes(durationMinutes)
                .firstTierRescueBenzodiazepine("Midazolam " + String.format("%.1f", midazolamDose) + " mg Intranasal/Buccal/IM (or Lorazepam " + String.format("%.1f", weightKg * 0.1) + " mg IV). Repeat once at 5 min if seizure continues.")
                .secondTierAntiepileptic("Levetiracetam (Keppra) " + String.format("%.0f", levetiracetamDose) + " mg IV over 10 min OR Fosphenytoin 20 mg PE/kg IV.")
                .rapidSequenceIntubationReadiness(durationMinutes >= 20 ? "REFRACTORY STATUS EPILEPTICUS: Prepare RSI with Propofol/Ketamine. Transfer to PICU." : "Maintain continuous airway and pulse oximetry monitoring.")
                .build();
    }
}
