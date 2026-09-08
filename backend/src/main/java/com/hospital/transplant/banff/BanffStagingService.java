package com.hospital.transplant.banff;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Banff 2019 Working Classification for Allograft Pathology.
 * Scores interstitial inflammation (i), tubulitis (t), intimal arteritis (v),
 * glomerulitis (g), peritubular capillaritis (ptc), and C4d complement staining.
 */
@Service
public class BanffStagingService {

    public record BanffLesionScores(int interstitialInflammation_i, int tubulitis_t, int intimalArteritis_v, int glomerulitis_g, int peritubularCapillaritis_ptc, int c4dScore) {}
    public record BanffDiagnosticResult(String diagnosisCategory, String tcrGrade, String abmrGrade, String recommendedTherapy) {}

    public BanffDiagnosticResult evaluateBiopsy(BanffLesionScores s) {
        String tcr = "NO TCMR";
        if (s.intimalArteritis_v() >= 2) tcr = "TCMR GRADE IIB (Severe Arteritis)";
        else if (s.intimalArteritis_v() == 1) tcr = "TCMR GRADE IIA (Mild-Moderate Arteritis)";
        else if (s.interstitialInflammation_i() >= 2 && s.tubulitis_t() >= 2) tcr = "TCMR GRADE IB (Severe Tubulitis)";
        else if (s.interstitialInflammation_i() >= 2 && s.tubulitis_t() >= 1) tcr = "TCMR GRADE IA (Mild-Moderate Tubulitis)";

        String abmr = "NO ACTIVE ABMR";
        if ((s.glomerulitis_g() + s.peritubularCapillaritis_ptc() >= 2) && s.c4dScore() >= 2) {
            abmr = "ACTIVE ANTIBODY-MEDIATED REJECTION (C4d POSITIVE ABMR)";
        }

        String therapy;
        if (abmr.contains("ACTIVE")) {
            therapy = "High-dose IVIG + Therapeutic Plasma Exchange (TPE) + Rituximab / Bortezomib";
        } else if (tcr.contains("GRADE II")) {
            therapy = "Anti-Thymocyte Globulin (rATG Thymoglobulin) 1.5 mg/kg + Methylprednisolone pulses";
        } else if (tcr.contains("GRADE I")) {
            therapy = "High-Dose Methylprednisolone Pulse (500mg IV daily x 3 days)";
        } else {
            therapy = "Stable Allograft: Continue baseline triple immunosuppression";
        }

        return new BanffDiagnosticResult(tcr + " | " + abmr, tcr, abmr, therapy);
    }
}
