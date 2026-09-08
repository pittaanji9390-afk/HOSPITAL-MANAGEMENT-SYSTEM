package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: CBC Differential & Coagulation.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincHematologyCompleteBloodCountKnowledgeBase {

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

    public LoincHematologyCompleteBloodCountKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("10001-2", new LoincTestItem("10001-2", "CBC Differential & Coagulation Assay #1", "HEM-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10002-3", new LoincTestItem("10002-3", "CBC Differential & Coagulation Assay #2", "HEM-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10003-4", new LoincTestItem("10003-4", "CBC Differential & Coagulation Assay #3", "HEM-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10004-5", new LoincTestItem("10004-5", "CBC Differential & Coagulation Assay #4", "HEM-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10005-6", new LoincTestItem("10005-6", "CBC Differential & Coagulation Assay #5", "HEM-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10006-7", new LoincTestItem("10006-7", "CBC Differential & Coagulation Assay #6", "HEM-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10007-8", new LoincTestItem("10007-8", "CBC Differential & Coagulation Assay #7", "HEM-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10008-9", new LoincTestItem("10008-9", "CBC Differential & Coagulation Assay #8", "HEM-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10009-1", new LoincTestItem("10009-1", "CBC Differential & Coagulation Assay #9", "HEM-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10010-2", new LoincTestItem("10010-2", "CBC Differential & Coagulation Assay #10", "HEM-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10011-3", new LoincTestItem("10011-3", "CBC Differential & Coagulation Assay #11", "HEM-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10012-4", new LoincTestItem("10012-4", "CBC Differential & Coagulation Assay #12", "HEM-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10013-5", new LoincTestItem("10013-5", "CBC Differential & Coagulation Assay #13", "HEM-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10014-6", new LoincTestItem("10014-6", "CBC Differential & Coagulation Assay #14", "HEM-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10015-7", new LoincTestItem("10015-7", "CBC Differential & Coagulation Assay #15", "HEM-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10016-8", new LoincTestItem("10016-8", "CBC Differential & Coagulation Assay #16", "HEM-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10017-9", new LoincTestItem("10017-9", "CBC Differential & Coagulation Assay #17", "HEM-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10018-1", new LoincTestItem("10018-1", "CBC Differential & Coagulation Assay #18", "HEM-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10019-2", new LoincTestItem("10019-2", "CBC Differential & Coagulation Assay #19", "HEM-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10020-3", new LoincTestItem("10020-3", "CBC Differential & Coagulation Assay #20", "HEM-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10021-4", new LoincTestItem("10021-4", "CBC Differential & Coagulation Assay #21", "HEM-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10022-5", new LoincTestItem("10022-5", "CBC Differential & Coagulation Assay #22", "HEM-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10023-6", new LoincTestItem("10023-6", "CBC Differential & Coagulation Assay #23", "HEM-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10024-7", new LoincTestItem("10024-7", "CBC Differential & Coagulation Assay #24", "HEM-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10025-8", new LoincTestItem("10025-8", "CBC Differential & Coagulation Assay #25", "HEM-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10026-9", new LoincTestItem("10026-9", "CBC Differential & Coagulation Assay #26", "HEM-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10027-1", new LoincTestItem("10027-1", "CBC Differential & Coagulation Assay #27", "HEM-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10028-2", new LoincTestItem("10028-2", "CBC Differential & Coagulation Assay #28", "HEM-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10029-3", new LoincTestItem("10029-3", "CBC Differential & Coagulation Assay #29", "HEM-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10030-4", new LoincTestItem("10030-4", "CBC Differential & Coagulation Assay #30", "HEM-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10031-5", new LoincTestItem("10031-5", "CBC Differential & Coagulation Assay #31", "HEM-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10032-6", new LoincTestItem("10032-6", "CBC Differential & Coagulation Assay #32", "HEM-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10033-7", new LoincTestItem("10033-7", "CBC Differential & Coagulation Assay #33", "HEM-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10034-8", new LoincTestItem("10034-8", "CBC Differential & Coagulation Assay #34", "HEM-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10035-9", new LoincTestItem("10035-9", "CBC Differential & Coagulation Assay #35", "HEM-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10036-1", new LoincTestItem("10036-1", "CBC Differential & Coagulation Assay #36", "HEM-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10037-2", new LoincTestItem("10037-2", "CBC Differential & Coagulation Assay #37", "HEM-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10038-3", new LoincTestItem("10038-3", "CBC Differential & Coagulation Assay #38", "HEM-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10039-4", new LoincTestItem("10039-4", "CBC Differential & Coagulation Assay #39", "HEM-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10040-5", new LoincTestItem("10040-5", "CBC Differential & Coagulation Assay #40", "HEM-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10041-6", new LoincTestItem("10041-6", "CBC Differential & Coagulation Assay #41", "HEM-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10042-7", new LoincTestItem("10042-7", "CBC Differential & Coagulation Assay #42", "HEM-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10043-8", new LoincTestItem("10043-8", "CBC Differential & Coagulation Assay #43", "HEM-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10044-9", new LoincTestItem("10044-9", "CBC Differential & Coagulation Assay #44", "HEM-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10045-1", new LoincTestItem("10045-1", "CBC Differential & Coagulation Assay #45", "HEM-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10046-2", new LoincTestItem("10046-2", "CBC Differential & Coagulation Assay #46", "HEM-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10047-3", new LoincTestItem("10047-3", "CBC Differential & Coagulation Assay #47", "HEM-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10048-4", new LoincTestItem("10048-4", "CBC Differential & Coagulation Assay #48", "HEM-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10049-5", new LoincTestItem("10049-5", "CBC Differential & Coagulation Assay #49", "HEM-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10050-6", new LoincTestItem("10050-6", "CBC Differential & Coagulation Assay #50", "HEM-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10051-7", new LoincTestItem("10051-7", "CBC Differential & Coagulation Assay #51", "HEM-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10052-8", new LoincTestItem("10052-8", "CBC Differential & Coagulation Assay #52", "HEM-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10053-9", new LoincTestItem("10053-9", "CBC Differential & Coagulation Assay #53", "HEM-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10054-1", new LoincTestItem("10054-1", "CBC Differential & Coagulation Assay #54", "HEM-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10055-2", new LoincTestItem("10055-2", "CBC Differential & Coagulation Assay #55", "HEM-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10056-3", new LoincTestItem("10056-3", "CBC Differential & Coagulation Assay #56", "HEM-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10057-4", new LoincTestItem("10057-4", "CBC Differential & Coagulation Assay #57", "HEM-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10058-5", new LoincTestItem("10058-5", "CBC Differential & Coagulation Assay #58", "HEM-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10059-6", new LoincTestItem("10059-6", "CBC Differential & Coagulation Assay #59", "HEM-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10060-7", new LoincTestItem("10060-7", "CBC Differential & Coagulation Assay #60", "HEM-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10061-8", new LoincTestItem("10061-8", "CBC Differential & Coagulation Assay #61", "HEM-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10062-9", new LoincTestItem("10062-9", "CBC Differential & Coagulation Assay #62", "HEM-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10063-1", new LoincTestItem("10063-1", "CBC Differential & Coagulation Assay #63", "HEM-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10064-2", new LoincTestItem("10064-2", "CBC Differential & Coagulation Assay #64", "HEM-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10065-3", new LoincTestItem("10065-3", "CBC Differential & Coagulation Assay #65", "HEM-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10066-4", new LoincTestItem("10066-4", "CBC Differential & Coagulation Assay #66", "HEM-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10067-5", new LoincTestItem("10067-5", "CBC Differential & Coagulation Assay #67", "HEM-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10068-6", new LoincTestItem("10068-6", "CBC Differential & Coagulation Assay #68", "HEM-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10069-7", new LoincTestItem("10069-7", "CBC Differential & Coagulation Assay #69", "HEM-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10070-8", new LoincTestItem("10070-8", "CBC Differential & Coagulation Assay #70", "HEM-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10071-9", new LoincTestItem("10071-9", "CBC Differential & Coagulation Assay #71", "HEM-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10072-1", new LoincTestItem("10072-1", "CBC Differential & Coagulation Assay #72", "HEM-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10073-2", new LoincTestItem("10073-2", "CBC Differential & Coagulation Assay #73", "HEM-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10074-3", new LoincTestItem("10074-3", "CBC Differential & Coagulation Assay #74", "HEM-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10075-4", new LoincTestItem("10075-4", "CBC Differential & Coagulation Assay #75", "HEM-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10076-5", new LoincTestItem("10076-5", "CBC Differential & Coagulation Assay #76", "HEM-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10077-6", new LoincTestItem("10077-6", "CBC Differential & Coagulation Assay #77", "HEM-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10078-7", new LoincTestItem("10078-7", "CBC Differential & Coagulation Assay #78", "HEM-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10079-8", new LoincTestItem("10079-8", "CBC Differential & Coagulation Assay #79", "HEM-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10080-9", new LoincTestItem("10080-9", "CBC Differential & Coagulation Assay #80", "HEM-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10081-1", new LoincTestItem("10081-1", "CBC Differential & Coagulation Assay #81", "HEM-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10082-2", new LoincTestItem("10082-2", "CBC Differential & Coagulation Assay #82", "HEM-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10083-3", new LoincTestItem("10083-3", "CBC Differential & Coagulation Assay #83", "HEM-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10084-4", new LoincTestItem("10084-4", "CBC Differential & Coagulation Assay #84", "HEM-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10085-5", new LoincTestItem("10085-5", "CBC Differential & Coagulation Assay #85", "HEM-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10086-6", new LoincTestItem("10086-6", "CBC Differential & Coagulation Assay #86", "HEM-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10087-7", new LoincTestItem("10087-7", "CBC Differential & Coagulation Assay #87", "HEM-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10088-8", new LoincTestItem("10088-8", "CBC Differential & Coagulation Assay #88", "HEM-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10089-9", new LoincTestItem("10089-9", "CBC Differential & Coagulation Assay #89", "HEM-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10090-1", new LoincTestItem("10090-1", "CBC Differential & Coagulation Assay #90", "HEM-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10091-2", new LoincTestItem("10091-2", "CBC Differential & Coagulation Assay #91", "HEM-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10092-3", new LoincTestItem("10092-3", "CBC Differential & Coagulation Assay #92", "HEM-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10093-4", new LoincTestItem("10093-4", "CBC Differential & Coagulation Assay #93", "HEM-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10094-5", new LoincTestItem("10094-5", "CBC Differential & Coagulation Assay #94", "HEM-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10095-6", new LoincTestItem("10095-6", "CBC Differential & Coagulation Assay #95", "HEM-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10096-7", new LoincTestItem("10096-7", "CBC Differential & Coagulation Assay #96", "HEM-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10097-8", new LoincTestItem("10097-8", "CBC Differential & Coagulation Assay #97", "HEM-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10098-9", new LoincTestItem("10098-9", "CBC Differential & Coagulation Assay #98", "HEM-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10099-1", new LoincTestItem("10099-1", "CBC Differential & Coagulation Assay #99", "HEM-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10100-2", new LoincTestItem("10100-2", "CBC Differential & Coagulation Assay #100", "HEM-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10101-3", new LoincTestItem("10101-3", "CBC Differential & Coagulation Assay #101", "HEM-201", "151.50 - 424.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10102-4", new LoincTestItem("10102-4", "CBC Differential & Coagulation Assay #102", "HEM-202", "153.00 - 428.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10103-5", new LoincTestItem("10103-5", "CBC Differential & Coagulation Assay #103", "HEM-203", "154.50 - 432.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10104-6", new LoincTestItem("10104-6", "CBC Differential & Coagulation Assay #104", "HEM-204", "156.00 - 436.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10105-7", new LoincTestItem("10105-7", "CBC Differential & Coagulation Assay #105", "HEM-205", "157.50 - 441.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10106-8", new LoincTestItem("10106-8", "CBC Differential & Coagulation Assay #106", "HEM-206", "159.00 - 445.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10107-9", new LoincTestItem("10107-9", "CBC Differential & Coagulation Assay #107", "HEM-207", "160.50 - 449.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10108-1", new LoincTestItem("10108-1", "CBC Differential & Coagulation Assay #108", "HEM-208", "162.00 - 453.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10109-2", new LoincTestItem("10109-2", "CBC Differential & Coagulation Assay #109", "HEM-209", "163.50 - 457.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10110-3", new LoincTestItem("10110-3", "CBC Differential & Coagulation Assay #110", "HEM-210", "165.00 - 462.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10111-4", new LoincTestItem("10111-4", "CBC Differential & Coagulation Assay #111", "HEM-211", "166.50 - 466.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10112-5", new LoincTestItem("10112-5", "CBC Differential & Coagulation Assay #112", "HEM-212", "168.00 - 470.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10113-6", new LoincTestItem("10113-6", "CBC Differential & Coagulation Assay #113", "HEM-213", "169.50 - 474.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10114-7", new LoincTestItem("10114-7", "CBC Differential & Coagulation Assay #114", "HEM-214", "171.00 - 478.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10115-8", new LoincTestItem("10115-8", "CBC Differential & Coagulation Assay #115", "HEM-215", "172.50 - 483.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10116-9", new LoincTestItem("10116-9", "CBC Differential & Coagulation Assay #116", "HEM-216", "174.00 - 487.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10117-1", new LoincTestItem("10117-1", "CBC Differential & Coagulation Assay #117", "HEM-217", "175.50 - 491.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10118-2", new LoincTestItem("10118-2", "CBC Differential & Coagulation Assay #118", "HEM-218", "177.00 - 495.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10119-3", new LoincTestItem("10119-3", "CBC Differential & Coagulation Assay #119", "HEM-219", "178.50 - 499.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10120-4", new LoincTestItem("10120-4", "CBC Differential & Coagulation Assay #120", "HEM-220", "180.00 - 504.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
