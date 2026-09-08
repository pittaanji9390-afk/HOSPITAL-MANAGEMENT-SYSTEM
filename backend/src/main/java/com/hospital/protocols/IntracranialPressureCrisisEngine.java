package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class IntracranialPressureCrisisEngine {

    @Data
    @Builder
    public static class IcpCrisisDirective {
        private String patientMrn;
        private double currentIcpMmHg;
        private double cerebralPerfusionPressureCpp;
        private boolean isIcpCrisis;
        private String hyperosmolarTherapyOrder;
        private String ventilatorAndPositioningDirectives;
    }

    public IcpCrisisDirective evaluateIcpCrisis(String mrn, double icp, double map) {
        double cpp = map - icp;
        boolean crisis = icp >= 20.0 || cpp < 60.0;

        return IcpCrisisDirective.builder()
                .patientMrn(mrn)
                .currentIcpMmHg(icp)
                .cerebralPerfusionPressureCpp(Math.round(cpp * 10.0) / 10.0)
                .isIcpCrisis(crisis)
                .hyperosmolarTherapyOrder(crisis ? "Administer 3% Hypertonic Saline 250 mL IV bolus over 15 min OR 20% Mannitol 1 g/kg IV bolus. Maintain Serum Sodium 145-155 mEq/L and Serum Osmolality < 320 mOsm/kg." : "Maintain baseline neuro-monitoring.")
                .ventilatorAndPositioningDirectives("Head of bed elevated 30 degrees; keep neck in neutral midline position; brief mild hyperventilation to PaCO2 30-35 mmHg only as temporizing bridge.")
                .build();
    }
}
