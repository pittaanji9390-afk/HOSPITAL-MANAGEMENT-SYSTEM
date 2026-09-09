package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ClabsiCentralLineBundleProtocol {

    @Data
    @AllArgsConstructor
    public static class CentralLineChecklist {
        private String lineId;
        private String insertionSite; // SUBCLAVIAN_PREFERRED, INTERNAL_JUGULAR, FEMORAL_AVOID
        private boolean isChlorhexidineSkinPrepDone;
        private boolean isMaximalSterileBarrierUsed;
        private boolean isDailyLineNecessityReviewed;
        private boolean isDressingChangeWithin7Days;
    }

    public CentralLineChecklist createChecklist(String lineId, String site) {
        return new CentralLineChecklist(lineId, site, true, true, true, true);
    }
}
