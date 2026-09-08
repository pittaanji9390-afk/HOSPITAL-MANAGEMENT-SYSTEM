package com.hospital.transplant.rest;

import com.hospital.transplant.allocation.MeldNaAllocationService;
import com.hospital.transplant.hla.VirtualCrossmatchService;
import com.hospital.transplant.kidney.KdpiEptsMatchingService;
import com.hospital.transplant.perfusion.OrganPerfusionTrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/transplant")
@CrossOrigin(origins = "*")
public class TransplantOperationsRestController {

    private final MeldNaAllocationService meldService;
    private final KdpiEptsMatchingService kasService;
    private final VirtualCrossmatchService vXmService;
    private final OrganPerfusionTrackingService perfusionService;

    public TransplantOperationsRestController(
        MeldNaAllocationService meldService,
        KdpiEptsMatchingService kasService,
        VirtualCrossmatchService vXmService,
        OrganPerfusionTrackingService perfusionService
    ) {
        this.meldService = meldService;
        this.kasService = kasService;
        this.vXmService = vXmService;
        this.perfusionService = perfusionService;
    }

    @PostMapping("/meld-na/calculate")
    public ResponseEntity<MeldNaAllocationService.MeldNaResult> calculateMeldNa(@RequestBody MeldNaAllocationService.MeldNaInput input) {
        return ResponseEntity.ok(meldService.calculateMeldNa(input));
    }

    @GetMapping("/perfusion/organs")
    public ResponseEntity<List<OrganPerfusionTrackingService.PerfusionTelemetry>> getActiveOrgans() {
        return ResponseEntity.ok(perfusionService.listActiveOrgans());
    }
}
