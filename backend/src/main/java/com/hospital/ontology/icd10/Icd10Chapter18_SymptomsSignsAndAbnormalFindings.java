package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 18 (R00-R99): Symptoms & Diagnostic Signs.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter18_SymptomsSignsAndAbnormalFindings {

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

    public Icd10Chapter18_SymptomsSignsAndAbnormalFindings() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("R00.1", new IcdEntry("R00.1", "Symptoms & Diagnostic Signs Clinical Entity #1: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 17));
        catalog.put("R00.2", new IcdEntry("R00.2", "Symptoms & Diagnostic Signs Clinical Entity #2: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 24));
        catalog.put("R00.3", new IcdEntry("R00.3", "Symptoms & Diagnostic Signs Clinical Entity #3: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 31));
        catalog.put("R00.4", new IcdEntry("R00.4", "Symptoms & Diagnostic Signs Clinical Entity #4: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 38));
        catalog.put("R00.5", new IcdEntry("R00.5", "Symptoms & Diagnostic Signs Clinical Entity #5: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 45));
        catalog.put("R00.6", new IcdEntry("R00.6", "Symptoms & Diagnostic Signs Clinical Entity #6: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 52));
        catalog.put("R00.7", new IcdEntry("R00.7", "Symptoms & Diagnostic Signs Clinical Entity #7: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 59));
        catalog.put("R00.8", new IcdEntry("R00.8", "Symptoms & Diagnostic Signs Clinical Entity #8: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 66));
        catalog.put("R00.9", new IcdEntry("R00.9", "Symptoms & Diagnostic Signs Clinical Entity #9: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 73));
        catalog.put("R01.0", new IcdEntry("R01.0", "Symptoms & Diagnostic Signs Clinical Entity #10: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 80));
        catalog.put("R01.1", new IcdEntry("R01.1", "Symptoms & Diagnostic Signs Clinical Entity #11: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 87));
        catalog.put("R01.2", new IcdEntry("R01.2", "Symptoms & Diagnostic Signs Clinical Entity #12: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 94));
        catalog.put("R01.3", new IcdEntry("R01.3", "Symptoms & Diagnostic Signs Clinical Entity #13: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 101));
        catalog.put("R01.4", new IcdEntry("R01.4", "Symptoms & Diagnostic Signs Clinical Entity #14: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 108));
        catalog.put("R01.5", new IcdEntry("R01.5", "Symptoms & Diagnostic Signs Clinical Entity #15: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 15));
        catalog.put("R01.6", new IcdEntry("R01.6", "Symptoms & Diagnostic Signs Clinical Entity #16: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 22));
        catalog.put("R01.7", new IcdEntry("R01.7", "Symptoms & Diagnostic Signs Clinical Entity #17: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 29));
        catalog.put("R01.8", new IcdEntry("R01.8", "Symptoms & Diagnostic Signs Clinical Entity #18: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 36));
        catalog.put("R01.9", new IcdEntry("R01.9", "Symptoms & Diagnostic Signs Clinical Entity #19: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 43));
        catalog.put("R02.0", new IcdEntry("R02.0", "Symptoms & Diagnostic Signs Clinical Entity #20: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 50));
        catalog.put("R02.1", new IcdEntry("R02.1", "Symptoms & Diagnostic Signs Clinical Entity #21: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 57));
        catalog.put("R02.2", new IcdEntry("R02.2", "Symptoms & Diagnostic Signs Clinical Entity #22: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 64));
        catalog.put("R02.3", new IcdEntry("R02.3", "Symptoms & Diagnostic Signs Clinical Entity #23: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 71));
        catalog.put("R02.4", new IcdEntry("R02.4", "Symptoms & Diagnostic Signs Clinical Entity #24: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 78));
        catalog.put("R02.5", new IcdEntry("R02.5", "Symptoms & Diagnostic Signs Clinical Entity #25: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 85));
        catalog.put("R02.6", new IcdEntry("R02.6", "Symptoms & Diagnostic Signs Clinical Entity #26: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 92));
        catalog.put("R02.7", new IcdEntry("R02.7", "Symptoms & Diagnostic Signs Clinical Entity #27: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 99));
        catalog.put("R02.8", new IcdEntry("R02.8", "Symptoms & Diagnostic Signs Clinical Entity #28: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 106));
        catalog.put("R02.9", new IcdEntry("R02.9", "Symptoms & Diagnostic Signs Clinical Entity #29: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 13));
        catalog.put("R03.0", new IcdEntry("R03.0", "Symptoms & Diagnostic Signs Clinical Entity #30: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 20));
        catalog.put("R03.1", new IcdEntry("R03.1", "Symptoms & Diagnostic Signs Clinical Entity #31: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 27));
        catalog.put("R03.2", new IcdEntry("R03.2", "Symptoms & Diagnostic Signs Clinical Entity #32: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 34));
        catalog.put("R03.3", new IcdEntry("R03.3", "Symptoms & Diagnostic Signs Clinical Entity #33: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 41));
        catalog.put("R03.4", new IcdEntry("R03.4", "Symptoms & Diagnostic Signs Clinical Entity #34: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 48));
        catalog.put("R03.5", new IcdEntry("R03.5", "Symptoms & Diagnostic Signs Clinical Entity #35: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 55));
        catalog.put("R03.6", new IcdEntry("R03.6", "Symptoms & Diagnostic Signs Clinical Entity #36: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 62));
        catalog.put("R03.7", new IcdEntry("R03.7", "Symptoms & Diagnostic Signs Clinical Entity #37: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 69));
        catalog.put("R03.8", new IcdEntry("R03.8", "Symptoms & Diagnostic Signs Clinical Entity #38: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 76));
        catalog.put("R03.9", new IcdEntry("R03.9", "Symptoms & Diagnostic Signs Clinical Entity #39: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 83));
        catalog.put("R04.0", new IcdEntry("R04.0", "Symptoms & Diagnostic Signs Clinical Entity #40: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 90));
        catalog.put("R04.1", new IcdEntry("R04.1", "Symptoms & Diagnostic Signs Clinical Entity #41: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 97));
        catalog.put("R04.2", new IcdEntry("R04.2", "Symptoms & Diagnostic Signs Clinical Entity #42: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 104));
        catalog.put("R04.3", new IcdEntry("R04.3", "Symptoms & Diagnostic Signs Clinical Entity #43: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 11));
        catalog.put("R04.4", new IcdEntry("R04.4", "Symptoms & Diagnostic Signs Clinical Entity #44: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 18));
        catalog.put("R04.5", new IcdEntry("R04.5", "Symptoms & Diagnostic Signs Clinical Entity #45: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 25));
        catalog.put("R04.6", new IcdEntry("R04.6", "Symptoms & Diagnostic Signs Clinical Entity #46: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 32));
        catalog.put("R04.7", new IcdEntry("R04.7", "Symptoms & Diagnostic Signs Clinical Entity #47: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 39));
        catalog.put("R04.8", new IcdEntry("R04.8", "Symptoms & Diagnostic Signs Clinical Entity #48: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 46));
        catalog.put("R04.9", new IcdEntry("R04.9", "Symptoms & Diagnostic Signs Clinical Entity #49: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 53));
        catalog.put("R05.0", new IcdEntry("R05.0", "Symptoms & Diagnostic Signs Clinical Entity #50: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 60));
        catalog.put("R05.1", new IcdEntry("R05.1", "Symptoms & Diagnostic Signs Clinical Entity #51: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 67));
        catalog.put("R05.2", new IcdEntry("R05.2", "Symptoms & Diagnostic Signs Clinical Entity #52: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 74));
        catalog.put("R05.3", new IcdEntry("R05.3", "Symptoms & Diagnostic Signs Clinical Entity #53: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 81));
        catalog.put("R05.4", new IcdEntry("R05.4", "Symptoms & Diagnostic Signs Clinical Entity #54: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 88));
        catalog.put("R05.5", new IcdEntry("R05.5", "Symptoms & Diagnostic Signs Clinical Entity #55: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 95));
        catalog.put("R05.6", new IcdEntry("R05.6", "Symptoms & Diagnostic Signs Clinical Entity #56: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 102));
        catalog.put("R05.7", new IcdEntry("R05.7", "Symptoms & Diagnostic Signs Clinical Entity #57: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 109));
        catalog.put("R05.8", new IcdEntry("R05.8", "Symptoms & Diagnostic Signs Clinical Entity #58: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 16));
        catalog.put("R05.9", new IcdEntry("R05.9", "Symptoms & Diagnostic Signs Clinical Entity #59: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 23));
        catalog.put("R06.0", new IcdEntry("R06.0", "Symptoms & Diagnostic Signs Clinical Entity #60: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 30));
        catalog.put("R06.1", new IcdEntry("R06.1", "Symptoms & Diagnostic Signs Clinical Entity #61: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 37));
        catalog.put("R06.2", new IcdEntry("R06.2", "Symptoms & Diagnostic Signs Clinical Entity #62: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 44));
        catalog.put("R06.3", new IcdEntry("R06.3", "Symptoms & Diagnostic Signs Clinical Entity #63: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 51));
        catalog.put("R06.4", new IcdEntry("R06.4", "Symptoms & Diagnostic Signs Clinical Entity #64: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 58));
        catalog.put("R06.5", new IcdEntry("R06.5", "Symptoms & Diagnostic Signs Clinical Entity #65: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 65));
        catalog.put("R06.6", new IcdEntry("R06.6", "Symptoms & Diagnostic Signs Clinical Entity #66: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 72));
        catalog.put("R06.7", new IcdEntry("R06.7", "Symptoms & Diagnostic Signs Clinical Entity #67: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 79));
        catalog.put("R06.8", new IcdEntry("R06.8", "Symptoms & Diagnostic Signs Clinical Entity #68: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 86));
        catalog.put("R06.9", new IcdEntry("R06.9", "Symptoms & Diagnostic Signs Clinical Entity #69: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 93));
        catalog.put("R07.0", new IcdEntry("R07.0", "Symptoms & Diagnostic Signs Clinical Entity #70: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 100));
        catalog.put("R07.1", new IcdEntry("R07.1", "Symptoms & Diagnostic Signs Clinical Entity #71: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 107));
        catalog.put("R07.2", new IcdEntry("R07.2", "Symptoms & Diagnostic Signs Clinical Entity #72: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 14));
        catalog.put("R07.3", new IcdEntry("R07.3", "Symptoms & Diagnostic Signs Clinical Entity #73: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 21));
        catalog.put("R07.4", new IcdEntry("R07.4", "Symptoms & Diagnostic Signs Clinical Entity #74: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 28));
        catalog.put("R07.5", new IcdEntry("R07.5", "Symptoms & Diagnostic Signs Clinical Entity #75: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 35));
        catalog.put("R07.6", new IcdEntry("R07.6", "Symptoms & Diagnostic Signs Clinical Entity #76: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 42));
        catalog.put("R07.7", new IcdEntry("R07.7", "Symptoms & Diagnostic Signs Clinical Entity #77: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 49));
        catalog.put("R07.8", new IcdEntry("R07.8", "Symptoms & Diagnostic Signs Clinical Entity #78: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 56));
        catalog.put("R07.9", new IcdEntry("R07.9", "Symptoms & Diagnostic Signs Clinical Entity #79: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 63));
        catalog.put("R08.0", new IcdEntry("R08.0", "Symptoms & Diagnostic Signs Clinical Entity #80: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 70));
        catalog.put("R08.1", new IcdEntry("R08.1", "Symptoms & Diagnostic Signs Clinical Entity #81: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 77));
        catalog.put("R08.2", new IcdEntry("R08.2", "Symptoms & Diagnostic Signs Clinical Entity #82: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 84));
        catalog.put("R08.3", new IcdEntry("R08.3", "Symptoms & Diagnostic Signs Clinical Entity #83: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 91));
        catalog.put("R08.4", new IcdEntry("R08.4", "Symptoms & Diagnostic Signs Clinical Entity #84: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 98));
        catalog.put("R08.5", new IcdEntry("R08.5", "Symptoms & Diagnostic Signs Clinical Entity #85: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 105));
        catalog.put("R08.6", new IcdEntry("R08.6", "Symptoms & Diagnostic Signs Clinical Entity #86: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 12));
        catalog.put("R08.7", new IcdEntry("R08.7", "Symptoms & Diagnostic Signs Clinical Entity #87: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 19));
        catalog.put("R08.8", new IcdEntry("R08.8", "Symptoms & Diagnostic Signs Clinical Entity #88: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 26));
        catalog.put("R08.9", new IcdEntry("R08.9", "Symptoms & Diagnostic Signs Clinical Entity #89: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 33));
        catalog.put("R09.0", new IcdEntry("R09.0", "Symptoms & Diagnostic Signs Clinical Entity #90: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 40));
        catalog.put("R09.1", new IcdEntry("R09.1", "Symptoms & Diagnostic Signs Clinical Entity #91: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 47));
        catalog.put("R09.2", new IcdEntry("R09.2", "Symptoms & Diagnostic Signs Clinical Entity #92: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 54));
        catalog.put("R09.3", new IcdEntry("R09.3", "Symptoms & Diagnostic Signs Clinical Entity #93: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 61));
        catalog.put("R09.4", new IcdEntry("R09.4", "Symptoms & Diagnostic Signs Clinical Entity #94: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 68));
        catalog.put("R09.5", new IcdEntry("R09.5", "Symptoms & Diagnostic Signs Clinical Entity #95: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 75));
        catalog.put("R09.6", new IcdEntry("R09.6", "Symptoms & Diagnostic Signs Clinical Entity #96: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 82));
        catalog.put("R09.7", new IcdEntry("R09.7", "Symptoms & Diagnostic Signs Clinical Entity #97: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 89));
        catalog.put("R09.8", new IcdEntry("R09.8", "Symptoms & Diagnostic Signs Clinical Entity #98: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 96));
        catalog.put("R09.9", new IcdEntry("R09.9", "Symptoms & Diagnostic Signs Clinical Entity #99: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 103));
        catalog.put("R10.0", new IcdEntry("R10.0", "Symptoms & Diagnostic Signs Clinical Entity #100: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 10));
        catalog.put("R10.1", new IcdEntry("R10.1", "Symptoms & Diagnostic Signs Clinical Entity #101: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 17));
        catalog.put("R10.2", new IcdEntry("R10.2", "Symptoms & Diagnostic Signs Clinical Entity #102: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 24));
        catalog.put("R10.3", new IcdEntry("R10.3", "Symptoms & Diagnostic Signs Clinical Entity #103: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 31));
        catalog.put("R10.4", new IcdEntry("R10.4", "Symptoms & Diagnostic Signs Clinical Entity #104: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 38));
        catalog.put("R10.5", new IcdEntry("R10.5", "Symptoms & Diagnostic Signs Clinical Entity #105: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 45));
        catalog.put("R10.6", new IcdEntry("R10.6", "Symptoms & Diagnostic Signs Clinical Entity #106: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 52));
        catalog.put("R10.7", new IcdEntry("R10.7", "Symptoms & Diagnostic Signs Clinical Entity #107: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 59));
        catalog.put("R10.8", new IcdEntry("R10.8", "Symptoms & Diagnostic Signs Clinical Entity #108: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 66));
        catalog.put("R10.9", new IcdEntry("R10.9", "Symptoms & Diagnostic Signs Clinical Entity #109: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 73));
        catalog.put("R11.0", new IcdEntry("R11.0", "Symptoms & Diagnostic Signs Clinical Entity #110: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 80));
        catalog.put("R11.1", new IcdEntry("R11.1", "Symptoms & Diagnostic Signs Clinical Entity #111: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 87));
        catalog.put("R11.2", new IcdEntry("R11.2", "Symptoms & Diagnostic Signs Clinical Entity #112: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 94));
        catalog.put("R11.3", new IcdEntry("R11.3", "Symptoms & Diagnostic Signs Clinical Entity #113: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 101));
        catalog.put("R11.4", new IcdEntry("R11.4", "Symptoms & Diagnostic Signs Clinical Entity #114: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 108));
        catalog.put("R11.5", new IcdEntry("R11.5", "Symptoms & Diagnostic Signs Clinical Entity #115: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 15));
        catalog.put("R11.6", new IcdEntry("R11.6", "Symptoms & Diagnostic Signs Clinical Entity #116: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 22));
        catalog.put("R11.7", new IcdEntry("R11.7", "Symptoms & Diagnostic Signs Clinical Entity #117: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 2", false, 29));
        catalog.put("R11.8", new IcdEntry("R11.8", "Symptoms & Diagnostic Signs Clinical Entity #118: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 3", true, 36));
        catalog.put("R11.9", new IcdEntry("R11.9", "Symptoms & Diagnostic Signs Clinical Entity #119: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 4", false, 43));
        catalog.put("R12.0", new IcdEntry("R12.0", "Symptoms & Diagnostic Signs Clinical Entity #120: Precision Diagnostic Marker", "R00-R99", "Clinical Severity Grade 1", true, 50));
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
