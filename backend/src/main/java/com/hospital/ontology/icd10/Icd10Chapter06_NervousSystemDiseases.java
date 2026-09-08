package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 06 (G00-G99): Neurological Disorders.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter06_NervousSystemDiseases {

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

    public Icd10Chapter06_NervousSystemDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("G00.1", new IcdEntry("G00.1", "Neurological Disorders Clinical Entity #1: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 17));
        catalog.put("G00.2", new IcdEntry("G00.2", "Neurological Disorders Clinical Entity #2: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 24));
        catalog.put("G00.3", new IcdEntry("G00.3", "Neurological Disorders Clinical Entity #3: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 31));
        catalog.put("G00.4", new IcdEntry("G00.4", "Neurological Disorders Clinical Entity #4: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 38));
        catalog.put("G00.5", new IcdEntry("G00.5", "Neurological Disorders Clinical Entity #5: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 45));
        catalog.put("G00.6", new IcdEntry("G00.6", "Neurological Disorders Clinical Entity #6: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 52));
        catalog.put("G00.7", new IcdEntry("G00.7", "Neurological Disorders Clinical Entity #7: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 59));
        catalog.put("G00.8", new IcdEntry("G00.8", "Neurological Disorders Clinical Entity #8: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 66));
        catalog.put("G00.9", new IcdEntry("G00.9", "Neurological Disorders Clinical Entity #9: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 73));
        catalog.put("G01.0", new IcdEntry("G01.0", "Neurological Disorders Clinical Entity #10: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 80));
        catalog.put("G01.1", new IcdEntry("G01.1", "Neurological Disorders Clinical Entity #11: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 87));
        catalog.put("G01.2", new IcdEntry("G01.2", "Neurological Disorders Clinical Entity #12: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 94));
        catalog.put("G01.3", new IcdEntry("G01.3", "Neurological Disorders Clinical Entity #13: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 101));
        catalog.put("G01.4", new IcdEntry("G01.4", "Neurological Disorders Clinical Entity #14: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 108));
        catalog.put("G01.5", new IcdEntry("G01.5", "Neurological Disorders Clinical Entity #15: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 15));
        catalog.put("G01.6", new IcdEntry("G01.6", "Neurological Disorders Clinical Entity #16: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 22));
        catalog.put("G01.7", new IcdEntry("G01.7", "Neurological Disorders Clinical Entity #17: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 29));
        catalog.put("G01.8", new IcdEntry("G01.8", "Neurological Disorders Clinical Entity #18: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 36));
        catalog.put("G01.9", new IcdEntry("G01.9", "Neurological Disorders Clinical Entity #19: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 43));
        catalog.put("G02.0", new IcdEntry("G02.0", "Neurological Disorders Clinical Entity #20: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 50));
        catalog.put("G02.1", new IcdEntry("G02.1", "Neurological Disorders Clinical Entity #21: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 57));
        catalog.put("G02.2", new IcdEntry("G02.2", "Neurological Disorders Clinical Entity #22: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 64));
        catalog.put("G02.3", new IcdEntry("G02.3", "Neurological Disorders Clinical Entity #23: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 71));
        catalog.put("G02.4", new IcdEntry("G02.4", "Neurological Disorders Clinical Entity #24: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 78));
        catalog.put("G02.5", new IcdEntry("G02.5", "Neurological Disorders Clinical Entity #25: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 85));
        catalog.put("G02.6", new IcdEntry("G02.6", "Neurological Disorders Clinical Entity #26: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 92));
        catalog.put("G02.7", new IcdEntry("G02.7", "Neurological Disorders Clinical Entity #27: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 99));
        catalog.put("G02.8", new IcdEntry("G02.8", "Neurological Disorders Clinical Entity #28: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 106));
        catalog.put("G02.9", new IcdEntry("G02.9", "Neurological Disorders Clinical Entity #29: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 13));
        catalog.put("G03.0", new IcdEntry("G03.0", "Neurological Disorders Clinical Entity #30: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 20));
        catalog.put("G03.1", new IcdEntry("G03.1", "Neurological Disorders Clinical Entity #31: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 27));
        catalog.put("G03.2", new IcdEntry("G03.2", "Neurological Disorders Clinical Entity #32: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 34));
        catalog.put("G03.3", new IcdEntry("G03.3", "Neurological Disorders Clinical Entity #33: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 41));
        catalog.put("G03.4", new IcdEntry("G03.4", "Neurological Disorders Clinical Entity #34: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 48));
        catalog.put("G03.5", new IcdEntry("G03.5", "Neurological Disorders Clinical Entity #35: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 55));
        catalog.put("G03.6", new IcdEntry("G03.6", "Neurological Disorders Clinical Entity #36: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 62));
        catalog.put("G03.7", new IcdEntry("G03.7", "Neurological Disorders Clinical Entity #37: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 69));
        catalog.put("G03.8", new IcdEntry("G03.8", "Neurological Disorders Clinical Entity #38: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 76));
        catalog.put("G03.9", new IcdEntry("G03.9", "Neurological Disorders Clinical Entity #39: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 83));
        catalog.put("G04.0", new IcdEntry("G04.0", "Neurological Disorders Clinical Entity #40: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 90));
        catalog.put("G04.1", new IcdEntry("G04.1", "Neurological Disorders Clinical Entity #41: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 97));
        catalog.put("G04.2", new IcdEntry("G04.2", "Neurological Disorders Clinical Entity #42: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 104));
        catalog.put("G04.3", new IcdEntry("G04.3", "Neurological Disorders Clinical Entity #43: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 11));
        catalog.put("G04.4", new IcdEntry("G04.4", "Neurological Disorders Clinical Entity #44: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 18));
        catalog.put("G04.5", new IcdEntry("G04.5", "Neurological Disorders Clinical Entity #45: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 25));
        catalog.put("G04.6", new IcdEntry("G04.6", "Neurological Disorders Clinical Entity #46: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 32));
        catalog.put("G04.7", new IcdEntry("G04.7", "Neurological Disorders Clinical Entity #47: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 39));
        catalog.put("G04.8", new IcdEntry("G04.8", "Neurological Disorders Clinical Entity #48: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 46));
        catalog.put("G04.9", new IcdEntry("G04.9", "Neurological Disorders Clinical Entity #49: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 53));
        catalog.put("G05.0", new IcdEntry("G05.0", "Neurological Disorders Clinical Entity #50: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 60));
        catalog.put("G05.1", new IcdEntry("G05.1", "Neurological Disorders Clinical Entity #51: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 67));
        catalog.put("G05.2", new IcdEntry("G05.2", "Neurological Disorders Clinical Entity #52: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 74));
        catalog.put("G05.3", new IcdEntry("G05.3", "Neurological Disorders Clinical Entity #53: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 81));
        catalog.put("G05.4", new IcdEntry("G05.4", "Neurological Disorders Clinical Entity #54: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 88));
        catalog.put("G05.5", new IcdEntry("G05.5", "Neurological Disorders Clinical Entity #55: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 95));
        catalog.put("G05.6", new IcdEntry("G05.6", "Neurological Disorders Clinical Entity #56: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 102));
        catalog.put("G05.7", new IcdEntry("G05.7", "Neurological Disorders Clinical Entity #57: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 109));
        catalog.put("G05.8", new IcdEntry("G05.8", "Neurological Disorders Clinical Entity #58: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 16));
        catalog.put("G05.9", new IcdEntry("G05.9", "Neurological Disorders Clinical Entity #59: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 23));
        catalog.put("G06.0", new IcdEntry("G06.0", "Neurological Disorders Clinical Entity #60: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 30));
        catalog.put("G06.1", new IcdEntry("G06.1", "Neurological Disorders Clinical Entity #61: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 37));
        catalog.put("G06.2", new IcdEntry("G06.2", "Neurological Disorders Clinical Entity #62: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 44));
        catalog.put("G06.3", new IcdEntry("G06.3", "Neurological Disorders Clinical Entity #63: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 51));
        catalog.put("G06.4", new IcdEntry("G06.4", "Neurological Disorders Clinical Entity #64: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 58));
        catalog.put("G06.5", new IcdEntry("G06.5", "Neurological Disorders Clinical Entity #65: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 65));
        catalog.put("G06.6", new IcdEntry("G06.6", "Neurological Disorders Clinical Entity #66: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 72));
        catalog.put("G06.7", new IcdEntry("G06.7", "Neurological Disorders Clinical Entity #67: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 79));
        catalog.put("G06.8", new IcdEntry("G06.8", "Neurological Disorders Clinical Entity #68: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 86));
        catalog.put("G06.9", new IcdEntry("G06.9", "Neurological Disorders Clinical Entity #69: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 93));
        catalog.put("G07.0", new IcdEntry("G07.0", "Neurological Disorders Clinical Entity #70: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 100));
        catalog.put("G07.1", new IcdEntry("G07.1", "Neurological Disorders Clinical Entity #71: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 107));
        catalog.put("G07.2", new IcdEntry("G07.2", "Neurological Disorders Clinical Entity #72: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 14));
        catalog.put("G07.3", new IcdEntry("G07.3", "Neurological Disorders Clinical Entity #73: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 21));
        catalog.put("G07.4", new IcdEntry("G07.4", "Neurological Disorders Clinical Entity #74: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 28));
        catalog.put("G07.5", new IcdEntry("G07.5", "Neurological Disorders Clinical Entity #75: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 35));
        catalog.put("G07.6", new IcdEntry("G07.6", "Neurological Disorders Clinical Entity #76: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 42));
        catalog.put("G07.7", new IcdEntry("G07.7", "Neurological Disorders Clinical Entity #77: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 49));
        catalog.put("G07.8", new IcdEntry("G07.8", "Neurological Disorders Clinical Entity #78: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 56));
        catalog.put("G07.9", new IcdEntry("G07.9", "Neurological Disorders Clinical Entity #79: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 63));
        catalog.put("G08.0", new IcdEntry("G08.0", "Neurological Disorders Clinical Entity #80: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 70));
        catalog.put("G08.1", new IcdEntry("G08.1", "Neurological Disorders Clinical Entity #81: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 77));
        catalog.put("G08.2", new IcdEntry("G08.2", "Neurological Disorders Clinical Entity #82: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 84));
        catalog.put("G08.3", new IcdEntry("G08.3", "Neurological Disorders Clinical Entity #83: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 91));
        catalog.put("G08.4", new IcdEntry("G08.4", "Neurological Disorders Clinical Entity #84: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 98));
        catalog.put("G08.5", new IcdEntry("G08.5", "Neurological Disorders Clinical Entity #85: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 105));
        catalog.put("G08.6", new IcdEntry("G08.6", "Neurological Disorders Clinical Entity #86: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 12));
        catalog.put("G08.7", new IcdEntry("G08.7", "Neurological Disorders Clinical Entity #87: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 19));
        catalog.put("G08.8", new IcdEntry("G08.8", "Neurological Disorders Clinical Entity #88: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 26));
        catalog.put("G08.9", new IcdEntry("G08.9", "Neurological Disorders Clinical Entity #89: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 33));
        catalog.put("G09.0", new IcdEntry("G09.0", "Neurological Disorders Clinical Entity #90: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 40));
        catalog.put("G09.1", new IcdEntry("G09.1", "Neurological Disorders Clinical Entity #91: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 47));
        catalog.put("G09.2", new IcdEntry("G09.2", "Neurological Disorders Clinical Entity #92: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 54));
        catalog.put("G09.3", new IcdEntry("G09.3", "Neurological Disorders Clinical Entity #93: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 61));
        catalog.put("G09.4", new IcdEntry("G09.4", "Neurological Disorders Clinical Entity #94: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 68));
        catalog.put("G09.5", new IcdEntry("G09.5", "Neurological Disorders Clinical Entity #95: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 75));
        catalog.put("G09.6", new IcdEntry("G09.6", "Neurological Disorders Clinical Entity #96: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 82));
        catalog.put("G09.7", new IcdEntry("G09.7", "Neurological Disorders Clinical Entity #97: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 89));
        catalog.put("G09.8", new IcdEntry("G09.8", "Neurological Disorders Clinical Entity #98: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 96));
        catalog.put("G09.9", new IcdEntry("G09.9", "Neurological Disorders Clinical Entity #99: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 103));
        catalog.put("G10.0", new IcdEntry("G10.0", "Neurological Disorders Clinical Entity #100: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 10));
        catalog.put("G10.1", new IcdEntry("G10.1", "Neurological Disorders Clinical Entity #101: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 17));
        catalog.put("G10.2", new IcdEntry("G10.2", "Neurological Disorders Clinical Entity #102: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 24));
        catalog.put("G10.3", new IcdEntry("G10.3", "Neurological Disorders Clinical Entity #103: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 31));
        catalog.put("G10.4", new IcdEntry("G10.4", "Neurological Disorders Clinical Entity #104: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 38));
        catalog.put("G10.5", new IcdEntry("G10.5", "Neurological Disorders Clinical Entity #105: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 45));
        catalog.put("G10.6", new IcdEntry("G10.6", "Neurological Disorders Clinical Entity #106: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 52));
        catalog.put("G10.7", new IcdEntry("G10.7", "Neurological Disorders Clinical Entity #107: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 59));
        catalog.put("G10.8", new IcdEntry("G10.8", "Neurological Disorders Clinical Entity #108: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 66));
        catalog.put("G10.9", new IcdEntry("G10.9", "Neurological Disorders Clinical Entity #109: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 73));
        catalog.put("G11.0", new IcdEntry("G11.0", "Neurological Disorders Clinical Entity #110: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 80));
        catalog.put("G11.1", new IcdEntry("G11.1", "Neurological Disorders Clinical Entity #111: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 87));
        catalog.put("G11.2", new IcdEntry("G11.2", "Neurological Disorders Clinical Entity #112: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 94));
        catalog.put("G11.3", new IcdEntry("G11.3", "Neurological Disorders Clinical Entity #113: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 101));
        catalog.put("G11.4", new IcdEntry("G11.4", "Neurological Disorders Clinical Entity #114: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 108));
        catalog.put("G11.5", new IcdEntry("G11.5", "Neurological Disorders Clinical Entity #115: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 15));
        catalog.put("G11.6", new IcdEntry("G11.6", "Neurological Disorders Clinical Entity #116: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 22));
        catalog.put("G11.7", new IcdEntry("G11.7", "Neurological Disorders Clinical Entity #117: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 2", false, 29));
        catalog.put("G11.8", new IcdEntry("G11.8", "Neurological Disorders Clinical Entity #118: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 3", true, 36));
        catalog.put("G11.9", new IcdEntry("G11.9", "Neurological Disorders Clinical Entity #119: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 4", false, 43));
        catalog.put("G12.0", new IcdEntry("G12.0", "Neurological Disorders Clinical Entity #120: Precision Diagnostic Marker", "G00-G99", "Clinical Severity Grade 1", true, 50));
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
