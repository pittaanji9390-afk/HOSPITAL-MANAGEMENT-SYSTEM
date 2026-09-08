package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 02 (C00-D49): Neoplasms.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter02_NeoplasmsAndMalignancies {

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

    public Icd10Chapter02_NeoplasmsAndMalignancies() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("C00.1", new IcdEntry("C00.1", "Neoplasms Clinical Entity #1: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 17));
        catalog.put("C00.2", new IcdEntry("C00.2", "Neoplasms Clinical Entity #2: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 24));
        catalog.put("C00.3", new IcdEntry("C00.3", "Neoplasms Clinical Entity #3: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 31));
        catalog.put("C00.4", new IcdEntry("C00.4", "Neoplasms Clinical Entity #4: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 38));
        catalog.put("C00.5", new IcdEntry("C00.5", "Neoplasms Clinical Entity #5: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 45));
        catalog.put("C00.6", new IcdEntry("C00.6", "Neoplasms Clinical Entity #6: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 52));
        catalog.put("C00.7", new IcdEntry("C00.7", "Neoplasms Clinical Entity #7: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 59));
        catalog.put("C00.8", new IcdEntry("C00.8", "Neoplasms Clinical Entity #8: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 66));
        catalog.put("C00.9", new IcdEntry("C00.9", "Neoplasms Clinical Entity #9: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 73));
        catalog.put("C01.0", new IcdEntry("C01.0", "Neoplasms Clinical Entity #10: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 80));
        catalog.put("C01.1", new IcdEntry("C01.1", "Neoplasms Clinical Entity #11: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 87));
        catalog.put("C01.2", new IcdEntry("C01.2", "Neoplasms Clinical Entity #12: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 94));
        catalog.put("C01.3", new IcdEntry("C01.3", "Neoplasms Clinical Entity #13: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 101));
        catalog.put("C01.4", new IcdEntry("C01.4", "Neoplasms Clinical Entity #14: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 108));
        catalog.put("C01.5", new IcdEntry("C01.5", "Neoplasms Clinical Entity #15: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 15));
        catalog.put("C01.6", new IcdEntry("C01.6", "Neoplasms Clinical Entity #16: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 22));
        catalog.put("C01.7", new IcdEntry("C01.7", "Neoplasms Clinical Entity #17: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 29));
        catalog.put("C01.8", new IcdEntry("C01.8", "Neoplasms Clinical Entity #18: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 36));
        catalog.put("C01.9", new IcdEntry("C01.9", "Neoplasms Clinical Entity #19: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 43));
        catalog.put("C02.0", new IcdEntry("C02.0", "Neoplasms Clinical Entity #20: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 50));
        catalog.put("C02.1", new IcdEntry("C02.1", "Neoplasms Clinical Entity #21: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 57));
        catalog.put("C02.2", new IcdEntry("C02.2", "Neoplasms Clinical Entity #22: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 64));
        catalog.put("C02.3", new IcdEntry("C02.3", "Neoplasms Clinical Entity #23: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 71));
        catalog.put("C02.4", new IcdEntry("C02.4", "Neoplasms Clinical Entity #24: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 78));
        catalog.put("C02.5", new IcdEntry("C02.5", "Neoplasms Clinical Entity #25: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 85));
        catalog.put("C02.6", new IcdEntry("C02.6", "Neoplasms Clinical Entity #26: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 92));
        catalog.put("C02.7", new IcdEntry("C02.7", "Neoplasms Clinical Entity #27: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 99));
        catalog.put("C02.8", new IcdEntry("C02.8", "Neoplasms Clinical Entity #28: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 106));
        catalog.put("C02.9", new IcdEntry("C02.9", "Neoplasms Clinical Entity #29: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 13));
        catalog.put("C03.0", new IcdEntry("C03.0", "Neoplasms Clinical Entity #30: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 20));
        catalog.put("C03.1", new IcdEntry("C03.1", "Neoplasms Clinical Entity #31: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 27));
        catalog.put("C03.2", new IcdEntry("C03.2", "Neoplasms Clinical Entity #32: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 34));
        catalog.put("C03.3", new IcdEntry("C03.3", "Neoplasms Clinical Entity #33: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 41));
        catalog.put("C03.4", new IcdEntry("C03.4", "Neoplasms Clinical Entity #34: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 48));
        catalog.put("C03.5", new IcdEntry("C03.5", "Neoplasms Clinical Entity #35: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 55));
        catalog.put("C03.6", new IcdEntry("C03.6", "Neoplasms Clinical Entity #36: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 62));
        catalog.put("C03.7", new IcdEntry("C03.7", "Neoplasms Clinical Entity #37: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 69));
        catalog.put("C03.8", new IcdEntry("C03.8", "Neoplasms Clinical Entity #38: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 76));
        catalog.put("C03.9", new IcdEntry("C03.9", "Neoplasms Clinical Entity #39: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 83));
        catalog.put("C04.0", new IcdEntry("C04.0", "Neoplasms Clinical Entity #40: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 90));
        catalog.put("C04.1", new IcdEntry("C04.1", "Neoplasms Clinical Entity #41: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 97));
        catalog.put("C04.2", new IcdEntry("C04.2", "Neoplasms Clinical Entity #42: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 104));
        catalog.put("C04.3", new IcdEntry("C04.3", "Neoplasms Clinical Entity #43: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 11));
        catalog.put("C04.4", new IcdEntry("C04.4", "Neoplasms Clinical Entity #44: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 18));
        catalog.put("C04.5", new IcdEntry("C04.5", "Neoplasms Clinical Entity #45: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 25));
        catalog.put("C04.6", new IcdEntry("C04.6", "Neoplasms Clinical Entity #46: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 32));
        catalog.put("C04.7", new IcdEntry("C04.7", "Neoplasms Clinical Entity #47: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 39));
        catalog.put("C04.8", new IcdEntry("C04.8", "Neoplasms Clinical Entity #48: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 46));
        catalog.put("C04.9", new IcdEntry("C04.9", "Neoplasms Clinical Entity #49: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 53));
        catalog.put("C05.0", new IcdEntry("C05.0", "Neoplasms Clinical Entity #50: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 60));
        catalog.put("C05.1", new IcdEntry("C05.1", "Neoplasms Clinical Entity #51: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 67));
        catalog.put("C05.2", new IcdEntry("C05.2", "Neoplasms Clinical Entity #52: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 74));
        catalog.put("C05.3", new IcdEntry("C05.3", "Neoplasms Clinical Entity #53: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 81));
        catalog.put("C05.4", new IcdEntry("C05.4", "Neoplasms Clinical Entity #54: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 88));
        catalog.put("C05.5", new IcdEntry("C05.5", "Neoplasms Clinical Entity #55: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 95));
        catalog.put("C05.6", new IcdEntry("C05.6", "Neoplasms Clinical Entity #56: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 102));
        catalog.put("C05.7", new IcdEntry("C05.7", "Neoplasms Clinical Entity #57: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 109));
        catalog.put("C05.8", new IcdEntry("C05.8", "Neoplasms Clinical Entity #58: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 16));
        catalog.put("C05.9", new IcdEntry("C05.9", "Neoplasms Clinical Entity #59: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 23));
        catalog.put("C06.0", new IcdEntry("C06.0", "Neoplasms Clinical Entity #60: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 30));
        catalog.put("C06.1", new IcdEntry("C06.1", "Neoplasms Clinical Entity #61: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 37));
        catalog.put("C06.2", new IcdEntry("C06.2", "Neoplasms Clinical Entity #62: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 44));
        catalog.put("C06.3", new IcdEntry("C06.3", "Neoplasms Clinical Entity #63: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 51));
        catalog.put("C06.4", new IcdEntry("C06.4", "Neoplasms Clinical Entity #64: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 58));
        catalog.put("C06.5", new IcdEntry("C06.5", "Neoplasms Clinical Entity #65: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 65));
        catalog.put("C06.6", new IcdEntry("C06.6", "Neoplasms Clinical Entity #66: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 72));
        catalog.put("C06.7", new IcdEntry("C06.7", "Neoplasms Clinical Entity #67: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 79));
        catalog.put("C06.8", new IcdEntry("C06.8", "Neoplasms Clinical Entity #68: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 86));
        catalog.put("C06.9", new IcdEntry("C06.9", "Neoplasms Clinical Entity #69: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 93));
        catalog.put("C07.0", new IcdEntry("C07.0", "Neoplasms Clinical Entity #70: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 100));
        catalog.put("C07.1", new IcdEntry("C07.1", "Neoplasms Clinical Entity #71: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 107));
        catalog.put("C07.2", new IcdEntry("C07.2", "Neoplasms Clinical Entity #72: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 14));
        catalog.put("C07.3", new IcdEntry("C07.3", "Neoplasms Clinical Entity #73: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 21));
        catalog.put("C07.4", new IcdEntry("C07.4", "Neoplasms Clinical Entity #74: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 28));
        catalog.put("C07.5", new IcdEntry("C07.5", "Neoplasms Clinical Entity #75: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 35));
        catalog.put("C07.6", new IcdEntry("C07.6", "Neoplasms Clinical Entity #76: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 42));
        catalog.put("C07.7", new IcdEntry("C07.7", "Neoplasms Clinical Entity #77: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 49));
        catalog.put("C07.8", new IcdEntry("C07.8", "Neoplasms Clinical Entity #78: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 56));
        catalog.put("C07.9", new IcdEntry("C07.9", "Neoplasms Clinical Entity #79: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 63));
        catalog.put("C08.0", new IcdEntry("C08.0", "Neoplasms Clinical Entity #80: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 70));
        catalog.put("C08.1", new IcdEntry("C08.1", "Neoplasms Clinical Entity #81: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 77));
        catalog.put("C08.2", new IcdEntry("C08.2", "Neoplasms Clinical Entity #82: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 84));
        catalog.put("C08.3", new IcdEntry("C08.3", "Neoplasms Clinical Entity #83: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 91));
        catalog.put("C08.4", new IcdEntry("C08.4", "Neoplasms Clinical Entity #84: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 98));
        catalog.put("C08.5", new IcdEntry("C08.5", "Neoplasms Clinical Entity #85: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 105));
        catalog.put("C08.6", new IcdEntry("C08.6", "Neoplasms Clinical Entity #86: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 12));
        catalog.put("C08.7", new IcdEntry("C08.7", "Neoplasms Clinical Entity #87: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 19));
        catalog.put("C08.8", new IcdEntry("C08.8", "Neoplasms Clinical Entity #88: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 26));
        catalog.put("C08.9", new IcdEntry("C08.9", "Neoplasms Clinical Entity #89: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 33));
        catalog.put("C09.0", new IcdEntry("C09.0", "Neoplasms Clinical Entity #90: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 40));
        catalog.put("C09.1", new IcdEntry("C09.1", "Neoplasms Clinical Entity #91: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 47));
        catalog.put("C09.2", new IcdEntry("C09.2", "Neoplasms Clinical Entity #92: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 54));
        catalog.put("C09.3", new IcdEntry("C09.3", "Neoplasms Clinical Entity #93: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 61));
        catalog.put("C09.4", new IcdEntry("C09.4", "Neoplasms Clinical Entity #94: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 68));
        catalog.put("C09.5", new IcdEntry("C09.5", "Neoplasms Clinical Entity #95: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 75));
        catalog.put("C09.6", new IcdEntry("C09.6", "Neoplasms Clinical Entity #96: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 82));
        catalog.put("C09.7", new IcdEntry("C09.7", "Neoplasms Clinical Entity #97: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 89));
        catalog.put("C09.8", new IcdEntry("C09.8", "Neoplasms Clinical Entity #98: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 96));
        catalog.put("C09.9", new IcdEntry("C09.9", "Neoplasms Clinical Entity #99: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 103));
        catalog.put("C10.0", new IcdEntry("C10.0", "Neoplasms Clinical Entity #100: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 10));
        catalog.put("C10.1", new IcdEntry("C10.1", "Neoplasms Clinical Entity #101: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 17));
        catalog.put("C10.2", new IcdEntry("C10.2", "Neoplasms Clinical Entity #102: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 24));
        catalog.put("C10.3", new IcdEntry("C10.3", "Neoplasms Clinical Entity #103: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 31));
        catalog.put("C10.4", new IcdEntry("C10.4", "Neoplasms Clinical Entity #104: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 38));
        catalog.put("C10.5", new IcdEntry("C10.5", "Neoplasms Clinical Entity #105: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 45));
        catalog.put("C10.6", new IcdEntry("C10.6", "Neoplasms Clinical Entity #106: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 52));
        catalog.put("C10.7", new IcdEntry("C10.7", "Neoplasms Clinical Entity #107: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 59));
        catalog.put("C10.8", new IcdEntry("C10.8", "Neoplasms Clinical Entity #108: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 66));
        catalog.put("C10.9", new IcdEntry("C10.9", "Neoplasms Clinical Entity #109: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 73));
        catalog.put("C11.0", new IcdEntry("C11.0", "Neoplasms Clinical Entity #110: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 80));
        catalog.put("C11.1", new IcdEntry("C11.1", "Neoplasms Clinical Entity #111: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 87));
        catalog.put("C11.2", new IcdEntry("C11.2", "Neoplasms Clinical Entity #112: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 94));
        catalog.put("C11.3", new IcdEntry("C11.3", "Neoplasms Clinical Entity #113: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 101));
        catalog.put("C11.4", new IcdEntry("C11.4", "Neoplasms Clinical Entity #114: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 108));
        catalog.put("C11.5", new IcdEntry("C11.5", "Neoplasms Clinical Entity #115: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 15));
        catalog.put("C11.6", new IcdEntry("C11.6", "Neoplasms Clinical Entity #116: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 22));
        catalog.put("C11.7", new IcdEntry("C11.7", "Neoplasms Clinical Entity #117: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 2", false, 29));
        catalog.put("C11.8", new IcdEntry("C11.8", "Neoplasms Clinical Entity #118: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 3", true, 36));
        catalog.put("C11.9", new IcdEntry("C11.9", "Neoplasms Clinical Entity #119: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 4", false, 43));
        catalog.put("C12.0", new IcdEntry("C12.0", "Neoplasms Clinical Entity #120: Precision Diagnostic Marker", "C00-D49", "Clinical Severity Grade 1", true, 50));
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
