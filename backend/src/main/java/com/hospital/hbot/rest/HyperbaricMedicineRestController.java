package com.hospital.hbot.rest;

import com.hospital.hbot.chamber.HyperbaricChamberService;
import com.hospital.hbot.co.CarbonMonoxideClearanceService;
import com.hospital.hbot.divetable.UsNavyDiveTableService;
import com.hospital.hbot.marx.MarxRadiationInjuryService;
import com.hospital.hbot.safety.ChamberSafetyInterlockService;
import com.hospital.hbot.tcom.TranscutaneousOximetryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/hbot")
@CrossOrigin(origins = "*")
public class HyperbaricMedicineRestController {

    private final HyperbaricChamberService chamberService;
    private final UsNavyDiveTableService diveService;
    private final CarbonMonoxideClearanceService coService;
    private final TranscutaneousOximetryService tcomService;
    private final MarxRadiationInjuryService marxService;
    private final ChamberSafetyInterlockService safetyService;

    public HyperbaricMedicineRestController(
        HyperbaricChamberService chamberService,
        UsNavyDiveTableService diveService,
        CarbonMonoxideClearanceService coService,
        TranscutaneousOximetryService tcomService,
        MarxRadiationInjuryService marxService,
        ChamberSafetyInterlockService safetyService
    ) {
        this.chamberService = chamberService;
        this.diveService = diveService;
        this.coService = coService;
        this.tcomService = tcomService;
        this.marxService = marxService;
        this.safetyService = safetyService;
    }

    @PostMapping("/session/start")
    public ResponseEntity<HyperbaricChamberService.ChamberSession> startSession(@RequestParam String chamberId, @RequestParam double targetAta) {
        return ResponseEntity.ok(chamberService.startSession(chamberId, targetAta));
    }

    @GetMapping("/divetables/select")
    public ResponseEntity<UsNavyDiveTableService.DiveTreatmentPlan> selectDiveTable(
        @RequestParam UsNavyDiveTableService.DciSeverity severity,
        @RequestParam boolean alteredMentalStatus,
        @RequestParam boolean numbnessWeakness
    ) {
        return ResponseEntity.ok(diveService.selectTreatmentTable(severity, alteredMentalStatus, numbnessWeakness));
    }

    @GetMapping("/tcom/evaluate")
    public ResponseEntity<TranscutaneousOximetryService.Tcpo2Assessment> evaluateTcpo2(
        @RequestParam double baseline,
        @RequestParam double normo100,
        @RequestParam double inChamber
    ) {
        return ResponseEntity.ok(tcomService.evaluateTcpo2(baseline, normo100, inChamber));
    }
}
