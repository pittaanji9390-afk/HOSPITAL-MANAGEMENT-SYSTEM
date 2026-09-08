package com.hospital.security.multitenant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TenantContextHolder {

    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_FACILITY = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        CURRENT_TENANT.set(tenantId);
    }

    public static String getTenantId() {
        return CURRENT_TENANT.get() != null ? CURRENT_TENANT.get() : "DEFAULT_HEALTH_SYSTEM";
    }

    public static void setFacilityId(String facilityId) {
        CURRENT_FACILITY.set(facilityId);
    }

    public static String getFacilityId() {
        return CURRENT_FACILITY.get() != null ? CURRENT_FACILITY.get() : "MAIN_CAMPUS_HOSPITAL";
    }

    public static void clear() {
        CURRENT_TENANT.remove();
        CURRENT_FACILITY.remove();
    }
}
