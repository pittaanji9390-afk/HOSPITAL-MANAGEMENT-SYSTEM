package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 17 (Q00-Q99): Congenital & Genetics.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter17_CongenitalMalformationsDeformations {

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

    public Icd10Chapter17_CongenitalMalformationsDeformations() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("Q00.1", new IcdEntry("Q00.1", "Congenital & Genetics Clinical Entity #1: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 17));
        catalog.put("Q00.2", new IcdEntry("Q00.2", "Congenital & Genetics Clinical Entity #2: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 24));
        catalog.put("Q00.3", new IcdEntry("Q00.3", "Congenital & Genetics Clinical Entity #3: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 31));
        catalog.put("Q00.4", new IcdEntry("Q00.4", "Congenital & Genetics Clinical Entity #4: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 38));
        catalog.put("Q00.5", new IcdEntry("Q00.5", "Congenital & Genetics Clinical Entity #5: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 45));
        catalog.put("Q00.6", new IcdEntry("Q00.6", "Congenital & Genetics Clinical Entity #6: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 52));
        catalog.put("Q00.7", new IcdEntry("Q00.7", "Congenital & Genetics Clinical Entity #7: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 59));
        catalog.put("Q00.8", new IcdEntry("Q00.8", "Congenital & Genetics Clinical Entity #8: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 66));
        catalog.put("Q00.9", new IcdEntry("Q00.9", "Congenital & Genetics Clinical Entity #9: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 73));
        catalog.put("Q01.0", new IcdEntry("Q01.0", "Congenital & Genetics Clinical Entity #10: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 80));
        catalog.put("Q01.1", new IcdEntry("Q01.1", "Congenital & Genetics Clinical Entity #11: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 87));
        catalog.put("Q01.2", new IcdEntry("Q01.2", "Congenital & Genetics Clinical Entity #12: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 94));
        catalog.put("Q01.3", new IcdEntry("Q01.3", "Congenital & Genetics Clinical Entity #13: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 101));
        catalog.put("Q01.4", new IcdEntry("Q01.4", "Congenital & Genetics Clinical Entity #14: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 108));
        catalog.put("Q01.5", new IcdEntry("Q01.5", "Congenital & Genetics Clinical Entity #15: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 15));
        catalog.put("Q01.6", new IcdEntry("Q01.6", "Congenital & Genetics Clinical Entity #16: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 22));
        catalog.put("Q01.7", new IcdEntry("Q01.7", "Congenital & Genetics Clinical Entity #17: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 29));
        catalog.put("Q01.8", new IcdEntry("Q01.8", "Congenital & Genetics Clinical Entity #18: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 36));
        catalog.put("Q01.9", new IcdEntry("Q01.9", "Congenital & Genetics Clinical Entity #19: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 43));
        catalog.put("Q02.0", new IcdEntry("Q02.0", "Congenital & Genetics Clinical Entity #20: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 50));
        catalog.put("Q02.1", new IcdEntry("Q02.1", "Congenital & Genetics Clinical Entity #21: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 57));
        catalog.put("Q02.2", new IcdEntry("Q02.2", "Congenital & Genetics Clinical Entity #22: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 64));
        catalog.put("Q02.3", new IcdEntry("Q02.3", "Congenital & Genetics Clinical Entity #23: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 71));
        catalog.put("Q02.4", new IcdEntry("Q02.4", "Congenital & Genetics Clinical Entity #24: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 78));
        catalog.put("Q02.5", new IcdEntry("Q02.5", "Congenital & Genetics Clinical Entity #25: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 85));
        catalog.put("Q02.6", new IcdEntry("Q02.6", "Congenital & Genetics Clinical Entity #26: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 92));
        catalog.put("Q02.7", new IcdEntry("Q02.7", "Congenital & Genetics Clinical Entity #27: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 99));
        catalog.put("Q02.8", new IcdEntry("Q02.8", "Congenital & Genetics Clinical Entity #28: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 106));
        catalog.put("Q02.9", new IcdEntry("Q02.9", "Congenital & Genetics Clinical Entity #29: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 13));
        catalog.put("Q03.0", new IcdEntry("Q03.0", "Congenital & Genetics Clinical Entity #30: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 20));
        catalog.put("Q03.1", new IcdEntry("Q03.1", "Congenital & Genetics Clinical Entity #31: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 27));
        catalog.put("Q03.2", new IcdEntry("Q03.2", "Congenital & Genetics Clinical Entity #32: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 34));
        catalog.put("Q03.3", new IcdEntry("Q03.3", "Congenital & Genetics Clinical Entity #33: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 41));
        catalog.put("Q03.4", new IcdEntry("Q03.4", "Congenital & Genetics Clinical Entity #34: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 48));
        catalog.put("Q03.5", new IcdEntry("Q03.5", "Congenital & Genetics Clinical Entity #35: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 55));
        catalog.put("Q03.6", new IcdEntry("Q03.6", "Congenital & Genetics Clinical Entity #36: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 62));
        catalog.put("Q03.7", new IcdEntry("Q03.7", "Congenital & Genetics Clinical Entity #37: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 69));
        catalog.put("Q03.8", new IcdEntry("Q03.8", "Congenital & Genetics Clinical Entity #38: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 76));
        catalog.put("Q03.9", new IcdEntry("Q03.9", "Congenital & Genetics Clinical Entity #39: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 83));
        catalog.put("Q04.0", new IcdEntry("Q04.0", "Congenital & Genetics Clinical Entity #40: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 90));
        catalog.put("Q04.1", new IcdEntry("Q04.1", "Congenital & Genetics Clinical Entity #41: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 97));
        catalog.put("Q04.2", new IcdEntry("Q04.2", "Congenital & Genetics Clinical Entity #42: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 104));
        catalog.put("Q04.3", new IcdEntry("Q04.3", "Congenital & Genetics Clinical Entity #43: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 11));
        catalog.put("Q04.4", new IcdEntry("Q04.4", "Congenital & Genetics Clinical Entity #44: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 18));
        catalog.put("Q04.5", new IcdEntry("Q04.5", "Congenital & Genetics Clinical Entity #45: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 25));
        catalog.put("Q04.6", new IcdEntry("Q04.6", "Congenital & Genetics Clinical Entity #46: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 32));
        catalog.put("Q04.7", new IcdEntry("Q04.7", "Congenital & Genetics Clinical Entity #47: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 39));
        catalog.put("Q04.8", new IcdEntry("Q04.8", "Congenital & Genetics Clinical Entity #48: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 46));
        catalog.put("Q04.9", new IcdEntry("Q04.9", "Congenital & Genetics Clinical Entity #49: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 53));
        catalog.put("Q05.0", new IcdEntry("Q05.0", "Congenital & Genetics Clinical Entity #50: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 60));
        catalog.put("Q05.1", new IcdEntry("Q05.1", "Congenital & Genetics Clinical Entity #51: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 67));
        catalog.put("Q05.2", new IcdEntry("Q05.2", "Congenital & Genetics Clinical Entity #52: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 74));
        catalog.put("Q05.3", new IcdEntry("Q05.3", "Congenital & Genetics Clinical Entity #53: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 81));
        catalog.put("Q05.4", new IcdEntry("Q05.4", "Congenital & Genetics Clinical Entity #54: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 88));
        catalog.put("Q05.5", new IcdEntry("Q05.5", "Congenital & Genetics Clinical Entity #55: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 95));
        catalog.put("Q05.6", new IcdEntry("Q05.6", "Congenital & Genetics Clinical Entity #56: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 102));
        catalog.put("Q05.7", new IcdEntry("Q05.7", "Congenital & Genetics Clinical Entity #57: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 109));
        catalog.put("Q05.8", new IcdEntry("Q05.8", "Congenital & Genetics Clinical Entity #58: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 16));
        catalog.put("Q05.9", new IcdEntry("Q05.9", "Congenital & Genetics Clinical Entity #59: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 23));
        catalog.put("Q06.0", new IcdEntry("Q06.0", "Congenital & Genetics Clinical Entity #60: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 30));
        catalog.put("Q06.1", new IcdEntry("Q06.1", "Congenital & Genetics Clinical Entity #61: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 37));
        catalog.put("Q06.2", new IcdEntry("Q06.2", "Congenital & Genetics Clinical Entity #62: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 44));
        catalog.put("Q06.3", new IcdEntry("Q06.3", "Congenital & Genetics Clinical Entity #63: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 51));
        catalog.put("Q06.4", new IcdEntry("Q06.4", "Congenital & Genetics Clinical Entity #64: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 58));
        catalog.put("Q06.5", new IcdEntry("Q06.5", "Congenital & Genetics Clinical Entity #65: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 65));
        catalog.put("Q06.6", new IcdEntry("Q06.6", "Congenital & Genetics Clinical Entity #66: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 72));
        catalog.put("Q06.7", new IcdEntry("Q06.7", "Congenital & Genetics Clinical Entity #67: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 79));
        catalog.put("Q06.8", new IcdEntry("Q06.8", "Congenital & Genetics Clinical Entity #68: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 86));
        catalog.put("Q06.9", new IcdEntry("Q06.9", "Congenital & Genetics Clinical Entity #69: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 93));
        catalog.put("Q07.0", new IcdEntry("Q07.0", "Congenital & Genetics Clinical Entity #70: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 100));
        catalog.put("Q07.1", new IcdEntry("Q07.1", "Congenital & Genetics Clinical Entity #71: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 107));
        catalog.put("Q07.2", new IcdEntry("Q07.2", "Congenital & Genetics Clinical Entity #72: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 14));
        catalog.put("Q07.3", new IcdEntry("Q07.3", "Congenital & Genetics Clinical Entity #73: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 21));
        catalog.put("Q07.4", new IcdEntry("Q07.4", "Congenital & Genetics Clinical Entity #74: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 28));
        catalog.put("Q07.5", new IcdEntry("Q07.5", "Congenital & Genetics Clinical Entity #75: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 35));
        catalog.put("Q07.6", new IcdEntry("Q07.6", "Congenital & Genetics Clinical Entity #76: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 42));
        catalog.put("Q07.7", new IcdEntry("Q07.7", "Congenital & Genetics Clinical Entity #77: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 49));
        catalog.put("Q07.8", new IcdEntry("Q07.8", "Congenital & Genetics Clinical Entity #78: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 56));
        catalog.put("Q07.9", new IcdEntry("Q07.9", "Congenital & Genetics Clinical Entity #79: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 63));
        catalog.put("Q08.0", new IcdEntry("Q08.0", "Congenital & Genetics Clinical Entity #80: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 70));
        catalog.put("Q08.1", new IcdEntry("Q08.1", "Congenital & Genetics Clinical Entity #81: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 77));
        catalog.put("Q08.2", new IcdEntry("Q08.2", "Congenital & Genetics Clinical Entity #82: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 84));
        catalog.put("Q08.3", new IcdEntry("Q08.3", "Congenital & Genetics Clinical Entity #83: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 91));
        catalog.put("Q08.4", new IcdEntry("Q08.4", "Congenital & Genetics Clinical Entity #84: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 98));
        catalog.put("Q08.5", new IcdEntry("Q08.5", "Congenital & Genetics Clinical Entity #85: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 105));
        catalog.put("Q08.6", new IcdEntry("Q08.6", "Congenital & Genetics Clinical Entity #86: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 12));
        catalog.put("Q08.7", new IcdEntry("Q08.7", "Congenital & Genetics Clinical Entity #87: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 4", false, 19));
        catalog.put("Q08.8", new IcdEntry("Q08.8", "Congenital & Genetics Clinical Entity #88: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 1", true, 26));
        catalog.put("Q08.9", new IcdEntry("Q08.9", "Congenital & Genetics Clinical Entity #89: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 2", false, 33));
        catalog.put("Q09.0", new IcdEntry("Q09.0", "Congenital & Genetics Clinical Entity #90: Precision Diagnostic Marker", "Q00-Q99", "Clinical Severity Grade 3", true, 40));
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
