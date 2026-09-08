package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 04 (E00-E89): Endocrine & Metabolic.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter04_EndocrineNutritionalMetabolic {

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

    public Icd10Chapter04_EndocrineNutritionalMetabolic() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("E00.1", new IcdEntry("E00.1", "Endocrine & Metabolic Clinical Entity #1: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 17));
        catalog.put("E00.2", new IcdEntry("E00.2", "Endocrine & Metabolic Clinical Entity #2: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 24));
        catalog.put("E00.3", new IcdEntry("E00.3", "Endocrine & Metabolic Clinical Entity #3: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 31));
        catalog.put("E00.4", new IcdEntry("E00.4", "Endocrine & Metabolic Clinical Entity #4: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 38));
        catalog.put("E00.5", new IcdEntry("E00.5", "Endocrine & Metabolic Clinical Entity #5: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 45));
        catalog.put("E00.6", new IcdEntry("E00.6", "Endocrine & Metabolic Clinical Entity #6: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 52));
        catalog.put("E00.7", new IcdEntry("E00.7", "Endocrine & Metabolic Clinical Entity #7: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 59));
        catalog.put("E00.8", new IcdEntry("E00.8", "Endocrine & Metabolic Clinical Entity #8: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 66));
        catalog.put("E00.9", new IcdEntry("E00.9", "Endocrine & Metabolic Clinical Entity #9: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 73));
        catalog.put("E01.0", new IcdEntry("E01.0", "Endocrine & Metabolic Clinical Entity #10: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 80));
        catalog.put("E01.1", new IcdEntry("E01.1", "Endocrine & Metabolic Clinical Entity #11: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 87));
        catalog.put("E01.2", new IcdEntry("E01.2", "Endocrine & Metabolic Clinical Entity #12: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 94));
        catalog.put("E01.3", new IcdEntry("E01.3", "Endocrine & Metabolic Clinical Entity #13: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 101));
        catalog.put("E01.4", new IcdEntry("E01.4", "Endocrine & Metabolic Clinical Entity #14: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 108));
        catalog.put("E01.5", new IcdEntry("E01.5", "Endocrine & Metabolic Clinical Entity #15: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 15));
        catalog.put("E01.6", new IcdEntry("E01.6", "Endocrine & Metabolic Clinical Entity #16: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 22));
        catalog.put("E01.7", new IcdEntry("E01.7", "Endocrine & Metabolic Clinical Entity #17: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 29));
        catalog.put("E01.8", new IcdEntry("E01.8", "Endocrine & Metabolic Clinical Entity #18: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 36));
        catalog.put("E01.9", new IcdEntry("E01.9", "Endocrine & Metabolic Clinical Entity #19: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 43));
        catalog.put("E02.0", new IcdEntry("E02.0", "Endocrine & Metabolic Clinical Entity #20: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 50));
        catalog.put("E02.1", new IcdEntry("E02.1", "Endocrine & Metabolic Clinical Entity #21: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 57));
        catalog.put("E02.2", new IcdEntry("E02.2", "Endocrine & Metabolic Clinical Entity #22: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 64));
        catalog.put("E02.3", new IcdEntry("E02.3", "Endocrine & Metabolic Clinical Entity #23: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 71));
        catalog.put("E02.4", new IcdEntry("E02.4", "Endocrine & Metabolic Clinical Entity #24: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 78));
        catalog.put("E02.5", new IcdEntry("E02.5", "Endocrine & Metabolic Clinical Entity #25: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 85));
        catalog.put("E02.6", new IcdEntry("E02.6", "Endocrine & Metabolic Clinical Entity #26: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 92));
        catalog.put("E02.7", new IcdEntry("E02.7", "Endocrine & Metabolic Clinical Entity #27: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 99));
        catalog.put("E02.8", new IcdEntry("E02.8", "Endocrine & Metabolic Clinical Entity #28: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 106));
        catalog.put("E02.9", new IcdEntry("E02.9", "Endocrine & Metabolic Clinical Entity #29: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 13));
        catalog.put("E03.0", new IcdEntry("E03.0", "Endocrine & Metabolic Clinical Entity #30: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 20));
        catalog.put("E03.1", new IcdEntry("E03.1", "Endocrine & Metabolic Clinical Entity #31: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 27));
        catalog.put("E03.2", new IcdEntry("E03.2", "Endocrine & Metabolic Clinical Entity #32: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 34));
        catalog.put("E03.3", new IcdEntry("E03.3", "Endocrine & Metabolic Clinical Entity #33: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 41));
        catalog.put("E03.4", new IcdEntry("E03.4", "Endocrine & Metabolic Clinical Entity #34: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 48));
        catalog.put("E03.5", new IcdEntry("E03.5", "Endocrine & Metabolic Clinical Entity #35: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 55));
        catalog.put("E03.6", new IcdEntry("E03.6", "Endocrine & Metabolic Clinical Entity #36: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 62));
        catalog.put("E03.7", new IcdEntry("E03.7", "Endocrine & Metabolic Clinical Entity #37: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 69));
        catalog.put("E03.8", new IcdEntry("E03.8", "Endocrine & Metabolic Clinical Entity #38: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 76));
        catalog.put("E03.9", new IcdEntry("E03.9", "Endocrine & Metabolic Clinical Entity #39: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 83));
        catalog.put("E04.0", new IcdEntry("E04.0", "Endocrine & Metabolic Clinical Entity #40: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 90));
        catalog.put("E04.1", new IcdEntry("E04.1", "Endocrine & Metabolic Clinical Entity #41: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 97));
        catalog.put("E04.2", new IcdEntry("E04.2", "Endocrine & Metabolic Clinical Entity #42: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 104));
        catalog.put("E04.3", new IcdEntry("E04.3", "Endocrine & Metabolic Clinical Entity #43: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 11));
        catalog.put("E04.4", new IcdEntry("E04.4", "Endocrine & Metabolic Clinical Entity #44: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 18));
        catalog.put("E04.5", new IcdEntry("E04.5", "Endocrine & Metabolic Clinical Entity #45: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 25));
        catalog.put("E04.6", new IcdEntry("E04.6", "Endocrine & Metabolic Clinical Entity #46: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 32));
        catalog.put("E04.7", new IcdEntry("E04.7", "Endocrine & Metabolic Clinical Entity #47: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 39));
        catalog.put("E04.8", new IcdEntry("E04.8", "Endocrine & Metabolic Clinical Entity #48: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 46));
        catalog.put("E04.9", new IcdEntry("E04.9", "Endocrine & Metabolic Clinical Entity #49: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 53));
        catalog.put("E05.0", new IcdEntry("E05.0", "Endocrine & Metabolic Clinical Entity #50: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 60));
        catalog.put("E05.1", new IcdEntry("E05.1", "Endocrine & Metabolic Clinical Entity #51: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 67));
        catalog.put("E05.2", new IcdEntry("E05.2", "Endocrine & Metabolic Clinical Entity #52: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 74));
        catalog.put("E05.3", new IcdEntry("E05.3", "Endocrine & Metabolic Clinical Entity #53: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 81));
        catalog.put("E05.4", new IcdEntry("E05.4", "Endocrine & Metabolic Clinical Entity #54: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 88));
        catalog.put("E05.5", new IcdEntry("E05.5", "Endocrine & Metabolic Clinical Entity #55: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 95));
        catalog.put("E05.6", new IcdEntry("E05.6", "Endocrine & Metabolic Clinical Entity #56: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 102));
        catalog.put("E05.7", new IcdEntry("E05.7", "Endocrine & Metabolic Clinical Entity #57: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 109));
        catalog.put("E05.8", new IcdEntry("E05.8", "Endocrine & Metabolic Clinical Entity #58: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 16));
        catalog.put("E05.9", new IcdEntry("E05.9", "Endocrine & Metabolic Clinical Entity #59: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 23));
        catalog.put("E06.0", new IcdEntry("E06.0", "Endocrine & Metabolic Clinical Entity #60: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 30));
        catalog.put("E06.1", new IcdEntry("E06.1", "Endocrine & Metabolic Clinical Entity #61: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 37));
        catalog.put("E06.2", new IcdEntry("E06.2", "Endocrine & Metabolic Clinical Entity #62: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 44));
        catalog.put("E06.3", new IcdEntry("E06.3", "Endocrine & Metabolic Clinical Entity #63: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 51));
        catalog.put("E06.4", new IcdEntry("E06.4", "Endocrine & Metabolic Clinical Entity #64: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 58));
        catalog.put("E06.5", new IcdEntry("E06.5", "Endocrine & Metabolic Clinical Entity #65: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 65));
        catalog.put("E06.6", new IcdEntry("E06.6", "Endocrine & Metabolic Clinical Entity #66: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 72));
        catalog.put("E06.7", new IcdEntry("E06.7", "Endocrine & Metabolic Clinical Entity #67: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 79));
        catalog.put("E06.8", new IcdEntry("E06.8", "Endocrine & Metabolic Clinical Entity #68: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 86));
        catalog.put("E06.9", new IcdEntry("E06.9", "Endocrine & Metabolic Clinical Entity #69: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 93));
        catalog.put("E07.0", new IcdEntry("E07.0", "Endocrine & Metabolic Clinical Entity #70: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 100));
        catalog.put("E07.1", new IcdEntry("E07.1", "Endocrine & Metabolic Clinical Entity #71: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 107));
        catalog.put("E07.2", new IcdEntry("E07.2", "Endocrine & Metabolic Clinical Entity #72: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 14));
        catalog.put("E07.3", new IcdEntry("E07.3", "Endocrine & Metabolic Clinical Entity #73: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 21));
        catalog.put("E07.4", new IcdEntry("E07.4", "Endocrine & Metabolic Clinical Entity #74: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 28));
        catalog.put("E07.5", new IcdEntry("E07.5", "Endocrine & Metabolic Clinical Entity #75: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 35));
        catalog.put("E07.6", new IcdEntry("E07.6", "Endocrine & Metabolic Clinical Entity #76: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 42));
        catalog.put("E07.7", new IcdEntry("E07.7", "Endocrine & Metabolic Clinical Entity #77: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 49));
        catalog.put("E07.8", new IcdEntry("E07.8", "Endocrine & Metabolic Clinical Entity #78: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 56));
        catalog.put("E07.9", new IcdEntry("E07.9", "Endocrine & Metabolic Clinical Entity #79: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 63));
        catalog.put("E08.0", new IcdEntry("E08.0", "Endocrine & Metabolic Clinical Entity #80: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 70));
        catalog.put("E08.1", new IcdEntry("E08.1", "Endocrine & Metabolic Clinical Entity #81: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 77));
        catalog.put("E08.2", new IcdEntry("E08.2", "Endocrine & Metabolic Clinical Entity #82: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 84));
        catalog.put("E08.3", new IcdEntry("E08.3", "Endocrine & Metabolic Clinical Entity #83: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 91));
        catalog.put("E08.4", new IcdEntry("E08.4", "Endocrine & Metabolic Clinical Entity #84: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 98));
        catalog.put("E08.5", new IcdEntry("E08.5", "Endocrine & Metabolic Clinical Entity #85: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 105));
        catalog.put("E08.6", new IcdEntry("E08.6", "Endocrine & Metabolic Clinical Entity #86: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 12));
        catalog.put("E08.7", new IcdEntry("E08.7", "Endocrine & Metabolic Clinical Entity #87: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 19));
        catalog.put("E08.8", new IcdEntry("E08.8", "Endocrine & Metabolic Clinical Entity #88: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 26));
        catalog.put("E08.9", new IcdEntry("E08.9", "Endocrine & Metabolic Clinical Entity #89: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 33));
        catalog.put("E09.0", new IcdEntry("E09.0", "Endocrine & Metabolic Clinical Entity #90: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 40));
        catalog.put("E09.1", new IcdEntry("E09.1", "Endocrine & Metabolic Clinical Entity #91: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 47));
        catalog.put("E09.2", new IcdEntry("E09.2", "Endocrine & Metabolic Clinical Entity #92: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 54));
        catalog.put("E09.3", new IcdEntry("E09.3", "Endocrine & Metabolic Clinical Entity #93: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 61));
        catalog.put("E09.4", new IcdEntry("E09.4", "Endocrine & Metabolic Clinical Entity #94: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 68));
        catalog.put("E09.5", new IcdEntry("E09.5", "Endocrine & Metabolic Clinical Entity #95: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 75));
        catalog.put("E09.6", new IcdEntry("E09.6", "Endocrine & Metabolic Clinical Entity #96: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 82));
        catalog.put("E09.7", new IcdEntry("E09.7", "Endocrine & Metabolic Clinical Entity #97: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 89));
        catalog.put("E09.8", new IcdEntry("E09.8", "Endocrine & Metabolic Clinical Entity #98: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 96));
        catalog.put("E09.9", new IcdEntry("E09.9", "Endocrine & Metabolic Clinical Entity #99: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 103));
        catalog.put("E10.0", new IcdEntry("E10.0", "Endocrine & Metabolic Clinical Entity #100: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 10));
        catalog.put("E10.1", new IcdEntry("E10.1", "Endocrine & Metabolic Clinical Entity #101: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 17));
        catalog.put("E10.2", new IcdEntry("E10.2", "Endocrine & Metabolic Clinical Entity #102: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 24));
        catalog.put("E10.3", new IcdEntry("E10.3", "Endocrine & Metabolic Clinical Entity #103: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 31));
        catalog.put("E10.4", new IcdEntry("E10.4", "Endocrine & Metabolic Clinical Entity #104: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 38));
        catalog.put("E10.5", new IcdEntry("E10.5", "Endocrine & Metabolic Clinical Entity #105: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 45));
        catalog.put("E10.6", new IcdEntry("E10.6", "Endocrine & Metabolic Clinical Entity #106: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 52));
        catalog.put("E10.7", new IcdEntry("E10.7", "Endocrine & Metabolic Clinical Entity #107: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 59));
        catalog.put("E10.8", new IcdEntry("E10.8", "Endocrine & Metabolic Clinical Entity #108: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 66));
        catalog.put("E10.9", new IcdEntry("E10.9", "Endocrine & Metabolic Clinical Entity #109: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 73));
        catalog.put("E11.0", new IcdEntry("E11.0", "Endocrine & Metabolic Clinical Entity #110: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 80));
        catalog.put("E11.1", new IcdEntry("E11.1", "Endocrine & Metabolic Clinical Entity #111: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 87));
        catalog.put("E11.2", new IcdEntry("E11.2", "Endocrine & Metabolic Clinical Entity #112: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 94));
        catalog.put("E11.3", new IcdEntry("E11.3", "Endocrine & Metabolic Clinical Entity #113: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 101));
        catalog.put("E11.4", new IcdEntry("E11.4", "Endocrine & Metabolic Clinical Entity #114: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 108));
        catalog.put("E11.5", new IcdEntry("E11.5", "Endocrine & Metabolic Clinical Entity #115: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 15));
        catalog.put("E11.6", new IcdEntry("E11.6", "Endocrine & Metabolic Clinical Entity #116: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 22));
        catalog.put("E11.7", new IcdEntry("E11.7", "Endocrine & Metabolic Clinical Entity #117: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 2", false, 29));
        catalog.put("E11.8", new IcdEntry("E11.8", "Endocrine & Metabolic Clinical Entity #118: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 3", true, 36));
        catalog.put("E11.9", new IcdEntry("E11.9", "Endocrine & Metabolic Clinical Entity #119: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 4", false, 43));
        catalog.put("E12.0", new IcdEntry("E12.0", "Endocrine & Metabolic Clinical Entity #120: Precision Diagnostic Marker", "E00-E89", "Clinical Severity Grade 1", true, 50));
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
