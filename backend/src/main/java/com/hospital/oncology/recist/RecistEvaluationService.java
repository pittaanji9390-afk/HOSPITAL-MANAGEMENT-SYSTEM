package com.hospital.oncology.recist;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * RECIST 1.1 (Response Evaluation Criteria in Solid Tumors) Response Classifier.
 * Evaluates Sum of Longest Diameters (SLD) of target lesions (max 5 total, max 2 per organ)
 * against baseline and nadir scans to classify: Complete Response (CR), Partial Response (PR),
 * Stable Disease (SD), and Progressive Disease (PD).
 */
@Service
public class RecistEvaluationService {

    public enum RecistCategory { COMPLETE_RESPONSE_CR, PARTIAL_RESPONSE_PR, STABLE_DISEASE_SD, PROGRESSIVE_DISEASE_PD }
    public record TargetLesion(String lesionId, String anatomicalLocation, double longestDiameterMm, boolean isLymphNodeShortAxis) {}
    public record RecistAssessment(
        double baselineSldMm,
        double nadirSldMm,
        double currentSldMm,
        double percentChangeFromBaseline,
        double percentChangeFromNadir,
        boolean newLesionAppeared,
        boolean nonTargetProgressive,
        RecistCategory overallResponse,
        String clinicalInterpretation
    ) {}

    public RecistAssessment evaluateResponse(
        double baselineSld,
        double nadirSld,
        double currentSld,
        boolean newLesions,
        boolean nonTargetProgression
    ) {
        double pctBaseline = ((currentSld - baselineSld) / baselineSld) * 100.0;
        double pctNadir = ((currentSld - nadirSld) / nadirSld) * 100.0;

        RecistCategory category;
        String interp;

        if (newLesions || nonTargetProgression || (pctNadir >= 20.0 && (currentSld - nadirSld) >= 5.0)) {
            category = RecistCategory.PROGRESSIVE_DISEASE_PD;
            interp = "PROGRESSIVE DISEASE (PD): >= 20% increase over nadir (+5mm absolute) or new lesion appearance.";
        } else if (currentSld == 0.0) {
            category = RecistCategory.COMPLETE_RESPONSE_CR;
            interp = "COMPLETE RESPONSE (CR): Disappearance of all target lesions (lymph nodes < 10mm short axis).";
        } else if (pctBaseline <= -30.0) {
            category = RecistCategory.PARTIAL_RESPONSE_PR;
            interp = "PARTIAL RESPONSE (PR): >= 30% decrease in sum of diameters relative to baseline.";
        } else {
            category = RecistCategory.STABLE_DISEASE_SD;
            interp = "STABLE DISEASE (SD): Insufficient shrinkage for PR and insufficient growth for PD.";
        }

        return new RecistAssessment(baselineSld, nadirSld, currentSld, pctBaseline, pctNadir, newLesions, nonTargetProgression, category, interp);
    }
}
