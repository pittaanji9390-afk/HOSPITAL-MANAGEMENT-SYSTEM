package com.hospital.cssd.iuss;

import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Immediate-Use Steam Sterilization (IUSS / "Flash") Compliance Auditor.
 * Evaluates emergency dropped instrument re-sterilization events against CMS/TJC regulations:
 * Prohibits IUSS for implantable devices and convenience/turnover speeding.
 */
@Service
public class IussAuditService {

    public enum IussReason { DROPPED_ONE_OF_A_KIND_INSTRUMENT, UNANTICIPATED_URGENT_SURGICAL_NEED, PROHIBITED_CONVENIENCE_VIOLATION, PROHIBITED_IMPLANT_VIOLATION }
    public record IussRecord(String incidentId, String orRoom, String instrumentName, IussReason reason, boolean isImplant, String surgeonName, String circulatorNurse, Instant timestamp, boolean compliant) {}

    private final List<IussRecord> auditTrail = Collections.synchronizedList(new ArrayList<>());

    public IussRecord logIussEvent(String orRoom, String instName, IussReason reason, boolean isImplant, String surgeon, String nurse) {
        boolean compliant = !isImplant && reason != IussReason.PROHIBITED_CONVENIENCE_VIOLATION && reason != IussReason.PROHIBITED_IMPLANT_VIOLATION;
        IussRecord record = new IussRecord("IUSS-" + UUID.randomUUID().toString().substring(0, 8), orRoom, instName, reason, isImplant, surgeon, nurse, Instant.now(), compliant);
        auditTrail.add(record);
        return record;
    }

    public List<IussRecord> getAuditTrail() {
        return new ArrayList<>(auditTrail);
    }
}
