package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class VapVentilatorBundleProtocol {

    @Data
    @AllArgsConstructor
    public static class VapBundleCompliance {
        private String ventilatorId;
        private boolean headOfBed30To45Degrees;
        private boolean dailySedationInterruption;
        private boolean pepticUlcerProphylaxis;
        private boolean deepVeinThrombosisProphylaxis;
        private boolean dailyOralChlorhexidineCare;
        private boolean subglotticSuctioningUsed;
        private boolean isFullyCompliant;
    }

    public VapBundleCompliance evaluateCompliance(String ventId, boolean hob, boolean sedationHoliday, boolean ppi, boolean dvt, boolean chlorhexidine, boolean subglottic) {
        boolean allMet = hob && sedationHoliday && ppi && dvt && chlorhexidine && subglottic;
        return new VapBundleCompliance(ventId, hob, sedationHoliday, ppi, dvt, chlorhexidine, subglottic, allMet);
    }
}
