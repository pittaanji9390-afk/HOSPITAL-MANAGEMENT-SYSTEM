package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: ABG, Acid-Base & Co-oximetry.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincArterialBloodGasVentilatoryPanelKnowledgeBase {

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

    public LoincArterialBloodGasVentilatoryPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("11601-2", new LoincTestItem("11601-2", "ABG, Acid-Base & Co-oximetry Assay #1", "ABG-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11602-3", new LoincTestItem("11602-3", "ABG, Acid-Base & Co-oximetry Assay #2", "ABG-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11603-4", new LoincTestItem("11603-4", "ABG, Acid-Base & Co-oximetry Assay #3", "ABG-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11604-5", new LoincTestItem("11604-5", "ABG, Acid-Base & Co-oximetry Assay #4", "ABG-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11605-6", new LoincTestItem("11605-6", "ABG, Acid-Base & Co-oximetry Assay #5", "ABG-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11606-7", new LoincTestItem("11606-7", "ABG, Acid-Base & Co-oximetry Assay #6", "ABG-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11607-8", new LoincTestItem("11607-8", "ABG, Acid-Base & Co-oximetry Assay #7", "ABG-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11608-9", new LoincTestItem("11608-9", "ABG, Acid-Base & Co-oximetry Assay #8", "ABG-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11609-1", new LoincTestItem("11609-1", "ABG, Acid-Base & Co-oximetry Assay #9", "ABG-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11610-2", new LoincTestItem("11610-2", "ABG, Acid-Base & Co-oximetry Assay #10", "ABG-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11611-3", new LoincTestItem("11611-3", "ABG, Acid-Base & Co-oximetry Assay #11", "ABG-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11612-4", new LoincTestItem("11612-4", "ABG, Acid-Base & Co-oximetry Assay #12", "ABG-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11613-5", new LoincTestItem("11613-5", "ABG, Acid-Base & Co-oximetry Assay #13", "ABG-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11614-6", new LoincTestItem("11614-6", "ABG, Acid-Base & Co-oximetry Assay #14", "ABG-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11615-7", new LoincTestItem("11615-7", "ABG, Acid-Base & Co-oximetry Assay #15", "ABG-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11616-8", new LoincTestItem("11616-8", "ABG, Acid-Base & Co-oximetry Assay #16", "ABG-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11617-9", new LoincTestItem("11617-9", "ABG, Acid-Base & Co-oximetry Assay #17", "ABG-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11618-1", new LoincTestItem("11618-1", "ABG, Acid-Base & Co-oximetry Assay #18", "ABG-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11619-2", new LoincTestItem("11619-2", "ABG, Acid-Base & Co-oximetry Assay #19", "ABG-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11620-3", new LoincTestItem("11620-3", "ABG, Acid-Base & Co-oximetry Assay #20", "ABG-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11621-4", new LoincTestItem("11621-4", "ABG, Acid-Base & Co-oximetry Assay #21", "ABG-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11622-5", new LoincTestItem("11622-5", "ABG, Acid-Base & Co-oximetry Assay #22", "ABG-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11623-6", new LoincTestItem("11623-6", "ABG, Acid-Base & Co-oximetry Assay #23", "ABG-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11624-7", new LoincTestItem("11624-7", "ABG, Acid-Base & Co-oximetry Assay #24", "ABG-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11625-8", new LoincTestItem("11625-8", "ABG, Acid-Base & Co-oximetry Assay #25", "ABG-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11626-9", new LoincTestItem("11626-9", "ABG, Acid-Base & Co-oximetry Assay #26", "ABG-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11627-1", new LoincTestItem("11627-1", "ABG, Acid-Base & Co-oximetry Assay #27", "ABG-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11628-2", new LoincTestItem("11628-2", "ABG, Acid-Base & Co-oximetry Assay #28", "ABG-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11629-3", new LoincTestItem("11629-3", "ABG, Acid-Base & Co-oximetry Assay #29", "ABG-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11630-4", new LoincTestItem("11630-4", "ABG, Acid-Base & Co-oximetry Assay #30", "ABG-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11631-5", new LoincTestItem("11631-5", "ABG, Acid-Base & Co-oximetry Assay #31", "ABG-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11632-6", new LoincTestItem("11632-6", "ABG, Acid-Base & Co-oximetry Assay #32", "ABG-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11633-7", new LoincTestItem("11633-7", "ABG, Acid-Base & Co-oximetry Assay #33", "ABG-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11634-8", new LoincTestItem("11634-8", "ABG, Acid-Base & Co-oximetry Assay #34", "ABG-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11635-9", new LoincTestItem("11635-9", "ABG, Acid-Base & Co-oximetry Assay #35", "ABG-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11636-1", new LoincTestItem("11636-1", "ABG, Acid-Base & Co-oximetry Assay #36", "ABG-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11637-2", new LoincTestItem("11637-2", "ABG, Acid-Base & Co-oximetry Assay #37", "ABG-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11638-3", new LoincTestItem("11638-3", "ABG, Acid-Base & Co-oximetry Assay #38", "ABG-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11639-4", new LoincTestItem("11639-4", "ABG, Acid-Base & Co-oximetry Assay #39", "ABG-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11640-5", new LoincTestItem("11640-5", "ABG, Acid-Base & Co-oximetry Assay #40", "ABG-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11641-6", new LoincTestItem("11641-6", "ABG, Acid-Base & Co-oximetry Assay #41", "ABG-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11642-7", new LoincTestItem("11642-7", "ABG, Acid-Base & Co-oximetry Assay #42", "ABG-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11643-8", new LoincTestItem("11643-8", "ABG, Acid-Base & Co-oximetry Assay #43", "ABG-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11644-9", new LoincTestItem("11644-9", "ABG, Acid-Base & Co-oximetry Assay #44", "ABG-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11645-1", new LoincTestItem("11645-1", "ABG, Acid-Base & Co-oximetry Assay #45", "ABG-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11646-2", new LoincTestItem("11646-2", "ABG, Acid-Base & Co-oximetry Assay #46", "ABG-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11647-3", new LoincTestItem("11647-3", "ABG, Acid-Base & Co-oximetry Assay #47", "ABG-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11648-4", new LoincTestItem("11648-4", "ABG, Acid-Base & Co-oximetry Assay #48", "ABG-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11649-5", new LoincTestItem("11649-5", "ABG, Acid-Base & Co-oximetry Assay #49", "ABG-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11650-6", new LoincTestItem("11650-6", "ABG, Acid-Base & Co-oximetry Assay #50", "ABG-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11651-7", new LoincTestItem("11651-7", "ABG, Acid-Base & Co-oximetry Assay #51", "ABG-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11652-8", new LoincTestItem("11652-8", "ABG, Acid-Base & Co-oximetry Assay #52", "ABG-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11653-9", new LoincTestItem("11653-9", "ABG, Acid-Base & Co-oximetry Assay #53", "ABG-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11654-1", new LoincTestItem("11654-1", "ABG, Acid-Base & Co-oximetry Assay #54", "ABG-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11655-2", new LoincTestItem("11655-2", "ABG, Acid-Base & Co-oximetry Assay #55", "ABG-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11656-3", new LoincTestItem("11656-3", "ABG, Acid-Base & Co-oximetry Assay #56", "ABG-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11657-4", new LoincTestItem("11657-4", "ABG, Acid-Base & Co-oximetry Assay #57", "ABG-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11658-5", new LoincTestItem("11658-5", "ABG, Acid-Base & Co-oximetry Assay #58", "ABG-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11659-6", new LoincTestItem("11659-6", "ABG, Acid-Base & Co-oximetry Assay #59", "ABG-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11660-7", new LoincTestItem("11660-7", "ABG, Acid-Base & Co-oximetry Assay #60", "ABG-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11661-8", new LoincTestItem("11661-8", "ABG, Acid-Base & Co-oximetry Assay #61", "ABG-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11662-9", new LoincTestItem("11662-9", "ABG, Acid-Base & Co-oximetry Assay #62", "ABG-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11663-1", new LoincTestItem("11663-1", "ABG, Acid-Base & Co-oximetry Assay #63", "ABG-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11664-2", new LoincTestItem("11664-2", "ABG, Acid-Base & Co-oximetry Assay #64", "ABG-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11665-3", new LoincTestItem("11665-3", "ABG, Acid-Base & Co-oximetry Assay #65", "ABG-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11666-4", new LoincTestItem("11666-4", "ABG, Acid-Base & Co-oximetry Assay #66", "ABG-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11667-5", new LoincTestItem("11667-5", "ABG, Acid-Base & Co-oximetry Assay #67", "ABG-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11668-6", new LoincTestItem("11668-6", "ABG, Acid-Base & Co-oximetry Assay #68", "ABG-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11669-7", new LoincTestItem("11669-7", "ABG, Acid-Base & Co-oximetry Assay #69", "ABG-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11670-8", new LoincTestItem("11670-8", "ABG, Acid-Base & Co-oximetry Assay #70", "ABG-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11671-9", new LoincTestItem("11671-9", "ABG, Acid-Base & Co-oximetry Assay #71", "ABG-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11672-1", new LoincTestItem("11672-1", "ABG, Acid-Base & Co-oximetry Assay #72", "ABG-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11673-2", new LoincTestItem("11673-2", "ABG, Acid-Base & Co-oximetry Assay #73", "ABG-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11674-3", new LoincTestItem("11674-3", "ABG, Acid-Base & Co-oximetry Assay #74", "ABG-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11675-4", new LoincTestItem("11675-4", "ABG, Acid-Base & Co-oximetry Assay #75", "ABG-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11676-5", new LoincTestItem("11676-5", "ABG, Acid-Base & Co-oximetry Assay #76", "ABG-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11677-6", new LoincTestItem("11677-6", "ABG, Acid-Base & Co-oximetry Assay #77", "ABG-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11678-7", new LoincTestItem("11678-7", "ABG, Acid-Base & Co-oximetry Assay #78", "ABG-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11679-8", new LoincTestItem("11679-8", "ABG, Acid-Base & Co-oximetry Assay #79", "ABG-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11680-9", new LoincTestItem("11680-9", "ABG, Acid-Base & Co-oximetry Assay #80", "ABG-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11681-1", new LoincTestItem("11681-1", "ABG, Acid-Base & Co-oximetry Assay #81", "ABG-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11682-2", new LoincTestItem("11682-2", "ABG, Acid-Base & Co-oximetry Assay #82", "ABG-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11683-3", new LoincTestItem("11683-3", "ABG, Acid-Base & Co-oximetry Assay #83", "ABG-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11684-4", new LoincTestItem("11684-4", "ABG, Acid-Base & Co-oximetry Assay #84", "ABG-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11685-5", new LoincTestItem("11685-5", "ABG, Acid-Base & Co-oximetry Assay #85", "ABG-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11686-6", new LoincTestItem("11686-6", "ABG, Acid-Base & Co-oximetry Assay #86", "ABG-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11687-7", new LoincTestItem("11687-7", "ABG, Acid-Base & Co-oximetry Assay #87", "ABG-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11688-8", new LoincTestItem("11688-8", "ABG, Acid-Base & Co-oximetry Assay #88", "ABG-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11689-9", new LoincTestItem("11689-9", "ABG, Acid-Base & Co-oximetry Assay #89", "ABG-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11690-1", new LoincTestItem("11690-1", "ABG, Acid-Base & Co-oximetry Assay #90", "ABG-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11691-2", new LoincTestItem("11691-2", "ABG, Acid-Base & Co-oximetry Assay #91", "ABG-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11692-3", new LoincTestItem("11692-3", "ABG, Acid-Base & Co-oximetry Assay #92", "ABG-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11693-4", new LoincTestItem("11693-4", "ABG, Acid-Base & Co-oximetry Assay #93", "ABG-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11694-5", new LoincTestItem("11694-5", "ABG, Acid-Base & Co-oximetry Assay #94", "ABG-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11695-6", new LoincTestItem("11695-6", "ABG, Acid-Base & Co-oximetry Assay #95", "ABG-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11696-7", new LoincTestItem("11696-7", "ABG, Acid-Base & Co-oximetry Assay #96", "ABG-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11697-8", new LoincTestItem("11697-8", "ABG, Acid-Base & Co-oximetry Assay #97", "ABG-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11698-9", new LoincTestItem("11698-9", "ABG, Acid-Base & Co-oximetry Assay #98", "ABG-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11699-1", new LoincTestItem("11699-1", "ABG, Acid-Base & Co-oximetry Assay #99", "ABG-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11700-2", new LoincTestItem("11700-2", "ABG, Acid-Base & Co-oximetry Assay #100", "ABG-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
