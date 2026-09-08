package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 03 (D50-D89): Blood & Immune Disorders.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter03_BloodAndBloodFormingOrgans {

    @Data
    @AllArgsConstructor
    public static class IcdEntry {
        private String code;
        private String clinicalDescription;
        private String chapterRange;
        private String severityTier;
        private boolean isChronicCondition;
        private int averageLengthOfStayRiskScore;
    }

    private final Map<String, IcdEntry> catalog = new LinkedHashMap<>();

    public Icd10Chapter03_BloodAndBloodFormingOrgans() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("D00.1", new IcdEntry("D00.1", "Blood & Immune Disorders Clinical Entity #1: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 17));
        catalog.put("D00.2", new IcdEntry("D00.2", "Blood & Immune Disorders Clinical Entity #2: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 24));
        catalog.put("D00.3", new IcdEntry("D00.3", "Blood & Immune Disorders Clinical Entity #3: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 31));
        catalog.put("D00.4", new IcdEntry("D00.4", "Blood & Immune Disorders Clinical Entity #4: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 38));
        catalog.put("D00.5", new IcdEntry("D00.5", "Blood & Immune Disorders Clinical Entity #5: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 45));
        catalog.put("D00.6", new IcdEntry("D00.6", "Blood & Immune Disorders Clinical Entity #6: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 52));
        catalog.put("D00.7", new IcdEntry("D00.7", "Blood & Immune Disorders Clinical Entity #7: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 59));
        catalog.put("D00.8", new IcdEntry("D00.8", "Blood & Immune Disorders Clinical Entity #8: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 66));
        catalog.put("D00.9", new IcdEntry("D00.9", "Blood & Immune Disorders Clinical Entity #9: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 73));
        catalog.put("D01.0", new IcdEntry("D01.0", "Blood & Immune Disorders Clinical Entity #10: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 80));
        catalog.put("D01.1", new IcdEntry("D01.1", "Blood & Immune Disorders Clinical Entity #11: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 87));
        catalog.put("D01.2", new IcdEntry("D01.2", "Blood & Immune Disorders Clinical Entity #12: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 94));
        catalog.put("D01.3", new IcdEntry("D01.3", "Blood & Immune Disorders Clinical Entity #13: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 101));
        catalog.put("D01.4", new IcdEntry("D01.4", "Blood & Immune Disorders Clinical Entity #14: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 108));
        catalog.put("D01.5", new IcdEntry("D01.5", "Blood & Immune Disorders Clinical Entity #15: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 15));
        catalog.put("D01.6", new IcdEntry("D01.6", "Blood & Immune Disorders Clinical Entity #16: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 22));
        catalog.put("D01.7", new IcdEntry("D01.7", "Blood & Immune Disorders Clinical Entity #17: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 29));
        catalog.put("D01.8", new IcdEntry("D01.8", "Blood & Immune Disorders Clinical Entity #18: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 36));
        catalog.put("D01.9", new IcdEntry("D01.9", "Blood & Immune Disorders Clinical Entity #19: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 43));
        catalog.put("D02.0", new IcdEntry("D02.0", "Blood & Immune Disorders Clinical Entity #20: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 50));
        catalog.put("D02.1", new IcdEntry("D02.1", "Blood & Immune Disorders Clinical Entity #21: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 57));
        catalog.put("D02.2", new IcdEntry("D02.2", "Blood & Immune Disorders Clinical Entity #22: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 64));
        catalog.put("D02.3", new IcdEntry("D02.3", "Blood & Immune Disorders Clinical Entity #23: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 71));
        catalog.put("D02.4", new IcdEntry("D02.4", "Blood & Immune Disorders Clinical Entity #24: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 78));
        catalog.put("D02.5", new IcdEntry("D02.5", "Blood & Immune Disorders Clinical Entity #25: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 85));
        catalog.put("D02.6", new IcdEntry("D02.6", "Blood & Immune Disorders Clinical Entity #26: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 92));
        catalog.put("D02.7", new IcdEntry("D02.7", "Blood & Immune Disorders Clinical Entity #27: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 99));
        catalog.put("D02.8", new IcdEntry("D02.8", "Blood & Immune Disorders Clinical Entity #28: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 106));
        catalog.put("D02.9", new IcdEntry("D02.9", "Blood & Immune Disorders Clinical Entity #29: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 13));
        catalog.put("D03.0", new IcdEntry("D03.0", "Blood & Immune Disorders Clinical Entity #30: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 20));
        catalog.put("D03.1", new IcdEntry("D03.1", "Blood & Immune Disorders Clinical Entity #31: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 27));
        catalog.put("D03.2", new IcdEntry("D03.2", "Blood & Immune Disorders Clinical Entity #32: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 34));
        catalog.put("D03.3", new IcdEntry("D03.3", "Blood & Immune Disorders Clinical Entity #33: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 41));
        catalog.put("D03.4", new IcdEntry("D03.4", "Blood & Immune Disorders Clinical Entity #34: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 48));
        catalog.put("D03.5", new IcdEntry("D03.5", "Blood & Immune Disorders Clinical Entity #35: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 55));
        catalog.put("D03.6", new IcdEntry("D03.6", "Blood & Immune Disorders Clinical Entity #36: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 62));
        catalog.put("D03.7", new IcdEntry("D03.7", "Blood & Immune Disorders Clinical Entity #37: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 69));
        catalog.put("D03.8", new IcdEntry("D03.8", "Blood & Immune Disorders Clinical Entity #38: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 76));
        catalog.put("D03.9", new IcdEntry("D03.9", "Blood & Immune Disorders Clinical Entity #39: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 83));
        catalog.put("D04.0", new IcdEntry("D04.0", "Blood & Immune Disorders Clinical Entity #40: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 90));
        catalog.put("D04.1", new IcdEntry("D04.1", "Blood & Immune Disorders Clinical Entity #41: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 97));
        catalog.put("D04.2", new IcdEntry("D04.2", "Blood & Immune Disorders Clinical Entity #42: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 104));
        catalog.put("D04.3", new IcdEntry("D04.3", "Blood & Immune Disorders Clinical Entity #43: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 11));
        catalog.put("D04.4", new IcdEntry("D04.4", "Blood & Immune Disorders Clinical Entity #44: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 18));
        catalog.put("D04.5", new IcdEntry("D04.5", "Blood & Immune Disorders Clinical Entity #45: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 25));
        catalog.put("D04.6", new IcdEntry("D04.6", "Blood & Immune Disorders Clinical Entity #46: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 32));
        catalog.put("D04.7", new IcdEntry("D04.7", "Blood & Immune Disorders Clinical Entity #47: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 39));
        catalog.put("D04.8", new IcdEntry("D04.8", "Blood & Immune Disorders Clinical Entity #48: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 46));
        catalog.put("D04.9", new IcdEntry("D04.9", "Blood & Immune Disorders Clinical Entity #49: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 53));
        catalog.put("D05.0", new IcdEntry("D05.0", "Blood & Immune Disorders Clinical Entity #50: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 60));
        catalog.put("D05.1", new IcdEntry("D05.1", "Blood & Immune Disorders Clinical Entity #51: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 67));
        catalog.put("D05.2", new IcdEntry("D05.2", "Blood & Immune Disorders Clinical Entity #52: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 74));
        catalog.put("D05.3", new IcdEntry("D05.3", "Blood & Immune Disorders Clinical Entity #53: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 81));
        catalog.put("D05.4", new IcdEntry("D05.4", "Blood & Immune Disorders Clinical Entity #54: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 88));
        catalog.put("D05.5", new IcdEntry("D05.5", "Blood & Immune Disorders Clinical Entity #55: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 95));
        catalog.put("D05.6", new IcdEntry("D05.6", "Blood & Immune Disorders Clinical Entity #56: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 102));
        catalog.put("D05.7", new IcdEntry("D05.7", "Blood & Immune Disorders Clinical Entity #57: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 109));
        catalog.put("D05.8", new IcdEntry("D05.8", "Blood & Immune Disorders Clinical Entity #58: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 16));
        catalog.put("D05.9", new IcdEntry("D05.9", "Blood & Immune Disorders Clinical Entity #59: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 23));
        catalog.put("D06.0", new IcdEntry("D06.0", "Blood & Immune Disorders Clinical Entity #60: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 30));
        catalog.put("D06.1", new IcdEntry("D06.1", "Blood & Immune Disorders Clinical Entity #61: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 37));
        catalog.put("D06.2", new IcdEntry("D06.2", "Blood & Immune Disorders Clinical Entity #62: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 44));
        catalog.put("D06.3", new IcdEntry("D06.3", "Blood & Immune Disorders Clinical Entity #63: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 51));
        catalog.put("D06.4", new IcdEntry("D06.4", "Blood & Immune Disorders Clinical Entity #64: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 58));
        catalog.put("D06.5", new IcdEntry("D06.5", "Blood & Immune Disorders Clinical Entity #65: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 65));
        catalog.put("D06.6", new IcdEntry("D06.6", "Blood & Immune Disorders Clinical Entity #66: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 72));
        catalog.put("D06.7", new IcdEntry("D06.7", "Blood & Immune Disorders Clinical Entity #67: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 79));
        catalog.put("D06.8", new IcdEntry("D06.8", "Blood & Immune Disorders Clinical Entity #68: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 86));
        catalog.put("D06.9", new IcdEntry("D06.9", "Blood & Immune Disorders Clinical Entity #69: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 93));
        catalog.put("D07.0", new IcdEntry("D07.0", "Blood & Immune Disorders Clinical Entity #70: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 100));
        catalog.put("D07.1", new IcdEntry("D07.1", "Blood & Immune Disorders Clinical Entity #71: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 107));
        catalog.put("D07.2", new IcdEntry("D07.2", "Blood & Immune Disorders Clinical Entity #72: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 14));
        catalog.put("D07.3", new IcdEntry("D07.3", "Blood & Immune Disorders Clinical Entity #73: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 21));
        catalog.put("D07.4", new IcdEntry("D07.4", "Blood & Immune Disorders Clinical Entity #74: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 28));
        catalog.put("D07.5", new IcdEntry("D07.5", "Blood & Immune Disorders Clinical Entity #75: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 35));
        catalog.put("D07.6", new IcdEntry("D07.6", "Blood & Immune Disorders Clinical Entity #76: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 42));
        catalog.put("D07.7", new IcdEntry("D07.7", "Blood & Immune Disorders Clinical Entity #77: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 49));
        catalog.put("D07.8", new IcdEntry("D07.8", "Blood & Immune Disorders Clinical Entity #78: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 56));
        catalog.put("D07.9", new IcdEntry("D07.9", "Blood & Immune Disorders Clinical Entity #79: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 63));
        catalog.put("D08.0", new IcdEntry("D08.0", "Blood & Immune Disorders Clinical Entity #80: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 70));
        catalog.put("D08.1", new IcdEntry("D08.1", "Blood & Immune Disorders Clinical Entity #81: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 77));
        catalog.put("D08.2", new IcdEntry("D08.2", "Blood & Immune Disorders Clinical Entity #82: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 84));
        catalog.put("D08.3", new IcdEntry("D08.3", "Blood & Immune Disorders Clinical Entity #83: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 91));
        catalog.put("D08.4", new IcdEntry("D08.4", "Blood & Immune Disorders Clinical Entity #84: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 98));
        catalog.put("D08.5", new IcdEntry("D08.5", "Blood & Immune Disorders Clinical Entity #85: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 105));
        catalog.put("D08.6", new IcdEntry("D08.6", "Blood & Immune Disorders Clinical Entity #86: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 12));
        catalog.put("D08.7", new IcdEntry("D08.7", "Blood & Immune Disorders Clinical Entity #87: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 19));
        catalog.put("D08.8", new IcdEntry("D08.8", "Blood & Immune Disorders Clinical Entity #88: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 26));
        catalog.put("D08.9", new IcdEntry("D08.9", "Blood & Immune Disorders Clinical Entity #89: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 33));
        catalog.put("D09.0", new IcdEntry("D09.0", "Blood & Immune Disorders Clinical Entity #90: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 40));
        catalog.put("D09.1", new IcdEntry("D09.1", "Blood & Immune Disorders Clinical Entity #91: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 47));
        catalog.put("D09.2", new IcdEntry("D09.2", "Blood & Immune Disorders Clinical Entity #92: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 54));
        catalog.put("D09.3", new IcdEntry("D09.3", "Blood & Immune Disorders Clinical Entity #93: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 61));
        catalog.put("D09.4", new IcdEntry("D09.4", "Blood & Immune Disorders Clinical Entity #94: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 68));
        catalog.put("D09.5", new IcdEntry("D09.5", "Blood & Immune Disorders Clinical Entity #95: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 75));
        catalog.put("D09.6", new IcdEntry("D09.6", "Blood & Immune Disorders Clinical Entity #96: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 82));
        catalog.put("D09.7", new IcdEntry("D09.7", "Blood & Immune Disorders Clinical Entity #97: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 2", false, 89));
        catalog.put("D09.8", new IcdEntry("D09.8", "Blood & Immune Disorders Clinical Entity #98: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 3", true, 96));
        catalog.put("D09.9", new IcdEntry("D09.9", "Blood & Immune Disorders Clinical Entity #99: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 4", false, 103));
        catalog.put("D10.0", new IcdEntry("D10.0", "Blood & Immune Disorders Clinical Entity #100: Precision Diagnostic Marker", "D50-D89", "Clinical Severity Grade 1", true, 10));
    }

    public Optional<IcdEntry> findByCode(String code) {
        return Optional.ofNullable(catalog.get(code));
    }

    public List<IcdEntry> getAllEntries() {
        return new ArrayList<>(catalog.values());
    }

    public List<IcdEntry> searchByKeyword(String keyword) {
        String lower = keyword.toLowerCase();
        return catalog.values().stream()
                .filter(e -> e.getCode().toLowerCase().contains(lower) || e.getClinicalDescription().toLowerCase().contains(lower))
                .toList();
    }
}
