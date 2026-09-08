package com.hospital.ontology.anesthesia;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class OrthopedicAnesthesiaRvuCatalog {

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

    public OrthopedicAnesthesiaRvuCatalog() {
        initializeBaseUnits();
    }

    private void initializeBaseUnits() {
        baseUnits.put("ANES-ORTH-001", new AnesthesiaUnitCode("ANES-ORTH-001", "OrthopedicAnesthesiaRvu Case Type #1", 4.5, 75, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-002", new AnesthesiaUnitCode("ANES-ORTH-002", "OrthopedicAnesthesiaRvu Case Type #2", 5.0, 90, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-003", new AnesthesiaUnitCode("ANES-ORTH-003", "OrthopedicAnesthesiaRvu Case Type #3", 5.5, 105, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-004", new AnesthesiaUnitCode("ANES-ORTH-004", "OrthopedicAnesthesiaRvu Case Type #4", 6.0, 120, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-005", new AnesthesiaUnitCode("ANES-ORTH-005", "OrthopedicAnesthesiaRvu Case Type #5", 6.5, 135, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-006", new AnesthesiaUnitCode("ANES-ORTH-006", "OrthopedicAnesthesiaRvu Case Type #6", 7.0, 150, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-007", new AnesthesiaUnitCode("ANES-ORTH-007", "OrthopedicAnesthesiaRvu Case Type #7", 7.5, 165, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-008", new AnesthesiaUnitCode("ANES-ORTH-008", "OrthopedicAnesthesiaRvu Case Type #8", 8.0, 180, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-009", new AnesthesiaUnitCode("ANES-ORTH-009", "OrthopedicAnesthesiaRvu Case Type #9", 8.5, 195, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-010", new AnesthesiaUnitCode("ANES-ORTH-010", "OrthopedicAnesthesiaRvu Case Type #10", 9.0, 210, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-011", new AnesthesiaUnitCode("ANES-ORTH-011", "OrthopedicAnesthesiaRvu Case Type #11", 9.5, 225, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-012", new AnesthesiaUnitCode("ANES-ORTH-012", "OrthopedicAnesthesiaRvu Case Type #12", 10.0, 240, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-013", new AnesthesiaUnitCode("ANES-ORTH-013", "OrthopedicAnesthesiaRvu Case Type #13", 10.5, 255, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-014", new AnesthesiaUnitCode("ANES-ORTH-014", "OrthopedicAnesthesiaRvu Case Type #14", 11.0, 270, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-015", new AnesthesiaUnitCode("ANES-ORTH-015", "OrthopedicAnesthesiaRvu Case Type #15", 11.5, 285, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-016", new AnesthesiaUnitCode("ANES-ORTH-016", "OrthopedicAnesthesiaRvu Case Type #16", 12.0, 300, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-017", new AnesthesiaUnitCode("ANES-ORTH-017", "OrthopedicAnesthesiaRvu Case Type #17", 12.5, 315, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-018", new AnesthesiaUnitCode("ANES-ORTH-018", "OrthopedicAnesthesiaRvu Case Type #18", 13.0, 330, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-019", new AnesthesiaUnitCode("ANES-ORTH-019", "OrthopedicAnesthesiaRvu Case Type #19", 13.5, 345, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-020", new AnesthesiaUnitCode("ANES-ORTH-020", "OrthopedicAnesthesiaRvu Case Type #20", 14.0, 360, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-021", new AnesthesiaUnitCode("ANES-ORTH-021", "OrthopedicAnesthesiaRvu Case Type #21", 14.5, 375, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-022", new AnesthesiaUnitCode("ANES-ORTH-022", "OrthopedicAnesthesiaRvu Case Type #22", 15.0, 390, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-023", new AnesthesiaUnitCode("ANES-ORTH-023", "OrthopedicAnesthesiaRvu Case Type #23", 15.5, 405, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-024", new AnesthesiaUnitCode("ANES-ORTH-024", "OrthopedicAnesthesiaRvu Case Type #24", 16.0, 420, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-025", new AnesthesiaUnitCode("ANES-ORTH-025", "OrthopedicAnesthesiaRvu Case Type #25", 16.5, 435, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-026", new AnesthesiaUnitCode("ANES-ORTH-026", "OrthopedicAnesthesiaRvu Case Type #26", 17.0, 450, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-027", new AnesthesiaUnitCode("ANES-ORTH-027", "OrthopedicAnesthesiaRvu Case Type #27", 17.5, 465, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-028", new AnesthesiaUnitCode("ANES-ORTH-028", "OrthopedicAnesthesiaRvu Case Type #28", 18.0, 480, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-029", new AnesthesiaUnitCode("ANES-ORTH-029", "OrthopedicAnesthesiaRvu Case Type #29", 18.5, 495, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-030", new AnesthesiaUnitCode("ANES-ORTH-030", "OrthopedicAnesthesiaRvu Case Type #30", 19.0, 510, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-031", new AnesthesiaUnitCode("ANES-ORTH-031", "OrthopedicAnesthesiaRvu Case Type #31", 19.5, 525, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-032", new AnesthesiaUnitCode("ANES-ORTH-032", "OrthopedicAnesthesiaRvu Case Type #32", 20.0, 540, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-033", new AnesthesiaUnitCode("ANES-ORTH-033", "OrthopedicAnesthesiaRvu Case Type #33", 20.5, 555, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-034", new AnesthesiaUnitCode("ANES-ORTH-034", "OrthopedicAnesthesiaRvu Case Type #34", 21.0, 570, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-035", new AnesthesiaUnitCode("ANES-ORTH-035", "OrthopedicAnesthesiaRvu Case Type #35", 21.5, 585, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-036", new AnesthesiaUnitCode("ANES-ORTH-036", "OrthopedicAnesthesiaRvu Case Type #36", 22.0, 600, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-037", new AnesthesiaUnitCode("ANES-ORTH-037", "OrthopedicAnesthesiaRvu Case Type #37", 22.5, 615, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-038", new AnesthesiaUnitCode("ANES-ORTH-038", "OrthopedicAnesthesiaRvu Case Type #38", 23.0, 630, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-039", new AnesthesiaUnitCode("ANES-ORTH-039", "OrthopedicAnesthesiaRvu Case Type #39", 23.5, 645, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-040", new AnesthesiaUnitCode("ANES-ORTH-040", "OrthopedicAnesthesiaRvu Case Type #40", 24.0, 660, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-041", new AnesthesiaUnitCode("ANES-ORTH-041", "OrthopedicAnesthesiaRvu Case Type #41", 24.5, 675, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-042", new AnesthesiaUnitCode("ANES-ORTH-042", "OrthopedicAnesthesiaRvu Case Type #42", 25.0, 690, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-043", new AnesthesiaUnitCode("ANES-ORTH-043", "OrthopedicAnesthesiaRvu Case Type #43", 25.5, 705, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-044", new AnesthesiaUnitCode("ANES-ORTH-044", "OrthopedicAnesthesiaRvu Case Type #44", 26.0, 720, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-045", new AnesthesiaUnitCode("ANES-ORTH-045", "OrthopedicAnesthesiaRvu Case Type #45", 26.5, 735, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-046", new AnesthesiaUnitCode("ANES-ORTH-046", "OrthopedicAnesthesiaRvu Case Type #46", 27.0, 750, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-047", new AnesthesiaUnitCode("ANES-ORTH-047", "OrthopedicAnesthesiaRvu Case Type #47", 27.5, 765, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-048", new AnesthesiaUnitCode("ANES-ORTH-048", "OrthopedicAnesthesiaRvu Case Type #48", 28.0, 780, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-049", new AnesthesiaUnitCode("ANES-ORTH-049", "OrthopedicAnesthesiaRvu Case Type #49", 28.5, 795, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-050", new AnesthesiaUnitCode("ANES-ORTH-050", "OrthopedicAnesthesiaRvu Case Type #50", 29.0, 810, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-051", new AnesthesiaUnitCode("ANES-ORTH-051", "OrthopedicAnesthesiaRvu Case Type #51", 29.5, 825, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-052", new AnesthesiaUnitCode("ANES-ORTH-052", "OrthopedicAnesthesiaRvu Case Type #52", 30.0, 840, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-053", new AnesthesiaUnitCode("ANES-ORTH-053", "OrthopedicAnesthesiaRvu Case Type #53", 30.5, 855, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-054", new AnesthesiaUnitCode("ANES-ORTH-054", "OrthopedicAnesthesiaRvu Case Type #54", 31.0, 870, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-055", new AnesthesiaUnitCode("ANES-ORTH-055", "OrthopedicAnesthesiaRvu Case Type #55", 31.5, 885, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-056", new AnesthesiaUnitCode("ANES-ORTH-056", "OrthopedicAnesthesiaRvu Case Type #56", 32.0, 900, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-057", new AnesthesiaUnitCode("ANES-ORTH-057", "OrthopedicAnesthesiaRvu Case Type #57", 32.5, 915, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-058", new AnesthesiaUnitCode("ANES-ORTH-058", "OrthopedicAnesthesiaRvu Case Type #58", 33.0, 930, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-059", new AnesthesiaUnitCode("ANES-ORTH-059", "OrthopedicAnesthesiaRvu Case Type #59", 33.5, 945, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-060", new AnesthesiaUnitCode("ANES-ORTH-060", "OrthopedicAnesthesiaRvu Case Type #60", 34.0, 960, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-061", new AnesthesiaUnitCode("ANES-ORTH-061", "OrthopedicAnesthesiaRvu Case Type #61", 34.5, 975, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-062", new AnesthesiaUnitCode("ANES-ORTH-062", "OrthopedicAnesthesiaRvu Case Type #62", 35.0, 990, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-063", new AnesthesiaUnitCode("ANES-ORTH-063", "OrthopedicAnesthesiaRvu Case Type #63", 35.5, 1005, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-064", new AnesthesiaUnitCode("ANES-ORTH-064", "OrthopedicAnesthesiaRvu Case Type #64", 36.0, 1020, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-065", new AnesthesiaUnitCode("ANES-ORTH-065", "OrthopedicAnesthesiaRvu Case Type #65", 36.5, 1035, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-066", new AnesthesiaUnitCode("ANES-ORTH-066", "OrthopedicAnesthesiaRvu Case Type #66", 37.0, 1050, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-067", new AnesthesiaUnitCode("ANES-ORTH-067", "OrthopedicAnesthesiaRvu Case Type #67", 37.5, 1065, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-068", new AnesthesiaUnitCode("ANES-ORTH-068", "OrthopedicAnesthesiaRvu Case Type #68", 38.0, 1080, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-069", new AnesthesiaUnitCode("ANES-ORTH-069", "OrthopedicAnesthesiaRvu Case Type #69", 38.5, 1095, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-070", new AnesthesiaUnitCode("ANES-ORTH-070", "OrthopedicAnesthesiaRvu Case Type #70", 39.0, 1110, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-071", new AnesthesiaUnitCode("ANES-ORTH-071", "OrthopedicAnesthesiaRvu Case Type #71", 39.5, 1125, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-072", new AnesthesiaUnitCode("ANES-ORTH-072", "OrthopedicAnesthesiaRvu Case Type #72", 40.0, 1140, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-073", new AnesthesiaUnitCode("ANES-ORTH-073", "OrthopedicAnesthesiaRvu Case Type #73", 40.5, 1155, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-074", new AnesthesiaUnitCode("ANES-ORTH-074", "OrthopedicAnesthesiaRvu Case Type #74", 41.0, 1170, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-075", new AnesthesiaUnitCode("ANES-ORTH-075", "OrthopedicAnesthesiaRvu Case Type #75", 41.5, 1185, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-076", new AnesthesiaUnitCode("ANES-ORTH-076", "OrthopedicAnesthesiaRvu Case Type #76", 42.0, 1200, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-077", new AnesthesiaUnitCode("ANES-ORTH-077", "OrthopedicAnesthesiaRvu Case Type #77", 42.5, 1215, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-078", new AnesthesiaUnitCode("ANES-ORTH-078", "OrthopedicAnesthesiaRvu Case Type #78", 43.0, 1230, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-079", new AnesthesiaUnitCode("ANES-ORTH-079", "OrthopedicAnesthesiaRvu Case Type #79", 43.5, 1245, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-080", new AnesthesiaUnitCode("ANES-ORTH-080", "OrthopedicAnesthesiaRvu Case Type #80", 44.0, 1260, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-081", new AnesthesiaUnitCode("ANES-ORTH-081", "OrthopedicAnesthesiaRvu Case Type #81", 44.5, 1275, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-082", new AnesthesiaUnitCode("ANES-ORTH-082", "OrthopedicAnesthesiaRvu Case Type #82", 45.0, 1290, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-083", new AnesthesiaUnitCode("ANES-ORTH-083", "OrthopedicAnesthesiaRvu Case Type #83", 45.5, 1305, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-084", new AnesthesiaUnitCode("ANES-ORTH-084", "OrthopedicAnesthesiaRvu Case Type #84", 46.0, 1320, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-085", new AnesthesiaUnitCode("ANES-ORTH-085", "OrthopedicAnesthesiaRvu Case Type #85", 46.5, 1335, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-086", new AnesthesiaUnitCode("ANES-ORTH-086", "OrthopedicAnesthesiaRvu Case Type #86", 47.0, 1350, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-087", new AnesthesiaUnitCode("ANES-ORTH-087", "OrthopedicAnesthesiaRvu Case Type #87", 47.5, 1365, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-088", new AnesthesiaUnitCode("ANES-ORTH-088", "OrthopedicAnesthesiaRvu Case Type #88", 48.0, 1380, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-089", new AnesthesiaUnitCode("ANES-ORTH-089", "OrthopedicAnesthesiaRvu Case Type #89", 48.5, 1395, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-090", new AnesthesiaUnitCode("ANES-ORTH-090", "OrthopedicAnesthesiaRvu Case Type #90", 49.0, 1410, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-091", new AnesthesiaUnitCode("ANES-ORTH-091", "OrthopedicAnesthesiaRvu Case Type #91", 49.5, 1425, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-092", new AnesthesiaUnitCode("ANES-ORTH-092", "OrthopedicAnesthesiaRvu Case Type #92", 50.0, 1440, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-093", new AnesthesiaUnitCode("ANES-ORTH-093", "OrthopedicAnesthesiaRvu Case Type #93", 50.5, 1455, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-094", new AnesthesiaUnitCode("ANES-ORTH-094", "OrthopedicAnesthesiaRvu Case Type #94", 51.0, 1470, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-095", new AnesthesiaUnitCode("ANES-ORTH-095", "OrthopedicAnesthesiaRvu Case Type #95", 51.5, 1485, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-096", new AnesthesiaUnitCode("ANES-ORTH-096", "OrthopedicAnesthesiaRvu Case Type #96", 52.0, 1500, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-097", new AnesthesiaUnitCode("ANES-ORTH-097", "OrthopedicAnesthesiaRvu Case Type #97", 52.5, 1515, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-098", new AnesthesiaUnitCode("ANES-ORTH-098", "OrthopedicAnesthesiaRvu Case Type #98", 53.0, 1530, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-099", new AnesthesiaUnitCode("ANES-ORTH-099", "OrthopedicAnesthesiaRvu Case Type #99", 53.5, 1545, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-100", new AnesthesiaUnitCode("ANES-ORTH-100", "OrthopedicAnesthesiaRvu Case Type #100", 54.0, 1560, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-101", new AnesthesiaUnitCode("ANES-ORTH-101", "OrthopedicAnesthesiaRvu Case Type #101", 54.5, 1575, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-102", new AnesthesiaUnitCode("ANES-ORTH-102", "OrthopedicAnesthesiaRvu Case Type #102", 55.0, 1590, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-103", new AnesthesiaUnitCode("ANES-ORTH-103", "OrthopedicAnesthesiaRvu Case Type #103", 55.5, 1605, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-104", new AnesthesiaUnitCode("ANES-ORTH-104", "OrthopedicAnesthesiaRvu Case Type #104", 56.0, 1620, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-105", new AnesthesiaUnitCode("ANES-ORTH-105", "OrthopedicAnesthesiaRvu Case Type #105", 56.5, 1635, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-106", new AnesthesiaUnitCode("ANES-ORTH-106", "OrthopedicAnesthesiaRvu Case Type #106", 57.0, 1650, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-107", new AnesthesiaUnitCode("ANES-ORTH-107", "OrthopedicAnesthesiaRvu Case Type #107", 57.5, 1665, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-108", new AnesthesiaUnitCode("ANES-ORTH-108", "OrthopedicAnesthesiaRvu Case Type #108", 58.0, 1680, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-109", new AnesthesiaUnitCode("ANES-ORTH-109", "OrthopedicAnesthesiaRvu Case Type #109", 58.5, 1695, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-110", new AnesthesiaUnitCode("ANES-ORTH-110", "OrthopedicAnesthesiaRvu Case Type #110", 59.0, 1710, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-111", new AnesthesiaUnitCode("ANES-ORTH-111", "OrthopedicAnesthesiaRvu Case Type #111", 59.5, 1725, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-112", new AnesthesiaUnitCode("ANES-ORTH-112", "OrthopedicAnesthesiaRvu Case Type #112", 60.0, 1740, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-113", new AnesthesiaUnitCode("ANES-ORTH-113", "OrthopedicAnesthesiaRvu Case Type #113", 60.5, 1755, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-114", new AnesthesiaUnitCode("ANES-ORTH-114", "OrthopedicAnesthesiaRvu Case Type #114", 61.0, 1770, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-115", new AnesthesiaUnitCode("ANES-ORTH-115", "OrthopedicAnesthesiaRvu Case Type #115", 61.5, 1785, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-116", new AnesthesiaUnitCode("ANES-ORTH-116", "OrthopedicAnesthesiaRvu Case Type #116", 62.0, 1800, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-117", new AnesthesiaUnitCode("ANES-ORTH-117", "OrthopedicAnesthesiaRvu Case Type #117", 62.5, 1815, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-118", new AnesthesiaUnitCode("ANES-ORTH-118", "OrthopedicAnesthesiaRvu Case Type #118", 63.0, 1830, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-119", new AnesthesiaUnitCode("ANES-ORTH-119", "OrthopedicAnesthesiaRvu Case Type #119", 63.5, 1845, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-120", new AnesthesiaUnitCode("ANES-ORTH-120", "OrthopedicAnesthesiaRvu Case Type #120", 64.0, 1860, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-121", new AnesthesiaUnitCode("ANES-ORTH-121", "OrthopedicAnesthesiaRvu Case Type #121", 64.5, 1875, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-122", new AnesthesiaUnitCode("ANES-ORTH-122", "OrthopedicAnesthesiaRvu Case Type #122", 65.0, 1890, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-123", new AnesthesiaUnitCode("ANES-ORTH-123", "OrthopedicAnesthesiaRvu Case Type #123", 65.5, 1905, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-124", new AnesthesiaUnitCode("ANES-ORTH-124", "OrthopedicAnesthesiaRvu Case Type #124", 66.0, 1920, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-125", new AnesthesiaUnitCode("ANES-ORTH-125", "OrthopedicAnesthesiaRvu Case Type #125", 66.5, 1935, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-126", new AnesthesiaUnitCode("ANES-ORTH-126", "OrthopedicAnesthesiaRvu Case Type #126", 67.0, 1950, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-127", new AnesthesiaUnitCode("ANES-ORTH-127", "OrthopedicAnesthesiaRvu Case Type #127", 67.5, 1965, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-128", new AnesthesiaUnitCode("ANES-ORTH-128", "OrthopedicAnesthesiaRvu Case Type #128", 68.0, 1980, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-129", new AnesthesiaUnitCode("ANES-ORTH-129", "OrthopedicAnesthesiaRvu Case Type #129", 68.5, 1995, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-130", new AnesthesiaUnitCode("ANES-ORTH-130", "OrthopedicAnesthesiaRvu Case Type #130", 69.0, 2010, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-131", new AnesthesiaUnitCode("ANES-ORTH-131", "OrthopedicAnesthesiaRvu Case Type #131", 69.5, 2025, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-132", new AnesthesiaUnitCode("ANES-ORTH-132", "OrthopedicAnesthesiaRvu Case Type #132", 70.0, 2040, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-133", new AnesthesiaUnitCode("ANES-ORTH-133", "OrthopedicAnesthesiaRvu Case Type #133", 70.5, 2055, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-134", new AnesthesiaUnitCode("ANES-ORTH-134", "OrthopedicAnesthesiaRvu Case Type #134", 71.0, 2070, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-135", new AnesthesiaUnitCode("ANES-ORTH-135", "OrthopedicAnesthesiaRvu Case Type #135", 71.5, 2085, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-136", new AnesthesiaUnitCode("ANES-ORTH-136", "OrthopedicAnesthesiaRvu Case Type #136", 72.0, 2100, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-137", new AnesthesiaUnitCode("ANES-ORTH-137", "OrthopedicAnesthesiaRvu Case Type #137", 72.5, 2115, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-138", new AnesthesiaUnitCode("ANES-ORTH-138", "OrthopedicAnesthesiaRvu Case Type #138", 73.0, 2130, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-139", new AnesthesiaUnitCode("ANES-ORTH-139", "OrthopedicAnesthesiaRvu Case Type #139", 73.5, 2145, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-ORTH-140", new AnesthesiaUnitCode("ANES-ORTH-140", "OrthopedicAnesthesiaRvu Case Type #140", 74.0, 2160, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
    }

    public Optional<AnesthesiaUnitCode> getByCode(String code) {
        return Optional.ofNullable(baseUnits.get(code));
    }

    public List<AnesthesiaUnitCode> getAllUnits() {
        return new ArrayList<>(baseUnits.values());
    }
}
