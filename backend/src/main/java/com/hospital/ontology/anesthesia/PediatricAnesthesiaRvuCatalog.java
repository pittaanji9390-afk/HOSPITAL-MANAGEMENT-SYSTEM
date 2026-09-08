package com.hospital.ontology.anesthesia;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PediatricAnesthesiaRvuCatalog {

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

    public PediatricAnesthesiaRvuCatalog() {
        initializeBaseUnits();
    }

    private void initializeBaseUnits() {
        baseUnits.put("ANES-PEDI-001", new AnesthesiaUnitCode("ANES-PEDI-001", "PediatricAnesthesiaRvu Case Type #1", 4.5, 75, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-002", new AnesthesiaUnitCode("ANES-PEDI-002", "PediatricAnesthesiaRvu Case Type #2", 5.0, 90, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-003", new AnesthesiaUnitCode("ANES-PEDI-003", "PediatricAnesthesiaRvu Case Type #3", 5.5, 105, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-004", new AnesthesiaUnitCode("ANES-PEDI-004", "PediatricAnesthesiaRvu Case Type #4", 6.0, 120, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-005", new AnesthesiaUnitCode("ANES-PEDI-005", "PediatricAnesthesiaRvu Case Type #5", 6.5, 135, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-006", new AnesthesiaUnitCode("ANES-PEDI-006", "PediatricAnesthesiaRvu Case Type #6", 7.0, 150, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-007", new AnesthesiaUnitCode("ANES-PEDI-007", "PediatricAnesthesiaRvu Case Type #7", 7.5, 165, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-008", new AnesthesiaUnitCode("ANES-PEDI-008", "PediatricAnesthesiaRvu Case Type #8", 8.0, 180, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-009", new AnesthesiaUnitCode("ANES-PEDI-009", "PediatricAnesthesiaRvu Case Type #9", 8.5, 195, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-010", new AnesthesiaUnitCode("ANES-PEDI-010", "PediatricAnesthesiaRvu Case Type #10", 9.0, 210, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-011", new AnesthesiaUnitCode("ANES-PEDI-011", "PediatricAnesthesiaRvu Case Type #11", 9.5, 225, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-012", new AnesthesiaUnitCode("ANES-PEDI-012", "PediatricAnesthesiaRvu Case Type #12", 10.0, 240, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-013", new AnesthesiaUnitCode("ANES-PEDI-013", "PediatricAnesthesiaRvu Case Type #13", 10.5, 255, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-014", new AnesthesiaUnitCode("ANES-PEDI-014", "PediatricAnesthesiaRvu Case Type #14", 11.0, 270, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-015", new AnesthesiaUnitCode("ANES-PEDI-015", "PediatricAnesthesiaRvu Case Type #15", 11.5, 285, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-016", new AnesthesiaUnitCode("ANES-PEDI-016", "PediatricAnesthesiaRvu Case Type #16", 12.0, 300, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-017", new AnesthesiaUnitCode("ANES-PEDI-017", "PediatricAnesthesiaRvu Case Type #17", 12.5, 315, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-018", new AnesthesiaUnitCode("ANES-PEDI-018", "PediatricAnesthesiaRvu Case Type #18", 13.0, 330, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-019", new AnesthesiaUnitCode("ANES-PEDI-019", "PediatricAnesthesiaRvu Case Type #19", 13.5, 345, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-020", new AnesthesiaUnitCode("ANES-PEDI-020", "PediatricAnesthesiaRvu Case Type #20", 14.0, 360, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-021", new AnesthesiaUnitCode("ANES-PEDI-021", "PediatricAnesthesiaRvu Case Type #21", 14.5, 375, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-022", new AnesthesiaUnitCode("ANES-PEDI-022", "PediatricAnesthesiaRvu Case Type #22", 15.0, 390, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-023", new AnesthesiaUnitCode("ANES-PEDI-023", "PediatricAnesthesiaRvu Case Type #23", 15.5, 405, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-024", new AnesthesiaUnitCode("ANES-PEDI-024", "PediatricAnesthesiaRvu Case Type #24", 16.0, 420, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-025", new AnesthesiaUnitCode("ANES-PEDI-025", "PediatricAnesthesiaRvu Case Type #25", 16.5, 435, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-026", new AnesthesiaUnitCode("ANES-PEDI-026", "PediatricAnesthesiaRvu Case Type #26", 17.0, 450, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-027", new AnesthesiaUnitCode("ANES-PEDI-027", "PediatricAnesthesiaRvu Case Type #27", 17.5, 465, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-028", new AnesthesiaUnitCode("ANES-PEDI-028", "PediatricAnesthesiaRvu Case Type #28", 18.0, 480, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-029", new AnesthesiaUnitCode("ANES-PEDI-029", "PediatricAnesthesiaRvu Case Type #29", 18.5, 495, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-030", new AnesthesiaUnitCode("ANES-PEDI-030", "PediatricAnesthesiaRvu Case Type #30", 19.0, 510, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-031", new AnesthesiaUnitCode("ANES-PEDI-031", "PediatricAnesthesiaRvu Case Type #31", 19.5, 525, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-032", new AnesthesiaUnitCode("ANES-PEDI-032", "PediatricAnesthesiaRvu Case Type #32", 20.0, 540, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-033", new AnesthesiaUnitCode("ANES-PEDI-033", "PediatricAnesthesiaRvu Case Type #33", 20.5, 555, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-034", new AnesthesiaUnitCode("ANES-PEDI-034", "PediatricAnesthesiaRvu Case Type #34", 21.0, 570, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-035", new AnesthesiaUnitCode("ANES-PEDI-035", "PediatricAnesthesiaRvu Case Type #35", 21.5, 585, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-036", new AnesthesiaUnitCode("ANES-PEDI-036", "PediatricAnesthesiaRvu Case Type #36", 22.0, 600, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-037", new AnesthesiaUnitCode("ANES-PEDI-037", "PediatricAnesthesiaRvu Case Type #37", 22.5, 615, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-038", new AnesthesiaUnitCode("ANES-PEDI-038", "PediatricAnesthesiaRvu Case Type #38", 23.0, 630, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-039", new AnesthesiaUnitCode("ANES-PEDI-039", "PediatricAnesthesiaRvu Case Type #39", 23.5, 645, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-040", new AnesthesiaUnitCode("ANES-PEDI-040", "PediatricAnesthesiaRvu Case Type #40", 24.0, 660, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-041", new AnesthesiaUnitCode("ANES-PEDI-041", "PediatricAnesthesiaRvu Case Type #41", 24.5, 675, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-042", new AnesthesiaUnitCode("ANES-PEDI-042", "PediatricAnesthesiaRvu Case Type #42", 25.0, 690, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-043", new AnesthesiaUnitCode("ANES-PEDI-043", "PediatricAnesthesiaRvu Case Type #43", 25.5, 705, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-044", new AnesthesiaUnitCode("ANES-PEDI-044", "PediatricAnesthesiaRvu Case Type #44", 26.0, 720, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-045", new AnesthesiaUnitCode("ANES-PEDI-045", "PediatricAnesthesiaRvu Case Type #45", 26.5, 735, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-046", new AnesthesiaUnitCode("ANES-PEDI-046", "PediatricAnesthesiaRvu Case Type #46", 27.0, 750, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-047", new AnesthesiaUnitCode("ANES-PEDI-047", "PediatricAnesthesiaRvu Case Type #47", 27.5, 765, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-048", new AnesthesiaUnitCode("ANES-PEDI-048", "PediatricAnesthesiaRvu Case Type #48", 28.0, 780, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-049", new AnesthesiaUnitCode("ANES-PEDI-049", "PediatricAnesthesiaRvu Case Type #49", 28.5, 795, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-050", new AnesthesiaUnitCode("ANES-PEDI-050", "PediatricAnesthesiaRvu Case Type #50", 29.0, 810, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-051", new AnesthesiaUnitCode("ANES-PEDI-051", "PediatricAnesthesiaRvu Case Type #51", 29.5, 825, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-052", new AnesthesiaUnitCode("ANES-PEDI-052", "PediatricAnesthesiaRvu Case Type #52", 30.0, 840, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-053", new AnesthesiaUnitCode("ANES-PEDI-053", "PediatricAnesthesiaRvu Case Type #53", 30.5, 855, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-054", new AnesthesiaUnitCode("ANES-PEDI-054", "PediatricAnesthesiaRvu Case Type #54", 31.0, 870, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-055", new AnesthesiaUnitCode("ANES-PEDI-055", "PediatricAnesthesiaRvu Case Type #55", 31.5, 885, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-056", new AnesthesiaUnitCode("ANES-PEDI-056", "PediatricAnesthesiaRvu Case Type #56", 32.0, 900, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-057", new AnesthesiaUnitCode("ANES-PEDI-057", "PediatricAnesthesiaRvu Case Type #57", 32.5, 915, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-058", new AnesthesiaUnitCode("ANES-PEDI-058", "PediatricAnesthesiaRvu Case Type #58", 33.0, 930, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-059", new AnesthesiaUnitCode("ANES-PEDI-059", "PediatricAnesthesiaRvu Case Type #59", 33.5, 945, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-060", new AnesthesiaUnitCode("ANES-PEDI-060", "PediatricAnesthesiaRvu Case Type #60", 34.0, 960, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-061", new AnesthesiaUnitCode("ANES-PEDI-061", "PediatricAnesthesiaRvu Case Type #61", 34.5, 975, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-062", new AnesthesiaUnitCode("ANES-PEDI-062", "PediatricAnesthesiaRvu Case Type #62", 35.0, 990, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-063", new AnesthesiaUnitCode("ANES-PEDI-063", "PediatricAnesthesiaRvu Case Type #63", 35.5, 1005, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-064", new AnesthesiaUnitCode("ANES-PEDI-064", "PediatricAnesthesiaRvu Case Type #64", 36.0, 1020, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-065", new AnesthesiaUnitCode("ANES-PEDI-065", "PediatricAnesthesiaRvu Case Type #65", 36.5, 1035, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-066", new AnesthesiaUnitCode("ANES-PEDI-066", "PediatricAnesthesiaRvu Case Type #66", 37.0, 1050, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-067", new AnesthesiaUnitCode("ANES-PEDI-067", "PediatricAnesthesiaRvu Case Type #67", 37.5, 1065, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-068", new AnesthesiaUnitCode("ANES-PEDI-068", "PediatricAnesthesiaRvu Case Type #68", 38.0, 1080, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-069", new AnesthesiaUnitCode("ANES-PEDI-069", "PediatricAnesthesiaRvu Case Type #69", 38.5, 1095, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-070", new AnesthesiaUnitCode("ANES-PEDI-070", "PediatricAnesthesiaRvu Case Type #70", 39.0, 1110, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-071", new AnesthesiaUnitCode("ANES-PEDI-071", "PediatricAnesthesiaRvu Case Type #71", 39.5, 1125, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-072", new AnesthesiaUnitCode("ANES-PEDI-072", "PediatricAnesthesiaRvu Case Type #72", 40.0, 1140, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-073", new AnesthesiaUnitCode("ANES-PEDI-073", "PediatricAnesthesiaRvu Case Type #73", 40.5, 1155, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-074", new AnesthesiaUnitCode("ANES-PEDI-074", "PediatricAnesthesiaRvu Case Type #74", 41.0, 1170, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-075", new AnesthesiaUnitCode("ANES-PEDI-075", "PediatricAnesthesiaRvu Case Type #75", 41.5, 1185, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-076", new AnesthesiaUnitCode("ANES-PEDI-076", "PediatricAnesthesiaRvu Case Type #76", 42.0, 1200, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-077", new AnesthesiaUnitCode("ANES-PEDI-077", "PediatricAnesthesiaRvu Case Type #77", 42.5, 1215, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-078", new AnesthesiaUnitCode("ANES-PEDI-078", "PediatricAnesthesiaRvu Case Type #78", 43.0, 1230, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-079", new AnesthesiaUnitCode("ANES-PEDI-079", "PediatricAnesthesiaRvu Case Type #79", 43.5, 1245, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-080", new AnesthesiaUnitCode("ANES-PEDI-080", "PediatricAnesthesiaRvu Case Type #80", 44.0, 1260, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-081", new AnesthesiaUnitCode("ANES-PEDI-081", "PediatricAnesthesiaRvu Case Type #81", 44.5, 1275, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-082", new AnesthesiaUnitCode("ANES-PEDI-082", "PediatricAnesthesiaRvu Case Type #82", 45.0, 1290, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-083", new AnesthesiaUnitCode("ANES-PEDI-083", "PediatricAnesthesiaRvu Case Type #83", 45.5, 1305, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-084", new AnesthesiaUnitCode("ANES-PEDI-084", "PediatricAnesthesiaRvu Case Type #84", 46.0, 1320, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-085", new AnesthesiaUnitCode("ANES-PEDI-085", "PediatricAnesthesiaRvu Case Type #85", 46.5, 1335, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-086", new AnesthesiaUnitCode("ANES-PEDI-086", "PediatricAnesthesiaRvu Case Type #86", 47.0, 1350, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-087", new AnesthesiaUnitCode("ANES-PEDI-087", "PediatricAnesthesiaRvu Case Type #87", 47.5, 1365, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-088", new AnesthesiaUnitCode("ANES-PEDI-088", "PediatricAnesthesiaRvu Case Type #88", 48.0, 1380, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-089", new AnesthesiaUnitCode("ANES-PEDI-089", "PediatricAnesthesiaRvu Case Type #89", 48.5, 1395, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-090", new AnesthesiaUnitCode("ANES-PEDI-090", "PediatricAnesthesiaRvu Case Type #90", 49.0, 1410, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-091", new AnesthesiaUnitCode("ANES-PEDI-091", "PediatricAnesthesiaRvu Case Type #91", 49.5, 1425, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-092", new AnesthesiaUnitCode("ANES-PEDI-092", "PediatricAnesthesiaRvu Case Type #92", 50.0, 1440, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-093", new AnesthesiaUnitCode("ANES-PEDI-093", "PediatricAnesthesiaRvu Case Type #93", 50.5, 1455, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-094", new AnesthesiaUnitCode("ANES-PEDI-094", "PediatricAnesthesiaRvu Case Type #94", 51.0, 1470, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-095", new AnesthesiaUnitCode("ANES-PEDI-095", "PediatricAnesthesiaRvu Case Type #95", 51.5, 1485, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-096", new AnesthesiaUnitCode("ANES-PEDI-096", "PediatricAnesthesiaRvu Case Type #96", 52.0, 1500, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-097", new AnesthesiaUnitCode("ANES-PEDI-097", "PediatricAnesthesiaRvu Case Type #97", 52.5, 1515, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-098", new AnesthesiaUnitCode("ANES-PEDI-098", "PediatricAnesthesiaRvu Case Type #98", 53.0, 1530, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-099", new AnesthesiaUnitCode("ANES-PEDI-099", "PediatricAnesthesiaRvu Case Type #99", 53.5, 1545, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-100", new AnesthesiaUnitCode("ANES-PEDI-100", "PediatricAnesthesiaRvu Case Type #100", 54.0, 1560, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-101", new AnesthesiaUnitCode("ANES-PEDI-101", "PediatricAnesthesiaRvu Case Type #101", 54.5, 1575, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-102", new AnesthesiaUnitCode("ANES-PEDI-102", "PediatricAnesthesiaRvu Case Type #102", 55.0, 1590, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-103", new AnesthesiaUnitCode("ANES-PEDI-103", "PediatricAnesthesiaRvu Case Type #103", 55.5, 1605, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-104", new AnesthesiaUnitCode("ANES-PEDI-104", "PediatricAnesthesiaRvu Case Type #104", 56.0, 1620, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-105", new AnesthesiaUnitCode("ANES-PEDI-105", "PediatricAnesthesiaRvu Case Type #105", 56.5, 1635, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-106", new AnesthesiaUnitCode("ANES-PEDI-106", "PediatricAnesthesiaRvu Case Type #106", 57.0, 1650, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-107", new AnesthesiaUnitCode("ANES-PEDI-107", "PediatricAnesthesiaRvu Case Type #107", 57.5, 1665, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-108", new AnesthesiaUnitCode("ANES-PEDI-108", "PediatricAnesthesiaRvu Case Type #108", 58.0, 1680, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-109", new AnesthesiaUnitCode("ANES-PEDI-109", "PediatricAnesthesiaRvu Case Type #109", 58.5, 1695, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-110", new AnesthesiaUnitCode("ANES-PEDI-110", "PediatricAnesthesiaRvu Case Type #110", 59.0, 1710, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-111", new AnesthesiaUnitCode("ANES-PEDI-111", "PediatricAnesthesiaRvu Case Type #111", 59.5, 1725, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-112", new AnesthesiaUnitCode("ANES-PEDI-112", "PediatricAnesthesiaRvu Case Type #112", 60.0, 1740, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-113", new AnesthesiaUnitCode("ANES-PEDI-113", "PediatricAnesthesiaRvu Case Type #113", 60.5, 1755, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-114", new AnesthesiaUnitCode("ANES-PEDI-114", "PediatricAnesthesiaRvu Case Type #114", 61.0, 1770, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-115", new AnesthesiaUnitCode("ANES-PEDI-115", "PediatricAnesthesiaRvu Case Type #115", 61.5, 1785, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-116", new AnesthesiaUnitCode("ANES-PEDI-116", "PediatricAnesthesiaRvu Case Type #116", 62.0, 1800, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-117", new AnesthesiaUnitCode("ANES-PEDI-117", "PediatricAnesthesiaRvu Case Type #117", 62.5, 1815, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-118", new AnesthesiaUnitCode("ANES-PEDI-118", "PediatricAnesthesiaRvu Case Type #118", 63.0, 1830, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-119", new AnesthesiaUnitCode("ANES-PEDI-119", "PediatricAnesthesiaRvu Case Type #119", 63.5, 1845, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-120", new AnesthesiaUnitCode("ANES-PEDI-120", "PediatricAnesthesiaRvu Case Type #120", 64.0, 1860, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-121", new AnesthesiaUnitCode("ANES-PEDI-121", "PediatricAnesthesiaRvu Case Type #121", 64.5, 1875, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-122", new AnesthesiaUnitCode("ANES-PEDI-122", "PediatricAnesthesiaRvu Case Type #122", 65.0, 1890, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-123", new AnesthesiaUnitCode("ANES-PEDI-123", "PediatricAnesthesiaRvu Case Type #123", 65.5, 1905, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-124", new AnesthesiaUnitCode("ANES-PEDI-124", "PediatricAnesthesiaRvu Case Type #124", 66.0, 1920, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-125", new AnesthesiaUnitCode("ANES-PEDI-125", "PediatricAnesthesiaRvu Case Type #125", 66.5, 1935, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-126", new AnesthesiaUnitCode("ANES-PEDI-126", "PediatricAnesthesiaRvu Case Type #126", 67.0, 1950, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-127", new AnesthesiaUnitCode("ANES-PEDI-127", "PediatricAnesthesiaRvu Case Type #127", 67.5, 1965, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-128", new AnesthesiaUnitCode("ANES-PEDI-128", "PediatricAnesthesiaRvu Case Type #128", 68.0, 1980, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-129", new AnesthesiaUnitCode("ANES-PEDI-129", "PediatricAnesthesiaRvu Case Type #129", 68.5, 1995, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-130", new AnesthesiaUnitCode("ANES-PEDI-130", "PediatricAnesthesiaRvu Case Type #130", 69.0, 2010, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-131", new AnesthesiaUnitCode("ANES-PEDI-131", "PediatricAnesthesiaRvu Case Type #131", 69.5, 2025, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-132", new AnesthesiaUnitCode("ANES-PEDI-132", "PediatricAnesthesiaRvu Case Type #132", 70.0, 2040, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-133", new AnesthesiaUnitCode("ANES-PEDI-133", "PediatricAnesthesiaRvu Case Type #133", 70.5, 2055, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-134", new AnesthesiaUnitCode("ANES-PEDI-134", "PediatricAnesthesiaRvu Case Type #134", 71.0, 2070, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-135", new AnesthesiaUnitCode("ANES-PEDI-135", "PediatricAnesthesiaRvu Case Type #135", 71.5, 2085, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-136", new AnesthesiaUnitCode("ANES-PEDI-136", "PediatricAnesthesiaRvu Case Type #136", 72.0, 2100, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-137", new AnesthesiaUnitCode("ANES-PEDI-137", "PediatricAnesthesiaRvu Case Type #137", 72.5, 2115, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-138", new AnesthesiaUnitCode("ANES-PEDI-138", "PediatricAnesthesiaRvu Case Type #138", 73.0, 2130, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-139", new AnesthesiaUnitCode("ANES-PEDI-139", "PediatricAnesthesiaRvu Case Type #139", 73.5, 2145, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-PEDI-140", new AnesthesiaUnitCode("ANES-PEDI-140", "PediatricAnesthesiaRvu Case Type #140", 74.0, 2160, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
    }

    public Optional<AnesthesiaUnitCode> getByCode(String code) {
        return Optional.ofNullable(baseUnits.get(code));
    }

    public List<AnesthesiaUnitCode> getAllUnits() {
        return new ArrayList<>(baseUnits.values());
    }
}
