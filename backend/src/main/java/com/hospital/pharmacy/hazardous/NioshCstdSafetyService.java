package com.hospital.pharmacy.hazardous;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * NIOSH (National Institute for Occupational Safety and Health) Hazardous Drug Handling Service.
 * Evaluates Table 1 (Antineoplastics), Table 2 (Non-antineoplastic hazardous), and Table 3 (Reproductive risks).
 * Mandates CSTD (e.g., PhaSeal, Equashield, OnGuard) containment and dual chemo-rated PPE protocols.
 */
@Service
public class NioshCstdSafetyService {

    public enum NioshTable { TABLE_1_ANTINEOPLASTIC, TABLE_2_NON_ANTINEOPLASTIC_HAZARDOUS, TABLE_3_REPRODUCTIVE_RISK, NON_HAZARDOUS }
    public record NioshDrugProfile(String genericName, NioshTable category, boolean cstdMandatedForCompounding, boolean cstdMandatedForAdministration, String requiredPpeProtocol) {}

    private final Map<String, NioshDrugProfile> registry = new HashMap<>();

    public NioshCstdSafetyService() {
        seedNioshTables();
    }

    private void seedNioshTables() {
        registry.put("DOXORUBICIN", new NioshDrugProfile("DOXORUBICIN", NioshTable.TABLE_1_ANTINEOPLASTIC, true, true, "Double ASTM D6978 Chemo Gloves, Gown, N95 Respirator in Class II Type B2 BSC"));
        registry.put("CYCLOPHOSPHAMIDE", new NioshDrugProfile("CYCLOPHOSPHAMIDE", NioshTable.TABLE_1_ANTINEOPLASTIC, true, true, "Double Chemo Gloves, Impermeable Gown, Face Shield, CSTD Syringe Lock"));
        registry.put("METHOTREXATE", new NioshDrugProfile("METHOTREXATE", NioshTable.TABLE_1_ANTINEOPLASTIC, true, true, "Double Chemo Gloves, Closed-System Transfer Adapter"));
        registry.put("GANCICLOVIR", new NioshDrugProfile("GANCICLOVIR", NioshTable.TABLE_2_NON_ANTINEOPLASTIC_HAZARDOUS, true, false, "Single Chemo Gloves, Dedicated BSC Hood"));
        registry.put("FINASTERIDE", new NioshDrugProfile("FINASTERIDE", NioshTable.TABLE_3_REPRODUCTIVE_RISK, false, false, "Single Gloves, Do Not Crush/Split for Pregnant Personnel"));
    }

    public NioshDrugProfile checkHandlingRequirements(String drugName) {
        return registry.getOrDefault(drugName.toUpperCase(), new NioshDrugProfile(drugName, NioshTable.NON_HAZARDOUS, false, false, "Standard Universal Precautions"));
    }
}
