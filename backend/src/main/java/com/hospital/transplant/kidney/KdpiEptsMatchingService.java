package com.hospital.transplant.kidney;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * UNOS Kidney Allocation System (KAS): Matches high-longevity kidneys (KDPI <= 20%)
 * with candidates with the highest expected post-transplant longevity (EPTS <= 20%).
 */
@Service
public class KdpiEptsMatchingService {

    public record DonorProfile(int ageYears, double serumCreatinine, boolean hasHypertension, boolean hasDiabetes, boolean isCvaCauseOfDeath, boolean isHcvPositive, double weightKg, double heightCm) {}
    public record CandidateProfile(int ageYears, boolean hasDiabetes, boolean previousOrganTransplant, int monthsOnDialysis) {}

    public record KasMatchingResult(
        double kdpiPercentile,
        double eptsPercentile,
        boolean top20PercentLongevityMatch,
        String allocationSequenceTier
    ) {}

    public KasMatchingResult evaluateMatch(DonorProfile donor, CandidateProfile candidate) {
        // Approximate KDPI calculation based on donor risk factors
        double kdra = 0.0;
        kdra += (donor.ageYears() - 40) * 0.0128;
        kdra += (donor.serumCreatinine() - 1.0) * 0.22;
        if (donor.hasHypertension()) kdra += 0.126;
        if (donor.hasDiabetes()) kdra += 0.13;
        if (donor.isHcvPositive()) kdra += 0.24;

        double kdpi = Math.min(100.0, Math.max(1.0, 50.0 + (kdra * 40.0)));

        // Approximate EPTS calculation
        double eptsRaw = 0.0;
        eptsRaw += (candidate.ageYears() - 45) * 0.035;
        if (candidate.hasDiabetes()) eptsRaw += 0.45;
        if (candidate.previousOrganTransplant()) eptsRaw += 0.30;
        eptsRaw += (candidate.monthsOnDialysis() / 12.0) * 0.05;

        double epts = Math.min(100.0, Math.max(1.0, 50.0 + (eptsRaw * 30.0)));

        boolean isTop20 = (kdpi <= 20.0 && epts <= 20.0);
        String tier = isTop20 ? "UNOS TIER A: TOP 20% LONGEVITY ALLOCATION" : (kdpi > 85.0 ? "DUAL-KIDNEY / HIGH-KDPI CONSENT TIER" : "STANDARD CAS ALLOCATION TIER");

        return new KasMatchingResult(kdpi, epts, isTop20, tier);
    }
}
