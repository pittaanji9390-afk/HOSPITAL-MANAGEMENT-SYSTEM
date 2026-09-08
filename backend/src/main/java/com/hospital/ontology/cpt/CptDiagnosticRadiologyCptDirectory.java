package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray.
 */
@Component
public class CptDiagnosticRadiologyCptDirectory {

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

    public CptDiagnosticRadiologyCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("70001", new CptProcedureCode("70001", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70002", new CptProcedureCode("70002", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("70003", new CptProcedureCode("70003", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70004", new CptProcedureCode("70004", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("70005", new CptProcedureCode("70005", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70006", new CptProcedureCode("70006", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("70007", new CptProcedureCode("70007", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70008", new CptProcedureCode("70008", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("70009", new CptProcedureCode("70009", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70010", new CptProcedureCode("70010", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("70011", new CptProcedureCode("70011", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70012", new CptProcedureCode("70012", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("70013", new CptProcedureCode("70013", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70014", new CptProcedureCode("70014", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("70015", new CptProcedureCode("70015", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70016", new CptProcedureCode("70016", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("70017", new CptProcedureCode("70017", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70018", new CptProcedureCode("70018", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("70019", new CptProcedureCode("70019", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70020", new CptProcedureCode("70020", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("70021", new CptProcedureCode("70021", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70022", new CptProcedureCode("70022", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("70023", new CptProcedureCode("70023", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70024", new CptProcedureCode("70024", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("70025", new CptProcedureCode("70025", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70026", new CptProcedureCode("70026", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("70027", new CptProcedureCode("70027", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70028", new CptProcedureCode("70028", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("70029", new CptProcedureCode("70029", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70030", new CptProcedureCode("70030", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("70031", new CptProcedureCode("70031", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70032", new CptProcedureCode("70032", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("70033", new CptProcedureCode("70033", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70034", new CptProcedureCode("70034", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("70035", new CptProcedureCode("70035", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70036", new CptProcedureCode("70036", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("70037", new CptProcedureCode("70037", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70038", new CptProcedureCode("70038", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("70039", new CptProcedureCode("70039", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70040", new CptProcedureCode("70040", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("70041", new CptProcedureCode("70041", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70042", new CptProcedureCode("70042", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("70043", new CptProcedureCode("70043", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70044", new CptProcedureCode("70044", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("70045", new CptProcedureCode("70045", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70046", new CptProcedureCode("70046", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("70047", new CptProcedureCode("70047", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70048", new CptProcedureCode("70048", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("70049", new CptProcedureCode("70049", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70050", new CptProcedureCode("70050", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("70051", new CptProcedureCode("70051", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70052", new CptProcedureCode("70052", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("70053", new CptProcedureCode("70053", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70054", new CptProcedureCode("70054", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("70055", new CptProcedureCode("70055", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70056", new CptProcedureCode("70056", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("70057", new CptProcedureCode("70057", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70058", new CptProcedureCode("70058", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("70059", new CptProcedureCode("70059", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70060", new CptProcedureCode("70060", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("70061", new CptProcedureCode("70061", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70062", new CptProcedureCode("70062", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("70063", new CptProcedureCode("70063", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70064", new CptProcedureCode("70064", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("70065", new CptProcedureCode("70065", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70066", new CptProcedureCode("70066", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("70067", new CptProcedureCode("70067", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70068", new CptProcedureCode("70068", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("70069", new CptProcedureCode("70069", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70070", new CptProcedureCode("70070", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("70071", new CptProcedureCode("70071", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70072", new CptProcedureCode("70072", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("70073", new CptProcedureCode("70073", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70074", new CptProcedureCode("70074", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("70075", new CptProcedureCode("70075", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70076", new CptProcedureCode("70076", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("70077", new CptProcedureCode("70077", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70078", new CptProcedureCode("70078", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("70079", new CptProcedureCode("70079", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70080", new CptProcedureCode("70080", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("70081", new CptProcedureCode("70081", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70082", new CptProcedureCode("70082", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("70083", new CptProcedureCode("70083", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70084", new CptProcedureCode("70084", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("70085", new CptProcedureCode("70085", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70086", new CptProcedureCode("70086", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("70087", new CptProcedureCode("70087", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70088", new CptProcedureCode("70088", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("70089", new CptProcedureCode("70089", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70090", new CptProcedureCode("70090", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("70091", new CptProcedureCode("70091", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70092", new CptProcedureCode("70092", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("70093", new CptProcedureCode("70093", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70094", new CptProcedureCode("70094", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("70095", new CptProcedureCode("70095", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70096", new CptProcedureCode("70096", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("70097", new CptProcedureCode("70097", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70098", new CptProcedureCode("70098", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("70099", new CptProcedureCode("70099", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70100", new CptProcedureCode("70100", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
        procedures.put("70101", new CptProcedureCode("70101", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #101", 186.80, 4795, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70102", new CptProcedureCode("70102", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #102", 188.60, 4840, "SURGICAL_MAJOR", true));
        procedures.put("70103", new CptProcedureCode("70103", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #103", 190.40, 4885, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70104", new CptProcedureCode("70104", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #104", 192.20, 4930, "SURGICAL_MAJOR", true));
        procedures.put("70105", new CptProcedureCode("70105", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #105", 194.00, 4975, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70106", new CptProcedureCode("70106", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #106", 195.80, 5020, "SURGICAL_MAJOR", true));
        procedures.put("70107", new CptProcedureCode("70107", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #107", 197.60, 5065, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70108", new CptProcedureCode("70108", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #108", 199.40, 5110, "SURGICAL_MAJOR", true));
        procedures.put("70109", new CptProcedureCode("70109", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #109", 201.20, 5155, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70110", new CptProcedureCode("70110", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #110", 203.00, 5200, "SURGICAL_MAJOR", true));
        procedures.put("70111", new CptProcedureCode("70111", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #111", 204.80, 5245, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70112", new CptProcedureCode("70112", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #112", 206.60, 5290, "SURGICAL_MAJOR", true));
        procedures.put("70113", new CptProcedureCode("70113", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #113", 208.40, 5335, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70114", new CptProcedureCode("70114", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #114", 210.20, 5380, "SURGICAL_MAJOR", true));
        procedures.put("70115", new CptProcedureCode("70115", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #115", 212.00, 5425, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70116", new CptProcedureCode("70116", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #116", 213.80, 5470, "SURGICAL_MAJOR", true));
        procedures.put("70117", new CptProcedureCode("70117", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #117", 215.60, 5515, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70118", new CptProcedureCode("70118", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #118", 217.40, 5560, "SURGICAL_MAJOR", true));
        procedures.put("70119", new CptProcedureCode("70119", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #119", 219.20, 5605, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("70120", new CptProcedureCode("70120", "CT Scans, 3T MRI, PET-CT, Doppler Ultrasound & X-Ray Procedure #120", 221.00, 5650, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
