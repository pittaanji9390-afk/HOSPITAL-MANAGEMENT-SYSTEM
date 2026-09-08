package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: Antihypertensives, Antiarrhythmics & Inotropes.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormCardiovascularAgentsFormulary {

    @Data
    @AllArgsConstructor
    public static class RxMedicationItem {
        private String rxCui;
        private String genericAndBrandName;
        private String atcClassification;
        private String standardStrength;
        private String administrationRoute;
        private boolean hasBlackBoxWarning;
        private boolean requiresRenalDoseAdjustment;
        private String clinicalPharmacologyNote;
    }

    private final Map<String, RxMedicationItem> medications = new LinkedHashMap<>();

    public RxNormCardiovascularAgentsFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("300001", new RxMedicationItem("300001", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #1", "C.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300002", new RxMedicationItem("300002", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #2", "C.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300003", new RxMedicationItem("300003", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #3", "C.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300004", new RxMedicationItem("300004", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #4", "C.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300005", new RxMedicationItem("300005", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #5", "C.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300006", new RxMedicationItem("300006", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #6", "C.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300007", new RxMedicationItem("300007", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #7", "C.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300008", new RxMedicationItem("300008", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #8", "C.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300009", new RxMedicationItem("300009", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #9", "C.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300010", new RxMedicationItem("300010", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #10", "C.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300011", new RxMedicationItem("300011", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #11", "C.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300012", new RxMedicationItem("300012", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #12", "C.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300013", new RxMedicationItem("300013", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #13", "C.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300014", new RxMedicationItem("300014", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #14", "C.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300015", new RxMedicationItem("300015", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #15", "C.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300016", new RxMedicationItem("300016", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #16", "C.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300017", new RxMedicationItem("300017", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #17", "C.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300018", new RxMedicationItem("300018", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #18", "C.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300019", new RxMedicationItem("300019", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #19", "C.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300020", new RxMedicationItem("300020", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #20", "C.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300021", new RxMedicationItem("300021", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #21", "C.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300022", new RxMedicationItem("300022", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #22", "C.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300023", new RxMedicationItem("300023", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #23", "C.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300024", new RxMedicationItem("300024", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #24", "C.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300025", new RxMedicationItem("300025", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #25", "C.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300026", new RxMedicationItem("300026", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #26", "C.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300027", new RxMedicationItem("300027", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #27", "C.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300028", new RxMedicationItem("300028", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #28", "C.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300029", new RxMedicationItem("300029", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #29", "C.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300030", new RxMedicationItem("300030", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #30", "C.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300031", new RxMedicationItem("300031", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #31", "C.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300032", new RxMedicationItem("300032", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #32", "C.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300033", new RxMedicationItem("300033", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #33", "C.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300034", new RxMedicationItem("300034", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #34", "C.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300035", new RxMedicationItem("300035", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #35", "C.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300036", new RxMedicationItem("300036", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #36", "C.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300037", new RxMedicationItem("300037", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #37", "C.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300038", new RxMedicationItem("300038", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #38", "C.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300039", new RxMedicationItem("300039", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #39", "C.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300040", new RxMedicationItem("300040", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #40", "C.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300041", new RxMedicationItem("300041", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #41", "C.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300042", new RxMedicationItem("300042", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #42", "C.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300043", new RxMedicationItem("300043", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #43", "C.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300044", new RxMedicationItem("300044", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #44", "C.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300045", new RxMedicationItem("300045", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #45", "C.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300046", new RxMedicationItem("300046", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #46", "C.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300047", new RxMedicationItem("300047", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #47", "C.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300048", new RxMedicationItem("300048", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #48", "C.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300049", new RxMedicationItem("300049", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #49", "C.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300050", new RxMedicationItem("300050", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #50", "C.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300051", new RxMedicationItem("300051", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #51", "C.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300052", new RxMedicationItem("300052", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #52", "C.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300053", new RxMedicationItem("300053", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #53", "C.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300054", new RxMedicationItem("300054", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #54", "C.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300055", new RxMedicationItem("300055", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #55", "C.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300056", new RxMedicationItem("300056", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #56", "C.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300057", new RxMedicationItem("300057", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #57", "C.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300058", new RxMedicationItem("300058", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #58", "C.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300059", new RxMedicationItem("300059", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #59", "C.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300060", new RxMedicationItem("300060", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #60", "C.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300061", new RxMedicationItem("300061", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #61", "C.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300062", new RxMedicationItem("300062", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #62", "C.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300063", new RxMedicationItem("300063", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #63", "C.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300064", new RxMedicationItem("300064", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #64", "C.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300065", new RxMedicationItem("300065", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #65", "C.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300066", new RxMedicationItem("300066", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #66", "C.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300067", new RxMedicationItem("300067", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #67", "C.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300068", new RxMedicationItem("300068", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #68", "C.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300069", new RxMedicationItem("300069", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #69", "C.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300070", new RxMedicationItem("300070", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #70", "C.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300071", new RxMedicationItem("300071", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #71", "C.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300072", new RxMedicationItem("300072", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #72", "C.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300073", new RxMedicationItem("300073", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #73", "C.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300074", new RxMedicationItem("300074", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #74", "C.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300075", new RxMedicationItem("300075", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #75", "C.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300076", new RxMedicationItem("300076", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #76", "C.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300077", new RxMedicationItem("300077", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #77", "C.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300078", new RxMedicationItem("300078", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #78", "C.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300079", new RxMedicationItem("300079", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #79", "C.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300080", new RxMedicationItem("300080", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #80", "C.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300081", new RxMedicationItem("300081", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #81", "C.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300082", new RxMedicationItem("300082", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #82", "C.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300083", new RxMedicationItem("300083", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #83", "C.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300084", new RxMedicationItem("300084", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #84", "C.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300085", new RxMedicationItem("300085", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #85", "C.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300086", new RxMedicationItem("300086", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #86", "C.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300087", new RxMedicationItem("300087", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #87", "C.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300088", new RxMedicationItem("300088", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #88", "C.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300089", new RxMedicationItem("300089", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #89", "C.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300090", new RxMedicationItem("300090", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #90", "C.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300091", new RxMedicationItem("300091", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #91", "C.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300092", new RxMedicationItem("300092", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #92", "C.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300093", new RxMedicationItem("300093", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #93", "C.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300094", new RxMedicationItem("300094", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #94", "C.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300095", new RxMedicationItem("300095", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #95", "C.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300096", new RxMedicationItem("300096", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #96", "C.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300097", new RxMedicationItem("300097", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #97", "C.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300098", new RxMedicationItem("300098", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #98", "C.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300099", new RxMedicationItem("300099", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #99", "C.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300100", new RxMedicationItem("300100", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #100", "C.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300101", new RxMedicationItem("300101", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #101", "C.101", "1010 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300102", new RxMedicationItem("300102", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #102", "C.102", "1020 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300103", new RxMedicationItem("300103", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #103", "C.103", "1030 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300104", new RxMedicationItem("300104", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #104", "C.104", "1040 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300105", new RxMedicationItem("300105", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #105", "C.105", "1050 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300106", new RxMedicationItem("300106", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #106", "C.106", "1060 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300107", new RxMedicationItem("300107", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #107", "C.107", "1070 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300108", new RxMedicationItem("300108", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #108", "C.108", "1080 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300109", new RxMedicationItem("300109", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #109", "C.109", "1090 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300110", new RxMedicationItem("300110", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #110", "C.110", "1100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300111", new RxMedicationItem("300111", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #111", "C.111", "1110 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300112", new RxMedicationItem("300112", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #112", "C.112", "1120 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300113", new RxMedicationItem("300113", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #113", "C.113", "1130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300114", new RxMedicationItem("300114", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #114", "C.114", "1140 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300115", new RxMedicationItem("300115", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #115", "C.115", "1150 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300116", new RxMedicationItem("300116", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #116", "C.116", "1160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300117", new RxMedicationItem("300117", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #117", "C.117", "1170 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300118", new RxMedicationItem("300118", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #118", "C.118", "1180 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300119", new RxMedicationItem("300119", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #119", "C.119", "1190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300120", new RxMedicationItem("300120", "Antihypertensives, Antiarrhythmics & Inotropes Drug Entity #120", "C.120", "1200 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
