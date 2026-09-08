package com.hospital.clinical.formulary;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Formulary Engine for ImmunologyBiologicsAntiTnf.
 * Standardizes drug monographs, mechanism of action, dosing titrations, and black box safety warnings.
 */
@Component
public class ImmunologyBiologicsAntiTnfEngine {

    @Data
    @Builder
    public static class DrugMonograph {
        private String drugCode;
        private String drugName;
        private String mechanismOfAction;
        private String indications;
        private String dosingAndAdjustments;
        private String warningsAndSafety;
    }

    private static final List<DrugMonograph> CATALOG = new ArrayList<>();

    static {
        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-1", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #1",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-2", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #2",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-3", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #3",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-4", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #4",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-5", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #5",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-6", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #6",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-7", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #7",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-8", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #8",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-9", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #9",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-10", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #10",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-11", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #11",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-12", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #12",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-13", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #13",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-14", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #14",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-15", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #15",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-16", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #16",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-17", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #17",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-18", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #18",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-19", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #19",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-20", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #20",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-21", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #21",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-22", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #22",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-23", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #23",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-24", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #24",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("ImmunologyBiologicsAntiTnf-DRUG-25", "ImmunologyBiologicsAntiTnf Pharmaceutical Agent #25",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

    }

    private static void addMonograph(String code, String name, String moa, String ind, String dose, String warn) {
        CATALOG.add(DrugMonograph.builder()
                .drugCode(code)
                .drugName(name)
                .mechanismOfAction(moa)
                .indications(ind)
                .dosingAndAdjustments(dose)
                .warningsAndSafety(warn)
                .build());
    }

    public List<DrugMonograph> getAllMonographs() {
        return Collections.unmodifiableList(CATALOG);
    }

    public Optional<DrugMonograph> findByCode(String code) {
        if (code == null) return Optional.empty();
        return CATALOG.stream()
                .filter(m -> m.getDrugCode().equalsIgnoreCase(code.trim()))
                .findFirst();
    }

    public List<DrugMonograph> search(String query) {
        if (query == null || query.isBlank()) return CATALOG;
        String q = query.toLowerCase().trim();
        return CATALOG.stream()
                .filter(m -> m.getDrugCode().toLowerCase().contains(q) ||
                             m.getDrugName().toLowerCase().contains(q) ||
                             m.getIndications().toLowerCase().contains(q) ||
                             m.getWarningsAndSafety().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
