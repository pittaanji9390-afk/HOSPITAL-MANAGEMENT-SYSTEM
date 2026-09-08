package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: NGS Oncology Panel & Pharmacogenomics.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincMolecularPathologyGenomicsPanelKnowledgeBase {

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

    public LoincMolecularPathologyGenomicsPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("11401-2", new LoincTestItem("11401-2", "NGS Oncology Panel & Pharmacogenomics Assay #1", "MOL-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11402-3", new LoincTestItem("11402-3", "NGS Oncology Panel & Pharmacogenomics Assay #2", "MOL-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11403-4", new LoincTestItem("11403-4", "NGS Oncology Panel & Pharmacogenomics Assay #3", "MOL-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11404-5", new LoincTestItem("11404-5", "NGS Oncology Panel & Pharmacogenomics Assay #4", "MOL-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11405-6", new LoincTestItem("11405-6", "NGS Oncology Panel & Pharmacogenomics Assay #5", "MOL-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11406-7", new LoincTestItem("11406-7", "NGS Oncology Panel & Pharmacogenomics Assay #6", "MOL-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11407-8", new LoincTestItem("11407-8", "NGS Oncology Panel & Pharmacogenomics Assay #7", "MOL-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11408-9", new LoincTestItem("11408-9", "NGS Oncology Panel & Pharmacogenomics Assay #8", "MOL-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11409-1", new LoincTestItem("11409-1", "NGS Oncology Panel & Pharmacogenomics Assay #9", "MOL-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11410-2", new LoincTestItem("11410-2", "NGS Oncology Panel & Pharmacogenomics Assay #10", "MOL-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11411-3", new LoincTestItem("11411-3", "NGS Oncology Panel & Pharmacogenomics Assay #11", "MOL-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11412-4", new LoincTestItem("11412-4", "NGS Oncology Panel & Pharmacogenomics Assay #12", "MOL-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11413-5", new LoincTestItem("11413-5", "NGS Oncology Panel & Pharmacogenomics Assay #13", "MOL-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11414-6", new LoincTestItem("11414-6", "NGS Oncology Panel & Pharmacogenomics Assay #14", "MOL-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11415-7", new LoincTestItem("11415-7", "NGS Oncology Panel & Pharmacogenomics Assay #15", "MOL-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11416-8", new LoincTestItem("11416-8", "NGS Oncology Panel & Pharmacogenomics Assay #16", "MOL-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11417-9", new LoincTestItem("11417-9", "NGS Oncology Panel & Pharmacogenomics Assay #17", "MOL-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11418-1", new LoincTestItem("11418-1", "NGS Oncology Panel & Pharmacogenomics Assay #18", "MOL-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11419-2", new LoincTestItem("11419-2", "NGS Oncology Panel & Pharmacogenomics Assay #19", "MOL-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11420-3", new LoincTestItem("11420-3", "NGS Oncology Panel & Pharmacogenomics Assay #20", "MOL-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11421-4", new LoincTestItem("11421-4", "NGS Oncology Panel & Pharmacogenomics Assay #21", "MOL-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11422-5", new LoincTestItem("11422-5", "NGS Oncology Panel & Pharmacogenomics Assay #22", "MOL-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11423-6", new LoincTestItem("11423-6", "NGS Oncology Panel & Pharmacogenomics Assay #23", "MOL-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11424-7", new LoincTestItem("11424-7", "NGS Oncology Panel & Pharmacogenomics Assay #24", "MOL-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11425-8", new LoincTestItem("11425-8", "NGS Oncology Panel & Pharmacogenomics Assay #25", "MOL-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11426-9", new LoincTestItem("11426-9", "NGS Oncology Panel & Pharmacogenomics Assay #26", "MOL-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11427-1", new LoincTestItem("11427-1", "NGS Oncology Panel & Pharmacogenomics Assay #27", "MOL-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11428-2", new LoincTestItem("11428-2", "NGS Oncology Panel & Pharmacogenomics Assay #28", "MOL-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11429-3", new LoincTestItem("11429-3", "NGS Oncology Panel & Pharmacogenomics Assay #29", "MOL-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11430-4", new LoincTestItem("11430-4", "NGS Oncology Panel & Pharmacogenomics Assay #30", "MOL-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11431-5", new LoincTestItem("11431-5", "NGS Oncology Panel & Pharmacogenomics Assay #31", "MOL-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11432-6", new LoincTestItem("11432-6", "NGS Oncology Panel & Pharmacogenomics Assay #32", "MOL-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11433-7", new LoincTestItem("11433-7", "NGS Oncology Panel & Pharmacogenomics Assay #33", "MOL-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11434-8", new LoincTestItem("11434-8", "NGS Oncology Panel & Pharmacogenomics Assay #34", "MOL-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11435-9", new LoincTestItem("11435-9", "NGS Oncology Panel & Pharmacogenomics Assay #35", "MOL-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11436-1", new LoincTestItem("11436-1", "NGS Oncology Panel & Pharmacogenomics Assay #36", "MOL-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11437-2", new LoincTestItem("11437-2", "NGS Oncology Panel & Pharmacogenomics Assay #37", "MOL-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11438-3", new LoincTestItem("11438-3", "NGS Oncology Panel & Pharmacogenomics Assay #38", "MOL-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11439-4", new LoincTestItem("11439-4", "NGS Oncology Panel & Pharmacogenomics Assay #39", "MOL-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11440-5", new LoincTestItem("11440-5", "NGS Oncology Panel & Pharmacogenomics Assay #40", "MOL-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11441-6", new LoincTestItem("11441-6", "NGS Oncology Panel & Pharmacogenomics Assay #41", "MOL-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11442-7", new LoincTestItem("11442-7", "NGS Oncology Panel & Pharmacogenomics Assay #42", "MOL-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11443-8", new LoincTestItem("11443-8", "NGS Oncology Panel & Pharmacogenomics Assay #43", "MOL-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11444-9", new LoincTestItem("11444-9", "NGS Oncology Panel & Pharmacogenomics Assay #44", "MOL-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11445-1", new LoincTestItem("11445-1", "NGS Oncology Panel & Pharmacogenomics Assay #45", "MOL-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11446-2", new LoincTestItem("11446-2", "NGS Oncology Panel & Pharmacogenomics Assay #46", "MOL-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11447-3", new LoincTestItem("11447-3", "NGS Oncology Panel & Pharmacogenomics Assay #47", "MOL-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11448-4", new LoincTestItem("11448-4", "NGS Oncology Panel & Pharmacogenomics Assay #48", "MOL-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11449-5", new LoincTestItem("11449-5", "NGS Oncology Panel & Pharmacogenomics Assay #49", "MOL-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11450-6", new LoincTestItem("11450-6", "NGS Oncology Panel & Pharmacogenomics Assay #50", "MOL-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11451-7", new LoincTestItem("11451-7", "NGS Oncology Panel & Pharmacogenomics Assay #51", "MOL-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11452-8", new LoincTestItem("11452-8", "NGS Oncology Panel & Pharmacogenomics Assay #52", "MOL-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11453-9", new LoincTestItem("11453-9", "NGS Oncology Panel & Pharmacogenomics Assay #53", "MOL-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11454-1", new LoincTestItem("11454-1", "NGS Oncology Panel & Pharmacogenomics Assay #54", "MOL-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11455-2", new LoincTestItem("11455-2", "NGS Oncology Panel & Pharmacogenomics Assay #55", "MOL-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11456-3", new LoincTestItem("11456-3", "NGS Oncology Panel & Pharmacogenomics Assay #56", "MOL-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11457-4", new LoincTestItem("11457-4", "NGS Oncology Panel & Pharmacogenomics Assay #57", "MOL-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11458-5", new LoincTestItem("11458-5", "NGS Oncology Panel & Pharmacogenomics Assay #58", "MOL-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11459-6", new LoincTestItem("11459-6", "NGS Oncology Panel & Pharmacogenomics Assay #59", "MOL-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11460-7", new LoincTestItem("11460-7", "NGS Oncology Panel & Pharmacogenomics Assay #60", "MOL-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11461-8", new LoincTestItem("11461-8", "NGS Oncology Panel & Pharmacogenomics Assay #61", "MOL-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11462-9", new LoincTestItem("11462-9", "NGS Oncology Panel & Pharmacogenomics Assay #62", "MOL-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11463-1", new LoincTestItem("11463-1", "NGS Oncology Panel & Pharmacogenomics Assay #63", "MOL-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11464-2", new LoincTestItem("11464-2", "NGS Oncology Panel & Pharmacogenomics Assay #64", "MOL-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11465-3", new LoincTestItem("11465-3", "NGS Oncology Panel & Pharmacogenomics Assay #65", "MOL-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11466-4", new LoincTestItem("11466-4", "NGS Oncology Panel & Pharmacogenomics Assay #66", "MOL-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11467-5", new LoincTestItem("11467-5", "NGS Oncology Panel & Pharmacogenomics Assay #67", "MOL-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11468-6", new LoincTestItem("11468-6", "NGS Oncology Panel & Pharmacogenomics Assay #68", "MOL-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11469-7", new LoincTestItem("11469-7", "NGS Oncology Panel & Pharmacogenomics Assay #69", "MOL-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11470-8", new LoincTestItem("11470-8", "NGS Oncology Panel & Pharmacogenomics Assay #70", "MOL-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11471-9", new LoincTestItem("11471-9", "NGS Oncology Panel & Pharmacogenomics Assay #71", "MOL-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11472-1", new LoincTestItem("11472-1", "NGS Oncology Panel & Pharmacogenomics Assay #72", "MOL-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11473-2", new LoincTestItem("11473-2", "NGS Oncology Panel & Pharmacogenomics Assay #73", "MOL-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11474-3", new LoincTestItem("11474-3", "NGS Oncology Panel & Pharmacogenomics Assay #74", "MOL-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11475-4", new LoincTestItem("11475-4", "NGS Oncology Panel & Pharmacogenomics Assay #75", "MOL-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11476-5", new LoincTestItem("11476-5", "NGS Oncology Panel & Pharmacogenomics Assay #76", "MOL-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11477-6", new LoincTestItem("11477-6", "NGS Oncology Panel & Pharmacogenomics Assay #77", "MOL-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11478-7", new LoincTestItem("11478-7", "NGS Oncology Panel & Pharmacogenomics Assay #78", "MOL-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11479-8", new LoincTestItem("11479-8", "NGS Oncology Panel & Pharmacogenomics Assay #79", "MOL-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11480-9", new LoincTestItem("11480-9", "NGS Oncology Panel & Pharmacogenomics Assay #80", "MOL-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11481-1", new LoincTestItem("11481-1", "NGS Oncology Panel & Pharmacogenomics Assay #81", "MOL-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11482-2", new LoincTestItem("11482-2", "NGS Oncology Panel & Pharmacogenomics Assay #82", "MOL-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11483-3", new LoincTestItem("11483-3", "NGS Oncology Panel & Pharmacogenomics Assay #83", "MOL-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11484-4", new LoincTestItem("11484-4", "NGS Oncology Panel & Pharmacogenomics Assay #84", "MOL-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11485-5", new LoincTestItem("11485-5", "NGS Oncology Panel & Pharmacogenomics Assay #85", "MOL-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11486-6", new LoincTestItem("11486-6", "NGS Oncology Panel & Pharmacogenomics Assay #86", "MOL-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11487-7", new LoincTestItem("11487-7", "NGS Oncology Panel & Pharmacogenomics Assay #87", "MOL-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11488-8", new LoincTestItem("11488-8", "NGS Oncology Panel & Pharmacogenomics Assay #88", "MOL-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11489-9", new LoincTestItem("11489-9", "NGS Oncology Panel & Pharmacogenomics Assay #89", "MOL-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11490-1", new LoincTestItem("11490-1", "NGS Oncology Panel & Pharmacogenomics Assay #90", "MOL-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11491-2", new LoincTestItem("11491-2", "NGS Oncology Panel & Pharmacogenomics Assay #91", "MOL-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11492-3", new LoincTestItem("11492-3", "NGS Oncology Panel & Pharmacogenomics Assay #92", "MOL-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11493-4", new LoincTestItem("11493-4", "NGS Oncology Panel & Pharmacogenomics Assay #93", "MOL-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11494-5", new LoincTestItem("11494-5", "NGS Oncology Panel & Pharmacogenomics Assay #94", "MOL-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11495-6", new LoincTestItem("11495-6", "NGS Oncology Panel & Pharmacogenomics Assay #95", "MOL-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11496-7", new LoincTestItem("11496-7", "NGS Oncology Panel & Pharmacogenomics Assay #96", "MOL-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11497-8", new LoincTestItem("11497-8", "NGS Oncology Panel & Pharmacogenomics Assay #97", "MOL-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11498-9", new LoincTestItem("11498-9", "NGS Oncology Panel & Pharmacogenomics Assay #98", "MOL-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11499-1", new LoincTestItem("11499-1", "NGS Oncology Panel & Pharmacogenomics Assay #99", "MOL-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11500-2", new LoincTestItem("11500-2", "NGS Oncology Panel & Pharmacogenomics Assay #100", "MOL-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
