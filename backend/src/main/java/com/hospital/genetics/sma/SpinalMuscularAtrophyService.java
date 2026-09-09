package com.hospital.genetics.sma;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Spinal Muscular Atrophy (SMA) Molecular Classification Engine (CureSMA Guidelines).
 * Evaluates homozygous deletion of SMN1 (Exon 7/8) and counts SMN2 backup copy number (1 to 5 copies)
 * to predict SMA Type (Type 0, 1, 2, 3, 4) and match with disease-modifying therapies:
 * - Onasemnogene abeparvovec (Zolgensma AAV9 gene therapy < 2y),
 * - Nusinersen (Spinraza antisense intrathecal),
 * - Risdiplam (Evrysdi oral SMN2 splicing modifier).
 */
@Service
public class SpinalMuscularAtrophyService {

    public record SmaGenotype(int smn1Exon7CopyNumber, int smn2BackupCopyNumber, int ageMonths) {}
    public record SmaClinicalStratification(String smaPhenotype, String expectedSeverity, String precisionTherapyOptions) {}

    public SmaClinicalStratification evaluateSma(SmaGenotype g) {
        if (g.smn1Exon7CopyNumber() > 0) {
            return new SmaClinicalStratification("UNAFFECTED / CARRIER", "No SMN1 homozygous deletion detected.", "Standard newborn screening follow-up.");
        }

        String type;
        String severity;
        if (g.smn2BackupCopyNumber() <= 1) {
            type = "SMA TYPE 0 / 1A (VERY SEVERE)";
            severity = "Severe hypotonia, respiratory failure at birth or < 1 month.";
        } else if (g.smn2BackupCopyNumber() == 2) {
            type = "SMA TYPE 1 (WERDNIG-HOFFMANN - SEVERE)";
            severity = "Never sits independently, onset < 6 months.";
        } else if (g.smn2BackupCopyNumber() == 3) {
            type = "SMA TYPE 2 (DUBOWITZ - INTERMEDIATE)";
            severity = "Sits but never walks independently, onset 6-18 months.";
        } else {
            type = "SMA TYPE 3 / 4 (KUGELBERG-WELANDER - MILD/ADULT)";
            severity = "Achieves independent ambulation, onset > 18 months.";
        }

        String therapies = g.ageMonths() <= 24 ? "First-Line: Onasemnogene abeparvovec-xioi (Zolgensma) one-time IV gene replacement or Risdiplam / Nusinersen." : "Risdiplam oral daily or Nusinersen intrathecal loading.";

        return new SmaClinicalStratification(type, severity, therapies);
    }
}
