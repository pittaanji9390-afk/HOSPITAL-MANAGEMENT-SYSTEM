package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: Interventional Cardiology, CABG & Pacemaker Implantation.
 */
@Component
public class CptCardiovascularSurgicalCptDirectory {

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

    public CptCardiovascularSurgicalCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("33001", new CptProcedureCode("33001", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33002", new CptProcedureCode("33002", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("33003", new CptProcedureCode("33003", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33004", new CptProcedureCode("33004", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("33005", new CptProcedureCode("33005", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33006", new CptProcedureCode("33006", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("33007", new CptProcedureCode("33007", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33008", new CptProcedureCode("33008", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("33009", new CptProcedureCode("33009", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33010", new CptProcedureCode("33010", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("33011", new CptProcedureCode("33011", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33012", new CptProcedureCode("33012", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("33013", new CptProcedureCode("33013", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33014", new CptProcedureCode("33014", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("33015", new CptProcedureCode("33015", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33016", new CptProcedureCode("33016", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("33017", new CptProcedureCode("33017", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33018", new CptProcedureCode("33018", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("33019", new CptProcedureCode("33019", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33020", new CptProcedureCode("33020", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("33021", new CptProcedureCode("33021", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33022", new CptProcedureCode("33022", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("33023", new CptProcedureCode("33023", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33024", new CptProcedureCode("33024", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("33025", new CptProcedureCode("33025", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33026", new CptProcedureCode("33026", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("33027", new CptProcedureCode("33027", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33028", new CptProcedureCode("33028", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("33029", new CptProcedureCode("33029", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33030", new CptProcedureCode("33030", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("33031", new CptProcedureCode("33031", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33032", new CptProcedureCode("33032", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("33033", new CptProcedureCode("33033", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33034", new CptProcedureCode("33034", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("33035", new CptProcedureCode("33035", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33036", new CptProcedureCode("33036", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("33037", new CptProcedureCode("33037", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33038", new CptProcedureCode("33038", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("33039", new CptProcedureCode("33039", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33040", new CptProcedureCode("33040", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("33041", new CptProcedureCode("33041", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33042", new CptProcedureCode("33042", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("33043", new CptProcedureCode("33043", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33044", new CptProcedureCode("33044", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("33045", new CptProcedureCode("33045", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33046", new CptProcedureCode("33046", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("33047", new CptProcedureCode("33047", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33048", new CptProcedureCode("33048", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("33049", new CptProcedureCode("33049", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33050", new CptProcedureCode("33050", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("33051", new CptProcedureCode("33051", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33052", new CptProcedureCode("33052", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("33053", new CptProcedureCode("33053", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33054", new CptProcedureCode("33054", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("33055", new CptProcedureCode("33055", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33056", new CptProcedureCode("33056", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("33057", new CptProcedureCode("33057", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33058", new CptProcedureCode("33058", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("33059", new CptProcedureCode("33059", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33060", new CptProcedureCode("33060", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("33061", new CptProcedureCode("33061", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33062", new CptProcedureCode("33062", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("33063", new CptProcedureCode("33063", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33064", new CptProcedureCode("33064", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("33065", new CptProcedureCode("33065", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33066", new CptProcedureCode("33066", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("33067", new CptProcedureCode("33067", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33068", new CptProcedureCode("33068", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("33069", new CptProcedureCode("33069", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33070", new CptProcedureCode("33070", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("33071", new CptProcedureCode("33071", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33072", new CptProcedureCode("33072", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("33073", new CptProcedureCode("33073", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33074", new CptProcedureCode("33074", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("33075", new CptProcedureCode("33075", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33076", new CptProcedureCode("33076", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("33077", new CptProcedureCode("33077", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33078", new CptProcedureCode("33078", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("33079", new CptProcedureCode("33079", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33080", new CptProcedureCode("33080", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("33081", new CptProcedureCode("33081", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33082", new CptProcedureCode("33082", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("33083", new CptProcedureCode("33083", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33084", new CptProcedureCode("33084", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("33085", new CptProcedureCode("33085", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33086", new CptProcedureCode("33086", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("33087", new CptProcedureCode("33087", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33088", new CptProcedureCode("33088", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("33089", new CptProcedureCode("33089", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33090", new CptProcedureCode("33090", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("33091", new CptProcedureCode("33091", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33092", new CptProcedureCode("33092", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("33093", new CptProcedureCode("33093", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33094", new CptProcedureCode("33094", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("33095", new CptProcedureCode("33095", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33096", new CptProcedureCode("33096", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("33097", new CptProcedureCode("33097", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33098", new CptProcedureCode("33098", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("33099", new CptProcedureCode("33099", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33100", new CptProcedureCode("33100", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("33101", new CptProcedureCode("33101", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33102", new CptProcedureCode("33102", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("33103", new CptProcedureCode("33103", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33104", new CptProcedureCode("33104", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("33105", new CptProcedureCode("33105", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33106", new CptProcedureCode("33106", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("33107", new CptProcedureCode("33107", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33108", new CptProcedureCode("33108", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("33109", new CptProcedureCode("33109", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33110", new CptProcedureCode("33110", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
        procedures.put("33111", new CptProcedureCode("33111", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #111", 204.80, 5245, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33112", new CptProcedureCode("33112", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #112", 206.60, 5290, "SURGICAL_MAJOR", true));
        procedures.put("33113", new CptProcedureCode("33113", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #113", 208.40, 5335, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33114", new CptProcedureCode("33114", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #114", 210.20, 5380, "SURGICAL_MAJOR", true));
        procedures.put("33115", new CptProcedureCode("33115", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #115", 212.00, 5425, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33116", new CptProcedureCode("33116", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #116", 213.80, 5470, "SURGICAL_MAJOR", true));
        procedures.put("33117", new CptProcedureCode("33117", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #117", 215.60, 5515, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33118", new CptProcedureCode("33118", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #118", 217.40, 5560, "SURGICAL_MAJOR", true));
        procedures.put("33119", new CptProcedureCode("33119", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #119", 219.20, 5605, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("33120", new CptProcedureCode("33120", "Interventional Cardiology, CABG & Pacemaker Implantation Procedure #120", 221.00, 5650, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
