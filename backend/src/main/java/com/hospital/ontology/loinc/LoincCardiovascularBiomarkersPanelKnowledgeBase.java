package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Troponin, NT-proBNP & Lipid Subfractions.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincCardiovascularBiomarkersPanelKnowledgeBase {

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

    public LoincCardiovascularBiomarkersPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("10401-2", new LoincTestItem("10401-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #1", "CARD-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10402-3", new LoincTestItem("10402-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #2", "CARD-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10403-4", new LoincTestItem("10403-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #3", "CARD-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10404-5", new LoincTestItem("10404-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #4", "CARD-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10405-6", new LoincTestItem("10405-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #5", "CARD-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10406-7", new LoincTestItem("10406-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #6", "CARD-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10407-8", new LoincTestItem("10407-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #7", "CARD-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10408-9", new LoincTestItem("10408-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #8", "CARD-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10409-1", new LoincTestItem("10409-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #9", "CARD-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10410-2", new LoincTestItem("10410-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #10", "CARD-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10411-3", new LoincTestItem("10411-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #11", "CARD-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10412-4", new LoincTestItem("10412-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #12", "CARD-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10413-5", new LoincTestItem("10413-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #13", "CARD-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10414-6", new LoincTestItem("10414-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #14", "CARD-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10415-7", new LoincTestItem("10415-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #15", "CARD-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10416-8", new LoincTestItem("10416-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #16", "CARD-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10417-9", new LoincTestItem("10417-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #17", "CARD-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10418-1", new LoincTestItem("10418-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #18", "CARD-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10419-2", new LoincTestItem("10419-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #19", "CARD-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10420-3", new LoincTestItem("10420-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #20", "CARD-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10421-4", new LoincTestItem("10421-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #21", "CARD-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10422-5", new LoincTestItem("10422-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #22", "CARD-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10423-6", new LoincTestItem("10423-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #23", "CARD-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10424-7", new LoincTestItem("10424-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #24", "CARD-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10425-8", new LoincTestItem("10425-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #25", "CARD-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10426-9", new LoincTestItem("10426-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #26", "CARD-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10427-1", new LoincTestItem("10427-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #27", "CARD-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10428-2", new LoincTestItem("10428-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #28", "CARD-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10429-3", new LoincTestItem("10429-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #29", "CARD-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10430-4", new LoincTestItem("10430-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #30", "CARD-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10431-5", new LoincTestItem("10431-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #31", "CARD-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10432-6", new LoincTestItem("10432-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #32", "CARD-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10433-7", new LoincTestItem("10433-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #33", "CARD-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10434-8", new LoincTestItem("10434-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #34", "CARD-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10435-9", new LoincTestItem("10435-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #35", "CARD-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10436-1", new LoincTestItem("10436-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #36", "CARD-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10437-2", new LoincTestItem("10437-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #37", "CARD-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10438-3", new LoincTestItem("10438-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #38", "CARD-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10439-4", new LoincTestItem("10439-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #39", "CARD-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10440-5", new LoincTestItem("10440-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #40", "CARD-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10441-6", new LoincTestItem("10441-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #41", "CARD-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10442-7", new LoincTestItem("10442-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #42", "CARD-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10443-8", new LoincTestItem("10443-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #43", "CARD-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10444-9", new LoincTestItem("10444-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #44", "CARD-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10445-1", new LoincTestItem("10445-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #45", "CARD-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10446-2", new LoincTestItem("10446-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #46", "CARD-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10447-3", new LoincTestItem("10447-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #47", "CARD-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10448-4", new LoincTestItem("10448-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #48", "CARD-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10449-5", new LoincTestItem("10449-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #49", "CARD-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10450-6", new LoincTestItem("10450-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #50", "CARD-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10451-7", new LoincTestItem("10451-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #51", "CARD-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10452-8", new LoincTestItem("10452-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #52", "CARD-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10453-9", new LoincTestItem("10453-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #53", "CARD-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10454-1", new LoincTestItem("10454-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #54", "CARD-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10455-2", new LoincTestItem("10455-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #55", "CARD-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10456-3", new LoincTestItem("10456-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #56", "CARD-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10457-4", new LoincTestItem("10457-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #57", "CARD-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10458-5", new LoincTestItem("10458-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #58", "CARD-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10459-6", new LoincTestItem("10459-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #59", "CARD-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10460-7", new LoincTestItem("10460-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #60", "CARD-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10461-8", new LoincTestItem("10461-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #61", "CARD-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10462-9", new LoincTestItem("10462-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #62", "CARD-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10463-1", new LoincTestItem("10463-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #63", "CARD-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10464-2", new LoincTestItem("10464-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #64", "CARD-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10465-3", new LoincTestItem("10465-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #65", "CARD-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10466-4", new LoincTestItem("10466-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #66", "CARD-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10467-5", new LoincTestItem("10467-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #67", "CARD-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10468-6", new LoincTestItem("10468-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #68", "CARD-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10469-7", new LoincTestItem("10469-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #69", "CARD-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10470-8", new LoincTestItem("10470-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #70", "CARD-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10471-9", new LoincTestItem("10471-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #71", "CARD-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10472-1", new LoincTestItem("10472-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #72", "CARD-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10473-2", new LoincTestItem("10473-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #73", "CARD-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10474-3", new LoincTestItem("10474-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #74", "CARD-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10475-4", new LoincTestItem("10475-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #75", "CARD-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10476-5", new LoincTestItem("10476-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #76", "CARD-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10477-6", new LoincTestItem("10477-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #77", "CARD-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10478-7", new LoincTestItem("10478-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #78", "CARD-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10479-8", new LoincTestItem("10479-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #79", "CARD-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10480-9", new LoincTestItem("10480-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #80", "CARD-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10481-1", new LoincTestItem("10481-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #81", "CARD-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10482-2", new LoincTestItem("10482-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #82", "CARD-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10483-3", new LoincTestItem("10483-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #83", "CARD-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10484-4", new LoincTestItem("10484-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #84", "CARD-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10485-5", new LoincTestItem("10485-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #85", "CARD-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10486-6", new LoincTestItem("10486-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #86", "CARD-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10487-7", new LoincTestItem("10487-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #87", "CARD-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10488-8", new LoincTestItem("10488-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #88", "CARD-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10489-9", new LoincTestItem("10489-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #89", "CARD-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10490-1", new LoincTestItem("10490-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #90", "CARD-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10491-2", new LoincTestItem("10491-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #91", "CARD-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10492-3", new LoincTestItem("10492-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #92", "CARD-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10493-4", new LoincTestItem("10493-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #93", "CARD-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10494-5", new LoincTestItem("10494-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #94", "CARD-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10495-6", new LoincTestItem("10495-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #95", "CARD-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10496-7", new LoincTestItem("10496-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #96", "CARD-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10497-8", new LoincTestItem("10497-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #97", "CARD-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10498-9", new LoincTestItem("10498-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #98", "CARD-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10499-1", new LoincTestItem("10499-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #99", "CARD-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10500-2", new LoincTestItem("10500-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #100", "CARD-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10501-3", new LoincTestItem("10501-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #101", "CARD-201", "151.50 - 424.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10502-4", new LoincTestItem("10502-4", "Troponin, NT-proBNP & Lipid Subfractions Assay #102", "CARD-202", "153.00 - 428.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10503-5", new LoincTestItem("10503-5", "Troponin, NT-proBNP & Lipid Subfractions Assay #103", "CARD-203", "154.50 - 432.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10504-6", new LoincTestItem("10504-6", "Troponin, NT-proBNP & Lipid Subfractions Assay #104", "CARD-204", "156.00 - 436.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10505-7", new LoincTestItem("10505-7", "Troponin, NT-proBNP & Lipid Subfractions Assay #105", "CARD-205", "157.50 - 441.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10506-8", new LoincTestItem("10506-8", "Troponin, NT-proBNP & Lipid Subfractions Assay #106", "CARD-206", "159.00 - 445.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10507-9", new LoincTestItem("10507-9", "Troponin, NT-proBNP & Lipid Subfractions Assay #107", "CARD-207", "160.50 - 449.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10508-1", new LoincTestItem("10508-1", "Troponin, NT-proBNP & Lipid Subfractions Assay #108", "CARD-208", "162.00 - 453.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("10509-2", new LoincTestItem("10509-2", "Troponin, NT-proBNP & Lipid Subfractions Assay #109", "CARD-209", "163.50 - 457.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("10510-3", new LoincTestItem("10510-3", "Troponin, NT-proBNP & Lipid Subfractions Assay #110", "CARD-210", "165.00 - 462.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
