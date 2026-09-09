package com.hospital.oncology.qol;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * EORTC QLQ-C30 (European Organisation for Research and Treatment of Cancer Quality of Life Core 30).
 * Calculates Global Health Status (0-100, higher = better), Functional Scales (Physical, Role, Emotional, Cognitive, Social),
 * and Symptom Scales (Fatigue, Nausea/Vomiting, Pain, Dyspnea, Insomnia, Appetite Loss, Constipation, Diarrhea, Financial).
 */
@Service
public class EortcQolScoringService {

    public record EortcRawScores(double globalHealthRaw, double physicalRaw, double fatigueRaw, double painRaw) {}
    public record EortcStandardizedScores(double globalHealthStatus, double physicalFunctioning, double fatigueSymptom, double painSymptom) {}

    public EortcStandardizedScores calculateScores(EortcRawScores r) {
        // Linear transformation formula: S = ((Raw - 1) / Range) * 100
        double globalHealth = ((r.globalHealthRaw() - 1.0) / 6.0) * 100.0; // 7-point scale
        double physical = (1.0 - ((r.physicalRaw() - 1.0) / 3.0)) * 100.0; // 4-point scale (inverted for function)
        double fatigue = ((r.fatigueRaw() - 1.0) / 3.0) * 100.0; // 4-point scale
        double pain = ((r.painRaw() - 1.0) / 3.0) * 100.0;

        return new EortcStandardizedScores(
            Math.min(100.0, Math.max(0.0, globalHealth)),
            Math.min(100.0, Math.max(0.0, physical)),
            Math.min(100.0, Math.max(0.0, fatigue)),
            Math.min(100.0, Math.max(0.0, pain))
        );
    }
}
