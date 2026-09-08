package com.hospital.genetics.oncology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class KrasG12cNonsmallCellLungCancerEngine {

    @Data
    @AllArgsConstructor
    public static class KrasGuidance {
        private String patientId;
        private String krasAllele; // G12C, G12D, G12V, WILD_TYPE
        private String targetedAgent;
    }

    public KrasGuidance evaluateKras(String patientId, String allele) {
        String drug = allele.equals("G12C") ? "Sotorasib (Lumakras) 960mg Daily or Adagrasib (Krazati) 600mg BID" : "Chemo-immunotherapy (Pembrolizumab + Carboplatin + Paclitaxel)";
        return new KrasGuidance(patientId, allele, drug);
    }
}
