package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NeurologicalMajorComorbiditiesKnowledgeCatalog {

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

    public NeurologicalMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-NEUR-001", new ComorbidityEntry("MCC-NEUR-001", "NeurologicalMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-NEUR-002", new ComorbidityEntry("MCC-NEUR-002", "NeurologicalMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-NEUR-003", new ComorbidityEntry("MCC-NEUR-003", "NeurologicalMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-NEUR-004", new ComorbidityEntry("MCC-NEUR-004", "NeurologicalMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-NEUR-005", new ComorbidityEntry("MCC-NEUR-005", "NeurologicalMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-NEUR-006", new ComorbidityEntry("MCC-NEUR-006", "NeurologicalMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-NEUR-007", new ComorbidityEntry("MCC-NEUR-007", "NeurologicalMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-NEUR-008", new ComorbidityEntry("MCC-NEUR-008", "NeurologicalMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-NEUR-009", new ComorbidityEntry("MCC-NEUR-009", "NeurologicalMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-NEUR-010", new ComorbidityEntry("MCC-NEUR-010", "NeurologicalMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-NEUR-011", new ComorbidityEntry("MCC-NEUR-011", "NeurologicalMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-NEUR-012", new ComorbidityEntry("MCC-NEUR-012", "NeurologicalMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-NEUR-013", new ComorbidityEntry("MCC-NEUR-013", "NeurologicalMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-NEUR-014", new ComorbidityEntry("MCC-NEUR-014", "NeurologicalMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-NEUR-015", new ComorbidityEntry("MCC-NEUR-015", "NeurologicalMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-NEUR-016", new ComorbidityEntry("MCC-NEUR-016", "NeurologicalMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-NEUR-017", new ComorbidityEntry("MCC-NEUR-017", "NeurologicalMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-NEUR-018", new ComorbidityEntry("MCC-NEUR-018", "NeurologicalMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-NEUR-019", new ComorbidityEntry("MCC-NEUR-019", "NeurologicalMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-NEUR-020", new ComorbidityEntry("MCC-NEUR-020", "NeurologicalMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-NEUR-021", new ComorbidityEntry("MCC-NEUR-021", "NeurologicalMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-NEUR-022", new ComorbidityEntry("MCC-NEUR-022", "NeurologicalMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-NEUR-023", new ComorbidityEntry("MCC-NEUR-023", "NeurologicalMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-NEUR-024", new ComorbidityEntry("MCC-NEUR-024", "NeurologicalMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-NEUR-025", new ComorbidityEntry("MCC-NEUR-025", "NeurologicalMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-NEUR-026", new ComorbidityEntry("MCC-NEUR-026", "NeurologicalMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-NEUR-027", new ComorbidityEntry("MCC-NEUR-027", "NeurologicalMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-NEUR-028", new ComorbidityEntry("MCC-NEUR-028", "NeurologicalMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-NEUR-029", new ComorbidityEntry("MCC-NEUR-029", "NeurologicalMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-NEUR-030", new ComorbidityEntry("MCC-NEUR-030", "NeurologicalMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-NEUR-031", new ComorbidityEntry("MCC-NEUR-031", "NeurologicalMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-NEUR-032", new ComorbidityEntry("MCC-NEUR-032", "NeurologicalMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-NEUR-033", new ComorbidityEntry("MCC-NEUR-033", "NeurologicalMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-NEUR-034", new ComorbidityEntry("MCC-NEUR-034", "NeurologicalMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-NEUR-035", new ComorbidityEntry("MCC-NEUR-035", "NeurologicalMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-NEUR-036", new ComorbidityEntry("MCC-NEUR-036", "NeurologicalMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-NEUR-037", new ComorbidityEntry("MCC-NEUR-037", "NeurologicalMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-NEUR-038", new ComorbidityEntry("MCC-NEUR-038", "NeurologicalMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-NEUR-039", new ComorbidityEntry("MCC-NEUR-039", "NeurologicalMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-NEUR-040", new ComorbidityEntry("MCC-NEUR-040", "NeurologicalMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-NEUR-041", new ComorbidityEntry("MCC-NEUR-041", "NeurologicalMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-NEUR-042", new ComorbidityEntry("MCC-NEUR-042", "NeurologicalMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-NEUR-043", new ComorbidityEntry("MCC-NEUR-043", "NeurologicalMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-NEUR-044", new ComorbidityEntry("MCC-NEUR-044", "NeurologicalMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-NEUR-045", new ComorbidityEntry("MCC-NEUR-045", "NeurologicalMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-NEUR-046", new ComorbidityEntry("MCC-NEUR-046", "NeurologicalMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-NEUR-047", new ComorbidityEntry("MCC-NEUR-047", "NeurologicalMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-NEUR-048", new ComorbidityEntry("MCC-NEUR-048", "NeurologicalMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-NEUR-049", new ComorbidityEntry("MCC-NEUR-049", "NeurologicalMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-NEUR-050", new ComorbidityEntry("MCC-NEUR-050", "NeurologicalMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-NEUR-051", new ComorbidityEntry("MCC-NEUR-051", "NeurologicalMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-NEUR-052", new ComorbidityEntry("MCC-NEUR-052", "NeurologicalMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-NEUR-053", new ComorbidityEntry("MCC-NEUR-053", "NeurologicalMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-NEUR-054", new ComorbidityEntry("MCC-NEUR-054", "NeurologicalMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-NEUR-055", new ComorbidityEntry("MCC-NEUR-055", "NeurologicalMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-NEUR-056", new ComorbidityEntry("MCC-NEUR-056", "NeurologicalMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-NEUR-057", new ComorbidityEntry("MCC-NEUR-057", "NeurologicalMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-NEUR-058", new ComorbidityEntry("MCC-NEUR-058", "NeurologicalMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-NEUR-059", new ComorbidityEntry("MCC-NEUR-059", "NeurologicalMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-NEUR-060", new ComorbidityEntry("MCC-NEUR-060", "NeurologicalMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-NEUR-061", new ComorbidityEntry("MCC-NEUR-061", "NeurologicalMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-NEUR-062", new ComorbidityEntry("MCC-NEUR-062", "NeurologicalMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-NEUR-063", new ComorbidityEntry("MCC-NEUR-063", "NeurologicalMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-NEUR-064", new ComorbidityEntry("MCC-NEUR-064", "NeurologicalMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-NEUR-065", new ComorbidityEntry("MCC-NEUR-065", "NeurologicalMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-NEUR-066", new ComorbidityEntry("MCC-NEUR-066", "NeurologicalMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-NEUR-067", new ComorbidityEntry("MCC-NEUR-067", "NeurologicalMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-NEUR-068", new ComorbidityEntry("MCC-NEUR-068", "NeurologicalMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-NEUR-069", new ComorbidityEntry("MCC-NEUR-069", "NeurologicalMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-NEUR-070", new ComorbidityEntry("MCC-NEUR-070", "NeurologicalMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-NEUR-071", new ComorbidityEntry("MCC-NEUR-071", "NeurologicalMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-NEUR-072", new ComorbidityEntry("MCC-NEUR-072", "NeurologicalMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-NEUR-073", new ComorbidityEntry("MCC-NEUR-073", "NeurologicalMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-NEUR-074", new ComorbidityEntry("MCC-NEUR-074", "NeurologicalMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-NEUR-075", new ComorbidityEntry("MCC-NEUR-075", "NeurologicalMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-NEUR-076", new ComorbidityEntry("MCC-NEUR-076", "NeurologicalMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-NEUR-077", new ComorbidityEntry("MCC-NEUR-077", "NeurologicalMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-NEUR-078", new ComorbidityEntry("MCC-NEUR-078", "NeurologicalMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-NEUR-079", new ComorbidityEntry("MCC-NEUR-079", "NeurologicalMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-NEUR-080", new ComorbidityEntry("MCC-NEUR-080", "NeurologicalMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-NEUR-081", new ComorbidityEntry("MCC-NEUR-081", "NeurologicalMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-NEUR-082", new ComorbidityEntry("MCC-NEUR-082", "NeurologicalMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-NEUR-083", new ComorbidityEntry("MCC-NEUR-083", "NeurologicalMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-NEUR-084", new ComorbidityEntry("MCC-NEUR-084", "NeurologicalMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-NEUR-085", new ComorbidityEntry("MCC-NEUR-085", "NeurologicalMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-NEUR-086", new ComorbidityEntry("MCC-NEUR-086", "NeurologicalMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-NEUR-087", new ComorbidityEntry("MCC-NEUR-087", "NeurologicalMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-NEUR-088", new ComorbidityEntry("MCC-NEUR-088", "NeurologicalMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-NEUR-089", new ComorbidityEntry("MCC-NEUR-089", "NeurologicalMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-NEUR-090", new ComorbidityEntry("MCC-NEUR-090", "NeurologicalMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-NEUR-091", new ComorbidityEntry("MCC-NEUR-091", "NeurologicalMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-NEUR-092", new ComorbidityEntry("MCC-NEUR-092", "NeurologicalMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-NEUR-093", new ComorbidityEntry("MCC-NEUR-093", "NeurologicalMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-NEUR-094", new ComorbidityEntry("MCC-NEUR-094", "NeurologicalMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-NEUR-095", new ComorbidityEntry("MCC-NEUR-095", "NeurologicalMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-NEUR-096", new ComorbidityEntry("MCC-NEUR-096", "NeurologicalMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-NEUR-097", new ComorbidityEntry("MCC-NEUR-097", "NeurologicalMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-NEUR-098", new ComorbidityEntry("MCC-NEUR-098", "NeurologicalMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-NEUR-099", new ComorbidityEntry("MCC-NEUR-099", "NeurologicalMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-NEUR-100", new ComorbidityEntry("MCC-NEUR-100", "NeurologicalMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-NEUR-101", new ComorbidityEntry("MCC-NEUR-101", "NeurologicalMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-NEUR-102", new ComorbidityEntry("MCC-NEUR-102", "NeurologicalMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-NEUR-103", new ComorbidityEntry("MCC-NEUR-103", "NeurologicalMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-NEUR-104", new ComorbidityEntry("MCC-NEUR-104", "NeurologicalMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-NEUR-105", new ComorbidityEntry("MCC-NEUR-105", "NeurologicalMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-NEUR-106", new ComorbidityEntry("MCC-NEUR-106", "NeurologicalMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-NEUR-107", new ComorbidityEntry("MCC-NEUR-107", "NeurologicalMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-NEUR-108", new ComorbidityEntry("MCC-NEUR-108", "NeurologicalMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-NEUR-109", new ComorbidityEntry("MCC-NEUR-109", "NeurologicalMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-NEUR-110", new ComorbidityEntry("MCC-NEUR-110", "NeurologicalMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-NEUR-111", new ComorbidityEntry("MCC-NEUR-111", "NeurologicalMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-NEUR-112", new ComorbidityEntry("MCC-NEUR-112", "NeurologicalMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-NEUR-113", new ComorbidityEntry("MCC-NEUR-113", "NeurologicalMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-NEUR-114", new ComorbidityEntry("MCC-NEUR-114", "NeurologicalMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-NEUR-115", new ComorbidityEntry("MCC-NEUR-115", "NeurologicalMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-NEUR-116", new ComorbidityEntry("MCC-NEUR-116", "NeurologicalMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-NEUR-117", new ComorbidityEntry("MCC-NEUR-117", "NeurologicalMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-NEUR-118", new ComorbidityEntry("MCC-NEUR-118", "NeurologicalMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-NEUR-119", new ComorbidityEntry("MCC-NEUR-119", "NeurologicalMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-NEUR-120", new ComorbidityEntry("MCC-NEUR-120", "NeurologicalMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-NEUR-121", new ComorbidityEntry("MCC-NEUR-121", "NeurologicalMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-NEUR-122", new ComorbidityEntry("MCC-NEUR-122", "NeurologicalMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-NEUR-123", new ComorbidityEntry("MCC-NEUR-123", "NeurologicalMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-NEUR-124", new ComorbidityEntry("MCC-NEUR-124", "NeurologicalMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-NEUR-125", new ComorbidityEntry("MCC-NEUR-125", "NeurologicalMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-NEUR-126", new ComorbidityEntry("MCC-NEUR-126", "NeurologicalMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-NEUR-127", new ComorbidityEntry("MCC-NEUR-127", "NeurologicalMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-NEUR-128", new ComorbidityEntry("MCC-NEUR-128", "NeurologicalMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-NEUR-129", new ComorbidityEntry("MCC-NEUR-129", "NeurologicalMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-NEUR-130", new ComorbidityEntry("MCC-NEUR-130", "NeurologicalMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-NEUR-131", new ComorbidityEntry("MCC-NEUR-131", "NeurologicalMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-NEUR-132", new ComorbidityEntry("MCC-NEUR-132", "NeurologicalMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-NEUR-133", new ComorbidityEntry("MCC-NEUR-133", "NeurologicalMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-NEUR-134", new ComorbidityEntry("MCC-NEUR-134", "NeurologicalMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-NEUR-135", new ComorbidityEntry("MCC-NEUR-135", "NeurologicalMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-NEUR-136", new ComorbidityEntry("MCC-NEUR-136", "NeurologicalMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-NEUR-137", new ComorbidityEntry("MCC-NEUR-137", "NeurologicalMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-NEUR-138", new ComorbidityEntry("MCC-NEUR-138", "NeurologicalMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-NEUR-139", new ComorbidityEntry("MCC-NEUR-139", "NeurologicalMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-NEUR-140", new ComorbidityEntry("MCC-NEUR-140", "NeurologicalMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-NEUR-141", new ComorbidityEntry("MCC-NEUR-141", "NeurologicalMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-NEUR-142", new ComorbidityEntry("MCC-NEUR-142", "NeurologicalMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-NEUR-143", new ComorbidityEntry("MCC-NEUR-143", "NeurologicalMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-NEUR-144", new ComorbidityEntry("MCC-NEUR-144", "NeurologicalMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-NEUR-145", new ComorbidityEntry("MCC-NEUR-145", "NeurologicalMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-NEUR-146", new ComorbidityEntry("MCC-NEUR-146", "NeurologicalMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-NEUR-147", new ComorbidityEntry("MCC-NEUR-147", "NeurologicalMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-NEUR-148", new ComorbidityEntry("MCC-NEUR-148", "NeurologicalMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-NEUR-149", new ComorbidityEntry("MCC-NEUR-149", "NeurologicalMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-NEUR-150", new ComorbidityEntry("MCC-NEUR-150", "NeurologicalMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
