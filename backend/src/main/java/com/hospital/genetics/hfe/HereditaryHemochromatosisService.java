package com.hospital.genetics.hfe;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Hereditary Hemochromatosis (HH) HFE Gene Mutation Classifier (AASLD Guidelines).
 * - C282Y Homozygote (C282Y/C282Y): Highest risk for progressive iron overload, hepatic cirrhosis, and bronze diabetes.
 * - Compound Heterozygote (C282Y/H63D): Moderate risk for phenotypic iron overload.
 * - H63D Homozygote (H63D/H63D): Low clinical penetrance.
 */
@Service
public class HereditaryHemochromatosisService {

    public record HfeAssessment(String genotype, double transferrinSaturationPercent, double serumFerritinNgMl, boolean therapeuticPhlebotomyIndicated, String phlebotomySchedule) {}

    public HfeAssessment evaluate(String allele1, String allele2, double transferrinSat, double ferritin) {
        String genotype = allele1.toUpperCase() + " / " + allele2.toUpperCase();
        boolean isC282yHomozygote = genotype.contains("C282Y") && !genotype.contains("WT") && !genotype.contains("H63D");
        boolean isCompoundHet = genotype.contains("C282Y") && genotype.contains("H63D");

        boolean phlebotomy = (transferrinSat > 45.0 && ferritin > 300.0) || (isC282yHomozygote && ferritin > 200.0);
        String schedule = phlebotomy ? "Induction: 500 mL therapeutic phlebotomy weekly until ferritin 50-100 ng/mL, then maintenance Q2-4 months." : "Monitor annual iron panel (Ferritin + Transferrin Saturation).";

        return new HfeAssessment(genotype, transferrinSat, ferritin, phlebotomy, schedule);
    }
}
