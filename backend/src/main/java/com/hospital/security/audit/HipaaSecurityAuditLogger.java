package com.hospital.security.audit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Slf4j
@Service
public class HipaaSecurityAuditLogger {

    @Data
    @AllArgsConstructor
    public static class AuditLogEntry {
        private String eventId;
        private Instant timestamp;
        private String userId;
        private String userRole;
        private String patientId;
        private String actionType; // VIEW, EXPORT, MODIFY, DELETE, OVERRIDE, BREAK_GLASS
        private String resourceUri;
        private String clientIpAddress;
        private String workstationMacAddress;
        private boolean isPhiAccessed;
        private String justificationNote;
    }

    private final List<AuditLogEntry> auditTrail = Collections.synchronizedList(new ArrayList<>());

    public void logAccess(String userId, String role, String patientId, String action, String uri, String ip, boolean isPhi, String note) {
        String eventId = "AUD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        AuditLogEntry entry = new AuditLogEntry(eventId, Instant.now(), userId, role, patientId, action, uri, ip, "00:50:56:C0:00:08", isPhi, note);
        auditTrail.add(entry);
        log.info("[HIPAA-AUDIT] Event: {} | User: {} ({}) | Action: {} | Patient: {} | IP: {} | PHI: {}",
                eventId, userId, role, action, patientId, ip, isPhi);
    }

    public List<AuditLogEntry> getRecentLogs(int limit) {
        int size = auditTrail.size();
        return auditTrail.subList(Math.max(0, size - limit), size);
    }
}
