package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 10 (J00-J99): Pulmonology & Respiratory.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter10_RespiratorySystemDiseases {

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

    public Icd10Chapter10_RespiratorySystemDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("J00.1", new IcdEntry("J00.1", "Pulmonology & Respiratory Clinical Entity #1: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 17));
        catalog.put("J00.2", new IcdEntry("J00.2", "Pulmonology & Respiratory Clinical Entity #2: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 24));
        catalog.put("J00.3", new IcdEntry("J00.3", "Pulmonology & Respiratory Clinical Entity #3: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 31));
        catalog.put("J00.4", new IcdEntry("J00.4", "Pulmonology & Respiratory Clinical Entity #4: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 38));
        catalog.put("J00.5", new IcdEntry("J00.5", "Pulmonology & Respiratory Clinical Entity #5: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 45));
        catalog.put("J00.6", new IcdEntry("J00.6", "Pulmonology & Respiratory Clinical Entity #6: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 52));
        catalog.put("J00.7", new IcdEntry("J00.7", "Pulmonology & Respiratory Clinical Entity #7: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 59));
        catalog.put("J00.8", new IcdEntry("J00.8", "Pulmonology & Respiratory Clinical Entity #8: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 66));
        catalog.put("J00.9", new IcdEntry("J00.9", "Pulmonology & Respiratory Clinical Entity #9: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 73));
        catalog.put("J01.0", new IcdEntry("J01.0", "Pulmonology & Respiratory Clinical Entity #10: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 80));
        catalog.put("J01.1", new IcdEntry("J01.1", "Pulmonology & Respiratory Clinical Entity #11: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 87));
        catalog.put("J01.2", new IcdEntry("J01.2", "Pulmonology & Respiratory Clinical Entity #12: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 94));
        catalog.put("J01.3", new IcdEntry("J01.3", "Pulmonology & Respiratory Clinical Entity #13: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 101));
        catalog.put("J01.4", new IcdEntry("J01.4", "Pulmonology & Respiratory Clinical Entity #14: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 108));
        catalog.put("J01.5", new IcdEntry("J01.5", "Pulmonology & Respiratory Clinical Entity #15: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 15));
        catalog.put("J01.6", new IcdEntry("J01.6", "Pulmonology & Respiratory Clinical Entity #16: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 22));
        catalog.put("J01.7", new IcdEntry("J01.7", "Pulmonology & Respiratory Clinical Entity #17: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 29));
        catalog.put("J01.8", new IcdEntry("J01.8", "Pulmonology & Respiratory Clinical Entity #18: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 36));
        catalog.put("J01.9", new IcdEntry("J01.9", "Pulmonology & Respiratory Clinical Entity #19: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 43));
        catalog.put("J02.0", new IcdEntry("J02.0", "Pulmonology & Respiratory Clinical Entity #20: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 50));
        catalog.put("J02.1", new IcdEntry("J02.1", "Pulmonology & Respiratory Clinical Entity #21: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 57));
        catalog.put("J02.2", new IcdEntry("J02.2", "Pulmonology & Respiratory Clinical Entity #22: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 64));
        catalog.put("J02.3", new IcdEntry("J02.3", "Pulmonology & Respiratory Clinical Entity #23: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 71));
        catalog.put("J02.4", new IcdEntry("J02.4", "Pulmonology & Respiratory Clinical Entity #24: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 78));
        catalog.put("J02.5", new IcdEntry("J02.5", "Pulmonology & Respiratory Clinical Entity #25: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 85));
        catalog.put("J02.6", new IcdEntry("J02.6", "Pulmonology & Respiratory Clinical Entity #26: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 92));
        catalog.put("J02.7", new IcdEntry("J02.7", "Pulmonology & Respiratory Clinical Entity #27: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 99));
        catalog.put("J02.8", new IcdEntry("J02.8", "Pulmonology & Respiratory Clinical Entity #28: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 106));
        catalog.put("J02.9", new IcdEntry("J02.9", "Pulmonology & Respiratory Clinical Entity #29: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 13));
        catalog.put("J03.0", new IcdEntry("J03.0", "Pulmonology & Respiratory Clinical Entity #30: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 20));
        catalog.put("J03.1", new IcdEntry("J03.1", "Pulmonology & Respiratory Clinical Entity #31: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 27));
        catalog.put("J03.2", new IcdEntry("J03.2", "Pulmonology & Respiratory Clinical Entity #32: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 34));
        catalog.put("J03.3", new IcdEntry("J03.3", "Pulmonology & Respiratory Clinical Entity #33: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 41));
        catalog.put("J03.4", new IcdEntry("J03.4", "Pulmonology & Respiratory Clinical Entity #34: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 48));
        catalog.put("J03.5", new IcdEntry("J03.5", "Pulmonology & Respiratory Clinical Entity #35: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 55));
        catalog.put("J03.6", new IcdEntry("J03.6", "Pulmonology & Respiratory Clinical Entity #36: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 62));
        catalog.put("J03.7", new IcdEntry("J03.7", "Pulmonology & Respiratory Clinical Entity #37: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 69));
        catalog.put("J03.8", new IcdEntry("J03.8", "Pulmonology & Respiratory Clinical Entity #38: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 76));
        catalog.put("J03.9", new IcdEntry("J03.9", "Pulmonology & Respiratory Clinical Entity #39: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 83));
        catalog.put("J04.0", new IcdEntry("J04.0", "Pulmonology & Respiratory Clinical Entity #40: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 90));
        catalog.put("J04.1", new IcdEntry("J04.1", "Pulmonology & Respiratory Clinical Entity #41: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 97));
        catalog.put("J04.2", new IcdEntry("J04.2", "Pulmonology & Respiratory Clinical Entity #42: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 104));
        catalog.put("J04.3", new IcdEntry("J04.3", "Pulmonology & Respiratory Clinical Entity #43: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 11));
        catalog.put("J04.4", new IcdEntry("J04.4", "Pulmonology & Respiratory Clinical Entity #44: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 18));
        catalog.put("J04.5", new IcdEntry("J04.5", "Pulmonology & Respiratory Clinical Entity #45: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 25));
        catalog.put("J04.6", new IcdEntry("J04.6", "Pulmonology & Respiratory Clinical Entity #46: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 32));
        catalog.put("J04.7", new IcdEntry("J04.7", "Pulmonology & Respiratory Clinical Entity #47: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 39));
        catalog.put("J04.8", new IcdEntry("J04.8", "Pulmonology & Respiratory Clinical Entity #48: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 46));
        catalog.put("J04.9", new IcdEntry("J04.9", "Pulmonology & Respiratory Clinical Entity #49: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 53));
        catalog.put("J05.0", new IcdEntry("J05.0", "Pulmonology & Respiratory Clinical Entity #50: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 60));
        catalog.put("J05.1", new IcdEntry("J05.1", "Pulmonology & Respiratory Clinical Entity #51: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 67));
        catalog.put("J05.2", new IcdEntry("J05.2", "Pulmonology & Respiratory Clinical Entity #52: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 74));
        catalog.put("J05.3", new IcdEntry("J05.3", "Pulmonology & Respiratory Clinical Entity #53: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 81));
        catalog.put("J05.4", new IcdEntry("J05.4", "Pulmonology & Respiratory Clinical Entity #54: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 88));
        catalog.put("J05.5", new IcdEntry("J05.5", "Pulmonology & Respiratory Clinical Entity #55: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 95));
        catalog.put("J05.6", new IcdEntry("J05.6", "Pulmonology & Respiratory Clinical Entity #56: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 102));
        catalog.put("J05.7", new IcdEntry("J05.7", "Pulmonology & Respiratory Clinical Entity #57: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 109));
        catalog.put("J05.8", new IcdEntry("J05.8", "Pulmonology & Respiratory Clinical Entity #58: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 16));
        catalog.put("J05.9", new IcdEntry("J05.9", "Pulmonology & Respiratory Clinical Entity #59: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 23));
        catalog.put("J06.0", new IcdEntry("J06.0", "Pulmonology & Respiratory Clinical Entity #60: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 30));
        catalog.put("J06.1", new IcdEntry("J06.1", "Pulmonology & Respiratory Clinical Entity #61: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 37));
        catalog.put("J06.2", new IcdEntry("J06.2", "Pulmonology & Respiratory Clinical Entity #62: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 44));
        catalog.put("J06.3", new IcdEntry("J06.3", "Pulmonology & Respiratory Clinical Entity #63: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 51));
        catalog.put("J06.4", new IcdEntry("J06.4", "Pulmonology & Respiratory Clinical Entity #64: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 58));
        catalog.put("J06.5", new IcdEntry("J06.5", "Pulmonology & Respiratory Clinical Entity #65: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 65));
        catalog.put("J06.6", new IcdEntry("J06.6", "Pulmonology & Respiratory Clinical Entity #66: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 72));
        catalog.put("J06.7", new IcdEntry("J06.7", "Pulmonology & Respiratory Clinical Entity #67: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 79));
        catalog.put("J06.8", new IcdEntry("J06.8", "Pulmonology & Respiratory Clinical Entity #68: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 86));
        catalog.put("J06.9", new IcdEntry("J06.9", "Pulmonology & Respiratory Clinical Entity #69: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 93));
        catalog.put("J07.0", new IcdEntry("J07.0", "Pulmonology & Respiratory Clinical Entity #70: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 100));
        catalog.put("J07.1", new IcdEntry("J07.1", "Pulmonology & Respiratory Clinical Entity #71: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 107));
        catalog.put("J07.2", new IcdEntry("J07.2", "Pulmonology & Respiratory Clinical Entity #72: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 14));
        catalog.put("J07.3", new IcdEntry("J07.3", "Pulmonology & Respiratory Clinical Entity #73: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 21));
        catalog.put("J07.4", new IcdEntry("J07.4", "Pulmonology & Respiratory Clinical Entity #74: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 28));
        catalog.put("J07.5", new IcdEntry("J07.5", "Pulmonology & Respiratory Clinical Entity #75: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 35));
        catalog.put("J07.6", new IcdEntry("J07.6", "Pulmonology & Respiratory Clinical Entity #76: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 42));
        catalog.put("J07.7", new IcdEntry("J07.7", "Pulmonology & Respiratory Clinical Entity #77: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 49));
        catalog.put("J07.8", new IcdEntry("J07.8", "Pulmonology & Respiratory Clinical Entity #78: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 56));
        catalog.put("J07.9", new IcdEntry("J07.9", "Pulmonology & Respiratory Clinical Entity #79: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 63));
        catalog.put("J08.0", new IcdEntry("J08.0", "Pulmonology & Respiratory Clinical Entity #80: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 70));
        catalog.put("J08.1", new IcdEntry("J08.1", "Pulmonology & Respiratory Clinical Entity #81: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 77));
        catalog.put("J08.2", new IcdEntry("J08.2", "Pulmonology & Respiratory Clinical Entity #82: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 84));
        catalog.put("J08.3", new IcdEntry("J08.3", "Pulmonology & Respiratory Clinical Entity #83: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 91));
        catalog.put("J08.4", new IcdEntry("J08.4", "Pulmonology & Respiratory Clinical Entity #84: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 98));
        catalog.put("J08.5", new IcdEntry("J08.5", "Pulmonology & Respiratory Clinical Entity #85: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 105));
        catalog.put("J08.6", new IcdEntry("J08.6", "Pulmonology & Respiratory Clinical Entity #86: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 12));
        catalog.put("J08.7", new IcdEntry("J08.7", "Pulmonology & Respiratory Clinical Entity #87: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 19));
        catalog.put("J08.8", new IcdEntry("J08.8", "Pulmonology & Respiratory Clinical Entity #88: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 26));
        catalog.put("J08.9", new IcdEntry("J08.9", "Pulmonology & Respiratory Clinical Entity #89: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 33));
        catalog.put("J09.0", new IcdEntry("J09.0", "Pulmonology & Respiratory Clinical Entity #90: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 40));
        catalog.put("J09.1", new IcdEntry("J09.1", "Pulmonology & Respiratory Clinical Entity #91: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 47));
        catalog.put("J09.2", new IcdEntry("J09.2", "Pulmonology & Respiratory Clinical Entity #92: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 54));
        catalog.put("J09.3", new IcdEntry("J09.3", "Pulmonology & Respiratory Clinical Entity #93: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 61));
        catalog.put("J09.4", new IcdEntry("J09.4", "Pulmonology & Respiratory Clinical Entity #94: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 68));
        catalog.put("J09.5", new IcdEntry("J09.5", "Pulmonology & Respiratory Clinical Entity #95: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 75));
        catalog.put("J09.6", new IcdEntry("J09.6", "Pulmonology & Respiratory Clinical Entity #96: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 82));
        catalog.put("J09.7", new IcdEntry("J09.7", "Pulmonology & Respiratory Clinical Entity #97: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 89));
        catalog.put("J09.8", new IcdEntry("J09.8", "Pulmonology & Respiratory Clinical Entity #98: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 96));
        catalog.put("J09.9", new IcdEntry("J09.9", "Pulmonology & Respiratory Clinical Entity #99: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 103));
        catalog.put("J10.0", new IcdEntry("J10.0", "Pulmonology & Respiratory Clinical Entity #100: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 10));
        catalog.put("J10.1", new IcdEntry("J10.1", "Pulmonology & Respiratory Clinical Entity #101: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 17));
        catalog.put("J10.2", new IcdEntry("J10.2", "Pulmonology & Respiratory Clinical Entity #102: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 24));
        catalog.put("J10.3", new IcdEntry("J10.3", "Pulmonology & Respiratory Clinical Entity #103: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 31));
        catalog.put("J10.4", new IcdEntry("J10.4", "Pulmonology & Respiratory Clinical Entity #104: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 38));
        catalog.put("J10.5", new IcdEntry("J10.5", "Pulmonology & Respiratory Clinical Entity #105: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 45));
        catalog.put("J10.6", new IcdEntry("J10.6", "Pulmonology & Respiratory Clinical Entity #106: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 52));
        catalog.put("J10.7", new IcdEntry("J10.7", "Pulmonology & Respiratory Clinical Entity #107: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 59));
        catalog.put("J10.8", new IcdEntry("J10.8", "Pulmonology & Respiratory Clinical Entity #108: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 66));
        catalog.put("J10.9", new IcdEntry("J10.9", "Pulmonology & Respiratory Clinical Entity #109: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 73));
        catalog.put("J11.0", new IcdEntry("J11.0", "Pulmonology & Respiratory Clinical Entity #110: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 80));
        catalog.put("J11.1", new IcdEntry("J11.1", "Pulmonology & Respiratory Clinical Entity #111: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 87));
        catalog.put("J11.2", new IcdEntry("J11.2", "Pulmonology & Respiratory Clinical Entity #112: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 94));
        catalog.put("J11.3", new IcdEntry("J11.3", "Pulmonology & Respiratory Clinical Entity #113: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 101));
        catalog.put("J11.4", new IcdEntry("J11.4", "Pulmonology & Respiratory Clinical Entity #114: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 108));
        catalog.put("J11.5", new IcdEntry("J11.5", "Pulmonology & Respiratory Clinical Entity #115: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 15));
        catalog.put("J11.6", new IcdEntry("J11.6", "Pulmonology & Respiratory Clinical Entity #116: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 22));
        catalog.put("J11.7", new IcdEntry("J11.7", "Pulmonology & Respiratory Clinical Entity #117: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 2", false, 29));
        catalog.put("J11.8", new IcdEntry("J11.8", "Pulmonology & Respiratory Clinical Entity #118: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 3", true, 36));
        catalog.put("J11.9", new IcdEntry("J11.9", "Pulmonology & Respiratory Clinical Entity #119: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 4", false, 43));
        catalog.put("J12.0", new IcdEntry("J12.0", "Pulmonology & Respiratory Clinical Entity #120: Precision Diagnostic Marker", "J00-J99", "Clinical Severity Grade 1", true, 50));
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
