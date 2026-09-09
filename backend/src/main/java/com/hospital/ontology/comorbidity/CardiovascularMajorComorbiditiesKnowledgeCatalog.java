package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CardiovascularMajorComorbiditiesKnowledgeCatalog {

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

    public CardiovascularMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-CARD-001", new ComorbidityEntry("MCC-CARD-001", "CardiovascularMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-CARD-002", new ComorbidityEntry("MCC-CARD-002", "CardiovascularMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-CARD-003", new ComorbidityEntry("MCC-CARD-003", "CardiovascularMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-CARD-004", new ComorbidityEntry("MCC-CARD-004", "CardiovascularMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-CARD-005", new ComorbidityEntry("MCC-CARD-005", "CardiovascularMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-CARD-006", new ComorbidityEntry("MCC-CARD-006", "CardiovascularMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-CARD-007", new ComorbidityEntry("MCC-CARD-007", "CardiovascularMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-CARD-008", new ComorbidityEntry("MCC-CARD-008", "CardiovascularMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-CARD-009", new ComorbidityEntry("MCC-CARD-009", "CardiovascularMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-CARD-010", new ComorbidityEntry("MCC-CARD-010", "CardiovascularMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-CARD-011", new ComorbidityEntry("MCC-CARD-011", "CardiovascularMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-CARD-012", new ComorbidityEntry("MCC-CARD-012", "CardiovascularMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-CARD-013", new ComorbidityEntry("MCC-CARD-013", "CardiovascularMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-CARD-014", new ComorbidityEntry("MCC-CARD-014", "CardiovascularMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-CARD-015", new ComorbidityEntry("MCC-CARD-015", "CardiovascularMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-CARD-016", new ComorbidityEntry("MCC-CARD-016", "CardiovascularMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-CARD-017", new ComorbidityEntry("MCC-CARD-017", "CardiovascularMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-CARD-018", new ComorbidityEntry("MCC-CARD-018", "CardiovascularMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-CARD-019", new ComorbidityEntry("MCC-CARD-019", "CardiovascularMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-CARD-020", new ComorbidityEntry("MCC-CARD-020", "CardiovascularMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-CARD-021", new ComorbidityEntry("MCC-CARD-021", "CardiovascularMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-CARD-022", new ComorbidityEntry("MCC-CARD-022", "CardiovascularMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-CARD-023", new ComorbidityEntry("MCC-CARD-023", "CardiovascularMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-CARD-024", new ComorbidityEntry("MCC-CARD-024", "CardiovascularMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-CARD-025", new ComorbidityEntry("MCC-CARD-025", "CardiovascularMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-CARD-026", new ComorbidityEntry("MCC-CARD-026", "CardiovascularMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-CARD-027", new ComorbidityEntry("MCC-CARD-027", "CardiovascularMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-CARD-028", new ComorbidityEntry("MCC-CARD-028", "CardiovascularMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-CARD-029", new ComorbidityEntry("MCC-CARD-029", "CardiovascularMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-CARD-030", new ComorbidityEntry("MCC-CARD-030", "CardiovascularMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-CARD-031", new ComorbidityEntry("MCC-CARD-031", "CardiovascularMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-CARD-032", new ComorbidityEntry("MCC-CARD-032", "CardiovascularMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-CARD-033", new ComorbidityEntry("MCC-CARD-033", "CardiovascularMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-CARD-034", new ComorbidityEntry("MCC-CARD-034", "CardiovascularMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-CARD-035", new ComorbidityEntry("MCC-CARD-035", "CardiovascularMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-CARD-036", new ComorbidityEntry("MCC-CARD-036", "CardiovascularMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-CARD-037", new ComorbidityEntry("MCC-CARD-037", "CardiovascularMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-CARD-038", new ComorbidityEntry("MCC-CARD-038", "CardiovascularMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-CARD-039", new ComorbidityEntry("MCC-CARD-039", "CardiovascularMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-CARD-040", new ComorbidityEntry("MCC-CARD-040", "CardiovascularMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-CARD-041", new ComorbidityEntry("MCC-CARD-041", "CardiovascularMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-CARD-042", new ComorbidityEntry("MCC-CARD-042", "CardiovascularMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-CARD-043", new ComorbidityEntry("MCC-CARD-043", "CardiovascularMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-CARD-044", new ComorbidityEntry("MCC-CARD-044", "CardiovascularMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-CARD-045", new ComorbidityEntry("MCC-CARD-045", "CardiovascularMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-CARD-046", new ComorbidityEntry("MCC-CARD-046", "CardiovascularMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-CARD-047", new ComorbidityEntry("MCC-CARD-047", "CardiovascularMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-CARD-048", new ComorbidityEntry("MCC-CARD-048", "CardiovascularMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-CARD-049", new ComorbidityEntry("MCC-CARD-049", "CardiovascularMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-CARD-050", new ComorbidityEntry("MCC-CARD-050", "CardiovascularMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-CARD-051", new ComorbidityEntry("MCC-CARD-051", "CardiovascularMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-CARD-052", new ComorbidityEntry("MCC-CARD-052", "CardiovascularMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-CARD-053", new ComorbidityEntry("MCC-CARD-053", "CardiovascularMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-CARD-054", new ComorbidityEntry("MCC-CARD-054", "CardiovascularMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-CARD-055", new ComorbidityEntry("MCC-CARD-055", "CardiovascularMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-CARD-056", new ComorbidityEntry("MCC-CARD-056", "CardiovascularMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-CARD-057", new ComorbidityEntry("MCC-CARD-057", "CardiovascularMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-CARD-058", new ComorbidityEntry("MCC-CARD-058", "CardiovascularMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-CARD-059", new ComorbidityEntry("MCC-CARD-059", "CardiovascularMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-CARD-060", new ComorbidityEntry("MCC-CARD-060", "CardiovascularMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-CARD-061", new ComorbidityEntry("MCC-CARD-061", "CardiovascularMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-CARD-062", new ComorbidityEntry("MCC-CARD-062", "CardiovascularMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-CARD-063", new ComorbidityEntry("MCC-CARD-063", "CardiovascularMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-CARD-064", new ComorbidityEntry("MCC-CARD-064", "CardiovascularMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-CARD-065", new ComorbidityEntry("MCC-CARD-065", "CardiovascularMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-CARD-066", new ComorbidityEntry("MCC-CARD-066", "CardiovascularMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-CARD-067", new ComorbidityEntry("MCC-CARD-067", "CardiovascularMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-CARD-068", new ComorbidityEntry("MCC-CARD-068", "CardiovascularMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-CARD-069", new ComorbidityEntry("MCC-CARD-069", "CardiovascularMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-CARD-070", new ComorbidityEntry("MCC-CARD-070", "CardiovascularMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-CARD-071", new ComorbidityEntry("MCC-CARD-071", "CardiovascularMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-CARD-072", new ComorbidityEntry("MCC-CARD-072", "CardiovascularMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-CARD-073", new ComorbidityEntry("MCC-CARD-073", "CardiovascularMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-CARD-074", new ComorbidityEntry("MCC-CARD-074", "CardiovascularMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-CARD-075", new ComorbidityEntry("MCC-CARD-075", "CardiovascularMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-CARD-076", new ComorbidityEntry("MCC-CARD-076", "CardiovascularMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-CARD-077", new ComorbidityEntry("MCC-CARD-077", "CardiovascularMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-CARD-078", new ComorbidityEntry("MCC-CARD-078", "CardiovascularMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-CARD-079", new ComorbidityEntry("MCC-CARD-079", "CardiovascularMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-CARD-080", new ComorbidityEntry("MCC-CARD-080", "CardiovascularMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-CARD-081", new ComorbidityEntry("MCC-CARD-081", "CardiovascularMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-CARD-082", new ComorbidityEntry("MCC-CARD-082", "CardiovascularMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-CARD-083", new ComorbidityEntry("MCC-CARD-083", "CardiovascularMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-CARD-084", new ComorbidityEntry("MCC-CARD-084", "CardiovascularMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-CARD-085", new ComorbidityEntry("MCC-CARD-085", "CardiovascularMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-CARD-086", new ComorbidityEntry("MCC-CARD-086", "CardiovascularMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-CARD-087", new ComorbidityEntry("MCC-CARD-087", "CardiovascularMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-CARD-088", new ComorbidityEntry("MCC-CARD-088", "CardiovascularMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-CARD-089", new ComorbidityEntry("MCC-CARD-089", "CardiovascularMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-CARD-090", new ComorbidityEntry("MCC-CARD-090", "CardiovascularMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-CARD-091", new ComorbidityEntry("MCC-CARD-091", "CardiovascularMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-CARD-092", new ComorbidityEntry("MCC-CARD-092", "CardiovascularMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-CARD-093", new ComorbidityEntry("MCC-CARD-093", "CardiovascularMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-CARD-094", new ComorbidityEntry("MCC-CARD-094", "CardiovascularMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-CARD-095", new ComorbidityEntry("MCC-CARD-095", "CardiovascularMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-CARD-096", new ComorbidityEntry("MCC-CARD-096", "CardiovascularMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-CARD-097", new ComorbidityEntry("MCC-CARD-097", "CardiovascularMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-CARD-098", new ComorbidityEntry("MCC-CARD-098", "CardiovascularMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-CARD-099", new ComorbidityEntry("MCC-CARD-099", "CardiovascularMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-CARD-100", new ComorbidityEntry("MCC-CARD-100", "CardiovascularMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-CARD-101", new ComorbidityEntry("MCC-CARD-101", "CardiovascularMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-CARD-102", new ComorbidityEntry("MCC-CARD-102", "CardiovascularMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-CARD-103", new ComorbidityEntry("MCC-CARD-103", "CardiovascularMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-CARD-104", new ComorbidityEntry("MCC-CARD-104", "CardiovascularMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-CARD-105", new ComorbidityEntry("MCC-CARD-105", "CardiovascularMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-CARD-106", new ComorbidityEntry("MCC-CARD-106", "CardiovascularMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-CARD-107", new ComorbidityEntry("MCC-CARD-107", "CardiovascularMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-CARD-108", new ComorbidityEntry("MCC-CARD-108", "CardiovascularMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-CARD-109", new ComorbidityEntry("MCC-CARD-109", "CardiovascularMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-CARD-110", new ComorbidityEntry("MCC-CARD-110", "CardiovascularMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-CARD-111", new ComorbidityEntry("MCC-CARD-111", "CardiovascularMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-CARD-112", new ComorbidityEntry("MCC-CARD-112", "CardiovascularMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-CARD-113", new ComorbidityEntry("MCC-CARD-113", "CardiovascularMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-CARD-114", new ComorbidityEntry("MCC-CARD-114", "CardiovascularMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-CARD-115", new ComorbidityEntry("MCC-CARD-115", "CardiovascularMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-CARD-116", new ComorbidityEntry("MCC-CARD-116", "CardiovascularMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-CARD-117", new ComorbidityEntry("MCC-CARD-117", "CardiovascularMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-CARD-118", new ComorbidityEntry("MCC-CARD-118", "CardiovascularMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-CARD-119", new ComorbidityEntry("MCC-CARD-119", "CardiovascularMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-CARD-120", new ComorbidityEntry("MCC-CARD-120", "CardiovascularMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-CARD-121", new ComorbidityEntry("MCC-CARD-121", "CardiovascularMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-CARD-122", new ComorbidityEntry("MCC-CARD-122", "CardiovascularMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-CARD-123", new ComorbidityEntry("MCC-CARD-123", "CardiovascularMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-CARD-124", new ComorbidityEntry("MCC-CARD-124", "CardiovascularMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-CARD-125", new ComorbidityEntry("MCC-CARD-125", "CardiovascularMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-CARD-126", new ComorbidityEntry("MCC-CARD-126", "CardiovascularMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-CARD-127", new ComorbidityEntry("MCC-CARD-127", "CardiovascularMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-CARD-128", new ComorbidityEntry("MCC-CARD-128", "CardiovascularMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-CARD-129", new ComorbidityEntry("MCC-CARD-129", "CardiovascularMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-CARD-130", new ComorbidityEntry("MCC-CARD-130", "CardiovascularMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-CARD-131", new ComorbidityEntry("MCC-CARD-131", "CardiovascularMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-CARD-132", new ComorbidityEntry("MCC-CARD-132", "CardiovascularMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-CARD-133", new ComorbidityEntry("MCC-CARD-133", "CardiovascularMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-CARD-134", new ComorbidityEntry("MCC-CARD-134", "CardiovascularMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-CARD-135", new ComorbidityEntry("MCC-CARD-135", "CardiovascularMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-CARD-136", new ComorbidityEntry("MCC-CARD-136", "CardiovascularMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-CARD-137", new ComorbidityEntry("MCC-CARD-137", "CardiovascularMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-CARD-138", new ComorbidityEntry("MCC-CARD-138", "CardiovascularMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-CARD-139", new ComorbidityEntry("MCC-CARD-139", "CardiovascularMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-CARD-140", new ComorbidityEntry("MCC-CARD-140", "CardiovascularMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-CARD-141", new ComorbidityEntry("MCC-CARD-141", "CardiovascularMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-CARD-142", new ComorbidityEntry("MCC-CARD-142", "CardiovascularMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-CARD-143", new ComorbidityEntry("MCC-CARD-143", "CardiovascularMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-CARD-144", new ComorbidityEntry("MCC-CARD-144", "CardiovascularMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-CARD-145", new ComorbidityEntry("MCC-CARD-145", "CardiovascularMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-CARD-146", new ComorbidityEntry("MCC-CARD-146", "CardiovascularMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-CARD-147", new ComorbidityEntry("MCC-CARD-147", "CardiovascularMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-CARD-148", new ComorbidityEntry("MCC-CARD-148", "CardiovascularMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-CARD-149", new ComorbidityEntry("MCC-CARD-149", "CardiovascularMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-CARD-150", new ComorbidityEntry("MCC-CARD-150", "CardiovascularMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
