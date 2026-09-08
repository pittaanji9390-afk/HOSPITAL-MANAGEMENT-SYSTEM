package com.hospital.hbot.marx;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Marx Protocol for Osteoradionecrosis (ORN) and Late Radiation Tissue Injury (Radiation Cystitis, Proctitis, Soft Tissue Necrosis).
 * - Marx Stage I: 30 pre-debridement HBOT sessions (2.4 ATA x 90 min) -> full mucosal cover or proceed to Stage II.
 * - Marx Stage II: Debridement followed by 10 post-op HBOT sessions.
 * - Marx Stage III: Radical resection + vascularized flap reconstruction + 30 pre-op / 10 post-op HBOT sessions.
 */
@Service
public class MarxRadiationInjuryService {

    public record MarxPlan(int stage, int preOpSessions, int postOpSessions, double targetAta, String surgicalAction) {}

    public MarxPlan getMarxProtocol(int stage) {
        if (stage == 1) {
            return new MarxPlan(1, 30, 0, 2.4, "Evaluate for spontaneous mucosal healing. If bone exposed after 30 sessions, advance to Stage II.");
        } else if (stage == 2) {
            return new MarxPlan(2, 30, 10, 2.4, "Perform transoral alveolar debridement followed by 10 post-operative HBOT sessions.");
        } else {
            return new MarxPlan(3, 30, 10, 2.4, "Radical segmental mandibular resection, external fixation/vascularized fibular flap + 10 post-op sessions.");
        }
    }
}
