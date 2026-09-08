package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: Craniotomy, Spine Fusion & Stereotactic Radiosurgery.
 */
@Component
public class CptNeurosurgicalAndSpineCptDirectory {

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

    public CptNeurosurgicalAndSpineCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("61001", new CptProcedureCode("61001", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61002", new CptProcedureCode("61002", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("61003", new CptProcedureCode("61003", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61004", new CptProcedureCode("61004", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("61005", new CptProcedureCode("61005", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61006", new CptProcedureCode("61006", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("61007", new CptProcedureCode("61007", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61008", new CptProcedureCode("61008", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("61009", new CptProcedureCode("61009", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61010", new CptProcedureCode("61010", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("61011", new CptProcedureCode("61011", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61012", new CptProcedureCode("61012", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("61013", new CptProcedureCode("61013", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61014", new CptProcedureCode("61014", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("61015", new CptProcedureCode("61015", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61016", new CptProcedureCode("61016", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("61017", new CptProcedureCode("61017", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61018", new CptProcedureCode("61018", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("61019", new CptProcedureCode("61019", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61020", new CptProcedureCode("61020", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("61021", new CptProcedureCode("61021", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61022", new CptProcedureCode("61022", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("61023", new CptProcedureCode("61023", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61024", new CptProcedureCode("61024", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("61025", new CptProcedureCode("61025", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61026", new CptProcedureCode("61026", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("61027", new CptProcedureCode("61027", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61028", new CptProcedureCode("61028", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("61029", new CptProcedureCode("61029", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61030", new CptProcedureCode("61030", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("61031", new CptProcedureCode("61031", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61032", new CptProcedureCode("61032", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("61033", new CptProcedureCode("61033", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61034", new CptProcedureCode("61034", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("61035", new CptProcedureCode("61035", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61036", new CptProcedureCode("61036", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("61037", new CptProcedureCode("61037", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61038", new CptProcedureCode("61038", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("61039", new CptProcedureCode("61039", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61040", new CptProcedureCode("61040", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("61041", new CptProcedureCode("61041", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61042", new CptProcedureCode("61042", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("61043", new CptProcedureCode("61043", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61044", new CptProcedureCode("61044", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("61045", new CptProcedureCode("61045", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61046", new CptProcedureCode("61046", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("61047", new CptProcedureCode("61047", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61048", new CptProcedureCode("61048", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("61049", new CptProcedureCode("61049", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61050", new CptProcedureCode("61050", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("61051", new CptProcedureCode("61051", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61052", new CptProcedureCode("61052", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("61053", new CptProcedureCode("61053", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61054", new CptProcedureCode("61054", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("61055", new CptProcedureCode("61055", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61056", new CptProcedureCode("61056", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("61057", new CptProcedureCode("61057", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61058", new CptProcedureCode("61058", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("61059", new CptProcedureCode("61059", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61060", new CptProcedureCode("61060", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("61061", new CptProcedureCode("61061", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61062", new CptProcedureCode("61062", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("61063", new CptProcedureCode("61063", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61064", new CptProcedureCode("61064", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("61065", new CptProcedureCode("61065", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61066", new CptProcedureCode("61066", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("61067", new CptProcedureCode("61067", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61068", new CptProcedureCode("61068", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("61069", new CptProcedureCode("61069", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61070", new CptProcedureCode("61070", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("61071", new CptProcedureCode("61071", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61072", new CptProcedureCode("61072", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("61073", new CptProcedureCode("61073", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61074", new CptProcedureCode("61074", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("61075", new CptProcedureCode("61075", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61076", new CptProcedureCode("61076", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("61077", new CptProcedureCode("61077", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61078", new CptProcedureCode("61078", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("61079", new CptProcedureCode("61079", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61080", new CptProcedureCode("61080", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("61081", new CptProcedureCode("61081", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61082", new CptProcedureCode("61082", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("61083", new CptProcedureCode("61083", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61084", new CptProcedureCode("61084", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("61085", new CptProcedureCode("61085", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61086", new CptProcedureCode("61086", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("61087", new CptProcedureCode("61087", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61088", new CptProcedureCode("61088", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("61089", new CptProcedureCode("61089", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61090", new CptProcedureCode("61090", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("61091", new CptProcedureCode("61091", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61092", new CptProcedureCode("61092", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("61093", new CptProcedureCode("61093", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61094", new CptProcedureCode("61094", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("61095", new CptProcedureCode("61095", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61096", new CptProcedureCode("61096", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("61097", new CptProcedureCode("61097", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61098", new CptProcedureCode("61098", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("61099", new CptProcedureCode("61099", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61100", new CptProcedureCode("61100", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("61101", new CptProcedureCode("61101", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61102", new CptProcedureCode("61102", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("61103", new CptProcedureCode("61103", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61104", new CptProcedureCode("61104", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("61105", new CptProcedureCode("61105", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61106", new CptProcedureCode("61106", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("61107", new CptProcedureCode("61107", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61108", new CptProcedureCode("61108", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("61109", new CptProcedureCode("61109", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("61110", new CptProcedureCode("61110", "Craniotomy, Spine Fusion & Stereotactic Radiosurgery Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
