package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class MetabolicAcidosisMajorComorbiditiesKnowledgeCatalog {

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

    public MetabolicAcidosisMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-META-001", new ComorbidityEntry("MCC-META-001", "MetabolicAcidosisMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-META-002", new ComorbidityEntry("MCC-META-002", "MetabolicAcidosisMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-META-003", new ComorbidityEntry("MCC-META-003", "MetabolicAcidosisMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-META-004", new ComorbidityEntry("MCC-META-004", "MetabolicAcidosisMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-META-005", new ComorbidityEntry("MCC-META-005", "MetabolicAcidosisMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-META-006", new ComorbidityEntry("MCC-META-006", "MetabolicAcidosisMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-META-007", new ComorbidityEntry("MCC-META-007", "MetabolicAcidosisMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-META-008", new ComorbidityEntry("MCC-META-008", "MetabolicAcidosisMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-META-009", new ComorbidityEntry("MCC-META-009", "MetabolicAcidosisMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-META-010", new ComorbidityEntry("MCC-META-010", "MetabolicAcidosisMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-META-011", new ComorbidityEntry("MCC-META-011", "MetabolicAcidosisMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-META-012", new ComorbidityEntry("MCC-META-012", "MetabolicAcidosisMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-META-013", new ComorbidityEntry("MCC-META-013", "MetabolicAcidosisMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-META-014", new ComorbidityEntry("MCC-META-014", "MetabolicAcidosisMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-META-015", new ComorbidityEntry("MCC-META-015", "MetabolicAcidosisMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-META-016", new ComorbidityEntry("MCC-META-016", "MetabolicAcidosisMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-META-017", new ComorbidityEntry("MCC-META-017", "MetabolicAcidosisMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-META-018", new ComorbidityEntry("MCC-META-018", "MetabolicAcidosisMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-META-019", new ComorbidityEntry("MCC-META-019", "MetabolicAcidosisMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-META-020", new ComorbidityEntry("MCC-META-020", "MetabolicAcidosisMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-META-021", new ComorbidityEntry("MCC-META-021", "MetabolicAcidosisMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-META-022", new ComorbidityEntry("MCC-META-022", "MetabolicAcidosisMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-META-023", new ComorbidityEntry("MCC-META-023", "MetabolicAcidosisMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-META-024", new ComorbidityEntry("MCC-META-024", "MetabolicAcidosisMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-META-025", new ComorbidityEntry("MCC-META-025", "MetabolicAcidosisMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-META-026", new ComorbidityEntry("MCC-META-026", "MetabolicAcidosisMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-META-027", new ComorbidityEntry("MCC-META-027", "MetabolicAcidosisMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-META-028", new ComorbidityEntry("MCC-META-028", "MetabolicAcidosisMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-META-029", new ComorbidityEntry("MCC-META-029", "MetabolicAcidosisMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-META-030", new ComorbidityEntry("MCC-META-030", "MetabolicAcidosisMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-META-031", new ComorbidityEntry("MCC-META-031", "MetabolicAcidosisMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-META-032", new ComorbidityEntry("MCC-META-032", "MetabolicAcidosisMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-META-033", new ComorbidityEntry("MCC-META-033", "MetabolicAcidosisMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-META-034", new ComorbidityEntry("MCC-META-034", "MetabolicAcidosisMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-META-035", new ComorbidityEntry("MCC-META-035", "MetabolicAcidosisMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-META-036", new ComorbidityEntry("MCC-META-036", "MetabolicAcidosisMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-META-037", new ComorbidityEntry("MCC-META-037", "MetabolicAcidosisMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-META-038", new ComorbidityEntry("MCC-META-038", "MetabolicAcidosisMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-META-039", new ComorbidityEntry("MCC-META-039", "MetabolicAcidosisMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-META-040", new ComorbidityEntry("MCC-META-040", "MetabolicAcidosisMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-META-041", new ComorbidityEntry("MCC-META-041", "MetabolicAcidosisMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-META-042", new ComorbidityEntry("MCC-META-042", "MetabolicAcidosisMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-META-043", new ComorbidityEntry("MCC-META-043", "MetabolicAcidosisMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-META-044", new ComorbidityEntry("MCC-META-044", "MetabolicAcidosisMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-META-045", new ComorbidityEntry("MCC-META-045", "MetabolicAcidosisMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-META-046", new ComorbidityEntry("MCC-META-046", "MetabolicAcidosisMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-META-047", new ComorbidityEntry("MCC-META-047", "MetabolicAcidosisMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-META-048", new ComorbidityEntry("MCC-META-048", "MetabolicAcidosisMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-META-049", new ComorbidityEntry("MCC-META-049", "MetabolicAcidosisMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-META-050", new ComorbidityEntry("MCC-META-050", "MetabolicAcidosisMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-META-051", new ComorbidityEntry("MCC-META-051", "MetabolicAcidosisMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-META-052", new ComorbidityEntry("MCC-META-052", "MetabolicAcidosisMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-META-053", new ComorbidityEntry("MCC-META-053", "MetabolicAcidosisMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-META-054", new ComorbidityEntry("MCC-META-054", "MetabolicAcidosisMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-META-055", new ComorbidityEntry("MCC-META-055", "MetabolicAcidosisMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-META-056", new ComorbidityEntry("MCC-META-056", "MetabolicAcidosisMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-META-057", new ComorbidityEntry("MCC-META-057", "MetabolicAcidosisMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-META-058", new ComorbidityEntry("MCC-META-058", "MetabolicAcidosisMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-META-059", new ComorbidityEntry("MCC-META-059", "MetabolicAcidosisMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-META-060", new ComorbidityEntry("MCC-META-060", "MetabolicAcidosisMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-META-061", new ComorbidityEntry("MCC-META-061", "MetabolicAcidosisMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-META-062", new ComorbidityEntry("MCC-META-062", "MetabolicAcidosisMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-META-063", new ComorbidityEntry("MCC-META-063", "MetabolicAcidosisMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-META-064", new ComorbidityEntry("MCC-META-064", "MetabolicAcidosisMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-META-065", new ComorbidityEntry("MCC-META-065", "MetabolicAcidosisMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-META-066", new ComorbidityEntry("MCC-META-066", "MetabolicAcidosisMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-META-067", new ComorbidityEntry("MCC-META-067", "MetabolicAcidosisMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-META-068", new ComorbidityEntry("MCC-META-068", "MetabolicAcidosisMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-META-069", new ComorbidityEntry("MCC-META-069", "MetabolicAcidosisMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-META-070", new ComorbidityEntry("MCC-META-070", "MetabolicAcidosisMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-META-071", new ComorbidityEntry("MCC-META-071", "MetabolicAcidosisMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-META-072", new ComorbidityEntry("MCC-META-072", "MetabolicAcidosisMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-META-073", new ComorbidityEntry("MCC-META-073", "MetabolicAcidosisMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-META-074", new ComorbidityEntry("MCC-META-074", "MetabolicAcidosisMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-META-075", new ComorbidityEntry("MCC-META-075", "MetabolicAcidosisMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-META-076", new ComorbidityEntry("MCC-META-076", "MetabolicAcidosisMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-META-077", new ComorbidityEntry("MCC-META-077", "MetabolicAcidosisMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-META-078", new ComorbidityEntry("MCC-META-078", "MetabolicAcidosisMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-META-079", new ComorbidityEntry("MCC-META-079", "MetabolicAcidosisMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-META-080", new ComorbidityEntry("MCC-META-080", "MetabolicAcidosisMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-META-081", new ComorbidityEntry("MCC-META-081", "MetabolicAcidosisMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-META-082", new ComorbidityEntry("MCC-META-082", "MetabolicAcidosisMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-META-083", new ComorbidityEntry("MCC-META-083", "MetabolicAcidosisMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-META-084", new ComorbidityEntry("MCC-META-084", "MetabolicAcidosisMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-META-085", new ComorbidityEntry("MCC-META-085", "MetabolicAcidosisMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-META-086", new ComorbidityEntry("MCC-META-086", "MetabolicAcidosisMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-META-087", new ComorbidityEntry("MCC-META-087", "MetabolicAcidosisMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-META-088", new ComorbidityEntry("MCC-META-088", "MetabolicAcidosisMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-META-089", new ComorbidityEntry("MCC-META-089", "MetabolicAcidosisMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-META-090", new ComorbidityEntry("MCC-META-090", "MetabolicAcidosisMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-META-091", new ComorbidityEntry("MCC-META-091", "MetabolicAcidosisMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-META-092", new ComorbidityEntry("MCC-META-092", "MetabolicAcidosisMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-META-093", new ComorbidityEntry("MCC-META-093", "MetabolicAcidosisMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-META-094", new ComorbidityEntry("MCC-META-094", "MetabolicAcidosisMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-META-095", new ComorbidityEntry("MCC-META-095", "MetabolicAcidosisMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-META-096", new ComorbidityEntry("MCC-META-096", "MetabolicAcidosisMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-META-097", new ComorbidityEntry("MCC-META-097", "MetabolicAcidosisMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-META-098", new ComorbidityEntry("MCC-META-098", "MetabolicAcidosisMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-META-099", new ComorbidityEntry("MCC-META-099", "MetabolicAcidosisMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-META-100", new ComorbidityEntry("MCC-META-100", "MetabolicAcidosisMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-META-101", new ComorbidityEntry("MCC-META-101", "MetabolicAcidosisMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-META-102", new ComorbidityEntry("MCC-META-102", "MetabolicAcidosisMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-META-103", new ComorbidityEntry("MCC-META-103", "MetabolicAcidosisMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-META-104", new ComorbidityEntry("MCC-META-104", "MetabolicAcidosisMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-META-105", new ComorbidityEntry("MCC-META-105", "MetabolicAcidosisMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-META-106", new ComorbidityEntry("MCC-META-106", "MetabolicAcidosisMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-META-107", new ComorbidityEntry("MCC-META-107", "MetabolicAcidosisMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-META-108", new ComorbidityEntry("MCC-META-108", "MetabolicAcidosisMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-META-109", new ComorbidityEntry("MCC-META-109", "MetabolicAcidosisMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-META-110", new ComorbidityEntry("MCC-META-110", "MetabolicAcidosisMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-META-111", new ComorbidityEntry("MCC-META-111", "MetabolicAcidosisMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-META-112", new ComorbidityEntry("MCC-META-112", "MetabolicAcidosisMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-META-113", new ComorbidityEntry("MCC-META-113", "MetabolicAcidosisMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-META-114", new ComorbidityEntry("MCC-META-114", "MetabolicAcidosisMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-META-115", new ComorbidityEntry("MCC-META-115", "MetabolicAcidosisMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-META-116", new ComorbidityEntry("MCC-META-116", "MetabolicAcidosisMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-META-117", new ComorbidityEntry("MCC-META-117", "MetabolicAcidosisMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-META-118", new ComorbidityEntry("MCC-META-118", "MetabolicAcidosisMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-META-119", new ComorbidityEntry("MCC-META-119", "MetabolicAcidosisMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-META-120", new ComorbidityEntry("MCC-META-120", "MetabolicAcidosisMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-META-121", new ComorbidityEntry("MCC-META-121", "MetabolicAcidosisMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-META-122", new ComorbidityEntry("MCC-META-122", "MetabolicAcidosisMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-META-123", new ComorbidityEntry("MCC-META-123", "MetabolicAcidosisMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-META-124", new ComorbidityEntry("MCC-META-124", "MetabolicAcidosisMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-META-125", new ComorbidityEntry("MCC-META-125", "MetabolicAcidosisMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-META-126", new ComorbidityEntry("MCC-META-126", "MetabolicAcidosisMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-META-127", new ComorbidityEntry("MCC-META-127", "MetabolicAcidosisMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-META-128", new ComorbidityEntry("MCC-META-128", "MetabolicAcidosisMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-META-129", new ComorbidityEntry("MCC-META-129", "MetabolicAcidosisMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-META-130", new ComorbidityEntry("MCC-META-130", "MetabolicAcidosisMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-META-131", new ComorbidityEntry("MCC-META-131", "MetabolicAcidosisMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-META-132", new ComorbidityEntry("MCC-META-132", "MetabolicAcidosisMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-META-133", new ComorbidityEntry("MCC-META-133", "MetabolicAcidosisMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-META-134", new ComorbidityEntry("MCC-META-134", "MetabolicAcidosisMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-META-135", new ComorbidityEntry("MCC-META-135", "MetabolicAcidosisMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-META-136", new ComorbidityEntry("MCC-META-136", "MetabolicAcidosisMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-META-137", new ComorbidityEntry("MCC-META-137", "MetabolicAcidosisMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-META-138", new ComorbidityEntry("MCC-META-138", "MetabolicAcidosisMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-META-139", new ComorbidityEntry("MCC-META-139", "MetabolicAcidosisMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-META-140", new ComorbidityEntry("MCC-META-140", "MetabolicAcidosisMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-META-141", new ComorbidityEntry("MCC-META-141", "MetabolicAcidosisMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-META-142", new ComorbidityEntry("MCC-META-142", "MetabolicAcidosisMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-META-143", new ComorbidityEntry("MCC-META-143", "MetabolicAcidosisMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-META-144", new ComorbidityEntry("MCC-META-144", "MetabolicAcidosisMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-META-145", new ComorbidityEntry("MCC-META-145", "MetabolicAcidosisMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-META-146", new ComorbidityEntry("MCC-META-146", "MetabolicAcidosisMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-META-147", new ComorbidityEntry("MCC-META-147", "MetabolicAcidosisMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-META-148", new ComorbidityEntry("MCC-META-148", "MetabolicAcidosisMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-META-149", new ComorbidityEntry("MCC-META-149", "MetabolicAcidosisMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-META-150", new ComorbidityEntry("MCC-META-150", "MetabolicAcidosisMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
