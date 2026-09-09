package com.hospital.oncology.rest;

import com.hospital.oncology.cinv.CinvAntiemeticService;
import com.hospital.oncology.dosing.ChemotherapyDosingService;
import com.hospital.oncology.irae.IraeManagementService;
import com.hospital.oncology.mtb.MolecularTumorBoardService;
import com.hospital.oncology.neutropenia.FebrileNeutropeniaService;
import com.hospital.oncology.qol.EortcQolScoringService;
import com.hospital.oncology.recist.RecistEvaluationService;
import com.hospital.oncology.tls.TumorLysisSyndromeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/oncology")
@CrossOrigin(origins = "*")
public class ClinicalOncologyRestController {

    private final ChemotherapyDosingService dosingService;
    private final RecistEvaluationService recistService;
    private final IraeManagementService iraeService;
    private final MolecularTumorBoardService mtbService;
    private final FebrileNeutropeniaService neutropeniaService;
    private final TumorLysisSyndromeService tlsService;

    public ClinicalOncologyRestController(
        ChemotherapyDosingService dosingService,
        RecistEvaluationService recistService,
        IraeManagementService iraeService,
        MolecularTumorBoardService mtbService,
        FebrileNeutropeniaService neutropeniaService,
        TumorLysisSyndromeService tlsService
    ) {
        this.dosingService = dosingService;
        this.recistService = recistService;
        this.iraeService = iraeService;
        this.mtbService = mtbService;
        this.neutropeniaService = neutropeniaService;
        this.tlsService = tlsService;
    }

    @PostMapping("/dosing/calvert")
    public ResponseEntity<ChemotherapyDosingService.CalvertDosingResult> calculateCarboplatin(
        @RequestBody ChemotherapyDosingService.PatientBiometrics biometrics,
        @RequestParam double targetAuc
    ) {
        return ResponseEntity.ok(dosingService.calculateCarboplatinDose(biometrics, targetAuc));
    }

    @GetMapping("/mtb/annotate")
    public ResponseEntity<MolecularTumorBoardService.PrecisionTherapyRecommendation> annotateVariant(
        @RequestParam String gene,
        @RequestParam String variant
    ) {
        return ResponseEntity.ok(mtbService.annotateVariant(gene, variant));
    }
}
