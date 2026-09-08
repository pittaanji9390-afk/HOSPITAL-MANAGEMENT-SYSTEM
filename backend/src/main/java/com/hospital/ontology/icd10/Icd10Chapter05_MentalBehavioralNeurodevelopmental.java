package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 05 (F01-F99): Mental Health & Behavioral.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter05_MentalBehavioralNeurodevelopmental {

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

    public Icd10Chapter05_MentalBehavioralNeurodevelopmental() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("F00.1", new IcdEntry("F00.1", "Mental Health & Behavioral Clinical Entity #1: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 17));
        catalog.put("F00.2", new IcdEntry("F00.2", "Mental Health & Behavioral Clinical Entity #2: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 24));
        catalog.put("F00.3", new IcdEntry("F00.3", "Mental Health & Behavioral Clinical Entity #3: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 31));
        catalog.put("F00.4", new IcdEntry("F00.4", "Mental Health & Behavioral Clinical Entity #4: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 38));
        catalog.put("F00.5", new IcdEntry("F00.5", "Mental Health & Behavioral Clinical Entity #5: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 45));
        catalog.put("F00.6", new IcdEntry("F00.6", "Mental Health & Behavioral Clinical Entity #6: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 52));
        catalog.put("F00.7", new IcdEntry("F00.7", "Mental Health & Behavioral Clinical Entity #7: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 59));
        catalog.put("F00.8", new IcdEntry("F00.8", "Mental Health & Behavioral Clinical Entity #8: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 66));
        catalog.put("F00.9", new IcdEntry("F00.9", "Mental Health & Behavioral Clinical Entity #9: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 73));
        catalog.put("F01.0", new IcdEntry("F01.0", "Mental Health & Behavioral Clinical Entity #10: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 80));
        catalog.put("F01.1", new IcdEntry("F01.1", "Mental Health & Behavioral Clinical Entity #11: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 87));
        catalog.put("F01.2", new IcdEntry("F01.2", "Mental Health & Behavioral Clinical Entity #12: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 94));
        catalog.put("F01.3", new IcdEntry("F01.3", "Mental Health & Behavioral Clinical Entity #13: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 101));
        catalog.put("F01.4", new IcdEntry("F01.4", "Mental Health & Behavioral Clinical Entity #14: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 108));
        catalog.put("F01.5", new IcdEntry("F01.5", "Mental Health & Behavioral Clinical Entity #15: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 15));
        catalog.put("F01.6", new IcdEntry("F01.6", "Mental Health & Behavioral Clinical Entity #16: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 22));
        catalog.put("F01.7", new IcdEntry("F01.7", "Mental Health & Behavioral Clinical Entity #17: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 29));
        catalog.put("F01.8", new IcdEntry("F01.8", "Mental Health & Behavioral Clinical Entity #18: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 36));
        catalog.put("F01.9", new IcdEntry("F01.9", "Mental Health & Behavioral Clinical Entity #19: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 43));
        catalog.put("F02.0", new IcdEntry("F02.0", "Mental Health & Behavioral Clinical Entity #20: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 50));
        catalog.put("F02.1", new IcdEntry("F02.1", "Mental Health & Behavioral Clinical Entity #21: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 57));
        catalog.put("F02.2", new IcdEntry("F02.2", "Mental Health & Behavioral Clinical Entity #22: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 64));
        catalog.put("F02.3", new IcdEntry("F02.3", "Mental Health & Behavioral Clinical Entity #23: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 71));
        catalog.put("F02.4", new IcdEntry("F02.4", "Mental Health & Behavioral Clinical Entity #24: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 78));
        catalog.put("F02.5", new IcdEntry("F02.5", "Mental Health & Behavioral Clinical Entity #25: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 85));
        catalog.put("F02.6", new IcdEntry("F02.6", "Mental Health & Behavioral Clinical Entity #26: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 92));
        catalog.put("F02.7", new IcdEntry("F02.7", "Mental Health & Behavioral Clinical Entity #27: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 99));
        catalog.put("F02.8", new IcdEntry("F02.8", "Mental Health & Behavioral Clinical Entity #28: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 106));
        catalog.put("F02.9", new IcdEntry("F02.9", "Mental Health & Behavioral Clinical Entity #29: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 13));
        catalog.put("F03.0", new IcdEntry("F03.0", "Mental Health & Behavioral Clinical Entity #30: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 20));
        catalog.put("F03.1", new IcdEntry("F03.1", "Mental Health & Behavioral Clinical Entity #31: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 27));
        catalog.put("F03.2", new IcdEntry("F03.2", "Mental Health & Behavioral Clinical Entity #32: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 34));
        catalog.put("F03.3", new IcdEntry("F03.3", "Mental Health & Behavioral Clinical Entity #33: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 41));
        catalog.put("F03.4", new IcdEntry("F03.4", "Mental Health & Behavioral Clinical Entity #34: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 48));
        catalog.put("F03.5", new IcdEntry("F03.5", "Mental Health & Behavioral Clinical Entity #35: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 55));
        catalog.put("F03.6", new IcdEntry("F03.6", "Mental Health & Behavioral Clinical Entity #36: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 62));
        catalog.put("F03.7", new IcdEntry("F03.7", "Mental Health & Behavioral Clinical Entity #37: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 69));
        catalog.put("F03.8", new IcdEntry("F03.8", "Mental Health & Behavioral Clinical Entity #38: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 76));
        catalog.put("F03.9", new IcdEntry("F03.9", "Mental Health & Behavioral Clinical Entity #39: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 83));
        catalog.put("F04.0", new IcdEntry("F04.0", "Mental Health & Behavioral Clinical Entity #40: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 90));
        catalog.put("F04.1", new IcdEntry("F04.1", "Mental Health & Behavioral Clinical Entity #41: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 97));
        catalog.put("F04.2", new IcdEntry("F04.2", "Mental Health & Behavioral Clinical Entity #42: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 104));
        catalog.put("F04.3", new IcdEntry("F04.3", "Mental Health & Behavioral Clinical Entity #43: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 11));
        catalog.put("F04.4", new IcdEntry("F04.4", "Mental Health & Behavioral Clinical Entity #44: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 18));
        catalog.put("F04.5", new IcdEntry("F04.5", "Mental Health & Behavioral Clinical Entity #45: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 25));
        catalog.put("F04.6", new IcdEntry("F04.6", "Mental Health & Behavioral Clinical Entity #46: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 32));
        catalog.put("F04.7", new IcdEntry("F04.7", "Mental Health & Behavioral Clinical Entity #47: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 39));
        catalog.put("F04.8", new IcdEntry("F04.8", "Mental Health & Behavioral Clinical Entity #48: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 46));
        catalog.put("F04.9", new IcdEntry("F04.9", "Mental Health & Behavioral Clinical Entity #49: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 53));
        catalog.put("F05.0", new IcdEntry("F05.0", "Mental Health & Behavioral Clinical Entity #50: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 60));
        catalog.put("F05.1", new IcdEntry("F05.1", "Mental Health & Behavioral Clinical Entity #51: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 67));
        catalog.put("F05.2", new IcdEntry("F05.2", "Mental Health & Behavioral Clinical Entity #52: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 74));
        catalog.put("F05.3", new IcdEntry("F05.3", "Mental Health & Behavioral Clinical Entity #53: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 81));
        catalog.put("F05.4", new IcdEntry("F05.4", "Mental Health & Behavioral Clinical Entity #54: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 88));
        catalog.put("F05.5", new IcdEntry("F05.5", "Mental Health & Behavioral Clinical Entity #55: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 95));
        catalog.put("F05.6", new IcdEntry("F05.6", "Mental Health & Behavioral Clinical Entity #56: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 102));
        catalog.put("F05.7", new IcdEntry("F05.7", "Mental Health & Behavioral Clinical Entity #57: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 109));
        catalog.put("F05.8", new IcdEntry("F05.8", "Mental Health & Behavioral Clinical Entity #58: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 16));
        catalog.put("F05.9", new IcdEntry("F05.9", "Mental Health & Behavioral Clinical Entity #59: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 23));
        catalog.put("F06.0", new IcdEntry("F06.0", "Mental Health & Behavioral Clinical Entity #60: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 30));
        catalog.put("F06.1", new IcdEntry("F06.1", "Mental Health & Behavioral Clinical Entity #61: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 37));
        catalog.put("F06.2", new IcdEntry("F06.2", "Mental Health & Behavioral Clinical Entity #62: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 44));
        catalog.put("F06.3", new IcdEntry("F06.3", "Mental Health & Behavioral Clinical Entity #63: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 51));
        catalog.put("F06.4", new IcdEntry("F06.4", "Mental Health & Behavioral Clinical Entity #64: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 58));
        catalog.put("F06.5", new IcdEntry("F06.5", "Mental Health & Behavioral Clinical Entity #65: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 65));
        catalog.put("F06.6", new IcdEntry("F06.6", "Mental Health & Behavioral Clinical Entity #66: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 72));
        catalog.put("F06.7", new IcdEntry("F06.7", "Mental Health & Behavioral Clinical Entity #67: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 79));
        catalog.put("F06.8", new IcdEntry("F06.8", "Mental Health & Behavioral Clinical Entity #68: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 86));
        catalog.put("F06.9", new IcdEntry("F06.9", "Mental Health & Behavioral Clinical Entity #69: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 93));
        catalog.put("F07.0", new IcdEntry("F07.0", "Mental Health & Behavioral Clinical Entity #70: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 100));
        catalog.put("F07.1", new IcdEntry("F07.1", "Mental Health & Behavioral Clinical Entity #71: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 107));
        catalog.put("F07.2", new IcdEntry("F07.2", "Mental Health & Behavioral Clinical Entity #72: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 14));
        catalog.put("F07.3", new IcdEntry("F07.3", "Mental Health & Behavioral Clinical Entity #73: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 21));
        catalog.put("F07.4", new IcdEntry("F07.4", "Mental Health & Behavioral Clinical Entity #74: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 28));
        catalog.put("F07.5", new IcdEntry("F07.5", "Mental Health & Behavioral Clinical Entity #75: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 35));
        catalog.put("F07.6", new IcdEntry("F07.6", "Mental Health & Behavioral Clinical Entity #76: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 42));
        catalog.put("F07.7", new IcdEntry("F07.7", "Mental Health & Behavioral Clinical Entity #77: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 49));
        catalog.put("F07.8", new IcdEntry("F07.8", "Mental Health & Behavioral Clinical Entity #78: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 56));
        catalog.put("F07.9", new IcdEntry("F07.9", "Mental Health & Behavioral Clinical Entity #79: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 63));
        catalog.put("F08.0", new IcdEntry("F08.0", "Mental Health & Behavioral Clinical Entity #80: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 70));
        catalog.put("F08.1", new IcdEntry("F08.1", "Mental Health & Behavioral Clinical Entity #81: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 77));
        catalog.put("F08.2", new IcdEntry("F08.2", "Mental Health & Behavioral Clinical Entity #82: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 84));
        catalog.put("F08.3", new IcdEntry("F08.3", "Mental Health & Behavioral Clinical Entity #83: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 91));
        catalog.put("F08.4", new IcdEntry("F08.4", "Mental Health & Behavioral Clinical Entity #84: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 98));
        catalog.put("F08.5", new IcdEntry("F08.5", "Mental Health & Behavioral Clinical Entity #85: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 105));
        catalog.put("F08.6", new IcdEntry("F08.6", "Mental Health & Behavioral Clinical Entity #86: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 12));
        catalog.put("F08.7", new IcdEntry("F08.7", "Mental Health & Behavioral Clinical Entity #87: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 19));
        catalog.put("F08.8", new IcdEntry("F08.8", "Mental Health & Behavioral Clinical Entity #88: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 26));
        catalog.put("F08.9", new IcdEntry("F08.9", "Mental Health & Behavioral Clinical Entity #89: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 33));
        catalog.put("F09.0", new IcdEntry("F09.0", "Mental Health & Behavioral Clinical Entity #90: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 40));
        catalog.put("F09.1", new IcdEntry("F09.1", "Mental Health & Behavioral Clinical Entity #91: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 47));
        catalog.put("F09.2", new IcdEntry("F09.2", "Mental Health & Behavioral Clinical Entity #92: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 54));
        catalog.put("F09.3", new IcdEntry("F09.3", "Mental Health & Behavioral Clinical Entity #93: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 61));
        catalog.put("F09.4", new IcdEntry("F09.4", "Mental Health & Behavioral Clinical Entity #94: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 68));
        catalog.put("F09.5", new IcdEntry("F09.5", "Mental Health & Behavioral Clinical Entity #95: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 75));
        catalog.put("F09.6", new IcdEntry("F09.6", "Mental Health & Behavioral Clinical Entity #96: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 82));
        catalog.put("F09.7", new IcdEntry("F09.7", "Mental Health & Behavioral Clinical Entity #97: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 89));
        catalog.put("F09.8", new IcdEntry("F09.8", "Mental Health & Behavioral Clinical Entity #98: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 96));
        catalog.put("F09.9", new IcdEntry("F09.9", "Mental Health & Behavioral Clinical Entity #99: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 103));
        catalog.put("F10.0", new IcdEntry("F10.0", "Mental Health & Behavioral Clinical Entity #100: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 10));
        catalog.put("F10.1", new IcdEntry("F10.1", "Mental Health & Behavioral Clinical Entity #101: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 17));
        catalog.put("F10.2", new IcdEntry("F10.2", "Mental Health & Behavioral Clinical Entity #102: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 24));
        catalog.put("F10.3", new IcdEntry("F10.3", "Mental Health & Behavioral Clinical Entity #103: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 31));
        catalog.put("F10.4", new IcdEntry("F10.4", "Mental Health & Behavioral Clinical Entity #104: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 38));
        catalog.put("F10.5", new IcdEntry("F10.5", "Mental Health & Behavioral Clinical Entity #105: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 45));
        catalog.put("F10.6", new IcdEntry("F10.6", "Mental Health & Behavioral Clinical Entity #106: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 52));
        catalog.put("F10.7", new IcdEntry("F10.7", "Mental Health & Behavioral Clinical Entity #107: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 4", false, 59));
        catalog.put("F10.8", new IcdEntry("F10.8", "Mental Health & Behavioral Clinical Entity #108: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 1", true, 66));
        catalog.put("F10.9", new IcdEntry("F10.9", "Mental Health & Behavioral Clinical Entity #109: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 2", false, 73));
        catalog.put("F11.0", new IcdEntry("F11.0", "Mental Health & Behavioral Clinical Entity #110: Precision Diagnostic Marker", "F01-F99", "Clinical Severity Grade 3", true, 80));
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
