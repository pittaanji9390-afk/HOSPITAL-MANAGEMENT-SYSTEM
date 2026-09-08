package com.hospital.cssd.rest;

import com.hospital.cssd.autoclave.AutoclaveCycleService;
import com.hospital.cssd.bi.BiologicalIndicatorService;
import com.hospital.cssd.endoscope.EndoscopeReprocessingService;
import com.hospital.cssd.tracking.InstrumentTrackingService;
import com.hospital.cssd.washer.WasherDisinfectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/cssd")
@CrossOrigin(origins = "*")
public class CssdOperationsRestController {

    private final InstrumentTrackingService trackingService;
    private final AutoclaveCycleService autoclaveService;
    private final BiologicalIndicatorService biService;
    private final EndoscopeReprocessingService endoscopeService;
    private final WasherDisinfectorService washerService;

    public CssdOperationsRestController(
        InstrumentTrackingService trackingService,
        AutoclaveCycleService autoclaveService,
        BiologicalIndicatorService biService,
        EndoscopeReprocessingService endoscopeService,
        WasherDisinfectorService washerService
    ) {
        this.trackingService = trackingService;
        this.autoclaveService = autoclaveService;
        this.biService = biService;
        this.endoscopeService = endoscopeService;
        this.washerService = washerService;
    }

    @GetMapping("/trays")
    public ResponseEntity<List<InstrumentTrackingService.TrayInstance>> getAllTrays() {
        return ResponseEntity.ok(trackingService.getAllTrays());
    }

    @GetMapping("/bi/tests")
    public ResponseEntity<List<BiologicalIndicatorService.BiTestRecord>> getBiRecords() {
        return ResponseEntity.ok(biService.getAllBiRecords());
    }

    @GetMapping("/endoscopes")
    public ResponseEntity<List<EndoscopeReprocessingService.EndoscopeDevice>> getEndoscopes() {
        return ResponseEntity.ok(endoscopeService.listAllScopes());
    }

    @GetMapping("/washers/cycles")
    public ResponseEntity<List<WasherDisinfectorService.WasherCycleTelemetry>> getWasherLogs() {
        return ResponseEntity.ok(washerService.getCycleLogs());
    }
}
