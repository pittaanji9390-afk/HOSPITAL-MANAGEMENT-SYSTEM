package com.hospital.nucmed.ga68;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Germanium-68 / Gallium-68 (Ge-68/Ga-68) Generator & Radiopharmaceutical Quality Control (USP <825>).
 * Calculates Ge-68 Breakthrough limit (< 0.001%) and Radiochemical Purity of Ga-68 DOTATOC / PSMA-11 (ITLC >= 95.0%).
 */
@Service
public class Ga68RadiopharmacyService {

    public record Ga68QcRecord(String tracerName, double eluateActivityMci, double ge68BreakthroughPercent, double itlcPurityPercent) {}
    public record Ga68ReleaseResult(boolean releasedForInjection, String qualityAuditMessage) {}

    public Ga68ReleaseResult testPurity(Ga68QcRecord rec) {
        boolean passGe = rec.ge68BreakthroughPercent() < 0.001;
        boolean passItlc = rec.itlcPurityPercent() >= 95.0;

        boolean pass = passGe && passItlc;
        String msg = pass
            ? "RELEASED: Ga-68 purity " + rec.itlcPurityPercent() + "% >= 95% and Ge-68 breakthrough < 0.001%."
            : "REJECTED: Purity failure. Radio-colloids or Germanium breakthrough detected.";

        return new Ga68ReleaseResult(pass, msg);
    }
}
