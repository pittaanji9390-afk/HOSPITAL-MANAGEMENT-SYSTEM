package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CautiHoudiniRemovalProtocol {

    @Data
    @AllArgsConstructor
    public static class HoudiniCriteriaEvaluation {
        private String catheterId;
        private boolean hasValidIndication;
        private String activeHoudiniIndication;
        private String removalOrderDirective;
    }

    public HoudiniCriteriaEvaluation evaluateCatheter(String id, boolean hematuriaGross, boolean obstructionUrinary, boolean urologicSurgery, boolean decubitusUlcerStage34, boolean inputOutputStrict, boolean notForResuscitationPalliative, boolean immobilityProlonged) {
        boolean valid = hematuriaGross || obstructionUrinary || urologicSurgery || decubitusUlcerStage34 || inputOutputStrict || notForResuscitationPalliative || immobilityProlonged;
        return new HoudiniCriteriaEvaluation(id, valid, valid ? "Valid Clinical Indication Present (HOUDINI)" : "NO VALID INDICATION (HOUDINI Criteria Unmet)", valid ? "Maintain Foley with daily re-evaluation." : "REMOVE FOLEY CATHETER TODAY to prevent CAUTI.");
    }
}
