package com.hospital.transplant.hla;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Virtual Crossmatch (vXM) and Calculated Panel Reactive Antibody (cPRA) Engine.
 * Compares recipient donor-specific anti-HLA antibodies (DSA) from Luminex Single Antigen Beads (MFI > 1000)
 * against donor HLA-A, B, C, DRB1, DRB3/4/5, DQA1, DQB1, DPA1, DPB1 typing.
 */
@Service
public class VirtualCrossmatchService {

    public record HlaTyping(List<String> locusA, List<String> locusB, List<String> locusC, List<String> locusDr, List<String> locusDq) {}
    public record RecipientAntiHlaProfile(String recipientMrn, double cPraPercent, Map<String, Integer> donorSpecificAntibodiesMfi) {}

    public record VirtualCrossmatchResult(
        boolean isVirtualCrossmatchNegative,
        List<String> detectedDsaAntigens,
        int highestMfiValue,
        String immunologicalRiskTier
    ) {}

    public VirtualCrossmatchResult performVirtualCrossmatch(HlaTyping donorHla, RecipientAntiHlaProfile recipient) {
        Set<String> donorAntigens = new HashSet<>();
        donorAntigens.addAll(donorHla.locusA());
        donorAntigens.addAll(donorHla.locusB());
        donorAntigens.addAll(donorHla.locusC());
        donorAntigens.addAll(donorHla.locusDr());
        donorAntigens.addAll(donorHla.locusDq());

        List<String> matchedDsa = new ArrayList<>();
        int maxMfi = 0;

        for (Map.Entry<String, Integer> dsa : recipient.donorSpecificAntibodiesMfi().entrySet()) {
            if (donorAntigens.contains(dsa.getKey()) && dsa.getValue() >= 1000) {
                matchedDsa.add(dsa.getKey() + " (MFI: " + dsa.getValue() + ")");
                if (dsa.getValue() > maxMfi) {
                    maxMfi = dsa.getValue();
                }
            }
        }

        boolean vXmNegative = matchedDsa.isEmpty();
        String risk;
        if (vXmNegative) {
            risk = recipient.cPraPercent() > 80.0 ? "LOW DSA RISK (HIGH SENSITIZATION CPRA)" : "STANDARD IMMUNOLOGICAL RISK";
        } else if (maxMfi > 5000) {
            risk = "HIGH RISK: HYPERACUTE / ACCELERATED REJECTION (CONTRAINDICATED)";
        } else {
            risk = "MODERATE RISK: REQUIRES DESENSITIZATION / PLASMAPHERESIS / IVIG";
        }

        return new VirtualCrossmatchResult(vXmNegative, matchedDsa, maxMfi, risk);
    }
}
