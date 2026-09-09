package com.hospital.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class RateLimitingFilter extends OncePerRequestFilter {

    private static final int MAX_REQUESTS_PER_MINUTE = 30;
    private final Map<String, RequestCounter> requestCounts = new ConcurrentHashMap<>();

    private static class RequestCounter {
        final AtomicInteger count = new AtomicInteger(0);
        volatile long windowStartTime = System.currentTimeMillis();

        boolean allowRequest(int limit) {
            long now = System.currentTimeMillis();
            if (now - windowStartTime > 60000) {
                synchronized (this) {
                    if (now - windowStartTime > 60000) {
                        count.set(0);
                        windowStartTime = now;
                    }
                }
            }
            return count.incrementAndGet() <= limit;
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();

        // Rate-limit authentication attempts
        if (path.startsWith("/api/v1/auth/login") || path.startsWith("/api/v1/auth/forgot-password")) {
            String clientIp = getClientIP(request);
            String key = clientIp + ":" + path;

            RequestCounter counter = requestCounts.computeIfAbsent(key, k -> new RequestCounter());
            if (!counter.allowRequest(MAX_REQUESTS_PER_MINUTE)) {
                log.warn("Rate limit exceeded for IP: {} on path: {}", clientIp, path);
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write("{\"success\":false,\"status\":429,\"code\":\"TOO_MANY_REQUESTS\",\"message\":\"Too many attempts. Please try again in one minute.\"}");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(",")) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0].trim();
    }
}
