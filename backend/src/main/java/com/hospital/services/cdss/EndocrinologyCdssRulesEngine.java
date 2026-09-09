package com.hospital.services.cdss;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class EndocrinologyCdssRulesEngine {

    @Data
    @Builder
    public static class DkaTitrationOrder {
        private String patientMrn;
        private double anionGap;
        private double calculatedEffectiveSerumOsmolality;
        private double regularInsulinInfusionUnitsPerHr;
        private String ivFluidsRegimen;
        private String potassiumReplacementDirective;
    }

    public DkaTitrationOrder calculateDkaOrders(String mrn, double sodium, double potassium, double chloride, double bicarbonate, double glucoseMgDl, double weightKg) {
        double anionGap = sodium - (chloride + bicarbonate);
        double effOsm = 2.0 * sodium + (glucoseMgDl / 18.0);

        double insulinRate = weightKg * 0.10; // 0.1 U/kg/hr
        String fluids = glucoseMgDl <= 250.0 ? "D5W with 0.45% NaCl at 150-250 mL/hr to prevent hypoglycemia while closing anion gap." : "0.9% Normal Saline at 500-1000 mL/hr for initial 2-4 hours.";

        String kOrder;
        if (potassium < 3.3) {
            kOrder = "HOLD INSULIN INFUSION. Administer IV KCl 20-30 mEq/hr until Serum Potassium > 3.3 mEq/L.";
        } else if (potassium <= 5.2) {
            kOrder = "Add 20-30 mEq KCl per liter of IV fluid to maintain Serum K+ between 4.0 - 5.0 mEq/L.";
        } else {
            kOrder = "Serum Potassium > 5.2 mEq/L: Do not add KCl to IV fluids. Recheck Potassium Q2H.";
        }

        return DkaTitrationOrder.builder()
                .patientMrn(mrn)
                .anionGap(Math.round(anionGap * 10.0) / 10.0)
                .calculatedEffectiveSerumOsmolality(Math.round(effOsm * 10.0) / 10.0)
                .regularInsulinInfusionUnitsPerHr(Math.round(insulinRate * 10.0) / 10.0)
                .ivFluidsRegimen(fluids)
                .potassiumReplacementDirective(kOrder)
                .build();
    }
}
