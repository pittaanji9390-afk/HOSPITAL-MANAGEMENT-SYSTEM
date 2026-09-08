package com.hospital.genetics.pgx;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class HlaB1502CarbamazepineStevensJohnsonEngine {

    @Data
    @AllArgsConstructor
    public static class HlaB1502Result {
        private String patientId;
        private boolean isHlaB1502Positive;
        private String carbamazepineSafety;
    }

    public HlaB1502Result checkHlaB1502(String patientId, boolean positive) {
        String safety = positive ? "CONTRAINDICATED: Extreme risk of Stevens-Johnson Syndrome / Toxic Epidermal Necrolysis (SJS/TEN). Use Levetiracetam or Valproate." : "HLA-B*15:02 Negative: Carbamazepine / Oxcarbazepine safe.";
        return new HlaB1502Result(patientId, positive, safety);
    }
}
