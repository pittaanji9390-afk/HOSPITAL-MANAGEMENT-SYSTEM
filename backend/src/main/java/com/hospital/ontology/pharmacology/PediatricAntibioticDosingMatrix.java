package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PediatricAntibioticDosingMatrix {

    @Data
    @AllArgsConstructor
    public static class PediatricDoseEntry {
        private String doseCode;
        private String drugName;
        private double weightBasedDoseMgPerKg;
        private String dosingUnit;
        private double absoluteMaxDailyDoseMg;
        private String maxUnit;
        private String dosingInterval;
        private String safetyPrecaution;
    }

    private final Map<String, PediatricDoseEntry> dosingTable = new LinkedHashMap<>();

    public PediatricAntibioticDosingMatrix() {
        initializeDosing();
    }

    private void initializeDosing() {
        dosingTable.put("PED-DOSE-PEDI-001", new PediatricDoseEntry("PED-DOSE-PEDI-001", "PediatricAntibioticDosing Drug Entity #1", 7.5, "mg/kg/day", 150, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-002", new PediatricDoseEntry("PED-DOSE-PEDI-002", "PediatricAntibioticDosing Drug Entity #2", 10.0, "mg/kg/day", 200, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-003", new PediatricDoseEntry("PED-DOSE-PEDI-003", "PediatricAntibioticDosing Drug Entity #3", 12.5, "mg/kg/day", 250, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-004", new PediatricDoseEntry("PED-DOSE-PEDI-004", "PediatricAntibioticDosing Drug Entity #4", 15.0, "mg/kg/day", 300, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-005", new PediatricDoseEntry("PED-DOSE-PEDI-005", "PediatricAntibioticDosing Drug Entity #5", 17.5, "mg/kg/day", 350, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-006", new PediatricDoseEntry("PED-DOSE-PEDI-006", "PediatricAntibioticDosing Drug Entity #6", 20.0, "mg/kg/day", 400, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-007", new PediatricDoseEntry("PED-DOSE-PEDI-007", "PediatricAntibioticDosing Drug Entity #7", 22.5, "mg/kg/day", 450, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-008", new PediatricDoseEntry("PED-DOSE-PEDI-008", "PediatricAntibioticDosing Drug Entity #8", 25.0, "mg/kg/day", 500, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-009", new PediatricDoseEntry("PED-DOSE-PEDI-009", "PediatricAntibioticDosing Drug Entity #9", 27.5, "mg/kg/day", 550, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-010", new PediatricDoseEntry("PED-DOSE-PEDI-010", "PediatricAntibioticDosing Drug Entity #10", 30.0, "mg/kg/day", 600, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-011", new PediatricDoseEntry("PED-DOSE-PEDI-011", "PediatricAntibioticDosing Drug Entity #11", 32.5, "mg/kg/day", 650, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-012", new PediatricDoseEntry("PED-DOSE-PEDI-012", "PediatricAntibioticDosing Drug Entity #12", 35.0, "mg/kg/day", 700, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-013", new PediatricDoseEntry("PED-DOSE-PEDI-013", "PediatricAntibioticDosing Drug Entity #13", 37.5, "mg/kg/day", 750, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-014", new PediatricDoseEntry("PED-DOSE-PEDI-014", "PediatricAntibioticDosing Drug Entity #14", 40.0, "mg/kg/day", 800, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-015", new PediatricDoseEntry("PED-DOSE-PEDI-015", "PediatricAntibioticDosing Drug Entity #15", 42.5, "mg/kg/day", 850, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-016", new PediatricDoseEntry("PED-DOSE-PEDI-016", "PediatricAntibioticDosing Drug Entity #16", 45.0, "mg/kg/day", 900, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-017", new PediatricDoseEntry("PED-DOSE-PEDI-017", "PediatricAntibioticDosing Drug Entity #17", 47.5, "mg/kg/day", 950, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-018", new PediatricDoseEntry("PED-DOSE-PEDI-018", "PediatricAntibioticDosing Drug Entity #18", 50.0, "mg/kg/day", 1000, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-019", new PediatricDoseEntry("PED-DOSE-PEDI-019", "PediatricAntibioticDosing Drug Entity #19", 52.5, "mg/kg/day", 1050, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-020", new PediatricDoseEntry("PED-DOSE-PEDI-020", "PediatricAntibioticDosing Drug Entity #20", 55.0, "mg/kg/day", 1100, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-021", new PediatricDoseEntry("PED-DOSE-PEDI-021", "PediatricAntibioticDosing Drug Entity #21", 57.5, "mg/kg/day", 1150, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-022", new PediatricDoseEntry("PED-DOSE-PEDI-022", "PediatricAntibioticDosing Drug Entity #22", 60.0, "mg/kg/day", 1200, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-023", new PediatricDoseEntry("PED-DOSE-PEDI-023", "PediatricAntibioticDosing Drug Entity #23", 62.5, "mg/kg/day", 1250, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-024", new PediatricDoseEntry("PED-DOSE-PEDI-024", "PediatricAntibioticDosing Drug Entity #24", 65.0, "mg/kg/day", 1300, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-025", new PediatricDoseEntry("PED-DOSE-PEDI-025", "PediatricAntibioticDosing Drug Entity #25", 67.5, "mg/kg/day", 1350, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-026", new PediatricDoseEntry("PED-DOSE-PEDI-026", "PediatricAntibioticDosing Drug Entity #26", 70.0, "mg/kg/day", 1400, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-027", new PediatricDoseEntry("PED-DOSE-PEDI-027", "PediatricAntibioticDosing Drug Entity #27", 72.5, "mg/kg/day", 1450, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-028", new PediatricDoseEntry("PED-DOSE-PEDI-028", "PediatricAntibioticDosing Drug Entity #28", 75.0, "mg/kg/day", 1500, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-029", new PediatricDoseEntry("PED-DOSE-PEDI-029", "PediatricAntibioticDosing Drug Entity #29", 77.5, "mg/kg/day", 1550, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-030", new PediatricDoseEntry("PED-DOSE-PEDI-030", "PediatricAntibioticDosing Drug Entity #30", 80.0, "mg/kg/day", 1600, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-031", new PediatricDoseEntry("PED-DOSE-PEDI-031", "PediatricAntibioticDosing Drug Entity #31", 82.5, "mg/kg/day", 1650, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-032", new PediatricDoseEntry("PED-DOSE-PEDI-032", "PediatricAntibioticDosing Drug Entity #32", 85.0, "mg/kg/day", 1700, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-033", new PediatricDoseEntry("PED-DOSE-PEDI-033", "PediatricAntibioticDosing Drug Entity #33", 87.5, "mg/kg/day", 1750, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-034", new PediatricDoseEntry("PED-DOSE-PEDI-034", "PediatricAntibioticDosing Drug Entity #34", 90.0, "mg/kg/day", 1800, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-035", new PediatricDoseEntry("PED-DOSE-PEDI-035", "PediatricAntibioticDosing Drug Entity #35", 92.5, "mg/kg/day", 1850, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-036", new PediatricDoseEntry("PED-DOSE-PEDI-036", "PediatricAntibioticDosing Drug Entity #36", 95.0, "mg/kg/day", 1900, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-037", new PediatricDoseEntry("PED-DOSE-PEDI-037", "PediatricAntibioticDosing Drug Entity #37", 97.5, "mg/kg/day", 1950, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-038", new PediatricDoseEntry("PED-DOSE-PEDI-038", "PediatricAntibioticDosing Drug Entity #38", 100.0, "mg/kg/day", 2000, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-039", new PediatricDoseEntry("PED-DOSE-PEDI-039", "PediatricAntibioticDosing Drug Entity #39", 102.5, "mg/kg/day", 2050, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-040", new PediatricDoseEntry("PED-DOSE-PEDI-040", "PediatricAntibioticDosing Drug Entity #40", 105.0, "mg/kg/day", 2100, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-041", new PediatricDoseEntry("PED-DOSE-PEDI-041", "PediatricAntibioticDosing Drug Entity #41", 107.5, "mg/kg/day", 2150, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-042", new PediatricDoseEntry("PED-DOSE-PEDI-042", "PediatricAntibioticDosing Drug Entity #42", 110.0, "mg/kg/day", 2200, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-043", new PediatricDoseEntry("PED-DOSE-PEDI-043", "PediatricAntibioticDosing Drug Entity #43", 112.5, "mg/kg/day", 2250, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-044", new PediatricDoseEntry("PED-DOSE-PEDI-044", "PediatricAntibioticDosing Drug Entity #44", 115.0, "mg/kg/day", 2300, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-045", new PediatricDoseEntry("PED-DOSE-PEDI-045", "PediatricAntibioticDosing Drug Entity #45", 117.5, "mg/kg/day", 2350, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-046", new PediatricDoseEntry("PED-DOSE-PEDI-046", "PediatricAntibioticDosing Drug Entity #46", 120.0, "mg/kg/day", 2400, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-047", new PediatricDoseEntry("PED-DOSE-PEDI-047", "PediatricAntibioticDosing Drug Entity #47", 122.5, "mg/kg/day", 2450, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-048", new PediatricDoseEntry("PED-DOSE-PEDI-048", "PediatricAntibioticDosing Drug Entity #48", 125.0, "mg/kg/day", 2500, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-049", new PediatricDoseEntry("PED-DOSE-PEDI-049", "PediatricAntibioticDosing Drug Entity #49", 127.5, "mg/kg/day", 2550, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-050", new PediatricDoseEntry("PED-DOSE-PEDI-050", "PediatricAntibioticDosing Drug Entity #50", 130.0, "mg/kg/day", 2600, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-051", new PediatricDoseEntry("PED-DOSE-PEDI-051", "PediatricAntibioticDosing Drug Entity #51", 132.5, "mg/kg/day", 2650, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-052", new PediatricDoseEntry("PED-DOSE-PEDI-052", "PediatricAntibioticDosing Drug Entity #52", 135.0, "mg/kg/day", 2700, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-053", new PediatricDoseEntry("PED-DOSE-PEDI-053", "PediatricAntibioticDosing Drug Entity #53", 137.5, "mg/kg/day", 2750, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-054", new PediatricDoseEntry("PED-DOSE-PEDI-054", "PediatricAntibioticDosing Drug Entity #54", 140.0, "mg/kg/day", 2800, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-055", new PediatricDoseEntry("PED-DOSE-PEDI-055", "PediatricAntibioticDosing Drug Entity #55", 142.5, "mg/kg/day", 2850, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-056", new PediatricDoseEntry("PED-DOSE-PEDI-056", "PediatricAntibioticDosing Drug Entity #56", 145.0, "mg/kg/day", 2900, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-057", new PediatricDoseEntry("PED-DOSE-PEDI-057", "PediatricAntibioticDosing Drug Entity #57", 147.5, "mg/kg/day", 2950, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-058", new PediatricDoseEntry("PED-DOSE-PEDI-058", "PediatricAntibioticDosing Drug Entity #58", 150.0, "mg/kg/day", 3000, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-059", new PediatricDoseEntry("PED-DOSE-PEDI-059", "PediatricAntibioticDosing Drug Entity #59", 152.5, "mg/kg/day", 3050, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-060", new PediatricDoseEntry("PED-DOSE-PEDI-060", "PediatricAntibioticDosing Drug Entity #60", 155.0, "mg/kg/day", 3100, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-061", new PediatricDoseEntry("PED-DOSE-PEDI-061", "PediatricAntibioticDosing Drug Entity #61", 157.5, "mg/kg/day", 3150, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-062", new PediatricDoseEntry("PED-DOSE-PEDI-062", "PediatricAntibioticDosing Drug Entity #62", 160.0, "mg/kg/day", 3200, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-063", new PediatricDoseEntry("PED-DOSE-PEDI-063", "PediatricAntibioticDosing Drug Entity #63", 162.5, "mg/kg/day", 3250, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-064", new PediatricDoseEntry("PED-DOSE-PEDI-064", "PediatricAntibioticDosing Drug Entity #64", 165.0, "mg/kg/day", 3300, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-065", new PediatricDoseEntry("PED-DOSE-PEDI-065", "PediatricAntibioticDosing Drug Entity #65", 167.5, "mg/kg/day", 3350, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-066", new PediatricDoseEntry("PED-DOSE-PEDI-066", "PediatricAntibioticDosing Drug Entity #66", 170.0, "mg/kg/day", 3400, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-067", new PediatricDoseEntry("PED-DOSE-PEDI-067", "PediatricAntibioticDosing Drug Entity #67", 172.5, "mg/kg/day", 3450, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-068", new PediatricDoseEntry("PED-DOSE-PEDI-068", "PediatricAntibioticDosing Drug Entity #68", 175.0, "mg/kg/day", 3500, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-069", new PediatricDoseEntry("PED-DOSE-PEDI-069", "PediatricAntibioticDosing Drug Entity #69", 177.5, "mg/kg/day", 3550, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-070", new PediatricDoseEntry("PED-DOSE-PEDI-070", "PediatricAntibioticDosing Drug Entity #70", 180.0, "mg/kg/day", 3600, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-071", new PediatricDoseEntry("PED-DOSE-PEDI-071", "PediatricAntibioticDosing Drug Entity #71", 182.5, "mg/kg/day", 3650, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-072", new PediatricDoseEntry("PED-DOSE-PEDI-072", "PediatricAntibioticDosing Drug Entity #72", 185.0, "mg/kg/day", 3700, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-073", new PediatricDoseEntry("PED-DOSE-PEDI-073", "PediatricAntibioticDosing Drug Entity #73", 187.5, "mg/kg/day", 3750, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-074", new PediatricDoseEntry("PED-DOSE-PEDI-074", "PediatricAntibioticDosing Drug Entity #74", 190.0, "mg/kg/day", 3800, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-075", new PediatricDoseEntry("PED-DOSE-PEDI-075", "PediatricAntibioticDosing Drug Entity #75", 192.5, "mg/kg/day", 3850, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-076", new PediatricDoseEntry("PED-DOSE-PEDI-076", "PediatricAntibioticDosing Drug Entity #76", 195.0, "mg/kg/day", 3900, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-077", new PediatricDoseEntry("PED-DOSE-PEDI-077", "PediatricAntibioticDosing Drug Entity #77", 197.5, "mg/kg/day", 3950, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-078", new PediatricDoseEntry("PED-DOSE-PEDI-078", "PediatricAntibioticDosing Drug Entity #78", 200.0, "mg/kg/day", 4000, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-079", new PediatricDoseEntry("PED-DOSE-PEDI-079", "PediatricAntibioticDosing Drug Entity #79", 202.5, "mg/kg/day", 4050, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-080", new PediatricDoseEntry("PED-DOSE-PEDI-080", "PediatricAntibioticDosing Drug Entity #80", 205.0, "mg/kg/day", 4100, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-081", new PediatricDoseEntry("PED-DOSE-PEDI-081", "PediatricAntibioticDosing Drug Entity #81", 207.5, "mg/kg/day", 4150, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-082", new PediatricDoseEntry("PED-DOSE-PEDI-082", "PediatricAntibioticDosing Drug Entity #82", 210.0, "mg/kg/day", 4200, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-083", new PediatricDoseEntry("PED-DOSE-PEDI-083", "PediatricAntibioticDosing Drug Entity #83", 212.5, "mg/kg/day", 4250, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-084", new PediatricDoseEntry("PED-DOSE-PEDI-084", "PediatricAntibioticDosing Drug Entity #84", 215.0, "mg/kg/day", 4300, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-085", new PediatricDoseEntry("PED-DOSE-PEDI-085", "PediatricAntibioticDosing Drug Entity #85", 217.5, "mg/kg/day", 4350, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-086", new PediatricDoseEntry("PED-DOSE-PEDI-086", "PediatricAntibioticDosing Drug Entity #86", 220.0, "mg/kg/day", 4400, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-087", new PediatricDoseEntry("PED-DOSE-PEDI-087", "PediatricAntibioticDosing Drug Entity #87", 222.5, "mg/kg/day", 4450, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-088", new PediatricDoseEntry("PED-DOSE-PEDI-088", "PediatricAntibioticDosing Drug Entity #88", 225.0, "mg/kg/day", 4500, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-089", new PediatricDoseEntry("PED-DOSE-PEDI-089", "PediatricAntibioticDosing Drug Entity #89", 227.5, "mg/kg/day", 4550, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-090", new PediatricDoseEntry("PED-DOSE-PEDI-090", "PediatricAntibioticDosing Drug Entity #90", 230.0, "mg/kg/day", 4600, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-091", new PediatricDoseEntry("PED-DOSE-PEDI-091", "PediatricAntibioticDosing Drug Entity #91", 232.5, "mg/kg/day", 4650, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-092", new PediatricDoseEntry("PED-DOSE-PEDI-092", "PediatricAntibioticDosing Drug Entity #92", 235.0, "mg/kg/day", 4700, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-093", new PediatricDoseEntry("PED-DOSE-PEDI-093", "PediatricAntibioticDosing Drug Entity #93", 237.5, "mg/kg/day", 4750, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-094", new PediatricDoseEntry("PED-DOSE-PEDI-094", "PediatricAntibioticDosing Drug Entity #94", 240.0, "mg/kg/day", 4800, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-095", new PediatricDoseEntry("PED-DOSE-PEDI-095", "PediatricAntibioticDosing Drug Entity #95", 242.5, "mg/kg/day", 4850, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-096", new PediatricDoseEntry("PED-DOSE-PEDI-096", "PediatricAntibioticDosing Drug Entity #96", 245.0, "mg/kg/day", 4900, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-097", new PediatricDoseEntry("PED-DOSE-PEDI-097", "PediatricAntibioticDosing Drug Entity #97", 247.5, "mg/kg/day", 4950, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-098", new PediatricDoseEntry("PED-DOSE-PEDI-098", "PediatricAntibioticDosing Drug Entity #98", 250.0, "mg/kg/day", 5000, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-099", new PediatricDoseEntry("PED-DOSE-PEDI-099", "PediatricAntibioticDosing Drug Entity #99", 252.5, "mg/kg/day", 5050, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-100", new PediatricDoseEntry("PED-DOSE-PEDI-100", "PediatricAntibioticDosing Drug Entity #100", 255.0, "mg/kg/day", 5100, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-101", new PediatricDoseEntry("PED-DOSE-PEDI-101", "PediatricAntibioticDosing Drug Entity #101", 257.5, "mg/kg/day", 5150, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-102", new PediatricDoseEntry("PED-DOSE-PEDI-102", "PediatricAntibioticDosing Drug Entity #102", 260.0, "mg/kg/day", 5200, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-103", new PediatricDoseEntry("PED-DOSE-PEDI-103", "PediatricAntibioticDosing Drug Entity #103", 262.5, "mg/kg/day", 5250, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-104", new PediatricDoseEntry("PED-DOSE-PEDI-104", "PediatricAntibioticDosing Drug Entity #104", 265.0, "mg/kg/day", 5300, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-105", new PediatricDoseEntry("PED-DOSE-PEDI-105", "PediatricAntibioticDosing Drug Entity #105", 267.5, "mg/kg/day", 5350, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-106", new PediatricDoseEntry("PED-DOSE-PEDI-106", "PediatricAntibioticDosing Drug Entity #106", 270.0, "mg/kg/day", 5400, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-107", new PediatricDoseEntry("PED-DOSE-PEDI-107", "PediatricAntibioticDosing Drug Entity #107", 272.5, "mg/kg/day", 5450, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-108", new PediatricDoseEntry("PED-DOSE-PEDI-108", "PediatricAntibioticDosing Drug Entity #108", 275.0, "mg/kg/day", 5500, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-109", new PediatricDoseEntry("PED-DOSE-PEDI-109", "PediatricAntibioticDosing Drug Entity #109", 277.5, "mg/kg/day", 5550, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-110", new PediatricDoseEntry("PED-DOSE-PEDI-110", "PediatricAntibioticDosing Drug Entity #110", 280.0, "mg/kg/day", 5600, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-111", new PediatricDoseEntry("PED-DOSE-PEDI-111", "PediatricAntibioticDosing Drug Entity #111", 282.5, "mg/kg/day", 5650, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-112", new PediatricDoseEntry("PED-DOSE-PEDI-112", "PediatricAntibioticDosing Drug Entity #112", 285.0, "mg/kg/day", 5700, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-113", new PediatricDoseEntry("PED-DOSE-PEDI-113", "PediatricAntibioticDosing Drug Entity #113", 287.5, "mg/kg/day", 5750, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-114", new PediatricDoseEntry("PED-DOSE-PEDI-114", "PediatricAntibioticDosing Drug Entity #114", 290.0, "mg/kg/day", 5800, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-115", new PediatricDoseEntry("PED-DOSE-PEDI-115", "PediatricAntibioticDosing Drug Entity #115", 292.5, "mg/kg/day", 5850, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-116", new PediatricDoseEntry("PED-DOSE-PEDI-116", "PediatricAntibioticDosing Drug Entity #116", 295.0, "mg/kg/day", 5900, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-117", new PediatricDoseEntry("PED-DOSE-PEDI-117", "PediatricAntibioticDosing Drug Entity #117", 297.5, "mg/kg/day", 5950, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-118", new PediatricDoseEntry("PED-DOSE-PEDI-118", "PediatricAntibioticDosing Drug Entity #118", 300.0, "mg/kg/day", 6000, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-119", new PediatricDoseEntry("PED-DOSE-PEDI-119", "PediatricAntibioticDosing Drug Entity #119", 302.5, "mg/kg/day", 6050, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
        dosingTable.put("PED-DOSE-PEDI-120", new PediatricDoseEntry("PED-DOSE-PEDI-120", "PediatricAntibioticDosing Drug Entity #120", 305.0, "mg/kg/day", 6100, "mg/day", "Q8H / Q12H divided doses", "Do not exceed standard adult single dose."));
    }

    public Optional<PediatricDoseEntry> findByCode(String code) {
        return Optional.ofNullable(dosingTable.get(code));
    }

    public List<PediatricDoseEntry> getAllEntries() {
        return new ArrayList<>(dosingTable.values());
    }
}
