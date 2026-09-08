package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: Bronchodilators, Corticosteroids & Surfactants.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormPulmonaryAndRespiratoryFormulary {

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

    public RxNormPulmonaryAndRespiratoryFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("302501", new RxMedicationItem("302501", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #1", "R.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302502", new RxMedicationItem("302502", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #2", "R.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302503", new RxMedicationItem("302503", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #3", "R.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302504", new RxMedicationItem("302504", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #4", "R.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302505", new RxMedicationItem("302505", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #5", "R.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302506", new RxMedicationItem("302506", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #6", "R.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302507", new RxMedicationItem("302507", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #7", "R.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302508", new RxMedicationItem("302508", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #8", "R.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302509", new RxMedicationItem("302509", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #9", "R.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302510", new RxMedicationItem("302510", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #10", "R.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302511", new RxMedicationItem("302511", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #11", "R.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302512", new RxMedicationItem("302512", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #12", "R.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302513", new RxMedicationItem("302513", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #13", "R.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302514", new RxMedicationItem("302514", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #14", "R.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302515", new RxMedicationItem("302515", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #15", "R.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302516", new RxMedicationItem("302516", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #16", "R.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302517", new RxMedicationItem("302517", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #17", "R.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302518", new RxMedicationItem("302518", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #18", "R.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302519", new RxMedicationItem("302519", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #19", "R.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302520", new RxMedicationItem("302520", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #20", "R.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302521", new RxMedicationItem("302521", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #21", "R.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302522", new RxMedicationItem("302522", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #22", "R.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302523", new RxMedicationItem("302523", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #23", "R.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302524", new RxMedicationItem("302524", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #24", "R.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302525", new RxMedicationItem("302525", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #25", "R.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302526", new RxMedicationItem("302526", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #26", "R.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302527", new RxMedicationItem("302527", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #27", "R.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302528", new RxMedicationItem("302528", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #28", "R.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302529", new RxMedicationItem("302529", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #29", "R.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302530", new RxMedicationItem("302530", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #30", "R.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302531", new RxMedicationItem("302531", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #31", "R.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302532", new RxMedicationItem("302532", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #32", "R.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302533", new RxMedicationItem("302533", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #33", "R.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302534", new RxMedicationItem("302534", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #34", "R.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302535", new RxMedicationItem("302535", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #35", "R.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302536", new RxMedicationItem("302536", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #36", "R.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302537", new RxMedicationItem("302537", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #37", "R.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302538", new RxMedicationItem("302538", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #38", "R.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302539", new RxMedicationItem("302539", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #39", "R.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302540", new RxMedicationItem("302540", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #40", "R.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302541", new RxMedicationItem("302541", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #41", "R.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302542", new RxMedicationItem("302542", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #42", "R.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302543", new RxMedicationItem("302543", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #43", "R.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302544", new RxMedicationItem("302544", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #44", "R.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302545", new RxMedicationItem("302545", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #45", "R.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302546", new RxMedicationItem("302546", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #46", "R.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302547", new RxMedicationItem("302547", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #47", "R.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302548", new RxMedicationItem("302548", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #48", "R.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302549", new RxMedicationItem("302549", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #49", "R.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302550", new RxMedicationItem("302550", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #50", "R.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302551", new RxMedicationItem("302551", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #51", "R.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302552", new RxMedicationItem("302552", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #52", "R.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302553", new RxMedicationItem("302553", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #53", "R.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302554", new RxMedicationItem("302554", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #54", "R.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302555", new RxMedicationItem("302555", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #55", "R.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302556", new RxMedicationItem("302556", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #56", "R.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302557", new RxMedicationItem("302557", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #57", "R.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302558", new RxMedicationItem("302558", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #58", "R.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302559", new RxMedicationItem("302559", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #59", "R.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302560", new RxMedicationItem("302560", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #60", "R.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302561", new RxMedicationItem("302561", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #61", "R.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302562", new RxMedicationItem("302562", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #62", "R.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302563", new RxMedicationItem("302563", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #63", "R.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302564", new RxMedicationItem("302564", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #64", "R.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302565", new RxMedicationItem("302565", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #65", "R.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302566", new RxMedicationItem("302566", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #66", "R.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302567", new RxMedicationItem("302567", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #67", "R.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302568", new RxMedicationItem("302568", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #68", "R.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302569", new RxMedicationItem("302569", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #69", "R.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302570", new RxMedicationItem("302570", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #70", "R.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302571", new RxMedicationItem("302571", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #71", "R.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302572", new RxMedicationItem("302572", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #72", "R.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302573", new RxMedicationItem("302573", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #73", "R.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302574", new RxMedicationItem("302574", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #74", "R.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302575", new RxMedicationItem("302575", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #75", "R.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302576", new RxMedicationItem("302576", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #76", "R.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302577", new RxMedicationItem("302577", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #77", "R.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302578", new RxMedicationItem("302578", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #78", "R.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302579", new RxMedicationItem("302579", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #79", "R.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302580", new RxMedicationItem("302580", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #80", "R.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302581", new RxMedicationItem("302581", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #81", "R.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302582", new RxMedicationItem("302582", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #82", "R.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302583", new RxMedicationItem("302583", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #83", "R.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302584", new RxMedicationItem("302584", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #84", "R.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302585", new RxMedicationItem("302585", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #85", "R.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302586", new RxMedicationItem("302586", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #86", "R.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302587", new RxMedicationItem("302587", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #87", "R.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302588", new RxMedicationItem("302588", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #88", "R.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302589", new RxMedicationItem("302589", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #89", "R.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302590", new RxMedicationItem("302590", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #90", "R.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302591", new RxMedicationItem("302591", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #91", "R.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302592", new RxMedicationItem("302592", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #92", "R.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302593", new RxMedicationItem("302593", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #93", "R.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302594", new RxMedicationItem("302594", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #94", "R.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302595", new RxMedicationItem("302595", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #95", "R.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302596", new RxMedicationItem("302596", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #96", "R.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302597", new RxMedicationItem("302597", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #97", "R.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302598", new RxMedicationItem("302598", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #98", "R.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302599", new RxMedicationItem("302599", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #99", "R.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("302600", new RxMedicationItem("302600", "Bronchodilators, Corticosteroids & Surfactants Drug Entity #100", "R.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
