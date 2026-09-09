package com.hospital.interoperability;

import com.hospital.interoperability.hl7.Hl7V2MessageEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Hl7EngineTest {

    private final Hl7V2MessageEngine engine = new Hl7V2MessageEngine();

    @Test
    @DisplayName("HL7 v2: Should successfully build standard ADT^A01 Inpatient Admission message")
    void testBuildAdtA01() {
        String hl7 = engine.buildAdtA01(
                "MRN-10001",
                "Anand",
                "Patil",
                "1982-06-14",
                "MALE",
                "74 Indiranagar^^Bengaluru^KA^560029",
                "+919845012345",
                "IPD-10001",
                "Dr. Rajesh Sharma",
                "CCU-301^BED-CCU-01^CCU",
                "Severe Unstable Angina"
        );

        assertNotNull(hl7);
        assertTrue(hl7.startsWith("MSH|^~\\&|APEX_HMS|APEX_MAIN|"));
        assertTrue(hl7.contains("ADT^A01"));
        assertTrue(hl7.contains("PID|1||MRN-10001^^^APEX_HOSPITAL^MR||Patil^Anand"));
        assertTrue(hl7.contains("PV1|1|I|CCU-301^BED-CCU-01^CCU"));
        assertTrue(hl7.contains("DG1|1|ICD-10|R69|Severe Unstable Angina"));
    }

    @Test
    @DisplayName("HL7 v2: Should parse raw HL7 message into structured segments and fields")
    void testParseHl7Message() {
        String rawHl7 = "MSH|^~\\&|LIS_APP|MAIN_LAB|HMS_APP|MAIN_HOSP|20260829120000||ORU^R01|CTRL-99881|P|2.5\r" +
                        "PID|1||MRN-10001^^^HOSP||Patil^Anand||19820614|M\r" +
                        "OBR|1|ORD-101|ORD-101-LIS|LAB-CBC^Complete Blood Count\r" +
                        "OBX|1|NM|718-7^Hemoglobin^LN||14.2|g/dL|13.5-17.5|N|||F\r";

        Hl7V2MessageEngine.Hl7Message msg = engine.parse(rawHl7);

        assertNotNull(msg);
        assertEquals("ORU^R01", msg.getMessageType());
        assertEquals("CTRL-99881", msg.getControlId());
        assertEquals("LIS_APP", msg.getSendingApplication());
        assertEquals(4, msg.getSegments().size());

        Hl7V2MessageEngine.Hl7Segment obx = msg.getSegments().get(3);
        assertEquals("OBX", obx.getSegmentId());
        assertEquals("NM", obx.getField(1)); // Field 2 in 1-based indexing
        assertEquals("14.2", obx.getField(4)); // Result Value
    }
}
