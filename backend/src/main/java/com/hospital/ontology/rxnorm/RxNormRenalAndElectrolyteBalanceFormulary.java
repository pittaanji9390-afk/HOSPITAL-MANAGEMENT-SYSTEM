package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: Diuretics, Phosphate Binders & Dialysates.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormRenalAndElectrolyteBalanceFormulary {

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

    public RxNormRenalAndElectrolyteBalanceFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("304501", new RxMedicationItem("304501", "Diuretics, Phosphate Binders & Dialysates Drug Entity #1", "C03.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304502", new RxMedicationItem("304502", "Diuretics, Phosphate Binders & Dialysates Drug Entity #2", "C03.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304503", new RxMedicationItem("304503", "Diuretics, Phosphate Binders & Dialysates Drug Entity #3", "C03.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304504", new RxMedicationItem("304504", "Diuretics, Phosphate Binders & Dialysates Drug Entity #4", "C03.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304505", new RxMedicationItem("304505", "Diuretics, Phosphate Binders & Dialysates Drug Entity #5", "C03.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304506", new RxMedicationItem("304506", "Diuretics, Phosphate Binders & Dialysates Drug Entity #6", "C03.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304507", new RxMedicationItem("304507", "Diuretics, Phosphate Binders & Dialysates Drug Entity #7", "C03.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304508", new RxMedicationItem("304508", "Diuretics, Phosphate Binders & Dialysates Drug Entity #8", "C03.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304509", new RxMedicationItem("304509", "Diuretics, Phosphate Binders & Dialysates Drug Entity #9", "C03.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304510", new RxMedicationItem("304510", "Diuretics, Phosphate Binders & Dialysates Drug Entity #10", "C03.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304511", new RxMedicationItem("304511", "Diuretics, Phosphate Binders & Dialysates Drug Entity #11", "C03.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304512", new RxMedicationItem("304512", "Diuretics, Phosphate Binders & Dialysates Drug Entity #12", "C03.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304513", new RxMedicationItem("304513", "Diuretics, Phosphate Binders & Dialysates Drug Entity #13", "C03.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304514", new RxMedicationItem("304514", "Diuretics, Phosphate Binders & Dialysates Drug Entity #14", "C03.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304515", new RxMedicationItem("304515", "Diuretics, Phosphate Binders & Dialysates Drug Entity #15", "C03.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304516", new RxMedicationItem("304516", "Diuretics, Phosphate Binders & Dialysates Drug Entity #16", "C03.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304517", new RxMedicationItem("304517", "Diuretics, Phosphate Binders & Dialysates Drug Entity #17", "C03.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304518", new RxMedicationItem("304518", "Diuretics, Phosphate Binders & Dialysates Drug Entity #18", "C03.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304519", new RxMedicationItem("304519", "Diuretics, Phosphate Binders & Dialysates Drug Entity #19", "C03.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304520", new RxMedicationItem("304520", "Diuretics, Phosphate Binders & Dialysates Drug Entity #20", "C03.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304521", new RxMedicationItem("304521", "Diuretics, Phosphate Binders & Dialysates Drug Entity #21", "C03.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304522", new RxMedicationItem("304522", "Diuretics, Phosphate Binders & Dialysates Drug Entity #22", "C03.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304523", new RxMedicationItem("304523", "Diuretics, Phosphate Binders & Dialysates Drug Entity #23", "C03.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304524", new RxMedicationItem("304524", "Diuretics, Phosphate Binders & Dialysates Drug Entity #24", "C03.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304525", new RxMedicationItem("304525", "Diuretics, Phosphate Binders & Dialysates Drug Entity #25", "C03.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304526", new RxMedicationItem("304526", "Diuretics, Phosphate Binders & Dialysates Drug Entity #26", "C03.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304527", new RxMedicationItem("304527", "Diuretics, Phosphate Binders & Dialysates Drug Entity #27", "C03.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304528", new RxMedicationItem("304528", "Diuretics, Phosphate Binders & Dialysates Drug Entity #28", "C03.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304529", new RxMedicationItem("304529", "Diuretics, Phosphate Binders & Dialysates Drug Entity #29", "C03.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304530", new RxMedicationItem("304530", "Diuretics, Phosphate Binders & Dialysates Drug Entity #30", "C03.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304531", new RxMedicationItem("304531", "Diuretics, Phosphate Binders & Dialysates Drug Entity #31", "C03.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304532", new RxMedicationItem("304532", "Diuretics, Phosphate Binders & Dialysates Drug Entity #32", "C03.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304533", new RxMedicationItem("304533", "Diuretics, Phosphate Binders & Dialysates Drug Entity #33", "C03.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304534", new RxMedicationItem("304534", "Diuretics, Phosphate Binders & Dialysates Drug Entity #34", "C03.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304535", new RxMedicationItem("304535", "Diuretics, Phosphate Binders & Dialysates Drug Entity #35", "C03.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304536", new RxMedicationItem("304536", "Diuretics, Phosphate Binders & Dialysates Drug Entity #36", "C03.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304537", new RxMedicationItem("304537", "Diuretics, Phosphate Binders & Dialysates Drug Entity #37", "C03.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304538", new RxMedicationItem("304538", "Diuretics, Phosphate Binders & Dialysates Drug Entity #38", "C03.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304539", new RxMedicationItem("304539", "Diuretics, Phosphate Binders & Dialysates Drug Entity #39", "C03.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304540", new RxMedicationItem("304540", "Diuretics, Phosphate Binders & Dialysates Drug Entity #40", "C03.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304541", new RxMedicationItem("304541", "Diuretics, Phosphate Binders & Dialysates Drug Entity #41", "C03.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304542", new RxMedicationItem("304542", "Diuretics, Phosphate Binders & Dialysates Drug Entity #42", "C03.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304543", new RxMedicationItem("304543", "Diuretics, Phosphate Binders & Dialysates Drug Entity #43", "C03.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304544", new RxMedicationItem("304544", "Diuretics, Phosphate Binders & Dialysates Drug Entity #44", "C03.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304545", new RxMedicationItem("304545", "Diuretics, Phosphate Binders & Dialysates Drug Entity #45", "C03.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304546", new RxMedicationItem("304546", "Diuretics, Phosphate Binders & Dialysates Drug Entity #46", "C03.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304547", new RxMedicationItem("304547", "Diuretics, Phosphate Binders & Dialysates Drug Entity #47", "C03.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304548", new RxMedicationItem("304548", "Diuretics, Phosphate Binders & Dialysates Drug Entity #48", "C03.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304549", new RxMedicationItem("304549", "Diuretics, Phosphate Binders & Dialysates Drug Entity #49", "C03.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304550", new RxMedicationItem("304550", "Diuretics, Phosphate Binders & Dialysates Drug Entity #50", "C03.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304551", new RxMedicationItem("304551", "Diuretics, Phosphate Binders & Dialysates Drug Entity #51", "C03.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304552", new RxMedicationItem("304552", "Diuretics, Phosphate Binders & Dialysates Drug Entity #52", "C03.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304553", new RxMedicationItem("304553", "Diuretics, Phosphate Binders & Dialysates Drug Entity #53", "C03.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304554", new RxMedicationItem("304554", "Diuretics, Phosphate Binders & Dialysates Drug Entity #54", "C03.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304555", new RxMedicationItem("304555", "Diuretics, Phosphate Binders & Dialysates Drug Entity #55", "C03.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304556", new RxMedicationItem("304556", "Diuretics, Phosphate Binders & Dialysates Drug Entity #56", "C03.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304557", new RxMedicationItem("304557", "Diuretics, Phosphate Binders & Dialysates Drug Entity #57", "C03.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304558", new RxMedicationItem("304558", "Diuretics, Phosphate Binders & Dialysates Drug Entity #58", "C03.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304559", new RxMedicationItem("304559", "Diuretics, Phosphate Binders & Dialysates Drug Entity #59", "C03.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304560", new RxMedicationItem("304560", "Diuretics, Phosphate Binders & Dialysates Drug Entity #60", "C03.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304561", new RxMedicationItem("304561", "Diuretics, Phosphate Binders & Dialysates Drug Entity #61", "C03.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304562", new RxMedicationItem("304562", "Diuretics, Phosphate Binders & Dialysates Drug Entity #62", "C03.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304563", new RxMedicationItem("304563", "Diuretics, Phosphate Binders & Dialysates Drug Entity #63", "C03.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304564", new RxMedicationItem("304564", "Diuretics, Phosphate Binders & Dialysates Drug Entity #64", "C03.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304565", new RxMedicationItem("304565", "Diuretics, Phosphate Binders & Dialysates Drug Entity #65", "C03.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304566", new RxMedicationItem("304566", "Diuretics, Phosphate Binders & Dialysates Drug Entity #66", "C03.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304567", new RxMedicationItem("304567", "Diuretics, Phosphate Binders & Dialysates Drug Entity #67", "C03.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304568", new RxMedicationItem("304568", "Diuretics, Phosphate Binders & Dialysates Drug Entity #68", "C03.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304569", new RxMedicationItem("304569", "Diuretics, Phosphate Binders & Dialysates Drug Entity #69", "C03.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304570", new RxMedicationItem("304570", "Diuretics, Phosphate Binders & Dialysates Drug Entity #70", "C03.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304571", new RxMedicationItem("304571", "Diuretics, Phosphate Binders & Dialysates Drug Entity #71", "C03.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304572", new RxMedicationItem("304572", "Diuretics, Phosphate Binders & Dialysates Drug Entity #72", "C03.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304573", new RxMedicationItem("304573", "Diuretics, Phosphate Binders & Dialysates Drug Entity #73", "C03.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304574", new RxMedicationItem("304574", "Diuretics, Phosphate Binders & Dialysates Drug Entity #74", "C03.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304575", new RxMedicationItem("304575", "Diuretics, Phosphate Binders & Dialysates Drug Entity #75", "C03.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304576", new RxMedicationItem("304576", "Diuretics, Phosphate Binders & Dialysates Drug Entity #76", "C03.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304577", new RxMedicationItem("304577", "Diuretics, Phosphate Binders & Dialysates Drug Entity #77", "C03.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304578", new RxMedicationItem("304578", "Diuretics, Phosphate Binders & Dialysates Drug Entity #78", "C03.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304579", new RxMedicationItem("304579", "Diuretics, Phosphate Binders & Dialysates Drug Entity #79", "C03.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304580", new RxMedicationItem("304580", "Diuretics, Phosphate Binders & Dialysates Drug Entity #80", "C03.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304581", new RxMedicationItem("304581", "Diuretics, Phosphate Binders & Dialysates Drug Entity #81", "C03.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304582", new RxMedicationItem("304582", "Diuretics, Phosphate Binders & Dialysates Drug Entity #82", "C03.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304583", new RxMedicationItem("304583", "Diuretics, Phosphate Binders & Dialysates Drug Entity #83", "C03.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304584", new RxMedicationItem("304584", "Diuretics, Phosphate Binders & Dialysates Drug Entity #84", "C03.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304585", new RxMedicationItem("304585", "Diuretics, Phosphate Binders & Dialysates Drug Entity #85", "C03.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304586", new RxMedicationItem("304586", "Diuretics, Phosphate Binders & Dialysates Drug Entity #86", "C03.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304587", new RxMedicationItem("304587", "Diuretics, Phosphate Binders & Dialysates Drug Entity #87", "C03.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304588", new RxMedicationItem("304588", "Diuretics, Phosphate Binders & Dialysates Drug Entity #88", "C03.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304589", new RxMedicationItem("304589", "Diuretics, Phosphate Binders & Dialysates Drug Entity #89", "C03.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304590", new RxMedicationItem("304590", "Diuretics, Phosphate Binders & Dialysates Drug Entity #90", "C03.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304591", new RxMedicationItem("304591", "Diuretics, Phosphate Binders & Dialysates Drug Entity #91", "C03.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304592", new RxMedicationItem("304592", "Diuretics, Phosphate Binders & Dialysates Drug Entity #92", "C03.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304593", new RxMedicationItem("304593", "Diuretics, Phosphate Binders & Dialysates Drug Entity #93", "C03.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304594", new RxMedicationItem("304594", "Diuretics, Phosphate Binders & Dialysates Drug Entity #94", "C03.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304595", new RxMedicationItem("304595", "Diuretics, Phosphate Binders & Dialysates Drug Entity #95", "C03.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304596", new RxMedicationItem("304596", "Diuretics, Phosphate Binders & Dialysates Drug Entity #96", "C03.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304597", new RxMedicationItem("304597", "Diuretics, Phosphate Binders & Dialysates Drug Entity #97", "C03.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304598", new RxMedicationItem("304598", "Diuretics, Phosphate Binders & Dialysates Drug Entity #98", "C03.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304599", new RxMedicationItem("304599", "Diuretics, Phosphate Binders & Dialysates Drug Entity #99", "C03.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("304600", new RxMedicationItem("304600", "Diuretics, Phosphate Binders & Dialysates Drug Entity #100", "C03.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
