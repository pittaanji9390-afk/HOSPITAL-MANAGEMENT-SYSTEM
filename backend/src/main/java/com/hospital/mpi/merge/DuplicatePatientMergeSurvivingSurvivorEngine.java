package com.hospital.mpi.merge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Slf4j
@Service
public class DuplicatePatientMergeSurvivingSurvivorEngine {

    @Data
    @AllArgsConstructor
    public static class MergeAuditRecord {
        private String mergeEventId;
        private String survivingPatientId;
        private String subsumedPatientId;
        private Instant mergedTimestamp;
        private String mergedByStaffId;
        private String rationale;
        private boolean isReversible;
    }

    private final List<MergeAuditRecord> mergeHistory = Collections.synchronizedList(new ArrayList<>());

    public MergeAuditRecord mergeRecords(String survivingId, String subsumedId, String staffId, String reason) {
        String eventId = "MRG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        MergeAuditRecord rec = new MergeAuditRecord(eventId, survivingId, subsumedId, Instant.now(), staffId, reason, true);
        mergeHistory.add(rec);
        log.warn("[EMPI-MERGE] Patient {} subsumed into surviving golden record {}. Event: {}", subsumedId, survivingId, eventId);
        return rec;
    }
}
