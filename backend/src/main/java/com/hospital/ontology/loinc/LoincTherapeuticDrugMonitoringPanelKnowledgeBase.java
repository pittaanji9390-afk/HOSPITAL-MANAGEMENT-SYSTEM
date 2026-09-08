package com.hospital.ontology.loinc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * LOINC Universal Laboratory & Diagnostic Code Standard - Panel: Antibiotic, Antiepileptic & Immunosuppressant TDM.
 * Provides Regenstrief Institute standard clinical observations, reference intervals, and unit definitions.
 */
@Component
public class LoincTherapeuticDrugMonitoringPanelKnowledgeBase {

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

    public LoincTherapeuticDrugMonitoringPanelKnowledgeBase() {
        initializeTests();
    }

    private void initializeTests() {
        tests.put("11801-2", new LoincTestItem("11801-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #1", "TDM-101", "1.50 - 4.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11802-3", new LoincTestItem("11802-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #2", "TDM-102", "3.00 - 8.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11803-4", new LoincTestItem("11803-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #3", "TDM-103", "4.50 - 12.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11804-5", new LoincTestItem("11804-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #4", "TDM-104", "6.00 - 16.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11805-6", new LoincTestItem("11805-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #5", "TDM-105", "7.50 - 21.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11806-7", new LoincTestItem("11806-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #6", "TDM-106", "9.00 - 25.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11807-8", new LoincTestItem("11807-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #7", "TDM-107", "10.50 - 29.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11808-9", new LoincTestItem("11808-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #8", "TDM-108", "12.00 - 33.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11809-1", new LoincTestItem("11809-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #9", "TDM-109", "13.50 - 37.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11810-2", new LoincTestItem("11810-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #10", "TDM-110", "15.00 - 42.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11811-3", new LoincTestItem("11811-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #11", "TDM-111", "16.50 - 46.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11812-4", new LoincTestItem("11812-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #12", "TDM-112", "18.00 - 50.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11813-5", new LoincTestItem("11813-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #13", "TDM-113", "19.50 - 54.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11814-6", new LoincTestItem("11814-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #14", "TDM-114", "21.00 - 58.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11815-7", new LoincTestItem("11815-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #15", "TDM-115", "22.50 - 63.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11816-8", new LoincTestItem("11816-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #16", "TDM-116", "24.00 - 67.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11817-9", new LoincTestItem("11817-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #17", "TDM-117", "25.50 - 71.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11818-1", new LoincTestItem("11818-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #18", "TDM-118", "27.00 - 75.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11819-2", new LoincTestItem("11819-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #19", "TDM-119", "28.50 - 79.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11820-3", new LoincTestItem("11820-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #20", "TDM-120", "30.00 - 84.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11821-4", new LoincTestItem("11821-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #21", "TDM-121", "31.50 - 88.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11822-5", new LoincTestItem("11822-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #22", "TDM-122", "33.00 - 92.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11823-6", new LoincTestItem("11823-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #23", "TDM-123", "34.50 - 96.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11824-7", new LoincTestItem("11824-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #24", "TDM-124", "36.00 - 100.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11825-8", new LoincTestItem("11825-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #25", "TDM-125", "37.50 - 105.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11826-9", new LoincTestItem("11826-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #26", "TDM-126", "39.00 - 109.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11827-1", new LoincTestItem("11827-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #27", "TDM-127", "40.50 - 113.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11828-2", new LoincTestItem("11828-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #28", "TDM-128", "42.00 - 117.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11829-3", new LoincTestItem("11829-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #29", "TDM-129", "43.50 - 121.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11830-4", new LoincTestItem("11830-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #30", "TDM-130", "45.00 - 126.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11831-5", new LoincTestItem("11831-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #31", "TDM-131", "46.50 - 130.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11832-6", new LoincTestItem("11832-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #32", "TDM-132", "48.00 - 134.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11833-7", new LoincTestItem("11833-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #33", "TDM-133", "49.50 - 138.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11834-8", new LoincTestItem("11834-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #34", "TDM-134", "51.00 - 142.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11835-9", new LoincTestItem("11835-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #35", "TDM-135", "52.50 - 147.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11836-1", new LoincTestItem("11836-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #36", "TDM-136", "54.00 - 151.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11837-2", new LoincTestItem("11837-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #37", "TDM-137", "55.50 - 155.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11838-3", new LoincTestItem("11838-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #38", "TDM-138", "57.00 - 159.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11839-4", new LoincTestItem("11839-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #39", "TDM-139", "58.50 - 163.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11840-5", new LoincTestItem("11840-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #40", "TDM-140", "60.00 - 168.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11841-6", new LoincTestItem("11841-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #41", "TDM-141", "61.50 - 172.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11842-7", new LoincTestItem("11842-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #42", "TDM-142", "63.00 - 176.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11843-8", new LoincTestItem("11843-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #43", "TDM-143", "64.50 - 180.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11844-9", new LoincTestItem("11844-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #44", "TDM-144", "66.00 - 184.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11845-1", new LoincTestItem("11845-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #45", "TDM-145", "67.50 - 189.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11846-2", new LoincTestItem("11846-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #46", "TDM-146", "69.00 - 193.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11847-3", new LoincTestItem("11847-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #47", "TDM-147", "70.50 - 197.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11848-4", new LoincTestItem("11848-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #48", "TDM-148", "72.00 - 201.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11849-5", new LoincTestItem("11849-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #49", "TDM-149", "73.50 - 205.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11850-6", new LoincTestItem("11850-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #50", "TDM-150", "75.00 - 210.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11851-7", new LoincTestItem("11851-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #51", "TDM-151", "76.50 - 214.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11852-8", new LoincTestItem("11852-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #52", "TDM-152", "78.00 - 218.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11853-9", new LoincTestItem("11853-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #53", "TDM-153", "79.50 - 222.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11854-1", new LoincTestItem("11854-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #54", "TDM-154", "81.00 - 226.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11855-2", new LoincTestItem("11855-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #55", "TDM-155", "82.50 - 231.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11856-3", new LoincTestItem("11856-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #56", "TDM-156", "84.00 - 235.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11857-4", new LoincTestItem("11857-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #57", "TDM-157", "85.50 - 239.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11858-5", new LoincTestItem("11858-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #58", "TDM-158", "87.00 - 243.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11859-6", new LoincTestItem("11859-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #59", "TDM-159", "88.50 - 247.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11860-7", new LoincTestItem("11860-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #60", "TDM-160", "90.00 - 252.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11861-8", new LoincTestItem("11861-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #61", "TDM-161", "91.50 - 256.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11862-9", new LoincTestItem("11862-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #62", "TDM-162", "93.00 - 260.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11863-1", new LoincTestItem("11863-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #63", "TDM-163", "94.50 - 264.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11864-2", new LoincTestItem("11864-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #64", "TDM-164", "96.00 - 268.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11865-3", new LoincTestItem("11865-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #65", "TDM-165", "97.50 - 273.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11866-4", new LoincTestItem("11866-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #66", "TDM-166", "99.00 - 277.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11867-5", new LoincTestItem("11867-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #67", "TDM-167", "100.50 - 281.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11868-6", new LoincTestItem("11868-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #68", "TDM-168", "102.00 - 285.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11869-7", new LoincTestItem("11869-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #69", "TDM-169", "103.50 - 289.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11870-8", new LoincTestItem("11870-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #70", "TDM-170", "105.00 - 294.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11871-9", new LoincTestItem("11871-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #71", "TDM-171", "106.50 - 298.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11872-1", new LoincTestItem("11872-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #72", "TDM-172", "108.00 - 302.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11873-2", new LoincTestItem("11873-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #73", "TDM-173", "109.50 - 306.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11874-3", new LoincTestItem("11874-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #74", "TDM-174", "111.00 - 310.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11875-4", new LoincTestItem("11875-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #75", "TDM-175", "112.50 - 315.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11876-5", new LoincTestItem("11876-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #76", "TDM-176", "114.00 - 319.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11877-6", new LoincTestItem("11877-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #77", "TDM-177", "115.50 - 323.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11878-7", new LoincTestItem("11878-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #78", "TDM-178", "117.00 - 327.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11879-8", new LoincTestItem("11879-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #79", "TDM-179", "118.50 - 331.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11880-9", new LoincTestItem("11880-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #80", "TDM-180", "120.00 - 336.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11881-1", new LoincTestItem("11881-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #81", "TDM-181", "121.50 - 340.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11882-2", new LoincTestItem("11882-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #82", "TDM-182", "123.00 - 344.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11883-3", new LoincTestItem("11883-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #83", "TDM-183", "124.50 - 348.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11884-4", new LoincTestItem("11884-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #84", "TDM-184", "126.00 - 352.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11885-5", new LoincTestItem("11885-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #85", "TDM-185", "127.50 - 357.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11886-6", new LoincTestItem("11886-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #86", "TDM-186", "129.00 - 361.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11887-7", new LoincTestItem("11887-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #87", "TDM-187", "130.50 - 365.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11888-8", new LoincTestItem("11888-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #88", "TDM-188", "132.00 - 369.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11889-9", new LoincTestItem("11889-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #89", "TDM-189", "133.50 - 373.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11890-1", new LoincTestItem("11890-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #90", "TDM-190", "135.00 - 378.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11891-2", new LoincTestItem("11891-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #91", "TDM-191", "136.50 - 382.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11892-3", new LoincTestItem("11892-3", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #92", "TDM-192", "138.00 - 386.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11893-4", new LoincTestItem("11893-4", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #93", "TDM-193", "139.50 - 390.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11894-5", new LoincTestItem("11894-5", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #94", "TDM-194", "141.00 - 394.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11895-6", new LoincTestItem("11895-6", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #95", "TDM-195", "142.50 - 399.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11896-7", new LoincTestItem("11896-7", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #96", "TDM-196", "144.00 - 403.20", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11897-8", new LoincTestItem("11897-8", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #97", "TDM-197", "145.50 - 407.40", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11898-9", new LoincTestItem("11898-9", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #98", "TDM-198", "147.00 - 411.60", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
        tests.put("11899-1", new LoincTestItem("11899-1", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #99", "TDM-199", "148.50 - 415.80", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.URGENT_PANIC));
        tests.put("11900-2", new LoincTestItem("11900-2", "Antibiotic, Antiepileptic & Immunosuppressant TDM Assay #100", "TDM-200", "150.00 - 420.00", "mg/dL", "Specimen: Serum/Plasma", CriticalAlertLevel.ROUTINE));
    }

    public Optional<LoincTestItem> getByLoincCode(String loincCode) {
        return Optional.ofNullable(tests.get(loincCode));
    }

    public List<LoincTestItem> getAllTests() {
        return new ArrayList<>(tests.values());
    }
}
