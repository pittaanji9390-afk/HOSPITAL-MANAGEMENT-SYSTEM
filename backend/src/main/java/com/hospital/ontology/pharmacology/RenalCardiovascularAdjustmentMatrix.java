package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RenalCardiovascularAdjustmentMatrix {

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

    public RenalCardiovascularAdjustmentMatrix() {
        initializeRules();
    }

    private void initializeRules() {
        adjustments.put("RENAL-ADJ-RENA-001", new RenalAdjustmentRule("RENAL-ADJ-RENA-001", "RenalCardiovascularAdjustment Medication #1", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-002", new RenalAdjustmentRule("RENAL-ADJ-RENA-002", "RenalCardiovascularAdjustment Medication #2", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-003", new RenalAdjustmentRule("RENAL-ADJ-RENA-003", "RenalCardiovascularAdjustment Medication #3", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-004", new RenalAdjustmentRule("RENAL-ADJ-RENA-004", "RenalCardiovascularAdjustment Medication #4", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-005", new RenalAdjustmentRule("RENAL-ADJ-RENA-005", "RenalCardiovascularAdjustment Medication #5", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-006", new RenalAdjustmentRule("RENAL-ADJ-RENA-006", "RenalCardiovascularAdjustment Medication #6", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-007", new RenalAdjustmentRule("RENAL-ADJ-RENA-007", "RenalCardiovascularAdjustment Medication #7", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-008", new RenalAdjustmentRule("RENAL-ADJ-RENA-008", "RenalCardiovascularAdjustment Medication #8", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-009", new RenalAdjustmentRule("RENAL-ADJ-RENA-009", "RenalCardiovascularAdjustment Medication #9", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-010", new RenalAdjustmentRule("RENAL-ADJ-RENA-010", "RenalCardiovascularAdjustment Medication #10", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-011", new RenalAdjustmentRule("RENAL-ADJ-RENA-011", "RenalCardiovascularAdjustment Medication #11", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-012", new RenalAdjustmentRule("RENAL-ADJ-RENA-012", "RenalCardiovascularAdjustment Medication #12", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-013", new RenalAdjustmentRule("RENAL-ADJ-RENA-013", "RenalCardiovascularAdjustment Medication #13", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-014", new RenalAdjustmentRule("RENAL-ADJ-RENA-014", "RenalCardiovascularAdjustment Medication #14", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-015", new RenalAdjustmentRule("RENAL-ADJ-RENA-015", "RenalCardiovascularAdjustment Medication #15", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-016", new RenalAdjustmentRule("RENAL-ADJ-RENA-016", "RenalCardiovascularAdjustment Medication #16", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-017", new RenalAdjustmentRule("RENAL-ADJ-RENA-017", "RenalCardiovascularAdjustment Medication #17", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-018", new RenalAdjustmentRule("RENAL-ADJ-RENA-018", "RenalCardiovascularAdjustment Medication #18", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-019", new RenalAdjustmentRule("RENAL-ADJ-RENA-019", "RenalCardiovascularAdjustment Medication #19", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-020", new RenalAdjustmentRule("RENAL-ADJ-RENA-020", "RenalCardiovascularAdjustment Medication #20", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-021", new RenalAdjustmentRule("RENAL-ADJ-RENA-021", "RenalCardiovascularAdjustment Medication #21", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-022", new RenalAdjustmentRule("RENAL-ADJ-RENA-022", "RenalCardiovascularAdjustment Medication #22", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-023", new RenalAdjustmentRule("RENAL-ADJ-RENA-023", "RenalCardiovascularAdjustment Medication #23", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-024", new RenalAdjustmentRule("RENAL-ADJ-RENA-024", "RenalCardiovascularAdjustment Medication #24", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-025", new RenalAdjustmentRule("RENAL-ADJ-RENA-025", "RenalCardiovascularAdjustment Medication #25", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-026", new RenalAdjustmentRule("RENAL-ADJ-RENA-026", "RenalCardiovascularAdjustment Medication #26", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-027", new RenalAdjustmentRule("RENAL-ADJ-RENA-027", "RenalCardiovascularAdjustment Medication #27", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-028", new RenalAdjustmentRule("RENAL-ADJ-RENA-028", "RenalCardiovascularAdjustment Medication #28", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-029", new RenalAdjustmentRule("RENAL-ADJ-RENA-029", "RenalCardiovascularAdjustment Medication #29", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-030", new RenalAdjustmentRule("RENAL-ADJ-RENA-030", "RenalCardiovascularAdjustment Medication #30", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-031", new RenalAdjustmentRule("RENAL-ADJ-RENA-031", "RenalCardiovascularAdjustment Medication #31", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-032", new RenalAdjustmentRule("RENAL-ADJ-RENA-032", "RenalCardiovascularAdjustment Medication #32", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-033", new RenalAdjustmentRule("RENAL-ADJ-RENA-033", "RenalCardiovascularAdjustment Medication #33", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-034", new RenalAdjustmentRule("RENAL-ADJ-RENA-034", "RenalCardiovascularAdjustment Medication #34", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-035", new RenalAdjustmentRule("RENAL-ADJ-RENA-035", "RenalCardiovascularAdjustment Medication #35", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-036", new RenalAdjustmentRule("RENAL-ADJ-RENA-036", "RenalCardiovascularAdjustment Medication #36", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-037", new RenalAdjustmentRule("RENAL-ADJ-RENA-037", "RenalCardiovascularAdjustment Medication #37", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-038", new RenalAdjustmentRule("RENAL-ADJ-RENA-038", "RenalCardiovascularAdjustment Medication #38", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-039", new RenalAdjustmentRule("RENAL-ADJ-RENA-039", "RenalCardiovascularAdjustment Medication #39", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-040", new RenalAdjustmentRule("RENAL-ADJ-RENA-040", "RenalCardiovascularAdjustment Medication #40", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-041", new RenalAdjustmentRule("RENAL-ADJ-RENA-041", "RenalCardiovascularAdjustment Medication #41", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-042", new RenalAdjustmentRule("RENAL-ADJ-RENA-042", "RenalCardiovascularAdjustment Medication #42", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-043", new RenalAdjustmentRule("RENAL-ADJ-RENA-043", "RenalCardiovascularAdjustment Medication #43", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-044", new RenalAdjustmentRule("RENAL-ADJ-RENA-044", "RenalCardiovascularAdjustment Medication #44", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-045", new RenalAdjustmentRule("RENAL-ADJ-RENA-045", "RenalCardiovascularAdjustment Medication #45", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-046", new RenalAdjustmentRule("RENAL-ADJ-RENA-046", "RenalCardiovascularAdjustment Medication #46", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-047", new RenalAdjustmentRule("RENAL-ADJ-RENA-047", "RenalCardiovascularAdjustment Medication #47", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-048", new RenalAdjustmentRule("RENAL-ADJ-RENA-048", "RenalCardiovascularAdjustment Medication #48", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-049", new RenalAdjustmentRule("RENAL-ADJ-RENA-049", "RenalCardiovascularAdjustment Medication #49", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-050", new RenalAdjustmentRule("RENAL-ADJ-RENA-050", "RenalCardiovascularAdjustment Medication #50", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-051", new RenalAdjustmentRule("RENAL-ADJ-RENA-051", "RenalCardiovascularAdjustment Medication #51", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-052", new RenalAdjustmentRule("RENAL-ADJ-RENA-052", "RenalCardiovascularAdjustment Medication #52", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-053", new RenalAdjustmentRule("RENAL-ADJ-RENA-053", "RenalCardiovascularAdjustment Medication #53", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-054", new RenalAdjustmentRule("RENAL-ADJ-RENA-054", "RenalCardiovascularAdjustment Medication #54", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-055", new RenalAdjustmentRule("RENAL-ADJ-RENA-055", "RenalCardiovascularAdjustment Medication #55", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-056", new RenalAdjustmentRule("RENAL-ADJ-RENA-056", "RenalCardiovascularAdjustment Medication #56", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-057", new RenalAdjustmentRule("RENAL-ADJ-RENA-057", "RenalCardiovascularAdjustment Medication #57", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-058", new RenalAdjustmentRule("RENAL-ADJ-RENA-058", "RenalCardiovascularAdjustment Medication #58", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-059", new RenalAdjustmentRule("RENAL-ADJ-RENA-059", "RenalCardiovascularAdjustment Medication #59", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-060", new RenalAdjustmentRule("RENAL-ADJ-RENA-060", "RenalCardiovascularAdjustment Medication #60", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-061", new RenalAdjustmentRule("RENAL-ADJ-RENA-061", "RenalCardiovascularAdjustment Medication #61", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-062", new RenalAdjustmentRule("RENAL-ADJ-RENA-062", "RenalCardiovascularAdjustment Medication #62", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-063", new RenalAdjustmentRule("RENAL-ADJ-RENA-063", "RenalCardiovascularAdjustment Medication #63", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-064", new RenalAdjustmentRule("RENAL-ADJ-RENA-064", "RenalCardiovascularAdjustment Medication #64", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-065", new RenalAdjustmentRule("RENAL-ADJ-RENA-065", "RenalCardiovascularAdjustment Medication #65", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-066", new RenalAdjustmentRule("RENAL-ADJ-RENA-066", "RenalCardiovascularAdjustment Medication #66", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-067", new RenalAdjustmentRule("RENAL-ADJ-RENA-067", "RenalCardiovascularAdjustment Medication #67", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-068", new RenalAdjustmentRule("RENAL-ADJ-RENA-068", "RenalCardiovascularAdjustment Medication #68", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-069", new RenalAdjustmentRule("RENAL-ADJ-RENA-069", "RenalCardiovascularAdjustment Medication #69", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-070", new RenalAdjustmentRule("RENAL-ADJ-RENA-070", "RenalCardiovascularAdjustment Medication #70", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-071", new RenalAdjustmentRule("RENAL-ADJ-RENA-071", "RenalCardiovascularAdjustment Medication #71", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-072", new RenalAdjustmentRule("RENAL-ADJ-RENA-072", "RenalCardiovascularAdjustment Medication #72", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-073", new RenalAdjustmentRule("RENAL-ADJ-RENA-073", "RenalCardiovascularAdjustment Medication #73", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-074", new RenalAdjustmentRule("RENAL-ADJ-RENA-074", "RenalCardiovascularAdjustment Medication #74", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-075", new RenalAdjustmentRule("RENAL-ADJ-RENA-075", "RenalCardiovascularAdjustment Medication #75", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-076", new RenalAdjustmentRule("RENAL-ADJ-RENA-076", "RenalCardiovascularAdjustment Medication #76", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-077", new RenalAdjustmentRule("RENAL-ADJ-RENA-077", "RenalCardiovascularAdjustment Medication #77", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-078", new RenalAdjustmentRule("RENAL-ADJ-RENA-078", "RenalCardiovascularAdjustment Medication #78", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-079", new RenalAdjustmentRule("RENAL-ADJ-RENA-079", "RenalCardiovascularAdjustment Medication #79", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-080", new RenalAdjustmentRule("RENAL-ADJ-RENA-080", "RenalCardiovascularAdjustment Medication #80", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-081", new RenalAdjustmentRule("RENAL-ADJ-RENA-081", "RenalCardiovascularAdjustment Medication #81", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-082", new RenalAdjustmentRule("RENAL-ADJ-RENA-082", "RenalCardiovascularAdjustment Medication #82", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-083", new RenalAdjustmentRule("RENAL-ADJ-RENA-083", "RenalCardiovascularAdjustment Medication #83", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-084", new RenalAdjustmentRule("RENAL-ADJ-RENA-084", "RenalCardiovascularAdjustment Medication #84", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-085", new RenalAdjustmentRule("RENAL-ADJ-RENA-085", "RenalCardiovascularAdjustment Medication #85", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-086", new RenalAdjustmentRule("RENAL-ADJ-RENA-086", "RenalCardiovascularAdjustment Medication #86", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-087", new RenalAdjustmentRule("RENAL-ADJ-RENA-087", "RenalCardiovascularAdjustment Medication #87", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-088", new RenalAdjustmentRule("RENAL-ADJ-RENA-088", "RenalCardiovascularAdjustment Medication #88", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-089", new RenalAdjustmentRule("RENAL-ADJ-RENA-089", "RenalCardiovascularAdjustment Medication #89", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-090", new RenalAdjustmentRule("RENAL-ADJ-RENA-090", "RenalCardiovascularAdjustment Medication #90", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-091", new RenalAdjustmentRule("RENAL-ADJ-RENA-091", "RenalCardiovascularAdjustment Medication #91", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-092", new RenalAdjustmentRule("RENAL-ADJ-RENA-092", "RenalCardiovascularAdjustment Medication #92", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-093", new RenalAdjustmentRule("RENAL-ADJ-RENA-093", "RenalCardiovascularAdjustment Medication #93", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-094", new RenalAdjustmentRule("RENAL-ADJ-RENA-094", "RenalCardiovascularAdjustment Medication #94", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-095", new RenalAdjustmentRule("RENAL-ADJ-RENA-095", "RenalCardiovascularAdjustment Medication #95", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-096", new RenalAdjustmentRule("RENAL-ADJ-RENA-096", "RenalCardiovascularAdjustment Medication #96", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-097", new RenalAdjustmentRule("RENAL-ADJ-RENA-097", "RenalCardiovascularAdjustment Medication #97", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-098", new RenalAdjustmentRule("RENAL-ADJ-RENA-098", "RenalCardiovascularAdjustment Medication #98", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-099", new RenalAdjustmentRule("RENAL-ADJ-RENA-099", "RenalCardiovascularAdjustment Medication #99", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-100", new RenalAdjustmentRule("RENAL-ADJ-RENA-100", "RenalCardiovascularAdjustment Medication #100", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-101", new RenalAdjustmentRule("RENAL-ADJ-RENA-101", "RenalCardiovascularAdjustment Medication #101", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-102", new RenalAdjustmentRule("RENAL-ADJ-RENA-102", "RenalCardiovascularAdjustment Medication #102", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-103", new RenalAdjustmentRule("RENAL-ADJ-RENA-103", "RenalCardiovascularAdjustment Medication #103", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-104", new RenalAdjustmentRule("RENAL-ADJ-RENA-104", "RenalCardiovascularAdjustment Medication #104", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-105", new RenalAdjustmentRule("RENAL-ADJ-RENA-105", "RenalCardiovascularAdjustment Medication #105", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-106", new RenalAdjustmentRule("RENAL-ADJ-RENA-106", "RenalCardiovascularAdjustment Medication #106", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-107", new RenalAdjustmentRule("RENAL-ADJ-RENA-107", "RenalCardiovascularAdjustment Medication #107", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-108", new RenalAdjustmentRule("RENAL-ADJ-RENA-108", "RenalCardiovascularAdjustment Medication #108", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-109", new RenalAdjustmentRule("RENAL-ADJ-RENA-109", "RenalCardiovascularAdjustment Medication #109", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-110", new RenalAdjustmentRule("RENAL-ADJ-RENA-110", "RenalCardiovascularAdjustment Medication #110", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-111", new RenalAdjustmentRule("RENAL-ADJ-RENA-111", "RenalCardiovascularAdjustment Medication #111", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-112", new RenalAdjustmentRule("RENAL-ADJ-RENA-112", "RenalCardiovascularAdjustment Medication #112", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-113", new RenalAdjustmentRule("RENAL-ADJ-RENA-113", "RenalCardiovascularAdjustment Medication #113", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-114", new RenalAdjustmentRule("RENAL-ADJ-RENA-114", "RenalCardiovascularAdjustment Medication #114", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-115", new RenalAdjustmentRule("RENAL-ADJ-RENA-115", "RenalCardiovascularAdjustment Medication #115", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-116", new RenalAdjustmentRule("RENAL-ADJ-RENA-116", "RenalCardiovascularAdjustment Medication #116", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-117", new RenalAdjustmentRule("RENAL-ADJ-RENA-117", "RenalCardiovascularAdjustment Medication #117", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-118", new RenalAdjustmentRule("RENAL-ADJ-RENA-118", "RenalCardiovascularAdjustment Medication #118", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-119", new RenalAdjustmentRule("RENAL-ADJ-RENA-119", "RenalCardiovascularAdjustment Medication #119", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-120", new RenalAdjustmentRule("RENAL-ADJ-RENA-120", "RenalCardiovascularAdjustment Medication #120", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
    }

    public Optional<RenalAdjustmentRule> findByCode(String code) {
        return Optional.ofNullable(adjustments.get(code));
    }

    public List<RenalAdjustmentRule> getAllRules() {
        return new ArrayList<>(adjustments.values());
    }
}
