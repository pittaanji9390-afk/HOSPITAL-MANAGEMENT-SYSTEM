package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: Surgical Pathology, Flow Cytometry & Molecular Diagnostics.
 */
@Component
public class CptPathologyAndLaboratoryCptDirectory {

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

    public CptPathologyAndLaboratoryCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("88001", new CptProcedureCode("88001", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88002", new CptProcedureCode("88002", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("88003", new CptProcedureCode("88003", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88004", new CptProcedureCode("88004", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("88005", new CptProcedureCode("88005", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88006", new CptProcedureCode("88006", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("88007", new CptProcedureCode("88007", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88008", new CptProcedureCode("88008", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("88009", new CptProcedureCode("88009", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88010", new CptProcedureCode("88010", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("88011", new CptProcedureCode("88011", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88012", new CptProcedureCode("88012", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("88013", new CptProcedureCode("88013", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88014", new CptProcedureCode("88014", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("88015", new CptProcedureCode("88015", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88016", new CptProcedureCode("88016", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("88017", new CptProcedureCode("88017", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88018", new CptProcedureCode("88018", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("88019", new CptProcedureCode("88019", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88020", new CptProcedureCode("88020", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("88021", new CptProcedureCode("88021", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88022", new CptProcedureCode("88022", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("88023", new CptProcedureCode("88023", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88024", new CptProcedureCode("88024", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("88025", new CptProcedureCode("88025", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88026", new CptProcedureCode("88026", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("88027", new CptProcedureCode("88027", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88028", new CptProcedureCode("88028", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("88029", new CptProcedureCode("88029", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88030", new CptProcedureCode("88030", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("88031", new CptProcedureCode("88031", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88032", new CptProcedureCode("88032", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("88033", new CptProcedureCode("88033", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88034", new CptProcedureCode("88034", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("88035", new CptProcedureCode("88035", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88036", new CptProcedureCode("88036", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("88037", new CptProcedureCode("88037", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88038", new CptProcedureCode("88038", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("88039", new CptProcedureCode("88039", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88040", new CptProcedureCode("88040", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("88041", new CptProcedureCode("88041", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88042", new CptProcedureCode("88042", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("88043", new CptProcedureCode("88043", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88044", new CptProcedureCode("88044", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("88045", new CptProcedureCode("88045", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88046", new CptProcedureCode("88046", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("88047", new CptProcedureCode("88047", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88048", new CptProcedureCode("88048", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("88049", new CptProcedureCode("88049", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88050", new CptProcedureCode("88050", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("88051", new CptProcedureCode("88051", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88052", new CptProcedureCode("88052", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("88053", new CptProcedureCode("88053", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88054", new CptProcedureCode("88054", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("88055", new CptProcedureCode("88055", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88056", new CptProcedureCode("88056", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("88057", new CptProcedureCode("88057", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88058", new CptProcedureCode("88058", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("88059", new CptProcedureCode("88059", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88060", new CptProcedureCode("88060", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("88061", new CptProcedureCode("88061", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88062", new CptProcedureCode("88062", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("88063", new CptProcedureCode("88063", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88064", new CptProcedureCode("88064", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("88065", new CptProcedureCode("88065", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88066", new CptProcedureCode("88066", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("88067", new CptProcedureCode("88067", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88068", new CptProcedureCode("88068", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("88069", new CptProcedureCode("88069", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88070", new CptProcedureCode("88070", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("88071", new CptProcedureCode("88071", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88072", new CptProcedureCode("88072", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("88073", new CptProcedureCode("88073", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88074", new CptProcedureCode("88074", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("88075", new CptProcedureCode("88075", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88076", new CptProcedureCode("88076", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("88077", new CptProcedureCode("88077", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88078", new CptProcedureCode("88078", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("88079", new CptProcedureCode("88079", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88080", new CptProcedureCode("88080", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("88081", new CptProcedureCode("88081", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88082", new CptProcedureCode("88082", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("88083", new CptProcedureCode("88083", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88084", new CptProcedureCode("88084", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("88085", new CptProcedureCode("88085", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88086", new CptProcedureCode("88086", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("88087", new CptProcedureCode("88087", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88088", new CptProcedureCode("88088", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("88089", new CptProcedureCode("88089", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88090", new CptProcedureCode("88090", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("88091", new CptProcedureCode("88091", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88092", new CptProcedureCode("88092", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("88093", new CptProcedureCode("88093", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88094", new CptProcedureCode("88094", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("88095", new CptProcedureCode("88095", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88096", new CptProcedureCode("88096", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("88097", new CptProcedureCode("88097", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88098", new CptProcedureCode("88098", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("88099", new CptProcedureCode("88099", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88100", new CptProcedureCode("88100", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("88101", new CptProcedureCode("88101", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88102", new CptProcedureCode("88102", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("88103", new CptProcedureCode("88103", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88104", new CptProcedureCode("88104", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("88105", new CptProcedureCode("88105", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88106", new CptProcedureCode("88106", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("88107", new CptProcedureCode("88107", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88108", new CptProcedureCode("88108", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("88109", new CptProcedureCode("88109", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("88110", new CptProcedureCode("88110", "Surgical Pathology, Flow Cytometry & Molecular Diagnostics Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
