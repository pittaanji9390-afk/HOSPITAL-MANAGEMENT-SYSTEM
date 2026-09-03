package com.hospital.common.idempotency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

/**
 * Enterprise Distributed Idempotency Service.
 * Protects critical financial transactions, clinical orders, and patient registrations
 * against duplicate network submissions, concurrent double-clicks, and replay attacks.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class IdempotencyService {

    private final Optional<StringRedisTemplate> redisTemplate;
    private static final String IDEMPOTENCY_KEY_PREFIX = "idempotency:key:";
    private static final Duration DEFAULT_TTL = Duration.ofMinutes(10);

    public enum IdempotencyStatus {
        ACQUIRED,
        IN_PROGRESS,
        COMPLETED,
        CONFLICT
    }

    /**
     * Attempts to acquire an idempotency lock for the given transaction key.
     * @param key Unique idempotency token (e.g. UUID from X-Idempotency-Key header)
     * @param requestHash SHA-256 fingerprint of the request payload
     * @return True if lock acquired, False if key is already active/completed
     */
    public boolean acquireLock(String key, String requestHash) {
        if (redisTemplate.isEmpty() || key == null || key.isBlank()) {
            return true; // Graceful fallback if Redis is disabled
        }

        String redisKey = IDEMPOTENCY_KEY_PREFIX + key;
        String val = "IN_PROGRESS:" + requestHash;

        Boolean acquired = redisTemplate.get().opsForValue().setIfAbsent(redisKey, val, DEFAULT_TTL);
        return Boolean.TRUE.equals(acquired);
    }

    /**
     * Commits the completed response for the idempotency key so subsequent identical requests
     * receive the cached response without re-executing business logic.
     */
    public void commitResponse(String key, String responseBody, int statusCode) {
        if (redisTemplate.isEmpty() || key == null || key.isBlank()) {
            return;
        }

        String redisKey = IDEMPOTENCY_KEY_PREFIX + key;
        String val = "COMPLETED:" + statusCode + ":" + responseBody;
        redisTemplate.get().opsForValue().set(redisKey, val, DEFAULT_TTL);
    }

    /**
     * Retrieves existing cached response if the request was previously executed.
     */
    public Optional<String> getExistingResponse(String key) {
        if (redisTemplate.isEmpty() || key == null || key.isBlank()) {
            return Optional.empty();
        }

        String redisKey = IDEMPOTENCY_KEY_PREFIX + key;
        String val = redisTemplate.get().opsForValue().get(redisKey);

        if (val != null && val.startsWith("COMPLETED:")) {
            return Optional.of(val.substring("COMPLETED:".length()));
        }
        return Optional.empty();
    }

    /**
     * Releases lock in the event of an unrecoverable technical exception.
     */
    public void releaseLock(String key) {
        if (redisTemplate.isEmpty() || key == null || key.isBlank()) {
            return;
        }
        redisTemplate.get().delete(IDEMPOTENCY_KEY_PREFIX + key);
    }
}
