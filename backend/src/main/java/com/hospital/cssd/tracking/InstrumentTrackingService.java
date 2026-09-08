package com.hospital.cssd.tracking;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Central Sterile Supply Department (CSSD) RFID Surgical Instrument Set & Tray Assembly Tracking Engine.
 * Verifies completeness of instrument trays (e.g. Major Laparotomy, Total Knee Arthroplasty, Craniotomy)
 * using RFID scanning and 2D laser-etched data matrix verification before and after surgical cases.
 */
@Service
public class InstrumentTrackingService {

    public enum TrayStatus { DECONTAMINATION, ASSEMBLY_INSPECTION, PACKAGED_FOR_STERILIZATION, STERILIZED_IN_STORAGE, DISPATCHED_TO_OR, IN_USE_SURGERY, POST_OP_COUNTED }

    public record SurgicalInstrument(String instrumentId, String laserBarcode, String name, String category, boolean requiresMicroscopeCheck) {}
    public record TrayRecipe(String recipeId, String trayName, String surgicalSpecialty, List<SurgicalInstrument> standardComponents) {}
    public record TrayInstance(String trayInstanceId, String rfidTagId, String recipeId, TrayStatus status, List<String> scannedInstrumentIds, Instant lastScannedAt, String currentZone) {}

    private final Map<String, TrayRecipe> recipes = new ConcurrentHashMap<>();
    private final Map<String, TrayInstance> activeTrays = new ConcurrentHashMap<>();

    public InstrumentTrackingService() {
        seedRecipes();
    }

    private void seedRecipes() {
        List<SurgicalInstrument> laparotomyItems = List.of(
            new SurgicalInstrument("INS-001", "BC-LAP-01", "#3 Scalpel Handle", "Cutting", false),
            new SurgicalInstrument("INS-002", "BC-LAP-02", "Metzenbaum Scissors 7 inch Curv", "Cutting", false),
            new SurgicalInstrument("INS-003", "BC-LAP-03", "Mayo Scissors 6.75 inch Straight", "Cutting", false),
            new SurgicalInstrument("INS-004", "BC-LAP-04", "DeBakey Vascular Tissue Forceps 8 inch", "Grasping", true),
            new SurgicalInstrument("INS-005", "BC-LAP-05", "Russian Tissue Forceps 8 inch", "Grasping", false),
            new SurgicalInstrument("INS-006", "BC-LAP-06", "Balfour Abdominal Retractor Set", "Retracting", false),
            new SurgicalInstrument("INS-007", "BC-LAP-07", "Richardson Retractor Medium", "Retracting", false),
            new SurgicalInstrument("INS-008", "BC-LAP-08", "Crile Hemostatic Clamp Curv 5.5 inch", "Clamping", false),
            new SurgicalInstrument("INS-009", "BC-LAP-09", "Rochester-Pean Clamp 8 inch", "Clamping", false),
            new SurgicalInstrument("INS-010", "BC-LAP-10", "Allis Tissue Forceps 6 inch", "Grasping", false)
        );

        TrayRecipe lapRecipe = new TrayRecipe("REC-LAP-MAJ", "Major Laparotomy Basic Set", "General Surgery", laparotomyItems);
        recipes.put(lapRecipe.recipeId(), lapRecipe);

        TrayInstance tray1 = new TrayInstance("TRAY-INST-1001", "RFID-E280-1122-3344", "REC-LAP-MAJ", TrayStatus.STERILIZED_IN_STORAGE, List.of("INS-001", "INS-002", "INS-003", "INS-004", "INS-005", "INS-006", "INS-007", "INS-008", "INS-009", "INS-010"), Instant.now(), "CSSD Sterile Core Rack A-04");
        activeTrays.put(tray1.trayInstanceId(), tray1);
    }

    public synchronized boolean verifyTrayAssemblyCompleteness(String trayInstanceId) {
        TrayInstance tray = activeTrays.get(trayInstanceId);
        if (tray == null) throw new IllegalArgumentException("Tray instance not found: " + trayInstanceId);
        
        TrayRecipe recipe = recipes.get(tray.recipeId());
        if (recipe == null) return false;

        Set<String> requiredIds = new HashSet<>();
        for (SurgicalInstrument inst : recipe.standardComponents()) {
            requiredIds.add(inst.instrumentId());
        }

        return tray.scannedInstrumentIds().containsAll(requiredIds);
    }

    public synchronized TrayInstance updateTrayStatus(String trayInstanceId, TrayStatus newStatus, String zone) {
        TrayInstance current = activeTrays.get(trayInstanceId);
        if (current == null) throw new IllegalArgumentException("Tray not found: " + trayInstanceId);
        
        TrayInstance updated = new TrayInstance(current.trayInstanceId(), current.rfidTagId(), current.recipeId(), newStatus, current.scannedInstrumentIds(), Instant.now(), zone);
        activeTrays.put(trayInstanceId, updated);
        return updated;
    }

    public TrayInstance getTray(String trayInstanceId) {
        return activeTrays.get(trayInstanceId);
    }

    public List<TrayInstance> getAllTrays() {
        return new ArrayList<>(activeTrays.values());
    }
}
