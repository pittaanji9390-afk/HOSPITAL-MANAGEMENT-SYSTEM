package com.hospital.pharmacy.rest;

import com.hospital.pharmacy.adc.AdcDrawerBusService;
import com.hospital.pharmacy.cleanroom.CleanroomMonitoringService;
import com.hospital.pharmacy.compounding.GravimetricVerificationService;
import com.hospital.pharmacy.controlled.DeaPerpetualLedgerService;
import com.hospital.pharmacy.tpn.TpnFormulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/pharmacy")
@CrossOrigin(origins = "*")
public class HospitalPharmacyRestController {

    private final AdcDrawerBusService adcService;
    private final DeaPerpetualLedgerService deaService;
    private final CleanroomMonitoringService cleanroomService;
    private final GravimetricVerificationService gravimetricService;
    private final TpnFormulationService tpnService;

    public HospitalPharmacyRestController(
        AdcDrawerBusService adcService,
        DeaPerpetualLedgerService deaService,
        CleanroomMonitoringService cleanroomService,
        GravimetricVerificationService gravimetricService,
        TpnFormulationService tpnService
    ) {
        this.adcService = adcService;
        this.deaService = deaService;
        this.cleanroomService = cleanroomService;
        this.gravimetricService = gravimetricService;
        this.tpnService = tpnService;
    }

    @GetMapping("/adc/drawers/{drawerId}")
    public ResponseEntity<AdcDrawerBusService.DrawerTelemetry> getAdcDrawerStatus(@PathVariable String drawerId) {
        return ResponseEntity.ok(adcService.getDrawerTelemetry(drawerId));
    }

    @PostMapping("/adc/drawers/{drawerId}/unlock")
    public ResponseEntity<AdcDrawerBusService.SolenoidState> unlockPocket(
        @PathVariable String drawerId,
        @RequestParam String pocketId,
        @RequestParam String nurseBadge,
        @RequestParam String rxOrder
    ) {
        return ResponseEntity.ok(adcService.unlockPocket(drawerId, pocketId, nurseBadge, rxOrder));
    }

    @GetMapping("/controlled/vault/{ndc}")
    public ResponseEntity<DeaPerpetualLedgerService.VaultBalance> getVaultBalance(@PathVariable String ndc) {
        return ResponseEntity.ok(deaService.getBalance(ndc));
    }

    @GetMapping("/cleanroom/zones")
    public ResponseEntity<List<CleanroomMonitoringService.CleanroomZone>> getCleanroomZones() {
        return ResponseEntity.ok(cleanroomService.getAllZones());
    }

    @PostMapping("/tpn/calculate")
    public ResponseEntity<TpnFormulationService.TpnSafetyProfile> calculateTpn(@RequestBody TpnFormulationService.TpnPrescription rx) {
        return ResponseEntity.ok(tpnService.evaluateTpn(rx));
    }
}
