package com.hospital.bloodbank.rest;

import com.hospital.bloodbank.compatibility.CompatibilityMatrixService;
import com.hospital.bloodbank.emergency.EmergencyReleaseService;
import com.hospital.bloodbank.hemovigilance.HemovigilanceService;
import com.hospital.bloodbank.isbt.Isbt128ParserService;
import com.hospital.bloodbank.mtp.MassiveTransfusionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/bloodbank")
@CrossOrigin(origins = "*")
public class BloodBankOperationsRestController {

    private final Isbt128ParserService isbtService;
    private final MassiveTransfusionService mtpService;
    private final HemovigilanceService hemovigilanceService;
    private final CompatibilityMatrixService compatibilityService;
    private final EmergencyReleaseService emergencyService;

    public BloodBankOperationsRestController(
        Isbt128ParserService isbtService,
        MassiveTransfusionService mtpService,
        HemovigilanceService hemovigilanceService,
        CompatibilityMatrixService compatibilityService,
        EmergencyReleaseService emergencyService
    ) {
        this.isbtService = isbtService;
        this.mtpService = mtpService;
        this.hemovigilanceService = hemovigilanceService;
        this.compatibilityService = compatibilityService;
        this.emergencyService = emergencyService;
    }

    @PostMapping("/isbt/parse")
    public ResponseEntity<Isbt128ParserService.ParsedIsbt128Tag> parseIsbt(@RequestParam String din, @RequestParam String product, @RequestParam String abo) {
        return ResponseEntity.ok(isbtService.parseDin(din, product, abo));
    }

    @GetMapping("/mtp/coolers/{mtpId}")
    public ResponseEntity<List<MassiveTransfusionService.MtpCooler>> getMtpCoolers(@PathVariable String mtpId) {
        return ResponseEntity.ok(mtpService.getActiveCoolers(mtpId));
    }

    @GetMapping("/compatibility/check")
    public ResponseEntity<CompatibilityMatrixService.CompatibilityCheck> checkCompatibility(@RequestParam String recipientAbo, @RequestParam String donorAbo, @RequestParam String component) {
        return ResponseEntity.ok(compatibilityService.verifyCompatibility(recipientAbo, donorAbo, component));
    }
}
