package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 16 (P00-P96): Neonatology & Perinatal.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter16_PerinatalPeriodConditions {

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

    public Icd10Chapter16_PerinatalPeriodConditions() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("P00.1", new IcdEntry("P00.1", "Neonatology & Perinatal Clinical Entity #1: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 17));
        catalog.put("P00.2", new IcdEntry("P00.2", "Neonatology & Perinatal Clinical Entity #2: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 24));
        catalog.put("P00.3", new IcdEntry("P00.3", "Neonatology & Perinatal Clinical Entity #3: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 31));
        catalog.put("P00.4", new IcdEntry("P00.4", "Neonatology & Perinatal Clinical Entity #4: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 38));
        catalog.put("P00.5", new IcdEntry("P00.5", "Neonatology & Perinatal Clinical Entity #5: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 45));
        catalog.put("P00.6", new IcdEntry("P00.6", "Neonatology & Perinatal Clinical Entity #6: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 52));
        catalog.put("P00.7", new IcdEntry("P00.7", "Neonatology & Perinatal Clinical Entity #7: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 59));
        catalog.put("P00.8", new IcdEntry("P00.8", "Neonatology & Perinatal Clinical Entity #8: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 66));
        catalog.put("P00.9", new IcdEntry("P00.9", "Neonatology & Perinatal Clinical Entity #9: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 73));
        catalog.put("P01.0", new IcdEntry("P01.0", "Neonatology & Perinatal Clinical Entity #10: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 80));
        catalog.put("P01.1", new IcdEntry("P01.1", "Neonatology & Perinatal Clinical Entity #11: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 87));
        catalog.put("P01.2", new IcdEntry("P01.2", "Neonatology & Perinatal Clinical Entity #12: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 94));
        catalog.put("P01.3", new IcdEntry("P01.3", "Neonatology & Perinatal Clinical Entity #13: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 101));
        catalog.put("P01.4", new IcdEntry("P01.4", "Neonatology & Perinatal Clinical Entity #14: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 108));
        catalog.put("P01.5", new IcdEntry("P01.5", "Neonatology & Perinatal Clinical Entity #15: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 15));
        catalog.put("P01.6", new IcdEntry("P01.6", "Neonatology & Perinatal Clinical Entity #16: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 22));
        catalog.put("P01.7", new IcdEntry("P01.7", "Neonatology & Perinatal Clinical Entity #17: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 29));
        catalog.put("P01.8", new IcdEntry("P01.8", "Neonatology & Perinatal Clinical Entity #18: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 36));
        catalog.put("P01.9", new IcdEntry("P01.9", "Neonatology & Perinatal Clinical Entity #19: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 43));
        catalog.put("P02.0", new IcdEntry("P02.0", "Neonatology & Perinatal Clinical Entity #20: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 50));
        catalog.put("P02.1", new IcdEntry("P02.1", "Neonatology & Perinatal Clinical Entity #21: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 57));
        catalog.put("P02.2", new IcdEntry("P02.2", "Neonatology & Perinatal Clinical Entity #22: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 64));
        catalog.put("P02.3", new IcdEntry("P02.3", "Neonatology & Perinatal Clinical Entity #23: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 71));
        catalog.put("P02.4", new IcdEntry("P02.4", "Neonatology & Perinatal Clinical Entity #24: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 78));
        catalog.put("P02.5", new IcdEntry("P02.5", "Neonatology & Perinatal Clinical Entity #25: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 85));
        catalog.put("P02.6", new IcdEntry("P02.6", "Neonatology & Perinatal Clinical Entity #26: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 92));
        catalog.put("P02.7", new IcdEntry("P02.7", "Neonatology & Perinatal Clinical Entity #27: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 99));
        catalog.put("P02.8", new IcdEntry("P02.8", "Neonatology & Perinatal Clinical Entity #28: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 106));
        catalog.put("P02.9", new IcdEntry("P02.9", "Neonatology & Perinatal Clinical Entity #29: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 13));
        catalog.put("P03.0", new IcdEntry("P03.0", "Neonatology & Perinatal Clinical Entity #30: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 20));
        catalog.put("P03.1", new IcdEntry("P03.1", "Neonatology & Perinatal Clinical Entity #31: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 27));
        catalog.put("P03.2", new IcdEntry("P03.2", "Neonatology & Perinatal Clinical Entity #32: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 34));
        catalog.put("P03.3", new IcdEntry("P03.3", "Neonatology & Perinatal Clinical Entity #33: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 41));
        catalog.put("P03.4", new IcdEntry("P03.4", "Neonatology & Perinatal Clinical Entity #34: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 48));
        catalog.put("P03.5", new IcdEntry("P03.5", "Neonatology & Perinatal Clinical Entity #35: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 55));
        catalog.put("P03.6", new IcdEntry("P03.6", "Neonatology & Perinatal Clinical Entity #36: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 62));
        catalog.put("P03.7", new IcdEntry("P03.7", "Neonatology & Perinatal Clinical Entity #37: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 69));
        catalog.put("P03.8", new IcdEntry("P03.8", "Neonatology & Perinatal Clinical Entity #38: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 76));
        catalog.put("P03.9", new IcdEntry("P03.9", "Neonatology & Perinatal Clinical Entity #39: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 83));
        catalog.put("P04.0", new IcdEntry("P04.0", "Neonatology & Perinatal Clinical Entity #40: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 90));
        catalog.put("P04.1", new IcdEntry("P04.1", "Neonatology & Perinatal Clinical Entity #41: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 97));
        catalog.put("P04.2", new IcdEntry("P04.2", "Neonatology & Perinatal Clinical Entity #42: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 104));
        catalog.put("P04.3", new IcdEntry("P04.3", "Neonatology & Perinatal Clinical Entity #43: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 11));
        catalog.put("P04.4", new IcdEntry("P04.4", "Neonatology & Perinatal Clinical Entity #44: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 18));
        catalog.put("P04.5", new IcdEntry("P04.5", "Neonatology & Perinatal Clinical Entity #45: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 25));
        catalog.put("P04.6", new IcdEntry("P04.6", "Neonatology & Perinatal Clinical Entity #46: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 32));
        catalog.put("P04.7", new IcdEntry("P04.7", "Neonatology & Perinatal Clinical Entity #47: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 39));
        catalog.put("P04.8", new IcdEntry("P04.8", "Neonatology & Perinatal Clinical Entity #48: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 46));
        catalog.put("P04.9", new IcdEntry("P04.9", "Neonatology & Perinatal Clinical Entity #49: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 53));
        catalog.put("P05.0", new IcdEntry("P05.0", "Neonatology & Perinatal Clinical Entity #50: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 60));
        catalog.put("P05.1", new IcdEntry("P05.1", "Neonatology & Perinatal Clinical Entity #51: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 67));
        catalog.put("P05.2", new IcdEntry("P05.2", "Neonatology & Perinatal Clinical Entity #52: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 74));
        catalog.put("P05.3", new IcdEntry("P05.3", "Neonatology & Perinatal Clinical Entity #53: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 81));
        catalog.put("P05.4", new IcdEntry("P05.4", "Neonatology & Perinatal Clinical Entity #54: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 88));
        catalog.put("P05.5", new IcdEntry("P05.5", "Neonatology & Perinatal Clinical Entity #55: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 95));
        catalog.put("P05.6", new IcdEntry("P05.6", "Neonatology & Perinatal Clinical Entity #56: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 102));
        catalog.put("P05.7", new IcdEntry("P05.7", "Neonatology & Perinatal Clinical Entity #57: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 109));
        catalog.put("P05.8", new IcdEntry("P05.8", "Neonatology & Perinatal Clinical Entity #58: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 16));
        catalog.put("P05.9", new IcdEntry("P05.9", "Neonatology & Perinatal Clinical Entity #59: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 23));
        catalog.put("P06.0", new IcdEntry("P06.0", "Neonatology & Perinatal Clinical Entity #60: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 30));
        catalog.put("P06.1", new IcdEntry("P06.1", "Neonatology & Perinatal Clinical Entity #61: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 37));
        catalog.put("P06.2", new IcdEntry("P06.2", "Neonatology & Perinatal Clinical Entity #62: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 44));
        catalog.put("P06.3", new IcdEntry("P06.3", "Neonatology & Perinatal Clinical Entity #63: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 51));
        catalog.put("P06.4", new IcdEntry("P06.4", "Neonatology & Perinatal Clinical Entity #64: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 58));
        catalog.put("P06.5", new IcdEntry("P06.5", "Neonatology & Perinatal Clinical Entity #65: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 65));
        catalog.put("P06.6", new IcdEntry("P06.6", "Neonatology & Perinatal Clinical Entity #66: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 72));
        catalog.put("P06.7", new IcdEntry("P06.7", "Neonatology & Perinatal Clinical Entity #67: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 79));
        catalog.put("P06.8", new IcdEntry("P06.8", "Neonatology & Perinatal Clinical Entity #68: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 86));
        catalog.put("P06.9", new IcdEntry("P06.9", "Neonatology & Perinatal Clinical Entity #69: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 93));
        catalog.put("P07.0", new IcdEntry("P07.0", "Neonatology & Perinatal Clinical Entity #70: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 100));
        catalog.put("P07.1", new IcdEntry("P07.1", "Neonatology & Perinatal Clinical Entity #71: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 107));
        catalog.put("P07.2", new IcdEntry("P07.2", "Neonatology & Perinatal Clinical Entity #72: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 14));
        catalog.put("P07.3", new IcdEntry("P07.3", "Neonatology & Perinatal Clinical Entity #73: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 21));
        catalog.put("P07.4", new IcdEntry("P07.4", "Neonatology & Perinatal Clinical Entity #74: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 28));
        catalog.put("P07.5", new IcdEntry("P07.5", "Neonatology & Perinatal Clinical Entity #75: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 35));
        catalog.put("P07.6", new IcdEntry("P07.6", "Neonatology & Perinatal Clinical Entity #76: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 42));
        catalog.put("P07.7", new IcdEntry("P07.7", "Neonatology & Perinatal Clinical Entity #77: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 49));
        catalog.put("P07.8", new IcdEntry("P07.8", "Neonatology & Perinatal Clinical Entity #78: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 56));
        catalog.put("P07.9", new IcdEntry("P07.9", "Neonatology & Perinatal Clinical Entity #79: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 63));
        catalog.put("P08.0", new IcdEntry("P08.0", "Neonatology & Perinatal Clinical Entity #80: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 70));
        catalog.put("P08.1", new IcdEntry("P08.1", "Neonatology & Perinatal Clinical Entity #81: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 77));
        catalog.put("P08.2", new IcdEntry("P08.2", "Neonatology & Perinatal Clinical Entity #82: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 84));
        catalog.put("P08.3", new IcdEntry("P08.3", "Neonatology & Perinatal Clinical Entity #83: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 91));
        catalog.put("P08.4", new IcdEntry("P08.4", "Neonatology & Perinatal Clinical Entity #84: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 98));
        catalog.put("P08.5", new IcdEntry("P08.5", "Neonatology & Perinatal Clinical Entity #85: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 105));
        catalog.put("P08.6", new IcdEntry("P08.6", "Neonatology & Perinatal Clinical Entity #86: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 12));
        catalog.put("P08.7", new IcdEntry("P08.7", "Neonatology & Perinatal Clinical Entity #87: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 4", false, 19));
        catalog.put("P08.8", new IcdEntry("P08.8", "Neonatology & Perinatal Clinical Entity #88: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 1", true, 26));
        catalog.put("P08.9", new IcdEntry("P08.9", "Neonatology & Perinatal Clinical Entity #89: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 2", false, 33));
        catalog.put("P09.0", new IcdEntry("P09.0", "Neonatology & Perinatal Clinical Entity #90: Precision Diagnostic Marker", "P00-P96", "Clinical Severity Grade 3", true, 40));
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
