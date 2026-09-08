package com.hospital.ontology.anesthesia;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NeurosurgicalAnesthesiaRvuCatalog {

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

    public NeurosurgicalAnesthesiaRvuCatalog() {
        initializeBaseUnits();
    }

    private void initializeBaseUnits() {
        baseUnits.put("ANES-NEUR-001", new AnesthesiaUnitCode("ANES-NEUR-001", "NeurosurgicalAnesthesiaRvu Case Type #1", 4.5, 75, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-002", new AnesthesiaUnitCode("ANES-NEUR-002", "NeurosurgicalAnesthesiaRvu Case Type #2", 5.0, 90, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-003", new AnesthesiaUnitCode("ANES-NEUR-003", "NeurosurgicalAnesthesiaRvu Case Type #3", 5.5, 105, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-004", new AnesthesiaUnitCode("ANES-NEUR-004", "NeurosurgicalAnesthesiaRvu Case Type #4", 6.0, 120, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-005", new AnesthesiaUnitCode("ANES-NEUR-005", "NeurosurgicalAnesthesiaRvu Case Type #5", 6.5, 135, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-006", new AnesthesiaUnitCode("ANES-NEUR-006", "NeurosurgicalAnesthesiaRvu Case Type #6", 7.0, 150, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-007", new AnesthesiaUnitCode("ANES-NEUR-007", "NeurosurgicalAnesthesiaRvu Case Type #7", 7.5, 165, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-008", new AnesthesiaUnitCode("ANES-NEUR-008", "NeurosurgicalAnesthesiaRvu Case Type #8", 8.0, 180, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-009", new AnesthesiaUnitCode("ANES-NEUR-009", "NeurosurgicalAnesthesiaRvu Case Type #9", 8.5, 195, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-010", new AnesthesiaUnitCode("ANES-NEUR-010", "NeurosurgicalAnesthesiaRvu Case Type #10", 9.0, 210, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-011", new AnesthesiaUnitCode("ANES-NEUR-011", "NeurosurgicalAnesthesiaRvu Case Type #11", 9.5, 225, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-012", new AnesthesiaUnitCode("ANES-NEUR-012", "NeurosurgicalAnesthesiaRvu Case Type #12", 10.0, 240, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-013", new AnesthesiaUnitCode("ANES-NEUR-013", "NeurosurgicalAnesthesiaRvu Case Type #13", 10.5, 255, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-014", new AnesthesiaUnitCode("ANES-NEUR-014", "NeurosurgicalAnesthesiaRvu Case Type #14", 11.0, 270, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-015", new AnesthesiaUnitCode("ANES-NEUR-015", "NeurosurgicalAnesthesiaRvu Case Type #15", 11.5, 285, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-016", new AnesthesiaUnitCode("ANES-NEUR-016", "NeurosurgicalAnesthesiaRvu Case Type #16", 12.0, 300, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-017", new AnesthesiaUnitCode("ANES-NEUR-017", "NeurosurgicalAnesthesiaRvu Case Type #17", 12.5, 315, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-018", new AnesthesiaUnitCode("ANES-NEUR-018", "NeurosurgicalAnesthesiaRvu Case Type #18", 13.0, 330, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-019", new AnesthesiaUnitCode("ANES-NEUR-019", "NeurosurgicalAnesthesiaRvu Case Type #19", 13.5, 345, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-020", new AnesthesiaUnitCode("ANES-NEUR-020", "NeurosurgicalAnesthesiaRvu Case Type #20", 14.0, 360, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-021", new AnesthesiaUnitCode("ANES-NEUR-021", "NeurosurgicalAnesthesiaRvu Case Type #21", 14.5, 375, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-022", new AnesthesiaUnitCode("ANES-NEUR-022", "NeurosurgicalAnesthesiaRvu Case Type #22", 15.0, 390, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-023", new AnesthesiaUnitCode("ANES-NEUR-023", "NeurosurgicalAnesthesiaRvu Case Type #23", 15.5, 405, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-024", new AnesthesiaUnitCode("ANES-NEUR-024", "NeurosurgicalAnesthesiaRvu Case Type #24", 16.0, 420, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-025", new AnesthesiaUnitCode("ANES-NEUR-025", "NeurosurgicalAnesthesiaRvu Case Type #25", 16.5, 435, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-026", new AnesthesiaUnitCode("ANES-NEUR-026", "NeurosurgicalAnesthesiaRvu Case Type #26", 17.0, 450, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-027", new AnesthesiaUnitCode("ANES-NEUR-027", "NeurosurgicalAnesthesiaRvu Case Type #27", 17.5, 465, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-028", new AnesthesiaUnitCode("ANES-NEUR-028", "NeurosurgicalAnesthesiaRvu Case Type #28", 18.0, 480, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-029", new AnesthesiaUnitCode("ANES-NEUR-029", "NeurosurgicalAnesthesiaRvu Case Type #29", 18.5, 495, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-030", new AnesthesiaUnitCode("ANES-NEUR-030", "NeurosurgicalAnesthesiaRvu Case Type #30", 19.0, 510, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-031", new AnesthesiaUnitCode("ANES-NEUR-031", "NeurosurgicalAnesthesiaRvu Case Type #31", 19.5, 525, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-032", new AnesthesiaUnitCode("ANES-NEUR-032", "NeurosurgicalAnesthesiaRvu Case Type #32", 20.0, 540, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-033", new AnesthesiaUnitCode("ANES-NEUR-033", "NeurosurgicalAnesthesiaRvu Case Type #33", 20.5, 555, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-034", new AnesthesiaUnitCode("ANES-NEUR-034", "NeurosurgicalAnesthesiaRvu Case Type #34", 21.0, 570, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-035", new AnesthesiaUnitCode("ANES-NEUR-035", "NeurosurgicalAnesthesiaRvu Case Type #35", 21.5, 585, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-036", new AnesthesiaUnitCode("ANES-NEUR-036", "NeurosurgicalAnesthesiaRvu Case Type #36", 22.0, 600, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-037", new AnesthesiaUnitCode("ANES-NEUR-037", "NeurosurgicalAnesthesiaRvu Case Type #37", 22.5, 615, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-038", new AnesthesiaUnitCode("ANES-NEUR-038", "NeurosurgicalAnesthesiaRvu Case Type #38", 23.0, 630, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-039", new AnesthesiaUnitCode("ANES-NEUR-039", "NeurosurgicalAnesthesiaRvu Case Type #39", 23.5, 645, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-040", new AnesthesiaUnitCode("ANES-NEUR-040", "NeurosurgicalAnesthesiaRvu Case Type #40", 24.0, 660, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-041", new AnesthesiaUnitCode("ANES-NEUR-041", "NeurosurgicalAnesthesiaRvu Case Type #41", 24.5, 675, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-042", new AnesthesiaUnitCode("ANES-NEUR-042", "NeurosurgicalAnesthesiaRvu Case Type #42", 25.0, 690, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-043", new AnesthesiaUnitCode("ANES-NEUR-043", "NeurosurgicalAnesthesiaRvu Case Type #43", 25.5, 705, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-044", new AnesthesiaUnitCode("ANES-NEUR-044", "NeurosurgicalAnesthesiaRvu Case Type #44", 26.0, 720, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-045", new AnesthesiaUnitCode("ANES-NEUR-045", "NeurosurgicalAnesthesiaRvu Case Type #45", 26.5, 735, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-046", new AnesthesiaUnitCode("ANES-NEUR-046", "NeurosurgicalAnesthesiaRvu Case Type #46", 27.0, 750, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-047", new AnesthesiaUnitCode("ANES-NEUR-047", "NeurosurgicalAnesthesiaRvu Case Type #47", 27.5, 765, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-048", new AnesthesiaUnitCode("ANES-NEUR-048", "NeurosurgicalAnesthesiaRvu Case Type #48", 28.0, 780, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-049", new AnesthesiaUnitCode("ANES-NEUR-049", "NeurosurgicalAnesthesiaRvu Case Type #49", 28.5, 795, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-050", new AnesthesiaUnitCode("ANES-NEUR-050", "NeurosurgicalAnesthesiaRvu Case Type #50", 29.0, 810, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-051", new AnesthesiaUnitCode("ANES-NEUR-051", "NeurosurgicalAnesthesiaRvu Case Type #51", 29.5, 825, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-052", new AnesthesiaUnitCode("ANES-NEUR-052", "NeurosurgicalAnesthesiaRvu Case Type #52", 30.0, 840, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-053", new AnesthesiaUnitCode("ANES-NEUR-053", "NeurosurgicalAnesthesiaRvu Case Type #53", 30.5, 855, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-054", new AnesthesiaUnitCode("ANES-NEUR-054", "NeurosurgicalAnesthesiaRvu Case Type #54", 31.0, 870, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-055", new AnesthesiaUnitCode("ANES-NEUR-055", "NeurosurgicalAnesthesiaRvu Case Type #55", 31.5, 885, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-056", new AnesthesiaUnitCode("ANES-NEUR-056", "NeurosurgicalAnesthesiaRvu Case Type #56", 32.0, 900, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-057", new AnesthesiaUnitCode("ANES-NEUR-057", "NeurosurgicalAnesthesiaRvu Case Type #57", 32.5, 915, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-058", new AnesthesiaUnitCode("ANES-NEUR-058", "NeurosurgicalAnesthesiaRvu Case Type #58", 33.0, 930, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-059", new AnesthesiaUnitCode("ANES-NEUR-059", "NeurosurgicalAnesthesiaRvu Case Type #59", 33.5, 945, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-060", new AnesthesiaUnitCode("ANES-NEUR-060", "NeurosurgicalAnesthesiaRvu Case Type #60", 34.0, 960, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-061", new AnesthesiaUnitCode("ANES-NEUR-061", "NeurosurgicalAnesthesiaRvu Case Type #61", 34.5, 975, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-062", new AnesthesiaUnitCode("ANES-NEUR-062", "NeurosurgicalAnesthesiaRvu Case Type #62", 35.0, 990, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-063", new AnesthesiaUnitCode("ANES-NEUR-063", "NeurosurgicalAnesthesiaRvu Case Type #63", 35.5, 1005, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-064", new AnesthesiaUnitCode("ANES-NEUR-064", "NeurosurgicalAnesthesiaRvu Case Type #64", 36.0, 1020, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-065", new AnesthesiaUnitCode("ANES-NEUR-065", "NeurosurgicalAnesthesiaRvu Case Type #65", 36.5, 1035, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-066", new AnesthesiaUnitCode("ANES-NEUR-066", "NeurosurgicalAnesthesiaRvu Case Type #66", 37.0, 1050, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-067", new AnesthesiaUnitCode("ANES-NEUR-067", "NeurosurgicalAnesthesiaRvu Case Type #67", 37.5, 1065, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-068", new AnesthesiaUnitCode("ANES-NEUR-068", "NeurosurgicalAnesthesiaRvu Case Type #68", 38.0, 1080, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-069", new AnesthesiaUnitCode("ANES-NEUR-069", "NeurosurgicalAnesthesiaRvu Case Type #69", 38.5, 1095, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-070", new AnesthesiaUnitCode("ANES-NEUR-070", "NeurosurgicalAnesthesiaRvu Case Type #70", 39.0, 1110, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-071", new AnesthesiaUnitCode("ANES-NEUR-071", "NeurosurgicalAnesthesiaRvu Case Type #71", 39.5, 1125, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-072", new AnesthesiaUnitCode("ANES-NEUR-072", "NeurosurgicalAnesthesiaRvu Case Type #72", 40.0, 1140, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-073", new AnesthesiaUnitCode("ANES-NEUR-073", "NeurosurgicalAnesthesiaRvu Case Type #73", 40.5, 1155, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-074", new AnesthesiaUnitCode("ANES-NEUR-074", "NeurosurgicalAnesthesiaRvu Case Type #74", 41.0, 1170, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-075", new AnesthesiaUnitCode("ANES-NEUR-075", "NeurosurgicalAnesthesiaRvu Case Type #75", 41.5, 1185, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-076", new AnesthesiaUnitCode("ANES-NEUR-076", "NeurosurgicalAnesthesiaRvu Case Type #76", 42.0, 1200, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-077", new AnesthesiaUnitCode("ANES-NEUR-077", "NeurosurgicalAnesthesiaRvu Case Type #77", 42.5, 1215, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-078", new AnesthesiaUnitCode("ANES-NEUR-078", "NeurosurgicalAnesthesiaRvu Case Type #78", 43.0, 1230, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-079", new AnesthesiaUnitCode("ANES-NEUR-079", "NeurosurgicalAnesthesiaRvu Case Type #79", 43.5, 1245, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-080", new AnesthesiaUnitCode("ANES-NEUR-080", "NeurosurgicalAnesthesiaRvu Case Type #80", 44.0, 1260, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-081", new AnesthesiaUnitCode("ANES-NEUR-081", "NeurosurgicalAnesthesiaRvu Case Type #81", 44.5, 1275, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-082", new AnesthesiaUnitCode("ANES-NEUR-082", "NeurosurgicalAnesthesiaRvu Case Type #82", 45.0, 1290, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-083", new AnesthesiaUnitCode("ANES-NEUR-083", "NeurosurgicalAnesthesiaRvu Case Type #83", 45.5, 1305, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-084", new AnesthesiaUnitCode("ANES-NEUR-084", "NeurosurgicalAnesthesiaRvu Case Type #84", 46.0, 1320, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-085", new AnesthesiaUnitCode("ANES-NEUR-085", "NeurosurgicalAnesthesiaRvu Case Type #85", 46.5, 1335, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-086", new AnesthesiaUnitCode("ANES-NEUR-086", "NeurosurgicalAnesthesiaRvu Case Type #86", 47.0, 1350, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-087", new AnesthesiaUnitCode("ANES-NEUR-087", "NeurosurgicalAnesthesiaRvu Case Type #87", 47.5, 1365, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-088", new AnesthesiaUnitCode("ANES-NEUR-088", "NeurosurgicalAnesthesiaRvu Case Type #88", 48.0, 1380, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-089", new AnesthesiaUnitCode("ANES-NEUR-089", "NeurosurgicalAnesthesiaRvu Case Type #89", 48.5, 1395, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-090", new AnesthesiaUnitCode("ANES-NEUR-090", "NeurosurgicalAnesthesiaRvu Case Type #90", 49.0, 1410, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-091", new AnesthesiaUnitCode("ANES-NEUR-091", "NeurosurgicalAnesthesiaRvu Case Type #91", 49.5, 1425, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-092", new AnesthesiaUnitCode("ANES-NEUR-092", "NeurosurgicalAnesthesiaRvu Case Type #92", 50.0, 1440, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-093", new AnesthesiaUnitCode("ANES-NEUR-093", "NeurosurgicalAnesthesiaRvu Case Type #93", 50.5, 1455, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-094", new AnesthesiaUnitCode("ANES-NEUR-094", "NeurosurgicalAnesthesiaRvu Case Type #94", 51.0, 1470, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-095", new AnesthesiaUnitCode("ANES-NEUR-095", "NeurosurgicalAnesthesiaRvu Case Type #95", 51.5, 1485, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-096", new AnesthesiaUnitCode("ANES-NEUR-096", "NeurosurgicalAnesthesiaRvu Case Type #96", 52.0, 1500, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-097", new AnesthesiaUnitCode("ANES-NEUR-097", "NeurosurgicalAnesthesiaRvu Case Type #97", 52.5, 1515, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-098", new AnesthesiaUnitCode("ANES-NEUR-098", "NeurosurgicalAnesthesiaRvu Case Type #98", 53.0, 1530, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-099", new AnesthesiaUnitCode("ANES-NEUR-099", "NeurosurgicalAnesthesiaRvu Case Type #99", 53.5, 1545, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-100", new AnesthesiaUnitCode("ANES-NEUR-100", "NeurosurgicalAnesthesiaRvu Case Type #100", 54.0, 1560, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-101", new AnesthesiaUnitCode("ANES-NEUR-101", "NeurosurgicalAnesthesiaRvu Case Type #101", 54.5, 1575, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-102", new AnesthesiaUnitCode("ANES-NEUR-102", "NeurosurgicalAnesthesiaRvu Case Type #102", 55.0, 1590, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-103", new AnesthesiaUnitCode("ANES-NEUR-103", "NeurosurgicalAnesthesiaRvu Case Type #103", 55.5, 1605, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-104", new AnesthesiaUnitCode("ANES-NEUR-104", "NeurosurgicalAnesthesiaRvu Case Type #104", 56.0, 1620, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-105", new AnesthesiaUnitCode("ANES-NEUR-105", "NeurosurgicalAnesthesiaRvu Case Type #105", 56.5, 1635, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-106", new AnesthesiaUnitCode("ANES-NEUR-106", "NeurosurgicalAnesthesiaRvu Case Type #106", 57.0, 1650, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-107", new AnesthesiaUnitCode("ANES-NEUR-107", "NeurosurgicalAnesthesiaRvu Case Type #107", 57.5, 1665, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-108", new AnesthesiaUnitCode("ANES-NEUR-108", "NeurosurgicalAnesthesiaRvu Case Type #108", 58.0, 1680, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-109", new AnesthesiaUnitCode("ANES-NEUR-109", "NeurosurgicalAnesthesiaRvu Case Type #109", 58.5, 1695, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-110", new AnesthesiaUnitCode("ANES-NEUR-110", "NeurosurgicalAnesthesiaRvu Case Type #110", 59.0, 1710, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-111", new AnesthesiaUnitCode("ANES-NEUR-111", "NeurosurgicalAnesthesiaRvu Case Type #111", 59.5, 1725, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-112", new AnesthesiaUnitCode("ANES-NEUR-112", "NeurosurgicalAnesthesiaRvu Case Type #112", 60.0, 1740, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-113", new AnesthesiaUnitCode("ANES-NEUR-113", "NeurosurgicalAnesthesiaRvu Case Type #113", 60.5, 1755, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-114", new AnesthesiaUnitCode("ANES-NEUR-114", "NeurosurgicalAnesthesiaRvu Case Type #114", 61.0, 1770, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-115", new AnesthesiaUnitCode("ANES-NEUR-115", "NeurosurgicalAnesthesiaRvu Case Type #115", 61.5, 1785, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-116", new AnesthesiaUnitCode("ANES-NEUR-116", "NeurosurgicalAnesthesiaRvu Case Type #116", 62.0, 1800, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-117", new AnesthesiaUnitCode("ANES-NEUR-117", "NeurosurgicalAnesthesiaRvu Case Type #117", 62.5, 1815, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-118", new AnesthesiaUnitCode("ANES-NEUR-118", "NeurosurgicalAnesthesiaRvu Case Type #118", 63.0, 1830, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-119", new AnesthesiaUnitCode("ANES-NEUR-119", "NeurosurgicalAnesthesiaRvu Case Type #119", 63.5, 1845, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-120", new AnesthesiaUnitCode("ANES-NEUR-120", "NeurosurgicalAnesthesiaRvu Case Type #120", 64.0, 1860, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-121", new AnesthesiaUnitCode("ANES-NEUR-121", "NeurosurgicalAnesthesiaRvu Case Type #121", 64.5, 1875, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-122", new AnesthesiaUnitCode("ANES-NEUR-122", "NeurosurgicalAnesthesiaRvu Case Type #122", 65.0, 1890, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-123", new AnesthesiaUnitCode("ANES-NEUR-123", "NeurosurgicalAnesthesiaRvu Case Type #123", 65.5, 1905, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-124", new AnesthesiaUnitCode("ANES-NEUR-124", "NeurosurgicalAnesthesiaRvu Case Type #124", 66.0, 1920, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-125", new AnesthesiaUnitCode("ANES-NEUR-125", "NeurosurgicalAnesthesiaRvu Case Type #125", 66.5, 1935, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-126", new AnesthesiaUnitCode("ANES-NEUR-126", "NeurosurgicalAnesthesiaRvu Case Type #126", 67.0, 1950, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-127", new AnesthesiaUnitCode("ANES-NEUR-127", "NeurosurgicalAnesthesiaRvu Case Type #127", 67.5, 1965, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-128", new AnesthesiaUnitCode("ANES-NEUR-128", "NeurosurgicalAnesthesiaRvu Case Type #128", 68.0, 1980, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-129", new AnesthesiaUnitCode("ANES-NEUR-129", "NeurosurgicalAnesthesiaRvu Case Type #129", 68.5, 1995, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-130", new AnesthesiaUnitCode("ANES-NEUR-130", "NeurosurgicalAnesthesiaRvu Case Type #130", 69.0, 2010, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-131", new AnesthesiaUnitCode("ANES-NEUR-131", "NeurosurgicalAnesthesiaRvu Case Type #131", 69.5, 2025, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-132", new AnesthesiaUnitCode("ANES-NEUR-132", "NeurosurgicalAnesthesiaRvu Case Type #132", 70.0, 2040, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-133", new AnesthesiaUnitCode("ANES-NEUR-133", "NeurosurgicalAnesthesiaRvu Case Type #133", 70.5, 2055, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-134", new AnesthesiaUnitCode("ANES-NEUR-134", "NeurosurgicalAnesthesiaRvu Case Type #134", 71.0, 2070, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-135", new AnesthesiaUnitCode("ANES-NEUR-135", "NeurosurgicalAnesthesiaRvu Case Type #135", 71.5, 2085, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-136", new AnesthesiaUnitCode("ANES-NEUR-136", "NeurosurgicalAnesthesiaRvu Case Type #136", 72.0, 2100, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-137", new AnesthesiaUnitCode("ANES-NEUR-137", "NeurosurgicalAnesthesiaRvu Case Type #137", 72.5, 2115, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-138", new AnesthesiaUnitCode("ANES-NEUR-138", "NeurosurgicalAnesthesiaRvu Case Type #138", 73.0, 2130, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-139", new AnesthesiaUnitCode("ANES-NEUR-139", "NeurosurgicalAnesthesiaRvu Case Type #139", 73.5, 2145, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
        baseUnits.put("ANES-NEUR-140", new AnesthesiaUnitCode("ANES-NEUR-140", "NeurosurgicalAnesthesiaRvu Case Type #140", 74.0, 2160, "Complex monitored anesthesia care (MAC) / General Endotracheal."));
    }

    public Optional<AnesthesiaUnitCode> getByCode(String code) {
        return Optional.ofNullable(baseUnits.get(code));
    }

    public List<AnesthesiaUnitCode> getAllUnits() {
        return new ArrayList<>(baseUnits.values());
    }
}
