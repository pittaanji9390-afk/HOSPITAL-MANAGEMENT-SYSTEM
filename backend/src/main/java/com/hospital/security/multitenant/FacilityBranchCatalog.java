package com.hospital.security.multitenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class FacilityBranchCatalog {

    @Data
    @AllArgsConstructor
    public static class FacilityBranch {
        private String facilityId;
        private String facilityName;
        private String tenantId;
        private String facilityType; // Acute Care, Ambulatory, Rehab, Dialysis
        private int totalLicensedBeds;
        private int icuBedCapacity;
        private String traumaCenterLevel; // Level 1, Level 2, None
        private String cliaLicenseNumber;
    }

    private final Map<String, FacilityBranch> facilities = new LinkedHashMap<>();

    public FacilityBranchCatalog() {
        facilities.put("FAC-MAIN", new FacilityBranch("FAC-MAIN", "Metro General Academic Hospital", "TEN-METRO-01", "Tertiary Acute Care Hospital", 650, 96, "Level 1 Trauma Center", "CLIA-99D0882104"));
        facilities.put("FAC-NORTH", new FacilityBranch("FAC-NORTH", "Metro North Community Medical Center", "TEN-METRO-01", "Community Hospital", 220, 24, "Level 3 Trauma Center", "CLIA-99D0554120"));
        facilities.put("FAC-SURG", new FacilityBranch("FAC-SURG", "Metro West Ambulatory Surgery Pavilion", "TEN-METRO-01", "Ambulatory Surgical Center", 0, 0, "None", "CLIA-99D0339912"));
        facilities.put("FAC-REHAB", new FacilityBranch("FAC-REHAB", "Metro Children & Adults Rehabilitation Center", "TEN-METRO-01", "Inpatient Rehabilitation Facility", 80, 0, "None", "CLIA-99D0221199"));
    }

    public Optional<FacilityBranch> getFacility(String id) { return Optional.ofNullable(facilities.get(id)); }
    public List<FacilityBranch> getAllFacilities() { return new ArrayList<>(facilities.values()); }
}
