package com.hospital.billing.cob;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class CoordinationOfBenefitsCobCalculator {

    @Data
    @AllArgsConstructor
    public static class CobDetermination {
        private String patientId;
        private String primaryPayer;
        private String secondaryPayer;
        private String determinationRule; // "BIRTHDAY_RULE", "SUBSCRIBER_ACTIVE_EMPLOYEE_RULE", "MEDICARE_SECONDARY_PAYER_MSP"
    }

    public CobDetermination determinePrimarySecondary(String patientId, int parent1BirthMonth, int parent1BirthDay, int parent2BirthMonth, int parent2BirthDay) {
        boolean parent1Earlier = (parent1BirthMonth < parent2BirthMonth) || (parent1BirthMonth == parent2BirthMonth && parent1BirthDay < parent2BirthDay);
        return new CobDetermination(patientId, parent1Earlier ? "Parent 1 Payer Plan" : "Parent 2 Payer Plan", parent1Earlier ? "Parent 2 Payer Plan" : "Parent 1 Payer Plan", "BIRTHDAY_RULE");
    }
}
