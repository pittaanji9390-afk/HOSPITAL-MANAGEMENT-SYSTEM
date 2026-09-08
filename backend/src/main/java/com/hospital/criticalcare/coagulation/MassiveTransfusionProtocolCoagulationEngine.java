package com.hospital.criticalcare.coagulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class MassiveTransfusionProtocolCoagulationEngine {

    @Data
    @AllArgsConstructor
    public static class RotemHemostasisGuidance {
        private String patientId;
        private double extemCtSec; // Clotting Time (Normal 38-79s)
        private double fibtemA10Mm; // Fibrinogen Clot Amplitude (Normal >10mm)
        private double extemMlfPercent; // Maximum Lysis (Normal <15%, >15% indicates hyperfibrinolysis)
        private String indicatedBloodProduct;
    }

    public RotemHemostasisGuidance interpretRotem(String patientId, double extemCt, double fibtemA10, double extemMlf) {
        String product;
        if (extemMlf > 15.0) {
            product = "Hyperfibrinolysis Detected: Administer Tranexamic Acid (TXA) 1g IV STAT";
        } else if (fibtemA10 < 10.0) {
            product = "Hypofibrinogenemia: Transfuse Cryoprecipitate 10 Units or Fibrinogen Concentrate";
        } else if (extemCt > 80.0) {
            product = "Coagulation Factor Deficiency: Transfuse Fresh Frozen Plasma (FFP) 2-4 Units or 4-Factor PCC";
        } else {
            product = "Stable Clot Kinetics: Continue standard 1:1:1 PRBC/FFP/Platelet ratio";
        }

        return new RotemHemostasisGuidance(patientId, extemCt, fibtemA10, extemMlf, product);
    }
}
