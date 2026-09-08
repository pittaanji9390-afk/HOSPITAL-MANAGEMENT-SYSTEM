package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: CSF Chemistry, Cell Count, Oligoclonal Bands.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincCerebrospinalFluidAnalysisPanelKnowledgeBase {

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

    public LoincCerebrospinalFluidAnalysisPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("12001-2", new LoincTestItem("12001-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #1", "CSF-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12002-3", new LoincTestItem("12002-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #2", "CSF-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12003-4", new LoincTestItem("12003-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #3", "CSF-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12004-5", new LoincTestItem("12004-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #4", "CSF-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12005-6", new LoincTestItem("12005-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #5", "CSF-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12006-7", new LoincTestItem("12006-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #6", "CSF-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12007-8", new LoincTestItem("12007-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #7", "CSF-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12008-9", new LoincTestItem("12008-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #8", "CSF-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12009-1", new LoincTestItem("12009-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #9", "CSF-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12010-2", new LoincTestItem("12010-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #10", "CSF-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12011-3", new LoincTestItem("12011-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #11", "CSF-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12012-4", new LoincTestItem("12012-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #12", "CSF-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12013-5", new LoincTestItem("12013-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #13", "CSF-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12014-6", new LoincTestItem("12014-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #14", "CSF-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12015-7", new LoincTestItem("12015-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #15", "CSF-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12016-8", new LoincTestItem("12016-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #16", "CSF-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12017-9", new LoincTestItem("12017-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #17", "CSF-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12018-1", new LoincTestItem("12018-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #18", "CSF-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12019-2", new LoincTestItem("12019-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #19", "CSF-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12020-3", new LoincTestItem("12020-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #20", "CSF-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12021-4", new LoincTestItem("12021-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #21", "CSF-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12022-5", new LoincTestItem("12022-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #22", "CSF-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12023-6", new LoincTestItem("12023-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #23", "CSF-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12024-7", new LoincTestItem("12024-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #24", "CSF-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12025-8", new LoincTestItem("12025-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #25", "CSF-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12026-9", new LoincTestItem("12026-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #26", "CSF-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12027-1", new LoincTestItem("12027-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #27", "CSF-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12028-2", new LoincTestItem("12028-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #28", "CSF-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12029-3", new LoincTestItem("12029-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #29", "CSF-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12030-4", new LoincTestItem("12030-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #30", "CSF-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12031-5", new LoincTestItem("12031-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #31", "CSF-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12032-6", new LoincTestItem("12032-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #32", "CSF-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12033-7", new LoincTestItem("12033-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #33", "CSF-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12034-8", new LoincTestItem("12034-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #34", "CSF-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12035-9", new LoincTestItem("12035-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #35", "CSF-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12036-1", new LoincTestItem("12036-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #36", "CSF-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12037-2", new LoincTestItem("12037-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #37", "CSF-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12038-3", new LoincTestItem("12038-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #38", "CSF-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12039-4", new LoincTestItem("12039-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #39", "CSF-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12040-5", new LoincTestItem("12040-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #40", "CSF-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12041-6", new LoincTestItem("12041-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #41", "CSF-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12042-7", new LoincTestItem("12042-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #42", "CSF-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12043-8", new LoincTestItem("12043-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #43", "CSF-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12044-9", new LoincTestItem("12044-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #44", "CSF-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12045-1", new LoincTestItem("12045-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #45", "CSF-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12046-2", new LoincTestItem("12046-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #46", "CSF-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12047-3", new LoincTestItem("12047-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #47", "CSF-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12048-4", new LoincTestItem("12048-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #48", "CSF-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12049-5", new LoincTestItem("12049-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #49", "CSF-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12050-6", new LoincTestItem("12050-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #50", "CSF-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12051-7", new LoincTestItem("12051-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #51", "CSF-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12052-8", new LoincTestItem("12052-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #52", "CSF-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12053-9", new LoincTestItem("12053-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #53", "CSF-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12054-1", new LoincTestItem("12054-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #54", "CSF-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12055-2", new LoincTestItem("12055-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #55", "CSF-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12056-3", new LoincTestItem("12056-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #56", "CSF-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12057-4", new LoincTestItem("12057-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #57", "CSF-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12058-5", new LoincTestItem("12058-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #58", "CSF-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12059-6", new LoincTestItem("12059-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #59", "CSF-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12060-7", new LoincTestItem("12060-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #60", "CSF-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12061-8", new LoincTestItem("12061-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #61", "CSF-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12062-9", new LoincTestItem("12062-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #62", "CSF-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12063-1", new LoincTestItem("12063-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #63", "CSF-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12064-2", new LoincTestItem("12064-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #64", "CSF-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12065-3", new LoincTestItem("12065-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #65", "CSF-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12066-4", new LoincTestItem("12066-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #66", "CSF-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12067-5", new LoincTestItem("12067-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #67", "CSF-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12068-6", new LoincTestItem("12068-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #68", "CSF-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12069-7", new LoincTestItem("12069-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #69", "CSF-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12070-8", new LoincTestItem("12070-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #70", "CSF-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12071-9", new LoincTestItem("12071-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #71", "CSF-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12072-1", new LoincTestItem("12072-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #72", "CSF-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12073-2", new LoincTestItem("12073-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #73", "CSF-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12074-3", new LoincTestItem("12074-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #74", "CSF-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12075-4", new LoincTestItem("12075-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #75", "CSF-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12076-5", new LoincTestItem("12076-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #76", "CSF-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12077-6", new LoincTestItem("12077-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #77", "CSF-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12078-7", new LoincTestItem("12078-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #78", "CSF-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12079-8", new LoincTestItem("12079-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #79", "CSF-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12080-9", new LoincTestItem("12080-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #80", "CSF-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12081-1", new LoincTestItem("12081-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #81", "CSF-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12082-2", new LoincTestItem("12082-2", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #82", "CSF-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12083-3", new LoincTestItem("12083-3", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #83", "CSF-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12084-4", new LoincTestItem("12084-4", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #84", "CSF-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12085-5", new LoincTestItem("12085-5", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #85", "CSF-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12086-6", new LoincTestItem("12086-6", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #86", "CSF-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12087-7", new LoincTestItem("12087-7", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #87", "CSF-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("12088-8", new LoincTestItem("12088-8", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #88", "CSF-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12089-9", new LoincTestItem("12089-9", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #89", "CSF-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("12090-1", new LoincTestItem("12090-1", "CSF Chemistry, Cell Count, Oligoclonal Bands Assay #90", "CSF-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
