package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: Total Joint Arthroplasty, Arthroscopy & Fracture Fixation.
 */
@Component
public class CptOrthopedicSurgicalCptDirectory {

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

    public CptOrthopedicSurgicalCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("27001", new CptProcedureCode("27001", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27002", new CptProcedureCode("27002", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("27003", new CptProcedureCode("27003", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27004", new CptProcedureCode("27004", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("27005", new CptProcedureCode("27005", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27006", new CptProcedureCode("27006", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("27007", new CptProcedureCode("27007", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27008", new CptProcedureCode("27008", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("27009", new CptProcedureCode("27009", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27010", new CptProcedureCode("27010", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("27011", new CptProcedureCode("27011", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27012", new CptProcedureCode("27012", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("27013", new CptProcedureCode("27013", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27014", new CptProcedureCode("27014", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("27015", new CptProcedureCode("27015", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27016", new CptProcedureCode("27016", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("27017", new CptProcedureCode("27017", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27018", new CptProcedureCode("27018", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("27019", new CptProcedureCode("27019", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27020", new CptProcedureCode("27020", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("27021", new CptProcedureCode("27021", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27022", new CptProcedureCode("27022", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("27023", new CptProcedureCode("27023", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27024", new CptProcedureCode("27024", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("27025", new CptProcedureCode("27025", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27026", new CptProcedureCode("27026", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("27027", new CptProcedureCode("27027", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27028", new CptProcedureCode("27028", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("27029", new CptProcedureCode("27029", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27030", new CptProcedureCode("27030", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("27031", new CptProcedureCode("27031", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27032", new CptProcedureCode("27032", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("27033", new CptProcedureCode("27033", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27034", new CptProcedureCode("27034", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("27035", new CptProcedureCode("27035", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27036", new CptProcedureCode("27036", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("27037", new CptProcedureCode("27037", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27038", new CptProcedureCode("27038", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("27039", new CptProcedureCode("27039", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27040", new CptProcedureCode("27040", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("27041", new CptProcedureCode("27041", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27042", new CptProcedureCode("27042", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("27043", new CptProcedureCode("27043", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27044", new CptProcedureCode("27044", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("27045", new CptProcedureCode("27045", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27046", new CptProcedureCode("27046", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("27047", new CptProcedureCode("27047", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27048", new CptProcedureCode("27048", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("27049", new CptProcedureCode("27049", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27050", new CptProcedureCode("27050", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("27051", new CptProcedureCode("27051", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27052", new CptProcedureCode("27052", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("27053", new CptProcedureCode("27053", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27054", new CptProcedureCode("27054", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("27055", new CptProcedureCode("27055", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27056", new CptProcedureCode("27056", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("27057", new CptProcedureCode("27057", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27058", new CptProcedureCode("27058", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("27059", new CptProcedureCode("27059", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27060", new CptProcedureCode("27060", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("27061", new CptProcedureCode("27061", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27062", new CptProcedureCode("27062", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("27063", new CptProcedureCode("27063", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27064", new CptProcedureCode("27064", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("27065", new CptProcedureCode("27065", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27066", new CptProcedureCode("27066", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("27067", new CptProcedureCode("27067", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27068", new CptProcedureCode("27068", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("27069", new CptProcedureCode("27069", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27070", new CptProcedureCode("27070", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("27071", new CptProcedureCode("27071", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27072", new CptProcedureCode("27072", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("27073", new CptProcedureCode("27073", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27074", new CptProcedureCode("27074", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("27075", new CptProcedureCode("27075", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27076", new CptProcedureCode("27076", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("27077", new CptProcedureCode("27077", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27078", new CptProcedureCode("27078", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("27079", new CptProcedureCode("27079", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27080", new CptProcedureCode("27080", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("27081", new CptProcedureCode("27081", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27082", new CptProcedureCode("27082", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("27083", new CptProcedureCode("27083", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27084", new CptProcedureCode("27084", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("27085", new CptProcedureCode("27085", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27086", new CptProcedureCode("27086", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("27087", new CptProcedureCode("27087", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27088", new CptProcedureCode("27088", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("27089", new CptProcedureCode("27089", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27090", new CptProcedureCode("27090", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("27091", new CptProcedureCode("27091", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27092", new CptProcedureCode("27092", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("27093", new CptProcedureCode("27093", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27094", new CptProcedureCode("27094", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("27095", new CptProcedureCode("27095", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27096", new CptProcedureCode("27096", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("27097", new CptProcedureCode("27097", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27098", new CptProcedureCode("27098", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("27099", new CptProcedureCode("27099", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27100", new CptProcedureCode("27100", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("27101", new CptProcedureCode("27101", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27102", new CptProcedureCode("27102", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("27103", new CptProcedureCode("27103", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27104", new CptProcedureCode("27104", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("27105", new CptProcedureCode("27105", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27106", new CptProcedureCode("27106", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("27107", new CptProcedureCode("27107", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27108", new CptProcedureCode("27108", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("27109", new CptProcedureCode("27109", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27110", new CptProcedureCode("27110", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
        procedures.put("27111", new CptProcedureCode("27111", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #111", 204.80, 5245, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27112", new CptProcedureCode("27112", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #112", 206.60, 5290, "SURGICAL_MAJOR", true));
        procedures.put("27113", new CptProcedureCode("27113", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #113", 208.40, 5335, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27114", new CptProcedureCode("27114", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #114", 210.20, 5380, "SURGICAL_MAJOR", true));
        procedures.put("27115", new CptProcedureCode("27115", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #115", 212.00, 5425, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27116", new CptProcedureCode("27116", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #116", 213.80, 5470, "SURGICAL_MAJOR", true));
        procedures.put("27117", new CptProcedureCode("27117", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #117", 215.60, 5515, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27118", new CptProcedureCode("27118", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #118", 217.40, 5560, "SURGICAL_MAJOR", true));
        procedures.put("27119", new CptProcedureCode("27119", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #119", 219.20, 5605, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27120", new CptProcedureCode("27120", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #120", 221.00, 5650, "SURGICAL_MAJOR", true));
        procedures.put("27121", new CptProcedureCode("27121", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #121", 222.80, 5695, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27122", new CptProcedureCode("27122", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #122", 224.60, 5740, "SURGICAL_MAJOR", true));
        procedures.put("27123", new CptProcedureCode("27123", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #123", 226.40, 5785, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27124", new CptProcedureCode("27124", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #124", 228.20, 5830, "SURGICAL_MAJOR", true));
        procedures.put("27125", new CptProcedureCode("27125", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #125", 230.00, 5875, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27126", new CptProcedureCode("27126", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #126", 231.80, 5920, "SURGICAL_MAJOR", true));
        procedures.put("27127", new CptProcedureCode("27127", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #127", 233.60, 5965, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27128", new CptProcedureCode("27128", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #128", 235.40, 6010, "SURGICAL_MAJOR", true));
        procedures.put("27129", new CptProcedureCode("27129", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #129", 237.20, 6055, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("27130", new CptProcedureCode("27130", "Total Joint Arthroplasty, Arthroscopy & Fracture Fixation Procedure #130", 239.00, 6100, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
