package com.hospital.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class SurvivingSepsisHour1Pathway {

    @Data
    @Builder
    public static class SepsisBundleItem {
        private String elementId;
        private String clinicalIntervention;
        private String rationale;
    }

    public List<SepsisBundleItem> getHour1BundleElements() {
        return List.of(
            SepsisBundleItem.builder()
                .elementId("SEPSIS_1_LACTATE")
                .clinicalIntervention("Measure Blood Serum Lactate Level (Point-of-Care or Core Lab)")
                .rationale("Identify tissue hypoperfusion. Remeasure within 2-4 hours if initial lactate > 2.0 mmol/L to guide resuscitation.")
                .build(),
            SepsisBundleItem.builder()
                .elementId("SEPSIS_2_BLOOD_CULTURES")
                .clinicalIntervention("Obtain 2 Sets of Blood Cultures (Aerobic & Anaerobic) prior to initiating antimicrobials")
                .rationale("Enable pathogen identification and targeted de-escalation without delaying antibiotic therapy > 45 minutes.")
                .build(),
            SepsisBundleItem.builder()
                .elementId("SEPSIS_3_ANTIBIOTICS")
                .clinicalIntervention("Administer Empiric Broad-Spectrum IV Antibiotics (Vancomycin + Cefepime/Meropenem)")
                .rationale("Every hour of delay in antibiotic administration correlates with a 7.6% increase in septic shock mortality.")
                .build(),
            SepsisBundleItem.builder()
                .elementId("SEPSIS_4_CRYSTALLOIDS")
                .clinicalIntervention("Rapidly Infuse 30 mL/kg Balanced Crystalloid (Lactated Ringer's) for Hypotension or Lactate >= 4")
                .rationale("Restore effective circulating intravascular volume and optimize cardiac preload.")
                .build(),
            SepsisBundleItem.builder()
                .elementId("SEPSIS_5_VASOPRESSORS")
                .clinicalIntervention("Apply Norepinephrine Vasopressor Infusion if Hypotensive during/after fluids to maintain MAP >= 65 mmHg")
                .rationale("First-choice vasopressor to restore perfusion pressure to vital organs.")
                .build()
        );
    }
}
