package com.hospital.security.rbac;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ClinicalPermissionRegistry {

    @Data
    @AllArgsConstructor
    public static class ClinicalPermission {
        private String permissionCode;
        private String module;
        private String description;
        private boolean isHighRiskAction;
        private boolean requiresTwoPersonVerification;
    }

    private final Map<String, ClinicalPermission> permissions = new LinkedHashMap<>();

    public ClinicalPermissionRegistry() {
        permissions.put("CLIN_ORDER_C2_NARCOTICS", new ClinicalPermission("CLIN_ORDER_C2_NARCOTICS", "Pharmacy", "Prescribe Schedule II Controlled Substances with DEA EPCS signature", true, false));
        permissions.put("CLIN_ORDER_CHEMO_ANTINEOPLASTIC", new ClinicalPermission("CLIN_ORDER_CHEMO_ANTINEOPLASTIC", "Oncology", "Order cytotoxic chemotherapy regimens requiring dual oncologist signoff", true, true));
        permissions.put("CLIN_SIGN_DEATH_CERTIFICATE", new ClinicalPermission("CLIN_SIGN_DEATH_CERTIFICATE", "Medical Records", "Electronically sign state vital statistics death certificate", true, false));
        permissions.put("CLIN_OVERRIDE_DRUG_ALLERGY", new ClinicalPermission("CLIN_OVERRIDE_DRUG_ALLERGY", "CPOE", "Override severe anaphylaxis drug-allergy hard stop in CDSS", true, false));
        permissions.put("CLIN_RELEASE_BLOOD_EMERGENCY", new ClinicalPermission("CLIN_RELEASE_BLOOD_EMERGENCY", "Blood Bank", "Order uncrossmatched O-negative emergency massive transfusion release", true, true));
        permissions.put("CLIN_REST_PHYS_RESTRAINTS", new ClinicalPermission("CLIN_REST_PHYS_RESTRAINTS", "Nursing", "Order medical or behavioral physical limb restraints for 24 hours", true, false));
        permissions.put("CLIN_VIEW_VIP_RESTRICTED_EHR", new ClinicalPermission("CLIN_VIEW_VIP_RESTRICTED_EHR", "Privacy", "View restricted VIP/Celebrity/Employee confidential medical records", true, false));
        permissions.put("CLIN_MODIFY_CLINICAL_TRIAL_ARM", new ClinicalPermission("CLIN_MODIFY_CLINICAL_TRIAL_ARM", "Research", "Assign or switch human subject experimental randomized trial arm", true, true));
    }

    public boolean hasPermission(String role, String permissionCode) {
        if ("SUPER_ADMIN".equalsIgnoreCase(role) || "CHIEF_MEDICAL_OFFICER".equalsIgnoreCase(role)) return true;
        if ("ATTENDING_PHYSICIAN".equalsIgnoreCase(role)) {
            return !permissionCode.equals("CLIN_VIEW_VIP_RESTRICTED_EHR");
        }
        if ("ICU_STAFF_NURSE".equalsIgnoreCase(role)) {
            return permissionCode.equals("CLIN_REST_PHYS_RESTRAINTS") || permissionCode.equals("CLIN_RELEASE_BLOOD_EMERGENCY");
        }
        return false;
    }

    public Optional<ClinicalPermission> getPermission(String code) { return Optional.ofNullable(permissions.get(code)); }
    public List<ClinicalPermission> getAllPermissions() { return new ArrayList<>(permissions.values()); }
}
