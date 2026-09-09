package com.hospital.oncology.extravasation;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Oncology Nursing Society (ONS) & ESMO Chemotherapy Extravasation Management Engine.
 * Categorizes Vesicants (DNA-binding vs non-DNA-binding), Irritants, and Exfoliants.
 * Directs emergency antidotes: Dexrazoxane (Totect for Anthracyclines), Hyaluronidase (Vinca Alkaloids),
 * Sodium Thiosulfate (Mechlorethamine / Cisplatin), and Cold vs Warm Thermal Packs.
 */
@Service
public class ExtravasationProtocolService {

    public record ExtravasationDirective(String drugName, String vesicantClass, String thermalCompress, String specificAntidote, String administrationInstructions) {}

    private final Map<String, ExtravasationDirective> protocolCatalog = new HashMap<>();

    public ExtravasationProtocolService() {
        seedProtocols();
    }

    private void seedProtocols() {
        protocolCatalog.put("DOXORUBICIN", new ExtravasationDirective("DOXORUBICIN", "DNA-Binding Vesicant", "Dry Cold Pack (15 min QID x 3 days) - DO NOT APPLY HEAT", "Dexrazoxane (Totect) IV", "Day 1: 1000 mg/m2 IV within 6 hrs; Day 2: 1000 mg/m2; Day 3: 500 mg/m2"));
        protocolCatalog.put("VINCRISTINE", new ExtravasationDirective("VINCRISTINE", "Non-DNA-Binding Plant Alkaloid Vesicant", "Dry Warm Heat Pack (15 min QID x 2 days) - DO NOT APPLY COLD", "Hyaluronidase 150 Units/mL", "Inject 1.0 - 1.7 mL subQ clockwise around the extravasation site with 25G needle"));
        protocolCatalog.put("PACLITAXEL", new ExtravasationDirective("PACLITAXEL", "Vesicant / Irritant", "Dry Cold Pack (15 min QID)", "Hyaluronidase (Consider for large volume)", "Aspirate residual drug, elevate extremity"));
        protocolCatalog.put("CISPLATIN", new ExtravasationDirective("CISPLATIN", "DNA-Binding Vesicant (Large volume > 20mL)", "Dry Cold Pack", "1/6 M Sodium Thiosulfate", "Inject 2-4 mL subQ for concentrated extravasations"));
    }

    public ExtravasationDirective getDirective(String drugName) {
        return protocolCatalog.getOrDefault(drugName.toUpperCase(), new ExtravasationDirective(drugName, "Irritant / Non-Vesicant", "Cold Compress", "None (Aspiration & Elevation)", "Standard non-vesicant supportive care"));
    }
}
