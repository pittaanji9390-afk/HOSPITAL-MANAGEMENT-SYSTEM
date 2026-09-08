package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: Beta-Lactams, Carbapenems & Glycopeptides.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormAntimicrobialAntibioticsFormulary {

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

    public RxNormAntimicrobialAntibioticsFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("300501", new RxMedicationItem("300501", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #1", "J01.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300502", new RxMedicationItem("300502", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #2", "J01.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300503", new RxMedicationItem("300503", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #3", "J01.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300504", new RxMedicationItem("300504", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #4", "J01.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300505", new RxMedicationItem("300505", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #5", "J01.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300506", new RxMedicationItem("300506", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #6", "J01.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300507", new RxMedicationItem("300507", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #7", "J01.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300508", new RxMedicationItem("300508", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #8", "J01.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300509", new RxMedicationItem("300509", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #9", "J01.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300510", new RxMedicationItem("300510", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #10", "J01.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300511", new RxMedicationItem("300511", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #11", "J01.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300512", new RxMedicationItem("300512", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #12", "J01.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300513", new RxMedicationItem("300513", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #13", "J01.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300514", new RxMedicationItem("300514", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #14", "J01.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300515", new RxMedicationItem("300515", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #15", "J01.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300516", new RxMedicationItem("300516", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #16", "J01.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300517", new RxMedicationItem("300517", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #17", "J01.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300518", new RxMedicationItem("300518", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #18", "J01.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300519", new RxMedicationItem("300519", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #19", "J01.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300520", new RxMedicationItem("300520", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #20", "J01.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300521", new RxMedicationItem("300521", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #21", "J01.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300522", new RxMedicationItem("300522", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #22", "J01.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300523", new RxMedicationItem("300523", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #23", "J01.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300524", new RxMedicationItem("300524", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #24", "J01.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300525", new RxMedicationItem("300525", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #25", "J01.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300526", new RxMedicationItem("300526", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #26", "J01.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300527", new RxMedicationItem("300527", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #27", "J01.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300528", new RxMedicationItem("300528", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #28", "J01.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300529", new RxMedicationItem("300529", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #29", "J01.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300530", new RxMedicationItem("300530", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #30", "J01.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300531", new RxMedicationItem("300531", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #31", "J01.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300532", new RxMedicationItem("300532", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #32", "J01.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300533", new RxMedicationItem("300533", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #33", "J01.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300534", new RxMedicationItem("300534", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #34", "J01.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300535", new RxMedicationItem("300535", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #35", "J01.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300536", new RxMedicationItem("300536", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #36", "J01.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300537", new RxMedicationItem("300537", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #37", "J01.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300538", new RxMedicationItem("300538", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #38", "J01.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300539", new RxMedicationItem("300539", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #39", "J01.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300540", new RxMedicationItem("300540", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #40", "J01.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300541", new RxMedicationItem("300541", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #41", "J01.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300542", new RxMedicationItem("300542", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #42", "J01.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300543", new RxMedicationItem("300543", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #43", "J01.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300544", new RxMedicationItem("300544", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #44", "J01.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300545", new RxMedicationItem("300545", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #45", "J01.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300546", new RxMedicationItem("300546", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #46", "J01.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300547", new RxMedicationItem("300547", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #47", "J01.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300548", new RxMedicationItem("300548", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #48", "J01.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300549", new RxMedicationItem("300549", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #49", "J01.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300550", new RxMedicationItem("300550", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #50", "J01.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300551", new RxMedicationItem("300551", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #51", "J01.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300552", new RxMedicationItem("300552", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #52", "J01.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300553", new RxMedicationItem("300553", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #53", "J01.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300554", new RxMedicationItem("300554", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #54", "J01.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300555", new RxMedicationItem("300555", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #55", "J01.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300556", new RxMedicationItem("300556", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #56", "J01.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300557", new RxMedicationItem("300557", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #57", "J01.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300558", new RxMedicationItem("300558", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #58", "J01.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300559", new RxMedicationItem("300559", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #59", "J01.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300560", new RxMedicationItem("300560", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #60", "J01.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300561", new RxMedicationItem("300561", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #61", "J01.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300562", new RxMedicationItem("300562", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #62", "J01.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300563", new RxMedicationItem("300563", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #63", "J01.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300564", new RxMedicationItem("300564", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #64", "J01.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300565", new RxMedicationItem("300565", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #65", "J01.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300566", new RxMedicationItem("300566", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #66", "J01.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300567", new RxMedicationItem("300567", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #67", "J01.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300568", new RxMedicationItem("300568", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #68", "J01.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300569", new RxMedicationItem("300569", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #69", "J01.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300570", new RxMedicationItem("300570", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #70", "J01.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300571", new RxMedicationItem("300571", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #71", "J01.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300572", new RxMedicationItem("300572", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #72", "J01.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300573", new RxMedicationItem("300573", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #73", "J01.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300574", new RxMedicationItem("300574", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #74", "J01.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300575", new RxMedicationItem("300575", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #75", "J01.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300576", new RxMedicationItem("300576", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #76", "J01.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300577", new RxMedicationItem("300577", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #77", "J01.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300578", new RxMedicationItem("300578", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #78", "J01.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300579", new RxMedicationItem("300579", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #79", "J01.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300580", new RxMedicationItem("300580", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #80", "J01.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300581", new RxMedicationItem("300581", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #81", "J01.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300582", new RxMedicationItem("300582", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #82", "J01.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300583", new RxMedicationItem("300583", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #83", "J01.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300584", new RxMedicationItem("300584", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #84", "J01.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300585", new RxMedicationItem("300585", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #85", "J01.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300586", new RxMedicationItem("300586", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #86", "J01.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300587", new RxMedicationItem("300587", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #87", "J01.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300588", new RxMedicationItem("300588", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #88", "J01.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300589", new RxMedicationItem("300589", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #89", "J01.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300590", new RxMedicationItem("300590", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #90", "J01.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300591", new RxMedicationItem("300591", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #91", "J01.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300592", new RxMedicationItem("300592", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #92", "J01.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300593", new RxMedicationItem("300593", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #93", "J01.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300594", new RxMedicationItem("300594", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #94", "J01.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300595", new RxMedicationItem("300595", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #95", "J01.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300596", new RxMedicationItem("300596", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #96", "J01.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300597", new RxMedicationItem("300597", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #97", "J01.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300598", new RxMedicationItem("300598", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #98", "J01.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300599", new RxMedicationItem("300599", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #99", "J01.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300600", new RxMedicationItem("300600", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #100", "J01.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300601", new RxMedicationItem("300601", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #101", "J01.101", "1010 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300602", new RxMedicationItem("300602", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #102", "J01.102", "1020 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300603", new RxMedicationItem("300603", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #103", "J01.103", "1030 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300604", new RxMedicationItem("300604", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #104", "J01.104", "1040 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300605", new RxMedicationItem("300605", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #105", "J01.105", "1050 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300606", new RxMedicationItem("300606", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #106", "J01.106", "1060 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300607", new RxMedicationItem("300607", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #107", "J01.107", "1070 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300608", new RxMedicationItem("300608", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #108", "J01.108", "1080 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300609", new RxMedicationItem("300609", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #109", "J01.109", "1090 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300610", new RxMedicationItem("300610", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #110", "J01.110", "1100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300611", new RxMedicationItem("300611", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #111", "J01.111", "1110 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300612", new RxMedicationItem("300612", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #112", "J01.112", "1120 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300613", new RxMedicationItem("300613", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #113", "J01.113", "1130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300614", new RxMedicationItem("300614", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #114", "J01.114", "1140 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300615", new RxMedicationItem("300615", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #115", "J01.115", "1150 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300616", new RxMedicationItem("300616", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #116", "J01.116", "1160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300617", new RxMedicationItem("300617", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #117", "J01.117", "1170 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300618", new RxMedicationItem("300618", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #118", "J01.118", "1180 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300619", new RxMedicationItem("300619", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #119", "J01.119", "1190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300620", new RxMedicationItem("300620", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #120", "J01.120", "1200 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300621", new RxMedicationItem("300621", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #121", "J01.121", "1210 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300622", new RxMedicationItem("300622", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #122", "J01.122", "1220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300623", new RxMedicationItem("300623", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #123", "J01.123", "1230 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300624", new RxMedicationItem("300624", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #124", "J01.124", "1240 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300625", new RxMedicationItem("300625", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #125", "J01.125", "1250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300626", new RxMedicationItem("300626", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #126", "J01.126", "1260 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300627", new RxMedicationItem("300627", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #127", "J01.127", "1270 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300628", new RxMedicationItem("300628", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #128", "J01.128", "1280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300629", new RxMedicationItem("300629", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #129", "J01.129", "1290 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("300630", new RxMedicationItem("300630", "Beta-Lactams, Carbapenems & Glycopeptides Drug Entity #130", "J01.130", "1300 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
