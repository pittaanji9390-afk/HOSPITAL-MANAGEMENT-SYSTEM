package com.hospital.burn;

import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Service
public class ParklandResuscitationService {

    public static record ParklandResult(
            String patientId,
            double weightKg,
            double tbsaPercent, // Total Body Surface Area % 2nd/3rd degree burns
            double total24HourFluidsMl, // 4 mL * weight kg * %TBSA
            double first8HoursMl, // 50% of total
            double next16HoursMl, // 50% of total
            double targetUrineOutputMlPerHour, // 0.5 mL/kg/h adult (30-50 mL/h)
            Instant calculatedAt
    ) implements Serializable {}

    public ParklandResult calculateParkland(String patientId, double weightKg, double tbsa) {
        double total = 4.0 * weightKg * tbsa;
        double first8 = total * 0.5;
        double next16 = total * 0.5;
        double targetUrine = weightKg * 0.5;

        return new ParklandResult(patientId, weightKg, tbsa, total, first8, next16, targetUrine, Instant.now());
    }
}
