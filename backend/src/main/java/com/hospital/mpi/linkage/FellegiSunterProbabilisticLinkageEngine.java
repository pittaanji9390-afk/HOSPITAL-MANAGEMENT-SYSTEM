package com.hospital.mpi.linkage;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class FellegiSunterProbabilisticLinkageEngine {

    @Data
    @AllArgsConstructor
    public static class LinkageDecision {
        private String candidateRecordIdA;
        private String candidateRecordIdB;
        private double totalMatchWeightScore;
        private double lowerThreshold; // 12.0
        private double upperThreshold; // 24.0
        private String matchClassification; // DEFINITE_MATCH, PROBABLE_MATCH_MANUAL_REVIEW, DEFINITE_NON_MATCH
    }

    public LinkageDecision evaluateLinkage(String idA, String idB, boolean ssnMatch, boolean lastNameMatch, boolean firstNameMatch, boolean dobMatch, boolean genderMatch, boolean phoneMatch) {
        double weight = 0.0;
        if (ssnMatch) weight += 15.2; else weight -= 6.4;
        if (lastNameMatch) weight += 6.8; else weight -= 4.2;
        if (firstNameMatch) weight += 4.5; else weight -= 3.1;
        if (dobMatch) weight += 8.1; else weight -= 5.0;
        if (genderMatch) weight += 1.2; else weight -= 1.0;
        if (phoneMatch) weight += 5.0; else weight -= 2.0;

        String classification;
        if (weight >= 24.0) {
            classification = "DEFINITE_MATCH";
        } else if (weight >= 12.0) {
            classification = "PROBABLE_MATCH_MANUAL_REVIEW";
        } else {
            classification = "DEFINITE_NON_MATCH";
        }

        return new LinkageDecision(idA, idB, Math.round(weight * 10.0) / 10.0, 12.0, 24.0, classification);
    }
}
