package com.hospital.uro;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class UrodynamicsService {

    public static record UrodynamicEvaluation(
            String testId,
            String patientId,
            double maxFlowRateQmaxMlSec, // Normal > 15 mL/s
            double postVoidResidualMl, // Normal < 50 mL
            int ipssScore, // 0-35
            boolean bladderOutletObstruction,
            String urologicalPlan,
            Instant evaluatedAt
    ) implements Serializable {}

    public UrodynamicEvaluation evaluateUrodynamics(String id, String patientId, double qmax, double pvr, int ipss) {
        boolean boo = qmax < 10.0 && pvr > 100.0;
        String plan = boo
                ? "Bladder Outlet Obstruction confirmed: Initiate Alpha-1 Blocker (Tamsulosin 0.4mg) + 5-ARI (Finasteride 5mg) or TURP."
                : "Non-obstructed flow pattern; conservative fluid and voiding schedule.";

        return new UrodynamicEvaluation(id, patientId, qmax, pvr, ipss, boo, plan, Instant.now());
    }
}
