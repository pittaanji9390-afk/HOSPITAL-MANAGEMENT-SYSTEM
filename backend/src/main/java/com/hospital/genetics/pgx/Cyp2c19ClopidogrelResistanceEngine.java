package com.hospital.genetics.pgx;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class Cyp2c19ClopidogrelResistanceEngine {

    @Data
    @AllArgsConstructor
    public static class Cyp2c19Result {
        private String patientId;
        private String diplotype; // e.g., *1/*2, *2/*2, *1/*17, *17/*17
        private String phenotype; // POOR, INTERMEDIATE, NORMAL, RAPID, ULTRARAPID
        private boolean isClopidogrelResistant;
        private String recommendedAntiplateletAgent;
    }

    public Cyp2c19Result evaluateCyp2c19(String patientId, String diplotype) {
        boolean resistant = diplotype.contains("*2") || diplotype.contains("*3");
        String pheno = diplotype.equals("*2/*2") ? "POOR_METABOLIZER" : resistant ? "INTERMEDIATE_METABOLIZER" : "NORMAL_METABOLIZER";
        String drug = resistant ? "Ticagrelor 90mg BID or Prasugrel 10mg Daily (Alternative to Clopidogrel)" : "Clopidogrel (Plavix) 75mg Daily";

        return new Cyp2c19Result(patientId, diplotype, pheno, resistant, drug);
    }
}
