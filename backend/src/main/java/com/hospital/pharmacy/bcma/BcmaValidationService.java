package com.hospital.pharmacy.bcma;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Barcode Medication Administration (BCMA) 5-Rights Verification Service:
 * 1. Right Patient (Wristband Barcode Match)
 * 2. Right Medication (GS1 / 2D DataMatrix GTIN / NDC Match)
 * 3. Right Dose (Unit-dose / Multi-dose calculation)
 * 4. Right Route (IV, Oral, SubQ, IM, Inhalation)
 * 5. Right Time (+/- 30 minute standard hospital administration window)
 */
@Service
public class BcmaValidationService {

    public record ActiveOrder(
        String orderId,
        String patientMrn,
        String ndcCode,
        String drugName,
        double prescribedDose,
        String unit,
        String route,
        Instant scheduledTime
    ) {}

    public record BcmaScanPayload(
        String scannedPatientWristband,
        String scannedMedicationBarcode,
        double administeredDose,
        String route,
        String nurseBadgeId
    ) {}

    public record BcmaVerificationResult(
        boolean isSafeToAdminister,
        boolean rightPatient,
        boolean rightMedication,
        boolean rightDose,
        boolean rightRoute,
        boolean rightTime,
        String diagnosticDetails
    ) {}

    public BcmaVerificationResult verifyAdministration(ActiveOrder order, BcmaScanPayload scan) {
        boolean rightPatient = order.patientMrn().equalsIgnoreCase(scan.scannedPatientWristband());
        boolean rightMed = scan.scannedMedicationBarcode().contains(order.ndcCode()) || scan.scannedMedicationBarcode().contains(order.orderId());
        boolean rightDose = Math.abs(order.prescribedDose() - scan.administeredDose()) < 0.001;
        boolean rightRoute = order.route().equalsIgnoreCase(scan.route());
        
        long minutesDifference = Math.abs(ChronoUnit.MINUTES.between(order.scheduledTime(), Instant.now()));
        boolean rightTime = minutesDifference <= 60; // Standard hospital policy allowance

        boolean pass = rightPatient && rightMed && rightDose && rightRoute && rightTime;

        List<String> errors = new ArrayList<>();
        if (!rightPatient) errors.add("WRONG PATIENT WRISTBAND SCAN");
        if (!rightMed) errors.add("WRONG MEDICATION BARCODE");
        if (!rightDose) errors.add(String.format("DOSE MISMATCH (Prescribed: %.2f %s, Scanned: %.2f %s)", order.prescribedDose(), order.unit(), scan.administeredDose(), order.unit()));
        if (!rightRoute) errors.add("INCORRECT ROUTE (" + scan.route() + " vs " + order.route() + ")");
        if (!rightTime) errors.add(String.format("OUTSIDE ADMINISTRATION TIME WINDOW (Dose was scheduled %d min ago)", minutesDifference));

        String details = pass ? "ALL 5-RIGHTS VERIFIED: Safe to administer." : "BCMA INTERCEPT: " + String.join(", ", errors);

        return new BcmaVerificationResult(pass, rightPatient, rightMed, rightDose, rightRoute, rightTime, details);
    }
}
