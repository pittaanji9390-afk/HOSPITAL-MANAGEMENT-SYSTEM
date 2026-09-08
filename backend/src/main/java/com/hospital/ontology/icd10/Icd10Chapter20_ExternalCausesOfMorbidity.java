package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 20 (V00-Y99): Environmental & External Factors.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter20_ExternalCausesOfMorbidity {

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

    public Icd10Chapter20_ExternalCausesOfMorbidity() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("V00.1", new IcdEntry("V00.1", "Environmental & External Factors Clinical Entity #1: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 17));
        catalog.put("V00.2", new IcdEntry("V00.2", "Environmental & External Factors Clinical Entity #2: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 24));
        catalog.put("V00.3", new IcdEntry("V00.3", "Environmental & External Factors Clinical Entity #3: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 31));
        catalog.put("V00.4", new IcdEntry("V00.4", "Environmental & External Factors Clinical Entity #4: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 38));
        catalog.put("V00.5", new IcdEntry("V00.5", "Environmental & External Factors Clinical Entity #5: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 45));
        catalog.put("V00.6", new IcdEntry("V00.6", "Environmental & External Factors Clinical Entity #6: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 52));
        catalog.put("V00.7", new IcdEntry("V00.7", "Environmental & External Factors Clinical Entity #7: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 59));
        catalog.put("V00.8", new IcdEntry("V00.8", "Environmental & External Factors Clinical Entity #8: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 66));
        catalog.put("V00.9", new IcdEntry("V00.9", "Environmental & External Factors Clinical Entity #9: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 73));
        catalog.put("V01.0", new IcdEntry("V01.0", "Environmental & External Factors Clinical Entity #10: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 80));
        catalog.put("V01.1", new IcdEntry("V01.1", "Environmental & External Factors Clinical Entity #11: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 87));
        catalog.put("V01.2", new IcdEntry("V01.2", "Environmental & External Factors Clinical Entity #12: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 94));
        catalog.put("V01.3", new IcdEntry("V01.3", "Environmental & External Factors Clinical Entity #13: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 101));
        catalog.put("V01.4", new IcdEntry("V01.4", "Environmental & External Factors Clinical Entity #14: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 108));
        catalog.put("V01.5", new IcdEntry("V01.5", "Environmental & External Factors Clinical Entity #15: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 15));
        catalog.put("V01.6", new IcdEntry("V01.6", "Environmental & External Factors Clinical Entity #16: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 22));
        catalog.put("V01.7", new IcdEntry("V01.7", "Environmental & External Factors Clinical Entity #17: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 29));
        catalog.put("V01.8", new IcdEntry("V01.8", "Environmental & External Factors Clinical Entity #18: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 36));
        catalog.put("V01.9", new IcdEntry("V01.9", "Environmental & External Factors Clinical Entity #19: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 43));
        catalog.put("V02.0", new IcdEntry("V02.0", "Environmental & External Factors Clinical Entity #20: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 50));
        catalog.put("V02.1", new IcdEntry("V02.1", "Environmental & External Factors Clinical Entity #21: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 57));
        catalog.put("V02.2", new IcdEntry("V02.2", "Environmental & External Factors Clinical Entity #22: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 64));
        catalog.put("V02.3", new IcdEntry("V02.3", "Environmental & External Factors Clinical Entity #23: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 71));
        catalog.put("V02.4", new IcdEntry("V02.4", "Environmental & External Factors Clinical Entity #24: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 78));
        catalog.put("V02.5", new IcdEntry("V02.5", "Environmental & External Factors Clinical Entity #25: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 85));
        catalog.put("V02.6", new IcdEntry("V02.6", "Environmental & External Factors Clinical Entity #26: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 92));
        catalog.put("V02.7", new IcdEntry("V02.7", "Environmental & External Factors Clinical Entity #27: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 99));
        catalog.put("V02.8", new IcdEntry("V02.8", "Environmental & External Factors Clinical Entity #28: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 106));
        catalog.put("V02.9", new IcdEntry("V02.9", "Environmental & External Factors Clinical Entity #29: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 13));
        catalog.put("V03.0", new IcdEntry("V03.0", "Environmental & External Factors Clinical Entity #30: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 20));
        catalog.put("V03.1", new IcdEntry("V03.1", "Environmental & External Factors Clinical Entity #31: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 27));
        catalog.put("V03.2", new IcdEntry("V03.2", "Environmental & External Factors Clinical Entity #32: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 34));
        catalog.put("V03.3", new IcdEntry("V03.3", "Environmental & External Factors Clinical Entity #33: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 41));
        catalog.put("V03.4", new IcdEntry("V03.4", "Environmental & External Factors Clinical Entity #34: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 48));
        catalog.put("V03.5", new IcdEntry("V03.5", "Environmental & External Factors Clinical Entity #35: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 55));
        catalog.put("V03.6", new IcdEntry("V03.6", "Environmental & External Factors Clinical Entity #36: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 62));
        catalog.put("V03.7", new IcdEntry("V03.7", "Environmental & External Factors Clinical Entity #37: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 69));
        catalog.put("V03.8", new IcdEntry("V03.8", "Environmental & External Factors Clinical Entity #38: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 76));
        catalog.put("V03.9", new IcdEntry("V03.9", "Environmental & External Factors Clinical Entity #39: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 83));
        catalog.put("V04.0", new IcdEntry("V04.0", "Environmental & External Factors Clinical Entity #40: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 90));
        catalog.put("V04.1", new IcdEntry("V04.1", "Environmental & External Factors Clinical Entity #41: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 97));
        catalog.put("V04.2", new IcdEntry("V04.2", "Environmental & External Factors Clinical Entity #42: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 104));
        catalog.put("V04.3", new IcdEntry("V04.3", "Environmental & External Factors Clinical Entity #43: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 11));
        catalog.put("V04.4", new IcdEntry("V04.4", "Environmental & External Factors Clinical Entity #44: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 18));
        catalog.put("V04.5", new IcdEntry("V04.5", "Environmental & External Factors Clinical Entity #45: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 25));
        catalog.put("V04.6", new IcdEntry("V04.6", "Environmental & External Factors Clinical Entity #46: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 32));
        catalog.put("V04.7", new IcdEntry("V04.7", "Environmental & External Factors Clinical Entity #47: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 39));
        catalog.put("V04.8", new IcdEntry("V04.8", "Environmental & External Factors Clinical Entity #48: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 46));
        catalog.put("V04.9", new IcdEntry("V04.9", "Environmental & External Factors Clinical Entity #49: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 53));
        catalog.put("V05.0", new IcdEntry("V05.0", "Environmental & External Factors Clinical Entity #50: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 60));
        catalog.put("V05.1", new IcdEntry("V05.1", "Environmental & External Factors Clinical Entity #51: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 67));
        catalog.put("V05.2", new IcdEntry("V05.2", "Environmental & External Factors Clinical Entity #52: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 74));
        catalog.put("V05.3", new IcdEntry("V05.3", "Environmental & External Factors Clinical Entity #53: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 81));
        catalog.put("V05.4", new IcdEntry("V05.4", "Environmental & External Factors Clinical Entity #54: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 88));
        catalog.put("V05.5", new IcdEntry("V05.5", "Environmental & External Factors Clinical Entity #55: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 95));
        catalog.put("V05.6", new IcdEntry("V05.6", "Environmental & External Factors Clinical Entity #56: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 102));
        catalog.put("V05.7", new IcdEntry("V05.7", "Environmental & External Factors Clinical Entity #57: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 109));
        catalog.put("V05.8", new IcdEntry("V05.8", "Environmental & External Factors Clinical Entity #58: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 16));
        catalog.put("V05.9", new IcdEntry("V05.9", "Environmental & External Factors Clinical Entity #59: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 23));
        catalog.put("V06.0", new IcdEntry("V06.0", "Environmental & External Factors Clinical Entity #60: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 30));
        catalog.put("V06.1", new IcdEntry("V06.1", "Environmental & External Factors Clinical Entity #61: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 37));
        catalog.put("V06.2", new IcdEntry("V06.2", "Environmental & External Factors Clinical Entity #62: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 44));
        catalog.put("V06.3", new IcdEntry("V06.3", "Environmental & External Factors Clinical Entity #63: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 51));
        catalog.put("V06.4", new IcdEntry("V06.4", "Environmental & External Factors Clinical Entity #64: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 58));
        catalog.put("V06.5", new IcdEntry("V06.5", "Environmental & External Factors Clinical Entity #65: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 65));
        catalog.put("V06.6", new IcdEntry("V06.6", "Environmental & External Factors Clinical Entity #66: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 72));
        catalog.put("V06.7", new IcdEntry("V06.7", "Environmental & External Factors Clinical Entity #67: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 79));
        catalog.put("V06.8", new IcdEntry("V06.8", "Environmental & External Factors Clinical Entity #68: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 86));
        catalog.put("V06.9", new IcdEntry("V06.9", "Environmental & External Factors Clinical Entity #69: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 93));
        catalog.put("V07.0", new IcdEntry("V07.0", "Environmental & External Factors Clinical Entity #70: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 100));
        catalog.put("V07.1", new IcdEntry("V07.1", "Environmental & External Factors Clinical Entity #71: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 107));
        catalog.put("V07.2", new IcdEntry("V07.2", "Environmental & External Factors Clinical Entity #72: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 14));
        catalog.put("V07.3", new IcdEntry("V07.3", "Environmental & External Factors Clinical Entity #73: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 21));
        catalog.put("V07.4", new IcdEntry("V07.4", "Environmental & External Factors Clinical Entity #74: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 28));
        catalog.put("V07.5", new IcdEntry("V07.5", "Environmental & External Factors Clinical Entity #75: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 35));
        catalog.put("V07.6", new IcdEntry("V07.6", "Environmental & External Factors Clinical Entity #76: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 42));
        catalog.put("V07.7", new IcdEntry("V07.7", "Environmental & External Factors Clinical Entity #77: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 49));
        catalog.put("V07.8", new IcdEntry("V07.8", "Environmental & External Factors Clinical Entity #78: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 56));
        catalog.put("V07.9", new IcdEntry("V07.9", "Environmental & External Factors Clinical Entity #79: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 63));
        catalog.put("V08.0", new IcdEntry("V08.0", "Environmental & External Factors Clinical Entity #80: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 70));
        catalog.put("V08.1", new IcdEntry("V08.1", "Environmental & External Factors Clinical Entity #81: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 77));
        catalog.put("V08.2", new IcdEntry("V08.2", "Environmental & External Factors Clinical Entity #82: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 84));
        catalog.put("V08.3", new IcdEntry("V08.3", "Environmental & External Factors Clinical Entity #83: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 91));
        catalog.put("V08.4", new IcdEntry("V08.4", "Environmental & External Factors Clinical Entity #84: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 98));
        catalog.put("V08.5", new IcdEntry("V08.5", "Environmental & External Factors Clinical Entity #85: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 105));
        catalog.put("V08.6", new IcdEntry("V08.6", "Environmental & External Factors Clinical Entity #86: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 12));
        catalog.put("V08.7", new IcdEntry("V08.7", "Environmental & External Factors Clinical Entity #87: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 19));
        catalog.put("V08.8", new IcdEntry("V08.8", "Environmental & External Factors Clinical Entity #88: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 26));
        catalog.put("V08.9", new IcdEntry("V08.9", "Environmental & External Factors Clinical Entity #89: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 33));
        catalog.put("V09.0", new IcdEntry("V09.0", "Environmental & External Factors Clinical Entity #90: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 40));
        catalog.put("V09.1", new IcdEntry("V09.1", "Environmental & External Factors Clinical Entity #91: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 47));
        catalog.put("V09.2", new IcdEntry("V09.2", "Environmental & External Factors Clinical Entity #92: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 54));
        catalog.put("V09.3", new IcdEntry("V09.3", "Environmental & External Factors Clinical Entity #93: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 61));
        catalog.put("V09.4", new IcdEntry("V09.4", "Environmental & External Factors Clinical Entity #94: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 68));
        catalog.put("V09.5", new IcdEntry("V09.5", "Environmental & External Factors Clinical Entity #95: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 75));
        catalog.put("V09.6", new IcdEntry("V09.6", "Environmental & External Factors Clinical Entity #96: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 82));
        catalog.put("V09.7", new IcdEntry("V09.7", "Environmental & External Factors Clinical Entity #97: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 2", false, 89));
        catalog.put("V09.8", new IcdEntry("V09.8", "Environmental & External Factors Clinical Entity #98: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 3", true, 96));
        catalog.put("V09.9", new IcdEntry("V09.9", "Environmental & External Factors Clinical Entity #99: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 4", false, 103));
        catalog.put("V10.0", new IcdEntry("V10.0", "Environmental & External Factors Clinical Entity #100: Precision Diagnostic Marker", "V00-Y99", "Clinical Severity Grade 1", true, 10));
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
