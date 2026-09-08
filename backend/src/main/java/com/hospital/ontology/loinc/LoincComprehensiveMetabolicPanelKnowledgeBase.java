package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Renal, Liver & Electrolytes Panel.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincComprehensiveMetabolicPanelKnowledgeBase {

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

    public LoincComprehensiveMetabolicPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("10201-2", new LoincTestItem("10201-2", "Renal, Liver & Electrolytes Panel Assay #1", "CMP-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10202-3", new LoincTestItem("10202-3", "Renal, Liver & Electrolytes Panel Assay #2", "CMP-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10203-4", new LoincTestItem("10203-4", "Renal, Liver & Electrolytes Panel Assay #3", "CMP-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10204-5", new LoincTestItem("10204-5", "Renal, Liver & Electrolytes Panel Assay #4", "CMP-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10205-6", new LoincTestItem("10205-6", "Renal, Liver & Electrolytes Panel Assay #5", "CMP-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10206-7", new LoincTestItem("10206-7", "Renal, Liver & Electrolytes Panel Assay #6", "CMP-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10207-8", new LoincTestItem("10207-8", "Renal, Liver & Electrolytes Panel Assay #7", "CMP-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10208-9", new LoincTestItem("10208-9", "Renal, Liver & Electrolytes Panel Assay #8", "CMP-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10209-1", new LoincTestItem("10209-1", "Renal, Liver & Electrolytes Panel Assay #9", "CMP-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10210-2", new LoincTestItem("10210-2", "Renal, Liver & Electrolytes Panel Assay #10", "CMP-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10211-3", new LoincTestItem("10211-3", "Renal, Liver & Electrolytes Panel Assay #11", "CMP-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10212-4", new LoincTestItem("10212-4", "Renal, Liver & Electrolytes Panel Assay #12", "CMP-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10213-5", new LoincTestItem("10213-5", "Renal, Liver & Electrolytes Panel Assay #13", "CMP-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10214-6", new LoincTestItem("10214-6", "Renal, Liver & Electrolytes Panel Assay #14", "CMP-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10215-7", new LoincTestItem("10215-7", "Renal, Liver & Electrolytes Panel Assay #15", "CMP-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10216-8", new LoincTestItem("10216-8", "Renal, Liver & Electrolytes Panel Assay #16", "CMP-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10217-9", new LoincTestItem("10217-9", "Renal, Liver & Electrolytes Panel Assay #17", "CMP-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10218-1", new LoincTestItem("10218-1", "Renal, Liver & Electrolytes Panel Assay #18", "CMP-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10219-2", new LoincTestItem("10219-2", "Renal, Liver & Electrolytes Panel Assay #19", "CMP-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10220-3", new LoincTestItem("10220-3", "Renal, Liver & Electrolytes Panel Assay #20", "CMP-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10221-4", new LoincTestItem("10221-4", "Renal, Liver & Electrolytes Panel Assay #21", "CMP-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10222-5", new LoincTestItem("10222-5", "Renal, Liver & Electrolytes Panel Assay #22", "CMP-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10223-6", new LoincTestItem("10223-6", "Renal, Liver & Electrolytes Panel Assay #23", "CMP-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10224-7", new LoincTestItem("10224-7", "Renal, Liver & Electrolytes Panel Assay #24", "CMP-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10225-8", new LoincTestItem("10225-8", "Renal, Liver & Electrolytes Panel Assay #25", "CMP-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10226-9", new LoincTestItem("10226-9", "Renal, Liver & Electrolytes Panel Assay #26", "CMP-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10227-1", new LoincTestItem("10227-1", "Renal, Liver & Electrolytes Panel Assay #27", "CMP-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10228-2", new LoincTestItem("10228-2", "Renal, Liver & Electrolytes Panel Assay #28", "CMP-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10229-3", new LoincTestItem("10229-3", "Renal, Liver & Electrolytes Panel Assay #29", "CMP-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10230-4", new LoincTestItem("10230-4", "Renal, Liver & Electrolytes Panel Assay #30", "CMP-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10231-5", new LoincTestItem("10231-5", "Renal, Liver & Electrolytes Panel Assay #31", "CMP-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10232-6", new LoincTestItem("10232-6", "Renal, Liver & Electrolytes Panel Assay #32", "CMP-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10233-7", new LoincTestItem("10233-7", "Renal, Liver & Electrolytes Panel Assay #33", "CMP-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10234-8", new LoincTestItem("10234-8", "Renal, Liver & Electrolytes Panel Assay #34", "CMP-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10235-9", new LoincTestItem("10235-9", "Renal, Liver & Electrolytes Panel Assay #35", "CMP-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10236-1", new LoincTestItem("10236-1", "Renal, Liver & Electrolytes Panel Assay #36", "CMP-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10237-2", new LoincTestItem("10237-2", "Renal, Liver & Electrolytes Panel Assay #37", "CMP-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10238-3", new LoincTestItem("10238-3", "Renal, Liver & Electrolytes Panel Assay #38", "CMP-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10239-4", new LoincTestItem("10239-4", "Renal, Liver & Electrolytes Panel Assay #39", "CMP-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10240-5", new LoincTestItem("10240-5", "Renal, Liver & Electrolytes Panel Assay #40", "CMP-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10241-6", new LoincTestItem("10241-6", "Renal, Liver & Electrolytes Panel Assay #41", "CMP-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10242-7", new LoincTestItem("10242-7", "Renal, Liver & Electrolytes Panel Assay #42", "CMP-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10243-8", new LoincTestItem("10243-8", "Renal, Liver & Electrolytes Panel Assay #43", "CMP-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10244-9", new LoincTestItem("10244-9", "Renal, Liver & Electrolytes Panel Assay #44", "CMP-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10245-1", new LoincTestItem("10245-1", "Renal, Liver & Electrolytes Panel Assay #45", "CMP-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10246-2", new LoincTestItem("10246-2", "Renal, Liver & Electrolytes Panel Assay #46", "CMP-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10247-3", new LoincTestItem("10247-3", "Renal, Liver & Electrolytes Panel Assay #47", "CMP-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10248-4", new LoincTestItem("10248-4", "Renal, Liver & Electrolytes Panel Assay #48", "CMP-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10249-5", new LoincTestItem("10249-5", "Renal, Liver & Electrolytes Panel Assay #49", "CMP-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10250-6", new LoincTestItem("10250-6", "Renal, Liver & Electrolytes Panel Assay #50", "CMP-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10251-7", new LoincTestItem("10251-7", "Renal, Liver & Electrolytes Panel Assay #51", "CMP-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10252-8", new LoincTestItem("10252-8", "Renal, Liver & Electrolytes Panel Assay #52", "CMP-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10253-9", new LoincTestItem("10253-9", "Renal, Liver & Electrolytes Panel Assay #53", "CMP-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10254-1", new LoincTestItem("10254-1", "Renal, Liver & Electrolytes Panel Assay #54", "CMP-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10255-2", new LoincTestItem("10255-2", "Renal, Liver & Electrolytes Panel Assay #55", "CMP-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10256-3", new LoincTestItem("10256-3", "Renal, Liver & Electrolytes Panel Assay #56", "CMP-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10257-4", new LoincTestItem("10257-4", "Renal, Liver & Electrolytes Panel Assay #57", "CMP-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10258-5", new LoincTestItem("10258-5", "Renal, Liver & Electrolytes Panel Assay #58", "CMP-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10259-6", new LoincTestItem("10259-6", "Renal, Liver & Electrolytes Panel Assay #59", "CMP-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10260-7", new LoincTestItem("10260-7", "Renal, Liver & Electrolytes Panel Assay #60", "CMP-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10261-8", new LoincTestItem("10261-8", "Renal, Liver & Electrolytes Panel Assay #61", "CMP-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10262-9", new LoincTestItem("10262-9", "Renal, Liver & Electrolytes Panel Assay #62", "CMP-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10263-1", new LoincTestItem("10263-1", "Renal, Liver & Electrolytes Panel Assay #63", "CMP-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10264-2", new LoincTestItem("10264-2", "Renal, Liver & Electrolytes Panel Assay #64", "CMP-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10265-3", new LoincTestItem("10265-3", "Renal, Liver & Electrolytes Panel Assay #65", "CMP-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10266-4", new LoincTestItem("10266-4", "Renal, Liver & Electrolytes Panel Assay #66", "CMP-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10267-5", new LoincTestItem("10267-5", "Renal, Liver & Electrolytes Panel Assay #67", "CMP-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10268-6", new LoincTestItem("10268-6", "Renal, Liver & Electrolytes Panel Assay #68", "CMP-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10269-7", new LoincTestItem("10269-7", "Renal, Liver & Electrolytes Panel Assay #69", "CMP-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10270-8", new LoincTestItem("10270-8", "Renal, Liver & Electrolytes Panel Assay #70", "CMP-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10271-9", new LoincTestItem("10271-9", "Renal, Liver & Electrolytes Panel Assay #71", "CMP-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10272-1", new LoincTestItem("10272-1", "Renal, Liver & Electrolytes Panel Assay #72", "CMP-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10273-2", new LoincTestItem("10273-2", "Renal, Liver & Electrolytes Panel Assay #73", "CMP-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10274-3", new LoincTestItem("10274-3", "Renal, Liver & Electrolytes Panel Assay #74", "CMP-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10275-4", new LoincTestItem("10275-4", "Renal, Liver & Electrolytes Panel Assay #75", "CMP-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10276-5", new LoincTestItem("10276-5", "Renal, Liver & Electrolytes Panel Assay #76", "CMP-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10277-6", new LoincTestItem("10277-6", "Renal, Liver & Electrolytes Panel Assay #77", "CMP-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10278-7", new LoincTestItem("10278-7", "Renal, Liver & Electrolytes Panel Assay #78", "CMP-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10279-8", new LoincTestItem("10279-8", "Renal, Liver & Electrolytes Panel Assay #79", "CMP-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10280-9", new LoincTestItem("10280-9", "Renal, Liver & Electrolytes Panel Assay #80", "CMP-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10281-1", new LoincTestItem("10281-1", "Renal, Liver & Electrolytes Panel Assay #81", "CMP-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10282-2", new LoincTestItem("10282-2", "Renal, Liver & Electrolytes Panel Assay #82", "CMP-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10283-3", new LoincTestItem("10283-3", "Renal, Liver & Electrolytes Panel Assay #83", "CMP-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10284-4", new LoincTestItem("10284-4", "Renal, Liver & Electrolytes Panel Assay #84", "CMP-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10285-5", new LoincTestItem("10285-5", "Renal, Liver & Electrolytes Panel Assay #85", "CMP-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10286-6", new LoincTestItem("10286-6", "Renal, Liver & Electrolytes Panel Assay #86", "CMP-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10287-7", new LoincTestItem("10287-7", "Renal, Liver & Electrolytes Panel Assay #87", "CMP-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10288-8", new LoincTestItem("10288-8", "Renal, Liver & Electrolytes Panel Assay #88", "CMP-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10289-9", new LoincTestItem("10289-9", "Renal, Liver & Electrolytes Panel Assay #89", "CMP-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10290-1", new LoincTestItem("10290-1", "Renal, Liver & Electrolytes Panel Assay #90", "CMP-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10291-2", new LoincTestItem("10291-2", "Renal, Liver & Electrolytes Panel Assay #91", "CMP-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10292-3", new LoincTestItem("10292-3", "Renal, Liver & Electrolytes Panel Assay #92", "CMP-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10293-4", new LoincTestItem("10293-4", "Renal, Liver & Electrolytes Panel Assay #93", "CMP-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10294-5", new LoincTestItem("10294-5", "Renal, Liver & Electrolytes Panel Assay #94", "CMP-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10295-6", new LoincTestItem("10295-6", "Renal, Liver & Electrolytes Panel Assay #95", "CMP-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10296-7", new LoincTestItem("10296-7", "Renal, Liver & Electrolytes Panel Assay #96", "CMP-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10297-8", new LoincTestItem("10297-8", "Renal, Liver & Electrolytes Panel Assay #97", "CMP-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10298-9", new LoincTestItem("10298-9", "Renal, Liver & Electrolytes Panel Assay #98", "CMP-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10299-1", new LoincTestItem("10299-1", "Renal, Liver & Electrolytes Panel Assay #99", "CMP-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10300-2", new LoincTestItem("10300-2", "Renal, Liver & Electrolytes Panel Assay #100", "CMP-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10301-3", new LoincTestItem("10301-3", "Renal, Liver & Electrolytes Panel Assay #101", "CMP-201", "151.50 - 424.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10302-4", new LoincTestItem("10302-4", "Renal, Liver & Electrolytes Panel Assay #102", "CMP-202", "153.00 - 428.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10303-5", new LoincTestItem("10303-5", "Renal, Liver & Electrolytes Panel Assay #103", "CMP-203", "154.50 - 432.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10304-6", new LoincTestItem("10304-6", "Renal, Liver & Electrolytes Panel Assay #104", "CMP-204", "156.00 - 436.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10305-7", new LoincTestItem("10305-7", "Renal, Liver & Electrolytes Panel Assay #105", "CMP-205", "157.50 - 441.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10306-8", new LoincTestItem("10306-8", "Renal, Liver & Electrolytes Panel Assay #106", "CMP-206", "159.00 - 445.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10307-9", new LoincTestItem("10307-9", "Renal, Liver & Electrolytes Panel Assay #107", "CMP-207", "160.50 - 449.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10308-1", new LoincTestItem("10308-1", "Renal, Liver & Electrolytes Panel Assay #108", "CMP-208", "162.00 - 453.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10309-2", new LoincTestItem("10309-2", "Renal, Liver & Electrolytes Panel Assay #109", "CMP-209", "163.50 - 457.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10310-3", new LoincTestItem("10310-3", "Renal, Liver & Electrolytes Panel Assay #110", "CMP-210", "165.00 - 462.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10311-4", new LoincTestItem("10311-4", "Renal, Liver & Electrolytes Panel Assay #111", "CMP-211", "166.50 - 466.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10312-5", new LoincTestItem("10312-5", "Renal, Liver & Electrolytes Panel Assay #112", "CMP-212", "168.00 - 470.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10313-6", new LoincTestItem("10313-6", "Renal, Liver & Electrolytes Panel Assay #113", "CMP-213", "169.50 - 474.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10314-7", new LoincTestItem("10314-7", "Renal, Liver & Electrolytes Panel Assay #114", "CMP-214", "171.00 - 478.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10315-8", new LoincTestItem("10315-8", "Renal, Liver & Electrolytes Panel Assay #115", "CMP-215", "172.50 - 483.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10316-9", new LoincTestItem("10316-9", "Renal, Liver & Electrolytes Panel Assay #116", "CMP-216", "174.00 - 487.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10317-1", new LoincTestItem("10317-1", "Renal, Liver & Electrolytes Panel Assay #117", "CMP-217", "175.50 - 491.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10318-2", new LoincTestItem("10318-2", "Renal, Liver & Electrolytes Panel Assay #118", "CMP-218", "177.00 - 495.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10319-3", new LoincTestItem("10319-3", "Renal, Liver & Electrolytes Panel Assay #119", "CMP-219", "178.50 - 499.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10320-4", new LoincTestItem("10320-4", "Renal, Liver & Electrolytes Panel Assay #120", "CMP-220", "180.00 - 504.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
