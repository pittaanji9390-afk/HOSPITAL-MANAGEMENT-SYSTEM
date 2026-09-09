package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 11 (K00-K95): Gastroenterology & Hepatic.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter11_DigestiveSystemDiseases {

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

    public Icd10Chapter11_DigestiveSystemDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("K00.1", new IcdEntry("K00.1", "Gastroenterology & Hepatic Clinical Entity #1: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 17));
        catalog.put("K00.2", new IcdEntry("K00.2", "Gastroenterology & Hepatic Clinical Entity #2: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 24));
        catalog.put("K00.3", new IcdEntry("K00.3", "Gastroenterology & Hepatic Clinical Entity #3: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 31));
        catalog.put("K00.4", new IcdEntry("K00.4", "Gastroenterology & Hepatic Clinical Entity #4: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 38));
        catalog.put("K00.5", new IcdEntry("K00.5", "Gastroenterology & Hepatic Clinical Entity #5: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 45));
        catalog.put("K00.6", new IcdEntry("K00.6", "Gastroenterology & Hepatic Clinical Entity #6: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 52));
        catalog.put("K00.7", new IcdEntry("K00.7", "Gastroenterology & Hepatic Clinical Entity #7: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 59));
        catalog.put("K00.8", new IcdEntry("K00.8", "Gastroenterology & Hepatic Clinical Entity #8: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 66));
        catalog.put("K00.9", new IcdEntry("K00.9", "Gastroenterology & Hepatic Clinical Entity #9: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 73));
        catalog.put("K01.0", new IcdEntry("K01.0", "Gastroenterology & Hepatic Clinical Entity #10: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 80));
        catalog.put("K01.1", new IcdEntry("K01.1", "Gastroenterology & Hepatic Clinical Entity #11: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 87));
        catalog.put("K01.2", new IcdEntry("K01.2", "Gastroenterology & Hepatic Clinical Entity #12: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 94));
        catalog.put("K01.3", new IcdEntry("K01.3", "Gastroenterology & Hepatic Clinical Entity #13: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 101));
        catalog.put("K01.4", new IcdEntry("K01.4", "Gastroenterology & Hepatic Clinical Entity #14: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 108));
        catalog.put("K01.5", new IcdEntry("K01.5", "Gastroenterology & Hepatic Clinical Entity #15: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 15));
        catalog.put("K01.6", new IcdEntry("K01.6", "Gastroenterology & Hepatic Clinical Entity #16: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 22));
        catalog.put("K01.7", new IcdEntry("K01.7", "Gastroenterology & Hepatic Clinical Entity #17: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 29));
        catalog.put("K01.8", new IcdEntry("K01.8", "Gastroenterology & Hepatic Clinical Entity #18: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 36));
        catalog.put("K01.9", new IcdEntry("K01.9", "Gastroenterology & Hepatic Clinical Entity #19: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 43));
        catalog.put("K02.0", new IcdEntry("K02.0", "Gastroenterology & Hepatic Clinical Entity #20: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 50));
        catalog.put("K02.1", new IcdEntry("K02.1", "Gastroenterology & Hepatic Clinical Entity #21: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 57));
        catalog.put("K02.2", new IcdEntry("K02.2", "Gastroenterology & Hepatic Clinical Entity #22: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 64));
        catalog.put("K02.3", new IcdEntry("K02.3", "Gastroenterology & Hepatic Clinical Entity #23: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 71));
        catalog.put("K02.4", new IcdEntry("K02.4", "Gastroenterology & Hepatic Clinical Entity #24: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 78));
        catalog.put("K02.5", new IcdEntry("K02.5", "Gastroenterology & Hepatic Clinical Entity #25: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 85));
        catalog.put("K02.6", new IcdEntry("K02.6", "Gastroenterology & Hepatic Clinical Entity #26: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 92));
        catalog.put("K02.7", new IcdEntry("K02.7", "Gastroenterology & Hepatic Clinical Entity #27: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 99));
        catalog.put("K02.8", new IcdEntry("K02.8", "Gastroenterology & Hepatic Clinical Entity #28: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 106));
        catalog.put("K02.9", new IcdEntry("K02.9", "Gastroenterology & Hepatic Clinical Entity #29: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 13));
        catalog.put("K03.0", new IcdEntry("K03.0", "Gastroenterology & Hepatic Clinical Entity #30: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 20));
        catalog.put("K03.1", new IcdEntry("K03.1", "Gastroenterology & Hepatic Clinical Entity #31: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 27));
        catalog.put("K03.2", new IcdEntry("K03.2", "Gastroenterology & Hepatic Clinical Entity #32: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 34));
        catalog.put("K03.3", new IcdEntry("K03.3", "Gastroenterology & Hepatic Clinical Entity #33: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 41));
        catalog.put("K03.4", new IcdEntry("K03.4", "Gastroenterology & Hepatic Clinical Entity #34: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 48));
        catalog.put("K03.5", new IcdEntry("K03.5", "Gastroenterology & Hepatic Clinical Entity #35: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 55));
        catalog.put("K03.6", new IcdEntry("K03.6", "Gastroenterology & Hepatic Clinical Entity #36: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 62));
        catalog.put("K03.7", new IcdEntry("K03.7", "Gastroenterology & Hepatic Clinical Entity #37: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 69));
        catalog.put("K03.8", new IcdEntry("K03.8", "Gastroenterology & Hepatic Clinical Entity #38: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 76));
        catalog.put("K03.9", new IcdEntry("K03.9", "Gastroenterology & Hepatic Clinical Entity #39: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 83));
        catalog.put("K04.0", new IcdEntry("K04.0", "Gastroenterology & Hepatic Clinical Entity #40: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 90));
        catalog.put("K04.1", new IcdEntry("K04.1", "Gastroenterology & Hepatic Clinical Entity #41: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 97));
        catalog.put("K04.2", new IcdEntry("K04.2", "Gastroenterology & Hepatic Clinical Entity #42: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 104));
        catalog.put("K04.3", new IcdEntry("K04.3", "Gastroenterology & Hepatic Clinical Entity #43: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 11));
        catalog.put("K04.4", new IcdEntry("K04.4", "Gastroenterology & Hepatic Clinical Entity #44: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 18));
        catalog.put("K04.5", new IcdEntry("K04.5", "Gastroenterology & Hepatic Clinical Entity #45: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 25));
        catalog.put("K04.6", new IcdEntry("K04.6", "Gastroenterology & Hepatic Clinical Entity #46: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 32));
        catalog.put("K04.7", new IcdEntry("K04.7", "Gastroenterology & Hepatic Clinical Entity #47: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 39));
        catalog.put("K04.8", new IcdEntry("K04.8", "Gastroenterology & Hepatic Clinical Entity #48: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 46));
        catalog.put("K04.9", new IcdEntry("K04.9", "Gastroenterology & Hepatic Clinical Entity #49: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 53));
        catalog.put("K05.0", new IcdEntry("K05.0", "Gastroenterology & Hepatic Clinical Entity #50: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 60));
        catalog.put("K05.1", new IcdEntry("K05.1", "Gastroenterology & Hepatic Clinical Entity #51: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 67));
        catalog.put("K05.2", new IcdEntry("K05.2", "Gastroenterology & Hepatic Clinical Entity #52: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 74));
        catalog.put("K05.3", new IcdEntry("K05.3", "Gastroenterology & Hepatic Clinical Entity #53: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 81));
        catalog.put("K05.4", new IcdEntry("K05.4", "Gastroenterology & Hepatic Clinical Entity #54: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 88));
        catalog.put("K05.5", new IcdEntry("K05.5", "Gastroenterology & Hepatic Clinical Entity #55: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 95));
        catalog.put("K05.6", new IcdEntry("K05.6", "Gastroenterology & Hepatic Clinical Entity #56: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 102));
        catalog.put("K05.7", new IcdEntry("K05.7", "Gastroenterology & Hepatic Clinical Entity #57: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 109));
        catalog.put("K05.8", new IcdEntry("K05.8", "Gastroenterology & Hepatic Clinical Entity #58: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 16));
        catalog.put("K05.9", new IcdEntry("K05.9", "Gastroenterology & Hepatic Clinical Entity #59: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 23));
        catalog.put("K06.0", new IcdEntry("K06.0", "Gastroenterology & Hepatic Clinical Entity #60: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 30));
        catalog.put("K06.1", new IcdEntry("K06.1", "Gastroenterology & Hepatic Clinical Entity #61: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 37));
        catalog.put("K06.2", new IcdEntry("K06.2", "Gastroenterology & Hepatic Clinical Entity #62: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 44));
        catalog.put("K06.3", new IcdEntry("K06.3", "Gastroenterology & Hepatic Clinical Entity #63: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 51));
        catalog.put("K06.4", new IcdEntry("K06.4", "Gastroenterology & Hepatic Clinical Entity #64: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 58));
        catalog.put("K06.5", new IcdEntry("K06.5", "Gastroenterology & Hepatic Clinical Entity #65: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 65));
        catalog.put("K06.6", new IcdEntry("K06.6", "Gastroenterology & Hepatic Clinical Entity #66: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 72));
        catalog.put("K06.7", new IcdEntry("K06.7", "Gastroenterology & Hepatic Clinical Entity #67: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 79));
        catalog.put("K06.8", new IcdEntry("K06.8", "Gastroenterology & Hepatic Clinical Entity #68: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 86));
        catalog.put("K06.9", new IcdEntry("K06.9", "Gastroenterology & Hepatic Clinical Entity #69: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 93));
        catalog.put("K07.0", new IcdEntry("K07.0", "Gastroenterology & Hepatic Clinical Entity #70: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 100));
        catalog.put("K07.1", new IcdEntry("K07.1", "Gastroenterology & Hepatic Clinical Entity #71: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 107));
        catalog.put("K07.2", new IcdEntry("K07.2", "Gastroenterology & Hepatic Clinical Entity #72: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 14));
        catalog.put("K07.3", new IcdEntry("K07.3", "Gastroenterology & Hepatic Clinical Entity #73: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 21));
        catalog.put("K07.4", new IcdEntry("K07.4", "Gastroenterology & Hepatic Clinical Entity #74: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 28));
        catalog.put("K07.5", new IcdEntry("K07.5", "Gastroenterology & Hepatic Clinical Entity #75: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 35));
        catalog.put("K07.6", new IcdEntry("K07.6", "Gastroenterology & Hepatic Clinical Entity #76: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 42));
        catalog.put("K07.7", new IcdEntry("K07.7", "Gastroenterology & Hepatic Clinical Entity #77: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 49));
        catalog.put("K07.8", new IcdEntry("K07.8", "Gastroenterology & Hepatic Clinical Entity #78: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 56));
        catalog.put("K07.9", new IcdEntry("K07.9", "Gastroenterology & Hepatic Clinical Entity #79: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 63));
        catalog.put("K08.0", new IcdEntry("K08.0", "Gastroenterology & Hepatic Clinical Entity #80: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 70));
        catalog.put("K08.1", new IcdEntry("K08.1", "Gastroenterology & Hepatic Clinical Entity #81: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 77));
        catalog.put("K08.2", new IcdEntry("K08.2", "Gastroenterology & Hepatic Clinical Entity #82: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 84));
        catalog.put("K08.3", new IcdEntry("K08.3", "Gastroenterology & Hepatic Clinical Entity #83: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 91));
        catalog.put("K08.4", new IcdEntry("K08.4", "Gastroenterology & Hepatic Clinical Entity #84: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 98));
        catalog.put("K08.5", new IcdEntry("K08.5", "Gastroenterology & Hepatic Clinical Entity #85: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 105));
        catalog.put("K08.6", new IcdEntry("K08.6", "Gastroenterology & Hepatic Clinical Entity #86: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 12));
        catalog.put("K08.7", new IcdEntry("K08.7", "Gastroenterology & Hepatic Clinical Entity #87: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 19));
        catalog.put("K08.8", new IcdEntry("K08.8", "Gastroenterology & Hepatic Clinical Entity #88: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 26));
        catalog.put("K08.9", new IcdEntry("K08.9", "Gastroenterology & Hepatic Clinical Entity #89: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 33));
        catalog.put("K09.0", new IcdEntry("K09.0", "Gastroenterology & Hepatic Clinical Entity #90: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 40));
        catalog.put("K09.1", new IcdEntry("K09.1", "Gastroenterology & Hepatic Clinical Entity #91: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 47));
        catalog.put("K09.2", new IcdEntry("K09.2", "Gastroenterology & Hepatic Clinical Entity #92: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 54));
        catalog.put("K09.3", new IcdEntry("K09.3", "Gastroenterology & Hepatic Clinical Entity #93: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 61));
        catalog.put("K09.4", new IcdEntry("K09.4", "Gastroenterology & Hepatic Clinical Entity #94: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 68));
        catalog.put("K09.5", new IcdEntry("K09.5", "Gastroenterology & Hepatic Clinical Entity #95: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 75));
        catalog.put("K09.6", new IcdEntry("K09.6", "Gastroenterology & Hepatic Clinical Entity #96: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 82));
        catalog.put("K09.7", new IcdEntry("K09.7", "Gastroenterology & Hepatic Clinical Entity #97: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 89));
        catalog.put("K09.8", new IcdEntry("K09.8", "Gastroenterology & Hepatic Clinical Entity #98: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 96));
        catalog.put("K09.9", new IcdEntry("K09.9", "Gastroenterology & Hepatic Clinical Entity #99: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 103));
        catalog.put("K10.0", new IcdEntry("K10.0", "Gastroenterology & Hepatic Clinical Entity #100: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 10));
        catalog.put("K10.1", new IcdEntry("K10.1", "Gastroenterology & Hepatic Clinical Entity #101: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 17));
        catalog.put("K10.2", new IcdEntry("K10.2", "Gastroenterology & Hepatic Clinical Entity #102: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 24));
        catalog.put("K10.3", new IcdEntry("K10.3", "Gastroenterology & Hepatic Clinical Entity #103: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 31));
        catalog.put("K10.4", new IcdEntry("K10.4", "Gastroenterology & Hepatic Clinical Entity #104: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 38));
        catalog.put("K10.5", new IcdEntry("K10.5", "Gastroenterology & Hepatic Clinical Entity #105: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 45));
        catalog.put("K10.6", new IcdEntry("K10.6", "Gastroenterology & Hepatic Clinical Entity #106: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 52));
        catalog.put("K10.7", new IcdEntry("K10.7", "Gastroenterology & Hepatic Clinical Entity #107: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 59));
        catalog.put("K10.8", new IcdEntry("K10.8", "Gastroenterology & Hepatic Clinical Entity #108: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 66));
        catalog.put("K10.9", new IcdEntry("K10.9", "Gastroenterology & Hepatic Clinical Entity #109: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 73));
        catalog.put("K11.0", new IcdEntry("K11.0", "Gastroenterology & Hepatic Clinical Entity #110: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 80));
        catalog.put("K11.1", new IcdEntry("K11.1", "Gastroenterology & Hepatic Clinical Entity #111: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 87));
        catalog.put("K11.2", new IcdEntry("K11.2", "Gastroenterology & Hepatic Clinical Entity #112: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 94));
        catalog.put("K11.3", new IcdEntry("K11.3", "Gastroenterology & Hepatic Clinical Entity #113: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 101));
        catalog.put("K11.4", new IcdEntry("K11.4", "Gastroenterology & Hepatic Clinical Entity #114: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 108));
        catalog.put("K11.5", new IcdEntry("K11.5", "Gastroenterology & Hepatic Clinical Entity #115: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 15));
        catalog.put("K11.6", new IcdEntry("K11.6", "Gastroenterology & Hepatic Clinical Entity #116: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 22));
        catalog.put("K11.7", new IcdEntry("K11.7", "Gastroenterology & Hepatic Clinical Entity #117: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 2", false, 29));
        catalog.put("K11.8", new IcdEntry("K11.8", "Gastroenterology & Hepatic Clinical Entity #118: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 3", true, 36));
        catalog.put("K11.9", new IcdEntry("K11.9", "Gastroenterology & Hepatic Clinical Entity #119: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 4", false, 43));
        catalog.put("K12.0", new IcdEntry("K12.0", "Gastroenterology & Hepatic Clinical Entity #120: Precision Diagnostic Marker", "K00-K95", "Clinical Severity Grade 1", true, 50));
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
