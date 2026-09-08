package com.hospital.billing.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalNecessityLcdNcdRuleEngine {

    @Data
    @AllArgsConstructor
    public static class MedicalNecessityCheckResult {
        private String cptCode;
        private String icd10Code;
        private boolean isMedicallyNecessaryPerLcd;
        private String lcdPolicyId;
        private String rationale;
    }

    public MedicalNecessityCheckResult verifyMedicalNecessity(String cpt, String icd10) {
        boolean passes = cpt.equals("71275") && (icd10.startsWith("I26") || icd10.startsWith("R07"));
        return new MedicalNecessityCheckResult(cpt, icd10, passes, "LCD-L33580", passes ? "Covered: Diagnosis supports medical necessity for CTA Chest" : "Non-Covered: Diagnosis does not support procedure per Medicare LCD");
    }
}
