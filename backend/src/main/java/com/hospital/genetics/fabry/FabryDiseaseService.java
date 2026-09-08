package com.hospital.genetics.fabry;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Fabry Disease (X-Linked Lysosomal Storage Disorder) Engine.
 * Evaluates Alpha-Galactosidase A (Alpha-Gal A) enzyme activity, plasma lyso-Gb3 biomarker,
 * and classifies GLA gene missense mutations for oral pharmacological chaperone (Migalastat / Galafold) amenability vs ERT (Agalsidase beta).
 */
@Service
public class FabryDiseaseService {

    public record FabryProfile(String glaMutation, double alphaGalEnzymeActivityNmolHrMg, double plasmaLysoGb3NmolL, boolean isMale) {}
    public record FabryTreatmentPlan(boolean confirmedFabryDisease, boolean isAmenableToMigalastat, String recommendedTherapy) {}

    public FabryTreatmentPlan evaluateFabry(FabryProfile p) {
        boolean confirmed = (p.isMale() && p.alphaGalEnzymeActivityNmolHrMg() < 1.0) || p.plasmaLysoGb3NmolL() > 3.0;
        boolean amenable = p.glaMutation().toUpperCase().contains("R301Q") || p.glaMutation().toUpperCase().contains("N215S");

        String therapy;
        if (!confirmed) {
            therapy = "Normal Enzyme Activity / Inconclusive lyso-Gb3.";
        } else if (amenable) {
            therapy = "Oral Pharmacological Chaperone: Migalastat 123mg PO every other day.";
        } else {
            therapy = "Enzyme Replacement Therapy (ERT): Agalsidase beta (Fabrazyme) 1.0 mg/kg IV every 2 weeks.";
        }

        return new FabryTreatmentPlan(confirmed, amenable, therapy);
    }
}
