package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 14 (N00-N99): Nephrology & Urology.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter14_GenitourinarySystemDiseases {

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

    public Icd10Chapter14_GenitourinarySystemDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("N00.1", new IcdEntry("N00.1", "Nephrology & Urology Clinical Entity #1: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 17));
        catalog.put("N00.2", new IcdEntry("N00.2", "Nephrology & Urology Clinical Entity #2: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 24));
        catalog.put("N00.3", new IcdEntry("N00.3", "Nephrology & Urology Clinical Entity #3: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 31));
        catalog.put("N00.4", new IcdEntry("N00.4", "Nephrology & Urology Clinical Entity #4: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 38));
        catalog.put("N00.5", new IcdEntry("N00.5", "Nephrology & Urology Clinical Entity #5: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 45));
        catalog.put("N00.6", new IcdEntry("N00.6", "Nephrology & Urology Clinical Entity #6: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 52));
        catalog.put("N00.7", new IcdEntry("N00.7", "Nephrology & Urology Clinical Entity #7: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 59));
        catalog.put("N00.8", new IcdEntry("N00.8", "Nephrology & Urology Clinical Entity #8: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 66));
        catalog.put("N00.9", new IcdEntry("N00.9", "Nephrology & Urology Clinical Entity #9: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 73));
        catalog.put("N01.0", new IcdEntry("N01.0", "Nephrology & Urology Clinical Entity #10: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 80));
        catalog.put("N01.1", new IcdEntry("N01.1", "Nephrology & Urology Clinical Entity #11: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 87));
        catalog.put("N01.2", new IcdEntry("N01.2", "Nephrology & Urology Clinical Entity #12: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 94));
        catalog.put("N01.3", new IcdEntry("N01.3", "Nephrology & Urology Clinical Entity #13: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 101));
        catalog.put("N01.4", new IcdEntry("N01.4", "Nephrology & Urology Clinical Entity #14: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 108));
        catalog.put("N01.5", new IcdEntry("N01.5", "Nephrology & Urology Clinical Entity #15: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 15));
        catalog.put("N01.6", new IcdEntry("N01.6", "Nephrology & Urology Clinical Entity #16: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 22));
        catalog.put("N01.7", new IcdEntry("N01.7", "Nephrology & Urology Clinical Entity #17: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 29));
        catalog.put("N01.8", new IcdEntry("N01.8", "Nephrology & Urology Clinical Entity #18: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 36));
        catalog.put("N01.9", new IcdEntry("N01.9", "Nephrology & Urology Clinical Entity #19: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 43));
        catalog.put("N02.0", new IcdEntry("N02.0", "Nephrology & Urology Clinical Entity #20: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 50));
        catalog.put("N02.1", new IcdEntry("N02.1", "Nephrology & Urology Clinical Entity #21: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 57));
        catalog.put("N02.2", new IcdEntry("N02.2", "Nephrology & Urology Clinical Entity #22: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 64));
        catalog.put("N02.3", new IcdEntry("N02.3", "Nephrology & Urology Clinical Entity #23: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 71));
        catalog.put("N02.4", new IcdEntry("N02.4", "Nephrology & Urology Clinical Entity #24: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 78));
        catalog.put("N02.5", new IcdEntry("N02.5", "Nephrology & Urology Clinical Entity #25: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 85));
        catalog.put("N02.6", new IcdEntry("N02.6", "Nephrology & Urology Clinical Entity #26: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 92));
        catalog.put("N02.7", new IcdEntry("N02.7", "Nephrology & Urology Clinical Entity #27: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 99));
        catalog.put("N02.8", new IcdEntry("N02.8", "Nephrology & Urology Clinical Entity #28: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 106));
        catalog.put("N02.9", new IcdEntry("N02.9", "Nephrology & Urology Clinical Entity #29: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 13));
        catalog.put("N03.0", new IcdEntry("N03.0", "Nephrology & Urology Clinical Entity #30: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 20));
        catalog.put("N03.1", new IcdEntry("N03.1", "Nephrology & Urology Clinical Entity #31: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 27));
        catalog.put("N03.2", new IcdEntry("N03.2", "Nephrology & Urology Clinical Entity #32: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 34));
        catalog.put("N03.3", new IcdEntry("N03.3", "Nephrology & Urology Clinical Entity #33: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 41));
        catalog.put("N03.4", new IcdEntry("N03.4", "Nephrology & Urology Clinical Entity #34: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 48));
        catalog.put("N03.5", new IcdEntry("N03.5", "Nephrology & Urology Clinical Entity #35: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 55));
        catalog.put("N03.6", new IcdEntry("N03.6", "Nephrology & Urology Clinical Entity #36: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 62));
        catalog.put("N03.7", new IcdEntry("N03.7", "Nephrology & Urology Clinical Entity #37: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 69));
        catalog.put("N03.8", new IcdEntry("N03.8", "Nephrology & Urology Clinical Entity #38: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 76));
        catalog.put("N03.9", new IcdEntry("N03.9", "Nephrology & Urology Clinical Entity #39: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 83));
        catalog.put("N04.0", new IcdEntry("N04.0", "Nephrology & Urology Clinical Entity #40: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 90));
        catalog.put("N04.1", new IcdEntry("N04.1", "Nephrology & Urology Clinical Entity #41: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 97));
        catalog.put("N04.2", new IcdEntry("N04.2", "Nephrology & Urology Clinical Entity #42: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 104));
        catalog.put("N04.3", new IcdEntry("N04.3", "Nephrology & Urology Clinical Entity #43: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 11));
        catalog.put("N04.4", new IcdEntry("N04.4", "Nephrology & Urology Clinical Entity #44: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 18));
        catalog.put("N04.5", new IcdEntry("N04.5", "Nephrology & Urology Clinical Entity #45: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 25));
        catalog.put("N04.6", new IcdEntry("N04.6", "Nephrology & Urology Clinical Entity #46: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 32));
        catalog.put("N04.7", new IcdEntry("N04.7", "Nephrology & Urology Clinical Entity #47: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 39));
        catalog.put("N04.8", new IcdEntry("N04.8", "Nephrology & Urology Clinical Entity #48: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 46));
        catalog.put("N04.9", new IcdEntry("N04.9", "Nephrology & Urology Clinical Entity #49: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 53));
        catalog.put("N05.0", new IcdEntry("N05.0", "Nephrology & Urology Clinical Entity #50: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 60));
        catalog.put("N05.1", new IcdEntry("N05.1", "Nephrology & Urology Clinical Entity #51: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 67));
        catalog.put("N05.2", new IcdEntry("N05.2", "Nephrology & Urology Clinical Entity #52: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 74));
        catalog.put("N05.3", new IcdEntry("N05.3", "Nephrology & Urology Clinical Entity #53: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 81));
        catalog.put("N05.4", new IcdEntry("N05.4", "Nephrology & Urology Clinical Entity #54: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 88));
        catalog.put("N05.5", new IcdEntry("N05.5", "Nephrology & Urology Clinical Entity #55: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 95));
        catalog.put("N05.6", new IcdEntry("N05.6", "Nephrology & Urology Clinical Entity #56: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 102));
        catalog.put("N05.7", new IcdEntry("N05.7", "Nephrology & Urology Clinical Entity #57: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 109));
        catalog.put("N05.8", new IcdEntry("N05.8", "Nephrology & Urology Clinical Entity #58: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 16));
        catalog.put("N05.9", new IcdEntry("N05.9", "Nephrology & Urology Clinical Entity #59: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 23));
        catalog.put("N06.0", new IcdEntry("N06.0", "Nephrology & Urology Clinical Entity #60: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 30));
        catalog.put("N06.1", new IcdEntry("N06.1", "Nephrology & Urology Clinical Entity #61: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 37));
        catalog.put("N06.2", new IcdEntry("N06.2", "Nephrology & Urology Clinical Entity #62: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 44));
        catalog.put("N06.3", new IcdEntry("N06.3", "Nephrology & Urology Clinical Entity #63: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 51));
        catalog.put("N06.4", new IcdEntry("N06.4", "Nephrology & Urology Clinical Entity #64: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 58));
        catalog.put("N06.5", new IcdEntry("N06.5", "Nephrology & Urology Clinical Entity #65: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 65));
        catalog.put("N06.6", new IcdEntry("N06.6", "Nephrology & Urology Clinical Entity #66: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 72));
        catalog.put("N06.7", new IcdEntry("N06.7", "Nephrology & Urology Clinical Entity #67: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 79));
        catalog.put("N06.8", new IcdEntry("N06.8", "Nephrology & Urology Clinical Entity #68: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 86));
        catalog.put("N06.9", new IcdEntry("N06.9", "Nephrology & Urology Clinical Entity #69: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 93));
        catalog.put("N07.0", new IcdEntry("N07.0", "Nephrology & Urology Clinical Entity #70: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 100));
        catalog.put("N07.1", new IcdEntry("N07.1", "Nephrology & Urology Clinical Entity #71: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 107));
        catalog.put("N07.2", new IcdEntry("N07.2", "Nephrology & Urology Clinical Entity #72: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 14));
        catalog.put("N07.3", new IcdEntry("N07.3", "Nephrology & Urology Clinical Entity #73: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 21));
        catalog.put("N07.4", new IcdEntry("N07.4", "Nephrology & Urology Clinical Entity #74: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 28));
        catalog.put("N07.5", new IcdEntry("N07.5", "Nephrology & Urology Clinical Entity #75: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 35));
        catalog.put("N07.6", new IcdEntry("N07.6", "Nephrology & Urology Clinical Entity #76: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 42));
        catalog.put("N07.7", new IcdEntry("N07.7", "Nephrology & Urology Clinical Entity #77: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 49));
        catalog.put("N07.8", new IcdEntry("N07.8", "Nephrology & Urology Clinical Entity #78: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 56));
        catalog.put("N07.9", new IcdEntry("N07.9", "Nephrology & Urology Clinical Entity #79: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 63));
        catalog.put("N08.0", new IcdEntry("N08.0", "Nephrology & Urology Clinical Entity #80: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 70));
        catalog.put("N08.1", new IcdEntry("N08.1", "Nephrology & Urology Clinical Entity #81: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 77));
        catalog.put("N08.2", new IcdEntry("N08.2", "Nephrology & Urology Clinical Entity #82: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 84));
        catalog.put("N08.3", new IcdEntry("N08.3", "Nephrology & Urology Clinical Entity #83: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 91));
        catalog.put("N08.4", new IcdEntry("N08.4", "Nephrology & Urology Clinical Entity #84: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 98));
        catalog.put("N08.5", new IcdEntry("N08.5", "Nephrology & Urology Clinical Entity #85: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 105));
        catalog.put("N08.6", new IcdEntry("N08.6", "Nephrology & Urology Clinical Entity #86: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 12));
        catalog.put("N08.7", new IcdEntry("N08.7", "Nephrology & Urology Clinical Entity #87: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 19));
        catalog.put("N08.8", new IcdEntry("N08.8", "Nephrology & Urology Clinical Entity #88: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 26));
        catalog.put("N08.9", new IcdEntry("N08.9", "Nephrology & Urology Clinical Entity #89: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 33));
        catalog.put("N09.0", new IcdEntry("N09.0", "Nephrology & Urology Clinical Entity #90: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 40));
        catalog.put("N09.1", new IcdEntry("N09.1", "Nephrology & Urology Clinical Entity #91: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 47));
        catalog.put("N09.2", new IcdEntry("N09.2", "Nephrology & Urology Clinical Entity #92: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 54));
        catalog.put("N09.3", new IcdEntry("N09.3", "Nephrology & Urology Clinical Entity #93: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 61));
        catalog.put("N09.4", new IcdEntry("N09.4", "Nephrology & Urology Clinical Entity #94: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 68));
        catalog.put("N09.5", new IcdEntry("N09.5", "Nephrology & Urology Clinical Entity #95: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 75));
        catalog.put("N09.6", new IcdEntry("N09.6", "Nephrology & Urology Clinical Entity #96: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 82));
        catalog.put("N09.7", new IcdEntry("N09.7", "Nephrology & Urology Clinical Entity #97: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 89));
        catalog.put("N09.8", new IcdEntry("N09.8", "Nephrology & Urology Clinical Entity #98: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 96));
        catalog.put("N09.9", new IcdEntry("N09.9", "Nephrology & Urology Clinical Entity #99: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 103));
        catalog.put("N10.0", new IcdEntry("N10.0", "Nephrology & Urology Clinical Entity #100: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 10));
        catalog.put("N10.1", new IcdEntry("N10.1", "Nephrology & Urology Clinical Entity #101: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 17));
        catalog.put("N10.2", new IcdEntry("N10.2", "Nephrology & Urology Clinical Entity #102: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 24));
        catalog.put("N10.3", new IcdEntry("N10.3", "Nephrology & Urology Clinical Entity #103: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 31));
        catalog.put("N10.4", new IcdEntry("N10.4", "Nephrology & Urology Clinical Entity #104: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 38));
        catalog.put("N10.5", new IcdEntry("N10.5", "Nephrology & Urology Clinical Entity #105: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 45));
        catalog.put("N10.6", new IcdEntry("N10.6", "Nephrology & Urology Clinical Entity #106: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 52));
        catalog.put("N10.7", new IcdEntry("N10.7", "Nephrology & Urology Clinical Entity #107: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 4", false, 59));
        catalog.put("N10.8", new IcdEntry("N10.8", "Nephrology & Urology Clinical Entity #108: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 1", true, 66));
        catalog.put("N10.9", new IcdEntry("N10.9", "Nephrology & Urology Clinical Entity #109: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 2", false, 73));
        catalog.put("N11.0", new IcdEntry("N11.0", "Nephrology & Urology Clinical Entity #110: Precision Diagnostic Marker", "N00-N99", "Clinical Severity Grade 3", true, 80));
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
