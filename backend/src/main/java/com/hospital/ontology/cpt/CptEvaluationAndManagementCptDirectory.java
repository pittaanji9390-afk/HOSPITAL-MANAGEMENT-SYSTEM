package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: E/M Codes: Outpatient, Inpatient, ICU & Emergency.
 */
@Component
public class CptEvaluationAndManagementCptDirectory {

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

    public CptEvaluationAndManagementCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("99201", new CptProcedureCode("99201", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99202", new CptProcedureCode("99202", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("99203", new CptProcedureCode("99203", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99204", new CptProcedureCode("99204", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("99205", new CptProcedureCode("99205", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99206", new CptProcedureCode("99206", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("99207", new CptProcedureCode("99207", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99208", new CptProcedureCode("99208", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("99209", new CptProcedureCode("99209", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99210", new CptProcedureCode("99210", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("99211", new CptProcedureCode("99211", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99212", new CptProcedureCode("99212", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("99213", new CptProcedureCode("99213", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99214", new CptProcedureCode("99214", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("99215", new CptProcedureCode("99215", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99216", new CptProcedureCode("99216", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("99217", new CptProcedureCode("99217", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99218", new CptProcedureCode("99218", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("99219", new CptProcedureCode("99219", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99220", new CptProcedureCode("99220", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("99221", new CptProcedureCode("99221", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99222", new CptProcedureCode("99222", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("99223", new CptProcedureCode("99223", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99224", new CptProcedureCode("99224", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("99225", new CptProcedureCode("99225", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99226", new CptProcedureCode("99226", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("99227", new CptProcedureCode("99227", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99228", new CptProcedureCode("99228", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("99229", new CptProcedureCode("99229", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99230", new CptProcedureCode("99230", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("99231", new CptProcedureCode("99231", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99232", new CptProcedureCode("99232", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("99233", new CptProcedureCode("99233", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99234", new CptProcedureCode("99234", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("99235", new CptProcedureCode("99235", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99236", new CptProcedureCode("99236", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("99237", new CptProcedureCode("99237", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99238", new CptProcedureCode("99238", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("99239", new CptProcedureCode("99239", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99240", new CptProcedureCode("99240", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("99241", new CptProcedureCode("99241", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99242", new CptProcedureCode("99242", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("99243", new CptProcedureCode("99243", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99244", new CptProcedureCode("99244", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("99245", new CptProcedureCode("99245", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99246", new CptProcedureCode("99246", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("99247", new CptProcedureCode("99247", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99248", new CptProcedureCode("99248", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("99249", new CptProcedureCode("99249", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99250", new CptProcedureCode("99250", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("99251", new CptProcedureCode("99251", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99252", new CptProcedureCode("99252", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("99253", new CptProcedureCode("99253", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99254", new CptProcedureCode("99254", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("99255", new CptProcedureCode("99255", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99256", new CptProcedureCode("99256", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("99257", new CptProcedureCode("99257", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99258", new CptProcedureCode("99258", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("99259", new CptProcedureCode("99259", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99260", new CptProcedureCode("99260", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("99261", new CptProcedureCode("99261", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99262", new CptProcedureCode("99262", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("99263", new CptProcedureCode("99263", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99264", new CptProcedureCode("99264", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("99265", new CptProcedureCode("99265", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99266", new CptProcedureCode("99266", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("99267", new CptProcedureCode("99267", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99268", new CptProcedureCode("99268", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("99269", new CptProcedureCode("99269", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99270", new CptProcedureCode("99270", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("99271", new CptProcedureCode("99271", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99272", new CptProcedureCode("99272", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("99273", new CptProcedureCode("99273", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99274", new CptProcedureCode("99274", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("99275", new CptProcedureCode("99275", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99276", new CptProcedureCode("99276", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("99277", new CptProcedureCode("99277", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99278", new CptProcedureCode("99278", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("99279", new CptProcedureCode("99279", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99280", new CptProcedureCode("99280", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("99281", new CptProcedureCode("99281", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99282", new CptProcedureCode("99282", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("99283", new CptProcedureCode("99283", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99284", new CptProcedureCode("99284", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("99285", new CptProcedureCode("99285", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99286", new CptProcedureCode("99286", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("99287", new CptProcedureCode("99287", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99288", new CptProcedureCode("99288", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("99289", new CptProcedureCode("99289", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99290", new CptProcedureCode("99290", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("99291", new CptProcedureCode("99291", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99292", new CptProcedureCode("99292", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("99293", new CptProcedureCode("99293", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99294", new CptProcedureCode("99294", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("99295", new CptProcedureCode("99295", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99296", new CptProcedureCode("99296", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("99297", new CptProcedureCode("99297", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99298", new CptProcedureCode("99298", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("99299", new CptProcedureCode("99299", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99300", new CptProcedureCode("99300", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("99301", new CptProcedureCode("99301", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99302", new CptProcedureCode("99302", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("99303", new CptProcedureCode("99303", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99304", new CptProcedureCode("99304", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("99305", new CptProcedureCode("99305", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99306", new CptProcedureCode("99306", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("99307", new CptProcedureCode("99307", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99308", new CptProcedureCode("99308", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("99309", new CptProcedureCode("99309", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99310", new CptProcedureCode("99310", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
        procedures.put("99311", new CptProcedureCode("99311", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #111", 204.80, 5245, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99312", new CptProcedureCode("99312", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #112", 206.60, 5290, "SURGICAL_MAJOR", true));
        procedures.put("99313", new CptProcedureCode("99313", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #113", 208.40, 5335, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99314", new CptProcedureCode("99314", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #114", 210.20, 5380, "SURGICAL_MAJOR", true));
        procedures.put("99315", new CptProcedureCode("99315", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #115", 212.00, 5425, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99316", new CptProcedureCode("99316", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #116", 213.80, 5470, "SURGICAL_MAJOR", true));
        procedures.put("99317", new CptProcedureCode("99317", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #117", 215.60, 5515, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99318", new CptProcedureCode("99318", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #118", 217.40, 5560, "SURGICAL_MAJOR", true));
        procedures.put("99319", new CptProcedureCode("99319", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #119", 219.20, 5605, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("99320", new CptProcedureCode("99320", "E/M Codes: Outpatient, Inpatient, ICU & Emergency Procedure #120", 221.00, 5650, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
