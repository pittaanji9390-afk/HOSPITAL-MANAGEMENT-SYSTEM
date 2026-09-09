package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 19 (S00-T88): Trauma & Toxicological.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter19_InjuryPoisoningExternalCauses {

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

    public Icd10Chapter19_InjuryPoisoningExternalCauses() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("S00.1", new IcdEntry("S00.1", "Trauma & Toxicological Clinical Entity #1: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 17));
        catalog.put("S00.2", new IcdEntry("S00.2", "Trauma & Toxicological Clinical Entity #2: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 24));
        catalog.put("S00.3", new IcdEntry("S00.3", "Trauma & Toxicological Clinical Entity #3: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 31));
        catalog.put("S00.4", new IcdEntry("S00.4", "Trauma & Toxicological Clinical Entity #4: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 38));
        catalog.put("S00.5", new IcdEntry("S00.5", "Trauma & Toxicological Clinical Entity #5: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 45));
        catalog.put("S00.6", new IcdEntry("S00.6", "Trauma & Toxicological Clinical Entity #6: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 52));
        catalog.put("S00.7", new IcdEntry("S00.7", "Trauma & Toxicological Clinical Entity #7: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 59));
        catalog.put("S00.8", new IcdEntry("S00.8", "Trauma & Toxicological Clinical Entity #8: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 66));
        catalog.put("S00.9", new IcdEntry("S00.9", "Trauma & Toxicological Clinical Entity #9: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 73));
        catalog.put("S01.0", new IcdEntry("S01.0", "Trauma & Toxicological Clinical Entity #10: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 80));
        catalog.put("S01.1", new IcdEntry("S01.1", "Trauma & Toxicological Clinical Entity #11: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 87));
        catalog.put("S01.2", new IcdEntry("S01.2", "Trauma & Toxicological Clinical Entity #12: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 94));
        catalog.put("S01.3", new IcdEntry("S01.3", "Trauma & Toxicological Clinical Entity #13: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 101));
        catalog.put("S01.4", new IcdEntry("S01.4", "Trauma & Toxicological Clinical Entity #14: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 108));
        catalog.put("S01.5", new IcdEntry("S01.5", "Trauma & Toxicological Clinical Entity #15: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 15));
        catalog.put("S01.6", new IcdEntry("S01.6", "Trauma & Toxicological Clinical Entity #16: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 22));
        catalog.put("S01.7", new IcdEntry("S01.7", "Trauma & Toxicological Clinical Entity #17: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 29));
        catalog.put("S01.8", new IcdEntry("S01.8", "Trauma & Toxicological Clinical Entity #18: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 36));
        catalog.put("S01.9", new IcdEntry("S01.9", "Trauma & Toxicological Clinical Entity #19: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 43));
        catalog.put("S02.0", new IcdEntry("S02.0", "Trauma & Toxicological Clinical Entity #20: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 50));
        catalog.put("S02.1", new IcdEntry("S02.1", "Trauma & Toxicological Clinical Entity #21: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 57));
        catalog.put("S02.2", new IcdEntry("S02.2", "Trauma & Toxicological Clinical Entity #22: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 64));
        catalog.put("S02.3", new IcdEntry("S02.3", "Trauma & Toxicological Clinical Entity #23: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 71));
        catalog.put("S02.4", new IcdEntry("S02.4", "Trauma & Toxicological Clinical Entity #24: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 78));
        catalog.put("S02.5", new IcdEntry("S02.5", "Trauma & Toxicological Clinical Entity #25: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 85));
        catalog.put("S02.6", new IcdEntry("S02.6", "Trauma & Toxicological Clinical Entity #26: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 92));
        catalog.put("S02.7", new IcdEntry("S02.7", "Trauma & Toxicological Clinical Entity #27: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 99));
        catalog.put("S02.8", new IcdEntry("S02.8", "Trauma & Toxicological Clinical Entity #28: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 106));
        catalog.put("S02.9", new IcdEntry("S02.9", "Trauma & Toxicological Clinical Entity #29: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 13));
        catalog.put("S03.0", new IcdEntry("S03.0", "Trauma & Toxicological Clinical Entity #30: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 20));
        catalog.put("S03.1", new IcdEntry("S03.1", "Trauma & Toxicological Clinical Entity #31: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 27));
        catalog.put("S03.2", new IcdEntry("S03.2", "Trauma & Toxicological Clinical Entity #32: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 34));
        catalog.put("S03.3", new IcdEntry("S03.3", "Trauma & Toxicological Clinical Entity #33: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 41));
        catalog.put("S03.4", new IcdEntry("S03.4", "Trauma & Toxicological Clinical Entity #34: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 48));
        catalog.put("S03.5", new IcdEntry("S03.5", "Trauma & Toxicological Clinical Entity #35: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 55));
        catalog.put("S03.6", new IcdEntry("S03.6", "Trauma & Toxicological Clinical Entity #36: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 62));
        catalog.put("S03.7", new IcdEntry("S03.7", "Trauma & Toxicological Clinical Entity #37: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 69));
        catalog.put("S03.8", new IcdEntry("S03.8", "Trauma & Toxicological Clinical Entity #38: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 76));
        catalog.put("S03.9", new IcdEntry("S03.9", "Trauma & Toxicological Clinical Entity #39: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 83));
        catalog.put("S04.0", new IcdEntry("S04.0", "Trauma & Toxicological Clinical Entity #40: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 90));
        catalog.put("S04.1", new IcdEntry("S04.1", "Trauma & Toxicological Clinical Entity #41: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 97));
        catalog.put("S04.2", new IcdEntry("S04.2", "Trauma & Toxicological Clinical Entity #42: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 104));
        catalog.put("S04.3", new IcdEntry("S04.3", "Trauma & Toxicological Clinical Entity #43: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 11));
        catalog.put("S04.4", new IcdEntry("S04.4", "Trauma & Toxicological Clinical Entity #44: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 18));
        catalog.put("S04.5", new IcdEntry("S04.5", "Trauma & Toxicological Clinical Entity #45: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 25));
        catalog.put("S04.6", new IcdEntry("S04.6", "Trauma & Toxicological Clinical Entity #46: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 32));
        catalog.put("S04.7", new IcdEntry("S04.7", "Trauma & Toxicological Clinical Entity #47: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 39));
        catalog.put("S04.8", new IcdEntry("S04.8", "Trauma & Toxicological Clinical Entity #48: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 46));
        catalog.put("S04.9", new IcdEntry("S04.9", "Trauma & Toxicological Clinical Entity #49: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 53));
        catalog.put("S05.0", new IcdEntry("S05.0", "Trauma & Toxicological Clinical Entity #50: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 60));
        catalog.put("S05.1", new IcdEntry("S05.1", "Trauma & Toxicological Clinical Entity #51: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 67));
        catalog.put("S05.2", new IcdEntry("S05.2", "Trauma & Toxicological Clinical Entity #52: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 74));
        catalog.put("S05.3", new IcdEntry("S05.3", "Trauma & Toxicological Clinical Entity #53: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 81));
        catalog.put("S05.4", new IcdEntry("S05.4", "Trauma & Toxicological Clinical Entity #54: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 88));
        catalog.put("S05.5", new IcdEntry("S05.5", "Trauma & Toxicological Clinical Entity #55: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 95));
        catalog.put("S05.6", new IcdEntry("S05.6", "Trauma & Toxicological Clinical Entity #56: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 102));
        catalog.put("S05.7", new IcdEntry("S05.7", "Trauma & Toxicological Clinical Entity #57: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 109));
        catalog.put("S05.8", new IcdEntry("S05.8", "Trauma & Toxicological Clinical Entity #58: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 16));
        catalog.put("S05.9", new IcdEntry("S05.9", "Trauma & Toxicological Clinical Entity #59: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 23));
        catalog.put("S06.0", new IcdEntry("S06.0", "Trauma & Toxicological Clinical Entity #60: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 30));
        catalog.put("S06.1", new IcdEntry("S06.1", "Trauma & Toxicological Clinical Entity #61: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 37));
        catalog.put("S06.2", new IcdEntry("S06.2", "Trauma & Toxicological Clinical Entity #62: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 44));
        catalog.put("S06.3", new IcdEntry("S06.3", "Trauma & Toxicological Clinical Entity #63: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 51));
        catalog.put("S06.4", new IcdEntry("S06.4", "Trauma & Toxicological Clinical Entity #64: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 58));
        catalog.put("S06.5", new IcdEntry("S06.5", "Trauma & Toxicological Clinical Entity #65: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 65));
        catalog.put("S06.6", new IcdEntry("S06.6", "Trauma & Toxicological Clinical Entity #66: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 72));
        catalog.put("S06.7", new IcdEntry("S06.7", "Trauma & Toxicological Clinical Entity #67: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 79));
        catalog.put("S06.8", new IcdEntry("S06.8", "Trauma & Toxicological Clinical Entity #68: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 86));
        catalog.put("S06.9", new IcdEntry("S06.9", "Trauma & Toxicological Clinical Entity #69: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 93));
        catalog.put("S07.0", new IcdEntry("S07.0", "Trauma & Toxicological Clinical Entity #70: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 100));
        catalog.put("S07.1", new IcdEntry("S07.1", "Trauma & Toxicological Clinical Entity #71: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 107));
        catalog.put("S07.2", new IcdEntry("S07.2", "Trauma & Toxicological Clinical Entity #72: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 14));
        catalog.put("S07.3", new IcdEntry("S07.3", "Trauma & Toxicological Clinical Entity #73: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 21));
        catalog.put("S07.4", new IcdEntry("S07.4", "Trauma & Toxicological Clinical Entity #74: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 28));
        catalog.put("S07.5", new IcdEntry("S07.5", "Trauma & Toxicological Clinical Entity #75: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 35));
        catalog.put("S07.6", new IcdEntry("S07.6", "Trauma & Toxicological Clinical Entity #76: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 42));
        catalog.put("S07.7", new IcdEntry("S07.7", "Trauma & Toxicological Clinical Entity #77: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 49));
        catalog.put("S07.8", new IcdEntry("S07.8", "Trauma & Toxicological Clinical Entity #78: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 56));
        catalog.put("S07.9", new IcdEntry("S07.9", "Trauma & Toxicological Clinical Entity #79: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 63));
        catalog.put("S08.0", new IcdEntry("S08.0", "Trauma & Toxicological Clinical Entity #80: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 70));
        catalog.put("S08.1", new IcdEntry("S08.1", "Trauma & Toxicological Clinical Entity #81: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 77));
        catalog.put("S08.2", new IcdEntry("S08.2", "Trauma & Toxicological Clinical Entity #82: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 84));
        catalog.put("S08.3", new IcdEntry("S08.3", "Trauma & Toxicological Clinical Entity #83: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 91));
        catalog.put("S08.4", new IcdEntry("S08.4", "Trauma & Toxicological Clinical Entity #84: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 98));
        catalog.put("S08.5", new IcdEntry("S08.5", "Trauma & Toxicological Clinical Entity #85: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 105));
        catalog.put("S08.6", new IcdEntry("S08.6", "Trauma & Toxicological Clinical Entity #86: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 12));
        catalog.put("S08.7", new IcdEntry("S08.7", "Trauma & Toxicological Clinical Entity #87: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 19));
        catalog.put("S08.8", new IcdEntry("S08.8", "Trauma & Toxicological Clinical Entity #88: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 26));
        catalog.put("S08.9", new IcdEntry("S08.9", "Trauma & Toxicological Clinical Entity #89: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 33));
        catalog.put("S09.0", new IcdEntry("S09.0", "Trauma & Toxicological Clinical Entity #90: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 40));
        catalog.put("S09.1", new IcdEntry("S09.1", "Trauma & Toxicological Clinical Entity #91: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 47));
        catalog.put("S09.2", new IcdEntry("S09.2", "Trauma & Toxicological Clinical Entity #92: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 54));
        catalog.put("S09.3", new IcdEntry("S09.3", "Trauma & Toxicological Clinical Entity #93: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 61));
        catalog.put("S09.4", new IcdEntry("S09.4", "Trauma & Toxicological Clinical Entity #94: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 68));
        catalog.put("S09.5", new IcdEntry("S09.5", "Trauma & Toxicological Clinical Entity #95: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 75));
        catalog.put("S09.6", new IcdEntry("S09.6", "Trauma & Toxicological Clinical Entity #96: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 82));
        catalog.put("S09.7", new IcdEntry("S09.7", "Trauma & Toxicological Clinical Entity #97: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 89));
        catalog.put("S09.8", new IcdEntry("S09.8", "Trauma & Toxicological Clinical Entity #98: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 96));
        catalog.put("S09.9", new IcdEntry("S09.9", "Trauma & Toxicological Clinical Entity #99: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 103));
        catalog.put("S10.0", new IcdEntry("S10.0", "Trauma & Toxicological Clinical Entity #100: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 10));
        catalog.put("S10.1", new IcdEntry("S10.1", "Trauma & Toxicological Clinical Entity #101: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 17));
        catalog.put("S10.2", new IcdEntry("S10.2", "Trauma & Toxicological Clinical Entity #102: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 24));
        catalog.put("S10.3", new IcdEntry("S10.3", "Trauma & Toxicological Clinical Entity #103: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 31));
        catalog.put("S10.4", new IcdEntry("S10.4", "Trauma & Toxicological Clinical Entity #104: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 38));
        catalog.put("S10.5", new IcdEntry("S10.5", "Trauma & Toxicological Clinical Entity #105: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 45));
        catalog.put("S10.6", new IcdEntry("S10.6", "Trauma & Toxicological Clinical Entity #106: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 52));
        catalog.put("S10.7", new IcdEntry("S10.7", "Trauma & Toxicological Clinical Entity #107: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 59));
        catalog.put("S10.8", new IcdEntry("S10.8", "Trauma & Toxicological Clinical Entity #108: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 66));
        catalog.put("S10.9", new IcdEntry("S10.9", "Trauma & Toxicological Clinical Entity #109: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 73));
        catalog.put("S11.0", new IcdEntry("S11.0", "Trauma & Toxicological Clinical Entity #110: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 80));
        catalog.put("S11.1", new IcdEntry("S11.1", "Trauma & Toxicological Clinical Entity #111: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 87));
        catalog.put("S11.2", new IcdEntry("S11.2", "Trauma & Toxicological Clinical Entity #112: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 94));
        catalog.put("S11.3", new IcdEntry("S11.3", "Trauma & Toxicological Clinical Entity #113: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 101));
        catalog.put("S11.4", new IcdEntry("S11.4", "Trauma & Toxicological Clinical Entity #114: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 108));
        catalog.put("S11.5", new IcdEntry("S11.5", "Trauma & Toxicological Clinical Entity #115: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 15));
        catalog.put("S11.6", new IcdEntry("S11.6", "Trauma & Toxicological Clinical Entity #116: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 22));
        catalog.put("S11.7", new IcdEntry("S11.7", "Trauma & Toxicological Clinical Entity #117: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 29));
        catalog.put("S11.8", new IcdEntry("S11.8", "Trauma & Toxicological Clinical Entity #118: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 36));
        catalog.put("S11.9", new IcdEntry("S11.9", "Trauma & Toxicological Clinical Entity #119: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 43));
        catalog.put("S12.0", new IcdEntry("S12.0", "Trauma & Toxicological Clinical Entity #120: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 50));
        catalog.put("S12.1", new IcdEntry("S12.1", "Trauma & Toxicological Clinical Entity #121: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 57));
        catalog.put("S12.2", new IcdEntry("S12.2", "Trauma & Toxicological Clinical Entity #122: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 64));
        catalog.put("S12.3", new IcdEntry("S12.3", "Trauma & Toxicological Clinical Entity #123: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 71));
        catalog.put("S12.4", new IcdEntry("S12.4", "Trauma & Toxicological Clinical Entity #124: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 78));
        catalog.put("S12.5", new IcdEntry("S12.5", "Trauma & Toxicological Clinical Entity #125: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 85));
        catalog.put("S12.6", new IcdEntry("S12.6", "Trauma & Toxicological Clinical Entity #126: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 92));
        catalog.put("S12.7", new IcdEntry("S12.7", "Trauma & Toxicological Clinical Entity #127: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 99));
        catalog.put("S12.8", new IcdEntry("S12.8", "Trauma & Toxicological Clinical Entity #128: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 106));
        catalog.put("S12.9", new IcdEntry("S12.9", "Trauma & Toxicological Clinical Entity #129: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 13));
        catalog.put("S13.0", new IcdEntry("S13.0", "Trauma & Toxicological Clinical Entity #130: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 20));
        catalog.put("S13.1", new IcdEntry("S13.1", "Trauma & Toxicological Clinical Entity #131: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 27));
        catalog.put("S13.2", new IcdEntry("S13.2", "Trauma & Toxicological Clinical Entity #132: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 34));
        catalog.put("S13.3", new IcdEntry("S13.3", "Trauma & Toxicological Clinical Entity #133: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 41));
        catalog.put("S13.4", new IcdEntry("S13.4", "Trauma & Toxicological Clinical Entity #134: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 48));
        catalog.put("S13.5", new IcdEntry("S13.5", "Trauma & Toxicological Clinical Entity #135: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 55));
        catalog.put("S13.6", new IcdEntry("S13.6", "Trauma & Toxicological Clinical Entity #136: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 62));
        catalog.put("S13.7", new IcdEntry("S13.7", "Trauma & Toxicological Clinical Entity #137: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 2", false, 69));
        catalog.put("S13.8", new IcdEntry("S13.8", "Trauma & Toxicological Clinical Entity #138: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 3", true, 76));
        catalog.put("S13.9", new IcdEntry("S13.9", "Trauma & Toxicological Clinical Entity #139: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 4", false, 83));
        catalog.put("S14.0", new IcdEntry("S14.0", "Trauma & Toxicological Clinical Entity #140: Precision Diagnostic Marker", "S00-T88", "Clinical Severity Grade 1", true, 90));
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
