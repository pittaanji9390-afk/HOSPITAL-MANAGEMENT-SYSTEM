package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RespiratoryMajorComorbiditiesKnowledgeCatalog {

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

    public RespiratoryMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-RESP-001", new ComorbidityEntry("MCC-RESP-001", "RespiratoryMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-RESP-002", new ComorbidityEntry("MCC-RESP-002", "RespiratoryMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-RESP-003", new ComorbidityEntry("MCC-RESP-003", "RespiratoryMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-RESP-004", new ComorbidityEntry("MCC-RESP-004", "RespiratoryMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-RESP-005", new ComorbidityEntry("MCC-RESP-005", "RespiratoryMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-RESP-006", new ComorbidityEntry("MCC-RESP-006", "RespiratoryMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-RESP-007", new ComorbidityEntry("MCC-RESP-007", "RespiratoryMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-RESP-008", new ComorbidityEntry("MCC-RESP-008", "RespiratoryMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-RESP-009", new ComorbidityEntry("MCC-RESP-009", "RespiratoryMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-RESP-010", new ComorbidityEntry("MCC-RESP-010", "RespiratoryMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-RESP-011", new ComorbidityEntry("MCC-RESP-011", "RespiratoryMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-RESP-012", new ComorbidityEntry("MCC-RESP-012", "RespiratoryMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-RESP-013", new ComorbidityEntry("MCC-RESP-013", "RespiratoryMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-RESP-014", new ComorbidityEntry("MCC-RESP-014", "RespiratoryMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-RESP-015", new ComorbidityEntry("MCC-RESP-015", "RespiratoryMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-RESP-016", new ComorbidityEntry("MCC-RESP-016", "RespiratoryMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-RESP-017", new ComorbidityEntry("MCC-RESP-017", "RespiratoryMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-RESP-018", new ComorbidityEntry("MCC-RESP-018", "RespiratoryMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-RESP-019", new ComorbidityEntry("MCC-RESP-019", "RespiratoryMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-RESP-020", new ComorbidityEntry("MCC-RESP-020", "RespiratoryMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-RESP-021", new ComorbidityEntry("MCC-RESP-021", "RespiratoryMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-RESP-022", new ComorbidityEntry("MCC-RESP-022", "RespiratoryMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-RESP-023", new ComorbidityEntry("MCC-RESP-023", "RespiratoryMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-RESP-024", new ComorbidityEntry("MCC-RESP-024", "RespiratoryMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-RESP-025", new ComorbidityEntry("MCC-RESP-025", "RespiratoryMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-RESP-026", new ComorbidityEntry("MCC-RESP-026", "RespiratoryMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-RESP-027", new ComorbidityEntry("MCC-RESP-027", "RespiratoryMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-RESP-028", new ComorbidityEntry("MCC-RESP-028", "RespiratoryMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-RESP-029", new ComorbidityEntry("MCC-RESP-029", "RespiratoryMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-RESP-030", new ComorbidityEntry("MCC-RESP-030", "RespiratoryMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-RESP-031", new ComorbidityEntry("MCC-RESP-031", "RespiratoryMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-RESP-032", new ComorbidityEntry("MCC-RESP-032", "RespiratoryMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-RESP-033", new ComorbidityEntry("MCC-RESP-033", "RespiratoryMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-RESP-034", new ComorbidityEntry("MCC-RESP-034", "RespiratoryMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-RESP-035", new ComorbidityEntry("MCC-RESP-035", "RespiratoryMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-RESP-036", new ComorbidityEntry("MCC-RESP-036", "RespiratoryMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-RESP-037", new ComorbidityEntry("MCC-RESP-037", "RespiratoryMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-RESP-038", new ComorbidityEntry("MCC-RESP-038", "RespiratoryMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-RESP-039", new ComorbidityEntry("MCC-RESP-039", "RespiratoryMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-RESP-040", new ComorbidityEntry("MCC-RESP-040", "RespiratoryMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-RESP-041", new ComorbidityEntry("MCC-RESP-041", "RespiratoryMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-RESP-042", new ComorbidityEntry("MCC-RESP-042", "RespiratoryMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-RESP-043", new ComorbidityEntry("MCC-RESP-043", "RespiratoryMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-RESP-044", new ComorbidityEntry("MCC-RESP-044", "RespiratoryMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-RESP-045", new ComorbidityEntry("MCC-RESP-045", "RespiratoryMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-RESP-046", new ComorbidityEntry("MCC-RESP-046", "RespiratoryMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-RESP-047", new ComorbidityEntry("MCC-RESP-047", "RespiratoryMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-RESP-048", new ComorbidityEntry("MCC-RESP-048", "RespiratoryMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-RESP-049", new ComorbidityEntry("MCC-RESP-049", "RespiratoryMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-RESP-050", new ComorbidityEntry("MCC-RESP-050", "RespiratoryMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-RESP-051", new ComorbidityEntry("MCC-RESP-051", "RespiratoryMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-RESP-052", new ComorbidityEntry("MCC-RESP-052", "RespiratoryMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-RESP-053", new ComorbidityEntry("MCC-RESP-053", "RespiratoryMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-RESP-054", new ComorbidityEntry("MCC-RESP-054", "RespiratoryMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-RESP-055", new ComorbidityEntry("MCC-RESP-055", "RespiratoryMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-RESP-056", new ComorbidityEntry("MCC-RESP-056", "RespiratoryMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-RESP-057", new ComorbidityEntry("MCC-RESP-057", "RespiratoryMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-RESP-058", new ComorbidityEntry("MCC-RESP-058", "RespiratoryMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-RESP-059", new ComorbidityEntry("MCC-RESP-059", "RespiratoryMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-RESP-060", new ComorbidityEntry("MCC-RESP-060", "RespiratoryMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-RESP-061", new ComorbidityEntry("MCC-RESP-061", "RespiratoryMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-RESP-062", new ComorbidityEntry("MCC-RESP-062", "RespiratoryMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-RESP-063", new ComorbidityEntry("MCC-RESP-063", "RespiratoryMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-RESP-064", new ComorbidityEntry("MCC-RESP-064", "RespiratoryMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-RESP-065", new ComorbidityEntry("MCC-RESP-065", "RespiratoryMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-RESP-066", new ComorbidityEntry("MCC-RESP-066", "RespiratoryMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-RESP-067", new ComorbidityEntry("MCC-RESP-067", "RespiratoryMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-RESP-068", new ComorbidityEntry("MCC-RESP-068", "RespiratoryMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-RESP-069", new ComorbidityEntry("MCC-RESP-069", "RespiratoryMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-RESP-070", new ComorbidityEntry("MCC-RESP-070", "RespiratoryMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-RESP-071", new ComorbidityEntry("MCC-RESP-071", "RespiratoryMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-RESP-072", new ComorbidityEntry("MCC-RESP-072", "RespiratoryMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-RESP-073", new ComorbidityEntry("MCC-RESP-073", "RespiratoryMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-RESP-074", new ComorbidityEntry("MCC-RESP-074", "RespiratoryMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-RESP-075", new ComorbidityEntry("MCC-RESP-075", "RespiratoryMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-RESP-076", new ComorbidityEntry("MCC-RESP-076", "RespiratoryMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-RESP-077", new ComorbidityEntry("MCC-RESP-077", "RespiratoryMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-RESP-078", new ComorbidityEntry("MCC-RESP-078", "RespiratoryMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-RESP-079", new ComorbidityEntry("MCC-RESP-079", "RespiratoryMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-RESP-080", new ComorbidityEntry("MCC-RESP-080", "RespiratoryMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-RESP-081", new ComorbidityEntry("MCC-RESP-081", "RespiratoryMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-RESP-082", new ComorbidityEntry("MCC-RESP-082", "RespiratoryMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-RESP-083", new ComorbidityEntry("MCC-RESP-083", "RespiratoryMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-RESP-084", new ComorbidityEntry("MCC-RESP-084", "RespiratoryMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-RESP-085", new ComorbidityEntry("MCC-RESP-085", "RespiratoryMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-RESP-086", new ComorbidityEntry("MCC-RESP-086", "RespiratoryMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-RESP-087", new ComorbidityEntry("MCC-RESP-087", "RespiratoryMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-RESP-088", new ComorbidityEntry("MCC-RESP-088", "RespiratoryMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-RESP-089", new ComorbidityEntry("MCC-RESP-089", "RespiratoryMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-RESP-090", new ComorbidityEntry("MCC-RESP-090", "RespiratoryMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-RESP-091", new ComorbidityEntry("MCC-RESP-091", "RespiratoryMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-RESP-092", new ComorbidityEntry("MCC-RESP-092", "RespiratoryMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-RESP-093", new ComorbidityEntry("MCC-RESP-093", "RespiratoryMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-RESP-094", new ComorbidityEntry("MCC-RESP-094", "RespiratoryMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-RESP-095", new ComorbidityEntry("MCC-RESP-095", "RespiratoryMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-RESP-096", new ComorbidityEntry("MCC-RESP-096", "RespiratoryMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-RESP-097", new ComorbidityEntry("MCC-RESP-097", "RespiratoryMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-RESP-098", new ComorbidityEntry("MCC-RESP-098", "RespiratoryMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-RESP-099", new ComorbidityEntry("MCC-RESP-099", "RespiratoryMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-RESP-100", new ComorbidityEntry("MCC-RESP-100", "RespiratoryMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-RESP-101", new ComorbidityEntry("MCC-RESP-101", "RespiratoryMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-RESP-102", new ComorbidityEntry("MCC-RESP-102", "RespiratoryMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-RESP-103", new ComorbidityEntry("MCC-RESP-103", "RespiratoryMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-RESP-104", new ComorbidityEntry("MCC-RESP-104", "RespiratoryMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-RESP-105", new ComorbidityEntry("MCC-RESP-105", "RespiratoryMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-RESP-106", new ComorbidityEntry("MCC-RESP-106", "RespiratoryMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-RESP-107", new ComorbidityEntry("MCC-RESP-107", "RespiratoryMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-RESP-108", new ComorbidityEntry("MCC-RESP-108", "RespiratoryMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-RESP-109", new ComorbidityEntry("MCC-RESP-109", "RespiratoryMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-RESP-110", new ComorbidityEntry("MCC-RESP-110", "RespiratoryMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-RESP-111", new ComorbidityEntry("MCC-RESP-111", "RespiratoryMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-RESP-112", new ComorbidityEntry("MCC-RESP-112", "RespiratoryMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-RESP-113", new ComorbidityEntry("MCC-RESP-113", "RespiratoryMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-RESP-114", new ComorbidityEntry("MCC-RESP-114", "RespiratoryMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-RESP-115", new ComorbidityEntry("MCC-RESP-115", "RespiratoryMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-RESP-116", new ComorbidityEntry("MCC-RESP-116", "RespiratoryMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-RESP-117", new ComorbidityEntry("MCC-RESP-117", "RespiratoryMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-RESP-118", new ComorbidityEntry("MCC-RESP-118", "RespiratoryMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-RESP-119", new ComorbidityEntry("MCC-RESP-119", "RespiratoryMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-RESP-120", new ComorbidityEntry("MCC-RESP-120", "RespiratoryMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-RESP-121", new ComorbidityEntry("MCC-RESP-121", "RespiratoryMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-RESP-122", new ComorbidityEntry("MCC-RESP-122", "RespiratoryMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-RESP-123", new ComorbidityEntry("MCC-RESP-123", "RespiratoryMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-RESP-124", new ComorbidityEntry("MCC-RESP-124", "RespiratoryMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-RESP-125", new ComorbidityEntry("MCC-RESP-125", "RespiratoryMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-RESP-126", new ComorbidityEntry("MCC-RESP-126", "RespiratoryMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-RESP-127", new ComorbidityEntry("MCC-RESP-127", "RespiratoryMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-RESP-128", new ComorbidityEntry("MCC-RESP-128", "RespiratoryMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-RESP-129", new ComorbidityEntry("MCC-RESP-129", "RespiratoryMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-RESP-130", new ComorbidityEntry("MCC-RESP-130", "RespiratoryMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-RESP-131", new ComorbidityEntry("MCC-RESP-131", "RespiratoryMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-RESP-132", new ComorbidityEntry("MCC-RESP-132", "RespiratoryMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-RESP-133", new ComorbidityEntry("MCC-RESP-133", "RespiratoryMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-RESP-134", new ComorbidityEntry("MCC-RESP-134", "RespiratoryMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-RESP-135", new ComorbidityEntry("MCC-RESP-135", "RespiratoryMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-RESP-136", new ComorbidityEntry("MCC-RESP-136", "RespiratoryMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-RESP-137", new ComorbidityEntry("MCC-RESP-137", "RespiratoryMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-RESP-138", new ComorbidityEntry("MCC-RESP-138", "RespiratoryMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-RESP-139", new ComorbidityEntry("MCC-RESP-139", "RespiratoryMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-RESP-140", new ComorbidityEntry("MCC-RESP-140", "RespiratoryMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-RESP-141", new ComorbidityEntry("MCC-RESP-141", "RespiratoryMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-RESP-142", new ComorbidityEntry("MCC-RESP-142", "RespiratoryMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-RESP-143", new ComorbidityEntry("MCC-RESP-143", "RespiratoryMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-RESP-144", new ComorbidityEntry("MCC-RESP-144", "RespiratoryMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-RESP-145", new ComorbidityEntry("MCC-RESP-145", "RespiratoryMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-RESP-146", new ComorbidityEntry("MCC-RESP-146", "RespiratoryMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-RESP-147", new ComorbidityEntry("MCC-RESP-147", "RespiratoryMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-RESP-148", new ComorbidityEntry("MCC-RESP-148", "RespiratoryMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-RESP-149", new ComorbidityEntry("MCC-RESP-149", "RespiratoryMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-RESP-150", new ComorbidityEntry("MCC-RESP-150", "RespiratoryMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
