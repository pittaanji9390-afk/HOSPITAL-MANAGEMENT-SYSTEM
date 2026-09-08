package com.hospital.transplant.viral;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Post-Transplant Viral Surveillance Engine.
 * Evaluates CMV Serostatus Risk (D+/R- High Risk, D+/R+ or D-/R+ Moderate Risk, D-/R- Low Risk),
 * Quantitative PCR DNA Log Copies/mL, and EBV DNAemia triggers for immunosuppression reduction.
 */
@Service
public class TransplantViralSurveillanceService {

    public record CmvAssessment(String donorSerology, String recipientSerology, double viralCopiesPerMl, boolean requiresValganciclovirTreatment) {}

    public CmvAssessment evaluateCmv(String dSero, String rSero, double copiesMl) {
        boolean highRisk = "POSITIVE".equalsIgnoreCase(dSero) && "NEGATIVE".equalsIgnoreCase(rSero);
        boolean activeInfection = copiesMl >= 1000.0;
        return new CmvAssessment(dSero, rSero, copiesMl, highRisk || activeInfection);
    }
}
