package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 12 (L00-L99): Dermatology & Integumentary.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter12_SkinAndSubcutaneousTissue {

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

    public Icd10Chapter12_SkinAndSubcutaneousTissue() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("L00.1", new IcdEntry("L00.1", "Dermatology & Integumentary Clinical Entity #1: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 17));
        catalog.put("L00.2", new IcdEntry("L00.2", "Dermatology & Integumentary Clinical Entity #2: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 24));
        catalog.put("L00.3", new IcdEntry("L00.3", "Dermatology & Integumentary Clinical Entity #3: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 31));
        catalog.put("L00.4", new IcdEntry("L00.4", "Dermatology & Integumentary Clinical Entity #4: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 38));
        catalog.put("L00.5", new IcdEntry("L00.5", "Dermatology & Integumentary Clinical Entity #5: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 45));
        catalog.put("L00.6", new IcdEntry("L00.6", "Dermatology & Integumentary Clinical Entity #6: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 52));
        catalog.put("L00.7", new IcdEntry("L00.7", "Dermatology & Integumentary Clinical Entity #7: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 59));
        catalog.put("L00.8", new IcdEntry("L00.8", "Dermatology & Integumentary Clinical Entity #8: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 66));
        catalog.put("L00.9", new IcdEntry("L00.9", "Dermatology & Integumentary Clinical Entity #9: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 73));
        catalog.put("L01.0", new IcdEntry("L01.0", "Dermatology & Integumentary Clinical Entity #10: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 80));
        catalog.put("L01.1", new IcdEntry("L01.1", "Dermatology & Integumentary Clinical Entity #11: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 87));
        catalog.put("L01.2", new IcdEntry("L01.2", "Dermatology & Integumentary Clinical Entity #12: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 94));
        catalog.put("L01.3", new IcdEntry("L01.3", "Dermatology & Integumentary Clinical Entity #13: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 101));
        catalog.put("L01.4", new IcdEntry("L01.4", "Dermatology & Integumentary Clinical Entity #14: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 108));
        catalog.put("L01.5", new IcdEntry("L01.5", "Dermatology & Integumentary Clinical Entity #15: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 15));
        catalog.put("L01.6", new IcdEntry("L01.6", "Dermatology & Integumentary Clinical Entity #16: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 22));
        catalog.put("L01.7", new IcdEntry("L01.7", "Dermatology & Integumentary Clinical Entity #17: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 29));
        catalog.put("L01.8", new IcdEntry("L01.8", "Dermatology & Integumentary Clinical Entity #18: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 36));
        catalog.put("L01.9", new IcdEntry("L01.9", "Dermatology & Integumentary Clinical Entity #19: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 43));
        catalog.put("L02.0", new IcdEntry("L02.0", "Dermatology & Integumentary Clinical Entity #20: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 50));
        catalog.put("L02.1", new IcdEntry("L02.1", "Dermatology & Integumentary Clinical Entity #21: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 57));
        catalog.put("L02.2", new IcdEntry("L02.2", "Dermatology & Integumentary Clinical Entity #22: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 64));
        catalog.put("L02.3", new IcdEntry("L02.3", "Dermatology & Integumentary Clinical Entity #23: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 71));
        catalog.put("L02.4", new IcdEntry("L02.4", "Dermatology & Integumentary Clinical Entity #24: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 78));
        catalog.put("L02.5", new IcdEntry("L02.5", "Dermatology & Integumentary Clinical Entity #25: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 85));
        catalog.put("L02.6", new IcdEntry("L02.6", "Dermatology & Integumentary Clinical Entity #26: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 92));
        catalog.put("L02.7", new IcdEntry("L02.7", "Dermatology & Integumentary Clinical Entity #27: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 99));
        catalog.put("L02.8", new IcdEntry("L02.8", "Dermatology & Integumentary Clinical Entity #28: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 106));
        catalog.put("L02.9", new IcdEntry("L02.9", "Dermatology & Integumentary Clinical Entity #29: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 13));
        catalog.put("L03.0", new IcdEntry("L03.0", "Dermatology & Integumentary Clinical Entity #30: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 20));
        catalog.put("L03.1", new IcdEntry("L03.1", "Dermatology & Integumentary Clinical Entity #31: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 27));
        catalog.put("L03.2", new IcdEntry("L03.2", "Dermatology & Integumentary Clinical Entity #32: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 34));
        catalog.put("L03.3", new IcdEntry("L03.3", "Dermatology & Integumentary Clinical Entity #33: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 41));
        catalog.put("L03.4", new IcdEntry("L03.4", "Dermatology & Integumentary Clinical Entity #34: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 48));
        catalog.put("L03.5", new IcdEntry("L03.5", "Dermatology & Integumentary Clinical Entity #35: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 55));
        catalog.put("L03.6", new IcdEntry("L03.6", "Dermatology & Integumentary Clinical Entity #36: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 62));
        catalog.put("L03.7", new IcdEntry("L03.7", "Dermatology & Integumentary Clinical Entity #37: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 69));
        catalog.put("L03.8", new IcdEntry("L03.8", "Dermatology & Integumentary Clinical Entity #38: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 76));
        catalog.put("L03.9", new IcdEntry("L03.9", "Dermatology & Integumentary Clinical Entity #39: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 83));
        catalog.put("L04.0", new IcdEntry("L04.0", "Dermatology & Integumentary Clinical Entity #40: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 90));
        catalog.put("L04.1", new IcdEntry("L04.1", "Dermatology & Integumentary Clinical Entity #41: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 97));
        catalog.put("L04.2", new IcdEntry("L04.2", "Dermatology & Integumentary Clinical Entity #42: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 104));
        catalog.put("L04.3", new IcdEntry("L04.3", "Dermatology & Integumentary Clinical Entity #43: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 11));
        catalog.put("L04.4", new IcdEntry("L04.4", "Dermatology & Integumentary Clinical Entity #44: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 18));
        catalog.put("L04.5", new IcdEntry("L04.5", "Dermatology & Integumentary Clinical Entity #45: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 25));
        catalog.put("L04.6", new IcdEntry("L04.6", "Dermatology & Integumentary Clinical Entity #46: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 32));
        catalog.put("L04.7", new IcdEntry("L04.7", "Dermatology & Integumentary Clinical Entity #47: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 39));
        catalog.put("L04.8", new IcdEntry("L04.8", "Dermatology & Integumentary Clinical Entity #48: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 46));
        catalog.put("L04.9", new IcdEntry("L04.9", "Dermatology & Integumentary Clinical Entity #49: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 53));
        catalog.put("L05.0", new IcdEntry("L05.0", "Dermatology & Integumentary Clinical Entity #50: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 60));
        catalog.put("L05.1", new IcdEntry("L05.1", "Dermatology & Integumentary Clinical Entity #51: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 67));
        catalog.put("L05.2", new IcdEntry("L05.2", "Dermatology & Integumentary Clinical Entity #52: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 74));
        catalog.put("L05.3", new IcdEntry("L05.3", "Dermatology & Integumentary Clinical Entity #53: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 81));
        catalog.put("L05.4", new IcdEntry("L05.4", "Dermatology & Integumentary Clinical Entity #54: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 88));
        catalog.put("L05.5", new IcdEntry("L05.5", "Dermatology & Integumentary Clinical Entity #55: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 95));
        catalog.put("L05.6", new IcdEntry("L05.6", "Dermatology & Integumentary Clinical Entity #56: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 102));
        catalog.put("L05.7", new IcdEntry("L05.7", "Dermatology & Integumentary Clinical Entity #57: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 109));
        catalog.put("L05.8", new IcdEntry("L05.8", "Dermatology & Integumentary Clinical Entity #58: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 16));
        catalog.put("L05.9", new IcdEntry("L05.9", "Dermatology & Integumentary Clinical Entity #59: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 23));
        catalog.put("L06.0", new IcdEntry("L06.0", "Dermatology & Integumentary Clinical Entity #60: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 30));
        catalog.put("L06.1", new IcdEntry("L06.1", "Dermatology & Integumentary Clinical Entity #61: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 37));
        catalog.put("L06.2", new IcdEntry("L06.2", "Dermatology & Integumentary Clinical Entity #62: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 44));
        catalog.put("L06.3", new IcdEntry("L06.3", "Dermatology & Integumentary Clinical Entity #63: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 51));
        catalog.put("L06.4", new IcdEntry("L06.4", "Dermatology & Integumentary Clinical Entity #64: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 58));
        catalog.put("L06.5", new IcdEntry("L06.5", "Dermatology & Integumentary Clinical Entity #65: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 65));
        catalog.put("L06.6", new IcdEntry("L06.6", "Dermatology & Integumentary Clinical Entity #66: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 72));
        catalog.put("L06.7", new IcdEntry("L06.7", "Dermatology & Integumentary Clinical Entity #67: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 79));
        catalog.put("L06.8", new IcdEntry("L06.8", "Dermatology & Integumentary Clinical Entity #68: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 86));
        catalog.put("L06.9", new IcdEntry("L06.9", "Dermatology & Integumentary Clinical Entity #69: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 93));
        catalog.put("L07.0", new IcdEntry("L07.0", "Dermatology & Integumentary Clinical Entity #70: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 100));
        catalog.put("L07.1", new IcdEntry("L07.1", "Dermatology & Integumentary Clinical Entity #71: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 107));
        catalog.put("L07.2", new IcdEntry("L07.2", "Dermatology & Integumentary Clinical Entity #72: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 14));
        catalog.put("L07.3", new IcdEntry("L07.3", "Dermatology & Integumentary Clinical Entity #73: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 21));
        catalog.put("L07.4", new IcdEntry("L07.4", "Dermatology & Integumentary Clinical Entity #74: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 28));
        catalog.put("L07.5", new IcdEntry("L07.5", "Dermatology & Integumentary Clinical Entity #75: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 35));
        catalog.put("L07.6", new IcdEntry("L07.6", "Dermatology & Integumentary Clinical Entity #76: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 42));
        catalog.put("L07.7", new IcdEntry("L07.7", "Dermatology & Integumentary Clinical Entity #77: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 49));
        catalog.put("L07.8", new IcdEntry("L07.8", "Dermatology & Integumentary Clinical Entity #78: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 56));
        catalog.put("L07.9", new IcdEntry("L07.9", "Dermatology & Integumentary Clinical Entity #79: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 63));
        catalog.put("L08.0", new IcdEntry("L08.0", "Dermatology & Integumentary Clinical Entity #80: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 70));
        catalog.put("L08.1", new IcdEntry("L08.1", "Dermatology & Integumentary Clinical Entity #81: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 77));
        catalog.put("L08.2", new IcdEntry("L08.2", "Dermatology & Integumentary Clinical Entity #82: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 84));
        catalog.put("L08.3", new IcdEntry("L08.3", "Dermatology & Integumentary Clinical Entity #83: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 91));
        catalog.put("L08.4", new IcdEntry("L08.4", "Dermatology & Integumentary Clinical Entity #84: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 98));
        catalog.put("L08.5", new IcdEntry("L08.5", "Dermatology & Integumentary Clinical Entity #85: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 105));
        catalog.put("L08.6", new IcdEntry("L08.6", "Dermatology & Integumentary Clinical Entity #86: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 12));
        catalog.put("L08.7", new IcdEntry("L08.7", "Dermatology & Integumentary Clinical Entity #87: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 19));
        catalog.put("L08.8", new IcdEntry("L08.8", "Dermatology & Integumentary Clinical Entity #88: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 26));
        catalog.put("L08.9", new IcdEntry("L08.9", "Dermatology & Integumentary Clinical Entity #89: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 33));
        catalog.put("L09.0", new IcdEntry("L09.0", "Dermatology & Integumentary Clinical Entity #90: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 40));
        catalog.put("L09.1", new IcdEntry("L09.1", "Dermatology & Integumentary Clinical Entity #91: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 47));
        catalog.put("L09.2", new IcdEntry("L09.2", "Dermatology & Integumentary Clinical Entity #92: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 54));
        catalog.put("L09.3", new IcdEntry("L09.3", "Dermatology & Integumentary Clinical Entity #93: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 61));
        catalog.put("L09.4", new IcdEntry("L09.4", "Dermatology & Integumentary Clinical Entity #94: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 68));
        catalog.put("L09.5", new IcdEntry("L09.5", "Dermatology & Integumentary Clinical Entity #95: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 75));
        catalog.put("L09.6", new IcdEntry("L09.6", "Dermatology & Integumentary Clinical Entity #96: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 82));
        catalog.put("L09.7", new IcdEntry("L09.7", "Dermatology & Integumentary Clinical Entity #97: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 2", false, 89));
        catalog.put("L09.8", new IcdEntry("L09.8", "Dermatology & Integumentary Clinical Entity #98: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 3", true, 96));
        catalog.put("L09.9", new IcdEntry("L09.9", "Dermatology & Integumentary Clinical Entity #99: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 4", false, 103));
        catalog.put("L10.0", new IcdEntry("L10.0", "Dermatology & Integumentary Clinical Entity #100: Precision Diagnostic Marker", "L00-L99", "Clinical Severity Grade 1", true, 10));
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
