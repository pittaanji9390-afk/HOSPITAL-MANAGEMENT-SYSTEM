package com.hospital.criticalcare.ventilation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class ArdsVentilatorDrivingPressureCalculator {

    @Data
    @AllArgsConstructor
    public static class VentilatorDrivingProfile {
        private String patientId;
        private double drivingPressureCmH2O; // Target <= 14 cmH2O
        private double staticComplianceMlPerCmH2O; // Normal 50-100 mL/cmH2O (ARDS <30)
        private double mechanicalPowerJoulesPerMin; // Target < 17 J/min
        private boolean isDrivingPressureSafe;
        private String ventilatorTitrationAdvice;
    }

    public VentilatorDrivingProfile calculateDrivingPressure(String patientId, double tidalVolumeMl, double pPlatCmH2O, double peepCmH2O, double peakPressureCmH2O, double respiratoryRate) {
        double deltaP = pPlatCmH2O - peepCmH2O;
        double cStat = deltaP > 0 ? tidalVolumeMl / deltaP : 0;
        double mechanicalPower = 0.098 * respiratoryRate * (tidalVolumeMl / 1000.0) * (peakPressureCmH2O - (deltaP / 2.0));

        boolean safe = deltaP <= 14.0;
        String advice = safe ? "Protective lung ventilation settings verified (Delta-P <= 14 cmH2O)" : "HIGH DRIVING PRESSURE ALERT: Decrease tidal volume to 4-6 mL/kg PBW or titrate PEEP";

        return new VentilatorDrivingProfile(patientId, Math.round(deltaP * 10.0) / 10.0, Math.round(cStat * 10.0) / 10.0, Math.round(mechanicalPower * 10.0) / 10.0, safe, advice);
    }
}
