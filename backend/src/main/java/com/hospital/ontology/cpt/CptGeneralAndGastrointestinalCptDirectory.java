package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: Laparoscopy, Colectomy, Bariatric & Endoscopy.
 */
@Component
public class CptGeneralAndGastrointestinalCptDirectory {

    @Data
    @AllArgsConstructor
    public static class CptProcedureCode {
        private String cptCode;
        private String procedureDescriptor;
        private double relativeValueUnitsRvu;
        private int estimatedDurationMinutes;
        private String surgicalTierCategory;
        private boolean isPriorAuthorizationMandatory;
    }

    private final Map<String, CptProcedureCode> procedures = new LinkedHashMap<>();

    public CptGeneralAndGastrointestinalCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("43001", new CptProcedureCode("43001", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43002", new CptProcedureCode("43002", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("43003", new CptProcedureCode("43003", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43004", new CptProcedureCode("43004", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("43005", new CptProcedureCode("43005", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43006", new CptProcedureCode("43006", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("43007", new CptProcedureCode("43007", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43008", new CptProcedureCode("43008", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("43009", new CptProcedureCode("43009", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43010", new CptProcedureCode("43010", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("43011", new CptProcedureCode("43011", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43012", new CptProcedureCode("43012", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("43013", new CptProcedureCode("43013", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43014", new CptProcedureCode("43014", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("43015", new CptProcedureCode("43015", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43016", new CptProcedureCode("43016", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("43017", new CptProcedureCode("43017", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43018", new CptProcedureCode("43018", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("43019", new CptProcedureCode("43019", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43020", new CptProcedureCode("43020", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("43021", new CptProcedureCode("43021", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43022", new CptProcedureCode("43022", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("43023", new CptProcedureCode("43023", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43024", new CptProcedureCode("43024", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("43025", new CptProcedureCode("43025", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43026", new CptProcedureCode("43026", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("43027", new CptProcedureCode("43027", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43028", new CptProcedureCode("43028", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("43029", new CptProcedureCode("43029", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43030", new CptProcedureCode("43030", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("43031", new CptProcedureCode("43031", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43032", new CptProcedureCode("43032", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("43033", new CptProcedureCode("43033", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43034", new CptProcedureCode("43034", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("43035", new CptProcedureCode("43035", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43036", new CptProcedureCode("43036", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("43037", new CptProcedureCode("43037", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43038", new CptProcedureCode("43038", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("43039", new CptProcedureCode("43039", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43040", new CptProcedureCode("43040", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("43041", new CptProcedureCode("43041", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43042", new CptProcedureCode("43042", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("43043", new CptProcedureCode("43043", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43044", new CptProcedureCode("43044", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("43045", new CptProcedureCode("43045", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43046", new CptProcedureCode("43046", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("43047", new CptProcedureCode("43047", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43048", new CptProcedureCode("43048", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("43049", new CptProcedureCode("43049", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43050", new CptProcedureCode("43050", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("43051", new CptProcedureCode("43051", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43052", new CptProcedureCode("43052", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("43053", new CptProcedureCode("43053", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43054", new CptProcedureCode("43054", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("43055", new CptProcedureCode("43055", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43056", new CptProcedureCode("43056", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("43057", new CptProcedureCode("43057", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43058", new CptProcedureCode("43058", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("43059", new CptProcedureCode("43059", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43060", new CptProcedureCode("43060", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("43061", new CptProcedureCode("43061", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43062", new CptProcedureCode("43062", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("43063", new CptProcedureCode("43063", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43064", new CptProcedureCode("43064", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("43065", new CptProcedureCode("43065", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43066", new CptProcedureCode("43066", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("43067", new CptProcedureCode("43067", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43068", new CptProcedureCode("43068", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("43069", new CptProcedureCode("43069", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43070", new CptProcedureCode("43070", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("43071", new CptProcedureCode("43071", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43072", new CptProcedureCode("43072", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("43073", new CptProcedureCode("43073", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43074", new CptProcedureCode("43074", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("43075", new CptProcedureCode("43075", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43076", new CptProcedureCode("43076", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("43077", new CptProcedureCode("43077", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43078", new CptProcedureCode("43078", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("43079", new CptProcedureCode("43079", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43080", new CptProcedureCode("43080", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("43081", new CptProcedureCode("43081", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43082", new CptProcedureCode("43082", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("43083", new CptProcedureCode("43083", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43084", new CptProcedureCode("43084", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("43085", new CptProcedureCode("43085", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43086", new CptProcedureCode("43086", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("43087", new CptProcedureCode("43087", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43088", new CptProcedureCode("43088", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("43089", new CptProcedureCode("43089", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43090", new CptProcedureCode("43090", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("43091", new CptProcedureCode("43091", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43092", new CptProcedureCode("43092", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("43093", new CptProcedureCode("43093", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43094", new CptProcedureCode("43094", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("43095", new CptProcedureCode("43095", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43096", new CptProcedureCode("43096", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("43097", new CptProcedureCode("43097", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43098", new CptProcedureCode("43098", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("43099", new CptProcedureCode("43099", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43100", new CptProcedureCode("43100", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("43101", new CptProcedureCode("43101", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43102", new CptProcedureCode("43102", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("43103", new CptProcedureCode("43103", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43104", new CptProcedureCode("43104", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("43105", new CptProcedureCode("43105", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43106", new CptProcedureCode("43106", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("43107", new CptProcedureCode("43107", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43108", new CptProcedureCode("43108", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("43109", new CptProcedureCode("43109", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43110", new CptProcedureCode("43110", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
        procedures.put("43111", new CptProcedureCode("43111", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #111", 204.80, 5245, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43112", new CptProcedureCode("43112", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #112", 206.60, 5290, "SURGICAL_MAJOR", true));
        procedures.put("43113", new CptProcedureCode("43113", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #113", 208.40, 5335, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43114", new CptProcedureCode("43114", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #114", 210.20, 5380, "SURGICAL_MAJOR", true));
        procedures.put("43115", new CptProcedureCode("43115", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #115", 212.00, 5425, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43116", new CptProcedureCode("43116", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #116", 213.80, 5470, "SURGICAL_MAJOR", true));
        procedures.put("43117", new CptProcedureCode("43117", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #117", 215.60, 5515, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43118", new CptProcedureCode("43118", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #118", 217.40, 5560, "SURGICAL_MAJOR", true));
        procedures.put("43119", new CptProcedureCode("43119", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #119", 219.20, 5605, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("43120", new CptProcedureCode("43120", "Laparoscopy, Colectomy, Bariatric & Endoscopy Procedure #120", 221.00, 5650, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
