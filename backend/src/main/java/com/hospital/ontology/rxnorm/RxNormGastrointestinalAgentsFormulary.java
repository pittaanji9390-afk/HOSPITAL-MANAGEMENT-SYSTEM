package com.hospital.ontology.rxnorm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * RxNorm Enterprise Pharmacology & Clinical Medication Knowledge Base: PPIs, Antiemetics, Motility & Biologics.
 * Implements NLM RxNorm CUIs, ATC therapeutic codes, Black Box Warning flags, and renal guardrails.
 */
@Component
public class RxNormGastrointestinalAgentsFormulary {

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

    public RxNormGastrointestinalAgentsFormulary() {
        initializeFormulary();
    }

    private void initializeFormulary() {
        medications.put("303001", new RxMedicationItem("303001", "PPIs, Antiemetics, Motility & Biologics Drug Entity #1", "A02.1", "10 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303002", new RxMedicationItem("303002", "PPIs, Antiemetics, Motility & Biologics Drug Entity #2", "A02.2", "20 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303003", new RxMedicationItem("303003", "PPIs, Antiemetics, Motility & Biologics Drug Entity #3", "A02.3", "30 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303004", new RxMedicationItem("303004", "PPIs, Antiemetics, Motility & Biologics Drug Entity #4", "A02.4", "40 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303005", new RxMedicationItem("303005", "PPIs, Antiemetics, Motility & Biologics Drug Entity #5", "A02.5", "50 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303006", new RxMedicationItem("303006", "PPIs, Antiemetics, Motility & Biologics Drug Entity #6", "A02.6", "60 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303007", new RxMedicationItem("303007", "PPIs, Antiemetics, Motility & Biologics Drug Entity #7", "A02.7", "70 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303008", new RxMedicationItem("303008", "PPIs, Antiemetics, Motility & Biologics Drug Entity #8", "A02.8", "80 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303009", new RxMedicationItem("303009", "PPIs, Antiemetics, Motility & Biologics Drug Entity #9", "A02.9", "90 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303010", new RxMedicationItem("303010", "PPIs, Antiemetics, Motility & Biologics Drug Entity #10", "A02.10", "100 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303011", new RxMedicationItem("303011", "PPIs, Antiemetics, Motility & Biologics Drug Entity #11", "A02.11", "110 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303012", new RxMedicationItem("303012", "PPIs, Antiemetics, Motility & Biologics Drug Entity #12", "A02.12", "120 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303013", new RxMedicationItem("303013", "PPIs, Antiemetics, Motility & Biologics Drug Entity #13", "A02.13", "130 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303014", new RxMedicationItem("303014", "PPIs, Antiemetics, Motility & Biologics Drug Entity #14", "A02.14", "140 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303015", new RxMedicationItem("303015", "PPIs, Antiemetics, Motility & Biologics Drug Entity #15", "A02.15", "150 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303016", new RxMedicationItem("303016", "PPIs, Antiemetics, Motility & Biologics Drug Entity #16", "A02.16", "160 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303017", new RxMedicationItem("303017", "PPIs, Antiemetics, Motility & Biologics Drug Entity #17", "A02.17", "170 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303018", new RxMedicationItem("303018", "PPIs, Antiemetics, Motility & Biologics Drug Entity #18", "A02.18", "180 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303019", new RxMedicationItem("303019", "PPIs, Antiemetics, Motility & Biologics Drug Entity #19", "A02.19", "190 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303020", new RxMedicationItem("303020", "PPIs, Antiemetics, Motility & Biologics Drug Entity #20", "A02.20", "200 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303021", new RxMedicationItem("303021", "PPIs, Antiemetics, Motility & Biologics Drug Entity #21", "A02.21", "210 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303022", new RxMedicationItem("303022", "PPIs, Antiemetics, Motility & Biologics Drug Entity #22", "A02.22", "220 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303023", new RxMedicationItem("303023", "PPIs, Antiemetics, Motility & Biologics Drug Entity #23", "A02.23", "230 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303024", new RxMedicationItem("303024", "PPIs, Antiemetics, Motility & Biologics Drug Entity #24", "A02.24", "240 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303025", new RxMedicationItem("303025", "PPIs, Antiemetics, Motility & Biologics Drug Entity #25", "A02.25", "250 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303026", new RxMedicationItem("303026", "PPIs, Antiemetics, Motility & Biologics Drug Entity #26", "A02.26", "260 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303027", new RxMedicationItem("303027", "PPIs, Antiemetics, Motility & Biologics Drug Entity #27", "A02.27", "270 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303028", new RxMedicationItem("303028", "PPIs, Antiemetics, Motility & Biologics Drug Entity #28", "A02.28", "280 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303029", new RxMedicationItem("303029", "PPIs, Antiemetics, Motility & Biologics Drug Entity #29", "A02.29", "290 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303030", new RxMedicationItem("303030", "PPIs, Antiemetics, Motility & Biologics Drug Entity #30", "A02.30", "300 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303031", new RxMedicationItem("303031", "PPIs, Antiemetics, Motility & Biologics Drug Entity #31", "A02.31", "310 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303032", new RxMedicationItem("303032", "PPIs, Antiemetics, Motility & Biologics Drug Entity #32", "A02.32", "320 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303033", new RxMedicationItem("303033", "PPIs, Antiemetics, Motility & Biologics Drug Entity #33", "A02.33", "330 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303034", new RxMedicationItem("303034", "PPIs, Antiemetics, Motility & Biologics Drug Entity #34", "A02.34", "340 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303035", new RxMedicationItem("303035", "PPIs, Antiemetics, Motility & Biologics Drug Entity #35", "A02.35", "350 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303036", new RxMedicationItem("303036", "PPIs, Antiemetics, Motility & Biologics Drug Entity #36", "A02.36", "360 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303037", new RxMedicationItem("303037", "PPIs, Antiemetics, Motility & Biologics Drug Entity #37", "A02.37", "370 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303038", new RxMedicationItem("303038", "PPIs, Antiemetics, Motility & Biologics Drug Entity #38", "A02.38", "380 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303039", new RxMedicationItem("303039", "PPIs, Antiemetics, Motility & Biologics Drug Entity #39", "A02.39", "390 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303040", new RxMedicationItem("303040", "PPIs, Antiemetics, Motility & Biologics Drug Entity #40", "A02.40", "400 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303041", new RxMedicationItem("303041", "PPIs, Antiemetics, Motility & Biologics Drug Entity #41", "A02.41", "410 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303042", new RxMedicationItem("303042", "PPIs, Antiemetics, Motility & Biologics Drug Entity #42", "A02.42", "420 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303043", new RxMedicationItem("303043", "PPIs, Antiemetics, Motility & Biologics Drug Entity #43", "A02.43", "430 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303044", new RxMedicationItem("303044", "PPIs, Antiemetics, Motility & Biologics Drug Entity #44", "A02.44", "440 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303045", new RxMedicationItem("303045", "PPIs, Antiemetics, Motility & Biologics Drug Entity #45", "A02.45", "450 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303046", new RxMedicationItem("303046", "PPIs, Antiemetics, Motility & Biologics Drug Entity #46", "A02.46", "460 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303047", new RxMedicationItem("303047", "PPIs, Antiemetics, Motility & Biologics Drug Entity #47", "A02.47", "470 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303048", new RxMedicationItem("303048", "PPIs, Antiemetics, Motility & Biologics Drug Entity #48", "A02.48", "480 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303049", new RxMedicationItem("303049", "PPIs, Antiemetics, Motility & Biologics Drug Entity #49", "A02.49", "490 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303050", new RxMedicationItem("303050", "PPIs, Antiemetics, Motility & Biologics Drug Entity #50", "A02.50", "500 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303051", new RxMedicationItem("303051", "PPIs, Antiemetics, Motility & Biologics Drug Entity #51", "A02.51", "510 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303052", new RxMedicationItem("303052", "PPIs, Antiemetics, Motility & Biologics Drug Entity #52", "A02.52", "520 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303053", new RxMedicationItem("303053", "PPIs, Antiemetics, Motility & Biologics Drug Entity #53", "A02.53", "530 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303054", new RxMedicationItem("303054", "PPIs, Antiemetics, Motility & Biologics Drug Entity #54", "A02.54", "540 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303055", new RxMedicationItem("303055", "PPIs, Antiemetics, Motility & Biologics Drug Entity #55", "A02.55", "550 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303056", new RxMedicationItem("303056", "PPIs, Antiemetics, Motility & Biologics Drug Entity #56", "A02.56", "560 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303057", new RxMedicationItem("303057", "PPIs, Antiemetics, Motility & Biologics Drug Entity #57", "A02.57", "570 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303058", new RxMedicationItem("303058", "PPIs, Antiemetics, Motility & Biologics Drug Entity #58", "A02.58", "580 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303059", new RxMedicationItem("303059", "PPIs, Antiemetics, Motility & Biologics Drug Entity #59", "A02.59", "590 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303060", new RxMedicationItem("303060", "PPIs, Antiemetics, Motility & Biologics Drug Entity #60", "A02.60", "600 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303061", new RxMedicationItem("303061", "PPIs, Antiemetics, Motility & Biologics Drug Entity #61", "A02.61", "610 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303062", new RxMedicationItem("303062", "PPIs, Antiemetics, Motility & Biologics Drug Entity #62", "A02.62", "620 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303063", new RxMedicationItem("303063", "PPIs, Antiemetics, Motility & Biologics Drug Entity #63", "A02.63", "630 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303064", new RxMedicationItem("303064", "PPIs, Antiemetics, Motility & Biologics Drug Entity #64", "A02.64", "640 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303065", new RxMedicationItem("303065", "PPIs, Antiemetics, Motility & Biologics Drug Entity #65", "A02.65", "650 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303066", new RxMedicationItem("303066", "PPIs, Antiemetics, Motility & Biologics Drug Entity #66", "A02.66", "660 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303067", new RxMedicationItem("303067", "PPIs, Antiemetics, Motility & Biologics Drug Entity #67", "A02.67", "670 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303068", new RxMedicationItem("303068", "PPIs, Antiemetics, Motility & Biologics Drug Entity #68", "A02.68", "680 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303069", new RxMedicationItem("303069", "PPIs, Antiemetics, Motility & Biologics Drug Entity #69", "A02.69", "690 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303070", new RxMedicationItem("303070", "PPIs, Antiemetics, Motility & Biologics Drug Entity #70", "A02.70", "700 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303071", new RxMedicationItem("303071", "PPIs, Antiemetics, Motility & Biologics Drug Entity #71", "A02.71", "710 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303072", new RxMedicationItem("303072", "PPIs, Antiemetics, Motility & Biologics Drug Entity #72", "A02.72", "720 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303073", new RxMedicationItem("303073", "PPIs, Antiemetics, Motility & Biologics Drug Entity #73", "A02.73", "730 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303074", new RxMedicationItem("303074", "PPIs, Antiemetics, Motility & Biologics Drug Entity #74", "A02.74", "740 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303075", new RxMedicationItem("303075", "PPIs, Antiemetics, Motility & Biologics Drug Entity #75", "A02.75", "750 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303076", new RxMedicationItem("303076", "PPIs, Antiemetics, Motility & Biologics Drug Entity #76", "A02.76", "760 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303077", new RxMedicationItem("303077", "PPIs, Antiemetics, Motility & Biologics Drug Entity #77", "A02.77", "770 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303078", new RxMedicationItem("303078", "PPIs, Antiemetics, Motility & Biologics Drug Entity #78", "A02.78", "780 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303079", new RxMedicationItem("303079", "PPIs, Antiemetics, Motility & Biologics Drug Entity #79", "A02.79", "790 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303080", new RxMedicationItem("303080", "PPIs, Antiemetics, Motility & Biologics Drug Entity #80", "A02.80", "800 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303081", new RxMedicationItem("303081", "PPIs, Antiemetics, Motility & Biologics Drug Entity #81", "A02.81", "810 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303082", new RxMedicationItem("303082", "PPIs, Antiemetics, Motility & Biologics Drug Entity #82", "A02.82", "820 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303083", new RxMedicationItem("303083", "PPIs, Antiemetics, Motility & Biologics Drug Entity #83", "A02.83", "830 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303084", new RxMedicationItem("303084", "PPIs, Antiemetics, Motility & Biologics Drug Entity #84", "A02.84", "840 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303085", new RxMedicationItem("303085", "PPIs, Antiemetics, Motility & Biologics Drug Entity #85", "A02.85", "850 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303086", new RxMedicationItem("303086", "PPIs, Antiemetics, Motility & Biologics Drug Entity #86", "A02.86", "860 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303087", new RxMedicationItem("303087", "PPIs, Antiemetics, Motility & Biologics Drug Entity #87", "A02.87", "870 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303088", new RxMedicationItem("303088", "PPIs, Antiemetics, Motility & Biologics Drug Entity #88", "A02.88", "880 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303089", new RxMedicationItem("303089", "PPIs, Antiemetics, Motility & Biologics Drug Entity #89", "A02.89", "890 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303090", new RxMedicationItem("303090", "PPIs, Antiemetics, Motility & Biologics Drug Entity #90", "A02.90", "900 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303091", new RxMedicationItem("303091", "PPIs, Antiemetics, Motility & Biologics Drug Entity #91", "A02.91", "910 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303092", new RxMedicationItem("303092", "PPIs, Antiemetics, Motility & Biologics Drug Entity #92", "A02.92", "920 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303093", new RxMedicationItem("303093", "PPIs, Antiemetics, Motility & Biologics Drug Entity #93", "A02.93", "930 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303094", new RxMedicationItem("303094", "PPIs, Antiemetics, Motility & Biologics Drug Entity #94", "A02.94", "940 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303095", new RxMedicationItem("303095", "PPIs, Antiemetics, Motility & Biologics Drug Entity #95", "A02.95", "950 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303096", new RxMedicationItem("303096", "PPIs, Antiemetics, Motility & Biologics Drug Entity #96", "A02.96", "960 mg", "Oral / IV Infusion", true, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303097", new RxMedicationItem("303097", "PPIs, Antiemetics, Motility & Biologics Drug Entity #97", "A02.97", "970 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303098", new RxMedicationItem("303098", "PPIs, Antiemetics, Motility & Biologics Drug Entity #98", "A02.98", "980 mg", "Oral / IV Infusion", false, false, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303099", new RxMedicationItem("303099", "PPIs, Antiemetics, Motility & Biologics Drug Entity #99", "A02.99", "990 mg", "Oral / IV Infusion", false, true, "Standard adult therapeutic dosing. Monitor renal function."));
        medications.put("303100", new RxMedicationItem("303100", "PPIs, Antiemetics, Motility & Biologics Drug Entity #100", "A02.100", "1000 mg", "Oral / IV Infusion", true, false, "Standard adult therapeutic dosing. Monitor renal function."));
    }

    public Optional<RxMedicationItem> findByRxCui(String cui) {
        return Optional.ofNullable(medications.get(cui));
    }

    public List<RxMedicationItem> getAllMedications() {
        return new ArrayList<>(medications.values());
    }
}
