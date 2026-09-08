package com.hospital.ontology.anesthesia;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CardiothoracicAnesthesiaRvuCatalog {

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

    public CardiothoracicAnesthesiaRvuCatalog() {
        initializeBaseUnits();
    }

    private void initializeBaseUnits() {
        baseUnits.put("ANES-CARD-001", new AnesthesiaUnitCode("ANES-CARD-001", "CardiothoracicAnesthesiaRvu Case Type #1", 4.5, 75, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-002", new AnesthesiaUnitCode("ANES-CARD-002", "CardiothoracicAnesthesiaRvu Case Type #2", 5.0, 90, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-003", new AnesthesiaUnitCode("ANES-CARD-003", "CardiothoracicAnesthesiaRvu Case Type #3", 5.5, 105, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-004", new AnesthesiaUnitCode("ANES-CARD-004", "CardiothoracicAnesthesiaRvu Case Type #4", 6.0, 120, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-005", new AnesthesiaUnitCode("ANES-CARD-005", "CardiothoracicAnesthesiaRvu Case Type #5", 6.5, 135, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-006", new AnesthesiaUnitCode("ANES-CARD-006", "CardiothoracicAnesthesiaRvu Case Type #6", 7.0, 150, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-007", new AnesthesiaUnitCode("ANES-CARD-007", "CardiothoracicAnesthesiaRvu Case Type #7", 7.5, 165, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-008", new AnesthesiaUnitCode("ANES-CARD-008", "CardiothoracicAnesthesiaRvu Case Type #8", 8.0, 180, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-009", new AnesthesiaUnitCode("ANES-CARD-009", "CardiothoracicAnesthesiaRvu Case Type #9", 8.5, 195, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-010", new AnesthesiaUnitCode("ANES-CARD-010", "CardiothoracicAnesthesiaRvu Case Type #10", 9.0, 210, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-011", new AnesthesiaUnitCode("ANES-CARD-011", "CardiothoracicAnesthesiaRvu Case Type #11", 9.5, 225, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-012", new AnesthesiaUnitCode("ANES-CARD-012", "CardiothoracicAnesthesiaRvu Case Type #12", 10.0, 240, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-013", new AnesthesiaUnitCode("ANES-CARD-013", "CardiothoracicAnesthesiaRvu Case Type #13", 10.5, 255, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-014", new AnesthesiaUnitCode("ANES-CARD-014", "CardiothoracicAnesthesiaRvu Case Type #14", 11.0, 270, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-015", new AnesthesiaUnitCode("ANES-CARD-015", "CardiothoracicAnesthesiaRvu Case Type #15", 11.5, 285, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-016", new AnesthesiaUnitCode("ANES-CARD-016", "CardiothoracicAnesthesiaRvu Case Type #16", 12.0, 300, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-017", new AnesthesiaUnitCode("ANES-CARD-017", "CardiothoracicAnesthesiaRvu Case Type #17", 12.5, 315, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-018", new AnesthesiaUnitCode("ANES-CARD-018", "CardiothoracicAnesthesiaRvu Case Type #18", 13.0, 330, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-019", new AnesthesiaUnitCode("ANES-CARD-019", "CardiothoracicAnesthesiaRvu Case Type #19", 13.5, 345, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-020", new AnesthesiaUnitCode("ANES-CARD-020", "CardiothoracicAnesthesiaRvu Case Type #20", 14.0, 360, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-021", new AnesthesiaUnitCode("ANES-CARD-021", "CardiothoracicAnesthesiaRvu Case Type #21", 14.5, 375, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-022", new AnesthesiaUnitCode("ANES-CARD-022", "CardiothoracicAnesthesiaRvu Case Type #22", 15.0, 390, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-023", new AnesthesiaUnitCode("ANES-CARD-023", "CardiothoracicAnesthesiaRvu Case Type #23", 15.5, 405, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-024", new AnesthesiaUnitCode("ANES-CARD-024", "CardiothoracicAnesthesiaRvu Case Type #24", 16.0, 420, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-025", new AnesthesiaUnitCode("ANES-CARD-025", "CardiothoracicAnesthesiaRvu Case Type #25", 16.5, 435, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-026", new AnesthesiaUnitCode("ANES-CARD-026", "CardiothoracicAnesthesiaRvu Case Type #26", 17.0, 450, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-027", new AnesthesiaUnitCode("ANES-CARD-027", "CardiothoracicAnesthesiaRvu Case Type #27", 17.5, 465, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-028", new AnesthesiaUnitCode("ANES-CARD-028", "CardiothoracicAnesthesiaRvu Case Type #28", 18.0, 480, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-029", new AnesthesiaUnitCode("ANES-CARD-029", "CardiothoracicAnesthesiaRvu Case Type #29", 18.5, 495, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-030", new AnesthesiaUnitCode("ANES-CARD-030", "CardiothoracicAnesthesiaRvu Case Type #30", 19.0, 510, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-031", new AnesthesiaUnitCode("ANES-CARD-031", "CardiothoracicAnesthesiaRvu Case Type #31", 19.5, 525, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-032", new AnesthesiaUnitCode("ANES-CARD-032", "CardiothoracicAnesthesiaRvu Case Type #32", 20.0, 540, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-033", new AnesthesiaUnitCode("ANES-CARD-033", "CardiothoracicAnesthesiaRvu Case Type #33", 20.5, 555, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-034", new AnesthesiaUnitCode("ANES-CARD-034", "CardiothoracicAnesthesiaRvu Case Type #34", 21.0, 570, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-035", new AnesthesiaUnitCode("ANES-CARD-035", "CardiothoracicAnesthesiaRvu Case Type #35", 21.5, 585, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-036", new AnesthesiaUnitCode("ANES-CARD-036", "CardiothoracicAnesthesiaRvu Case Type #36", 22.0, 600, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-037", new AnesthesiaUnitCode("ANES-CARD-037", "CardiothoracicAnesthesiaRvu Case Type #37", 22.5, 615, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-038", new AnesthesiaUnitCode("ANES-CARD-038", "CardiothoracicAnesthesiaRvu Case Type #38", 23.0, 630, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-039", new AnesthesiaUnitCode("ANES-CARD-039", "CardiothoracicAnesthesiaRvu Case Type #39", 23.5, 645, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-040", new AnesthesiaUnitCode("ANES-CARD-040", "CardiothoracicAnesthesiaRvu Case Type #40", 24.0, 660, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-041", new AnesthesiaUnitCode("ANES-CARD-041", "CardiothoracicAnesthesiaRvu Case Type #41", 24.5, 675, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-042", new AnesthesiaUnitCode("ANES-CARD-042", "CardiothoracicAnesthesiaRvu Case Type #42", 25.0, 690, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-043", new AnesthesiaUnitCode("ANES-CARD-043", "CardiothoracicAnesthesiaRvu Case Type #43", 25.5, 705, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-044", new AnesthesiaUnitCode("ANES-CARD-044", "CardiothoracicAnesthesiaRvu Case Type #44", 26.0, 720, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-045", new AnesthesiaUnitCode("ANES-CARD-045", "CardiothoracicAnesthesiaRvu Case Type #45", 26.5, 735, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-046", new AnesthesiaUnitCode("ANES-CARD-046", "CardiothoracicAnesthesiaRvu Case Type #46", 27.0, 750, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-047", new AnesthesiaUnitCode("ANES-CARD-047", "CardiothoracicAnesthesiaRvu Case Type #47", 27.5, 765, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-048", new AnesthesiaUnitCode("ANES-CARD-048", "CardiothoracicAnesthesiaRvu Case Type #48", 28.0, 780, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-049", new AnesthesiaUnitCode("ANES-CARD-049", "CardiothoracicAnesthesiaRvu Case Type #49", 28.5, 795, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-050", new AnesthesiaUnitCode("ANES-CARD-050", "CardiothoracicAnesthesiaRvu Case Type #50", 29.0, 810, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-051", new AnesthesiaUnitCode("ANES-CARD-051", "CardiothoracicAnesthesiaRvu Case Type #51", 29.5, 825, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-052", new AnesthesiaUnitCode("ANES-CARD-052", "CardiothoracicAnesthesiaRvu Case Type #52", 30.0, 840, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-053", new AnesthesiaUnitCode("ANES-CARD-053", "CardiothoracicAnesthesiaRvu Case Type #53", 30.5, 855, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-054", new AnesthesiaUnitCode("ANES-CARD-054", "CardiothoracicAnesthesiaRvu Case Type #54", 31.0, 870, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-055", new AnesthesiaUnitCode("ANES-CARD-055", "CardiothoracicAnesthesiaRvu Case Type #55", 31.5, 885, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-056", new AnesthesiaUnitCode("ANES-CARD-056", "CardiothoracicAnesthesiaRvu Case Type #56", 32.0, 900, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-057", new AnesthesiaUnitCode("ANES-CARD-057", "CardiothoracicAnesthesiaRvu Case Type #57", 32.5, 915, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-058", new AnesthesiaUnitCode("ANES-CARD-058", "CardiothoracicAnesthesiaRvu Case Type #58", 33.0, 930, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-059", new AnesthesiaUnitCode("ANES-CARD-059", "CardiothoracicAnesthesiaRvu Case Type #59", 33.5, 945, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-060", new AnesthesiaUnitCode("ANES-CARD-060", "CardiothoracicAnesthesiaRvu Case Type #60", 34.0, 960, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-061", new AnesthesiaUnitCode("ANES-CARD-061", "CardiothoracicAnesthesiaRvu Case Type #61", 34.5, 975, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-062", new AnesthesiaUnitCode("ANES-CARD-062", "CardiothoracicAnesthesiaRvu Case Type #62", 35.0, 990, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-063", new AnesthesiaUnitCode("ANES-CARD-063", "CardiothoracicAnesthesiaRvu Case Type #63", 35.5, 1005, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-064", new AnesthesiaUnitCode("ANES-CARD-064", "CardiothoracicAnesthesiaRvu Case Type #64", 36.0, 1020, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-065", new AnesthesiaUnitCode("ANES-CARD-065", "CardiothoracicAnesthesiaRvu Case Type #65", 36.5, 1035, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-066", new AnesthesiaUnitCode("ANES-CARD-066", "CardiothoracicAnesthesiaRvu Case Type #66", 37.0, 1050, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-067", new AnesthesiaUnitCode("ANES-CARD-067", "CardiothoracicAnesthesiaRvu Case Type #67", 37.5, 1065, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-068", new AnesthesiaUnitCode("ANES-CARD-068", "CardiothoracicAnesthesiaRvu Case Type #68", 38.0, 1080, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-069", new AnesthesiaUnitCode("ANES-CARD-069", "CardiothoracicAnesthesiaRvu Case Type #69", 38.5, 1095, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-070", new AnesthesiaUnitCode("ANES-CARD-070", "CardiothoracicAnesthesiaRvu Case Type #70", 39.0, 1110, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-071", new AnesthesiaUnitCode("ANES-CARD-071", "CardiothoracicAnesthesiaRvu Case Type #71", 39.5, 1125, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-072", new AnesthesiaUnitCode("ANES-CARD-072", "CardiothoracicAnesthesiaRvu Case Type #72", 40.0, 1140, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-073", new AnesthesiaUnitCode("ANES-CARD-073", "CardiothoracicAnesthesiaRvu Case Type #73", 40.5, 1155, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-074", new AnesthesiaUnitCode("ANES-CARD-074", "CardiothoracicAnesthesiaRvu Case Type #74", 41.0, 1170, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-075", new AnesthesiaUnitCode("ANES-CARD-075", "CardiothoracicAnesthesiaRvu Case Type #75", 41.5, 1185, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-076", new AnesthesiaUnitCode("ANES-CARD-076", "CardiothoracicAnesthesiaRvu Case Type #76", 42.0, 1200, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-077", new AnesthesiaUnitCode("ANES-CARD-077", "CardiothoracicAnesthesiaRvu Case Type #77", 42.5, 1215, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-078", new AnesthesiaUnitCode("ANES-CARD-078", "CardiothoracicAnesthesiaRvu Case Type #78", 43.0, 1230, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-079", new AnesthesiaUnitCode("ANES-CARD-079", "CardiothoracicAnesthesiaRvu Case Type #79", 43.5, 1245, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-080", new AnesthesiaUnitCode("ANES-CARD-080", "CardiothoracicAnesthesiaRvu Case Type #80", 44.0, 1260, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-081", new AnesthesiaUnitCode("ANES-CARD-081", "CardiothoracicAnesthesiaRvu Case Type #81", 44.5, 1275, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-082", new AnesthesiaUnitCode("ANES-CARD-082", "CardiothoracicAnesthesiaRvu Case Type #82", 45.0, 1290, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-083", new AnesthesiaUnitCode("ANES-CARD-083", "CardiothoracicAnesthesiaRvu Case Type #83", 45.5, 1305, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-084", new AnesthesiaUnitCode("ANES-CARD-084", "CardiothoracicAnesthesiaRvu Case Type #84", 46.0, 1320, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-085", new AnesthesiaUnitCode("ANES-CARD-085", "CardiothoracicAnesthesiaRvu Case Type #85", 46.5, 1335, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-086", new AnesthesiaUnitCode("ANES-CARD-086", "CardiothoracicAnesthesiaRvu Case Type #86", 47.0, 1350, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-087", new AnesthesiaUnitCode("ANES-CARD-087", "CardiothoracicAnesthesiaRvu Case Type #87", 47.5, 1365, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-088", new AnesthesiaUnitCode("ANES-CARD-088", "CardiothoracicAnesthesiaRvu Case Type #88", 48.0, 1380, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-089", new AnesthesiaUnitCode("ANES-CARD-089", "CardiothoracicAnesthesiaRvu Case Type #89", 48.5, 1395, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-090", new AnesthesiaUnitCode("ANES-CARD-090", "CardiothoracicAnesthesiaRvu Case Type #90", 49.0, 1410, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-091", new AnesthesiaUnitCode("ANES-CARD-091", "CardiothoracicAnesthesiaRvu Case Type #91", 49.5, 1425, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-092", new AnesthesiaUnitCode("ANES-CARD-092", "CardiothoracicAnesthesiaRvu Case Type #92", 50.0, 1440, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-093", new AnesthesiaUnitCode("ANES-CARD-093", "CardiothoracicAnesthesiaRvu Case Type #93", 50.5, 1455, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-094", new AnesthesiaUnitCode("ANES-CARD-094", "CardiothoracicAnesthesiaRvu Case Type #94", 51.0, 1470, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-095", new AnesthesiaUnitCode("ANES-CARD-095", "CardiothoracicAnesthesiaRvu Case Type #95", 51.5, 1485, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-096", new AnesthesiaUnitCode("ANES-CARD-096", "CardiothoracicAnesthesiaRvu Case Type #96", 52.0, 1500, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-097", new AnesthesiaUnitCode("ANES-CARD-097", "CardiothoracicAnesthesiaRvu Case Type #97", 52.5, 1515, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-098", new AnesthesiaUnitCode("ANES-CARD-098", "CardiothoracicAnesthesiaRvu Case Type #98", 53.0, 1530, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-099", new AnesthesiaUnitCode("ANES-CARD-099", "CardiothoracicAnesthesiaRvu Case Type #99", 53.5, 1545, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-100", new AnesthesiaUnitCode("ANES-CARD-100", "CardiothoracicAnesthesiaRvu Case Type #100", 54.0, 1560, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-101", new AnesthesiaUnitCode("ANES-CARD-101", "CardiothoracicAnesthesiaRvu Case Type #101", 54.5, 1575, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-102", new AnesthesiaUnitCode("ANES-CARD-102", "CardiothoracicAnesthesiaRvu Case Type #102", 55.0, 1590, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-103", new AnesthesiaUnitCode("ANES-CARD-103", "CardiothoracicAnesthesiaRvu Case Type #103", 55.5, 1605, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-104", new AnesthesiaUnitCode("ANES-CARD-104", "CardiothoracicAnesthesiaRvu Case Type #104", 56.0, 1620, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-105", new AnesthesiaUnitCode("ANES-CARD-105", "CardiothoracicAnesthesiaRvu Case Type #105", 56.5, 1635, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-106", new AnesthesiaUnitCode("ANES-CARD-106", "CardiothoracicAnesthesiaRvu Case Type #106", 57.0, 1650, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-107", new AnesthesiaUnitCode("ANES-CARD-107", "CardiothoracicAnesthesiaRvu Case Type #107", 57.5, 1665, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-108", new AnesthesiaUnitCode("ANES-CARD-108", "CardiothoracicAnesthesiaRvu Case Type #108", 58.0, 1680, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-109", new AnesthesiaUnitCode("ANES-CARD-109", "CardiothoracicAnesthesiaRvu Case Type #109", 58.5, 1695, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-110", new AnesthesiaUnitCode("ANES-CARD-110", "CardiothoracicAnesthesiaRvu Case Type #110", 59.0, 1710, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-111", new AnesthesiaUnitCode("ANES-CARD-111", "CardiothoracicAnesthesiaRvu Case Type #111", 59.5, 1725, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-112", new AnesthesiaUnitCode("ANES-CARD-112", "CardiothoracicAnesthesiaRvu Case Type #112", 60.0, 1740, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-113", new AnesthesiaUnitCode("ANES-CARD-113", "CardiothoracicAnesthesiaRvu Case Type #113", 60.5, 1755, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-114", new AnesthesiaUnitCode("ANES-CARD-114", "CardiothoracicAnesthesiaRvu Case Type #114", 61.0, 1770, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-115", new AnesthesiaUnitCode("ANES-CARD-115", "CardiothoracicAnesthesiaRvu Case Type #115", 61.5, 1785, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-116", new AnesthesiaUnitCode("ANES-CARD-116", "CardiothoracicAnesthesiaRvu Case Type #116", 62.0, 1800, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-117", new AnesthesiaUnitCode("ANES-CARD-117", "CardiothoracicAnesthesiaRvu Case Type #117", 62.5, 1815, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-118", new AnesthesiaUnitCode("ANES-CARD-118", "CardiothoracicAnesthesiaRvu Case Type #118", 63.0, 1830, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-119", new AnesthesiaUnitCode("ANES-CARD-119", "CardiothoracicAnesthesiaRvu Case Type #119", 63.5, 1845, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-120", new AnesthesiaUnitCode("ANES-CARD-120", "CardiothoracicAnesthesiaRvu Case Type #120", 64.0, 1860, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-121", new AnesthesiaUnitCode("ANES-CARD-121", "CardiothoracicAnesthesiaRvu Case Type #121", 64.5, 1875, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-122", new AnesthesiaUnitCode("ANES-CARD-122", "CardiothoracicAnesthesiaRvu Case Type #122", 65.0, 1890, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-123", new AnesthesiaUnitCode("ANES-CARD-123", "CardiothoracicAnesthesiaRvu Case Type #123", 65.5, 1905, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-124", new AnesthesiaUnitCode("ANES-CARD-124", "CardiothoracicAnesthesiaRvu Case Type #124", 66.0, 1920, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-125", new AnesthesiaUnitCode("ANES-CARD-125", "CardiothoracicAnesthesiaRvu Case Type #125", 66.5, 1935, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-126", new AnesthesiaUnitCode("ANES-CARD-126", "CardiothoracicAnesthesiaRvu Case Type #126", 67.0, 1950, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-127", new AnesthesiaUnitCode("ANES-CARD-127", "CardiothoracicAnesthesiaRvu Case Type #127", 67.5, 1965, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-128", new AnesthesiaUnitCode("ANES-CARD-128", "CardiothoracicAnesthesiaRvu Case Type #128", 68.0, 1980, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-129", new AnesthesiaUnitCode("ANES-CARD-129", "CardiothoracicAnesthesiaRvu Case Type #129", 68.5, 1995, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-130", new AnesthesiaUnitCode("ANES-CARD-130", "CardiothoracicAnesthesiaRvu Case Type #130", 69.0, 2010, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-131", new AnesthesiaUnitCode("ANES-CARD-131", "CardiothoracicAnesthesiaRvu Case Type #131", 69.5, 2025, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-132", new AnesthesiaUnitCode("ANES-CARD-132", "CardiothoracicAnesthesiaRvu Case Type #132", 70.0, 2040, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-133", new AnesthesiaUnitCode("ANES-CARD-133", "CardiothoracicAnesthesiaRvu Case Type #133", 70.5, 2055, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-134", new AnesthesiaUnitCode("ANES-CARD-134", "CardiothoracicAnesthesiaRvu Case Type #134", 71.0, 2070, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-135", new AnesthesiaUnitCode("ANES-CARD-135", "CardiothoracicAnesthesiaRvu Case Type #135", 71.5, 2085, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-136", new AnesthesiaUnitCode("ANES-CARD-136", "CardiothoracicAnesthesiaRvu Case Type #136", 72.0, 2100, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-137", new AnesthesiaUnitCode("ANES-CARD-137", "CardiothoracicAnesthesiaRvu Case Type #137", 72.5, 2115, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-138", new AnesthesiaUnitCode("ANES-CARD-138", "CardiothoracicAnesthesiaRvu Case Type #138", 73.0, 2130, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-139", new AnesthesiaUnitCode("ANES-CARD-139", "CardiothoracicAnesthesiaRvu Case Type #139", 73.5, 2145, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-CARD-140", new AnesthesiaUnitCode("ANES-CARD-140", "CardiothoracicAnesthesiaRvu Case Type #140", 74.0, 2160, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
    }

    public Optional<AnesthesiaUnitCode> getByCode(String code) {
        return Optional.ofNullable(baseUnits.get(code));
    }

    public List<AnesthesiaUnitCode> getAllUnits() {
        return new ArrayList<>(baseUnits.values());
    }
}
