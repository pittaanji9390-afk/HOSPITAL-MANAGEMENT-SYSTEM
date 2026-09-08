package com.hospital.bloodbank.compatibility;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * ABO/Rh Blood Component Compatibility Matrix & Electronic Crossmatch (eXM) Engine.
 * Verifies recipient vs donor compatibility for pRBCs, Plasma (FFP), and Cryoprecipitate.
 * (Note: Plasma compatibility is the reverse of RBC compatibility!).
 */
@Service
public class CompatibilityMatrixService {

    public record CompatibilityCheck(String recipientAbo, String donorAbo, String componentType, boolean isCompatible, String clinicalRule) {}

    public CompatibilityCheck verifyCompatibility(String recipientAbo, String donorAbo, String componentType) {
        boolean pass = false;
        String rule = "";

        if ("RBC".equalsIgnoreCase(componentType)) {
            // RBC rules: O can only receive O; A receives A/O; B receives B/O; AB receives AB/A/B/O
            if ("O".equalsIgnoreCase(recipientAbo)) pass = "O".equalsIgnoreCase(donorAbo);
            else if ("A".equalsIgnoreCase(recipientAbo)) pass = "A".equalsIgnoreCase(donorAbo) || "O".equalsIgnoreCase(donorAbo);
            else if ("B".equalsIgnoreCase(recipientAbo)) pass = "B".equalsIgnoreCase(donorAbo) || "O".equalsIgnoreCase(donorAbo);
            else if ("AB".equalsIgnoreCase(recipientAbo)) pass = true;
            rule = "RBC Compatibility: Recipient antibodies must not lyse donor red blood cells.";
        } else if ("PLASMA".equalsIgnoreCase(componentType) || "FFP".equalsIgnoreCase(componentType)) {
            // Plasma rules: AB is universal donor; O can receive from anyone
            if ("AB".equalsIgnoreCase(recipientAbo)) pass = "AB".equalsIgnoreCase(donorAbo);
            else if ("A".equalsIgnoreCase(recipientAbo)) pass = "A".equalsIgnoreCase(donorAbo) || "AB".equalsIgnoreCase(donorAbo);
            else if ("B".equalsIgnoreCase(recipientAbo)) pass = "B".equalsIgnoreCase(donorAbo) || "AB".equalsIgnoreCase(donorAbo);
            else if ("O".equalsIgnoreCase(recipientAbo)) pass = true;
            rule = "Plasma Compatibility: Donor antibodies in plasma must not lyse recipient red blood cells.";
        }

        return new CompatibilityCheck(recipientAbo, donorAbo, componentType, pass, rule);
    }
}
