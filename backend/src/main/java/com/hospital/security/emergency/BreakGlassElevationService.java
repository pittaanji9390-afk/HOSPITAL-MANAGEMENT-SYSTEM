package com.hospital.security.emergency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;

@Slf4j
@Service
public class BreakGlassElevationService {

    @Data
    @AllArgsConstructor
    public static class BreakGlassToken {
        private String tokenId;
        private String requestingUserId;
        private String patientId;
        private String emergencyReasonCategory; // RESUSCITATION, TRAUMA_ESI_1, CODE_BLUE, PSYCH_CRISIS
        private String detailedJustification;
        private Instant activatedAt;
        private Instant expiresAt;
        private boolean isUnderSupervisorReview;
    }

    private final Map<String, BreakGlassToken> activeTokens = new LinkedHashMap<>();

    public BreakGlassToken requestBreakGlass(String userId, String patientId, String reasonCategory, String justification) {
        String tokenId = "BG-TOK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Instant now = Instant.now();
        Instant expiry = now.plusSeconds(3600 * 4); // 4 Hour temporary elevation
        BreakGlassToken token = new BreakGlassToken(tokenId, userId, patientId, reasonCategory, justification, now, expiry, true);
        activeTokens.put(tokenId, token);
        log.warn("[BREAK-GLASS ALERT] User {} activated emergency override for patient {}. Reason: {}. Token: {}",
                userId, patientId, reasonCategory, tokenId);
        return token;
    }

    public boolean isTokenValid(String tokenId) {
        BreakGlassToken token = activeTokens.get(tokenId);
        return token != null && Instant.now().isBefore(token.getExpiresAt());
    }

    public List<BreakGlassToken> getPendingReviews() {
        return activeTokens.values().stream().filter(BreakGlassToken::isUnderSupervisorReview).toList();
    }
}
