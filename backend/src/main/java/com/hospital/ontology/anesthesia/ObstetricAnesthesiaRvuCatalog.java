package com.hospital.ontology.anesthesia;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObstetricAnesthesiaRvuCatalog {

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

    public ObstetricAnesthesiaRvuCatalog() {
        initializeBaseUnits();
    }

    private void initializeBaseUnits() {
        baseUnits.put("ANES-OBST-001", new AnesthesiaUnitCode("ANES-OBST-001", "ObstetricAnesthesiaRvu Case Type #1", 4.5, 75, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-002", new AnesthesiaUnitCode("ANES-OBST-002", "ObstetricAnesthesiaRvu Case Type #2", 5.0, 90, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-003", new AnesthesiaUnitCode("ANES-OBST-003", "ObstetricAnesthesiaRvu Case Type #3", 5.5, 105, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-004", new AnesthesiaUnitCode("ANES-OBST-004", "ObstetricAnesthesiaRvu Case Type #4", 6.0, 120, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-005", new AnesthesiaUnitCode("ANES-OBST-005", "ObstetricAnesthesiaRvu Case Type #5", 6.5, 135, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-006", new AnesthesiaUnitCode("ANES-OBST-006", "ObstetricAnesthesiaRvu Case Type #6", 7.0, 150, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-007", new AnesthesiaUnitCode("ANES-OBST-007", "ObstetricAnesthesiaRvu Case Type #7", 7.5, 165, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-008", new AnesthesiaUnitCode("ANES-OBST-008", "ObstetricAnesthesiaRvu Case Type #8", 8.0, 180, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-009", new AnesthesiaUnitCode("ANES-OBST-009", "ObstetricAnesthesiaRvu Case Type #9", 8.5, 195, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-010", new AnesthesiaUnitCode("ANES-OBST-010", "ObstetricAnesthesiaRvu Case Type #10", 9.0, 210, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-011", new AnesthesiaUnitCode("ANES-OBST-011", "ObstetricAnesthesiaRvu Case Type #11", 9.5, 225, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-012", new AnesthesiaUnitCode("ANES-OBST-012", "ObstetricAnesthesiaRvu Case Type #12", 10.0, 240, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-013", new AnesthesiaUnitCode("ANES-OBST-013", "ObstetricAnesthesiaRvu Case Type #13", 10.5, 255, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-014", new AnesthesiaUnitCode("ANES-OBST-014", "ObstetricAnesthesiaRvu Case Type #14", 11.0, 270, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-015", new AnesthesiaUnitCode("ANES-OBST-015", "ObstetricAnesthesiaRvu Case Type #15", 11.5, 285, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-016", new AnesthesiaUnitCode("ANES-OBST-016", "ObstetricAnesthesiaRvu Case Type #16", 12.0, 300, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-017", new AnesthesiaUnitCode("ANES-OBST-017", "ObstetricAnesthesiaRvu Case Type #17", 12.5, 315, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-018", new AnesthesiaUnitCode("ANES-OBST-018", "ObstetricAnesthesiaRvu Case Type #18", 13.0, 330, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-019", new AnesthesiaUnitCode("ANES-OBST-019", "ObstetricAnesthesiaRvu Case Type #19", 13.5, 345, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-020", new AnesthesiaUnitCode("ANES-OBST-020", "ObstetricAnesthesiaRvu Case Type #20", 14.0, 360, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-021", new AnesthesiaUnitCode("ANES-OBST-021", "ObstetricAnesthesiaRvu Case Type #21", 14.5, 375, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-022", new AnesthesiaUnitCode("ANES-OBST-022", "ObstetricAnesthesiaRvu Case Type #22", 15.0, 390, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-023", new AnesthesiaUnitCode("ANES-OBST-023", "ObstetricAnesthesiaRvu Case Type #23", 15.5, 405, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-024", new AnesthesiaUnitCode("ANES-OBST-024", "ObstetricAnesthesiaRvu Case Type #24", 16.0, 420, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-025", new AnesthesiaUnitCode("ANES-OBST-025", "ObstetricAnesthesiaRvu Case Type #25", 16.5, 435, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-026", new AnesthesiaUnitCode("ANES-OBST-026", "ObstetricAnesthesiaRvu Case Type #26", 17.0, 450, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-027", new AnesthesiaUnitCode("ANES-OBST-027", "ObstetricAnesthesiaRvu Case Type #27", 17.5, 465, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-028", new AnesthesiaUnitCode("ANES-OBST-028", "ObstetricAnesthesiaRvu Case Type #28", 18.0, 480, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-029", new AnesthesiaUnitCode("ANES-OBST-029", "ObstetricAnesthesiaRvu Case Type #29", 18.5, 495, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-030", new AnesthesiaUnitCode("ANES-OBST-030", "ObstetricAnesthesiaRvu Case Type #30", 19.0, 510, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-031", new AnesthesiaUnitCode("ANES-OBST-031", "ObstetricAnesthesiaRvu Case Type #31", 19.5, 525, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-032", new AnesthesiaUnitCode("ANES-OBST-032", "ObstetricAnesthesiaRvu Case Type #32", 20.0, 540, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-033", new AnesthesiaUnitCode("ANES-OBST-033", "ObstetricAnesthesiaRvu Case Type #33", 20.5, 555, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-034", new AnesthesiaUnitCode("ANES-OBST-034", "ObstetricAnesthesiaRvu Case Type #34", 21.0, 570, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-035", new AnesthesiaUnitCode("ANES-OBST-035", "ObstetricAnesthesiaRvu Case Type #35", 21.5, 585, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-036", new AnesthesiaUnitCode("ANES-OBST-036", "ObstetricAnesthesiaRvu Case Type #36", 22.0, 600, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-037", new AnesthesiaUnitCode("ANES-OBST-037", "ObstetricAnesthesiaRvu Case Type #37", 22.5, 615, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-038", new AnesthesiaUnitCode("ANES-OBST-038", "ObstetricAnesthesiaRvu Case Type #38", 23.0, 630, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-039", new AnesthesiaUnitCode("ANES-OBST-039", "ObstetricAnesthesiaRvu Case Type #39", 23.5, 645, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-040", new AnesthesiaUnitCode("ANES-OBST-040", "ObstetricAnesthesiaRvu Case Type #40", 24.0, 660, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-041", new AnesthesiaUnitCode("ANES-OBST-041", "ObstetricAnesthesiaRvu Case Type #41", 24.5, 675, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-042", new AnesthesiaUnitCode("ANES-OBST-042", "ObstetricAnesthesiaRvu Case Type #42", 25.0, 690, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-043", new AnesthesiaUnitCode("ANES-OBST-043", "ObstetricAnesthesiaRvu Case Type #43", 25.5, 705, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-044", new AnesthesiaUnitCode("ANES-OBST-044", "ObstetricAnesthesiaRvu Case Type #44", 26.0, 720, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-045", new AnesthesiaUnitCode("ANES-OBST-045", "ObstetricAnesthesiaRvu Case Type #45", 26.5, 735, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-046", new AnesthesiaUnitCode("ANES-OBST-046", "ObstetricAnesthesiaRvu Case Type #46", 27.0, 750, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-047", new AnesthesiaUnitCode("ANES-OBST-047", "ObstetricAnesthesiaRvu Case Type #47", 27.5, 765, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-048", new AnesthesiaUnitCode("ANES-OBST-048", "ObstetricAnesthesiaRvu Case Type #48", 28.0, 780, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-049", new AnesthesiaUnitCode("ANES-OBST-049", "ObstetricAnesthesiaRvu Case Type #49", 28.5, 795, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-050", new AnesthesiaUnitCode("ANES-OBST-050", "ObstetricAnesthesiaRvu Case Type #50", 29.0, 810, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-051", new AnesthesiaUnitCode("ANES-OBST-051", "ObstetricAnesthesiaRvu Case Type #51", 29.5, 825, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-052", new AnesthesiaUnitCode("ANES-OBST-052", "ObstetricAnesthesiaRvu Case Type #52", 30.0, 840, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-053", new AnesthesiaUnitCode("ANES-OBST-053", "ObstetricAnesthesiaRvu Case Type #53", 30.5, 855, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-054", new AnesthesiaUnitCode("ANES-OBST-054", "ObstetricAnesthesiaRvu Case Type #54", 31.0, 870, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-055", new AnesthesiaUnitCode("ANES-OBST-055", "ObstetricAnesthesiaRvu Case Type #55", 31.5, 885, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-056", new AnesthesiaUnitCode("ANES-OBST-056", "ObstetricAnesthesiaRvu Case Type #56", 32.0, 900, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-057", new AnesthesiaUnitCode("ANES-OBST-057", "ObstetricAnesthesiaRvu Case Type #57", 32.5, 915, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-058", new AnesthesiaUnitCode("ANES-OBST-058", "ObstetricAnesthesiaRvu Case Type #58", 33.0, 930, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-059", new AnesthesiaUnitCode("ANES-OBST-059", "ObstetricAnesthesiaRvu Case Type #59", 33.5, 945, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-060", new AnesthesiaUnitCode("ANES-OBST-060", "ObstetricAnesthesiaRvu Case Type #60", 34.0, 960, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-061", new AnesthesiaUnitCode("ANES-OBST-061", "ObstetricAnesthesiaRvu Case Type #61", 34.5, 975, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-062", new AnesthesiaUnitCode("ANES-OBST-062", "ObstetricAnesthesiaRvu Case Type #62", 35.0, 990, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-063", new AnesthesiaUnitCode("ANES-OBST-063", "ObstetricAnesthesiaRvu Case Type #63", 35.5, 1005, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-064", new AnesthesiaUnitCode("ANES-OBST-064", "ObstetricAnesthesiaRvu Case Type #64", 36.0, 1020, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-065", new AnesthesiaUnitCode("ANES-OBST-065", "ObstetricAnesthesiaRvu Case Type #65", 36.5, 1035, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-066", new AnesthesiaUnitCode("ANES-OBST-066", "ObstetricAnesthesiaRvu Case Type #66", 37.0, 1050, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-067", new AnesthesiaUnitCode("ANES-OBST-067", "ObstetricAnesthesiaRvu Case Type #67", 37.5, 1065, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-068", new AnesthesiaUnitCode("ANES-OBST-068", "ObstetricAnesthesiaRvu Case Type #68", 38.0, 1080, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-069", new AnesthesiaUnitCode("ANES-OBST-069", "ObstetricAnesthesiaRvu Case Type #69", 38.5, 1095, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-070", new AnesthesiaUnitCode("ANES-OBST-070", "ObstetricAnesthesiaRvu Case Type #70", 39.0, 1110, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-071", new AnesthesiaUnitCode("ANES-OBST-071", "ObstetricAnesthesiaRvu Case Type #71", 39.5, 1125, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-072", new AnesthesiaUnitCode("ANES-OBST-072", "ObstetricAnesthesiaRvu Case Type #72", 40.0, 1140, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-073", new AnesthesiaUnitCode("ANES-OBST-073", "ObstetricAnesthesiaRvu Case Type #73", 40.5, 1155, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-074", new AnesthesiaUnitCode("ANES-OBST-074", "ObstetricAnesthesiaRvu Case Type #74", 41.0, 1170, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-075", new AnesthesiaUnitCode("ANES-OBST-075", "ObstetricAnesthesiaRvu Case Type #75", 41.5, 1185, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-076", new AnesthesiaUnitCode("ANES-OBST-076", "ObstetricAnesthesiaRvu Case Type #76", 42.0, 1200, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-077", new AnesthesiaUnitCode("ANES-OBST-077", "ObstetricAnesthesiaRvu Case Type #77", 42.5, 1215, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-078", new AnesthesiaUnitCode("ANES-OBST-078", "ObstetricAnesthesiaRvu Case Type #78", 43.0, 1230, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-079", new AnesthesiaUnitCode("ANES-OBST-079", "ObstetricAnesthesiaRvu Case Type #79", 43.5, 1245, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-080", new AnesthesiaUnitCode("ANES-OBST-080", "ObstetricAnesthesiaRvu Case Type #80", 44.0, 1260, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-081", new AnesthesiaUnitCode("ANES-OBST-081", "ObstetricAnesthesiaRvu Case Type #81", 44.5, 1275, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-082", new AnesthesiaUnitCode("ANES-OBST-082", "ObstetricAnesthesiaRvu Case Type #82", 45.0, 1290, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-083", new AnesthesiaUnitCode("ANES-OBST-083", "ObstetricAnesthesiaRvu Case Type #83", 45.5, 1305, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-084", new AnesthesiaUnitCode("ANES-OBST-084", "ObstetricAnesthesiaRvu Case Type #84", 46.0, 1320, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-085", new AnesthesiaUnitCode("ANES-OBST-085", "ObstetricAnesthesiaRvu Case Type #85", 46.5, 1335, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-086", new AnesthesiaUnitCode("ANES-OBST-086", "ObstetricAnesthesiaRvu Case Type #86", 47.0, 1350, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-087", new AnesthesiaUnitCode("ANES-OBST-087", "ObstetricAnesthesiaRvu Case Type #87", 47.5, 1365, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-088", new AnesthesiaUnitCode("ANES-OBST-088", "ObstetricAnesthesiaRvu Case Type #88", 48.0, 1380, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-089", new AnesthesiaUnitCode("ANES-OBST-089", "ObstetricAnesthesiaRvu Case Type #89", 48.5, 1395, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-090", new AnesthesiaUnitCode("ANES-OBST-090", "ObstetricAnesthesiaRvu Case Type #90", 49.0, 1410, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-091", new AnesthesiaUnitCode("ANES-OBST-091", "ObstetricAnesthesiaRvu Case Type #91", 49.5, 1425, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-092", new AnesthesiaUnitCode("ANES-OBST-092", "ObstetricAnesthesiaRvu Case Type #92", 50.0, 1440, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-093", new AnesthesiaUnitCode("ANES-OBST-093", "ObstetricAnesthesiaRvu Case Type #93", 50.5, 1455, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-094", new AnesthesiaUnitCode("ANES-OBST-094", "ObstetricAnesthesiaRvu Case Type #94", 51.0, 1470, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-095", new AnesthesiaUnitCode("ANES-OBST-095", "ObstetricAnesthesiaRvu Case Type #95", 51.5, 1485, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-096", new AnesthesiaUnitCode("ANES-OBST-096", "ObstetricAnesthesiaRvu Case Type #96", 52.0, 1500, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-097", new AnesthesiaUnitCode("ANES-OBST-097", "ObstetricAnesthesiaRvu Case Type #97", 52.5, 1515, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-098", new AnesthesiaUnitCode("ANES-OBST-098", "ObstetricAnesthesiaRvu Case Type #98", 53.0, 1530, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-099", new AnesthesiaUnitCode("ANES-OBST-099", "ObstetricAnesthesiaRvu Case Type #99", 53.5, 1545, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-100", new AnesthesiaUnitCode("ANES-OBST-100", "ObstetricAnesthesiaRvu Case Type #100", 54.0, 1560, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-101", new AnesthesiaUnitCode("ANES-OBST-101", "ObstetricAnesthesiaRvu Case Type #101", 54.5, 1575, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-102", new AnesthesiaUnitCode("ANES-OBST-102", "ObstetricAnesthesiaRvu Case Type #102", 55.0, 1590, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-103", new AnesthesiaUnitCode("ANES-OBST-103", "ObstetricAnesthesiaRvu Case Type #103", 55.5, 1605, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-104", new AnesthesiaUnitCode("ANES-OBST-104", "ObstetricAnesthesiaRvu Case Type #104", 56.0, 1620, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-105", new AnesthesiaUnitCode("ANES-OBST-105", "ObstetricAnesthesiaRvu Case Type #105", 56.5, 1635, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-106", new AnesthesiaUnitCode("ANES-OBST-106", "ObstetricAnesthesiaRvu Case Type #106", 57.0, 1650, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-107", new AnesthesiaUnitCode("ANES-OBST-107", "ObstetricAnesthesiaRvu Case Type #107", 57.5, 1665, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-108", new AnesthesiaUnitCode("ANES-OBST-108", "ObstetricAnesthesiaRvu Case Type #108", 58.0, 1680, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-109", new AnesthesiaUnitCode("ANES-OBST-109", "ObstetricAnesthesiaRvu Case Type #109", 58.5, 1695, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-110", new AnesthesiaUnitCode("ANES-OBST-110", "ObstetricAnesthesiaRvu Case Type #110", 59.0, 1710, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-111", new AnesthesiaUnitCode("ANES-OBST-111", "ObstetricAnesthesiaRvu Case Type #111", 59.5, 1725, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-112", new AnesthesiaUnitCode("ANES-OBST-112", "ObstetricAnesthesiaRvu Case Type #112", 60.0, 1740, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-113", new AnesthesiaUnitCode("ANES-OBST-113", "ObstetricAnesthesiaRvu Case Type #113", 60.5, 1755, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-114", new AnesthesiaUnitCode("ANES-OBST-114", "ObstetricAnesthesiaRvu Case Type #114", 61.0, 1770, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-115", new AnesthesiaUnitCode("ANES-OBST-115", "ObstetricAnesthesiaRvu Case Type #115", 61.5, 1785, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-116", new AnesthesiaUnitCode("ANES-OBST-116", "ObstetricAnesthesiaRvu Case Type #116", 62.0, 1800, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-117", new AnesthesiaUnitCode("ANES-OBST-117", "ObstetricAnesthesiaRvu Case Type #117", 62.5, 1815, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-118", new AnesthesiaUnitCode("ANES-OBST-118", "ObstetricAnesthesiaRvu Case Type #118", 63.0, 1830, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-119", new AnesthesiaUnitCode("ANES-OBST-119", "ObstetricAnesthesiaRvu Case Type #119", 63.5, 1845, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-120", new AnesthesiaUnitCode("ANES-OBST-120", "ObstetricAnesthesiaRvu Case Type #120", 64.0, 1860, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-121", new AnesthesiaUnitCode("ANES-OBST-121", "ObstetricAnesthesiaRvu Case Type #121", 64.5, 1875, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-122", new AnesthesiaUnitCode("ANES-OBST-122", "ObstetricAnesthesiaRvu Case Type #122", 65.0, 1890, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-123", new AnesthesiaUnitCode("ANES-OBST-123", "ObstetricAnesthesiaRvu Case Type #123", 65.5, 1905, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-124", new AnesthesiaUnitCode("ANES-OBST-124", "ObstetricAnesthesiaRvu Case Type #124", 66.0, 1920, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-125", new AnesthesiaUnitCode("ANES-OBST-125", "ObstetricAnesthesiaRvu Case Type #125", 66.5, 1935, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-126", new AnesthesiaUnitCode("ANES-OBST-126", "ObstetricAnesthesiaRvu Case Type #126", 67.0, 1950, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-127", new AnesthesiaUnitCode("ANES-OBST-127", "ObstetricAnesthesiaRvu Case Type #127", 67.5, 1965, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-128", new AnesthesiaUnitCode("ANES-OBST-128", "ObstetricAnesthesiaRvu Case Type #128", 68.0, 1980, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-129", new AnesthesiaUnitCode("ANES-OBST-129", "ObstetricAnesthesiaRvu Case Type #129", 68.5, 1995, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-130", new AnesthesiaUnitCode("ANES-OBST-130", "ObstetricAnesthesiaRvu Case Type #130", 69.0, 2010, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-131", new AnesthesiaUnitCode("ANES-OBST-131", "ObstetricAnesthesiaRvu Case Type #131", 69.5, 2025, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-132", new AnesthesiaUnitCode("ANES-OBST-132", "ObstetricAnesthesiaRvu Case Type #132", 70.0, 2040, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-133", new AnesthesiaUnitCode("ANES-OBST-133", "ObstetricAnesthesiaRvu Case Type #133", 70.5, 2055, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-134", new AnesthesiaUnitCode("ANES-OBST-134", "ObstetricAnesthesiaRvu Case Type #134", 71.0, 2070, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-135", new AnesthesiaUnitCode("ANES-OBST-135", "ObstetricAnesthesiaRvu Case Type #135", 71.5, 2085, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-136", new AnesthesiaUnitCode("ANES-OBST-136", "ObstetricAnesthesiaRvu Case Type #136", 72.0, 2100, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-137", new AnesthesiaUnitCode("ANES-OBST-137", "ObstetricAnesthesiaRvu Case Type #137", 72.5, 2115, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-138", new AnesthesiaUnitCode("ANES-OBST-138", "ObstetricAnesthesiaRvu Case Type #138", 73.0, 2130, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-139", new AnesthesiaUnitCode("ANES-OBST-139", "ObstetricAnesthesiaRvu Case Type #139", 73.5, 2145, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-OBST-140", new AnesthesiaUnitCode("ANES-OBST-140", "ObstetricAnesthesiaRvu Case Type #140", 74.0, 2160, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
    }

    public Optional<AnesthesiaUnitCode> getByCode(String code) {
        return Optional.ofNullable(baseUnits.get(code));
    }

    public List<AnesthesiaUnitCode> getAllUnits() {
        return new ArrayList<>(baseUnits.values());
    }
}
