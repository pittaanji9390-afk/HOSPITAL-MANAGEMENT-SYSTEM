package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class OncologicEmergenciesEngine {

    @Data
    @Builder
    public static class FebrileNeutropeniaTriage {
        private String patientMrn;
        private int absoluteNeutrophilCountAnc;
        private double temperatureCelsius;
        private boolean isSevereNeutropenia;
        private String empiricAntibioticStatOrder;
        private String tumorLysisProphylaxisOrder;
    }

    public FebrileNeutropeniaTriage evaluateOncologicEmergency(String mrn, int anc, double temp, double uricAcid, double potassium, double phosphate) {
        boolean severe = anc < 500;
        boolean tls = uricAcid > 8.0 || potassium > 6.0 || phosphate > 4.5;

        return FebrileNeutropeniaTriage.builder()
                .patientMrn(mrn)
                .absoluteNeutrophilCountAnc(anc)
                .temperatureCelsius(temp)
                .isSevereNeutropenia(severe)
                .empiricAntibioticStatOrder(severe && temp >= 38.0 ? "STAT IV Cefepime 2g Q8H (or Meropenem 1g Q8H if septic shock or prior ESBL). Must be administered within 60 minutes of fever spike." : "Routine oncology surveillance.")
                .tumorLysisProphylaxisOrder(tls ? "Rasburicase 0.2 mg/kg IV single dose + aggressive IV hydration (3000 mL/m2/day) without added potassium." : "Allopurinol 300mg PO daily + IV hydration.")
                .build();
    }
}
