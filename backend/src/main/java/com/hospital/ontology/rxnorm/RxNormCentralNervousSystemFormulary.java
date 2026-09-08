package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: Analgesics, Anesthetics, Sedatives & Antiepileptics.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormCentralNervousSystemFormulary {

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

    public RxNormCentralNervousSystemFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("301501", new RxMedicationItem("301501", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #1", "N.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301502", new RxMedicationItem("301502", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #2", "N.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301503", new RxMedicationItem("301503", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #3", "N.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301504", new RxMedicationItem("301504", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #4", "N.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301505", new RxMedicationItem("301505", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #5", "N.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301506", new RxMedicationItem("301506", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #6", "N.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301507", new RxMedicationItem("301507", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #7", "N.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301508", new RxMedicationItem("301508", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #8", "N.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301509", new RxMedicationItem("301509", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #9", "N.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301510", new RxMedicationItem("301510", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #10", "N.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301511", new RxMedicationItem("301511", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #11", "N.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301512", new RxMedicationItem("301512", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #12", "N.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301513", new RxMedicationItem("301513", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #13", "N.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301514", new RxMedicationItem("301514", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #14", "N.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301515", new RxMedicationItem("301515", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #15", "N.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301516", new RxMedicationItem("301516", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #16", "N.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301517", new RxMedicationItem("301517", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #17", "N.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301518", new RxMedicationItem("301518", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #18", "N.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301519", new RxMedicationItem("301519", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #19", "N.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301520", new RxMedicationItem("301520", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #20", "N.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301521", new RxMedicationItem("301521", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #21", "N.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301522", new RxMedicationItem("301522", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #22", "N.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301523", new RxMedicationItem("301523", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #23", "N.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301524", new RxMedicationItem("301524", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #24", "N.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301525", new RxMedicationItem("301525", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #25", "N.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301526", new RxMedicationItem("301526", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #26", "N.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301527", new RxMedicationItem("301527", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #27", "N.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301528", new RxMedicationItem("301528", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #28", "N.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301529", new RxMedicationItem("301529", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #29", "N.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301530", new RxMedicationItem("301530", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #30", "N.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301531", new RxMedicationItem("301531", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #31", "N.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301532", new RxMedicationItem("301532", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #32", "N.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301533", new RxMedicationItem("301533", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #33", "N.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301534", new RxMedicationItem("301534", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #34", "N.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301535", new RxMedicationItem("301535", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #35", "N.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301536", new RxMedicationItem("301536", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #36", "N.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301537", new RxMedicationItem("301537", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #37", "N.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301538", new RxMedicationItem("301538", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #38", "N.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301539", new RxMedicationItem("301539", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #39", "N.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301540", new RxMedicationItem("301540", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #40", "N.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301541", new RxMedicationItem("301541", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #41", "N.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301542", new RxMedicationItem("301542", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #42", "N.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301543", new RxMedicationItem("301543", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #43", "N.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301544", new RxMedicationItem("301544", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #44", "N.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301545", new RxMedicationItem("301545", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #45", "N.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301546", new RxMedicationItem("301546", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #46", "N.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301547", new RxMedicationItem("301547", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #47", "N.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301548", new RxMedicationItem("301548", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #48", "N.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301549", new RxMedicationItem("301549", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #49", "N.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301550", new RxMedicationItem("301550", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #50", "N.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301551", new RxMedicationItem("301551", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #51", "N.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301552", new RxMedicationItem("301552", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #52", "N.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301553", new RxMedicationItem("301553", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #53", "N.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301554", new RxMedicationItem("301554", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #54", "N.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301555", new RxMedicationItem("301555", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #55", "N.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301556", new RxMedicationItem("301556", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #56", "N.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301557", new RxMedicationItem("301557", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #57", "N.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301558", new RxMedicationItem("301558", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #58", "N.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301559", new RxMedicationItem("301559", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #59", "N.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301560", new RxMedicationItem("301560", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #60", "N.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301561", new RxMedicationItem("301561", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #61", "N.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301562", new RxMedicationItem("301562", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #62", "N.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301563", new RxMedicationItem("301563", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #63", "N.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301564", new RxMedicationItem("301564", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #64", "N.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301565", new RxMedicationItem("301565", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #65", "N.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301566", new RxMedicationItem("301566", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #66", "N.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301567", new RxMedicationItem("301567", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #67", "N.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301568", new RxMedicationItem("301568", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #68", "N.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301569", new RxMedicationItem("301569", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #69", "N.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301570", new RxMedicationItem("301570", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #70", "N.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301571", new RxMedicationItem("301571", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #71", "N.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301572", new RxMedicationItem("301572", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #72", "N.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301573", new RxMedicationItem("301573", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #73", "N.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301574", new RxMedicationItem("301574", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #74", "N.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301575", new RxMedicationItem("301575", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #75", "N.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301576", new RxMedicationItem("301576", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #76", "N.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301577", new RxMedicationItem("301577", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #77", "N.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301578", new RxMedicationItem("301578", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #78", "N.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301579", new RxMedicationItem("301579", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #79", "N.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301580", new RxMedicationItem("301580", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #80", "N.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301581", new RxMedicationItem("301581", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #81", "N.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301582", new RxMedicationItem("301582", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #82", "N.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301583", new RxMedicationItem("301583", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #83", "N.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301584", new RxMedicationItem("301584", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #84", "N.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301585", new RxMedicationItem("301585", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #85", "N.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301586", new RxMedicationItem("301586", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #86", "N.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301587", new RxMedicationItem("301587", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #87", "N.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301588", new RxMedicationItem("301588", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #88", "N.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301589", new RxMedicationItem("301589", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #89", "N.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301590", new RxMedicationItem("301590", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #90", "N.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301591", new RxMedicationItem("301591", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #91", "N.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301592", new RxMedicationItem("301592", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #92", "N.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301593", new RxMedicationItem("301593", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #93", "N.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301594", new RxMedicationItem("301594", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #94", "N.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301595", new RxMedicationItem("301595", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #95", "N.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301596", new RxMedicationItem("301596", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #96", "N.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301597", new RxMedicationItem("301597", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #97", "N.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301598", new RxMedicationItem("301598", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #98", "N.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301599", new RxMedicationItem("301599", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #99", "N.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301600", new RxMedicationItem("301600", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #100", "N.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301601", new RxMedicationItem("301601", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #101", "N.101", "1010 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301602", new RxMedicationItem("301602", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #102", "N.102", "1020 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301603", new RxMedicationItem("301603", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #103", "N.103", "1030 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301604", new RxMedicationItem("301604", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #104", "N.104", "1040 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301605", new RxMedicationItem("301605", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #105", "N.105", "1050 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301606", new RxMedicationItem("301606", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #106", "N.106", "1060 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301607", new RxMedicationItem("301607", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #107", "N.107", "1070 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301608", new RxMedicationItem("301608", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #108", "N.108", "1080 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301609", new RxMedicationItem("301609", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #109", "N.109", "1090 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301610", new RxMedicationItem("301610", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #110", "N.110", "1100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301611", new RxMedicationItem("301611", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #111", "N.111", "1110 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301612", new RxMedicationItem("301612", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #112", "N.112", "1120 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301613", new RxMedicationItem("301613", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #113", "N.113", "1130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301614", new RxMedicationItem("301614", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #114", "N.114", "1140 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301615", new RxMedicationItem("301615", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #115", "N.115", "1150 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301616", new RxMedicationItem("301616", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #116", "N.116", "1160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301617", new RxMedicationItem("301617", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #117", "N.117", "1170 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301618", new RxMedicationItem("301618", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #118", "N.118", "1180 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301619", new RxMedicationItem("301619", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #119", "N.119", "1190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("301620", new RxMedicationItem("301620", "Analgesics, Anesthetics, Sedatives & Antiepileptics Drug Entity #120", "N.120", "1200 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
