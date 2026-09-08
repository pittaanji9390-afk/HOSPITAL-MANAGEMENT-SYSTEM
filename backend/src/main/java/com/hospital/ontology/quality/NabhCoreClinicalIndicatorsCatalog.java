package com.hospital.ontology.quality;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NabhCoreClinicalIndicatorsCatalog {

    @Data
    @AllArgsConstructor
    public static class NabhIndicator {
        private String indicatorCode;
        private String indicatorTitle;
        private String benchmarkStandard;
        private String calculationFormula;
        private String monitoringDepartment;
    }

    private final Map<String, NabhIndicator> indicators = new LinkedHashMap<>();

    public NabhCoreClinicalIndicatorsCatalog() {
        indicators.put("NABH-01", new NabhIndicator("NABH-01", "Catheter-Associated Urinary Tract Infection (CAUTI) Rate", "< 2.0 per 1000 catheter days", "(Number of CAUTIs / Urinary catheter days) * 1000", "Infection Control"));
        indicators.put("NABH-02", new NabhIndicator("NABH-02", "Central Line-Associated Bloodstream Infection (CLABSI) Rate", "< 1.5 per 1000 central line days", "(Number of CLABSIs / Central line days) * 1000", "Critical Care / Infection Control"));
        indicators.put("NABH-03", new NabhIndicator("NABH-03", "Ventilator-Associated Pneumonia (VAP) Rate", "< 3.0 per 1000 ventilator days", "(Number of VAPs / Ventilator days) * 1000", "Critical Care / Pulmonology"));
        indicators.put("NABH-04", new NabhIndicator("NABH-04", "Surgical Site Infection (SSI) Rate", "< 1.0% in clean surgical cases", "(Number of SSIs / Total surgical procedures) * 100", "Surgical Services"));
        indicators.put("NABH-05", new NabhIndicator("NABH-05", "Unplanned Return to ICU within 48 Hours", "< 1.5% of total ICU discharges", "(Unplanned readmissions within 48h / Total ICU discharges) * 100", "Critical Care"));
    }

    public Optional<NabhIndicator> getIndicator(String code) { return Optional.ofNullable(indicators.get(code)); }
    public List<NabhIndicator> getAll() { return new ArrayList<>(indicators.values()); }
}
