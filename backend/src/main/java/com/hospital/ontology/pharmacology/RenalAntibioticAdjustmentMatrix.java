package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RenalAntibioticAdjustmentMatrix {

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

    public RenalAntibioticAdjustmentMatrix() {
        initializeRules();
    }

    private void initializeRules() {
        adjustments.put("RENAL-ADJ-RENA-001", new RenalAdjustmentRule("RENAL-ADJ-RENA-001", "RenalAntibioticAdjustment Medication #1", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-002", new RenalAdjustmentRule("RENAL-ADJ-RENA-002", "RenalAntibioticAdjustment Medication #2", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-003", new RenalAdjustmentRule("RENAL-ADJ-RENA-003", "RenalAntibioticAdjustment Medication #3", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-004", new RenalAdjustmentRule("RENAL-ADJ-RENA-004", "RenalAntibioticAdjustment Medication #4", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-005", new RenalAdjustmentRule("RENAL-ADJ-RENA-005", "RenalAntibioticAdjustment Medication #5", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-006", new RenalAdjustmentRule("RENAL-ADJ-RENA-006", "RenalAntibioticAdjustment Medication #6", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-007", new RenalAdjustmentRule("RENAL-ADJ-RENA-007", "RenalAntibioticAdjustment Medication #7", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-008", new RenalAdjustmentRule("RENAL-ADJ-RENA-008", "RenalAntibioticAdjustment Medication #8", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-009", new RenalAdjustmentRule("RENAL-ADJ-RENA-009", "RenalAntibioticAdjustment Medication #9", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-010", new RenalAdjustmentRule("RENAL-ADJ-RENA-010", "RenalAntibioticAdjustment Medication #10", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-011", new RenalAdjustmentRule("RENAL-ADJ-RENA-011", "RenalAntibioticAdjustment Medication #11", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-012", new RenalAdjustmentRule("RENAL-ADJ-RENA-012", "RenalAntibioticAdjustment Medication #12", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-013", new RenalAdjustmentRule("RENAL-ADJ-RENA-013", "RenalAntibioticAdjustment Medication #13", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-014", new RenalAdjustmentRule("RENAL-ADJ-RENA-014", "RenalAntibioticAdjustment Medication #14", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-015", new RenalAdjustmentRule("RENAL-ADJ-RENA-015", "RenalAntibioticAdjustment Medication #15", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-016", new RenalAdjustmentRule("RENAL-ADJ-RENA-016", "RenalAntibioticAdjustment Medication #16", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-017", new RenalAdjustmentRule("RENAL-ADJ-RENA-017", "RenalAntibioticAdjustment Medication #17", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-018", new RenalAdjustmentRule("RENAL-ADJ-RENA-018", "RenalAntibioticAdjustment Medication #18", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-019", new RenalAdjustmentRule("RENAL-ADJ-RENA-019", "RenalAntibioticAdjustment Medication #19", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-020", new RenalAdjustmentRule("RENAL-ADJ-RENA-020", "RenalAntibioticAdjustment Medication #20", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-021", new RenalAdjustmentRule("RENAL-ADJ-RENA-021", "RenalAntibioticAdjustment Medication #21", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-022", new RenalAdjustmentRule("RENAL-ADJ-RENA-022", "RenalAntibioticAdjustment Medication #22", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-023", new RenalAdjustmentRule("RENAL-ADJ-RENA-023", "RenalAntibioticAdjustment Medication #23", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-024", new RenalAdjustmentRule("RENAL-ADJ-RENA-024", "RenalAntibioticAdjustment Medication #24", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-025", new RenalAdjustmentRule("RENAL-ADJ-RENA-025", "RenalAntibioticAdjustment Medication #25", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-026", new RenalAdjustmentRule("RENAL-ADJ-RENA-026", "RenalAntibioticAdjustment Medication #26", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-027", new RenalAdjustmentRule("RENAL-ADJ-RENA-027", "RenalAntibioticAdjustment Medication #27", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-028", new RenalAdjustmentRule("RENAL-ADJ-RENA-028", "RenalAntibioticAdjustment Medication #28", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-029", new RenalAdjustmentRule("RENAL-ADJ-RENA-029", "RenalAntibioticAdjustment Medication #29", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-030", new RenalAdjustmentRule("RENAL-ADJ-RENA-030", "RenalAntibioticAdjustment Medication #30", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-031", new RenalAdjustmentRule("RENAL-ADJ-RENA-031", "RenalAntibioticAdjustment Medication #31", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-032", new RenalAdjustmentRule("RENAL-ADJ-RENA-032", "RenalAntibioticAdjustment Medication #32", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-033", new RenalAdjustmentRule("RENAL-ADJ-RENA-033", "RenalAntibioticAdjustment Medication #33", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-034", new RenalAdjustmentRule("RENAL-ADJ-RENA-034", "RenalAntibioticAdjustment Medication #34", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-035", new RenalAdjustmentRule("RENAL-ADJ-RENA-035", "RenalAntibioticAdjustment Medication #35", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-036", new RenalAdjustmentRule("RENAL-ADJ-RENA-036", "RenalAntibioticAdjustment Medication #36", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-037", new RenalAdjustmentRule("RENAL-ADJ-RENA-037", "RenalAntibioticAdjustment Medication #37", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-038", new RenalAdjustmentRule("RENAL-ADJ-RENA-038", "RenalAntibioticAdjustment Medication #38", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-039", new RenalAdjustmentRule("RENAL-ADJ-RENA-039", "RenalAntibioticAdjustment Medication #39", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-040", new RenalAdjustmentRule("RENAL-ADJ-RENA-040", "RenalAntibioticAdjustment Medication #40", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-041", new RenalAdjustmentRule("RENAL-ADJ-RENA-041", "RenalAntibioticAdjustment Medication #41", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-042", new RenalAdjustmentRule("RENAL-ADJ-RENA-042", "RenalAntibioticAdjustment Medication #42", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-043", new RenalAdjustmentRule("RENAL-ADJ-RENA-043", "RenalAntibioticAdjustment Medication #43", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-044", new RenalAdjustmentRule("RENAL-ADJ-RENA-044", "RenalAntibioticAdjustment Medication #44", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-045", new RenalAdjustmentRule("RENAL-ADJ-RENA-045", "RenalAntibioticAdjustment Medication #45", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-046", new RenalAdjustmentRule("RENAL-ADJ-RENA-046", "RenalAntibioticAdjustment Medication #46", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-047", new RenalAdjustmentRule("RENAL-ADJ-RENA-047", "RenalAntibioticAdjustment Medication #47", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-048", new RenalAdjustmentRule("RENAL-ADJ-RENA-048", "RenalAntibioticAdjustment Medication #48", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-049", new RenalAdjustmentRule("RENAL-ADJ-RENA-049", "RenalAntibioticAdjustment Medication #49", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-050", new RenalAdjustmentRule("RENAL-ADJ-RENA-050", "RenalAntibioticAdjustment Medication #50", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-051", new RenalAdjustmentRule("RENAL-ADJ-RENA-051", "RenalAntibioticAdjustment Medication #51", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-052", new RenalAdjustmentRule("RENAL-ADJ-RENA-052", "RenalAntibioticAdjustment Medication #52", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-053", new RenalAdjustmentRule("RENAL-ADJ-RENA-053", "RenalAntibioticAdjustment Medication #53", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-054", new RenalAdjustmentRule("RENAL-ADJ-RENA-054", "RenalAntibioticAdjustment Medication #54", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-055", new RenalAdjustmentRule("RENAL-ADJ-RENA-055", "RenalAntibioticAdjustment Medication #55", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-056", new RenalAdjustmentRule("RENAL-ADJ-RENA-056", "RenalAntibioticAdjustment Medication #56", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-057", new RenalAdjustmentRule("RENAL-ADJ-RENA-057", "RenalAntibioticAdjustment Medication #57", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-058", new RenalAdjustmentRule("RENAL-ADJ-RENA-058", "RenalAntibioticAdjustment Medication #58", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-059", new RenalAdjustmentRule("RENAL-ADJ-RENA-059", "RenalAntibioticAdjustment Medication #59", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-060", new RenalAdjustmentRule("RENAL-ADJ-RENA-060", "RenalAntibioticAdjustment Medication #60", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-061", new RenalAdjustmentRule("RENAL-ADJ-RENA-061", "RenalAntibioticAdjustment Medication #61", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-062", new RenalAdjustmentRule("RENAL-ADJ-RENA-062", "RenalAntibioticAdjustment Medication #62", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-063", new RenalAdjustmentRule("RENAL-ADJ-RENA-063", "RenalAntibioticAdjustment Medication #63", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-064", new RenalAdjustmentRule("RENAL-ADJ-RENA-064", "RenalAntibioticAdjustment Medication #64", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-065", new RenalAdjustmentRule("RENAL-ADJ-RENA-065", "RenalAntibioticAdjustment Medication #65", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-066", new RenalAdjustmentRule("RENAL-ADJ-RENA-066", "RenalAntibioticAdjustment Medication #66", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-067", new RenalAdjustmentRule("RENAL-ADJ-RENA-067", "RenalAntibioticAdjustment Medication #67", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-068", new RenalAdjustmentRule("RENAL-ADJ-RENA-068", "RenalAntibioticAdjustment Medication #68", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-069", new RenalAdjustmentRule("RENAL-ADJ-RENA-069", "RenalAntibioticAdjustment Medication #69", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-070", new RenalAdjustmentRule("RENAL-ADJ-RENA-070", "RenalAntibioticAdjustment Medication #70", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-071", new RenalAdjustmentRule("RENAL-ADJ-RENA-071", "RenalAntibioticAdjustment Medication #71", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-072", new RenalAdjustmentRule("RENAL-ADJ-RENA-072", "RenalAntibioticAdjustment Medication #72", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-073", new RenalAdjustmentRule("RENAL-ADJ-RENA-073", "RenalAntibioticAdjustment Medication #73", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-074", new RenalAdjustmentRule("RENAL-ADJ-RENA-074", "RenalAntibioticAdjustment Medication #74", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-075", new RenalAdjustmentRule("RENAL-ADJ-RENA-075", "RenalAntibioticAdjustment Medication #75", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-076", new RenalAdjustmentRule("RENAL-ADJ-RENA-076", "RenalAntibioticAdjustment Medication #76", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-077", new RenalAdjustmentRule("RENAL-ADJ-RENA-077", "RenalAntibioticAdjustment Medication #77", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-078", new RenalAdjustmentRule("RENAL-ADJ-RENA-078", "RenalAntibioticAdjustment Medication #78", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-079", new RenalAdjustmentRule("RENAL-ADJ-RENA-079", "RenalAntibioticAdjustment Medication #79", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-080", new RenalAdjustmentRule("RENAL-ADJ-RENA-080", "RenalAntibioticAdjustment Medication #80", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-081", new RenalAdjustmentRule("RENAL-ADJ-RENA-081", "RenalAntibioticAdjustment Medication #81", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-082", new RenalAdjustmentRule("RENAL-ADJ-RENA-082", "RenalAntibioticAdjustment Medication #82", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-083", new RenalAdjustmentRule("RENAL-ADJ-RENA-083", "RenalAntibioticAdjustment Medication #83", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-084", new RenalAdjustmentRule("RENAL-ADJ-RENA-084", "RenalAntibioticAdjustment Medication #84", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-085", new RenalAdjustmentRule("RENAL-ADJ-RENA-085", "RenalAntibioticAdjustment Medication #85", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-086", new RenalAdjustmentRule("RENAL-ADJ-RENA-086", "RenalAntibioticAdjustment Medication #86", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-087", new RenalAdjustmentRule("RENAL-ADJ-RENA-087", "RenalAntibioticAdjustment Medication #87", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-088", new RenalAdjustmentRule("RENAL-ADJ-RENA-088", "RenalAntibioticAdjustment Medication #88", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-089", new RenalAdjustmentRule("RENAL-ADJ-RENA-089", "RenalAntibioticAdjustment Medication #89", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-090", new RenalAdjustmentRule("RENAL-ADJ-RENA-090", "RenalAntibioticAdjustment Medication #90", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-091", new RenalAdjustmentRule("RENAL-ADJ-RENA-091", "RenalAntibioticAdjustment Medication #91", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-092", new RenalAdjustmentRule("RENAL-ADJ-RENA-092", "RenalAntibioticAdjustment Medication #92", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-093", new RenalAdjustmentRule("RENAL-ADJ-RENA-093", "RenalAntibioticAdjustment Medication #93", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-094", new RenalAdjustmentRule("RENAL-ADJ-RENA-094", "RenalAntibioticAdjustment Medication #94", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-095", new RenalAdjustmentRule("RENAL-ADJ-RENA-095", "RenalAntibioticAdjustment Medication #95", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-096", new RenalAdjustmentRule("RENAL-ADJ-RENA-096", "RenalAntibioticAdjustment Medication #96", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-097", new RenalAdjustmentRule("RENAL-ADJ-RENA-097", "RenalAntibioticAdjustment Medication #97", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-098", new RenalAdjustmentRule("RENAL-ADJ-RENA-098", "RenalAntibioticAdjustment Medication #98", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-099", new RenalAdjustmentRule("RENAL-ADJ-RENA-099", "RenalAntibioticAdjustment Medication #99", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-100", new RenalAdjustmentRule("RENAL-ADJ-RENA-100", "RenalAntibioticAdjustment Medication #100", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-101", new RenalAdjustmentRule("RENAL-ADJ-RENA-101", "RenalAntibioticAdjustment Medication #101", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-102", new RenalAdjustmentRule("RENAL-ADJ-RENA-102", "RenalAntibioticAdjustment Medication #102", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-103", new RenalAdjustmentRule("RENAL-ADJ-RENA-103", "RenalAntibioticAdjustment Medication #103", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-104", new RenalAdjustmentRule("RENAL-ADJ-RENA-104", "RenalAntibioticAdjustment Medication #104", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-105", new RenalAdjustmentRule("RENAL-ADJ-RENA-105", "RenalAntibioticAdjustment Medication #105", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-106", new RenalAdjustmentRule("RENAL-ADJ-RENA-106", "RenalAntibioticAdjustment Medication #106", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-107", new RenalAdjustmentRule("RENAL-ADJ-RENA-107", "RenalAntibioticAdjustment Medication #107", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-108", new RenalAdjustmentRule("RENAL-ADJ-RENA-108", "RenalAntibioticAdjustment Medication #108", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-109", new RenalAdjustmentRule("RENAL-ADJ-RENA-109", "RenalAntibioticAdjustment Medication #109", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-110", new RenalAdjustmentRule("RENAL-ADJ-RENA-110", "RenalAntibioticAdjustment Medication #110", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-111", new RenalAdjustmentRule("RENAL-ADJ-RENA-111", "RenalAntibioticAdjustment Medication #111", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-112", new RenalAdjustmentRule("RENAL-ADJ-RENA-112", "RenalAntibioticAdjustment Medication #112", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-113", new RenalAdjustmentRule("RENAL-ADJ-RENA-113", "RenalAntibioticAdjustment Medication #113", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-114", new RenalAdjustmentRule("RENAL-ADJ-RENA-114", "RenalAntibioticAdjustment Medication #114", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-115", new RenalAdjustmentRule("RENAL-ADJ-RENA-115", "RenalAntibioticAdjustment Medication #115", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-116", new RenalAdjustmentRule("RENAL-ADJ-RENA-116", "RenalAntibioticAdjustment Medication #116", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-117", new RenalAdjustmentRule("RENAL-ADJ-RENA-117", "RenalAntibioticAdjustment Medication #117", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-118", new RenalAdjustmentRule("RENAL-ADJ-RENA-118", "RenalAntibioticAdjustment Medication #118", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-119", new RenalAdjustmentRule("RENAL-ADJ-RENA-119", "RenalAntibioticAdjustment Medication #119", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-120", new RenalAdjustmentRule("RENAL-ADJ-RENA-120", "RenalAntibioticAdjustment Medication #120", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
    }

    public Optional<RenalAdjustmentRule> findByCode(String code) {
        return Optional.ofNullable(adjustments.get(code));
    }

    public List<RenalAdjustmentRule> getAllRules() {
        return new ArrayList<>(adjustments.values());
    }
}
