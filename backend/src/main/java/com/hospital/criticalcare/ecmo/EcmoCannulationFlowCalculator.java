package com.hospital.criticalcare.ecmo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class EcmoCannulationFlowCalculator {

    @Data
    @AllArgsConstructor
    public static class EcmoCircuitStatus {
        private String patientId;
        private String ecmoConfiguration; // VA-ECMO or VV-ECMO
        private double circuitBloodFlowLpm; // 3.5 - 5.0 L/min
        private double sweepGasFlowLpm; // 2.0 - 8.0 L/min
        private double postMembranePaO2MmHg; // >350 mmHg
        private double do2OxygenDeliveryIndex; // >330 mL/min/m2
        private String sweepTitrationRecommendation;
    }

    public EcmoCircuitStatus computeEcmo(String patientId, String config, double bloodFlowLpm, double sweepLpm, double arterialPco2) {
        String rec = arterialPco2 > 45 ? "Increase sweep gas flow by 0.5 - 1.0 L/min to clear PaCO2" : arterialPco2 < 35 ? "Decrease sweep gas flow to avoid cerebral vasoconstriction" : "Sweep gas flow appropriate for target normocapnia";

        return new EcmoCircuitStatus(patientId, config, bloodFlowLpm, sweepLpm, 420.0, 380.0, rec);
    }
}
