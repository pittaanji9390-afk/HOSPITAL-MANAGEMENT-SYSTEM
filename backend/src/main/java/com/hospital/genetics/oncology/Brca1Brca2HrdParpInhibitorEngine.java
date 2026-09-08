package com.hospital.genetics.oncology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class Brca1Brca2HrdParpInhibitorEngine {

    @Data
    @AllArgsConstructor
    public static class BrcaGuidance {
        private String patientId;
        private String brcaStatus; // BRCA1_PATHOGENIC, BRCA2_PATHOGENIC, WILD_TYPE
        private boolean isHrdPositive;
        private String parpInhibitorRecommendation;
    }

    public BrcaGuidance evaluateBrca(String patientId, String status, boolean hrd) {
        boolean eligible = status.contains("PATHOGENIC") || hrd;
        String parp = eligible ? "Olaparib (Lynparza) 300mg BID or Niraparib (Zejula) Maintenance" : "Standard Chemotherapy / Surveillance";
        return new BrcaGuidance(patientId, status, hrd, parp);
    }
}
