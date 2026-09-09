package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RenalFailureMajorComorbiditiesKnowledgeCatalog {

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

    public RenalFailureMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-RENA-001", new ComorbidityEntry("MCC-RENA-001", "RenalFailureMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-RENA-002", new ComorbidityEntry("MCC-RENA-002", "RenalFailureMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-RENA-003", new ComorbidityEntry("MCC-RENA-003", "RenalFailureMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-RENA-004", new ComorbidityEntry("MCC-RENA-004", "RenalFailureMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-RENA-005", new ComorbidityEntry("MCC-RENA-005", "RenalFailureMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-RENA-006", new ComorbidityEntry("MCC-RENA-006", "RenalFailureMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-RENA-007", new ComorbidityEntry("MCC-RENA-007", "RenalFailureMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-RENA-008", new ComorbidityEntry("MCC-RENA-008", "RenalFailureMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-RENA-009", new ComorbidityEntry("MCC-RENA-009", "RenalFailureMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-RENA-010", new ComorbidityEntry("MCC-RENA-010", "RenalFailureMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-RENA-011", new ComorbidityEntry("MCC-RENA-011", "RenalFailureMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-RENA-012", new ComorbidityEntry("MCC-RENA-012", "RenalFailureMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-RENA-013", new ComorbidityEntry("MCC-RENA-013", "RenalFailureMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-RENA-014", new ComorbidityEntry("MCC-RENA-014", "RenalFailureMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-RENA-015", new ComorbidityEntry("MCC-RENA-015", "RenalFailureMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-RENA-016", new ComorbidityEntry("MCC-RENA-016", "RenalFailureMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-RENA-017", new ComorbidityEntry("MCC-RENA-017", "RenalFailureMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-RENA-018", new ComorbidityEntry("MCC-RENA-018", "RenalFailureMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-RENA-019", new ComorbidityEntry("MCC-RENA-019", "RenalFailureMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-RENA-020", new ComorbidityEntry("MCC-RENA-020", "RenalFailureMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-RENA-021", new ComorbidityEntry("MCC-RENA-021", "RenalFailureMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-RENA-022", new ComorbidityEntry("MCC-RENA-022", "RenalFailureMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-RENA-023", new ComorbidityEntry("MCC-RENA-023", "RenalFailureMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-RENA-024", new ComorbidityEntry("MCC-RENA-024", "RenalFailureMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-RENA-025", new ComorbidityEntry("MCC-RENA-025", "RenalFailureMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-RENA-026", new ComorbidityEntry("MCC-RENA-026", "RenalFailureMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-RENA-027", new ComorbidityEntry("MCC-RENA-027", "RenalFailureMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-RENA-028", new ComorbidityEntry("MCC-RENA-028", "RenalFailureMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-RENA-029", new ComorbidityEntry("MCC-RENA-029", "RenalFailureMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-RENA-030", new ComorbidityEntry("MCC-RENA-030", "RenalFailureMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-RENA-031", new ComorbidityEntry("MCC-RENA-031", "RenalFailureMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-RENA-032", new ComorbidityEntry("MCC-RENA-032", "RenalFailureMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-RENA-033", new ComorbidityEntry("MCC-RENA-033", "RenalFailureMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-RENA-034", new ComorbidityEntry("MCC-RENA-034", "RenalFailureMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-RENA-035", new ComorbidityEntry("MCC-RENA-035", "RenalFailureMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-RENA-036", new ComorbidityEntry("MCC-RENA-036", "RenalFailureMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-RENA-037", new ComorbidityEntry("MCC-RENA-037", "RenalFailureMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-RENA-038", new ComorbidityEntry("MCC-RENA-038", "RenalFailureMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-RENA-039", new ComorbidityEntry("MCC-RENA-039", "RenalFailureMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-RENA-040", new ComorbidityEntry("MCC-RENA-040", "RenalFailureMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-RENA-041", new ComorbidityEntry("MCC-RENA-041", "RenalFailureMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-RENA-042", new ComorbidityEntry("MCC-RENA-042", "RenalFailureMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-RENA-043", new ComorbidityEntry("MCC-RENA-043", "RenalFailureMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-RENA-044", new ComorbidityEntry("MCC-RENA-044", "RenalFailureMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-RENA-045", new ComorbidityEntry("MCC-RENA-045", "RenalFailureMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-RENA-046", new ComorbidityEntry("MCC-RENA-046", "RenalFailureMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-RENA-047", new ComorbidityEntry("MCC-RENA-047", "RenalFailureMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-RENA-048", new ComorbidityEntry("MCC-RENA-048", "RenalFailureMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-RENA-049", new ComorbidityEntry("MCC-RENA-049", "RenalFailureMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-RENA-050", new ComorbidityEntry("MCC-RENA-050", "RenalFailureMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-RENA-051", new ComorbidityEntry("MCC-RENA-051", "RenalFailureMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-RENA-052", new ComorbidityEntry("MCC-RENA-052", "RenalFailureMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-RENA-053", new ComorbidityEntry("MCC-RENA-053", "RenalFailureMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-RENA-054", new ComorbidityEntry("MCC-RENA-054", "RenalFailureMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-RENA-055", new ComorbidityEntry("MCC-RENA-055", "RenalFailureMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-RENA-056", new ComorbidityEntry("MCC-RENA-056", "RenalFailureMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-RENA-057", new ComorbidityEntry("MCC-RENA-057", "RenalFailureMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-RENA-058", new ComorbidityEntry("MCC-RENA-058", "RenalFailureMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-RENA-059", new ComorbidityEntry("MCC-RENA-059", "RenalFailureMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-RENA-060", new ComorbidityEntry("MCC-RENA-060", "RenalFailureMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-RENA-061", new ComorbidityEntry("MCC-RENA-061", "RenalFailureMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-RENA-062", new ComorbidityEntry("MCC-RENA-062", "RenalFailureMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-RENA-063", new ComorbidityEntry("MCC-RENA-063", "RenalFailureMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-RENA-064", new ComorbidityEntry("MCC-RENA-064", "RenalFailureMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-RENA-065", new ComorbidityEntry("MCC-RENA-065", "RenalFailureMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-RENA-066", new ComorbidityEntry("MCC-RENA-066", "RenalFailureMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-RENA-067", new ComorbidityEntry("MCC-RENA-067", "RenalFailureMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-RENA-068", new ComorbidityEntry("MCC-RENA-068", "RenalFailureMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-RENA-069", new ComorbidityEntry("MCC-RENA-069", "RenalFailureMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-RENA-070", new ComorbidityEntry("MCC-RENA-070", "RenalFailureMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-RENA-071", new ComorbidityEntry("MCC-RENA-071", "RenalFailureMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-RENA-072", new ComorbidityEntry("MCC-RENA-072", "RenalFailureMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-RENA-073", new ComorbidityEntry("MCC-RENA-073", "RenalFailureMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-RENA-074", new ComorbidityEntry("MCC-RENA-074", "RenalFailureMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-RENA-075", new ComorbidityEntry("MCC-RENA-075", "RenalFailureMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-RENA-076", new ComorbidityEntry("MCC-RENA-076", "RenalFailureMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-RENA-077", new ComorbidityEntry("MCC-RENA-077", "RenalFailureMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-RENA-078", new ComorbidityEntry("MCC-RENA-078", "RenalFailureMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-RENA-079", new ComorbidityEntry("MCC-RENA-079", "RenalFailureMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-RENA-080", new ComorbidityEntry("MCC-RENA-080", "RenalFailureMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-RENA-081", new ComorbidityEntry("MCC-RENA-081", "RenalFailureMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-RENA-082", new ComorbidityEntry("MCC-RENA-082", "RenalFailureMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-RENA-083", new ComorbidityEntry("MCC-RENA-083", "RenalFailureMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-RENA-084", new ComorbidityEntry("MCC-RENA-084", "RenalFailureMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-RENA-085", new ComorbidityEntry("MCC-RENA-085", "RenalFailureMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-RENA-086", new ComorbidityEntry("MCC-RENA-086", "RenalFailureMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-RENA-087", new ComorbidityEntry("MCC-RENA-087", "RenalFailureMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-RENA-088", new ComorbidityEntry("MCC-RENA-088", "RenalFailureMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-RENA-089", new ComorbidityEntry("MCC-RENA-089", "RenalFailureMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-RENA-090", new ComorbidityEntry("MCC-RENA-090", "RenalFailureMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-RENA-091", new ComorbidityEntry("MCC-RENA-091", "RenalFailureMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-RENA-092", new ComorbidityEntry("MCC-RENA-092", "RenalFailureMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-RENA-093", new ComorbidityEntry("MCC-RENA-093", "RenalFailureMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-RENA-094", new ComorbidityEntry("MCC-RENA-094", "RenalFailureMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-RENA-095", new ComorbidityEntry("MCC-RENA-095", "RenalFailureMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-RENA-096", new ComorbidityEntry("MCC-RENA-096", "RenalFailureMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-RENA-097", new ComorbidityEntry("MCC-RENA-097", "RenalFailureMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-RENA-098", new ComorbidityEntry("MCC-RENA-098", "RenalFailureMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-RENA-099", new ComorbidityEntry("MCC-RENA-099", "RenalFailureMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-RENA-100", new ComorbidityEntry("MCC-RENA-100", "RenalFailureMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-RENA-101", new ComorbidityEntry("MCC-RENA-101", "RenalFailureMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-RENA-102", new ComorbidityEntry("MCC-RENA-102", "RenalFailureMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-RENA-103", new ComorbidityEntry("MCC-RENA-103", "RenalFailureMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-RENA-104", new ComorbidityEntry("MCC-RENA-104", "RenalFailureMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-RENA-105", new ComorbidityEntry("MCC-RENA-105", "RenalFailureMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-RENA-106", new ComorbidityEntry("MCC-RENA-106", "RenalFailureMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-RENA-107", new ComorbidityEntry("MCC-RENA-107", "RenalFailureMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-RENA-108", new ComorbidityEntry("MCC-RENA-108", "RenalFailureMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-RENA-109", new ComorbidityEntry("MCC-RENA-109", "RenalFailureMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-RENA-110", new ComorbidityEntry("MCC-RENA-110", "RenalFailureMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-RENA-111", new ComorbidityEntry("MCC-RENA-111", "RenalFailureMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-RENA-112", new ComorbidityEntry("MCC-RENA-112", "RenalFailureMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-RENA-113", new ComorbidityEntry("MCC-RENA-113", "RenalFailureMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-RENA-114", new ComorbidityEntry("MCC-RENA-114", "RenalFailureMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-RENA-115", new ComorbidityEntry("MCC-RENA-115", "RenalFailureMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-RENA-116", new ComorbidityEntry("MCC-RENA-116", "RenalFailureMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-RENA-117", new ComorbidityEntry("MCC-RENA-117", "RenalFailureMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-RENA-118", new ComorbidityEntry("MCC-RENA-118", "RenalFailureMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-RENA-119", new ComorbidityEntry("MCC-RENA-119", "RenalFailureMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-RENA-120", new ComorbidityEntry("MCC-RENA-120", "RenalFailureMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-RENA-121", new ComorbidityEntry("MCC-RENA-121", "RenalFailureMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-RENA-122", new ComorbidityEntry("MCC-RENA-122", "RenalFailureMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-RENA-123", new ComorbidityEntry("MCC-RENA-123", "RenalFailureMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-RENA-124", new ComorbidityEntry("MCC-RENA-124", "RenalFailureMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-RENA-125", new ComorbidityEntry("MCC-RENA-125", "RenalFailureMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-RENA-126", new ComorbidityEntry("MCC-RENA-126", "RenalFailureMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-RENA-127", new ComorbidityEntry("MCC-RENA-127", "RenalFailureMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-RENA-128", new ComorbidityEntry("MCC-RENA-128", "RenalFailureMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-RENA-129", new ComorbidityEntry("MCC-RENA-129", "RenalFailureMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-RENA-130", new ComorbidityEntry("MCC-RENA-130", "RenalFailureMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-RENA-131", new ComorbidityEntry("MCC-RENA-131", "RenalFailureMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-RENA-132", new ComorbidityEntry("MCC-RENA-132", "RenalFailureMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-RENA-133", new ComorbidityEntry("MCC-RENA-133", "RenalFailureMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-RENA-134", new ComorbidityEntry("MCC-RENA-134", "RenalFailureMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-RENA-135", new ComorbidityEntry("MCC-RENA-135", "RenalFailureMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-RENA-136", new ComorbidityEntry("MCC-RENA-136", "RenalFailureMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-RENA-137", new ComorbidityEntry("MCC-RENA-137", "RenalFailureMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-RENA-138", new ComorbidityEntry("MCC-RENA-138", "RenalFailureMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-RENA-139", new ComorbidityEntry("MCC-RENA-139", "RenalFailureMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-RENA-140", new ComorbidityEntry("MCC-RENA-140", "RenalFailureMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-RENA-141", new ComorbidityEntry("MCC-RENA-141", "RenalFailureMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-RENA-142", new ComorbidityEntry("MCC-RENA-142", "RenalFailureMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-RENA-143", new ComorbidityEntry("MCC-RENA-143", "RenalFailureMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-RENA-144", new ComorbidityEntry("MCC-RENA-144", "RenalFailureMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-RENA-145", new ComorbidityEntry("MCC-RENA-145", "RenalFailureMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-RENA-146", new ComorbidityEntry("MCC-RENA-146", "RenalFailureMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-RENA-147", new ComorbidityEntry("MCC-RENA-147", "RenalFailureMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-RENA-148", new ComorbidityEntry("MCC-RENA-148", "RenalFailureMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-RENA-149", new ComorbidityEntry("MCC-RENA-149", "RenalFailureMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-RENA-150", new ComorbidityEntry("MCC-RENA-150", "RenalFailureMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
