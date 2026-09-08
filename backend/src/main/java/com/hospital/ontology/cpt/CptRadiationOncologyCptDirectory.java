package com.hospital.ontology.cpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * CPT / HCPCS AMA Standard Procedural Coding & Relative Value Units (RVU) Encyclopedia: IMRT, CyberKnife, Proton Beam & Brachytherapy.
 */
@Component
public class CptRadiationOncologyCptDirectory {

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

    public CptRadiationOncologyCptDirectory() {
        initializeProcedures();
    }

    private void initializeProcedures() {
        procedures.put("77001", new CptProcedureCode("77001", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #1", 6.80, 295, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77002", new CptProcedureCode("77002", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #2", 8.60, 340, "SURGICAL_MAJOR", true));
        procedures.put("77003", new CptProcedureCode("77003", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #3", 10.40, 385, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77004", new CptProcedureCode("77004", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #4", 12.20, 430, "SURGICAL_MAJOR", true));
        procedures.put("77005", new CptProcedureCode("77005", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #5", 14.00, 475, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77006", new CptProcedureCode("77006", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #6", 15.80, 520, "SURGICAL_MAJOR", true));
        procedures.put("77007", new CptProcedureCode("77007", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #7", 17.60, 565, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77008", new CptProcedureCode("77008", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #8", 19.40, 610, "SURGICAL_MAJOR", true));
        procedures.put("77009", new CptProcedureCode("77009", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #9", 21.20, 655, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77010", new CptProcedureCode("77010", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #10", 23.00, 700, "SURGICAL_MAJOR", true));
        procedures.put("77011", new CptProcedureCode("77011", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #11", 24.80, 745, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77012", new CptProcedureCode("77012", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #12", 26.60, 790, "SURGICAL_MAJOR", true));
        procedures.put("77013", new CptProcedureCode("77013", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #13", 28.40, 835, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77014", new CptProcedureCode("77014", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #14", 30.20, 880, "SURGICAL_MAJOR", true));
        procedures.put("77015", new CptProcedureCode("77015", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #15", 32.00, 925, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77016", new CptProcedureCode("77016", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #16", 33.80, 970, "SURGICAL_MAJOR", true));
        procedures.put("77017", new CptProcedureCode("77017", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #17", 35.60, 1015, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77018", new CptProcedureCode("77018", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #18", 37.40, 1060, "SURGICAL_MAJOR", true));
        procedures.put("77019", new CptProcedureCode("77019", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #19", 39.20, 1105, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77020", new CptProcedureCode("77020", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #20", 41.00, 1150, "SURGICAL_MAJOR", true));
        procedures.put("77021", new CptProcedureCode("77021", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #21", 42.80, 1195, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77022", new CptProcedureCode("77022", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #22", 44.60, 1240, "SURGICAL_MAJOR", true));
        procedures.put("77023", new CptProcedureCode("77023", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #23", 46.40, 1285, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77024", new CptProcedureCode("77024", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #24", 48.20, 1330, "SURGICAL_MAJOR", true));
        procedures.put("77025", new CptProcedureCode("77025", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #25", 50.00, 1375, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77026", new CptProcedureCode("77026", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #26", 51.80, 1420, "SURGICAL_MAJOR", true));
        procedures.put("77027", new CptProcedureCode("77027", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #27", 53.60, 1465, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77028", new CptProcedureCode("77028", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #28", 55.40, 1510, "SURGICAL_MAJOR", true));
        procedures.put("77029", new CptProcedureCode("77029", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #29", 57.20, 1555, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77030", new CptProcedureCode("77030", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #30", 59.00, 1600, "SURGICAL_MAJOR", true));
        procedures.put("77031", new CptProcedureCode("77031", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #31", 60.80, 1645, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77032", new CptProcedureCode("77032", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #32", 62.60, 1690, "SURGICAL_MAJOR", true));
        procedures.put("77033", new CptProcedureCode("77033", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #33", 64.40, 1735, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77034", new CptProcedureCode("77034", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #34", 66.20, 1780, "SURGICAL_MAJOR", true));
        procedures.put("77035", new CptProcedureCode("77035", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #35", 68.00, 1825, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77036", new CptProcedureCode("77036", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #36", 69.80, 1870, "SURGICAL_MAJOR", true));
        procedures.put("77037", new CptProcedureCode("77037", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #37", 71.60, 1915, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77038", new CptProcedureCode("77038", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #38", 73.40, 1960, "SURGICAL_MAJOR", true));
        procedures.put("77039", new CptProcedureCode("77039", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #39", 75.20, 2005, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77040", new CptProcedureCode("77040", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #40", 77.00, 2050, "SURGICAL_MAJOR", true));
        procedures.put("77041", new CptProcedureCode("77041", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #41", 78.80, 2095, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77042", new CptProcedureCode("77042", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #42", 80.60, 2140, "SURGICAL_MAJOR", true));
        procedures.put("77043", new CptProcedureCode("77043", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #43", 82.40, 2185, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77044", new CptProcedureCode("77044", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #44", 84.20, 2230, "SURGICAL_MAJOR", true));
        procedures.put("77045", new CptProcedureCode("77045", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #45", 86.00, 2275, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77046", new CptProcedureCode("77046", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #46", 87.80, 2320, "SURGICAL_MAJOR", true));
        procedures.put("77047", new CptProcedureCode("77047", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #47", 89.60, 2365, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77048", new CptProcedureCode("77048", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #48", 91.40, 2410, "SURGICAL_MAJOR", true));
        procedures.put("77049", new CptProcedureCode("77049", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #49", 93.20, 2455, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77050", new CptProcedureCode("77050", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #50", 95.00, 2500, "SURGICAL_MAJOR", true));
        procedures.put("77051", new CptProcedureCode("77051", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #51", 96.80, 2545, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77052", new CptProcedureCode("77052", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #52", 98.60, 2590, "SURGICAL_MAJOR", true));
        procedures.put("77053", new CptProcedureCode("77053", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #53", 100.40, 2635, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77054", new CptProcedureCode("77054", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #54", 102.20, 2680, "SURGICAL_MAJOR", true));
        procedures.put("77055", new CptProcedureCode("77055", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #55", 104.00, 2725, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77056", new CptProcedureCode("77056", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #56", 105.80, 2770, "SURGICAL_MAJOR", true));
        procedures.put("77057", new CptProcedureCode("77057", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #57", 107.60, 2815, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77058", new CptProcedureCode("77058", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #58", 109.40, 2860, "SURGICAL_MAJOR", true));
        procedures.put("77059", new CptProcedureCode("77059", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #59", 111.20, 2905, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77060", new CptProcedureCode("77060", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #60", 113.00, 2950, "SURGICAL_MAJOR", true));
        procedures.put("77061", new CptProcedureCode("77061", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #61", 114.80, 2995, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77062", new CptProcedureCode("77062", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #62", 116.60, 3040, "SURGICAL_MAJOR", true));
        procedures.put("77063", new CptProcedureCode("77063", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #63", 118.40, 3085, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77064", new CptProcedureCode("77064", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #64", 120.20, 3130, "SURGICAL_MAJOR", true));
        procedures.put("77065", new CptProcedureCode("77065", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #65", 122.00, 3175, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77066", new CptProcedureCode("77066", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #66", 123.80, 3220, "SURGICAL_MAJOR", true));
        procedures.put("77067", new CptProcedureCode("77067", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #67", 125.60, 3265, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77068", new CptProcedureCode("77068", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #68", 127.40, 3310, "SURGICAL_MAJOR", true));
        procedures.put("77069", new CptProcedureCode("77069", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #69", 129.20, 3355, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77070", new CptProcedureCode("77070", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #70", 131.00, 3400, "SURGICAL_MAJOR", true));
        procedures.put("77071", new CptProcedureCode("77071", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #71", 132.80, 3445, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77072", new CptProcedureCode("77072", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #72", 134.60, 3490, "SURGICAL_MAJOR", true));
        procedures.put("77073", new CptProcedureCode("77073", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #73", 136.40, 3535, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77074", new CptProcedureCode("77074", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #74", 138.20, 3580, "SURGICAL_MAJOR", true));
        procedures.put("77075", new CptProcedureCode("77075", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #75", 140.00, 3625, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77076", new CptProcedureCode("77076", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #76", 141.80, 3670, "SURGICAL_MAJOR", true));
        procedures.put("77077", new CptProcedureCode("77077", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #77", 143.60, 3715, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77078", new CptProcedureCode("77078", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #78", 145.40, 3760, "SURGICAL_MAJOR", true));
        procedures.put("77079", new CptProcedureCode("77079", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #79", 147.20, 3805, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77080", new CptProcedureCode("77080", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #80", 149.00, 3850, "SURGICAL_MAJOR", true));
        procedures.put("77081", new CptProcedureCode("77081", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #81", 150.80, 3895, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77082", new CptProcedureCode("77082", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #82", 152.60, 3940, "SURGICAL_MAJOR", true));
        procedures.put("77083", new CptProcedureCode("77083", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #83", 154.40, 3985, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77084", new CptProcedureCode("77084", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #84", 156.20, 4030, "SURGICAL_MAJOR", true));
        procedures.put("77085", new CptProcedureCode("77085", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #85", 158.00, 4075, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77086", new CptProcedureCode("77086", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #86", 159.80, 4120, "SURGICAL_MAJOR", true));
        procedures.put("77087", new CptProcedureCode("77087", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #87", 161.60, 4165, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77088", new CptProcedureCode("77088", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #88", 163.40, 4210, "SURGICAL_MAJOR", true));
        procedures.put("77089", new CptProcedureCode("77089", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #89", 165.20, 4255, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77090", new CptProcedureCode("77090", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #90", 167.00, 4300, "SURGICAL_MAJOR", true));
        procedures.put("77091", new CptProcedureCode("77091", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #91", 168.80, 4345, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77092", new CptProcedureCode("77092", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #92", 170.60, 4390, "SURGICAL_MAJOR", true));
        procedures.put("77093", new CptProcedureCode("77093", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #93", 172.40, 4435, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77094", new CptProcedureCode("77094", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #94", 174.20, 4480, "SURGICAL_MAJOR", true));
        procedures.put("77095", new CptProcedureCode("77095", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #95", 176.00, 4525, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77096", new CptProcedureCode("77096", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #96", 177.80, 4570, "SURGICAL_MAJOR", true));
        procedures.put("77097", new CptProcedureCode("77097", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #97", 179.60, 4615, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77098", new CptProcedureCode("77098", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #98", 181.40, 4660, "SURGICAL_MAJOR", true));
        procedures.put("77099", new CptProcedureCode("77099", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #99", 183.20, 4705, "DIAGNOSTIC_INTERVENTION", true));
        procedures.put("77100", new CptProcedureCode("77100", "IMRT, CyberKnife, Proton Beam & Brachytherapy Procedure #100", 185.00, 4750, "SURGICAL_MAJOR", true));
    }

    public Optional<CptProcedureCode> findByCptCode(String cptCode) {
        return Optional.ofNullable(procedures.get(cptCode));
    }

    public List<CptProcedureCode> getAllProcedures() {
        return new ArrayList<>(procedures.values());
    }
}
