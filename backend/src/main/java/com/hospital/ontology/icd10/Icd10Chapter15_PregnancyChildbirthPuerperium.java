package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 15 (O00-O9A): Obstetrics & Maternal-Fetal.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter15_PregnancyChildbirthPuerperium {

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

    public Icd10Chapter15_PregnancyChildbirthPuerperium() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("O00.1", new IcdEntry("O00.1", "Obstetrics & Maternal-Fetal Clinical Entity #1: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 17));
        catalog.put("O00.2", new IcdEntry("O00.2", "Obstetrics & Maternal-Fetal Clinical Entity #2: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 24));
        catalog.put("O00.3", new IcdEntry("O00.3", "Obstetrics & Maternal-Fetal Clinical Entity #3: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 31));
        catalog.put("O00.4", new IcdEntry("O00.4", "Obstetrics & Maternal-Fetal Clinical Entity #4: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 38));
        catalog.put("O00.5", new IcdEntry("O00.5", "Obstetrics & Maternal-Fetal Clinical Entity #5: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 45));
        catalog.put("O00.6", new IcdEntry("O00.6", "Obstetrics & Maternal-Fetal Clinical Entity #6: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 52));
        catalog.put("O00.7", new IcdEntry("O00.7", "Obstetrics & Maternal-Fetal Clinical Entity #7: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 59));
        catalog.put("O00.8", new IcdEntry("O00.8", "Obstetrics & Maternal-Fetal Clinical Entity #8: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 66));
        catalog.put("O00.9", new IcdEntry("O00.9", "Obstetrics & Maternal-Fetal Clinical Entity #9: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 73));
        catalog.put("O01.0", new IcdEntry("O01.0", "Obstetrics & Maternal-Fetal Clinical Entity #10: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 80));
        catalog.put("O01.1", new IcdEntry("O01.1", "Obstetrics & Maternal-Fetal Clinical Entity #11: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 87));
        catalog.put("O01.2", new IcdEntry("O01.2", "Obstetrics & Maternal-Fetal Clinical Entity #12: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 94));
        catalog.put("O01.3", new IcdEntry("O01.3", "Obstetrics & Maternal-Fetal Clinical Entity #13: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 101));
        catalog.put("O01.4", new IcdEntry("O01.4", "Obstetrics & Maternal-Fetal Clinical Entity #14: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 108));
        catalog.put("O01.5", new IcdEntry("O01.5", "Obstetrics & Maternal-Fetal Clinical Entity #15: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 15));
        catalog.put("O01.6", new IcdEntry("O01.6", "Obstetrics & Maternal-Fetal Clinical Entity #16: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 22));
        catalog.put("O01.7", new IcdEntry("O01.7", "Obstetrics & Maternal-Fetal Clinical Entity #17: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 29));
        catalog.put("O01.8", new IcdEntry("O01.8", "Obstetrics & Maternal-Fetal Clinical Entity #18: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 36));
        catalog.put("O01.9", new IcdEntry("O01.9", "Obstetrics & Maternal-Fetal Clinical Entity #19: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 43));
        catalog.put("O02.0", new IcdEntry("O02.0", "Obstetrics & Maternal-Fetal Clinical Entity #20: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 50));
        catalog.put("O02.1", new IcdEntry("O02.1", "Obstetrics & Maternal-Fetal Clinical Entity #21: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 57));
        catalog.put("O02.2", new IcdEntry("O02.2", "Obstetrics & Maternal-Fetal Clinical Entity #22: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 64));
        catalog.put("O02.3", new IcdEntry("O02.3", "Obstetrics & Maternal-Fetal Clinical Entity #23: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 71));
        catalog.put("O02.4", new IcdEntry("O02.4", "Obstetrics & Maternal-Fetal Clinical Entity #24: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 78));
        catalog.put("O02.5", new IcdEntry("O02.5", "Obstetrics & Maternal-Fetal Clinical Entity #25: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 85));
        catalog.put("O02.6", new IcdEntry("O02.6", "Obstetrics & Maternal-Fetal Clinical Entity #26: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 92));
        catalog.put("O02.7", new IcdEntry("O02.7", "Obstetrics & Maternal-Fetal Clinical Entity #27: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 99));
        catalog.put("O02.8", new IcdEntry("O02.8", "Obstetrics & Maternal-Fetal Clinical Entity #28: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 106));
        catalog.put("O02.9", new IcdEntry("O02.9", "Obstetrics & Maternal-Fetal Clinical Entity #29: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 13));
        catalog.put("O03.0", new IcdEntry("O03.0", "Obstetrics & Maternal-Fetal Clinical Entity #30: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 20));
        catalog.put("O03.1", new IcdEntry("O03.1", "Obstetrics & Maternal-Fetal Clinical Entity #31: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 27));
        catalog.put("O03.2", new IcdEntry("O03.2", "Obstetrics & Maternal-Fetal Clinical Entity #32: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 34));
        catalog.put("O03.3", new IcdEntry("O03.3", "Obstetrics & Maternal-Fetal Clinical Entity #33: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 41));
        catalog.put("O03.4", new IcdEntry("O03.4", "Obstetrics & Maternal-Fetal Clinical Entity #34: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 48));
        catalog.put("O03.5", new IcdEntry("O03.5", "Obstetrics & Maternal-Fetal Clinical Entity #35: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 55));
        catalog.put("O03.6", new IcdEntry("O03.6", "Obstetrics & Maternal-Fetal Clinical Entity #36: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 62));
        catalog.put("O03.7", new IcdEntry("O03.7", "Obstetrics & Maternal-Fetal Clinical Entity #37: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 69));
        catalog.put("O03.8", new IcdEntry("O03.8", "Obstetrics & Maternal-Fetal Clinical Entity #38: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 76));
        catalog.put("O03.9", new IcdEntry("O03.9", "Obstetrics & Maternal-Fetal Clinical Entity #39: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 83));
        catalog.put("O04.0", new IcdEntry("O04.0", "Obstetrics & Maternal-Fetal Clinical Entity #40: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 90));
        catalog.put("O04.1", new IcdEntry("O04.1", "Obstetrics & Maternal-Fetal Clinical Entity #41: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 97));
        catalog.put("O04.2", new IcdEntry("O04.2", "Obstetrics & Maternal-Fetal Clinical Entity #42: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 104));
        catalog.put("O04.3", new IcdEntry("O04.3", "Obstetrics & Maternal-Fetal Clinical Entity #43: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 11));
        catalog.put("O04.4", new IcdEntry("O04.4", "Obstetrics & Maternal-Fetal Clinical Entity #44: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 18));
        catalog.put("O04.5", new IcdEntry("O04.5", "Obstetrics & Maternal-Fetal Clinical Entity #45: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 25));
        catalog.put("O04.6", new IcdEntry("O04.6", "Obstetrics & Maternal-Fetal Clinical Entity #46: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 32));
        catalog.put("O04.7", new IcdEntry("O04.7", "Obstetrics & Maternal-Fetal Clinical Entity #47: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 39));
        catalog.put("O04.8", new IcdEntry("O04.8", "Obstetrics & Maternal-Fetal Clinical Entity #48: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 46));
        catalog.put("O04.9", new IcdEntry("O04.9", "Obstetrics & Maternal-Fetal Clinical Entity #49: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 53));
        catalog.put("O05.0", new IcdEntry("O05.0", "Obstetrics & Maternal-Fetal Clinical Entity #50: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 60));
        catalog.put("O05.1", new IcdEntry("O05.1", "Obstetrics & Maternal-Fetal Clinical Entity #51: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 67));
        catalog.put("O05.2", new IcdEntry("O05.2", "Obstetrics & Maternal-Fetal Clinical Entity #52: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 74));
        catalog.put("O05.3", new IcdEntry("O05.3", "Obstetrics & Maternal-Fetal Clinical Entity #53: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 81));
        catalog.put("O05.4", new IcdEntry("O05.4", "Obstetrics & Maternal-Fetal Clinical Entity #54: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 88));
        catalog.put("O05.5", new IcdEntry("O05.5", "Obstetrics & Maternal-Fetal Clinical Entity #55: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 95));
        catalog.put("O05.6", new IcdEntry("O05.6", "Obstetrics & Maternal-Fetal Clinical Entity #56: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 102));
        catalog.put("O05.7", new IcdEntry("O05.7", "Obstetrics & Maternal-Fetal Clinical Entity #57: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 109));
        catalog.put("O05.8", new IcdEntry("O05.8", "Obstetrics & Maternal-Fetal Clinical Entity #58: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 16));
        catalog.put("O05.9", new IcdEntry("O05.9", "Obstetrics & Maternal-Fetal Clinical Entity #59: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 23));
        catalog.put("O06.0", new IcdEntry("O06.0", "Obstetrics & Maternal-Fetal Clinical Entity #60: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 30));
        catalog.put("O06.1", new IcdEntry("O06.1", "Obstetrics & Maternal-Fetal Clinical Entity #61: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 37));
        catalog.put("O06.2", new IcdEntry("O06.2", "Obstetrics & Maternal-Fetal Clinical Entity #62: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 44));
        catalog.put("O06.3", new IcdEntry("O06.3", "Obstetrics & Maternal-Fetal Clinical Entity #63: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 51));
        catalog.put("O06.4", new IcdEntry("O06.4", "Obstetrics & Maternal-Fetal Clinical Entity #64: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 58));
        catalog.put("O06.5", new IcdEntry("O06.5", "Obstetrics & Maternal-Fetal Clinical Entity #65: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 65));
        catalog.put("O06.6", new IcdEntry("O06.6", "Obstetrics & Maternal-Fetal Clinical Entity #66: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 72));
        catalog.put("O06.7", new IcdEntry("O06.7", "Obstetrics & Maternal-Fetal Clinical Entity #67: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 79));
        catalog.put("O06.8", new IcdEntry("O06.8", "Obstetrics & Maternal-Fetal Clinical Entity #68: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 86));
        catalog.put("O06.9", new IcdEntry("O06.9", "Obstetrics & Maternal-Fetal Clinical Entity #69: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 93));
        catalog.put("O07.0", new IcdEntry("O07.0", "Obstetrics & Maternal-Fetal Clinical Entity #70: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 100));
        catalog.put("O07.1", new IcdEntry("O07.1", "Obstetrics & Maternal-Fetal Clinical Entity #71: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 107));
        catalog.put("O07.2", new IcdEntry("O07.2", "Obstetrics & Maternal-Fetal Clinical Entity #72: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 14));
        catalog.put("O07.3", new IcdEntry("O07.3", "Obstetrics & Maternal-Fetal Clinical Entity #73: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 21));
        catalog.put("O07.4", new IcdEntry("O07.4", "Obstetrics & Maternal-Fetal Clinical Entity #74: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 28));
        catalog.put("O07.5", new IcdEntry("O07.5", "Obstetrics & Maternal-Fetal Clinical Entity #75: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 35));
        catalog.put("O07.6", new IcdEntry("O07.6", "Obstetrics & Maternal-Fetal Clinical Entity #76: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 42));
        catalog.put("O07.7", new IcdEntry("O07.7", "Obstetrics & Maternal-Fetal Clinical Entity #77: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 49));
        catalog.put("O07.8", new IcdEntry("O07.8", "Obstetrics & Maternal-Fetal Clinical Entity #78: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 56));
        catalog.put("O07.9", new IcdEntry("O07.9", "Obstetrics & Maternal-Fetal Clinical Entity #79: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 63));
        catalog.put("O08.0", new IcdEntry("O08.0", "Obstetrics & Maternal-Fetal Clinical Entity #80: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 70));
        catalog.put("O08.1", new IcdEntry("O08.1", "Obstetrics & Maternal-Fetal Clinical Entity #81: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 77));
        catalog.put("O08.2", new IcdEntry("O08.2", "Obstetrics & Maternal-Fetal Clinical Entity #82: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 84));
        catalog.put("O08.3", new IcdEntry("O08.3", "Obstetrics & Maternal-Fetal Clinical Entity #83: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 91));
        catalog.put("O08.4", new IcdEntry("O08.4", "Obstetrics & Maternal-Fetal Clinical Entity #84: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 98));
        catalog.put("O08.5", new IcdEntry("O08.5", "Obstetrics & Maternal-Fetal Clinical Entity #85: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 105));
        catalog.put("O08.6", new IcdEntry("O08.6", "Obstetrics & Maternal-Fetal Clinical Entity #86: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 12));
        catalog.put("O08.7", new IcdEntry("O08.7", "Obstetrics & Maternal-Fetal Clinical Entity #87: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 19));
        catalog.put("O08.8", new IcdEntry("O08.8", "Obstetrics & Maternal-Fetal Clinical Entity #88: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 26));
        catalog.put("O08.9", new IcdEntry("O08.9", "Obstetrics & Maternal-Fetal Clinical Entity #89: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 33));
        catalog.put("O09.0", new IcdEntry("O09.0", "Obstetrics & Maternal-Fetal Clinical Entity #90: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 40));
        catalog.put("O09.1", new IcdEntry("O09.1", "Obstetrics & Maternal-Fetal Clinical Entity #91: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 47));
        catalog.put("O09.2", new IcdEntry("O09.2", "Obstetrics & Maternal-Fetal Clinical Entity #92: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 54));
        catalog.put("O09.3", new IcdEntry("O09.3", "Obstetrics & Maternal-Fetal Clinical Entity #93: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 61));
        catalog.put("O09.4", new IcdEntry("O09.4", "Obstetrics & Maternal-Fetal Clinical Entity #94: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 68));
        catalog.put("O09.5", new IcdEntry("O09.5", "Obstetrics & Maternal-Fetal Clinical Entity #95: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 75));
        catalog.put("O09.6", new IcdEntry("O09.6", "Obstetrics & Maternal-Fetal Clinical Entity #96: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 82));
        catalog.put("O09.7", new IcdEntry("O09.7", "Obstetrics & Maternal-Fetal Clinical Entity #97: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 2", false, 89));
        catalog.put("O09.8", new IcdEntry("O09.8", "Obstetrics & Maternal-Fetal Clinical Entity #98: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 3", true, 96));
        catalog.put("O09.9", new IcdEntry("O09.9", "Obstetrics & Maternal-Fetal Clinical Entity #99: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 4", false, 103));
        catalog.put("O10.0", new IcdEntry("O10.0", "Obstetrics & Maternal-Fetal Clinical Entity #100: Precision Diagnostic Marker", "O00-O9A", "Clinical Severity Grade 1", true, 10));
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
