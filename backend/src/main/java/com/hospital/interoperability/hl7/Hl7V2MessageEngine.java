package com.hospital.interoperability.hl7;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Enterprise HL7 v2.5 / v2.8 Standard Healthcare Message Processing Engine.
 * Supports ADT (Admit, Discharge, Transfer), ORM (Order Messages), ORU (Observation Results),
 * and DFT (Detailed Financial Transactions) without third-party dependencies.
 */
@Component
public class Hl7V2MessageEngine {

    private static final DateTimeFormatter HL7_TS_FMT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Data
    @Builder
    public static class Hl7Segment {
        private String segmentId;
        private List<String> fields;

        public String getField(int index) {
            if (index >= 0 && index < fields.size()) {
                return fields.get(index);
            }
            return "";
        }

        public String toHl7String() {
            return segmentId + "|" + String.join("|", fields);
        }
    }

    @Data
    @Builder
    public static class Hl7Message {
        private String messageType;      // ADT^A01, ADT^A08, ORM^O01, ORU^R01, DFT^P03
        private String controlId;
        private String sendingApplication;
        private String sendingFacility;
        private String receivingApplication;
        private String receivingFacility;
        private String timestamp;
        private String version;          // 2.5
        private List<Hl7Segment> segments;

        public String encode() {
            StringBuilder sb = new StringBuilder();
            // MSH segment
            sb.append("MSH|^~\\&|").append(sendingApplication).append("|").append(sendingFacility)
                    .append("|").append(receivingApplication).append("|").append(receivingFacility)
                    .append("|").append(timestamp).append("||").append(messageType).append("|")
                    .append(controlId).append("|P|").append(version != null ? version : "2.5").append("\r");

            for (Hl7Segment seg : segments) {
                if (!"MSH".equalsIgnoreCase(seg.getSegmentId())) {
                    sb.append(seg.toHl7String()).append("\r");
                }
            }
            return sb.toString();
        }
    }

    /**
     * Parses a raw HL7 v2.x ER7 formatted string into an Hl7Message data structure.
     */
    public Hl7Message parse(String rawHl7) {
        if (rawHl7 == null || rawHl7.isBlank()) {
            throw new IllegalArgumentException("HL7 raw payload cannot be empty");
        }

        String[] lines = rawHl7.split("\r\n|\r|\n");
        List<Hl7Segment> segmentList = new ArrayList<>();
        String msgType = "";
        String controlId = "";
        String sendApp = "";
        String sendFac = "";
        String recApp = "";
        String recFac = "";
        String ts = "";
        String ver = "2.5";

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] rawFields = line.split("\\|", -1);
            if (rawFields.length == 0) continue;

            String segId = rawFields[0];
            List<String> fieldValues = new ArrayList<>();

            if ("MSH".equalsIgnoreCase(segId)) {
                // In MSH, field separator is field 1, encoding characters is field 2
                sendApp = rawFields.length > 2 ? rawFields[2] : "";
                sendFac = rawFields.length > 3 ? rawFields[3] : "";
                recApp = rawFields.length > 4 ? rawFields[4] : "";
                recFac = rawFields.length > 5 ? rawFields[5] : "";
                ts = rawFields.length > 6 ? rawFields[6] : "";
                msgType = rawFields.length > 8 ? rawFields[8] : "";
                controlId = rawFields.length > 9 ? rawFields[9] : "";
                ver = rawFields.length > 11 ? rawFields[11] : "2.5";

                for (int i = 1; i < rawFields.length; i++) {
                    fieldValues.add(rawFields[i]);
                }
            } else {
                for (int i = 1; i < rawFields.length; i++) {
                    fieldValues.add(rawFields[i]);
                }
            }

            segmentList.add(Hl7Segment.builder()
                    .segmentId(segId)
                    .fields(fieldValues)
                    .build());
        }

        return Hl7Message.builder()
                .messageType(msgType)
                .controlId(controlId)
                .sendingApplication(sendApp)
                .sendingFacility(sendFac)
                .receivingApplication(recApp)
                .receivingFacility(recFac)
                .timestamp(ts)
                .version(ver)
                .segments(segmentList)
                .build();
    }

    /**
     * Builds an ADT^A01 (Inpatient Admission) message.
     */
    public String buildAdtA01(String mrn, String firstName, String lastName, String dob, String gender,
                              String address, String phone, String admissionNo, String doctorName,
                              String wardRoomBed, String admissionReason) {
        String ts = LocalDateTime.now().format(HL7_TS_FMT);
        String controlId = "CTRL-" + System.currentTimeMillis();

        List<Hl7Segment> segs = new ArrayList<>();

        // PID Segment
        // PID|1||MRN-10001^^^HOSPITAL^MR||Patil^Anand^Kumar||19820614|M|||74 Indiranagar^^Bengaluru^KA^560029||+919845012345
        List<String> pidFields = Arrays.asList(
                "1",
                "",
                mrn + "^^^APEX_HOSPITAL^MR",
                "",
                lastName + "^" + firstName,
                "",
                dob.replace("-", ""),
                gender.startsWith("M") ? "M" : "F",
                "",
                "",
                address,
                "",
                phone
        );
        segs.add(Hl7Segment.builder().segmentId("PID").fields(pidFields).build());

        // PV1 Segment (Patient Visit)
        // PV1|1|I|MGW-101^BED-01^WARD-NORTH||||DOC-002^Sharma^Rajesh^^Dr||||||||||ADM-10001
        List<String> pv1Fields = Arrays.asList(
                "1",
                "I", // Inpatient
                wardRoomBed,
                "",
                "",
                "",
                "DOC-REF^" + doctorName.replace(" ", "^"),
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                admissionNo,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ts // Admission Date Time
        );
        segs.add(Hl7Segment.builder().segmentId("PV1").fields(pv1Fields).build());

        // DG1 Segment (Diagnosis)
        if (admissionReason != null && !admissionReason.isBlank()) {
            List<String> dg1Fields = Arrays.asList(
                    "1",
                    "ICD-10",
                    "R69",
                    admissionReason,
                    ts,
                    "A" // Admitting diagnosis
            );
            segs.add(Hl7Segment.builder().segmentId("DG1").fields(dg1Fields).build());
        }

        Hl7Message msg = Hl7Message.builder()
                .messageType("ADT^A01")
                .controlId(controlId)
                .sendingApplication("APEX_HMS")
                .sendingFacility("APEX_MAIN")
                .receivingApplication("CENTRAL_LIS_PACS")
                .receivingFacility("REGIONAL_HEALTH")
                .timestamp(ts)
                .version("2.5")
                .segments(segs)
                .build();

        return msg.encode();
    }

    /**
     * Builds an ORU^R01 (Unsolicited Laboratory / Diagnostic Observation Result) message.
     */
    public String buildOruR01(String mrn, String patientName, String orderNo, String testCode,
                              String testName, String resultValue, String units, String refRange,
                              String abnormalFlag, String verifiedBy) {
        String ts = LocalDateTime.now().format(HL7_TS_FMT);
        String controlId = "ORU-" + System.currentTimeMillis();

        List<Hl7Segment> segs = new ArrayList<>();

        // PID
        segs.add(Hl7Segment.builder()
                .segmentId("PID")
                .fields(Arrays.asList("1", "", mrn + "^^^APEX_HOSPITAL^MR", "", patientName.replace(" ", "^")))
                .build());

        // OBR (Observation Request)
        segs.add(Hl7Segment.builder()
                .segmentId("OBR")
                .fields(Arrays.asList("1", orderNo, orderNo + "-LIS", testCode + "^" + testName, "", ts, ts))
                .build());

        // OBX (Observation Segment)
        // OBX|1|NM|2345-7^Glucose^LN||95.0|mg/dL|70.0-99.0|N|||F|||20260829120000|LAB_TECH
        segs.add(Hl7Segment.builder()
                .segmentId("OBX")
                .fields(Arrays.asList(
                        "1",
                        "NM", // Numeric
                        testCode + "^" + testName + "^LN",
                        "",
                        resultValue,
                        units,
                        refRange,
                        abnormalFlag != null ? abnormalFlag : "N",
                        "",
                        "",
                        "F", // Final result
                        "",
                        "",
                        ts,
                        verifiedBy != null ? verifiedBy.replace(" ", "^") : "APEX_LAB"
                ))
                .build());

        Hl7Message msg = Hl7Message.builder()
                .messageType("ORU^R01")
                .controlId(controlId)
                .sendingApplication("APEX_LIS")
                .sendingFacility("APEX_LAB_CORE")
                .receivingApplication("APEX_EMR")
                .receivingFacility("APEX_MAIN")
                .timestamp(ts)
                .version("2.5")
                .segments(segs)
                .build();

        return msg.encode();
    }
}
