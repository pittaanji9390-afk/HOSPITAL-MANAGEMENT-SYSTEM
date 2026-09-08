package com.hospital.pathways;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CodeStrokeThrombolysisPathway {

    @Data
    @Builder
    public static class StrokeMilestone {
        private String stepCode;
        private String stepTitle;
        private int targetMinutes;
        private List<String> requiredOrders;
    }

    public List<StrokeMilestone> getStrokeCareBundle() {
        return List.of(
            StrokeMilestone.builder()
                .stepCode("STEP_1_ARRIVAL_AND_NIHSS")
                .stepTitle("Emergency Assessment, NIHSS Examination & Point-of-Care Glucose")
                .targetMinutes(10)
                .requiredOrders(List.of("Point-of-care capillary blood glucose (rule out hypoglycemia)", "Complete NIHSS 11-item evaluation", "Establish 2 large bore IV access lines"))
                .build(),
            StrokeMilestone.builder()
                .stepCode("STEP_2_NCCT_AND_CTA_IMAGING")
                .stepTitle("Non-Contrast CT Brain & CT Angiography Head/Neck")
                .targetMinutes(25)
                .requiredOrders(List.of("Non-contrast head CT (rule out intracranial hemorrhage)", "CT Angiography to evaluate Large Vessel Occlusion (LVO)"))
                .build(),
            StrokeMilestone.builder()
                .stepCode("STEP_3_THROMBOLYTIC_INFUSION")
                .stepTitle("IV Thrombolysis Administration (Alteplase 0.9 mg/kg or Tenecteplase 0.25 mg/kg)")
                .targetMinutes(45)
                .requiredOrders(List.of("Verify blood pressure < 185/110 mmHg (administer Nicardipine/Labetalol if elevated)", "Administer IV Thrombolytic bolus", "Transfer to Neuro-ICU"))
                .build()
        );
    }
}
