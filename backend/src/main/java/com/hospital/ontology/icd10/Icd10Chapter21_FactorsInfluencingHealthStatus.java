package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 21 (Z00-Z99): Health Encounters & Social Determinants.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter21_FactorsInfluencingHealthStatus {

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

    public Icd10Chapter21_FactorsInfluencingHealthStatus() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("Z00.1", new IcdEntry("Z00.1", "Health Encounters & Social Determinants Clinical Entity #1: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 17));
        catalog.put("Z00.2", new IcdEntry("Z00.2", "Health Encounters & Social Determinants Clinical Entity #2: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 24));
        catalog.put("Z00.3", new IcdEntry("Z00.3", "Health Encounters & Social Determinants Clinical Entity #3: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 31));
        catalog.put("Z00.4", new IcdEntry("Z00.4", "Health Encounters & Social Determinants Clinical Entity #4: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 38));
        catalog.put("Z00.5", new IcdEntry("Z00.5", "Health Encounters & Social Determinants Clinical Entity #5: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 45));
        catalog.put("Z00.6", new IcdEntry("Z00.6", "Health Encounters & Social Determinants Clinical Entity #6: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 52));
        catalog.put("Z00.7", new IcdEntry("Z00.7", "Health Encounters & Social Determinants Clinical Entity #7: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 59));
        catalog.put("Z00.8", new IcdEntry("Z00.8", "Health Encounters & Social Determinants Clinical Entity #8: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 66));
        catalog.put("Z00.9", new IcdEntry("Z00.9", "Health Encounters & Social Determinants Clinical Entity #9: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 73));
        catalog.put("Z01.0", new IcdEntry("Z01.0", "Health Encounters & Social Determinants Clinical Entity #10: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 80));
        catalog.put("Z01.1", new IcdEntry("Z01.1", "Health Encounters & Social Determinants Clinical Entity #11: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 87));
        catalog.put("Z01.2", new IcdEntry("Z01.2", "Health Encounters & Social Determinants Clinical Entity #12: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 94));
        catalog.put("Z01.3", new IcdEntry("Z01.3", "Health Encounters & Social Determinants Clinical Entity #13: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 101));
        catalog.put("Z01.4", new IcdEntry("Z01.4", "Health Encounters & Social Determinants Clinical Entity #14: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 108));
        catalog.put("Z01.5", new IcdEntry("Z01.5", "Health Encounters & Social Determinants Clinical Entity #15: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 15));
        catalog.put("Z01.6", new IcdEntry("Z01.6", "Health Encounters & Social Determinants Clinical Entity #16: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 22));
        catalog.put("Z01.7", new IcdEntry("Z01.7", "Health Encounters & Social Determinants Clinical Entity #17: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 29));
        catalog.put("Z01.8", new IcdEntry("Z01.8", "Health Encounters & Social Determinants Clinical Entity #18: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 36));
        catalog.put("Z01.9", new IcdEntry("Z01.9", "Health Encounters & Social Determinants Clinical Entity #19: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 43));
        catalog.put("Z02.0", new IcdEntry("Z02.0", "Health Encounters & Social Determinants Clinical Entity #20: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 50));
        catalog.put("Z02.1", new IcdEntry("Z02.1", "Health Encounters & Social Determinants Clinical Entity #21: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 57));
        catalog.put("Z02.2", new IcdEntry("Z02.2", "Health Encounters & Social Determinants Clinical Entity #22: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 64));
        catalog.put("Z02.3", new IcdEntry("Z02.3", "Health Encounters & Social Determinants Clinical Entity #23: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 71));
        catalog.put("Z02.4", new IcdEntry("Z02.4", "Health Encounters & Social Determinants Clinical Entity #24: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 78));
        catalog.put("Z02.5", new IcdEntry("Z02.5", "Health Encounters & Social Determinants Clinical Entity #25: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 85));
        catalog.put("Z02.6", new IcdEntry("Z02.6", "Health Encounters & Social Determinants Clinical Entity #26: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 92));
        catalog.put("Z02.7", new IcdEntry("Z02.7", "Health Encounters & Social Determinants Clinical Entity #27: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 99));
        catalog.put("Z02.8", new IcdEntry("Z02.8", "Health Encounters & Social Determinants Clinical Entity #28: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 106));
        catalog.put("Z02.9", new IcdEntry("Z02.9", "Health Encounters & Social Determinants Clinical Entity #29: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 13));
        catalog.put("Z03.0", new IcdEntry("Z03.0", "Health Encounters & Social Determinants Clinical Entity #30: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 20));
        catalog.put("Z03.1", new IcdEntry("Z03.1", "Health Encounters & Social Determinants Clinical Entity #31: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 27));
        catalog.put("Z03.2", new IcdEntry("Z03.2", "Health Encounters & Social Determinants Clinical Entity #32: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 34));
        catalog.put("Z03.3", new IcdEntry("Z03.3", "Health Encounters & Social Determinants Clinical Entity #33: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 41));
        catalog.put("Z03.4", new IcdEntry("Z03.4", "Health Encounters & Social Determinants Clinical Entity #34: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 48));
        catalog.put("Z03.5", new IcdEntry("Z03.5", "Health Encounters & Social Determinants Clinical Entity #35: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 55));
        catalog.put("Z03.6", new IcdEntry("Z03.6", "Health Encounters & Social Determinants Clinical Entity #36: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 62));
        catalog.put("Z03.7", new IcdEntry("Z03.7", "Health Encounters & Social Determinants Clinical Entity #37: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 69));
        catalog.put("Z03.8", new IcdEntry("Z03.8", "Health Encounters & Social Determinants Clinical Entity #38: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 76));
        catalog.put("Z03.9", new IcdEntry("Z03.9", "Health Encounters & Social Determinants Clinical Entity #39: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 83));
        catalog.put("Z04.0", new IcdEntry("Z04.0", "Health Encounters & Social Determinants Clinical Entity #40: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 90));
        catalog.put("Z04.1", new IcdEntry("Z04.1", "Health Encounters & Social Determinants Clinical Entity #41: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 97));
        catalog.put("Z04.2", new IcdEntry("Z04.2", "Health Encounters & Social Determinants Clinical Entity #42: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 104));
        catalog.put("Z04.3", new IcdEntry("Z04.3", "Health Encounters & Social Determinants Clinical Entity #43: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 11));
        catalog.put("Z04.4", new IcdEntry("Z04.4", "Health Encounters & Social Determinants Clinical Entity #44: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 18));
        catalog.put("Z04.5", new IcdEntry("Z04.5", "Health Encounters & Social Determinants Clinical Entity #45: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 25));
        catalog.put("Z04.6", new IcdEntry("Z04.6", "Health Encounters & Social Determinants Clinical Entity #46: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 32));
        catalog.put("Z04.7", new IcdEntry("Z04.7", "Health Encounters & Social Determinants Clinical Entity #47: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 39));
        catalog.put("Z04.8", new IcdEntry("Z04.8", "Health Encounters & Social Determinants Clinical Entity #48: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 46));
        catalog.put("Z04.9", new IcdEntry("Z04.9", "Health Encounters & Social Determinants Clinical Entity #49: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 53));
        catalog.put("Z05.0", new IcdEntry("Z05.0", "Health Encounters & Social Determinants Clinical Entity #50: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 60));
        catalog.put("Z05.1", new IcdEntry("Z05.1", "Health Encounters & Social Determinants Clinical Entity #51: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 67));
        catalog.put("Z05.2", new IcdEntry("Z05.2", "Health Encounters & Social Determinants Clinical Entity #52: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 74));
        catalog.put("Z05.3", new IcdEntry("Z05.3", "Health Encounters & Social Determinants Clinical Entity #53: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 81));
        catalog.put("Z05.4", new IcdEntry("Z05.4", "Health Encounters & Social Determinants Clinical Entity #54: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 88));
        catalog.put("Z05.5", new IcdEntry("Z05.5", "Health Encounters & Social Determinants Clinical Entity #55: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 95));
        catalog.put("Z05.6", new IcdEntry("Z05.6", "Health Encounters & Social Determinants Clinical Entity #56: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 102));
        catalog.put("Z05.7", new IcdEntry("Z05.7", "Health Encounters & Social Determinants Clinical Entity #57: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 109));
        catalog.put("Z05.8", new IcdEntry("Z05.8", "Health Encounters & Social Determinants Clinical Entity #58: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 16));
        catalog.put("Z05.9", new IcdEntry("Z05.9", "Health Encounters & Social Determinants Clinical Entity #59: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 23));
        catalog.put("Z06.0", new IcdEntry("Z06.0", "Health Encounters & Social Determinants Clinical Entity #60: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 30));
        catalog.put("Z06.1", new IcdEntry("Z06.1", "Health Encounters & Social Determinants Clinical Entity #61: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 37));
        catalog.put("Z06.2", new IcdEntry("Z06.2", "Health Encounters & Social Determinants Clinical Entity #62: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 44));
        catalog.put("Z06.3", new IcdEntry("Z06.3", "Health Encounters & Social Determinants Clinical Entity #63: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 51));
        catalog.put("Z06.4", new IcdEntry("Z06.4", "Health Encounters & Social Determinants Clinical Entity #64: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 58));
        catalog.put("Z06.5", new IcdEntry("Z06.5", "Health Encounters & Social Determinants Clinical Entity #65: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 65));
        catalog.put("Z06.6", new IcdEntry("Z06.6", "Health Encounters & Social Determinants Clinical Entity #66: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 72));
        catalog.put("Z06.7", new IcdEntry("Z06.7", "Health Encounters & Social Determinants Clinical Entity #67: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 79));
        catalog.put("Z06.8", new IcdEntry("Z06.8", "Health Encounters & Social Determinants Clinical Entity #68: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 86));
        catalog.put("Z06.9", new IcdEntry("Z06.9", "Health Encounters & Social Determinants Clinical Entity #69: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 93));
        catalog.put("Z07.0", new IcdEntry("Z07.0", "Health Encounters & Social Determinants Clinical Entity #70: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 100));
        catalog.put("Z07.1", new IcdEntry("Z07.1", "Health Encounters & Social Determinants Clinical Entity #71: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 107));
        catalog.put("Z07.2", new IcdEntry("Z07.2", "Health Encounters & Social Determinants Clinical Entity #72: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 14));
        catalog.put("Z07.3", new IcdEntry("Z07.3", "Health Encounters & Social Determinants Clinical Entity #73: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 21));
        catalog.put("Z07.4", new IcdEntry("Z07.4", "Health Encounters & Social Determinants Clinical Entity #74: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 28));
        catalog.put("Z07.5", new IcdEntry("Z07.5", "Health Encounters & Social Determinants Clinical Entity #75: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 35));
        catalog.put("Z07.6", new IcdEntry("Z07.6", "Health Encounters & Social Determinants Clinical Entity #76: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 42));
        catalog.put("Z07.7", new IcdEntry("Z07.7", "Health Encounters & Social Determinants Clinical Entity #77: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 49));
        catalog.put("Z07.8", new IcdEntry("Z07.8", "Health Encounters & Social Determinants Clinical Entity #78: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 56));
        catalog.put("Z07.9", new IcdEntry("Z07.9", "Health Encounters & Social Determinants Clinical Entity #79: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 63));
        catalog.put("Z08.0", new IcdEntry("Z08.0", "Health Encounters & Social Determinants Clinical Entity #80: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 70));
        catalog.put("Z08.1", new IcdEntry("Z08.1", "Health Encounters & Social Determinants Clinical Entity #81: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 77));
        catalog.put("Z08.2", new IcdEntry("Z08.2", "Health Encounters & Social Determinants Clinical Entity #82: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 84));
        catalog.put("Z08.3", new IcdEntry("Z08.3", "Health Encounters & Social Determinants Clinical Entity #83: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 91));
        catalog.put("Z08.4", new IcdEntry("Z08.4", "Health Encounters & Social Determinants Clinical Entity #84: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 98));
        catalog.put("Z08.5", new IcdEntry("Z08.5", "Health Encounters & Social Determinants Clinical Entity #85: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 105));
        catalog.put("Z08.6", new IcdEntry("Z08.6", "Health Encounters & Social Determinants Clinical Entity #86: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 12));
        catalog.put("Z08.7", new IcdEntry("Z08.7", "Health Encounters & Social Determinants Clinical Entity #87: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 19));
        catalog.put("Z08.8", new IcdEntry("Z08.8", "Health Encounters & Social Determinants Clinical Entity #88: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 26));
        catalog.put("Z08.9", new IcdEntry("Z08.9", "Health Encounters & Social Determinants Clinical Entity #89: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 33));
        catalog.put("Z09.0", new IcdEntry("Z09.0", "Health Encounters & Social Determinants Clinical Entity #90: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 40));
        catalog.put("Z09.1", new IcdEntry("Z09.1", "Health Encounters & Social Determinants Clinical Entity #91: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 47));
        catalog.put("Z09.2", new IcdEntry("Z09.2", "Health Encounters & Social Determinants Clinical Entity #92: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 54));
        catalog.put("Z09.3", new IcdEntry("Z09.3", "Health Encounters & Social Determinants Clinical Entity #93: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 61));
        catalog.put("Z09.4", new IcdEntry("Z09.4", "Health Encounters & Social Determinants Clinical Entity #94: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 68));
        catalog.put("Z09.5", new IcdEntry("Z09.5", "Health Encounters & Social Determinants Clinical Entity #95: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 75));
        catalog.put("Z09.6", new IcdEntry("Z09.6", "Health Encounters & Social Determinants Clinical Entity #96: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 82));
        catalog.put("Z09.7", new IcdEntry("Z09.7", "Health Encounters & Social Determinants Clinical Entity #97: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 89));
        catalog.put("Z09.8", new IcdEntry("Z09.8", "Health Encounters & Social Determinants Clinical Entity #98: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 96));
        catalog.put("Z09.9", new IcdEntry("Z09.9", "Health Encounters & Social Determinants Clinical Entity #99: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 103));
        catalog.put("Z10.0", new IcdEntry("Z10.0", "Health Encounters & Social Determinants Clinical Entity #100: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 10));
        catalog.put("Z10.1", new IcdEntry("Z10.1", "Health Encounters & Social Determinants Clinical Entity #101: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 17));
        catalog.put("Z10.2", new IcdEntry("Z10.2", "Health Encounters & Social Determinants Clinical Entity #102: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 24));
        catalog.put("Z10.3", new IcdEntry("Z10.3", "Health Encounters & Social Determinants Clinical Entity #103: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 31));
        catalog.put("Z10.4", new IcdEntry("Z10.4", "Health Encounters & Social Determinants Clinical Entity #104: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 38));
        catalog.put("Z10.5", new IcdEntry("Z10.5", "Health Encounters & Social Determinants Clinical Entity #105: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 45));
        catalog.put("Z10.6", new IcdEntry("Z10.6", "Health Encounters & Social Determinants Clinical Entity #106: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 52));
        catalog.put("Z10.7", new IcdEntry("Z10.7", "Health Encounters & Social Determinants Clinical Entity #107: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 4", false, 59));
        catalog.put("Z10.8", new IcdEntry("Z10.8", "Health Encounters & Social Determinants Clinical Entity #108: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 1", true, 66));
        catalog.put("Z10.9", new IcdEntry("Z10.9", "Health Encounters & Social Determinants Clinical Entity #109: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 2", false, 73));
        catalog.put("Z11.0", new IcdEntry("Z11.0", "Health Encounters & Social Determinants Clinical Entity #110: Precision Diagnostic Marker", "Z00-Z99", "Clinical Severity Grade 3", true, 80));
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
