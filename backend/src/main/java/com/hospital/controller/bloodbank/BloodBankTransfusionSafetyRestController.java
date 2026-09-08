package com.hospital.controller.bloodbank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/blood-bank")
@CrossOrigin(origins = "*")
public class BloodBankTransfusionSafetyRestController {

    @Data
    @AllArgsConstructor
    public static class BloodProductUnit {
        private String unitDinBarcode; // ISBT 128 barcode
        private String productType; // Packed Red Blood Cells (PRBC), Platelets Pheresed, Fresh Frozen Plasma (FFP), Cryoprecipitate
        private String aboRhGroup; // O+, O-, A+, A-, B+, B-, AB+, AB-
        private String allocatedPatientId;
        private String crossmatchStatus; // COMPATIBLE, INCOMPATIBLE, EMERGENCY_UNCROSSMATCHED
        private Instant expirationDateTime;
    }

    private final Map<String, BloodProductUnit> units = new LinkedHashMap<>();

    public BloodBankTransfusionSafetyRestController() {
        units.put("DIN-W0398-PRBC-01", new BloodProductUnit("DIN-W0398-PRBC-01", "Packed Red Blood Cells (PRBC)", "O-Negative", "PT-8812", "COMPATIBLE", Instant.now().plusSeconds(86400 * 20)));
        units.put("DIN-W0398-PLT-02", new BloodProductUnit("DIN-W0398-PLT-02", "Platelets Leukoreduced", "A-Positive", "PT-9941", "COMPATIBLE", Instant.now().plusSeconds(86400 * 2)));
    }

    @GetMapping("/units")
    public ResponseEntity<List<BloodProductUnit>> getUnits() {
        return ResponseEntity.ok(new ArrayList<>(units.values()));
    }
}
