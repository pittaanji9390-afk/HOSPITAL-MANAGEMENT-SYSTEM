package com.hospital.clinical.formulary;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Formulary Engine for PulmonaryBronchodilators.
 * Standardizes drug monographs, mechanism of action, dosing titrations, and black box safety warnings.
 */
@Component
public class PulmonaryBronchodilatorsEngine {

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
        addMonograph("PulmonaryBronchodilators-DRUG-1", "PulmonaryBronchodilators Pharmaceutical Agent #1",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-2", "PulmonaryBronchodilators Pharmaceutical Agent #2",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-3", "PulmonaryBronchodilators Pharmaceutical Agent #3",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-4", "PulmonaryBronchodilators Pharmaceutical Agent #4",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-5", "PulmonaryBronchodilators Pharmaceutical Agent #5",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-6", "PulmonaryBronchodilators Pharmaceutical Agent #6",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-7", "PulmonaryBronchodilators Pharmaceutical Agent #7",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-8", "PulmonaryBronchodilators Pharmaceutical Agent #8",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-9", "PulmonaryBronchodilators Pharmaceutical Agent #9",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-10", "PulmonaryBronchodilators Pharmaceutical Agent #10",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-11", "PulmonaryBronchodilators Pharmaceutical Agent #11",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-12", "PulmonaryBronchodilators Pharmaceutical Agent #12",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-13", "PulmonaryBronchodilators Pharmaceutical Agent #13",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-14", "PulmonaryBronchodilators Pharmaceutical Agent #14",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-15", "PulmonaryBronchodilators Pharmaceutical Agent #15",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-16", "PulmonaryBronchodilators Pharmaceutical Agent #16",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-17", "PulmonaryBronchodilators Pharmaceutical Agent #17",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-18", "PulmonaryBronchodilators Pharmaceutical Agent #18",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-19", "PulmonaryBronchodilators Pharmaceutical Agent #19",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-20", "PulmonaryBronchodilators Pharmaceutical Agent #20",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-21", "PulmonaryBronchodilators Pharmaceutical Agent #21",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-22", "PulmonaryBronchodilators Pharmaceutical Agent #22",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-23", "PulmonaryBronchodilators Pharmaceutical Agent #23",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-24", "PulmonaryBronchodilators Pharmaceutical Agent #24",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("PulmonaryBronchodilators-DRUG-25", "PulmonaryBronchodilators Pharmaceutical Agent #25",
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
