package com.hospital.cathlab.rest;

import com.hospital.cathlab.coronary.TimiFlowGradeService;
import com.hospital.cathlab.syntax.SyntaxScoreCalculatorService;
import com.hospital.cathlab.hemodynamics.CoronaryPhysiologyFfrService;
import com.hospital.cathlab.cin.MehranRiskCinService;
import com.hospital.cathlab.radiation.FluoroscopyRadiationSafetyService;
import com.hospital.cathlab.closure.VascularClosureDeviceService;
import com.hospital.cathlab.tips.TipsHemodynamicsService;
import com.hospital.cathlab.thrombectomy.CatheterThrombolysisService;
import com.hospital.cathlab.hemodynamics.LvHemodynamicsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/cathlab")
@CrossOrigin(origins = "*")
public class CathLabRestController {

    private final TimiFlowGradeService timiService;
    private final SyntaxScoreCalculatorService syntaxService;
    private final CoronaryPhysiologyFfrService ffrService;
    private final MehranRiskCinService mehranService;
    private final FluoroscopyRadiationSafetyService radiationService;
    private final VascularClosureDeviceService closureService;
    private final TipsHemodynamicsService tipsService;
    private final CatheterThrombolysisService ekosService;
    private final LvHemodynamicsService lvService;

    public CathLabRestController(
            TimiFlowGradeService timiService,
            SyntaxScoreCalculatorService syntaxService,
            CoronaryPhysiologyFfrService ffrService,
            MehranRiskCinService mehranService,
            FluoroscopyRadiationSafetyService radiationService,
            VascularClosureDeviceService closureService,
            TipsHemodynamicsService tipsService,
            CatheterThrombolysisService ekosService,
            LvHemodynamicsService lvService
    ) {
        this.timiService = timiService;
        this.syntaxService = syntaxService;
        this.ffrService = ffrService;
        this.mehranService = mehranService;
        this.radiationService = radiationService;
        this.closureService = closureService;
        this.tipsService = tipsService;
        this.ekosService = ekosService;
        this.lvService = lvService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> getHealth() {
        return ResponseEntity.ok(Map.of(
                "service", "Cardiac Cath Lab & Interventional Radiology Subsystem",
                "status", "ACTIVE",
                "angiographySuites", 6,
                "supportedProcedures", List.of("PCI", "TAVR", "FFR/iFR", "TIPS", "EKOS", "Atherectomy", "EVAR")
        ));
    }
}
