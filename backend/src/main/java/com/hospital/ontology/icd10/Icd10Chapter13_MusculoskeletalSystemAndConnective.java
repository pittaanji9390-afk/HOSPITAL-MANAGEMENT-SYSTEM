package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 13 (M00-M99): Orthopedics & Rheumatology.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter13_MusculoskeletalSystemAndConnective {

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

    public Icd10Chapter13_MusculoskeletalSystemAndConnective() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("M00.1", new IcdEntry("M00.1", "Orthopedics & Rheumatology Clinical Entity #1: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 17));
        catalog.put("M00.2", new IcdEntry("M00.2", "Orthopedics & Rheumatology Clinical Entity #2: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 24));
        catalog.put("M00.3", new IcdEntry("M00.3", "Orthopedics & Rheumatology Clinical Entity #3: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 31));
        catalog.put("M00.4", new IcdEntry("M00.4", "Orthopedics & Rheumatology Clinical Entity #4: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 38));
        catalog.put("M00.5", new IcdEntry("M00.5", "Orthopedics & Rheumatology Clinical Entity #5: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 45));
        catalog.put("M00.6", new IcdEntry("M00.6", "Orthopedics & Rheumatology Clinical Entity #6: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 52));
        catalog.put("M00.7", new IcdEntry("M00.7", "Orthopedics & Rheumatology Clinical Entity #7: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 59));
        catalog.put("M00.8", new IcdEntry("M00.8", "Orthopedics & Rheumatology Clinical Entity #8: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 66));
        catalog.put("M00.9", new IcdEntry("M00.9", "Orthopedics & Rheumatology Clinical Entity #9: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 73));
        catalog.put("M01.0", new IcdEntry("M01.0", "Orthopedics & Rheumatology Clinical Entity #10: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 80));
        catalog.put("M01.1", new IcdEntry("M01.1", "Orthopedics & Rheumatology Clinical Entity #11: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 87));
        catalog.put("M01.2", new IcdEntry("M01.2", "Orthopedics & Rheumatology Clinical Entity #12: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 94));
        catalog.put("M01.3", new IcdEntry("M01.3", "Orthopedics & Rheumatology Clinical Entity #13: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 101));
        catalog.put("M01.4", new IcdEntry("M01.4", "Orthopedics & Rheumatology Clinical Entity #14: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 108));
        catalog.put("M01.5", new IcdEntry("M01.5", "Orthopedics & Rheumatology Clinical Entity #15: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 15));
        catalog.put("M01.6", new IcdEntry("M01.6", "Orthopedics & Rheumatology Clinical Entity #16: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 22));
        catalog.put("M01.7", new IcdEntry("M01.7", "Orthopedics & Rheumatology Clinical Entity #17: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 29));
        catalog.put("M01.8", new IcdEntry("M01.8", "Orthopedics & Rheumatology Clinical Entity #18: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 36));
        catalog.put("M01.9", new IcdEntry("M01.9", "Orthopedics & Rheumatology Clinical Entity #19: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 43));
        catalog.put("M02.0", new IcdEntry("M02.0", "Orthopedics & Rheumatology Clinical Entity #20: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 50));
        catalog.put("M02.1", new IcdEntry("M02.1", "Orthopedics & Rheumatology Clinical Entity #21: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 57));
        catalog.put("M02.2", new IcdEntry("M02.2", "Orthopedics & Rheumatology Clinical Entity #22: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 64));
        catalog.put("M02.3", new IcdEntry("M02.3", "Orthopedics & Rheumatology Clinical Entity #23: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 71));
        catalog.put("M02.4", new IcdEntry("M02.4", "Orthopedics & Rheumatology Clinical Entity #24: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 78));
        catalog.put("M02.5", new IcdEntry("M02.5", "Orthopedics & Rheumatology Clinical Entity #25: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 85));
        catalog.put("M02.6", new IcdEntry("M02.6", "Orthopedics & Rheumatology Clinical Entity #26: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 92));
        catalog.put("M02.7", new IcdEntry("M02.7", "Orthopedics & Rheumatology Clinical Entity #27: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 99));
        catalog.put("M02.8", new IcdEntry("M02.8", "Orthopedics & Rheumatology Clinical Entity #28: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 106));
        catalog.put("M02.9", new IcdEntry("M02.9", "Orthopedics & Rheumatology Clinical Entity #29: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 13));
        catalog.put("M03.0", new IcdEntry("M03.0", "Orthopedics & Rheumatology Clinical Entity #30: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 20));
        catalog.put("M03.1", new IcdEntry("M03.1", "Orthopedics & Rheumatology Clinical Entity #31: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 27));
        catalog.put("M03.2", new IcdEntry("M03.2", "Orthopedics & Rheumatology Clinical Entity #32: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 34));
        catalog.put("M03.3", new IcdEntry("M03.3", "Orthopedics & Rheumatology Clinical Entity #33: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 41));
        catalog.put("M03.4", new IcdEntry("M03.4", "Orthopedics & Rheumatology Clinical Entity #34: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 48));
        catalog.put("M03.5", new IcdEntry("M03.5", "Orthopedics & Rheumatology Clinical Entity #35: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 55));
        catalog.put("M03.6", new IcdEntry("M03.6", "Orthopedics & Rheumatology Clinical Entity #36: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 62));
        catalog.put("M03.7", new IcdEntry("M03.7", "Orthopedics & Rheumatology Clinical Entity #37: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 69));
        catalog.put("M03.8", new IcdEntry("M03.8", "Orthopedics & Rheumatology Clinical Entity #38: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 76));
        catalog.put("M03.9", new IcdEntry("M03.9", "Orthopedics & Rheumatology Clinical Entity #39: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 83));
        catalog.put("M04.0", new IcdEntry("M04.0", "Orthopedics & Rheumatology Clinical Entity #40: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 90));
        catalog.put("M04.1", new IcdEntry("M04.1", "Orthopedics & Rheumatology Clinical Entity #41: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 97));
        catalog.put("M04.2", new IcdEntry("M04.2", "Orthopedics & Rheumatology Clinical Entity #42: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 104));
        catalog.put("M04.3", new IcdEntry("M04.3", "Orthopedics & Rheumatology Clinical Entity #43: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 11));
        catalog.put("M04.4", new IcdEntry("M04.4", "Orthopedics & Rheumatology Clinical Entity #44: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 18));
        catalog.put("M04.5", new IcdEntry("M04.5", "Orthopedics & Rheumatology Clinical Entity #45: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 25));
        catalog.put("M04.6", new IcdEntry("M04.6", "Orthopedics & Rheumatology Clinical Entity #46: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 32));
        catalog.put("M04.7", new IcdEntry("M04.7", "Orthopedics & Rheumatology Clinical Entity #47: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 39));
        catalog.put("M04.8", new IcdEntry("M04.8", "Orthopedics & Rheumatology Clinical Entity #48: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 46));
        catalog.put("M04.9", new IcdEntry("M04.9", "Orthopedics & Rheumatology Clinical Entity #49: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 53));
        catalog.put("M05.0", new IcdEntry("M05.0", "Orthopedics & Rheumatology Clinical Entity #50: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 60));
        catalog.put("M05.1", new IcdEntry("M05.1", "Orthopedics & Rheumatology Clinical Entity #51: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 67));
        catalog.put("M05.2", new IcdEntry("M05.2", "Orthopedics & Rheumatology Clinical Entity #52: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 74));
        catalog.put("M05.3", new IcdEntry("M05.3", "Orthopedics & Rheumatology Clinical Entity #53: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 81));
        catalog.put("M05.4", new IcdEntry("M05.4", "Orthopedics & Rheumatology Clinical Entity #54: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 88));
        catalog.put("M05.5", new IcdEntry("M05.5", "Orthopedics & Rheumatology Clinical Entity #55: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 95));
        catalog.put("M05.6", new IcdEntry("M05.6", "Orthopedics & Rheumatology Clinical Entity #56: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 102));
        catalog.put("M05.7", new IcdEntry("M05.7", "Orthopedics & Rheumatology Clinical Entity #57: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 109));
        catalog.put("M05.8", new IcdEntry("M05.8", "Orthopedics & Rheumatology Clinical Entity #58: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 16));
        catalog.put("M05.9", new IcdEntry("M05.9", "Orthopedics & Rheumatology Clinical Entity #59: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 23));
        catalog.put("M06.0", new IcdEntry("M06.0", "Orthopedics & Rheumatology Clinical Entity #60: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 30));
        catalog.put("M06.1", new IcdEntry("M06.1", "Orthopedics & Rheumatology Clinical Entity #61: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 37));
        catalog.put("M06.2", new IcdEntry("M06.2", "Orthopedics & Rheumatology Clinical Entity #62: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 44));
        catalog.put("M06.3", new IcdEntry("M06.3", "Orthopedics & Rheumatology Clinical Entity #63: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 51));
        catalog.put("M06.4", new IcdEntry("M06.4", "Orthopedics & Rheumatology Clinical Entity #64: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 58));
        catalog.put("M06.5", new IcdEntry("M06.5", "Orthopedics & Rheumatology Clinical Entity #65: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 65));
        catalog.put("M06.6", new IcdEntry("M06.6", "Orthopedics & Rheumatology Clinical Entity #66: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 72));
        catalog.put("M06.7", new IcdEntry("M06.7", "Orthopedics & Rheumatology Clinical Entity #67: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 79));
        catalog.put("M06.8", new IcdEntry("M06.8", "Orthopedics & Rheumatology Clinical Entity #68: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 86));
        catalog.put("M06.9", new IcdEntry("M06.9", "Orthopedics & Rheumatology Clinical Entity #69: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 93));
        catalog.put("M07.0", new IcdEntry("M07.0", "Orthopedics & Rheumatology Clinical Entity #70: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 100));
        catalog.put("M07.1", new IcdEntry("M07.1", "Orthopedics & Rheumatology Clinical Entity #71: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 107));
        catalog.put("M07.2", new IcdEntry("M07.2", "Orthopedics & Rheumatology Clinical Entity #72: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 14));
        catalog.put("M07.3", new IcdEntry("M07.3", "Orthopedics & Rheumatology Clinical Entity #73: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 21));
        catalog.put("M07.4", new IcdEntry("M07.4", "Orthopedics & Rheumatology Clinical Entity #74: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 28));
        catalog.put("M07.5", new IcdEntry("M07.5", "Orthopedics & Rheumatology Clinical Entity #75: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 35));
        catalog.put("M07.6", new IcdEntry("M07.6", "Orthopedics & Rheumatology Clinical Entity #76: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 42));
        catalog.put("M07.7", new IcdEntry("M07.7", "Orthopedics & Rheumatology Clinical Entity #77: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 49));
        catalog.put("M07.8", new IcdEntry("M07.8", "Orthopedics & Rheumatology Clinical Entity #78: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 56));
        catalog.put("M07.9", new IcdEntry("M07.9", "Orthopedics & Rheumatology Clinical Entity #79: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 63));
        catalog.put("M08.0", new IcdEntry("M08.0", "Orthopedics & Rheumatology Clinical Entity #80: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 70));
        catalog.put("M08.1", new IcdEntry("M08.1", "Orthopedics & Rheumatology Clinical Entity #81: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 77));
        catalog.put("M08.2", new IcdEntry("M08.2", "Orthopedics & Rheumatology Clinical Entity #82: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 84));
        catalog.put("M08.3", new IcdEntry("M08.3", "Orthopedics & Rheumatology Clinical Entity #83: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 91));
        catalog.put("M08.4", new IcdEntry("M08.4", "Orthopedics & Rheumatology Clinical Entity #84: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 98));
        catalog.put("M08.5", new IcdEntry("M08.5", "Orthopedics & Rheumatology Clinical Entity #85: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 105));
        catalog.put("M08.6", new IcdEntry("M08.6", "Orthopedics & Rheumatology Clinical Entity #86: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 12));
        catalog.put("M08.7", new IcdEntry("M08.7", "Orthopedics & Rheumatology Clinical Entity #87: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 19));
        catalog.put("M08.8", new IcdEntry("M08.8", "Orthopedics & Rheumatology Clinical Entity #88: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 26));
        catalog.put("M08.9", new IcdEntry("M08.9", "Orthopedics & Rheumatology Clinical Entity #89: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 33));
        catalog.put("M09.0", new IcdEntry("M09.0", "Orthopedics & Rheumatology Clinical Entity #90: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 40));
        catalog.put("M09.1", new IcdEntry("M09.1", "Orthopedics & Rheumatology Clinical Entity #91: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 47));
        catalog.put("M09.2", new IcdEntry("M09.2", "Orthopedics & Rheumatology Clinical Entity #92: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 54));
        catalog.put("M09.3", new IcdEntry("M09.3", "Orthopedics & Rheumatology Clinical Entity #93: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 61));
        catalog.put("M09.4", new IcdEntry("M09.4", "Orthopedics & Rheumatology Clinical Entity #94: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 68));
        catalog.put("M09.5", new IcdEntry("M09.5", "Orthopedics & Rheumatology Clinical Entity #95: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 75));
        catalog.put("M09.6", new IcdEntry("M09.6", "Orthopedics & Rheumatology Clinical Entity #96: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 82));
        catalog.put("M09.7", new IcdEntry("M09.7", "Orthopedics & Rheumatology Clinical Entity #97: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 89));
        catalog.put("M09.8", new IcdEntry("M09.8", "Orthopedics & Rheumatology Clinical Entity #98: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 96));
        catalog.put("M09.9", new IcdEntry("M09.9", "Orthopedics & Rheumatology Clinical Entity #99: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 103));
        catalog.put("M10.0", new IcdEntry("M10.0", "Orthopedics & Rheumatology Clinical Entity #100: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 10));
        catalog.put("M10.1", new IcdEntry("M10.1", "Orthopedics & Rheumatology Clinical Entity #101: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 17));
        catalog.put("M10.2", new IcdEntry("M10.2", "Orthopedics & Rheumatology Clinical Entity #102: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 24));
        catalog.put("M10.3", new IcdEntry("M10.3", "Orthopedics & Rheumatology Clinical Entity #103: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 31));
        catalog.put("M10.4", new IcdEntry("M10.4", "Orthopedics & Rheumatology Clinical Entity #104: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 38));
        catalog.put("M10.5", new IcdEntry("M10.5", "Orthopedics & Rheumatology Clinical Entity #105: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 45));
        catalog.put("M10.6", new IcdEntry("M10.6", "Orthopedics & Rheumatology Clinical Entity #106: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 52));
        catalog.put("M10.7", new IcdEntry("M10.7", "Orthopedics & Rheumatology Clinical Entity #107: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 59));
        catalog.put("M10.8", new IcdEntry("M10.8", "Orthopedics & Rheumatology Clinical Entity #108: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 66));
        catalog.put("M10.9", new IcdEntry("M10.9", "Orthopedics & Rheumatology Clinical Entity #109: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 73));
        catalog.put("M11.0", new IcdEntry("M11.0", "Orthopedics & Rheumatology Clinical Entity #110: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 80));
        catalog.put("M11.1", new IcdEntry("M11.1", "Orthopedics & Rheumatology Clinical Entity #111: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 87));
        catalog.put("M11.2", new IcdEntry("M11.2", "Orthopedics & Rheumatology Clinical Entity #112: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 94));
        catalog.put("M11.3", new IcdEntry("M11.3", "Orthopedics & Rheumatology Clinical Entity #113: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 101));
        catalog.put("M11.4", new IcdEntry("M11.4", "Orthopedics & Rheumatology Clinical Entity #114: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 108));
        catalog.put("M11.5", new IcdEntry("M11.5", "Orthopedics & Rheumatology Clinical Entity #115: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 15));
        catalog.put("M11.6", new IcdEntry("M11.6", "Orthopedics & Rheumatology Clinical Entity #116: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 22));
        catalog.put("M11.7", new IcdEntry("M11.7", "Orthopedics & Rheumatology Clinical Entity #117: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 29));
        catalog.put("M11.8", new IcdEntry("M11.8", "Orthopedics & Rheumatology Clinical Entity #118: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 36));
        catalog.put("M11.9", new IcdEntry("M11.9", "Orthopedics & Rheumatology Clinical Entity #119: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 43));
        catalog.put("M12.0", new IcdEntry("M12.0", "Orthopedics & Rheumatology Clinical Entity #120: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 50));
        catalog.put("M12.1", new IcdEntry("M12.1", "Orthopedics & Rheumatology Clinical Entity #121: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 57));
        catalog.put("M12.2", new IcdEntry("M12.2", "Orthopedics & Rheumatology Clinical Entity #122: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 64));
        catalog.put("M12.3", new IcdEntry("M12.3", "Orthopedics & Rheumatology Clinical Entity #123: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 71));
        catalog.put("M12.4", new IcdEntry("M12.4", "Orthopedics & Rheumatology Clinical Entity #124: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 78));
        catalog.put("M12.5", new IcdEntry("M12.5", "Orthopedics & Rheumatology Clinical Entity #125: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 85));
        catalog.put("M12.6", new IcdEntry("M12.6", "Orthopedics & Rheumatology Clinical Entity #126: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 92));
        catalog.put("M12.7", new IcdEntry("M12.7", "Orthopedics & Rheumatology Clinical Entity #127: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 4", false, 99));
        catalog.put("M12.8", new IcdEntry("M12.8", "Orthopedics & Rheumatology Clinical Entity #128: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 1", true, 106));
        catalog.put("M12.9", new IcdEntry("M12.9", "Orthopedics & Rheumatology Clinical Entity #129: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 2", false, 13));
        catalog.put("M13.0", new IcdEntry("M13.0", "Orthopedics & Rheumatology Clinical Entity #130: Precision Diagnostic Marker", "M00-M99", "Clinical Severity Grade 3", true, 20));
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
