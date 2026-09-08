package com.hospital.ontology.pharmacology;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RenalAnticoagulantAdjustmentMatrix {

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

    public RenalAnticoagulantAdjustmentMatrix() {
        initializeRules();
    }

    private void initializeRules() {
        adjustments.put("RENAL-ADJ-RENA-001", new RenalAdjustmentRule("RENAL-ADJ-RENA-001", "RenalAnticoagulantAdjustment Medication #1", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-002", new RenalAdjustmentRule("RENAL-ADJ-RENA-002", "RenalAnticoagulantAdjustment Medication #2", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-003", new RenalAdjustmentRule("RENAL-ADJ-RENA-003", "RenalAnticoagulantAdjustment Medication #3", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-004", new RenalAdjustmentRule("RENAL-ADJ-RENA-004", "RenalAnticoagulantAdjustment Medication #4", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-005", new RenalAdjustmentRule("RENAL-ADJ-RENA-005", "RenalAnticoagulantAdjustment Medication #5", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-006", new RenalAdjustmentRule("RENAL-ADJ-RENA-006", "RenalAnticoagulantAdjustment Medication #6", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-007", new RenalAdjustmentRule("RENAL-ADJ-RENA-007", "RenalAnticoagulantAdjustment Medication #7", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-008", new RenalAdjustmentRule("RENAL-ADJ-RENA-008", "RenalAnticoagulantAdjustment Medication #8", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-009", new RenalAdjustmentRule("RENAL-ADJ-RENA-009", "RenalAnticoagulantAdjustment Medication #9", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-010", new RenalAdjustmentRule("RENAL-ADJ-RENA-010", "RenalAnticoagulantAdjustment Medication #10", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-011", new RenalAdjustmentRule("RENAL-ADJ-RENA-011", "RenalAnticoagulantAdjustment Medication #11", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-012", new RenalAdjustmentRule("RENAL-ADJ-RENA-012", "RenalAnticoagulantAdjustment Medication #12", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-013", new RenalAdjustmentRule("RENAL-ADJ-RENA-013", "RenalAnticoagulantAdjustment Medication #13", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-014", new RenalAdjustmentRule("RENAL-ADJ-RENA-014", "RenalAnticoagulantAdjustment Medication #14", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-015", new RenalAdjustmentRule("RENAL-ADJ-RENA-015", "RenalAnticoagulantAdjustment Medication #15", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-016", new RenalAdjustmentRule("RENAL-ADJ-RENA-016", "RenalAnticoagulantAdjustment Medication #16", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-017", new RenalAdjustmentRule("RENAL-ADJ-RENA-017", "RenalAnticoagulantAdjustment Medication #17", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-018", new RenalAdjustmentRule("RENAL-ADJ-RENA-018", "RenalAnticoagulantAdjustment Medication #18", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-019", new RenalAdjustmentRule("RENAL-ADJ-RENA-019", "RenalAnticoagulantAdjustment Medication #19", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-020", new RenalAdjustmentRule("RENAL-ADJ-RENA-020", "RenalAnticoagulantAdjustment Medication #20", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-021", new RenalAdjustmentRule("RENAL-ADJ-RENA-021", "RenalAnticoagulantAdjustment Medication #21", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-022", new RenalAdjustmentRule("RENAL-ADJ-RENA-022", "RenalAnticoagulantAdjustment Medication #22", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-023", new RenalAdjustmentRule("RENAL-ADJ-RENA-023", "RenalAnticoagulantAdjustment Medication #23", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-024", new RenalAdjustmentRule("RENAL-ADJ-RENA-024", "RenalAnticoagulantAdjustment Medication #24", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-025", new RenalAdjustmentRule("RENAL-ADJ-RENA-025", "RenalAnticoagulantAdjustment Medication #25", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-026", new RenalAdjustmentRule("RENAL-ADJ-RENA-026", "RenalAnticoagulantAdjustment Medication #26", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-027", new RenalAdjustmentRule("RENAL-ADJ-RENA-027", "RenalAnticoagulantAdjustment Medication #27", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-028", new RenalAdjustmentRule("RENAL-ADJ-RENA-028", "RenalAnticoagulantAdjustment Medication #28", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-029", new RenalAdjustmentRule("RENAL-ADJ-RENA-029", "RenalAnticoagulantAdjustment Medication #29", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-030", new RenalAdjustmentRule("RENAL-ADJ-RENA-030", "RenalAnticoagulantAdjustment Medication #30", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-031", new RenalAdjustmentRule("RENAL-ADJ-RENA-031", "RenalAnticoagulantAdjustment Medication #31", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-032", new RenalAdjustmentRule("RENAL-ADJ-RENA-032", "RenalAnticoagulantAdjustment Medication #32", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-033", new RenalAdjustmentRule("RENAL-ADJ-RENA-033", "RenalAnticoagulantAdjustment Medication #33", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-034", new RenalAdjustmentRule("RENAL-ADJ-RENA-034", "RenalAnticoagulantAdjustment Medication #34", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-035", new RenalAdjustmentRule("RENAL-ADJ-RENA-035", "RenalAnticoagulantAdjustment Medication #35", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-036", new RenalAdjustmentRule("RENAL-ADJ-RENA-036", "RenalAnticoagulantAdjustment Medication #36", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-037", new RenalAdjustmentRule("RENAL-ADJ-RENA-037", "RenalAnticoagulantAdjustment Medication #37", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-038", new RenalAdjustmentRule("RENAL-ADJ-RENA-038", "RenalAnticoagulantAdjustment Medication #38", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-039", new RenalAdjustmentRule("RENAL-ADJ-RENA-039", "RenalAnticoagulantAdjustment Medication #39", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-040", new RenalAdjustmentRule("RENAL-ADJ-RENA-040", "RenalAnticoagulantAdjustment Medication #40", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-041", new RenalAdjustmentRule("RENAL-ADJ-RENA-041", "RenalAnticoagulantAdjustment Medication #41", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-042", new RenalAdjustmentRule("RENAL-ADJ-RENA-042", "RenalAnticoagulantAdjustment Medication #42", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-043", new RenalAdjustmentRule("RENAL-ADJ-RENA-043", "RenalAnticoagulantAdjustment Medication #43", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-044", new RenalAdjustmentRule("RENAL-ADJ-RENA-044", "RenalAnticoagulantAdjustment Medication #44", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-045", new RenalAdjustmentRule("RENAL-ADJ-RENA-045", "RenalAnticoagulantAdjustment Medication #45", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-046", new RenalAdjustmentRule("RENAL-ADJ-RENA-046", "RenalAnticoagulantAdjustment Medication #46", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-047", new RenalAdjustmentRule("RENAL-ADJ-RENA-047", "RenalAnticoagulantAdjustment Medication #47", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-048", new RenalAdjustmentRule("RENAL-ADJ-RENA-048", "RenalAnticoagulantAdjustment Medication #48", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-049", new RenalAdjustmentRule("RENAL-ADJ-RENA-049", "RenalAnticoagulantAdjustment Medication #49", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-050", new RenalAdjustmentRule("RENAL-ADJ-RENA-050", "RenalAnticoagulantAdjustment Medication #50", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-051", new RenalAdjustmentRule("RENAL-ADJ-RENA-051", "RenalAnticoagulantAdjustment Medication #51", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-052", new RenalAdjustmentRule("RENAL-ADJ-RENA-052", "RenalAnticoagulantAdjustment Medication #52", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-053", new RenalAdjustmentRule("RENAL-ADJ-RENA-053", "RenalAnticoagulantAdjustment Medication #53", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-054", new RenalAdjustmentRule("RENAL-ADJ-RENA-054", "RenalAnticoagulantAdjustment Medication #54", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-055", new RenalAdjustmentRule("RENAL-ADJ-RENA-055", "RenalAnticoagulantAdjustment Medication #55", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-056", new RenalAdjustmentRule("RENAL-ADJ-RENA-056", "RenalAnticoagulantAdjustment Medication #56", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-057", new RenalAdjustmentRule("RENAL-ADJ-RENA-057", "RenalAnticoagulantAdjustment Medication #57", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-058", new RenalAdjustmentRule("RENAL-ADJ-RENA-058", "RenalAnticoagulantAdjustment Medication #58", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-059", new RenalAdjustmentRule("RENAL-ADJ-RENA-059", "RenalAnticoagulantAdjustment Medication #59", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-060", new RenalAdjustmentRule("RENAL-ADJ-RENA-060", "RenalAnticoagulantAdjustment Medication #60", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-061", new RenalAdjustmentRule("RENAL-ADJ-RENA-061", "RenalAnticoagulantAdjustment Medication #61", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-062", new RenalAdjustmentRule("RENAL-ADJ-RENA-062", "RenalAnticoagulantAdjustment Medication #62", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-063", new RenalAdjustmentRule("RENAL-ADJ-RENA-063", "RenalAnticoagulantAdjustment Medication #63", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-064", new RenalAdjustmentRule("RENAL-ADJ-RENA-064", "RenalAnticoagulantAdjustment Medication #64", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-065", new RenalAdjustmentRule("RENAL-ADJ-RENA-065", "RenalAnticoagulantAdjustment Medication #65", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-066", new RenalAdjustmentRule("RENAL-ADJ-RENA-066", "RenalAnticoagulantAdjustment Medication #66", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-067", new RenalAdjustmentRule("RENAL-ADJ-RENA-067", "RenalAnticoagulantAdjustment Medication #67", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-068", new RenalAdjustmentRule("RENAL-ADJ-RENA-068", "RenalAnticoagulantAdjustment Medication #68", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-069", new RenalAdjustmentRule("RENAL-ADJ-RENA-069", "RenalAnticoagulantAdjustment Medication #69", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-070", new RenalAdjustmentRule("RENAL-ADJ-RENA-070", "RenalAnticoagulantAdjustment Medication #70", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-071", new RenalAdjustmentRule("RENAL-ADJ-RENA-071", "RenalAnticoagulantAdjustment Medication #71", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-072", new RenalAdjustmentRule("RENAL-ADJ-RENA-072", "RenalAnticoagulantAdjustment Medication #72", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-073", new RenalAdjustmentRule("RENAL-ADJ-RENA-073", "RenalAnticoagulantAdjustment Medication #73", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-074", new RenalAdjustmentRule("RENAL-ADJ-RENA-074", "RenalAnticoagulantAdjustment Medication #74", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-075", new RenalAdjustmentRule("RENAL-ADJ-RENA-075", "RenalAnticoagulantAdjustment Medication #75", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-076", new RenalAdjustmentRule("RENAL-ADJ-RENA-076", "RenalAnticoagulantAdjustment Medication #76", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-077", new RenalAdjustmentRule("RENAL-ADJ-RENA-077", "RenalAnticoagulantAdjustment Medication #77", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-078", new RenalAdjustmentRule("RENAL-ADJ-RENA-078", "RenalAnticoagulantAdjustment Medication #78", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-079", new RenalAdjustmentRule("RENAL-ADJ-RENA-079", "RenalAnticoagulantAdjustment Medication #79", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-080", new RenalAdjustmentRule("RENAL-ADJ-RENA-080", "RenalAnticoagulantAdjustment Medication #80", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-081", new RenalAdjustmentRule("RENAL-ADJ-RENA-081", "RenalAnticoagulantAdjustment Medication #81", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-082", new RenalAdjustmentRule("RENAL-ADJ-RENA-082", "RenalAnticoagulantAdjustment Medication #82", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-083", new RenalAdjustmentRule("RENAL-ADJ-RENA-083", "RenalAnticoagulantAdjustment Medication #83", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-084", new RenalAdjustmentRule("RENAL-ADJ-RENA-084", "RenalAnticoagulantAdjustment Medication #84", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-085", new RenalAdjustmentRule("RENAL-ADJ-RENA-085", "RenalAnticoagulantAdjustment Medication #85", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-086", new RenalAdjustmentRule("RENAL-ADJ-RENA-086", "RenalAnticoagulantAdjustment Medication #86", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-087", new RenalAdjustmentRule("RENAL-ADJ-RENA-087", "RenalAnticoagulantAdjustment Medication #87", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-088", new RenalAdjustmentRule("RENAL-ADJ-RENA-088", "RenalAnticoagulantAdjustment Medication #88", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-089", new RenalAdjustmentRule("RENAL-ADJ-RENA-089", "RenalAnticoagulantAdjustment Medication #89", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-090", new RenalAdjustmentRule("RENAL-ADJ-RENA-090", "RenalAnticoagulantAdjustment Medication #90", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-091", new RenalAdjustmentRule("RENAL-ADJ-RENA-091", "RenalAnticoagulantAdjustment Medication #91", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-092", new RenalAdjustmentRule("RENAL-ADJ-RENA-092", "RenalAnticoagulantAdjustment Medication #92", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-093", new RenalAdjustmentRule("RENAL-ADJ-RENA-093", "RenalAnticoagulantAdjustment Medication #93", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-094", new RenalAdjustmentRule("RENAL-ADJ-RENA-094", "RenalAnticoagulantAdjustment Medication #94", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-095", new RenalAdjustmentRule("RENAL-ADJ-RENA-095", "RenalAnticoagulantAdjustment Medication #95", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-096", new RenalAdjustmentRule("RENAL-ADJ-RENA-096", "RenalAnticoagulantAdjustment Medication #96", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-097", new RenalAdjustmentRule("RENAL-ADJ-RENA-097", "RenalAnticoagulantAdjustment Medication #97", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-098", new RenalAdjustmentRule("RENAL-ADJ-RENA-098", "RenalAnticoagulantAdjustment Medication #98", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-099", new RenalAdjustmentRule("RENAL-ADJ-RENA-099", "RenalAnticoagulantAdjustment Medication #99", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-100", new RenalAdjustmentRule("RENAL-ADJ-RENA-100", "RenalAnticoagulantAdjustment Medication #100", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-101", new RenalAdjustmentRule("RENAL-ADJ-RENA-101", "RenalAnticoagulantAdjustment Medication #101", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-102", new RenalAdjustmentRule("RENAL-ADJ-RENA-102", "RenalAnticoagulantAdjustment Medication #102", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-103", new RenalAdjustmentRule("RENAL-ADJ-RENA-103", "RenalAnticoagulantAdjustment Medication #103", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-104", new RenalAdjustmentRule("RENAL-ADJ-RENA-104", "RenalAnticoagulantAdjustment Medication #104", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-105", new RenalAdjustmentRule("RENAL-ADJ-RENA-105", "RenalAnticoagulantAdjustment Medication #105", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-106", new RenalAdjustmentRule("RENAL-ADJ-RENA-106", "RenalAnticoagulantAdjustment Medication #106", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-107", new RenalAdjustmentRule("RENAL-ADJ-RENA-107", "RenalAnticoagulantAdjustment Medication #107", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-108", new RenalAdjustmentRule("RENAL-ADJ-RENA-108", "RenalAnticoagulantAdjustment Medication #108", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-109", new RenalAdjustmentRule("RENAL-ADJ-RENA-109", "RenalAnticoagulantAdjustment Medication #109", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-110", new RenalAdjustmentRule("RENAL-ADJ-RENA-110", "RenalAnticoagulantAdjustment Medication #110", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-111", new RenalAdjustmentRule("RENAL-ADJ-RENA-111", "RenalAnticoagulantAdjustment Medication #111", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-112", new RenalAdjustmentRule("RENAL-ADJ-RENA-112", "RenalAnticoagulantAdjustment Medication #112", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-113", new RenalAdjustmentRule("RENAL-ADJ-RENA-113", "RenalAnticoagulantAdjustment Medication #113", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-114", new RenalAdjustmentRule("RENAL-ADJ-RENA-114", "RenalAnticoagulantAdjustment Medication #114", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-115", new RenalAdjustmentRule("RENAL-ADJ-RENA-115", "RenalAnticoagulantAdjustment Medication #115", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-116", new RenalAdjustmentRule("RENAL-ADJ-RENA-116", "RenalAnticoagulantAdjustment Medication #116", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-117", new RenalAdjustmentRule("RENAL-ADJ-RENA-117", "RenalAnticoagulantAdjustment Medication #117", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-118", new RenalAdjustmentRule("RENAL-ADJ-RENA-118", "RenalAnticoagulantAdjustment Medication #118", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-119", new RenalAdjustmentRule("RENAL-ADJ-RENA-119", "RenalAnticoagulantAdjustment Medication #119", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
        adjustments.put("RENAL-ADJ-RENA-120", new RenalAdjustmentRule("RENAL-ADJ-RENA-120", "RenalAnticoagulantAdjustment Medication #120", "CrCl > 50: 100%", "CrCl 30-50: 50% Q12H", "CrCl 15-29: 50% Q24H", "CrCl < 15 / HD: 25% post-dialysis", true));
    }

    public Optional<RenalAdjustmentRule> findByCode(String code) {
        return Optional.ofNullable(adjustments.get(code));
    }

    public List<RenalAdjustmentRule> getAllRules() {
        return new ArrayList<>(adjustments.values());
    }
}
