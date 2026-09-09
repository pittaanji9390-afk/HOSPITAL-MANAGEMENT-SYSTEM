package com.hospital.oncology.cinv;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * NCCN / ASCO Chemotherapy-Induced Nausea and Vomiting (CINV) Antiemetic Protocol Selector.
 * High Emetogenic Chemotherapy (HEC: Cisplatin, AC regimen) -> 4-Drug Regimen:
 * NK1 RA (Aprepitant/Fosaprepitant) + 5-HT3 RA (Ondansetron/Palonosetron) + Dexamethasone + Olanzapine.
 */
@Service
public class CinvAntiemeticService {

    public enum EmeticRiskCategory { HIGH_HEC_GT_90PCT, MODERATE_MEC_30_90PCT, LOW_10_30PCT, MINIMAL_LT_10PCT }
    public record AntiemeticProtocol(EmeticRiskCategory category, String acutePreventionRegimen, String delayedPreventionRegimen) {}

    public AntiemeticProtocol getRegimen(EmeticRiskCategory risk) {
        if (risk == EmeticRiskCategory.HIGH_HEC_GT_90PCT) {
            return new AntiemeticProtocol(
                risk,
                "Day 1: Fosaprepitant 150mg IV + Palonosetron 0.25mg IV + Dexamethasone 12mg PO/IV + Olanzapine 10mg PO",
                "Days 2-4: Dexamethasone 8mg PO daily + Olanzapine 10mg PO QHS"
            );
        } else if (risk == EmeticRiskCategory.MODERATE_MEC_30_90PCT) {
            return new AntiemeticProtocol(
                risk,
                "Day 1: Ondansetron 16mg PO/IV + Dexamethasone 8mg PO/IV (+/- NK1 RA if prior CINV)",
                "Days 2-3: Dexamethasone 8mg PO daily or Ondansetron 8mg PO BID"
            );
        } else {
            return new AntiemeticProtocol(risk, "Day 1: Ondansetron 8mg PO or Dexamethasone 8mg PO as needed", "PRN breakthrough Prochlorperazine 10mg PO");
        }
    }
}
