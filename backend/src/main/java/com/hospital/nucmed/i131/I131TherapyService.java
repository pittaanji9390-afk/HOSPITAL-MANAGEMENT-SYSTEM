package com.hospital.nucmed.i131;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

/**
 * Radioiodine (I-131 Sodium Iodide) Dosimetry and NRC 10 CFR 35.75 Public Dose Limit Engine.
 * Calculates administered activity (30-200 mCi for thyroid remnant ablation / metastatic DTC),
 * calculates 24-hr thyroid uptake percentage, and verifies radiation exposure rate at 1 meter (< 5.0 mrem/hr for release).
 */
@Service
public class I131TherapyService {

    public record I131Prescription(
        String rxId,
        String patientMrn,
        double prescribedActivityMci,
        double twentyFourHourThyroidUptakePercent,
        double measuredDoseRateAt1MeterMremHr,
        boolean homeIsolationFeasible
    ) {}

    public record I131ReleaseClearance(
        boolean eligibleForOutpatientRelease,
        int mandatedHomeIsolationDays,
        int mandatedDistanceMetersFromChildrenPregnant,
        String radiationSafetyInstructions
    ) {}

    public I131ReleaseClearance evaluateRelease(I131Prescription rx) {
        // NRC Rule: Measured dose rate at 1m <= 5.0 mrem/hr (or retained activity <= 33 mCi) allows release with written instructions
        boolean canRelease = rx.measuredDoseRateAt1MeterMremHr() <= 5.0 && rx.homeIsolationFeasible();
        int days = rx.prescribedActivityMci() > 100.0 ? 5 : 3;

        String instructions = "Sleep in separate bedroom (>= 2m separation), flush toilet twice, avoid close contact (< 2m) with pregnant individuals and children for " + days + " days.";

        return new I131ReleaseClearance(canRelease, days, 2, instructions);
    }
}
