package com.hospital.ophthalmology;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class OphthalmologyService {

    public enum RetinopathyGrade { NO_DR, MILD_NPDR, MODERATE_NPDR, SEVERE_NPDR, PROLIFERATIVE_DR }

    public static record EyeAssessment(
            String examId,
            String patientId,
            int iopRightMmHg,
            int iopLeftMmHg,
            RetinopathyGrade rightRetinopathy,
            RetinopathyGrade leftRetinopathy,
            boolean antiVegfIndicated,
            String ocularHypotensiveOrder,
            Instant examinedAt
    ) implements Serializable {}

    public EyeAssessment evaluateEyes(String id, String patientId, int iopOd, int iopOs, RetinopathyGrade od, RetinopathyGrade os) {
        boolean vegf = (od == RetinopathyGrade.PROLIFERATIVE_DR || os == RetinopathyGrade.PROLIFERATIVE_DR);
        String drop = (iopOd > 21 || iopOs > 21) 
                ? "Initiate topical Prostaglandin Analog (Latanoprost 0.005% 1 drop QHS) + Beta Blocker (Timolol 0.5% BID)."
                : "Intraocular pressure within target range (<21 mmHg).";

        return new EyeAssessment(id, patientId, iopOd, iopOs, od, os, vegf, drop, Instant.now());
    }
}
