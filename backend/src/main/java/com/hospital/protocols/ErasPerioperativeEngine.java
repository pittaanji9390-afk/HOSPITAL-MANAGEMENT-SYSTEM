package com.hospital.protocols;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ErasPerioperativeEngine {

    @Data
    @Builder
    public static class ErasCarePathway {
        private String surgicalCaseId;
        private List<String> preOpDirectives;
        private List<String> intraOpDirectives;
        private List<String> postOpDirectives;
    }

    public ErasCarePathway getErasPathway(String caseId) {
        return ErasCarePathway.builder()
                .surgicalCaseId(caseId)
                .preOpDirectives(List.of("No prolonged fasting: Clear liquids with carbohydrate loading up to 2 hours pre-op", "Multimodal analgesia pre-medication: Gabapentin 300mg + Acetaminophen 1000mg PO"))
                .intraOpDirectives(List.of("Goal-Directed Fluid Therapy (GDFT) using pulse pressure variation (PPV)", "Thoracic epidural analgesia or TAP blocks (opioid-sparing anesthesia)", "Normothermia maintenance with forced-air warming blanket"))
                .postOpDirectives(List.of("Early oral feeding initiated on POD 0", "Early mobilization: Out of bed >= 2 hours on POD 0, >= 6 hours daily from POD 1", "Early urinary catheter removal within 24 hours post-op"))
                .build();
    }
}
