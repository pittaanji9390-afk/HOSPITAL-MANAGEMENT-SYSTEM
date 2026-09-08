package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SepsisInfectionMajorComorbiditiesKnowledgeCatalog {

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

    public SepsisInfectionMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-SEPS-001", new ComorbidityEntry("MCC-SEPS-001", "SepsisInfectionMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-SEPS-002", new ComorbidityEntry("MCC-SEPS-002", "SepsisInfectionMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-SEPS-003", new ComorbidityEntry("MCC-SEPS-003", "SepsisInfectionMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-SEPS-004", new ComorbidityEntry("MCC-SEPS-004", "SepsisInfectionMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-SEPS-005", new ComorbidityEntry("MCC-SEPS-005", "SepsisInfectionMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-SEPS-006", new ComorbidityEntry("MCC-SEPS-006", "SepsisInfectionMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-SEPS-007", new ComorbidityEntry("MCC-SEPS-007", "SepsisInfectionMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-SEPS-008", new ComorbidityEntry("MCC-SEPS-008", "SepsisInfectionMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-SEPS-009", new ComorbidityEntry("MCC-SEPS-009", "SepsisInfectionMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-SEPS-010", new ComorbidityEntry("MCC-SEPS-010", "SepsisInfectionMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-SEPS-011", new ComorbidityEntry("MCC-SEPS-011", "SepsisInfectionMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-SEPS-012", new ComorbidityEntry("MCC-SEPS-012", "SepsisInfectionMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-SEPS-013", new ComorbidityEntry("MCC-SEPS-013", "SepsisInfectionMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-SEPS-014", new ComorbidityEntry("MCC-SEPS-014", "SepsisInfectionMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-SEPS-015", new ComorbidityEntry("MCC-SEPS-015", "SepsisInfectionMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-SEPS-016", new ComorbidityEntry("MCC-SEPS-016", "SepsisInfectionMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-SEPS-017", new ComorbidityEntry("MCC-SEPS-017", "SepsisInfectionMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-SEPS-018", new ComorbidityEntry("MCC-SEPS-018", "SepsisInfectionMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-SEPS-019", new ComorbidityEntry("MCC-SEPS-019", "SepsisInfectionMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-SEPS-020", new ComorbidityEntry("MCC-SEPS-020", "SepsisInfectionMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-SEPS-021", new ComorbidityEntry("MCC-SEPS-021", "SepsisInfectionMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-SEPS-022", new ComorbidityEntry("MCC-SEPS-022", "SepsisInfectionMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-SEPS-023", new ComorbidityEntry("MCC-SEPS-023", "SepsisInfectionMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-SEPS-024", new ComorbidityEntry("MCC-SEPS-024", "SepsisInfectionMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-SEPS-025", new ComorbidityEntry("MCC-SEPS-025", "SepsisInfectionMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-SEPS-026", new ComorbidityEntry("MCC-SEPS-026", "SepsisInfectionMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-SEPS-027", new ComorbidityEntry("MCC-SEPS-027", "SepsisInfectionMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-SEPS-028", new ComorbidityEntry("MCC-SEPS-028", "SepsisInfectionMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-SEPS-029", new ComorbidityEntry("MCC-SEPS-029", "SepsisInfectionMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-SEPS-030", new ComorbidityEntry("MCC-SEPS-030", "SepsisInfectionMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-SEPS-031", new ComorbidityEntry("MCC-SEPS-031", "SepsisInfectionMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-SEPS-032", new ComorbidityEntry("MCC-SEPS-032", "SepsisInfectionMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-SEPS-033", new ComorbidityEntry("MCC-SEPS-033", "SepsisInfectionMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-SEPS-034", new ComorbidityEntry("MCC-SEPS-034", "SepsisInfectionMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-SEPS-035", new ComorbidityEntry("MCC-SEPS-035", "SepsisInfectionMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-SEPS-036", new ComorbidityEntry("MCC-SEPS-036", "SepsisInfectionMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-SEPS-037", new ComorbidityEntry("MCC-SEPS-037", "SepsisInfectionMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-SEPS-038", new ComorbidityEntry("MCC-SEPS-038", "SepsisInfectionMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-SEPS-039", new ComorbidityEntry("MCC-SEPS-039", "SepsisInfectionMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-SEPS-040", new ComorbidityEntry("MCC-SEPS-040", "SepsisInfectionMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-SEPS-041", new ComorbidityEntry("MCC-SEPS-041", "SepsisInfectionMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-SEPS-042", new ComorbidityEntry("MCC-SEPS-042", "SepsisInfectionMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-SEPS-043", new ComorbidityEntry("MCC-SEPS-043", "SepsisInfectionMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-SEPS-044", new ComorbidityEntry("MCC-SEPS-044", "SepsisInfectionMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-SEPS-045", new ComorbidityEntry("MCC-SEPS-045", "SepsisInfectionMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-SEPS-046", new ComorbidityEntry("MCC-SEPS-046", "SepsisInfectionMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-SEPS-047", new ComorbidityEntry("MCC-SEPS-047", "SepsisInfectionMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-SEPS-048", new ComorbidityEntry("MCC-SEPS-048", "SepsisInfectionMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-SEPS-049", new ComorbidityEntry("MCC-SEPS-049", "SepsisInfectionMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-SEPS-050", new ComorbidityEntry("MCC-SEPS-050", "SepsisInfectionMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-SEPS-051", new ComorbidityEntry("MCC-SEPS-051", "SepsisInfectionMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-SEPS-052", new ComorbidityEntry("MCC-SEPS-052", "SepsisInfectionMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-SEPS-053", new ComorbidityEntry("MCC-SEPS-053", "SepsisInfectionMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-SEPS-054", new ComorbidityEntry("MCC-SEPS-054", "SepsisInfectionMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-SEPS-055", new ComorbidityEntry("MCC-SEPS-055", "SepsisInfectionMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-SEPS-056", new ComorbidityEntry("MCC-SEPS-056", "SepsisInfectionMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-SEPS-057", new ComorbidityEntry("MCC-SEPS-057", "SepsisInfectionMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-SEPS-058", new ComorbidityEntry("MCC-SEPS-058", "SepsisInfectionMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-SEPS-059", new ComorbidityEntry("MCC-SEPS-059", "SepsisInfectionMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-SEPS-060", new ComorbidityEntry("MCC-SEPS-060", "SepsisInfectionMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-SEPS-061", new ComorbidityEntry("MCC-SEPS-061", "SepsisInfectionMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-SEPS-062", new ComorbidityEntry("MCC-SEPS-062", "SepsisInfectionMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-SEPS-063", new ComorbidityEntry("MCC-SEPS-063", "SepsisInfectionMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-SEPS-064", new ComorbidityEntry("MCC-SEPS-064", "SepsisInfectionMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-SEPS-065", new ComorbidityEntry("MCC-SEPS-065", "SepsisInfectionMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-SEPS-066", new ComorbidityEntry("MCC-SEPS-066", "SepsisInfectionMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-SEPS-067", new ComorbidityEntry("MCC-SEPS-067", "SepsisInfectionMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-SEPS-068", new ComorbidityEntry("MCC-SEPS-068", "SepsisInfectionMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-SEPS-069", new ComorbidityEntry("MCC-SEPS-069", "SepsisInfectionMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-SEPS-070", new ComorbidityEntry("MCC-SEPS-070", "SepsisInfectionMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-SEPS-071", new ComorbidityEntry("MCC-SEPS-071", "SepsisInfectionMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-SEPS-072", new ComorbidityEntry("MCC-SEPS-072", "SepsisInfectionMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-SEPS-073", new ComorbidityEntry("MCC-SEPS-073", "SepsisInfectionMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-SEPS-074", new ComorbidityEntry("MCC-SEPS-074", "SepsisInfectionMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-SEPS-075", new ComorbidityEntry("MCC-SEPS-075", "SepsisInfectionMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-SEPS-076", new ComorbidityEntry("MCC-SEPS-076", "SepsisInfectionMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-SEPS-077", new ComorbidityEntry("MCC-SEPS-077", "SepsisInfectionMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-SEPS-078", new ComorbidityEntry("MCC-SEPS-078", "SepsisInfectionMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-SEPS-079", new ComorbidityEntry("MCC-SEPS-079", "SepsisInfectionMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-SEPS-080", new ComorbidityEntry("MCC-SEPS-080", "SepsisInfectionMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-SEPS-081", new ComorbidityEntry("MCC-SEPS-081", "SepsisInfectionMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-SEPS-082", new ComorbidityEntry("MCC-SEPS-082", "SepsisInfectionMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-SEPS-083", new ComorbidityEntry("MCC-SEPS-083", "SepsisInfectionMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-SEPS-084", new ComorbidityEntry("MCC-SEPS-084", "SepsisInfectionMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-SEPS-085", new ComorbidityEntry("MCC-SEPS-085", "SepsisInfectionMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-SEPS-086", new ComorbidityEntry("MCC-SEPS-086", "SepsisInfectionMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-SEPS-087", new ComorbidityEntry("MCC-SEPS-087", "SepsisInfectionMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-SEPS-088", new ComorbidityEntry("MCC-SEPS-088", "SepsisInfectionMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-SEPS-089", new ComorbidityEntry("MCC-SEPS-089", "SepsisInfectionMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-SEPS-090", new ComorbidityEntry("MCC-SEPS-090", "SepsisInfectionMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-SEPS-091", new ComorbidityEntry("MCC-SEPS-091", "SepsisInfectionMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-SEPS-092", new ComorbidityEntry("MCC-SEPS-092", "SepsisInfectionMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-SEPS-093", new ComorbidityEntry("MCC-SEPS-093", "SepsisInfectionMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-SEPS-094", new ComorbidityEntry("MCC-SEPS-094", "SepsisInfectionMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-SEPS-095", new ComorbidityEntry("MCC-SEPS-095", "SepsisInfectionMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-SEPS-096", new ComorbidityEntry("MCC-SEPS-096", "SepsisInfectionMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-SEPS-097", new ComorbidityEntry("MCC-SEPS-097", "SepsisInfectionMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-SEPS-098", new ComorbidityEntry("MCC-SEPS-098", "SepsisInfectionMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-SEPS-099", new ComorbidityEntry("MCC-SEPS-099", "SepsisInfectionMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-SEPS-100", new ComorbidityEntry("MCC-SEPS-100", "SepsisInfectionMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-SEPS-101", new ComorbidityEntry("MCC-SEPS-101", "SepsisInfectionMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-SEPS-102", new ComorbidityEntry("MCC-SEPS-102", "SepsisInfectionMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-SEPS-103", new ComorbidityEntry("MCC-SEPS-103", "SepsisInfectionMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-SEPS-104", new ComorbidityEntry("MCC-SEPS-104", "SepsisInfectionMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-SEPS-105", new ComorbidityEntry("MCC-SEPS-105", "SepsisInfectionMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-SEPS-106", new ComorbidityEntry("MCC-SEPS-106", "SepsisInfectionMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-SEPS-107", new ComorbidityEntry("MCC-SEPS-107", "SepsisInfectionMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-SEPS-108", new ComorbidityEntry("MCC-SEPS-108", "SepsisInfectionMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-SEPS-109", new ComorbidityEntry("MCC-SEPS-109", "SepsisInfectionMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-SEPS-110", new ComorbidityEntry("MCC-SEPS-110", "SepsisInfectionMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-SEPS-111", new ComorbidityEntry("MCC-SEPS-111", "SepsisInfectionMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-SEPS-112", new ComorbidityEntry("MCC-SEPS-112", "SepsisInfectionMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-SEPS-113", new ComorbidityEntry("MCC-SEPS-113", "SepsisInfectionMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-SEPS-114", new ComorbidityEntry("MCC-SEPS-114", "SepsisInfectionMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-SEPS-115", new ComorbidityEntry("MCC-SEPS-115", "SepsisInfectionMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-SEPS-116", new ComorbidityEntry("MCC-SEPS-116", "SepsisInfectionMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-SEPS-117", new ComorbidityEntry("MCC-SEPS-117", "SepsisInfectionMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-SEPS-118", new ComorbidityEntry("MCC-SEPS-118", "SepsisInfectionMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-SEPS-119", new ComorbidityEntry("MCC-SEPS-119", "SepsisInfectionMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-SEPS-120", new ComorbidityEntry("MCC-SEPS-120", "SepsisInfectionMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-SEPS-121", new ComorbidityEntry("MCC-SEPS-121", "SepsisInfectionMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-SEPS-122", new ComorbidityEntry("MCC-SEPS-122", "SepsisInfectionMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-SEPS-123", new ComorbidityEntry("MCC-SEPS-123", "SepsisInfectionMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-SEPS-124", new ComorbidityEntry("MCC-SEPS-124", "SepsisInfectionMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-SEPS-125", new ComorbidityEntry("MCC-SEPS-125", "SepsisInfectionMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-SEPS-126", new ComorbidityEntry("MCC-SEPS-126", "SepsisInfectionMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-SEPS-127", new ComorbidityEntry("MCC-SEPS-127", "SepsisInfectionMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-SEPS-128", new ComorbidityEntry("MCC-SEPS-128", "SepsisInfectionMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-SEPS-129", new ComorbidityEntry("MCC-SEPS-129", "SepsisInfectionMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-SEPS-130", new ComorbidityEntry("MCC-SEPS-130", "SepsisInfectionMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-SEPS-131", new ComorbidityEntry("MCC-SEPS-131", "SepsisInfectionMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-SEPS-132", new ComorbidityEntry("MCC-SEPS-132", "SepsisInfectionMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-SEPS-133", new ComorbidityEntry("MCC-SEPS-133", "SepsisInfectionMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-SEPS-134", new ComorbidityEntry("MCC-SEPS-134", "SepsisInfectionMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-SEPS-135", new ComorbidityEntry("MCC-SEPS-135", "SepsisInfectionMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-SEPS-136", new ComorbidityEntry("MCC-SEPS-136", "SepsisInfectionMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-SEPS-137", new ComorbidityEntry("MCC-SEPS-137", "SepsisInfectionMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-SEPS-138", new ComorbidityEntry("MCC-SEPS-138", "SepsisInfectionMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-SEPS-139", new ComorbidityEntry("MCC-SEPS-139", "SepsisInfectionMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-SEPS-140", new ComorbidityEntry("MCC-SEPS-140", "SepsisInfectionMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-SEPS-141", new ComorbidityEntry("MCC-SEPS-141", "SepsisInfectionMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-SEPS-142", new ComorbidityEntry("MCC-SEPS-142", "SepsisInfectionMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-SEPS-143", new ComorbidityEntry("MCC-SEPS-143", "SepsisInfectionMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-SEPS-144", new ComorbidityEntry("MCC-SEPS-144", "SepsisInfectionMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-SEPS-145", new ComorbidityEntry("MCC-SEPS-145", "SepsisInfectionMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-SEPS-146", new ComorbidityEntry("MCC-SEPS-146", "SepsisInfectionMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-SEPS-147", new ComorbidityEntry("MCC-SEPS-147", "SepsisInfectionMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-SEPS-148", new ComorbidityEntry("MCC-SEPS-148", "SepsisInfectionMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-SEPS-149", new ComorbidityEntry("MCC-SEPS-149", "SepsisInfectionMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-SEPS-150", new ComorbidityEntry("MCC-SEPS-150", "SepsisInfectionMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
