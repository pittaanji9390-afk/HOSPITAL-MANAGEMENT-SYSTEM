package com.hospital.pharmacy.ismp;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Institute for Safe Medication Practices (ISMP) High-Alert Medication Guardrails.
 * Enforces independent dual-nurse signature workflows for PINCH drugs:
 * Potassium, Insulin, Narcotics, Chemotherapy, Heparin / Anticoagulants.
 */
@Service
public class IsmpDoubleCheckService {

    public enum HighAlertCategory { POTASSIUM_IV_BOLUS, INSULIN_INFUSION, OPIOID_PCA, CHEMOTHERAPY_CYTOTOXIC, HEPARIN_WEIGHT_BASED, NEUROMUSCULAR_BLOCKER }
    public enum GuardrailBreach { NONE, SOFT_LIMIT_WARNING, HARD_LIMIT_PROHIBITED }

    public record HighAlertDefinition(String genericName, HighAlertCategory category, double maxSingleDose, double maxContinuousRatePerHour, String unit, String hardStopReason) {}
    public record VerificationSession(String sessionId, String rxId, String drugName, double dose, String nurse1Id, String nurse2Id, boolean completed, Instant timestamp) {}

    private final Map<String, HighAlertDefinition> ruleCatalog = new ConcurrentHashMap<>();
    private final Map<String, VerificationSession> activeSessions = new ConcurrentHashMap<>();

    public IsmpDoubleCheckService() {
        seedIsmpRules();
    }

    private void seedIsmpRules() {
        ruleCatalog.put("INSULIN REGULAR", new HighAlertDefinition("INSULIN REGULAR", HighAlertCategory.INSULIN_INFUSION, 25.0, 20.0, "Units/hr", "Rate > 20 Units/hr requires endocrinology approval"));
        ruleCatalog.put("HEPARIN SODIUM", new HighAlertDefinition("HEPARIN SODIUM", HighAlertCategory.HEPARIN_WEIGHT_BASED, 25000.0, 2500.0, "Units/hr", "Heparin infusion > 2500 Units/hr hard stop: risk of fatal hemorrhage"));
        ruleCatalog.put("POTASSIUM CHLORIDE", new HighAlertDefinition("POTASSIUM CHLORIDE", HighAlertCategory.POTASSIUM_IV_BOLUS, 20.0, 20.0, "mEq/hr", "Peripheral IV potassium > 10 mEq/hr or Central > 20 mEq/hr hard stop: risk of cardiac arrest"));
        ruleCatalog.put("ROCURONIUM", new HighAlertDefinition("ROCURONIUM", HighAlertCategory.NEUROMUSCULAR_BLOCKER, 100.0, 0.0, "mg", "Paralytic agent: patient MUST be mechanically ventilated"));
    }

    public GuardrailBreach evaluateDose(String drugName, double requestedDose, double continuousRatePerHour) {
        HighAlertDefinition def = ruleCatalog.get(drugName.toUpperCase());
        if (def == null) return GuardrailBreach.NONE;

        if (continuousRatePerHour > def.maxContinuousRatePerHour() * 1.5 || (def.maxSingleDose() > 0 && requestedDose > def.maxSingleDose() * 1.5)) {
            return GuardrailBreach.HARD_LIMIT_PROHIBITED;
        }
        if (continuousRatePerHour > def.maxContinuousRatePerHour() || (def.maxSingleDose() > 0 && requestedDose > def.maxSingleDose())) {
            return GuardrailBreach.SOFT_LIMIT_WARNING;
        }
        return GuardrailBreach.NONE;
    }

    public VerificationSession initiateDoubleCheck(String rxId, String drugName, double dose, String primaryNurseId) {
        String sessionId = "ISMP-CHK-" + UUID.randomUUID().toString().substring(0, 8);
        VerificationSession session = new VerificationSession(sessionId, rxId, drugName, dose, primaryNurseId, null, false, Instant.now());
        activeSessions.put(sessionId, session);
        return session;
    }

    public VerificationSession coSignDoubleCheck(String sessionId, String secondaryNurseId) {
        VerificationSession current = activeSessions.get(sessionId);
        if (current == null) throw new IllegalArgumentException("Session not found: " + sessionId);
        if (current.nurse1Id().equals(secondaryNurseId)) {
            throw new IllegalArgumentException("Independent double-check policy violation: Secondary co-signer cannot be the same as primary nurse.");
        }
        VerificationSession updated = new VerificationSession(sessionId, current.rxId(), current.drugName(), current.dose(), current.nurse1Id(), secondaryNurseId, true, Instant.now());
        activeSessions.put(sessionId, updated);
        return updated;
    }
}
