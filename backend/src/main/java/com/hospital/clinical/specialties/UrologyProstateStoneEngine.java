package com.hospital.clinical.specialties;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Enterprise Clinical Decision Engine for Urology, Nephrolithiasis, BPH & Urological Malignancies.
 * Production-grade medical protocols, diagnostic criteria, and evidence-based therapeutic regimens.
 */
@Component
public class UrologyProstateStoneEngine {

    @Data
    @Builder
    public static class ClinicalProtocol {
        private String protocolName;
        private String pharmacotherapyAndInterventions;
        private String adverseReactionsAndToxicity;
        private String dosageAdjustmentAndSafetyRules;
    }

    private static final List<ClinicalProtocol> PROTOCOLS = new ArrayList<>();

    static {
        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Acute Obstructive Ureteral Calculus with Sepsis")
                .pharmacotherapyAndInterventions("EMERGENT DECOMPRESSION: Retrograde Ureteral Double-J (DJ) Stenting or Percutaneous Nephrostomy (PCN) + IV Ceftriaxone 2g / Meropenem 1g")
                .adverseReactionsAndToxicity("Urosepsis, septic shock, pyonephrosis, irreversible renal parenchymal loss")
                .dosageAdjustmentAndSafetyRules("DO NOT PERFORM URETEROSCOPY / LITHOTRIPSY IN THE SETTING OF INFECTION; decompress first, treat stone second")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Medical Expulsive Therapy for Ureteral Stones (5-10 mm)")
                .pharmacotherapyAndInterventions("Tamsulosin 0.4mg daily (Alpha-1A selective antagonist) + Ketorolac 10mg PO tid (NSAID) + Oral hydration")
                .adverseReactionsAndToxicity("Orthostatic hypotension, retrograde ejaculation, floppy iris syndrome during cataract surgery")
                .dosageAdjustmentAndSafetyRules("Limit trial to 4-6 weeks; prompt surgical intervention (Ureteroscopy with Holmium laser) if pain unmanageable or renal function declines")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Benign Prostatic Hyperplasia with Urinary Retention (IPSS > 20)")
                .pharmacotherapyAndInterventions("Dual Therapy: Tamsulosin 0.4mg daily + Finasteride 5mg daily (5-Alpha Reductase Inhibitor: reduces prostate volume by 25% over 6-12 months)")
                .adverseReactionsAndToxicity("Decreased libido, erectile dysfunction, orthostasis; Finasteride artificially reduces serum PSA by 50% (double measured PSA for cancer screening)")
                .dosageAdjustmentAndSafetyRules("Transurethral Resection of the Prostate (TURP) or Holmium Laser Enucleation (HoLEP) for refractory urinary retention")
                .build());

        PROTOCOLS.add(ClinicalProtocol.builder()
                .protocolName("Non-Muscle Invasive Bladder Cancer (NMIBC High-Risk)")
                .pharmacotherapyAndInterventions("Intravesical Bacillus Calmette-Guerin (BCG) immunotherapy: 6-week induction followed by 3-year maintenance (3 weekly instillations at 3, 6, 12, 18, 24, 30, 36 months)")
                .adverseReactionsAndToxicity("BCG cystitis, systemic BCGosis / mycobacterial sepsis, granulomatous prostatitis")
                .dosageAdjustmentAndSafetyRules("Hold BCG if gross hematuria or fever; treat systemic BCGosis with Isoniazid 300mg + Rifampin 600mg + Ethambutol 1200mg + Prednisone")
                .build());

    }

    public List<ClinicalProtocol> getAllProtocols() {
        return Collections.unmodifiableList(PROTOCOLS);
    }

    public Optional<ClinicalProtocol> findByName(String name) {
        if (name == null) return Optional.empty();
        return PROTOCOLS.stream()
                .filter(p -> p.getProtocolName().toLowerCase().contains(name.toLowerCase().trim()))
                .findFirst();
    }

    public List<ClinicalProtocol> search(String query) {
        if (query == null || query.isBlank()) return PROTOCOLS;
        String q = query.toLowerCase().trim();
        return PROTOCOLS.stream()
                .filter(p -> p.getProtocolName().toLowerCase().contains(q) ||
                             p.getPharmacotherapyAndInterventions().toLowerCase().contains(q) ||
                             p.getAdverseReactionsAndToxicity().toLowerCase().contains(q) ||
                             p.getDosageAdjustmentAndSafetyRules().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
