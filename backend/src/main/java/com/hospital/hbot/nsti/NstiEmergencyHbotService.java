package com.hospital.hbot.nsti;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Emergency HBOT Protocol for Necrotizing Soft Tissue Infections (NSTI), Gas Gangrene (Clostridium perfringens),
 * and Fournier Gangrene (UHMS Category 1 Emergency Indication).
 * Inhibits alpha-toxin production at PO2 > 250 mmHg, bactericidal to obligate anaerobes, promotes leukocyte oxidative burst.
 */
@Service
public class NstiEmergencyHbotService {

    public record NstiHbotDirective(String infectionType, double targetPressureAta, int sessionDurationMinutes, int frequencyHours, String surgicalDebridementPrerequisite) {}

    public NstiHbotDirective getEmergencyProtocol(String infectionType) {
        return new NstiHbotDirective(
            infectionType,
            3.0, // 3.0 ATA for clostridial myonecrosis to arrest alpha-toxin
            90,
            8, // Q8H for first 24 hours, then BID
            "MANDATORY: Emergent surgical debridement must not be delayed for HBOT. HBOT is an adjunctive therapy following initial operating room source control."
        );
    }
}
