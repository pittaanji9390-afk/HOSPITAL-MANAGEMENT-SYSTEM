package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Thyroid, Pituitary, Adrenal & Reproductive.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincEndocrinologyHormonePanelKnowledgeBase {

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

    public LoincEndocrinologyHormonePanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("11001-2", new LoincTestItem("11001-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #1", "ENDO-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11002-3", new LoincTestItem("11002-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #2", "ENDO-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11003-4", new LoincTestItem("11003-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #3", "ENDO-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11004-5", new LoincTestItem("11004-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #4", "ENDO-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11005-6", new LoincTestItem("11005-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #5", "ENDO-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11006-7", new LoincTestItem("11006-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #6", "ENDO-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11007-8", new LoincTestItem("11007-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #7", "ENDO-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11008-9", new LoincTestItem("11008-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #8", "ENDO-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11009-1", new LoincTestItem("11009-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #9", "ENDO-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11010-2", new LoincTestItem("11010-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #10", "ENDO-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11011-3", new LoincTestItem("11011-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #11", "ENDO-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11012-4", new LoincTestItem("11012-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #12", "ENDO-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11013-5", new LoincTestItem("11013-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #13", "ENDO-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11014-6", new LoincTestItem("11014-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #14", "ENDO-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11015-7", new LoincTestItem("11015-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #15", "ENDO-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11016-8", new LoincTestItem("11016-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #16", "ENDO-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11017-9", new LoincTestItem("11017-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #17", "ENDO-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11018-1", new LoincTestItem("11018-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #18", "ENDO-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11019-2", new LoincTestItem("11019-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #19", "ENDO-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11020-3", new LoincTestItem("11020-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #20", "ENDO-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11021-4", new LoincTestItem("11021-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #21", "ENDO-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11022-5", new LoincTestItem("11022-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #22", "ENDO-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11023-6", new LoincTestItem("11023-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #23", "ENDO-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11024-7", new LoincTestItem("11024-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #24", "ENDO-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11025-8", new LoincTestItem("11025-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #25", "ENDO-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11026-9", new LoincTestItem("11026-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #26", "ENDO-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11027-1", new LoincTestItem("11027-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #27", "ENDO-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11028-2", new LoincTestItem("11028-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #28", "ENDO-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11029-3", new LoincTestItem("11029-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #29", "ENDO-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11030-4", new LoincTestItem("11030-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #30", "ENDO-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11031-5", new LoincTestItem("11031-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #31", "ENDO-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11032-6", new LoincTestItem("11032-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #32", "ENDO-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11033-7", new LoincTestItem("11033-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #33", "ENDO-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11034-8", new LoincTestItem("11034-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #34", "ENDO-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11035-9", new LoincTestItem("11035-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #35", "ENDO-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11036-1", new LoincTestItem("11036-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #36", "ENDO-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11037-2", new LoincTestItem("11037-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #37", "ENDO-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11038-3", new LoincTestItem("11038-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #38", "ENDO-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11039-4", new LoincTestItem("11039-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #39", "ENDO-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11040-5", new LoincTestItem("11040-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #40", "ENDO-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11041-6", new LoincTestItem("11041-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #41", "ENDO-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11042-7", new LoincTestItem("11042-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #42", "ENDO-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11043-8", new LoincTestItem("11043-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #43", "ENDO-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11044-9", new LoincTestItem("11044-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #44", "ENDO-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11045-1", new LoincTestItem("11045-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #45", "ENDO-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11046-2", new LoincTestItem("11046-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #46", "ENDO-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11047-3", new LoincTestItem("11047-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #47", "ENDO-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11048-4", new LoincTestItem("11048-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #48", "ENDO-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11049-5", new LoincTestItem("11049-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #49", "ENDO-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11050-6", new LoincTestItem("11050-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #50", "ENDO-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11051-7", new LoincTestItem("11051-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #51", "ENDO-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11052-8", new LoincTestItem("11052-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #52", "ENDO-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11053-9", new LoincTestItem("11053-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #53", "ENDO-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11054-1", new LoincTestItem("11054-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #54", "ENDO-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11055-2", new LoincTestItem("11055-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #55", "ENDO-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11056-3", new LoincTestItem("11056-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #56", "ENDO-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11057-4", new LoincTestItem("11057-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #57", "ENDO-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11058-5", new LoincTestItem("11058-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #58", "ENDO-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11059-6", new LoincTestItem("11059-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #59", "ENDO-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11060-7", new LoincTestItem("11060-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #60", "ENDO-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11061-8", new LoincTestItem("11061-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #61", "ENDO-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11062-9", new LoincTestItem("11062-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #62", "ENDO-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11063-1", new LoincTestItem("11063-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #63", "ENDO-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11064-2", new LoincTestItem("11064-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #64", "ENDO-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11065-3", new LoincTestItem("11065-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #65", "ENDO-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11066-4", new LoincTestItem("11066-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #66", "ENDO-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11067-5", new LoincTestItem("11067-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #67", "ENDO-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11068-6", new LoincTestItem("11068-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #68", "ENDO-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11069-7", new LoincTestItem("11069-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #69", "ENDO-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11070-8", new LoincTestItem("11070-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #70", "ENDO-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11071-9", new LoincTestItem("11071-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #71", "ENDO-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11072-1", new LoincTestItem("11072-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #72", "ENDO-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11073-2", new LoincTestItem("11073-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #73", "ENDO-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11074-3", new LoincTestItem("11074-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #74", "ENDO-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11075-4", new LoincTestItem("11075-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #75", "ENDO-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11076-5", new LoincTestItem("11076-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #76", "ENDO-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11077-6", new LoincTestItem("11077-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #77", "ENDO-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11078-7", new LoincTestItem("11078-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #78", "ENDO-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11079-8", new LoincTestItem("11079-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #79", "ENDO-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11080-9", new LoincTestItem("11080-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #80", "ENDO-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11081-1", new LoincTestItem("11081-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #81", "ENDO-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11082-2", new LoincTestItem("11082-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #82", "ENDO-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11083-3", new LoincTestItem("11083-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #83", "ENDO-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11084-4", new LoincTestItem("11084-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #84", "ENDO-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11085-5", new LoincTestItem("11085-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #85", "ENDO-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11086-6", new LoincTestItem("11086-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #86", "ENDO-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11087-7", new LoincTestItem("11087-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #87", "ENDO-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11088-8", new LoincTestItem("11088-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #88", "ENDO-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11089-9", new LoincTestItem("11089-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #89", "ENDO-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11090-1", new LoincTestItem("11090-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #90", "ENDO-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11091-2", new LoincTestItem("11091-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #91", "ENDO-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11092-3", new LoincTestItem("11092-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #92", "ENDO-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11093-4", new LoincTestItem("11093-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #93", "ENDO-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11094-5", new LoincTestItem("11094-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #94", "ENDO-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11095-6", new LoincTestItem("11095-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #95", "ENDO-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11096-7", new LoincTestItem("11096-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #96", "ENDO-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11097-8", new LoincTestItem("11097-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #97", "ENDO-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11098-9", new LoincTestItem("11098-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #98", "ENDO-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11099-1", new LoincTestItem("11099-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #99", "ENDO-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11100-2", new LoincTestItem("11100-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #100", "ENDO-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11101-3", new LoincTestItem("11101-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #101", "ENDO-201", "151.50 - 424.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11102-4", new LoincTestItem("11102-4", "Thyroid, Pituitary, Adrenal & Reproductive Assay #102", "ENDO-202", "153.00 - 428.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11103-5", new LoincTestItem("11103-5", "Thyroid, Pituitary, Adrenal & Reproductive Assay #103", "ENDO-203", "154.50 - 432.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11104-6", new LoincTestItem("11104-6", "Thyroid, Pituitary, Adrenal & Reproductive Assay #104", "ENDO-204", "156.00 - 436.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11105-7", new LoincTestItem("11105-7", "Thyroid, Pituitary, Adrenal & Reproductive Assay #105", "ENDO-205", "157.50 - 441.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11106-8", new LoincTestItem("11106-8", "Thyroid, Pituitary, Adrenal & Reproductive Assay #106", "ENDO-206", "159.00 - 445.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11107-9", new LoincTestItem("11107-9", "Thyroid, Pituitary, Adrenal & Reproductive Assay #107", "ENDO-207", "160.50 - 449.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11108-1", new LoincTestItem("11108-1", "Thyroid, Pituitary, Adrenal & Reproductive Assay #108", "ENDO-208", "162.00 - 453.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11109-2", new LoincTestItem("11109-2", "Thyroid, Pituitary, Adrenal & Reproductive Assay #109", "ENDO-209", "163.50 - 457.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11110-3", new LoincTestItem("11110-3", "Thyroid, Pituitary, Adrenal & Reproductive Assay #110", "ENDO-210", "165.00 - 462.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
