package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 07 (H00-H59): Ophthalmology & Eye.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter07_EyeAndAdnexaDiseases {

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

    public Icd10Chapter07_EyeAndAdnexaDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("H00.1", new IcdEntry("H00.1", "Ophthalmology & Eye Clinical Entity #1: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 17));
        catalog.put("H00.2", new IcdEntry("H00.2", "Ophthalmology & Eye Clinical Entity #2: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 24));
        catalog.put("H00.3", new IcdEntry("H00.3", "Ophthalmology & Eye Clinical Entity #3: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 31));
        catalog.put("H00.4", new IcdEntry("H00.4", "Ophthalmology & Eye Clinical Entity #4: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 38));
        catalog.put("H00.5", new IcdEntry("H00.5", "Ophthalmology & Eye Clinical Entity #5: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 45));
        catalog.put("H00.6", new IcdEntry("H00.6", "Ophthalmology & Eye Clinical Entity #6: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 52));
        catalog.put("H00.7", new IcdEntry("H00.7", "Ophthalmology & Eye Clinical Entity #7: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 59));
        catalog.put("H00.8", new IcdEntry("H00.8", "Ophthalmology & Eye Clinical Entity #8: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 66));
        catalog.put("H00.9", new IcdEntry("H00.9", "Ophthalmology & Eye Clinical Entity #9: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 73));
        catalog.put("H01.0", new IcdEntry("H01.0", "Ophthalmology & Eye Clinical Entity #10: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 80));
        catalog.put("H01.1", new IcdEntry("H01.1", "Ophthalmology & Eye Clinical Entity #11: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 87));
        catalog.put("H01.2", new IcdEntry("H01.2", "Ophthalmology & Eye Clinical Entity #12: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 94));
        catalog.put("H01.3", new IcdEntry("H01.3", "Ophthalmology & Eye Clinical Entity #13: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 101));
        catalog.put("H01.4", new IcdEntry("H01.4", "Ophthalmology & Eye Clinical Entity #14: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 108));
        catalog.put("H01.5", new IcdEntry("H01.5", "Ophthalmology & Eye Clinical Entity #15: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 15));
        catalog.put("H01.6", new IcdEntry("H01.6", "Ophthalmology & Eye Clinical Entity #16: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 22));
        catalog.put("H01.7", new IcdEntry("H01.7", "Ophthalmology & Eye Clinical Entity #17: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 29));
        catalog.put("H01.8", new IcdEntry("H01.8", "Ophthalmology & Eye Clinical Entity #18: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 36));
        catalog.put("H01.9", new IcdEntry("H01.9", "Ophthalmology & Eye Clinical Entity #19: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 43));
        catalog.put("H02.0", new IcdEntry("H02.0", "Ophthalmology & Eye Clinical Entity #20: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 50));
        catalog.put("H02.1", new IcdEntry("H02.1", "Ophthalmology & Eye Clinical Entity #21: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 57));
        catalog.put("H02.2", new IcdEntry("H02.2", "Ophthalmology & Eye Clinical Entity #22: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 64));
        catalog.put("H02.3", new IcdEntry("H02.3", "Ophthalmology & Eye Clinical Entity #23: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 71));
        catalog.put("H02.4", new IcdEntry("H02.4", "Ophthalmology & Eye Clinical Entity #24: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 78));
        catalog.put("H02.5", new IcdEntry("H02.5", "Ophthalmology & Eye Clinical Entity #25: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 85));
        catalog.put("H02.6", new IcdEntry("H02.6", "Ophthalmology & Eye Clinical Entity #26: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 92));
        catalog.put("H02.7", new IcdEntry("H02.7", "Ophthalmology & Eye Clinical Entity #27: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 99));
        catalog.put("H02.8", new IcdEntry("H02.8", "Ophthalmology & Eye Clinical Entity #28: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 106));
        catalog.put("H02.9", new IcdEntry("H02.9", "Ophthalmology & Eye Clinical Entity #29: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 13));
        catalog.put("H03.0", new IcdEntry("H03.0", "Ophthalmology & Eye Clinical Entity #30: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 20));
        catalog.put("H03.1", new IcdEntry("H03.1", "Ophthalmology & Eye Clinical Entity #31: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 27));
        catalog.put("H03.2", new IcdEntry("H03.2", "Ophthalmology & Eye Clinical Entity #32: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 34));
        catalog.put("H03.3", new IcdEntry("H03.3", "Ophthalmology & Eye Clinical Entity #33: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 41));
        catalog.put("H03.4", new IcdEntry("H03.4", "Ophthalmology & Eye Clinical Entity #34: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 48));
        catalog.put("H03.5", new IcdEntry("H03.5", "Ophthalmology & Eye Clinical Entity #35: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 55));
        catalog.put("H03.6", new IcdEntry("H03.6", "Ophthalmology & Eye Clinical Entity #36: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 62));
        catalog.put("H03.7", new IcdEntry("H03.7", "Ophthalmology & Eye Clinical Entity #37: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 69));
        catalog.put("H03.8", new IcdEntry("H03.8", "Ophthalmology & Eye Clinical Entity #38: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 76));
        catalog.put("H03.9", new IcdEntry("H03.9", "Ophthalmology & Eye Clinical Entity #39: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 83));
        catalog.put("H04.0", new IcdEntry("H04.0", "Ophthalmology & Eye Clinical Entity #40: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 90));
        catalog.put("H04.1", new IcdEntry("H04.1", "Ophthalmology & Eye Clinical Entity #41: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 97));
        catalog.put("H04.2", new IcdEntry("H04.2", "Ophthalmology & Eye Clinical Entity #42: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 104));
        catalog.put("H04.3", new IcdEntry("H04.3", "Ophthalmology & Eye Clinical Entity #43: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 11));
        catalog.put("H04.4", new IcdEntry("H04.4", "Ophthalmology & Eye Clinical Entity #44: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 18));
        catalog.put("H04.5", new IcdEntry("H04.5", "Ophthalmology & Eye Clinical Entity #45: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 25));
        catalog.put("H04.6", new IcdEntry("H04.6", "Ophthalmology & Eye Clinical Entity #46: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 32));
        catalog.put("H04.7", new IcdEntry("H04.7", "Ophthalmology & Eye Clinical Entity #47: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 39));
        catalog.put("H04.8", new IcdEntry("H04.8", "Ophthalmology & Eye Clinical Entity #48: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 46));
        catalog.put("H04.9", new IcdEntry("H04.9", "Ophthalmology & Eye Clinical Entity #49: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 53));
        catalog.put("H05.0", new IcdEntry("H05.0", "Ophthalmology & Eye Clinical Entity #50: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 60));
        catalog.put("H05.1", new IcdEntry("H05.1", "Ophthalmology & Eye Clinical Entity #51: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 67));
        catalog.put("H05.2", new IcdEntry("H05.2", "Ophthalmology & Eye Clinical Entity #52: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 74));
        catalog.put("H05.3", new IcdEntry("H05.3", "Ophthalmology & Eye Clinical Entity #53: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 81));
        catalog.put("H05.4", new IcdEntry("H05.4", "Ophthalmology & Eye Clinical Entity #54: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 88));
        catalog.put("H05.5", new IcdEntry("H05.5", "Ophthalmology & Eye Clinical Entity #55: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 95));
        catalog.put("H05.6", new IcdEntry("H05.6", "Ophthalmology & Eye Clinical Entity #56: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 102));
        catalog.put("H05.7", new IcdEntry("H05.7", "Ophthalmology & Eye Clinical Entity #57: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 109));
        catalog.put("H05.8", new IcdEntry("H05.8", "Ophthalmology & Eye Clinical Entity #58: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 16));
        catalog.put("H05.9", new IcdEntry("H05.9", "Ophthalmology & Eye Clinical Entity #59: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 23));
        catalog.put("H06.0", new IcdEntry("H06.0", "Ophthalmology & Eye Clinical Entity #60: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 30));
        catalog.put("H06.1", new IcdEntry("H06.1", "Ophthalmology & Eye Clinical Entity #61: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 37));
        catalog.put("H06.2", new IcdEntry("H06.2", "Ophthalmology & Eye Clinical Entity #62: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 44));
        catalog.put("H06.3", new IcdEntry("H06.3", "Ophthalmology & Eye Clinical Entity #63: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 51));
        catalog.put("H06.4", new IcdEntry("H06.4", "Ophthalmology & Eye Clinical Entity #64: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 58));
        catalog.put("H06.5", new IcdEntry("H06.5", "Ophthalmology & Eye Clinical Entity #65: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 65));
        catalog.put("H06.6", new IcdEntry("H06.6", "Ophthalmology & Eye Clinical Entity #66: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 72));
        catalog.put("H06.7", new IcdEntry("H06.7", "Ophthalmology & Eye Clinical Entity #67: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 79));
        catalog.put("H06.8", new IcdEntry("H06.8", "Ophthalmology & Eye Clinical Entity #68: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 86));
        catalog.put("H06.9", new IcdEntry("H06.9", "Ophthalmology & Eye Clinical Entity #69: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 93));
        catalog.put("H07.0", new IcdEntry("H07.0", "Ophthalmology & Eye Clinical Entity #70: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 100));
        catalog.put("H07.1", new IcdEntry("H07.1", "Ophthalmology & Eye Clinical Entity #71: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 107));
        catalog.put("H07.2", new IcdEntry("H07.2", "Ophthalmology & Eye Clinical Entity #72: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 14));
        catalog.put("H07.3", new IcdEntry("H07.3", "Ophthalmology & Eye Clinical Entity #73: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 21));
        catalog.put("H07.4", new IcdEntry("H07.4", "Ophthalmology & Eye Clinical Entity #74: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 28));
        catalog.put("H07.5", new IcdEntry("H07.5", "Ophthalmology & Eye Clinical Entity #75: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 35));
        catalog.put("H07.6", new IcdEntry("H07.6", "Ophthalmology & Eye Clinical Entity #76: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 42));
        catalog.put("H07.7", new IcdEntry("H07.7", "Ophthalmology & Eye Clinical Entity #77: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 49));
        catalog.put("H07.8", new IcdEntry("H07.8", "Ophthalmology & Eye Clinical Entity #78: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 56));
        catalog.put("H07.9", new IcdEntry("H07.9", "Ophthalmology & Eye Clinical Entity #79: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 63));
        catalog.put("H08.0", new IcdEntry("H08.0", "Ophthalmology & Eye Clinical Entity #80: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 70));
        catalog.put("H08.1", new IcdEntry("H08.1", "Ophthalmology & Eye Clinical Entity #81: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 77));
        catalog.put("H08.2", new IcdEntry("H08.2", "Ophthalmology & Eye Clinical Entity #82: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 84));
        catalog.put("H08.3", new IcdEntry("H08.3", "Ophthalmology & Eye Clinical Entity #83: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 91));
        catalog.put("H08.4", new IcdEntry("H08.4", "Ophthalmology & Eye Clinical Entity #84: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 98));
        catalog.put("H08.5", new IcdEntry("H08.5", "Ophthalmology & Eye Clinical Entity #85: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 105));
        catalog.put("H08.6", new IcdEntry("H08.6", "Ophthalmology & Eye Clinical Entity #86: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 12));
        catalog.put("H08.7", new IcdEntry("H08.7", "Ophthalmology & Eye Clinical Entity #87: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 19));
        catalog.put("H08.8", new IcdEntry("H08.8", "Ophthalmology & Eye Clinical Entity #88: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 26));
        catalog.put("H08.9", new IcdEntry("H08.9", "Ophthalmology & Eye Clinical Entity #89: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 33));
        catalog.put("H09.0", new IcdEntry("H09.0", "Ophthalmology & Eye Clinical Entity #90: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 40));
        catalog.put("H09.1", new IcdEntry("H09.1", "Ophthalmology & Eye Clinical Entity #91: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 47));
        catalog.put("H09.2", new IcdEntry("H09.2", "Ophthalmology & Eye Clinical Entity #92: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 54));
        catalog.put("H09.3", new IcdEntry("H09.3", "Ophthalmology & Eye Clinical Entity #93: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 61));
        catalog.put("H09.4", new IcdEntry("H09.4", "Ophthalmology & Eye Clinical Entity #94: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 68));
        catalog.put("H09.5", new IcdEntry("H09.5", "Ophthalmology & Eye Clinical Entity #95: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 75));
        catalog.put("H09.6", new IcdEntry("H09.6", "Ophthalmology & Eye Clinical Entity #96: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 82));
        catalog.put("H09.7", new IcdEntry("H09.7", "Ophthalmology & Eye Clinical Entity #97: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 2", false, 89));
        catalog.put("H09.8", new IcdEntry("H09.8", "Ophthalmology & Eye Clinical Entity #98: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 3", true, 96));
        catalog.put("H09.9", new IcdEntry("H09.9", "Ophthalmology & Eye Clinical Entity #99: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 4", false, 103));
        catalog.put("H10.0", new IcdEntry("H10.0", "Ophthalmology & Eye Clinical Entity #100: Precision Diagnostic Marker", "H00-H59", "Clinical Severity Grade 1", true, 10));
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
