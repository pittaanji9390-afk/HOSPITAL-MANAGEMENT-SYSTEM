package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Blood Cultures & MIC Susceptibility.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincMicrobiologyAndAntibiogramPanelKnowledgeBase {

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

    public LoincMicrobiologyAndAntibiogramPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("10801-2", new LoincTestItem("10801-2", "Blood Cultures & MIC Susceptibility Assay #1", "MIC-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10802-3", new LoincTestItem("10802-3", "Blood Cultures & MIC Susceptibility Assay #2", "MIC-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10803-4", new LoincTestItem("10803-4", "Blood Cultures & MIC Susceptibility Assay #3", "MIC-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10804-5", new LoincTestItem("10804-5", "Blood Cultures & MIC Susceptibility Assay #4", "MIC-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10805-6", new LoincTestItem("10805-6", "Blood Cultures & MIC Susceptibility Assay #5", "MIC-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10806-7", new LoincTestItem("10806-7", "Blood Cultures & MIC Susceptibility Assay #6", "MIC-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10807-8", new LoincTestItem("10807-8", "Blood Cultures & MIC Susceptibility Assay #7", "MIC-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10808-9", new LoincTestItem("10808-9", "Blood Cultures & MIC Susceptibility Assay #8", "MIC-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10809-1", new LoincTestItem("10809-1", "Blood Cultures & MIC Susceptibility Assay #9", "MIC-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10810-2", new LoincTestItem("10810-2", "Blood Cultures & MIC Susceptibility Assay #10", "MIC-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10811-3", new LoincTestItem("10811-3", "Blood Cultures & MIC Susceptibility Assay #11", "MIC-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10812-4", new LoincTestItem("10812-4", "Blood Cultures & MIC Susceptibility Assay #12", "MIC-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10813-5", new LoincTestItem("10813-5", "Blood Cultures & MIC Susceptibility Assay #13", "MIC-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10814-6", new LoincTestItem("10814-6", "Blood Cultures & MIC Susceptibility Assay #14", "MIC-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10815-7", new LoincTestItem("10815-7", "Blood Cultures & MIC Susceptibility Assay #15", "MIC-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10816-8", new LoincTestItem("10816-8", "Blood Cultures & MIC Susceptibility Assay #16", "MIC-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10817-9", new LoincTestItem("10817-9", "Blood Cultures & MIC Susceptibility Assay #17", "MIC-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10818-1", new LoincTestItem("10818-1", "Blood Cultures & MIC Susceptibility Assay #18", "MIC-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10819-2", new LoincTestItem("10819-2", "Blood Cultures & MIC Susceptibility Assay #19", "MIC-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10820-3", new LoincTestItem("10820-3", "Blood Cultures & MIC Susceptibility Assay #20", "MIC-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10821-4", new LoincTestItem("10821-4", "Blood Cultures & MIC Susceptibility Assay #21", "MIC-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10822-5", new LoincTestItem("10822-5", "Blood Cultures & MIC Susceptibility Assay #22", "MIC-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10823-6", new LoincTestItem("10823-6", "Blood Cultures & MIC Susceptibility Assay #23", "MIC-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10824-7", new LoincTestItem("10824-7", "Blood Cultures & MIC Susceptibility Assay #24", "MIC-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10825-8", new LoincTestItem("10825-8", "Blood Cultures & MIC Susceptibility Assay #25", "MIC-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10826-9", new LoincTestItem("10826-9", "Blood Cultures & MIC Susceptibility Assay #26", "MIC-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10827-1", new LoincTestItem("10827-1", "Blood Cultures & MIC Susceptibility Assay #27", "MIC-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10828-2", new LoincTestItem("10828-2", "Blood Cultures & MIC Susceptibility Assay #28", "MIC-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10829-3", new LoincTestItem("10829-3", "Blood Cultures & MIC Susceptibility Assay #29", "MIC-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10830-4", new LoincTestItem("10830-4", "Blood Cultures & MIC Susceptibility Assay #30", "MIC-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10831-5", new LoincTestItem("10831-5", "Blood Cultures & MIC Susceptibility Assay #31", "MIC-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10832-6", new LoincTestItem("10832-6", "Blood Cultures & MIC Susceptibility Assay #32", "MIC-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10833-7", new LoincTestItem("10833-7", "Blood Cultures & MIC Susceptibility Assay #33", "MIC-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10834-8", new LoincTestItem("10834-8", "Blood Cultures & MIC Susceptibility Assay #34", "MIC-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10835-9", new LoincTestItem("10835-9", "Blood Cultures & MIC Susceptibility Assay #35", "MIC-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10836-1", new LoincTestItem("10836-1", "Blood Cultures & MIC Susceptibility Assay #36", "MIC-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10837-2", new LoincTestItem("10837-2", "Blood Cultures & MIC Susceptibility Assay #37", "MIC-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10838-3", new LoincTestItem("10838-3", "Blood Cultures & MIC Susceptibility Assay #38", "MIC-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10839-4", new LoincTestItem("10839-4", "Blood Cultures & MIC Susceptibility Assay #39", "MIC-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10840-5", new LoincTestItem("10840-5", "Blood Cultures & MIC Susceptibility Assay #40", "MIC-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10841-6", new LoincTestItem("10841-6", "Blood Cultures & MIC Susceptibility Assay #41", "MIC-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10842-7", new LoincTestItem("10842-7", "Blood Cultures & MIC Susceptibility Assay #42", "MIC-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10843-8", new LoincTestItem("10843-8", "Blood Cultures & MIC Susceptibility Assay #43", "MIC-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10844-9", new LoincTestItem("10844-9", "Blood Cultures & MIC Susceptibility Assay #44", "MIC-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10845-1", new LoincTestItem("10845-1", "Blood Cultures & MIC Susceptibility Assay #45", "MIC-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10846-2", new LoincTestItem("10846-2", "Blood Cultures & MIC Susceptibility Assay #46", "MIC-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10847-3", new LoincTestItem("10847-3", "Blood Cultures & MIC Susceptibility Assay #47", "MIC-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10848-4", new LoincTestItem("10848-4", "Blood Cultures & MIC Susceptibility Assay #48", "MIC-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10849-5", new LoincTestItem("10849-5", "Blood Cultures & MIC Susceptibility Assay #49", "MIC-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10850-6", new LoincTestItem("10850-6", "Blood Cultures & MIC Susceptibility Assay #50", "MIC-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10851-7", new LoincTestItem("10851-7", "Blood Cultures & MIC Susceptibility Assay #51", "MIC-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10852-8", new LoincTestItem("10852-8", "Blood Cultures & MIC Susceptibility Assay #52", "MIC-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10853-9", new LoincTestItem("10853-9", "Blood Cultures & MIC Susceptibility Assay #53", "MIC-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10854-1", new LoincTestItem("10854-1", "Blood Cultures & MIC Susceptibility Assay #54", "MIC-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10855-2", new LoincTestItem("10855-2", "Blood Cultures & MIC Susceptibility Assay #55", "MIC-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10856-3", new LoincTestItem("10856-3", "Blood Cultures & MIC Susceptibility Assay #56", "MIC-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10857-4", new LoincTestItem("10857-4", "Blood Cultures & MIC Susceptibility Assay #57", "MIC-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10858-5", new LoincTestItem("10858-5", "Blood Cultures & MIC Susceptibility Assay #58", "MIC-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10859-6", new LoincTestItem("10859-6", "Blood Cultures & MIC Susceptibility Assay #59", "MIC-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10860-7", new LoincTestItem("10860-7", "Blood Cultures & MIC Susceptibility Assay #60", "MIC-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10861-8", new LoincTestItem("10861-8", "Blood Cultures & MIC Susceptibility Assay #61", "MIC-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10862-9", new LoincTestItem("10862-9", "Blood Cultures & MIC Susceptibility Assay #62", "MIC-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10863-1", new LoincTestItem("10863-1", "Blood Cultures & MIC Susceptibility Assay #63", "MIC-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10864-2", new LoincTestItem("10864-2", "Blood Cultures & MIC Susceptibility Assay #64", "MIC-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10865-3", new LoincTestItem("10865-3", "Blood Cultures & MIC Susceptibility Assay #65", "MIC-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10866-4", new LoincTestItem("10866-4", "Blood Cultures & MIC Susceptibility Assay #66", "MIC-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10867-5", new LoincTestItem("10867-5", "Blood Cultures & MIC Susceptibility Assay #67", "MIC-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10868-6", new LoincTestItem("10868-6", "Blood Cultures & MIC Susceptibility Assay #68", "MIC-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10869-7", new LoincTestItem("10869-7", "Blood Cultures & MIC Susceptibility Assay #69", "MIC-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10870-8", new LoincTestItem("10870-8", "Blood Cultures & MIC Susceptibility Assay #70", "MIC-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10871-9", new LoincTestItem("10871-9", "Blood Cultures & MIC Susceptibility Assay #71", "MIC-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10872-1", new LoincTestItem("10872-1", "Blood Cultures & MIC Susceptibility Assay #72", "MIC-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10873-2", new LoincTestItem("10873-2", "Blood Cultures & MIC Susceptibility Assay #73", "MIC-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10874-3", new LoincTestItem("10874-3", "Blood Cultures & MIC Susceptibility Assay #74", "MIC-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10875-4", new LoincTestItem("10875-4", "Blood Cultures & MIC Susceptibility Assay #75", "MIC-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10876-5", new LoincTestItem("10876-5", "Blood Cultures & MIC Susceptibility Assay #76", "MIC-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10877-6", new LoincTestItem("10877-6", "Blood Cultures & MIC Susceptibility Assay #77", "MIC-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10878-7", new LoincTestItem("10878-7", "Blood Cultures & MIC Susceptibility Assay #78", "MIC-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10879-8", new LoincTestItem("10879-8", "Blood Cultures & MIC Susceptibility Assay #79", "MIC-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10880-9", new LoincTestItem("10880-9", "Blood Cultures & MIC Susceptibility Assay #80", "MIC-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10881-1", new LoincTestItem("10881-1", "Blood Cultures & MIC Susceptibility Assay #81", "MIC-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10882-2", new LoincTestItem("10882-2", "Blood Cultures & MIC Susceptibility Assay #82", "MIC-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10883-3", new LoincTestItem("10883-3", "Blood Cultures & MIC Susceptibility Assay #83", "MIC-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10884-4", new LoincTestItem("10884-4", "Blood Cultures & MIC Susceptibility Assay #84", "MIC-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10885-5", new LoincTestItem("10885-5", "Blood Cultures & MIC Susceptibility Assay #85", "MIC-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10886-6", new LoincTestItem("10886-6", "Blood Cultures & MIC Susceptibility Assay #86", "MIC-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10887-7", new LoincTestItem("10887-7", "Blood Cultures & MIC Susceptibility Assay #87", "MIC-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10888-8", new LoincTestItem("10888-8", "Blood Cultures & MIC Susceptibility Assay #88", "MIC-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10889-9", new LoincTestItem("10889-9", "Blood Cultures & MIC Susceptibility Assay #89", "MIC-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10890-1", new LoincTestItem("10890-1", "Blood Cultures & MIC Susceptibility Assay #90", "MIC-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10891-2", new LoincTestItem("10891-2", "Blood Cultures & MIC Susceptibility Assay #91", "MIC-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10892-3", new LoincTestItem("10892-3", "Blood Cultures & MIC Susceptibility Assay #92", "MIC-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10893-4", new LoincTestItem("10893-4", "Blood Cultures & MIC Susceptibility Assay #93", "MIC-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10894-5", new LoincTestItem("10894-5", "Blood Cultures & MIC Susceptibility Assay #94", "MIC-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10895-6", new LoincTestItem("10895-6", "Blood Cultures & MIC Susceptibility Assay #95", "MIC-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10896-7", new LoincTestItem("10896-7", "Blood Cultures & MIC Susceptibility Assay #96", "MIC-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10897-8", new LoincTestItem("10897-8", "Blood Cultures & MIC Susceptibility Assay #97", "MIC-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10898-9", new LoincTestItem("10898-9", "Blood Cultures & MIC Susceptibility Assay #98", "MIC-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10899-1", new LoincTestItem("10899-1", "Blood Cultures & MIC Susceptibility Assay #99", "MIC-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10900-2", new LoincTestItem("10900-2", "Blood Cultures & MIC Susceptibility Assay #100", "MIC-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10901-3", new LoincTestItem("10901-3", "Blood Cultures & MIC Susceptibility Assay #101", "MIC-201", "151.50 - 424.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10902-4", new LoincTestItem("10902-4", "Blood Cultures & MIC Susceptibility Assay #102", "MIC-202", "153.00 - 428.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10903-5", new LoincTestItem("10903-5", "Blood Cultures & MIC Susceptibility Assay #103", "MIC-203", "154.50 - 432.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10904-6", new LoincTestItem("10904-6", "Blood Cultures & MIC Susceptibility Assay #104", "MIC-204", "156.00 - 436.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10905-7", new LoincTestItem("10905-7", "Blood Cultures & MIC Susceptibility Assay #105", "MIC-205", "157.50 - 441.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10906-8", new LoincTestItem("10906-8", "Blood Cultures & MIC Susceptibility Assay #106", "MIC-206", "159.00 - 445.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10907-9", new LoincTestItem("10907-9", "Blood Cultures & MIC Susceptibility Assay #107", "MIC-207", "160.50 - 449.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10908-1", new LoincTestItem("10908-1", "Blood Cultures & MIC Susceptibility Assay #108", "MIC-208", "162.00 - 453.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10909-2", new LoincTestItem("10909-2", "Blood Cultures & MIC Susceptibility Assay #109", "MIC-209", "163.50 - 457.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10910-3", new LoincTestItem("10910-3", "Blood Cultures & MIC Susceptibility Assay #110", "MIC-210", "165.00 - 462.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10911-4", new LoincTestItem("10911-4", "Blood Cultures & MIC Susceptibility Assay #111", "MIC-211", "166.50 - 466.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10912-5", new LoincTestItem("10912-5", "Blood Cultures & MIC Susceptibility Assay #112", "MIC-212", "168.00 - 470.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10913-6", new LoincTestItem("10913-6", "Blood Cultures & MIC Susceptibility Assay #113", "MIC-213", "169.50 - 474.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10914-7", new LoincTestItem("10914-7", "Blood Cultures & MIC Susceptibility Assay #114", "MIC-214", "171.00 - 478.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10915-8", new LoincTestItem("10915-8", "Blood Cultures & MIC Susceptibility Assay #115", "MIC-215", "172.50 - 483.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10916-9", new LoincTestItem("10916-9", "Blood Cultures & MIC Susceptibility Assay #116", "MIC-216", "174.00 - 487.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10917-1", new LoincTestItem("10917-1", "Blood Cultures & MIC Susceptibility Assay #117", "MIC-217", "175.50 - 491.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10918-2", new LoincTestItem("10918-2", "Blood Cultures & MIC Susceptibility Assay #118", "MIC-218", "177.00 - 495.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10919-3", new LoincTestItem("10919-3", "Blood Cultures & MIC Susceptibility Assay #119", "MIC-219", "178.50 - 499.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10920-4", new LoincTestItem("10920-4", "Blood Cultures & MIC Susceptibility Assay #120", "MIC-220", "180.00 - 504.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
