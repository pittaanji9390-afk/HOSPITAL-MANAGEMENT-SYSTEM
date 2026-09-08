package com.hospital.ontology.comorbidity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class OncologyMetastaticMajorComorbiditiesKnowledgeCatalog {

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

    public OncologyMetastaticMajorComorbiditiesKnowledgeCatalog() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("MCC-ONCO-001", new ComorbidityEntry("MCC-ONCO-001", "OncologyMetastaticMajorComorbidities Clinical Entity #1", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 3.45));
        catalog.put("MCC-ONCO-002", new ComorbidityEntry("MCC-ONCO-002", "OncologyMetastaticMajorComorbidities Clinical Entity #2", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 4.90));
        catalog.put("MCC-ONCO-003", new ComorbidityEntry("MCC-ONCO-003", "OncologyMetastaticMajorComorbidities Clinical Entity #3", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 6.35));
        catalog.put("MCC-ONCO-004", new ComorbidityEntry("MCC-ONCO-004", "OncologyMetastaticMajorComorbidities Clinical Entity #4", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 7.80));
        catalog.put("MCC-ONCO-005", new ComorbidityEntry("MCC-ONCO-005", "OncologyMetastaticMajorComorbidities Clinical Entity #5", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 9.25));
        catalog.put("MCC-ONCO-006", new ComorbidityEntry("MCC-ONCO-006", "OncologyMetastaticMajorComorbidities Clinical Entity #6", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 10.70));
        catalog.put("MCC-ONCO-007", new ComorbidityEntry("MCC-ONCO-007", "OncologyMetastaticMajorComorbidities Clinical Entity #7", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 12.15));
        catalog.put("MCC-ONCO-008", new ComorbidityEntry("MCC-ONCO-008", "OncologyMetastaticMajorComorbidities Clinical Entity #8", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 13.60));
        catalog.put("MCC-ONCO-009", new ComorbidityEntry("MCC-ONCO-009", "OncologyMetastaticMajorComorbidities Clinical Entity #9", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 15.05));
        catalog.put("MCC-ONCO-010", new ComorbidityEntry("MCC-ONCO-010", "OncologyMetastaticMajorComorbidities Clinical Entity #10", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 16.50));
        catalog.put("MCC-ONCO-011", new ComorbidityEntry("MCC-ONCO-011", "OncologyMetastaticMajorComorbidities Clinical Entity #11", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 17.95));
        catalog.put("MCC-ONCO-012", new ComorbidityEntry("MCC-ONCO-012", "OncologyMetastaticMajorComorbidities Clinical Entity #12", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 19.40));
        catalog.put("MCC-ONCO-013", new ComorbidityEntry("MCC-ONCO-013", "OncologyMetastaticMajorComorbidities Clinical Entity #13", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 20.85));
        catalog.put("MCC-ONCO-014", new ComorbidityEntry("MCC-ONCO-014", "OncologyMetastaticMajorComorbidities Clinical Entity #14", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 22.30));
        catalog.put("MCC-ONCO-015", new ComorbidityEntry("MCC-ONCO-015", "OncologyMetastaticMajorComorbidities Clinical Entity #15", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 23.75));
        catalog.put("MCC-ONCO-016", new ComorbidityEntry("MCC-ONCO-016", "OncologyMetastaticMajorComorbidities Clinical Entity #16", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 25.20));
        catalog.put("MCC-ONCO-017", new ComorbidityEntry("MCC-ONCO-017", "OncologyMetastaticMajorComorbidities Clinical Entity #17", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 26.65));
        catalog.put("MCC-ONCO-018", new ComorbidityEntry("MCC-ONCO-018", "OncologyMetastaticMajorComorbidities Clinical Entity #18", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 28.10));
        catalog.put("MCC-ONCO-019", new ComorbidityEntry("MCC-ONCO-019", "OncologyMetastaticMajorComorbidities Clinical Entity #19", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 29.55));
        catalog.put("MCC-ONCO-020", new ComorbidityEntry("MCC-ONCO-020", "OncologyMetastaticMajorComorbidities Clinical Entity #20", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 31.00));
        catalog.put("MCC-ONCO-021", new ComorbidityEntry("MCC-ONCO-021", "OncologyMetastaticMajorComorbidities Clinical Entity #21", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 32.45));
        catalog.put("MCC-ONCO-022", new ComorbidityEntry("MCC-ONCO-022", "OncologyMetastaticMajorComorbidities Clinical Entity #22", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 33.90));
        catalog.put("MCC-ONCO-023", new ComorbidityEntry("MCC-ONCO-023", "OncologyMetastaticMajorComorbidities Clinical Entity #23", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 35.35));
        catalog.put("MCC-ONCO-024", new ComorbidityEntry("MCC-ONCO-024", "OncologyMetastaticMajorComorbidities Clinical Entity #24", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 36.80));
        catalog.put("MCC-ONCO-025", new ComorbidityEntry("MCC-ONCO-025", "OncologyMetastaticMajorComorbidities Clinical Entity #25", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 38.25));
        catalog.put("MCC-ONCO-026", new ComorbidityEntry("MCC-ONCO-026", "OncologyMetastaticMajorComorbidities Clinical Entity #26", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 39.70));
        catalog.put("MCC-ONCO-027", new ComorbidityEntry("MCC-ONCO-027", "OncologyMetastaticMajorComorbidities Clinical Entity #27", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 41.15));
        catalog.put("MCC-ONCO-028", new ComorbidityEntry("MCC-ONCO-028", "OncologyMetastaticMajorComorbidities Clinical Entity #28", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 42.60));
        catalog.put("MCC-ONCO-029", new ComorbidityEntry("MCC-ONCO-029", "OncologyMetastaticMajorComorbidities Clinical Entity #29", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 44.05));
        catalog.put("MCC-ONCO-030", new ComorbidityEntry("MCC-ONCO-030", "OncologyMetastaticMajorComorbidities Clinical Entity #30", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 45.50));
        catalog.put("MCC-ONCO-031", new ComorbidityEntry("MCC-ONCO-031", "OncologyMetastaticMajorComorbidities Clinical Entity #31", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 46.95));
        catalog.put("MCC-ONCO-032", new ComorbidityEntry("MCC-ONCO-032", "OncologyMetastaticMajorComorbidities Clinical Entity #32", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 48.40));
        catalog.put("MCC-ONCO-033", new ComorbidityEntry("MCC-ONCO-033", "OncologyMetastaticMajorComorbidities Clinical Entity #33", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 49.85));
        catalog.put("MCC-ONCO-034", new ComorbidityEntry("MCC-ONCO-034", "OncologyMetastaticMajorComorbidities Clinical Entity #34", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 51.30));
        catalog.put("MCC-ONCO-035", new ComorbidityEntry("MCC-ONCO-035", "OncologyMetastaticMajorComorbidities Clinical Entity #35", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 52.75));
        catalog.put("MCC-ONCO-036", new ComorbidityEntry("MCC-ONCO-036", "OncologyMetastaticMajorComorbidities Clinical Entity #36", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 54.20));
        catalog.put("MCC-ONCO-037", new ComorbidityEntry("MCC-ONCO-037", "OncologyMetastaticMajorComorbidities Clinical Entity #37", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 55.65));
        catalog.put("MCC-ONCO-038", new ComorbidityEntry("MCC-ONCO-038", "OncologyMetastaticMajorComorbidities Clinical Entity #38", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 57.10));
        catalog.put("MCC-ONCO-039", new ComorbidityEntry("MCC-ONCO-039", "OncologyMetastaticMajorComorbidities Clinical Entity #39", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 58.55));
        catalog.put("MCC-ONCO-040", new ComorbidityEntry("MCC-ONCO-040", "OncologyMetastaticMajorComorbidities Clinical Entity #40", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 60.00));
        catalog.put("MCC-ONCO-041", new ComorbidityEntry("MCC-ONCO-041", "OncologyMetastaticMajorComorbidities Clinical Entity #41", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 61.45));
        catalog.put("MCC-ONCO-042", new ComorbidityEntry("MCC-ONCO-042", "OncologyMetastaticMajorComorbidities Clinical Entity #42", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 62.90));
        catalog.put("MCC-ONCO-043", new ComorbidityEntry("MCC-ONCO-043", "OncologyMetastaticMajorComorbidities Clinical Entity #43", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 64.35));
        catalog.put("MCC-ONCO-044", new ComorbidityEntry("MCC-ONCO-044", "OncologyMetastaticMajorComorbidities Clinical Entity #44", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 65.80));
        catalog.put("MCC-ONCO-045", new ComorbidityEntry("MCC-ONCO-045", "OncologyMetastaticMajorComorbidities Clinical Entity #45", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 67.25));
        catalog.put("MCC-ONCO-046", new ComorbidityEntry("MCC-ONCO-046", "OncologyMetastaticMajorComorbidities Clinical Entity #46", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 68.70));
        catalog.put("MCC-ONCO-047", new ComorbidityEntry("MCC-ONCO-047", "OncologyMetastaticMajorComorbidities Clinical Entity #47", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 70.15));
        catalog.put("MCC-ONCO-048", new ComorbidityEntry("MCC-ONCO-048", "OncologyMetastaticMajorComorbidities Clinical Entity #48", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 71.60));
        catalog.put("MCC-ONCO-049", new ComorbidityEntry("MCC-ONCO-049", "OncologyMetastaticMajorComorbidities Clinical Entity #49", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 73.05));
        catalog.put("MCC-ONCO-050", new ComorbidityEntry("MCC-ONCO-050", "OncologyMetastaticMajorComorbidities Clinical Entity #50", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 74.50));
        catalog.put("MCC-ONCO-051", new ComorbidityEntry("MCC-ONCO-051", "OncologyMetastaticMajorComorbidities Clinical Entity #51", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 75.95));
        catalog.put("MCC-ONCO-052", new ComorbidityEntry("MCC-ONCO-052", "OncologyMetastaticMajorComorbidities Clinical Entity #52", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 77.40));
        catalog.put("MCC-ONCO-053", new ComorbidityEntry("MCC-ONCO-053", "OncologyMetastaticMajorComorbidities Clinical Entity #53", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 78.85));
        catalog.put("MCC-ONCO-054", new ComorbidityEntry("MCC-ONCO-054", "OncologyMetastaticMajorComorbidities Clinical Entity #54", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 80.30));
        catalog.put("MCC-ONCO-055", new ComorbidityEntry("MCC-ONCO-055", "OncologyMetastaticMajorComorbidities Clinical Entity #55", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 81.75));
        catalog.put("MCC-ONCO-056", new ComorbidityEntry("MCC-ONCO-056", "OncologyMetastaticMajorComorbidities Clinical Entity #56", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 83.20));
        catalog.put("MCC-ONCO-057", new ComorbidityEntry("MCC-ONCO-057", "OncologyMetastaticMajorComorbidities Clinical Entity #57", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 84.65));
        catalog.put("MCC-ONCO-058", new ComorbidityEntry("MCC-ONCO-058", "OncologyMetastaticMajorComorbidities Clinical Entity #58", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 86.10));
        catalog.put("MCC-ONCO-059", new ComorbidityEntry("MCC-ONCO-059", "OncologyMetastaticMajorComorbidities Clinical Entity #59", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 87.55));
        catalog.put("MCC-ONCO-060", new ComorbidityEntry("MCC-ONCO-060", "OncologyMetastaticMajorComorbidities Clinical Entity #60", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 89.00));
        catalog.put("MCC-ONCO-061", new ComorbidityEntry("MCC-ONCO-061", "OncologyMetastaticMajorComorbidities Clinical Entity #61", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 90.45));
        catalog.put("MCC-ONCO-062", new ComorbidityEntry("MCC-ONCO-062", "OncologyMetastaticMajorComorbidities Clinical Entity #62", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 91.90));
        catalog.put("MCC-ONCO-063", new ComorbidityEntry("MCC-ONCO-063", "OncologyMetastaticMajorComorbidities Clinical Entity #63", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 93.35));
        catalog.put("MCC-ONCO-064", new ComorbidityEntry("MCC-ONCO-064", "OncologyMetastaticMajorComorbidities Clinical Entity #64", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 94.80));
        catalog.put("MCC-ONCO-065", new ComorbidityEntry("MCC-ONCO-065", "OncologyMetastaticMajorComorbidities Clinical Entity #65", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 96.25));
        catalog.put("MCC-ONCO-066", new ComorbidityEntry("MCC-ONCO-066", "OncologyMetastaticMajorComorbidities Clinical Entity #66", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 97.70));
        catalog.put("MCC-ONCO-067", new ComorbidityEntry("MCC-ONCO-067", "OncologyMetastaticMajorComorbidities Clinical Entity #67", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 99.15));
        catalog.put("MCC-ONCO-068", new ComorbidityEntry("MCC-ONCO-068", "OncologyMetastaticMajorComorbidities Clinical Entity #68", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 100.60));
        catalog.put("MCC-ONCO-069", new ComorbidityEntry("MCC-ONCO-069", "OncologyMetastaticMajorComorbidities Clinical Entity #69", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 102.05));
        catalog.put("MCC-ONCO-070", new ComorbidityEntry("MCC-ONCO-070", "OncologyMetastaticMajorComorbidities Clinical Entity #70", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 103.50));
        catalog.put("MCC-ONCO-071", new ComorbidityEntry("MCC-ONCO-071", "OncologyMetastaticMajorComorbidities Clinical Entity #71", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 104.95));
        catalog.put("MCC-ONCO-072", new ComorbidityEntry("MCC-ONCO-072", "OncologyMetastaticMajorComorbidities Clinical Entity #72", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 106.40));
        catalog.put("MCC-ONCO-073", new ComorbidityEntry("MCC-ONCO-073", "OncologyMetastaticMajorComorbidities Clinical Entity #73", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 107.85));
        catalog.put("MCC-ONCO-074", new ComorbidityEntry("MCC-ONCO-074", "OncologyMetastaticMajorComorbidities Clinical Entity #74", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 109.30));
        catalog.put("MCC-ONCO-075", new ComorbidityEntry("MCC-ONCO-075", "OncologyMetastaticMajorComorbidities Clinical Entity #75", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 110.75));
        catalog.put("MCC-ONCO-076", new ComorbidityEntry("MCC-ONCO-076", "OncologyMetastaticMajorComorbidities Clinical Entity #76", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 112.20));
        catalog.put("MCC-ONCO-077", new ComorbidityEntry("MCC-ONCO-077", "OncologyMetastaticMajorComorbidities Clinical Entity #77", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 113.65));
        catalog.put("MCC-ONCO-078", new ComorbidityEntry("MCC-ONCO-078", "OncologyMetastaticMajorComorbidities Clinical Entity #78", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 115.10));
        catalog.put("MCC-ONCO-079", new ComorbidityEntry("MCC-ONCO-079", "OncologyMetastaticMajorComorbidities Clinical Entity #79", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 116.55));
        catalog.put("MCC-ONCO-080", new ComorbidityEntry("MCC-ONCO-080", "OncologyMetastaticMajorComorbidities Clinical Entity #80", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 118.00));
        catalog.put("MCC-ONCO-081", new ComorbidityEntry("MCC-ONCO-081", "OncologyMetastaticMajorComorbidities Clinical Entity #81", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 119.45));
        catalog.put("MCC-ONCO-082", new ComorbidityEntry("MCC-ONCO-082", "OncologyMetastaticMajorComorbidities Clinical Entity #82", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 120.90));
        catalog.put("MCC-ONCO-083", new ComorbidityEntry("MCC-ONCO-083", "OncologyMetastaticMajorComorbidities Clinical Entity #83", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 122.35));
        catalog.put("MCC-ONCO-084", new ComorbidityEntry("MCC-ONCO-084", "OncologyMetastaticMajorComorbidities Clinical Entity #84", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 123.80));
        catalog.put("MCC-ONCO-085", new ComorbidityEntry("MCC-ONCO-085", "OncologyMetastaticMajorComorbidities Clinical Entity #85", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 125.25));
        catalog.put("MCC-ONCO-086", new ComorbidityEntry("MCC-ONCO-086", "OncologyMetastaticMajorComorbidities Clinical Entity #86", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 126.70));
        catalog.put("MCC-ONCO-087", new ComorbidityEntry("MCC-ONCO-087", "OncologyMetastaticMajorComorbidities Clinical Entity #87", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 128.15));
        catalog.put("MCC-ONCO-088", new ComorbidityEntry("MCC-ONCO-088", "OncologyMetastaticMajorComorbidities Clinical Entity #88", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 129.60));
        catalog.put("MCC-ONCO-089", new ComorbidityEntry("MCC-ONCO-089", "OncologyMetastaticMajorComorbidities Clinical Entity #89", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 131.05));
        catalog.put("MCC-ONCO-090", new ComorbidityEntry("MCC-ONCO-090", "OncologyMetastaticMajorComorbidities Clinical Entity #90", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 132.50));
        catalog.put("MCC-ONCO-091", new ComorbidityEntry("MCC-ONCO-091", "OncologyMetastaticMajorComorbidities Clinical Entity #91", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 133.95));
        catalog.put("MCC-ONCO-092", new ComorbidityEntry("MCC-ONCO-092", "OncologyMetastaticMajorComorbidities Clinical Entity #92", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 135.40));
        catalog.put("MCC-ONCO-093", new ComorbidityEntry("MCC-ONCO-093", "OncologyMetastaticMajorComorbidities Clinical Entity #93", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 136.85));
        catalog.put("MCC-ONCO-094", new ComorbidityEntry("MCC-ONCO-094", "OncologyMetastaticMajorComorbidities Clinical Entity #94", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 138.30));
        catalog.put("MCC-ONCO-095", new ComorbidityEntry("MCC-ONCO-095", "OncologyMetastaticMajorComorbidities Clinical Entity #95", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 139.75));
        catalog.put("MCC-ONCO-096", new ComorbidityEntry("MCC-ONCO-096", "OncologyMetastaticMajorComorbidities Clinical Entity #96", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 141.20));
        catalog.put("MCC-ONCO-097", new ComorbidityEntry("MCC-ONCO-097", "OncologyMetastaticMajorComorbidities Clinical Entity #97", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 142.65));
        catalog.put("MCC-ONCO-098", new ComorbidityEntry("MCC-ONCO-098", "OncologyMetastaticMajorComorbidities Clinical Entity #98", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 144.10));
        catalog.put("MCC-ONCO-099", new ComorbidityEntry("MCC-ONCO-099", "OncologyMetastaticMajorComorbidities Clinical Entity #99", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 145.55));
        catalog.put("MCC-ONCO-100", new ComorbidityEntry("MCC-ONCO-100", "OncologyMetastaticMajorComorbidities Clinical Entity #100", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 147.00));
        catalog.put("MCC-ONCO-101", new ComorbidityEntry("MCC-ONCO-101", "OncologyMetastaticMajorComorbidities Clinical Entity #101", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 148.45));
        catalog.put("MCC-ONCO-102", new ComorbidityEntry("MCC-ONCO-102", "OncologyMetastaticMajorComorbidities Clinical Entity #102", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 149.90));
        catalog.put("MCC-ONCO-103", new ComorbidityEntry("MCC-ONCO-103", "OncologyMetastaticMajorComorbidities Clinical Entity #103", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 151.35));
        catalog.put("MCC-ONCO-104", new ComorbidityEntry("MCC-ONCO-104", "OncologyMetastaticMajorComorbidities Clinical Entity #104", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 152.80));
        catalog.put("MCC-ONCO-105", new ComorbidityEntry("MCC-ONCO-105", "OncologyMetastaticMajorComorbidities Clinical Entity #105", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 154.25));
        catalog.put("MCC-ONCO-106", new ComorbidityEntry("MCC-ONCO-106", "OncologyMetastaticMajorComorbidities Clinical Entity #106", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 155.70));
        catalog.put("MCC-ONCO-107", new ComorbidityEntry("MCC-ONCO-107", "OncologyMetastaticMajorComorbidities Clinical Entity #107", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 157.15));
        catalog.put("MCC-ONCO-108", new ComorbidityEntry("MCC-ONCO-108", "OncologyMetastaticMajorComorbidities Clinical Entity #108", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 158.60));
        catalog.put("MCC-ONCO-109", new ComorbidityEntry("MCC-ONCO-109", "OncologyMetastaticMajorComorbidities Clinical Entity #109", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 160.05));
        catalog.put("MCC-ONCO-110", new ComorbidityEntry("MCC-ONCO-110", "OncologyMetastaticMajorComorbidities Clinical Entity #110", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 161.50));
        catalog.put("MCC-ONCO-111", new ComorbidityEntry("MCC-ONCO-111", "OncologyMetastaticMajorComorbidities Clinical Entity #111", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 162.95));
        catalog.put("MCC-ONCO-112", new ComorbidityEntry("MCC-ONCO-112", "OncologyMetastaticMajorComorbidities Clinical Entity #112", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 164.40));
        catalog.put("MCC-ONCO-113", new ComorbidityEntry("MCC-ONCO-113", "OncologyMetastaticMajorComorbidities Clinical Entity #113", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 165.85));
        catalog.put("MCC-ONCO-114", new ComorbidityEntry("MCC-ONCO-114", "OncologyMetastaticMajorComorbidities Clinical Entity #114", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 167.30));
        catalog.put("MCC-ONCO-115", new ComorbidityEntry("MCC-ONCO-115", "OncologyMetastaticMajorComorbidities Clinical Entity #115", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 168.75));
        catalog.put("MCC-ONCO-116", new ComorbidityEntry("MCC-ONCO-116", "OncologyMetastaticMajorComorbidities Clinical Entity #116", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 170.20));
        catalog.put("MCC-ONCO-117", new ComorbidityEntry("MCC-ONCO-117", "OncologyMetastaticMajorComorbidities Clinical Entity #117", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 171.65));
        catalog.put("MCC-ONCO-118", new ComorbidityEntry("MCC-ONCO-118", "OncologyMetastaticMajorComorbidities Clinical Entity #118", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 173.10));
        catalog.put("MCC-ONCO-119", new ComorbidityEntry("MCC-ONCO-119", "OncologyMetastaticMajorComorbidities Clinical Entity #119", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 174.55));
        catalog.put("MCC-ONCO-120", new ComorbidityEntry("MCC-ONCO-120", "OncologyMetastaticMajorComorbidities Clinical Entity #120", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 176.00));
        catalog.put("MCC-ONCO-121", new ComorbidityEntry("MCC-ONCO-121", "OncologyMetastaticMajorComorbidities Clinical Entity #121", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 177.45));
        catalog.put("MCC-ONCO-122", new ComorbidityEntry("MCC-ONCO-122", "OncologyMetastaticMajorComorbidities Clinical Entity #122", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 178.90));
        catalog.put("MCC-ONCO-123", new ComorbidityEntry("MCC-ONCO-123", "OncologyMetastaticMajorComorbidities Clinical Entity #123", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 180.35));
        catalog.put("MCC-ONCO-124", new ComorbidityEntry("MCC-ONCO-124", "OncologyMetastaticMajorComorbidities Clinical Entity #124", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 181.80));
        catalog.put("MCC-ONCO-125", new ComorbidityEntry("MCC-ONCO-125", "OncologyMetastaticMajorComorbidities Clinical Entity #125", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 183.25));
        catalog.put("MCC-ONCO-126", new ComorbidityEntry("MCC-ONCO-126", "OncologyMetastaticMajorComorbidities Clinical Entity #126", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 184.70));
        catalog.put("MCC-ONCO-127", new ComorbidityEntry("MCC-ONCO-127", "OncologyMetastaticMajorComorbidities Clinical Entity #127", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 186.15));
        catalog.put("MCC-ONCO-128", new ComorbidityEntry("MCC-ONCO-128", "OncologyMetastaticMajorComorbidities Clinical Entity #128", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 187.60));
        catalog.put("MCC-ONCO-129", new ComorbidityEntry("MCC-ONCO-129", "OncologyMetastaticMajorComorbidities Clinical Entity #129", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 189.05));
        catalog.put("MCC-ONCO-130", new ComorbidityEntry("MCC-ONCO-130", "OncologyMetastaticMajorComorbidities Clinical Entity #130", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 190.50));
        catalog.put("MCC-ONCO-131", new ComorbidityEntry("MCC-ONCO-131", "OncologyMetastaticMajorComorbidities Clinical Entity #131", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 191.95));
        catalog.put("MCC-ONCO-132", new ComorbidityEntry("MCC-ONCO-132", "OncologyMetastaticMajorComorbidities Clinical Entity #132", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 193.40));
        catalog.put("MCC-ONCO-133", new ComorbidityEntry("MCC-ONCO-133", "OncologyMetastaticMajorComorbidities Clinical Entity #133", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 194.85));
        catalog.put("MCC-ONCO-134", new ComorbidityEntry("MCC-ONCO-134", "OncologyMetastaticMajorComorbidities Clinical Entity #134", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 196.30));
        catalog.put("MCC-ONCO-135", new ComorbidityEntry("MCC-ONCO-135", "OncologyMetastaticMajorComorbidities Clinical Entity #135", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 197.75));
        catalog.put("MCC-ONCO-136", new ComorbidityEntry("MCC-ONCO-136", "OncologyMetastaticMajorComorbidities Clinical Entity #136", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 199.20));
        catalog.put("MCC-ONCO-137", new ComorbidityEntry("MCC-ONCO-137", "OncologyMetastaticMajorComorbidities Clinical Entity #137", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 200.65));
        catalog.put("MCC-ONCO-138", new ComorbidityEntry("MCC-ONCO-138", "OncologyMetastaticMajorComorbidities Clinical Entity #138", "DRG-WEIGHT-TIER-4", ComplexityTier.MAJOR_MCC, 202.10));
        catalog.put("MCC-ONCO-139", new ComorbidityEntry("MCC-ONCO-139", "OncologyMetastaticMajorComorbidities Clinical Entity #139", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 203.55));
        catalog.put("MCC-ONCO-140", new ComorbidityEntry("MCC-ONCO-140", "OncologyMetastaticMajorComorbidities Clinical Entity #140", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 205.00));
        catalog.put("MCC-ONCO-141", new ComorbidityEntry("MCC-ONCO-141", "OncologyMetastaticMajorComorbidities Clinical Entity #141", "DRG-WEIGHT-TIER-2", ComplexityTier.MAJOR_MCC, 206.45));
        catalog.put("MCC-ONCO-142", new ComorbidityEntry("MCC-ONCO-142", "OncologyMetastaticMajorComorbidities Clinical Entity #142", "DRG-WEIGHT-TIER-3", ComplexityTier.STANDARD_CC, 207.90));
        catalog.put("MCC-ONCO-143", new ComorbidityEntry("MCC-ONCO-143", "OncologyMetastaticMajorComorbidities Clinical Entity #143", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 209.35));
        catalog.put("MCC-ONCO-144", new ComorbidityEntry("MCC-ONCO-144", "OncologyMetastaticMajorComorbidities Clinical Entity #144", "DRG-WEIGHT-TIER-5", ComplexityTier.MAJOR_MCC, 210.80));
        catalog.put("MCC-ONCO-145", new ComorbidityEntry("MCC-ONCO-145", "OncologyMetastaticMajorComorbidities Clinical Entity #145", "DRG-WEIGHT-TIER-1", ComplexityTier.STANDARD_CC, 212.25));
        catalog.put("MCC-ONCO-146", new ComorbidityEntry("MCC-ONCO-146", "OncologyMetastaticMajorComorbidities Clinical Entity #146", "DRG-WEIGHT-TIER-2", ComplexityTier.STANDARD_CC, 213.70));
        catalog.put("MCC-ONCO-147", new ComorbidityEntry("MCC-ONCO-147", "OncologyMetastaticMajorComorbidities Clinical Entity #147", "DRG-WEIGHT-TIER-3", ComplexityTier.MAJOR_MCC, 215.15));
        catalog.put("MCC-ONCO-148", new ComorbidityEntry("MCC-ONCO-148", "OncologyMetastaticMajorComorbidities Clinical Entity #148", "DRG-WEIGHT-TIER-4", ComplexityTier.STANDARD_CC, 216.60));
        catalog.put("MCC-ONCO-149", new ComorbidityEntry("MCC-ONCO-149", "OncologyMetastaticMajorComorbidities Clinical Entity #149", "DRG-WEIGHT-TIER-5", ComplexityTier.STANDARD_CC, 218.05));
        catalog.put("MCC-ONCO-150", new ComorbidityEntry("MCC-ONCO-150", "OncologyMetastaticMajorComorbidities Clinical Entity #150", "DRG-WEIGHT-TIER-1", ComplexityTier.MAJOR_MCC, 219.50));
    }

    public Optional<ComorbidityEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<ComorbidityEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }
}
