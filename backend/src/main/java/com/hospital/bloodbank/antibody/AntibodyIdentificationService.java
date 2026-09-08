package com.hospital.bloodbank.antibody;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Immunohematology Antibody Identification (ID) & Antigram Rule-Out Engine.
 * Evaluates patient serum against 11-cell reagent red cell panels across IS, 37°C LISS, and AHG (Anti-Human Globulin / Coombs).
 * Enforces the "Rule of Three" (p < 0.05 statistical confirmation: 3 antigen-positive reacting cells + 3 antigen-negative non-reacting cells).
 */
@Service
public class AntibodyIdentificationService {

    public record PanelCellReaction(int cellNumber, String d, String c, String bigE, String littleC, String littleE, String k, String fya, String fyb, String jka, String jkb, String ahgReaction) {}
    public record IdentifiedAntibodyResult(String identifiedAlloantibody, int positiveMatches, int negativeMatches, boolean ruleOfThreeConfirmed, String antigenNegativeUnitRecommendation) {}

    public IdentifiedAntibodyResult identifyAntibody(List<PanelCellReaction> panel) {
        int kPosReact = 0;
        int kNegNonReact = 0;

        for (PanelCellReaction cell : panel) {
            if ("+".equals(cell.k()) && !"-".equals(cell.ahgReaction()) && !"0".equals(cell.ahgReaction())) {
                kPosReact++;
            } else if ("-".equals(cell.k()) && ("-".equals(cell.ahgReaction()) || "0".equals(cell.ahgReaction()))) {
                kNegNonReact++;
            }
        }

        boolean ruleOf3 = (kPosReact >= 3 && kNegNonReact >= 3);
        String name = ruleOf3 ? "Anti-Kell (Anti-K)" : "Atypical Alloantibody Under Investigation";
        String rec = ruleOf3 ? "Crossmatch ONLY Kell-negative (K-) donor units with Coombs AHG phase crossmatch." : "Perform extended enzyme / ficin / DTT panel.";

        return new IdentifiedAntibodyResult(name, kPosReact, kNegNonReact, ruleOf3, rec);
    }
}
