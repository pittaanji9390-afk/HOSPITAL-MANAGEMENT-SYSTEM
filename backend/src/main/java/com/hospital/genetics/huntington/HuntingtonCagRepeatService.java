package com.hospital.genetics.huntington;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Huntington Disease (HD) HTT Exon 1 CAG Trinucleotide Repeat Classifier (ACMG Guidelines):
 * - Normal: <= 26 CAG repeats (No disease, stable).
 * - Intermediate: 27 - 35 CAG repeats (No disease in individual, risk of paternal expansion in offspring).
 * - Reduced Penetrance: 36 - 39 CAG repeats (May or may not develop HD symptoms late in life).
 * - Full Penetrance: >= 40 CAG repeats (100% lifetime penetrance; >= 60 indicates Juvenile HD).
 */
@Service
public class HuntingtonCagRepeatService {

    public enum HdPenetranceClass { NORMAL_ALLELE, INTERMEDIATE_PREMUTATION, REDUCED_PENETRANCE, FULL_PENETRANCE_ADULT, JUVENILE_HUNTINGTON_ONSET }
    public record HdResult(int allele1Repeats, int allele2Repeats, int higherAllele, HdPenetranceClass penetrance, String geneticCounselingSummary) {}

    public HdResult evaluateCagRepeats(int a1, int a2) {
        int higher = Math.max(a1, a2);
        HdPenetranceClass penetrance;
        String summary;

        if (higher >= 60) {
            penetrance = HdPenetranceClass.JUVENILE_HUNTINGTON_ONSET;
            summary = "Full Penetrance Juvenile Onset HD: Extensive CAG expansion. Manifests with parkinsonism, dystonia, and rapid cognitive decline.";
        } else if (higher >= 40) {
            penetrance = HdPenetranceClass.FULL_PENETRANCE_ADULT;
            summary = "Full Penetrance HD: 100% lifetime risk of chorea, psychiatric manifestations, and progressive neurodegeneration.";
        } else if (higher >= 36) {
            penetrance = HdPenetranceClass.REDUCED_PENETRANCE;
            summary = "Reduced Penetrance HD: Individual may develop symptoms late in life or remain asymptomatic. Offspring at 50% inheritance risk.";
        } else if (higher >= 27) {
            penetrance = HdPenetranceClass.INTERMEDIATE_PREMUTATION;
            summary = "Intermediate Allele: Non-penetrant in patient, but meiotically unstable with potential expansion to full penetrance during spermatogenesis.";
        } else {
            penetrance = HdPenetranceClass.NORMAL_ALLELE;
            summary = "Normal Range: Negative for Huntington disease CAG repeat expansion.";
        }

        return new HdResult(a1, a2, higher, penetrance, summary);
    }
}
