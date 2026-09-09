package com.hospital.derm;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class DermatologyOncologyService {

    public static record MelanomaStaging(
            String lesionId,
            String patientId,
            double breslowDepthMm,
            boolean ulcerationPresent,
            int mitoticRatePerMm2,
            String ajccStage,
            boolean sentinelLymphNodeBiopsyIndicated,
            int recommendedExcisionMarginMm,
            Instant stagedAt
    ) implements Serializable {}

    public MelanomaStaging stageMelanoma(String lesionId, String patientId, double breslow, boolean ulceration, int mitoses) {
        String stage;
        boolean slnb;
        int margin;

        if (breslow <= 0.8 && !ulceration) {
            stage = "Stage IA (T1a)";
            slnb = false;
            margin = 10; // 1 cm
        } else if (breslow <= 1.0 || (breslow <= 2.0 && !ulceration)) {
            stage = "Stage IB (T1b / T2a)";
            slnb = true;
            margin = 10;
        } else if (breslow <= 4.0) {
            stage = "Stage IIA/IIB";
            slnb = true;
            margin = 20; // 2 cm
        } else {
            stage = "Stage IIC (T4b)";
            slnb = true;
            margin = 20;
        }

        return new MelanomaStaging(lesionId, patientId, breslow, ulceration, mitoses, stage, slnb, margin, Instant.now());
    }
}
