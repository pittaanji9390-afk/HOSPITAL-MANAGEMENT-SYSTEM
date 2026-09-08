package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CoagulopathyMajorComorbiditiesKnowledgeCatalog {

    public enum ComplexityTier {
        STANDARD_CC,
        MAJOR_MCC
    }

    @Data
    @AllArgsConstructor
    public static class ComorbidityEntry {
        private String comorbidityCode;
        private String clinicalDescription;
        private String drgWeightTier;
        private ComplexityTier complexity;
        private double relativeCaseMixIndexWeight;
    }

    private final Map<String, ComorbidityEntry> catalog = new LinkedHashMap<>();

    public CoagulopathyMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-COAG-001", new ComorbidityEntry("MCC-COAG-001", "CoagulopathyMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-COAG-002", new ComorbidityEntry("MCC-COAG-002", "CoagulopathyMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-COAG-003", new ComorbidityEntry("MCC-COAG-003", "CoagulopathyMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-COAG-004", new ComorbidityEntry("MCC-COAG-004", "CoagulopathyMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-COAG-005", new ComorbidityEntry("MCC-COAG-005", "CoagulopathyMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-COAG-006", new ComorbidityEntry("MCC-COAG-006", "CoagulopathyMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-COAG-007", new ComorbidityEntry("MCC-COAG-007", "CoagulopathyMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-COAG-008", new ComorbidityEntry("MCC-COAG-008", "CoagulopathyMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-COAG-009", new ComorbidityEntry("MCC-COAG-009", "CoagulopathyMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-COAG-010", new ComorbidityEntry("MCC-COAG-010", "CoagulopathyMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-COAG-011", new ComorbidityEntry("MCC-COAG-011", "CoagulopathyMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-COAG-012", new ComorbidityEntry("MCC-COAG-012", "CoagulopathyMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-COAG-013", new ComorbidityEntry("MCC-COAG-013", "CoagulopathyMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-COAG-014", new ComorbidityEntry("MCC-COAG-014", "CoagulopathyMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-COAG-015", new ComorbidityEntry("MCC-COAG-015", "CoagulopathyMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-COAG-016", new ComorbidityEntry("MCC-COAG-016", "CoagulopathyMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-COAG-017", new ComorbidityEntry("MCC-COAG-017", "CoagulopathyMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-COAG-018", new ComorbidityEntry("MCC-COAG-018", "CoagulopathyMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-COAG-019", new ComorbidityEntry("MCC-COAG-019", "CoagulopathyMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-COAG-020", new ComorbidityEntry("MCC-COAG-020", "CoagulopathyMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-COAG-021", new ComorbidityEntry("MCC-COAG-021", "CoagulopathyMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-COAG-022", new ComorbidityEntry("MCC-COAG-022", "CoagulopathyMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-COAG-023", new ComorbidityEntry("MCC-COAG-023", "CoagulopathyMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-COAG-024", new ComorbidityEntry("MCC-COAG-024", "CoagulopathyMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-COAG-025", new ComorbidityEntry("MCC-COAG-025", "CoagulopathyMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-COAG-026", new ComorbidityEntry("MCC-COAG-026", "CoagulopathyMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-COAG-027", new ComorbidityEntry("MCC-COAG-027", "CoagulopathyMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-COAG-028", new ComorbidityEntry("MCC-COAG-028", "CoagulopathyMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-COAG-029", new ComorbidityEntry("MCC-COAG-029", "CoagulopathyMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-COAG-030", new ComorbidityEntry("MCC-COAG-030", "CoagulopathyMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-COAG-031", new ComorbidityEntry("MCC-COAG-031", "CoagulopathyMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-COAG-032", new ComorbidityEntry("MCC-COAG-032", "CoagulopathyMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-COAG-033", new ComorbidityEntry("MCC-COAG-033", "CoagulopathyMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-COAG-034", new ComorbidityEntry("MCC-COAG-034", "CoagulopathyMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-COAG-035", new ComorbidityEntry("MCC-COAG-035", "CoagulopathyMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-COAG-036", new ComorbidityEntry("MCC-COAG-036", "CoagulopathyMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-COAG-037", new ComorbidityEntry("MCC-COAG-037", "CoagulopathyMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-COAG-038", new ComorbidityEntry("MCC-COAG-038", "CoagulopathyMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-COAG-039", new ComorbidityEntry("MCC-COAG-039", "CoagulopathyMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-COAG-040", new ComorbidityEntry("MCC-COAG-040", "CoagulopathyMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-COAG-041", new ComorbidityEntry("MCC-COAG-041", "CoagulopathyMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-COAG-042", new ComorbidityEntry("MCC-COAG-042", "CoagulopathyMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-COAG-043", new ComorbidityEntry("MCC-COAG-043", "CoagulopathyMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-COAG-044", new ComorbidityEntry("MCC-COAG-044", "CoagulopathyMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-COAG-045", new ComorbidityEntry("MCC-COAG-045", "CoagulopathyMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-COAG-046", new ComorbidityEntry("MCC-COAG-046", "CoagulopathyMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-COAG-047", new ComorbidityEntry("MCC-COAG-047", "CoagulopathyMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-COAG-048", new ComorbidityEntry("MCC-COAG-048", "CoagulopathyMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-COAG-049", new ComorbidityEntry("MCC-COAG-049", "CoagulopathyMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-COAG-050", new ComorbidityEntry("MCC-COAG-050", "CoagulopathyMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-COAG-051", new ComorbidityEntry("MCC-COAG-051", "CoagulopathyMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-COAG-052", new ComorbidityEntry("MCC-COAG-052", "CoagulopathyMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-COAG-053", new ComorbidityEntry("MCC-COAG-053", "CoagulopathyMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-COAG-054", new ComorbidityEntry("MCC-COAG-054", "CoagulopathyMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-COAG-055", new ComorbidityEntry("MCC-COAG-055", "CoagulopathyMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-COAG-056", new ComorbidityEntry("MCC-COAG-056", "CoagulopathyMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-COAG-057", new ComorbidityEntry("MCC-COAG-057", "CoagulopathyMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-COAG-058", new ComorbidityEntry("MCC-COAG-058", "CoagulopathyMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-COAG-059", new ComorbidityEntry("MCC-COAG-059", "CoagulopathyMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-COAG-060", new ComorbidityEntry("MCC-COAG-060", "CoagulopathyMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-COAG-061", new ComorbidityEntry("MCC-COAG-061", "CoagulopathyMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-COAG-062", new ComorbidityEntry("MCC-COAG-062", "CoagulopathyMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-COAG-063", new ComorbidityEntry("MCC-COAG-063", "CoagulopathyMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-COAG-064", new ComorbidityEntry("MCC-COAG-064", "CoagulopathyMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-COAG-065", new ComorbidityEntry("MCC-COAG-065", "CoagulopathyMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-COAG-066", new ComorbidityEntry("MCC-COAG-066", "CoagulopathyMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-COAG-067", new ComorbidityEntry("MCC-COAG-067", "CoagulopathyMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-COAG-068", new ComorbidityEntry("MCC-COAG-068", "CoagulopathyMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-COAG-069", new ComorbidityEntry("MCC-COAG-069", "CoagulopathyMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-COAG-070", new ComorbidityEntry("MCC-COAG-070", "CoagulopathyMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-COAG-071", new ComorbidityEntry("MCC-COAG-071", "CoagulopathyMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-COAG-072", new ComorbidityEntry("MCC-COAG-072", "CoagulopathyMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-COAG-073", new ComorbidityEntry("MCC-COAG-073", "CoagulopathyMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-COAG-074", new ComorbidityEntry("MCC-COAG-074", "CoagulopathyMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-COAG-075", new ComorbidityEntry("MCC-COAG-075", "CoagulopathyMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-COAG-076", new ComorbidityEntry("MCC-COAG-076", "CoagulopathyMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-COAG-077", new ComorbidityEntry("MCC-COAG-077", "CoagulopathyMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-COAG-078", new ComorbidityEntry("MCC-COAG-078", "CoagulopathyMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-COAG-079", new ComorbidityEntry("MCC-COAG-079", "CoagulopathyMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-COAG-080", new ComorbidityEntry("MCC-COAG-080", "CoagulopathyMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-COAG-081", new ComorbidityEntry("MCC-COAG-081", "CoagulopathyMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-COAG-082", new ComorbidityEntry("MCC-COAG-082", "CoagulopathyMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-COAG-083", new ComorbidityEntry("MCC-COAG-083", "CoagulopathyMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-COAG-084", new ComorbidityEntry("MCC-COAG-084", "CoagulopathyMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-COAG-085", new ComorbidityEntry("MCC-COAG-085", "CoagulopathyMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-COAG-086", new ComorbidityEntry("MCC-COAG-086", "CoagulopathyMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-COAG-087", new ComorbidityEntry("MCC-COAG-087", "CoagulopathyMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-COAG-088", new ComorbidityEntry("MCC-COAG-088", "CoagulopathyMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-COAG-089", new ComorbidityEntry("MCC-COAG-089", "CoagulopathyMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-COAG-090", new ComorbidityEntry("MCC-COAG-090", "CoagulopathyMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-COAG-091", new ComorbidityEntry("MCC-COAG-091", "CoagulopathyMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-COAG-092", new ComorbidityEntry("MCC-COAG-092", "CoagulopathyMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-COAG-093", new ComorbidityEntry("MCC-COAG-093", "CoagulopathyMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-COAG-094", new ComorbidityEntry("MCC-COAG-094", "CoagulopathyMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-COAG-095", new ComorbidityEntry("MCC-COAG-095", "CoagulopathyMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-COAG-096", new ComorbidityEntry("MCC-COAG-096", "CoagulopathyMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-COAG-097", new ComorbidityEntry("MCC-COAG-097", "CoagulopathyMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-COAG-098", new ComorbidityEntry("MCC-COAG-098", "CoagulopathyMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-COAG-099", new ComorbidityEntry("MCC-COAG-099", "CoagulopathyMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-COAG-100", new ComorbidityEntry("MCC-COAG-100", "CoagulopathyMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-COAG-101", new ComorbidityEntry("MCC-COAG-101", "CoagulopathyMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-COAG-102", new ComorbidityEntry("MCC-COAG-102", "CoagulopathyMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-COAG-103", new ComorbidityEntry("MCC-COAG-103", "CoagulopathyMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-COAG-104", new ComorbidityEntry("MCC-COAG-104", "CoagulopathyMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-COAG-105", new ComorbidityEntry("MCC-COAG-105", "CoagulopathyMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-COAG-106", new ComorbidityEntry("MCC-COAG-106", "CoagulopathyMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-COAG-107", new ComorbidityEntry("MCC-COAG-107", "CoagulopathyMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-COAG-108", new ComorbidityEntry("MCC-COAG-108", "CoagulopathyMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-COAG-109", new ComorbidityEntry("MCC-COAG-109", "CoagulopathyMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-COAG-110", new ComorbidityEntry("MCC-COAG-110", "CoagulopathyMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-COAG-111", new ComorbidityEntry("MCC-COAG-111", "CoagulopathyMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-COAG-112", new ComorbidityEntry("MCC-COAG-112", "CoagulopathyMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-COAG-113", new ComorbidityEntry("MCC-COAG-113", "CoagulopathyMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-COAG-114", new ComorbidityEntry("MCC-COAG-114", "CoagulopathyMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-COAG-115", new ComorbidityEntry("MCC-COAG-115", "CoagulopathyMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-COAG-116", new ComorbidityEntry("MCC-COAG-116", "CoagulopathyMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-COAG-117", new ComorbidityEntry("MCC-COAG-117", "CoagulopathyMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-COAG-118", new ComorbidityEntry("MCC-COAG-118", "CoagulopathyMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-COAG-119", new ComorbidityEntry("MCC-COAG-119", "CoagulopathyMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-COAG-120", new ComorbidityEntry("MCC-COAG-120", "CoagulopathyMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-COAG-121", new ComorbidityEntry("MCC-COAG-121", "CoagulopathyMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-COAG-122", new ComorbidityEntry("MCC-COAG-122", "CoagulopathyMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-COAG-123", new ComorbidityEntry("MCC-COAG-123", "CoagulopathyMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-COAG-124", new ComorbidityEntry("MCC-COAG-124", "CoagulopathyMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-COAG-125", new ComorbidityEntry("MCC-COAG-125", "CoagulopathyMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-COAG-126", new ComorbidityEntry("MCC-COAG-126", "CoagulopathyMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-COAG-127", new ComorbidityEntry("MCC-COAG-127", "CoagulopathyMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-COAG-128", new ComorbidityEntry("MCC-COAG-128", "CoagulopathyMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-COAG-129", new ComorbidityEntry("MCC-COAG-129", "CoagulopathyMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-COAG-130", new ComorbidityEntry("MCC-COAG-130", "CoagulopathyMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-COAG-131", new ComorbidityEntry("MCC-COAG-131", "CoagulopathyMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-COAG-132", new ComorbidityEntry("MCC-COAG-132", "CoagulopathyMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-COAG-133", new ComorbidityEntry("MCC-COAG-133", "CoagulopathyMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-COAG-134", new ComorbidityEntry("MCC-COAG-134", "CoagulopathyMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-COAG-135", new ComorbidityEntry("MCC-COAG-135", "CoagulopathyMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-COAG-136", new ComorbidityEntry("MCC-COAG-136", "CoagulopathyMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-COAG-137", new ComorbidityEntry("MCC-COAG-137", "CoagulopathyMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-COAG-138", new ComorbidityEntry("MCC-COAG-138", "CoagulopathyMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-COAG-139", new ComorbidityEntry("MCC-COAG-139", "CoagulopathyMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-COAG-140", new ComorbidityEntry("MCC-COAG-140", "CoagulopathyMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-COAG-141", new ComorbidityEntry("MCC-COAG-141", "CoagulopathyMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-COAG-142", new ComorbidityEntry("MCC-COAG-142", "CoagulopathyMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-COAG-143", new ComorbidityEntry("MCC-COAG-143", "CoagulopathyMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-COAG-144", new ComorbidityEntry("MCC-COAG-144", "CoagulopathyMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-COAG-145", new ComorbidityEntry("MCC-COAG-145", "CoagulopathyMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-COAG-146", new ComorbidityEntry("MCC-COAG-146", "CoagulopathyMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-COAG-147", new ComorbidityEntry("MCC-COAG-147", "CoagulopathyMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-COAG-148", new ComorbidityEntry("MCC-COAG-148", "CoagulopathyMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-COAG-149", new ComorbidityEntry("MCC-COAG-149", "CoagulopathyMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-COAG-150", new ComorbidityEntry("MCC-COAG-150", "CoagulopathyMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
