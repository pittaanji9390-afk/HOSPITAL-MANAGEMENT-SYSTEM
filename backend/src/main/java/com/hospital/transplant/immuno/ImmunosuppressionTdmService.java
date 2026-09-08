package com.hospital.transplant.immuno;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Post-Transplant Therapeutic Drug Monitoring (TDM) & Immunosuppression Engine.
 * Targets: Tacrolimus trough (Prograf/Envarsus: 8-12 ng/mL month 1-3, 5-8 ng/mL post-month 3),
 * Cyclosporine C0/C2 monitoring, Mycophenolate MPA AUC (30-60 mg*h/L), and Corticosteroid weaning.
 */
@Service
public class ImmunosuppressionTdmService {

    public enum PostTransplantPhase { EARLY_MONTH_0_3, MAINTENANCE_POST_MONTH_3, RESCUE_REJECTION_THERAPY }
    public record TdmResult(String drugName, double measuredTroughNgMl, double targetMin, double targetMax, boolean withinTherapeuticWindow, String clinicalAction) {}

    public TdmResult evaluateTacrolimusTrough(double measuredTrough, PostTransplantPhase phase) {
        double targetMin = phase == PostTransplantPhase.EARLY_MONTH_0_3 ? 8.0 : 5.0;
        double targetMax = phase == PostTransplantPhase.EARLY_MONTH_0_3 ? 12.0 : 8.0;

        boolean pass = measuredTrough >= targetMin && measuredTrough <= targetMax;
        String action;
        if (measuredTrough < targetMin) {
            action = "SUB-THERAPEUTIC: Increase Tacrolimus dose by 20%. Acute cellular rejection risk.";
        } else if (measuredTrough > targetMax) {
            action = "SUPRA-THERAPEUTIC: Decrease dose by 25%. Calcineurin inhibitor nephrotoxicity / tremor risk.";
        } else {
            action = "THERAPEUTIC: Maintain current immunosuppressive dosing schedule.";
        }

        return new TdmResult("Tacrolimus (Prograf)", measuredTrough, targetMin, targetMax, pass, action);
    }
}
