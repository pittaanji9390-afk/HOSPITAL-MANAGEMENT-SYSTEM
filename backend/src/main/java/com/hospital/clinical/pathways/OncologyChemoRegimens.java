package com.hospital.clinical.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Medical Oncology & Chemotherapy Regimens Clinical Knowledge Base.
 * Implements NCCN (National Comprehensive Cancer Network) and ASCO standardized evidence-based protocols.
 */
@Component
public class OncologyChemoRegimens {

    @Data
    @Builder
    public static class ChemoDrugItem {
        private String drugName;
        private String genericName;
        private double standardDose;
        private String doseUnit; // mg/m2, mg/kg, AUC, Flat
        private String administrationRoute; // IV_INFUSION, IV_PUSH, ORAL, SUBCUTANEOUS
        private int durationMinutes;
        private String vehicleFluid; // 500 mL Normal Saline, 250 mL D5W
        private String sequenceOrder;
        private List<String> mandatoryPreMedications;
        private String toxicityMonitoring;
    }

    @Data
    @Builder
    public static class OncologyRegimen {
        private String regimenCode;
        private String regimenName;
        private String cancerType; // Breast, Colorectal, Lung, Lymphoma, etc.
        private String indication; // Adjuvant, Neoadjuvant, Palliative, First-line
        private int cycleLengthDays;
        private int totalPlannedCycles;
        private List<ChemoDrugItem> drugs;
        private List<String> antiEmeticProtocol;
        private List<String> labPrerequisites;
    }

    private static final List<OncologyRegimen> REGIMENS = new ArrayList<>();

    static {
        // 1. AC-T Regimen (Breast Cancer)
        List<ChemoDrugItem> actDrugs = Arrays.asList(
                ChemoDrugItem.builder()
                        .drugName("Doxorubicin (Adriamycin)")
                        .genericName("Doxorubicin Hydrochloride")
                        .standardDose(60.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_PUSH")
                        .durationMinutes(15)
                        .vehicleFluid("50 mL Normal Saline")
                        .sequenceOrder("Step 1 (Red Devil)")
                        .mandatoryPreMedications(Arrays.asList("Ondansetron 16 mg IV", "Dexamethasone 12 mg IV", "Aprepitant 125 mg PO"))
                        .toxicityMonitoring("Cardiotoxicity (Cumulative dose limit 450 mg/m2), Vesicant extravasation check")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Cyclophosphamide (Cytoxan)")
                        .genericName("Cyclophosphamide")
                        .standardDose(600.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(60)
                        .vehicleFluid("500 mL Normal Saline")
                        .sequenceOrder("Step 2")
                        .mandatoryPreMedications(Arrays.asList("Hydration IV 1000 mL Normal Saline"))
                        .toxicityMonitoring("Hemorrhagic cystitis, Myelosuppression (ANC nadir day 10-14)")
                        .build()
        );

        REGIMENS.add(OncologyRegimen.builder()
                .regimenCode("AC_BREAST")
                .regimenName("Doxorubicin + Cyclophosphamide (AC)")
                .cancerType("Invasive Ductal Carcinoma of Breast")
                .indication("Adjuvant / Neoadjuvant Curative Intent")
                .cycleLengthDays(21)
                .totalPlannedCycles(4)
                .drugs(actDrugs)
                .antiEmeticProtocol(Arrays.asList("Triple antiemetic: NK1 antagonist + 5-HT3 antagonist + Dexamethasone"))
                .labPrerequisites(Arrays.asList("ANC >= 1500/uL", "Platelets >= 100,000/uL", "LVEF >= 50% on Baseline Echocardiogram", "Total Bilirubin <= 1.5x ULN"))
                .build());

        // 2. FOLFOX6 Regimen (Colorectal Cancer)
        List<ChemoDrugItem> folfoxDrugs = Arrays.asList(
                ChemoDrugItem.builder()
                        .drugName("Oxaliplatin (Eloxatin)")
                        .genericName("Oxaliplatin")
                        .standardDose(85.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(120)
                        .vehicleFluid("500 mL 5% Dextrose in Water (D5W - DO NOT USE SALINE)")
                        .sequenceOrder("Step 1 (Concurrent with Leucovorin)")
                        .mandatoryPreMedications(Arrays.asList("Palonosetron 0.25 mg IV", "Dexamethasone 8 mg IV"))
                        .toxicityMonitoring("Acute cold-induced peripheral neuropathy (Avoid cold drinks/ice), Laryngopharyngeal dysesthesia")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Leucovorin (Folinic Acid)")
                        .genericName("Calcium Folinate")
                        .standardDose(400.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(120)
                        .vehicleFluid("500 mL D5W")
                        .sequenceOrder("Step 1 (Concurrent with Oxaliplatin)")
                        .mandatoryPreMedications(Collections.emptyList())
                        .toxicityMonitoring("Biochemical modulation of 5-FU")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Fluorouracil (5-FU Bolus)")
                        .genericName("5-Fluorouracil")
                        .standardDose(400.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_PUSH")
                        .durationMinutes(5)
                        .vehicleFluid("Direct IV Push")
                        .sequenceOrder("Step 2")
                        .mandatoryPreMedications(Collections.emptyList())
                        .toxicityMonitoring("Mucositis, Diarrhea, Myelosuppression")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Fluorouracil (5-FU Continuous Infusion)")
                        .genericName("5-Fluorouracil")
                        .standardDose(2400.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(2760) // 46 hours continuous via elastomeric pump
                        .vehicleFluid("Elastomeric Ambulatory Infusion Pump (Home Infusion)")
                        .sequenceOrder("Step 3 (46-hour pump)")
                        .mandatoryPreMedications(Collections.emptyList())
                        .toxicityMonitoring("Coronary vasospasm, Hand-Foot syndrome, DPD deficiency check")
                        .build()
        );

        REGIMENS.add(OncologyRegimen.builder()
                .regimenCode("FOLFOX_CRC")
                .regimenName("mFOLFOX6 (Oxaliplatin + Leucovorin + 5-FU)")
                .cancerType("Colorectal Adenocarcinoma (Stage III/IV)")
                .indication("Adjuvant post-resection or First-line metastatic")
                .cycleLengthDays(14)
                .totalPlannedCycles(12)
                .drugs(folfoxDrugs)
                .antiEmeticProtocol(Arrays.asList("Moderate emetogenic risk: 5-HT3 antagonist + Dexamethasone Day 1"))
                .labPrerequisites(Arrays.asList("ANC >= 1500/uL", "Platelets >= 100,000/uL", "AST/ALT <= 2.5x ULN", "Creatinine Clearance >= 50 mL/min"))
                .build());

        // 3. R-CHOP Regimen (Diffuse Large B-Cell Lymphoma - DLBCL)
        List<ChemoDrugItem> rchopDrugs = Arrays.asList(
                ChemoDrugItem.builder()
                        .drugName("Rituximab (MabThera)")
                        .genericName("Rituximab (Anti-CD20 Monoclonal Antibody)")
                        .standardDose(375.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(240)
                        .vehicleFluid("500 mL Normal Saline")
                        .sequenceOrder("Step 1")
                        .mandatoryPreMedications(Arrays.asList("Paracetamol 1000 mg PO", "Diphenhydramine 50 mg IV", "Hydrocortisone 100 mg IV"))
                        .toxicityMonitoring("Infusion-related reactions (Chills, Rigors, Bronchospasm), Hepatitis B viral reactivation screening")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Cyclophosphamide")
                        .genericName("Cyclophosphamide")
                        .standardDose(750.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(60)
                        .vehicleFluid("500 mL Normal Saline")
                        .sequenceOrder("Step 2")
                        .mandatoryPreMedications(Collections.singletonList("Ondansetron 8 mg IV"))
                        .toxicityMonitoring("Myelosuppression, Hemorrhagic cystitis")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Doxorubicin")
                        .genericName("Doxorubicin")
                        .standardDose(50.0)
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_PUSH")
                        .durationMinutes(15)
                        .vehicleFluid("50 mL Saline")
                        .sequenceOrder("Step 3")
                        .mandatoryPreMedications(Collections.emptyList())
                        .toxicityMonitoring("Ejection Fraction monitoring")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Vincristine (Oncovin)")
                        .genericName("Vincristine Sulfate")
                        .standardDose(1.4) // Max 2.0 mg cap
                        .doseUnit("mg/m2")
                        .administrationRoute("IV_INFUSION")
                        .durationMinutes(15)
                        .vehicleFluid("50 mL Normal Saline in minibag (FATAL IF GIVEN INTRATHECALLY)")
                        .sequenceOrder("Step 4")
                        .mandatoryPreMedications(Collections.emptyList())
                        .toxicityMonitoring("Peripheral neuropathy, Paralytic ileus, Severe constipation. Max dose capped at 2.0 mg.")
                        .build(),
                ChemoDrugItem.builder()
                        .drugName("Prednisone")
                        .genericName("Prednisolone")
                        .standardDose(100.0)
                        .doseUnit("Flat")
                        .administrationRoute("ORAL")
                        .durationMinutes(0)
                        .vehicleFluid("Oral Tablets")
                        .sequenceOrder("Daily Days 1 to 5")
                        .mandatoryPreMedications(Collections.singletonList("Pantoprazole 40 mg daily"))
                        .toxicityMonitoring("Hyperglycemia, Gastritis, Insomnia")
                        .build()
        );

        REGIMENS.add(OncologyRegimen.builder()
                .regimenCode("RCHOP_LYMPHOMA")
                .regimenName("R-CHOP (Rituximab + CHOP)")
                .cancerType("Diffuse Large B-Cell Non-Hodgkin Lymphoma")
                .indication("First-line Curative Immunochemotherapy")
                .cycleLengthDays(21)
                .totalPlannedCycles(6)
                .drugs(rchopDrugs)
                .antiEmeticProtocol(Arrays.asList("High emetogenic risk protocol on Day 1"))
                .labPrerequisites(Arrays.asList("HBsAg Negative (or on Entecavir prophylaxis)", "LVEF >= 50%", "ANC >= 1000/uL", "Platelets >= 75,000/uL"))
                .build());
    }

    /**
     * Calculates Body Surface Area (BSA) using the Mosteller Formula:
     * BSA (m2) = sqrt([Height (cm) x Weight (kg)] / 3600)
     */
    public BigDecimal calculateBsaMosteller(double heightCm, double weightKg) {
        if (heightCm <= 0 || weightKg <= 0) {
            return BigDecimal.valueOf(1.70); // Standard default BSA
        }
        double bsa = Math.sqrt((heightCm * weightKg) / 3600.0);
        return BigDecimal.valueOf(bsa).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates patient-specific individual dose based on Body Surface Area.
     */
    public BigDecimal calculateIndividualDose(double standardDosePerM2, BigDecimal bsa) {
        return BigDecimal.valueOf(standardDosePerM2)
                .multiply(bsa)
                .setScale(1, RoundingMode.HALF_UP);
    }

    public List<OncologyRegimen> getRegimens() {
        return REGIMENS;
    }

    public Optional<OncologyRegimen> getRegimenByCode(String code) {
        return REGIMENS.stream()
                .filter(r -> r.getRegimenCode().equalsIgnoreCase(code))
                .findFirst();
    }
}
