package com.hospital.clinical.formulary;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Formulary Engine for EndocrineInsulinsAntidiabetics.
 * Standardizes drug monographs, mechanism of action, dosing titrations, and black box safety warnings.
 */
@Component
public class EndocrineInsulinsAntidiabeticsEngine {

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
        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-1", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #1",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-2", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #2",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-3", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #3",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-4", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #4",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-5", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #5",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-6", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #6",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-7", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #7",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-8", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #8",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-9", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #9",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-10", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #10",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-11", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #11",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-12", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #12",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-13", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #13",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-14", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #14",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-15", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #15",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-16", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #16",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-17", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #17",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-18", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #18",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-19", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #19",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-20", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #20",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-21", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #21",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-22", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #22",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-23", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #23",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-24", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #24",
            "Mechanism of Action & Clinical Pharmacodynamics: High-affinity selective receptor interaction modulating intracellular secondary messenger cascades and physiologic effector pathways.",
            "Therapeutic Indications: Primary clinical syndromes, FDA-approved indications, and off-label evidence-based applications in acute and ambulatory care.",
            "Standard Dosing & Renal/Hepatic Adjustments: Weight-based and eGFR-titrated dosage schedules with mandatory interval prolongation for renal impairment.",
            "Black Box Warnings & Adverse Drug Reactions: High-risk toxicities, drug-drug interaction contraindications, and mandatory baseline safety laboratory panels.");

        addMonograph("EndocrineInsulinsAntidiabetics-DRUG-25", "EndocrineInsulinsAntidiabetics Pharmaceutical Agent #25",
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
