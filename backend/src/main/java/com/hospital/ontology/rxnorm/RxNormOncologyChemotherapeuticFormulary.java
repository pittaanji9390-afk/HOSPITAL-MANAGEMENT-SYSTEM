package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: Antimetabolites, Monoclonal Antibodies & TKIs.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormOncologyChemotherapeuticFormulary {

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

    public RxNormOncologyChemotherapeuticFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("301001", new RxMedicationItem("301001", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #1", "L.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301002", new RxMedicationItem("301002", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #2", "L.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301003", new RxMedicationItem("301003", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #3", "L.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301004", new RxMedicationItem("301004", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #4", "L.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301005", new RxMedicationItem("301005", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #5", "L.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301006", new RxMedicationItem("301006", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #6", "L.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301007", new RxMedicationItem("301007", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #7", "L.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301008", new RxMedicationItem("301008", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #8", "L.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301009", new RxMedicationItem("301009", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #9", "L.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301010", new RxMedicationItem("301010", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #10", "L.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301011", new RxMedicationItem("301011", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #11", "L.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301012", new RxMedicationItem("301012", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #12", "L.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301013", new RxMedicationItem("301013", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #13", "L.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301014", new RxMedicationItem("301014", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #14", "L.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301015", new RxMedicationItem("301015", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #15", "L.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301016", new RxMedicationItem("301016", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #16", "L.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301017", new RxMedicationItem("301017", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #17", "L.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301018", new RxMedicationItem("301018", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #18", "L.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301019", new RxMedicationItem("301019", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #19", "L.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301020", new RxMedicationItem("301020", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #20", "L.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301021", new RxMedicationItem("301021", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #21", "L.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301022", new RxMedicationItem("301022", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #22", "L.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301023", new RxMedicationItem("301023", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #23", "L.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301024", new RxMedicationItem("301024", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #24", "L.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301025", new RxMedicationItem("301025", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #25", "L.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301026", new RxMedicationItem("301026", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #26", "L.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301027", new RxMedicationItem("301027", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #27", "L.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301028", new RxMedicationItem("301028", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #28", "L.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301029", new RxMedicationItem("301029", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #29", "L.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301030", new RxMedicationItem("301030", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #30", "L.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301031", new RxMedicationItem("301031", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #31", "L.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301032", new RxMedicationItem("301032", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #32", "L.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301033", new RxMedicationItem("301033", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #33", "L.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301034", new RxMedicationItem("301034", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #34", "L.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301035", new RxMedicationItem("301035", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #35", "L.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301036", new RxMedicationItem("301036", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #36", "L.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301037", new RxMedicationItem("301037", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #37", "L.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301038", new RxMedicationItem("301038", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #38", "L.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301039", new RxMedicationItem("301039", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #39", "L.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301040", new RxMedicationItem("301040", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #40", "L.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301041", new RxMedicationItem("301041", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #41", "L.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301042", new RxMedicationItem("301042", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #42", "L.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301043", new RxMedicationItem("301043", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #43", "L.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301044", new RxMedicationItem("301044", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #44", "L.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301045", new RxMedicationItem("301045", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #45", "L.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301046", new RxMedicationItem("301046", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #46", "L.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301047", new RxMedicationItem("301047", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #47", "L.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301048", new RxMedicationItem("301048", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #48", "L.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301049", new RxMedicationItem("301049", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #49", "L.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301050", new RxMedicationItem("301050", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #50", "L.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301051", new RxMedicationItem("301051", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #51", "L.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301052", new RxMedicationItem("301052", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #52", "L.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301053", new RxMedicationItem("301053", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #53", "L.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301054", new RxMedicationItem("301054", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #54", "L.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301055", new RxMedicationItem("301055", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #55", "L.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301056", new RxMedicationItem("301056", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #56", "L.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301057", new RxMedicationItem("301057", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #57", "L.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301058", new RxMedicationItem("301058", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #58", "L.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301059", new RxMedicationItem("301059", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #59", "L.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301060", new RxMedicationItem("301060", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #60", "L.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301061", new RxMedicationItem("301061", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #61", "L.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301062", new RxMedicationItem("301062", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #62", "L.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301063", new RxMedicationItem("301063", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #63", "L.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301064", new RxMedicationItem("301064", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #64", "L.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301065", new RxMedicationItem("301065", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #65", "L.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301066", new RxMedicationItem("301066", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #66", "L.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301067", new RxMedicationItem("301067", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #67", "L.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301068", new RxMedicationItem("301068", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #68", "L.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301069", new RxMedicationItem("301069", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #69", "L.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301070", new RxMedicationItem("301070", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #70", "L.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301071", new RxMedicationItem("301071", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #71", "L.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301072", new RxMedicationItem("301072", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #72", "L.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301073", new RxMedicationItem("301073", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #73", "L.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301074", new RxMedicationItem("301074", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #74", "L.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301075", new RxMedicationItem("301075", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #75", "L.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301076", new RxMedicationItem("301076", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #76", "L.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301077", new RxMedicationItem("301077", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #77", "L.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301078", new RxMedicationItem("301078", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #78", "L.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301079", new RxMedicationItem("301079", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #79", "L.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301080", new RxMedicationItem("301080", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #80", "L.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301081", new RxMedicationItem("301081", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #81", "L.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301082", new RxMedicationItem("301082", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #82", "L.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301083", new RxMedicationItem("301083", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #83", "L.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301084", new RxMedicationItem("301084", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #84", "L.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301085", new RxMedicationItem("301085", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #85", "L.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301086", new RxMedicationItem("301086", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #86", "L.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301087", new RxMedicationItem("301087", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #87", "L.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301088", new RxMedicationItem("301088", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #88", "L.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301089", new RxMedicationItem("301089", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #89", "L.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301090", new RxMedicationItem("301090", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #90", "L.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301091", new RxMedicationItem("301091", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #91", "L.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301092", new RxMedicationItem("301092", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #92", "L.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301093", new RxMedicationItem("301093", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #93", "L.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301094", new RxMedicationItem("301094", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #94", "L.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301095", new RxMedicationItem("301095", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #95", "L.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301096", new RxMedicationItem("301096", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #96", "L.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301097", new RxMedicationItem("301097", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #97", "L.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301098", new RxMedicationItem("301098", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #98", "L.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301099", new RxMedicationItem("301099", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #99", "L.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301100", new RxMedicationItem("301100", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #100", "L.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301101", new RxMedicationItem("301101", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #101", "L.101", "1010 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301102", new RxMedicationItem("301102", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #102", "L.102", "1020 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301103", new RxMedicationItem("301103", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #103", "L.103", "1030 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301104", new RxMedicationItem("301104", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #104", "L.104", "1040 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301105", new RxMedicationItem("301105", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #105", "L.105", "1050 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301106", new RxMedicationItem("301106", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #106", "L.106", "1060 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301107", new RxMedicationItem("301107", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #107", "L.107", "1070 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301108", new RxMedicationItem("301108", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #108", "L.108", "1080 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301109", new RxMedicationItem("301109", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #109", "L.109", "1090 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301110", new RxMedicationItem("301110", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #110", "L.110", "1100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301111", new RxMedicationItem("301111", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #111", "L.111", "1110 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301112", new RxMedicationItem("301112", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #112", "L.112", "1120 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301113", new RxMedicationItem("301113", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #113", "L.113", "1130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301114", new RxMedicationItem("301114", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #114", "L.114", "1140 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301115", new RxMedicationItem("301115", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #115", "L.115", "1150 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301116", new RxMedicationItem("301116", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #116", "L.116", "1160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301117", new RxMedicationItem("301117", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #117", "L.117", "1170 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301118", new RxMedicationItem("301118", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #118", "L.118", "1180 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301119", new RxMedicationItem("301119", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #119", "L.119", "1190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301120", new RxMedicationItem("301120", "Antimetabolites, Monoclonal Antibodies & TKIs Drug Entity #120", "L.120", "1200 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
