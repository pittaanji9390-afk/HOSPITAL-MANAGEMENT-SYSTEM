package com.hospital.genetics.oncology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class EgfrMutationTargetedTherapyEngine {

    @Data
    @AllArgsConstructor
    public static class EgfrTherapyGuidance {
        private String patientId;
        private String mutationType; // Exon 19 Deletion, L858R Point Mutation, T790M Resistance, C797S
        private String recommendedTkiTherapy;
        private String clinicalEvidence;
    }

    public EgfrTherapyGuidance evaluateEgfr(String patientId, String mutation) {
        String tki;
        String ev;
        if (mutation.contains("T790M") || mutation.contains("Exon 19") || mutation.contains("L858R")) {
            tki = "Osimertinib (Tagrisso) 80mg Daily";
            ev = "First-line preferred 3rd-generation EGFR TKI with CNS penetration (FLAURA Trial)";
        } else {
            tki = "Standard Platinum-Doublet Chemotherapy (Carboplatin + Pemetrexed)";
            ev = "EGFR wild-type / no activating mutation detected";
        }

        return new EgfrTherapyGuidance(patientId, mutation, tki, ev);
    }
}
