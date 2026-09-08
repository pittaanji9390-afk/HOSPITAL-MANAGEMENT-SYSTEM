package com.hospital.security.lifecycle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class UserRoleProvisioningEngine {

    @Data
    @AllArgsConstructor
    public static class StaffAccountLifecycle {
        private String employeeId;
        private String fullName;
        private String department;
        private String assignedRole;
        private String accountStatus; // ACTIVE, SUSPENDED, DEPROVISIONED, ON_LEAVE
        private LocalDate onboardingDate;
        private LocalDate lastPrivilegeReviewDate;
    }

    private final Map<String, StaffAccountLifecycle> accounts = new LinkedHashMap<>();

    public UserRoleProvisioningEngine() {
        accounts.put("EMP-1001", new StaffAccountLifecycle("EMP-1001", "Dr. Gregory House", "Internal Medicine", "ATTENDING_PHYSICIAN", "ACTIVE", LocalDate.now().minusYears(3), LocalDate.now().minusMonths(2)));
        accounts.put("EMP-1002", new StaffAccountLifecycle("EMP-1002", "Nurse Jackie Peyton", "Emergency Department", "CHARGE_NURSE", "ACTIVE", LocalDate.now().minusYears(2), LocalDate.now().minusMonths(1)));
    }

    public void suspendAccount(String empId, String reason) {
        StaffAccountLifecycle acc = accounts.get(empId);
        if (acc != null) {
            acc.setAccountStatus("SUSPENDED");
            log.warn("[ACCOUNT-LIFECYCLE] Account {} suspended. Reason: {}", empId, reason);
        }
    }

    public List<StaffAccountLifecycle> getAllAccounts() { return new ArrayList<>(accounts.values()); }
}
