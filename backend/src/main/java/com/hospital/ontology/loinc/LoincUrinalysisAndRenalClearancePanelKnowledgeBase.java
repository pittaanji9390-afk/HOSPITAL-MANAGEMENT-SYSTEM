package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Urine Dipstick, Microscopy & 24h Clearance.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincUrinalysisAndRenalClearancePanelKnowledgeBase {

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

    public LoincUrinalysisAndRenalClearancePanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("11201-2", new LoincTestItem("11201-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #1", "URI-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11202-3", new LoincTestItem("11202-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #2", "URI-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11203-4", new LoincTestItem("11203-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #3", "URI-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11204-5", new LoincTestItem("11204-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #4", "URI-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11205-6", new LoincTestItem("11205-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #5", "URI-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11206-7", new LoincTestItem("11206-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #6", "URI-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11207-8", new LoincTestItem("11207-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #7", "URI-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11208-9", new LoincTestItem("11208-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #8", "URI-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11209-1", new LoincTestItem("11209-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #9", "URI-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11210-2", new LoincTestItem("11210-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #10", "URI-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11211-3", new LoincTestItem("11211-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #11", "URI-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11212-4", new LoincTestItem("11212-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #12", "URI-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11213-5", new LoincTestItem("11213-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #13", "URI-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11214-6", new LoincTestItem("11214-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #14", "URI-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11215-7", new LoincTestItem("11215-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #15", "URI-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11216-8", new LoincTestItem("11216-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #16", "URI-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11217-9", new LoincTestItem("11217-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #17", "URI-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11218-1", new LoincTestItem("11218-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #18", "URI-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11219-2", new LoincTestItem("11219-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #19", "URI-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11220-3", new LoincTestItem("11220-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #20", "URI-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11221-4", new LoincTestItem("11221-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #21", "URI-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11222-5", new LoincTestItem("11222-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #22", "URI-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11223-6", new LoincTestItem("11223-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #23", "URI-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11224-7", new LoincTestItem("11224-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #24", "URI-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11225-8", new LoincTestItem("11225-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #25", "URI-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11226-9", new LoincTestItem("11226-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #26", "URI-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11227-1", new LoincTestItem("11227-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #27", "URI-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11228-2", new LoincTestItem("11228-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #28", "URI-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11229-3", new LoincTestItem("11229-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #29", "URI-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11230-4", new LoincTestItem("11230-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #30", "URI-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11231-5", new LoincTestItem("11231-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #31", "URI-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11232-6", new LoincTestItem("11232-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #32", "URI-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11233-7", new LoincTestItem("11233-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #33", "URI-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11234-8", new LoincTestItem("11234-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #34", "URI-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11235-9", new LoincTestItem("11235-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #35", "URI-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11236-1", new LoincTestItem("11236-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #36", "URI-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11237-2", new LoincTestItem("11237-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #37", "URI-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11238-3", new LoincTestItem("11238-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #38", "URI-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11239-4", new LoincTestItem("11239-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #39", "URI-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11240-5", new LoincTestItem("11240-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #40", "URI-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11241-6", new LoincTestItem("11241-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #41", "URI-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11242-7", new LoincTestItem("11242-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #42", "URI-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11243-8", new LoincTestItem("11243-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #43", "URI-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11244-9", new LoincTestItem("11244-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #44", "URI-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11245-1", new LoincTestItem("11245-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #45", "URI-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11246-2", new LoincTestItem("11246-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #46", "URI-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11247-3", new LoincTestItem("11247-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #47", "URI-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11248-4", new LoincTestItem("11248-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #48", "URI-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11249-5", new LoincTestItem("11249-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #49", "URI-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11250-6", new LoincTestItem("11250-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #50", "URI-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11251-7", new LoincTestItem("11251-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #51", "URI-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11252-8", new LoincTestItem("11252-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #52", "URI-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11253-9", new LoincTestItem("11253-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #53", "URI-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11254-1", new LoincTestItem("11254-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #54", "URI-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11255-2", new LoincTestItem("11255-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #55", "URI-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11256-3", new LoincTestItem("11256-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #56", "URI-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11257-4", new LoincTestItem("11257-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #57", "URI-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11258-5", new LoincTestItem("11258-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #58", "URI-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11259-6", new LoincTestItem("11259-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #59", "URI-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11260-7", new LoincTestItem("11260-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #60", "URI-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11261-8", new LoincTestItem("11261-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #61", "URI-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11262-9", new LoincTestItem("11262-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #62", "URI-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11263-1", new LoincTestItem("11263-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #63", "URI-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11264-2", new LoincTestItem("11264-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #64", "URI-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11265-3", new LoincTestItem("11265-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #65", "URI-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11266-4", new LoincTestItem("11266-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #66", "URI-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11267-5", new LoincTestItem("11267-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #67", "URI-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11268-6", new LoincTestItem("11268-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #68", "URI-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11269-7", new LoincTestItem("11269-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #69", "URI-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11270-8", new LoincTestItem("11270-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #70", "URI-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11271-9", new LoincTestItem("11271-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #71", "URI-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11272-1", new LoincTestItem("11272-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #72", "URI-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11273-2", new LoincTestItem("11273-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #73", "URI-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11274-3", new LoincTestItem("11274-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #74", "URI-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11275-4", new LoincTestItem("11275-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #75", "URI-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11276-5", new LoincTestItem("11276-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #76", "URI-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11277-6", new LoincTestItem("11277-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #77", "URI-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11278-7", new LoincTestItem("11278-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #78", "URI-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11279-8", new LoincTestItem("11279-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #79", "URI-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11280-9", new LoincTestItem("11280-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #80", "URI-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11281-1", new LoincTestItem("11281-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #81", "URI-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11282-2", new LoincTestItem("11282-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #82", "URI-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11283-3", new LoincTestItem("11283-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #83", "URI-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11284-4", new LoincTestItem("11284-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #84", "URI-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11285-5", new LoincTestItem("11285-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #85", "URI-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11286-6", new LoincTestItem("11286-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #86", "URI-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11287-7", new LoincTestItem("11287-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #87", "URI-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11288-8", new LoincTestItem("11288-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #88", "URI-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11289-9", new LoincTestItem("11289-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #89", "URI-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11290-1", new LoincTestItem("11290-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #90", "URI-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11291-2", new LoincTestItem("11291-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #91", "URI-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11292-3", new LoincTestItem("11292-3", "Urine Dipstick, Microscopy & 24h Clearance Assay #92", "URI-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11293-4", new LoincTestItem("11293-4", "Urine Dipstick, Microscopy & 24h Clearance Assay #93", "URI-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11294-5", new LoincTestItem("11294-5", "Urine Dipstick, Microscopy & 24h Clearance Assay #94", "URI-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11295-6", new LoincTestItem("11295-6", "Urine Dipstick, Microscopy & 24h Clearance Assay #95", "URI-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11296-7", new LoincTestItem("11296-7", "Urine Dipstick, Microscopy & 24h Clearance Assay #96", "URI-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11297-8", new LoincTestItem("11297-8", "Urine Dipstick, Microscopy & 24h Clearance Assay #97", "URI-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11298-9", new LoincTestItem("11298-9", "Urine Dipstick, Microscopy & 24h Clearance Assay #98", "URI-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11299-1", new LoincTestItem("11299-1", "Urine Dipstick, Microscopy & 24h Clearance Assay #99", "URI-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11300-2", new LoincTestItem("11300-2", "Urine Dipstick, Microscopy & 24h Clearance Assay #100", "URI-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
