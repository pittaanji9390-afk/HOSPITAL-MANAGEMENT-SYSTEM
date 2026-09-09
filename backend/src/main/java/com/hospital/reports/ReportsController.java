package com.hospital.reports;

import com.hospital.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DashboardStatsDto {
    private long totalPatients;
    private long todayAppointments;
    private long activeAdmissions;
    private long availableBeds;
    private long occupiedBeds;
    private long activeEmergencyCases;
    private BigDecimal todayRevenue;
    private BigDecimal outstandingBalance;
}

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
@Tag(name = "Reports & Analytics", description = "Clinical, operational, and financial KPI dashboards")
public class ReportsController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/dashboard-stats")
    @Operation(summary = "Get aggregated executive dashboard metrics")
    public ResponseEntity<ApiResponse<DashboardStatsDto>> getDashboardStats() {
        Long totalPatients = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM patients WHERE status = 'ACTIVE'", Long.class);
        Long todayAppointments = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM appointments WHERE scheduled_date = CURRENT_DATE AND status NOT IN ('CANCELLED')", Long.class);
        Long activeAdmissions = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ipd_admissions WHERE status = 'ADMITTED'", Long.class);
        Long availableBeds = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM beds WHERE status = 'AVAILABLE'", Long.class);
        Long occupiedBeds = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM beds WHERE status = 'OCCUPIED'", Long.class);
        Long activeEmergency = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM emergency_cases WHERE status IN ('TRIAGED', 'UNDER_TREATMENT')", Long.class);

        BigDecimal todayRevenue = jdbcTemplate.queryForObject(
                "SELECT COALESCE(SUM(amount), 0.00) FROM payments WHERE DATE(payment_date) = CURRENT_DATE", BigDecimal.class);
        BigDecimal outstandingBalance = jdbcTemplate.queryForObject(
                "SELECT COALESCE(SUM(balance_amount), 0.00) FROM invoices WHERE status IN ('ISSUED', 'PARTIALLY_PAID')", BigDecimal.class);

        DashboardStatsDto stats = DashboardStatsDto.builder()
                .totalPatients(totalPatients != null ? totalPatients : 0)
                .todayAppointments(todayAppointments != null ? todayAppointments : 0)
                .activeAdmissions(activeAdmissions != null ? activeAdmissions : 0)
                .availableBeds(availableBeds != null ? availableBeds : 0)
                .occupiedBeds(occupiedBeds != null ? occupiedBeds : 0)
                .activeEmergencyCases(activeEmergency != null ? activeEmergency : 0)
                .todayRevenue(todayRevenue != null ? todayRevenue : BigDecimal.ZERO)
                .outstandingBalance(outstandingBalance != null ? outstandingBalance : BigDecimal.ZERO)
                .build();

        return ResponseEntity.ok(ApiResponse.ok(stats));
    }
}
