package com.hospital.controller.clinical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/cpoe-orders")
@CrossOrigin(origins = "*")
public class InpatientOrderEntryCpoeRestController {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CpoeOrderRequest {
        private String patientId;
        private String orderingDoctorId;
        private String orderType; // MEDICATION, LAB, RADIOLOGY, NURSING_CARE, DIET
        private String orderItemCode;
        private String orderItemDescription;
        private String dosageInstructions;
        private String priority; // STAT, URGENT, ROUTINE
    }

    @Data
    @AllArgsConstructor
    public static class CpoeOrderRecord {
        private String orderId;
        private String patientId;
        private String orderType;
        private String orderItemDescription;
        private String status; // PENDING_VERIFICATION, VERIFIED, DISPENSED, EXECUTED, CANCELLED
        private Instant orderTimestamp;
        private String priority;
    }

    private final Map<String, CpoeOrderRecord> orders = new LinkedHashMap<>();

    public InpatientOrderEntryCpoeRestController() {
        orders.put("ORD-1001", new CpoeOrderRecord("ORD-1001", "PT-9941", "MEDICATION", "Norepinephrine 4mg in 250mL D5W", "EXECUTED", Instant.now().minusSeconds(7200), "STAT"));
        orders.put("ORD-1002", new CpoeOrderRecord("ORD-1002", "PT-8812", "LAB", "STAT Troponin-I & Arterial Blood Gas", "VERIFIED", Instant.now().minusSeconds(1800), "STAT"));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<CpoeOrderRecord>> getOrdersByPatient(@PathVariable String patientId) {
        List<CpoeOrderRecord> list = orders.values().stream().filter(o -> o.getPatientId().equals(patientId)).toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<CpoeOrderRecord> placeOrder(@RequestBody CpoeOrderRequest req) {
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        CpoeOrderRecord ord = new CpoeOrderRecord(orderId, req.getPatientId(), req.getOrderType(), req.getOrderItemDescription(), "PENDING_VERIFICATION", Instant.now(), req.getPriority());
        orders.put(orderId, ord);
        log.info("[CPOE-API] Placed order {} for patient {}", orderId, req.getPatientId());
        return ResponseEntity.ok(ord);
    }
}
