package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RenalHypoglycemicAdjustmentMatrix {

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

    public RenalHypoglycemicAdjustmentMatrix() {
        initializeRules();
    }

    private void initializeRules() {
        adjustments.put("RENAL-ADJ-RENA-001", new RenalAdjustmentRule("RENAL-ADJ-RENA-001", "RenalHypoglycemicAdjustment Medication #1", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-002", new RenalAdjustmentRule("RENAL-ADJ-RENA-002", "RenalHypoglycemicAdjustment Medication #2", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-003", new RenalAdjustmentRule("RENAL-ADJ-RENA-003", "RenalHypoglycemicAdjustment Medication #3", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-004", new RenalAdjustmentRule("RENAL-ADJ-RENA-004", "RenalHypoglycemicAdjustment Medication #4", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-005", new RenalAdjustmentRule("RENAL-ADJ-RENA-005", "RenalHypoglycemicAdjustment Medication #5", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-006", new RenalAdjustmentRule("RENAL-ADJ-RENA-006", "RenalHypoglycemicAdjustment Medication #6", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-007", new RenalAdjustmentRule("RENAL-ADJ-RENA-007", "RenalHypoglycemicAdjustment Medication #7", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-008", new RenalAdjustmentRule("RENAL-ADJ-RENA-008", "RenalHypoglycemicAdjustment Medication #8", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-009", new RenalAdjustmentRule("RENAL-ADJ-RENA-009", "RenalHypoglycemicAdjustment Medication #9", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-010", new RenalAdjustmentRule("RENAL-ADJ-RENA-010", "RenalHypoglycemicAdjustment Medication #10", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-011", new RenalAdjustmentRule("RENAL-ADJ-RENA-011", "RenalHypoglycemicAdjustment Medication #11", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-012", new RenalAdjustmentRule("RENAL-ADJ-RENA-012", "RenalHypoglycemicAdjustment Medication #12", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-013", new RenalAdjustmentRule("RENAL-ADJ-RENA-013", "RenalHypoglycemicAdjustment Medication #13", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-014", new RenalAdjustmentRule("RENAL-ADJ-RENA-014", "RenalHypoglycemicAdjustment Medication #14", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-015", new RenalAdjustmentRule("RENAL-ADJ-RENA-015", "RenalHypoglycemicAdjustment Medication #15", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-016", new RenalAdjustmentRule("RENAL-ADJ-RENA-016", "RenalHypoglycemicAdjustment Medication #16", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-017", new RenalAdjustmentRule("RENAL-ADJ-RENA-017", "RenalHypoglycemicAdjustment Medication #17", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-018", new RenalAdjustmentRule("RENAL-ADJ-RENA-018", "RenalHypoglycemicAdjustment Medication #18", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-019", new RenalAdjustmentRule("RENAL-ADJ-RENA-019", "RenalHypoglycemicAdjustment Medication #19", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-020", new RenalAdjustmentRule("RENAL-ADJ-RENA-020", "RenalHypoglycemicAdjustment Medication #20", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-021", new RenalAdjustmentRule("RENAL-ADJ-RENA-021", "RenalHypoglycemicAdjustment Medication #21", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-022", new RenalAdjustmentRule("RENAL-ADJ-RENA-022", "RenalHypoglycemicAdjustment Medication #22", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-023", new RenalAdjustmentRule("RENAL-ADJ-RENA-023", "RenalHypoglycemicAdjustment Medication #23", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-024", new RenalAdjustmentRule("RENAL-ADJ-RENA-024", "RenalHypoglycemicAdjustment Medication #24", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-025", new RenalAdjustmentRule("RENAL-ADJ-RENA-025", "RenalHypoglycemicAdjustment Medication #25", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-026", new RenalAdjustmentRule("RENAL-ADJ-RENA-026", "RenalHypoglycemicAdjustment Medication #26", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-027", new RenalAdjustmentRule("RENAL-ADJ-RENA-027", "RenalHypoglycemicAdjustment Medication #27", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-028", new RenalAdjustmentRule("RENAL-ADJ-RENA-028", "RenalHypoglycemicAdjustment Medication #28", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-029", new RenalAdjustmentRule("RENAL-ADJ-RENA-029", "RenalHypoglycemicAdjustment Medication #29", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-030", new RenalAdjustmentRule("RENAL-ADJ-RENA-030", "RenalHypoglycemicAdjustment Medication #30", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-031", new RenalAdjustmentRule("RENAL-ADJ-RENA-031", "RenalHypoglycemicAdjustment Medication #31", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-032", new RenalAdjustmentRule("RENAL-ADJ-RENA-032", "RenalHypoglycemicAdjustment Medication #32", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-033", new RenalAdjustmentRule("RENAL-ADJ-RENA-033", "RenalHypoglycemicAdjustment Medication #33", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-034", new RenalAdjustmentRule("RENAL-ADJ-RENA-034", "RenalHypoglycemicAdjustment Medication #34", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-035", new RenalAdjustmentRule("RENAL-ADJ-RENA-035", "RenalHypoglycemicAdjustment Medication #35", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-036", new RenalAdjustmentRule("RENAL-ADJ-RENA-036", "RenalHypoglycemicAdjustment Medication #36", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-037", new RenalAdjustmentRule("RENAL-ADJ-RENA-037", "RenalHypoglycemicAdjustment Medication #37", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-038", new RenalAdjustmentRule("RENAL-ADJ-RENA-038", "RenalHypoglycemicAdjustment Medication #38", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-039", new RenalAdjustmentRule("RENAL-ADJ-RENA-039", "RenalHypoglycemicAdjustment Medication #39", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-040", new RenalAdjustmentRule("RENAL-ADJ-RENA-040", "RenalHypoglycemicAdjustment Medication #40", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-041", new RenalAdjustmentRule("RENAL-ADJ-RENA-041", "RenalHypoglycemicAdjustment Medication #41", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-042", new RenalAdjustmentRule("RENAL-ADJ-RENA-042", "RenalHypoglycemicAdjustment Medication #42", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-043", new RenalAdjustmentRule("RENAL-ADJ-RENA-043", "RenalHypoglycemicAdjustment Medication #43", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-044", new RenalAdjustmentRule("RENAL-ADJ-RENA-044", "RenalHypoglycemicAdjustment Medication #44", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-045", new RenalAdjustmentRule("RENAL-ADJ-RENA-045", "RenalHypoglycemicAdjustment Medication #45", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-046", new RenalAdjustmentRule("RENAL-ADJ-RENA-046", "RenalHypoglycemicAdjustment Medication #46", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-047", new RenalAdjustmentRule("RENAL-ADJ-RENA-047", "RenalHypoglycemicAdjustment Medication #47", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-048", new RenalAdjustmentRule("RENAL-ADJ-RENA-048", "RenalHypoglycemicAdjustment Medication #48", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-049", new RenalAdjustmentRule("RENAL-ADJ-RENA-049", "RenalHypoglycemicAdjustment Medication #49", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-050", new RenalAdjustmentRule("RENAL-ADJ-RENA-050", "RenalHypoglycemicAdjustment Medication #50", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-051", new RenalAdjustmentRule("RENAL-ADJ-RENA-051", "RenalHypoglycemicAdjustment Medication #51", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-052", new RenalAdjustmentRule("RENAL-ADJ-RENA-052", "RenalHypoglycemicAdjustment Medication #52", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-053", new RenalAdjustmentRule("RENAL-ADJ-RENA-053", "RenalHypoglycemicAdjustment Medication #53", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-054", new RenalAdjustmentRule("RENAL-ADJ-RENA-054", "RenalHypoglycemicAdjustment Medication #54", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-055", new RenalAdjustmentRule("RENAL-ADJ-RENA-055", "RenalHypoglycemicAdjustment Medication #55", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-056", new RenalAdjustmentRule("RENAL-ADJ-RENA-056", "RenalHypoglycemicAdjustment Medication #56", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-057", new RenalAdjustmentRule("RENAL-ADJ-RENA-057", "RenalHypoglycemicAdjustment Medication #57", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-058", new RenalAdjustmentRule("RENAL-ADJ-RENA-058", "RenalHypoglycemicAdjustment Medication #58", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-059", new RenalAdjustmentRule("RENAL-ADJ-RENA-059", "RenalHypoglycemicAdjustment Medication #59", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-060", new RenalAdjustmentRule("RENAL-ADJ-RENA-060", "RenalHypoglycemicAdjustment Medication #60", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-061", new RenalAdjustmentRule("RENAL-ADJ-RENA-061", "RenalHypoglycemicAdjustment Medication #61", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-062", new RenalAdjustmentRule("RENAL-ADJ-RENA-062", "RenalHypoglycemicAdjustment Medication #62", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-063", new RenalAdjustmentRule("RENAL-ADJ-RENA-063", "RenalHypoglycemicAdjustment Medication #63", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-064", new RenalAdjustmentRule("RENAL-ADJ-RENA-064", "RenalHypoglycemicAdjustment Medication #64", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-065", new RenalAdjustmentRule("RENAL-ADJ-RENA-065", "RenalHypoglycemicAdjustment Medication #65", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-066", new RenalAdjustmentRule("RENAL-ADJ-RENA-066", "RenalHypoglycemicAdjustment Medication #66", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-067", new RenalAdjustmentRule("RENAL-ADJ-RENA-067", "RenalHypoglycemicAdjustment Medication #67", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-068", new RenalAdjustmentRule("RENAL-ADJ-RENA-068", "RenalHypoglycemicAdjustment Medication #68", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-069", new RenalAdjustmentRule("RENAL-ADJ-RENA-069", "RenalHypoglycemicAdjustment Medication #69", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-070", new RenalAdjustmentRule("RENAL-ADJ-RENA-070", "RenalHypoglycemicAdjustment Medication #70", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-071", new RenalAdjustmentRule("RENAL-ADJ-RENA-071", "RenalHypoglycemicAdjustment Medication #71", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-072", new RenalAdjustmentRule("RENAL-ADJ-RENA-072", "RenalHypoglycemicAdjustment Medication #72", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-073", new RenalAdjustmentRule("RENAL-ADJ-RENA-073", "RenalHypoglycemicAdjustment Medication #73", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-074", new RenalAdjustmentRule("RENAL-ADJ-RENA-074", "RenalHypoglycemicAdjustment Medication #74", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-075", new RenalAdjustmentRule("RENAL-ADJ-RENA-075", "RenalHypoglycemicAdjustment Medication #75", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-076", new RenalAdjustmentRule("RENAL-ADJ-RENA-076", "RenalHypoglycemicAdjustment Medication #76", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-077", new RenalAdjustmentRule("RENAL-ADJ-RENA-077", "RenalHypoglycemicAdjustment Medication #77", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-078", new RenalAdjustmentRule("RENAL-ADJ-RENA-078", "RenalHypoglycemicAdjustment Medication #78", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-079", new RenalAdjustmentRule("RENAL-ADJ-RENA-079", "RenalHypoglycemicAdjustment Medication #79", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-080", new RenalAdjustmentRule("RENAL-ADJ-RENA-080", "RenalHypoglycemicAdjustment Medication #80", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-081", new RenalAdjustmentRule("RENAL-ADJ-RENA-081", "RenalHypoglycemicAdjustment Medication #81", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-082", new RenalAdjustmentRule("RENAL-ADJ-RENA-082", "RenalHypoglycemicAdjustment Medication #82", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-083", new RenalAdjustmentRule("RENAL-ADJ-RENA-083", "RenalHypoglycemicAdjustment Medication #83", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-084", new RenalAdjustmentRule("RENAL-ADJ-RENA-084", "RenalHypoglycemicAdjustment Medication #84", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-085", new RenalAdjustmentRule("RENAL-ADJ-RENA-085", "RenalHypoglycemicAdjustment Medication #85", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-086", new RenalAdjustmentRule("RENAL-ADJ-RENA-086", "RenalHypoglycemicAdjustment Medication #86", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-087", new RenalAdjustmentRule("RENAL-ADJ-RENA-087", "RenalHypoglycemicAdjustment Medication #87", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-088", new RenalAdjustmentRule("RENAL-ADJ-RENA-088", "RenalHypoglycemicAdjustment Medication #88", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-089", new RenalAdjustmentRule("RENAL-ADJ-RENA-089", "RenalHypoglycemicAdjustment Medication #89", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-090", new RenalAdjustmentRule("RENAL-ADJ-RENA-090", "RenalHypoglycemicAdjustment Medication #90", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-091", new RenalAdjustmentRule("RENAL-ADJ-RENA-091", "RenalHypoglycemicAdjustment Medication #91", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-092", new RenalAdjustmentRule("RENAL-ADJ-RENA-092", "RenalHypoglycemicAdjustment Medication #92", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-093", new RenalAdjustmentRule("RENAL-ADJ-RENA-093", "RenalHypoglycemicAdjustment Medication #93", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-094", new RenalAdjustmentRule("RENAL-ADJ-RENA-094", "RenalHypoglycemicAdjustment Medication #94", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-095", new RenalAdjustmentRule("RENAL-ADJ-RENA-095", "RenalHypoglycemicAdjustment Medication #95", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-096", new RenalAdjustmentRule("RENAL-ADJ-RENA-096", "RenalHypoglycemicAdjustment Medication #96", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-097", new RenalAdjustmentRule("RENAL-ADJ-RENA-097", "RenalHypoglycemicAdjustment Medication #97", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-098", new RenalAdjustmentRule("RENAL-ADJ-RENA-098", "RenalHypoglycemicAdjustment Medication #98", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-099", new RenalAdjustmentRule("RENAL-ADJ-RENA-099", "RenalHypoglycemicAdjustment Medication #99", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-100", new RenalAdjustmentRule("RENAL-ADJ-RENA-100", "RenalHypoglycemicAdjustment Medication #100", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-101", new RenalAdjustmentRule("RENAL-ADJ-RENA-101", "RenalHypoglycemicAdjustment Medication #101", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-102", new RenalAdjustmentRule("RENAL-ADJ-RENA-102", "RenalHypoglycemicAdjustment Medication #102", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-103", new RenalAdjustmentRule("RENAL-ADJ-RENA-103", "RenalHypoglycemicAdjustment Medication #103", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-104", new RenalAdjustmentRule("RENAL-ADJ-RENA-104", "RenalHypoglycemicAdjustment Medication #104", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-105", new RenalAdjustmentRule("RENAL-ADJ-RENA-105", "RenalHypoglycemicAdjustment Medication #105", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-106", new RenalAdjustmentRule("RENAL-ADJ-RENA-106", "RenalHypoglycemicAdjustment Medication #106", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-107", new RenalAdjustmentRule("RENAL-ADJ-RENA-107", "RenalHypoglycemicAdjustment Medication #107", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-108", new RenalAdjustmentRule("RENAL-ADJ-RENA-108", "RenalHypoglycemicAdjustment Medication #108", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-109", new RenalAdjustmentRule("RENAL-ADJ-RENA-109", "RenalHypoglycemicAdjustment Medication #109", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-110", new RenalAdjustmentRule("RENAL-ADJ-RENA-110", "RenalHypoglycemicAdjustment Medication #110", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-111", new RenalAdjustmentRule("RENAL-ADJ-RENA-111", "RenalHypoglycemicAdjustment Medication #111", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-112", new RenalAdjustmentRule("RENAL-ADJ-RENA-112", "RenalHypoglycemicAdjustment Medication #112", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-113", new RenalAdjustmentRule("RENAL-ADJ-RENA-113", "RenalHypoglycemicAdjustment Medication #113", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-114", new RenalAdjustmentRule("RENAL-ADJ-RENA-114", "RenalHypoglycemicAdjustment Medication #114", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-115", new RenalAdjustmentRule("RENAL-ADJ-RENA-115", "RenalHypoglycemicAdjustment Medication #115", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-116", new RenalAdjustmentRule("RENAL-ADJ-RENA-116", "RenalHypoglycemicAdjustment Medication #116", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-117", new RenalAdjustmentRule("RENAL-ADJ-RENA-117", "RenalHypoglycemicAdjustment Medication #117", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-118", new RenalAdjustmentRule("RENAL-ADJ-RENA-118", "RenalHypoglycemicAdjustment Medication #118", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-119", new RenalAdjustmentRule("RENAL-ADJ-RENA-119", "RenalHypoglycemicAdjustment Medication #119", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-120", new RenalAdjustmentRule("RENAL-ADJ-RENA-120", "RenalHypoglycemicAdjustment Medication #120", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
    }

    public Optional<RenalAdjustmentRule> findByCode(String code) {
        return Optional.ofNullable(adjustments.get(code));
    }

    public List<RenalAdjustmentRule> getAllRules() {
        return new ArrayList<>(adjustments.values());
    }
}
