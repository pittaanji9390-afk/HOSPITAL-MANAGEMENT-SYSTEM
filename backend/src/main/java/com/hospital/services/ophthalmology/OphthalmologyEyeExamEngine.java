package com.hospital.services.ophthalmology;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class OphthalmologyEyeExamEngine {

    @Data
    @Builder
    public static class EyeExaminationSummary {
        private String patientMrn;
        private double odIopMmHg;
        private double osIopMmHg;
        private double odLogMar;
        private double osLogMar;
        private String etdrsRetinopathyStage;
        private boolean isGlaucomaSuspect;
        private String therapeuticPlan;
    }

    public EyeExaminationSummary processEyeExam(String patientMrn, double odIop, double osIop, String odSnellen, String osSnellen, String etdrsStage) {
        double odLog = odSnellen.equals("20/20") ? 0.0 : (odSnellen.equals("20/40") ? 0.30 : (odSnellen.equals("20/200") ? 1.0 : 0.5));
        double osLog = osSnellen.equals("20/20") ? 0.0 : (osSnellen.equals("20/40") ? 0.30 : (osSnellen.equals("20/200") ? 1.0 : 0.5));

        boolean glaucomaAlert = odIop > 21.0 || osIop > 21.0;

        return EyeExaminationSummary.builder()
                .patientMrn(patientMrn)
                .odIopMmHg(odIop)
                .osIopMmHg(osIop)
                .odLogMar(odLog)
                .osLogMar(osLog)
                .etdrsRetinopathyStage(etdrsStage)
                .isGlaucomaSuspect(glaucomaAlert)
                .therapeuticPlan(glaucomaAlert ? "Initiate Latanoprost 0.005% ophthalmic solution 1 drop QHS in affected eye; schedule Humphrey Visual Field 24-2." : "Routine 12-month follow-up examination.")
                .build();
    }
}
