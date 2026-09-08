package com.hospital.hbot.osteo;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Cierny-Mader Staging System for Chronic Osteomyelitis (UHMS Approved Indication).
 * Combines Anatomic Type (1-Medullary, 2-Superficial, 3-Localized, 4-Diffuse)
 * and Physiologic Host Class (A-Normal, B-Systemic/Local Compromise, C-Treatment Prohibitive).
 * HBOT (2.4 ATA x 90 min x 30-40 sessions) stimulates osteoclast-mediated bone resorption of sequestrum and neovascularization.
 */
@Service
public class CiernyMaderOsteoService {

    public record OsteoProtocol(String stage, int recommendedHbotSessions, double targetAta, String surgicalAction) {}

    public OsteoProtocol evaluateOsteo(int anatomicType, String hostClass) {
        String stageName = "Cierny-Mader Stage " + anatomicType + hostClass;
        return new OsteoProtocol(stageName, 30, 2.4, "Surgical debridement of necrotic bone (sequestrectomy) + Culture-directed antibiotics + 30 HBOT sessions.");
    }
}
