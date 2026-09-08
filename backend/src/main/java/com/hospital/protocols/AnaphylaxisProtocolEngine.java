package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AnaphylaxisProtocolEngine {

    @Data
    @Builder
    public static class AnaphylaxisOrderDirective {
        private String patientMrn;
        private double weightKg;
        private double epinephrineDoseMg;
        private String epinephrineRoute;
        private String secondaryMedications;
        private int biphasicSurveillanceHours;
    }

    public AnaphylaxisOrderDirective calculateAnaphylaxisOrders(String mrn, double weightKg) {
        double epiDose = weightKg >= 50.0 ? 0.50 : (weightKg >= 25.0 ? 0.30 : 0.15);

        return AnaphylaxisOrderDirective.builder()
                .patientMrn(mrn)
                .weightKg(weightKg)
                .epinephrineDoseMg(epiDose)
                .epinephrineRoute("INTRAMUSCULAR (IM) in Anterolateral Mid-Thigh (Vastus Lateralis) - Repeat every 5-15 min PRN")
                .secondaryMedications("Diphenhydramine 50mg IV + Famotidine 20mg IV + Methylprednisolone 125mg IV + 1000mL Normal Saline bolus")
                .biphasicSurveillanceHours(8)
                .build();
    }
}
