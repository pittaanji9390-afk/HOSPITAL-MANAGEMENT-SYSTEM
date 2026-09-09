package com.hospital.ontology.anesthesia;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class TraumaAndEmergencyAnesthesiaRvuCatalog {

    @Data
    @AllArgsConstructor
    public static class AnesthesiaUnitCode {
        private String code;
        private String procedureName;
        private double baseUnits;
        private int averageTimeMinutes;
        private String techniqueDirective;
    }

    private final Map<String, AnesthesiaUnitCode> baseUnits = new LinkedHashMap<>();

    public TraumaAndEmergencyAnesthesiaRvuCatalog() {
        initializeBaseUnits();
    }

    private void initializeBaseUnits() {
        baseUnits.put("ANES-TRAU-001", new AnesthesiaUnitCode("ANES-TRAU-001", "TraumaAndEmergencyAnesthesiaRvu Case Type #1", 4.5, 75, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-002", new AnesthesiaUnitCode("ANES-TRAU-002", "TraumaAndEmergencyAnesthesiaRvu Case Type #2", 5.0, 90, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-003", new AnesthesiaUnitCode("ANES-TRAU-003", "TraumaAndEmergencyAnesthesiaRvu Case Type #3", 5.5, 105, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-004", new AnesthesiaUnitCode("ANES-TRAU-004", "TraumaAndEmergencyAnesthesiaRvu Case Type #4", 6.0, 120, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-005", new AnesthesiaUnitCode("ANES-TRAU-005", "TraumaAndEmergencyAnesthesiaRvu Case Type #5", 6.5, 135, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-006", new AnesthesiaUnitCode("ANES-TRAU-006", "TraumaAndEmergencyAnesthesiaRvu Case Type #6", 7.0, 150, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-007", new AnesthesiaUnitCode("ANES-TRAU-007", "TraumaAndEmergencyAnesthesiaRvu Case Type #7", 7.5, 165, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-008", new AnesthesiaUnitCode("ANES-TRAU-008", "TraumaAndEmergencyAnesthesiaRvu Case Type #8", 8.0, 180, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-009", new AnesthesiaUnitCode("ANES-TRAU-009", "TraumaAndEmergencyAnesthesiaRvu Case Type #9", 8.5, 195, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-010", new AnesthesiaUnitCode("ANES-TRAU-010", "TraumaAndEmergencyAnesthesiaRvu Case Type #10", 9.0, 210, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-011", new AnesthesiaUnitCode("ANES-TRAU-011", "TraumaAndEmergencyAnesthesiaRvu Case Type #11", 9.5, 225, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-012", new AnesthesiaUnitCode("ANES-TRAU-012", "TraumaAndEmergencyAnesthesiaRvu Case Type #12", 10.0, 240, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-013", new AnesthesiaUnitCode("ANES-TRAU-013", "TraumaAndEmergencyAnesthesiaRvu Case Type #13", 10.5, 255, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-014", new AnesthesiaUnitCode("ANES-TRAU-014", "TraumaAndEmergencyAnesthesiaRvu Case Type #14", 11.0, 270, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-015", new AnesthesiaUnitCode("ANES-TRAU-015", "TraumaAndEmergencyAnesthesiaRvu Case Type #15", 11.5, 285, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-016", new AnesthesiaUnitCode("ANES-TRAU-016", "TraumaAndEmergencyAnesthesiaRvu Case Type #16", 12.0, 300, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-017", new AnesthesiaUnitCode("ANES-TRAU-017", "TraumaAndEmergencyAnesthesiaRvu Case Type #17", 12.5, 315, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-018", new AnesthesiaUnitCode("ANES-TRAU-018", "TraumaAndEmergencyAnesthesiaRvu Case Type #18", 13.0, 330, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-019", new AnesthesiaUnitCode("ANES-TRAU-019", "TraumaAndEmergencyAnesthesiaRvu Case Type #19", 13.5, 345, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-020", new AnesthesiaUnitCode("ANES-TRAU-020", "TraumaAndEmergencyAnesthesiaRvu Case Type #20", 14.0, 360, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-021", new AnesthesiaUnitCode("ANES-TRAU-021", "TraumaAndEmergencyAnesthesiaRvu Case Type #21", 14.5, 375, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-022", new AnesthesiaUnitCode("ANES-TRAU-022", "TraumaAndEmergencyAnesthesiaRvu Case Type #22", 15.0, 390, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-023", new AnesthesiaUnitCode("ANES-TRAU-023", "TraumaAndEmergencyAnesthesiaRvu Case Type #23", 15.5, 405, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-024", new AnesthesiaUnitCode("ANES-TRAU-024", "TraumaAndEmergencyAnesthesiaRvu Case Type #24", 16.0, 420, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-025", new AnesthesiaUnitCode("ANES-TRAU-025", "TraumaAndEmergencyAnesthesiaRvu Case Type #25", 16.5, 435, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-026", new AnesthesiaUnitCode("ANES-TRAU-026", "TraumaAndEmergencyAnesthesiaRvu Case Type #26", 17.0, 450, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-027", new AnesthesiaUnitCode("ANES-TRAU-027", "TraumaAndEmergencyAnesthesiaRvu Case Type #27", 17.5, 465, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-028", new AnesthesiaUnitCode("ANES-TRAU-028", "TraumaAndEmergencyAnesthesiaRvu Case Type #28", 18.0, 480, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-029", new AnesthesiaUnitCode("ANES-TRAU-029", "TraumaAndEmergencyAnesthesiaRvu Case Type #29", 18.5, 495, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-030", new AnesthesiaUnitCode("ANES-TRAU-030", "TraumaAndEmergencyAnesthesiaRvu Case Type #30", 19.0, 510, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-031", new AnesthesiaUnitCode("ANES-TRAU-031", "TraumaAndEmergencyAnesthesiaRvu Case Type #31", 19.5, 525, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-032", new AnesthesiaUnitCode("ANES-TRAU-032", "TraumaAndEmergencyAnesthesiaRvu Case Type #32", 20.0, 540, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-033", new AnesthesiaUnitCode("ANES-TRAU-033", "TraumaAndEmergencyAnesthesiaRvu Case Type #33", 20.5, 555, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-034", new AnesthesiaUnitCode("ANES-TRAU-034", "TraumaAndEmergencyAnesthesiaRvu Case Type #34", 21.0, 570, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-035", new AnesthesiaUnitCode("ANES-TRAU-035", "TraumaAndEmergencyAnesthesiaRvu Case Type #35", 21.5, 585, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-036", new AnesthesiaUnitCode("ANES-TRAU-036", "TraumaAndEmergencyAnesthesiaRvu Case Type #36", 22.0, 600, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-037", new AnesthesiaUnitCode("ANES-TRAU-037", "TraumaAndEmergencyAnesthesiaRvu Case Type #37", 22.5, 615, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-038", new AnesthesiaUnitCode("ANES-TRAU-038", "TraumaAndEmergencyAnesthesiaRvu Case Type #38", 23.0, 630, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-039", new AnesthesiaUnitCode("ANES-TRAU-039", "TraumaAndEmergencyAnesthesiaRvu Case Type #39", 23.5, 645, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-040", new AnesthesiaUnitCode("ANES-TRAU-040", "TraumaAndEmergencyAnesthesiaRvu Case Type #40", 24.0, 660, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-041", new AnesthesiaUnitCode("ANES-TRAU-041", "TraumaAndEmergencyAnesthesiaRvu Case Type #41", 24.5, 675, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-042", new AnesthesiaUnitCode("ANES-TRAU-042", "TraumaAndEmergencyAnesthesiaRvu Case Type #42", 25.0, 690, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-043", new AnesthesiaUnitCode("ANES-TRAU-043", "TraumaAndEmergencyAnesthesiaRvu Case Type #43", 25.5, 705, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-044", new AnesthesiaUnitCode("ANES-TRAU-044", "TraumaAndEmergencyAnesthesiaRvu Case Type #44", 26.0, 720, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-045", new AnesthesiaUnitCode("ANES-TRAU-045", "TraumaAndEmergencyAnesthesiaRvu Case Type #45", 26.5, 735, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-046", new AnesthesiaUnitCode("ANES-TRAU-046", "TraumaAndEmergencyAnesthesiaRvu Case Type #46", 27.0, 750, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-047", new AnesthesiaUnitCode("ANES-TRAU-047", "TraumaAndEmergencyAnesthesiaRvu Case Type #47", 27.5, 765, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-048", new AnesthesiaUnitCode("ANES-TRAU-048", "TraumaAndEmergencyAnesthesiaRvu Case Type #48", 28.0, 780, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-049", new AnesthesiaUnitCode("ANES-TRAU-049", "TraumaAndEmergencyAnesthesiaRvu Case Type #49", 28.5, 795, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-050", new AnesthesiaUnitCode("ANES-TRAU-050", "TraumaAndEmergencyAnesthesiaRvu Case Type #50", 29.0, 810, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-051", new AnesthesiaUnitCode("ANES-TRAU-051", "TraumaAndEmergencyAnesthesiaRvu Case Type #51", 29.5, 825, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-052", new AnesthesiaUnitCode("ANES-TRAU-052", "TraumaAndEmergencyAnesthesiaRvu Case Type #52", 30.0, 840, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-053", new AnesthesiaUnitCode("ANES-TRAU-053", "TraumaAndEmergencyAnesthesiaRvu Case Type #53", 30.5, 855, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-054", new AnesthesiaUnitCode("ANES-TRAU-054", "TraumaAndEmergencyAnesthesiaRvu Case Type #54", 31.0, 870, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-055", new AnesthesiaUnitCode("ANES-TRAU-055", "TraumaAndEmergencyAnesthesiaRvu Case Type #55", 31.5, 885, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-056", new AnesthesiaUnitCode("ANES-TRAU-056", "TraumaAndEmergencyAnesthesiaRvu Case Type #56", 32.0, 900, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-057", new AnesthesiaUnitCode("ANES-TRAU-057", "TraumaAndEmergencyAnesthesiaRvu Case Type #57", 32.5, 915, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-058", new AnesthesiaUnitCode("ANES-TRAU-058", "TraumaAndEmergencyAnesthesiaRvu Case Type #58", 33.0, 930, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-059", new AnesthesiaUnitCode("ANES-TRAU-059", "TraumaAndEmergencyAnesthesiaRvu Case Type #59", 33.5, 945, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-060", new AnesthesiaUnitCode("ANES-TRAU-060", "TraumaAndEmergencyAnesthesiaRvu Case Type #60", 34.0, 960, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-061", new AnesthesiaUnitCode("ANES-TRAU-061", "TraumaAndEmergencyAnesthesiaRvu Case Type #61", 34.5, 975, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-062", new AnesthesiaUnitCode("ANES-TRAU-062", "TraumaAndEmergencyAnesthesiaRvu Case Type #62", 35.0, 990, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-063", new AnesthesiaUnitCode("ANES-TRAU-063", "TraumaAndEmergencyAnesthesiaRvu Case Type #63", 35.5, 1005, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-064", new AnesthesiaUnitCode("ANES-TRAU-064", "TraumaAndEmergencyAnesthesiaRvu Case Type #64", 36.0, 1020, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-065", new AnesthesiaUnitCode("ANES-TRAU-065", "TraumaAndEmergencyAnesthesiaRvu Case Type #65", 36.5, 1035, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-066", new AnesthesiaUnitCode("ANES-TRAU-066", "TraumaAndEmergencyAnesthesiaRvu Case Type #66", 37.0, 1050, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-067", new AnesthesiaUnitCode("ANES-TRAU-067", "TraumaAndEmergencyAnesthesiaRvu Case Type #67", 37.5, 1065, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-068", new AnesthesiaUnitCode("ANES-TRAU-068", "TraumaAndEmergencyAnesthesiaRvu Case Type #68", 38.0, 1080, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-069", new AnesthesiaUnitCode("ANES-TRAU-069", "TraumaAndEmergencyAnesthesiaRvu Case Type #69", 38.5, 1095, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-070", new AnesthesiaUnitCode("ANES-TRAU-070", "TraumaAndEmergencyAnesthesiaRvu Case Type #70", 39.0, 1110, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-071", new AnesthesiaUnitCode("ANES-TRAU-071", "TraumaAndEmergencyAnesthesiaRvu Case Type #71", 39.5, 1125, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-072", new AnesthesiaUnitCode("ANES-TRAU-072", "TraumaAndEmergencyAnesthesiaRvu Case Type #72", 40.0, 1140, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-073", new AnesthesiaUnitCode("ANES-TRAU-073", "TraumaAndEmergencyAnesthesiaRvu Case Type #73", 40.5, 1155, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-074", new AnesthesiaUnitCode("ANES-TRAU-074", "TraumaAndEmergencyAnesthesiaRvu Case Type #74", 41.0, 1170, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-075", new AnesthesiaUnitCode("ANES-TRAU-075", "TraumaAndEmergencyAnesthesiaRvu Case Type #75", 41.5, 1185, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-076", new AnesthesiaUnitCode("ANES-TRAU-076", "TraumaAndEmergencyAnesthesiaRvu Case Type #76", 42.0, 1200, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-077", new AnesthesiaUnitCode("ANES-TRAU-077", "TraumaAndEmergencyAnesthesiaRvu Case Type #77", 42.5, 1215, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-078", new AnesthesiaUnitCode("ANES-TRAU-078", "TraumaAndEmergencyAnesthesiaRvu Case Type #78", 43.0, 1230, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-079", new AnesthesiaUnitCode("ANES-TRAU-079", "TraumaAndEmergencyAnesthesiaRvu Case Type #79", 43.5, 1245, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-080", new AnesthesiaUnitCode("ANES-TRAU-080", "TraumaAndEmergencyAnesthesiaRvu Case Type #80", 44.0, 1260, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-081", new AnesthesiaUnitCode("ANES-TRAU-081", "TraumaAndEmergencyAnesthesiaRvu Case Type #81", 44.5, 1275, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-082", new AnesthesiaUnitCode("ANES-TRAU-082", "TraumaAndEmergencyAnesthesiaRvu Case Type #82", 45.0, 1290, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-083", new AnesthesiaUnitCode("ANES-TRAU-083", "TraumaAndEmergencyAnesthesiaRvu Case Type #83", 45.5, 1305, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-084", new AnesthesiaUnitCode("ANES-TRAU-084", "TraumaAndEmergencyAnesthesiaRvu Case Type #84", 46.0, 1320, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-085", new AnesthesiaUnitCode("ANES-TRAU-085", "TraumaAndEmergencyAnesthesiaRvu Case Type #85", 46.5, 1335, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-086", new AnesthesiaUnitCode("ANES-TRAU-086", "TraumaAndEmergencyAnesthesiaRvu Case Type #86", 47.0, 1350, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-087", new AnesthesiaUnitCode("ANES-TRAU-087", "TraumaAndEmergencyAnesthesiaRvu Case Type #87", 47.5, 1365, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-088", new AnesthesiaUnitCode("ANES-TRAU-088", "TraumaAndEmergencyAnesthesiaRvu Case Type #88", 48.0, 1380, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-089", new AnesthesiaUnitCode("ANES-TRAU-089", "TraumaAndEmergencyAnesthesiaRvu Case Type #89", 48.5, 1395, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-090", new AnesthesiaUnitCode("ANES-TRAU-090", "TraumaAndEmergencyAnesthesiaRvu Case Type #90", 49.0, 1410, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-091", new AnesthesiaUnitCode("ANES-TRAU-091", "TraumaAndEmergencyAnesthesiaRvu Case Type #91", 49.5, 1425, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-092", new AnesthesiaUnitCode("ANES-TRAU-092", "TraumaAndEmergencyAnesthesiaRvu Case Type #92", 50.0, 1440, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-093", new AnesthesiaUnitCode("ANES-TRAU-093", "TraumaAndEmergencyAnesthesiaRvu Case Type #93", 50.5, 1455, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-094", new AnesthesiaUnitCode("ANES-TRAU-094", "TraumaAndEmergencyAnesthesiaRvu Case Type #94", 51.0, 1470, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-095", new AnesthesiaUnitCode("ANES-TRAU-095", "TraumaAndEmergencyAnesthesiaRvu Case Type #95", 51.5, 1485, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-096", new AnesthesiaUnitCode("ANES-TRAU-096", "TraumaAndEmergencyAnesthesiaRvu Case Type #96", 52.0, 1500, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-097", new AnesthesiaUnitCode("ANES-TRAU-097", "TraumaAndEmergencyAnesthesiaRvu Case Type #97", 52.5, 1515, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-098", new AnesthesiaUnitCode("ANES-TRAU-098", "TraumaAndEmergencyAnesthesiaRvu Case Type #98", 53.0, 1530, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-099", new AnesthesiaUnitCode("ANES-TRAU-099", "TraumaAndEmergencyAnesthesiaRvu Case Type #99", 53.5, 1545, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-100", new AnesthesiaUnitCode("ANES-TRAU-100", "TraumaAndEmergencyAnesthesiaRvu Case Type #100", 54.0, 1560, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-101", new AnesthesiaUnitCode("ANES-TRAU-101", "TraumaAndEmergencyAnesthesiaRvu Case Type #101", 54.5, 1575, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-102", new AnesthesiaUnitCode("ANES-TRAU-102", "TraumaAndEmergencyAnesthesiaRvu Case Type #102", 55.0, 1590, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-103", new AnesthesiaUnitCode("ANES-TRAU-103", "TraumaAndEmergencyAnesthesiaRvu Case Type #103", 55.5, 1605, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-104", new AnesthesiaUnitCode("ANES-TRAU-104", "TraumaAndEmergencyAnesthesiaRvu Case Type #104", 56.0, 1620, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-105", new AnesthesiaUnitCode("ANES-TRAU-105", "TraumaAndEmergencyAnesthesiaRvu Case Type #105", 56.5, 1635, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-106", new AnesthesiaUnitCode("ANES-TRAU-106", "TraumaAndEmergencyAnesthesiaRvu Case Type #106", 57.0, 1650, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-107", new AnesthesiaUnitCode("ANES-TRAU-107", "TraumaAndEmergencyAnesthesiaRvu Case Type #107", 57.5, 1665, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-108", new AnesthesiaUnitCode("ANES-TRAU-108", "TraumaAndEmergencyAnesthesiaRvu Case Type #108", 58.0, 1680, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-109", new AnesthesiaUnitCode("ANES-TRAU-109", "TraumaAndEmergencyAnesthesiaRvu Case Type #109", 58.5, 1695, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-110", new AnesthesiaUnitCode("ANES-TRAU-110", "TraumaAndEmergencyAnesthesiaRvu Case Type #110", 59.0, 1710, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-111", new AnesthesiaUnitCode("ANES-TRAU-111", "TraumaAndEmergencyAnesthesiaRvu Case Type #111", 59.5, 1725, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-112", new AnesthesiaUnitCode("ANES-TRAU-112", "TraumaAndEmergencyAnesthesiaRvu Case Type #112", 60.0, 1740, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-113", new AnesthesiaUnitCode("ANES-TRAU-113", "TraumaAndEmergencyAnesthesiaRvu Case Type #113", 60.5, 1755, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-114", new AnesthesiaUnitCode("ANES-TRAU-114", "TraumaAndEmergencyAnesthesiaRvu Case Type #114", 61.0, 1770, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-115", new AnesthesiaUnitCode("ANES-TRAU-115", "TraumaAndEmergencyAnesthesiaRvu Case Type #115", 61.5, 1785, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-116", new AnesthesiaUnitCode("ANES-TRAU-116", "TraumaAndEmergencyAnesthesiaRvu Case Type #116", 62.0, 1800, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-117", new AnesthesiaUnitCode("ANES-TRAU-117", "TraumaAndEmergencyAnesthesiaRvu Case Type #117", 62.5, 1815, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-118", new AnesthesiaUnitCode("ANES-TRAU-118", "TraumaAndEmergencyAnesthesiaRvu Case Type #118", 63.0, 1830, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-119", new AnesthesiaUnitCode("ANES-TRAU-119", "TraumaAndEmergencyAnesthesiaRvu Case Type #119", 63.5, 1845, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-120", new AnesthesiaUnitCode("ANES-TRAU-120", "TraumaAndEmergencyAnesthesiaRvu Case Type #120", 64.0, 1860, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-121", new AnesthesiaUnitCode("ANES-TRAU-121", "TraumaAndEmergencyAnesthesiaRvu Case Type #121", 64.5, 1875, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-122", new AnesthesiaUnitCode("ANES-TRAU-122", "TraumaAndEmergencyAnesthesiaRvu Case Type #122", 65.0, 1890, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-123", new AnesthesiaUnitCode("ANES-TRAU-123", "TraumaAndEmergencyAnesthesiaRvu Case Type #123", 65.5, 1905, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-124", new AnesthesiaUnitCode("ANES-TRAU-124", "TraumaAndEmergencyAnesthesiaRvu Case Type #124", 66.0, 1920, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-125", new AnesthesiaUnitCode("ANES-TRAU-125", "TraumaAndEmergencyAnesthesiaRvu Case Type #125", 66.5, 1935, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-126", new AnesthesiaUnitCode("ANES-TRAU-126", "TraumaAndEmergencyAnesthesiaRvu Case Type #126", 67.0, 1950, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-127", new AnesthesiaUnitCode("ANES-TRAU-127", "TraumaAndEmergencyAnesthesiaRvu Case Type #127", 67.5, 1965, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-128", new AnesthesiaUnitCode("ANES-TRAU-128", "TraumaAndEmergencyAnesthesiaRvu Case Type #128", 68.0, 1980, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-129", new AnesthesiaUnitCode("ANES-TRAU-129", "TraumaAndEmergencyAnesthesiaRvu Case Type #129", 68.5, 1995, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-130", new AnesthesiaUnitCode("ANES-TRAU-130", "TraumaAndEmergencyAnesthesiaRvu Case Type #130", 69.0, 2010, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-131", new AnesthesiaUnitCode("ANES-TRAU-131", "TraumaAndEmergencyAnesthesiaRvu Case Type #131", 69.5, 2025, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-132", new AnesthesiaUnitCode("ANES-TRAU-132", "TraumaAndEmergencyAnesthesiaRvu Case Type #132", 70.0, 2040, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-133", new AnesthesiaUnitCode("ANES-TRAU-133", "TraumaAndEmergencyAnesthesiaRvu Case Type #133", 70.5, 2055, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-134", new AnesthesiaUnitCode("ANES-TRAU-134", "TraumaAndEmergencyAnesthesiaRvu Case Type #134", 71.0, 2070, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-135", new AnesthesiaUnitCode("ANES-TRAU-135", "TraumaAndEmergencyAnesthesiaRvu Case Type #135", 71.5, 2085, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-136", new AnesthesiaUnitCode("ANES-TRAU-136", "TraumaAndEmergencyAnesthesiaRvu Case Type #136", 72.0, 2100, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-137", new AnesthesiaUnitCode("ANES-TRAU-137", "TraumaAndEmergencyAnesthesiaRvu Case Type #137", 72.5, 2115, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-138", new AnesthesiaUnitCode("ANES-TRAU-138", "TraumaAndEmergencyAnesthesiaRvu Case Type #138", 73.0, 2130, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-139", new AnesthesiaUnitCode("ANES-TRAU-139", "TraumaAndEmergencyAnesthesiaRvu Case Type #139", 73.5, 2145, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-TRAU-140", new AnesthesiaUnitCode("ANES-TRAU-140", "TraumaAndEmergencyAnesthesiaRvu Case Type #140", 74.0, 2160, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
    }

    public Optional<AnesthesiaUnitCode> getByCode(String code) {
        return Optional.ofNullable(baseUnits.get(code));
    }

    public List<AnesthesiaUnitCode> getAllUnits() {
        return new ArrayList<>(baseUnits.values());
    }
}
