package com.hospital.services.orthopedics;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class OrthopedicsJointRegistryEngine {

    @Data
    @Builder
    public static class JointArthroplastyAssessment {
        private String jointRegistryId;
        private String anatomicalJoint; // HIP, KNEE, SHOULDER
        private double harrisHipScore;
        private String clinicalOutcomeGrade; // EXCELLENT, GOOD, FAIR, POOR
        private String implantBearingSurface; // CERAMIC_ON_POLYETHYLENE, CERAMIC_ON_CERAMIC, METAL_ON_POLYETHYLENE
        private String venousThromboembolismProphylaxis;
    }

    public JointArthroplastyAssessment evaluateJoint(String registryId, String joint, double painScore, double functionScore, double deformityScore, double motionScore, String bearingType) {
        double totalHhs = painScore + functionScore + deformityScore + motionScore;
        String outcome = totalHhs >= 90 ? "EXCELLENT" : (totalHhs >= 80 ? "GOOD" : (totalHhs >= 70 ? "FAIR" : "POOR"));

        return JointArthroplastyAssessment.builder()
                .jointRegistryId(registryId)
                .anatomicalJoint(joint)
                .harrisHipScore(totalHhs)
                .clinicalOutcomeGrade(outcome)
                .implantBearingSurface(bearingType)
                .venousThromboembolismProphylaxis("Enoxaparin 40mg SC daily starting 12h post-op for 35 days + Sequential Compression Devices (SCD).")
                .build();
    }
}
