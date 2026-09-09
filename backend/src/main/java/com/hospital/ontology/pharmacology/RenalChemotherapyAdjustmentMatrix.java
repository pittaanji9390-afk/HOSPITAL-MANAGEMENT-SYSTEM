package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RenalChemotherapyAdjustmentMatrix {

    @Data
    @AllArgsConstructor
    public static class RenalAdjustmentRule {
        private String ruleCode;
        private String medicationName;
        private String normalCrClDose;
        private String moderateImpairmentDose;
        private String severeImpairmentDose;
        private String esrdDialysisDose;
        private boolean isDialyzable;
    }

    private final Map<String, RenalAdjustmentRule> adjustments = new LinkedHashMap<>();

    public RenalChemotherapyAdjustmentMatrix() {
        initializeRules();
    }

    private void initializeRules() {
        adjustments.put("RENAL-ADJ-RENA-001", new RenalAdjustmentRule("RENAL-ADJ-RENA-001", "RenalChemotherapyAdjustment Medication #1", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-002", new RenalAdjustmentRule("RENAL-ADJ-RENA-002", "RenalChemotherapyAdjustment Medication #2", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-003", new RenalAdjustmentRule("RENAL-ADJ-RENA-003", "RenalChemotherapyAdjustment Medication #3", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-004", new RenalAdjustmentRule("RENAL-ADJ-RENA-004", "RenalChemotherapyAdjustment Medication #4", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-005", new RenalAdjustmentRule("RENAL-ADJ-RENA-005", "RenalChemotherapyAdjustment Medication #5", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-006", new RenalAdjustmentRule("RENAL-ADJ-RENA-006", "RenalChemotherapyAdjustment Medication #6", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-007", new RenalAdjustmentRule("RENAL-ADJ-RENA-007", "RenalChemotherapyAdjustment Medication #7", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-008", new RenalAdjustmentRule("RENAL-ADJ-RENA-008", "RenalChemotherapyAdjustment Medication #8", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-009", new RenalAdjustmentRule("RENAL-ADJ-RENA-009", "RenalChemotherapyAdjustment Medication #9", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-010", new RenalAdjustmentRule("RENAL-ADJ-RENA-010", "RenalChemotherapyAdjustment Medication #10", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-011", new RenalAdjustmentRule("RENAL-ADJ-RENA-011", "RenalChemotherapyAdjustment Medication #11", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-012", new RenalAdjustmentRule("RENAL-ADJ-RENA-012", "RenalChemotherapyAdjustment Medication #12", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-013", new RenalAdjustmentRule("RENAL-ADJ-RENA-013", "RenalChemotherapyAdjustment Medication #13", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-014", new RenalAdjustmentRule("RENAL-ADJ-RENA-014", "RenalChemotherapyAdjustment Medication #14", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-015", new RenalAdjustmentRule("RENAL-ADJ-RENA-015", "RenalChemotherapyAdjustment Medication #15", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-016", new RenalAdjustmentRule("RENAL-ADJ-RENA-016", "RenalChemotherapyAdjustment Medication #16", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-017", new RenalAdjustmentRule("RENAL-ADJ-RENA-017", "RenalChemotherapyAdjustment Medication #17", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-018", new RenalAdjustmentRule("RENAL-ADJ-RENA-018", "RenalChemotherapyAdjustment Medication #18", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-019", new RenalAdjustmentRule("RENAL-ADJ-RENA-019", "RenalChemotherapyAdjustment Medication #19", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-020", new RenalAdjustmentRule("RENAL-ADJ-RENA-020", "RenalChemotherapyAdjustment Medication #20", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-021", new RenalAdjustmentRule("RENAL-ADJ-RENA-021", "RenalChemotherapyAdjustment Medication #21", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-022", new RenalAdjustmentRule("RENAL-ADJ-RENA-022", "RenalChemotherapyAdjustment Medication #22", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-023", new RenalAdjustmentRule("RENAL-ADJ-RENA-023", "RenalChemotherapyAdjustment Medication #23", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-024", new RenalAdjustmentRule("RENAL-ADJ-RENA-024", "RenalChemotherapyAdjustment Medication #24", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-025", new RenalAdjustmentRule("RENAL-ADJ-RENA-025", "RenalChemotherapyAdjustment Medication #25", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-026", new RenalAdjustmentRule("RENAL-ADJ-RENA-026", "RenalChemotherapyAdjustment Medication #26", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-027", new RenalAdjustmentRule("RENAL-ADJ-RENA-027", "RenalChemotherapyAdjustment Medication #27", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-028", new RenalAdjustmentRule("RENAL-ADJ-RENA-028", "RenalChemotherapyAdjustment Medication #28", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-029", new RenalAdjustmentRule("RENAL-ADJ-RENA-029", "RenalChemotherapyAdjustment Medication #29", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-030", new RenalAdjustmentRule("RENAL-ADJ-RENA-030", "RenalChemotherapyAdjustment Medication #30", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-031", new RenalAdjustmentRule("RENAL-ADJ-RENA-031", "RenalChemotherapyAdjustment Medication #31", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-032", new RenalAdjustmentRule("RENAL-ADJ-RENA-032", "RenalChemotherapyAdjustment Medication #32", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-033", new RenalAdjustmentRule("RENAL-ADJ-RENA-033", "RenalChemotherapyAdjustment Medication #33", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-034", new RenalAdjustmentRule("RENAL-ADJ-RENA-034", "RenalChemotherapyAdjustment Medication #34", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-035", new RenalAdjustmentRule("RENAL-ADJ-RENA-035", "RenalChemotherapyAdjustment Medication #35", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-036", new RenalAdjustmentRule("RENAL-ADJ-RENA-036", "RenalChemotherapyAdjustment Medication #36", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-037", new RenalAdjustmentRule("RENAL-ADJ-RENA-037", "RenalChemotherapyAdjustment Medication #37", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-038", new RenalAdjustmentRule("RENAL-ADJ-RENA-038", "RenalChemotherapyAdjustment Medication #38", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-039", new RenalAdjustmentRule("RENAL-ADJ-RENA-039", "RenalChemotherapyAdjustment Medication #39", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-040", new RenalAdjustmentRule("RENAL-ADJ-RENA-040", "RenalChemotherapyAdjustment Medication #40", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-041", new RenalAdjustmentRule("RENAL-ADJ-RENA-041", "RenalChemotherapyAdjustment Medication #41", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-042", new RenalAdjustmentRule("RENAL-ADJ-RENA-042", "RenalChemotherapyAdjustment Medication #42", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-043", new RenalAdjustmentRule("RENAL-ADJ-RENA-043", "RenalChemotherapyAdjustment Medication #43", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-044", new RenalAdjustmentRule("RENAL-ADJ-RENA-044", "RenalChemotherapyAdjustment Medication #44", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-045", new RenalAdjustmentRule("RENAL-ADJ-RENA-045", "RenalChemotherapyAdjustment Medication #45", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-046", new RenalAdjustmentRule("RENAL-ADJ-RENA-046", "RenalChemotherapyAdjustment Medication #46", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-047", new RenalAdjustmentRule("RENAL-ADJ-RENA-047", "RenalChemotherapyAdjustment Medication #47", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-048", new RenalAdjustmentRule("RENAL-ADJ-RENA-048", "RenalChemotherapyAdjustment Medication #48", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-049", new RenalAdjustmentRule("RENAL-ADJ-RENA-049", "RenalChemotherapyAdjustment Medication #49", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-050", new RenalAdjustmentRule("RENAL-ADJ-RENA-050", "RenalChemotherapyAdjustment Medication #50", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-051", new RenalAdjustmentRule("RENAL-ADJ-RENA-051", "RenalChemotherapyAdjustment Medication #51", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-052", new RenalAdjustmentRule("RENAL-ADJ-RENA-052", "RenalChemotherapyAdjustment Medication #52", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-053", new RenalAdjustmentRule("RENAL-ADJ-RENA-053", "RenalChemotherapyAdjustment Medication #53", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-054", new RenalAdjustmentRule("RENAL-ADJ-RENA-054", "RenalChemotherapyAdjustment Medication #54", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-055", new RenalAdjustmentRule("RENAL-ADJ-RENA-055", "RenalChemotherapyAdjustment Medication #55", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-056", new RenalAdjustmentRule("RENAL-ADJ-RENA-056", "RenalChemotherapyAdjustment Medication #56", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-057", new RenalAdjustmentRule("RENAL-ADJ-RENA-057", "RenalChemotherapyAdjustment Medication #57", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-058", new RenalAdjustmentRule("RENAL-ADJ-RENA-058", "RenalChemotherapyAdjustment Medication #58", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-059", new RenalAdjustmentRule("RENAL-ADJ-RENA-059", "RenalChemotherapyAdjustment Medication #59", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-060", new RenalAdjustmentRule("RENAL-ADJ-RENA-060", "RenalChemotherapyAdjustment Medication #60", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-061", new RenalAdjustmentRule("RENAL-ADJ-RENA-061", "RenalChemotherapyAdjustment Medication #61", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-062", new RenalAdjustmentRule("RENAL-ADJ-RENA-062", "RenalChemotherapyAdjustment Medication #62", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-063", new RenalAdjustmentRule("RENAL-ADJ-RENA-063", "RenalChemotherapyAdjustment Medication #63", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-064", new RenalAdjustmentRule("RENAL-ADJ-RENA-064", "RenalChemotherapyAdjustment Medication #64", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-065", new RenalAdjustmentRule("RENAL-ADJ-RENA-065", "RenalChemotherapyAdjustment Medication #65", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-066", new RenalAdjustmentRule("RENAL-ADJ-RENA-066", "RenalChemotherapyAdjustment Medication #66", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-067", new RenalAdjustmentRule("RENAL-ADJ-RENA-067", "RenalChemotherapyAdjustment Medication #67", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-068", new RenalAdjustmentRule("RENAL-ADJ-RENA-068", "RenalChemotherapyAdjustment Medication #68", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-069", new RenalAdjustmentRule("RENAL-ADJ-RENA-069", "RenalChemotherapyAdjustment Medication #69", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-070", new RenalAdjustmentRule("RENAL-ADJ-RENA-070", "RenalChemotherapyAdjustment Medication #70", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-071", new RenalAdjustmentRule("RENAL-ADJ-RENA-071", "RenalChemotherapyAdjustment Medication #71", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-072", new RenalAdjustmentRule("RENAL-ADJ-RENA-072", "RenalChemotherapyAdjustment Medication #72", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-073", new RenalAdjustmentRule("RENAL-ADJ-RENA-073", "RenalChemotherapyAdjustment Medication #73", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-074", new RenalAdjustmentRule("RENAL-ADJ-RENA-074", "RenalChemotherapyAdjustment Medication #74", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-075", new RenalAdjustmentRule("RENAL-ADJ-RENA-075", "RenalChemotherapyAdjustment Medication #75", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-076", new RenalAdjustmentRule("RENAL-ADJ-RENA-076", "RenalChemotherapyAdjustment Medication #76", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-077", new RenalAdjustmentRule("RENAL-ADJ-RENA-077", "RenalChemotherapyAdjustment Medication #77", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-078", new RenalAdjustmentRule("RENAL-ADJ-RENA-078", "RenalChemotherapyAdjustment Medication #78", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-079", new RenalAdjustmentRule("RENAL-ADJ-RENA-079", "RenalChemotherapyAdjustment Medication #79", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-080", new RenalAdjustmentRule("RENAL-ADJ-RENA-080", "RenalChemotherapyAdjustment Medication #80", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-081", new RenalAdjustmentRule("RENAL-ADJ-RENA-081", "RenalChemotherapyAdjustment Medication #81", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-082", new RenalAdjustmentRule("RENAL-ADJ-RENA-082", "RenalChemotherapyAdjustment Medication #82", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-083", new RenalAdjustmentRule("RENAL-ADJ-RENA-083", "RenalChemotherapyAdjustment Medication #83", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-084", new RenalAdjustmentRule("RENAL-ADJ-RENA-084", "RenalChemotherapyAdjustment Medication #84", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-085", new RenalAdjustmentRule("RENAL-ADJ-RENA-085", "RenalChemotherapyAdjustment Medication #85", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-086", new RenalAdjustmentRule("RENAL-ADJ-RENA-086", "RenalChemotherapyAdjustment Medication #86", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-087", new RenalAdjustmentRule("RENAL-ADJ-RENA-087", "RenalChemotherapyAdjustment Medication #87", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-088", new RenalAdjustmentRule("RENAL-ADJ-RENA-088", "RenalChemotherapyAdjustment Medication #88", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-089", new RenalAdjustmentRule("RENAL-ADJ-RENA-089", "RenalChemotherapyAdjustment Medication #89", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-090", new RenalAdjustmentRule("RENAL-ADJ-RENA-090", "RenalChemotherapyAdjustment Medication #90", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-091", new RenalAdjustmentRule("RENAL-ADJ-RENA-091", "RenalChemotherapyAdjustment Medication #91", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-092", new RenalAdjustmentRule("RENAL-ADJ-RENA-092", "RenalChemotherapyAdjustment Medication #92", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-093", new RenalAdjustmentRule("RENAL-ADJ-RENA-093", "RenalChemotherapyAdjustment Medication #93", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-094", new RenalAdjustmentRule("RENAL-ADJ-RENA-094", "RenalChemotherapyAdjustment Medication #94", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-095", new RenalAdjustmentRule("RENAL-ADJ-RENA-095", "RenalChemotherapyAdjustment Medication #95", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-096", new RenalAdjustmentRule("RENAL-ADJ-RENA-096", "RenalChemotherapyAdjustment Medication #96", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-097", new RenalAdjustmentRule("RENAL-ADJ-RENA-097", "RenalChemotherapyAdjustment Medication #97", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-098", new RenalAdjustmentRule("RENAL-ADJ-RENA-098", "RenalChemotherapyAdjustment Medication #98", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-099", new RenalAdjustmentRule("RENAL-ADJ-RENA-099", "RenalChemotherapyAdjustment Medication #99", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-100", new RenalAdjustmentRule("RENAL-ADJ-RENA-100", "RenalChemotherapyAdjustment Medication #100", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-101", new RenalAdjustmentRule("RENAL-ADJ-RENA-101", "RenalChemotherapyAdjustment Medication #101", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-102", new RenalAdjustmentRule("RENAL-ADJ-RENA-102", "RenalChemotherapyAdjustment Medication #102", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-103", new RenalAdjustmentRule("RENAL-ADJ-RENA-103", "RenalChemotherapyAdjustment Medication #103", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-104", new RenalAdjustmentRule("RENAL-ADJ-RENA-104", "RenalChemotherapyAdjustment Medication #104", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-105", new RenalAdjustmentRule("RENAL-ADJ-RENA-105", "RenalChemotherapyAdjustment Medication #105", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-106", new RenalAdjustmentRule("RENAL-ADJ-RENA-106", "RenalChemotherapyAdjustment Medication #106", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-107", new RenalAdjustmentRule("RENAL-ADJ-RENA-107", "RenalChemotherapyAdjustment Medication #107", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-108", new RenalAdjustmentRule("RENAL-ADJ-RENA-108", "RenalChemotherapyAdjustment Medication #108", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-109", new RenalAdjustmentRule("RENAL-ADJ-RENA-109", "RenalChemotherapyAdjustment Medication #109", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-110", new RenalAdjustmentRule("RENAL-ADJ-RENA-110", "RenalChemotherapyAdjustment Medication #110", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-111", new RenalAdjustmentRule("RENAL-ADJ-RENA-111", "RenalChemotherapyAdjustment Medication #111", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-112", new RenalAdjustmentRule("RENAL-ADJ-RENA-112", "RenalChemotherapyAdjustment Medication #112", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-113", new RenalAdjustmentRule("RENAL-ADJ-RENA-113", "RenalChemotherapyAdjustment Medication #113", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-114", new RenalAdjustmentRule("RENAL-ADJ-RENA-114", "RenalChemotherapyAdjustment Medication #114", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-115", new RenalAdjustmentRule("RENAL-ADJ-RENA-115", "RenalChemotherapyAdjustment Medication #115", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-116", new RenalAdjustmentRule("RENAL-ADJ-RENA-116", "RenalChemotherapyAdjustment Medication #116", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-117", new RenalAdjustmentRule("RENAL-ADJ-RENA-117", "RenalChemotherapyAdjustment Medication #117", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-118", new RenalAdjustmentRule("RENAL-ADJ-RENA-118", "RenalChemotherapyAdjustment Medication #118", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-119", new RenalAdjustmentRule("RENAL-ADJ-RENA-119", "RenalChemotherapyAdjustment Medication #119", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-120", new RenalAdjustmentRule("RENAL-ADJ-RENA-120", "RenalChemotherapyAdjustment Medication #120", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
    }

    public Optional<RenalAdjustmentRule> findByCode(String code) {
        return Optional.ofNullable(adjustments.get(code));
    }

    public List<RenalAdjustmentRule> getAllRules() {
        return new ArrayList<>(adjustments.values());
    }
}
