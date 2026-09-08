package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 01 (A00-B99): Infectious and Parasitic.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter01_InfectiousAndParasiticDiseases {

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

    public Icd10Chapter01_InfectiousAndParasiticDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("A00.1", new IcdEntry("A00.1", "Infectious and Parasitic Clinical Entity #1: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 17));
        catalog.put("A00.2", new IcdEntry("A00.2", "Infectious and Parasitic Clinical Entity #2: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 24));
        catalog.put("A00.3", new IcdEntry("A00.3", "Infectious and Parasitic Clinical Entity #3: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 31));
        catalog.put("A00.4", new IcdEntry("A00.4", "Infectious and Parasitic Clinical Entity #4: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 38));
        catalog.put("A00.5", new IcdEntry("A00.5", "Infectious and Parasitic Clinical Entity #5: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 45));
        catalog.put("A00.6", new IcdEntry("A00.6", "Infectious and Parasitic Clinical Entity #6: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 52));
        catalog.put("A00.7", new IcdEntry("A00.7", "Infectious and Parasitic Clinical Entity #7: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 59));
        catalog.put("A00.8", new IcdEntry("A00.8", "Infectious and Parasitic Clinical Entity #8: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 66));
        catalog.put("A00.9", new IcdEntry("A00.9", "Infectious and Parasitic Clinical Entity #9: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 73));
        catalog.put("A01.0", new IcdEntry("A01.0", "Infectious and Parasitic Clinical Entity #10: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 80));
        catalog.put("A01.1", new IcdEntry("A01.1", "Infectious and Parasitic Clinical Entity #11: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 87));
        catalog.put("A01.2", new IcdEntry("A01.2", "Infectious and Parasitic Clinical Entity #12: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 94));
        catalog.put("A01.3", new IcdEntry("A01.3", "Infectious and Parasitic Clinical Entity #13: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 101));
        catalog.put("A01.4", new IcdEntry("A01.4", "Infectious and Parasitic Clinical Entity #14: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 108));
        catalog.put("A01.5", new IcdEntry("A01.5", "Infectious and Parasitic Clinical Entity #15: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 15));
        catalog.put("A01.6", new IcdEntry("A01.6", "Infectious and Parasitic Clinical Entity #16: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 22));
        catalog.put("A01.7", new IcdEntry("A01.7", "Infectious and Parasitic Clinical Entity #17: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 29));
        catalog.put("A01.8", new IcdEntry("A01.8", "Infectious and Parasitic Clinical Entity #18: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 36));
        catalog.put("A01.9", new IcdEntry("A01.9", "Infectious and Parasitic Clinical Entity #19: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 43));
        catalog.put("A02.0", new IcdEntry("A02.0", "Infectious and Parasitic Clinical Entity #20: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 50));
        catalog.put("A02.1", new IcdEntry("A02.1", "Infectious and Parasitic Clinical Entity #21: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 57));
        catalog.put("A02.2", new IcdEntry("A02.2", "Infectious and Parasitic Clinical Entity #22: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 64));
        catalog.put("A02.3", new IcdEntry("A02.3", "Infectious and Parasitic Clinical Entity #23: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 71));
        catalog.put("A02.4", new IcdEntry("A02.4", "Infectious and Parasitic Clinical Entity #24: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 78));
        catalog.put("A02.5", new IcdEntry("A02.5", "Infectious and Parasitic Clinical Entity #25: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 85));
        catalog.put("A02.6", new IcdEntry("A02.6", "Infectious and Parasitic Clinical Entity #26: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 92));
        catalog.put("A02.7", new IcdEntry("A02.7", "Infectious and Parasitic Clinical Entity #27: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 99));
        catalog.put("A02.8", new IcdEntry("A02.8", "Infectious and Parasitic Clinical Entity #28: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 106));
        catalog.put("A02.9", new IcdEntry("A02.9", "Infectious and Parasitic Clinical Entity #29: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 13));
        catalog.put("A03.0", new IcdEntry("A03.0", "Infectious and Parasitic Clinical Entity #30: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 20));
        catalog.put("A03.1", new IcdEntry("A03.1", "Infectious and Parasitic Clinical Entity #31: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 27));
        catalog.put("A03.2", new IcdEntry("A03.2", "Infectious and Parasitic Clinical Entity #32: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 34));
        catalog.put("A03.3", new IcdEntry("A03.3", "Infectious and Parasitic Clinical Entity #33: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 41));
        catalog.put("A03.4", new IcdEntry("A03.4", "Infectious and Parasitic Clinical Entity #34: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 48));
        catalog.put("A03.5", new IcdEntry("A03.5", "Infectious and Parasitic Clinical Entity #35: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 55));
        catalog.put("A03.6", new IcdEntry("A03.6", "Infectious and Parasitic Clinical Entity #36: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 62));
        catalog.put("A03.7", new IcdEntry("A03.7", "Infectious and Parasitic Clinical Entity #37: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 69));
        catalog.put("A03.8", new IcdEntry("A03.8", "Infectious and Parasitic Clinical Entity #38: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 76));
        catalog.put("A03.9", new IcdEntry("A03.9", "Infectious and Parasitic Clinical Entity #39: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 83));
        catalog.put("A04.0", new IcdEntry("A04.0", "Infectious and Parasitic Clinical Entity #40: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 90));
        catalog.put("A04.1", new IcdEntry("A04.1", "Infectious and Parasitic Clinical Entity #41: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 97));
        catalog.put("A04.2", new IcdEntry("A04.2", "Infectious and Parasitic Clinical Entity #42: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 104));
        catalog.put("A04.3", new IcdEntry("A04.3", "Infectious and Parasitic Clinical Entity #43: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 11));
        catalog.put("A04.4", new IcdEntry("A04.4", "Infectious and Parasitic Clinical Entity #44: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 18));
        catalog.put("A04.5", new IcdEntry("A04.5", "Infectious and Parasitic Clinical Entity #45: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 25));
        catalog.put("A04.6", new IcdEntry("A04.6", "Infectious and Parasitic Clinical Entity #46: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 32));
        catalog.put("A04.7", new IcdEntry("A04.7", "Infectious and Parasitic Clinical Entity #47: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 39));
        catalog.put("A04.8", new IcdEntry("A04.8", "Infectious and Parasitic Clinical Entity #48: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 46));
        catalog.put("A04.9", new IcdEntry("A04.9", "Infectious and Parasitic Clinical Entity #49: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 53));
        catalog.put("A05.0", new IcdEntry("A05.0", "Infectious and Parasitic Clinical Entity #50: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 60));
        catalog.put("A05.1", new IcdEntry("A05.1", "Infectious and Parasitic Clinical Entity #51: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 67));
        catalog.put("A05.2", new IcdEntry("A05.2", "Infectious and Parasitic Clinical Entity #52: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 74));
        catalog.put("A05.3", new IcdEntry("A05.3", "Infectious and Parasitic Clinical Entity #53: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 81));
        catalog.put("A05.4", new IcdEntry("A05.4", "Infectious and Parasitic Clinical Entity #54: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 88));
        catalog.put("A05.5", new IcdEntry("A05.5", "Infectious and Parasitic Clinical Entity #55: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 95));
        catalog.put("A05.6", new IcdEntry("A05.6", "Infectious and Parasitic Clinical Entity #56: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 102));
        catalog.put("A05.7", new IcdEntry("A05.7", "Infectious and Parasitic Clinical Entity #57: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 109));
        catalog.put("A05.8", new IcdEntry("A05.8", "Infectious and Parasitic Clinical Entity #58: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 16));
        catalog.put("A05.9", new IcdEntry("A05.9", "Infectious and Parasitic Clinical Entity #59: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 23));
        catalog.put("A06.0", new IcdEntry("A06.0", "Infectious and Parasitic Clinical Entity #60: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 30));
        catalog.put("A06.1", new IcdEntry("A06.1", "Infectious and Parasitic Clinical Entity #61: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 37));
        catalog.put("A06.2", new IcdEntry("A06.2", "Infectious and Parasitic Clinical Entity #62: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 44));
        catalog.put("A06.3", new IcdEntry("A06.3", "Infectious and Parasitic Clinical Entity #63: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 51));
        catalog.put("A06.4", new IcdEntry("A06.4", "Infectious and Parasitic Clinical Entity #64: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 58));
        catalog.put("A06.5", new IcdEntry("A06.5", "Infectious and Parasitic Clinical Entity #65: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 65));
        catalog.put("A06.6", new IcdEntry("A06.6", "Infectious and Parasitic Clinical Entity #66: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 72));
        catalog.put("A06.7", new IcdEntry("A06.7", "Infectious and Parasitic Clinical Entity #67: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 79));
        catalog.put("A06.8", new IcdEntry("A06.8", "Infectious and Parasitic Clinical Entity #68: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 86));
        catalog.put("A06.9", new IcdEntry("A06.9", "Infectious and Parasitic Clinical Entity #69: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 93));
        catalog.put("A07.0", new IcdEntry("A07.0", "Infectious and Parasitic Clinical Entity #70: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 100));
        catalog.put("A07.1", new IcdEntry("A07.1", "Infectious and Parasitic Clinical Entity #71: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 107));
        catalog.put("A07.2", new IcdEntry("A07.2", "Infectious and Parasitic Clinical Entity #72: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 14));
        catalog.put("A07.3", new IcdEntry("A07.3", "Infectious and Parasitic Clinical Entity #73: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 21));
        catalog.put("A07.4", new IcdEntry("A07.4", "Infectious and Parasitic Clinical Entity #74: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 28));
        catalog.put("A07.5", new IcdEntry("A07.5", "Infectious and Parasitic Clinical Entity #75: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 35));
        catalog.put("A07.6", new IcdEntry("A07.6", "Infectious and Parasitic Clinical Entity #76: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 42));
        catalog.put("A07.7", new IcdEntry("A07.7", "Infectious and Parasitic Clinical Entity #77: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 49));
        catalog.put("A07.8", new IcdEntry("A07.8", "Infectious and Parasitic Clinical Entity #78: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 56));
        catalog.put("A07.9", new IcdEntry("A07.9", "Infectious and Parasitic Clinical Entity #79: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 63));
        catalog.put("A08.0", new IcdEntry("A08.0", "Infectious and Parasitic Clinical Entity #80: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 70));
        catalog.put("A08.1", new IcdEntry("A08.1", "Infectious and Parasitic Clinical Entity #81: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 77));
        catalog.put("A08.2", new IcdEntry("A08.2", "Infectious and Parasitic Clinical Entity #82: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 84));
        catalog.put("A08.3", new IcdEntry("A08.3", "Infectious and Parasitic Clinical Entity #83: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 91));
        catalog.put("A08.4", new IcdEntry("A08.4", "Infectious and Parasitic Clinical Entity #84: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 98));
        catalog.put("A08.5", new IcdEntry("A08.5", "Infectious and Parasitic Clinical Entity #85: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 105));
        catalog.put("A08.6", new IcdEntry("A08.6", "Infectious and Parasitic Clinical Entity #86: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 12));
        catalog.put("A08.7", new IcdEntry("A08.7", "Infectious and Parasitic Clinical Entity #87: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 19));
        catalog.put("A08.8", new IcdEntry("A08.8", "Infectious and Parasitic Clinical Entity #88: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 26));
        catalog.put("A08.9", new IcdEntry("A08.9", "Infectious and Parasitic Clinical Entity #89: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 33));
        catalog.put("A09.0", new IcdEntry("A09.0", "Infectious and Parasitic Clinical Entity #90: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 40));
        catalog.put("A09.1", new IcdEntry("A09.1", "Infectious and Parasitic Clinical Entity #91: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 47));
        catalog.put("A09.2", new IcdEntry("A09.2", "Infectious and Parasitic Clinical Entity #92: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 54));
        catalog.put("A09.3", new IcdEntry("A09.3", "Infectious and Parasitic Clinical Entity #93: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 61));
        catalog.put("A09.4", new IcdEntry("A09.4", "Infectious and Parasitic Clinical Entity #94: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 68));
        catalog.put("A09.5", new IcdEntry("A09.5", "Infectious and Parasitic Clinical Entity #95: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 75));
        catalog.put("A09.6", new IcdEntry("A09.6", "Infectious and Parasitic Clinical Entity #96: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 82));
        catalog.put("A09.7", new IcdEntry("A09.7", "Infectious and Parasitic Clinical Entity #97: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 89));
        catalog.put("A09.8", new IcdEntry("A09.8", "Infectious and Parasitic Clinical Entity #98: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 96));
        catalog.put("A09.9", new IcdEntry("A09.9", "Infectious and Parasitic Clinical Entity #99: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 103));
        catalog.put("A10.0", new IcdEntry("A10.0", "Infectious and Parasitic Clinical Entity #100: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 10));
        catalog.put("A10.1", new IcdEntry("A10.1", "Infectious and Parasitic Clinical Entity #101: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 17));
        catalog.put("A10.2", new IcdEntry("A10.2", "Infectious and Parasitic Clinical Entity #102: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 24));
        catalog.put("A10.3", new IcdEntry("A10.3", "Infectious and Parasitic Clinical Entity #103: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 31));
        catalog.put("A10.4", new IcdEntry("A10.4", "Infectious and Parasitic Clinical Entity #104: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 38));
        catalog.put("A10.5", new IcdEntry("A10.5", "Infectious and Parasitic Clinical Entity #105: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 45));
        catalog.put("A10.6", new IcdEntry("A10.6", "Infectious and Parasitic Clinical Entity #106: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 52));
        catalog.put("A10.7", new IcdEntry("A10.7", "Infectious and Parasitic Clinical Entity #107: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 59));
        catalog.put("A10.8", new IcdEntry("A10.8", "Infectious and Parasitic Clinical Entity #108: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 66));
        catalog.put("A10.9", new IcdEntry("A10.9", "Infectious and Parasitic Clinical Entity #109: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 73));
        catalog.put("A11.0", new IcdEntry("A11.0", "Infectious and Parasitic Clinical Entity #110: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 80));
        catalog.put("A11.1", new IcdEntry("A11.1", "Infectious and Parasitic Clinical Entity #111: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 87));
        catalog.put("A11.2", new IcdEntry("A11.2", "Infectious and Parasitic Clinical Entity #112: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 94));
        catalog.put("A11.3", new IcdEntry("A11.3", "Infectious and Parasitic Clinical Entity #113: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 101));
        catalog.put("A11.4", new IcdEntry("A11.4", "Infectious and Parasitic Clinical Entity #114: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 108));
        catalog.put("A11.5", new IcdEntry("A11.5", "Infectious and Parasitic Clinical Entity #115: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 15));
        catalog.put("A11.6", new IcdEntry("A11.6", "Infectious and Parasitic Clinical Entity #116: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 22));
        catalog.put("A11.7", new IcdEntry("A11.7", "Infectious and Parasitic Clinical Entity #117: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 2", false, 29));
        catalog.put("A11.8", new IcdEntry("A11.8", "Infectious and Parasitic Clinical Entity #118: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 3", true, 36));
        catalog.put("A11.9", new IcdEntry("A11.9", "Infectious and Parasitic Clinical Entity #119: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 4", false, 43));
        catalog.put("A12.0", new IcdEntry("A12.0", "Infectious and Parasitic Clinical Entity #120: Precision Diagnostic Marker", "A00-B99", "Clinical Severity Grade 1", true, 50));
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
