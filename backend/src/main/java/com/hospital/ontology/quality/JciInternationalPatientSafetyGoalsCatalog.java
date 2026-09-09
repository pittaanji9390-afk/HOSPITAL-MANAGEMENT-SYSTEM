package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JciInternationalPatientSafetyGoalsCatalog {

    @Data
    @AllArgsConstructor
    public static class IpsgGoal {
        private String goalNumber;
        private String title;
        private String mandatoryRequirement;
        private List<String> verificationCheckpoints;
    }

    private final Map<String, IpsgGoal> goals = new LinkedHashMap<>();

    public JciInternationalPatientSafetyGoalsCatalog() {
        goals.put("IPSG.1", new IpsgGoal("IPSG.1", "Identify Patients Correctly", "Use at least two patient identifiers (Full Name, MRN, DOB) before care delivery", List.of("Check wristband barcode", "Verbal confirmation with patient/family", "Never use room/bed number as identifier")));
        goals.put("IPSG.2", new IpsgGoal("IPSG.2", "Improve Effective Communication", "Implement Read-Back verification for critical verbal/telephone orders and critical lab results", List.of("Write down order", "Read back full order to prescriber", "Prescriber counter-signature within 24h")));
        goals.put("IPSG.3", new IpsgGoal("IPSG.3", "Improve Safety of High-Alert Medications", "Standardize high-alert drug labeling, separate storage, and independent double-checks", List.of("Tall Man lettering", "Lock concentrated electrolytes outside pharmacy", "Dual nurse witness signoff")));
        goals.put("IPSG.4", new IpsgGoal("IPSG.4", "Ensure Safe Surgery", "Conduct pre-operative verification, site marking by surgeon, and surgical Time-Out", List.of("Site marking with permanent surgical marker", "Pre-op checklist completed", "Time-Out immediately before skin incision")));
        goals.put("IPSG.5", new IpsgGoal("IPSG.5", "Reduce Risk of Healthcare-Associated Infections", "Comply with WHO 5 Moments of Hand Hygiene guidelines", List.of("Alcohol hand rub availability at bedside", "Periodic compliance audits", "Gloves do not replace hand hygiene")));
        goals.put("IPSG.6", new IpsgGoal("IPSG.6", "Reduce Patient Harm from Falls", "Conduct initial fall risk assessment on admission and implement tailored fall precautions", List.of("Morse Fall Scale or Hendrich II Model", "Yellow fall-risk wristband", "Bed in lowest position with brakes locked")));
    }

    public Optional<IpsgGoal> getGoal(String goal) { return Optional.ofNullable(goals.get(goal)); }
    public List<IpsgGoal> getAll() { return new ArrayList<>(goals.values()); }
}
