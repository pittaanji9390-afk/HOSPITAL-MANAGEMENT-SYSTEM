package com.hospital.services.anesthesiology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AnesthesiologyPerioperativeEngine {

    @Data
    @Builder
    public static class AnesthesiaPacuReport {
        private String surgeryCaseId;
        private String asaPhysicalStatus; // ASA_I, ASA_II, ASA_III, ASA_IV, ASA_V, ASA_E
        private int mallampatiClass; // 1, 2, 3, 4
        private boolean isDifficultAirwayPredicted;
        private int modifiedAldreteScore; // Out of 10
        private boolean isPacuDischargeEligible;
        private String postOpAnalgesiaProtocol;
    }

    public AnesthesiaPacuReport assessAnesthesia(String caseId, String asa, int mallampati, int activity, int respiration, int circulation, int consciousness, int o2Sat) {
        int aldrete = activity + respiration + circulation + consciousness + o2Sat;
        boolean difficultAirway = mallampati >= 3;

        return AnesthesiaPacuReport.builder()
                .surgeryCaseId(caseId)
                .asaPhysicalStatus(asa)
                .mallampatiClass(mallampati)
                .isDifficultAirwayPredicted(difficultAirway)
                .modifiedAldreteScore(aldrete)
                .isPacuDischargeEligible(aldrete >= 9)
                .postOpAnalgesiaProtocol("Multimodal Analgesia: IV Acetaminophen 1000mg Q6H + Ketorolac 15mg IV Q6H (x48h) + Patient-Controlled Analgesia (PCA) Hydromorphone.")
                .build();
    }
}
