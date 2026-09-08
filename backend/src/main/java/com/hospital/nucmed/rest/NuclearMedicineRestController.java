package com.hospital.nucmed.rest;

import com.hospital.nucmed.dotatate.Lu177DotatateService;
import com.hospital.nucmed.generator.Tc99mGeneratorQcService;
import com.hospital.nucmed.i131.I131TherapyService;
import com.hospital.nucmed.lu177.Lu177PsmaService;
import com.hospital.nucmed.pet.PetCtDosimetryService;
import com.hospital.nucmed.safety.RadiationSurveyService;
import com.hospital.nucmed.sirt.Y90RadioembolizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/nucmed")
@CrossOrigin(origins = "*")
public class NuclearMedicineRestController {

    private final Tc99mGeneratorQcService generatorService;
    private final I131TherapyService i131Service;
    private final Lu177PsmaService lu177Service;
    private final Y90RadioembolizationService y90Service;
    private final PetCtDosimetryService petService;
    private final RadiationSurveyService surveyService;

    public NuclearMedicineRestController(
        Tc99mGeneratorQcService generatorService,
        I131TherapyService i131Service,
        Lu177PsmaService lu177Service,
        Y90RadioembolizationService y90Service,
        PetCtDosimetryService petService,
        RadiationSurveyService surveyService
    ) {
        this.generatorService = generatorService;
        this.i131Service = i131Service;
        this.lu177Service = lu177Service;
        this.y90Service = y90Service;
        this.petService = petService;
        this.surveyService = surveyService;
    }

    @PostMapping("/generator/tc99m/evaluate")
    public ResponseEntity<Tc99mGeneratorQcService.QcEvaluationResult> evaluateTc99m(@RequestBody Tc99mGeneratorQcService.GeneratorElutionRecord record) {
        return ResponseEntity.ok(generatorService.evaluateElution(record));
    }

    @GetMapping("/sirt/y90/dosimetry")
    public ResponseEntity<Y90RadioembolizationService.Y90DosimetryPlan> calculateY90Dosimetry(
        @RequestParam double lungCounts,
        @RequestParam double liverCounts,
        @RequestParam double liverMassGrams,
        @RequestParam double tumorDoseGy
    ) {
        return ResponseEntity.ok(y90Service.calculateDosimetry(new Y90RadioembolizationService.MaaScanCounts(lungCounts, liverCounts, liverMassGrams, tumorDoseGy)));
    }
}
