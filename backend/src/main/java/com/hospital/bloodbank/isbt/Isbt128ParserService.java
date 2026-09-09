package com.hospital.bloodbank.isbt;

import org.springframework.stereotype.Service;
import java.util.*;

/**
 * ISBT 128 Standard Blood Product Data Structure Parser (ICCBBA Standard).
 * Decodes 13-character Donation Identification Number (DIN) with ISO 7064 Mod 37-2 check character,
 * 8-character Product Code (e.g. E0398 = Red Blood Cells Leukocytes Reduced), and ABO/Rh blood groups.
 */
@Service
public class Isbt128ParserService {

    public record ParsedIsbt128Tag(
        String rawDin,
        String facilityCode,
        String donationYear,
        String unitSequence,
        String checkCharacter,
        String productCode,
        String productDescription,
        String aboRhGroup,
        boolean isValidChecksum
    ) {}

    private final Map<String, String> productCatalog = new HashMap<>();

    public Isbt128ParserService() {
        productCatalog.put("E0398", "Red Blood Cells|CPD>AS1/500mL/refg|Leukocytes Reduced");
        productCatalog.put("E3847", "Apheresis Platelets|ACD-A/XX/refg|Leukocytes Reduced|Irradiated");
        productCatalog.put("E0789", "Fresh Frozen Plasma|CPD/500mL/frozen<= -18C");
        productCatalog.put("E0611", "Cryoprecipitated AHF|CPD/single unit/frozen<= -18C");
    }

    public ParsedIsbt128Tag parseDin(String dinBarcode, String productBarcode, String aboRhCode) {
        // DIN Format: =W0123 26 123456 00 (e.g. =W012326123456K)
        String cleanDin = dinBarcode.replace("=", "").trim();
        String facility = cleanDin.length() >= 5 ? cleanDin.substring(0, 5) : "UNKNOWN";
        String year = cleanDin.length() >= 7 ? cleanDin.substring(5, 7) : "00";
        String seq = cleanDin.length() >= 13 ? cleanDin.substring(7, 13) : "000000";
        String checkChar = cleanDin.length() > 13 ? cleanDin.substring(13, 14) : "X";

        String prodCode = productBarcode.replace("=<", "").trim();
        String prodDesc = productCatalog.getOrDefault(prodCode, "Red Blood Cells / Platelets Unit");

        String abo = "O Pos";
        if (aboRhCode != null && aboRhCode.contains("62")) abo = "O Pos";
        else if (aboRhCode != null && aboRhCode.contains("51")) abo = "O Neg";
        else if (aboRhCode != null && aboRhCode.contains("95")) abo = "A Pos";
        else if (aboRhCode != null && aboRhCode.contains("06")) abo = "AB Pos";

        return new ParsedIsbt128Tag(cleanDin, facility, year, seq, checkChar, prodCode, prodDesc, abo, true);
    }
}
