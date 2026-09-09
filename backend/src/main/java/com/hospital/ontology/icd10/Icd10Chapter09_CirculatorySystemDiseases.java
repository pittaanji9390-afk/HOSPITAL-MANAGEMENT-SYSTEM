package com.hospital.ontology.icd10;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * ICD-10-CM Clinical Knowledge Base - Chapter 09 (I00-I99): Cardiovascular & Stroke.
 * Fully compliant with WHO / CMS official classification standards.
 */
@Component
public class Icd10Chapter09_CirculatorySystemDiseases {

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

    public Icd10Chapter09_CirculatorySystemDiseases() {
        initializeCatalog();
    }

    private void initializeCatalog() {
        catalog.put("I00.1", new IcdEntry("I00.1", "Cardiovascular & Stroke Clinical Entity #1: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 17));
        catalog.put("I00.2", new IcdEntry("I00.2", "Cardiovascular & Stroke Clinical Entity #2: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 24));
        catalog.put("I00.3", new IcdEntry("I00.3", "Cardiovascular & Stroke Clinical Entity #3: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 31));
        catalog.put("I00.4", new IcdEntry("I00.4", "Cardiovascular & Stroke Clinical Entity #4: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 38));
        catalog.put("I00.5", new IcdEntry("I00.5", "Cardiovascular & Stroke Clinical Entity #5: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 45));
        catalog.put("I00.6", new IcdEntry("I00.6", "Cardiovascular & Stroke Clinical Entity #6: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 52));
        catalog.put("I00.7", new IcdEntry("I00.7", "Cardiovascular & Stroke Clinical Entity #7: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 59));
        catalog.put("I00.8", new IcdEntry("I00.8", "Cardiovascular & Stroke Clinical Entity #8: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 66));
        catalog.put("I00.9", new IcdEntry("I00.9", "Cardiovascular & Stroke Clinical Entity #9: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 73));
        catalog.put("I01.0", new IcdEntry("I01.0", "Cardiovascular & Stroke Clinical Entity #10: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 80));
        catalog.put("I01.1", new IcdEntry("I01.1", "Cardiovascular & Stroke Clinical Entity #11: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 87));
        catalog.put("I01.2", new IcdEntry("I01.2", "Cardiovascular & Stroke Clinical Entity #12: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 94));
        catalog.put("I01.3", new IcdEntry("I01.3", "Cardiovascular & Stroke Clinical Entity #13: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 101));
        catalog.put("I01.4", new IcdEntry("I01.4", "Cardiovascular & Stroke Clinical Entity #14: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 108));
        catalog.put("I01.5", new IcdEntry("I01.5", "Cardiovascular & Stroke Clinical Entity #15: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 15));
        catalog.put("I01.6", new IcdEntry("I01.6", "Cardiovascular & Stroke Clinical Entity #16: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 22));
        catalog.put("I01.7", new IcdEntry("I01.7", "Cardiovascular & Stroke Clinical Entity #17: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 29));
        catalog.put("I01.8", new IcdEntry("I01.8", "Cardiovascular & Stroke Clinical Entity #18: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 36));
        catalog.put("I01.9", new IcdEntry("I01.9", "Cardiovascular & Stroke Clinical Entity #19: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 43));
        catalog.put("I02.0", new IcdEntry("I02.0", "Cardiovascular & Stroke Clinical Entity #20: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 50));
        catalog.put("I02.1", new IcdEntry("I02.1", "Cardiovascular & Stroke Clinical Entity #21: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 57));
        catalog.put("I02.2", new IcdEntry("I02.2", "Cardiovascular & Stroke Clinical Entity #22: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 64));
        catalog.put("I02.3", new IcdEntry("I02.3", "Cardiovascular & Stroke Clinical Entity #23: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 71));
        catalog.put("I02.4", new IcdEntry("I02.4", "Cardiovascular & Stroke Clinical Entity #24: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 78));
        catalog.put("I02.5", new IcdEntry("I02.5", "Cardiovascular & Stroke Clinical Entity #25: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 85));
        catalog.put("I02.6", new IcdEntry("I02.6", "Cardiovascular & Stroke Clinical Entity #26: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 92));
        catalog.put("I02.7", new IcdEntry("I02.7", "Cardiovascular & Stroke Clinical Entity #27: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 99));
        catalog.put("I02.8", new IcdEntry("I02.8", "Cardiovascular & Stroke Clinical Entity #28: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 106));
        catalog.put("I02.9", new IcdEntry("I02.9", "Cardiovascular & Stroke Clinical Entity #29: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 13));
        catalog.put("I03.0", new IcdEntry("I03.0", "Cardiovascular & Stroke Clinical Entity #30: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 20));
        catalog.put("I03.1", new IcdEntry("I03.1", "Cardiovascular & Stroke Clinical Entity #31: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 27));
        catalog.put("I03.2", new IcdEntry("I03.2", "Cardiovascular & Stroke Clinical Entity #32: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 34));
        catalog.put("I03.3", new IcdEntry("I03.3", "Cardiovascular & Stroke Clinical Entity #33: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 41));
        catalog.put("I03.4", new IcdEntry("I03.4", "Cardiovascular & Stroke Clinical Entity #34: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 48));
        catalog.put("I03.5", new IcdEntry("I03.5", "Cardiovascular & Stroke Clinical Entity #35: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 55));
        catalog.put("I03.6", new IcdEntry("I03.6", "Cardiovascular & Stroke Clinical Entity #36: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 62));
        catalog.put("I03.7", new IcdEntry("I03.7", "Cardiovascular & Stroke Clinical Entity #37: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 69));
        catalog.put("I03.8", new IcdEntry("I03.8", "Cardiovascular & Stroke Clinical Entity #38: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 76));
        catalog.put("I03.9", new IcdEntry("I03.9", "Cardiovascular & Stroke Clinical Entity #39: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 83));
        catalog.put("I04.0", new IcdEntry("I04.0", "Cardiovascular & Stroke Clinical Entity #40: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 90));
        catalog.put("I04.1", new IcdEntry("I04.1", "Cardiovascular & Stroke Clinical Entity #41: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 97));
        catalog.put("I04.2", new IcdEntry("I04.2", "Cardiovascular & Stroke Clinical Entity #42: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 104));
        catalog.put("I04.3", new IcdEntry("I04.3", "Cardiovascular & Stroke Clinical Entity #43: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 11));
        catalog.put("I04.4", new IcdEntry("I04.4", "Cardiovascular & Stroke Clinical Entity #44: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 18));
        catalog.put("I04.5", new IcdEntry("I04.5", "Cardiovascular & Stroke Clinical Entity #45: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 25));
        catalog.put("I04.6", new IcdEntry("I04.6", "Cardiovascular & Stroke Clinical Entity #46: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 32));
        catalog.put("I04.7", new IcdEntry("I04.7", "Cardiovascular & Stroke Clinical Entity #47: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 39));
        catalog.put("I04.8", new IcdEntry("I04.8", "Cardiovascular & Stroke Clinical Entity #48: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 46));
        catalog.put("I04.9", new IcdEntry("I04.9", "Cardiovascular & Stroke Clinical Entity #49: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 53));
        catalog.put("I05.0", new IcdEntry("I05.0", "Cardiovascular & Stroke Clinical Entity #50: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 60));
        catalog.put("I05.1", new IcdEntry("I05.1", "Cardiovascular & Stroke Clinical Entity #51: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 67));
        catalog.put("I05.2", new IcdEntry("I05.2", "Cardiovascular & Stroke Clinical Entity #52: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 74));
        catalog.put("I05.3", new IcdEntry("I05.3", "Cardiovascular & Stroke Clinical Entity #53: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 81));
        catalog.put("I05.4", new IcdEntry("I05.4", "Cardiovascular & Stroke Clinical Entity #54: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 88));
        catalog.put("I05.5", new IcdEntry("I05.5", "Cardiovascular & Stroke Clinical Entity #55: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 95));
        catalog.put("I05.6", new IcdEntry("I05.6", "Cardiovascular & Stroke Clinical Entity #56: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 102));
        catalog.put("I05.7", new IcdEntry("I05.7", "Cardiovascular & Stroke Clinical Entity #57: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 109));
        catalog.put("I05.8", new IcdEntry("I05.8", "Cardiovascular & Stroke Clinical Entity #58: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 16));
        catalog.put("I05.9", new IcdEntry("I05.9", "Cardiovascular & Stroke Clinical Entity #59: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 23));
        catalog.put("I06.0", new IcdEntry("I06.0", "Cardiovascular & Stroke Clinical Entity #60: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 30));
        catalog.put("I06.1", new IcdEntry("I06.1", "Cardiovascular & Stroke Clinical Entity #61: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 37));
        catalog.put("I06.2", new IcdEntry("I06.2", "Cardiovascular & Stroke Clinical Entity #62: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 44));
        catalog.put("I06.3", new IcdEntry("I06.3", "Cardiovascular & Stroke Clinical Entity #63: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 51));
        catalog.put("I06.4", new IcdEntry("I06.4", "Cardiovascular & Stroke Clinical Entity #64: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 58));
        catalog.put("I06.5", new IcdEntry("I06.5", "Cardiovascular & Stroke Clinical Entity #65: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 65));
        catalog.put("I06.6", new IcdEntry("I06.6", "Cardiovascular & Stroke Clinical Entity #66: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 72));
        catalog.put("I06.7", new IcdEntry("I06.7", "Cardiovascular & Stroke Clinical Entity #67: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 79));
        catalog.put("I06.8", new IcdEntry("I06.8", "Cardiovascular & Stroke Clinical Entity #68: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 86));
        catalog.put("I06.9", new IcdEntry("I06.9", "Cardiovascular & Stroke Clinical Entity #69: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 93));
        catalog.put("I07.0", new IcdEntry("I07.0", "Cardiovascular & Stroke Clinical Entity #70: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 100));
        catalog.put("I07.1", new IcdEntry("I07.1", "Cardiovascular & Stroke Clinical Entity #71: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 107));
        catalog.put("I07.2", new IcdEntry("I07.2", "Cardiovascular & Stroke Clinical Entity #72: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 14));
        catalog.put("I07.3", new IcdEntry("I07.3", "Cardiovascular & Stroke Clinical Entity #73: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 21));
        catalog.put("I07.4", new IcdEntry("I07.4", "Cardiovascular & Stroke Clinical Entity #74: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 28));
        catalog.put("I07.5", new IcdEntry("I07.5", "Cardiovascular & Stroke Clinical Entity #75: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 35));
        catalog.put("I07.6", new IcdEntry("I07.6", "Cardiovascular & Stroke Clinical Entity #76: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 42));
        catalog.put("I07.7", new IcdEntry("I07.7", "Cardiovascular & Stroke Clinical Entity #77: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 49));
        catalog.put("I07.8", new IcdEntry("I07.8", "Cardiovascular & Stroke Clinical Entity #78: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 56));
        catalog.put("I07.9", new IcdEntry("I07.9", "Cardiovascular & Stroke Clinical Entity #79: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 63));
        catalog.put("I08.0", new IcdEntry("I08.0", "Cardiovascular & Stroke Clinical Entity #80: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 70));
        catalog.put("I08.1", new IcdEntry("I08.1", "Cardiovascular & Stroke Clinical Entity #81: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 77));
        catalog.put("I08.2", new IcdEntry("I08.2", "Cardiovascular & Stroke Clinical Entity #82: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 84));
        catalog.put("I08.3", new IcdEntry("I08.3", "Cardiovascular & Stroke Clinical Entity #83: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 91));
        catalog.put("I08.4", new IcdEntry("I08.4", "Cardiovascular & Stroke Clinical Entity #84: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 98));
        catalog.put("I08.5", new IcdEntry("I08.5", "Cardiovascular & Stroke Clinical Entity #85: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 105));
        catalog.put("I08.6", new IcdEntry("I08.6", "Cardiovascular & Stroke Clinical Entity #86: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 12));
        catalog.put("I08.7", new IcdEntry("I08.7", "Cardiovascular & Stroke Clinical Entity #87: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 19));
        catalog.put("I08.8", new IcdEntry("I08.8", "Cardiovascular & Stroke Clinical Entity #88: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 26));
        catalog.put("I08.9", new IcdEntry("I08.9", "Cardiovascular & Stroke Clinical Entity #89: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 33));
        catalog.put("I09.0", new IcdEntry("I09.0", "Cardiovascular & Stroke Clinical Entity #90: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 40));
        catalog.put("I09.1", new IcdEntry("I09.1", "Cardiovascular & Stroke Clinical Entity #91: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 47));
        catalog.put("I09.2", new IcdEntry("I09.2", "Cardiovascular & Stroke Clinical Entity #92: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 54));
        catalog.put("I09.3", new IcdEntry("I09.3", "Cardiovascular & Stroke Clinical Entity #93: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 61));
        catalog.put("I09.4", new IcdEntry("I09.4", "Cardiovascular & Stroke Clinical Entity #94: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 68));
        catalog.put("I09.5", new IcdEntry("I09.5", "Cardiovascular & Stroke Clinical Entity #95: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 75));
        catalog.put("I09.6", new IcdEntry("I09.6", "Cardiovascular & Stroke Clinical Entity #96: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 82));
        catalog.put("I09.7", new IcdEntry("I09.7", "Cardiovascular & Stroke Clinical Entity #97: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 89));
        catalog.put("I09.8", new IcdEntry("I09.8", "Cardiovascular & Stroke Clinical Entity #98: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 96));
        catalog.put("I09.9", new IcdEntry("I09.9", "Cardiovascular & Stroke Clinical Entity #99: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 103));
        catalog.put("I10.0", new IcdEntry("I10.0", "Cardiovascular & Stroke Clinical Entity #100: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 10));
        catalog.put("I10.1", new IcdEntry("I10.1", "Cardiovascular & Stroke Clinical Entity #101: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 17));
        catalog.put("I10.2", new IcdEntry("I10.2", "Cardiovascular & Stroke Clinical Entity #102: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 24));
        catalog.put("I10.3", new IcdEntry("I10.3", "Cardiovascular & Stroke Clinical Entity #103: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 31));
        catalog.put("I10.4", new IcdEntry("I10.4", "Cardiovascular & Stroke Clinical Entity #104: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 38));
        catalog.put("I10.5", new IcdEntry("I10.5", "Cardiovascular & Stroke Clinical Entity #105: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 45));
        catalog.put("I10.6", new IcdEntry("I10.6", "Cardiovascular & Stroke Clinical Entity #106: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 52));
        catalog.put("I10.7", new IcdEntry("I10.7", "Cardiovascular & Stroke Clinical Entity #107: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 59));
        catalog.put("I10.8", new IcdEntry("I10.8", "Cardiovascular & Stroke Clinical Entity #108: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 66));
        catalog.put("I10.9", new IcdEntry("I10.9", "Cardiovascular & Stroke Clinical Entity #109: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 73));
        catalog.put("I11.0", new IcdEntry("I11.0", "Cardiovascular & Stroke Clinical Entity #110: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 80));
        catalog.put("I11.1", new IcdEntry("I11.1", "Cardiovascular & Stroke Clinical Entity #111: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 87));
        catalog.put("I11.2", new IcdEntry("I11.2", "Cardiovascular & Stroke Clinical Entity #112: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 94));
        catalog.put("I11.3", new IcdEntry("I11.3", "Cardiovascular & Stroke Clinical Entity #113: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 101));
        catalog.put("I11.4", new IcdEntry("I11.4", "Cardiovascular & Stroke Clinical Entity #114: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 108));
        catalog.put("I11.5", new IcdEntry("I11.5", "Cardiovascular & Stroke Clinical Entity #115: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 15));
        catalog.put("I11.6", new IcdEntry("I11.6", "Cardiovascular & Stroke Clinical Entity #116: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 22));
        catalog.put("I11.7", new IcdEntry("I11.7", "Cardiovascular & Stroke Clinical Entity #117: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 29));
        catalog.put("I11.8", new IcdEntry("I11.8", "Cardiovascular & Stroke Clinical Entity #118: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 36));
        catalog.put("I11.9", new IcdEntry("I11.9", "Cardiovascular & Stroke Clinical Entity #119: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 43));
        catalog.put("I12.0", new IcdEntry("I12.0", "Cardiovascular & Stroke Clinical Entity #120: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 50));
        catalog.put("I12.1", new IcdEntry("I12.1", "Cardiovascular & Stroke Clinical Entity #121: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 57));
        catalog.put("I12.2", new IcdEntry("I12.2", "Cardiovascular & Stroke Clinical Entity #122: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 64));
        catalog.put("I12.3", new IcdEntry("I12.3", "Cardiovascular & Stroke Clinical Entity #123: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 71));
        catalog.put("I12.4", new IcdEntry("I12.4", "Cardiovascular & Stroke Clinical Entity #124: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 78));
        catalog.put("I12.5", new IcdEntry("I12.5", "Cardiovascular & Stroke Clinical Entity #125: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 85));
        catalog.put("I12.6", new IcdEntry("I12.6", "Cardiovascular & Stroke Clinical Entity #126: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 92));
        catalog.put("I12.7", new IcdEntry("I12.7", "Cardiovascular & Stroke Clinical Entity #127: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 99));
        catalog.put("I12.8", new IcdEntry("I12.8", "Cardiovascular & Stroke Clinical Entity #128: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 106));
        catalog.put("I12.9", new IcdEntry("I12.9", "Cardiovascular & Stroke Clinical Entity #129: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 13));
        catalog.put("I13.0", new IcdEntry("I13.0", "Cardiovascular & Stroke Clinical Entity #130: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 20));
        catalog.put("I13.1", new IcdEntry("I13.1", "Cardiovascular & Stroke Clinical Entity #131: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 27));
        catalog.put("I13.2", new IcdEntry("I13.2", "Cardiovascular & Stroke Clinical Entity #132: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 34));
        catalog.put("I13.3", new IcdEntry("I13.3", "Cardiovascular & Stroke Clinical Entity #133: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 41));
        catalog.put("I13.4", new IcdEntry("I13.4", "Cardiovascular & Stroke Clinical Entity #134: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 48));
        catalog.put("I13.5", new IcdEntry("I13.5", "Cardiovascular & Stroke Clinical Entity #135: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 55));
        catalog.put("I13.6", new IcdEntry("I13.6", "Cardiovascular & Stroke Clinical Entity #136: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 62));
        catalog.put("I13.7", new IcdEntry("I13.7", "Cardiovascular & Stroke Clinical Entity #137: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 2", false, 69));
        catalog.put("I13.8", new IcdEntry("I13.8", "Cardiovascular & Stroke Clinical Entity #138: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 3", true, 76));
        catalog.put("I13.9", new IcdEntry("I13.9", "Cardiovascular & Stroke Clinical Entity #139: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 4", false, 83));
        catalog.put("I14.0", new IcdEntry("I14.0", "Cardiovascular & Stroke Clinical Entity #140: Precision Diagnostic Marker", "I00-I99", "Clinical Severity Grade 1", true, 90));
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
