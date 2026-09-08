package com.hospital.genetics.rest;

import com.hospital.genetics.acmg.AcmgVariantClassificationService;
import com.hospital.genetics.fabry.FabryDiseaseService;
import com.hospital.genetics.fh.FamilialHypercholesterolemiaService;
import com.hospital.genetics.hboc.HbocBrcaService;
import com.hospital.genetics.hfe.HereditaryHemochromatosisService;
import com.hospital.genetics.huntington.HuntingtonCagRepeatService;
import com.hospital.genetics.lqts.LongQtSchwartzService;
import com.hospital.genetics.lynch.LynchSyndromeEvaluatorService;
import com.hospital.genetics.sma.SpinalMuscularAtrophyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/genetics")
@CrossOrigin(origins = "*")
public class ClinicalGeneticsRestController {

    private final AcmgVariantClassificationService acmgService;
    private final LynchSyndromeEvaluatorService lynchService;
    private final HbocBrcaService hbocService;
    private final FamilialHypercholesterolemiaService fhService;
    private final HuntingtonCagRepeatService hdService;
    private final SpinalMuscularAtrophyService smaService;

    public ClinicalGeneticsRestController(
        AcmgVariantClassificationService acmgService,
        LynchSyndromeEvaluatorService lynchService,
        HbocBrcaService hbocService,
        FamilialHypercholesterolemiaService fhService,
        HuntingtonCagRepeatService hdService,
        SpinalMuscularAtrophyService smaService
    ) {
        this.acmgService = acmgService;
        this.lynchService = lynchService;
        this.hbocService = hbocService;
        this.fhService = fhService;
        this.hdService = hdService;
        this.smaService = smaService;
    }

    @PostMapping("/acmg/classify")
    public ResponseEntity<AcmgVariantClassificationService.AcmgResult> classifyVariant(@RequestBody AcmgVariantClassificationService.VariantEvidenceCriteria criteria) {
        return ResponseEntity.ok(acmgService.classifyVariant(criteria));
    }

    @GetMapping("/huntington/cag")
    public ResponseEntity<HuntingtonCagRepeatService.HdResult> evaluateHuntington(@RequestParam int a1, @RequestParam int a2) {
        return ResponseEntity.ok(hdService.evaluateCagRepeats(a1, a2));
    }
}
