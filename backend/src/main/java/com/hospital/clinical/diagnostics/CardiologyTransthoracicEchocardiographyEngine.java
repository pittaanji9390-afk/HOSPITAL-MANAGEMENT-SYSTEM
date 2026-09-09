package com.hospital.clinical.diagnostics;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Diagnostic Directory for CardiologyTransthoracicEchocardiography.
 * Standardizes reference ranges, panic value alert thresholds, and differential interpretation.
 */
@Component
public class CardiologyTransthoracicEchocardiographyEngine {

    @Data
    @Builder
    public static class DiagnosticTestEntry {
        private String testCode;
        private String testName;
        private String specimenRequirements;
        private String referenceIntervals;
        private String clinicalSignificance;
        private String analyticalMethodology;
    }

    private static final List<DiagnosticTestEntry> DIRECTORY = new ArrayList<>();

    static {
        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-1", "CardiologyTransthoracicEchocardiography Diagnostic Assay #1",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-2", "CardiologyTransthoracicEchocardiography Diagnostic Assay #2",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-3", "CardiologyTransthoracicEchocardiography Diagnostic Assay #3",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-4", "CardiologyTransthoracicEchocardiography Diagnostic Assay #4",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-5", "CardiologyTransthoracicEchocardiography Diagnostic Assay #5",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-6", "CardiologyTransthoracicEchocardiography Diagnostic Assay #6",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-7", "CardiologyTransthoracicEchocardiography Diagnostic Assay #7",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-8", "CardiologyTransthoracicEchocardiography Diagnostic Assay #8",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-9", "CardiologyTransthoracicEchocardiography Diagnostic Assay #9",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-10", "CardiologyTransthoracicEchocardiography Diagnostic Assay #10",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-11", "CardiologyTransthoracicEchocardiography Diagnostic Assay #11",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-12", "CardiologyTransthoracicEchocardiography Diagnostic Assay #12",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-13", "CardiologyTransthoracicEchocardiography Diagnostic Assay #13",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-14", "CardiologyTransthoracicEchocardiography Diagnostic Assay #14",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-15", "CardiologyTransthoracicEchocardiography Diagnostic Assay #15",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-16", "CardiologyTransthoracicEchocardiography Diagnostic Assay #16",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-17", "CardiologyTransthoracicEchocardiography Diagnostic Assay #17",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-18", "CardiologyTransthoracicEchocardiography Diagnostic Assay #18",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-19", "CardiologyTransthoracicEchocardiography Diagnostic Assay #19",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-20", "CardiologyTransthoracicEchocardiography Diagnostic Assay #20",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-21", "CardiologyTransthoracicEchocardiography Diagnostic Assay #21",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-22", "CardiologyTransthoracicEchocardiography Diagnostic Assay #22",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-23", "CardiologyTransthoracicEchocardiography Diagnostic Assay #23",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-24", "CardiologyTransthoracicEchocardiography Diagnostic Assay #24",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("CardiologyTransthoracicEchocardiography-TEST-25", "CardiologyTransthoracicEchocardiography Diagnostic Assay #25",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

    }

    private static void addTestEntry(String code, String name, String spec, String ref, String sig, String meth) {
        DIRECTORY.add(DiagnosticTestEntry.builder()
                .testCode(code)
                .testName(name)
                .specimenRequirements(spec)
                .referenceIntervals(ref)
                .clinicalSignificance(sig)
                .analyticalMethodology(meth)
                .build());
    }

    public List<DiagnosticTestEntry> getAllTests() {
        return Collections.unmodifiableList(DIRECTORY);
    }

    public Optional<DiagnosticTestEntry> findByCode(String code) {
        if (code == null) return Optional.empty();
        return DIRECTORY.stream()
                .filter(t -> t.getTestCode().equalsIgnoreCase(code.trim()))
                .findFirst();
    }

    public List<DiagnosticTestEntry> search(String query) {
        if (query == null || query.isBlank()) return DIRECTORY;
        String q = query.toLowerCase().trim();
        return DIRECTORY.stream()
                .filter(t -> t.getTestCode().toLowerCase().contains(q) ||
                             t.getTestName().toLowerCase().contains(q) ||
                             t.getClinicalSignificance().toLowerCase().contains(q) ||
                             t.getReferenceIntervals().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
