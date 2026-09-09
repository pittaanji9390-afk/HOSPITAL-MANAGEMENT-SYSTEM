package com.hospital.clinical.diagnostics;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Diagnostic Directory for HematologyCompleteBloodCount.
 * Standardizes reference ranges, panic value alert thresholds, and differential interpretation.
 */
@Component
public class HematologyCompleteBloodCountEngine {

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
        addTestEntry("HematologyCompleteBloodCount-TEST-1", "HematologyCompleteBloodCount Diagnostic Assay #1",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-2", "HematologyCompleteBloodCount Diagnostic Assay #2",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-3", "HematologyCompleteBloodCount Diagnostic Assay #3",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-4", "HematologyCompleteBloodCount Diagnostic Assay #4",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-5", "HematologyCompleteBloodCount Diagnostic Assay #5",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-6", "HematologyCompleteBloodCount Diagnostic Assay #6",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-7", "HematologyCompleteBloodCount Diagnostic Assay #7",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-8", "HematologyCompleteBloodCount Diagnostic Assay #8",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-9", "HematologyCompleteBloodCount Diagnostic Assay #9",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-10", "HematologyCompleteBloodCount Diagnostic Assay #10",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-11", "HematologyCompleteBloodCount Diagnostic Assay #11",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-12", "HematologyCompleteBloodCount Diagnostic Assay #12",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-13", "HematologyCompleteBloodCount Diagnostic Assay #13",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-14", "HematologyCompleteBloodCount Diagnostic Assay #14",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-15", "HematologyCompleteBloodCount Diagnostic Assay #15",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-16", "HematologyCompleteBloodCount Diagnostic Assay #16",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-17", "HematologyCompleteBloodCount Diagnostic Assay #17",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-18", "HematologyCompleteBloodCount Diagnostic Assay #18",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-19", "HematologyCompleteBloodCount Diagnostic Assay #19",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-20", "HematologyCompleteBloodCount Diagnostic Assay #20",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-21", "HematologyCompleteBloodCount Diagnostic Assay #21",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-22", "HematologyCompleteBloodCount Diagnostic Assay #22",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-23", "HematologyCompleteBloodCount Diagnostic Assay #23",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-24", "HematologyCompleteBloodCount Diagnostic Assay #24",
            "Specimen Requirements & Collection Methodology: Standardized venous whole blood / plasma / sterile body fluid collected in appropriate preservative tube.",
            "Biological Reference Intervals: Adult male: normal reference bounds; Adult female: normal reference bounds; Critical panic value alert limits.",
            "Clinical Significance & Differential Interpretation: Pathologic elevations indicate acute tissue necrosis, malignant proliferation, or inflammatory cascade activation.",
            "Analytical Methodology & Interferences: Quantitative chemiluminescent immunoassay / automated spectrophotometry with interference screening for hemolysis, icterus, and lipemia.");

        addTestEntry("HematologyCompleteBloodCount-TEST-25", "HematologyCompleteBloodCount Diagnostic Assay #25",
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
