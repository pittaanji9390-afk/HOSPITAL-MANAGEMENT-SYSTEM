package com.hospital.billing.edi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class AnsiX12271EligibilityResponseGenerator {

    @Data
    @AllArgsConstructor
    public static class PatientBenefitProfile {
        private String memberId;
        private boolean isActiveCoverage;
        private String planName;
        private double copayPrimaryCare;
        private double copaySpecialist;
        private double copayEmergencyRoom;
        private double deductibleIndividualRemaining;
        private double outOfPocketMaxRemaining;
        private double coinsurancePercent;
    }

    public PatientBenefitProfile parse271Payload(String memberId) {
        return new PatientBenefitProfile(memberId, true, "Blue Cross PPO Comprehensive Plan", 25.0, 50.0, 250.0, 450.0, 1850.0, 20.0);
    }
}
