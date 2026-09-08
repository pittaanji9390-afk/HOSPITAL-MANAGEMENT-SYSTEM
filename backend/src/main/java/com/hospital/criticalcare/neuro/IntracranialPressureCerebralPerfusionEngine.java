package com.hospital.criticalcare.neuro;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class IntracranialPressureCerebralPerfusionEngine {

    @Data
    @AllArgsConstructor
    public static class NeuroIcuProfile {
        private String patientId;
        private double icpMmHg; // Normal <20 mmHg
        private double mapMmHg;
        private double cppMmHg; // CPP = MAP - ICP (Target 60 - 70 mmHg)
        private boolean isIcpElevated;
        private boolean isCppAdequate;
        private String tieredInterventionRecommendation;
    }

    public NeuroIcuProfile evaluateNeuro(String patientId, double icp, double map) {
        double cpp = map - icp;
        boolean icpHigh = icp >= 20.0;
        boolean cppOk = cpp >= 60.0 && cpp <= 70.0;

        String rec;
        if (icp >= 25.0) {
            rec = "Tier 2 Neuro-ICU Crisis: Administer 23.4% Hypertonic Saline 30mL IV bolus + EVD CSF drainage";
        } else if (icpHigh) {
            rec = "Tier 1: Optimize head of bed 30-deg midline, target normothermia, titrate sedation";
        } else {
            rec = "ICP and CPP within target neuroprotection goals";
        }

        return new NeuroIcuProfile(patientId, icp, map, Math.round(cpp * 10.0) / 10.0, icpHigh, cppOk, rec);
    }
}
