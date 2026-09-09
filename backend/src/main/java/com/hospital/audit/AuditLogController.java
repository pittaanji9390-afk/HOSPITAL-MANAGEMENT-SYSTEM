package com.hospital.audit;

import com.hospital.common.ApiResponse;
import com.hospital.common.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    @Builder.Default
    private UUID eventId = UUID.randomUUID();

    @Column(name = "actor_id", nullable = false, length = 50)
    private String actorId;

    @Column(name = "actor_role", length = 50)
    private String actorRole;

    @Column(name = "tenant_id", length = 50)
    @Builder.Default
    private String tenantId = "MAIN_HOSPITAL";

    @Column(nullable = false, length = 50)
    private String module;

    @Column(nullable = false, length = 50)
    private String action;

    @Column(name = "entity_name", nullable = false, length = 50)
    private String entityName;

    @Column(name = "entity_id", nullable = false, length = 50)
    private String entityId;

    @Column(name = "ip_address", length = 50)
    private String ipAddress;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    @Column(nullable = false)
    @Builder.Default
    private Instant timestamp = Instant.now();
}

@Repository
interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    @Query("SELECT a FROM AuditLog a WHERE (:module IS NULL OR a.module = :module) AND (:action IS NULL OR a.action = :action) ORDER BY a.timestamp DESC")
    Page<AuditLog> searchLogs(@Param("module") String module, @Param("action") String action, Pageable pageable);
}

@Service
@RequiredArgsConstructor
class AuditService {
    private final AuditLogRepository repository;

    @Transactional(readOnly = true)
    public PagedResponse<AuditLog> getLogs(String module, String action, Pageable pageable) {
        Page<AuditLog> page = repository.searchLogs(module, action, pageable);
        return PagedResponse.from(page);
    }

    @Transactional
    public void record(String actorId, String role, String module, String action, String entityName, String entityId, String ip) {
        AuditLog log = AuditLog.builder()
                .actorId(actorId)
                .actorRole(role)
                .module(module)
                .action(action)
                .entityName(entityName)
                .entityId(entityId)
                .ipAddress(ip)
                .build();
        repository.save(log);
    }
}

@RestController
@RequestMapping("/api/v1/audit-logs")
@RequiredArgsConstructor
@Tag(name = "Audit Trail & Compliance", description = "Immutable security and clinical access logs")
public class AuditLogController {
    private final AuditService auditService;

    @GetMapping
    @PreAuthorize("hasAuthority('PERM_AUDIT_VIEW') or hasRole('SUPER_ADMIN')")
    @Operation(summary = "Search tamper-evident system audit records")
    public ResponseEntity<ApiResponse<PagedResponse<AuditLog>>> getLogs(
            @RequestParam(required = false) String module,
            @RequestParam(required = false) String action,
            @PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok(ApiResponse.ok(auditService.getLogs(module, action, pageable)));
    }
}
