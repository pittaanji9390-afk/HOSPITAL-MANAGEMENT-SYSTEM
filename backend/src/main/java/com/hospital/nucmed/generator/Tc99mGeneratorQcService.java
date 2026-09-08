package com.hospital.nucmed.generator;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

/**
 * Technetium-99m Radiopharmacy Generator Quality Control Engine.
 * NRC & USP <825> Regulations:
 * 1. Molybdenum-99 Radionuclidic Breakthrough limit: strictly < 0.15 uCi of Mo-99 per 1.0 mCi of Tc-99m at the time of administration.
 * 2. Aluminum Ion (Al3+) Chemical Impurity: strictly < 10.0 ug/mL (aurintricarboxylic acid spot test).
 * 3. Radiochemical Purity (Instant Thin-Layer Chromatography ITLC): strictly >= 95.0% free TcO4-.
 */
@Service
public class Tc99mGeneratorQcService {

    public record GeneratorElutionRecord(
        String elutionId,
        String generatorLotNumber,
        double tc99mYieldMci,
        double mo99BreakthroughUci,
        double aluminumPpm,
        double itlcPurityPercent,
        Instant elutionTime
    ) {}

    public record QcEvaluationResult(
        boolean passedNrcBreakthroughLimit,
        boolean passedChemicalAluminumLimit,
        boolean passedItlcPurityLimit,
        double calculatedMo99RatioUciPerMci,
        boolean isSafeForPatientDispense,
        String qualitySummary
    ) {}

    public QcEvaluationResult evaluateElution(GeneratorElutionRecord e) {
        double ratio = e.mo99BreakthroughUci() / e.tc99mYieldMci();
        boolean passMo = ratio < 0.15;
        boolean passAl = e.aluminumPpm() < 10.0;
        boolean passItlc = e.itlcPurityPercent() >= 95.0;

        boolean passAll = passMo && passAl && passItlc;

        String summary = passAll
            ? "PASSED ALL USP <825> & NRC CRITERIA: Mo-99 ratio (" + String.format("%.4f", ratio) + " uCi/mCi) < 0.15. Safe for compounding."
            : "FAILED QC INTERCEPT: Exceeds regulatory impurity thresholds. Eluate must be quarantined and discarded.";

        return new QcEvaluationResult(passMo, passAl, passItlc, ratio, passAll, summary);
    }
}
