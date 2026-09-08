package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Autoimmune, Immunoglobulins & Complement.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincImmunologyAndSerologyPanelKnowledgeBase {

    public enum CriticalAlertLevel {
        ROUTINE,
        ELEVATED,
        URGENT_PANIC
    }

    @Data
    @AllArgsConstructor
    public static class LoincTestItem {
        private String loincCode;
        private String testName;
        private String analyteIdentifier;
        private String normalReferenceRange;
        private String standardUnit;
        private String specimenType;
        private CriticalAlertLevel panicNotificationTier;
    }

    private final Map<String, LoincTestItem> tests = new LinkedHashMap<>();

    public LoincImmunologyAndSerologyPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("10601-2", new LoincTestItem("10601-2", "Autoimmune, Immunoglobulins & Complement Assay #1", "IMM-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10602-3", new LoincTestItem("10602-3", "Autoimmune, Immunoglobulins & Complement Assay #2", "IMM-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10603-4", new LoincTestItem("10603-4", "Autoimmune, Immunoglobulins & Complement Assay #3", "IMM-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10604-5", new LoincTestItem("10604-5", "Autoimmune, Immunoglobulins & Complement Assay #4", "IMM-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10605-6", new LoincTestItem("10605-6", "Autoimmune, Immunoglobulins & Complement Assay #5", "IMM-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10606-7", new LoincTestItem("10606-7", "Autoimmune, Immunoglobulins & Complement Assay #6", "IMM-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10607-8", new LoincTestItem("10607-8", "Autoimmune, Immunoglobulins & Complement Assay #7", "IMM-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10608-9", new LoincTestItem("10608-9", "Autoimmune, Immunoglobulins & Complement Assay #8", "IMM-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10609-1", new LoincTestItem("10609-1", "Autoimmune, Immunoglobulins & Complement Assay #9", "IMM-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10610-2", new LoincTestItem("10610-2", "Autoimmune, Immunoglobulins & Complement Assay #10", "IMM-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10611-3", new LoincTestItem("10611-3", "Autoimmune, Immunoglobulins & Complement Assay #11", "IMM-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10612-4", new LoincTestItem("10612-4", "Autoimmune, Immunoglobulins & Complement Assay #12", "IMM-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10613-5", new LoincTestItem("10613-5", "Autoimmune, Immunoglobulins & Complement Assay #13", "IMM-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10614-6", new LoincTestItem("10614-6", "Autoimmune, Immunoglobulins & Complement Assay #14", "IMM-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10615-7", new LoincTestItem("10615-7", "Autoimmune, Immunoglobulins & Complement Assay #15", "IMM-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10616-8", new LoincTestItem("10616-8", "Autoimmune, Immunoglobulins & Complement Assay #16", "IMM-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10617-9", new LoincTestItem("10617-9", "Autoimmune, Immunoglobulins & Complement Assay #17", "IMM-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10618-1", new LoincTestItem("10618-1", "Autoimmune, Immunoglobulins & Complement Assay #18", "IMM-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10619-2", new LoincTestItem("10619-2", "Autoimmune, Immunoglobulins & Complement Assay #19", "IMM-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10620-3", new LoincTestItem("10620-3", "Autoimmune, Immunoglobulins & Complement Assay #20", "IMM-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10621-4", new LoincTestItem("10621-4", "Autoimmune, Immunoglobulins & Complement Assay #21", "IMM-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10622-5", new LoincTestItem("10622-5", "Autoimmune, Immunoglobulins & Complement Assay #22", "IMM-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10623-6", new LoincTestItem("10623-6", "Autoimmune, Immunoglobulins & Complement Assay #23", "IMM-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10624-7", new LoincTestItem("10624-7", "Autoimmune, Immunoglobulins & Complement Assay #24", "IMM-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10625-8", new LoincTestItem("10625-8", "Autoimmune, Immunoglobulins & Complement Assay #25", "IMM-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10626-9", new LoincTestItem("10626-9", "Autoimmune, Immunoglobulins & Complement Assay #26", "IMM-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10627-1", new LoincTestItem("10627-1", "Autoimmune, Immunoglobulins & Complement Assay #27", "IMM-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10628-2", new LoincTestItem("10628-2", "Autoimmune, Immunoglobulins & Complement Assay #28", "IMM-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10629-3", new LoincTestItem("10629-3", "Autoimmune, Immunoglobulins & Complement Assay #29", "IMM-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10630-4", new LoincTestItem("10630-4", "Autoimmune, Immunoglobulins & Complement Assay #30", "IMM-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10631-5", new LoincTestItem("10631-5", "Autoimmune, Immunoglobulins & Complement Assay #31", "IMM-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10632-6", new LoincTestItem("10632-6", "Autoimmune, Immunoglobulins & Complement Assay #32", "IMM-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10633-7", new LoincTestItem("10633-7", "Autoimmune, Immunoglobulins & Complement Assay #33", "IMM-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10634-8", new LoincTestItem("10634-8", "Autoimmune, Immunoglobulins & Complement Assay #34", "IMM-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10635-9", new LoincTestItem("10635-9", "Autoimmune, Immunoglobulins & Complement Assay #35", "IMM-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10636-1", new LoincTestItem("10636-1", "Autoimmune, Immunoglobulins & Complement Assay #36", "IMM-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10637-2", new LoincTestItem("10637-2", "Autoimmune, Immunoglobulins & Complement Assay #37", "IMM-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10638-3", new LoincTestItem("10638-3", "Autoimmune, Immunoglobulins & Complement Assay #38", "IMM-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10639-4", new LoincTestItem("10639-4", "Autoimmune, Immunoglobulins & Complement Assay #39", "IMM-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10640-5", new LoincTestItem("10640-5", "Autoimmune, Immunoglobulins & Complement Assay #40", "IMM-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10641-6", new LoincTestItem("10641-6", "Autoimmune, Immunoglobulins & Complement Assay #41", "IMM-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10642-7", new LoincTestItem("10642-7", "Autoimmune, Immunoglobulins & Complement Assay #42", "IMM-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10643-8", new LoincTestItem("10643-8", "Autoimmune, Immunoglobulins & Complement Assay #43", "IMM-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10644-9", new LoincTestItem("10644-9", "Autoimmune, Immunoglobulins & Complement Assay #44", "IMM-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10645-1", new LoincTestItem("10645-1", "Autoimmune, Immunoglobulins & Complement Assay #45", "IMM-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10646-2", new LoincTestItem("10646-2", "Autoimmune, Immunoglobulins & Complement Assay #46", "IMM-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10647-3", new LoincTestItem("10647-3", "Autoimmune, Immunoglobulins & Complement Assay #47", "IMM-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10648-4", new LoincTestItem("10648-4", "Autoimmune, Immunoglobulins & Complement Assay #48", "IMM-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10649-5", new LoincTestItem("10649-5", "Autoimmune, Immunoglobulins & Complement Assay #49", "IMM-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10650-6", new LoincTestItem("10650-6", "Autoimmune, Immunoglobulins & Complement Assay #50", "IMM-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10651-7", new LoincTestItem("10651-7", "Autoimmune, Immunoglobulins & Complement Assay #51", "IMM-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10652-8", new LoincTestItem("10652-8", "Autoimmune, Immunoglobulins & Complement Assay #52", "IMM-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10653-9", new LoincTestItem("10653-9", "Autoimmune, Immunoglobulins & Complement Assay #53", "IMM-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10654-1", new LoincTestItem("10654-1", "Autoimmune, Immunoglobulins & Complement Assay #54", "IMM-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10655-2", new LoincTestItem("10655-2", "Autoimmune, Immunoglobulins & Complement Assay #55", "IMM-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10656-3", new LoincTestItem("10656-3", "Autoimmune, Immunoglobulins & Complement Assay #56", "IMM-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10657-4", new LoincTestItem("10657-4", "Autoimmune, Immunoglobulins & Complement Assay #57", "IMM-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10658-5", new LoincTestItem("10658-5", "Autoimmune, Immunoglobulins & Complement Assay #58", "IMM-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10659-6", new LoincTestItem("10659-6", "Autoimmune, Immunoglobulins & Complement Assay #59", "IMM-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10660-7", new LoincTestItem("10660-7", "Autoimmune, Immunoglobulins & Complement Assay #60", "IMM-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10661-8", new LoincTestItem("10661-8", "Autoimmune, Immunoglobulins & Complement Assay #61", "IMM-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10662-9", new LoincTestItem("10662-9", "Autoimmune, Immunoglobulins & Complement Assay #62", "IMM-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10663-1", new LoincTestItem("10663-1", "Autoimmune, Immunoglobulins & Complement Assay #63", "IMM-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10664-2", new LoincTestItem("10664-2", "Autoimmune, Immunoglobulins & Complement Assay #64", "IMM-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10665-3", new LoincTestItem("10665-3", "Autoimmune, Immunoglobulins & Complement Assay #65", "IMM-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10666-4", new LoincTestItem("10666-4", "Autoimmune, Immunoglobulins & Complement Assay #66", "IMM-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10667-5", new LoincTestItem("10667-5", "Autoimmune, Immunoglobulins & Complement Assay #67", "IMM-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10668-6", new LoincTestItem("10668-6", "Autoimmune, Immunoglobulins & Complement Assay #68", "IMM-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10669-7", new LoincTestItem("10669-7", "Autoimmune, Immunoglobulins & Complement Assay #69", "IMM-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10670-8", new LoincTestItem("10670-8", "Autoimmune, Immunoglobulins & Complement Assay #70", "IMM-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10671-9", new LoincTestItem("10671-9", "Autoimmune, Immunoglobulins & Complement Assay #71", "IMM-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10672-1", new LoincTestItem("10672-1", "Autoimmune, Immunoglobulins & Complement Assay #72", "IMM-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10673-2", new LoincTestItem("10673-2", "Autoimmune, Immunoglobulins & Complement Assay #73", "IMM-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10674-3", new LoincTestItem("10674-3", "Autoimmune, Immunoglobulins & Complement Assay #74", "IMM-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10675-4", new LoincTestItem("10675-4", "Autoimmune, Immunoglobulins & Complement Assay #75", "IMM-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10676-5", new LoincTestItem("10676-5", "Autoimmune, Immunoglobulins & Complement Assay #76", "IMM-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10677-6", new LoincTestItem("10677-6", "Autoimmune, Immunoglobulins & Complement Assay #77", "IMM-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10678-7", new LoincTestItem("10678-7", "Autoimmune, Immunoglobulins & Complement Assay #78", "IMM-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10679-8", new LoincTestItem("10679-8", "Autoimmune, Immunoglobulins & Complement Assay #79", "IMM-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10680-9", new LoincTestItem("10680-9", "Autoimmune, Immunoglobulins & Complement Assay #80", "IMM-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10681-1", new LoincTestItem("10681-1", "Autoimmune, Immunoglobulins & Complement Assay #81", "IMM-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10682-2", new LoincTestItem("10682-2", "Autoimmune, Immunoglobulins & Complement Assay #82", "IMM-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10683-3", new LoincTestItem("10683-3", "Autoimmune, Immunoglobulins & Complement Assay #83", "IMM-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10684-4", new LoincTestItem("10684-4", "Autoimmune, Immunoglobulins & Complement Assay #84", "IMM-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10685-5", new LoincTestItem("10685-5", "Autoimmune, Immunoglobulins & Complement Assay #85", "IMM-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10686-6", new LoincTestItem("10686-6", "Autoimmune, Immunoglobulins & Complement Assay #86", "IMM-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10687-7", new LoincTestItem("10687-7", "Autoimmune, Immunoglobulins & Complement Assay #87", "IMM-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10688-8", new LoincTestItem("10688-8", "Autoimmune, Immunoglobulins & Complement Assay #88", "IMM-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10689-9", new LoincTestItem("10689-9", "Autoimmune, Immunoglobulins & Complement Assay #89", "IMM-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10690-1", new LoincTestItem("10690-1", "Autoimmune, Immunoglobulins & Complement Assay #90", "IMM-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10691-2", new LoincTestItem("10691-2", "Autoimmune, Immunoglobulins & Complement Assay #91", "IMM-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10692-3", new LoincTestItem("10692-3", "Autoimmune, Immunoglobulins & Complement Assay #92", "IMM-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10693-4", new LoincTestItem("10693-4", "Autoimmune, Immunoglobulins & Complement Assay #93", "IMM-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10694-5", new LoincTestItem("10694-5", "Autoimmune, Immunoglobulins & Complement Assay #94", "IMM-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10695-6", new LoincTestItem("10695-6", "Autoimmune, Immunoglobulins & Complement Assay #95", "IMM-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10696-7", new LoincTestItem("10696-7", "Autoimmune, Immunoglobulins & Complement Assay #96", "IMM-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10697-8", new LoincTestItem("10697-8", "Autoimmune, Immunoglobulins & Complement Assay #97", "IMM-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10698-9", new LoincTestItem("10698-9", "Autoimmune, Immunoglobulins & Complement Assay #98", "IMM-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10699-1", new LoincTestItem("10699-1", "Autoimmune, Immunoglobulins & Complement Assay #99", "IMM-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10700-2", new LoincTestItem("10700-2", "Autoimmune, Immunoglobulins & Complement Assay #100", "IMM-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10701-3", new LoincTestItem("10701-3", "Autoimmune, Immunoglobulins & Complement Assay #101", "IMM-201", "151.50 - 424.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10702-4", new LoincTestItem("10702-4", "Autoimmune, Immunoglobulins & Complement Assay #102", "IMM-202", "153.00 - 428.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10703-5", new LoincTestItem("10703-5", "Autoimmune, Immunoglobulins & Complement Assay #103", "IMM-203", "154.50 - 432.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10704-6", new LoincTestItem("10704-6", "Autoimmune, Immunoglobulins & Complement Assay #104", "IMM-204", "156.00 - 436.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10705-7", new LoincTestItem("10705-7", "Autoimmune, Immunoglobulins & Complement Assay #105", "IMM-205", "157.50 - 441.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10706-8", new LoincTestItem("10706-8", "Autoimmune, Immunoglobulins & Complement Assay #106", "IMM-206", "159.00 - 445.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10707-9", new LoincTestItem("10707-9", "Autoimmune, Immunoglobulins & Complement Assay #107", "IMM-207", "160.50 - 449.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10708-1", new LoincTestItem("10708-1", "Autoimmune, Immunoglobulins & Complement Assay #108", "IMM-208", "162.00 - 453.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10709-2", new LoincTestItem("10709-2", "Autoimmune, Immunoglobulins & Complement Assay #109", "IMM-209", "163.50 - 457.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10710-3", new LoincTestItem("10710-3", "Autoimmune, Immunoglobulins & Complement Assay #110", "IMM-210", "165.00 - 462.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
