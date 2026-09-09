package com.hospital.clinical.diagnostics;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Diagnostic Directory for EndocrineThyroidHormonePanel.
 * Standardizes reference ranges, panic value alert thresholds, and differential interpretation.
 */
@Component
public class EndocrineThyroidHormonePanelEngine {

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
        addTestEntry("EndocrineThyroidHormonePanel-TEST-1", "EndocrineThyroidHormonePanel Diagnostic Assay #1",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-2", "EndocrineThyroidHormonePanel Diagnostic Assay #2",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-3", "EndocrineThyroidHormonePanel Diagnostic Assay #3",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-4", "EndocrineThyroidHormonePanel Diagnostic Assay #4",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-5", "EndocrineThyroidHormonePanel Diagnostic Assay #5",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-6", "EndocrineThyroidHormonePanel Diagnostic Assay #6",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-7", "EndocrineThyroidHormonePanel Diagnostic Assay #7",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-8", "EndocrineThyroidHormonePanel Diagnostic Assay #8",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-9", "EndocrineThyroidHormonePanel Diagnostic Assay #9",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-10", "EndocrineThyroidHormonePanel Diagnostic Assay #10",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-11", "EndocrineThyroidHormonePanel Diagnostic Assay #11",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-12", "EndocrineThyroidHormonePanel Diagnostic Assay #12",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-13", "EndocrineThyroidHormonePanel Diagnostic Assay #13",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-14", "EndocrineThyroidHormonePanel Diagnostic Assay #14",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-15", "EndocrineThyroidHormonePanel Diagnostic Assay #15",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-16", "EndocrineThyroidHormonePanel Diagnostic Assay #16",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-17", "EndocrineThyroidHormonePanel Diagnostic Assay #17",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-18", "EndocrineThyroidHormonePanel Diagnostic Assay #18",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-19", "EndocrineThyroidHormonePanel Diagnostic Assay #19",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-20", "EndocrineThyroidHormonePanel Diagnostic Assay #20",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-21", "EndocrineThyroidHormonePanel Diagnostic Assay #21",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-22", "EndocrineThyroidHormonePanel Diagnostic Assay #22",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-23", "EndocrineThyroidHormonePanel Diagnostic Assay #23",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-24", "EndocrineThyroidHormonePanel Diagnostic Assay #24",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("EndocrineThyroidHormonePanel-TEST-25", "EndocrineThyroidHormonePanel Diagnostic Assay #25",
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
