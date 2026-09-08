package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Heavy Metals, Drugs of Abuse & Toxin Assays.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincToxicologyAndSubstanceScreeningPanelKnowledgeBase {

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

    public LoincToxicologyAndSubstanceScreeningPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("12201-2", new LoincTestItem("12201-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #1", "TOX-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12202-3", new LoincTestItem("12202-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #2", "TOX-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12203-4", new LoincTestItem("12203-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #3", "TOX-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12204-5", new LoincTestItem("12204-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #4", "TOX-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12205-6", new LoincTestItem("12205-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #5", "TOX-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12206-7", new LoincTestItem("12206-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #6", "TOX-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12207-8", new LoincTestItem("12207-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #7", "TOX-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12208-9", new LoincTestItem("12208-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #8", "TOX-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12209-1", new LoincTestItem("12209-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #9", "TOX-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12210-2", new LoincTestItem("12210-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #10", "TOX-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12211-3", new LoincTestItem("12211-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #11", "TOX-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12212-4", new LoincTestItem("12212-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #12", "TOX-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12213-5", new LoincTestItem("12213-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #13", "TOX-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12214-6", new LoincTestItem("12214-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #14", "TOX-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12215-7", new LoincTestItem("12215-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #15", "TOX-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12216-8", new LoincTestItem("12216-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #16", "TOX-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12217-9", new LoincTestItem("12217-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #17", "TOX-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12218-1", new LoincTestItem("12218-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #18", "TOX-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12219-2", new LoincTestItem("12219-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #19", "TOX-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12220-3", new LoincTestItem("12220-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #20", "TOX-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12221-4", new LoincTestItem("12221-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #21", "TOX-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12222-5", new LoincTestItem("12222-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #22", "TOX-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12223-6", new LoincTestItem("12223-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #23", "TOX-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12224-7", new LoincTestItem("12224-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #24", "TOX-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12225-8", new LoincTestItem("12225-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #25", "TOX-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12226-9", new LoincTestItem("12226-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #26", "TOX-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12227-1", new LoincTestItem("12227-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #27", "TOX-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12228-2", new LoincTestItem("12228-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #28", "TOX-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12229-3", new LoincTestItem("12229-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #29", "TOX-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12230-4", new LoincTestItem("12230-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #30", "TOX-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12231-5", new LoincTestItem("12231-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #31", "TOX-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12232-6", new LoincTestItem("12232-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #32", "TOX-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12233-7", new LoincTestItem("12233-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #33", "TOX-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12234-8", new LoincTestItem("12234-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #34", "TOX-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12235-9", new LoincTestItem("12235-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #35", "TOX-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12236-1", new LoincTestItem("12236-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #36", "TOX-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12237-2", new LoincTestItem("12237-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #37", "TOX-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12238-3", new LoincTestItem("12238-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #38", "TOX-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12239-4", new LoincTestItem("12239-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #39", "TOX-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12240-5", new LoincTestItem("12240-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #40", "TOX-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12241-6", new LoincTestItem("12241-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #41", "TOX-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12242-7", new LoincTestItem("12242-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #42", "TOX-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12243-8", new LoincTestItem("12243-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #43", "TOX-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12244-9", new LoincTestItem("12244-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #44", "TOX-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12245-1", new LoincTestItem("12245-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #45", "TOX-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12246-2", new LoincTestItem("12246-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #46", "TOX-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12247-3", new LoincTestItem("12247-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #47", "TOX-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12248-4", new LoincTestItem("12248-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #48", "TOX-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12249-5", new LoincTestItem("12249-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #49", "TOX-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12250-6", new LoincTestItem("12250-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #50", "TOX-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12251-7", new LoincTestItem("12251-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #51", "TOX-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12252-8", new LoincTestItem("12252-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #52", "TOX-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12253-9", new LoincTestItem("12253-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #53", "TOX-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12254-1", new LoincTestItem("12254-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #54", "TOX-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12255-2", new LoincTestItem("12255-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #55", "TOX-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12256-3", new LoincTestItem("12256-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #56", "TOX-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12257-4", new LoincTestItem("12257-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #57", "TOX-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12258-5", new LoincTestItem("12258-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #58", "TOX-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12259-6", new LoincTestItem("12259-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #59", "TOX-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12260-7", new LoincTestItem("12260-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #60", "TOX-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12261-8", new LoincTestItem("12261-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #61", "TOX-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12262-9", new LoincTestItem("12262-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #62", "TOX-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12263-1", new LoincTestItem("12263-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #63", "TOX-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12264-2", new LoincTestItem("12264-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #64", "TOX-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12265-3", new LoincTestItem("12265-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #65", "TOX-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12266-4", new LoincTestItem("12266-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #66", "TOX-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12267-5", new LoincTestItem("12267-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #67", "TOX-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12268-6", new LoincTestItem("12268-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #68", "TOX-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12269-7", new LoincTestItem("12269-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #69", "TOX-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12270-8", new LoincTestItem("12270-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #70", "TOX-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12271-9", new LoincTestItem("12271-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #71", "TOX-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12272-1", new LoincTestItem("12272-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #72", "TOX-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12273-2", new LoincTestItem("12273-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #73", "TOX-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12274-3", new LoincTestItem("12274-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #74", "TOX-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12275-4", new LoincTestItem("12275-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #75", "TOX-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12276-5", new LoincTestItem("12276-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #76", "TOX-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12277-6", new LoincTestItem("12277-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #77", "TOX-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12278-7", new LoincTestItem("12278-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #78", "TOX-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12279-8", new LoincTestItem("12279-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #79", "TOX-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12280-9", new LoincTestItem("12280-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #80", "TOX-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12281-1", new LoincTestItem("12281-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #81", "TOX-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12282-2", new LoincTestItem("12282-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #82", "TOX-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12283-3", new LoincTestItem("12283-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #83", "TOX-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12284-4", new LoincTestItem("12284-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #84", "TOX-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12285-5", new LoincTestItem("12285-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #85", "TOX-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12286-6", new LoincTestItem("12286-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #86", "TOX-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12287-7", new LoincTestItem("12287-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #87", "TOX-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12288-8", new LoincTestItem("12288-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #88", "TOX-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12289-9", new LoincTestItem("12289-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #89", "TOX-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12290-1", new LoincTestItem("12290-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #90", "TOX-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12291-2", new LoincTestItem("12291-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #91", "TOX-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12292-3", new LoincTestItem("12292-3", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #92", "TOX-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12293-4", new LoincTestItem("12293-4", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #93", "TOX-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12294-5", new LoincTestItem("12294-5", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #94", "TOX-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12295-6", new LoincTestItem("12295-6", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #95", "TOX-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12296-7", new LoincTestItem("12296-7", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #96", "TOX-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12297-8", new LoincTestItem("12297-8", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #97", "TOX-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12298-9", new LoincTestItem("12298-9", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #98", "TOX-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12299-1", new LoincTestItem("12299-1", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #99", "TOX-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12300-2", new LoincTestItem("12300-2", "Heavy Metals, Drugs of Abuse & Toxin Assays Assay #100", "TOX-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
