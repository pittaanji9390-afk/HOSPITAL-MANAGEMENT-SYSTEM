package com.hospital.perinatal.rest;

import com.hospital.perinatal.efm.ElectronicFetalMonitoringService;
import com.hospital.perinatal.nichd.NichdDecelerationAnalyzerService;
import com.hospital.perinatal.induction.BishopScoreCalculatorService;
import com.hospital.perinatal.pph.PostpartumHemorrhageService;
import com.hospital.perinatal.preeclampsia.PreeclampsiaProtocolService;
import com.hospital.perinatal.gdm.GestationalDiabetesService;
import com.hospital.perinatal.gbs.GroupBStrepProphylaxisService;
import com.hospital.perinatal.apgar.ApgarNrpResuscitationService;
import com.hospital.perinatal.sepsis.NeonatalSepsisRiskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/perinatal")
@CrossOrigin(origins = "*")
public class PerinatalRestController {

    private final ElectronicFetalMonitoringService efmService;
    private final NichdDecelerationAnalyzerService nichdService;
    private final BishopScoreCalculatorService bishopService;
    private final PostpartumHemorrhageService pphService;
    private final PreeclampsiaProtocolService preeclampsiaService;
    private final GestationalDiabetesService gdmService;
    private final GroupBStrepProphylaxisService gbsService;
    private final ApgarNrpResuscitationService apgarService;
    private final NeonatalSepsisRiskService sepsisService;

    public PerinatalRestController(
            ElectronicFetalMonitoringService efmService,
            NichdDecelerationAnalyzerService nichdService,
            BishopScoreCalculatorService bishopService,
            PostpartumHemorrhageService pphService,
            PreeclampsiaProtocolService preeclampsiaService,
            GestationalDiabetesService gdmService,
            GroupBStrepProphylaxisService gbsService,
            ApgarNrpResuscitationService apgarService,
            NeonatalSepsisRiskService sepsisService
    ) {
        this.efmService = efmService;
        this.nichdService = nichdService;
        this.bishopService = bishopService;
        this.pphService = pphService;
        this.preeclampsiaService = preeclampsiaService;
        this.gdmService = gdmService;
        this.gbsService = gbsService;
        this.apgarService = apgarService;
        this.sepsisService = sepsisService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> getHealth() {
        return ResponseEntity.ok(Map.of(
                "service", "Labor & Delivery and Perinatal Medicine Subsystem",
                "status", "ACTIVE",
                "laborSuites", 12,
                "nicuBeds", 24,
                "guidelinesSupported", List.of("ACOG CTG Category I/II/III", "CMQCC PPH Stage 0-3", "ACOG Preeclampsia", "NRP 8th Edition")
        ));
    }
}
