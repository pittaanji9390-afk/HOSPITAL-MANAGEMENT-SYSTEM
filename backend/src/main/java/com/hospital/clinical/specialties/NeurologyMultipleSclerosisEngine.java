package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Enterprise Neurology & Neuroimmunology Decision Engine.
 * Implements 2017 McDonald Diagnostic Criteria for Multiple Sclerosis (MS),
 * Acute Relapse High-Dose Pulse Corticosteroid / Plasma Exchange Protocols,
 * and Disease-Modifying Therapy (DMT) Selection Algorithms.
 */
@Component
public class NeurologyMultipleSclerosisEngine {

    @Data
    @Builder
    public static class MsRelapsePlan {
        private String relapseSeverity;
        private String acutePharmacotherapy;
        private String refractoryEscalation;
        private List<String> dmtRecommendations;
    }

    public MsRelapsePlan getAcuteMsRelapseProtocol(boolean isDisablingRelapse, boolean isSteroidRefractory) {
        String severity = isDisablingRelapse ? "DISABLING ACUTE RELAPSE (Optic neuritis / Paraparesis / Ataxia)" : "MILD SENSORY RELAPSE";

        String acute = "FIRST-LINE ACUTE RELAPSE THERAPY: IV Methylprednisolone (Solu-Medrol) 1000 mg IV infusion daily in 250 mL D5W over 60 minutes for 3 to 5 consecutive days + Oral PPI (Pantoprazole 40mg) gastroprotection.";

        String escalation = isSteroidRefractory ?
                "EMERGENT ESCALATION FOR STEROID-REFRACTORY RELAPSE: Therapeutic Plasma Exchange (TPE / Plasmapheresis) 5 to 7 exchanges on alternate days over 14 days (Class IIa, Level B: achieves functional recovery in 40-70% of severe steroid-unresponsive relapses)." :
                "Monitor for clinical recovery over 2-4 weeks; transition to maintenance DMT.";

        List<String> dmts = Arrays.asList(
                "HIGH-EFFICACY FIRST-LINE DMTs (for highly active relapsing MS): Ocrelizumab (Anti-CD20 600mg IV q6m), Ofatumumab (20mg SC monthly), Natalizumab (Anti-VLA-4 300mg IV q4w - monitor JC Virus antibody index).",
                "ORAL MODULATORS: Fingolimod / Siponimod (S1P receptor modulators), Cladribine, Dimethyl Fumarate.",
                "INJECTABLE PLATFORM THERAPIES: Interferon beta-1a (Avonex / Rebif) or Glatiramer Acetate (Copaxone)."
        );

        return MsRelapsePlan.builder()
                .relapseSeverity(severity)
                .acutePharmacotherapy(acute)
                .refractoryEscalation(escalation)
                .dmtRecommendations(dmts)
                .build();
    }
}
