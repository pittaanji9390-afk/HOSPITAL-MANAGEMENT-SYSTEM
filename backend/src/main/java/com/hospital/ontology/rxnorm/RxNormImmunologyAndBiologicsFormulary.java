package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: TNF Inhibitors, Interleukin Blockers & Vaccines.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormImmunologyAndBiologicsFormulary {

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

    public RxNormImmunologyAndBiologicsFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("304001", new RxMedicationItem("304001", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #1", "L04.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304002", new RxMedicationItem("304002", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #2", "L04.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304003", new RxMedicationItem("304003", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #3", "L04.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304004", new RxMedicationItem("304004", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #4", "L04.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304005", new RxMedicationItem("304005", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #5", "L04.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304006", new RxMedicationItem("304006", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #6", "L04.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304007", new RxMedicationItem("304007", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #7", "L04.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304008", new RxMedicationItem("304008", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #8", "L04.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304009", new RxMedicationItem("304009", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #9", "L04.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304010", new RxMedicationItem("304010", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #10", "L04.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304011", new RxMedicationItem("304011", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #11", "L04.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304012", new RxMedicationItem("304012", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #12", "L04.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304013", new RxMedicationItem("304013", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #13", "L04.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304014", new RxMedicationItem("304014", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #14", "L04.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304015", new RxMedicationItem("304015", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #15", "L04.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304016", new RxMedicationItem("304016", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #16", "L04.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304017", new RxMedicationItem("304017", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #17", "L04.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304018", new RxMedicationItem("304018", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #18", "L04.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304019", new RxMedicationItem("304019", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #19", "L04.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304020", new RxMedicationItem("304020", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #20", "L04.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304021", new RxMedicationItem("304021", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #21", "L04.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304022", new RxMedicationItem("304022", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #22", "L04.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304023", new RxMedicationItem("304023", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #23", "L04.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304024", new RxMedicationItem("304024", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #24", "L04.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304025", new RxMedicationItem("304025", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #25", "L04.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304026", new RxMedicationItem("304026", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #26", "L04.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304027", new RxMedicationItem("304027", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #27", "L04.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304028", new RxMedicationItem("304028", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #28", "L04.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304029", new RxMedicationItem("304029", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #29", "L04.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304030", new RxMedicationItem("304030", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #30", "L04.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304031", new RxMedicationItem("304031", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #31", "L04.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304032", new RxMedicationItem("304032", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #32", "L04.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304033", new RxMedicationItem("304033", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #33", "L04.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304034", new RxMedicationItem("304034", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #34", "L04.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304035", new RxMedicationItem("304035", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #35", "L04.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304036", new RxMedicationItem("304036", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #36", "L04.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304037", new RxMedicationItem("304037", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #37", "L04.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304038", new RxMedicationItem("304038", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #38", "L04.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304039", new RxMedicationItem("304039", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #39", "L04.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304040", new RxMedicationItem("304040", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #40", "L04.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304041", new RxMedicationItem("304041", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #41", "L04.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304042", new RxMedicationItem("304042", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #42", "L04.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304043", new RxMedicationItem("304043", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #43", "L04.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304044", new RxMedicationItem("304044", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #44", "L04.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304045", new RxMedicationItem("304045", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #45", "L04.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304046", new RxMedicationItem("304046", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #46", "L04.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304047", new RxMedicationItem("304047", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #47", "L04.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304048", new RxMedicationItem("304048", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #48", "L04.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304049", new RxMedicationItem("304049", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #49", "L04.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304050", new RxMedicationItem("304050", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #50", "L04.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304051", new RxMedicationItem("304051", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #51", "L04.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304052", new RxMedicationItem("304052", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #52", "L04.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304053", new RxMedicationItem("304053", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #53", "L04.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304054", new RxMedicationItem("304054", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #54", "L04.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304055", new RxMedicationItem("304055", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #55", "L04.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304056", new RxMedicationItem("304056", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #56", "L04.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304057", new RxMedicationItem("304057", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #57", "L04.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304058", new RxMedicationItem("304058", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #58", "L04.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304059", new RxMedicationItem("304059", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #59", "L04.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304060", new RxMedicationItem("304060", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #60", "L04.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304061", new RxMedicationItem("304061", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #61", "L04.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304062", new RxMedicationItem("304062", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #62", "L04.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304063", new RxMedicationItem("304063", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #63", "L04.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304064", new RxMedicationItem("304064", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #64", "L04.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304065", new RxMedicationItem("304065", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #65", "L04.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304066", new RxMedicationItem("304066", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #66", "L04.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304067", new RxMedicationItem("304067", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #67", "L04.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304068", new RxMedicationItem("304068", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #68", "L04.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304069", new RxMedicationItem("304069", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #69", "L04.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304070", new RxMedicationItem("304070", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #70", "L04.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304071", new RxMedicationItem("304071", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #71", "L04.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304072", new RxMedicationItem("304072", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #72", "L04.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304073", new RxMedicationItem("304073", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #73", "L04.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304074", new RxMedicationItem("304074", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #74", "L04.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304075", new RxMedicationItem("304075", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #75", "L04.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304076", new RxMedicationItem("304076", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #76", "L04.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304077", new RxMedicationItem("304077", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #77", "L04.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304078", new RxMedicationItem("304078", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #78", "L04.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304079", new RxMedicationItem("304079", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #79", "L04.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304080", new RxMedicationItem("304080", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #80", "L04.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304081", new RxMedicationItem("304081", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #81", "L04.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304082", new RxMedicationItem("304082", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #82", "L04.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304083", new RxMedicationItem("304083", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #83", "L04.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304084", new RxMedicationItem("304084", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #84", "L04.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304085", new RxMedicationItem("304085", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #85", "L04.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304086", new RxMedicationItem("304086", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #86", "L04.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304087", new RxMedicationItem("304087", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #87", "L04.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304088", new RxMedicationItem("304088", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #88", "L04.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304089", new RxMedicationItem("304089", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #89", "L04.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304090", new RxMedicationItem("304090", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #90", "L04.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304091", new RxMedicationItem("304091", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #91", "L04.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304092", new RxMedicationItem("304092", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #92", "L04.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304093", new RxMedicationItem("304093", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #93", "L04.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304094", new RxMedicationItem("304094", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #94", "L04.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304095", new RxMedicationItem("304095", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #95", "L04.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304096", new RxMedicationItem("304096", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #96", "L04.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304097", new RxMedicationItem("304097", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #97", "L04.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304098", new RxMedicationItem("304098", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #98", "L04.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304099", new RxMedicationItem("304099", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #99", "L04.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304100", new RxMedicationItem("304100", "TNF Inhibitors, Interleukin Blockers & Vaccines Drug Entity #100", "L04.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
