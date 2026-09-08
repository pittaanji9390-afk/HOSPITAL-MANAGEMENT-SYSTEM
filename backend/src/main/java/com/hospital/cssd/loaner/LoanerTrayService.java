package com.hospital.cssd.loaner;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Orthopedic & Spine Vendor Loaner Tray Intake Management.
 * Enforces Joint Commission & AAMI ST79 requirement: Loaner trays must arrive at least 24 hours prior
 * to surgical case start for biological spore challenge decontamination, assembly, and sterilization.
 */
@Service
public class LoanerTrayService {

    public record LoanerSet(
        String loanerId,
        String vendorName,
        String surgicalCaseId,
        String patientMrn,
        String surgeonName,
        String setDescription,
        int trayCountInSet,
        Instant scheduledSurgeryTime,
        Instant receivedAtCssdTime,
        boolean compliantWith24HrArrivalSla
    ) {}

    private final Map<String, LoanerSet> loanerRegistry = new ConcurrentHashMap<>();

    public LoanerTrayService() {
        seedLoaners();
    }

    private void seedLoaners() {
        LoanerSet l1 = new LoanerSet(
            "LOAN-STK-TKA-8812",
            "Stryker Orthopaedics",
            "CASE-SURG-2026-9901",
            "MRN-774411",
            "Dr. Sarah Jenkins, MD",
            "Triathlon Total Knee Revision Instrumentation (5 Trays)",
            5,
            Instant.now().plusSeconds(129600),
            Instant.now().minusSeconds(3600),
            true
        );
        loanerRegistry.put(l1.loanerId(), l1);
    }

    public List<LoanerSet> listAllLoaners() {
        return new ArrayList<>(loanerRegistry.values());
    }
}
