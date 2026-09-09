package com.hospital.clinical.diagnostics;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Diagnostic Directory for PathologySurgicalBiopsyHistopathology.
 * Standardizes reference ranges, panic value alert thresholds, and differential interpretation.
 */
@Component
public class PathologySurgicalBiopsyHistopathologyEngine {

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
        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-1", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #1",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-2", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #2",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-3", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #3",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-4", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #4",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-5", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #5",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-6", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #6",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-7", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #7",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-8", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #8",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-9", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #9",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-10", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #10",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-11", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #11",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-12", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #12",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-13", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #13",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-14", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #14",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-15", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #15",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-16", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #16",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-17", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #17",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-18", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #18",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-19", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #19",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-20", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #20",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-21", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #21",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-22", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #22",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-23", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #23",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-24", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #24",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("PathologySurgicalBiopsyHistopathology-TEST-25", "PathologySurgicalBiopsyHistopathology Diagnostic Assay #25",
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
