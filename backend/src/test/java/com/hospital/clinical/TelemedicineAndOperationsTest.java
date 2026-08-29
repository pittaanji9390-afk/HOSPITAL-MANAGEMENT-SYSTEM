package com.hospital.clinical;

import com.hospital.bloodbank.BloodBankColdChainEngine;
import com.hospital.radiology.DicomPacsEngine;
import com.hospital.surgery.SurgicalSchedulingOptimizationEngine;
import com.hospital.telemedicine.TelemedicineEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelemedicineAndOperationsTest {

    private final TelemedicineEngine teleEngine = new TelemedicineEngine();
    private final DicomPacsEngine dicomEngine = new DicomPacsEngine();
    private final BloodBankColdChainEngine coldChainEngine = new BloodBankColdChainEngine();
    private final SurgicalSchedulingOptimizationEngine surgicalEngine = new SurgicalSchedulingOptimizationEngine();

    @Test
    @DisplayName("Telemedicine: Should create encrypted room with AES-GCM token and transition status through patient waiting")
    void testTelemedicineRoomLifecycle() {
        TelemedicineEngine.TeleConsultationRoom room = teleEngine.createRoom(
                1L, "MRN-10001", "Anand Patil", 1L, "Dr. Rajesh Sharma"
        );

        assertNotNull(room);
        assertTrue(room.getRoomId().startsWith("ROOM-TELE-"));
        assertEquals(TelemedicineEngine.RoomStatus.WAITING_FOR_PATIENT, room.getStatus());

        // Patient enters waiting room
        teleEngine.joinRoom(room.getRoomId(), "PATIENT");
        assertEquals(TelemedicineEngine.RoomStatus.PATIENT_IN_WAITING_ROOM, room.getStatus());

        // Doctor joins call
        teleEngine.joinRoom(room.getRoomId(), "DOCTOR");
        assertEquals(TelemedicineEngine.RoomStatus.IN_CONSULTATION, room.getStatus());
        assertNotNull(room.getActualStartTime());

        // End consultation
        teleEngine.endSession(room.getRoomId());
        assertEquals(TelemedicineEngine.RoomStatus.COMPLETED, room.getStatus());
        assertNotNull(room.getEndTime());
    }

    @Test
    @DisplayName("DICOM PACS: Should assign Lung window level (WW 1500, WL -600) for Chest CT study")
    void testDicomWindowLevelPresets() {
        DicomPacsEngine.DicomStudy study = dicomEngine.createPacsStudy(
                "ACC-10001", "MRN-10001", "Anand Patil", "CT", "CT Chest High Resolution", "THORAX"
        );

        assertNotNull(study);
        assertTrue(study.getStudyInstanceUid().startsWith("1.2.840.10008."));
        assertEquals("LUNG", study.getDefaultWindowPreset().getPresetName());
        assertEquals(1500, study.getDefaultWindowPreset().getWindowWidth());
        assertEquals(-600, study.getDefaultWindowPreset().getWindowCenter());
    }

    @Test
    @DisplayName("Blood Bank: Should detect temperature breach when PRBC storage exceeds 6.0°C")
    void testColdChainTemperatureBreach() {
        BloodBankColdChainEngine.ColdChainAlert alert = coldChainEngine.evaluateStorageTemperature(
                "FRIDGE-PRBC-01", "PRBC", 8.5 // 8.5 C is outside 2-6 C
        );

        assertNotNull(alert);
        assertTrue(alert.isBreachDetected());
        assertTrue(alert.getCorrectiveAction().contains("CRITICAL COLD CHAIN BREACH"));
    }

    @Test
    @DisplayName("Blood Bank: Should verify O- donor red blood cells are compatible with AB+ recipient")
    void testUniversalDonorCompatibility() {
        BloodBankColdChainEngine.CrossmatchResult res = coldChainEngine.verifyAboCompatibility(
                "AB+", "O-", "PRBC"
        );

        assertNotNull(res);
        assertTrue(res.isCompatible());
    }

    @Test
    @DisplayName("Surgical Scheduling: Should calculate total OR block time with anesthesia induction and room turnover")
    void testSurgicalBlockTimeCalculation() {
        SurgicalSchedulingOptimizationEngine.OrSlotEstimate est = surgicalEngine.estimateBlockTime(
                "Coronary Artery Bypass Graft (CABG)", "ASA_III"
        );

        assertNotNull(est);
        assertEquals(240, est.getEstimatedSurgicalMinutes());
        assertEquals(60, est.getAnesthesiaInductionMinutes()); // 45 + 15 for ASA III
        assertEquals(25, est.getOrTurnoverAndCleaningMinutes());
        assertEquals(325, est.getTotalBlockTimeMinutes()); // 240 + 60 + 25 = 325 mins
    }
}
