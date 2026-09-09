package com.hospital.transplant.abo;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * ABO-Incompatible (ABOi) Living Donor Protocol.
 * Tracks Anti-A / Anti-B IgM/IgG isohemagglutinin antibody titers (target <= 1:8 or 1:4 pre-op)
 * through Double Filtration Plasmapheresis (DFPP) and Anti-CD20 (Rituximab) conditioning.
 */
@Service
public class AboIncompatibleDesensitizationService {

    public record IsoagglutininTiter(String antibodyType, int titerDenominator, boolean safeForSurgicalIncision) {}

    public IsoagglutininTiter evaluateAboTiter(String antibody, int denominator) {
        boolean safe = denominator <= 8;
        return new IsoagglutininTiter(antibody, denominator, safe);
    }
}
