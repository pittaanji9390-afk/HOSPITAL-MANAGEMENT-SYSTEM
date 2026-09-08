package com.hospital.nucmed.ra223;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Radium-223 Dichloride (Xofigo) Targeted Alpha-Particle Radiotherapy Engine (ALSYMPCA Trial).
 * Calcium-mimetic targeted bone metastases alpha-emitter for mCRPC with symptomatic bone metastases and no visceral metastases.
 * Dose: 55 kBq (1.49 uCi) per kg body weight IV Q4W x 6 cycles.
 */
@Service
public class Radium223TherapyService {

    public record Ra223Prescription(double patientWeightKg, int cycleNumber, double ancCountMm3, double plateletCountMm3, double hemoglobinGDl, boolean visceralMetastasesPresent) {}
    public record Ra223Clearance(boolean approvedForAdministration, double administeredActivityKbq, String hematologicGuidance) {}

    public Ra223Clearance evaluateAdministration(Ra223Prescription p) {
        if (p.visceralMetastasesPresent()) {
            return new Ra223Clearance(false, 0.0, "CONTRAINDICATED: Radium-223 is not approved in the presence of visceral (liver/lung) metastases.");
        }

        boolean hematologyOk = (p.ancCountMm3() >= 1500.0 && p.plateletCountMm3() >= 100000.0 && p.hemoglobinGDl() >= 10.0);
        if (!hematologyOk) {
            return new Ra223Clearance(false, 0.0, "CYCLE HELD: Hematologic parameters below safety thresholds (ANC >= 1.5k, Plt >= 100k, Hb >= 10.0 g/dL).");
        }

        double activityKbq = p.patientWeightKg() * 55.0; // 55 kBq/kg
        return new Ra223Clearance(true, activityKbq, "APPROVED: Dispense " + String.format("%.0f", activityKbq) + " kBq Radium-223 IV slow push over 1 minute.");
    }
}
