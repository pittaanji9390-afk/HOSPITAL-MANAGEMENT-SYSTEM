package com.hospital.criticalcare.hemodynamics;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class PiccoHemodynamicParameterCalculator {

    @Data
    @AllArgsConstructor
    public static class PiccoHemodynamicProfile {
        private String patientId;
        private double cardiacIndexCi; // 3.0 - 5.0 L/min/m2
        private double extravascularLungWaterIndexEvlwi; // 3.0 - 7.0 mL/kg (Normal <10)
        private double globalEndDiastolicVolumeIndexGedvi; // 680 - 800 mL/m2
        private double strokeVolumeVariationSvv; // <10% (Fluid responsive if >13%)
        private double pulmonaryVascularPermeabilityIndexPvpi; // 1.0 - 3.0
        private boolean isFluidResponsive;
        private boolean hasPulmonaryEdema;
        private String clinicalGuidance;
    }

    public PiccoHemodynamicProfile evaluatePicco(String patientId, double cardiacOutput, double bsa, double pbwKg, double evlwMl, double gedvMl, double svvPercent) {
        double ci = bsa > 0 ? cardiacOutput / bsa : 0;
        double evlwi = pbwKg > 0 ? evlwMl / pbwKg : 0;
        double gedvi = bsa > 0 ? gedvMl / bsa : 0;
        double pvpi = gedvMl > 0 ? (evlwMl / gedvMl) * 4.0 : 1.0;

        boolean fluidResp = svvPercent > 13.0 && gedvi < 700.0;
        boolean edema = evlwi > 10.0;

        String guidance;
        if (edema && !fluidResp) {
            guidance = "Fluid Overload / Pulmonary Edema: Restrict fluids, initiate diuretics or ultrafiltration.";
        } else if (fluidResp && !edema) {
            guidance = "Hypovolemia / Fluid Responsive: Administer 250-500mL crystalloid bolus.";
        } else {
            guidance = "Hemodynamically Optimized: Maintain current vasoactive support.";
        }

        return new PiccoHemodynamicProfile(patientId, Math.round(ci * 100.0) / 100.0, Math.round(evlwi * 10.0) / 10.0, Math.round(gedvi), svvPercent, Math.round(pvpi * 10.0) / 10.0, fluidResp, edema, guidance);
    }
}
